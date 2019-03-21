package app.service;

import app.domain.TruckTirePairing;
import app.models.TireChangeDto;

public interface WriteService {
    String changeTire(TireChangeDto tireChangeDto);
}
