package com.facebook.facerec.module;

import com.facebook.facerec.manager.FaceBoxPrioritizer;
import com.facebook.facerec.manager.FaceRecManager;
import com.facebook.facerec.manager.ImagePipelineFaceBoxPrioritizer;
import com.facebook.facerec.manager.ImagePipelineFaceRecManager;
import com.facebook.facerec.manager.LegacyFaceBoxPrioritizer;
import com.facebook.facerec.manager.LegacyFaceRecManager;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import com.facebook.photos.base.analytics.TaggingSinglePhotoFlowLogger;
import com.facebook.photos.base.analytics.WaterfallIdGenerator;
import javax.inject.Provider;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: no_warn_external */
public class FaceRecognitionModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    @TaggingSinglePhotoFlowLogger
    static DefaultPhotoFlowLogger m15657a(WaterfallIdGenerator waterfallIdGenerator, DefaultPhotoFlowLogger defaultPhotoFlowLogger) {
        defaultPhotoFlowLogger.m19891a(WaterfallIdGenerator.m20067a());
        return defaultPhotoFlowLogger;
    }

    @ProviderMethod
    @Singleton
    @IsFrescoFaceRecFeatureEnabled
    static Boolean m15658a(GatekeeperStoreImpl gatekeeperStoreImpl) {
        return Boolean.valueOf(gatekeeperStoreImpl.a(838, false));
    }

    @ProviderMethod
    public static FaceRecManager m15656a(Provider<Boolean> provider, Provider<ImagePipelineFaceRecManager> provider2, Provider<LegacyFaceRecManager> provider3) {
        return ((Boolean) provider.get()).booleanValue() ? (FaceRecManager) provider2.get() : (FaceRecManager) provider3.get();
    }

    @ProviderMethod
    public static FaceBoxPrioritizer m15659b(Provider<Boolean> provider, Provider<ImagePipelineFaceBoxPrioritizer> provider2, Provider<LegacyFaceBoxPrioritizer> provider3) {
        return ((Boolean) provider.get()).booleanValue() ? (FaceBoxPrioritizer) provider2.get() : (FaceBoxPrioritizer) provider3.get();
    }
}
