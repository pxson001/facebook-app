package com.facebook.feed.photos;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import javax.annotation.Nullable;

/* compiled from: graphNotifUpdateSeenState */
public class FeedUnitImageRequest {
    private Uri f22020a;
    private String f22021b;
    public int f22022c = 0;
    private int f22023d = 0;
    private ImageLoadListener f22024e = new ImageLoadListener(this);

    /* compiled from: graphNotifUpdateSeenState */
    class ImageLoadListener extends BaseControllerListener {
        final /* synthetic */ FeedUnitImageRequest f22025a;

        public ImageLoadListener(FeedUnitImageRequest feedUnitImageRequest) {
            this.f22025a = feedUnitImageRequest;
        }

        public final void mo2603a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            this.f22025a.f22022c = 1;
        }

        public final void mo2607b(String str, @Nullable Object obj) {
            this.f22025a.f22022c = 1;
        }

        public final void mo2608b(String str, Throwable th) {
            this.f22025a.f22022c = 2;
        }
    }

    public FeedUnitImageRequest(Uri uri, String str) {
        this.f22020a = uri;
        this.f22021b = str;
    }

    public final Uri m29797a() {
        return this.f22020a;
    }

    public final ControllerListener m29798b() {
        return this.f22024e;
    }

    public final int m29799c() {
        return this.f22022c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FeedUnitImageRequest)) {
            return false;
        }
        return this.f22020a.equals(((FeedUnitImageRequest) obj).f22020a);
    }

    public int hashCode() {
        return this.f22020a.hashCode();
    }
}
