package com.facebook.widget.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.ListPreference;
import com.facebook.inject.FbInjector;
import com.facebook.prefs.shared.FbPreferenceHelper;
import com.facebook.prefs.shared.FbPreferenceHelperProvider;
import com.facebook.prefs.shared.PrefKey;
import javax.inject.Inject;

/* compiled from: com.facebook.pages.app */
public class OrcaListPreference extends ListPreference {
    private final FbPreferenceHelper f5839a = this.f5840b.m10079a(this);
    @Inject
    public FbPreferenceHelperProvider f5840b;

    public static void m10584a(Object obj, Context context) {
        ((OrcaListPreference) obj).f5840b = (FbPreferenceHelperProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(FbPreferenceHelperProvider.class);
    }

    public OrcaListPreference(Context context) {
        super(context);
        Class cls = OrcaListPreference.class;
        m10584a(this, getContext());
    }

    public SharedPreferences getSharedPreferences() {
        return this.f5839a.f5216b;
    }

    public final void m10585a(PrefKey prefKey) {
        this.f5839a.m10076a(prefKey);
    }

    protected String getPersistedString(String str) {
        return this.f5839a.m10075a(str);
    }

    protected boolean persistString(String str) {
        return this.f5839a.m10078b(str);
    }
}
