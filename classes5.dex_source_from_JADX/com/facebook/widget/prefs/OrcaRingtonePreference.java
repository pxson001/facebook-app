package com.facebook.widget.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.RingtonePreference;
import com.facebook.inject.FbInjector;
import com.facebook.prefs.shared.FbPreferenceHelper;
import com.facebook.prefs.shared.FbPreferenceHelperProvider;
import javax.inject.Inject;

/* compiled from: com.facebook.metagen.generator.mustache.MustacheCodeGenerator */
public class OrcaRingtonePreference extends RingtonePreference {
    public final FbPreferenceHelper f5844a = this.f5845b.m10079a(this);
    @Inject
    public FbPreferenceHelperProvider f5845b;

    public static void m10591a(Object obj, Context context) {
        ((OrcaRingtonePreference) obj).f5845b = (FbPreferenceHelperProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(FbPreferenceHelperProvider.class);
    }

    public OrcaRingtonePreference(Context context) {
        super(context);
        Class cls = OrcaRingtonePreference.class;
        m10591a(this, getContext());
    }

    public SharedPreferences getSharedPreferences() {
        return this.f5844a.f5216b;
    }

    protected String getPersistedString(String str) {
        return this.f5844a.m10075a(str);
    }

    protected boolean persistString(String str) {
        return this.f5844a.m10078b(str);
    }
}
