package com.facebook.video.videohome.partdefinitions;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedplugins.attachments.video.FullscreenTransitionListener;
import com.facebook.graphql.calls.EntryPointInputVideoChannelEntryPoint;
import com.facebook.graphql.enums.GraphQLReactionStoryActionStyle;
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
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentFieldsModel.MessageModel;
import com.facebook.video.analytics.VideoAnalytics.ClickTarget;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.channelfeed.ChannelFeedGenericLauncherPartDefinition;
import com.facebook.video.channelfeed.ChannelFeedParams.Builder;
import com.facebook.video.channelfeed.LaunchChannelFeedClickListener.OnLaunchCallback;
import com.facebook.video.engine.ExitFullScreenResult;
import com.facebook.video.videohome.environment.CanKnowPosition;
import com.facebook.video.videohome.logging.VideoHomeChannelLoggingData;
import com.facebook.video.videohome.logging.VideoHomeLoggingUtils;
import com.facebook.video.videohome.partdefinitions.VideoHomeBadgeWithTextAndFacepilePartDefinition.Props;
import com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager;
import com.google.common.base.Preconditions;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

@ContextScoped
/* compiled from: size= */
public class VideoHomeSectionHeaderPartDefinition<E extends CanKnowPosition> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, View> {
    public static final ViewType<View> f3147a = ViewType.a(2130907724);
    private static VideoHomeSectionHeaderPartDefinition f3148g;
    private static final Object f3149h = new Object();
    private final ChannelFeedGenericLauncherPartDefinition f3150b;
    private final TextPartDefinition f3151c;
    private final VideoHomeBadgeWithTextAndFacepilePartDefinition f3152d;
    public final VideoHomeSessionManager f3153e;
    public final VideoHomeLoggingUtils f3154f;

    /* compiled from: size= */
    public class C02962 implements FullscreenTransitionListener {
        final /* synthetic */ VideoHomeSectionHeaderPartDefinition f3146a;

        public C02962(VideoHomeSectionHeaderPartDefinition videoHomeSectionHeaderPartDefinition) {
            this.f3146a = videoHomeSectionHeaderPartDefinition;
        }

        public final void m2997a(ExitFullScreenResult exitFullScreenResult) {
            if (this.f3146a.f3153e.g() && this.f3146a.f3153e.i()) {
                this.f3146a.f3153e.c();
            }
        }
    }

    private static VideoHomeSectionHeaderPartDefinition m3000b(InjectorLike injectorLike) {
        return new VideoHomeSectionHeaderPartDefinition(ChannelFeedGenericLauncherPartDefinition.m2243a(injectorLike), TextPartDefinition.a(injectorLike), VideoHomeBadgeWithTextAndFacepilePartDefinition.m2902a(injectorLike), VideoHomeSessionManager.a(injectorLike), VideoHomeLoggingUtils.a(injectorLike));
    }

    public static boolean m2999a(ReactionUnitComponentNode reactionUnitComponentNode) {
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.b;
        return (reactionUnitComponentFields.a() != GraphQLReactionUnitComponentStyle.VIDEO_HOME_SECTION_HEADER || reactionUnitComponentFields == null || reactionUnitComponentFields.bv() == null) ? false : true;
    }

    public final Object m3002a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CanKnowPosition canKnowPosition = (CanKnowPosition) anyEnvironment;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.b;
        subParts.a(2131558927, this.f3151c, ((MessageModel) Preconditions.checkNotNull(reactionUnitComponentFields.bv())).a());
        subParts.a(2131568413, this.f3152d, new Props(reactionUnitComponentFields));
        ReactionStoryAttachmentActionFragmentModel v = reactionUnitComponentFields.v();
        if (v == null || v.j() != GraphQLReactionStoryActionStyle.OPEN_VIDEO_CHANNEL) {
            subParts.a(2131568433, this.f3151c, "");
        } else {
            Preconditions.checkNotNull(v.ad());
            Preconditions.checkNotNull(v.fU_());
            subParts.a(2131568433, this.f3151c, v.fU_().a());
            final String b = v.ad().b();
            final int a = canKnowPosition.a(reactionUnitComponentNode.c);
            Builder a2 = new Builder().a(b);
            a2.d = EntryPointInputVideoChannelEntryPoint.VIDEO_HOME;
            a2 = a2;
            a2.h = EventTriggerType.BY_USER;
            a2 = a2;
            a2.g = PlayerOrigin.VIDEO_HOME;
            subParts.a(2131568433, this.f3150b, new ChannelFeedGenericLauncherPartDefinition.Props(a2.a(), new AtomicReference(new C02962(this)), new OnLaunchCallback(this) {
                final /* synthetic */ VideoHomeSectionHeaderPartDefinition f3145d;

                public final void m2996a() {
                    if (this.f3145d.f3153e.g()) {
                        VideoHomeLoggingUtils videoHomeLoggingUtils = this.f3145d.f3154f;
                        PlayerOrigin playerOrigin = PlayerOrigin.VIDEO_HOME;
                        ClickTarget clickTarget = ClickTarget.SEE_MORE_BUTTON;
                        VideoHomeChannelLoggingData.Builder builder = new VideoHomeChannelLoggingData.Builder();
                        builder.a = b;
                        builder = builder;
                        builder.b = reactionUnitComponentNode.d;
                        builder = builder;
                        builder.c = a;
                        videoHomeLoggingUtils.a(playerOrigin, clickTarget, builder.a());
                    }
                }
            }));
        }
        return null;
    }

    @Inject
    public VideoHomeSectionHeaderPartDefinition(ChannelFeedGenericLauncherPartDefinition channelFeedGenericLauncherPartDefinition, TextPartDefinition textPartDefinition, VideoHomeBadgeWithTextAndFacepilePartDefinition videoHomeBadgeWithTextAndFacepilePartDefinition, VideoHomeSessionManager videoHomeSessionManager, VideoHomeLoggingUtils videoHomeLoggingUtils) {
        this.f3150b = channelFeedGenericLauncherPartDefinition;
        this.f3151c = textPartDefinition;
        this.f3152d = videoHomeBadgeWithTextAndFacepilePartDefinition;
        this.f3153e = videoHomeSessionManager;
        this.f3154f = videoHomeLoggingUtils;
    }

    public static VideoHomeSectionHeaderPartDefinition m2998a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeSectionHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3149h) {
                VideoHomeSectionHeaderPartDefinition videoHomeSectionHeaderPartDefinition;
                if (a2 != null) {
                    videoHomeSectionHeaderPartDefinition = (VideoHomeSectionHeaderPartDefinition) a2.a(f3149h);
                } else {
                    videoHomeSectionHeaderPartDefinition = f3148g;
                }
                if (videoHomeSectionHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3000b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3149h, b3);
                        } else {
                            f3148g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeSectionHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<View> m3001a() {
        return f3147a;
    }
}
