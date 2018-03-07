package com.facebook.rapidfeedback.debug;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import com.facebook.base.activity.FbPreferenceActivity;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.rapidfeedback.RapidFeedbackController;
import com.facebook.structuredsurvey.StructuredSurveyController;
import com.facebook.widget.prefs.OrcaCheckBoxPreference;
import com.facebook.widget.prefs.OrcaEditTextPreference;
import java.util.List;
import javax.inject.Inject;

/* compiled from: fail_count */
public class RapidFeedbackPreferencesActivity extends FbPreferenceActivity {
    @Inject
    RapidFeedbackController f15403a;
    @Inject
    SecureContextHelper f15404b;

    /* compiled from: fail_count */
    class C10911 implements OnPreferenceChangeListener {
        final /* synthetic */ RapidFeedbackPreferencesActivity f15401a;

        C10911(RapidFeedbackPreferencesActivity rapidFeedbackPreferencesActivity) {
            this.f15401a = rapidFeedbackPreferencesActivity;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            return RapidFeedbackPreferencesActivity.m23021b(this.f15401a, "args_integration_point_id", (String) obj);
        }
    }

    /* compiled from: fail_count */
    class C10922 implements OnPreferenceChangeListener {
        final /* synthetic */ RapidFeedbackPreferencesActivity f15402a;

        C10922(RapidFeedbackPreferencesActivity rapidFeedbackPreferencesActivity) {
            this.f15402a = rapidFeedbackPreferencesActivity;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            return RapidFeedbackPreferencesActivity.m23021b(this.f15402a, "args_survey_id", (String) obj);
        }
    }

    private static <T extends Context> void m23017a(Class<T> cls, T t) {
        m23018a((Object) t, (Context) t);
    }

    public static void m23018a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((RapidFeedbackPreferencesActivity) obj).m23016a(RapidFeedbackController.b(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector));
    }

    private void m23016a(RapidFeedbackController rapidFeedbackController, SecureContextHelper secureContextHelper) {
        this.f15403a = rapidFeedbackController;
        this.f15404b = secureContextHelper;
    }

    protected final void m23025c(Bundle bundle) {
        super.c(bundle);
        Class cls = RapidFeedbackPreferencesActivity.class;
        m23018a((Object) this, (Context) this);
        setTitle("Rapid Feedback Settings");
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1169839187);
        super.onResume();
        PreferenceScreen createPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
        setPreferenceScreen(createPreferenceScreen);
        Preference preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("TEST / DEBUG");
        createPreferenceScreen.addPreference(preferenceCategory);
        createPreferenceScreen.addPreference(m23024e());
        createPreferenceScreen.addPreference(m23023d());
        preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("DON'T SEE A SURVEY?");
        createPreferenceScreen.addPreference(preferenceCategory);
        createPreferenceScreen.addPreference(m23013a());
        createPreferenceScreen.addPreference(m23020b());
        m23015a(createPreferenceScreen, "RECENT SURVEY IDS", StructuredSurveyController.b, "args_survey_id");
        m23015a(createPreferenceScreen, "RECENT INTEGRATION POINT IDS", StructuredSurveyController.c, "args_integration_point_id");
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1344761669, a);
    }

    private Preference m23013a() {
        OrcaCheckBoxPreference orcaCheckBoxPreference = new OrcaCheckBoxPreference(this);
        orcaCheckBoxPreference.a(StructuredSurveyController.a);
        orcaCheckBoxPreference.setTitle("Developer Mode");
        orcaCheckBoxPreference.setSummary("Disables timeout between surveys");
        orcaCheckBoxPreference.setDefaultValue(Boolean.valueOf(false));
        return orcaCheckBoxPreference;
    }

    private Preference m23020b() {
        Preference preference = new Preference(this);
        preference.setSummary("Still don't see a survey? Are you whitelisted in your Tessa config?");
        return preference;
    }

    private Preference m23023d() {
        OrcaEditTextPreference orcaEditTextPreference = new OrcaEditTextPreference(this);
        orcaEditTextPreference.getEditText().setInputType(2);
        orcaEditTextPreference.setTitle("With Integration Point ID");
        orcaEditTextPreference.setSummary("Display a survey from Intern/Tessa");
        orcaEditTextPreference.getEditText().setSelectAllOnFocus(true);
        orcaEditTextPreference.getEditText().setHint("Integration Point ID");
        orcaEditTextPreference.setOnPreferenceChangeListener(new C10911(this));
        return orcaEditTextPreference;
    }

    private Preference m23024e() {
        OrcaEditTextPreference orcaEditTextPreference = new OrcaEditTextPreference(this);
        orcaEditTextPreference.getEditText().setInputType(2);
        orcaEditTextPreference.setTitle("With Survey ID");
        orcaEditTextPreference.setSummary("Display a survey from Intern/SimonX");
        orcaEditTextPreference.getEditText().setSelectAllOnFocus(true);
        orcaEditTextPreference.getEditText().setHint("Survey ID");
        orcaEditTextPreference.setOnPreferenceChangeListener(new C10922(this));
        return orcaEditTextPreference;
    }

    private void m23015a(PreferenceScreen preferenceScreen, String str, PrefKey prefKey, String str2) {
        Preference preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle(str);
        preferenceScreen.addPreference(preferenceCategory);
        List<String> a = this.f15403a.a(prefKey);
        if (a != null) {
            for (String a2 : a) {
                preferenceScreen.addPreference(m23014a(str2, a2));
            }
        }
    }

    private Preference m23014a(String str, String str2) {
        Preference preference = new Preference(this);
        preference.setTitle(str2);
        preference.setIntent(m23022c(str, str2));
        return preference;
    }

    public static boolean m23021b(RapidFeedbackPreferencesActivity rapidFeedbackPreferencesActivity, String str, String str2) {
        if (str2.isEmpty()) {
            return false;
        }
        rapidFeedbackPreferencesActivity.f15404b.a(rapidFeedbackPreferencesActivity.m23022c(str, str2), rapidFeedbackPreferencesActivity);
        return true;
    }

    private Intent m23022c(String str, String str2) {
        Intent intent = new Intent(this, DebugRapidFeedbackActivity.class);
        intent.putExtra(str, str2);
        return intent;
    }
}
