package hu.bme.aut.mobsoft.manblockchain.model.facebook;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

public class FriendDTOPicture {

    @SerializedName("thumbnail")
    private String thumbnail = null;

    @SerializedName("large")
    private String large = null;

    @SerializedName("medium")
    private String medium = null;

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FriendDTOPicture friendDTOPicture = (FriendDTOPicture) o;
        return Objects.equals(thumbnail, friendDTOPicture.thumbnail) &&
                Objects.equals(large, friendDTOPicture.large) &&
                Objects.equals(medium, friendDTOPicture.medium);
    }

    @Override
    public int hashCode() {
        return Objects.hash(thumbnail, large, medium);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FriendDTOPicture {\n");

        sb.append("    thumbnail: ").append(toIndentedString(thumbnail)).append("\n");
        sb.append("    large: ").append(toIndentedString(large)).append("\n");
        sb.append("    medium: ").append(toIndentedString(medium)).append("\n");
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
