package com.facebook.widget.titlebar;

import android.content.res.Resources;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.Assisted;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: quote_text */
public class TitleBarButtonSpecCache {
    private final AllCapsTransformationMethod f6248a;
    private final String f6249b;
    private ImmutableList<TitleBarButtonSpec> f6250c;
    private ImmutableList<TitleBarButtonSpec> f6251d;

    @Inject
    public TitleBarButtonSpecCache(@Assisted int i, AllCapsTransformationMethod allCapsTransformationMethod, Resources resources) {
        this.f6248a = allCapsTransformationMethod;
        this.f6249b = resources.getString(i);
    }

    public final ImmutableList<TitleBarButtonSpec> m8801a() {
        if (this.f6250c == null) {
            this.f6250c = m8800a(true);
        }
        return this.f6250c;
    }

    public final ImmutableList<TitleBarButtonSpec> m8802b() {
        if (this.f6251d == null) {
            this.f6251d = m8800a(false);
        }
        return this.f6251d;
    }

    private ImmutableList<TitleBarButtonSpec> m8800a(boolean z) {
        Builder a = TitleBarButtonSpec.a();
        a.d = z;
        a = a;
        a.h = -2;
        a = a;
        a.g = this.f6248a.getTransformation(this.f6249b, null).toString();
        return ImmutableList.of(a.a());
    }
}
