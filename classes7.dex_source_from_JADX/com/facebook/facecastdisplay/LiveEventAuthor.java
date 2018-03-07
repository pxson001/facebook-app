package com.facebook.facecastdisplay;

import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.LiveEventAuthorModel;
import com.facebook.graphql.model.GraphQLActor;
import javax.annotation.Nullable;

/* compiled from: storyset_item_cursor */
public class LiveEventAuthor {
    public final String f2902a;
    public final String f2903b;
    public final boolean f2904c;

    public LiveEventAuthor(String str, String str2, boolean z) {
        this.f2902a = str;
        this.f2903b = str2;
        this.f2904c = z;
    }

    public static LiveEventAuthor m3184a(GraphQLActor graphQLActor) {
        return new LiveEventAuthor(graphQLActor.aa(), graphQLActor.H(), graphQLActor.R());
    }

    @Nullable
    public static LiveEventAuthor m3183a(@Nullable LiveEventAuthorModel liveEventAuthorModel) {
        if (liveEventAuthorModel == null) {
            return null;
        }
        String l = liveEventAuthorModel.m3824l();
        String j = liveEventAuthorModel.m3822j();
        if (l == null || j == null) {
            return null;
        }
        return new LiveEventAuthor(l, j, liveEventAuthorModel.m3823k());
    }
}
