package com.facebook.feedback.ui.rows;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedback.ui.environment.BaseCommentsEnvironment;
import com.facebook.feedback.ui.environment.CommentsEnvironment;
import com.facebook.feedback.ui.rows.views.CommentRowPadding;
import com.facebook.feedback.ui.rows.views.MultiRowCommentReplyView;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: ridge_nux_dismiss */
public class CommentReplyPartDefinition extends MultiRowSinglePartDefinition<Props, Void, CommentsEnvironment, MultiRowCommentReplyView> {
    public static final ViewType f5008a = new C04921();
    private static CommentReplyPartDefinition f5009c;
    private static final Object f5010d = new Object();
    private final CommentStylingPartDefinition f5011b;

    /* compiled from: ridge_nux_dismiss */
    final class C04921 extends ViewType {
        C04921() {
        }

        public final View m5483a(Context context) {
            return new MultiRowCommentReplyView(new ContextThemeWrapper(context, 2131625248));
        }
    }

    /* compiled from: ridge_nux_dismiss */
    public class Props {
        public final GraphQLComment f5004a;
        public final GraphQLComment f5005b;
        public final CommentLevel f5006c;
        public final OnClickListener f5007d;

        public Props(GraphQLComment graphQLComment, GraphQLComment graphQLComment2, CommentLevel commentLevel, OnClickListener onClickListener) {
            this.f5004a = graphQLComment;
            this.f5005b = graphQLComment2;
            this.f5006c = commentLevel;
            this.f5007d = onClickListener;
        }
    }

    private static CommentReplyPartDefinition m5485b(InjectorLike injectorLike) {
        return new CommentReplyPartDefinition(CommentStylingPartDefinition.m5508a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void m5488a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -2001963374);
        Props props = (Props) obj;
        BaseCommentsEnvironment baseCommentsEnvironment = (BaseCommentsEnvironment) anyEnvironment;
        MultiRowCommentReplyView multiRowCommentReplyView = (MultiRowCommentReplyView) view;
        multiRowCommentReplyView.a(props.f5004a, false);
        multiRowCommentReplyView.setPadding(multiRowCommentReplyView.getPaddingLeft(), baseCommentsEnvironment.f4812i.f4821b, multiRowCommentReplyView.getPaddingRight(), baseCommentsEnvironment.f4812i.f4821b);
        multiRowCommentReplyView.setOnClickListener(props.f5007d);
        Logger.a(8, EntryType.MARK_POP, 1551208026, a);
    }

    public final void m5490b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((MultiRowCommentReplyView) view).setOnClickListener(null);
    }

    @Inject
    public CommentReplyPartDefinition(CommentStylingPartDefinition commentStylingPartDefinition) {
        this.f5011b = commentStylingPartDefinition;
    }

    public final boolean m5489a(Object obj) {
        return true;
    }

    public static CommentReplyPartDefinition m5484a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommentReplyPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5010d) {
                CommentReplyPartDefinition commentReplyPartDefinition;
                if (a2 != null) {
                    commentReplyPartDefinition = (CommentReplyPartDefinition) a2.a(f5010d);
                } else {
                    commentReplyPartDefinition = f5009c;
                }
                if (commentReplyPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5485b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5010d, b3);
                        } else {
                            f5009c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = commentReplyPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<MultiRowCommentReplyView> m5486a() {
        return f5008a;
    }

    public final Object m5487a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f5011b, new com.facebook.feedback.ui.rows.CommentStylingPartDefinition.Props(CommentRowPadding.PROFILE_PICTURE_OFFSET));
        return null;
    }
}
