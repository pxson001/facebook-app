package com.facebook.search.results.environment.common;

import com.facebook.graphql.enums.GraphQLObjectType.ObjectType;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.inject.Assisted;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.results.model.SearchResultsFeedCollection;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import com.facebook.search.results.model.unit.SearchResultsProductItemUnit;
import com.google.common.base.Optional;
import javax.inject.Inject;

/* compiled from: Serialization infrastructure does not support type serialization. */
public class CanLogCollectionItemNavigationImpl implements CanLogCollectionItemNavigation {
    private final SearchResultsMutableContext f22644a;
    private final SearchResultsFeedCollection f22645b;
    private final SearchResultsLogger f22646c;

    @Inject
    public CanLogCollectionItemNavigationImpl(@Assisted SearchResultsMutableContext searchResultsMutableContext, @Assisted SearchResultsFeedCollection searchResultsFeedCollection, SearchResultsLogger searchResultsLogger) {
        this.f22644a = searchResultsMutableContext;
        this.f22645b = searchResultsFeedCollection;
        this.f22646c = searchResultsLogger;
    }

    public final void mo1259a(SearchResultsProductItemUnit searchResultsProductItemUnit) {
        Optional a = this.f22645b.m27057a((Object) searchResultsProductItemUnit);
        if (a.isPresent()) {
            this.f22646c.m25482a(this.f22644a, searchResultsProductItemUnit.f23495b, (String) searchResultsProductItemUnit.mo1322l().orNull(), this.f22645b.m27064b((FeedUnit) a.get()), ((SearchResultsCollectionUnit) a.get()).f23463d.indexOf(searchResultsProductItemUnit), ((SearchResultsCollectionUnit) a.get()).f23463d.size(), ObjectType.a(searchResultsProductItemUnit.f23494a.j().g()).toLowerCase(), searchResultsProductItemUnit.f23494a.dp());
        }
    }
}
