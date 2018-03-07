package com.facebook.drawee.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.components.DraweeEventTracker.Event;
import com.facebook.drawee.drawable.VisibilityAwareDrawable;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import javax.annotation.Nullable;

/* compiled from: messenger_android_photo_reminders_media_tray_nux */
public class DraweeHolder<DH extends DraweeHierarchy> {
    private boolean f14181a = false;
    public boolean f14182b = false;
    private boolean f14183c = true;
    private boolean f14184d = true;
    public DH f14185e;
    public DraweeController f14186f = null;
    public final DraweeEventTracker f14187g = new DraweeEventTracker();

    public static <DH extends DraweeHierarchy> DraweeHolder<DH> m20512a(@Nullable DH dh, Context context) {
        return new DraweeHolder(dh);
    }

    public DraweeHolder(@Nullable DH dh) {
        if (dh != null) {
            m20519a((DraweeHierarchy) dh);
        }
    }

    public final void m20522b() {
        this.f14187g.m20546a(Event.ON_HOLDER_ATTACH);
        this.f14182b = true;
        m20516l();
    }

    public final void m20523d() {
        this.f14187g.m20546a(Event.ON_HOLDER_DETACH);
        this.f14182b = false;
        m20516l();
    }

    public final boolean m20521a(MotionEvent motionEvent) {
        if (this.f14186f == null) {
            return false;
        }
        return this.f14186f.m20529a(motionEvent);
    }

    public final void m20520a(boolean z) {
        if (this.f14183c != z) {
            this.f14187g.m20546a(z ? Event.ON_DRAWABLE_SHOW : Event.ON_DRAWABLE_HIDE);
            this.f14183c = z;
            m20516l();
        }
    }

    public final void m20517a() {
        if (!this.f14181a) {
            Class cls = DraweeEventTracker.class;
            String str = "%x: Draw requested for a non-attached controller %x. %s";
            Object[] objArr = new Object[]{Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.f14186f)), toString()};
            if (FLog.a.b(6)) {
                FLog.a.c(FLog.a(cls), FLog.a(str, objArr));
            }
            this.f14182b = true;
            this.f14183c = true;
            this.f14184d = true;
            m20516l();
        }
    }

    private void m20513a(@Nullable DraweeHolder draweeHolder) {
        Drawable h = m20526h();
        if (h instanceof VisibilityAwareDrawable) {
            ((VisibilityAwareDrawable) h).mo2749a(draweeHolder);
        }
    }

    public void mo3378a(@Nullable DraweeController draweeController) {
        boolean z = this.f14181a;
        if (z) {
            m20515k();
        }
        if (this.f14186f != null) {
            this.f14187g.m20546a(Event.ON_CLEAR_OLD_CONTROLLER);
            this.f14186f.m20528a(null);
        }
        this.f14186f = draweeController;
        if (this.f14186f != null) {
            this.f14187g.m20546a(Event.ON_SET_CONTROLLER);
            this.f14186f.m20528a(this.f14185e);
        } else {
            this.f14187g.m20546a(Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            m20514j();
        }
    }

    @Nullable
    public final DraweeController m20524e() {
        return this.f14186f;
    }

    public final void m20519a(DH dh) {
        this.f14187g.m20546a(Event.ON_SET_HIERARCHY);
        m20513a(null);
        this.f14185e = (DraweeHierarchy) Preconditions.a(dh);
        Drawable a = this.f14185e.mo2732a();
        boolean z = a == null || a.isVisible();
        m20520a(z);
        m20513a(this);
        if (this.f14186f != null) {
            this.f14186f.m20528a((DraweeHierarchy) dh);
        }
    }

    public final DH m20525f() {
        return (DraweeHierarchy) Preconditions.a(this.f14185e);
    }

    public final Drawable m20526h() {
        return this.f14185e == null ? null : this.f14185e.mo2732a();
    }

    private void m20514j() {
        if (!this.f14181a) {
            this.f14187g.m20546a(Event.ON_ATTACH_CONTROLLER);
            this.f14181a = true;
            if (this.f14186f != null && this.f14186f.m20530d() != null) {
                this.f14186f.m20531e();
            }
        }
    }

    private void m20515k() {
        if (this.f14181a) {
            this.f14187g.m20546a(Event.ON_DETACH_CONTROLLER);
            this.f14181a = false;
            if (this.f14186f != null) {
                this.f14186f.m20532f();
            }
        }
    }

    private void m20516l() {
        if (this.f14182b && this.f14183c && this.f14184d) {
            m20514j();
        } else {
            m20515k();
        }
    }

    public String toString() {
        return Objects.m20537a((Object) this).m20545a("controllerAttached", this.f14181a).m20545a("holderAttached", this.f14182b).m20545a("drawableVisible", this.f14183c).m20545a("activityStarted", this.f14184d).m20544a("events", this.f14187g.toString()).toString();
    }
}
