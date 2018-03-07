package com.facebook.feedback.ui;

import android.text.SpannableStringBuilder;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.api.ufiservices.common.CommentLoadDirection;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.feedback.ui.CommentView.NavigationListener;
import com.facebook.feedback.ui.LoadMoreCommentsView.Listener;
import com.facebook.feedback.ui.environment.CommentDelegateActionListener;
import com.facebook.feedback.ui.environment.CommentNavigationDelegateListener;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.inject.Assisted;
import com.facebook.notifications.logging.NotificationsLogger.NotificationLogObject;
import com.facebook.qe.api.QeAccessor;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: scrubber_moves */
public class DefaultCommentAdapter extends FbBaseAdapter implements SingleSegmentCommentAdapter {
    private static final String f4390a = DefaultCommentAdapter.class.getSimpleName();
    public GraphQLFeedback f4391b;
    private CommentOrderType f4392c;
    private CommentOrderDelegate f4393d;
    private FeedbackLoggingParams f4394e;
    private CommentDelegateActionListener f4395f;
    private NavigationListener f4396g;
    private Listener f4397h;
    private Listener f4398i;
    private AbstractFbErrorReporter f4399j;
    private final boolean f4400k;
    private Set<String> f4401l = new HashSet();
    private Map<String, SpannableStringBuilder> f4402m = new HashMap();

    /* compiled from: scrubber_moves */
    interface CommentOrderDelegate {
        int mo203a(int i);

        Object mo204b(int i);
    }

    /* compiled from: scrubber_moves */
    class DefaultOrderDelegate implements CommentOrderDelegate {
        final /* synthetic */ DefaultCommentAdapter f4388a;

        public DefaultOrderDelegate(DefaultCommentAdapter defaultCommentAdapter) {
            this.f4388a = defaultCommentAdapter;
        }

        public final int mo203a(int i) {
            if (GraphQLHelper.j(this.f4388a.f4391b) && DefaultCommentAdapter.m4994c(this.f4388a, i)) {
                return RowType.LOAD_BEFORE.ordinal();
            }
            if (GraphQLHelper.k(this.f4388a.f4391b) && DefaultCommentAdapter.m4992a(this.f4388a, i)) {
                return RowType.LOAD_AFTER.ordinal();
            }
            if (DefaultCommentAdapter.m4994c(this.f4388a, i)) {
                return RowType.COMMENT_BOTTOM.ordinal();
            }
            return RowType.COMMENT_MIDDLE.ordinal();
        }

        public final Object mo204b(int i) {
            if ((GraphQLHelper.j(this.f4388a.f4391b) && DefaultCommentAdapter.m4994c(this.f4388a, i)) || (GraphQLHelper.k(this.f4388a.f4391b) && DefaultCommentAdapter.m4992a(this.f4388a, i))) {
                return null;
            }
            return GraphQLHelper.a(this.f4388a.f4391b, (GraphQLHelper.g(this.f4388a.f4391b) - (GraphQLHelper.k(this.f4388a.f4391b) ? 0 : 1)) - i);
        }
    }

    /* compiled from: scrubber_moves */
    class RankedOrderDelegate implements CommentOrderDelegate {
        final /* synthetic */ DefaultCommentAdapter f4389a;

        public RankedOrderDelegate(DefaultCommentAdapter defaultCommentAdapter) {
            this.f4389a = defaultCommentAdapter;
        }

        public final int mo203a(int i) {
            if (GraphQLHelper.j(this.f4389a.f4391b) && DefaultCommentAdapter.m4992a(this.f4389a, i)) {
                return RowType.LOAD_BEFORE.ordinal();
            }
            if (GraphQLHelper.k(this.f4389a.f4391b) && DefaultCommentAdapter.m4994c(this.f4389a, i)) {
                return RowType.LOAD_AFTER.ordinal();
            }
            if (DefaultCommentAdapter.m4994c(this.f4389a, i)) {
                return RowType.COMMENT_BOTTOM.ordinal();
            }
            return RowType.COMMENT_MIDDLE.ordinal();
        }

        public final Object mo204b(int i) {
            if ((GraphQLHelper.j(this.f4389a.f4391b) && DefaultCommentAdapter.m4992a(this.f4389a, i)) || (GraphQLHelper.k(this.f4389a.f4391b) && DefaultCommentAdapter.m4994c(this.f4389a, i))) {
                return null;
            }
            return GraphQLHelper.a(this.f4389a.f4391b, i - (GraphQLHelper.j(this.f4389a.f4391b) ? 1 : 0));
        }
    }

    @VisibleForTesting
    /* compiled from: scrubber_moves */
    public enum RowType {
        LOAD_BEFORE,
        LOAD_AFTER,
        COMMENT_MIDDLE,
        COMMENT_BOTTOM
    }

    public final void mo198a(Object obj) {
        GraphQLFeedback graphQLFeedback;
        FeedProps feedProps = (FeedProps) obj;
        if (feedProps != null) {
            graphQLFeedback = (GraphQLFeedback) feedProps.a;
        } else {
            graphQLFeedback = null;
        }
        this.f4391b = graphQLFeedback;
        this.f4395f.f4816b = this.f4391b;
        this.f4396g.mo198a(this.f4391b);
        m4990a(CommentOrderType.getOrder(this.f4391b));
        AdapterDetour.a(this, 105780533);
    }

    @Inject
    public DefaultCommentAdapter(@Assisted BaseCommentNavigationDelegate baseCommentNavigationDelegate, CommentDelegate commentDelegate, AbstractFbErrorReporter abstractFbErrorReporter, final LoadMoreCommentsController loadMoreCommentsController, QeAccessor qeAccessor) {
        m4990a(CommentOrderType.DEFAULT_ORDER);
        this.f4395f = new CommentDelegateActionListener(commentDelegate);
        this.f4397h = new Listener(this) {
            final /* synthetic */ DefaultCommentAdapter f4384b;

            public final void mo202a() {
                loadMoreCommentsController.m5153a(this.f4384b.f4391b, CommentLoadDirection.LOAD_AFTER);
            }
        };
        this.f4398i = new Listener(this) {
            final /* synthetic */ DefaultCommentAdapter f4386b;

            public final void mo202a() {
                loadMoreCommentsController.m5153a(this.f4386b.f4391b, CommentLoadDirection.LOAD_BEFORE);
            }
        };
        this.f4396g = new CommentNavigationDelegateListener(baseCommentNavigationDelegate);
        this.f4399j = abstractFbErrorReporter;
        this.f4400k = qeAccessor.a(ExperimentsForFeedbackTestModule.a, false);
    }

    public int getViewTypeCount() {
        return RowType.values().length;
    }

    public int getItemViewType(int i) {
        return this.f4393d.mo203a(i);
    }

    public final View m4995a(int i, ViewGroup viewGroup) {
        RowType rowType = RowType.values()[i];
        Preconditions.checkElementIndex(rowType.ordinal(), RowType.values().length);
        switch (rowType) {
            case LOAD_AFTER:
            case LOAD_BEFORE:
                return LayoutInflater.from(new ContextThemeWrapper(viewGroup.getContext(), 2131625248)).inflate(2130905105, viewGroup, false);
            case COMMENT_BOTTOM:
            case COMMENT_MIDDLE:
                return LayoutInflater.from(new ContextThemeWrapper(viewGroup.getContext(), 2131625248)).inflate(2130903636, viewGroup, false);
            default:
                this.f4399j.b(f4390a, "Unexpected CommentView itemViewType: " + i + " RowType: " + rowType);
                return new CommentView(viewGroup.getContext());
        }
    }

    public final void m4997a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        Object obj2 = 1;
        RowType rowType = RowType.values()[i2];
        Object obj3 = (this.f4400k && m4994c(this, i)) ? 1 : null;
        switch (rowType) {
            case LOAD_AFTER:
                m4989a(view);
                if (obj3 == null || GraphQLHelper.j(this.f4391b)) {
                    obj2 = null;
                    break;
                }
            case LOAD_BEFORE:
                m4993b(view);
                if (obj3 == null || GraphQLHelper.k(this.f4391b)) {
                    obj2 = null;
                    break;
                }
            case COMMENT_BOTTOM:
            case COMMENT_MIDDLE:
                m4991a(obj, view);
                break;
        }
        obj2 = obj3;
        if (obj2 != null) {
            view.callOnClick();
        }
    }

    public Object getItem(int i) {
        if (this.f4391b == null) {
            return null;
        }
        return this.f4393d.mo204b(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getCount() {
        int i = 1;
        if (this.f4391b == null) {
            return 0;
        }
        int i2 = GraphQLHelper.k(this.f4391b) ? 1 : 0;
        if (!GraphQLHelper.j(this.f4391b)) {
            i = 0;
        }
        return (i2 + i) + GraphQLHelper.g(this.f4391b);
    }

    public final GraphQLComment mo205a(int i) {
        Object item = getItem(i);
        if (item instanceof GraphQLComment) {
            return (GraphQLComment) item;
        }
        return null;
    }

    public final void mo208a(String str) {
        this.f4401l.add(str);
    }

    public final void mo206a(FeedbackLoggingParams feedbackLoggingParams) {
        this.f4394e = feedbackLoggingParams;
        this.f4395f.m5349a(feedbackLoggingParams);
    }

    public final void mo207a(NotificationLogObject notificationLogObject) {
        this.f4395f.f4815a.f4249z = notificationLogObject;
    }

    private void m4990a(CommentOrderType commentOrderType) {
        if (this.f4392c != commentOrderType) {
            this.f4392c = commentOrderType;
            this.f4393d = commentOrderType == CommentOrderType.RANKED_ORDER ? new RankedOrderDelegate(this) : new DefaultOrderDelegate(this);
        }
    }

    private void m4989a(View view) {
        LoadMoreCommentsView loadMoreCommentsView = (LoadMoreCommentsView) view;
        loadMoreCommentsView.m5162a(this.f4392c, CommentLoadDirection.LOAD_AFTER);
        loadMoreCommentsView.f4615i = this.f4397h;
    }

    private void m4993b(View view) {
        LoadMoreCommentsView loadMoreCommentsView = (LoadMoreCommentsView) view;
        loadMoreCommentsView.m5162a(this.f4392c, CommentLoadDirection.LOAD_BEFORE);
        loadMoreCommentsView.f4615i = this.f4398i;
    }

    private void m4991a(Object obj, View view) {
        CommentView commentView = (CommentView) view;
        GraphQLComment graphQLComment = (GraphQLComment) obj;
        commentView.m4938a(FeedProps.c(graphQLComment), this.f4394e, this.f4392c, this.f4402m);
        commentView.m4939a(this.f4395f, this.f4396g);
        if (this.f4401l.contains(graphQLComment.y())) {
            this.f4401l.remove(graphQLComment.y());
            commentView.m4946f();
        }
    }

    static /* synthetic */ boolean m4992a(DefaultCommentAdapter defaultCommentAdapter, int i) {
        return i == 0;
    }

    public static boolean m4994c(DefaultCommentAdapter defaultCommentAdapter, int i) {
        return i == defaultCommentAdapter.getCount() + -1;
    }
}
