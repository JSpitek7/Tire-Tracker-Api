package app.service.implementation;

import app.domain.Truck;
import app.domain.TruckTirePairing;
import app.models.TireChangeDto;
import app.repository.TruckRepository;
import app.repository.TruckTirePairingRepository;
import app.service.WriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WriteServiceImpl implements WriteService {

    private TruckRepository truckRepository;
    private TruckTirePairingRepository truckTirePairingRepository;

    @Autowired
    WriteServiceImpl(TruckRepository truckRepository, TruckTirePairingRepository truckTirePairingRepository) {
        this.truckRepository = truckRepository;
        this.truckTirePairingRepository = truckTirePairingRepository;
    }

    public String changeTire(TireChangeDto tireChangeDto) {
        Truck truck = truckRepository.findByTruckVin(tireChangeDto.getVin());
        Integer count = truckTirePairingRepository.findAll().size();
        for (Integer i = 1; i <= 16; i++) {
            Integer pairingId = i + count;
            TruckTirePairing newRecord = new TruckTirePairing(pairingId,
                    truck.getTruckId(),
                    tireChangeDto.getModelId(),
                    i,
                    tireChangeDto.getMileage());
            truckTirePairingRepository.save(newRecord);
        }
        return "success";
    }
}
