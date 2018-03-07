package com.facebook.fbreact.perf;

import android.content.Context;
import android.view.MotionEvent;
import com.facebook.common.perftest.DrawFrameLogger;
import com.facebook.fbreact.perf.FrameLoggingFbReactScrollViewManager.C09371;
import com.facebook.fbreact.views.fbscroll.FbReactScrollView;
import com.facebook.infer.annotation.Assertions;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: eventName */
public class ObservableFbReactScrollView extends FbReactScrollView {
    public C09371 f7450a;
    public boolean f7451b;
    public boolean f7452c;
    private int f7453d;
    private final Runnable f7454e = new C09401(this);

    /* compiled from: eventName */
    class C09401 implements Runnable {
        final /* synthetic */ ObservableFbReactScrollView f7409a;

        C09401(ObservableFbReactScrollView observableFbReactScrollView) {
            this.f7409a = observableFbReactScrollView;
        }

        public void run() {
            if (this.f7409a.f7451b && !this.f7409a.f7452c) {
                ObservableFbReactScrollView.setScrollState(this.f7409a, 0);
            }
            this.f7409a.f7451b = false;
        }
    }

    public ObservableFbReactScrollView(Context context) {
        super(context, null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1451594573);
        int action = motionEvent.getAction();
        if (action == 2) {
            this.f7452c = true;
            this.f7451b = true;
        } else if (action == 1) {
            if (this.f7452c && !this.f7451b) {
                setScrollState(this, 0);
            }
            this.f7452c = false;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        LogUtils.a(-1461311129, a);
        return onTouchEvent;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (Math.abs(i4 - i2) > 0) {
            removeCallbacks(this.f7454e);
            if (this.f7452c) {
                setScrollState(this, 1);
            } else if (this.f7450a != null) {
                setScrollState(this, 2);
            }
            postDelayed(this.f7454e, 40);
        }
    }

    public static void setScrollState(ObservableFbReactScrollView observableFbReactScrollView, int i) {
        if (!(i == observableFbReactScrollView.f7453d || observableFbReactScrollView.f7450a == null)) {
            C09371 c09371 = observableFbReactScrollView.f7450a;
            switch (i) {
                case 0:
                    ((DrawFrameLogger) Assertions.b(c09371.f7402a.f7404a)).b();
                    break;
                case 1:
                case 2:
                    ((DrawFrameLogger) Assertions.b(c09371.f7402a.f7404a)).a();
                    break;
            }
        }
        observableFbReactScrollView.f7453d = i;
    }
}
