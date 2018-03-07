package com.facebook.feedplugins.video;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.videos.VideoViewCountPartDefinition;
import com.facebook.feed.rows.sections.attachments.videos.VideoViewCountTextPartDefinition;
import com.facebook.feed.rows.sections.attachments.videos.features.VideoViewCountChecker;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.graphqlstory.footer.ui.VideoPlayCountView;
import com.facebook.feedplugins.graphqlstory.footer.util.CrosspostedVideoViewCountTooltipUtil;
import com.facebook.graphql.model.GraphQLStoryAttachment;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: TV;>; */
public class VideoAttachmentViewCountPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, OnClickListener, HasPositionInformation, VideoPlayCountView> {
    private static VideoAttachmentViewCountPartDefinition f341e;
    private static final Object f342f = new Object();
    private final VideoViewCountChecker f343a;
    private final BackgroundPartDefinition f344b;
    private final VideoViewCountTextPartDefinition f345c;
    private final CrosspostedVideoViewCountTooltipUtil f346d;

    private static VideoAttachmentViewCountPartDefinition m305b(InjectorLike injectorLike) {
        return new VideoAttachmentViewCountPartDefinition(VideoViewCountChecker.m166b(injectorLike), BackgroundPartDefinition.a(injectorLike), VideoViewCountTextPartDefinition.m311a(injectorLike), CrosspostedVideoViewCountTooltipUtil.m314a(injectorLike));
    }

    public final Object m307a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f344b, new StylingData(AttachmentProps.e(feedProps), PaddingStyle.e));
        subParts.a(2131568294, this.f345c, feedProps.a);
        return this.f346d.m317a((GraphQLStoryAttachment) feedProps.a);
    }

    public final /* bridge */ /* synthetic */ void m308a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -346390723);
        OnClickListener onClickListener = (OnClickListener) obj2;
        VideoPlayCountView videoPlayCountView = (VideoPlayCountView) view;
        if (!(onClickListener == null || videoPlayCountView.a == null)) {
            videoPlayCountView.a.setOnClickListener(onClickListener);
        }
        Logger.a(8, EntryType.MARK_POP, 194107200, a);
    }

    public final boolean m309a(Object obj) {
        return this.f343a.m168a((FeedProps) obj);
    }

    public final void m310b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        VideoPlayCountView videoPlayCountView = (VideoPlayCountView) view;
        if (((OnClickListener) obj2) != null && videoPlayCountView.a != null) {
            videoPlayCountView.a.setOnClickListener(null);
        }
    }

    @Inject
    public VideoAttachmentViewCountPartDefinition(VideoViewCountChecker videoViewCountChecker, BackgroundPartDefinition backgroundPartDefinition, VideoViewCountTextPartDefinition videoViewCountTextPartDefinition, CrosspostedVideoViewCountTooltipUtil crosspostedVideoViewCountTooltipUtil) {
        this.f343a = videoViewCountChecker;
        this.f344b = backgroundPartDefinition;
        this.f345c = videoViewCountTextPartDefinition;
        this.f346d = crosspostedVideoViewCountTooltipUtil;
    }

    public final ViewType m306a() {
        return VideoViewCountPartDefinition.a;
    }

    public static VideoAttachmentViewCountPartDefinition m304a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoAttachmentViewCountPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f342f) {
                VideoAttachmentViewCountPartDefinition videoAttachmentViewCountPartDefinition;
                if (a2 != null) {
                    videoAttachmentViewCountPartDefinition = (VideoAttachmentViewCountPartDefinition) a2.a(f342f);
                } else {
                    videoAttachmentViewCountPartDefinition = f341e;
                }
                if (videoAttachmentViewCountPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m305b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f342f, b3);
                        } else {
                            f341e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoAttachmentViewCountPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
