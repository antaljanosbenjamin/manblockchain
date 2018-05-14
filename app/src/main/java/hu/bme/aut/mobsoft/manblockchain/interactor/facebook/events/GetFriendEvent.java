package hu.bme.aut.mobsoft.manblockchain.interactor.facebook.events;

import hu.bme.aut.mobsoft.manblockchain.model.Friend;
import hu.bme.aut.mobsoft.manblockchain.model.facebook.FriendDTO;

/**
 * Created by Antal János Benjamin on 2018. 03. 24..
 */

public class GetFriendEvent {

    private int code;
    private FriendDTO friendDTO;
    private Throwable throwable;

    public GetFriendEvent() {
    }

    public GetFriendEvent(int code, FriendDTO friendDTO, Throwable throwable) {
        this.code = code;
        this.friendDTO = friendDTO;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public FriendDTO getFriendDTO() {
        return friendDTO;
    }

    public void setFriend(FriendDTO friendDTO) {
        this.friendDTO = friendDTO;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
