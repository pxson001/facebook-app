package com.facebook.appirater;

import android.text.TextUtils;
import com.facebook.appirater.api.AppRaterReport;
import com.facebook.appirater.api.FetchISRConfigResult;
import com.facebook.appirater.ratingdialog.RatingDialogSaveState;
import com.facebook.debug.log.BLog;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Inject;

/* compiled from: multi-output-resolved */
public class InternalStarRatingPreferences {
    private static final Class<?> f7407a = InternalStarRatingPreferences.class;
    public final FbSharedPreferences f7408b;
    private final ObjectMapper f7409c;

    @Inject
    public InternalStarRatingPreferences(FbSharedPreferences fbSharedPreferences, ObjectMapper objectMapper) {
        this.f7408b = fbSharedPreferences;
        this.f7409c = objectMapper;
    }

    private void m7708a(PrefKey prefKey, Object obj) {
        String str = "";
        if (obj != null) {
            try {
                str = this.f7409c.a(obj);
            } catch (Throwable e) {
                BLog.b(f7407a, e, "Error writing %s to shared prefs", new Object[]{prefKey});
            }
        }
        this.f7408b.edit().a(prefKey, str).commit();
    }

    private <T> T m7707a(PrefKey prefKey, Class<T> cls) {
        T t = null;
        Object a = this.f7408b.a(prefKey, t);
        if (!TextUtils.isEmpty(a)) {
            try {
                t = this.f7409c.a(a, cls);
            } catch (Throwable e) {
                BLog.b(f7407a, e, "Error reading %s from shared prefs", new Object[]{prefKey});
            }
        }
        return t;
    }

    public final void m7711a(FetchISRConfigResult fetchISRConfigResult) {
        m7708a(InternalStarRatingPrefKeys.b, (Object) fetchISRConfigResult);
    }

    public final FetchISRConfigResult m7709a() {
        FetchISRConfigResult fetchISRConfigResult = (FetchISRConfigResult) m7707a(InternalStarRatingPrefKeys.b, FetchISRConfigResult.class);
        return (fetchISRConfigResult == null || !fetchISRConfigResult.a()) ? null : fetchISRConfigResult;
    }

    public final void m7710a(AppRaterReport appRaterReport) {
        m7708a(InternalStarRatingPrefKeys.c, (Object) appRaterReport);
    }

    public final AppRaterReport m7713b() {
        AppRaterReport appRaterReport = (AppRaterReport) m7707a(InternalStarRatingPrefKeys.c, AppRaterReport.class);
        return (appRaterReport == null || !appRaterReport.a()) ? null : appRaterReport;
    }

    public final void m7712a(RatingDialogSaveState ratingDialogSaveState) {
        m7708a(InternalStarRatingPrefKeys.f, (Object) ratingDialogSaveState);
    }

    public final RatingDialogSaveState m7714c() {
        return (RatingDialogSaveState) m7707a(InternalStarRatingPrefKeys.f, RatingDialogSaveState.class);
    }

    public final boolean m7715d() {
        return this.f7408b.a(InternalStarRatingPrefKeys.e, false);
    }

    public final boolean m7716e() {
        return this.f7408b.a(InternalStarRatingPrefKeys.d, false);
    }
}
