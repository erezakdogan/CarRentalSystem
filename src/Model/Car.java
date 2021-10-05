package Model;

import java.util.ArrayList;
import java.util.Objects;

import Helpers.DBConnector;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Car {
    private int id;
    private String make;
    private String type;
    private int dailyPrice, carCount;
    private String pricePeriod,avaiblePeriod;

    public Car() {
    }

    public Car(int id, String make,String type, int dailyPrice, int carCount, String pricePeriod, String avaiblePeriod) {
        this.id = id;
        this.make = make;
        this.type = type;
        this.dailyPrice = dailyPrice;
        this.carCount = carCount;
        this.pricePeriod = pricePeriod;
        this.avaiblePeriod = avaiblePeriod;
        
    }
    public int getId() {
        return this.id;
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

    public String getPricePeriod() {
        return this.pricePeriod;
    }

    public void setPricePeriod(String pricePeriod) {
        this.pricePeriod = pricePeriod;
    }

    public String getAvaiblePeriod() {
        return this.avaiblePeriod;
    }

    public void setAvaiblePeriod(String avaiblePeriod) {
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

    public Car pricePeriod(String pricePeriod) {
        setPricePeriod(pricePeriod);
        return this;
    }

    public Car avaiblePeriod(String avaiblePeriod) {
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

    public static ArrayList<Car> getAvailables(String city, String type, LocalDate arrival, LocalDate departure) {
        ArrayList<Car> availables = new ArrayList<>();
        ArrayList<Firm> firm = new ArrayList<>();
        for(Firm f : Firm.getFirms()){
            if(f.getFirmAddres().equals(city)){
                firm.add(f);
            }
        }

        String query = "SELECT * FROM  cars WHERE firm_id IN ("+getFirmsInCity(firm)+") AND type = '"+type+"';";
        Car car;
        try {
            Statement preparedStatement = DBConnector.getInstance().createStatement();
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String make = resultSet.getString("make");
                String carType = resultSet.getString("type");
                String dailyPrice = resultSet.getString("daily_price");
                String carCount = resultSet.getString("car_count");
                String pricePeriod = resultSet.getString("price_period");
                String avaiblePeriod = resultSet.getString("avaible_period");
                car = new Car(id,make, carType, Integer.parseInt(dailyPrice), Integer.parseInt(carCount), pricePeriod, avaiblePeriod);
                availables.add(car);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return availables;
    }

    private static String getFirmsInCity(ArrayList<Firm> firm) {
        String firmsInCity = "";
        for(int i = 0;i<firm.size();i++){
            if(i!=firm.size()-1&&firm.size()!=1){
                firmsInCity+=(firm.get(i).getId()+",");
            }else{
                firmsInCity+=(firm.get(i).getId());
            }
        }
        System.out.println(firmsInCity);
        return firmsInCity;
    }
}
