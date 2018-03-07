package com.facebook.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.inject.FbInjector;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;

/* compiled from: positive_button_string */
public class FacebookProgressCircleViewAnimated extends FacebookProgressCircleView {
    public long f4391b;
    public Handler f4392c = new Handler(Looper.getMainLooper());
    public boolean f4393d = false;
    private DefaultAndroidThreadUtil f4394e;
    private final Runnable f4395f = new C02041(this);

    /* compiled from: positive_button_string */
    class C02041 implements Runnable {
        final /* synthetic */ FacebookProgressCircleViewAnimated f4412a;

        C02041(FacebookProgressCircleViewAnimated facebookProgressCircleViewAnimated) {
            this.f4412a = facebookProgressCircleViewAnimated;
        }

        public void run() {
            if (this.f4412a.f4400a < ((double) this.f4412a.f4391b)) {
                this.f4412a.f4393d = true;
                FacebookProgressCircleView facebookProgressCircleView = this.f4412a;
                facebookProgressCircleView.a = facebookProgressCircleView.f4400a + 1.0d;
                this.f4412a.invalidate();
                HandlerDetour.b(this.f4412a.f4392c, this, 20, -1076003864);
                return;
            }
            this.f4412a.f4393d = false;
            this.f4412a.a = (double) this.f4412a.f4391b;
        }
    }

    public FacebookProgressCircleViewAnimated(Context context) {
        super(context);
        m4918a(context);
    }

    public FacebookProgressCircleViewAnimated(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4918a(context);
    }

    public FacebookProgressCircleViewAnimated(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        m4918a(context);
    }

    private final void m4918a(Context context) {
        this.f4394e = DefaultAndroidThreadUtil.b(FbInjector.get(context));
    }

    public void setProgress(double d) {
        setProgress((long) d);
    }

    public void setProgress(long j) {
        this.f4394e.a();
        this.f4391b = j;
        if (this.f4391b >= 100) {
            this.a = 0.0d;
            this.f4391b = 0;
        } else if (!this.f4393d) {
            HandlerDetour.b(this.f4392c, this.f4395f, 20, -512590093);
        }
    }
}
