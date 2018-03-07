package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.abtest.ExperimentsForAdInterfacesModule;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper.C25081;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.BaseAdInterfacesData.Builder;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.objective.BoostPostDataFetcher;
import com.facebook.adinterfaces.objective.BoostPostDataFetcher.C25232;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentValidationMessageModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel;
import com.facebook.adinterfaces.protocol.FetchAdminInfoQuery.FetchAdminInfoQueryString;
import com.facebook.adinterfaces.protocol.FetchAdminInfoQueryModels.FetchAdminInfoQueryModel;
import com.facebook.common.executors.ForUiThread;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLBatchRequestProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.RequestObservable;
import com.facebook.graphql.executor.RequestObserver;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: VideoId1 */
public class FetchPromotionMethod {
    private final GraphQLBatchRequestProvider f22390a;
    private final GraphQLQueryExecutor f22391b;
    private final AdInterfacesQueryBuilder f22392c;
    private final AdInterfacesDataHelper f22393d;
    @ForUiThread
    private final Executor f22394e;
    public final QuickPerformanceLogger f22395f;

    @Inject
    public FetchPromotionMethod(GraphQLQueryExecutor graphQLQueryExecutor, GraphQLBatchRequestProvider graphQLBatchRequestProvider, AdInterfacesQueryBuilder adInterfacesQueryBuilder, AdInterfacesDataHelper adInterfacesDataHelper, Executor executor, QuickPerformanceLogger quickPerformanceLogger) {
        this.f22391b = graphQLQueryExecutor;
        this.f22390a = graphQLBatchRequestProvider;
        this.f22392c = adInterfacesQueryBuilder;
        this.f22393d = adInterfacesDataHelper;
        this.f22394e = executor;
        this.f22395f = quickPerformanceLogger;
    }

    public final void m24234a(ObjectiveType objectiveType, final String str, @Nullable final String str2, @Nullable final String str3, final C25232 c25232) {
        boolean z;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(c25232, "no callback");
        this.f22395f.b(9895937);
        this.f22395f.a(9895937, objectiveType.name());
        GraphQLBatchRequest a = GraphQLBatchRequestProvider.a("FetchPromotion");
        AdInterfacesQueryBuilder adInterfacesQueryBuilder = this.f22392c;
        ObjectiveType objectiveType2 = ObjectiveType.BOOST_POST;
        GraphQlQueryString fetchAdminInfoQueryString = new FetchAdminInfoQueryString();
        if (str2 != null) {
            fetchAdminInfoQueryString.a("story_id", str2);
        }
        fetchAdminInfoQueryString.a("page_id", str);
        fetchAdminInfoQueryString.a("max_budgets_count", FetchBudgetRecommendationsMethod.f22361b);
        fetchAdminInfoQueryString.a("is_local_awareness", Boolean.valueOf(ObjectiveType.LOCAL_AWARENESS == objectiveType2));
        String str4 = "is_promote_website";
        if (ObjectiveType.PROMOTE_WEBSITE == objectiveType2) {
            z = true;
        } else {
            z = false;
        }
        fetchAdminInfoQueryString.a(str4, Boolean.valueOf(z));
        str4 = "is_cta";
        if (objectiveType2 == ObjectiveType.PROMOTE_CTA) {
            z = true;
        } else {
            z = false;
        }
        fetchAdminInfoQueryString.a(str4, Boolean.valueOf(z));
        fetchAdminInfoQueryString.a("fetch_saved_audiences", Boolean.valueOf(true));
        fetchAdminInfoQueryString.a("num_of_saved_audiences_to_fetch", Integer.valueOf(2));
        str4 = "is_page_like";
        if (ObjectiveType.PAGE_LIKE == objectiveType2) {
            z = true;
        } else {
            z = false;
        }
        fetchAdminInfoQueryString.a(str4, Boolean.valueOf(z));
        fetchAdminInfoQueryString.a("use_default_settings", Boolean.valueOf(true));
        fetchAdminInfoQueryString.a("component_app", objectiveType2.getComponentAppEnum());
        fetchAdminInfoQueryString.a("remove_audience_targeting_sentences", Boolean.valueOf(adInterfacesQueryBuilder.f21933b.a(ExperimentsForAdInterfacesModule.f21611h, false)));
        RequestObservable a2 = a.a(GraphQLRequest.a(fetchAdminInfoQueryString)).a(this.f22394e).a(new Function<GraphQLResult<FetchAdminInfoQueryModel>, AdInterfacesBoostPostDataModel>(this) {
            final /* synthetic */ FetchPromotionMethod f22383b;

            public Object apply(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult == null || graphQLResult.e == null || ((FetchAdminInfoQueryModel) graphQLResult.e).m24103a() == null) {
                    return null;
                }
                Builder builder = new AdInterfacesBoostPostDataModel.Builder();
                builder.f21731a = ((FetchAdminInfoQueryModel) graphQLResult.e).m24103a();
                Builder builder2 = builder;
                builder2.f21733c = str;
                builder2 = builder2;
                builder2.f21742l = "boosted_post_mobile";
                builder2.f21732b = ObjectiveType.BOOST_POST;
                return builder.mo961b();
            }
        });
        RequestObservable b = RequestObservable.b();
        if (str2 != null) {
            b = a.a(this.f22392c.m23054a(str2, objectiveType)).a(this.f22394e).a(new Function<GraphQLResult<StoryPromotionModel>, AdInterfacesBoostPostDataModel>(this) {
                final /* synthetic */ FetchPromotionMethod f22386c;

                public Object apply(Object obj) {
                    GraphQLResult graphQLResult = (GraphQLResult) obj;
                    if (graphQLResult == null || graphQLResult.e == null) {
                        return null;
                    }
                    AdInterfacesStatus adInterfacesStatus;
                    switch (C25081.f21688a[((StoryPromotionModel) graphQLResult.e).m23713l().m23677t().ordinal()]) {
                        case 1:
                            adInterfacesStatus = AdInterfacesStatus.INACTIVE;
                            break;
                        case 2:
                            adInterfacesStatus = AdInterfacesStatus.ACTIVE;
                            break;
                        case 3:
                            adInterfacesStatus = AdInterfacesStatus.PAUSED;
                            break;
                        case 4:
                            adInterfacesStatus = AdInterfacesStatus.EXTENDABLE;
                            break;
                        case 5:
                            adInterfacesStatus = AdInterfacesStatus.FINISHED;
                            break;
                        case 6:
                            adInterfacesStatus = AdInterfacesStatus.REJECTED;
                            break;
                        case 7:
                            adInterfacesStatus = AdInterfacesStatus.ERROR;
                            break;
                        case 8:
                            adInterfacesStatus = AdInterfacesStatus.PENDING;
                            break;
                        default:
                            adInterfacesStatus = AdInterfacesStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
                            break;
                    }
                    AdInterfacesStatus adInterfacesStatus2 = adInterfacesStatus;
                    BaseAdInterfacesData b = new AdInterfacesBoostPostDataModel.Builder().mo961b();
                    b.f21780a = (StoryPromotionModel) graphQLResult.e;
                    b.f21782c = str3;
                    b.f21748d = adInterfacesStatus2;
                    b.f21781b = str2;
                    if (!(((StoryPromotionModel) graphQLResult.e).m23712k() == null || ((StoryPromotionModel) graphQLResult.e).m23712k().m23703j() == null || ((StoryPromotionModel) graphQLResult.e).m23712k().m23703j().isEmpty())) {
                        b.f21757m = (BoostedComponentValidationMessageModel) ((StoryPromotionModel) graphQLResult.e).m23712k().m23703j().get(0);
                    }
                    return b;
                }
            });
        }
        RequestObservable.a(a2, b).a(this.f22394e).a(new RequestObserver<AdInterfacesBoostPostDataModel>(this) {
            final /* synthetic */ FetchPromotionMethod f22388b;
            private boolean f22389c = true;

            public final void m24232a(Object obj) {
                AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel = (AdInterfacesBoostPostDataModel) obj;
                if (this.f22389c) {
                    C25232 c25232 = c25232;
                    c25232.f21846a = adInterfacesBoostPostDataModel;
                    c25232.f21846a.f21755k = c25232.f21847b;
                } else {
                    c25232.f21846a.m22873a(adInterfacesBoostPostDataModel);
                }
                this.f22389c = false;
            }

            public final void m24231a() {
                this.f22388b.f22395f.b(9895937, (short) 2);
                C25232 c25232 = c25232;
                c25232.f21846a.f21782c = c25232.f21848c;
                c25232.f21851f.f21853b.m22824b(c25232.f21846a);
                c25232.f21849d.mo941a((BaseAdInterfacesData) c25232.f21850e.apply(c25232.f21846a));
            }

            public final void m24233a(Throwable th) {
                this.f22388b.f22395f.b(9895937, (short) 87);
                C25232 c25232 = c25232;
                c25232.f21851f.f21854c.m22727a(BoostPostDataFetcher.class, "Failed fetching data", th);
                c25232.f21849d.mo941a(null);
            }
        });
        this.f22391b.a(a);
    }
}
