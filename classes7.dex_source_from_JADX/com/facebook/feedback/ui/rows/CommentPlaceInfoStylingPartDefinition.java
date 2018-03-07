package com.facebook.feedback.ui.rows;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feedback.ui.environment.BaseCommentsEnvironment;
import com.facebook.feedback.ui.environment.CommentsEnvironment;
import com.facebook.feedback.ui.rows.views.CommentPlaceInfoAttachmentView;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: ridge_nux_tooltip_displayed */
public class CommentPlaceInfoStylingPartDefinition extends BaseSinglePartDefinition<Props, State, CommentsEnvironment, CommentPlaceInfoAttachmentView> {
    private static CommentPlaceInfoStylingPartDefinition f5001b;
    private static final Object f5002c = new Object();
    private final CommentStylingPartDefinition f5003a;

    /* compiled from: ridge_nux_tooltip_displayed */
    public @interface AttachmentStylingTypes {
    }

    /* compiled from: ridge_nux_tooltip_displayed */
    public class Props {
        @AttachmentStylingTypes
        public final int f4997a;
        public final CommentRowPadding f4998b;
        public final boolean f4999c;

        public Props(@AttachmentStylingTypes int i, CommentRowPadding commentRowPadding, boolean z) {
            this.f4997a = i;
            this.f4998b = commentRowPadding;
            this.f4999c = z;
        }
    }

    /* compiled from: ridge_nux_tooltip_displayed */
    public class State {
        public final int f5000a;

        public State(int i) {
            this.f5000a = i;
        }
    }

    private static CommentPlaceInfoStylingPartDefinition m5479b(InjectorLike injectorLike) {
        return new CommentPlaceInfoStylingPartDefinition(CommentStylingPartDefinition.m5508a(injectorLike));
    }

    public final Object m5480a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        BaseCommentsEnvironment baseCommentsEnvironment = (BaseCommentsEnvironment) anyEnvironment;
        if (props.f4997a == 0) {
            subParts.a(this.f5003a, new com.facebook.feedback.ui.rows.CommentStylingPartDefinition.Props(props.f4998b));
            return new State(0);
        } else if (props.f4997a == 2) {
            return new State(0);
        } else {
            return new State(baseCommentsEnvironment.f4812i.m5365a(props.f4998b));
        }
    }

    public final /* bridge */ /* synthetic */ void m5481a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1996538357);
        m5478a((Props) obj, (State) obj2, (CommentPlaceInfoAttachmentView) view);
        Logger.a(8, EntryType.MARK_POP, 1912212329, a);
    }

    public final void m5482b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        Props props = (Props) obj;
        State state = (State) obj2;
        CommentPlaceInfoAttachmentView commentPlaceInfoAttachmentView = (CommentPlaceInfoAttachmentView) view;
        commentPlaceInfoAttachmentView.setAddToMapButtonVisibility(8);
        ViewCompat.b(commentPlaceInfoAttachmentView, 0, commentPlaceInfoAttachmentView.getPaddingTop(), 0, commentPlaceInfoAttachmentView.getPaddingBottom());
        if (props.f4997a != 0 && props.f4997a != 2) {
            LayoutParams layoutParams = commentPlaceInfoAttachmentView.getLayoutParams();
            layoutParams.width -= state.f5000a;
        }
    }

    @Inject
    public CommentPlaceInfoStylingPartDefinition(CommentStylingPartDefinition commentStylingPartDefinition) {
        this.f5003a = commentStylingPartDefinition;
    }

    public static CommentPlaceInfoStylingPartDefinition m5477a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommentPlaceInfoStylingPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5002c) {
                CommentPlaceInfoStylingPartDefinition commentPlaceInfoStylingPartDefinition;
                if (a2 != null) {
                    commentPlaceInfoStylingPartDefinition = (CommentPlaceInfoStylingPartDefinition) a2.a(f5002c);
                } else {
                    commentPlaceInfoStylingPartDefinition = f5001b;
                }
                if (commentPlaceInfoStylingPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5479b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5002c, b3);
                        } else {
                            f5001b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = commentPlaceInfoStylingPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private static void m5478a(Props props, State state, CommentPlaceInfoAttachmentView commentPlaceInfoAttachmentView) {
        int i = 0;
        if (props.f4999c) {
            if (props.f4997a == 1 || props.f4997a == 2) {
                i = 1;
            }
            i = i != 0 ? 4 : 8;
        }
        commentPlaceInfoAttachmentView.setAddToMapButtonVisibility(i);
        if (props.f4997a != 0 && props.f4997a != 2) {
            ViewCompat.b(commentPlaceInfoAttachmentView, state.f5000a, commentPlaceInfoAttachmentView.getPaddingTop(), 0, commentPlaceInfoAttachmentView.getPaddingBottom());
            LayoutParams layoutParams = commentPlaceInfoAttachmentView.getLayoutParams();
            layoutParams.width += state.f5000a;
        }
    }
}
