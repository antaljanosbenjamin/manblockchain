package hu.bme.aut.mobsoft.manblockchain.model.facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;


public class FriendsDTO   {
  
  @SerializedName("results")
  private List<FriendDTO> results = new ArrayList<FriendDTO>();
  
  @SerializedName("info")
  private FriendsDTOInfo info = null;

  public List<FriendDTO> getResults() {
    return results;
  }
  public void setResults(List<FriendDTO> results) {
    this.results = results;
  }

  public FriendsDTOInfo getInfo() {
    return info;
  }
  public void setInfo(FriendsDTOInfo info) {
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
    FriendsDTO friendsDTO = (FriendsDTO) o;
    return Objects.equals(results, friendsDTO.results) &&
        Objects.equals(info, friendsDTO.info);
  }

  @Override
  public int hashCode() {
    return Objects.hash(results, info);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FriendsDTO {\n");
    
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
