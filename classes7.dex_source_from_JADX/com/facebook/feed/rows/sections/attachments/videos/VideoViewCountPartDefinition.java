package com.facebook.feed.rows.sections.attachments.videos;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.videos.features.VideoViewCountChecker;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.graphqlstory.footer.ui.VideoPlayCountView;
import com.facebook.feedplugins.graphqlstory.footer.util.CrosspostedVideoViewCountTooltipUtil;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
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
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Updated comment must have a non null feedback */
public class VideoViewCountPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, OnClickListener, HasPositionInformation, VideoPlayCountView> {
    public static final ViewType f21114a = new C17921();
    private static VideoViewCountPartDefinition f21115f;
    private static final Object f21116g = new Object();
    private final VideoViewCountChecker f21117b;
    private final BackgroundPartDefinition f21118c;
    private final VideoViewCountTextPartDefinition f21119d;
    private final CrosspostedVideoViewCountTooltipUtil f21120e;

    /* compiled from: Updated comment must have a non null feedback */
    final class C17921 extends ViewType {
        C17921() {
        }

        public final View m23982a(Context context) {
            return new VideoPlayCountView(context);
        }
    }

    private static VideoViewCountPartDefinition m23985b(InjectorLike injectorLike) {
        return new VideoViewCountPartDefinition(VideoViewCountChecker.b(injectorLike), BackgroundPartDefinition.a(injectorLike), VideoViewCountTextPartDefinition.a(injectorLike), CrosspostedVideoViewCountTooltipUtil.a(injectorLike));
    }

    public final Object m23987a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment a = m23984a((GraphQLStory) feedProps.a);
        subParts.a(this.f21118c, new StylingData(feedProps, PaddingStyle.e));
        subParts.a(2131568294, this.f21119d, a);
        return this.f21120e.a(a);
    }

    public final /* bridge */ /* synthetic */ void m23988a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 549268770);
        OnClickListener onClickListener = (OnClickListener) obj2;
        VideoPlayCountView videoPlayCountView = (VideoPlayCountView) view;
        if (!(onClickListener == null || videoPlayCountView.f23326a == null)) {
            videoPlayCountView.f23326a.setOnClickListener(onClickListener);
        }
        Logger.a(8, EntryType.MARK_POP, 1236685912, a);
    }

    public final boolean m23989a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        VideoViewCountChecker videoViewCountChecker = this.f21117b;
        FeedProps c = FeedProps.c(m23984a((GraphQLStory) feedProps.a));
        boolean z = VideoViewCountChecker.c(c) && videoViewCountChecker.a.i(AttachmentProps.e(c)) == 0;
        return z;
    }

    public final void m23990b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        VideoPlayCountView videoPlayCountView = (VideoPlayCountView) view;
        if (((OnClickListener) obj2) != null && videoPlayCountView.f23326a != null) {
            videoPlayCountView.f23326a.setOnClickListener(null);
        }
    }

    @Inject
    public VideoViewCountPartDefinition(VideoViewCountChecker videoViewCountChecker, BackgroundPartDefinition backgroundPartDefinition, VideoViewCountTextPartDefinition videoViewCountTextPartDefinition, CrosspostedVideoViewCountTooltipUtil crosspostedVideoViewCountTooltipUtil) {
        this.f21117b = videoViewCountChecker;
        this.f21118c = backgroundPartDefinition;
        this.f21119d = videoViewCountTextPartDefinition;
        this.f21120e = crosspostedVideoViewCountTooltipUtil;
    }

    public static VideoViewCountPartDefinition m23983a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoViewCountPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21116g) {
                VideoViewCountPartDefinition videoViewCountPartDefinition;
                if (a2 != null) {
                    videoViewCountPartDefinition = (VideoViewCountPartDefinition) a2.a(f21116g);
                } else {
                    videoViewCountPartDefinition = f21115f;
                }
                if (videoViewCountPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23985b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21116g, b3);
                        } else {
                            f21115f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoViewCountPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m23986a() {
        return f21114a;
    }

    private static GraphQLStoryAttachment m23984a(GraphQLStory graphQLStory) {
        if (!StoryAttachmentHelper.a(graphQLStory)) {
            return null;
        }
        ImmutableList M = graphQLStory.M();
        int size = M.size();
        for (int i = 0; i < size; i++) {
            GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) M.get(i);
            if (GraphQLStoryAttachmentUtil.d(graphQLStoryAttachment)) {
                return graphQLStoryAttachment;
            }
        }
        return null;
    }
}
