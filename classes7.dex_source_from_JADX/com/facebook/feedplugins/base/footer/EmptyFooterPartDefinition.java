package com.facebook.feedplugins.base.footer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TAP_PLAYER */
public class EmptyFooterPartDefinition extends MultiRowSinglePartDefinition<FeedProps<? extends FeedUnit>, Void, HasPositionInformation, View> {
    public static final PaddingStyle f22929a = PaddingStyle.o;
    public static final ViewType f22930b = new C19841();
    private static EmptyFooterPartDefinition f22931d;
    private static final Object f22932e = new Object();
    private final BackgroundPartDefinition f22933c;

    /* compiled from: TAP_PLAYER */
    final class C19841 extends ViewType {
        C19841() {
        }

        public final View m25442a(Context context) {
            return LayoutInflater.from(context).inflate(2130903970, null);
        }
    }

    private static EmptyFooterPartDefinition m25444b(InjectorLike injectorLike) {
        return new EmptyFooterPartDefinition(BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m25446a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f22933c, new StylingData((FeedProps) obj, f22929a, Position.BOTTOM));
        return null;
    }

    @Inject
    public EmptyFooterPartDefinition(BackgroundPartDefinition backgroundPartDefinition) {
        this.f22933c = backgroundPartDefinition;
    }

    public final ViewType m25445a() {
        return f22930b;
    }

    public final boolean m25447a(Object obj) {
        return true;
    }

    public static EmptyFooterPartDefinition m25443a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EmptyFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22932e) {
                EmptyFooterPartDefinition emptyFooterPartDefinition;
                if (a2 != null) {
                    emptyFooterPartDefinition = (EmptyFooterPartDefinition) a2.a(f22932e);
                } else {
                    emptyFooterPartDefinition = f22931d;
                }
                if (emptyFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25444b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22932e, b3);
                        } else {
                            f22931d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = emptyFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
