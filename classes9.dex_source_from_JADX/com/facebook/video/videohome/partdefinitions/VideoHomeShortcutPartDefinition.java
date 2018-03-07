package com.facebook.video.videohome.partdefinitions;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedplugins.attachments.video.FullscreenTransitionListener;
import com.facebook.graphql.calls.EntryPointInputVideoChannelEntryPoint;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionOpenVideoChannelFields.VideoChannel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentFieldsModel.MessageModel;
import com.facebook.topics.protocol.TopicFavoritesQueryModels.VideoTopicFragmentModel;
import com.facebook.topics.protocol.TopicFavoritesQueryModels.VideoTopicFragmentModel.SquareHeaderImageModel;
import com.facebook.topics.protocol.TopicFavoritesQueryModels.VideoTopicFragmentModel.VideoChannelSubtitleModel;
import com.facebook.topics.protocol.TopicFavoritesQueryModels.VideoTopicFragmentModel.VideoChannelTitleModel;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.channelfeed.ChannelFeedGenericLauncherPartDefinition;
import com.facebook.video.channelfeed.ChannelFeedHeaderParamsFactory;
import com.facebook.video.channelfeed.ChannelFeedParams;
import com.facebook.video.channelfeed.ChannelFeedParams.Builder;
import com.facebook.video.engine.ExitFullScreenResult;
import com.facebook.video.videohome.environment.HasReactionSessionId;
import com.facebook.video.videohome.partdefinitions.VideoHomeBadgeWithTextAndFacepilePartDefinition.Props;
import com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager;
import com.google.common.base.Preconditions;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

@ContextScoped
/* compiled from: single_recipient in ( */
public class VideoHomeShortcutPartDefinition<E extends HasContext & HasReactionSessionId> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, View> {
    public static final ViewType<View> f3165a = ViewType.a(2130907726);
    private static VideoHomeShortcutPartDefinition f3166g;
    private static final Object f3167h = new Object();
    private final TextPartDefinition f3168b;
    private final VideoHomeBadgeWithTextAndFacepilePartDefinition f3169c;
    private final ChannelFeedGenericLauncherPartDefinition f3170d;
    private final ChannelFeedHeaderParamsFactory f3171e;
    public final VideoHomeSessionManager f3172f;

    /* compiled from: single_recipient in ( */
    public class C02981 implements FullscreenTransitionListener {
        final /* synthetic */ VideoHomeShortcutPartDefinition f3164a;

        public C02981(VideoHomeShortcutPartDefinition videoHomeShortcutPartDefinition) {
            this.f3164a = videoHomeShortcutPartDefinition;
        }

        public final void m3011a(ExitFullScreenResult exitFullScreenResult) {
            if (this.f3164a.f3172f.g() && this.f3164a.f3172f.i()) {
                this.f3164a.f3172f.c();
            }
        }
    }

    private static VideoHomeShortcutPartDefinition m3014b(InjectorLike injectorLike) {
        return new VideoHomeShortcutPartDefinition(TextPartDefinition.a(injectorLike), VideoHomeBadgeWithTextAndFacepilePartDefinition.m2902a(injectorLike), ChannelFeedGenericLauncherPartDefinition.m2243a(injectorLike), ChannelFeedHeaderParamsFactory.m2263a(injectorLike), VideoHomeSessionManager.a(injectorLike));
    }

    public final Object m3016a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        HasContext hasContext = (HasContext) anyEnvironment;
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        subParts.a(2131558927, this.f3168b, ((MessageModel) Preconditions.checkNotNull(reactionUnitComponentFields.bv())).a());
        Resources resources = hasContext.getContext().getResources();
        subParts.a(2131568413, this.f3169c, new Props(reactionUnitComponentFields, Float.valueOf(resources.getDimension(2131431516)), Integer.valueOf(resources.getDimensionPixelSize(2131431517)), Integer.valueOf(resources.getDimensionPixelSize(2131431518))));
        subParts.a(this.f3170d, new ChannelFeedGenericLauncherPartDefinition.Props(m3012a(reactionUnitComponentFields.v().ad(), hasContext), new AtomicReference(new C02981(this)), null));
        return null;
    }

    public final boolean m3017a(Object obj) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        GraphQLReactionUnitComponentStyle a = reactionUnitComponentNode.b.a();
        ReactionStoryAttachmentActionFragmentModel v = reactionUnitComponentNode.b.v();
        return (a != GraphQLReactionUnitComponentStyle.VIDEO_HOME_SHORTCUT || v == null || v.ad() == null) ? false : true;
    }

    public static VideoHomeShortcutPartDefinition m3013a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeShortcutPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3167h) {
                VideoHomeShortcutPartDefinition videoHomeShortcutPartDefinition;
                if (a2 != null) {
                    videoHomeShortcutPartDefinition = (VideoHomeShortcutPartDefinition) a2.a(f3167h);
                } else {
                    videoHomeShortcutPartDefinition = f3166g;
                }
                if (videoHomeShortcutPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3014b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3167h, b3);
                        } else {
                            f3166g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeShortcutPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public VideoHomeShortcutPartDefinition(TextPartDefinition textPartDefinition, VideoHomeBadgeWithTextAndFacepilePartDefinition videoHomeBadgeWithTextAndFacepilePartDefinition, ChannelFeedGenericLauncherPartDefinition channelFeedGenericLauncherPartDefinition, ChannelFeedHeaderParamsFactory channelFeedHeaderParamsFactory, VideoHomeSessionManager videoHomeSessionManager) {
        this.f3168b = textPartDefinition;
        this.f3169c = videoHomeBadgeWithTextAndFacepilePartDefinition;
        this.f3170d = channelFeedGenericLauncherPartDefinition;
        this.f3171e = channelFeedHeaderParamsFactory;
        this.f3172f = videoHomeSessionManager;
    }

    public final ViewType<View> m3015a() {
        return f3165a;
    }

    private ChannelFeedParams m3012a(VideoChannel videoChannel, E e) {
        String a;
        String a2;
        Builder builder = new Builder();
        ChannelFeedHeaderParamsFactory channelFeedHeaderParamsFactory = this.f3171e;
        VideoTopicFragmentModel videoTopicFragmentModel = null;
        String a3 = videoChannel.d() != null ? videoChannel.d().a() : null;
        if (videoChannel.j() != null) {
            a = videoChannel.j().a();
        } else {
            a = null;
        }
        if (videoChannel.fg_() != null) {
            a2 = videoChannel.fg_().a();
        } else {
            a2 = null;
        }
        if (!(a3 == null && a == null)) {
            VideoTopicFragmentModel.Builder builder2 = new VideoTopicFragmentModel.Builder();
            builder2.a = videoChannel.b();
            builder2 = builder2;
            VideoChannelTitleModel.Builder builder3 = new VideoChannelTitleModel.Builder();
            builder3.a = a;
            builder2.h = builder3.a();
            builder2 = builder2;
            VideoChannelSubtitleModel.Builder builder4 = new VideoChannelSubtitleModel.Builder();
            builder4.a = a2;
            builder2.g = builder4.a();
            builder2 = builder2;
            builder2.e = videoChannel.g();
            builder2 = builder2;
            SquareHeaderImageModel.Builder builder5 = new SquareHeaderImageModel.Builder();
            builder5.a = a3;
            builder2.c = builder5.a();
            VideoTopicFragmentModel.Builder builder6 = builder2;
            builder6.b = videoChannel.c();
            videoTopicFragmentModel = builder6.a();
        }
        builder.k = channelFeedHeaderParamsFactory.m2265a(videoTopicFragmentModel, ((HasReactionSessionId) e).kL_());
        builder = builder.a(videoChannel.b());
        builder.d = EntryPointInputVideoChannelEntryPoint.VIDEO_HOME;
        builder = builder;
        builder.h = EventTriggerType.BY_USER;
        builder = builder;
        builder.g = PlayerOrigin.VIDEO_HOME;
        return builder.a();
    }
}
