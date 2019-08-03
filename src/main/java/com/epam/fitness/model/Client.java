package com.epam.fitness.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * The type Client.
 */
public class Client implements Serializable,Identifiable {

    private Long id;
    private Long coachId;
    private String name;
    private String surname;
    private String login;
    private String password;
    private Integer membership_purchased_number;
    private Float personalDiscount;
    private Long programId;

    /**
     * Instantiates a new Client.
     *
     * @param id                          the id
     * @param coachId                     the coach id
     * @param name                        the name
     * @param surname                     the surname
     * @param login                       the login
     * @param password                    the password
     * @param membership_purchased_number the membership purchased number
     * @param personalSale                the personal sale
     * @param programId                   the program id
     */
    public Client(Long id, Long coachId, String name, String surname, String login, String password, Integer membership_purchased_number, Float personalSale, Long programId){
        this.id = id;
        this.coachId = coachId;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.membership_purchased_number = membership_purchased_number;
        this.personalDiscount = personalSale;
        this.programId = programId;
    }

    /**
     * Instantiates a new Client.
     *
     * @param id                          the id
     * @param coachId                     the coach id
     * @param name                        the name
     * @param surname                     the surname
     * @param login                       the login
     * @param password                    the password
     * @param membership_purchased_number the membership purchased number
     * @param personalSale                the personal sale
     * @param corporateSale               the corporate sale
     */
    public Client(Long id, Long coachId, String name, String surname, String login, String password, Integer membership_purchased_number, Float personalSale, Float corporateSale){
        this.id = id;
        this.coachId = coachId;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.membership_purchased_number = membership_purchased_number;
        this.personalDiscount = personalSale;

    }

    /**
     * Instantiates a new Client.
     */
    public Client(){}

    /**
     * Sets id.
     *
     * @param clientID the client id
     */
    public void setID(long clientID) {
        this.id = clientID;
    }

    /**
     * Sets coach id.
     *
     * @param coachId the coach id
     */
    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets surname.
     *
     * @param surname the surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Sets login.
     *
     * @param login the login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets membership purchased number.
     *
     * @param membership_purchased_number the membership purchased number
     */
    public void setMembershipPurchasedNumber(int membership_purchased_number) {
        this.membership_purchased_number = membership_purchased_number;
    }

    /**
     * Sets personal sale.
     *
     * @param personalDiscount the personal discount
     */
    public void setPersonalSale(float personalDiscount) {
        this.personalDiscount = personalDiscount;
    }


    public Long getId() {
        return id;
    }

    /**
     * Gets coach id.
     *
     * @return the coach id
     */
    public Long getCoachId() {
        return coachId;
    }

    /**
     * Gets surname.
     *
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Gets login.
     *
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets membership purchased number.
     *
     * @return the membership purchased number
     */
    public int getMembershipPurchasedNumber() {
        return membership_purchased_number;
    }

    /**
     * Gets personal discount.
     *
     * @return the personal discount
     */
    public float getPersonalDiscount() {
        return personalDiscount;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets program id.
     *
     * @return the program id
     */
    public Long getProgramId() {
        return programId;
    }

    /**
     * Sets program id.
     *
     * @param programId the program id
     */
    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Client client = (Client) o;
        return  Objects.equals(getId(), client.getId()) &&
                Objects.equals(getCoachId(), client.getCoachId()) &&
                Objects.equals(getName(), client.getName()) &&
                Objects.equals(getSurname(), client.getSurname()) &&
                Objects.equals(getLogin(), client.getLogin()) &&
                Objects.equals(getPassword(), client.getPassword()) &&
                Objects.equals(getMembershipPurchasedNumber(), client.getMembershipPurchasedNumber()) &&
                Objects.equals(getPersonalDiscount(), client.getPersonalDiscount()) &&
                Objects.equals(getProgramId(), client.getProgramId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),getCoachId(),getName(),getSurname(),getLogin(),getPassword(),getMembershipPurchasedNumber(),getPersonalDiscount(),getProgramId());
    }
    

}
