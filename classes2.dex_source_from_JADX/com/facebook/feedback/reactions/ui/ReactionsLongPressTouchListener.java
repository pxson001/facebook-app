package com.facebook.feedback.reactions.ui;

import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.feed.rows.abtest.ExperimentsForMultipleRowsStoriesAbtestModule;
import com.facebook.feedback.reactions.abtest.ExperimentsForReactionsTestModule;
import com.facebook.feedback.reactions.abtest.ReactionsExperimentUtil;
import com.facebook.inject.Assisted;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

/* compiled from: gk_bootstrap_periodic_pull */
public class ReactionsLongPressTouchListener implements OnTouchListener {
    private final LongPressHandler f22351a;
    public final LongPressListener f22352b;
    public final ReactionsExperimentUtil f22353c;
    private final RectF f22354d = new RectF();
    private final boolean f22355e;
    public MotionEvent f22356f;

    /* compiled from: gk_bootstrap_periodic_pull */
    public interface LongPressListener {
        void mo3252a(MotionEvent motionEvent);
    }

    /* compiled from: gk_bootstrap_periodic_pull */
    class LongPressHandler extends Handler {
        private final WeakReference<ReactionsLongPressTouchListener> f22357a;

        public LongPressHandler(ReactionsLongPressTouchListener reactionsLongPressTouchListener) {
            super(Looper.getMainLooper());
            this.f22357a = new WeakReference(reactionsLongPressTouchListener);
        }

        public void handleMessage(Message message) {
            if (message.what == 1 && this.f22357a.get() != null) {
                ReactionsLongPressTouchListener reactionsLongPressTouchListener = (ReactionsLongPressTouchListener) this.f22357a.get();
                if (reactionsLongPressTouchListener.f22352b != null) {
                    reactionsLongPressTouchListener.f22352b.mo3252a(reactionsLongPressTouchListener.f22356f);
                }
            }
        }
    }

    @Inject
    public ReactionsLongPressTouchListener(QeAccessor qeAccessor, ReactionsExperimentUtil reactionsExperimentUtil, @Assisted LongPressListener longPressListener) {
        this.f22353c = reactionsExperimentUtil;
        this.f22352b = longPressListener;
        this.f22351a = new LongPressHandler(this);
        this.f22355e = qeAccessor.mo596a(ExperimentsForMultipleRowsStoriesAbtestModule.f6717g, false);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                m30287a(motionEvent);
                this.f22351a.removeMessages(1);
                LongPressHandler longPressHandler = this.f22351a;
                int a = this.f22353c.f6215b.mo572a(ExperimentsForReactionsTestModule.f21688e, 300);
                if (a < 150 || a > 1000) {
                    a = 300;
                }
                longPressHandler.sendEmptyMessageDelayed(1, (long) a);
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                this.f22354d.set((float) iArr[0], (float) iArr[1], (float) (iArr[0] + view.getWidth()), (float) (iArr[1] + view.getHeight()));
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                if (this.f22355e || this.f22354d.contains(motionEvent.getRawX(), motionEvent.getRawY())) {
                    m30287a(motionEvent);
                    break;
                }
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case 3:
                m30288c();
                break;
        }
        return false;
    }

    private void m30287a(MotionEvent motionEvent) {
        if (this.f22356f != null) {
            this.f22356f.recycle();
        }
        this.f22356f = motionEvent != null ? MotionEvent.obtain(motionEvent) : null;
    }

    private void m30288c() {
        this.f22351a.removeMessages(1);
        m30287a(null);
    }
}
