package android.support.v4.widget;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;

/* compiled from: not_updated */
class ExploreByTouchHelper$ExploreByTouchNodeProvider extends AccessibilityNodeProviderCompat {
    final /* synthetic */ ExploreByTouchHelper f6979a;

    public ExploreByTouchHelper$ExploreByTouchNodeProvider(ExploreByTouchHelper exploreByTouchHelper) {
        this.f6979a = exploreByTouchHelper;
    }

    public final AccessibilityNodeInfoCompat m7275a(int i) {
        return ExploreByTouchHelper.d(this.f6979a, i);
    }

    public final boolean m7276a(int i, int i2, Bundle bundle) {
        return ExploreByTouchHelper.a(this.f6979a, i, i2, bundle);
    }
}
