package com.facebook.video.pubsub;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.rti.shared.skywalker.SkywalkerSubscriptionConnector;
import com.facebook.video.abtest.VideoLivePlaybackConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: oxygen_map_marker_touch_detection_time */
public class VideoPubSubModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    static LiveStreamingSubscriberPool m6107a(VideoLivePlaybackConfig videoLivePlaybackConfig, SkywalkerSubscriptionConnector skywalkerSubscriptionConnector, ObjectMapper objectMapper) {
        return new LiveStreamingSubscriberPool(videoLivePlaybackConfig.t, skywalkerSubscriptionConnector, objectMapper);
    }
}
