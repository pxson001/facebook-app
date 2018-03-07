package com.facebook.feedback.ui.rows;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.popover.PopoverMenuWindow.OnMenuItemClickListener;
import com.facebook.feed.rows.core.props.CommentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.ui.environment.BaseCommentsEnvironment;
import com.facebook.feedback.ui.environment.HasCommentActions;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.ufiservices.cache.PendingCommentCache;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ridge_opt_in_turn_on_tapped */
public class CommentFailedStatusPartDefinition extends BaseSinglePartDefinition<FeedProps<GraphQLComment>, State, HasCommentActions, View> {
    private static CommentFailedStatusPartDefinition f4894b;
    private static final Object f4895c = new Object();
    public final PendingCommentCache f4896a;

    /* compiled from: ridge_opt_in_turn_on_tapped */
    public class C04812 implements OnMenuItemClickListener {
        final /* synthetic */ BaseCommentsEnvironment f4889a;
        final /* synthetic */ GraphQLComment f4890b;
        final /* synthetic */ GraphQLFeedback f4891c;
        final /* synthetic */ CommentFailedStatusPartDefinition f4892d;

        public C04812(CommentFailedStatusPartDefinition commentFailedStatusPartDefinition, BaseCommentsEnvironment baseCommentsEnvironment, GraphQLComment graphQLComment, GraphQLFeedback graphQLFeedback) {
            this.f4892d = commentFailedStatusPartDefinition;
            this.f4889a = baseCommentsEnvironment;
            this.f4890b = graphQLComment;
            this.f4891c = graphQLFeedback;
        }

        public final boolean m5415a(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == 2131568699) {
                BaseCommentsEnvironment baseCommentsEnvironment = this.f4889a;
                baseCommentsEnvironment.f4806c.m4855b(this.f4890b, this.f4891c);
            } else if (itemId == 2131568700) {
                this.f4889a.m5347e(this.f4890b, this.f4891c);
            }
            return true;
        }
    }

    /* compiled from: ridge_opt_in_turn_on_tapped */
    public class State {
        public final OnClickListener f4893a;

        public State(OnClickListener onClickListener) {
            this.f4893a = onClickListener;
        }
    }

    private static CommentFailedStatusPartDefinition m5417b(InjectorLike injectorLike) {
        return new CommentFailedStatusPartDefinition(PendingCommentCache.a(injectorLike));
    }

    public final Object m5418a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        final BaseCommentsEnvironment baseCommentsEnvironment = (BaseCommentsEnvironment) anyEnvironment;
        final GraphQLComment graphQLComment = (GraphQLComment) feedProps.a;
        final GraphQLFeedback b = CommentProps.b(feedProps);
        return new State(new OnClickListener(this) {
            final /* synthetic */ CommentFailedStatusPartDefinition f4888d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -452234013);
                CommentFailedStatusPartDefinition commentFailedStatusPartDefinition = this.f4888d;
                BaseCommentsEnvironment baseCommentsEnvironment = baseCommentsEnvironment;
                GraphQLComment graphQLComment = graphQLComment;
                GraphQLFeedback graphQLFeedback = b;
                FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(view.getContext());
                figPopoverMenuWindow.b(2131820593);
                figPopoverMenuWindow.p = new C04812(commentFailedStatusPartDefinition, baseCommentsEnvironment, graphQLComment, graphQLFeedback);
                figPopoverMenuWindow.f(view);
                Logger.a(2, EntryType.UI_INPUT_END, -1234553990, a);
            }
        });
    }

    public final /* bridge */ /* synthetic */ void m5419a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1037928005);
        FeedProps feedProps = (FeedProps) obj;
        State state = (State) obj2;
        if (view != null) {
            if (this.f4896a.c(((GraphQLComment) feedProps.a).H()) != GraphQLFeedOptimisticPublishState.FAILED) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
                view.setOnClickListener(state.f4893a);
            }
        }
        Logger.a(8, EntryType.MARK_POP, 19892427, a);
    }

    @Inject
    public CommentFailedStatusPartDefinition(PendingCommentCache pendingCommentCache) {
        this.f4896a = pendingCommentCache;
    }

    public static CommentFailedStatusPartDefinition m5416a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommentFailedStatusPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4895c) {
                CommentFailedStatusPartDefinition commentFailedStatusPartDefinition;
                if (a2 != null) {
                    commentFailedStatusPartDefinition = (CommentFailedStatusPartDefinition) a2.a(f4895c);
                } else {
                    commentFailedStatusPartDefinition = f4894b;
                }
                if (commentFailedStatusPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5417b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4895c, b3);
                        } else {
                            f4894b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = commentFailedStatusPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m5420b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        if (view != null) {
            view.setOnClickListener(null);
            view.setVisibility(8);
        }
    }
}
