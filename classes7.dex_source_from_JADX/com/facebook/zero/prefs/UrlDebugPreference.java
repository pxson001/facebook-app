package com.facebook.zero.prefs;

import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import com.facebook.zero.activity.ZeroUrlDebugActivity;
import javax.inject.Inject;

/* compiled from: z-m-scontent.xx.fbcdn.net */
public class UrlDebugPreference extends Preference {
    private final Context f160a;

    /* compiled from: z-m-scontent.xx.fbcdn.net */
    class C00281 implements OnPreferenceClickListener {
        final /* synthetic */ UrlDebugPreference f159a;

        C00281(UrlDebugPreference urlDebugPreference) {
            this.f159a = urlDebugPreference;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.f159a.getContext().startActivity(new Intent(this.f159a.getContext(), ZeroUrlDebugActivity.class));
            return true;
        }
    }

    @Inject
    public UrlDebugPreference(Context context) {
        super(context);
        this.f160a = context;
        setOnPreferenceClickListener(new C00281(this));
        setTitle(2131232989);
    }
}
