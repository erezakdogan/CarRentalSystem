package Model;

import java.util.ArrayList;
import java.util.Objects;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Helpers.DBConnector;

public class Firm {

    int id;
    private String firmName, firmAddres, firmPhone, firmMail, pass;

    public Firm() {

    }

    public Firm(int id, String firmName, String firmAddres, String firmPhone, String firmMail, String pass) {
        this.id = id;
        this.firmName = firmName;
        this.firmAddres = firmAddres;
        this.firmPhone = firmPhone;
        this.firmMail = firmMail;
        this.pass = pass;

    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Firm pass(String pass) {
        setPass(pass);
        return this;
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
        return Objects.equals(firmName, firm.firmName) && Objects.equals(firmAddres, firm.firmAddres)
                && Objects.equals(firmPhone, firm.firmPhone) && Objects.equals(firmMail, firm.firmMail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firmName, firmAddres, firmPhone, firmMail);
    }

    @Override
    public String toString() {
        return "{" + " firmName='" + getFirmName() + "'" + ", firmAddres='" + getFirmAddres() + "'" + ", firmPhone='"
                + getFirmPhone() + "'" + ", firmMail='" + getFirmMail() + "'" + "}";
    }

    public static void addFirm(String name, String mail, String pass, String address) {
        String query = "INSERT INTO firms (name,mail,pass,address) VALUES(?,?,?,?)";

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, mail);
            preparedStatement.setString(3, pass);
            preparedStatement.setString(4, address);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Firm> getFirms() {
        ArrayList<Firm> firms = new ArrayList<>();
        Firm firm;
        String query = "SELECT * FROM firms";
        try {
            Statement statement = DBConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String firmName = resultSet.getString("name");
                String firmAddres = resultSet.getString("address");
                String firmPhone = resultSet.getString("phone");
                String firmMail = resultSet.getString("mail");
                String pass = resultSet.getString("pass");
                int id = resultSet.getInt("id");
                firm = new Firm(id, firmName, firmAddres, firmPhone, firmMail, pass);
                firms.add(firm);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return firms;
    }

    public static void updateFirm(String column, String newValue, int id) {
        String query = "UPDATE firms SET " + column + " = '" + newValue + "' WHERE id = " + id + " ;";
        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

   

}
