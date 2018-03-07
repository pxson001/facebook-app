package com.facebook.feedplugins.richmedia;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition;
import com.facebook.feed.rows.sections.attachments.linkshare.AngoraAttachmentBackgroundPartDefinition;
import com.facebook.feedplugins.richmedia.RichMediaVideoAutoplayPartDefinition.Props;
import com.facebook.feedplugins.richmedia.abtest.ExperimentsForRichMediaAbTestModule;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.imagepipeline.request.ImageRequest;
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
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.feed.FeedVideoPlayerParamBuilderProvider;
import com.facebook.video.player.RichVideoPlayerParams;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: buttonClicked */
public class RichMediaVideoAttachmentPartDefinition<E extends HasPersistentState & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, VideoPlayerParams, E, RichMediaVideoAttachmentView> {
    public static final ViewType f9216a = new C11131();
    private static RichMediaVideoAttachmentPartDefinition f9217j;
    private static final Object f9218k = new Object();
    private final RichMediaVideoDimensionsPartDefinition f9219b;
    private final RichMediaVideoAutoplayPartDefinition f9220c;
    private final RichMediaTapPromptPartDefinition<?> f9221d;
    private final FeedVideoPlayerParamBuilderProvider f9222e;
    private final AttachmentLinkPartDefinition f9223f;
    private final AngoraAttachmentBackgroundPartDefinition f9224g;
    private final RichMediaAttachmentEdgeToEdgeBackgroundPartDefinition f9225h;
    public final QeAccessor f9226i;

    /* compiled from: buttonClicked */
    final class C11131 extends ViewType {
        C11131() {
        }

        public final View m9872a(Context context) {
            return new RichMediaVideoAttachmentView(context);
        }
    }

    private static RichMediaVideoAttachmentPartDefinition m9875b(InjectorLike injectorLike) {
        return new RichMediaVideoAttachmentPartDefinition(RichMediaVideoDimensionsPartDefinition.m9889a(injectorLike), RichMediaVideoAutoplayPartDefinition.m9883a(injectorLike), RichMediaTapPromptPartDefinition.m9869a(injectorLike), (FeedVideoPlayerParamBuilderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedVideoPlayerParamBuilderProvider.class), AttachmentLinkPartDefinition.a(injectorLike), AngoraAttachmentBackgroundPartDefinition.a(injectorLike), RichMediaAttachmentEdgeToEdgeBackgroundPartDefinition.m9833a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m9877a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        VideoPlayerParams a = this.f9222e.a(feedProps, GraphQLMediaConversionHelper.b(graphQLStoryAttachment.r())).a();
        subParts.a(this.f9219b, graphQLStoryAttachment);
        if (AttachmentProps.c(feedProps) != null) {
            subParts.a(this.f9220c, new Props(a.b, AttachmentProps.c(feedProps)));
        }
        subParts.a(this.f9221d, feedProps);
        subParts.a(this.f9223f, new AttachmentLinkPartDefinition.Props(feedProps));
        if (this.f9226i.a(ExperimentsForRichMediaAbTestModule.f9253b, false)) {
            subParts.a(this.f9225h, feedProps);
        } else {
            subParts.a(this.f9224g, feedProps);
        }
        return a;
    }

    public final /* bridge */ /* synthetic */ void m9878a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 657843219);
        m9874a((FeedProps) obj, (VideoPlayerParams) obj2, (RichMediaVideoAttachmentView) view);
        Logger.a(8, EntryType.MARK_POP, 1223750902, a);
    }

    public final boolean m9879a(Object obj) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ((FeedProps) obj).a;
        return (graphQLStoryAttachment.r() == null || graphQLStoryAttachment.r().j() == null || graphQLStoryAttachment.r().j().g() != 82650203) ? false : true;
    }

    public static RichMediaVideoAttachmentPartDefinition m9873a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RichMediaVideoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9218k) {
                RichMediaVideoAttachmentPartDefinition richMediaVideoAttachmentPartDefinition;
                if (a2 != null) {
                    richMediaVideoAttachmentPartDefinition = (RichMediaVideoAttachmentPartDefinition) a2.a(f9218k);
                } else {
                    richMediaVideoAttachmentPartDefinition = f9217j;
                }
                if (richMediaVideoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9875b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9218k, b3);
                        } else {
                            f9217j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = richMediaVideoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public RichMediaVideoAttachmentPartDefinition(RichMediaVideoDimensionsPartDefinition richMediaVideoDimensionsPartDefinition, RichMediaVideoAutoplayPartDefinition richMediaVideoAutoplayPartDefinition, RichMediaTapPromptPartDefinition richMediaTapPromptPartDefinition, FeedVideoPlayerParamBuilderProvider feedVideoPlayerParamBuilderProvider, AttachmentLinkPartDefinition attachmentLinkPartDefinition, AngoraAttachmentBackgroundPartDefinition angoraAttachmentBackgroundPartDefinition, RichMediaAttachmentEdgeToEdgeBackgroundPartDefinition richMediaAttachmentEdgeToEdgeBackgroundPartDefinition, QeAccessor qeAccessor) {
        this.f9219b = richMediaVideoDimensionsPartDefinition;
        this.f9220c = richMediaVideoAutoplayPartDefinition;
        this.f9221d = richMediaTapPromptPartDefinition;
        this.f9222e = feedVideoPlayerParamBuilderProvider;
        this.f9223f = attachmentLinkPartDefinition;
        this.f9224g = angoraAttachmentBackgroundPartDefinition;
        this.f9225h = richMediaAttachmentEdgeToEdgeBackgroundPartDefinition;
        this.f9226i = qeAccessor;
    }

    public final ViewType m9876a() {
        return f9216a;
    }

    private static void m9874a(FeedProps<GraphQLStoryAttachment> feedProps, VideoPlayerParams videoPlayerParams, RichMediaVideoAttachmentView richMediaVideoAttachmentView) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        boolean z = (videoPlayerParams == null || graphQLStoryAttachment == null || graphQLStoryAttachment.r() == null || graphQLStoryAttachment.r().j() == null || graphQLStoryAttachment.r().j().g() != 82650203) ? false : true;
        Preconditions.checkArgument(z);
        if (!(videoPlayerParams.b == null || videoPlayerParams.b.equals(richMediaVideoAttachmentView.f9237h))) {
            ImageRequest imageRequest;
            richMediaVideoAttachmentView.f9237h = videoPlayerParams.b;
            richMediaVideoAttachmentView.f9236g = richMediaVideoAttachmentView.f9230a.c(feedProps, 0.0f);
            Builder b = new Builder().b("GraphQLStoryProps", AttachmentProps.e(feedProps));
            String str = "CoverImageParamsKey";
            Preconditions.checkNotNull(graphQLStoryAttachment);
            if (graphQLStoryAttachment.r() == null || !GraphQLStoryAttachmentUtil.p(graphQLStoryAttachment) || graphQLStoryAttachment.r().S() == null) {
                imageRequest = null;
            } else {
                imageRequest = ImageRequest.a(graphQLStoryAttachment.r().S().b());
            }
            ImmutableMap b2 = b.b(str, imageRequest).b("VideoAspectRatioKey", Double.valueOf(richMediaVideoAttachmentView.f9236g)).b("SubtitlesLocalesKey", graphQLStoryAttachment.r().bl()).b();
            RichVideoPlayerParams.Builder builder = new RichVideoPlayerParams.Builder();
            builder.a = videoPlayerParams;
            RichVideoPlayerParams b3 = builder.a(b2).b();
            richMediaVideoAttachmentView.f9231b.g();
            richMediaVideoAttachmentView.f9231b.a(b3);
        }
        richMediaVideoAttachmentView.f9233d.setText(((GraphQLStoryAttachment) feedProps.a).A());
    }
}
