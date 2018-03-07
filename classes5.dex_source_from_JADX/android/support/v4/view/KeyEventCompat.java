package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.KeyEvent;

/* compiled from: video_list_title */
public class KeyEventCompat {
    public static final KeyEventVersionImpl f305a;

    /* compiled from: video_list_title */
    public interface KeyEventVersionImpl {
        void mo52a(KeyEvent keyEvent);

        boolean mo53a(int i, int i2);

        boolean mo54b(int i);
    }

    /* compiled from: video_list_title */
    class BaseKeyEventVersionImpl implements KeyEventVersionImpl {
        BaseKeyEventVersionImpl() {
        }

        private static int m332a(int i, int i2, int i3, int i4, int i5) {
            Object obj = 1;
            Object obj2 = (i2 & i3) != 0 ? 1 : null;
            int i6 = i4 | i5;
            if ((i2 & i6) == 0) {
                obj = null;
            }
            if (obj2 != null) {
                if (obj == null) {
                    return i & (i6 ^ -1);
                }
                throw new IllegalArgumentException("bad arguments");
            } else if (obj != null) {
                return i & (i3 ^ -1);
            } else {
                return i;
            }
        }

        public int mo55a(int i) {
            int i2;
            if ((i & 192) != 0) {
                i2 = i | 1;
            } else {
                i2 = i;
            }
            if ((i2 & 48) != 0) {
                i2 |= 2;
            }
            return i2 & 247;
        }

        public boolean mo53a(int i, int i2) {
            if (m332a(m332a(mo55a(i) & 247, i2, 1, 64, 128), i2, 2, 16, 32) == i2) {
                return true;
            }
            return false;
        }

        public boolean mo54b(int i) {
            return (mo55a(i) & 247) == 0;
        }

        public void mo52a(KeyEvent keyEvent) {
        }
    }

    /* compiled from: video_list_title */
    class EclairKeyEventVersionImpl extends BaseKeyEventVersionImpl {
        public final void mo52a(KeyEvent keyEvent) {
            keyEvent.startTracking();
        }

        EclairKeyEventVersionImpl() {
        }
    }

    /* compiled from: video_list_title */
    class HoneycombKeyEventVersionImpl extends EclairKeyEventVersionImpl {
        public final int mo55a(int i) {
            return KeyEvent.normalizeMetaState(i);
        }

        public final boolean mo53a(int i, int i2) {
            return KeyEvent.metaStateHasModifiers(i, i2);
        }

        public final boolean mo54b(int i) {
            return KeyEvent.metaStateHasNoModifiers(i);
        }

        HoneycombKeyEventVersionImpl() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f305a = new HoneycombKeyEventVersionImpl();
        } else {
            f305a = new BaseKeyEventVersionImpl();
        }
    }

    public static boolean m341a(KeyEvent keyEvent) {
        return f305a.mo54b(keyEvent.getMetaState());
    }
}
