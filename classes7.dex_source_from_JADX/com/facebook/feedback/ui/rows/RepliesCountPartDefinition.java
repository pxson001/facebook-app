package com.facebook.feedback.ui.rows;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.ui.environment.CommentsEnvironment;
import com.facebook.feedback.ui.rows.CommentStylingPartDefinition.Props;
import com.facebook.feedback.ui.rows.views.CommentRowPadding;
import com.facebook.feedback.ui.rows.views.RepliesCountView;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLHelper;
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
import com.facebook.resources.ui.FbTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ridgeWidget */
public class RepliesCountPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLComment>, Void, CommentsEnvironment, FbTextView> {
    public static final ViewType f5094a = new C05031();
    private static RepliesCountPartDefinition f5095c;
    private static final Object f5096d = new Object();
    private final CommentStylingPartDefinition f5097b;

    /* compiled from: ridgeWidget */
    final class C05031 extends ViewType {
        C05031() {
        }

        public final View m5565a(Context context) {
            return new RepliesCountView(new ContextThemeWrapper(context, 2131625248));
        }
    }

    private static RepliesCountPartDefinition m5567b(InjectorLike injectorLike) {
        return new RepliesCountPartDefinition(CommentStylingPartDefinition.m5508a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void m5570a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 945988469);
        FbTextView fbTextView = (FbTextView) view;
        int f = GraphQLHelper.f(((GraphQLComment) ((FeedProps) obj).a).l());
        fbTextView.setText(fbTextView.getContext().getResources().getQuantityString(2131689528, f, new Object[]{Integer.valueOf(f)}));
        Logger.a(8, EntryType.MARK_POP, 1770292241, a);
    }

    @Inject
    public RepliesCountPartDefinition(CommentStylingPartDefinition commentStylingPartDefinition) {
        this.f5097b = commentStylingPartDefinition;
    }

    public final boolean m5571a(Object obj) {
        return true;
    }

    public final ViewType m5568a() {
        return f5094a;
    }

    public static RepliesCountPartDefinition m5566a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RepliesCountPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5096d) {
                RepliesCountPartDefinition repliesCountPartDefinition;
                if (a2 != null) {
                    repliesCountPartDefinition = (RepliesCountPartDefinition) a2.a(f5096d);
                } else {
                    repliesCountPartDefinition = f5095c;
                }
                if (repliesCountPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5567b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5096d, b3);
                        } else {
                            f5095c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = repliesCountPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final Object m5569a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f5097b, new Props(CommentRowPadding.PROFILE_PICTURE_OFFSET));
        return null;
    }
}
