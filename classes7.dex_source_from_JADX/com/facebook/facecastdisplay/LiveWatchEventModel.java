package com.facebook.facecastdisplay;

import com.facebook.facecastdisplay.LiveEventModel.LiveEventType;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.LiveVideoViewersCollectionFragmentModel.EdgesModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: audio/eac3 */
public class LiveWatchEventModel extends LiveEventWithAuthorModel {
    public final ImmutableList<LiveEventAuthor> f18987a;
    public final boolean f18988b;

    private LiveWatchEventModel(ImmutableList<LiveEventAuthor> immutableList, boolean z) {
        super((LiveEventAuthor) immutableList.get(0));
        this.f18987a = immutableList;
        this.f18988b = z;
    }

    public final LiveEventType mo118a() {
        return LiveEventType.LIVE_WATCH_EVENT;
    }

    @Nullable
    public static LiveWatchEventModel m22566a(EdgesModel edgesModel) {
        LiveEventAuthor a = LiveEventAuthor.m3183a(edgesModel.m3897a());
        if (a == null) {
            return null;
        }
        return new LiveWatchEventModel(ImmutableList.of(a), false);
    }

    @Nullable
    public static LiveWatchEventModel m22567a(List<EdgesModel> list) {
        Builder builder = ImmutableList.builder();
        for (EdgesModel a : list) {
            LiveEventAuthor a2 = LiveEventAuthor.m3183a(a.m3897a());
            if (a2 != null) {
                builder.c(a2);
            }
        }
        ImmutableList b = builder.b();
        if (b.isEmpty()) {
            return null;
        }
        return new LiveWatchEventModel(b, true);
    }
}
