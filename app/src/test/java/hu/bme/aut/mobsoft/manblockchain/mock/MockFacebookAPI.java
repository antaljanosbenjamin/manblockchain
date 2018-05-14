package hu.bme.aut.mobsoft.manblockchain.mock;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.mobsoft.manblockchain.model.Friend;
import hu.bme.aut.mobsoft.manblockchain.model.facebook.FriendDTO;
import hu.bme.aut.mobsoft.manblockchain.model.facebook.FriendDTOId;
import hu.bme.aut.mobsoft.manblockchain.model.facebook.FriendDTOName;
import hu.bme.aut.mobsoft.manblockchain.model.facebook.FriendDTOPicture;
import hu.bme.aut.mobsoft.manblockchain.model.facebook.FriendsDTO;
import hu.bme.aut.mobsoft.manblockchain.model.facebook.FriendsDTOInfo;
import hu.bme.aut.mobsoft.manblockchain.network.FacebookAPI;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MockFacebookAPI implements FacebookAPI {

    @Override
    public Call<FriendsDTO> getNewFriends() {

        final FriendsDTO dto = new FriendsDTO();
        FriendsDTOInfo dtoInfo= new FriendsDTOInfo();
        dtoInfo.setResults(1);
        dto.setInfo(dtoInfo);

        FriendDTO friendDTO = new FriendDTO();
        FriendDTOName friendDTOName = new FriendDTOName();
        friendDTOName.setFirst("First");
        friendDTOName.setLast("Last");
        friendDTO.setName(friendDTOName);
        friendDTO.setEmail("first.last@example.com");
        friendDTO.setPhone("06123456789");
        FriendDTOPicture friendDTOPicture = new FriendDTOPicture();
        friendDTOPicture.setThumbnail("http://thumbnail.com/first");
        friendDTO.setPicture(friendDTOPicture);
        friendDTO.setDob("1993-08-06");

        List<FriendDTO> friendDTOS = new ArrayList<FriendDTO>();
        friendDTOS.add(friendDTO);
        dto.setResults(friendDTOS);

        Call<FriendsDTO> call = new Call<FriendsDTO>() {
            @Override
            public Response<FriendsDTO> execute() throws IOException {
                return Response.success(dto);
            }

            @Override
            public void enqueue(Callback<FriendsDTO> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<FriendsDTO> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };

        return call;
    }
}
