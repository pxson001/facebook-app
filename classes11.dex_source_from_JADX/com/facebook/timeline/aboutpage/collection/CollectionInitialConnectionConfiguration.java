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
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel;
import com.google.common.collect.ImmutableList;
import java.util.Collections;
import javax.inject.Inject;

/* compiled from: NAV_ITEM */
public class CollectionInitialConnectionConfiguration extends Configuration {
    private final String f13057a;
    private final String f13058b;
    private final CollectionsQueryExecutor f13059c;
    private final StandardCollectionSizes f13060d;
    private final CollectionsQeHelper f13061e;

    @Inject
    public CollectionInitialConnectionConfiguration(@Assisted String str, @Assisted String str2, CollectionsQueryExecutor collectionsQueryExecutor, StandardCollectionSizes standardCollectionSizes, CollectionsQeHelper collectionsQeHelper) {
        this.f13057a = str;
        this.f13058b = str2;
        this.f13059c = collectionsQueryExecutor;
        this.f13060d = standardCollectionSizes;
        this.f13061e = collectionsQeHelper;
    }

    public final String m13838a() {
        return "CollectionsCollectionInitial";
    }

    public final GraphQLRequest m13837a(TailFetchLocation tailFetchLocation) {
        GraphQLRequest a = GraphQLRequest.a(this.f13059c.m13775a(this.f13057a, this.f13058b, this.f13060d.m13829h() * 3, 4));
        if (1 != 0) {
            a.q = null;
        }
        return a;
    }

    public static RowIterator m13835a(TailFetchLocation tailFetchLocation, FetchTimelineSingleCollectionViewQueryModel fetchTimelineSingleCollectionViewQueryModel) {
        FetchTimelineSingleCollectionViewQueryModel fetchTimelineSingleCollectionViewQueryModel2 = (FetchTimelineSingleCollectionViewQueryModel) BufferRowArrayList.a(fetchTimelineSingleCollectionViewQueryModel);
        if (fetchTimelineSingleCollectionViewQueryModel2.m14735k() == null || fetchTimelineSingleCollectionViewQueryModel2.m14735k().m14722a().isEmpty()) {
            return new EmptyTailRowIterator(tailFetchLocation);
        }
        BufferRowArrayList bufferRowArrayList = new BufferRowArrayList();
        bufferRowArrayList.a(fetchTimelineSingleCollectionViewQueryModel2.u_(), fetchTimelineSingleCollectionViewQueryModel2.getClass());
        CollectionWithItemsAndSuggestionsModel collectionWithItemsAndSuggestionsModel = (CollectionWithItemsAndSuggestionsModel) fetchTimelineSingleCollectionViewQueryModel2.m14735k().m14722a().get(0);
        if (collectionWithItemsAndSuggestionsModel.m14684k() == null || collectionWithItemsAndSuggestionsModel.m14684k().m14349j() == null) {
            return new EmptyTailRowIterator(tailFetchLocation);
        }
        bufferRowArrayList.a(collectionWithItemsAndSuggestionsModel.u_(), collectionWithItemsAndSuggestionsModel.getClass());
        ImmutableList b = collectionWithItemsAndSuggestionsModel.m14684k().m14346b();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            AppCollectionItemModel appCollectionItemModel = (AppCollectionItemModel) b.get(i);
            bufferRowArrayList.a(appCollectionItemModel.u_(), appCollectionItemModel.getClass(), appCollectionItemModel.mo384d() != null ? Collections.singleton(appCollectionItemModel.mo384d()) : null, 0);
        }
        return new SequentialTailRowIterator(fetchTimelineSingleCollectionViewQueryModel2, bufferRowArrayList, tailFetchLocation, collectionWithItemsAndSuggestionsModel.m14684k().m14349j().a(), collectionWithItemsAndSuggestionsModel.m14684k().m14349j().b());
    }

    public final RowIterator m13836a(TailFetchLocation tailFetchLocation, GraphQLResult graphQLResult) {
        return m13835a(tailFetchLocation, (FetchTimelineSingleCollectionViewQueryModel) graphQLResult.e);
    }
}
