package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasScrollListenerSupport;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.attachments.video.VideoAttachmentDelegate;
import com.facebook.feedplugins.attachments.video.VideoAttachmentDelegateProvider;
import com.facebook.feedplugins.attachments.video.VideoAttachmentProps;
import com.facebook.feedplugins.video.LogFullscreenVideoDisplayedPartDefinition;
import com.facebook.feedplugins.video.PlayFullscreenVideoPartDefinition;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.video.feed.FeedVideoPlayerParamBuilderProvider;
import com.google.common.base.Absent;
import javax.inject.Inject;

@ContextScoped
/* compiled from: audience_educator_source_extra */
public class StorySetPageVideoAttachmentPartDefinition<E extends HasFeedListType & HasPrefetcher & HasScrollListenerSupport> extends BaseSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, View> {
    private static StorySetPageVideoAttachmentPartDefinition f9756e;
    private static final Object f9757f = new Object();
    private final LogFullscreenVideoDisplayedPartDefinition<E> f9758a;
    private final PlayFullscreenVideoPartDefinition<E> f9759b;
    private final VideoAttachmentDelegateProvider f9760c;
    private final FeedVideoPlayerParamBuilderProvider f9761d;

    private static StorySetPageVideoAttachmentPartDefinition m10197b(InjectorLike injectorLike) {
        return new StorySetPageVideoAttachmentPartDefinition((VideoAttachmentDelegateProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoAttachmentDelegateProvider.class), (FeedVideoPlayerParamBuilderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedVideoPlayerParamBuilderProvider.class), LogFullscreenVideoDisplayedPartDefinition.a(injectorLike), PlayFullscreenVideoPartDefinition.a(injectorLike));
    }

    public final Object m10198a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        VideoAttachmentDelegate a = this.f9760c.a(feedProps, Absent.INSTANCE);
        VideoAttachmentProps videoAttachmentProps = new VideoAttachmentProps(a, this.f9761d.a(feedProps, a.e));
        subParts.a(this.f9758a, videoAttachmentProps);
        subParts.a(this.f9759b, videoAttachmentProps);
        return null;
    }

    @Inject
    public StorySetPageVideoAttachmentPartDefinition(VideoAttachmentDelegateProvider videoAttachmentDelegateProvider, FeedVideoPlayerParamBuilderProvider feedVideoPlayerParamBuilderProvider, LogFullscreenVideoDisplayedPartDefinition logFullscreenVideoDisplayedPartDefinition, PlayFullscreenVideoPartDefinition playFullscreenVideoPartDefinition) {
        this.f9758a = logFullscreenVideoDisplayedPartDefinition;
        this.f9759b = playFullscreenVideoPartDefinition;
        this.f9760c = videoAttachmentDelegateProvider;
        this.f9761d = feedVideoPlayerParamBuilderProvider;
    }

    public static StorySetPageVideoAttachmentPartDefinition m10196a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetPageVideoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9757f) {
                StorySetPageVideoAttachmentPartDefinition storySetPageVideoAttachmentPartDefinition;
                if (a2 != null) {
                    storySetPageVideoAttachmentPartDefinition = (StorySetPageVideoAttachmentPartDefinition) a2.a(f9757f);
                } else {
                    storySetPageVideoAttachmentPartDefinition = f9756e;
                }
                if (storySetPageVideoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10197b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9757f, b3);
                        } else {
                            f9756e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetPageVideoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
