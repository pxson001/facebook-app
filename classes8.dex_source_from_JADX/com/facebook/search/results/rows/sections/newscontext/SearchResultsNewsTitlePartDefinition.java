package com.facebook.search.results.rows.sections.newscontext;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLTrendingTopicData;
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
import com.facebook.search.results.model.SearchResultsNewsTitle;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

@ContextScoped
/* compiled from: PageAdminCallToAction */
public class SearchResultsNewsTitlePartDefinition extends BaseSinglePartDefinition<SearchResultsNewsTitle, Spannable, AnyEnvironment, BetterTextView> {
    private static SearchResultsNewsTitlePartDefinition f24674a;
    private static final Object f24675b = new Object();

    private static SearchResultsNewsTitlePartDefinition m28089a() {
        return new SearchResultsNewsTitlePartDefinition();
    }

    public final Object m28093a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsNewsTitle searchResultsNewsTitle = (SearchResultsNewsTitle) obj;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(searchResultsNewsTitle.f23386a);
        spannableStringBuilder.setSpan(new StyleSpan(1), 0, spannableStringBuilder.length(), 17);
        spannableStringBuilder.append(": ").append(searchResultsNewsTitle.f23387b);
        return spannableStringBuilder;
    }

    public final /* bridge */ /* synthetic */ void m28094a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1489873342);
        ((BetterTextView) view).setText((Spannable) obj2);
        Logger.a(8, EntryType.MARK_POP, -1750272528, a);
    }

    public static boolean m28091a(GraphQLNode graphQLNode) {
        GraphQLTrendingTopicData iL = graphQLNode.iL();
        return (graphQLNode.dp() == null || Strings.isNullOrEmpty(graphQLNode.iM()) || iL == null || Strings.isNullOrEmpty(iL.o())) ? false : true;
    }

    public static SearchResultsNewsTitle m28092b(GraphQLNode graphQLNode) {
        Preconditions.checkState(m28091a(graphQLNode), "Insufficient data to bind provided node: %s", new Object[]{graphQLNode});
        return new SearchResultsNewsTitle(graphQLNode.iM(), ((GraphQLTrendingTopicData) Preconditions.checkNotNull(graphQLNode.iL())).o());
    }

    public static SearchResultsNewsTitlePartDefinition m28090a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsNewsTitlePartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f24675b) {
                SearchResultsNewsTitlePartDefinition searchResultsNewsTitlePartDefinition;
                if (a3 != null) {
                    searchResultsNewsTitlePartDefinition = (SearchResultsNewsTitlePartDefinition) a3.a(f24675b);
                } else {
                    searchResultsNewsTitlePartDefinition = f24674a;
                }
                if (searchResultsNewsTitlePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m28089a();
                        if (a3 != null) {
                            a3.a(f24675b, a2);
                        } else {
                            f24674a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = searchResultsNewsTitlePartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
