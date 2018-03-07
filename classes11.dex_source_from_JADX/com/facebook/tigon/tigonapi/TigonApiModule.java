package com.facebook.tigon.tigonapi;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.soloader.SoLoader;

@InjectorModule
/* compiled from: no_target */
public class TigonApiModule extends AbstractLibraryModule {
    static void m6340a() {
        SoLoader.a("tigonliger");
    }

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }
}
