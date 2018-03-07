package com.facebook.widget.prefs;

import android.content.Context;
import android.view.View;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.FbInjector;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import javax.inject.Inject;

/* compiled from: com.facebook.versioncontrol.branch */
public class EditTextPreferenceWithSummaryValue extends OrcaEditTextPreference {
    private final OnSharedPreferenceChangeListener f5829a = new C05291(this);
    public CharSequence f5830b = getSummary();
    @Inject
    public FbSharedPreferences f5831c;

    /* compiled from: com.facebook.versioncontrol.branch */
    class C05291 implements OnSharedPreferenceChangeListener {
        final /* synthetic */ EditTextPreferenceWithSummaryValue f5826a;

        C05291(EditTextPreferenceWithSummaryValue editTextPreferenceWithSummaryValue) {
            this.f5826a = editTextPreferenceWithSummaryValue;
        }

        public final void m10573a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
            EditTextPreferenceWithSummaryValue.m10577b(this.f5826a);
        }
    }

    public static void m10576a(Object obj, Context context) {
        ((EditTextPreferenceWithSummaryValue) obj).f5831c = (FbSharedPreferences) FbSharedPreferencesImpl.a(FbInjector.get(context));
    }

    public EditTextPreferenceWithSummaryValue(Context context) {
        super(context);
        Class cls = EditTextPreferenceWithSummaryValue.class;
        m10576a(this, getContext());
    }

    public final void m10578a() {
        String key = getKey();
        if (key != null) {
            this.f5831c.a(key, this.f5829a);
        }
    }

    protected void onBindView(View view) {
        m10577b(this);
        super.onBindView(view);
    }

    public static void m10577b(EditTextPreferenceWithSummaryValue editTextPreferenceWithSummaryValue) {
        CharSequence text = editTextPreferenceWithSummaryValue.getText();
        if (StringUtil.a(text)) {
            editTextPreferenceWithSummaryValue.setSummary(editTextPreferenceWithSummaryValue.f5830b);
        } else {
            editTextPreferenceWithSummaryValue.setSummary(text);
        }
    }
}
