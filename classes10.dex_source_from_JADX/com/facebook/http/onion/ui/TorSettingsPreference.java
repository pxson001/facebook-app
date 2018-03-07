package com.facebook.http.onion.ui;

import android.content.Context;
import android.preference.Preference;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: viewer_longitude */
public class TorSettingsPreference extends Preference {
    private static TorSettingsPreference m503b(InjectorLike injectorLike) {
        return new TorSettingsPreference((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public TorSettingsPreference(Context context) {
        super(context);
        setTitle(2131233711);
    }
}
