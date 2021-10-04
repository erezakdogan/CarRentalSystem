package Model;

import java.time.Period;
import java.util.Objects;

import Helpers.DBConnector;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class Car {
    private String make;
    private String type;
    private int dailyPrice, carCount;
    private Period pricePeriod,avaiblePeriod;

    public Car() {
    }

    public Car(String make,String type, int dailyPrice, int carCount, Period pricePeriod, Period avaiblePeriod) {
        this.make = make;
        this.type = type;
        this.dailyPrice = dailyPrice;
        this.carCount = carCount;
        this.pricePeriod = pricePeriod;
        this.avaiblePeriod = avaiblePeriod;
        
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getDailyPrice() {
        return this.dailyPrice;
    }

    public void setDailyPrice(int dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public int getCarCount() {
        return this.carCount;
    }

    public void setCarCount(int carCount) {
        this.carCount = carCount;
    }

    public Period getPricePeriod() {
        return this.pricePeriod;
    }

    public void setPricePeriod(Period pricePeriod) {
        this.pricePeriod = pricePeriod;
    }

    public Period getAvaiblePeriod() {
        return this.avaiblePeriod;
    }

    public void setAvaiblePeriod(Period avaiblePeriod) {
        this.avaiblePeriod = avaiblePeriod;
    }

    public Car make(String make) {
        setMake(make);
        return this;
    }

    public Car dailyPrice(int dailyPrice) {
        setDailyPrice(dailyPrice);
        return this;
    }

    public Car carCount(int carCount) {
        setCarCount(carCount);
        return this;
    }

    public Car pricePeriod(Period pricePeriod) {
        setPricePeriod(pricePeriod);
        return this;
    }

    public Car avaiblePeriod(Period avaiblePeriod) {
        setAvaiblePeriod(avaiblePeriod);
        return this;
    }
    
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Car type(String type) {
        setType(type);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Car)) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(make, car.make) && dailyPrice == car.dailyPrice && carCount == car.carCount && Objects.equals(pricePeriod, car.pricePeriod) && Objects.equals(avaiblePeriod, car.avaiblePeriod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, dailyPrice, carCount, pricePeriod, avaiblePeriod);
    }

    @Override
    public String toString() {
        return "{" +
            " make='" + getMake() + "'" +
            ", dailyPrice='" + getDailyPrice() + "'" +
            ", carCount='" + getCarCount() + "'" +
            ", pricePeriod='" + getPricePeriod() + "'" +
            ", avaiblePeriod='" + getAvaiblePeriod() + "'" +
            "}";
    }
    public static void addFleet(int firmId, String make, String type, String price, String count, LocalDate localDate, LocalDate localDate2, LocalDate localDate3, LocalDate localDate4) {
        String query = "INSERT INTO cars (firm_id,make,type,daily_price,car_count,price_period,avaible_period) VALUES(?,?,?,?,?,?,?);";
       try {
        PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
        preparedStatement.setInt(1, firmId);
        preparedStatement.setString(2, make);
        preparedStatement.setString(3, type);
        preparedStatement.setString(4, price);
        preparedStatement.setString(5, count);
        preparedStatement.setString(6, localDate+"/"+localDate2);
        preparedStatement.setString(7, localDate3+"/"+localDate4);
        preparedStatement.executeUpdate();
       } catch (SQLException e) {
           System.out.println(e.getMessage());
       }
    }
}
