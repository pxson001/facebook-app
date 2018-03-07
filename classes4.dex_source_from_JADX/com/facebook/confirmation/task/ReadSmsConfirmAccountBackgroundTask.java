package com.facebook.confirmation.task;

import android.content.Intent;
import com.facebook.backgroundtasks.AbstractBackgroundTask;
import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.backgroundtasks.BackgroundTask.Prerequisite;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.confirmation.logging.ConfirmationAnalyticsLogger;
import com.facebook.confirmation.prefs.AccountConfirmationPrefKeys;
import com.facebook.confirmation.protocol.ConfirmContactpointMethod;
import com.facebook.confirmation.protocol.ConfirmContactpointMethod.Params;
import com.facebook.confirmation.protocol.ConfirmationSource;
import com.facebook.confirmation.task.BackgroundConfirmationHelper.ConfirmationMethod;
import com.facebook.confirmation.util.ReadSmsHelper;
import com.facebook.growth.model.Contactpoint;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;
import javax.inject.Inject;

/* compiled from: fb_extend_sso_token */
public class ReadSmsConfirmAccountBackgroundTask extends AbstractBackgroundTask {
    private static final Class<?> f12032a = ReadSmsConfirmAccountBackgroundTask.class;
    private static final Pattern f12033b = Pattern.compile("(^|\\D)(\\d{4,10})($|\\D)");
    private static final Set<String> f12034c = ImmutableSet.of("32665", "FACEBOOK", "919232232665", "1006", "3265", "3404", new String[]{"32664", "3223", "42665", "51555"});
    private final AppStateManager f12035d;
    private final FbSharedPreferences f12036e;
    private final Clock f12037f;
    private final BackgroundConfirmationHelper f12038g;
    private final ReadSmsHelper f12039h;
    private final RuntimePermissionsUtil f12040i;
    private final Lazy<FbBroadcastManager> f12041j;
    private final Lazy<SingleMethodRunner> f12042k;
    private final Lazy<ConfirmContactpointMethod> f12043l;
    private final Lazy<ConfirmationAnalyticsLogger> f12044m;

    public static ReadSmsConfirmAccountBackgroundTask m12714b(InjectorLike injectorLike) {
        return new ReadSmsConfirmAccountBackgroundTask(AppStateManager.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), BackgroundConfirmationHelper.m12689b(injectorLike), RuntimePermissionsUtil.b(injectorLike), IdBasedLazy.a(injectorLike, 401), IdBasedSingletonScopeProvider.b(injectorLike, 2289), IdBasedLazy.a(injectorLike, 5316), IdBasedLazy.a(injectorLike, 881), ReadSmsHelper.m12724b(injectorLike));
    }

    @Inject
    public ReadSmsConfirmAccountBackgroundTask(AppStateManager appStateManager, FbSharedPreferences fbSharedPreferences, Clock clock, BackgroundConfirmationHelper backgroundConfirmationHelper, RuntimePermissionsUtil runtimePermissionsUtil, Lazy<FbBroadcastManager> lazy, Lazy<SingleMethodRunner> lazy2, Lazy<ConfirmContactpointMethod> lazy3, Lazy<ConfirmationAnalyticsLogger> lazy4, ReadSmsHelper readSmsHelper) {
        super("READ_SMS_FOR_CONFIRMATION_CODE");
        this.f12035d = appStateManager;
        this.f12036e = fbSharedPreferences;
        this.f12037f = clock;
        this.f12038g = backgroundConfirmationHelper;
        this.f12040i = runtimePermissionsUtil;
        this.f12041j = lazy;
        this.f12042k = lazy2;
        this.f12043l = lazy3;
        this.f12044m = lazy4;
        this.f12039h = readSmsHelper;
    }

    public final boolean mo595i() {
        Map l = m12716l();
        List a = Lists.a();
        boolean z = false;
        for (Entry entry : l.entrySet()) {
            if (this.f12037f.a() - ((Long) entry.getValue()).longValue() <= 604800000) {
                z = true;
            } else {
                a.add(entry.getKey());
            }
        }
        if (!a.isEmpty()) {
            this.f12038g.m12695a(ConfirmationMethod.REGULAR_SMS_CONFIRMATION, (Contactpoint[]) a.toArray(new Contactpoint[0]));
        }
        return z;
    }

    public final Set<Prerequisite> mo594h() {
        return ImmutableSet.of(Prerequisite.NETWORK_CONNECTIVITY, Prerequisite.USER_LOGGED_IN);
    }

    public final long mo593f() {
        if (!mo595i()) {
            return -1;
        }
        return (((long) (this.f12035d.j() ? 20 : 5)) * 60000) + this.f12036e.a(AccountConfirmationPrefKeys.f13078a, 0);
    }

    public final ListenableFuture<BackgroundResult> mo596j() {
        boolean a = this.f12040i.a("android.permission.READ_SMS");
        ((ConfirmationAnalyticsLogger) this.f12044m.get()).m12710a(a);
        if (a) {
            m12715k();
        }
        return Futures.a(new BackgroundResult(true));
    }

    private void m12715k() {
        Map l = m12716l();
        if (!l.isEmpty()) {
            List a = this.f12039h.m12725a(this.f12036e.a(AccountConfirmationPrefKeys.f13078a, 0), 259200000);
            ((ConfirmationAnalyticsLogger) this.f12044m.get()).m12706a(a.size());
            List a2 = this.f12039h.m12726a(a, f12034c, f12033b, 2);
            this.f12036e.edit().a(AccountConfirmationPrefKeys.f13078a, this.f12037f.a()).commit();
            m12712a(l.keySet(), a2);
        }
    }

    private Map<Contactpoint, Long> m12716l() {
        return this.f12038g.m12692a(ConfirmationMethod.REGULAR_SMS_CONFIRMATION);
    }

    private void m12712a(Set<Contactpoint> set, List<SmsCode> list) {
        if (!list.isEmpty() && !set.isEmpty()) {
            ((ConfirmationAnalyticsLogger) this.f12044m.get()).m12707a(set.size(), list.size());
            for (Contactpoint contactpoint : set) {
                for (SmsCode a : list) {
                    if (m12713a(contactpoint, a)) {
                        this.f12038g.m12695a(ConfirmationMethod.REGULAR_SMS_CONFIRMATION, (Contactpoint[]) set.toArray(new Contactpoint[0]));
                        ((BaseFbBroadcastManager) this.f12041j.get()).a(new Intent("action_background_contactpoint_confirmed").putExtra("extra_background_confirmed_contactpoint", contactpoint));
                        return;
                    }
                }
            }
        }
    }

    private boolean m12713a(Contactpoint contactpoint, SmsCode smsCode) {
        try {
            boolean booleanValue = ((Boolean) ((AbstractSingleMethodRunner) this.f12042k.get()).a((ApiMethod) this.f12043l.get(), new Params(contactpoint, smsCode.a, ConfirmationSource.ANDROID_AUTO_SMS_API))).booleanValue();
            ((ConfirmationAnalyticsLogger) this.f12044m.get()).m12711a(booleanValue, String.valueOf(smsCode.b));
            return booleanValue;
        } catch (Exception e) {
            ((ConfirmationAnalyticsLogger) this.f12044m.get()).m12711a(false, String.valueOf(smsCode.b));
            return false;
        } catch (Throwable th) {
            Throwable th2 = th;
            ((ConfirmationAnalyticsLogger) this.f12044m.get()).m12711a(false, String.valueOf(smsCode.b));
        }
    }
}
