package com.facebook.dialtone.switcher;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.dialtone.switcher.abtest.ExperimentsForDialtoneManualSwitcherModule;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.zero.common.constants.DialtonePrefKeys;
import com.facebook.zero.common.constants.FbZeroTokenType;
import com.facebook.zero.sdk.util.ZeroOptinInterstitialContentFetcher;
import javax.inject.Inject;

/* compiled from: size */
public class DialtoneManualSwitcherNuxActivity extends FbFragmentActivity implements AnalyticsActivity {
    @Inject
    AnalyticsLogger f4723p;
    @Inject
    FbSharedPreferences f4724q;
    @Inject
    @LocalBroadcast
    BaseFbBroadcastManager f4725r;
    @Inject
    SecureContextHelper f4726s;
    @Inject
    ZeroOptinInterstitialContentFetcher f4727t;
    @Inject
    QeAccessor f4728u;

    private static <T extends Context> void m8526a(Class<T> cls, T t) {
        m8527a((Object) t, (Context) t);
    }

    public static void m8527a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((DialtoneManualSwitcherNuxActivity) obj).m8523a(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), LocalFbBroadcastManager.m2946a(injectorLike), DefaultSecureContextHelper.m4636a(injectorLike), ZeroOptinInterstitialContentFetcher.b(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public final void mo790b(Bundle bundle) {
        super.mo790b(bundle);
        Class cls = DialtoneManualSwitcherNuxActivity.class;
        m8527a((Object) this, (Context) this);
        setContentView(2130903905);
        ((FbTextView) mo2563a(2131561016)).setText(getResources().getString(2131232604, new Object[]{"Facebook Flex"}));
        ((FbButton) mo2563a(2131561020)).setOnClickListener(new 1(this));
        if (this.f4728u.mo596a(ExperimentsForDialtoneManualSwitcherModule.b, false)) {
            m8531i();
        }
    }

    private void m8531i() {
        CharSequence a = this.f4724q.mo278a(DialtonePrefKeys.f2498u, "");
        if (StringUtil.m3589a(a)) {
            View findViewById = findViewById(2131561017);
            View findViewById2 = findViewById(2131561018);
            findViewById.setVisibility(0);
            findViewById2.setVisibility(8);
            this.f4727t.a(new 2(this, findViewById, findViewById2));
            this.f4727t.a(SizeUtil.m19194a(getResources()), "get_terms_and_conditions", "get_terms_and_conditions");
            return;
        }
        m8522a(Uri.parse(a));
    }

    private void m8522a(Uri uri) {
        FbTextView fbTextView = (FbTextView) mo2563a(2131561021);
        Resources resources = getResources();
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(resources);
        styledStringBuilder.a(resources.getString(2131232612));
        styledStringBuilder.a(" ");
        styledStringBuilder.a(new ForegroundColorSpan(resources.getColor(2131361916)), 33);
        styledStringBuilder.a(resources.getString(2131232613));
        styledStringBuilder.a();
        CharSequence b = styledStringBuilder.b();
        fbTextView.setText(b);
        fbTextView.setContentDescription(b);
        fbTextView.setOnClickListener(new 3(this, uri));
        fbTextView.setVisibility(0);
    }

    private void m8523a(AnalyticsLogger analyticsLogger, FbSharedPreferences fbSharedPreferences, BaseFbBroadcastManager baseFbBroadcastManager, SecureContextHelper secureContextHelper, ZeroOptinInterstitialContentFetcher zeroOptinInterstitialContentFetcher, QeAccessor qeAccessor) {
        this.f4723p = analyticsLogger;
        this.f4724q = fbSharedPreferences;
        this.f4725r = baseFbBroadcastManager;
        this.f4726s = secureContextHelper;
        this.f4727t = zeroOptinInterstitialContentFetcher;
        this.f4728u = qeAccessor;
    }

    private static Intent m8528b(Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.setFlags(335544320);
        return intent;
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1428383617);
        super.onResume();
        m8530b(this, "dialtone_switcher_nux_interstitial_impression");
        this.f4724q.edit().putBoolean(DialtonePrefKeys.f2503z, true).commit();
        Intent intent = new Intent("com.facebook.zero.ACTION_ZERO_UPDATE_STATUS");
        intent.putExtra("zero_status_to_update", "dialtone_nux_impression");
        this.f4725r.mo406a(intent);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -733270008, a);
    }

    public void onBackPressed() {
        m8530b(this, "dialtone_switcher_nux_interstitial_back_pressed");
        super.onBackPressed();
    }

    public final String am_() {
        return "dialtone_switcher_nux_interstitial";
    }

    public static void m8530b(DialtoneManualSwitcherNuxActivity dialtoneManualSwitcherNuxActivity, String str) {
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.f3099c = "dialtone";
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.m5090b("carrier_id", dialtoneManualSwitcherNuxActivity.f4724q.mo278a(FbZeroTokenType.NORMAL.getCarrierIdKey(), ""));
        dialtoneManualSwitcherNuxActivity.f4723p.mo526a(honeyClientEvent);
    }
}
