package com.facebook.ui.clickwithpositionlistener;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: group_feed_owner_authored_expired_type */
public class ClickWithPositionListenerBinder {
    private ClickWithPositionListenerAdapter f21752a;

    /* compiled from: group_feed_owner_authored_expired_type */
    class ClickWithPositionListenerAdapter implements OnClickListener, OnTouchListener {
        final /* synthetic */ ClickWithPositionListenerBinder f21753a;
        private float f21754b;
        private float f21755c;
        private int f21756d;
        private final ClickWithPositionListener f21757e;

        public ClickWithPositionListenerAdapter(ClickWithPositionListenerBinder clickWithPositionListenerBinder, ClickWithPositionListener clickWithPositionListener) {
            this.f21753a = clickWithPositionListenerBinder;
            this.f21757e = clickWithPositionListener;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 932246127);
            if (this.f21756d == 1) {
                this.f21757e.mo3186a(view, this.f21754b, this.f21755c);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 23205345, a);
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.f21754b = motionEvent.getX();
                this.f21755c = motionEvent.getY();
                this.f21756d = motionEvent.getPointerCount();
            }
            return false;
        }
    }

    public ClickWithPositionListenerBinder(ClickWithPositionListener clickWithPositionListener) {
        this.f21752a = new ClickWithPositionListenerAdapter(this, clickWithPositionListener);
    }

    public final void m29439a(View view) {
        view.setOnClickListener(this.f21752a);
        view.setOnTouchListener(this.f21752a);
    }

    public static void m29438b(View view) {
        view.setOnClickListener(null);
        view.setOnTouchListener(null);
    }
}
