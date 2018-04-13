package hu.bme.aut.mobsoft.manblockchain.model;

import java.util.Objects;

import hu.bme.aut.mobsoft.manblockchain.model.FriendId;
import hu.bme.aut.mobsoft.manblockchain.model.FriendLocation;
import hu.bme.aut.mobsoft.manblockchain.model.FriendLogin;
import hu.bme.aut.mobsoft.manblockchain.model.FriendName;
import hu.bme.aut.mobsoft.manblockchain.model.FriendPicture;

import com.google.gson.annotations.SerializedName;

public class Friend {

    @SerializedName("gender")
    private String gender = null;

    @SerializedName("name")
    private FriendName name = null;

    @SerializedName("location")
    private FriendLocation location = null;

    @SerializedName("email")
    private String email = null;

    @SerializedName("login")
    private FriendLogin login = null;

    @SerializedName("dob")
    private String dob = null;

    @SerializedName("registered")
    private String registered = null;

    @SerializedName("phone")
    private String phone = null;

    @SerializedName("cell")
    private String cell = null;

    @SerializedName("id")
    private FriendId id = null;

    @SerializedName("picture")
    private FriendPicture picture = null;

    @SerializedName("nat")
    private String nat = null;


    /**
     **/
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    /**
     **/
    public FriendName getName() {
        return name;
    }

    public void setName(FriendName name) {
        this.name = name;
    }


    /**
     **/
    public FriendLocation getLocation() {
        return location;
    }

    public void setLocation(FriendLocation location) {
        this.location = location;
    }


    /**
     **/
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    /**
     **/
    public FriendLogin getLogin() {
        return login;
    }

    public void setLogin(FriendLogin login) {
        this.login = login;
    }


    /**
     **/

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }


    /**
     **/

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }


    /**
     **/

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    /**
     **/

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }


    /**
     **/

    public FriendId getId() {
        return id;
    }

    public void setId(FriendId id) {
        this.id = id;
    }


    /**
     **/

    public FriendPicture getPicture() {
        return picture;
    }

    public void setPicture(FriendPicture picture) {
        this.picture = picture;
    }


    /**
     **/

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Friend friend = (Friend) o;
        return Objects.equals(gender, friend.gender) &&
                Objects.equals(name, friend.name) &&
                Objects.equals(location, friend.location) &&
                Objects.equals(email, friend.email) &&
                Objects.equals(login, friend.login) &&
                Objects.equals(dob, friend.dob) &&
                Objects.equals(registered, friend.registered) &&
                Objects.equals(phone, friend.phone) &&
                Objects.equals(cell, friend.cell) &&
                Objects.equals(id, friend.id) &&
                Objects.equals(picture, friend.picture) &&
                Objects.equals(nat, friend.nat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender, name, location, email, login, dob, registered, phone, cell, id, picture, nat);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Friend {\n");

        sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    location: ").append(toIndentedString(location)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    login: ").append(toIndentedString(login)).append("\n");
        sb.append("    dob: ").append(toIndentedString(dob)).append("\n");
        sb.append("    registered: ").append(toIndentedString(registered)).append("\n");
        sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
        sb.append("    cell: ").append(toIndentedString(cell)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    picture: ").append(toIndentedString(picture)).append("\n");
        sb.append("    nat: ").append(toIndentedString(nat)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
