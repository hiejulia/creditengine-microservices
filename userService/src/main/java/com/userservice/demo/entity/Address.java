package com.userservice.demo.entity;


import javax.persistence.*;
import java.util.Date;

/**
 * ADDRESS TABLE
 */


@Entity
@Table(name = "address")
public class Address {


    /**
     * Serial Id for serialization
     */
    private static final long serialVersionUID = 1245490181445280741L;
    /**
     * unique Id for each record.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * User Id , unique for every user
     */

    @Column(name = "user_id", nullable = false, unique = true, length = 36)
    private String userId;

    /**
     * City, Staying city of user
     */
    @Column(name = "city", nullable = true, length = 300)
    private String city;

    /**
     * Address Line for User Address.
     */
    @Column(name = "address_line", nullable = false,  length = 300)
    private String addressLine;



    /**
     * Pincode for user City
     */
    @Column(name = "pincode", nullable = false,  length = 36)
    private String pinCode;

    /**
     * Date on which user is created
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", length = 0)
    private Date createdOn= new Date();

    /**
     * Date on which user is deleted.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deleted_on", columnDefinition = "TIMESTAMP DEFAULT NULL", length = 0)
    private Date deletedOn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }



    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getDeletedOn() {
        return deletedOn;
    }

    public void setDeletedOn(Date deletedOn) {
        this.deletedOn = deletedOn;
    }

    @Override
    public String toString() {
        return "Address [id=" + id + ", userId=" + userId + ", city=" + city + ", addressLine=" + addressLine
                +  ", PinCode=" + pinCode + ", createdOn=" + createdOn
                + ", deletedOn=" + deletedOn + "]";
    }

}
