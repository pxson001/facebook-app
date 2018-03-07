package com.facebook.messaging.montage;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.montage.annotations.MyMontageThreadKey;
import javax.annotation.Nullable;

@InjectorModule
/* compiled from: iso-8859-4 */
public class MontageModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @UserScoped
    @MyMontageThreadKey
    @Nullable
    static ThreadKey m12870a(MontageTestHelper montageTestHelper) {
        return montageTestHelper.m12874a();
    }
}
