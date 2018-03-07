package com.facebook.widget.titlebar;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: quoteText */
public class TitleBarButtonSpecCacheProvider extends AbstractAssistedProvider<TitleBarButtonSpecCache> {
    public final TitleBarButtonSpecCache m8803a(int i) {
        return new TitleBarButtonSpecCache(i, AllCapsTransformationMethod.b(this), ResourcesMethodAutoProvider.a(this));
    }
}
