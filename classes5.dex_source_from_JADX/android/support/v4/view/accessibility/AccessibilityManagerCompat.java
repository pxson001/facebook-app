package android.support.v4.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityManager;
import java.util.Collections;
import java.util.List;

/* compiled from: vertex_edit_button */
public class AccessibilityManagerCompat {
    public static final AccessibilityManagerVersionImpl f376a;

    /* compiled from: vertex_edit_button */
    public interface AccessibilityManagerVersionImpl {
        List<AccessibilityServiceInfo> mo99a(AccessibilityManager accessibilityManager);

        List<AccessibilityServiceInfo> mo100a(AccessibilityManager accessibilityManager, int i);

        boolean mo101b(AccessibilityManager accessibilityManager);
    }

    /* compiled from: vertex_edit_button */
    class AccessibilityManagerStubImpl implements AccessibilityManagerVersionImpl {
        AccessibilityManagerStubImpl() {
        }

        public List<AccessibilityServiceInfo> mo100a(AccessibilityManager accessibilityManager, int i) {
            return Collections.emptyList();
        }

        public List<AccessibilityServiceInfo> mo99a(AccessibilityManager accessibilityManager) {
            return Collections.emptyList();
        }

        public boolean mo101b(AccessibilityManager accessibilityManager) {
            return false;
        }
    }

    /* compiled from: vertex_edit_button */
    class AccessibilityManagerIcsImpl extends AccessibilityManagerStubImpl {
        public final List<AccessibilityServiceInfo> mo100a(AccessibilityManager accessibilityManager, int i) {
            return accessibilityManager.getEnabledAccessibilityServiceList(i);
        }

        public final List<AccessibilityServiceInfo> mo99a(AccessibilityManager accessibilityManager) {
            return accessibilityManager.getInstalledAccessibilityServiceList();
        }

        public final boolean mo101b(AccessibilityManager accessibilityManager) {
            return accessibilityManager.isTouchExplorationEnabled();
        }

        AccessibilityManagerIcsImpl() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            f376a = new AccessibilityManagerIcsImpl();
        } else {
            f376a = new AccessibilityManagerStubImpl();
        }
    }

    public static boolean m534b(AccessibilityManager accessibilityManager) {
        return f376a.mo101b(accessibilityManager);
    }
}
