package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.MotionEvent;

/* compiled from: push_extra */
public class MotionEventCompat {
    static final MotionEventVersionImpl f4044a;

    /* compiled from: push_extra */
    class HoneycombMr1MotionEventVersionImpl extends GingerbreadMotionEventVersionImpl {
        public final float mo312e(MotionEvent motionEvent, int i) {
            return motionEvent.getAxisValue(i);
        }

        HoneycombMr1MotionEventVersionImpl() {
        }
    }

    /* compiled from: push_extra */
    class GingerbreadMotionEventVersionImpl extends EclairMotionEventVersionImpl {
        public final int mo313b(MotionEvent motionEvent) {
            return motionEvent.getSource();
        }

        GingerbreadMotionEventVersionImpl() {
        }
    }

    /* compiled from: push_extra */
    class EclairMotionEventVersionImpl extends BaseMotionEventVersionImpl {
        public final int mo315a(MotionEvent motionEvent, int i) {
            return motionEvent.findPointerIndex(i);
        }

        public final int mo316b(MotionEvent motionEvent, int i) {
            return motionEvent.getPointerId(i);
        }

        public final float mo317c(MotionEvent motionEvent, int i) {
            return motionEvent.getX(i);
        }

        public final float mo318d(MotionEvent motionEvent, int i) {
            return motionEvent.getY(i);
        }

        public final int mo314a(MotionEvent motionEvent) {
            return motionEvent.getPointerCount();
        }

        EclairMotionEventVersionImpl() {
        }
    }

    /* compiled from: push_extra */
    class BaseMotionEventVersionImpl implements MotionEventVersionImpl {
        BaseMotionEventVersionImpl() {
        }

        public int mo315a(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return 0;
            }
            return -1;
        }

        public int mo316b(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return 0;
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        public float mo317c(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return motionEvent.getX();
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        public float mo318d(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return motionEvent.getY();
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        public int mo314a(MotionEvent motionEvent) {
            return 1;
        }

        public int mo313b(MotionEvent motionEvent) {
            return 0;
        }

        public float mo312e(MotionEvent motionEvent, int i) {
            return 0.0f;
        }
    }

    /* compiled from: push_extra */
    interface MotionEventVersionImpl {
        int mo314a(MotionEvent motionEvent);

        int mo315a(MotionEvent motionEvent, int i);

        int mo313b(MotionEvent motionEvent);

        int mo316b(MotionEvent motionEvent, int i);

        float mo317c(MotionEvent motionEvent, int i);

        float mo318d(MotionEvent motionEvent, int i);

        float mo312e(MotionEvent motionEvent, int i);
    }

    static {
        if (VERSION.SDK_INT >= 12) {
            f4044a = new HoneycombMr1MotionEventVersionImpl();
        } else if (VERSION.SDK_INT >= 9) {
            f4044a = new GingerbreadMotionEventVersionImpl();
        } else if (VERSION.SDK_INT >= 5) {
            f4044a = new EclairMotionEventVersionImpl();
        } else {
            f4044a = new BaseMotionEventVersionImpl();
        }
    }

    public static int m4535a(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static int m4537b(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    public static int m4536a(MotionEvent motionEvent, int i) {
        return f4044a.mo315a(motionEvent, i);
    }

    public static int m4538b(MotionEvent motionEvent, int i) {
        return f4044a.mo316b(motionEvent, i);
    }

    public static float m4539c(MotionEvent motionEvent, int i) {
        return f4044a.mo317c(motionEvent, i);
    }

    public static float m4541d(MotionEvent motionEvent, int i) {
        return f4044a.mo318d(motionEvent, i);
    }

    public static int m4540c(MotionEvent motionEvent) {
        return f4044a.mo314a(motionEvent);
    }

    public static int m4542d(MotionEvent motionEvent) {
        return f4044a.mo313b(motionEvent);
    }

    public static float m4543e(MotionEvent motionEvent, int i) {
        return f4044a.mo312e(motionEvent, i);
    }
}
