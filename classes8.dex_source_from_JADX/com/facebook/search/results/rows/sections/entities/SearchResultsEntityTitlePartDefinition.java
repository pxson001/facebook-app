package com.facebook.search.results.rows.sections.entities;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.contentview.ContentView;
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
import com.facebook.search.results.protocol.entity.SearchResultsAppInterfaces.SearchResultsApp;
import com.facebook.search.results.protocol.entity.SearchResultsEventInterfaces.SearchResultsEvent;
import com.facebook.search.results.protocol.entity.SearchResultsGroupInterfaces.SearchResultsGroup;
import com.facebook.search.results.protocol.entity.SearchResultsPageInterfaces.SearchResultsPage;
import com.facebook.search.results.protocol.entity.SearchResultsPlaceInterfaces.SearchResultsPlace;
import com.facebook.search.results.protocol.entity.SearchResultsUserInterfaces.SearchResultsUser;
import com.facebook.search.util.TypeaheadRowTitleFormatter;
import javax.inject.Inject;

@ContextScoped
/* compiled from: QUERY_VIEWER_CANNOT_POST_LIST_TASK_ID */
public class SearchResultsEntityTitlePartDefinition<T extends SearchResultsApp & SearchResultsEvent & SearchResultsGroup & SearchResultsPage & SearchResultsPlace & SearchResultsUser> extends BaseSinglePartDefinition<T, CharSequence, AnyEnvironment, ContentView> {
    private static SearchResultsEntityTitlePartDefinition f24228b;
    private static final Object f24229c = new Object();
    private final Lazy<TypeaheadRowTitleFormatter> f24230a;

    private static SearchResultsEntityTitlePartDefinition m27753b(InjectorLike injectorLike) {
        return new SearchResultsEntityTitlePartDefinition(IdBasedSingletonScopeProvider.b(injectorLike, 10943));
    }

    public final Object m27754a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsApp searchResultsApp = (SearchResultsApp) obj;
        return SearchResultsEntityUtils.m27763a(((SearchResultsUser) searchResultsApp).mo562j(), ((SearchResultsUser) searchResultsApp).mo563k(), this.f24230a);
    }

    public final /* bridge */ /* synthetic */ void m27755a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -618028176);
        ((ContentView) view).setTitleText((CharSequence) obj2);
        Logger.a(8, EntryType.MARK_POP, -1490108732, a);
    }

    @Inject
    public SearchResultsEntityTitlePartDefinition(Lazy<TypeaheadRowTitleFormatter> lazy) {
        this.f24230a = lazy;
    }

    public static SearchResultsEntityTitlePartDefinition m27752a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsEntityTitlePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24229c) {
                SearchResultsEntityTitlePartDefinition searchResultsEntityTitlePartDefinition;
                if (a2 != null) {
                    searchResultsEntityTitlePartDefinition = (SearchResultsEntityTitlePartDefinition) a2.a(f24229c);
                } else {
                    searchResultsEntityTitlePartDefinition = f24228b;
                }
                if (searchResultsEntityTitlePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27753b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24229c, b3);
                        } else {
                            f24228b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsEntityTitlePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
