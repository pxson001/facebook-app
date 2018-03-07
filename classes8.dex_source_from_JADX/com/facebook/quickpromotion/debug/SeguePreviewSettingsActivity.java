package com.facebook.quickpromotion.debug;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.facebook.base.activity.FbPreferenceActivity;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.quickpromotion.prefs.QuickPromotionPrefKeys;
import com.facebook.widget.prefs.OrcaCheckBoxPreference;
import com.facebook.widget.prefs.OrcaEditTextPreference;
import com.google.common.base.Strings;
import java.lang.reflect.Field;
import javax.inject.Inject;

/* compiled from: redspace_performance */
public class SeguePreviewSettingsActivity extends FbPreferenceActivity {
    @Inject
    FbUriIntentHandler f4678a;
    @Inject
    FbSharedPreferences f4679b;
    private PreferenceCategory f4680c;
    private OnSharedPreferenceChangeListener f4681d = new C06241(this);
    public String f4682e = "";

    /* compiled from: redspace_performance */
    class C06241 implements OnSharedPreferenceChangeListener {
        final /* synthetic */ SeguePreviewSettingsActivity f4670a;

        C06241(SeguePreviewSettingsActivity seguePreviewSettingsActivity) {
            this.f4670a = seguePreviewSettingsActivity;
        }

        public final void m4517a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
            if (prefKey.equals(QuickPromotionPrefKeys.f4759c)) {
                this.f4670a.m4519a();
            }
        }
    }

    /* compiled from: redspace_performance */
    class C06252 implements OnPreferenceChangeListener {
        final /* synthetic */ SeguePreviewSettingsActivity f4671a;

        C06252(SeguePreviewSettingsActivity seguePreviewSettingsActivity) {
            this.f4671a = seguePreviewSettingsActivity;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            this.f4671a.f4678a.a(this.f4671a, obj == null ? "" : String.valueOf(obj));
            return true;
        }
    }

    /* compiled from: redspace_performance */
    class C06263 implements OnPreferenceChangeListener {
        final /* synthetic */ SeguePreviewSettingsActivity f4672a;

        C06263(SeguePreviewSettingsActivity seguePreviewSettingsActivity) {
            this.f4672a = seguePreviewSettingsActivity;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            String valueOf = obj == null ? "" : String.valueOf(obj);
            SeguePreviewSettingsActivity seguePreviewSettingsActivity = this.f4672a;
            SeguePreviewSettingsActivity.m4520a(preference, valueOf);
            if (!this.f4672a.f4682e.equals(valueOf)) {
                this.f4672a.f4682e = valueOf;
                this.f4672a.m4519a();
            }
            return true;
        }
    }

    private static <T extends Context> void m4525a(Class<T> cls, T t) {
        m4526a((Object) t, (Context) t);
    }

    public static void m4526a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((SeguePreviewSettingsActivity) obj).m4522a(FbUriIntentHandler.a(fbInjector), (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector));
    }

    private void m4522a(FbUriIntentHandler fbUriIntentHandler, FbSharedPreferences fbSharedPreferences) {
        this.f4678a = fbUriIntentHandler;
        this.f4679b = fbSharedPreferences;
    }

    public final void m4531c(Bundle bundle) {
        super.c(bundle);
        Class cls = SeguePreviewSettingsActivity.class;
        m4526a((Object) this, (Context) this);
        PreferenceScreen createPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
        m4521a(createPreferenceScreen);
        m4528b(createPreferenceScreen);
        m4529c(createPreferenceScreen);
        m4530d(createPreferenceScreen);
        setPreferenceScreen(createPreferenceScreen);
    }

    private void m4521a(PreferenceScreen preferenceScreen) {
        OrcaEditTextPreference orcaEditTextPreference = new OrcaEditTextPreference(this);
        orcaEditTextPreference.setText(this.f4682e);
        orcaEditTextPreference.setTitle("Launch segue");
        orcaEditTextPreference.setSummary("Launch a user defined segue");
        orcaEditTextPreference.getEditText().setHint("fb://");
        orcaEditTextPreference.setOnPreferenceChangeListener(new C06252(this));
        preferenceScreen.addPreference(orcaEditTextPreference);
    }

    private void m4528b(PreferenceScreen preferenceScreen) {
        Preference orcaEditTextPreference = new OrcaEditTextPreference(this);
        orcaEditTextPreference.setText(this.f4682e);
        orcaEditTextPreference.setTitle("Filter segues");
        m4520a(orcaEditTextPreference, orcaEditTextPreference.getText());
        orcaEditTextPreference.getEditText().setSelectAllOnFocus(true);
        orcaEditTextPreference.setOnPreferenceChangeListener(new C06263(this));
        preferenceScreen.addPreference(orcaEditTextPreference);
    }

    private void m4529c(PreferenceScreen preferenceScreen) {
        OrcaCheckBoxPreference orcaCheckBoxPreference = new OrcaCheckBoxPreference(this);
        orcaCheckBoxPreference.a(QuickPromotionPrefKeys.f4759c);
        orcaCheckBoxPreference.setTitle("Show all segues");
        orcaCheckBoxPreference.setSummary("Show all segues including parameterized segues.");
        orcaCheckBoxPreference.setDefaultValue(Boolean.valueOf(false));
        preferenceScreen.addPreference(orcaCheckBoxPreference);
    }

    private void m4530d(PreferenceScreen preferenceScreen) {
        this.f4680c = new PreferenceCategory(this);
        this.f4680c.setTitle("Segues");
        preferenceScreen.addPreference(this.f4680c);
        m4519a();
    }

    private void m4519a() {
        this.f4680c.removeAll();
        Field[] declaredFields = FBLinks.class.getDeclaredFields();
        if (declaredFields != null) {
            boolean a = this.f4679b.a(QuickPromotionPrefKeys.f4759c, false);
            for (Field field : declaredFields) {
                try {
                    boolean z;
                    final Object nullToEmpty = Strings.nullToEmpty((String) field.get(null));
                    if (nullToEmpty.contains("%s") || nullToEmpty.endsWith("=")) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (nullToEmpty.matches("^fb://.*$") && (a || !z)) {
                        if (StringLocaleUtil.a(nullToEmpty).contains(StringLocaleUtil.a(this.f4682e))) {
                            Preference preference = new Preference(this);
                            preference.setSummary(nullToEmpty);
                            preference.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
                                final /* synthetic */ SeguePreviewSettingsActivity f4677c;

                                public boolean onPreferenceClick(Preference preference) {
                                    if (z) {
                                        final View editText = new EditText(this.f4677c);
                                        editText.setText(nullToEmpty);
                                        new Builder(this.f4677c).a("Replace parameters").b(editText).a("Ok", new OnClickListener(this) {
                                            final /* synthetic */ C06284 f4674b;

                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                Editable text = editText.getText();
                                                if (text != null) {
                                                    this.f4674b.f4677c.f4678a.a(this.f4674b.f4677c, Strings.nullToEmpty(text.toString()));
                                                }
                                            }
                                        }).b("Cancel", null).b();
                                    } else {
                                        this.f4677c.f4678a.a(this.f4677c, nullToEmpty);
                                    }
                                    return true;
                                }
                            });
                            this.f4680c.addPreference(preference);
                        }
                    }
                } catch (IllegalAccessException e) {
                }
            }
        }
    }

    public static void m4520a(Preference preference, String str) {
        preference.setSummary(Strings.isNullOrEmpty(str) ? "No filter applied" : "Filtered by: " + str);
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1162392003);
        super.onResume();
        this.f4679b.a(QuickPromotionPrefKeys.f4759c, this.f4681d);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -494046444, a);
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1879914333);
        super.onPause();
        this.f4679b.b(QuickPromotionPrefKeys.f4759c, this.f4681d);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1238933195, a);
    }
}
