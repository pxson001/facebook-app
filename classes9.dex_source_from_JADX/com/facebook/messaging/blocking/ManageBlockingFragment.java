package com.facebook.messaging.blocking;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.common.analytics.BusinessAnalyticsLogger;
import com.facebook.messaging.business.common.helper.BusinessMessageDialogHelper;
import com.facebook.messaging.business.promotion.gating.BusinessPromotionGatekeepers;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.user.model.User;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: onScroll */
public class ManageBlockingFragment extends FbDialogFragment {
    @Inject
    public ManageBlockingFragmentController am;
    private User an;
    @Nullable
    private ManageBlockingParam ao;

    public static void m8523a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ManageBlockingFragment) obj).am = new ManageBlockingFragmentController(ErrorDialogs.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), BlockingUtils.m8514b(injectorLike), BlockingAnalyticsLogger.m8498b(injectorLike), IdBasedProvider.a(injectorLike, 643), BusinessAnalyticsLogger.m8898b(injectorLike), BusinessMessageDialogHelper.m9018b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 7898), BusinessPromotionGatekeepers.m9358b(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    public static ManageBlockingFragment m8522a(User user) {
        ManageBlockingFragment manageBlockingFragment = new ManageBlockingFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("arg_blockee", user);
        manageBlockingFragment.g(bundle);
        return manageBlockingFragment;
    }

    public final void m8525a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -9377198);
        super.a(bundle);
        Class cls = ManageBlockingFragment.class;
        m8523a(this, getContext());
        Bundle bundle2 = this.s;
        if (bundle != null) {
            this.an = (User) bundle.get("arg_blockee");
            this.ao = (ManageBlockingParam) bundle.get("arg_param");
        } else if (bundle2 != null) {
            this.an = (User) bundle2.getParcelable("arg_blockee");
            this.ao = (ManageBlockingParam) bundle2.getParcelable("arg_param");
        }
        LogUtils.f(61215178, a);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2068171412);
        super.mi_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 911059559, a);
    }

    public final Dialog m8526c(Bundle bundle) {
        Dialog c = super.c(bundle);
        c.getWindow().requestFeature(1);
        return c;
    }

    public final void m8527e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelable("arg_blockee", this.an);
        if (this.ao != null) {
            bundle.putParcelable("arg_param", this.ao);
        }
    }

    public final View m8524a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -458415356);
        View inflate = layoutInflater.inflate(2130905159, viewGroup, false);
        inflate.setOnClickListener(null);
        this.am.m8553a(this.an, this.ao, inflate, this.D);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -220068728, a);
        return inflate;
    }
}
