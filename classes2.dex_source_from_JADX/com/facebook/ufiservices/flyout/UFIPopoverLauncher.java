package com.facebook.ufiservices.flyout;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.Window;
import com.facebook.base.activity.FbRootViewUtil;
import com.facebook.base.fragment.FragmentManagerHost;
import com.facebook.common.util.ContextUtils;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ufiservices.flyout.PopoverParams.Builder;
import com.facebook.ufiservices.qe.ExperimentsForUFIServicesModule;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: is_success */
public class UFIPopoverLauncher {
    private final QeAccessor f18846a;

    public static UFIPopoverLauncher m26514b(InjectorLike injectorLike) {
        return new UFIPopoverLauncher(QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public UFIPopoverLauncher(QeAccessor qeAccessor) {
        this.f18846a = qeAccessor;
    }

    public final void m26515a(UFIContentFragment uFIContentFragment, Context context) {
        m26516a(uFIContentFragment, context, new Builder().a(), true);
    }

    public final void m26516a(UFIContentFragment uFIContentFragment, Context context, PopoverParams popoverParams, boolean z) {
        FragmentManagerHost fragmentManagerHost = (FragmentManagerHost) ContextUtils.m2500a(context, FragmentManagerHost.class);
        Activity activity = (Activity) ContextUtils.m2500a(context, Activity.class);
        Preconditions.checkNotNull(fragmentManagerHost);
        Preconditions.checkNotNull(activity);
        boolean z2 = popoverParams.a;
        String a = this.f18846a.mo581a(ExperimentsForUFIServicesModule.b, "CONTROL");
        if ("CONTROL".equals(a)) {
            Window window;
            View a2;
            FragmentManager kO_ = fragmentManagerHost.kO_();
            if (z2) {
                window = activity.getWindow();
            } else {
                window = null;
            }
            if (z2) {
                a2 = FbRootViewUtil.m13815a(context);
            } else {
                a2 = null;
            }
            UFIPopoverFragment uFIPopoverFragment = new UFIPopoverFragment();
            uFIPopoverFragment.ap = uFIContentFragment;
            uFIPopoverFragment.a(kO_, window, a2, z);
            return;
        }
        FragmentManager kO_2 = fragmentManagerHost.kO_();
        boolean equals = "VIEW_ANIMATION".equals(a);
        if (kO_2.mo851c()) {
            SimpleUFIPopoverFragment simpleUFIPopoverFragment = new SimpleUFIPopoverFragment();
            simpleUFIPopoverFragment.as = uFIContentFragment;
            DialogFragment dialogFragment = simpleUFIPopoverFragment;
            dialogFragment.m211a(2, dialogFragment.m217d());
            dialogFragment.an = equals;
            dialogFragment.m213a(kO_2, "chromeless:content:fragment:tag");
        } else {
            BLog.b(SimpleUFIPopoverFragment.ar, "Unsafe to commit stateful transactions.");
        }
    }
}
