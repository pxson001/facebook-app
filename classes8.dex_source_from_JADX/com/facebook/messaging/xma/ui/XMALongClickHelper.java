package com.facebook.messaging.xma.ui;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.facebook.inject.InjectorLike;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ti */
public class XMALongClickHelper {
    private GestureDetector f1606a;
    @Nullable
    public LongClickListener f1607b;
    public boolean f1608c;
    public boolean f1609d;

    /* compiled from: ti */
    public interface LongClickListener {
        void mo69a();
    }

    /* compiled from: ti */
    class C01701 extends SimpleOnGestureListener {
        final /* synthetic */ XMALongClickHelper f1605a;

        C01701(XMALongClickHelper xMALongClickHelper) {
            this.f1605a = xMALongClickHelper;
        }

        public boolean onDown(MotionEvent motionEvent) {
            this.f1605a.f1608c = false;
            return false;
        }

        public void onLongPress(MotionEvent motionEvent) {
            if (this.f1605a.f1607b != null) {
                this.f1605a.f1608c = true;
                if (this.f1605a.f1609d) {
                    this.f1605a.f1607b.mo69a();
                }
            }
        }
    }

    public static XMALongClickHelper m1799b(InjectorLike injectorLike) {
        return new XMALongClickHelper((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public XMALongClickHelper(Context context) {
        this.f1606a = new GestureDetector(context, new C01701(this));
    }

    public final boolean m1800a(MotionEvent motionEvent) {
        this.f1606a.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0) {
            this.f1609d = true;
        }
        if (this.f1607b == null || !this.f1608c) {
            return false;
        }
        return true;
    }

    public final void m1801b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1609d = false;
        }
    }
}
