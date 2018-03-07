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
/* compiled from: single_recipient=' */
public class VideoHomeSeeMorePartDefinition<E extends HasContext & HasReactionSessionId> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, View> {
    public static final ViewType<View> f3156a = ViewType.a(2130907725);
    private static VideoHomeSeeMorePartDefinition f3157g;
    private static final Object f3158h = new Object();
    private final TextPartDefinition f3159b;
    private final VideoHomeBadgeWithTextAndFacepilePartDefinition f3160c;
    private final ChannelFeedGenericLauncherPartDefinition f3161d;
    private final ChannelFeedHeaderParamsFactory f3162e;
    public final VideoHomeSessionManager f3163f;

    /* compiled from: single_recipient=' */
    public class C02971 implements FullscreenTransitionListener {
        final /* synthetic */ VideoHomeSeeMorePartDefinition f3155a;

        public C02971(VideoHomeSeeMorePartDefinition videoHomeSeeMorePartDefinition) {
            this.f3155a = videoHomeSeeMorePartDefinition;
        }

        public final void m3004a(ExitFullScreenResult exitFullScreenResult) {
            if (this.f3155a.f3163f.g() && this.f3155a.f3163f.i()) {
                this.f3155a.f3163f.c();
            }
        }
    }

    private static VideoHomeSeeMorePartDefinition m3007b(InjectorLike injectorLike) {
        return new VideoHomeSeeMorePartDefinition(TextPartDefinition.a(injectorLike), VideoHomeBadgeWithTextAndFacepilePartDefinition.m2902a(injectorLike), ChannelFeedGenericLauncherPartDefinition.m2243a(injectorLike), ChannelFeedHeaderParamsFactory.m2263a(injectorLike), VideoHomeSessionManager.a(injectorLike));
    }

    public final Object m3009a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        HasContext hasContext = (HasContext) anyEnvironment;
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        MessageModel messageModel = (MessageModel) Preconditions.checkNotNull(reactionUnitComponentFields.bv());
        Resources resources = hasContext.getContext().getResources();
        subParts.a(2131558927, this.f3159b, messageModel.a());
        subParts.a(2131568413, this.f3160c, new Props(reactionUnitComponentFields, Float.valueOf(resources.getDimension(2131431519)), Integer.valueOf(resources.getDimensionPixelSize(2131431520)), Integer.valueOf(resources.getDimensionPixelSize(2131431521))));
        subParts.a(this.f3161d, new ChannelFeedGenericLauncherPartDefinition.Props(m3005a(reactionUnitComponentFields.v().ad(), hasContext), new AtomicReference(new C02971(this)), null));
        return null;
    }

    public final boolean m3010a(Object obj) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        GraphQLReactionUnitComponentStyle a = reactionUnitComponentNode.b.a();
        ReactionStoryAttachmentActionFragmentModel v = reactionUnitComponentNode.b.v();
        return (a != GraphQLReactionUnitComponentStyle.VIDEO_HOME_SEE_MORE || v == null || v.ad() == null) ? false : true;
    }

    public static VideoHomeSeeMorePartDefinition m3006a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeSeeMorePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3158h) {
                VideoHomeSeeMorePartDefinition videoHomeSeeMorePartDefinition;
                if (a2 != null) {
                    videoHomeSeeMorePartDefinition = (VideoHomeSeeMorePartDefinition) a2.a(f3158h);
                } else {
                    videoHomeSeeMorePartDefinition = f3157g;
                }
                if (videoHomeSeeMorePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3007b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3158h, b3);
                        } else {
                            f3157g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeSeeMorePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public VideoHomeSeeMorePartDefinition(TextPartDefinition textPartDefinition, VideoHomeBadgeWithTextAndFacepilePartDefinition videoHomeBadgeWithTextAndFacepilePartDefinition, ChannelFeedGenericLauncherPartDefinition channelFeedGenericLauncherPartDefinition, ChannelFeedHeaderParamsFactory channelFeedHeaderParamsFactory, VideoHomeSessionManager videoHomeSessionManager) {
        this.f3159b = textPartDefinition;
        this.f3160c = videoHomeBadgeWithTextAndFacepilePartDefinition;
        this.f3161d = channelFeedGenericLauncherPartDefinition;
        this.f3162e = channelFeedHeaderParamsFactory;
        this.f3163f = videoHomeSessionManager;
    }

    public final ViewType<View> m3008a() {
        return f3156a;
    }

    private ChannelFeedParams m3005a(VideoChannel videoChannel, E e) {
        String a;
        String a2;
        Builder builder = new Builder();
        ChannelFeedHeaderParamsFactory channelFeedHeaderParamsFactory = this.f3162e;
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
