package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

/* compiled from: friends/center?source_ref=%s */
public class GestureDetectorCompat {
    public final GestureDetectorCompatImpl f23059a;

    /* compiled from: friends/center?source_ref=%s */
    class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompatImpl {
        private final GestureDetector f23060a;

        public GestureDetectorCompatImplJellybeanMr2(Context context, OnGestureListener onGestureListener, Handler handler) {
            this.f23060a = new GestureDetector(context, onGestureListener, handler);
        }

        public final boolean mo3387a(MotionEvent motionEvent) {
            return this.f23060a.onTouchEvent(motionEvent);
        }

        public final void mo3386a(boolean z) {
            this.f23060a.setIsLongpressEnabled(z);
        }
    }

    /* compiled from: friends/center?source_ref=%s */
    public interface GestureDetectorCompatImpl {
        void mo3386a(boolean z);

        boolean mo3387a(MotionEvent motionEvent);
    }

    public GestureDetectorCompat(Context context, OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    private GestureDetectorCompat(Context context, OnGestureListener onGestureListener, Handler handler) {
        if (VERSION.SDK_INT > 17) {
            this.f23059a = new GestureDetectorCompatImplJellybeanMr2(context, onGestureListener, handler);
        } else {
            this.f23059a = new GestureDetectorCompatImplBase(context, onGestureListener, handler);
        }
    }

    public final boolean m31181a(MotionEvent motionEvent) {
        return this.f23059a.mo3387a(motionEvent);
    }
}
