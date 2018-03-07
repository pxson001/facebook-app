package com.facebook.feedplugins.pyml.rows.contentbased.ui;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.model.SuggestedPageUnitItem;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

@ContextScoped
/* compiled from: notifications.db */
public class PymlSeeAllPagePartDefinition extends BaseSinglePartDefinitionWithViewType<SuggestedPageUnitItem, Void, AnyEnvironment, SeeAllPagesYouMayLikeView> {
    public static final ViewType<SeeAllPagesYouMayLikeView> f6757a = new C03151();
    private static PymlSeeAllPagePartDefinition f6758d;
    private static final Object f6759e = new Object();
    private final ClickListenerPartDefinition f6760b;
    public final IFeedIntentBuilder f6761c;

    /* compiled from: notifications.db */
    final class C03151 extends ViewType<SeeAllPagesYouMayLikeView> {
        C03151() {
        }

        public final View m7135a(Context context) {
            return new SeeAllPagesYouMayLikeView(context);
        }
    }

    private static PymlSeeAllPagePartDefinition m7132b(InjectorLike injectorLike) {
        return new PymlSeeAllPagePartDefinition(ClickListenerPartDefinition.a(injectorLike), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike));
    }

    public final Object m7134a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Preconditions.checkArgument(((SuggestedPageUnitItem) obj).mo553r());
        2 2 = new 2(this);
        subParts.a(2131560752, this.f6760b, 2);
        subParts.a(2131560753, this.f6760b, 2);
        return null;
    }

    @Inject
    public PymlSeeAllPagePartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, IFeedIntentBuilder iFeedIntentBuilder) {
        this.f6760b = clickListenerPartDefinition;
        this.f6761c = iFeedIntentBuilder;
    }

    public final ViewType<SeeAllPagesYouMayLikeView> m7133a() {
        return f6757a;
    }

    public static PymlSeeAllPagePartDefinition m7131a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PymlSeeAllPagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6759e) {
                PymlSeeAllPagePartDefinition pymlSeeAllPagePartDefinition;
                if (a2 != null) {
                    pymlSeeAllPagePartDefinition = (PymlSeeAllPagePartDefinition) a2.a(f6759e);
                } else {
                    pymlSeeAllPagePartDefinition = f6758d;
                }
                if (pymlSeeAllPagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7132b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6759e, b3);
                        } else {
                            f6758d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pymlSeeAllPagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
