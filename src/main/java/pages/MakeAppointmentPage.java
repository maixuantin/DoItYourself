package pages;

import locators.MakeAppointmentLocators;
import objects.Appointment;
import org.testng.Assert;

public class MakeAppointmentPage extends BasePage {
    public void makeAppointment(Appointment appointment) {
        selectDropdownByText(MakeAppointmentLocators.DROPDOWN_FACILITY, appointment.getFacility());
        if (appointment.isApplyHospitalReadmission()) {
            click(MakeAppointmentLocators.CHECKBOX_HOSPITAL_READMISSION);
        }
        switch (appointment.getHealthcareProgram().toLowerCase()) {
            case "medicare":
                click(MakeAppointmentLocators.RADIO_HEALTHCARE_MEDICARE);
                break;
            case "medicaid":
                click(MakeAppointmentLocators.RADIO_HEALTHCARE_MEDICAID);
                break;
            default:
                click(MakeAppointmentLocators.RADIO_HEALTHCARE_NONE);
                break;
        }
        inputValue(MakeAppointmentLocators.INPUT_VISIT_DATE, appointment.getVisitDate());
        inputValue(MakeAppointmentLocators.INPUT_COMMENT, appointment.getComment());
        click(MakeAppointmentLocators.BUTTON_MAKE_APPOINTMENT);
    }
}
