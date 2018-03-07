package com.facebook.instantarticles.fetcher;

import android.content.Context;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.richdocument.abtest.ExperimentsForRichDocumentAbtestModule;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQl.RichDocumentQueryString;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentMasterModel;
import com.facebook.richdocument.utils.ConnectionQualityMonitor;
import javax.inject.Inject;

/* compiled from: use_for_badge_count */
public class InstantArticlesFetchParams extends BaseInstantArticlesFetchParams<RichDocumentMasterModel> implements InjectableComponentWithoutContext {
    @Inject
    public ConnectionQualityMonitor f815b;
    @Inject
    public QeAccessor f816c;
    @Inject
    public GatekeeperStoreImpl f817d;
    public final Context f818e;

    public static void m826a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        InstantArticlesFetchParams instantArticlesFetchParams = (InstantArticlesFetchParams) obj;
        ConnectionQualityMonitor a = ConnectionQualityMonitor.a(fbInjector);
        QeAccessor qeAccessor = (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector);
        GatekeeperStoreImpl a2 = GatekeeperStoreImplMethodAutoProvider.a(fbInjector);
        instantArticlesFetchParams.f815b = a;
        instantArticlesFetchParams.f816c = qeAccessor;
        instantArticlesFetchParams.f817d = a2;
    }

    public InstantArticlesFetchParams(Context context, String str) {
        super(context, str);
        this.f818e = context;
        Class cls = InstantArticlesFetchParams.class;
        m826a(this, context);
    }

    private int m827q() {
        return (!m830u() || m829t()) ? 2500 : this.f818e.getResources().getDisplayMetrics().widthPixels;
    }

    private boolean m828r() {
        return m830u() && m829t();
    }

    private boolean m829t() {
        return this.f816c == null ? true : this.f816c.a(ExperimentsForRichDocumentAbtestModule.b, true);
    }

    private boolean m830u() {
        return this.f816c == null ? false : this.f816c.a(ExperimentsForRichDocumentAbtestModule.c, false);
    }

    public final Object mo21a() {
        String str;
        GraphQlQueryString richDocumentQueryString = new RichDocumentQueryString();
        GraphQlQueryString a = richDocumentQueryString.a("articleID", this.f799b).a("maxAuthors", Integer.valueOf(this.f800c)).a("maxElements", Integer.valueOf(this.f801d)).a("maxListElements", Integer.valueOf(this.f802e)).a("maxSlideshowMedia", Integer.valueOf(this.f803f)).a("media_type", this.f804g).a("scale", this.f805h).a("numRelatedArticlesToFetch", Integer.valueOf(((QeAccessor) this.f798a.get()).a(ExperimentsForRichDocumentAbtestModule.r, this.f808k))).a("relatedArticleImageWidth", Integer.valueOf(this.f809l)).a("relatedArticleImageHeight", Integer.valueOf(this.f810m)).a("final_image_width", Integer.valueOf(m827q())).a("final_image_height", Integer.valueOf(this.f811n)).a("fetch_intermediate_image", Boolean.valueOf(m828r())).a("intermediate_image_width", Integer.valueOf(m831w()));
        String str2 = "logoSizeType";
        boolean z = false;
        float f = this.f818e.getResources().getDisplayMetrics().density;
        if (this.f815b.a() == ConnectionQuality.POOR && f == 1.0f && this.f817d.a(103, false)) {
            z = true;
        }
        if (z) {
            str = "ARTICLE_LOGO";
        } else {
            str = "ARTICLE_LOGO_2X";
        }
        a.a(str2, str);
        if (m831w() < 1000) {
            richDocumentQueryString.a("video_cover_image_width", Integer.valueOf(m831w())).a("video_cover_image_height", Integer.valueOf(this.f811n));
        }
        if (this.f817d.a(69, false)) {
            richDocumentQueryString.a("preferred_quality", "HD").a("preferred_scrubbing", "MPEG_DASH").a("playlist_scrubbing", "MPEG_DASH");
        }
        GraphQLRequest a2 = GraphQLRequest.a(richDocumentQueryString).a(this.f806i);
        a2.b = true;
        return a2.a(this.f813p).a(this.f807j);
    }

    private int m831w() {
        return this.f818e.getResources().getDisplayMetrics().widthPixels;
    }
}
