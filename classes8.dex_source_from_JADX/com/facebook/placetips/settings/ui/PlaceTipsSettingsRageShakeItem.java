package com.facebook.placetips.settings.ui;

import android.content.Context;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.TriState;
import com.facebook.content.SecureContextHelper;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: caps */
public class PlaceTipsSettingsRageShakeItem {
    private final Provider<TriState> f18465a;
    private final Provider<Boolean> f18466b;
    public final SecureContextHelper f18467c;
    public final UriIntentMapper f18468d;

    @Inject
    public PlaceTipsSettingsRageShakeItem(Provider<TriState> provider, Provider<Boolean> provider2, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper) {
        this.f18465a = provider;
        this.f18466b = provider2;
        this.f18467c = secureContextHelper;
        this.f18468d = uriIntentMapper;
    }

    public final boolean m22396a() {
        return ((TriState) this.f18465a.get()).asBoolean(false) && ((Boolean) this.f18466b.get()).booleanValue();
    }

    public final String m22395a(Context context) {
        return context.getResources().getString(2131239376);
    }
}
