package pl.connectis.programator;

import java.util.List;

public interface PatientManager {

  /* Pseudo kontrakt - baza 5 pacjentów max */

  /* wyrzuca wyjątek TooManyPatients jeśli przekroczy rozmiar 5 */
  /* zwraca false jeśli próbujemy dodać pacjenta który istnieje */

  /* assertThrows(ArithmeticException.class, () ->calculator.divide(1, 0)); */

  /* wiek pacjenta [0, 200] */

  public boolean addPatient(Patient patient) throws TooManyExceptions ;

  public List<Patient> sortByName();

  public List<Patient> sortByYob();

  public List<Patient> findOlderThan(int years);
}
