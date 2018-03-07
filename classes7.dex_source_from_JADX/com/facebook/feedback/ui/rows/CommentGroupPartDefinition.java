package com.facebook.feedback.ui.rows;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ClipboardUtil;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.CommentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.traversal.GroupPartHolder;
import com.facebook.feedback.logging.FeedbackAnalyticsLogger;
import com.facebook.feedback.ui.CommentBackgroundUtil;
import com.facebook.feedback.ui.environment.BaseCommentsEnvironment;
import com.facebook.feedback.ui.environment.CommentsEnvironment;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.ufiservices.util.CommentMenuHelper;
import com.facebook.ufiservices.util.CommentMenuHelper.OnCommentClickListener;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ridge_opt_in_nux_start */
public class CommentGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLComment>, PressController, CommentsEnvironment> {
    private static CommentGroupPartDefinition f4906k;
    private static final Object f4907l = new Object();
    private final CommentTruncatableHeaderPartDefinition f4908a;
    private final CommentHeaderPartDefinition f4909b;
    private final CommentAttachmentsPartDefinition f4910c;
    private final CommentOfflineStatusPartDefinition f4911d;
    private final CommentActionsPartDefinition f4912e;
    private final CommentActionsWithReactionsPartDefinition f4913f;
    public final CommentBackgroundUtil f4914g;
    public final CommentMenuHelper f4915h;
    public final Context f4916i;
    public final FeedbackAnalyticsLogger f4917j;

    /* compiled from: ridge_opt_in_nux_start */
    public class PressController extends SimpleOnGestureListener implements OnLongClickListener, OnTouchListener {
        final /* synthetic */ CommentGroupPartDefinition f4899a;
        private final FeedProps<GraphQLComment> f4900b;
        public final GraphQLFeedback f4901c = CommentProps.b(this.f4900b);
        public final BaseCommentsEnvironment f4902d;
        public final List<View> f4903e;
        private final GestureDetectorCompat f4904f;
        public View f4905g;

        public PressController(CommentGroupPartDefinition commentGroupPartDefinition, FeedProps<GraphQLComment> feedProps, CommentsEnvironment commentsEnvironment) {
            this.f4899a = commentGroupPartDefinition;
            this.f4900b = feedProps;
            this.f4902d = commentsEnvironment;
            this.f4903e = new ArrayList();
            this.f4904f = new GestureDetectorCompat(commentGroupPartDefinition.f4916i, this);
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f4905g = view;
            this.f4904f.a(motionEvent);
            CommentBackgroundUtil commentBackgroundUtil;
            switch (motionEvent.getAction()) {
                case 0:
                    for (View view2 : this.f4903e) {
                        commentBackgroundUtil = this.f4899a.f4914g;
                        CommentBackgroundUtil.m4808a(view2.getBackground());
                    }
                    break;
                case 1:
                case 3:
                    for (View view22 : this.f4903e) {
                        commentBackgroundUtil = this.f4899a.f4914g;
                        CommentBackgroundUtil.m4812c(view22.getBackground());
                    }
                    break;
            }
            return false;
        }

        public boolean onLongClick(final View view) {
            view.cancelLongPress();
            this.f4899a.f4917j.g(this.f4902d.f4810g);
            this.f4899a.f4915h.a((GraphQLComment) this.f4900b.a, view, view.getContext(), new OnCommentClickListener(this) {
                final /* synthetic */ PressController f4898b;

                public final void m5421a(GraphQLComment graphQLComment) {
                    this.f4898b.f4902d.m5347e(graphQLComment, this.f4898b.f4901c);
                }

                public final void m5422a(String str, GraphQLComment graphQLComment) {
                    BaseCommentsEnvironment baseCommentsEnvironment = this.f4898b.f4902d;
                    baseCommentsEnvironment.f4806c.m4854a(str, graphQLComment, baseCommentsEnvironment.f4804a);
                }

                public final void m5423b(GraphQLComment graphQLComment) {
                    BaseCommentsEnvironment baseCommentsEnvironment = this.f4898b.f4902d;
                    GraphQLFeedback graphQLFeedback = this.f4898b.f4901c;
                    if (baseCommentsEnvironment.f4805b != null) {
                        baseCommentsEnvironment.f4805b.m4709a(graphQLComment, graphQLFeedback);
                    }
                }

                public final void m5424c(GraphQLComment graphQLComment) {
                    ClipboardUtil.a(view.getContext(), graphQLComment.s().a());
                }

                public final void m5425d(GraphQLComment graphQLComment) {
                    BaseCommentsEnvironment baseCommentsEnvironment = this.f4898b.f4902d;
                    baseCommentsEnvironment.f4806c.m4851a(graphQLComment, baseCommentsEnvironment.f4804a);
                }
            });
            return true;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }

        public void onLongPress(MotionEvent motionEvent) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setAction(3);
            if (this.f4905g instanceof ViewGroup) {
                this.f4905g.dispatchTouchEvent(obtain);
            } else {
                ((View) this.f4905g.getParent()).dispatchTouchEvent(obtain);
            }
            obtain.recycle();
        }
    }

    private static CommentGroupPartDefinition m5427b(InjectorLike injectorLike) {
        return new CommentGroupPartDefinition((Context) injectorLike.getInstance(Context.class), CommentTruncatableHeaderPartDefinition.m5512a(injectorLike), CommentHeaderPartDefinition.m5436a(injectorLike), CommentAttachmentsPartDefinition.m5411a(injectorLike), CommentOfflineStatusPartDefinition.m5444a(injectorLike), CommentActionsPartDefinition.m5382a(injectorLike), CommentActionsWithReactionsPartDefinition.m5397a(injectorLike), CommentBackgroundUtil.m4807a(injectorLike), CommentMenuHelper.b(injectorLike), FeedbackAnalyticsLogger.a(injectorLike));
    }

    public final Object m5428a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        BaseCommentsEnvironment baseCommentsEnvironment = (BaseCommentsEnvironment) anyEnvironment;
        SubPartsSelector.a(baseMultiRowSubParts, this.f4908a, feedProps).a(this.f4909b, feedProps);
        baseMultiRowSubParts.a(this.f4910c, feedProps);
        SubPartsSelector.a(baseMultiRowSubParts, this.f4911d, feedProps.a).a(this.f4913f, feedProps).a(this.f4912e, feedProps);
        return new PressController(this, feedProps, baseCommentsEnvironment);
    }

    public final void m5429a(Object obj, Object obj2, AnyEnvironment anyEnvironment, GroupPartHolder groupPartHolder) {
        FeedProps feedProps = (FeedProps) obj;
        PressController pressController = (PressController) obj2;
        View a = groupPartHolder.a();
        if (this.f4915h.a((GraphQLComment) feedProps.a)) {
            pressController.f4903e.add(a);
            a.setOnTouchListener(pressController);
            a.setOnLongClickListener(pressController);
        }
    }

    public final void m5431b(Object obj, Object obj2, AnyEnvironment anyEnvironment, GroupPartHolder groupPartHolder) {
        PressController pressController = (PressController) obj2;
        View a = groupPartHolder.a();
        pressController.f4903e.remove(a);
        a.setOnTouchListener(null);
        a.setOnLongClickListener(null);
        CommentBackgroundUtil.m4812c(a.getBackground());
    }

    @Inject
    public CommentGroupPartDefinition(Context context, CommentTruncatableHeaderPartDefinition commentTruncatableHeaderPartDefinition, CommentHeaderPartDefinition commentHeaderPartDefinition, CommentAttachmentsPartDefinition commentAttachmentsPartDefinition, CommentOfflineStatusPartDefinition commentOfflineStatusPartDefinition, CommentActionsPartDefinition commentActionsPartDefinition, CommentActionsWithReactionsPartDefinition commentActionsWithReactionsPartDefinition, CommentBackgroundUtil commentBackgroundUtil, CommentMenuHelper commentMenuHelper, FeedbackAnalyticsLogger feedbackAnalyticsLogger) {
        this.f4916i = context;
        this.f4908a = commentTruncatableHeaderPartDefinition;
        this.f4909b = commentHeaderPartDefinition;
        this.f4910c = commentAttachmentsPartDefinition;
        this.f4911d = commentOfflineStatusPartDefinition;
        this.f4912e = commentActionsPartDefinition;
        this.f4913f = commentActionsWithReactionsPartDefinition;
        this.f4914g = commentBackgroundUtil;
        this.f4915h = commentMenuHelper;
        this.f4917j = feedbackAnalyticsLogger;
    }

    public static CommentGroupPartDefinition m5426a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommentGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4907l) {
                CommentGroupPartDefinition commentGroupPartDefinition;
                if (a2 != null) {
                    commentGroupPartDefinition = (CommentGroupPartDefinition) a2.a(f4907l);
                } else {
                    commentGroupPartDefinition = f4906k;
                }
                if (commentGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5427b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4907l, b3);
                        } else {
                            f4906k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = commentGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m5430a(Object obj) {
        return true;
    }
}
