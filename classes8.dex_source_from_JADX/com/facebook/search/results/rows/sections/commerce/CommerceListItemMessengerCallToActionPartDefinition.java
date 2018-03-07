package com.facebook.search.results.rows.sections.commerce;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.feed.environment.HasContext;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.logging.api.SearchResultsAnalytics.InlineActionName;
import com.facebook.search.logging.api.SearchResultsAnalytics.InlineActionType;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.model.unit.SearchResultsProductItemUnit;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: RELATED_ARTICLE_CELL */
public class CommerceListItemMessengerCallToActionPartDefinition<E extends HasContext & HasSearchResultsContext> extends BaseSinglePartDefinition<SearchResultsProductItemUnit, Drawable, E, BetterTextView> {
    private static CommerceListItemMessengerCallToActionPartDefinition f23873d;
    private static final Object f23874e = new Object();
    private final ClickListenerPartDefinition f23875a;
    public final Lazy<FbUriIntentHandler> f23876b;
    public final Lazy<SearchResultsLogger> f23877c;

    private static CommerceListItemMessengerCallToActionPartDefinition m27480b(InjectorLike injectorLike) {
        return new CommerceListItemMessengerCallToActionPartDefinition(ClickListenerPartDefinition.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 616), IdBasedSingletonScopeProvider.b(injectorLike, 10491));
    }

    public final Object m27481a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final SearchResultsProductItemUnit searchResultsProductItemUnit = (SearchResultsProductItemUnit) obj;
        final HasContext hasContext = (HasContext) anyEnvironment;
        subParts.a(this.f23875a, new OnClickListener(this) {
            final /* synthetic */ CommerceListItemMessengerCallToActionPartDefinition f23872c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1587838763);
                ((FbUriIntentHandler) this.f23872c.f23876b.get()).a(hasContext.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.R, searchResultsProductItemUnit.f23494a.gU().H()));
                ((SearchResultsLogger) this.f23872c.f23877c.get()).m25484a(((HasSearchResultsContext) hasContext).mo1248s(), InlineActionType.NAVIGATION, InlineActionName.MESSAGE_SELLER, searchResultsProductItemUnit.f23494a.gU().H(), GraphQLGraphSearchResultRole.COMMERCE_C2C, searchResultsProductItemUnit.f23494a.j(), null);
                Logger.a(2, EntryType.UI_INPUT_END, 870222847, a);
            }
        });
        return hasContext.getContext().getResources().getDrawable(2130839987);
    }

    public final /* bridge */ /* synthetic */ void m27482a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 948535888);
        ((BetterTextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) obj2, null, null, null);
        Logger.a(8, EntryType.MARK_POP, -12226052, a);
    }

    public final void m27483b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((BetterTextView) view).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }

    @Inject
    public CommerceListItemMessengerCallToActionPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, Lazy<FbUriIntentHandler> lazy, Lazy<SearchResultsLogger> lazy2) {
        this.f23875a = clickListenerPartDefinition;
        this.f23876b = lazy;
        this.f23877c = lazy2;
    }

    public static CommerceListItemMessengerCallToActionPartDefinition m27479a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommerceListItemMessengerCallToActionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23874e) {
                CommerceListItemMessengerCallToActionPartDefinition commerceListItemMessengerCallToActionPartDefinition;
                if (a2 != null) {
                    commerceListItemMessengerCallToActionPartDefinition = (CommerceListItemMessengerCallToActionPartDefinition) a2.a(f23874e);
                } else {
                    commerceListItemMessengerCallToActionPartDefinition = f23873d;
                }
                if (commerceListItemMessengerCallToActionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27480b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23874e, b3);
                        } else {
                            f23873d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = commerceListItemMessengerCallToActionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
