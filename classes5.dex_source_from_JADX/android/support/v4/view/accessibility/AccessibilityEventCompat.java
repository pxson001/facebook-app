package android.support.v4.view.accessibility;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: vertex_inline */
public class AccessibilityEventCompat {
    public static final AccessibilityEventVersionImpl f375a;

    /* compiled from: vertex_inline */
    public interface AccessibilityEventVersionImpl {
        int mo97a(AccessibilityEvent accessibilityEvent);

        void mo98a(AccessibilityEvent accessibilityEvent, int i);
    }

    /* compiled from: vertex_inline */
    class AccessibilityEventStubImpl implements AccessibilityEventVersionImpl {
        AccessibilityEventStubImpl() {
        }

        public void mo98a(AccessibilityEvent accessibilityEvent, int i) {
        }

        public int mo97a(AccessibilityEvent accessibilityEvent) {
            return 0;
        }
    }

    /* compiled from: vertex_inline */
    class AccessibilityEventIcsImpl extends AccessibilityEventStubImpl {
        AccessibilityEventIcsImpl() {
        }
    }

    /* compiled from: vertex_inline */
    class AccessibilityEventKitKatImpl extends AccessibilityEventIcsImpl {
        public final void mo98a(AccessibilityEvent accessibilityEvent, int i) {
            accessibilityEvent.setContentChangeTypes(i);
        }

        public final int mo97a(AccessibilityEvent accessibilityEvent) {
            return accessibilityEvent.getContentChangeTypes();
        }

        AccessibilityEventKitKatImpl() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            f375a = new AccessibilityEventKitKatImpl();
        } else if (VERSION.SDK_INT >= 14) {
            f375a = new AccessibilityEventIcsImpl();
        } else {
            f375a = new AccessibilityEventStubImpl();
        }
    }

    private AccessibilityEventCompat() {
    }

    public static AccessibilityRecordCompat m524a(AccessibilityEvent accessibilityEvent) {
        return new AccessibilityRecordCompat(accessibilityEvent);
    }
}
