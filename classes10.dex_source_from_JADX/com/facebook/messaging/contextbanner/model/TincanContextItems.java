package com.facebook.messaging.contextbanner.model;

import android.content.res.Resources;
import com.facebook.ultralight.Inject;
import javax.annotation.Nullable;

/* compiled from: status_composer_from_uri */
public class TincanContextItems implements ContextItems {
    private Resources f2228a;
    @Nullable
    public String f2229b;

    @Inject
    public TincanContextItems(Resources resources) {
        this.f2228a = resources;
    }

    @Nullable
    public final String mo60a() {
        return this.f2228a.getString(2131232393);
    }

    @Nullable
    public final String mo61b() {
        return this.f2228a.getString(2131232394, new Object[]{this.f2229b});
    }

    @Nullable
    public final String mo62c() {
        return null;
    }
}
