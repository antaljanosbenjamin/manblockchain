package hu.bme.aut.mobsoft.manblockchain.model.facebook;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

public class FriendsDTOInfo {

    @SerializedName("seed")
    private String seed = null;

    @SerializedName("page")
    private Integer page = null;

    @SerializedName("results")
    private Integer results = null;

    @SerializedName("varsion")
    private String varsion = null;

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

    public String getVarsion() {
        return varsion;
    }

    public void setVarsion(String varsion) {
        this.varsion = varsion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FriendsDTOInfo friendsDTOInfo = (FriendsDTOInfo) o;
        return Objects.equals(seed, friendsDTOInfo.seed) &&
                Objects.equals(page, friendsDTOInfo.page) &&
                Objects.equals(results, friendsDTOInfo.results) &&
                Objects.equals(varsion, friendsDTOInfo.varsion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seed, page, results, varsion);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FriendsDTOInfo {\n");

        sb.append("    seed: ").append(toIndentedString(seed)).append("\n");
        sb.append("    page: ").append(toIndentedString(page)).append("\n");
        sb.append("    results: ").append(toIndentedString(results)).append("\n");
        sb.append("    varsion: ").append(toIndentedString(varsion)).append("\n");
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
