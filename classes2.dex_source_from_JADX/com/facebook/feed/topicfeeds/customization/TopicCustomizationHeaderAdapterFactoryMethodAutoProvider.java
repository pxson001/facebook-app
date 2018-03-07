package com.facebook.feed.topicfeeds.customization;

import com.facebook.feed.fragment.TopicCustomizationHeaderAdapterFactory;
import com.facebook.feed.topicfeeds.customization.TopicFeedsCustomizationModule.C04411;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: passwordCredentials */
public class TopicCustomizationHeaderAdapterFactoryMethodAutoProvider extends AbstractProvider<TopicCustomizationHeaderAdapterFactory> {
    public static C04411 m15468a(InjectorLike injectorLike) {
        return TopicFeedsCustomizationModule.m15469a((TopicCustomizationHeaderAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TopicCustomizationHeaderAdapterProvider.class));
    }

    public Object get() {
        return TopicFeedsCustomizationModule.m15469a((TopicCustomizationHeaderAdapterProvider) getOnDemandAssistedProviderForStaticDi(TopicCustomizationHeaderAdapterProvider.class));
    }
}
