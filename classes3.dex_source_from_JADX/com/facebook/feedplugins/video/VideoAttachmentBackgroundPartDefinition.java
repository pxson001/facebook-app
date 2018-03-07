package com.facebook.feedplugins.video;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.utils.CallToActionUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.videos.features.VideoViewCountChecker;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyleUtil;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feed.rows.styling.PositionResolver;
import com.facebook.feed.util.story.FeedStoryUtil;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.GraphQLStory;
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
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tablet.abtest.TabletExperimentConfiguration;
import com.facebook.video.videohome.abtest.ExperimentsForVideoHomeAbTestModule;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ufi/reactions/v2/16x16/yay */
public class VideoAttachmentBackgroundPartDefinition<E extends HasPositionInformation & HasPersistentState> extends BaseSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, View> {
    private static VideoAttachmentBackgroundPartDefinition f168k;
    private static final Object f169l = new Object();
    private final BackgroundPartDefinition f170a;
    private final VideoViewCountChecker f171b;
    private final DefaultPaddingStyleResolver f172c;
    private final PositionResolver f173d;
    private final FeedStoryUtil f174e;
    private final TabletExperimentConfiguration f175f;
    public final QeAccessor f176g;
    private final GatekeeperStoreImpl f177h;
    public final boolean f178i = this.f177h.a(482, false);
    private final FollowVideoHomeButtonVisibilityUtil f179j;

    private static VideoAttachmentBackgroundPartDefinition m163b(InjectorLike injectorLike) {
        return new VideoAttachmentBackgroundPartDefinition(BackgroundPartDefinition.a(injectorLike), VideoViewCountChecker.m166b(injectorLike), DefaultPaddingStyleResolver.a(injectorLike), TabletExperimentConfiguration.a(injectorLike), PositionResolver.a(injectorLike), FeedStoryUtil.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), FollowVideoHomeButtonVisibilityUtil.m170a(injectorLike));
    }

    public final Object m165a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Object a;
        FeedProps feedProps = (FeedProps) obj;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        if (this.f175f.a()) {
            a = m160a(feedProps);
        } else {
            a = m161a(feedProps, hasPositionInformation);
        }
        subParts.a(this.f170a, a);
        return null;
    }

    public static VideoAttachmentBackgroundPartDefinition m162a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoAttachmentBackgroundPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f169l) {
                VideoAttachmentBackgroundPartDefinition videoAttachmentBackgroundPartDefinition;
                if (a2 != null) {
                    videoAttachmentBackgroundPartDefinition = (VideoAttachmentBackgroundPartDefinition) a2.a(f169l);
                } else {
                    videoAttachmentBackgroundPartDefinition = f168k;
                }
                if (videoAttachmentBackgroundPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m163b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f169l, b3);
                        } else {
                            f168k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoAttachmentBackgroundPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public VideoAttachmentBackgroundPartDefinition(BackgroundPartDefinition backgroundPartDefinition, VideoViewCountChecker videoViewCountChecker, DefaultPaddingStyleResolver defaultPaddingStyleResolver, TabletExperimentConfiguration tabletExperimentConfiguration, PositionResolver positionResolver, FeedStoryUtil feedStoryUtil, QeAccessor qeAccessor, GatekeeperStoreImpl gatekeeperStoreImpl, FollowVideoHomeButtonVisibilityUtil followVideoHomeButtonVisibilityUtil) {
        this.f170a = backgroundPartDefinition;
        this.f171b = videoViewCountChecker;
        this.f172c = defaultPaddingStyleResolver;
        this.f175f = tabletExperimentConfiguration;
        this.f173d = positionResolver;
        this.f174e = feedStoryUtil;
        this.f176g = qeAccessor;
        this.f177h = gatekeeperStoreImpl;
        this.f179j = followVideoHomeButtonVisibilityUtil;
    }

    private StylingData m160a(FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        FeedProps e = AttachmentProps.e(feedProps);
        if (CallToActionUtil.k(graphQLStoryAttachment)) {
            return new StylingData(e, this.f172c.j());
        }
        if (m164b((FeedProps) feedProps)) {
            return new StylingData(e, PaddingStyle.b);
        }
        return new StylingData(e, PaddingStyle.f);
    }

    private StylingData m161a(FeedProps<GraphQLStoryAttachment> feedProps, E e) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        FeedProps e2 = AttachmentProps.e(feedProps);
        if (CallToActionUtil.k(graphQLStoryAttachment) || CallToActionUtil.h(graphQLStoryAttachment)) {
            return new StylingData(e2, this.f172c.j());
        }
        HasPersistentState hasPersistentState = (HasPersistentState) e;
        boolean z = false;
        boolean a = this.f176g.a(ExperimentsForVideoHomeAbTestModule.p, false);
        GraphQLStory c = AttachmentProps.c(feedProps);
        if (c != null) {
            z = FollowVideoHomeButtonVisibilityUtil.m171a(a, this.f178i, feedProps, (FollowVideosState) hasPersistentState.a(new FollowVideosKey(c), c));
        }
        if (z) {
            DefaultPaddingStyleResolver defaultPaddingStyleResolver = this.f172c;
            Builder c2 = Builder.c();
            c2.c = -defaultPaddingStyleResolver.e();
            return new StylingData(e2, c2.i());
        } else if (m164b((FeedProps) feedProps)) {
            if (this.f174e.d(feedProps) && this.f176g.a(ExperimentsForNewsFeedAbTestModule.ai, false)) {
                return new StylingData(e2, PaddingStyle.c);
            }
            return new StylingData(e2, PaddingStyle.g);
        } else if (!this.f174e.d(feedProps)) {
            return new StylingData(e2, PaddingStyle.f);
        } else {
            if (this.f176g.a(ExperimentsForNewsFeedAbTestModule.ai, false)) {
                return new StylingData(e2, BackgroundStyleUtil.a(feedProps, this.f173d, e));
            }
            return new StylingData(e2, PaddingStyle.f);
        }
    }

    private boolean m164b(FeedProps<GraphQLStoryAttachment> feedProps) {
        return this.f171b.m168a(feedProps);
    }
}
