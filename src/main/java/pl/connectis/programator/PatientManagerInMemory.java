package pl.connectis.programator;

import java.util.ArrayList;
import java.util.List;

public class PatientManagerInMemory implements PatientManager {

  private List<Patient> patients = new ArrayList<>();

  @Override
  public boolean addPatient(Patient patient) throws TooManyExceptions {
    if (patients.size() > 1) throw new TooManyExceptions();
    patients.add(patient);
    return true;
  }

  @Override
  public List<Patient> sortByName() {
    return null;
  }

  @Override
  public List<Patient> sortByYob() {
    return null;
  }

  @Override
  public List<Patient> findOlderThan(int years) {
    return null;
  }

  int helper(){
    return patients.size();
  }
}
