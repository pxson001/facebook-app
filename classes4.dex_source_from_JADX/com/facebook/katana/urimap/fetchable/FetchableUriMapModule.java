package com.facebook.katana.urimap.fetchable;

import com.facebook.debug.log.LogPrefixer;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: suggested_locale_list */
public class FetchableUriMapModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @FacewebUriTemplateMapParser
    static UriTemplateMapParser m1791a(FacewebUriHandlerBuilder facewebUriHandlerBuilder) {
        return new UriTemplateMapParser(facewebUriHandlerBuilder, FacewebUriMap.f1575a, LogPrefixer.a(FacewebUriMapClient.f1577a));
    }
}
