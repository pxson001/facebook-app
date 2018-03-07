package com.facebook.aplacefor.reaction.partdefinitions;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.aplacefor.reaction.ui.APlaceForAnimationVideoView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.CustomViewUtils;
import com.google.common.base.Strings;

@ContextScoped
/* compiled from: jewelBadgeCount */
public class ReactionAPlaceForAnimationPartDefinition<E extends HasContext & HasPersistentState> extends MultiRowSinglePartDefinition<Props, Void, E, APlaceForAnimationVideoView> {
    public static final ViewType f10521a = new C11221();
    private static ReactionAPlaceForAnimationPartDefinition f10522b;
    private static final Object f10523c = new Object();

    /* compiled from: jewelBadgeCount */
    final class C11221 extends ViewType {
        C11221() {
        }

        public final View m12420a(Context context) {
            return new APlaceForAnimationVideoView(context);
        }
    }

    /* compiled from: jewelBadgeCount */
    public class Props {
        public final String f10517a;
        public final int f10518b;
        public final int f10519c;
        private final String f10520d;

        /* compiled from: jewelBadgeCount */
        public class Builder {
            public String f10513a;
            public int f10514b;
            public int f10515c;
            public String f10516d;

            public final Props m12421a() {
                return new Props(this.f10513a, this.f10514b, this.f10515c, this.f10516d);
            }
        }

        public Props(String str, int i, int i2, String str2) {
            this.f10517a = str;
            this.f10518b = i;
            this.f10519c = i2;
            this.f10520d = str2;
        }
    }

    private static ReactionAPlaceForAnimationPartDefinition m12424c() {
        return new ReactionAPlaceForAnimationPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m12426a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 408007107);
        Props props = (Props) obj;
        APlaceForAnimationVideoView aPlaceForAnimationVideoView = (APlaceForAnimationVideoView) view;
        LayoutParams layoutParams = aPlaceForAnimationVideoView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(props.f10518b, props.f10519c);
        } else {
            layoutParams.width = props.f10518b;
            layoutParams.height = props.f10519c;
        }
        aPlaceForAnimationVideoView.setLayoutParams(layoutParams);
        CustomViewUtils.b(aPlaceForAnimationVideoView, new ColorDrawable(0));
        aPlaceForAnimationVideoView.m12452a(props.f10517a, ((double) props.f10518b) / ((double) props.f10519c));
        aPlaceForAnimationVideoView.iE_();
        Logger.a(8, EntryType.MARK_POP, -2062040963, a);
    }

    public final boolean m12427a(Object obj) {
        Props props = (Props) obj;
        return (props.f10517a == null || Strings.isNullOrEmpty(props.f10517a)) ? false : true;
    }

    public final void m12428b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((APlaceForAnimationVideoView) view).g();
    }

    public static Builder m12423b() {
        return new Builder();
    }

    public final ViewType m12425a() {
        return f10521a;
    }

    public static ReactionAPlaceForAnimationPartDefinition m12422a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionAPlaceForAnimationPartDefinition c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10523c) {
                ReactionAPlaceForAnimationPartDefinition reactionAPlaceForAnimationPartDefinition;
                if (a2 != null) {
                    reactionAPlaceForAnimationPartDefinition = (ReactionAPlaceForAnimationPartDefinition) a2.a(f10523c);
                } else {
                    reactionAPlaceForAnimationPartDefinition = f10522b;
                }
                if (reactionAPlaceForAnimationPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m12424c();
                        if (a2 != null) {
                            a2.a(f10523c, c);
                        } else {
                            f10522b = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = reactionAPlaceForAnimationPartDefinition;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
