package com.facebook.platform.common.module;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.platform.common.activity.PlatformLauncherActivity;
import com.facebook.platform.common.activity.PlatformWrapperActivity;
import com.facebook.platform.perflogging.PlatformPerformanceLoggingCommonTags;
import com.google.common.collect.ImmutableSet;
import java.util.Iterator;

@InjectorModule
/* compiled from: stream_disk_recording_audio_channels */
public class PlatformCommonModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @PlatformPerformanceLoggingCommonTags
    static String m5968a() {
        ImmutableSet of = ImmutableSet.of(PlatformLauncherActivity.class.getName(), PlatformWrapperActivity.class.getName());
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = of.iterator();
        Object obj = 1;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (obj == null) {
                stringBuilder.append('|');
            }
            stringBuilder.append(str);
            obj = null;
        }
        return stringBuilder.toString();
    }
}
