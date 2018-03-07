package com.facebook.feedplugins.video;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.utils.CallToActionUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.video.RichVideoPlayerPartDefinition.Props;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.watchandbrowse.VideoWatchAndBrowseLauncherPartDefinition;
import com.facebook.video.watchandbrowse.VideoWatchAndBrowseLauncherPartDefinitionProvider;
import com.facebook.video.watchandbrowse.WatchAndMoreType;
import com.facebook.video.watchandbrowse.abtest.ExperimentsForVideoWatchAndBrowseAbTestModule;
import com.facebook.video.watchandshop.WatchAndShopUtil;
import com.facebook.video.watchandshop.abtest.ExperimentsForWatchAndShopAbTestModule;
import com.google.common.base.Absent;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

@ContextScoped
/* compiled from: metadata.json */
public class RichVideoDirectResponseAttachmentPartDefinition<E extends CanShowVideoInFullScreen & HasPositionInformation & HasFeedListType & HasPersistentState & HasInvalidate & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, RichVideoAttachmentView> {
    public static final ViewType<RichVideoAttachmentView> f238a = new C00071();
    private static RichVideoDirectResponseAttachmentPartDefinition f239h;
    private static final Object f240i = new Object();
    private final VideoAttachmentBackgroundPartDefinition<E> f241b;
    private final RichVideoPlayerPartDefinition<E, RichVideoAttachmentView> f242c;
    private final InlineVideoAttachmentPartDefinition<FeedEnvironment> f243d;
    private final VideoWatchAndBrowseLauncherPartDefinitionProvider f244e;
    private final QeAccessor f245f;
    private final WatchAndShopUtil f246g;

    /* compiled from: metadata.json */
    final class C00071 extends ViewType<RichVideoAttachmentView> {
        C00071() {
        }

        public final View m224a(Context context) {
            return new RichVideoAttachmentView(context);
        }
    }

    private static RichVideoDirectResponseAttachmentPartDefinition m219b(InjectorLike injectorLike) {
        return new RichVideoDirectResponseAttachmentPartDefinition(VideoAttachmentBackgroundPartDefinition.m162a(injectorLike), RichVideoPlayerPartDefinition.m43a(injectorLike), InlineVideoAttachmentPartDefinition.m153a(injectorLike), (VideoWatchAndBrowseLauncherPartDefinitionProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoWatchAndBrowseLauncherPartDefinitionProvider.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), WatchAndShopUtil.m226a(injectorLike));
    }

    public final Object m222a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        boolean z;
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f241b, feedProps);
        AtomicReference atomicReference = new AtomicReference();
        subParts.a(this.f242c, new Props(feedProps, -1, Absent.INSTANCE, atomicReference));
        WatchAndShopUtil watchAndShopUtil = this.f246g;
        if (feedProps == null || feedProps.a == null) {
            z = false;
        } else {
            GraphQLStoryActionLink a = ActionLinkHelper.a((GraphQLStoryAttachment) feedProps.a, -508788748);
            z = (a == null || a.aI() == null || a.aI().isEmpty()) ? false : watchAndShopUtil.f249a.a(ExperimentsForWatchAndShopAbTestModule.a, false);
        }
        if (z) {
            subParts.a(this.f244e.m225a(WatchAndMoreType.WATCH_AND_SHOP), new VideoWatchAndBrowseLauncherPartDefinition.Props(feedProps, atomicReference));
        } else if (m220b(feedProps)) {
            subParts.a(this.f244e.m225a(WatchAndMoreType.WATCH_AND_BROWSE), new VideoWatchAndBrowseLauncherPartDefinition.Props(feedProps, atomicReference));
        }
        return null;
    }

    public final boolean m223a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        return this.f243d.m157a(feedProps) && (CallToActionUtil.n(graphQLStoryAttachment) || CallToActionUtil.d(graphQLStoryAttachment));
    }

    public static RichVideoDirectResponseAttachmentPartDefinition m218a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RichVideoDirectResponseAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f240i) {
                RichVideoDirectResponseAttachmentPartDefinition richVideoDirectResponseAttachmentPartDefinition;
                if (a2 != null) {
                    richVideoDirectResponseAttachmentPartDefinition = (RichVideoDirectResponseAttachmentPartDefinition) a2.a(f240i);
                } else {
                    richVideoDirectResponseAttachmentPartDefinition = f239h;
                }
                if (richVideoDirectResponseAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m219b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f240i, b3);
                        } else {
                            f239h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = richVideoDirectResponseAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public RichVideoDirectResponseAttachmentPartDefinition(VideoAttachmentBackgroundPartDefinition videoAttachmentBackgroundPartDefinition, RichVideoPlayerPartDefinition richVideoPlayerPartDefinition, InlineVideoAttachmentPartDefinition inlineVideoAttachmentPartDefinition, VideoWatchAndBrowseLauncherPartDefinitionProvider videoWatchAndBrowseLauncherPartDefinitionProvider, QeAccessor qeAccessor, WatchAndShopUtil watchAndShopUtil) {
        this.f241b = videoAttachmentBackgroundPartDefinition;
        this.f242c = richVideoPlayerPartDefinition;
        this.f243d = inlineVideoAttachmentPartDefinition;
        this.f244e = videoWatchAndBrowseLauncherPartDefinitionProvider;
        this.f245f = qeAccessor;
        this.f246g = watchAndShopUtil;
    }

    public final ViewType m221a() {
        return f238a;
    }

    private boolean m220b(FeedProps<GraphQLStoryAttachment> feedProps) {
        if (feedProps.a == null) {
            return false;
        }
        GraphQLStoryActionLink a = ActionLinkHelper.a((GraphQLStoryAttachment) feedProps.a, -508788748);
        if (a != null && a.p()) {
            Object obj = null;
            if (a != null) {
                GraphQLCallToActionType W = a.W();
                if (W.equals(GraphQLCallToActionType.INSTALL_MOBILE_APP) || W.equals(GraphQLCallToActionType.INSTALL_APP) || W.equals(GraphQLCallToActionType.PLAY_GAME)) {
                    obj = 1;
                }
            }
            if (obj == null) {
                return this.f245f.a(ExperimentsForVideoWatchAndBrowseAbTestModule.a, false);
            }
        }
        return false;
    }
}
