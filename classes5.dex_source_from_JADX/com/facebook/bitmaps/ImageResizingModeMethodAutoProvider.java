package com.facebook.bitmaps;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: android.view.View */
public class ImageResizingModeMethodAutoProvider extends AbstractProvider<ImageResizingMode> {
    public static ImageResizingMode m18455b(InjectorLike injectorLike) {
        return BitmapsModule.m18443a(IdBasedProvider.a(injectorLike, 4978), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    public Object get() {
        return BitmapsModule.m18443a(IdBasedProvider.a(this, 4978), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this));
    }
}
