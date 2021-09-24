package Model;

import java.util.Objects;

public class Customer {
    private String name,mail,pass,phone,identity;

    public Customer() {
    }

    public Customer(String name, String mail, String pass, String phone, String identity) {
        this.name = name;
        this.mail = mail;
        this.pass = pass;
        this.phone = phone;
        this.identity = identity;
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
        return Objects.equals(name, customer.name) && Objects.equals(mail, customer.mail) && Objects.equals(pass, customer.pass) && Objects.equals(phone, customer.phone) && Objects.equals(identity, customer.identity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mail, pass, phone, identity);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", mail='" + getMail() + "'" +
            ", pass='" + getPass() + "'" +
            ", phone='" + getPhone() + "'" +
            ", identity='" + getIdentity() + "'" +
            "}";
    }

    public static void addCustomer(String text, String text2, String text3) {
    }
    
}
