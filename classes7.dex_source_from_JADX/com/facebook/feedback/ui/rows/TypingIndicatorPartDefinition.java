package com.facebook.feedback.ui.rows;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.feedback.ui.environment.BaseCommentsEnvironment;
import com.facebook.feedback.ui.environment.CommentsEnvironment;
import com.facebook.feedback.ui.rows.CommentStylingPartDefinition.Props;
import com.facebook.feedback.ui.rows.views.CommentRowPadding;
import com.facebook.feedback.ui.rows.views.TypingRowView;
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
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: review_text */
public class TypingIndicatorPartDefinition extends MultiRowSinglePartDefinition<Integer, Void, CommentsEnvironment, TypingRowView> {
    public static final ViewType f5128a = new C05061();
    private static TypingIndicatorPartDefinition f5129d;
    private static final Object f5130e = new Object();
    public final boolean f5131b;
    private final CommentStylingPartDefinition f5132c;

    /* compiled from: review_text */
    final class C05061 extends ViewType {
        C05061() {
        }

        public final View m5586a(Context context) {
            return new TypingRowView(new ContextThemeWrapper(context, 2131625248));
        }
    }

    private static TypingIndicatorPartDefinition m5588b(InjectorLike injectorLike) {
        return new TypingIndicatorPartDefinition((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), CommentStylingPartDefinition.m5508a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void m5591a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1364052898);
        TypingRowView typingRowView = (TypingRowView) view;
        int i = ((BaseCommentsEnvironment) anyEnvironment).f4812i.f4820a;
        typingRowView.setPadding(typingRowView.getPaddingLeft(), i, typingRowView.getPaddingRight(), i);
        typingRowView.f5229k.setVisibility(this.f5131b ? 0 : 8);
        Logger.a(8, EntryType.MARK_POP, -90827321, a);
    }

    public final boolean m5592a(Object obj) {
        return ((Integer) obj).intValue() > 0;
    }

    public final /* bridge */ /* synthetic */ void m5593b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
    }

    @Inject
    public TypingIndicatorPartDefinition(QeAccessor qeAccessor, CommentStylingPartDefinition commentStylingPartDefinition) {
        this.f5131b = qeAccessor.a(ExperimentsForFeedbackTestModule.Z, false);
        this.f5132c = commentStylingPartDefinition;
    }

    public final ViewType m5589a() {
        return f5128a;
    }

    public static TypingIndicatorPartDefinition m5587a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TypingIndicatorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5130e) {
                TypingIndicatorPartDefinition typingIndicatorPartDefinition;
                if (a2 != null) {
                    typingIndicatorPartDefinition = (TypingIndicatorPartDefinition) a2.a(f5130e);
                } else {
                    typingIndicatorPartDefinition = f5129d;
                }
                if (typingIndicatorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5588b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5130e, b3);
                        } else {
                            f5129d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = typingIndicatorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final Object m5590a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f5132c, new Props(this.f5131b ? CommentRowPadding.NO_OFFSET : CommentRowPadding.PROFILE_PICTURE_OFFSET));
        return null;
    }
}
