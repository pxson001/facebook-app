package com.facebook.facecastdisplay;

import com.facebook.facecastdisplay.LiveEventModel.LiveEventType;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.VideoAnnouncementFragmentModel;
import javax.annotation.Nullable;

/* compiled from: submessage_after */
public class LiveAnnouncementEventModel extends LiveEventModel {
    public final String f2824a;
    public final int f2825b;
    public final String f2826c;
    public final String f2827d;
    public final String f2828e;

    private LiveAnnouncementEventModel(String str, int i, String str2, String str3, String str4) {
        this.f2824a = str;
        this.f2825b = i;
        this.f2826c = str2;
        this.f2827d = str3;
        this.f2828e = str4;
    }

    public final LiveEventType mo118a() {
        return LiveEventType.LIVE_ANNOUNCEMENT_EVENT;
    }

    @Nullable
    public static LiveAnnouncementEventModel m3126a(VideoAnnouncementFragmentModel videoAnnouncementFragmentModel) {
        if (videoAnnouncementFragmentModel.m3921m() == null || videoAnnouncementFragmentModel.m3918j() == null || videoAnnouncementFragmentModel.m3916a() == null || videoAnnouncementFragmentModel.m3920l() == null) {
            return null;
        }
        return new LiveAnnouncementEventModel(videoAnnouncementFragmentModel.m3921m(), videoAnnouncementFragmentModel.m3919k(), videoAnnouncementFragmentModel.m3918j(), videoAnnouncementFragmentModel.m3916a(), videoAnnouncementFragmentModel.m3920l());
    }
}
