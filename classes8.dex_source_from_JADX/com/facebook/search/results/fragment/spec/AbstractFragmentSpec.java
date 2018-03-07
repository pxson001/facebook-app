package com.facebook.search.results.fragment.spec;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.graphql.calls.ExactMatchInputExactMatch;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.search.api.SearchQueryFunctions;
import com.facebook.search.logging.api.SearchResultsSource;
import com.facebook.search.logging.api.SearchTypeaheadSession;
import com.facebook.search.model.GraphSearchQuerySpec;
import com.facebook.search.model.KeywordTypeaheadUnit.Builder;
import com.facebook.search.model.ReactionSearchData;
import com.facebook.search.results.fragment.GraphSearchResultFragment;
import com.google.common.collect.ImmutableList;

/* compiled from: SEE_MORE_ON_MODULE_TAPPED */
public abstract class AbstractFragmentSpec<T extends GraphSearchResultFragment> {
    public final GraphQLGraphSearchResultsDisplayStyle f23144a;
    public final String f23145b;
    public final boolean f23146c;

    public abstract T mo1308c();

    public AbstractFragmentSpec(Resources resources, GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle, int i, boolean z) {
        this.f23144a = graphQLGraphSearchResultsDisplayStyle;
        this.f23145b = resources.getString(i);
        this.f23146c = z;
    }

    public final void m26817a(Fragment fragment, GraphSearchQuerySpec graphSearchQuerySpec, SearchTypeaheadSession searchTypeaheadSession, SearchResultsSource searchResultsSource) {
        if (fragment instanceof GraphSearchResultFragment) {
            ((GraphSearchResultFragment) fragment).mo1281a(graphSearchQuerySpec, searchTypeaheadSession, searchResultsSource);
        }
    }

    public GraphSearchQuerySpec mo1309a(String str, String str2, String str3, String str4, ReactionSearchData reactionSearchData, ExactMatchInputExactMatch exactMatchInputExactMatch) {
        Object obj;
        String a;
        if (this.f23146c && this.f23144a.equals(GraphQLGraphSearchResultsDisplayStyle.BLENDED) && (str4 == null || (!str4.equals("celebrity") && !str4.equals("news_v2")))) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            a = StringFormatUtil.a("keywords_all_types(%s)", new Object[]{str});
        } else {
            a = SearchQueryFunctions.a(this.f23144a, str);
        }
        if (str4.equals("news_v2") && this.f23144a == GraphQLGraphSearchResultsDisplayStyle.BLENDED) {
            if (str2 == null || !str2.startsWith("str/")) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                a = str2;
            }
        }
        Builder builder = new Builder();
        builder.f22087b = str;
        builder = builder;
        builder.f22088c = a;
        Builder builder2 = builder;
        builder2.f22089d = str3;
        builder2 = builder2;
        builder2.f22090e = str4;
        builder2 = builder2;
        builder2.f22095j = reactionSearchData;
        builder2 = builder2;
        builder2.f22091f = exactMatchInputExactMatch;
        builder2 = builder2;
        builder2.f22107v = ImmutableList.of(this.f23144a);
        return builder2.m25651b();
    }
}
