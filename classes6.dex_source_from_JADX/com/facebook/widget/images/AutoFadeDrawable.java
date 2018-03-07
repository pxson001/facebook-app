package com.facebook.widget.images;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;

@Deprecated
/* compiled from: requesting column name with table name -- %s */
public class AutoFadeDrawable extends TransitionDrawable {
    public final Handler f5745a;
    public final Runnable f5746b = new C03361(this);
    public boolean f5747c;
    public boolean f5748d;

    /* compiled from: requesting column name with table name -- %s */
    class C03361 implements Runnable {
        final /* synthetic */ AutoFadeDrawable f5744a;

        C03361(AutoFadeDrawable autoFadeDrawable) {
            this.f5744a = autoFadeDrawable;
        }

        public void run() {
            this.f5744a.invalidateSelf();
        }
    }

    @Inject
    public AutoFadeDrawable(Handler handler, @Assisted Drawable drawable, @Assisted Drawable drawable2) {
        super(new Drawable[]{drawable, drawable2});
        this.f5745a = handler;
        setCrossFadeEnabled(false);
        this.f5747c = false;
        this.f5748d = false;
    }

    public void startTransition(int i) {
        if (!this.f5747c) {
            super.startTransition(i);
            this.f5747c = true;
        }
    }

    public void invalidateSelf() {
        if (!this.f5748d) {
            super.invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        HandlerDetour.a(this.f5745a, this.f5746b);
        super.draw(canvas);
        if (!this.f5747c) {
            this.f5748d = true;
            startTransition(300);
            this.f5748d = false;
            HandlerDetour.a(this.f5745a, this.f5746b);
            HandlerDetour.a(this.f5745a, this.f5746b, 33264585);
        }
    }
}
