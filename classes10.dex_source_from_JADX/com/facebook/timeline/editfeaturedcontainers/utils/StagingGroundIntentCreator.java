package com.facebook.timeline.editfeaturedcontainers.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.ipc.editgallery.EntryPoint;
import com.facebook.photos.base.media.MediaItemFactory.FallbackMediaId;
import com.facebook.timeline.stagingground.StagingGroundIntentFactory;
import com.facebook.timeline.stagingground.StagingGroundLaunchConfig.Builder;
import javax.annotation.Nullable;

/* compiled from: geofence_error_event_received */
public class StagingGroundIntentCreator {
    public static Intent m11093a(Context context, boolean z, @Nullable Uri uri, @Nullable String str) {
        if (str == null) {
            str = Long.toString(FallbackMediaId.DEFAULT.getValue());
        }
        Builder a = new Builder().a(uri, str);
        a.g = 2131241383;
        a = a;
        a.h = 2131241390;
        a = a;
        a.i = 2131241391;
        a = a;
        a.j = 2131241392;
        a = a;
        a.d = EntryPoint.PROFILE.name();
        a = a;
        a.p = true;
        a = a;
        a.q = 65;
        a = a;
        a.r = z;
        a = a;
        a.u = false;
        return StagingGroundIntentFactory.a(context, a.a(), null);
    }
}
