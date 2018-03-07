package com.facebook.zero.ui;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.ViewStub;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;
import com.facebook.zero.common.constants.ZeroPrefKeys;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.facebook.zero.sdk.request.ZeroIndicatorData;
import com.facebook.zero.sdk.ui.ZeroIndicator;
import com.facebook.zero.service.FbZeroIndicatorManager;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: small_picture_size */
public class ZeroIndicatorController {
    private static final Class<?> f4600a = ZeroIndicatorController.class;
    private final Context f4601b;
    private final FbZeroIndicatorManager f4602c;
    private final FbZeroFeatureVisibilityHelper f4603d;
    private final C02311 f4604e = new C02311(this);
    private final FbSharedPreferences f4605f;
    private final SecureContextHelper f4606g;
    private final BaseFbBroadcastManager f4607h;
    private final SelfRegistrableReceiverImpl f4608i = this.f4607h.m2951a().mo506a("com.facebook.zero.ZERO_RATING_INDICATOR_DATA_CHANGED", new C02323(this)).mo506a("com.facebook.zero.ZERO_RATING_STATE_CHANGED", new C02332(this)).mo503a();
    private final AnalyticsLogger f4609j;
    private final Provider<Boolean> f4610k;
    private final String f4611l = SafeUUIDGenerator.m2795a().toString();
    private ViewStub f4612m;
    public ZeroIndicator f4613n;
    @Nullable
    public Listener f4614o;
    public ZeroFeatureKey f4615p;

    /* compiled from: small_picture_size */
    public class C02311 {
        public final /* synthetic */ ZeroIndicatorController f4628a;

        C02311(ZeroIndicatorController zeroIndicatorController) {
            this.f4628a = zeroIndicatorController;
        }
    }

    /* compiled from: small_picture_size */
    class C02323 implements ActionReceiver {
        final /* synthetic */ ZeroIndicatorController f4629a;

        C02323(ZeroIndicatorController zeroIndicatorController) {
            this.f4629a = zeroIndicatorController;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1813443745);
            this.f4629a.m8370c();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1155424521, a);
        }
    }

    /* compiled from: small_picture_size */
    class C02332 implements ActionReceiver {
        final /* synthetic */ ZeroIndicatorController f4630a;

        C02332(ZeroIndicatorController zeroIndicatorController) {
            this.f4630a = zeroIndicatorController;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1040079751);
            this.f4630a.m8370c();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -57668897, a);
        }
    }

    /* compiled from: small_picture_size */
    public interface Listener {
        void mo1258a();

        void mo1259b();
    }

    public static ZeroIndicatorController m8360b(InjectorLike injectorLike) {
        return new ZeroIndicatorController((Context) injectorLike.getInstance(Context.class), FbZeroIndicatorManager.m8371a(injectorLike), FbZeroFeatureVisibilityHelper.m7916a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), DefaultSecureContextHelper.m4636a(injectorLike), LocalFbBroadcastManager.m2946a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4034));
    }

    public static ZeroIndicatorController m8358a(InjectorLike injectorLike) {
        return m8360b(injectorLike);
    }

    @Inject
    public ZeroIndicatorController(Context context, FbZeroIndicatorManager fbZeroIndicatorManager, FbZeroFeatureVisibilityHelper fbZeroFeatureVisibilityHelper, FbSharedPreferences fbSharedPreferences, SecureContextHelper secureContextHelper, FbBroadcastManager fbBroadcastManager, AnalyticsLogger analyticsLogger, Provider<Boolean> provider) {
        this.f4601b = context;
        this.f4602c = fbZeroIndicatorManager;
        this.f4603d = fbZeroFeatureVisibilityHelper;
        this.f4605f = fbSharedPreferences;
        this.f4606g = secureContextHelper;
        this.f4607h = fbBroadcastManager;
        this.f4609j = analyticsLogger;
        this.f4610k = provider;
    }

    public final void m8368a() {
        this.f4608i.m3296b();
        m8370c();
    }

    public final void m8369b() {
        this.f4608i.m3297c();
    }

    public final ZeroIndicatorController m8364a(ViewStub viewStub) {
        this.f4612m = viewStub;
        return this;
    }

    public final ZeroIndicatorController m8366a(ZeroIndicator zeroIndicator) {
        this.f4613n = zeroIndicator;
        return this;
    }

    public final ZeroIndicatorController m8367a(@Nullable Listener listener) {
        this.f4614o = listener;
        return this;
    }

    public final ZeroIndicatorController m8365a(ZeroFeatureKey zeroFeatureKey) {
        this.f4615p = zeroFeatureKey;
        return this;
    }

    public final void m8370c() {
        if (((Boolean) this.f4610k.get()).booleanValue()) {
            m8361d();
        } else {
            m8362e();
        }
    }

    private void m8361d() {
        if (this.f4603d.m7924a(this.f4615p)) {
            ZeroIndicatorData c = this.f4602c.m8377c();
            if (c == null) {
                m8362e();
                return;
            } else if (this.f4613n == null && this.f4612m == null) {
                BLog.b(f4600a, "We don't have a stub when we need to display banner");
                return;
            } else {
                if (this.f4613n == null) {
                    this.f4613n = (ZeroIndicator) this.f4612m.inflate();
                    this.f4613n.setListener(this.f4604e);
                } else {
                    this.f4613n.mo1253a();
                }
                this.f4613n.setIndicatorData(c);
                AnalyticsLogger analyticsLogger = this.f4609j;
                HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("view");
                honeyClientEvent.f3102f = this.f4611l;
                honeyClientEvent = honeyClientEvent;
                honeyClientEvent.f3099c = "zero_indicator";
                honeyClientEvent = honeyClientEvent;
                honeyClientEvent.f3101e = "zero_indicator_show";
                analyticsLogger.mo526a(honeyClientEvent);
                if (this.f4614o != null) {
                    this.f4614o.mo1258a();
                    return;
                }
                return;
            }
        }
        m8362e();
    }

    private void m8362e() {
        if (this.f4613n != null && this.f4613n.mo1255c()) {
            this.f4613n.mo1254b();
            if (this.f4614o != null) {
                this.f4614o.mo1259b();
            }
        }
    }

    public static void m8363f(ZeroIndicatorController zeroIndicatorController) {
        zeroIndicatorController.m8362e();
        AnalyticsLogger analyticsLogger = zeroIndicatorController.f4609j;
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("dismiss");
        honeyClientEvent.f3102f = zeroIndicatorController.f4611l;
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.f3099c = "zero_indicator";
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.f3101e = "zero_indicator_close";
        analyticsLogger.mo526a(honeyClientEvent);
        zeroIndicatorController.f4605f.edit().putBoolean(ZeroPrefKeys.m4712a(ZeroFeatureKey.ZERO_INDICATOR), false).commit();
    }

    public static void m8359a(ZeroIndicatorController zeroIndicatorController, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        zeroIndicatorController.f4609j.mo526a(new HoneyClientEvent("click").m5099k(zeroIndicatorController.f4611l).m5094g("zero_indicator").m5096i("zero_indicator_goto"));
        try {
            zeroIndicatorController.f4606g.mo665b(intent, zeroIndicatorController.f4601b);
        } catch (ActivityNotFoundException e) {
            BLog.b(f4600a, "Activity not found for opening url: [%s]", new Object[]{str});
        }
    }
}
