package com.facebook.pages.common.surface.protocol.headerfetcher;

import android.content.res.Resources;
import com.facebook.accessibility.AutomaticPhotoCaptioningUtils;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.appchoreographer.AppChoreographer;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.device.ScreenUtil;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.calls.ForNuxInputNuxKey;
import com.facebook.graphql.executor.GraphQLCacheKeySerializer;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.cachekey.KeyFactory;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.pages.adminedpages.AdminedPagesRamCache;
import com.facebook.pages.common.abtest.qe.PagesExperimentUtils;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQL.FetchPageHeaderQueryString;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.FetchPageHeaderQueryModel;
import com.facebook.pages.fb4a.abtest.PagesFb4aAbTestGatekeepers;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.coverphotosize.CoverPhotoSize;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import javax.inject.Inject;

/* compiled from: response_received_time */
public class PageHeaderFetchQueryExecutor {
    private final GraphQLQueryExecutor f2495a;
    private final GraphQLImageHelper f2496b;
    private final SizeAwareImageUtil f2497c;
    private final ScreenUtil f2498d;
    private final FbAppType f2499e;
    private final CoverPhotoSize f2500f;
    private final Resources f2501g;
    private final DefaultAppChoreographer f2502h;
    private final QeAccessor f2503i;
    private final PagesExperimentUtils f2504j;
    private final Lazy<GatekeeperStore> f2505k;
    private final AdminedPagesRamCache f2506l;
    private final AutomaticPhotoCaptioningUtils f2507m;

    /* compiled from: response_received_time */
    class PageHeaderQueryGraphQLCacheKeySerializer implements GraphQLCacheKeySerializer {
        private final FetchPageHeaderQueryString f2494c;

        public PageHeaderQueryGraphQLCacheKeySerializer(FetchPageHeaderQueryString fetchPageHeaderQueryString) {
            this.f2494c = fetchPageHeaderQueryString;
        }

        public final String m3447a(GraphQLRequest graphQLRequest, Class<?> cls, KeyFactory keyFactory) {
            return keyFactory.a(this.f2494c, cls, this.f2494c.a, Arrays.asList(new String[]{"19", "22", "20", "21", "28", "27", "30", "29", "26", "25"}));
        }
    }

    public static PageHeaderFetchQueryExecutor m3449b(InjectorLike injectorLike) {
        return new PageHeaderFetchQueryExecutor(GraphQLQueryExecutor.a(injectorLike), GraphQLImageHelper.a(injectorLike), SizeAwareImageUtil.a(injectorLike), ScreenUtil.a(injectorLike), (FbAppType) injectorLike.getInstance(FbAppType.class), CoverPhotoSize.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), DefaultAppChoreographer.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2128), AdminedPagesRamCache.a(injectorLike), PagesExperimentUtils.a(injectorLike), AutomaticPhotoCaptioningUtils.b(injectorLike));
    }

    @Inject
    public PageHeaderFetchQueryExecutor(GraphQLQueryExecutor graphQLQueryExecutor, GraphQLImageHelper graphQLImageHelper, SizeAwareImageUtil sizeAwareImageUtil, ScreenUtil screenUtil, FbAppType fbAppType, CoverPhotoSize coverPhotoSize, Resources resources, AppChoreographer appChoreographer, QeAccessor qeAccessor, Lazy<GatekeeperStore> lazy, AdminedPagesRamCache adminedPagesRamCache, PagesExperimentUtils pagesExperimentUtils, AutomaticPhotoCaptioningUtils automaticPhotoCaptioningUtils) {
        this.f2495a = graphQLQueryExecutor;
        this.f2496b = graphQLImageHelper;
        this.f2498d = screenUtil;
        this.f2497c = sizeAwareImageUtil;
        this.f2499e = fbAppType;
        this.f2500f = coverPhotoSize;
        this.f2501g = resources;
        this.f2502h = appChoreographer;
        this.f2503i = qeAccessor;
        this.f2505k = lazy;
        this.f2506l = adminedPagesRamCache;
        this.f2504j = pagesExperimentUtils;
        this.f2507m = automaticPhotoCaptioningUtils;
    }

    public final ListenableFuture<GraphQLResult<FetchPageHeaderQueryModel>> m3451a(Long l, GraphQLCachePolicy graphQLCachePolicy) {
        GraphQLQueryFuture a = this.f2495a.a(m3452b(l, graphQLCachePolicy));
        this.f2502h.a(a);
        return a;
    }

    public final GraphQLRequest<FetchPageHeaderQueryModel> m3452b(Long l, GraphQLCachePolicy graphQLCachePolicy) {
        FetchPageHeaderQueryString a = m3448a(String.valueOf(l));
        GraphQLRequest a2 = GraphQLRequest.a(a).a(RequestPriority.INTERACTIVE).a(graphQLCachePolicy).a(2419200);
        a2.e = ImmutableSet.of("PageHeaderTag");
        return a2.a(new PageHeaderQueryGraphQLCacheKeySerializer(a));
    }

    private FetchPageHeaderQueryString m3448a(String str) {
        boolean z;
        boolean z2 = false;
        GraphQlQueryString fetchPageHeaderQueryString = new FetchPageHeaderQueryString();
        boolean a = this.f2504j.a();
        boolean z3 = !this.f2504j.e();
        boolean b = this.f2504j.b();
        GraphQlQueryString a2 = fetchPageHeaderQueryString.a("page_id", str).a("profile_image_size", String.valueOf(GraphQLImageHelper.a(this.f2501g.getDimensionPixelSize(2131430093)))).a("context_items_row_limit", String.valueOf(this.f2501g.getInteger(2131492915))).a("context_item_icon_size", String.valueOf(this.f2501g.getDimensionPixelSize(2131429771))).a("scale", GraphQlQueryDefaults.a()).a("context_items_source", "newsfeed").a("context_items_source_id", "").a("profile_pic_as_cover_size", String.valueOf(Math.min(this.f2498d.c(), this.f2498d.d())));
        String str2 = "is_pma";
        if (this.f2499e.j == Product.PAA) {
            z = true;
        } else {
            z = false;
        }
        a2 = a2.a(str2, String.valueOf(z)).a("cover_image_high_res_size", String.valueOf(GraphQLImageHelper.a(this.f2500f.a()))).a("message_button_nux_key", ForNuxInputNuxKey.MESSAGE_BUTTON_NUX).a("call_to_action_enabled", String.valueOf(((GatekeeperStoreImpl) this.f2505k.get()).a(PagesFb4aAbTestGatekeepers.g, false))).a("context_rows_shown_in_header", Boolean.valueOf(z3));
        str2 = "should_redirect";
        if (this.f2499e.j == Product.FB4A) {
            z = true;
        } else {
            z = false;
        }
        GraphQlQueryString a3 = a2.a(str2, String.valueOf(z)).a("should_fetch_tab_data", String.valueOf(a)).a("profile_video_enabled", String.valueOf(b)).a("should_fetch_page_username", String.valueOf(((GatekeeperStoreImpl) this.f2505k.get()).a(PagesFb4aAbTestGatekeepers.h, false))).a("metabox_enabled", String.valueOf(this.f2504j.d()));
        String str3 = "should_fetch_rating";
        if (this.f2504j.d() || z3) {
            z2 = true;
        }
        a3.a(str3, String.valueOf(z2)).a("should_fetch_page_message_shortlink", String.valueOf(m3450b(str))).a("automatic_photo_captioning_enabled", Boolean.toString(this.f2507m.a()));
        this.f2497c.a(fetchPageHeaderQueryString, this.f2496b.c());
        fetchPageHeaderQueryString.b(true);
        return fetchPageHeaderQueryString;
    }

    private boolean m3450b(String str) {
        boolean z;
        if (this.f2506l.b(str) != null) {
            z = true;
        } else {
            z = false;
        }
        if (z && ((GatekeeperStoreImpl) this.f2505k.get()).a(PagesFb4aAbTestGatekeepers.j, false)) {
            return true;
        }
        return false;
    }
}
