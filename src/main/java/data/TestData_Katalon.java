package data;

import objects.Account;
import objects.Appointment;
import utilities.Utilities;

public class TestData_Katalon {
    public static Account accountKatalonSuccess() {
        return new Account("John Doe", "ThisIsNotAPassword");
    }

    public static Account accountKatalonUnsuccess() {
        return new Account("123", "ThisIsNotAPassword");
    }

    public static Appointment genAppointment() {
        String[] facilities = {"Tokyo CURA Healthcare Center", "Hongkong CURA Healthcare Center", "Seoul CURA Healthcare Center"};
        String[] programs = {"Medicare", "Medicaid", "None"};

        Appointment appointment = new Appointment();
        appointment.setFacility(facilities[Utilities.getRandomNumber(0, facilities.length)]);
        appointment.setApplyHospitalReadmission(Utilities.genRandomBoolean());
        appointment.setHealthcareProgram(programs[Utilities.getRandomNumber(0, programs.length)]);
        appointment.setVisitDate(Utilities.getCurrentDate("dd/MM/yyyy"));
        appointment.setComment("Hello World");
        return appointment;
    }
}
