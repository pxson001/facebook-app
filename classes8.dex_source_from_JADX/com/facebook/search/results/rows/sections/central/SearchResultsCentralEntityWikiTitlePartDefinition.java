package com.facebook.search.results.rows.sections.central;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
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
import com.facebook.search.results.model.unit.SearchResultsCentralWikiUnit;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
@Deprecated
/* compiled from: RESPONDED_PERSON_YOU_MAY_KNOW */
public class SearchResultsCentralEntityWikiTitlePartDefinition extends MultiRowSinglePartDefinition<FeedProps<SearchResultsCentralWikiUnit>, Void, HasPositionInformation, BetterTextView> {
    private static SearchResultsCentralEntityWikiTitlePartDefinition f23700c;
    private static final Object f23701d = new Object();
    private final BackgroundPartDefinition f23702a;
    private final TextPartDefinition f23703b;

    private static SearchResultsCentralEntityWikiTitlePartDefinition m27356b(InjectorLike injectorLike) {
        return new SearchResultsCentralEntityWikiTitlePartDefinition(BackgroundPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m27358a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsCentralWikiUnit searchResultsCentralWikiUnit = (SearchResultsCentralWikiUnit) ((FeedProps) obj).a;
        subParts.a(this.f23702a, SearchResultsCentralEntityWikiTitleConvertedPartDefinition.m27350b(searchResultsCentralWikiUnit.m27145m()));
        subParts.a(this.f23703b, searchResultsCentralWikiUnit.f23457a.eP());
        return null;
    }

    @Inject
    public SearchResultsCentralEntityWikiTitlePartDefinition(BackgroundPartDefinition backgroundPartDefinition, TextPartDefinition textPartDefinition) {
        this.f23702a = backgroundPartDefinition;
        this.f23703b = textPartDefinition;
    }

    public final ViewType<BetterTextView> m27357a() {
        return SearchResultsCentralEntityWikiTitleConvertedPartDefinition.f23695a;
    }

    public static SearchResultsCentralEntityWikiTitlePartDefinition m27355a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsCentralEntityWikiTitlePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23701d) {
                SearchResultsCentralEntityWikiTitlePartDefinition searchResultsCentralEntityWikiTitlePartDefinition;
                if (a2 != null) {
                    searchResultsCentralEntityWikiTitlePartDefinition = (SearchResultsCentralEntityWikiTitlePartDefinition) a2.a(f23701d);
                } else {
                    searchResultsCentralEntityWikiTitlePartDefinition = f23700c;
                }
                if (searchResultsCentralEntityWikiTitlePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27356b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23701d, b3);
                        } else {
                            f23700c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsCentralEntityWikiTitlePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m27359a(Object obj) {
        return true;
    }
}
