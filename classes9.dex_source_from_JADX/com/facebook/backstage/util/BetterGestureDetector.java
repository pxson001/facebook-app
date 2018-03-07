package com.facebook.backstage.util;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* compiled from: removeMontageViewerParams */
public class BetterGestureDetector extends GestureDetector {
    private static float f5551a = 0.0f;
    private static float f5552b = 0.0f;
    public final BetterGestureListener f5553c;
    private float f5554d;
    private float f5555e;
    private float f5556f;
    private float f5557g;
    private boolean f5558h;
    public boolean f5559i;
    private Handler f5560j = new C05871(this);
    public MotionEvent f5561k;
    public boolean f5562l;

    /* compiled from: removeMontageViewerParams */
    class C05871 extends Handler {
        final /* synthetic */ BetterGestureDetector f5550a;

        C05871(BetterGestureDetector betterGestureDetector) {
            this.f5550a = betterGestureDetector;
        }

        public void handleMessage(Message message) {
            this.f5550a.f5559i = true;
            if (this.f5550a.f5561k != null) {
                this.f5550a.f5553c.onLongPress(this.f5550a.f5561k);
            }
            super.handleMessage(message);
        }
    }

    public BetterGestureDetector(Context context, BetterGestureListener betterGestureListener) {
        super(context, betterGestureListener);
        this.f5553c = betterGestureListener;
        f5551a = m5762a(context, f5551a, 2131433210);
        f5552b = m5762a(context, f5552b, 2131433211);
    }

    private static float m5762a(Context context, float f, int i) {
        return f != 0.0f ? f : context.getResources().getDimension(i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        this.f5561k = motionEvent;
        switch (motionEvent.getAction()) {
            case 0:
                this.f5554d = motionEvent.getRawX();
                this.f5555e = motionEvent.getRawY();
                this.f5556f = this.f5554d;
                this.f5557g = this.f5555e;
                this.f5562l = true;
                this.f5558h = false;
                if (this.f5560j.hasMessages(0)) {
                    this.f5560j.removeMessages(0);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.f5560j.hasMessages(0)) {
                    this.f5560j.removeMessages(0);
                }
                this.f5559i = false;
                this.f5562l = false;
                if (!this.f5553c.m4884c()) {
                    this.f5553c.mo184a(motionEvent);
                    break;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.f5554d;
                float rawY = motionEvent.getRawY() - this.f5555e;
                float rawX2 = motionEvent.getRawX() - this.f5556f;
                float rawY2 = motionEvent.getRawY() - this.f5557g;
                if (this.f5558h) {
                    this.f5553c.mo185a(motionEvent, rawX2, rawY2);
                    this.f5556f = motionEvent.getRawX();
                    this.f5557g = motionEvent.getRawY();
                } else if (Math.sqrt(Math.pow((double) rawX, 2.0d) + Math.pow((double) rawY, 2.0d)) > ((double) f5552b)) {
                    this.f5553c.mo185a(motionEvent, rawX2, rawY2);
                    this.f5556f = motionEvent.getRawX();
                    this.f5557g = motionEvent.getRawY();
                    this.f5558h = true;
                }
                if (this.f5553c.m4885d()) {
                    if (!this.f5559i && Math.abs(rawX) < f5551a) {
                        if (rawX2 <= f5552b) {
                            if (!this.f5560j.hasMessages(0)) {
                                this.f5560j.sendEmptyMessageDelayed(0, (long) ViewConfiguration.getLongPressTimeout());
                                break;
                            }
                        }
                        this.f5560j.removeMessages(0);
                        this.f5560j.sendEmptyMessageDelayed(0, (long) ViewConfiguration.getLongPressTimeout());
                        break;
                    } else if (this.f5560j.hasMessages(0)) {
                        this.f5560j.removeMessages(0);
                        break;
                    }
                }
                break;
            default:
                if (this.f5560j.hasMessages(0)) {
                    this.f5560j.removeMessages(0);
                }
                int action = motionEvent.getAction() & -65281;
                if (action == 5) {
                    this.f5553c.mo195b(motionEvent);
                } else if (action == 6) {
                    this.f5553c.mo184a(motionEvent);
                    this.f5562l = false;
                }
                BetterGestureListener.m4879c(motionEvent);
                break;
        }
        return onTouchEvent;
    }
}
