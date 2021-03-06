package hu.bme.aut.mobsoft.manblockchain.model.facebook;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

public class FriendDTOName {

    @SerializedName("last")
    private String last = null;

    @SerializedName("title")
    private String title = null;

    @SerializedName("first")
    private String first = null;

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FriendDTOName friendDTOName = (FriendDTOName) o;
        return Objects.equals(last, friendDTOName.last) &&
                Objects.equals(title, friendDTOName.title) &&
                Objects.equals(first, friendDTOName.first);
    }

    @Override
    public int hashCode() {
        return Objects.hash(last, title, first);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FriendDTOName {\n");

        sb.append("    last: ").append(toIndentedString(last)).append("\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    first: ").append(toIndentedString(first)).append("\n");
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
