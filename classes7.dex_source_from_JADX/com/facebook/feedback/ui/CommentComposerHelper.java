package com.facebook.feedback.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.api.ufiservices.common.GraphQLActorCacheImpl;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.inject.Inject;

/* compiled from: selectRouteInt */
public class CommentComposerHelper {
    public static final CallerContext f4190a = CallerContext.a(SingleLineCommentComposerView.class, "story_feedback_flyout");
    private final GraphQLActorCacheImpl f4191b;

    /* compiled from: selectRouteInt */
    public final class C03701 implements OnClickListener {
        final /* synthetic */ CommentComposerView f4189a;

        public C03701(CommentComposerView commentComposerView) {
            this.f4189a = commentComposerView;
        }

        public final void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -488296403);
            CommentComposerHelper.m4815a(this.f4189a);
            this.f4189a.setMediaItem(null);
            this.f4189a.mo253n();
            Logger.a(2, EntryType.UI_INPUT_END, 1106529579, a);
        }
    }

    public static CommentComposerHelper m4814a(InjectorLike injectorLike) {
        return new CommentComposerHelper(GraphQLActorCacheImpl.a(injectorLike));
    }

    @Inject
    public CommentComposerHelper(GraphQLActorCacheImpl graphQLActorCacheImpl) {
        this.f4191b = graphQLActorCacheImpl;
    }

    public static boolean m4816a(GraphQLFeedback graphQLFeedback) {
        return graphQLFeedback != null && graphQLFeedback.c();
    }

    public final boolean m4818b(GraphQLFeedback graphQLFeedback) {
        if (graphQLFeedback == null) {
            return false;
        }
        if (graphQLFeedback.O() == null || this.f4191b.a() == null || this.f4191b.a().b() == null || this.f4191b.a().b().g() != 2645995) {
            return graphQLFeedback.d();
        }
        return false;
    }

    public static boolean m4817d(GraphQLFeedback graphQLFeedback) {
        return graphQLFeedback != null && graphQLFeedback.x_();
    }

    public static void m4815a(CommentComposerView commentComposerView) {
        View selfAsView = commentComposerView.getSelfAsView();
        View findViewById = selfAsView.findViewById(2131558487);
        if (findViewById == null) {
            findViewById = selfAsView.findViewById(2131560438);
        }
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }
}
