package com.facebook.feed.topicfeeds.customization;

import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.topics.data.TopicListFetcher;
import com.facebook.widget.listview.FbListAdapter;

@InjectorModule
/* compiled from: participant */
public class TopicFeedsCustomizationModule extends AbstractLibraryModule {

    /* compiled from: participant */
    public final class C04411 {
        final /* synthetic */ TopicCustomizationHeaderAdapterProvider f10373a;

        C04411(TopicCustomizationHeaderAdapterProvider topicCustomizationHeaderAdapterProvider) {
            this.f10373a = topicCustomizationHeaderAdapterProvider;
        }

        public final FbListAdapter m15470a(GraphQLExploreFeed graphQLExploreFeed) {
            InjectorLike injectorLike = this.f10373a;
            return new TopicCustomizationHeaderAdapter(graphQLExploreFeed, TopicListFetcher.b(injectorLike), TopicFeedsIntentFactory.b(injectorLike), DefaultSecureContextHelper.m4636a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3967), IdBasedLazy.m1808a(injectorLike, 2352));
        }
    }

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    public static C04411 m15469a(TopicCustomizationHeaderAdapterProvider topicCustomizationHeaderAdapterProvider) {
        return new C04411(topicCustomizationHeaderAdapterProvider);
    }
}
