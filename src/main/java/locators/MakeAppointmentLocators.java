package locators;

import org.openqa.selenium.By;

public class MakeAppointmentLocators {
    public static By DROPDOWN_FACILITY = By.id("combo_facility");
    public static By CHECKBOX_HOSPITAL_READMISSION = By.id("chk_hospotal_readmission");
    public static By RADIO_HEALTHCARE_MEDICARE = By.id("radio_program_medicare");
    public static By RADIO_HEALTHCARE_MEDICAID = By.id("radio_program_medicaid");
    public static By RADIO_HEALTHCARE_NONE = By.id("radio_program_none");
    public static By INPUT_VISIT_DATE = By.id("txt_visit_date");
    public static By INPUT_COMMENT = By.id("txt_comment");
    public static By BUTTON_MAKE_APPOINTMENT = By.id("btn-book-appointment");
}
