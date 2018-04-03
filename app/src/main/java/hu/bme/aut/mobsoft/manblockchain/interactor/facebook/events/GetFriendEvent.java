package hu.bme.aut.mobsoft.manblockchain.interactor.facebook.events;

import hu.bme.aut.mobsoft.manblockchain.model.Friend;

/**
 * Created by Antal János Benjamin on 2018. 03. 24..
 */

public class GetFriendEvent {

    private int code;
    private Friend friend;
    private Throwable throwable;

    public GetFriendEvent() {
    }

    public GetFriendEvent(int code, Friend friend, Throwable throwable) {
        this.code = code;
        this.friend = friend;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Friend getFriend() {
        return friend;
    }

    public void setFriend(Friend friend) {
        this.friend = friend;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
