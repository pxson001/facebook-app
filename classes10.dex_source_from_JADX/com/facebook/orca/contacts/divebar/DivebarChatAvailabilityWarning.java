package com.facebook.orca.contacts.divebar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.orca.common.ui.widgets.SlidingOutSuggestionViewBase;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.presence.PayForPlayPresence;
import com.facebook.push.prefs.PushPrefKeys;
import com.facebook.widget.animatablelistview.AnimatingItemView;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: one_page */
public class DivebarChatAvailabilityWarning extends SlidingOutSuggestionViewBase {
    @Inject
    FbSharedPreferences f5798a;
    @Inject
    Provider<PayForPlayPresence> f5799b;
    @Inject
    AnalyticsLogger f5800c;
    private final Button f5801d;

    /* compiled from: one_page */
    class C08421 implements OnClickListener {
        final /* synthetic */ DivebarChatAvailabilityWarning f5797a;

        C08421(DivebarChatAvailabilityWarning divebarChatAvailabilityWarning) {
            this.f5797a = divebarChatAvailabilityWarning;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -195173530);
            DivebarChatAvailabilityWarning.m5486g(this.f5797a);
            Logger.a(2, EntryType.UI_INPUT_END, -904783291, a);
        }
    }

    private static <T extends View> void m5484a(Class<T> cls, T t) {
        m5485a((Object) t, t.getContext());
    }

    private static void m5485a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((DivebarChatAvailabilityWarning) obj).m5483a((FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), IdBasedProvider.a(fbInjector, 3089), AnalyticsLoggerMethodAutoProvider.a(fbInjector));
    }

    public DivebarChatAvailabilityWarning(Context context) {
        this(context, null, 0);
    }

    public DivebarChatAvailabilityWarning(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DivebarChatAvailabilityWarning(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5484a(DivebarChatAvailabilityWarning.class, (View) this);
        setContentView(2130905683);
        this.f5320a = (AnimatingItemView) c(2131564831);
        this.f5801d = (Button) c(2131564832);
        this.f5801d.setOnClickListener(new C08421(this));
        mo217f();
    }

    public static void m5486g(DivebarChatAvailabilityWarning divebarChatAvailabilityWarning) {
        divebarChatAvailabilityWarning.m4722e();
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("click");
        honeyClientEvent.d = "button";
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.e = "divebar_availability_warning_turn_on";
        divebarChatAvailabilityWarning.f5800c.a(honeyClientEvent);
        honeyClientEvent = new HoneyClientEvent("chat_bar_online_status_change");
        honeyClientEvent.c = "chat_bar";
        divebarChatAvailabilityWarning.f5800c.c(honeyClientEvent.a("state", true).b("source", "divebar_warning"));
        divebarChatAvailabilityWarning.f5798a.edit().putBoolean(PushPrefKeys.a, true).commit();
    }

    final void mo217f() {
        if (((PayForPlayPresence) this.f5799b.get()) == PayForPlayPresence.DISABLED) {
            m4720a();
        } else {
            m4721b();
        }
    }

    private void m5483a(FbSharedPreferences fbSharedPreferences, Provider<PayForPlayPresence> provider, AnalyticsLogger analyticsLogger) {
        this.f5798a = fbSharedPreferences;
        this.f5799b = provider;
        this.f5800c = analyticsLogger;
    }
}
