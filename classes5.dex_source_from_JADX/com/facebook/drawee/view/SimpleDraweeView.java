package com.facebook.drawee.view;

import android.net.Uri;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder;
import javax.annotation.Nullable;

/* compiled from: ZeroIndicatorData */
public class SimpleDraweeView extends GenericDraweeView {
    public static Supplier<? extends SimpleDraweeControllerBuilder> f11983a;
    private SimpleDraweeControllerBuilder f11984b;

    protected SimpleDraweeControllerBuilder getControllerBuilder() {
        return this.f11984b;
    }

    public void setImageURI(Uri uri) {
        m19990a(uri, null);
    }

    public void setImageURI(@Nullable String str) {
        m19991a(str, null);
    }

    private void m19990a(Uri uri, @Nullable Object obj) {
        setController(this.f11984b.a(obj).a(uri).a(getController()).a());
    }

    private void m19991a(@Nullable String str, @Nullable Object obj) {
        m19990a(str != null ? Uri.parse(str) : null, obj);
    }
}
