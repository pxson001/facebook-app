package com.facebook.widget.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.EditTextPreference;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.facebook.inject.FbInjector;
import com.facebook.prefs.shared.FbPreferenceHelper;
import com.facebook.prefs.shared.FbPreferenceHelperProvider;
import com.facebook.prefs.shared.PrefKey;
import javax.inject.Inject;

/* compiled from: com.facebook.testing.instrumentation.sampleapp.BaseTestModule */
public class OrcaEditTextPreference extends EditTextPreference {
    private final FbPreferenceHelper f5827a = this.f5828b.m10079a(this);
    @Inject
    public FbPreferenceHelperProvider f5828b;

    public static void m10574a(Object obj, Context context) {
        ((OrcaEditTextPreference) obj).f5828b = (FbPreferenceHelperProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(FbPreferenceHelperProvider.class);
    }

    public OrcaEditTextPreference(Context context) {
        super(context);
        Class cls = OrcaEditTextPreference.class;
        m10574a(this, getContext());
    }

    protected void onAddEditTextToDialogView(View view, EditText editText) {
        ViewGroup viewGroup = (ViewGroup) view.findViewById(2131566205);
        if (viewGroup != null) {
            viewGroup.addView(editText, -1, -2);
        } else {
            super.onAddEditTextToDialogView(view, editText);
        }
    }

    public SharedPreferences getSharedPreferences() {
        return this.f5827a.f5216b;
    }

    public final void m10575a(PrefKey prefKey) {
        this.f5827a.m10076a(prefKey);
    }

    protected String getPersistedString(String str) {
        return this.f5827a.m10075a(str);
    }

    protected boolean persistString(String str) {
        return this.f5827a.m10078b(str);
    }
}
