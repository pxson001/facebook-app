package com.facebook.video.creativeediting;

import android.annotation.TargetApi;
import android.content.Context;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.videoeditgallery.VideoEditFeature;
import javax.inject.Inject;

@TargetApi(18)
/* compiled from: ed10c22fb494aa16aa00c1294c3014f5 */
public class VideoCropController implements VideoEditFeatureController {
    private final Context f15404a;

    public static VideoCropController m19434a(InjectorLike injectorLike) {
        return new VideoCropController((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public VideoCropController(Context context) {
        this.f15404a = context;
    }

    public final String mo559a() {
        return null;
    }

    public final void mo564b() {
    }

    public final void mo565c() {
    }

    public final boolean mo566d() {
        return false;
    }

    public final boolean mo567e() {
        return false;
    }

    public final void mo568f() {
    }

    public final void mo569g() {
    }

    public final void mo570h() {
    }

    public final void mo571i() {
    }

    public final Object mo572j() {
        return VideoEditFeature.CROP;
    }

    public final void mo1194k() {
    }
}
