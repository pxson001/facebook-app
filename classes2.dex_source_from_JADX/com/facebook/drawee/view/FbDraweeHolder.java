package com.facebook.drawee.view;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.Objects;
import com.facebook.drawee.components.DraweeEventTracker.Event;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.annotation.Nullable;

/* compiled from: friends_birthday_profile_image_size */
public class FbDraweeHolder<DH extends DraweeHierarchy> extends DraweeHolder<DH> {
    public static final Handler f23028a = new Handler(Looper.getMainLooper());
    public Runnable f23029b;
    public boolean f23030c;
    public boolean f23031d;

    public FbDraweeHolder(@Nullable DH dh) {
        super(dh);
    }

    public final void mo3378a(@Nullable DraweeController draweeController) {
        if (this.f23031d) {
            HandlerDetour.a(f23028a, this.f23029b);
            this.f23031d = false;
        }
        if (this.f23030c && this.f14186f == draweeController) {
            this.f14187g.m20546a(Event.ON_SAME_CONTROLLER_SKIPPED);
        } else {
            super.mo3378a(draweeController);
        }
    }

    public String toString() {
        return Objects.m20537a((Object) this).m20544a("draweeHolder", super.toString()).m20545a("skipSameController", this.f23030c).toString();
    }
}
