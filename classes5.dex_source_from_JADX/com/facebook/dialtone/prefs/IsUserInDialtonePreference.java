package com.facebook.dialtone.prefs;

import android.content.Context;
import android.preference.Preference;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.inject.FbInjector;

/* compiled from: \%03o */
public class IsUserInDialtonePreference extends Preference {
    public final DialtoneController f11858a;

    public IsUserInDialtonePreference(Context context) {
        super(context);
        this.f11858a = (DialtoneController) DialtoneControllerImpl.a(FbInjector.get(context));
        setTitle(2131232618);
        setSummary(this.f11858a.b() ? "Enabled" : "Disabled");
    }
}
