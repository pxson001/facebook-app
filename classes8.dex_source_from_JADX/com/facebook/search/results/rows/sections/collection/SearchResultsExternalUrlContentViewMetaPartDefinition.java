package com.facebook.search.results.rows.sections.collection;

import android.content.Context;
import android.view.View;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.feed.environment.HasContext;
import com.facebook.graphql.model.GraphQLNode;
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
/* compiled from: REQUEST_SENT */
public class SearchResultsExternalUrlContentViewMetaPartDefinition extends BaseSinglePartDefinition<GraphQLNode, String, HasContext, ContentView> {
    private static SearchResultsExternalUrlContentViewMetaPartDefinition f23744b;
    private static final Object f23745c = new Object();
    private final NumberTruncationUtil f23746a;

    private static SearchResultsExternalUrlContentViewMetaPartDefinition m27388b(InjectorLike injectorLike) {
        return new SearchResultsExternalUrlContentViewMetaPartDefinition(NumberTruncationUtil.a(injectorLike));
    }

    public final Object m27389a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        HasContext hasContext = (HasContext) anyEnvironment;
        int a = ((GraphQLNode) obj).B().a();
        String a2 = this.f23746a.a(a);
        return hasContext.getContext().getResources().getQuantityString(2131689712, a, new Object[]{a2});
    }

    public final /* bridge */ /* synthetic */ void m27390a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -531261913);
        ((ContentView) view).setMetaText((String) obj2);
        Logger.a(8, EntryType.MARK_POP, 919336482, a);
    }

    @Inject
    public SearchResultsExternalUrlContentViewMetaPartDefinition(NumberTruncationUtil numberTruncationUtil) {
        this.f23746a = numberTruncationUtil;
    }

    public static SearchResultsExternalUrlContentViewMetaPartDefinition m27387a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsExternalUrlContentViewMetaPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23745c) {
                SearchResultsExternalUrlContentViewMetaPartDefinition searchResultsExternalUrlContentViewMetaPartDefinition;
                if (a2 != null) {
                    searchResultsExternalUrlContentViewMetaPartDefinition = (SearchResultsExternalUrlContentViewMetaPartDefinition) a2.a(f23745c);
                } else {
                    searchResultsExternalUrlContentViewMetaPartDefinition = f23744b;
                }
                if (searchResultsExternalUrlContentViewMetaPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27388b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23745c, b3);
                        } else {
                            f23744b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsExternalUrlContentViewMetaPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
