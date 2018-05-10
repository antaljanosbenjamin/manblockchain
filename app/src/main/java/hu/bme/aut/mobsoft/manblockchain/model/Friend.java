package hu.bme.aut.mobsoft.manblockchain.model;

import android.content.Context;

import com.orm.SugarRecord;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import hu.bme.aut.mobsoft.manblockchain.model.facebook.FriendDTO;

/**
 * Created by Antal János Benjamin on 2018. 04. 25..
 */

public class Friend extends SugarRecord<Friend> {
    private String name;
    private String nickName;
    private String email;
    private String phoneNumber;
    private String facebookProfilURL;
    private String instagramProfilURL;
    private String linkedinProfilURL;
    private Date birthDate;
    private String comments;
    private boolean isStarred;

    private String convertName(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    public Friend() {
    }

    public Friend(FriendDTO friendDTO) {

        this.name = this.convertName(friendDTO.getName().getFirst()) + " " + this.convertName(friendDTO.getName().getLast());
        this.nickName = "";
        this.email = friendDTO.getEmail();
        this.phoneNumber = friendDTO.getPhone();
        String username = friendDTO.getEmail().split("@")[0];
        this.facebookProfilURL = "https://facebook.com/profile/" + username;
        this.instagramProfilURL = "";
        this.linkedinProfilURL = "";
        String dateStr = friendDTO.getDob().split(" ")[0];
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = new Date();
        try {
            birthDate = parser.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.birthDate = birthDate;
        this.comments = "";
        this.isStarred = false;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public boolean isStarred() {
        return isStarred;
    }

    public boolean changeStarred() {
        isStarred = !isStarred;
        return isStarred;
    }
}
