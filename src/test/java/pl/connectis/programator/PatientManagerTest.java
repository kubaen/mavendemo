package pl.connectis.programator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PatientManagerTest {

  PatientManager pm = new PatientManagerInMemory();

  @Test
  void checkTooManyPatientsExceptions() throws TooManyExceptions {

    pm.addPatient(new Patient());
    pm.addPatient(new Patient());

    assertEquals(2, ((PatientManagerInMemory)pm).helper());


    assertThrows(TooManyExceptions.class, () -> pm.addPatient(new Patient()));


  }

////  @Test
////  void checkIterable() {
////    List<Patient> patientList = new ArrayList<>();
////
////    patientList.add(new Patient("Bolek", 21, new Address("Warszawa", "Al. Jero")));
////    patientList.add(new Patient("Lolek", 21, new Address("Warszawa", "Al. Jero")));
////    patientList.add(new Patient("Tola", 21, new Address("Warszawa", "Al. Jero")));
////
////    List<Patient> patient2List = new LinkedList<>();
////
////    patient2List.add(new Patient("Bolek", 21, new Address("Warszawa", "Al. Jero")));
////    patient2List.add(new Patient("Lolek", 21, new Address("Warszawa", "Al. Jero")));
////    patient2List.add(new Patient("Tola", 21, new Address("Warszawa", "Al. Jero")));
////
////    assertIterableEquals(patient2List, patientList);
////
////
////
//
//  }
}
