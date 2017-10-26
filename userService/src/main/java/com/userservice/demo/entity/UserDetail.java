package com.userservice.demo.entity;


import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * USER DETAIL TABLE : USER_DETAIL
 */


@Entity
@Table(name = "user_detail")
public class UserDetail {

    /**
     *
     */
    private static final long serialVersionUID = 4804278804874617196L;

    /**
     * unique Id for each record.
     */

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * User Id , unique for every user
     */

    @Column(name = "user_id", nullable = false, unique = true, length = 50)
    private String userId;


    /**
     *  Name of User
     */
    @Column(name = "name", nullable = false,  length = 300)
    private String name;


    /**
     * Legal id Of user( could be social security number etc)
     */
    @Column(name = "ssn", nullable = false, unique = true, length = 20)
    private String ssn;

    /**
     * Gender of user
     */
    @Column(name = "gender", nullable = false, length = 20)
    private String gender;

    /**
     * Date of birth of user
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_of_birth", columnDefinition = "TIMESTAMP", length = 0)
    private Date dateOfBirth;

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



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "UserDetail [id=" + id + ", userId=" + userId + ", firstName="  + ", name=" + name
                + ", ssn=" + ssn + ", gender=" + gender + ", createdOn="
                + createdOn + ", deletedOn=" + deletedOn + "]";
    }
}
