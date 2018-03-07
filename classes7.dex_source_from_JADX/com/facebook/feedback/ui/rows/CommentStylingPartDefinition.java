package com.facebook.feedback.ui.rows;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feedback.ui.environment.BaseCommentsEnvironment;
import com.facebook.feedback.ui.environment.CommentStylingResolver;
import com.facebook.feedback.ui.environment.HasCommentStylingResolver;
import com.facebook.feedback.ui.rows.views.CommentRowPadding;
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

@ContextScoped
/* compiled from: ridge_library_load_failed */
public class CommentStylingPartDefinition extends BaseSinglePartDefinition<Props, Void, HasCommentStylingResolver, View> {
    private static CommentStylingPartDefinition f5022a;
    private static final Object f5023b = new Object();

    /* compiled from: ridge_library_load_failed */
    public class Props {
        public final CommentRowPadding f5021a;

        public Props(CommentRowPadding commentRowPadding) {
            this.f5021a = commentRowPadding;
        }
    }

    private static CommentStylingPartDefinition m5509b() {
        return new CommentStylingPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m5511a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1172978350);
        Props props = (Props) obj;
        CommentStylingResolver commentStylingResolver = ((BaseCommentsEnvironment) anyEnvironment).f4812i;
        ViewCompat.b(view, commentStylingResolver.m5365a(props.f5021a), view.getPaddingTop(), commentStylingResolver.f4823d, view.getPaddingBottom());
        Logger.a(8, EntryType.MARK_POP, 961615296, a);
    }

    public final Object m5510a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return null;
    }

    public static CommentStylingPartDefinition m5508a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommentStylingPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5023b) {
                CommentStylingPartDefinition commentStylingPartDefinition;
                if (a2 != null) {
                    commentStylingPartDefinition = (CommentStylingPartDefinition) a2.a(f5023b);
                } else {
                    commentStylingPartDefinition = f5022a;
                }
                if (commentStylingPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m5509b();
                        if (a2 != null) {
                            a2.a(f5023b, b3);
                        } else {
                            f5022a = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = commentStylingPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
