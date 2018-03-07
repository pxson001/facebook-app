package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

/* compiled from: rtc_video_camera_facing */
public class ViewConfigurationCompat {
    static final ViewConfigurationVersionImpl f6431a;

    /* compiled from: rtc_video_camera_facing */
    class IcsViewConfigurationVersionImpl extends HoneycombViewConfigurationVersionImpl {
        public final boolean mo1492b(ViewConfiguration viewConfiguration) {
            return viewConfiguration.hasPermanentMenuKey();
        }

        IcsViewConfigurationVersionImpl() {
        }
    }

    /* compiled from: rtc_video_camera_facing */
    class HoneycombViewConfigurationVersionImpl extends FroyoViewConfigurationVersionImpl {
        HoneycombViewConfigurationVersionImpl() {
        }

        public boolean mo1492b(ViewConfiguration viewConfiguration) {
            return false;
        }
    }

    /* compiled from: rtc_video_camera_facing */
    class FroyoViewConfigurationVersionImpl extends BaseViewConfigurationVersionImpl {
        public final int mo1493a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledPagingTouchSlop();
        }

        FroyoViewConfigurationVersionImpl() {
        }
    }

    /* compiled from: rtc_video_camera_facing */
    class BaseViewConfigurationVersionImpl implements ViewConfigurationVersionImpl {
        BaseViewConfigurationVersionImpl() {
        }

        public int mo1493a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledTouchSlop();
        }

        public boolean mo1492b(ViewConfiguration viewConfiguration) {
            return true;
        }
    }

    /* compiled from: rtc_video_camera_facing */
    interface ViewConfigurationVersionImpl {
        int mo1493a(ViewConfiguration viewConfiguration);

        boolean mo1492b(ViewConfiguration viewConfiguration);
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            f6431a = new IcsViewConfigurationVersionImpl();
        } else if (VERSION.SDK_INT >= 11) {
            f6431a = new HoneycombViewConfigurationVersionImpl();
        } else if (VERSION.SDK_INT >= 8) {
            f6431a = new FroyoViewConfigurationVersionImpl();
        } else {
            f6431a = new BaseViewConfigurationVersionImpl();
        }
    }

    public static int m10827a(ViewConfiguration viewConfiguration) {
        return f6431a.mo1493a(viewConfiguration);
    }

    public static boolean m10828b(ViewConfiguration viewConfiguration) {
        return f6431a.mo1492b(viewConfiguration);
    }
}
