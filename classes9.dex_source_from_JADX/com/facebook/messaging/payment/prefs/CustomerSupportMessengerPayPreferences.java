package com.facebook.messaging.payment.prefs;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceCategory;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.prefs.PaymentsPreferenceActivity.C15621;
import com.facebook.widget.fbpreferencefragment.FbPreferenceFragment;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: group_visible_count */
public class CustomerSupportMessengerPayPreferences extends FbPreferenceFragment implements MessengerPayPreferences<Void> {
    @Inject
    public Context f13764a;
    @Inject
    public AnalyticsLogger f13765b;
    @Inject
    public SecureContextHelper f13766c;
    public C15621 f13767d;
    private PreferenceCategory f13768e;

    public static void m14334a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        CustomerSupportMessengerPayPreferences customerSupportMessengerPayPreferences = (CustomerSupportMessengerPayPreferences) obj;
        Context context2 = (Context) fbInjector.getInstance(Context.class);
        AnalyticsLogger a = AnalyticsLoggerMethodAutoProvider.a(fbInjector);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        customerSupportMessengerPayPreferences.f13764a = context2;
        customerSupportMessengerPayPreferences.f13765b = a;
        customerSupportMessengerPayPreferences.f13766c = secureContextHelper;
    }

    public final void mo539a(C15621 c15621) {
        this.f13767d = c15621;
    }

    public final void mo542c(Bundle bundle) {
        super.mo542c(bundle);
        Class cls = CustomerSupportMessengerPayPreferences.class;
        m14334a(this, getContext());
        this.f13768e = new PreferenceCategory(ao());
        this.f13768e.setLayoutResource(2130906356);
        this.f13768e.setTitle(2131240304);
        this.f13767d.m14374a(this.f13768e);
    }

    public final ListenableFuture<Void> mo541b() {
        this.f13768e.removeAll();
        this.f13768e.addPreference(m14335e());
        this.f13768e.addPreference(aq());
        return Futures.a(null);
    }

    public final void mo540a(boolean z) {
    }

    private Preference m14335e() {
        return m14333a(b(2131240305), "https://m.facebook.com/help/messenger-app/750020781733477", "p2p_settings_help_center_tap");
    }

    private Preference aq() {
        return m14333a(b(2131240306), "https://m.facebook.com/help/contact/614010102040957", "p2p_settings_contact_us_tap");
    }

    private Preference m14333a(String str, final String str2, final String str3) {
        final Preference preference = new Preference(this.f13764a);
        preference.setLayoutResource(2130906154);
        preference.setTitle(str);
        preference.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
            final /* synthetic */ CustomerSupportMessengerPayPreferences f13757d;

            public boolean onPreferenceClick(Preference preference) {
                this.f13757d.f13767d.m14373a(preference);
                this.f13757d.f13765b.a(P2pPaymentsLogEvent.c("p2p_settings", str3));
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str2));
                preference.setIntent(intent);
                this.f13757d.f13766c.b(intent, this.f13757d.f13764a);
                return true;
            }
        });
        return preference;
    }
}
