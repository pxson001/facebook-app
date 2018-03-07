package com.facebook.ads.internal.view.video.support;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.FrameLayout;

public class C2004a extends FrameLayout {
    public C2007e f14395a;
    private C2009f f14396b;
    public View f14397c;
    public Uri f14398d;
    private Context f14399e;

    public final void m14495a() {
        this.f14395a.start();
    }

    public int getCurrentPosition() {
        return this.f14395a.getCurrentPosition();
    }

    public View getPlaceholderView() {
        return this.f14397c;
    }

    public C2009f getVideoImplType() {
        return this.f14396b;
    }

    public void setFrameVideoViewListener(C2005b c2005b) {
        this.f14395a.setFrameVideoViewListener(c2005b);
    }

    public void setVideoImpl(C2009f c2009f) {
        removeAllViews();
        if (c2009f == C2009f.TEXTURE_VIEW && VERSION.SDK_INT < 14) {
            c2009f = C2009f.VIDEO_VIEW;
        }
        this.f14396b = c2009f;
        Object c2008d;
        switch (c2009f) {
            case TEXTURE_VIEW:
                c2008d = new C2008d(this.f14399e);
                c2008d.mo743a(this.f14397c, this.f14398d);
                addView(c2008d);
                this.f14395a = c2008d;
                break;
            case VIDEO_VIEW:
                c2008d = new C2010g(this.f14399e);
                c2008d.mo743a(this.f14397c, this.f14398d);
                addView(c2008d);
                this.f14395a = c2008d;
                break;
        }
        addView(this.f14397c);
        m14495a();
    }
}
