package com.facebook.camera.ipc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.facebook.camera.CameraModule;
import com.facebook.content.FacebookOnlyIntentActionFactory;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

@Deprecated
/* compiled from: allow */
public class CameraIntentBuilder {
    private final String f10965a;
    public Activity f10966b;
    public long f10967c = -1;
    private String f10968d;
    public Intent f10969e;
    private int f10970f = 0;

    public static CameraIntentBuilder m18984b(InjectorLike injectorLike) {
        return new CameraIntentBuilder(CameraModule.m18806a((Context) injectorLike.getInstance(Context.class)));
    }

    @Inject
    public CameraIntentBuilder(String str) {
        this.f10965a = str;
        this.f10969e = new Intent();
    }

    public final Intent m18985a() {
        Intent putExtra = new Intent(FacebookOnlyIntentActionFactory.a(FbInjector.get(this.f10966b)).a(this.f10965a)).putExtra("extra_target_id", this.f10967c).putExtra("source_activity", this.f10966b.getLocalClassName()).putExtra("publisher_type", this.f10968d);
        putExtra.putExtras(this.f10969e);
        new StringBuilder("From ").append(this.f10966b.getLocalClassName()).append(" / ").append(this.f10965a).append("\n-> ").append(putExtra.toString());
        if (this.f10970f != 0) {
            putExtra.addFlags(this.f10970f);
        }
        return putExtra;
    }

    public final CameraIntentBuilder m18987b(boolean z) {
        this.f10969e.putExtra("extra_disable_video", z);
        return this;
    }

    public final CameraIntentBuilder m18986a(int i) {
        this.f10969e.putExtra("desired_initial_facing", i);
        return this;
    }

    public final CameraIntentBuilder m18988c(boolean z) {
        this.f10969e.putExtra("return_after_snap", z);
        return this;
    }

    public final CameraIntentBuilder m18989d(boolean z) {
        this.f10969e.putExtra("show_profile_crop_overlay", z);
        return this;
    }
}
