package com.facebook.feed.permalink;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.api.ufiservices.FetchSingleCommentParams;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.ui.Bindable;
import com.facebook.feedback.ui.CommentDelegate;
import com.facebook.feedback.ui.CommentView;
import com.facebook.feedback.ui.CommentView.NavigationListener;
import com.facebook.feedback.ui.environment.CommentDelegateActionListener;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLFeedback.Builder;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: admin_tapped_promote */
public class ThreadedCommentsPermalinkAdapter extends FbBaseAdapter implements Bindable<FeedProps<GraphQLComment>> {
    private static final String f19650a = ThreadedCommentsPermalinkAdapter.class.getSimpleName();
    private CommentDelegateActionListener f19651b;
    private NavigationListener f19652c;
    private AbstractFbErrorReporter f19653d;
    private FeedbackLoggingParams f19654e;
    private final FetchSingleCommentParams f19655f;
    private FeedProps<GraphQLComment> f19656g;
    public int f19657h;
    private CommentOrderType f19658i;
    private Map<String, SpannableStringBuilder> f19659j = new HashMap();

    @VisibleForTesting
    /* compiled from: admin_tapped_promote */
    public enum RowType {
        COMMENT_TOP,
        COMMENT_MIDDLE,
        COMMENT_BOTTOM,
        COMMENT_SINGLE,
        ESCAPE_HATCH
    }

    @Inject
    public ThreadedCommentsPermalinkAdapter(@Assisted FetchSingleCommentParams fetchSingleCommentParams, @Assisted NavigationListener navigationListener, @Assisted FeedbackLoggingParams feedbackLoggingParams, CommentDelegate commentDelegate, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f19654e = feedbackLoggingParams;
        this.f19655f = fetchSingleCommentParams;
        this.f19651b = new CommentDelegateActionListener(commentDelegate);
        this.f19651b.m5349a(feedbackLoggingParams);
        this.f19652c = navigationListener;
        this.f19653d = abstractFbErrorReporter;
        Builder builder = new Builder();
        builder.A = this.f19655f.b;
        GraphQLFeedback a = builder.a();
        this.f19658i = CommentOrderType.getOrder(a);
        this.f19651b.f4816b = a;
        this.f19652c.mo198a(a);
    }

    private static boolean m22921a(GraphQLComment graphQLComment, FetchSingleCommentParams fetchSingleCommentParams) {
        return (fetchSingleCommentParams.d == null || fetchSingleCommentParams.e == null || graphQLComment.E() == null || TextUtils.isEmpty(graphQLComment.E().a())) ? false : true;
    }

    public int getViewTypeCount() {
        return RowType.values().length;
    }

    public int getItemViewType(int i) {
        if (this.f19656g == null || ((GraphQLComment) this.f19656g.a).l() == null) {
            return RowType.COMMENT_SINGLE.ordinal();
        }
        GraphQLComment graphQLComment = (GraphQLComment) this.f19656g.a;
        Object obj = GraphQLHelper.g(graphQLComment.l()) > 0 ? 1 : null;
        if (!m22921a(graphQLComment, this.f19655f)) {
            return obj != null ? RowType.COMMENT_TOP.ordinal() : RowType.COMMENT_SINGLE.ordinal();
        } else {
            if (i == 0) {
                return RowType.ESCAPE_HATCH.ordinal();
            }
            if (obj != null) {
                return RowType.COMMENT_MIDDLE.ordinal();
            }
            return RowType.COMMENT_BOTTOM.ordinal();
        }
    }

    public final View m22923a(int i, ViewGroup viewGroup) {
        RowType rowType = RowType.values()[i];
        Preconditions.checkElementIndex(rowType.ordinal(), RowType.values().length);
        switch (rowType) {
            case COMMENT_SINGLE:
            case COMMENT_TOP:
            case COMMENT_MIDDLE:
            case COMMENT_BOTTOM:
                Context contextThemeWrapper;
                Context context = viewGroup.getContext();
                if (this.f19657h != 0) {
                    contextThemeWrapper = new ContextThemeWrapper(context, this.f19657h);
                } else {
                    contextThemeWrapper = context;
                }
                return LayoutInflater.from(new ContextThemeWrapper(contextThemeWrapper, 2131625248)).inflate(2130903636, viewGroup, false);
            case ESCAPE_HATCH:
                return LayoutInflater.from(viewGroup.getContext()).inflate(2130907397, viewGroup, false);
            default:
                this.f19653d.b(f19650a, "Unexpected CommentView itemViewType: " + i + " RowType: " + rowType);
                return new CommentView(viewGroup.getContext());
        }
    }

    public final void m22924a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        switch (RowType.values()[i2]) {
            case ESCAPE_HATCH:
                m22922b(obj, view);
                return;
            default:
                m22920a(obj, view);
                return;
        }
    }

    public Object getItem(int i) {
        return this.f19656g;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getCount() {
        if (this.f19656g == null) {
            return 0;
        }
        return m22921a((GraphQLComment) this.f19656g.a, this.f19655f) ? 2 : 1;
    }

    public final void m22925a(FeedProps<GraphQLComment> feedProps) {
        this.f19656g = feedProps;
        AdapterDetour.a(this, 1924327825);
    }

    private void m22920a(Object obj, View view) {
        CommentView commentView = (CommentView) view;
        FeedProps feedProps = (FeedProps) obj;
        commentView.f4314I = false;
        commentView.m4938a(feedProps, this.f19654e, this.f19658i, this.f19659j);
        commentView.m4939a(this.f19651b, this.f19652c);
    }

    private void m22922b(Object obj, View view) {
        ((CommentPermalinkEscapeHatchView) view).m22861a((GraphQLComment) ((FeedProps) obj).a, this.f19655f);
    }
}
