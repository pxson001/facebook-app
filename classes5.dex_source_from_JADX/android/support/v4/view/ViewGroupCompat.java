package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup;

/* compiled from: video/x-matroska */
public class ViewGroupCompat {
    public static final ViewGroupCompatImpl f353a;

    /* compiled from: video/x-matroska */
    public interface ViewGroupCompatImpl {
        int mo70a(ViewGroup viewGroup);

        void mo71a(ViewGroup viewGroup, boolean z);
    }

    /* compiled from: video/x-matroska */
    class ViewGroupCompatStubImpl implements ViewGroupCompatImpl {
        ViewGroupCompatStubImpl() {
        }

        public void mo71a(ViewGroup viewGroup, boolean z) {
        }

        public int mo70a(ViewGroup viewGroup) {
            return 0;
        }
    }

    /* compiled from: video/x-matroska */
    class ViewGroupCompatHCImpl extends ViewGroupCompatStubImpl {
        public final void mo71a(ViewGroup viewGroup, boolean z) {
            viewGroup.setMotionEventSplittingEnabled(z);
        }

        ViewGroupCompatHCImpl() {
        }
    }

    /* compiled from: video/x-matroska */
    class ViewGroupCompatIcsImpl extends ViewGroupCompatHCImpl {
        ViewGroupCompatIcsImpl() {
        }
    }

    /* compiled from: video/x-matroska */
    class ViewGroupCompatJellybeanMR2Impl extends ViewGroupCompatIcsImpl {
        public final int mo70a(ViewGroup viewGroup) {
            return viewGroup.getLayoutMode();
        }

        ViewGroupCompatJellybeanMR2Impl() {
        }
    }

    /* compiled from: video/x-matroska */
    class ViewGroupCompatApi21Impl extends ViewGroupCompatJellybeanMR2Impl {
        ViewGroupCompatApi21Impl() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f353a = new ViewGroupCompatApi21Impl();
        } else if (i >= 18) {
            f353a = new ViewGroupCompatJellybeanMR2Impl();
        } else if (i >= 14) {
            f353a = new ViewGroupCompatIcsImpl();
        } else if (i >= 11) {
            f353a = new ViewGroupCompatHCImpl();
        } else {
            f353a = new ViewGroupCompatStubImpl();
        }
    }

    private ViewGroupCompat() {
    }

    public static int m421a(ViewGroup viewGroup) {
        return f353a.mo70a(viewGroup);
    }
}
