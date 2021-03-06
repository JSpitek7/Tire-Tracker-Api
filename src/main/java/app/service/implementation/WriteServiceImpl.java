package app.service.implementation;

import app.domain.Tire;
import app.domain.TirePurchase;
import app.domain.Truck;
import app.domain.TruckTirePairing;
import app.models.AddTruckDto;
import app.models.PurchaseTireDto;
import app.models.TireChangeDto;
import app.repository.TirePurchaseRepository;
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

    private TirePurchaseRepository tirePurchaseRepository;
    private TireRepository tireRepository;
    private TruckRepository truckRepository;
    private TruckTirePairingRepository truckTirePairingRepository;

    @Autowired
    WriteServiceImpl(TirePurchaseRepository tirePurchaseRepository,
                     TireRepository tireRepository,
                     TruckRepository truckRepository,
                     TruckTirePairingRepository truckTirePairingRepository) {
        this.tirePurchaseRepository = tirePurchaseRepository;
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
        Optional<Truck> truckRecord = truckRepository.findById(tireChangeDto.getTruckId());
        if(truckRecord.isPresent()) {
            Truck truck = truckRecord.get();
            Tire newTireRecord = tireRepository.findFirstByTireModelIdAndTireStatusId(tireChangeDto.getModelId(),8);
            Tire newTire = tireRepository.getOne(newTireRecord.getTireId());
            newTire.setTruckMileageAtInstall(tireChangeDto.getMileage());
            newTire.setTireStatusId(1);
            tireRepository.save(newTire);
            Optional<TruckTirePairing> truckTirePairingRecord = truckTirePairingRepository
                    .findTruckTirePairingByTruckIdAndAndTirePositionIndex(
                            truck.getTruckId(),
                            tireChangeDto.getTireIndex()
                    );
            if(truckTirePairingRecord.isPresent()) {
                TruckTirePairing truckTirePairingChange = truckTirePairingRecord.get();
                Tire oldTire = tireRepository.getOne(truckTirePairingChange.getTireId());
                oldTire.setTruckMileageAtRemoval(tireChangeDto.getMileage());
                oldTire.setTireStatusId(tireChangeDto.getOldTireStatusId());
                tireRepository.save(oldTire);
                truckTirePairingChange.setTireId(newTire.getTireId());
                truckTirePairingRepository.save(truckTirePairingChange);
            } else {
                TruckTirePairing newTruckTirePairing = new TruckTirePairing(
                        truck.getTruckId(),
                        newTire.getTireId(),
                        tireChangeDto.getTireIndex()
                );
                truckTirePairingRepository.save(newTruckTirePairing);
            }
            return "success";
        } else return "truck does not exist";
    }

    public String addTruck(AddTruckDto addTruckDto) {
        if(truckRepository.findByTruckLicensePlateNumber(addTruckDto.getTruckLicensePlate()).isPresent()){
            return "Failed to add new truck: Truck already exists";
        }
        Truck truck = truckRepository.save(new Truck(
                addTruckDto.getEmpId(),
                addTruckDto.getTruckModelId(),
                addTruckDto.getTruckLicensePlate(),
                1));
        addTruckDto.getTruckTireDtoList().forEach(truckTire -> {
            Tire tireRecord = tireRepository.findFirstByTireModelIdAndTireStatusId(truckTire.getTireModelId(), 8);
            Tire tire = tireRepository.getOne(tireRecord.getTireId());
            tire.setTruckMileageAtInstall(addTruckDto.getTruckMileage());
            tire.setTireStatusId(1);
            truckTirePairingRepository.save(new TruckTirePairing(truck.getTruckId(),
                    tire.getTireId(),
                    truckTire.getTirePositionIndex()));
        });
        return "success";
    }

    public String purchaseTire(PurchaseTireDto purchaseTireDto) {
        TirePurchase tirePurchase = tirePurchaseRepository.save(new TirePurchase(
                purchaseTireDto.getTireVendorId(),
                purchaseTireDto.getTirePurchaseQuantity(),
                purchaseTireDto.getTirePurchasePricePerUnit()));
        Integer tireQuantityCounter;
        for (tireQuantityCounter = 1; tireQuantityCounter <= purchaseTireDto.getTirePurchaseQuantity(); tireQuantityCounter++) {
            tireRepository.save(new Tire(
                    purchaseTireDto.getTireModelId(),
                    randomString(10),
                    null,
                    null,
                    8,
                    tirePurchase.getTirePurchaseId()
            ));
        }
        return "success";
    }
}
