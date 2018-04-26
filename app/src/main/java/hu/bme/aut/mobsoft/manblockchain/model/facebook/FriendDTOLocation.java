package hu.bme.aut.mobsoft.manblockchain.model.facebook;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

public class FriendDTOLocation {

    @SerializedName("city")
    private String city = null;

    @SerializedName("street")
    private String street = null;

    @SerializedName("postcode")
    private String postcode = null;

    @SerializedName("state")
    private String state = null;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FriendDTOLocation friendDTOLocation = (FriendDTOLocation) o;
        return Objects.equals(city, friendDTOLocation.city) &&
                Objects.equals(street, friendDTOLocation.street) &&
                Objects.equals(postcode, friendDTOLocation.postcode) &&
                Objects.equals(state, friendDTOLocation.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, postcode, state);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FriendDTOLocation {\n");

        sb.append("    city: ").append(toIndentedString(city)).append("\n");
        sb.append("    street: ").append(toIndentedString(street)).append("\n");
        sb.append("    postcode: ").append(toIndentedString(postcode)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
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
