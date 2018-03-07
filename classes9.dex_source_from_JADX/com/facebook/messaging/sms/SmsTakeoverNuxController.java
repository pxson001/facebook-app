package com.facebook.messaging.sms;

import android.content.Context;
import android.telephony.SubscriptionManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.sms.abtest.ExperimentsForSmsTakeoverAbTestModule;
import com.facebook.messaging.sms.abtest.SmsGatekeepers;
import com.facebook.messaging.sms.abtest.SmsIntegrationState;
import com.facebook.messaging.sms.abtest.SmsOptinFlow;
import com.facebook.messaging.sms.abtest.SmsTakeoverMultiverseExperimentHelper;
import com.facebook.messaging.sms.analytics.SmsTakeoverAnalyticsLogger;
import com.facebook.messaging.sms.defaultapp.SmsPermissionsUtil;
import com.facebook.messaging.sms.prefs.SmsPrefKeys;
import com.facebook.messaging.sms.util.TelephonyUtils;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import javax.inject.Inject;

/* compiled from: compatible_with */
public class SmsTakeoverNuxController {
    public final Context f17488a;
    public final FbSharedPreferences f17489b;
    public final SmsIntegrationState f17490c;
    public final SmsGatekeepers f17491d;
    public final SmsTakeoverMultiverseExperimentHelper f17492e;
    public final SmsTakeoverAnalyticsLogger f17493f;
    public final SmsPermissionsUtil f17494g;
    private final Clock f17495h;

    /* compiled from: compatible_with */
    public enum NuxCallerContext {
        NONE,
        NUX_FULL_FLOW,
        THREAD_LIST_INTERSTITIAL,
        THREAD_VIEW_BANNER,
        PEOPLE_TAB_PROMO,
        ANONYMOUS_CHATHEAD,
        SMS_LOG_UPSELL,
        CALL_LOG_UPSELL,
        PERMANENT_CONTACT_CLICKED_SEARCH,
        PERMANENT_CONTACT_CLICKED_NULL_STATE,
        PERMANENT_CONTACT_CLICKED_PEOPLE_TAB
    }

    public static SmsTakeoverNuxController m17468b(InjectorLike injectorLike) {
        return new SmsTakeoverNuxController((Context) injectorLike.getInstance(Context.class), SmsIntegrationState.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), SmsGatekeepers.b(injectorLike), SmsTakeoverMultiverseExperimentHelper.b(injectorLike), SmsTakeoverAnalyticsLogger.b(injectorLike), SmsPermissionsUtil.m17591a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SmsTakeoverNuxController(Context context, SmsIntegrationState smsIntegrationState, FbSharedPreferences fbSharedPreferences, SmsGatekeepers smsGatekeepers, SmsTakeoverMultiverseExperimentHelper smsTakeoverMultiverseExperimentHelper, SmsTakeoverAnalyticsLogger smsTakeoverAnalyticsLogger, SmsPermissionsUtil smsPermissionsUtil, Clock clock) {
        this.f17488a = context;
        this.f17489b = fbSharedPreferences;
        this.f17490c = smsIntegrationState;
        this.f17491d = smsGatekeepers;
        this.f17492e = smsTakeoverMultiverseExperimentHelper;
        this.f17493f = smsTakeoverAnalyticsLogger;
        this.f17494g = smsPermissionsUtil;
        this.f17495h = clock;
    }

    private boolean m17469b() {
        if (this.f17489b.a(SmsPrefKeys.C, false)) {
            return this.f17492e.b();
        }
        if (!this.f17492e.a.a(ExperimentsForSmsTakeoverAbTestModule.I, false) || !this.f17490c.b() || this.f17490c.d() || this.f17489b.a(SmsPrefKeys.x, false)) {
            return false;
        }
        if (this.f17489b.a(SmsPrefKeys.B, false)) {
            return true;
        }
        if (Math.abs(this.f17495h.a() - Math.max(this.f17489b.a(SmsPrefKeys.u, 0), this.f17489b.a(SmsPrefKeys.v, 0))) <= 259200000) {
            return false;
        }
        return true;
    }

    public final boolean m17470a() {
        SmsOptinFlow smsOptinFlow;
        if (this.f17492e.a.a(ExperimentsForSmsTakeoverAbTestModule.r, false)) {
            smsOptinFlow = SmsOptinFlow.OPTIN_READ_ONLY_OR_FULL_MODE;
        } else {
            smsOptinFlow = SmsOptinFlow.NO_OPTIN;
        }
        SmsOptinFlow smsOptinFlow2 = smsOptinFlow;
        boolean z = false;
        if (this.f17489b.a(SmsPrefKeys.C, false)) {
            z = this.f17492e.b();
        } else if (this.f17492e.e()) {
            boolean b = this.f17494g.m17594b();
            if (!this.f17489b.a(SmsPrefKeys.y)) {
                int i;
                int i2;
                boolean a = TelephonyUtils.m17717a();
                boolean a2 = this.f17494g.f17616c.a("android.permission.READ_PHONE_STATE");
                if (a && a2) {
                    int activeSubscriptionInfoCount;
                    Context context = this.f17488a;
                    if (TelephonyUtils.m17717a()) {
                        activeSubscriptionInfoCount = SubscriptionManager.from(context).getActiveSubscriptionInfoCount();
                    } else {
                        activeSubscriptionInfoCount = 0;
                    }
                    i = activeSubscriptionInfoCount;
                    context = this.f17488a;
                    if (TelephonyUtils.m17717a()) {
                        activeSubscriptionInfoCount = SubscriptionManager.from(context).getActiveSubscriptionInfoCountMax();
                    } else {
                        activeSubscriptionInfoCount = 0;
                    }
                    i2 = activeSubscriptionInfoCount;
                } else {
                    i2 = 0;
                    i = 0;
                }
                this.f17493f.a(b, a2, a, i, i2);
                this.f17489b.edit().putBoolean(SmsPrefKeys.y, true).commit();
            }
            if (!(this.f17490c.a() || smsOptinFlow2 == SmsOptinFlow.NO_OPTIN)) {
                Object obj = 1;
                if (!this.f17491d.d()) {
                    if (!this.f17491d.e()) {
                        obj = null;
                    } else if (smsOptinFlow2 == SmsOptinFlow.OPTIN_FULL_MODE) {
                        obj = null;
                    }
                }
                if (obj == null && !this.f17492e.c()) {
                    z = true;
                }
            }
        }
        return z || m17469b();
    }
}
