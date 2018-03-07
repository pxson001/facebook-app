package com.facebook.search.results.model.unit;

import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.search.model.SearchResultsBaseFeedUnit;
import com.facebook.search.results.model.contract.SearchResultsFeedImpressionTrackable;
import com.facebook.search.results.model.specification.SearchResultsSupportDeclaration;
import com.google.common.base.Optional;
import javax.annotation.Nullable;

/* compiled from: Reset Search Spotlight State */
public class SearchResultsComposerUnit extends SearchResultsBaseFeedUnit implements SearchResultsFeedImpressionTrackable {
    public final String f23470a;
    public final String f23471b;
    public final String f23472c;
    private final Optional<String> f23473d;
    public MinutiaeObject f23474e;

    public SearchResultsComposerUnit(String str, String str2, String str3, @Nullable String str4) {
        this.f23470a = str;
        this.f23471b = str2;
        this.f23472c = str3;
        this.f23473d = Optional.fromNullable(str4);
    }

    public final GraphQLGraphSearchResultRole mo1321k() {
        return SearchResultsSupportDeclaration.f23435o.f23406a;
    }

    public final Optional<String> mo1322l() {
        return this.f23473d;
    }
}
