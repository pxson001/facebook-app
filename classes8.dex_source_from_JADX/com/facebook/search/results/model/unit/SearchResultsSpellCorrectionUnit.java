package com.facebook.search.results.model.unit;

import com.facebook.graphql.enums.GraphQLGraphSearchSpellerConfidence;
import com.facebook.search.model.GraphSearchQuerySpec;
import com.facebook.search.model.SearchResultsBaseFeedUnit;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: Refresh failed */
public class SearchResultsSpellCorrectionUnit extends SearchResultsBaseFeedUnit {
    public final GraphQLGraphSearchSpellerConfidence f23517a;
    public final String f23518b;
    public final String f23519c;
    public final String f23520d;
    public final String f23521e;
    public final GraphSearchQuerySpec f23522f;

    public SearchResultsSpellCorrectionUnit(GraphQLGraphSearchSpellerConfidence graphQLGraphSearchSpellerConfidence, String str, String str2, String str3, String str4, GraphSearchQuerySpec graphSearchQuerySpec) {
        this.f23517a = graphQLGraphSearchSpellerConfidence;
        this.f23518b = str;
        this.f23519c = str2;
        this.f23520d = str3;
        this.f23521e = str4;
        this.f23522f = graphSearchQuerySpec;
    }
}
