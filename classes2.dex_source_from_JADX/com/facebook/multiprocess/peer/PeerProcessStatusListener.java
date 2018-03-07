package com.facebook.multiprocess.peer;

/* compiled from: time_elapsed_since_scroll_to_top */
public interface PeerProcessStatusListener {

    /* compiled from: time_elapsed_since_scroll_to_top */
    public enum Direction {
        Incoming,
        Outgoing
    }

    void mo687a(PeerInfo peerInfo);

    void mo689a(PeerInfo peerInfo, Direction direction);
}
