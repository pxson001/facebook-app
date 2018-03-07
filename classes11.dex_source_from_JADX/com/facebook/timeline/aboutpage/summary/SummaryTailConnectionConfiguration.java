package com.facebook.timeline.aboutpage.summary;

import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.connection.ConnectionTailLoaderManager.RowIterator;
import com.facebook.graphql.connection.configuration.SequentialBatchConfiguration.StreamingConfiguration;
import com.facebook.graphql.connection.configuration.TailFetchLocation;
import com.facebook.graphql.connection.iterator.RetryTailRowIterator;
import com.facebook.graphql.connection.iterator.SequentialTailRowIterator;
import com.facebook.graphql.cursor.iterator.BufferRowArrayList;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResponseParser;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQLRefParam;
import com.facebook.inject.Assisted;
import com.facebook.timeline.aboutpage.CollectionsQeHelper;
import com.facebook.timeline.aboutpage.CollectionsQueryExecutor;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQL.CollectionAppSectionsNodeQueryString;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionsAppSectionWithItemsOrRequestablesModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.TimelineCollectionAppSectionsFieldsModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.TimelineCollectionAppSectionsFieldsModel.PageInfoModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.TimelineCollectionAppSectionsModel;
import com.facebook.timeline.aboutpage.views.CollectionStyleMapper;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: Ljavax/inject/Provider */
public class SummaryTailConnectionConfiguration extends StreamingConfiguration {
    private final String f13662a;
    private final boolean f13663b;
    private final CollectionsQueryExecutor f13664c;
    private final CollectionStyleMapper f13665d;
    private final CollectionsQeHelper f13666e;
    private final SummaryConnectionConfigurationHelper f13667f;

    @Inject
    public SummaryTailConnectionConfiguration(@Assisted String str, Boolean bool, CollectionsQueryExecutor collectionsQueryExecutor, CollectionStyleMapper collectionStyleMapper, CollectionsQeHelper collectionsQeHelper, SummaryConnectionConfigurationHelper summaryConnectionConfigurationHelper) {
        this.f13662a = str;
        this.f13663b = bool.booleanValue();
        this.f13664c = collectionsQueryExecutor;
        this.f13665d = collectionStyleMapper;
        this.f13666e = collectionsQeHelper;
        this.f13667f = summaryConnectionConfigurationHelper;
    }

    public final String m14858a() {
        return "CollectionsSummaryTail";
    }

    public final GraphQLRequest m14856a(TailFetchLocation tailFetchLocation) {
        CollectionAppSectionsNodeQueryString a = this.f13664c.m13772a(this.f13662a, 4, this.f13663b, tailFetchLocation.b);
        if (this.f13666e.m13765d()) {
            a.b("param", "collections_after");
            a.b("import", "collections_sections_end_cursor");
            a.b("max_runs", Integer.valueOf(3));
        }
        GraphQLRequest a2 = GraphQLRequest.a(a);
        if (1 != 0) {
            a2.q = null;
        }
        return a2;
    }

    public final GraphQLRequest m14857a(GraphQLRefParam graphQLRefParam) {
        CollectionAppSectionsNodeQueryString a = this.f13664c.m13772a(this.f13662a, 4, this.f13663b, graphQLRefParam.b);
        a.a("collections_after", graphQLRefParam);
        if (this.f13666e.m13765d()) {
            a.b("param", "collections_after");
            a.b("import", "collections_sections_end_cursor");
            a.b("max_runs", Integer.valueOf(3));
        }
        GraphQLRequest a2 = GraphQLRequest.a(a);
        if (1 != 0) {
            a2.q = null;
        }
        return a2;
    }

    public final RowIterator m14855a(TailFetchLocation tailFetchLocation, GraphQLResult graphQLResult) {
        TimelineCollectionAppSectionsModel timelineCollectionAppSectionsModel = (TimelineCollectionAppSectionsModel) graphQLResult.e;
        if (timelineCollectionAppSectionsModel == null || timelineCollectionAppSectionsModel.m14621a() == null) {
            BLog.b(SummaryTailConnectionConfiguration.class, "Missing connection");
            return new RetryTailRowIterator(tailFetchLocation);
        }
        boolean z;
        TimelineCollectionAppSectionsModel timelineCollectionAppSectionsModel2 = (TimelineCollectionAppSectionsModel) BufferRowArrayList.a(timelineCollectionAppSectionsModel);
        TimelineCollectionAppSectionsFieldsModel a = timelineCollectionAppSectionsModel2.m14621a();
        BufferRowArrayList bufferRowArrayList = new BufferRowArrayList(a.m14614a().size());
        ImmutableList a2 = a.m14614a();
        int size = a2.size();
        for (int i = 0; i < size; i++) {
            CollectionsAppSectionWithItemsOrRequestablesModel collectionsAppSectionWithItemsOrRequestablesModel = (CollectionsAppSectionWithItemsOrRequestablesModel) a2.get(i);
            if (this.f13667f.m14850a(this.f13665d, collectionsAppSectionWithItemsOrRequestablesModel)) {
                bufferRowArrayList.a(collectionsAppSectionWithItemsOrRequestablesModel.u_(), collectionsAppSectionWithItemsOrRequestablesModel.getClass(), GraphQLResponseParser.a(collectionsAppSectionWithItemsOrRequestablesModel), 0);
            }
        }
        String str = null;
        PageInfoModel j = timelineCollectionAppSectionsModel2.m14621a().m14616j();
        if (j == null) {
            BLog.b(SummaryTailConnectionConfiguration.class, "Missing page info");
            z = false;
        } else {
            str = j.m14608a();
            boolean z2 = j.m14610b() && !StringUtil.a(str);
            z = z2;
        }
        return new SequentialTailRowIterator(timelineCollectionAppSectionsModel2, bufferRowArrayList, tailFetchLocation, str, z);
    }
}
