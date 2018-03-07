package com.facebook.ui.browser.prefs;

import android.content.Context;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.prefs.CheckBoxOrSwitchPreference;
import javax.inject.Inject;

/* compiled from: timestamp_us */
public class BrowserPrefetchPreference extends CheckBoxOrSwitchPreference {
    private static BrowserPrefetchPreference m1664b(InjectorLike injectorLike) {
        return new BrowserPrefetchPreference((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public BrowserPrefetchPreference(Context context) {
        super(context);
        setKey(BrowserPrefKey.g.a());
        setSummary("Prefetch every link regardless of server side value");
        setTitle("Prefetch Every Link ");
    }
}
