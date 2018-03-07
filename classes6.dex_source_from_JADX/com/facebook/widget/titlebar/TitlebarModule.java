package com.facebook.widget.titlebar;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: quickcamback */
public class TitlebarModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsActionBarAllowed
    static Boolean m8809a() {
        return Boolean.valueOf(false);
    }
}
