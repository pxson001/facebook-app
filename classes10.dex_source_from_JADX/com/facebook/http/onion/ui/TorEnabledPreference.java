package com.facebook.http.onion.ui;

import android.content.Context;
import com.facebook.http.onion.prefs.OnionPrefKeys;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.prefs.CheckBoxOrSwitchPreference;
import javax.inject.Inject;

/* compiled from: viewgroup */
public class TorEnabledPreference extends CheckBoxOrSwitchPreference {
    private static TorEnabledPreference m500b(InjectorLike injectorLike) {
        return new TorEnabledPreference((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public TorEnabledPreference(Context context) {
        super(context);
        setTitle(2131233712);
        setSummary(2131233713);
        setKey(OnionPrefKeys.c.a());
    }
}
