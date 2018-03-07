package com.facebook.languages.switcher.task;

import com.facebook.conditionalworker.ConditionalWorker;
import com.facebook.conditionalworker.ConditionalWorkerRunner;
import com.facebook.debug.log.BLog;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.languages.switcher.service.GetUserLocaleMethod;
import com.facebook.languages.switchercommonex.LanguageSwitcherCommonExPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import javax.inject.Inject;

/* compiled from: tile_menu */
public class AutoSyncLoggedInUserLocaleConditionalWorker implements ConditionalWorker {
    private static final Class<?> f1426a = AutoSyncLoggedInUserLocaleConditionalWorker.class;
    private final FbSharedPreferences f1427b;
    private final AbstractSingleMethodRunner f1428c;
    private final GetUserLocaleMethod f1429d;

    @Inject
    public AutoSyncLoggedInUserLocaleConditionalWorker(FbSharedPreferences fbSharedPreferences, AbstractSingleMethodRunner abstractSingleMethodRunner, GetUserLocaleMethod getUserLocaleMethod) {
        this.f1427b = fbSharedPreferences;
        this.f1428c = abstractSingleMethodRunner;
        this.f1429d = getUserLocaleMethod;
    }

    public final boolean m1426a(ConditionalWorkerRunner conditionalWorkerRunner) {
        try {
            String str = (String) this.f1428c.a(this.f1429d, "me");
            String a = this.f1427b.a(LanguageSwitcherCommonExPrefKeys.a, null);
            if (!(str == null || str.equals(a))) {
                this.f1427b.edit().a(LanguageSwitcherCommonExPrefKeys.a, str).commit();
            }
            return true;
        } catch (Throwable e) {
            BLog.b(f1426a, "Error with Auto Sync Locale", e);
            return false;
        }
    }
}
