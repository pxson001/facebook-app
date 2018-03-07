package com.facebook.platform.common.action;

import android.content.Context;
import com.facebook.platform.common.util.PlatformPackageUtilities;
import javax.inject.Inject;

/* compiled from: stream_video_width */
public class PlatformAppCallResultBroadcaster {
    public final Context f4020a;
    public final PlatformPackageUtilities f4021b;

    @Inject
    public PlatformAppCallResultBroadcaster(Context context, PlatformPackageUtilities platformPackageUtilities) {
        this.f4020a = context;
        this.f4021b = platformPackageUtilities;
    }
}
