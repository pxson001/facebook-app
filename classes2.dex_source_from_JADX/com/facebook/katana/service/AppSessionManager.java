package com.facebook.katana.service;

import android.content.Context;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.service.AppSession.LoginStatus;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.toaster.Toaster;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: short_term_cache_key_pyml */
class AppSessionManager {
    private AppSession f4964a;
    private boolean f4965b = true;

    AppSessionManager() {
    }

    final boolean m8872a(Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        if (!BuildConstants.i || !this.f4964a.m8868c() || GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike).m2185a(18) != TriState.NO) {
            return true;
        }
        if (this.f4965b) {
            this.f4965b = false;
            Toaster.m6452a(context.getApplicationContext(), (CharSequence) "This beta build is only enabled for employees and authorized users.");
        }
        return false;
    }

    final synchronized AppSession m8873b(Context context) {
        if (this.f4964a == null) {
            LoggedInUserSessionManager a = LoggedInUserSessionManager.m2511a(FbInjector.get(context));
            this.f4964a = new AppSession(context);
            if (a.m2522b()) {
                TracerDetour.a("AppSession.doLogin", 1400198972);
                try {
                    int i = this.f4964a;
                    i.m8867c(context, false);
                    TracerDetour.a(i);
                } finally {
                    TracerDetour.a(48814808);
                }
            }
        }
        return this.f4964a;
    }

    @Nullable
    final synchronized AppSession m8871a(Context context, boolean z) {
        AppSession b;
        b = m8873b(context.getApplicationContext());
        if (b.m8869d() == LoginStatus.STATUS_LOGGED_OUT || (z && !m8872a(context))) {
            b = null;
        }
        return b;
    }
}
