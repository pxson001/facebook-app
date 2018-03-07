package com.facebook.http.onion.ui;

import android.content.Context;
import com.facebook.http.onion.prefs.OnionPrefKeys;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.prefs.CheckBoxOrSwitchPreference;
import javax.inject.Inject;

/* compiled from: visibleHeight */
public class OnionRewriteEnabledPreference extends CheckBoxOrSwitchPreference {
    private static OnionRewriteEnabledPreference m499b(InjectorLike injectorLike) {
        return new OnionRewriteEnabledPreference((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public OnionRewriteEnabledPreference(Context context) {
        super(context);
        setKey(OnionPrefKeys.b.a());
        setTitle(2131233714);
    }
}
