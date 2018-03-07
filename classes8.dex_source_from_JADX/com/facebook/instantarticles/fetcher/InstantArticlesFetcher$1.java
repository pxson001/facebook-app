package com.facebook.instantarticles.fetcher;

import android.content.Context;
import com.facebook.datasource.DataSource;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.enums.GraphQLDocumentElementType;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.richdocument.abtest.ExperimentsForRichDocumentAbtestModule;
import com.facebook.richdocument.fetcher.RichDocumentFeedbackFetcher;
import com.facebook.richdocument.fonts.RichDocumentFontManager;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.FBPhoto;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentEdge;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentPhoto;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentMasterModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentSectionEdgeModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentSectionEdgeModel.RichDocumentSectionModel;
import com.facebook.richdocument.utils.PrefetchUtils$ClosingDataSubscriber;
import com.google.common.util.concurrent.MoreExecutors;

/* compiled from: url_segue */
class InstantArticlesFetcher$1 extends ResultFutureCallback<GraphQLResult<RichDocumentMasterModel>> {
    final /* synthetic */ String f819a;
    final /* synthetic */ InstantArticlesFetcher$PrefetchMonitorImpl f820b;
    final /* synthetic */ Context f821c;
    final /* synthetic */ InstantArticlesFetcher f822d;

    InstantArticlesFetcher$1(InstantArticlesFetcher instantArticlesFetcher, String str, InstantArticlesFetcher$PrefetchMonitorImpl instantArticlesFetcher$PrefetchMonitorImpl, Context context) {
        this.f822d = instantArticlesFetcher;
        this.f819a = str;
        this.f820b = instantArticlesFetcher$PrefetchMonitorImpl;
        this.f821c = context;
    }

    protected final void m834a(Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (graphQLResult != null && graphQLResult.e != null && ((RichDocumentMasterModel) graphQLResult.e).m6060j() != null) {
            RichDocumentEdge j = ((RichDocumentMasterModel) graphQLResult.e).m6060j();
            if (this.f822d.f.a() != ConnectionQuality.POOR || this.f822d.e.a(ExperimentsForRichDocumentAbtestModule.g, true)) {
                if (j.mo352l() != null && this.f822d.a.a(694, false)) {
                    ((RichDocumentFontManager) this.f822d.b.get()).m5212b(j.mo352l());
                }
                boolean b = InstantArticlesFetcher.b(this.f822d);
                InstantArticlesFetcher instantArticlesFetcher = this.f822d;
                InstantArticlesFetcher$ScreenWidthResolutionImageTarget instantArticlesFetcher$ScreenWidthResolutionImageTarget = !InstantArticlesFetcher.b(instantArticlesFetcher) ? InstantArticlesFetcher$ScreenWidthResolutionImageTarget.NONE : instantArticlesFetcher.e.a(ExperimentsForRichDocumentAbtestModule.b, true) ? InstantArticlesFetcher$ScreenWidthResolutionImageTarget.INTERMEDIATE_IMAGE : InstantArticlesFetcher$ScreenWidthResolutionImageTarget.FINAL_IMAGE;
                InstantArticlesFetcher$ScreenWidthResolutionImageTarget instantArticlesFetcher$ScreenWidthResolutionImageTarget2 = instantArticlesFetcher$ScreenWidthResolutionImageTarget;
                if (j.id_() != null) {
                    RichDocumentPhoto id_ = j.id_();
                    if (InstantArticlesFetcher.a(this.f822d, id_)) {
                        this.f822d.c.b(id_.ig_().mo326m());
                        this.f820b.f825b = id_;
                    } else if (id_.if_() == GraphQLDocumentElementType.PHOTO) {
                        FBPhoto n = id_.mo340n();
                        if (n != null) {
                            String str = null;
                            if (b) {
                                instantArticlesFetcher = this.f822d;
                                str = InstantArticlesFetcher.a(id_, instantArticlesFetcher$ScreenWidthResolutionImageTarget2);
                            } else {
                                FBFullImageFragmentModel c = n.mo316c();
                                if (c != null) {
                                    str = c.d();
                                }
                            }
                            if (str != null) {
                                DataSource a = this.f822d.c.a(str);
                                InstantArticlesFetcher$PrefetchMonitorImpl instantArticlesFetcher$PrefetchMonitorImpl = this.f820b;
                                instantArticlesFetcher$PrefetchMonitorImpl.f826c = a;
                                if (instantArticlesFetcher$PrefetchMonitorImpl.f826c != null) {
                                    instantArticlesFetcher$PrefetchMonitorImpl.f826c.a(new PrefetchUtils$ClosingDataSubscriber(), MoreExecutors.a());
                                }
                            }
                        }
                    }
                }
                if (!(j.mo352l() == null || j.mo352l().m6366w() == null)) {
                    this.f822d.c.a(j.mo352l().m6366w().ii_());
                }
                if (j.ib_() != null) {
                    for (RichDocumentSectionEdgeModel a2 : j.ib_().mo342a()) {
                        RichDocumentSectionModel a3 = a2.m6230a();
                        if (b) {
                            InstantArticlesFetcher.a(this.f822d, this.f821c, this.f819a, a3, instantArticlesFetcher$ScreenWidthResolutionImageTarget2);
                        }
                        GraphQLFeedback o = a3.m6214o();
                        if (o != null) {
                            this.f822d.d.a.a(RichDocumentFeedbackFetcher.a(o.z_(), 1800));
                        }
                    }
                }
            }
        }
    }

    protected final void m833a(ServiceException serviceException) {
        this.f822d.g.b(this.f819a);
    }
}
