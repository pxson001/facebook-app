package com.facebook.timeline.aboutpage.collection;

import com.facebook.graphql.connection.ConnectionTailLoaderManager.RowIterator;
import com.facebook.graphql.connection.configuration.Configuration;
import com.facebook.graphql.connection.configuration.TailFetchLocation;
import com.facebook.graphql.connection.iterator.EmptyTailRowIterator;
import com.facebook.graphql.connection.iterator.SequentialTailRowIterator;
import com.facebook.graphql.cursor.iterator.BufferRowArrayList;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.Assisted;
import com.facebook.timeline.aboutpage.CollectionsQeHelper;
import com.facebook.timeline.aboutpage.CollectionsQueryExecutor;
import com.facebook.timeline.aboutpage.StandardCollectionSizes;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.AppCollectionItemModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLModels.CollectionWithItemsAndSuggestionsModel;
import com.google.common.collect.ImmutableList;
import java.util.Collections;
import javax.inject.Inject;

/* compiled from: NATIVE_WITH_FALLBACK */
public class CollectionTailConnectionConfiguration extends Configuration {
    private final String f13062a;
    private final CollectionsQueryExecutor f13063b;
    private final StandardCollectionSizes f13064c;
    private final CollectionsQeHelper f13065d;

    @Inject
    public CollectionTailConnectionConfiguration(@Assisted String str, CollectionsQueryExecutor collectionsQueryExecutor, StandardCollectionSizes standardCollectionSizes, CollectionsQeHelper collectionsQeHelper) {
        this.f13062a = str;
        this.f13063b = collectionsQueryExecutor;
        this.f13064c = standardCollectionSizes;
        this.f13065d = collectionsQeHelper;
    }

    public final String m13842a() {
        return "CollectionsCollectionTail";
    }

    public final GraphQLRequest m13841a(TailFetchLocation tailFetchLocation) {
        GraphQLRequest a = GraphQLRequest.a(this.f13063b.m13773a(this.f13062a, tailFetchLocation.b, this.f13064c.m13829h() * 3));
        if (1 != 0) {
            a.q = null;
        }
        return a;
    }

    public final RowIterator m13840a(TailFetchLocation tailFetchLocation, GraphQLResult graphQLResult) {
        CollectionWithItemsAndSuggestionsModel collectionWithItemsAndSuggestionsModel = (CollectionWithItemsAndSuggestionsModel) BufferRowArrayList.a((CollectionWithItemsAndSuggestionsModel) graphQLResult.e);
        if (collectionWithItemsAndSuggestionsModel == null || collectionWithItemsAndSuggestionsModel.m14684k() == null || collectionWithItemsAndSuggestionsModel.m14684k().m14349j() == null) {
            return new EmptyTailRowIterator(tailFetchLocation);
        }
        BufferRowArrayList bufferRowArrayList = new BufferRowArrayList(collectionWithItemsAndSuggestionsModel.m14684k().m14346b().size());
        ImmutableList b = collectionWithItemsAndSuggestionsModel.m14684k().m14346b();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            AppCollectionItemModel appCollectionItemModel = (AppCollectionItemModel) b.get(i);
            bufferRowArrayList.a(appCollectionItemModel.u_(), appCollectionItemModel.getClass(), appCollectionItemModel.mo384d() != null ? Collections.singleton(appCollectionItemModel.mo384d()) : null, 0);
        }
        return new SequentialTailRowIterator(collectionWithItemsAndSuggestionsModel, bufferRowArrayList, tailFetchLocation, collectionWithItemsAndSuggestionsModel.m14684k().m14349j().a(), collectionWithItemsAndSuggestionsModel.m14684k().m14349j().b());
    }
}
