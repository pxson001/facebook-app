package com.facebook.search.results.rows.sections.noresults;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.search.results.model.unit.SearchResultsEmptyEntityUnit;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PYMK_HEADER */
public class SearchResultsEmptyEntityModuleBodyPartDefinition<E extends HasPositionInformation & HasContext> extends MultiRowSinglePartDefinition<FeedProps<SearchResultsEmptyEntityUnit>, Void, E, BetterTextView> {
    public static final ViewType<BetterTextView> f24687a = ViewType.a(2130903969);
    private static SearchResultsEmptyEntityModuleBodyPartDefinition f24688d;
    private static final Object f24689e = new Object();
    private final BackgroundPartDefinition f24690b;
    private final TextPartDefinition f24691c;

    private static SearchResultsEmptyEntityModuleBodyPartDefinition m28104b(InjectorLike injectorLike) {
        return new SearchResultsEmptyEntityModuleBodyPartDefinition(BackgroundPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m28106a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        subParts.a(this.f24690b, new StylingData((FeedProps) obj, PaddingStyle.a, Position.BOTTOM));
        subParts.a(this.f24691c, ((HasContext) hasPositionInformation).getContext().getString(2131239027, new Object[]{((SearchResultsEmptyEntityUnit) r9.a).f23475a.toLowerCase()}));
        return null;
    }

    @Inject
    public SearchResultsEmptyEntityModuleBodyPartDefinition(BackgroundPartDefinition backgroundPartDefinition, TextPartDefinition textPartDefinition) {
        this.f24690b = backgroundPartDefinition;
        this.f24691c = textPartDefinition;
    }

    public final boolean m28107a(Object obj) {
        return true;
    }

    public final ViewType<BetterTextView> m28105a() {
        return f24687a;
    }

    public static SearchResultsEmptyEntityModuleBodyPartDefinition m28103a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsEmptyEntityModuleBodyPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24689e) {
                SearchResultsEmptyEntityModuleBodyPartDefinition searchResultsEmptyEntityModuleBodyPartDefinition;
                if (a2 != null) {
                    searchResultsEmptyEntityModuleBodyPartDefinition = (SearchResultsEmptyEntityModuleBodyPartDefinition) a2.a(f24689e);
                } else {
                    searchResultsEmptyEntityModuleBodyPartDefinition = f24688d;
                }
                if (searchResultsEmptyEntityModuleBodyPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28104b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24689e, b3);
                        } else {
                            f24688d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsEmptyEntityModuleBodyPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
