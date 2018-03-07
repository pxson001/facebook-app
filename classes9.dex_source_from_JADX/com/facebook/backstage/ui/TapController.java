package com.facebook.backstage.ui;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.backstage.ui.SpringTextView.AnimStates;
import com.facebook.backstage.ui.SpringTextView.C05841;

/* compiled from: remove_friend_ids */
public class TapController {
    public final GestureDetector f5513a;
    public boolean f5514b = true;
    public C05841 f5515c;

    /* compiled from: remove_friend_ids */
    class OnGestureListener extends SimpleOnGestureListener {
        final /* synthetic */ TapController f5511a;

        public OnGestureListener(TapController tapController) {
            this.f5511a = tapController;
        }

        public boolean onDown(MotionEvent motionEvent) {
            if (this.f5511a.f5515c != null) {
                SpringTextView springTextView = this.f5511a.f5515c.f5509a;
                if (!springTextView.f4389e.equals(AnimStates.PRESSING)) {
                    springTextView.f4389e = AnimStates.PRESSING;
                    springTextView.f4387c.a(springTextView.f4385a);
                    springTextView.f4387c.b(0.8d);
                }
            }
            return true;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (this.f5511a.f5515c != null) {
                this.f5511a.f5515c.m5743c();
            }
            if (this.f5511a.f5515c == null) {
                return false;
            }
            C05841 c05841 = this.f5511a.f5515c;
            if (c05841.f5509a.f4390f != null) {
                c05841.f5509a.f4390f.m5746a();
            }
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
        }
    }

    /* compiled from: remove_friend_ids */
    class ViewOnTouchListener implements OnTouchListener {
        final /* synthetic */ TapController f5512a;

        public ViewOnTouchListener(TapController tapController) {
            this.f5512a = tapController;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!this.f5512a.f5514b) {
                return false;
            }
            if (this.f5512a.f5513a.onTouchEvent(motionEvent)) {
                return true;
            }
            if ((motionEvent.getAction() != 3 && motionEvent.getAction() != 1) || this.f5512a.f5515c == null) {
                return true;
            }
            this.f5512a.f5515c.m5743c();
            return true;
        }
    }

    public TapController(Context context, View view) {
        view.setOnTouchListener(new ViewOnTouchListener(this));
        this.f5513a = new GestureDetector(context, new OnGestureListener(this));
        this.f5513a.setIsLongpressEnabled(false);
        this.f5513a.setOnDoubleTapListener(null);
    }
}
