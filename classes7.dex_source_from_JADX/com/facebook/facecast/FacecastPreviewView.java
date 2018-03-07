package com.facebook.facecast;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.debug.log.BLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: bulb */
public class FacecastPreviewView extends SurfaceView {
    private static final String f18044a = FacecastPreviewView.class.getName();
    public final List<OnTouchListener> f18045b;
    private boolean f18046c;

    /* compiled from: bulb */
    class C15251 implements OnTouchListener {
        final /* synthetic */ FacecastPreviewView f18043a;

        C15251(FacecastPreviewView facecastPreviewView) {
            this.f18043a = facecastPreviewView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean z = false;
            for (OnTouchListener onTouch : this.f18043a.f18045b) {
                boolean z2;
                if (onTouch.onTouch(view, motionEvent)) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                z = z2;
            }
            return z;
        }
    }

    public FacecastPreviewView(Context context) {
        this(context, null);
    }

    public FacecastPreviewView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FacecastPreviewView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18045b = new ArrayList();
        super.setOnTouchListener(new C15251(this));
    }

    public void onMeasure(int i, int i2) {
        int defaultSize;
        int min = Math.min(View.getDefaultSize(0, i), View.getDefaultSize(0, i2));
        if (this.f18046c) {
            defaultSize = View.getDefaultSize(0, i2);
        } else {
            defaultSize = min;
        }
        setMeasuredDimension(min, defaultSize);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
        BLog.b(f18044a, "Do not set an onTouchListener to this class. Use addOnTouchListener instead");
    }

    public final void m21876a(OnTouchListener onTouchListener) {
        this.f18045b.add(onTouchListener);
    }

    public final void m21877b(OnTouchListener onTouchListener) {
        this.f18045b.remove(onTouchListener);
    }

    public void setFullScreen(boolean z) {
        this.f18046c = z;
        requestLayout();
    }
}
