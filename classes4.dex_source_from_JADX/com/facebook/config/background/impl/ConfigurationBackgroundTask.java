package com.facebook.config.background.impl;

import android.os.Bundle;
import com.facebook.backgroundtasks.AbstractBackgroundTask;
import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.backgroundtasks.BackgroundTask.Prerequisite;
import com.facebook.backgroundtasks.SimpleBackgroundResultFutureCallback;
import com.facebook.common.time.Clock;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.EnumSet;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: rtc_neteq4_tune_experiment */
public class ConfigurationBackgroundTask extends AbstractBackgroundTask {
    private static final Class<?> f12005a = ConfigurationBackgroundTask.class;
    public final FbSharedPreferences f12006b;
    private final DefaultBlueServiceOperationFactory f12007c;
    public final Clock f12008d;

    /* compiled from: rtc_neteq4_tune_experiment */
    class C01481 extends OperationResultFutureCallback {
        final /* synthetic */ ConfigurationBackgroundTask f3227a;

        C01481(ConfigurationBackgroundTask configurationBackgroundTask) {
            this.f3227a = configurationBackgroundTask;
        }

        protected final void m3437a(Object obj) {
            this.f3227a.f12006b.edit().a(ConfigPrefKeys.f13104b, this.f3227a.f12008d.a()).commit();
        }

        protected final void mo148a(ServiceException serviceException) {
        }
    }

    @Inject
    public ConfigurationBackgroundTask(FbSharedPreferences fbSharedPreferences, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, Clock clock) {
        super("CONFIGURATION");
        this.f12006b = fbSharedPreferences;
        this.f12007c = defaultBlueServiceOperationFactory;
        this.f12008d = clock;
    }

    public final boolean mo595i() {
        long a = this.f12008d.a();
        long a2 = this.f12006b.a(ConfigPrefKeys.f13103a, 0);
        if (a < a2) {
            return true;
        }
        if (a - a2 < 900000) {
            return false;
        }
        a2 = this.f12006b.a(ConfigPrefKeys.f13104b, 0);
        if (a < a2 || a - a2 >= 7200000) {
            return true;
        }
        return false;
    }

    public final Set<Prerequisite> mo594h() {
        return EnumSet.of(Prerequisite.USER_LOGGED_IN, Prerequisite.NETWORK_CONNECTIVITY);
    }

    public final ListenableFuture<BackgroundResult> mo596j() {
        this.f12006b.edit().a(ConfigPrefKeys.f13103a, this.f12008d.a()).commit();
        Bundle bundle = new Bundle();
        bundle.putBoolean("forceFetch", false);
        OperationFuture a = BlueServiceOperationFactoryDetour.a(this.f12007c, "configuration", bundle, -1871077367).a();
        Futures.a(a, new C01481(this));
        SimpleBackgroundResultFutureCallback simpleBackgroundResultFutureCallback = new SimpleBackgroundResultFutureCallback(f12005a);
        Futures.a(a, simpleBackgroundResultFutureCallback);
        return simpleBackgroundResultFutureCallback;
    }
}
