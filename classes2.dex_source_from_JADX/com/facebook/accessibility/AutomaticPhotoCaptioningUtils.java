package com.facebook.accessibility;

import android.view.accessibility.AccessibilityManager;
import com.facebook.common.android.AccessibilityManagerMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.experiments.ExperimentsForPhotosExperimentsModule;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: scan_start_time */
public class AutomaticPhotoCaptioningUtils {
    private final AccessibilityManager f6068a;
    private final QeAccessor f6069b;

    public static AutomaticPhotoCaptioningUtils m10187b(InjectorLike injectorLike) {
        return new AutomaticPhotoCaptioningUtils(AccessibilityManagerMethodAutoProvider.m8780b(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public AutomaticPhotoCaptioningUtils(AccessibilityManager accessibilityManager, QeAccessor qeAccessor) {
        this.f6068a = accessibilityManager;
        this.f6069b = qeAccessor;
    }

    public final boolean m10188a() {
        return this.f6068a.isEnabled() && this.f6068a.isTouchExplorationEnabled() && this.f6069b.mo596a(ExperimentsForPhotosExperimentsModule.b, false);
    }

    public static AutomaticPhotoCaptioningUtils m10186a(InjectorLike injectorLike) {
        return m10187b(injectorLike);
    }
}
