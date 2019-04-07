package app.service.implementation;

import app.domain.Tire;
import app.domain.Truck;
import app.domain.TruckTirePairing;
import app.models.AddTruckDto;
import app.models.TireChangeDto;
import app.repository.TireRepository;
import app.repository.TruckRepository;
import app.repository.TruckTirePairingRepository;
import app.service.WriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Optional;

@Service
public class WriteServiceImpl implements WriteService {

    private TireRepository tireRepository;
    private TruckRepository truckRepository;
    private TruckTirePairingRepository truckTirePairingRepository;

    @Autowired
    WriteServiceImpl(TireRepository tireRepository,
                     TruckRepository truckRepository,
                     TruckTirePairingRepository truckTirePairingRepository) {
        this.tireRepository = tireRepository;
        this.truckRepository = truckRepository;
        this.truckTirePairingRepository = truckTirePairingRepository;
    }

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static SecureRandom rnd = new SecureRandom();

    String randomString( int len ){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }

    public String changeTire(TireChangeDto tireChangeDto) {
        Optional<Truck> truck = truckRepository.findByTruckLicensePlateNumber(tireChangeDto.getLicensePlate());
        if(truck.isPresent()) {
            Tire tire = tireRepository.save(new Tire(tireChangeDto.getModelId(),
                    randomString(10),
                    tireChangeDto.getMileage(),
                    1));
            TruckTirePairing truckTirePairingChange = truckTirePairingRepository.getOne(
                    truckTirePairingRepository.getTruckTirePairingByTruckIdAndAndTirePositionIndex(
                            truck.get().getTruckId(),
                            tireChangeDto.getTireIndex()).getTruckTirePairingId()
            );
            truckTirePairingChange.setTireId(tire.getTireId());
            truckTirePairingRepository.save(truckTirePairingChange);
            return "success";
        } else return "truck does not exist";
    }

    public String addTruck(AddTruckDto addTruckDto) {
        if(truckRepository.findByTruckLicensePlateNumber(addTruckDto.getTruckLicensePlate()).isPresent()){
            return "Failed to add new truck: Truck already exists";
        }
        Truck truck = truckRepository.save(new Truck(addTruckDto.getEmpId(),
                addTruckDto.getTruckModelId(), addTruckDto.getTruckLicensePlate()));
        addTruckDto.getTruckTireDtoList().forEach(truckTire -> {
            Tire tire = tireRepository.save(new Tire(truckTire.getTireModelId(),
                    randomString(10),
                    0,
                    1));
            truckTirePairingRepository.save(new TruckTirePairing(truck.getTruckId(),
                    tire.getTireId(),
                    truckTire.getTirePositionIndex()));
        });
        return "success";
    }
}
