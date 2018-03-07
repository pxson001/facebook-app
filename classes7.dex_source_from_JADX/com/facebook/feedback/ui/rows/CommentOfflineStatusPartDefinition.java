package com.facebook.feedback.ui.rows;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedback.ui.environment.BaseCommentsEnvironment;
import com.facebook.feedback.ui.environment.HasCommentStylingResolver;
import com.facebook.feedback.ui.rows.CommentStylingPartDefinition.Props;
import com.facebook.feedback.ui.rows.views.CommentOfflineStatusView;
import com.facebook.feedback.ui.rows.views.CommentRowPadding;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.GraphQLComment;
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
import com.facebook.ufiservices.cache.PendingCommentCache;
import com.facebook.widget.FlowLayout;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ridge_opt_in_not_now_tapped */
public class CommentOfflineStatusPartDefinition extends MultiRowSinglePartDefinition<GraphQLComment, CharSequence, HasCommentStylingResolver, FlowLayout> {
    public static final ViewType f4937a = new C04831();
    private static CommentOfflineStatusPartDefinition f4938d;
    private static final Object f4939e = new Object();
    private final CommentStylingPartDefinition f4940b;
    private final PendingCommentCache f4941c;

    /* compiled from: ridge_opt_in_not_now_tapped */
    final class C04831 extends ViewType {
        C04831() {
        }

        public final View m5443a(Context context) {
            return new CommentOfflineStatusView(new ContextThemeWrapper(context, 2131625248));
        }
    }

    private static CommentOfflineStatusPartDefinition m5445b(InjectorLike injectorLike) {
        return new CommentOfflineStatusPartDefinition(CommentStylingPartDefinition.m5508a(injectorLike), PendingCommentCache.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void m5448a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1204590480);
        FlowLayout flowLayout = (FlowLayout) view;
        flowLayout.setPadding(flowLayout.getPaddingLeft(), flowLayout.getPaddingTop(), flowLayout.getPaddingRight(), ((BaseCommentsEnvironment) anyEnvironment).f4812i.f4820a);
        Logger.a(8, EntryType.MARK_POP, 378775419, a);
    }

    public final boolean m5449a(Object obj) {
        return this.f4941c.c(((GraphQLComment) obj).H()) == GraphQLFeedOptimisticPublishState.OFFLINE;
    }

    @Inject
    public CommentOfflineStatusPartDefinition(CommentStylingPartDefinition commentStylingPartDefinition, PendingCommentCache pendingCommentCache) {
        this.f4940b = commentStylingPartDefinition;
        this.f4941c = pendingCommentCache;
    }

    public final ViewType m5446a() {
        return f4937a;
    }

    public static CommentOfflineStatusPartDefinition m5444a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommentOfflineStatusPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4939e) {
                CommentOfflineStatusPartDefinition commentOfflineStatusPartDefinition;
                if (a2 != null) {
                    commentOfflineStatusPartDefinition = (CommentOfflineStatusPartDefinition) a2.a(f4939e);
                } else {
                    commentOfflineStatusPartDefinition = f4938d;
                }
                if (commentOfflineStatusPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5445b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4939e, b3);
                        } else {
                            f4938d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = commentOfflineStatusPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final Object m5447a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f4940b, new Props(CommentRowPadding.PROFILE_PICTURE_OFFSET));
        return null;
    }
}
