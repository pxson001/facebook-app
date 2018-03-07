package com.facebook.feedback.ui.rows;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedback.ui.CommentComposerHelper;
import com.facebook.feedback.ui.InlineReplyComposerController;
import com.facebook.feedback.ui.environment.BaseCommentsEnvironment;
import com.facebook.feedback.ui.environment.CommentsEnvironment;
import com.facebook.feedback.ui.rows.views.CommentRowPadding;
import com.facebook.feedback.ui.rows.views.InlineReplyComposerView;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import javax.inject.Provider;

@ContextScoped
/* compiled from: ridge_full_nux */
public class InlineReplyComposerPartDefinition extends MultiRowSinglePartDefinition<Props, InlineReplyComposerController, CommentsEnvironment, InlineReplyComposerView> {
    public static final ViewType f5051b = new C04981();
    private static InlineReplyComposerPartDefinition f5052d;
    private static final Object f5053e = new Object();
    @Inject
    public volatile Provider<InlineReplyComposerController> f5054a = UltralightRuntime.a;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<CommentStylingPartDefinition> f5055c = UltralightRuntime.b;

    /* compiled from: ridge_full_nux */
    final class C04981 extends ViewType {
        C04981() {
        }

        public final View m5535a(Context context) {
            return new InlineReplyComposerView(new ContextThemeWrapper(context, 2131625248));
        }
    }

    /* compiled from: ridge_full_nux */
    public class Props {
        public final GraphQLComment f5050a;

        public Props(GraphQLComment graphQLComment) {
            this.f5050a = graphQLComment;
        }
    }

    private static InlineReplyComposerPartDefinition m5537b(InjectorLike injectorLike) {
        InlineReplyComposerPartDefinition inlineReplyComposerPartDefinition = new InlineReplyComposerPartDefinition();
        Provider a = IdBasedProvider.a(injectorLike, 6125);
        com.facebook.inject.Lazy a2 = IdBasedLazy.a(injectorLike, 6150);
        inlineReplyComposerPartDefinition.f5054a = a;
        inlineReplyComposerPartDefinition.f5055c = a2;
        return inlineReplyComposerPartDefinition;
    }

    public final /* bridge */ /* synthetic */ void m5540a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1235347086);
        Props props = (Props) obj;
        InlineReplyComposerController inlineReplyComposerController = (InlineReplyComposerController) obj2;
        BaseCommentsEnvironment baseCommentsEnvironment = (BaseCommentsEnvironment) anyEnvironment;
        InlineReplyComposerView inlineReplyComposerView = (InlineReplyComposerView) view;
        inlineReplyComposerController.m5144a(inlineReplyComposerView);
        inlineReplyComposerController.f4591c = props.f5050a.l();
        inlineReplyComposerController.f4590b = baseCommentsEnvironment;
        inlineReplyComposerController.m5145b();
        inlineReplyComposerView.setPadding(inlineReplyComposerView.getPaddingLeft(), baseCommentsEnvironment.f4812i.f4821b, inlineReplyComposerView.getPaddingRight(), baseCommentsEnvironment.f4812i.f4821b);
        inlineReplyComposerView.f5220j.addTextChangedListener(inlineReplyComposerController);
        inlineReplyComposerView.setPostButtonListener(inlineReplyComposerController);
        Logger.a(8, EntryType.MARK_POP, -179405209, a);
    }

    public final boolean m5541a(Object obj) {
        return CommentComposerHelper.m4816a(((Props) obj).f5050a.l());
    }

    public final void m5542b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        InlineReplyComposerController inlineReplyComposerController = (InlineReplyComposerController) obj2;
        InlineReplyComposerView inlineReplyComposerView = (InlineReplyComposerView) view;
        inlineReplyComposerView.setPostButtonListener(null);
        inlineReplyComposerView.f5220j.removeTextChangedListener(inlineReplyComposerController);
        inlineReplyComposerController.m5143a();
        inlineReplyComposerController.f4590b = null;
        inlineReplyComposerController.f4591c = null;
        inlineReplyComposerController.m5144a(null);
    }

    public final ViewType<InlineReplyComposerView> m5538a() {
        return f5051b;
    }

    public static InlineReplyComposerPartDefinition m5536a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineReplyComposerPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5053e) {
                InlineReplyComposerPartDefinition inlineReplyComposerPartDefinition;
                if (a2 != null) {
                    inlineReplyComposerPartDefinition = (InlineReplyComposerPartDefinition) a2.a(f5053e);
                } else {
                    inlineReplyComposerPartDefinition = f5052d;
                }
                if (inlineReplyComposerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5537b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5053e, b3);
                        } else {
                            f5052d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = inlineReplyComposerPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final Object m5539a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a((SinglePartDefinition) this.f5055c.get(), new com.facebook.feedback.ui.rows.CommentStylingPartDefinition.Props(CommentRowPadding.PROFILE_PICTURE_OFFSET));
        return (InlineReplyComposerController) this.f5054a.get();
    }
}
