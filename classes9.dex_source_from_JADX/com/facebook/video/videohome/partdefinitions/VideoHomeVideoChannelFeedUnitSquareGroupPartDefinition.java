package com.facebook.video.videohome.partdefinitions;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.protocol.graphql.ReactionConversionHelper;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.video.channelfeed.VideoHomePublisherInfoPartDefinition.Props;
import com.facebook.video.channelfeed.VideoHomePublisherInfoPartDefinition.Props.Builder;
import com.facebook.video.videohome.environment.CanKnowPosition;
import com.facebook.video.videohome.environment.HasShownVideosContainer;
import com.facebook.video.videohome.environment.ShownVideosContainer;
import com.facebook.video.videohome.views.VideoHomeLiveVideoHScrollComponentView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: signed_pre_key_record */
public class VideoHomeVideoChannelFeedUnitSquareGroupPartDefinition<E extends CanKnowPosition & HasShownVideosContainer> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, View> {
    public static final ViewType<View> f3237a = new C02991();
    private static VideoHomeVideoChannelFeedUnitSquareGroupPartDefinition f3238d;
    private static final Object f3239e = new Object();
    private final VideoHomeClippedPublisherInfoPartDefinition f3240b;
    private final VideoHomeVideoChannelFeedUnitSquareVideoPartDefinition f3241c;

    /* compiled from: signed_pre_key_record */
    final class C02991 extends ViewType<View> {
        C02991() {
        }

        public final View m3082a(Context context) {
            return new VideoHomeLiveVideoHScrollComponentView(context);
        }
    }

    private static VideoHomeVideoChannelFeedUnitSquareGroupPartDefinition m3085b(InjectorLike injectorLike) {
        return new VideoHomeVideoChannelFeedUnitSquareGroupPartDefinition(VideoHomeClippedPublisherInfoPartDefinition.m2910a(injectorLike), VideoHomeVideoChannelFeedUnitSquareVideoPartDefinition.m3090a(injectorLike));
    }

    private static void m3084a(ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        GraphQLStoryAttachment o = StoryAttachmentHelper.o(reactionUnitComponentNode.b.ax());
        ShownVideosContainer g = ((HasShownVideosContainer) e).g();
        g.f2832a.add(o.r().b());
    }

    public final Object m3087a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CanKnowPosition canKnowPosition = (CanKnowPosition) anyEnvironment;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.b;
        int a = canKnowPosition.a(reactionUnitComponentNode.c);
        GraphQLStory ax = reactionUnitComponentFields.ax();
        subParts.a(2131563199, this.f3241c, reactionUnitComponentNode);
        VideoHomeClippedPublisherInfoPartDefinition videoHomeClippedPublisherInfoPartDefinition = this.f3240b;
        Builder a2 = Props.m2585a(ax);
        a2.f2687c = false;
        a2 = a2;
        a2.f2688d = true;
        a2 = a2;
        a2.f2689e = 17170445;
        a2 = a2;
        a2.f2691g = ReactionConversionHelper.a(reactionUnitComponentFields.cf());
        Builder builder = a2;
        builder.f2692h = a;
        subParts.a(2131568415, videoHomeClippedPublisherInfoPartDefinition, builder.m2584a());
        return null;
    }

    public final /* bridge */ /* synthetic */ void m3088a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1993580606);
        m3084a((ReactionUnitComponentNode) obj, (CanKnowPosition) anyEnvironment);
        Logger.a(8, EntryType.MARK_POP, 1479253046, a);
    }

    public final boolean m3089a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        if (reactionUnitComponentFields != null) {
            GraphQLStory ax = reactionUnitComponentFields.ax();
            Object obj2 = null;
            if (ax != null) {
                GraphQLStoryAttachment o = StoryAttachmentHelper.o(ax);
                if (!(o == null || o.r() == null)) {
                    obj2 = 1;
                }
            }
            if (!(obj2 == null || reactionUnitComponentFields.ax().s() == GraphQLNegativeFeedbackActionType.HIDE)) {
                return true;
            }
        }
        return false;
    }

    @Inject
    public VideoHomeVideoChannelFeedUnitSquareGroupPartDefinition(VideoHomeClippedPublisherInfoPartDefinition videoHomeClippedPublisherInfoPartDefinition, VideoHomeVideoChannelFeedUnitSquareVideoPartDefinition videoHomeVideoChannelFeedUnitSquareVideoPartDefinition) {
        this.f3241c = videoHomeVideoChannelFeedUnitSquareVideoPartDefinition;
        this.f3240b = videoHomeClippedPublisherInfoPartDefinition;
    }

    public static VideoHomeVideoChannelFeedUnitSquareGroupPartDefinition m3083a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeVideoChannelFeedUnitSquareGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3239e) {
                VideoHomeVideoChannelFeedUnitSquareGroupPartDefinition videoHomeVideoChannelFeedUnitSquareGroupPartDefinition;
                if (a2 != null) {
                    videoHomeVideoChannelFeedUnitSquareGroupPartDefinition = (VideoHomeVideoChannelFeedUnitSquareGroupPartDefinition) a2.a(f3239e);
                } else {
                    videoHomeVideoChannelFeedUnitSquareGroupPartDefinition = f3238d;
                }
                if (videoHomeVideoChannelFeedUnitSquareGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3085b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3239e, b3);
                        } else {
                            f3238d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeVideoChannelFeedUnitSquareGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m3086a() {
        return f3237a;
    }
}
