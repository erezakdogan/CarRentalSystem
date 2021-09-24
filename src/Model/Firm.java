package Model;

import java.util.Objects;

public class Firm {
    private String firmName, firmAddres,firmPhone,firmMail;

    public Firm() {
    }

    public Firm(String firmName, String firmAddres, String firmPhone, String firmMail) {
        this.firmName = firmName;
        this.firmAddres = firmAddres;
        this.firmPhone = firmPhone;
        this.firmMail = firmMail;
    }

    public String getFirmName() {
        return this.firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public String getFirmAddres() {
        return this.firmAddres;
    }

    public void setFirmAddres(String firmAddres) {
        this.firmAddres = firmAddres;
    }

    public String getFirmPhone() {
        return this.firmPhone;
    }

    public void setFirmPhone(String firmPhone) {
        this.firmPhone = firmPhone;
    }

    public String getFirmMail() {
        return this.firmMail;
    }

    public void setFirmMail(String firmMail) {
        this.firmMail = firmMail;
    }

    public Firm firmName(String firmName) {
        setFirmName(firmName);
        return this;
    }

    public Firm firmAddres(String firmAddres) {
        setFirmAddres(firmAddres);
        return this;
    }

    public Firm firmPhone(String firmPhone) {
        setFirmPhone(firmPhone);
        return this;
    }

    public Firm firmMail(String firmMail) {
        setFirmMail(firmMail);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Firm)) {
            return false;
        }
        Firm firm = (Firm) o;
        return Objects.equals(firmName, firm.firmName) && Objects.equals(firmAddres, firm.firmAddres) && Objects.equals(firmPhone, firm.firmPhone) && Objects.equals(firmMail, firm.firmMail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firmName, firmAddres, firmPhone, firmMail);
    }

    @Override
    public String toString() {
        return "{" +
            " firmName='" + getFirmName() + "'" +
            ", firmAddres='" + getFirmAddres() + "'" +
            ", firmPhone='" + getFirmPhone() + "'" +
            ", firmMail='" + getFirmMail() + "'" +
            "}";
    }

    public static void addFirm(String text, String text2, String text3, String text4) {
    }
    
}
