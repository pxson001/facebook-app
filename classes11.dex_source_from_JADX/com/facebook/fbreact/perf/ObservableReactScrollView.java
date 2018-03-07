package com.facebook.fbreact.perf;

import android.content.Context;
import android.view.MotionEvent;
import com.facebook.common.perftest.DrawFrameLogger;
import com.facebook.fbreact.perf.FrameLoggingReactScrollViewManager.C09381;
import com.facebook.infer.annotation.Assertions;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.react.views.scroll.ReactScrollView;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: error_view */
public class ObservableReactScrollView extends ReactScrollView {
    public C09381 f7456a;
    public boolean f7457b;
    public boolean f7458c;
    private int f7459d;
    private final Runnable f7460e = new C09411(this);

    /* compiled from: error_view */
    class C09411 implements Runnable {
        final /* synthetic */ ObservableReactScrollView f7455a;

        C09411(ObservableReactScrollView observableReactScrollView) {
            this.f7455a = observableReactScrollView;
        }

        public void run() {
            if (this.f7455a.f7457b && !this.f7455a.f7458c) {
                ObservableReactScrollView.setScrollState(this.f7455a, 0);
            }
            this.f7455a.f7457b = false;
        }
    }

    public ObservableReactScrollView(Context context) {
        super(context);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1253385758);
        int action = motionEvent.getAction();
        if (action == 2) {
            this.f7458c = true;
            this.f7457b = true;
        } else if (action == 1) {
            if (this.f7458c && !this.f7457b) {
                setScrollState(this, 0);
            }
            this.f7458c = false;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        LogUtils.a(955623045, a);
        return onTouchEvent;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (Math.abs(i4 - i2) > 0) {
            removeCallbacks(this.f7460e);
            if (this.f7458c) {
                setScrollState(this, 1);
            } else if (this.f7456a != null) {
                setScrollState(this, 2);
            }
            postDelayed(this.f7460e, 40);
        }
    }

    public static void setScrollState(ObservableReactScrollView observableReactScrollView, int i) {
        if (!(i == observableReactScrollView.f7459d || observableReactScrollView.f7456a == null)) {
            C09381 c09381 = observableReactScrollView.f7456a;
            switch (i) {
                case 0:
                    ((DrawFrameLogger) Assertions.b(c09381.f7405a.f7406a)).b();
                    break;
                case 1:
                case 2:
                    ((DrawFrameLogger) Assertions.b(c09381.f7405a.f7406a)).a();
                    break;
            }
        }
        observableReactScrollView.f7459d = i;
    }
}
