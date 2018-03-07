package com.facebook.photos.mediagallery.ui;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.photos.mediagallery.abtest.ExperimentsForMediaGalleryAbTestModule;
import com.facebook.photos.mediagallery.ui.widget.FrescoMediaGalleryActionsGenerator;
import com.facebook.photos.mediagallery.ui.widget.LegacyMediaGalleryActionsGenerator;
import com.facebook.photos.mediagallery.ui.widget.MediaGalleryActionsGenerator;
import com.facebook.qe.api.QeAccessor;
import javax.inject.Provider;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: sms_wait_time */
public class MediaGalleryUiModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    static MediaGalleryActionsGenerator m2545a(QeAccessor qeAccessor, Provider<FrescoMediaGalleryActionsGenerator> provider, Provider<LegacyMediaGalleryActionsGenerator> provider2) {
        if (qeAccessor.a(ExperimentsForMediaGalleryAbTestModule.a, false)) {
            return (MediaGalleryActionsGenerator) provider.get();
        }
        return (MediaGalleryActionsGenerator) provider2.get();
    }
}
