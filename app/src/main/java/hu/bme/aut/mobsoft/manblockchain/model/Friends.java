package hu.bme.aut.mobsoft.manblockchain.model;

import java.util.Objects;

import hu.bme.aut.mobsoft.manblockchain.model.Friend;
import hu.bme.aut.mobsoft.manblockchain.model.FriendsInfo;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;


public class Friends {

    @SerializedName("results")
    private List<Friend> results = new ArrayList<Friend>();

    @SerializedName("info")
    private FriendsInfo info = null;


    /**
     **/

    public List<Friend> getResults() {
        return results;
    }

    public void setResults(List<Friend> results) {
        this.results = results;
    }


    /**
     **/

    public FriendsInfo getInfo() {
        return info;
    }

    public void setInfo(FriendsInfo info) {
        this.info = info;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Friends friends = (Friends) o;
        return Objects.equals(results, friends.results) &&
                Objects.equals(info, friends.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results, info);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Friends {\n");

        sb.append("    results: ").append(toIndentedString(results)).append("\n");
        sb.append("    info: ").append(toIndentedString(info)).append("\n");
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
