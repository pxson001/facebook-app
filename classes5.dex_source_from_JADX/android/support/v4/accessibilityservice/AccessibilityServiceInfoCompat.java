package android.support.v4.accessibilityservice;

import android.os.Build.VERSION;
import android.support.v7.widget.LinearLayoutCompat;

/* compiled from: work_newsfeed_nux */
public class AccessibilityServiceInfoCompat {
    private static final AccessibilityServiceInfoVersionImpl f0a;

    /* compiled from: work_newsfeed_nux */
    interface AccessibilityServiceInfoVersionImpl {
    }

    /* compiled from: work_newsfeed_nux */
    class AccessibilityServiceInfoStubImpl implements AccessibilityServiceInfoVersionImpl {
        AccessibilityServiceInfoStubImpl() {
        }
    }

    /* compiled from: work_newsfeed_nux */
    class AccessibilityServiceInfoIcsImpl extends AccessibilityServiceInfoStubImpl {
        AccessibilityServiceInfoIcsImpl() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            f0a = new AccessibilityServiceInfoIcsImpl();
        } else {
            f0a = new AccessibilityServiceInfoStubImpl();
        }
    }

    private AccessibilityServiceInfoCompat() {
    }

    public static String m0a(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        while (i > 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(i);
            i &= numberOfTrailingZeros ^ -1;
            if (stringBuilder.length() > 1) {
                stringBuilder.append(", ");
            }
            switch (numberOfTrailingZeros) {
                case 1:
                    stringBuilder.append("FEEDBACK_SPOKEN");
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    stringBuilder.append("FEEDBACK_HAPTIC");
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    stringBuilder.append("FEEDBACK_AUDIBLE");
                    break;
                case 8:
                    stringBuilder.append("FEEDBACK_VISUAL");
                    break;
                case 16:
                    stringBuilder.append("FEEDBACK_GENERIC");
                    break;
                default:
                    break;
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
