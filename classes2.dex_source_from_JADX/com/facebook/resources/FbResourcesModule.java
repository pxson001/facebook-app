package com.facebook.resources;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: validated_country */
public class FbResourcesModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @BaseResources
    static Resources m2603a(Context context) {
        if (context instanceof HasBaseResourcesAccess) {
            return ((HasBaseResourcesAccess) context).a();
        }
        return context.getResources();
    }
}
