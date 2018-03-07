package com.facebook.config.background.impl;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.config.background.BlueServiceOperationSyncComponent;
import com.facebook.config.background.ConfigurationComponent;
import com.facebook.config.background.STATICDI_MULTIBIND_PROVIDER$BlueServiceOperationSyncComponent;
import com.facebook.config.background.STATICDI_MULTIBIND_PROVIDER$ConfigurationComponent;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.http.protocol.BatchComponent;
import com.facebook.http.protocol.BatchComponentRunner;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.orca.background.FetchPinnedThreadsSyncComponent;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: rtc_multi_binary */
public class ConfigBackgroundServiceHandler implements BlueServiceHandler {
    public static final CallerContext f3228a = CallerContext.a(ConfigBackgroundServiceHandler.class);
    private final DefaultBlueServiceOperationFactory f3229b;
    private final BatchComponentRunner f3230c;
    private final Set<ConfigurationComponent> f3231d;
    private final Set<BlueServiceOperationSyncComponent> f3232e;
    private final FbSharedPreferences f3233f;
    private final Clock f3234g;
    private final ApiMethodRunnerParams f3235h;

    public static ConfigBackgroundServiceHandler m3442b(InjectorLike injectorLike) {
        return new ConfigBackgroundServiceHandler(DefaultBlueServiceOperationFactory.b(injectorLike), BatchComponentRunner.m1565a(injectorLike), STATICDI_MULTIBIND_PROVIDER$ConfigurationComponent.m3453a(injectorLike), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$BlueServiceOperationSyncComponent(injectorLike)), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ConfigBackgroundServiceHandler(BlueServiceOperationFactory blueServiceOperationFactory, BatchComponentRunner batchComponentRunner, Set<ConfigurationComponent> set, Set<BlueServiceOperationSyncComponent> set2, FbSharedPreferences fbSharedPreferences, Clock clock) {
        this.f3229b = blueServiceOperationFactory;
        this.f3230c = batchComponentRunner;
        this.f3231d = set;
        this.f3232e = set2;
        this.f3233f = fbSharedPreferences;
        this.f3234g = clock;
        this.f3235h = new ApiMethodRunnerParams();
        this.f3235h.i = false;
    }

    public final OperationResult m3444a(OperationParams operationParams) {
        String str = operationParams.b;
        if (str.equals("configuration")) {
            return m3443b(operationParams);
        }
        throw new IllegalArgumentException("Unhandled operation type: " + str);
    }

    private OperationResult m3443b(OperationParams operationParams) {
        boolean z = operationParams.c.getBoolean("forceFetch", false);
        List a = Lists.a();
        for (ConfigurationComponent configurationComponent : this.f3231d) {
            PrefKey prefKey = (PrefKey) ConfigPrefKeys.f13105c.a(configurationComponent.getClass().getName());
            if (m3440a(this.f3233f.a(prefKey, 0), configurationComponent.co_(), z)) {
                m3439a(prefKey);
                BatchComponent b = configurationComponent.mo101b();
                if (b != null) {
                    a.add(b);
                }
            }
        }
        this.f3235h.f = z ? RequestPriority.INTERACTIVE : RequestPriority.CAN_WAIT;
        this.f3230c.m1567a("handleFetchConfiguration", f3228a, a, this.f3235h);
        m3438a();
        return OperationResult.a;
    }

    private void m3438a() {
        for (FetchPinnedThreadsSyncComponent fetchPinnedThreadsSyncComponent : this.f3232e) {
            if (fetchPinnedThreadsSyncComponent != null && fetchPinnedThreadsSyncComponent.m10740d()) {
                PrefKey prefKey = (PrefKey) ConfigPrefKeys.f13106d.a(fetchPinnedThreadsSyncComponent.getClass().getName());
                if (m3440a(this.f3233f.a(prefKey, 0), 86400000, false)) {
                    BlueServiceOperationFactoryDetour.a(this.f3229b, "fetch_pinned_threads", fetchPinnedThreadsSyncComponent.m10739b(), ErrorPropagation.BY_ERROR_CODE, f3228a, 1165762406).a(true).a();
                    m3439a(prefKey);
                }
            }
        }
    }

    private boolean m3440a(long j, long j2, boolean z) {
        return z || j > this.f3234g.a() || this.f3234g.a() - j > j2;
    }

    private void m3439a(PrefKey prefKey) {
        this.f3233f.edit().a(prefKey, this.f3234g.a()).commit();
    }

    @VisibleForTesting
    private static CallerContext m3441b() {
        return f3228a;
    }
}
