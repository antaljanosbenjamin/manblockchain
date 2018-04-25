package hu.bme.aut.mobsoft.manblockchain.model;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by Antal János Benjamin on 2018. 04. 25..
 */

public class Friend extends SugarRecord<Friend> {
    private String name;
    private String nickName;
    private String phoneNumber;
    private String facebookProfilURL;
    private String instagramProfilURL;
    private String linkedinProfilURL;
    private Date birthDate;
    private String comments;

    public Friend(){}

    public Friend(String name, String nickName, String phoneNumber, String facebookProfilURL, String instagramProfilURL, String linkedinProfilURL, Date birthDate, String comments) {
        this.name = name;
        this.nickName = nickName;
        this.phoneNumber = phoneNumber;
        this.facebookProfilURL = facebookProfilURL;
        this.instagramProfilURL = instagramProfilURL;
        this.linkedinProfilURL = linkedinProfilURL;
        this.birthDate = birthDate;
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFacebookProfilURL() {
        return facebookProfilURL;
    }

    public void setFacebookProfilURL(String facebookProfilURL) {
        this.facebookProfilURL = facebookProfilURL;
    }

    public String getInstagramProfilURL() {
        return instagramProfilURL;
    }

    public void setInstagramProfilURL(String instagramProfilURL) {
        this.instagramProfilURL = instagramProfilURL;
    }

    public String getLinkedinProfilURL() {
        return linkedinProfilURL;
    }

    public void setLinkedinProfilURL(String linkedinProfilURL) {
        this.linkedinProfilURL = linkedinProfilURL;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
