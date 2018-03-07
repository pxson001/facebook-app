package com.facebook.feedback.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.feed.rows.adapter.DelegatingMultiRowAdapter;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.ui.environment.BaseCommentsEnvironment;
import com.facebook.feedback.ui.rows.RootProps;
import com.facebook.feedback.ui.rows.TopLevelCommentGroupPartDefinition.Props;
import com.facebook.feedback.ui.rows.views.HighlightableView;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.notifications.logging.NotificationsLogger.NotificationLogObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: routes */
public class MultiRowCommentAdapter extends DelegatingMultiRowAdapter implements SingleSegmentCommentAdapter {
    private final FeedbackListItemCollection f4618a;
    private final BaseCommentsEnvironment f4619b;
    public final Map<Integer, ValueAnimator> f4620c = new HashMap();
    private final AnimatorListenerAdapter f4621d = new C04441(this);

    /* compiled from: routes */
    class C04441 extends AnimatorListenerAdapter {
        final /* synthetic */ MultiRowCommentAdapter f4617a;

        C04441(MultiRowCommentAdapter multiRowCommentAdapter) {
            this.f4617a = multiRowCommentAdapter;
        }

        public void onAnimationEnd(Animator animator) {
            synchronized (this.f4617a.f4620c) {
                Iterator it = this.f4617a.f4620c.entrySet().iterator();
                while (it.hasNext()) {
                    if (animator.equals(((Entry) it.next()).getValue())) {
                        it.remove();
                    }
                }
            }
        }
    }

    public final GraphQLComment mo205a(int i) {
        GraphQLComment graphQLComment;
        RootProps rootProps = (RootProps) this.f4618a.f4549a.get(this.a.s_(i));
        if (rootProps instanceof Props) {
            graphQLComment = ((Props) rootProps).f5117b;
        } else {
            graphQLComment = null;
        }
        return graphQLComment;
    }

    public final void mo198a(Object obj) {
        this.f4618a.m5107a((FeedProps) obj);
        synchronized (this.f4620c) {
            Set<ValueAnimator> hashSet = new HashSet(this.f4620c.values());
            this.f4620c.clear();
            for (ValueAnimator valueAnimator : hashSet) {
                valueAnimator.cancel();
                valueAnimator.removeAllListeners();
                valueAnimator.removeAllUpdateListeners();
            }
        }
        notifyDataSetChanged();
    }

    public MultiRowCommentAdapter(MultiRowAdapter multiRowAdapter, FeedbackListItemCollection feedbackListItemCollection, BaseCommentsEnvironment baseCommentsEnvironment) {
        super(multiRowAdapter);
        this.f4618a = feedbackListItemCollection;
        this.f4619b = baseCommentsEnvironment;
    }

    public final void mo208a(String str) {
        int a = this.f4618a.m5105a(str);
        if (a != -1) {
            int t_ = b().t_(a);
            int c = b().c(a);
            ValueAnimator d = CommentBackgroundDrawable.m4803d();
            d.addListener(this.f4621d);
            synchronized (this.f4620c) {
                for (a = t_; a < t_ + c; a++) {
                    this.f4620c.put(Integer.valueOf(a), d);
                }
            }
        }
    }

    public View getView(int i, @Nullable View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        synchronized (this.f4620c) {
            if (this.f4620c.containsKey(Integer.valueOf(i)) && (view2 instanceof HighlightableView)) {
                ((HighlightableView) view2).mo279a((ValueAnimator) this.f4620c.get(Integer.valueOf(i)));
            }
        }
        return view2;
    }

    public final void mo206a(FeedbackLoggingParams feedbackLoggingParams) {
        BaseCommentsEnvironment baseCommentsEnvironment = this.f4619b;
        if (baseCommentsEnvironment.f4806c != null) {
            baseCommentsEnvironment.f4810g = feedbackLoggingParams;
            baseCommentsEnvironment.f4806c.f4248y = feedbackLoggingParams;
        }
    }

    public final void mo207a(NotificationLogObject notificationLogObject) {
        BaseCommentsEnvironment baseCommentsEnvironment = this.f4619b;
        baseCommentsEnvironment.f4811h = notificationLogObject;
        baseCommentsEnvironment.f4806c.f4249z = notificationLogObject;
    }
}
