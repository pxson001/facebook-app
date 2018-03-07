package com.facebook.timeline.aboutpage.sections;

import com.facebook.graphql.connection.ConnectionTailLoaderManager.RowIterator;
import com.facebook.graphql.connection.configuration.Configuration;
import com.facebook.graphql.connection.configuration.TailFetchLocation;
import com.facebook.graphql.connection.iterator.EmptyTailRowIterator;
import com.facebook.graphql.connection.iterator.SequentialTailRowIterator;
import com.facebook.graphql.cursor.iterator.BufferRowArrayList;
import com.facebook.graphql.enums.GraphQLTimelineAppCollectionStyle;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResponseParser;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.Assisted;
import com.facebook.timeline.aboutpage.CollectionsQeHelper;
import com.facebook.timeline.aboutpage.CollectionsQueryExecutor;
import com.facebook.timeline.aboutpage.StandardCollectionSizes;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLModels.CollectionWithItemsAndSuggestionsModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineCollectionsSectionViewQueryModel;
import com.facebook.timeline.aboutpage.views.CollectionStyleMapper;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: METADATA_FLOW_CANCELED */
public class SectionsConnectionConfiguration extends Configuration {
    private final String f13552a;
    private final CollectionsQueryExecutor f13553b;
    private final StandardCollectionSizes f13554c;
    private final CollectionStyleMapper f13555d;
    private final CollectionsQeHelper f13556e;

    @Inject
    public SectionsConnectionConfiguration(@Assisted String str, CollectionsQueryExecutor collectionsQueryExecutor, StandardCollectionSizes standardCollectionSizes, CollectionStyleMapper collectionStyleMapper, CollectionsQeHelper collectionsQeHelper) {
        this.f13552a = str;
        this.f13553b = collectionsQueryExecutor;
        this.f13554c = standardCollectionSizes;
        this.f13555d = collectionStyleMapper;
        this.f13556e = collectionsQeHelper;
    }

    public final String m14776a() {
        return "CollectionsSections";
    }

    public final GraphQLRequest<FetchTimelineCollectionsSectionViewQueryModel> m14775a(TailFetchLocation tailFetchLocation) {
        GraphQLRequest<FetchTimelineCollectionsSectionViewQueryModel> a = GraphQLRequest.a(this.f13553b.m13774a(this.f13552a, this.f13554c.m13829h(), 4, tailFetchLocation.b));
        if (1 != 0) {
            a.q = null;
        }
        return a;
    }

    public final RowIterator m14774a(TailFetchLocation tailFetchLocation, FetchTimelineCollectionsSectionViewQueryModel fetchTimelineCollectionsSectionViewQueryModel) {
        if (fetchTimelineCollectionsSectionViewQueryModel == null || fetchTimelineCollectionsSectionViewQueryModel.m14716k() == null || fetchTimelineCollectionsSectionViewQueryModel.m14716k().m14702j() == null) {
            return new EmptyTailRowIterator(tailFetchLocation);
        }
        FetchTimelineCollectionsSectionViewQueryModel fetchTimelineCollectionsSectionViewQueryModel2 = (FetchTimelineCollectionsSectionViewQueryModel) BufferRowArrayList.a(fetchTimelineCollectionsSectionViewQueryModel);
        BufferRowArrayList bufferRowArrayList = new BufferRowArrayList();
        if (tailFetchLocation.b == null) {
            bufferRowArrayList.a(fetchTimelineCollectionsSectionViewQueryModel2.u_(), fetchTimelineCollectionsSectionViewQueryModel2.getClass());
        }
        ImmutableList a = fetchTimelineCollectionsSectionViewQueryModel2.m14716k().m14700a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            CollectionWithItemsAndSuggestionsModel collectionWithItemsAndSuggestionsModel = (CollectionWithItemsAndSuggestionsModel) a.get(i);
            if (this.f13555d.m14916a(collectionWithItemsAndSuggestionsModel.mo396d()) != GraphQLTimelineAppCollectionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
                bufferRowArrayList.a(collectionWithItemsAndSuggestionsModel.u_(), collectionWithItemsAndSuggestionsModel.getClass(), GraphQLResponseParser.a(collectionWithItemsAndSuggestionsModel), 0);
            }
        }
        return new SequentialTailRowIterator(fetchTimelineCollectionsSectionViewQueryModel2, bufferRowArrayList, tailFetchLocation, fetchTimelineCollectionsSectionViewQueryModel2.m14716k().m14702j().a(), fetchTimelineCollectionsSectionViewQueryModel2.m14716k().m14702j().b());
    }

    public final RowIterator m14773a(TailFetchLocation tailFetchLocation, GraphQLResult graphQLResult) {
        return m14774a(tailFetchLocation, (FetchTimelineCollectionsSectionViewQueryModel) graphQLResult.e);
    }
}
