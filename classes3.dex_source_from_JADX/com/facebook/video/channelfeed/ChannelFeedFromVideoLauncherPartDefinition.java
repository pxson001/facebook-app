package com.facebook.video.channelfeed;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.videos.ui.HasChannelFeedLauncherInfo;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.autoplay.AutoplayStateManagerProvider;
import com.facebook.feed.autoplay.VideoStoryPersistentState;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.attachments.video.ChannelFeedEligibilityUtil;
import com.facebook.feedplugins.attachments.video.FeedAnalyticsUtil;
import com.facebook.feedplugins.attachments.video.InlineVideoPersistentState;
import com.facebook.feedplugins.attachments.video.InlineVideoStoryKey;
import com.facebook.feedplugins.attachments.video.VideoZeroDialogPartDefinition;
import com.facebook.feedplugins.attachments.video.VideoZeroDialogPartDefinition.Props;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLVideoChannel;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.video.analytics.ChannelEligibility;
import com.facebook.video.channelfeed.ChannelFeedParams.Builder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ufi/reactions/v2/16x16/love */
public class ChannelFeedFromVideoLauncherPartDefinition<E extends HasFeedListType & HasPersistentState, V extends View & HasChannelFeedLauncherInfo> extends BaseSinglePartDefinition<Props, Void, E, V> {
    private static ChannelFeedFromVideoLauncherPartDefinition f182f;
    private static final Object f183g = new Object();
    private final LaunchChannelFeedClickListenerProvider f184a;
    private final AutoplayStateManagerProvider f185b;
    private final ChannelFeedEligibilityUtil f186c;
    private final GraphQLStoryUtil f187d;
    private final Lazy<VideoZeroDialogPartDefinition> f188e;

    private static ChannelFeedFromVideoLauncherPartDefinition m174b(InjectorLike injectorLike) {
        return new ChannelFeedFromVideoLauncherPartDefinition((LaunchChannelFeedClickListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LaunchChannelFeedClickListenerProvider.class), (AutoplayStateManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AutoplayStateManagerProvider.class), ChannelFeedEligibilityUtil.a(injectorLike), GraphQLStoryUtil.a(injectorLike), IdBasedLazy.a(injectorLike, 1817));
    }

    public final Object m175a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasFeedListType hasFeedListType = (HasFeedListType) anyEnvironment;
        FeedProps e = AttachmentProps.e(props.a);
        if (e != null) {
            String b;
            GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) props.a.a;
            FeedListName a = hasFeedListType.c().a();
            ChannelEligibility a2 = this.f186c.a(props.a, a);
            FeedProps a3 = GraphQLStoryUtil.a(e, new 1(this));
            GraphQLMedia r = graphQLStoryAttachment.r();
            String str;
            if (r != null) {
                b = r.b();
                GraphQLVideoChannel bm = r.bm();
                if (bm != null) {
                    str = b;
                    b = bm.k();
                } else {
                    str = b;
                    b = null;
                }
            } else {
                b = null;
                str = null;
            }
            GraphQLStory graphQLStory = (GraphQLStory) a3.a;
            if (!(a2 != ChannelEligibility.ELIGIBLE || graphQLStory.c() == null || r2 == null)) {
                VideoStoryPersistentState a4;
                if (props.c == null || props.c.getVideoStoryPersistentState() == null) {
                    a4 = m172a(props.a, hasFeedListType);
                } else {
                    a4 = props.c.getVideoStoryPersistentState();
                }
                Builder builder = new Builder();
                builder.a = a3;
                builder = builder;
                builder.d = ChannelFeedEligibilityUtil.a(a);
                builder = builder;
                builder.h = a4.c();
                builder = builder;
                builder.g = FeedAnalyticsUtil.a(hasFeedListType.c());
                builder = builder;
                builder.l = props.f;
                builder = builder;
                builder.m = props.g;
                builder = builder;
                builder.k = props.d;
                Builder builder2 = builder;
                if (b != null) {
                    builder2.a(b);
                }
                subParts.a((SinglePartDefinition) this.f188e.get(), new Props(this.f184a.a(builder2.a(), a4, props.b, props.c, props.e)));
            }
        }
        return null;
    }

    public static ChannelFeedFromVideoLauncherPartDefinition m173a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ChannelFeedFromVideoLauncherPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f183g) {
                ChannelFeedFromVideoLauncherPartDefinition channelFeedFromVideoLauncherPartDefinition;
                if (a2 != null) {
                    channelFeedFromVideoLauncherPartDefinition = (ChannelFeedFromVideoLauncherPartDefinition) a2.a(f183g);
                } else {
                    channelFeedFromVideoLauncherPartDefinition = f182f;
                }
                if (channelFeedFromVideoLauncherPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m174b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f183g, b3);
                        } else {
                            f182f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = channelFeedFromVideoLauncherPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ChannelFeedFromVideoLauncherPartDefinition(LaunchChannelFeedClickListenerProvider launchChannelFeedClickListenerProvider, AutoplayStateManagerProvider autoplayStateManagerProvider, ChannelFeedEligibilityUtil channelFeedEligibilityUtil, GraphQLStoryUtil graphQLStoryUtil, Lazy<VideoZeroDialogPartDefinition> lazy) {
        this.f184a = launchChannelFeedClickListenerProvider;
        this.f185b = autoplayStateManagerProvider;
        this.f186c = channelFeedEligibilityUtil;
        this.f187d = graphQLStoryUtil;
        this.f188e = lazy;
    }

    private InlineVideoPersistentState m172a(FeedProps<GraphQLStoryAttachment> feedProps, E e) {
        FeedProps e2 = AttachmentProps.e(feedProps);
        return (InlineVideoPersistentState) ((HasPersistentState) e).a(new InlineVideoStoryKey(e2, GraphQLMediaConversionHelper.m236b(((GraphQLStoryAttachment) feedProps.a).r()), this.f185b), (CacheableEntity) e2.a);
    }
}
