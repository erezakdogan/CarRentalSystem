package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Objects;

import Helpers.DBConnector;

public class Rents {

    private int id, costumer_id, firm_id, price;
    private String car_make, res_per;

    public Rents() {
    }

    public Rents(int id, int costumer_id, int firm_id, int price, String car_make, String res_per) {
        this.id = id;
        this.costumer_id = costumer_id;
        this.firm_id = firm_id;
        this.price = price;
        this.car_make = car_make;
        this.res_per = res_per;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCostumer_id() {
        return this.costumer_id;
    }

    public void setCostumer_id(int costumer_id) {
        this.costumer_id = costumer_id;
    }

    public int getFirm_id() {
        return this.firm_id;
    }

    public void setFirm_id(int firm_id) {
        this.firm_id = firm_id;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCar_make() {
        return this.car_make;
    }

    public void setCar_make(String car_make) {
        this.car_make = car_make;
    }

    public String getRes_per() {
        return this.res_per;
    }

    public void setRes_per(String res_per) {
        this.res_per = res_per;
    }

    public Rents id(int id) {
        setId(id);
        return this;
    }

    public Rents costumer_id(int costumer_id) {
        setCostumer_id(costumer_id);
        return this;
    }

    public Rents firm_id(int firm_id) {
        setFirm_id(firm_id);
        return this;
    }

    public Rents price(int price) {
        setPrice(price);
        return this;
    }

    public Rents car_make(String car_make) {
        setCar_make(car_make);
        return this;
    }

    public Rents res_per(String res_per) {
        setRes_per(res_per);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Rents)) {
            return false;
        }
        Rents rents = (Rents) o;
        return id == rents.id && costumer_id == rents.costumer_id && firm_id == rents.firm_id && price == rents.price
                && Objects.equals(car_make, rents.car_make) && Objects.equals(res_per, rents.res_per);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, costumer_id, firm_id, price, car_make, res_per);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", costumer_id='" + getCostumer_id() + "'" + ", firm_id='" + getFirm_id()
                + "'" + ", price='" + getPrice() + "'" + ", car_make='" + getCar_make() + "'" + ", res_per='"
                + getRes_per() + "'" + "}";
    }

    public static void addRent(Car car, String identity, LocalDate localDate, LocalDate localDate2) {
        String query = "INSERT INTO reservations (customer_id,firm_id,price,car_make,res_per) VALUES (?,?,?,?,?)";
        System.out.println(localDate);
        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(identity));
            preparedStatement.setInt(2, car.getFirm_id());
            preparedStatement.setInt(3, (int) (car.getDailyPrice() * ChronoUnit.DAYS.between(localDate, localDate2)));
            preparedStatement.setString(4, car.getMake());
            preparedStatement.setString(5, localDate + "-" + localDate2);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static ArrayList<Rents> getRents(Customer customer) {
        ArrayList<Rents> rentsList = new ArrayList<>();
        String query = "SELECT * FROM reservations WHERE customer_id = " + customer.getIdentity();
        try {
            Statement statement = DBConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Rents rents;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int firm_id = resultSet.getInt("firm_id");
                int price = resultSet.getInt("price");
                String car_make = resultSet.getString("car_make");
                String res_per = resultSet.getString("res_per");
                rents = new Rents(id, Integer.parseInt(customer.getIdentity()), firm_id, price, car_make, res_per);
                rentsList.add(rents);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rentsList;
    }

    public static ArrayList<Rents> getRents(Firm firm) {
        ArrayList<Rents> rentsList = new ArrayList<>();
        String query = "SELECT * FROM reservations WHERE firm_id = " + firm.getId();
        try {
            Statement statement = DBConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Rents rents;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int customer_id = resultSet.getInt("customer_id");
                int price = resultSet.getInt("price");
                String car_make = resultSet.getString("car_make");
                String res_per = resultSet.getString("res_per");
                rents = new Rents(id, customer_id, firm.getId(), price, car_make, res_per);
                rentsList.add(rents);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rentsList;
    }

}
