package com.facebook.audiofingerprinting.module;

import com.facebook.audiofingerprinting.gating.IsRidgeEnabled;
import com.facebook.common.util.TriState;
import com.facebook.config.application.Product;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.google.common.annotations.VisibleForTesting;
import javax.inject.Provider;

@InjectorModule
/* compiled from: updateLayout */
public class AudioFingerprintingModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @VisibleForTesting
    @IsRidgeEnabled
    public static TriState m1044a(Provider<TriState> provider, Product product) {
        return product == Product.FB4A ? (TriState) provider.get() : TriState.NO;
    }
}
