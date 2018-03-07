package com.facebook.bitmaps;

import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import javax.inject.Provider;

@InjectorModule
/* compiled from: android_add_info_button */
public class BitmapsModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    static ImageResizingMode m18443a(Provider<NativeImageProcessor> provider, FbErrorReporter fbErrorReporter) {
        if (((NativeImageProcessor) provider.get()).m18476a()) {
            return ImageResizingMode.NATIVE_JT_13;
        }
        fbErrorReporter.a("NativeImageProcessor", "Failed to load native library");
        return ImageResizingMode.JAVA_RESIZER;
    }

    @ProviderMethod
    static ImageResizer m18442a(Provider<ImageResizingMode> provider, Provider<JavaImageResizer> provider2, Provider<NativeImageResizer> provider3) {
        if (provider.get() == ImageResizingMode.NATIVE_JT_13) {
            return (ImageResizer) provider3.get();
        }
        return (ImageResizer) provider2.get();
    }
}
