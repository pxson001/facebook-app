package com.facebook.search.results.rows.sections.commerce;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
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
import com.facebook.search.results.model.unit.SearchResultsProductItemUnit;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.text.BetterTextView;

@ContextScoped
/* compiled from: RELEVANCE */
public class CommerceListItemBuyNowCallToActionPartDefinition<E extends HasContext> extends BaseSinglePartDefinition<SearchResultsProductItemUnit, State, E, BetterTextView> {
    private static CommerceListItemBuyNowCallToActionPartDefinition f23864a;
    private static final Object f23865b = new Object();

    /* compiled from: RELEVANCE */
    public class State {
        public final String f23862a;
        public final Drawable f23863b;

        public State(String str, Drawable drawable) {
            this.f23862a = str;
            this.f23863b = drawable;
        }
    }

    private static CommerceListItemBuyNowCallToActionPartDefinition m27471a() {
        return new CommerceListItemBuyNowCallToActionPartDefinition();
    }

    public final Object m27473a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        HasContext hasContext = (HasContext) anyEnvironment;
        return new State(hasContext.getContext().getResources().getString(2131239067), hasContext.getContext().getResources().getDrawable(2130838153));
    }

    public final /* bridge */ /* synthetic */ void m27474a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1129150603);
        State state = (State) obj2;
        BetterTextView betterTextView = (BetterTextView) view;
        betterTextView.setText(state.f23862a);
        CustomViewUtils.b(betterTextView, state.f23863b);
        Logger.a(8, EntryType.MARK_POP, -1519789410, a);
    }

    public final void m27475b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        BetterTextView betterTextView = (BetterTextView) view;
        betterTextView.setText(null);
        CustomViewUtils.b(betterTextView, null);
        betterTextView.setPadding(0, 0, 0, 0);
    }

    public static CommerceListItemBuyNowCallToActionPartDefinition m27472a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommerceListItemBuyNowCallToActionPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f23865b) {
                CommerceListItemBuyNowCallToActionPartDefinition commerceListItemBuyNowCallToActionPartDefinition;
                if (a3 != null) {
                    commerceListItemBuyNowCallToActionPartDefinition = (CommerceListItemBuyNowCallToActionPartDefinition) a3.a(f23865b);
                } else {
                    commerceListItemBuyNowCallToActionPartDefinition = f23864a;
                }
                if (commerceListItemBuyNowCallToActionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m27471a();
                        if (a3 != null) {
                            a3.a(f23865b, a2);
                        } else {
                            f23864a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = commerceListItemBuyNowCallToActionPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
