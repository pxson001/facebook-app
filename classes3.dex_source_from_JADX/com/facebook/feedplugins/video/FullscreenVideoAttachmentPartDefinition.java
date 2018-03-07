package com.facebook.feedplugins.video;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.videos.ui.FullscreenVideoAttachmentView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.autoplay.AutoplayStateManagerProvider;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasScrollListenerSupport;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.attachments.video.FullscreenTransitionListener;
import com.facebook.feedplugins.attachments.video.FullscreenVideoCoverPartDefinition;
import com.facebook.feedplugins.attachments.video.InlineVideoPersistentState;
import com.facebook.feedplugins.attachments.video.InlineVideoStoryKey;
import com.facebook.feedplugins.attachments.video.VideoAttachmentDelegate;
import com.facebook.feedplugins.attachments.video.VideoAttachmentDelegateProvider;
import com.facebook.feedplugins.attachments.video.VideoAttachmentProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.video.channelfeed.ChannelFeedFromVideoLauncherPartDefinition;
import com.facebook.video.channelfeed.ChannelFeedFromVideoLauncherPartDefinition.Props;
import com.facebook.video.feed.FeedVideoPlayerParamBuilderProvider;
import com.google.common.base.Absent;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ufi/reactions/v2/16x16/anger */
public class FullscreenVideoAttachmentPartDefinition<E extends HasFeedListType & HasPositionInformation & HasPrefetcher & HasScrollListenerSupport & HasPersistentState> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, FullscreenVideoAttachmentView> {
    public static final ViewType f219a = new C00051();
    private static FullscreenVideoAttachmentPartDefinition f220j;
    private static final Object f221k = new Object();
    private final VideoAttachmentBackgroundPartDefinition<E> f222b;
    private final FeedVideoPlayerParamBuilderProvider f223c;
    private final LogFullscreenVideoDisplayedPartDefinition<E> f224d;
    private final PlayFullscreenVideoPartDefinition<E> f225e;
    private final FullscreenVideoCoverPartDefinition<E> f226f;
    private final VideoAttachmentDelegateProvider f227g;
    private final ChannelFeedFromVideoLauncherPartDefinition f228h;
    private final AutoplayStateManagerProvider f229i;

    /* compiled from: ufi/reactions/v2/16x16/anger */
    final class C00051 extends ViewType {
        C00051() {
        }

        public final View m207a(Context context) {
            return new FullscreenVideoAttachmentView(context);
        }
    }

    private static FullscreenVideoAttachmentPartDefinition m203b(InjectorLike injectorLike) {
        return new FullscreenVideoAttachmentPartDefinition(LogFullscreenVideoDisplayedPartDefinition.m126a(injectorLike), PlayFullscreenVideoPartDefinition.m132a(injectorLike), FullscreenVideoCoverPartDefinition.m209a(injectorLike), (VideoAttachmentDelegateProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoAttachmentDelegateProvider.class), (FeedVideoPlayerParamBuilderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedVideoPlayerParamBuilderProvider.class), VideoAttachmentBackgroundPartDefinition.m162a(injectorLike), ChannelFeedFromVideoLauncherPartDefinition.m173a(injectorLike), (AutoplayStateManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AutoplayStateManagerProvider.class));
    }

    public final Object m205a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        HasFeedListType hasFeedListType = (HasFeedListType) anyEnvironment;
        VideoAttachmentDelegate a = this.f227g.a(feedProps, Absent.INSTANCE);
        VideoAttachmentProps videoAttachmentProps = new VideoAttachmentProps(a, this.f223c.m86a(feedProps, a.e));
        subParts.a(this.f222b, feedProps);
        subParts.a(this.f224d, videoAttachmentProps);
        subParts.a(this.f225e, videoAttachmentProps);
        subParts.a(this.f226f, videoAttachmentProps);
        subParts.a(this.f228h, new Props(feedProps, m201a(feedProps, hasFeedListType)));
        return null;
    }

    public static FullscreenVideoAttachmentPartDefinition m200a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FullscreenVideoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f221k) {
                FullscreenVideoAttachmentPartDefinition fullscreenVideoAttachmentPartDefinition;
                if (a2 != null) {
                    fullscreenVideoAttachmentPartDefinition = (FullscreenVideoAttachmentPartDefinition) a2.a(f221k);
                } else {
                    fullscreenVideoAttachmentPartDefinition = f220j;
                }
                if (fullscreenVideoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m203b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f221k, b3);
                        } else {
                            f220j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = fullscreenVideoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public FullscreenVideoAttachmentPartDefinition(LogFullscreenVideoDisplayedPartDefinition logFullscreenVideoDisplayedPartDefinition, PlayFullscreenVideoPartDefinition playFullscreenVideoPartDefinition, FullscreenVideoCoverPartDefinition fullscreenVideoCoverPartDefinition, VideoAttachmentDelegateProvider videoAttachmentDelegateProvider, FeedVideoPlayerParamBuilderProvider feedVideoPlayerParamBuilderProvider, VideoAttachmentBackgroundPartDefinition videoAttachmentBackgroundPartDefinition, ChannelFeedFromVideoLauncherPartDefinition channelFeedFromVideoLauncherPartDefinition, AutoplayStateManagerProvider autoplayStateManagerProvider) {
        this.f224d = logFullscreenVideoDisplayedPartDefinition;
        this.f225e = playFullscreenVideoPartDefinition;
        this.f226f = fullscreenVideoCoverPartDefinition;
        this.f227g = videoAttachmentDelegateProvider;
        this.f223c = feedVideoPlayerParamBuilderProvider;
        this.f222b = videoAttachmentBackgroundPartDefinition;
        this.f228h = channelFeedFromVideoLauncherPartDefinition;
        this.f229i = autoplayStateManagerProvider;
    }

    public final ViewType m204a() {
        return f219a;
    }

    public final boolean m206a(Object obj) {
        return true;
    }

    private AtomicReference<FullscreenTransitionListener> m201a(FeedProps<GraphQLStoryAttachment> feedProps, E e) {
        return new AtomicReference(new 2(this, m202b(feedProps, e).b()));
    }

    private InlineVideoPersistentState m202b(FeedProps<GraphQLStoryAttachment> feedProps, E e) {
        FeedProps e2 = AttachmentProps.e(feedProps);
        return (InlineVideoPersistentState) ((HasPersistentState) e).a(new InlineVideoStoryKey(e2, GraphQLMediaConversionHelper.m236b(((GraphQLStoryAttachment) feedProps.a).r()), this.f229i), (CacheableEntity) e2.a);
    }
}
