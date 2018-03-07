package com.facebook.timeline.aboutpage.summary;

import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.connection.ConnectionTailLoaderManager.RowIterator;
import com.facebook.graphql.connection.configuration.Configuration;
import com.facebook.graphql.connection.configuration.TailFetchLocation;
import com.facebook.graphql.connection.iterator.EmptyTailRowIterator;
import com.facebook.graphql.connection.iterator.RetryTailRowIterator;
import com.facebook.graphql.connection.iterator.SequentialTailRowIterator;
import com.facebook.graphql.cursor.iterator.BufferRowArrayList;
import com.facebook.graphql.enums.GraphQLInfoRequestFieldStatus;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResponseParser;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.inject.Assisted;
import com.facebook.qe.api.QeAccessor;
import com.facebook.timeline.aboutpage.CollectionsQeHelper;
import com.facebook.timeline.aboutpage.CollectionsQueryExecutor;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLModels.AboutSectionInfoModel;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLModels.ProfileFieldInfoModel;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLModels.ProfileFieldSectionInfoModel;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLModels.ProfileInfoSectionsModel.ProfileFieldSectionsModel;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.AppCollectionItemModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.AppSectionInfoModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionWithItemsOrRequestablesModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionsAppSectionRequestableFieldModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionsAppSectionWithItemsOrRequestablesModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.TimelineCollectionAppSectionsFieldsModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.TimelineCollectionAppSectionsFieldsModel.PageInfoModel;
import com.facebook.timeline.aboutpage.views.CollectionStyleMapper;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Collections;
import javax.inject.Inject;

/* compiled from: Loading */
public class SummaryInitialConnectionConfiguration extends Configuration {
    private final String f13654a;
    public final QeAccessor f13655b;
    private final boolean f13656c;
    private final boolean f13657d;
    private final CollectionsQueryExecutor f13658e;
    private final CollectionStyleMapper f13659f;
    public final CollectionsQeHelper f13660g;
    private final SummaryConnectionConfigurationHelper f13661h;

    @Inject
    public SummaryInitialConnectionConfiguration(@Assisted String str, QeAccessor qeAccessor, Boolean bool, Boolean bool2, CollectionsQueryExecutor collectionsQueryExecutor, CollectionStyleMapper collectionStyleMapper, CollectionsQeHelper collectionsQeHelper, SummaryConnectionConfigurationHelper summaryConnectionConfigurationHelper) {
        this.f13654a = str;
        this.f13655b = qeAccessor;
        this.f13656c = bool.booleanValue();
        this.f13657d = bool2.booleanValue();
        this.f13658e = collectionsQueryExecutor;
        this.f13659f = collectionStyleMapper;
        this.f13660g = collectionsQeHelper;
        this.f13661h = summaryConnectionConfigurationHelper;
    }

    public final String m14853a() {
        return "CollectionsSummaryInitial";
    }

    public final GraphQLRequest m14852a(TailFetchLocation tailFetchLocation) {
        TypedGraphQlQueryString a;
        Preconditions.checkArgument(tailFetchLocation.b == null);
        if (this.f13655b.a(ExperimentsForTimelineAbTestModule.ax, false)) {
            a = this.f13658e.m13771a(this.f13654a, tailFetchLocation.b);
            a.b("param", "profile_field_sections_after");
            a.b("import", "profile_field_sections_end_cursor");
            a.b("max_runs", Integer.valueOf(3));
        } else {
            a = this.f13658e.m13779c(this.f13654a, 4, this.f13656c, tailFetchLocation.b);
        }
        GraphQLRequest a2 = GraphQLRequest.a(a);
        if (1 != 0) {
            a2.q = null;
        }
        return a2;
    }

    public final RowIterator m14851a(TailFetchLocation tailFetchLocation, GraphQLResult graphQLResult) {
        Object d = graphQLResult.d();
        BufferRowArrayList bufferRowArrayList;
        ImmutableList a;
        int size;
        int i;
        if (d instanceof AboutSectionInfoModel) {
            AboutSectionInfoModel aboutSectionInfoModel = (AboutSectionInfoModel) BufferRowArrayList.a((AboutSectionInfoModel) d);
            bufferRowArrayList = new BufferRowArrayList();
            if (tailFetchLocation.b == null) {
                bufferRowArrayList.a(aboutSectionInfoModel.u_(), aboutSectionInfoModel.getClass());
            }
            ProfileFieldSectionsModel j = aboutSectionInfoModel.m13954j();
            if (j == null) {
                return new EmptyTailRowIterator(tailFetchLocation);
            }
            a = j.m14112a();
            size = a.size();
            for (int i2 = 0; i2 < size; i2++) {
                ProfileFieldSectionInfoModel profileFieldSectionInfoModel = (ProfileFieldSectionInfoModel) a.get(i2);
                if (!(profileFieldSectionInfoModel == null || profileFieldSectionInfoModel.m14087j() == null || profileFieldSectionInfoModel.m14087j().m14065a().isEmpty())) {
                    BufferRowArrayList bufferRowArrayList2 = new BufferRowArrayList(profileFieldSectionInfoModel.m14087j().m14065a().size());
                    ImmutableList a2 = profileFieldSectionInfoModel.m14087j().m14065a();
                    int size2 = a2.size();
                    for (i = 0; i < size2; i++) {
                        ProfileFieldInfoModel profileFieldInfoModel = (ProfileFieldInfoModel) a2.get(i);
                        if (CollectionsSummaryItemsListFactory.m14841a(profileFieldInfoModel)) {
                            bufferRowArrayList2.a(profileFieldInfoModel.u_(), profileFieldInfoModel.getClass());
                        }
                    }
                    if (!bufferRowArrayList2.b()) {
                        bufferRowArrayList.a(profileFieldSectionInfoModel.u_(), profileFieldSectionInfoModel.getClass(), null, 2);
                        for (int i3 = 0; i3 < bufferRowArrayList2.a() - 1; i3++) {
                            bufferRowArrayList.a(bufferRowArrayList2.f(i3), bufferRowArrayList2.b(i3), null, 4);
                        }
                        bufferRowArrayList.a(bufferRowArrayList2.f(bufferRowArrayList2.a() - 1), bufferRowArrayList2.b(bufferRowArrayList2.a() - 1), null, 8);
                        bufferRowArrayList2.a();
                    }
                }
            }
            return new SequentialTailRowIterator(aboutSectionInfoModel, bufferRowArrayList, tailFetchLocation, "", true);
        } else if (d instanceof AppSectionInfoModel) {
            AppSectionInfoModel appSectionInfoModel = (AppSectionInfoModel) BufferRowArrayList.a((AppSectionInfoModel) d);
            bufferRowArrayList = new BufferRowArrayList();
            if (tailFetchLocation.b == null) {
                bufferRowArrayList.a(appSectionInfoModel.u_(), appSectionInfoModel.getClass());
            }
            TimelineCollectionAppSectionsFieldsModel j2 = appSectionInfoModel.m14513j();
            if (j2 == null) {
                BLog.b(SummaryInitialConnectionConfiguration.class, "Missing connection");
                return new RetryTailRowIterator(tailFetchLocation);
            }
            ImmutableList a3 = j2.m14614a();
            int size3 = a3.size();
            for (int i4 = 0; i4 < size3; i4++) {
                CollectionsAppSectionWithItemsOrRequestablesModel collectionsAppSectionWithItemsOrRequestablesModel = (CollectionsAppSectionWithItemsOrRequestablesModel) a3.get(i4);
                if (!(collectionsAppSectionWithItemsOrRequestablesModel.m14588o() == null || collectionsAppSectionWithItemsOrRequestablesModel.m14588o().m14562a().isEmpty())) {
                    if (GraphQLTimelineAppSectionType.ABOUT.equals(collectionsAppSectionWithItemsOrRequestablesModel.nP_()) || GraphQLTimelineAppSectionType.CONTACT.equals(collectionsAppSectionWithItemsOrRequestablesModel.nP_())) {
                        Object obj = !GraphQLTimelineAppSectionType.ABOUT.equals(collectionsAppSectionWithItemsOrRequestablesModel.nP_()) ? 1 : null;
                        Object obj2 = (obj != null || this.f13657d) ? null : 1;
                        if (GraphQLTimelineAppSectionType.ABOUT.equals(collectionsAppSectionWithItemsOrRequestablesModel.nP_())) {
                            size = 16;
                        } else {
                            size = 0;
                        }
                        if (obj != null) {
                            bufferRowArrayList.a(collectionsAppSectionWithItemsOrRequestablesModel.u_(), collectionsAppSectionWithItemsOrRequestablesModel.getClass(), null, size | 2);
                        }
                        BufferRowArrayList bufferRowArrayList3 = new BufferRowArrayList();
                        CollectionWithItemsOrRequestablesModel collectionWithItemsOrRequestablesModel = (CollectionWithItemsOrRequestablesModel) collectionsAppSectionWithItemsOrRequestablesModel.m14588o().m14562a().get(0);
                        if (collectionWithItemsOrRequestablesModel.m14530l() != null) {
                            ImmutableList b = collectionWithItemsOrRequestablesModel.m14530l().m14346b();
                            int size4 = b.size();
                            for (int i5 = 0; i5 < size4; i5++) {
                                AppCollectionItemModel appCollectionItemModel = (AppCollectionItemModel) b.get(i5);
                                bufferRowArrayList3.a(appCollectionItemModel.u_(), appCollectionItemModel.getClass(), appCollectionItemModel.mo384d() != null ? Collections.singleton(appCollectionItemModel.mo384d()) : null, 0);
                            }
                        }
                        if (collectionWithItemsOrRequestablesModel.m14531m() != null) {
                            a = collectionWithItemsOrRequestablesModel.m14531m().m14557a();
                            int size5 = a.size();
                            for (i = 0; i < size5; i++) {
                                CollectionsAppSectionRequestableFieldModel collectionsAppSectionRequestableFieldModel = (CollectionsAppSectionRequestableFieldModel) a.get(i);
                                if (!GraphQLInfoRequestFieldStatus.FILLED.equals(CollectionsSummaryItemsListFactory.m14839a(CollectionsAppSectionRequestableFieldModel.m14545a(collectionsAppSectionRequestableFieldModel)))) {
                                    bufferRowArrayList3.a(collectionsAppSectionRequestableFieldModel.u_(), collectionsAppSectionRequestableFieldModel.getClass());
                                }
                            }
                        }
                        for (int i6 = 0; i6 < bufferRowArrayList3.a(); i6++) {
                            if (i6 == 0 && obj == null) {
                                i = size | 2;
                            } else if (i6 == bufferRowArrayList3.a() - 1 && obj2 == null) {
                                i = size | 8;
                            } else {
                                i = size | 4;
                            }
                            bufferRowArrayList.a(bufferRowArrayList3.f(i6), bufferRowArrayList3.b(i6), null, i);
                        }
                        if (obj2 != null) {
                            bufferRowArrayList.a(collectionsAppSectionWithItemsOrRequestablesModel.u_(), collectionsAppSectionWithItemsOrRequestablesModel.getClass(), null, size | 8);
                        }
                    } else if (this.f13661h.m14850a(this.f13659f, collectionsAppSectionWithItemsOrRequestablesModel)) {
                        bufferRowArrayList.a(collectionsAppSectionWithItemsOrRequestablesModel.u_(), collectionsAppSectionWithItemsOrRequestablesModel.getClass(), GraphQLResponseParser.a(collectionsAppSectionWithItemsOrRequestablesModel), 0);
                    }
                }
            }
            String str = null;
            boolean z = false;
            PageInfoModel j3 = j2.m14616j();
            if (j3 == null) {
                BLog.b(SummaryInitialConnectionConfiguration.class, "Missing page info");
            } else {
                str = j3.m14608a();
                boolean z2 = j3.m14610b() && !StringUtil.a(str);
                z = z2;
            }
            return new SequentialTailRowIterator(appSectionInfoModel, bufferRowArrayList, tailFetchLocation, str, z);
        } else {
            throw new IllegalStateException();
        }
    }
}
