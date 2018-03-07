package com.facebook.feedback.ui.rows;

import android.content.Context;
import android.net.Uri;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.attachments.ui.AttachmentViewVideo;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.autoplay.DefaultVideoAutoplayManager;
import com.facebook.feed.autoplay.VideoViewController;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.feedback.ui.environment.CommentsEnvironment;
import com.facebook.feedback.ui.rows.CommentStylingPartDefinition.Props;
import com.facebook.feedback.ui.rows.views.CommentRowPadding;
import com.facebook.feedback.ui.rows.views.CommentVideoView;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.engine.VideoDataSource;
import com.facebook.video.engine.VideoDataSourceBuilder;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPlayerParamsBuilder;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.RichVideoPlayerParams.Builder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ridge_interstitial */
public class CommentVideoAttachmentPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, CommentsEnvironment, CommentVideoView> {
    public static final ViewType f5039a = new C04951();
    private static CommentVideoAttachmentPartDefinition f5040g;
    private static final Object f5041h = new Object();
    private final CommentStylingPartDefinition f5042b;
    public final QeAccessor f5043c;
    public final DefaultVideoAutoplayManager<CommentVideoView> f5044d;
    public final DefaultFeedIntentBuilder f5045e;
    public final SecureContextHelper f5046f;

    /* compiled from: ridge_interstitial */
    final class C04951 extends ViewType {
        C04951() {
        }

        public final View m5520a(Context context) {
            return new CommentVideoView(new ContextThemeWrapper(context, 2131625248));
        }
    }

    /* compiled from: ridge_interstitial */
    public class State {
        public final VideoViewController<CommentVideoView> f5036a;
        public final RichVideoPlayerParams f5037b;
        public final OnClickListener f5038c;

        public State(VideoViewController<CommentVideoView> videoViewController, RichVideoPlayerParams richVideoPlayerParams, OnClickListener onClickListener) {
            this.f5036a = videoViewController;
            this.f5037b = richVideoPlayerParams;
            this.f5038c = onClickListener;
        }
    }

    private static CommentVideoAttachmentPartDefinition m5525b(InjectorLike injectorLike) {
        return new CommentVideoAttachmentPartDefinition(CommentStylingPartDefinition.m5508a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), DefaultVideoAutoplayManager.a(injectorLike), DefaultFeedIntentBuilder.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    public final Object m5527a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        C04962 c04962;
        C04973 c04973;
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f5042b, new Props(CommentLevel.THREADED.equals(CommentLevel.getCommentLevelFromAttachment(feedProps)) ? CommentRowPadding.THREADED_PROFILE_PICTURE_OFFSET : CommentRowPadding.PROFILE_PICTURE_OFFSET));
        final GraphQLMedia r = ((GraphQLStoryAttachment) feedProps.a).r();
        if (r != null) {
            c04962 = new VideoViewController<CommentVideoView>(this, r.b()) {
                final /* synthetic */ CommentVideoAttachmentPartDefinition f5033a;

                public final void m5521a(Object obj) {
                    ((CommentVideoView) obj).f1010c.b(EventTriggerType.BY_AUTOPLAY);
                }

                public final void m5522b(Object obj) {
                    ((CommentVideoView) obj).f1010c.a(EventTriggerType.BY_AUTOPLAY);
                }
            };
        } else {
            c04962 = null;
        }
        VideoViewController videoViewController = c04962;
        RichVideoPlayerParams a = m5524a(r);
        if (r == null) {
            c04973 = null;
        } else {
            c04973 = new OnClickListener(this) {
                final /* synthetic */ CommentVideoAttachmentPartDefinition f5035b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 209265538);
                    if (r.aO() != null) {
                        DefaultFeedIntentBuilder defaultFeedIntentBuilder = this.f5035b.f5045e;
                        Long.parseLong(r.b());
                        this.f5035b.f5046f.a(defaultFeedIntentBuilder.c(r.aO()), view.getContext());
                    }
                    Logger.a(2, EntryType.UI_INPUT_END, 861972313, a);
                }
            };
        }
        return new State(videoViewController, a, c04973);
    }

    public final /* bridge */ /* synthetic */ void m5528a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -996634439);
        State state = (State) obj2;
        CommentVideoView commentVideoView = (CommentVideoView) view;
        commentVideoView.m987a((FeedProps) obj);
        commentVideoView.f1010c.a(state.f5037b);
        commentVideoView.setOnClickListener(state.f5038c);
        if (this.f5043c.a(ExperimentsForFeedbackTestModule.af, false)) {
            this.f5044d.a(commentVideoView, state.f5036a);
        }
        Logger.a(8, EntryType.MARK_POP, 2083927140, a);
    }

    public final boolean m5529a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        return (((GraphQLStoryAttachment) feedProps.a).r() == null || ((GraphQLStoryAttachment) feedProps.a).r().S() == null) ? false : true;
    }

    public final void m5530b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        CommentVideoView commentVideoView = (CommentVideoView) view;
        commentVideoView.setOnClickListener(null);
        commentVideoView.f1010c.g();
    }

    public static CommentVideoAttachmentPartDefinition m5523a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommentVideoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5041h) {
                CommentVideoAttachmentPartDefinition commentVideoAttachmentPartDefinition;
                if (a2 != null) {
                    commentVideoAttachmentPartDefinition = (CommentVideoAttachmentPartDefinition) a2.a(f5041h);
                } else {
                    commentVideoAttachmentPartDefinition = f5040g;
                }
                if (commentVideoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5525b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5041h, b3);
                        } else {
                            f5040g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = commentVideoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public CommentVideoAttachmentPartDefinition(CommentStylingPartDefinition commentStylingPartDefinition, QeAccessor qeAccessor, DefaultVideoAutoplayManager defaultVideoAutoplayManager, DefaultFeedIntentBuilder defaultFeedIntentBuilder, SecureContextHelper secureContextHelper) {
        this.f5042b = commentStylingPartDefinition;
        this.f5043c = qeAccessor;
        this.f5044d = defaultVideoAutoplayManager;
        this.f5045e = defaultFeedIntentBuilder;
        this.f5046f = secureContextHelper;
    }

    public final ViewType<CommentVideoView> m5526a() {
        return f5039a;
    }

    private static RichVideoPlayerParams m5524a(GraphQLMedia graphQLMedia) {
        ImageRequest imageRequest;
        float a = AttachmentViewVideo.m980a(graphQLMedia.bo(), graphQLMedia.R());
        Uri parse = graphQLMedia.aO() == null ? null : Uri.parse(graphQLMedia.aO());
        VideoDataSourceBuilder newBuilder = VideoDataSource.newBuilder();
        newBuilder.a = parse;
        VideoDataSourceBuilder videoDataSourceBuilder = newBuilder;
        videoDataSourceBuilder.f = StreamSourceType.FROM_STREAM;
        VideoPlayerParamsBuilder a2 = VideoPlayerParams.newBuilder().a(videoDataSourceBuilder.i());
        a2.g = graphQLMedia.am();
        a2 = a2;
        a2.q = graphQLMedia.ax();
        a2 = a2;
        a2.n = false;
        a2 = a2;
        Builder builder = new Builder();
        builder.a = a2.m();
        Builder a3 = builder.a("VideoAspectRatioKey", Double.valueOf((double) a));
        String str = "CoverImageParamsKey";
        if (graphQLMedia == null || graphQLMedia.S() == null || graphQLMedia.S().b() == null) {
            imageRequest = null;
        } else {
            imageRequest = ImageRequest.a(graphQLMedia.S().b());
        }
        return a3.a(str, imageRequest).b();
    }
}
