package com.facebook.fbui.viewdescriptionbuilder;

import com.facebook.drawee.instrumentation.DraweeViewDescriptionBuilderSpec;
import com.facebook.fbui.viewdescriptionbuilder.viewspecs.DefaultViewDescriptionBuilderSpec;
import com.facebook.fbui.viewdescriptionbuilder.viewspecs.ListViewDescriptionSpec;
import com.facebook.fbui.viewdescriptionbuilder.viewspecs.TextViewDescriptionSpec;
import com.facebook.fbui.viewdescriptionbuilder.viewspecs.ViewGroupDescriptionBuilderSpec;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$ViewDescriptionBuilderSpec implements MultiBindIndexedProvider<ViewDescriptionBuilderSpec>, Provider<Set<ViewDescriptionBuilderSpec>> {
    private final InjectorLike f8517a;

    public STATICDI_MULTIBIND_PROVIDER$ViewDescriptionBuilderSpec(InjectorLike injectorLike) {
        this.f8517a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f8517a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 5;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new DraweeViewDescriptionBuilderSpec();
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return new DefaultViewDescriptionBuilderSpec(LayoutParamsFormatter.a(injector), ViewIdExtractor.a(injector));
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return new ListViewDescriptionSpec();
            case 3:
                return new TextViewDescriptionSpec();
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return new ViewGroupDescriptionBuilderSpec();
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
