package hu.bme.aut.mobsoft.manblockchain.model.facebook;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;


public class FriendDTOLogin {

    @SerializedName("sha1")
    private String sha1 = null;

    @SerializedName("password")
    private String password = null;

    @SerializedName("salt")
    private String salt = null;

    @SerializedName("sha256")
    private String sha256 = null;

    @SerializedName("username")
    private String username = null;

    @SerializedName("md5")
    private String md5 = null;

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSha256() {
        return sha256;
    }

    public void setSha256(String sha256) {
        this.sha256 = sha256;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FriendDTOLogin friendDTOLogin = (FriendDTOLogin) o;
        return Objects.equals(sha1, friendDTOLogin.sha1) &&
                Objects.equals(password, friendDTOLogin.password) &&
                Objects.equals(salt, friendDTOLogin.salt) &&
                Objects.equals(sha256, friendDTOLogin.sha256) &&
                Objects.equals(username, friendDTOLogin.username) &&
                Objects.equals(md5, friendDTOLogin.md5);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sha1, password, salt, sha256, username, md5);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FriendDTOLogin {\n");

        sb.append("    sha1: ").append(toIndentedString(sha1)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
        sb.append("    salt: ").append(toIndentedString(salt)).append("\n");
        sb.append("    sha256: ").append(toIndentedString(sha256)).append("\n");
        sb.append("    username: ").append(toIndentedString(username)).append("\n");
        sb.append("    md5: ").append(toIndentedString(md5)).append("\n");
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
