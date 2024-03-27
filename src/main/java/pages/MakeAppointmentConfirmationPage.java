package pages;

import locators.AppointmentConfirmationLocators;
import objects.Appointment;
import org.testng.Assert;

public class MakeAppointmentConfirmationPage extends BasePage {
    public void validateAppointment(Appointment appointment) {
        String facility = getText(AppointmentConfirmationLocators.LABEL_FACILITY);
        Assert.assertEquals(facility, appointment.getFacility());

        String hospitalReadmission = getText(AppointmentConfirmationLocators.LABEL_HOSPITAL_READMISSION);
        if (appointment.isApplyHospitalReadmission()) {
            Assert.assertEquals(hospitalReadmission, "Yes");
        } else {
            Assert.assertEquals(hospitalReadmission, "No");
        }

        String program = getText(AppointmentConfirmationLocators.LABEL_HEALTHCARE_PROGRAM);
        Assert.assertEquals(program, appointment.getHealthcareProgram());

        String visitDate = getText(AppointmentConfirmationLocators.LABEL_VISIT_DATE);
        Assert.assertEquals(visitDate, appointment.getVisitDate());

        String comment = getText(AppointmentConfirmationLocators.LABEL_COMMENT);
        Assert.assertEquals(comment, appointment.getComment());
    }
}
