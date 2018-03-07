package com.facebook.facecastdisplay;

import com.facebook.facecastdisplay.LiveEventModel.LiveEventType;

/* compiled from: auto_execute_action_delay */
public class LiveInfoEventModel extends LiveEventModel {
    public LiveInfoType f18891a;

    /* compiled from: auto_execute_action_delay */
    public enum LiveInfoType {
        LIVE_INDICATOR_INFO
    }

    public LiveInfoEventModel(LiveInfoType liveInfoType) {
        this.f18891a = liveInfoType;
    }

    public final LiveEventType mo118a() {
        return LiveEventType.LIVE_INFO_EVENT;
    }
}
