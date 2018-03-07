package com.facebook.katana.urimap.fetchable;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: suggested_privacy_option */
public class C0085x28de9b83 extends AbstractProvider<UriTemplateMapParser> {
    public static UriTemplateMapParser m1788b(InjectorLike injectorLike) {
        return FetchableUriMapModule.m1791a(FacewebUriHandlerBuilder.m1789b(injectorLike));
    }

    public Object get() {
        return FetchableUriMapModule.m1791a(FacewebUriHandlerBuilder.m1789b(this));
    }
}
