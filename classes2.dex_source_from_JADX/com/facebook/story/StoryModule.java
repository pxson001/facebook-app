package com.facebook.story;

import android.content.Context;
import android.content.res.Resources;
import android.view.WindowManager;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.tablet.abtest.TabletColumnLayoutManager;
import com.facebook.tablet.abtest.TabletExperimentConfiguration;

@InjectorModule
/* compiled from: scan_duration */
public class StoryModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    static StoryImageSizes m10233a(Resources resources, Context context, TabletExperimentConfiguration tabletExperimentConfiguration, TabletColumnLayoutManager tabletColumnLayoutManager, Boolean bool) {
        int dimensionPixelSize = resources.getDimensionPixelSize(2131427503);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        int width = windowManager.getDefaultDisplay().getWidth();
        if (bool.booleanValue()) {
            if (tabletExperimentConfiguration.m7858a()) {
                width = tabletColumnLayoutManager.m8714a();
            }
            width = Math.min(width, (int) (((float) windowManager.getDefaultDisplay().getHeight()) * 0.8f));
        }
        return new StoryImageSizes(dimensionPixelSize, (int) (((float) width) * 0.8888889f), width);
    }
}
