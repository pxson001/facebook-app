package com.facebook.widget.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.CheckBoxPreference;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.inject.FbInjector;
import com.facebook.prefs.shared.FbPreferenceHelper;
import com.facebook.prefs.shared.FbPreferenceHelperProvider;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.PrefKey;
import javax.inject.Inject;

/* compiled from: com.facebook.wakizashi */
public class OrcaCheckBoxPreference extends CheckBoxPreference {
    private final FbPreferenceHelper f5823a = this.f5824b.m10079a(this);
    @Inject
    public FbPreferenceHelperProvider f5824b;

    public static void m10570a(Object obj, Context context) {
        ((OrcaCheckBoxPreference) obj).f5824b = (FbPreferenceHelperProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(FbPreferenceHelperProvider.class);
    }

    public OrcaCheckBoxPreference(Context context) {
        super(context);
        Class cls = OrcaCheckBoxPreference.class;
        m10570a(this, getContext());
    }

    protected void onBindView(View view) {
        super.onBindView(view);
        m10569a(view);
    }

    public SharedPreferences getSharedPreferences() {
        return this.f5823a.f5216b;
    }

    public final void m10571a(PrefKey prefKey) {
        this.f5823a.m10076a(prefKey);
    }

    protected boolean getPersistedBoolean(boolean z) {
        return this.f5823a.m10077a(z);
    }

    protected boolean persistBoolean(boolean z) {
        if (!shouldPersist()) {
            return false;
        }
        FbPreferenceHelper fbPreferenceHelper = this.f5823a;
        if (z != fbPreferenceHelper.m10077a(!z)) {
            Editor edit = fbPreferenceHelper.f5217c.edit();
            edit.putBoolean(new PrefKey(fbPreferenceHelper.f5215a.getKey()), z);
            edit.commit();
        }
        return true;
    }

    private void m10569a(View view) {
        int i = 0;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            while (i < viewGroup.getChildCount()) {
                m10569a(viewGroup.getChildAt(i));
                i++;
            }
        } else if (view instanceof TextView) {
            TextView textView = (TextView) view;
            textView.setSingleLine(false);
            textView.setEllipsize(null);
        }
    }
}
