package com.facebook.languages.switcher.prefs;

import android.content.Context;
import android.os.Bundle;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.locale.Locales;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.languages.switcher.LanguageSwitcherList;
import com.facebook.languages.switcher.LanguageSwitcherListHelper;
import com.facebook.languages.switcher.logging.LanguageSwitcherEventType;
import com.facebook.languages.switcher.logging.LanguageSwitcherLogger;
import com.facebook.languages.switchercommonex.LanguageSwitcherCommonExPrefKeys;
import com.facebook.widget.prefs.OrcaListPreferenceWithSummaryValue;
import javax.inject.Inject;

/* compiled from: time_threshold_to_restart_geofence_exceeded */
public class LanguagePreference extends OrcaListPreferenceWithSummaryValue {
    private final LanguageSwitcherLogger f1420b;
    public final LanguageSwitcherListHelper f1421c;

    private static LanguagePreference m1419b(InjectorLike injectorLike) {
        return new LanguagePreference((Context) injectorLike.getInstance(Context.class), LanguageSwitcherLogger.m1415b(injectorLike), LanguageSwitcherListHelper.b(injectorLike));
    }

    @Inject
    public LanguagePreference(Context context, LanguageSwitcherLogger languageSwitcherLogger, LanguageSwitcherListHelper languageSwitcherListHelper) {
        super(context);
        this.f1420b = languageSwitcherLogger;
        this.f1421c = languageSwitcherListHelper;
        setKey(LanguageSwitcherCommonExPrefKeys.b.a());
        LanguageSwitcherList b = this.f1421c.b();
        setEntries(b.b());
        setEntryValues(b.a());
        setDefaultValue("device");
        setTitle(2131240202);
    }

    protected void showDialog(Bundle bundle) {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        LanguageSwitcherLogger languageSwitcherLogger = this.f1420b;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(LanguageSwitcherEventType.VISIT.getAnalyticsName());
        honeyClientEvent.c = "language_switcher";
        languageSwitcherLogger.f1418a.c(honeyClientEvent.b("current_app_locale", locale).b("system_locale", Locales.e().toString()));
        super.showDialog(bundle);
    }

    protected boolean callChangeListener(Object obj) {
        String persistedString = getPersistedString("device");
        String str = (String) obj;
        if (!(StringUtil.a(str) || str.equals(persistedString))) {
            this.f1420b.m1417a(persistedString, str);
        }
        return super.callChangeListener(obj);
    }
}
