package hu.bme.aut.mobsoft.manblockchain.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;



public class FriendName {

    @SerializedName("last")
    private String last = null;

    @SerializedName("title")
    private String title = null;

    @SerializedName("first")
    private String first = null;


    /**
     **/

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }


    /**
     **/

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    /**
     **/

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
        FriendName friendName = (FriendName) o;
        return Objects.equals(last, friendName.last) &&
                Objects.equals(title, friendName.title) &&
                Objects.equals(first, friendName.first);
    }

    @Override
    public int hashCode() {
        return Objects.hash(last, title, first);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FriendName {\n");

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
