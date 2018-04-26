package hu.bme.aut.mobsoft.manblockchain.model.facebook;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

public class FriendDTO {

    @SerializedName("gender")
    private String gender = null;

    @SerializedName("name")
    private FriendDTOName name = null;

    @SerializedName("location")
    private FriendDTOLocation location = null;

    @SerializedName("email")
    private String email = null;

    @SerializedName("login")
    private FriendDTOLogin login = null;

    @SerializedName("dob")
    private String dob = null;

    @SerializedName("registered")
    private String registered = null;

    @SerializedName("phone")
    private String phone = null;

    @SerializedName("cell")
    private String cell = null;

    @SerializedName("id")
    private FriendDTOId id = null;

    @SerializedName("picture")
    private FriendDTOPicture picture = null;

    @SerializedName("nat")
    private String nat = null;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public FriendDTOName getName() {
        return name;
    }

    public void setName(FriendDTOName name) {
        this.name = name;
    }

    public FriendDTOLocation getLocation() {
        return location;
    }

    public void setLocation(FriendDTOLocation location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public FriendDTOLogin getLogin() {
        return login;
    }

    public void setLogin(FriendDTOLogin login) {
        this.login = login;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public FriendDTOId getId() {
        return id;
    }

    public void setId(FriendDTOId id) {
        this.id = id;
    }

    public FriendDTOPicture getPicture() {
        return picture;
    }

    public void setPicture(FriendDTOPicture picture) {
        this.picture = picture;
    }

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
        FriendDTO friendDTO = (FriendDTO) o;
        return Objects.equals(gender, friendDTO.gender) &&
                Objects.equals(name, friendDTO.name) &&
                Objects.equals(location, friendDTO.location) &&
                Objects.equals(email, friendDTO.email) &&
                Objects.equals(login, friendDTO.login) &&
                Objects.equals(dob, friendDTO.dob) &&
                Objects.equals(registered, friendDTO.registered) &&
                Objects.equals(phone, friendDTO.phone) &&
                Objects.equals(cell, friendDTO.cell) &&
                Objects.equals(id, friendDTO.id) &&
                Objects.equals(picture, friendDTO.picture) &&
                Objects.equals(nat, friendDTO.nat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender, name, location, email, login, dob, registered, phone, cell, id, picture, nat);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FriendDTO {\n");

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
