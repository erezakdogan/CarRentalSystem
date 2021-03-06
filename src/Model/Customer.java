package Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects; 
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import Helpers.DBConnector;

public class Customer {
    private int id;
    private String name, mail, pass, phone, identity;

    public Customer() {
    }

    public Customer(int id, String name, String mail, String pass, String phone, String identity) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.pass = pass;
        this.phone = phone;
        this.identity = identity;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentity() {
        return this.identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public Customer name(String name) {
        setName(name);
        return this;
    }

    public Customer mail(String mail) {
        setMail(mail);
        return this;
    }

    public Customer pass(String pass) {
        setPass(pass);
        return this;
    }

    public Customer phone(String phone) {
        setPhone(phone);
        return this;
    }

    public Customer identity(String identity) {
        setIdentity(identity);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Customer)) {
            return false;
        }
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) && Objects.equals(mail, customer.mail)
                && Objects.equals(pass, customer.pass) && Objects.equals(phone, customer.phone)
                && Objects.equals(identity, customer.identity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mail, pass, phone, identity);
    }

    @Override
    public String toString() {
        return "{" + " name='" + getName() + "'" + ", mail='" + getMail() + "'" + ", pass='" + getPass() + "'"
                + ", phone='" + getPhone() + "'" + ", identity='" + getIdentity() + "'" + "}";
    }

    public static void addCustomer(String name, String mail, String pass) {
        String query = "INSERT INTO customers (name,mail,pass) VALUES(?,?,?)";

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, mail);
            preparedStatement.setString(3, pass);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
        }
    }

    public static ArrayList<Customer> getCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        Customer customer;
        String query = "SELECT * FROM customers";
        try {
            Statement statement = DBConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String mail = resultSet.getString("mail");
                String pass = resultSet.getString("pass");
                String identity = resultSet.getString("identity");
                customer = new Customer(id, name, mail, pass, phone, identity);
                customers.add(customer);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return customers;
    }

    public static void updateCustomer(String column, String newVal, int customerId) {
        String query = "UPDATE customers SET " + column + "='" + newVal + "' WHERE id = " + customerId;
        try {
            Statement statement = DBConnector.getInstance().createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
