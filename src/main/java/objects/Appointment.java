package objects;

public class Appointment {
    String facility;
    boolean applyHospitalReadmission;
    String healthcareProgram;
    String visitDate;
    String comment;

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public boolean isApplyHospitalReadmission() {
        return applyHospitalReadmission;
    }

    public void setApplyHospitalReadmission(boolean applyHospitalReadmission) {
        this.applyHospitalReadmission = applyHospitalReadmission;
    }

    public String getHealthcareProgram() {
        return healthcareProgram;
    }

    public void setHealthcareProgram(String healthcareProgram) {
        this.healthcareProgram = healthcareProgram;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
