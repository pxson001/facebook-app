package com.facebook.search.typeahead.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.contentview.ContentView;
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
import com.facebook.search.model.KeywordTypeaheadUnit;
import com.facebook.search.suggestions.environment.SearchSuggestionsEnvironment;
import com.facebook.search.suggestions.viewbinder.KeywordSuggestionViewBinder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: verification_failure */
public class SearchTypeaheadKeywordPartDefinition extends MultiRowSinglePartDefinition<KeywordTypeaheadUnit, Object, SearchSuggestionsEnvironment, ContentView> {
    public static final ViewType<ContentView> f556a = ViewType.a(2130904633);
    private static SearchTypeaheadKeywordPartDefinition f557c;
    private static final Object f558d = new Object();
    public final KeywordSuggestionViewBinder f559b;

    private static SearchTypeaheadKeywordPartDefinition m650b(InjectorLike injectorLike) {
        return new SearchTypeaheadKeywordPartDefinition(KeywordSuggestionViewBinder.m493a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void m652a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1144400405);
        ContentView contentView = (ContentView) view;
        this.f559b.m503a(contentView, (KeywordTypeaheadUnit) obj);
        Logger.a(8, EntryType.MARK_POP, 394670262, a);
    }

    @Inject
    public SearchTypeaheadKeywordPartDefinition(KeywordSuggestionViewBinder keywordSuggestionViewBinder) {
        this.f559b = keywordSuggestionViewBinder;
    }

    public final ViewType<ContentView> m651a() {
        return f556a;
    }

    public final boolean m653a(Object obj) {
        return true;
    }

    public static SearchTypeaheadKeywordPartDefinition m649a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchTypeaheadKeywordPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f558d) {
                SearchTypeaheadKeywordPartDefinition searchTypeaheadKeywordPartDefinition;
                if (a2 != null) {
                    searchTypeaheadKeywordPartDefinition = (SearchTypeaheadKeywordPartDefinition) a2.a(f558d);
                } else {
                    searchTypeaheadKeywordPartDefinition = f557c;
                }
                if (searchTypeaheadKeywordPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m650b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f558d, b3);
                        } else {
                            f557c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchTypeaheadKeywordPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
