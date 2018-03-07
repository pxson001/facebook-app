package com.facebook.securitycheckup.items;

import android.content.Context;
import android.view.View;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.securitycheckup.SecurityCheckupLogger;
import com.facebook.securitycheckup.SecurityCheckupState;
import com.facebook.securitycheckup.inner.SecurityCheckupInnerControllerProvider;
import com.facebook.securitycheckup.password.SecurityCheckupPasswordChangeActivityLauncher;

/* compiled from: hub_id */
public class SecurityCheckupExpandableViewHolderProvider extends AbstractAssistedProvider<SecurityCheckupExpandableViewHolder> {
    public final SecurityCheckupExpandableViewHolder m10034a(View view, Context context) {
        return new SecurityCheckupExpandableViewHolder(view, context, new SecurityCheckupPasswordChangeActivityLauncher((Context) getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(this), IdBasedProvider.a(this, 12)), (SecurityCheckupInnerControllerProvider) getOnDemandAssistedProviderForStaticDi(SecurityCheckupInnerControllerProvider.class), SecurityCheckupLogger.m9901a((InjectorLike) this), SecurityCheckupState.m9932a(this));
    }
}
