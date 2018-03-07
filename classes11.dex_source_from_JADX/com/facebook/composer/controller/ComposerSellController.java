package com.facebook.composer.controller;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.ComposerFragment;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass40;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryParamSet;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groupcommerce.protocol.FetchGroupCommerceLocationInfo.StructuredLocationQueryString;
import com.facebook.groupcommerce.protocol.FetchGroupCommerceLocationInfoModels.StructuredLocationFragmentModel;
import com.facebook.groupcommerce.protocol.FetchGroupCommerceLocationInfoModels.StructuredLocationQueryModel;
import com.facebook.groupcommerce.protocol.FetchGroupCommercePreferredMarketplaceInfo;
import com.facebook.groupcommerce.protocol.FetchGroupCommercePreferredMarketplaceInfoModels.PreferredMarketplaceQueryModel;
import com.facebook.groupcommerce.protocol.FetchGroupCommercePreferredMarketplaceInfoModels.PreferredMarketplaceQueryModel.PreferredMarketplacesModel.EdgesModel;
import com.facebook.groupcommerce.protocol.FetchGroupCommercePreferredMarketplaceInfoModels.PreferredMarketplaceQueryModel.PreferredMarketplacesModel.EdgesModel.NodeModel;
import com.facebook.groupcommerce.protocol.FetchGroupCommerceZipcode.StructuredLocationZipcodeQueryString;
import com.facebook.groupcommerce.protocol.FetchGroupCommerceZipcodeModels.StructuredLocationZipcodeQueryModel;
import com.facebook.groupcommerce.protocol.FetchGroupCommerceZipcodeModels.StructuredLocationZipcodeQueryModel.GroupCommerceSuggestedLocationModel;
import com.facebook.groupcommerce.protocol.FetchUserGroupCommercePostToMarketplaceStateGraphQL.UserGroupCommercePostToMarketplaceStateQueryString;
import com.facebook.groupcommerce.protocol.FetchUserGroupCommercePostToMarketplaceStateGraphQLModels.UserGroupCommercePostToMarketplaceStateQueryModel;
import com.facebook.groupcommerce.protocol.FetchUserGroupCommercePostToMarketplaceStateGraphQLModels.UserGroupCommercePostToMarketplaceStateQueryModel.GroupSellConfigModel;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.model.ComposerLocation;
import com.facebook.ipc.composer.model.ComposerLocation.ProvidesViewerCoordinates;
import com.facebook.ipc.composer.model.MarketplaceCrossPostSettingModel;
import com.facebook.ipc.composer.model.ProductItemPlace;
import com.facebook.ipc.composer.model.ProductItemPlace.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: hi_res_photo_upload_setting_change */
public class ComposerSellController<DataProvider extends ProvidesViewerCoordinates> {
    private final GraphQLQueryExecutor f6305a;
    private final WeakReference<DataProvider> f6306b;
    private final Boolean f6307c;
    private final Boolean f6308d;
    private final Boolean f6309e;
    public final WeakReference<Delegate> f6310f;
    private final ExecutorService f6311g;
    public final AbstractFbErrorReporter f6312h;
    public ProductItemPlace f6313i = null;
    public long f6314j = 0;
    public Boolean f6315k = Boolean.valueOf(false);
    private long f6316l = 0;

    /* compiled from: hi_res_photo_upload_setting_change */
    class C07871 implements FutureCallback {
        final /* synthetic */ ComposerSellController f6301a;

        C07871(ComposerSellController composerSellController) {
            this.f6301a = composerSellController;
        }

        public void onSuccess(@Nullable Object obj) {
            String str;
            GroupCommerceSuggestedLocationModel a = ((StructuredLocationZipcodeQueryModel) ((GraphQLResult) obj).e).a();
            if (a == null || a.j() == null || a.j().a() == null) {
                str = null;
            } else {
                str = a.j().a().a();
            }
            ((AnonymousClass40) Preconditions.checkNotNull(this.f6301a.f6310f.get())).m7480a(str);
        }

        public void onFailure(Throwable th) {
            ((AnonymousClass40) Preconditions.checkNotNull(this.f6301a.f6310f.get())).m7480a(null);
            this.f6301a.f6312h.a("ComposerSellController", "Couldn't complete .", th);
        }
    }

    /* compiled from: hi_res_photo_upload_setting_change */
    class C07882 implements FutureCallback {
        final /* synthetic */ ComposerSellController f6302a;

        C07882(ComposerSellController composerSellController) {
            this.f6302a = composerSellController;
        }

        public void onSuccess(@Nullable Object obj) {
            ProductItemPlace productItemPlace;
            ComposerSellController composerSellController = this.f6302a;
            StructuredLocationFragmentModel a = ((StructuredLocationQueryModel) ((GraphQLResult) obj).e).a();
            if (a == null || a.k() == null) {
                productItemPlace = null;
            } else {
                Builder builder = new Builder();
                builder.a = a.l();
                builder = builder;
                builder.b = a.j();
                builder = builder;
                builder.c = a.k().a();
                builder = builder;
                builder.d = a.k().j();
                productItemPlace = builder.a();
            }
            composerSellController.f6313i = productItemPlace;
            ((AnonymousClass40) Preconditions.checkNotNull(this.f6302a.f6310f.get())).m7479a(this.f6302a.f6313i);
        }

        public void onFailure(Throwable th) {
            ((AnonymousClass40) Preconditions.checkNotNull(this.f6302a.f6310f.get())).m7479a(null);
            this.f6302a.f6312h.a("ComposerSellController", "Couldn't complete StructuredLocationQuery.", th);
        }
    }

    /* compiled from: hi_res_photo_upload_setting_change */
    class C07893 implements FutureCallback {
        final /* synthetic */ ComposerSellController f6303a;

        C07893(ComposerSellController composerSellController) {
            this.f6303a = composerSellController;
        }

        public void onSuccess(@Nullable Object obj) {
            PreferredMarketplaceQueryModel preferredMarketplaceQueryModel = (PreferredMarketplaceQueryModel) ((GraphQLResult) obj).e;
            if (preferredMarketplaceQueryModel.a() != null) {
                ImmutableList a = preferredMarketplaceQueryModel.a().a();
                int size = a.size();
                int i = 0;
                while (i < size) {
                    NodeModel a2 = ((EdgesModel) a.get(i)).a();
                    if (a2 == null || a2.j() == null) {
                        i++;
                    } else {
                        this.f6303a.f6314j = Long.parseLong(a2.j());
                        AnonymousClass40 anonymousClass40 = (AnonymousClass40) Preconditions.checkNotNull(this.f6303a.f6310f.get());
                        long j = this.f6303a.f6314j;
                        if (anonymousClass40.f6072a.bS.getShouldPostToMarketplace()) {
                            ComposerFragment.m7537a(anonymousClass40.f6072a, j);
                        }
                        return;
                    }
                }
            }
        }

        public void onFailure(Throwable th) {
            this.f6303a.f6312h.a("ComposerSellController", "Couldn't complete PreferredMarketplaceQuery.", th);
        }
    }

    /* compiled from: hi_res_photo_upload_setting_change */
    class C07904 implements FutureCallback {
        final /* synthetic */ ComposerSellController f6304a;

        C07904(ComposerSellController composerSellController) {
            this.f6304a = composerSellController;
        }

        public void onSuccess(@Nullable Object obj) {
            GroupSellConfigModel a = ((UserGroupCommercePostToMarketplaceStateQueryModel) ((GraphQLResult) obj).e).a();
            if (a != null) {
                ImmutableList a2 = a.a();
                int size = a2.size();
                for (int i = 0; i < size; i++) {
                    GroupSellConfigModel.EdgesModel.NodeModel a3 = ((GroupSellConfigModel.EdgesModel) a2.get(i)).a();
                    if (a3 != null) {
                        this.f6304a.f6315k = Boolean.valueOf(a3.a());
                        AnonymousClass40 anonymousClass40 = (AnonymousClass40) Preconditions.checkNotNull(this.f6304a.f6310f.get());
                        Boolean bool = this.f6304a.f6315k;
                        MarketplaceCrossPostSettingModel marketplaceCrossPostSettingModel = anonymousClass40.f6072a.aS.m7439o().getCommerceInfo().getMarketplaceCrossPostSettingModel();
                        if (marketplaceCrossPostSettingModel != null && marketplaceCrossPostSettingModel.a().booleanValue()) {
                            anonymousClass40.f6072a.bS.setIsPostToMarketplaceChecked(bool.booleanValue());
                        }
                        return;
                    }
                }
            }
        }

        public void onFailure(Throwable th) {
            this.f6304a.f6312h.a("ComposerSellController", "Couldn't complete UserGroupCommercePostToMarketplaceStateQuery.", th);
        }
    }

    @Inject
    public ComposerSellController(@Assisted Delegate delegate, @Assisted DataProvider dataProvider, @Assisted Boolean bool, @Assisted Boolean bool2, @Assisted Boolean bool3, @Assisted long j, ExecutorService executorService, GraphQLQueryExecutor graphQLQueryExecutor, FbErrorReporter fbErrorReporter) {
        this.f6305a = graphQLQueryExecutor;
        this.f6311g = executorService;
        this.f6307c = bool;
        this.f6308d = bool2;
        this.f6309e = bool3;
        this.f6310f = new WeakReference(Preconditions.checkNotNull(delegate));
        this.f6306b = new WeakReference(Preconditions.checkNotNull(dataProvider));
        this.f6312h = fbErrorReporter;
        this.f6316l = j;
        m7736d();
        m7735c();
        m7738f();
    }

    private void m7735c() {
        if (this.f6308d.booleanValue()) {
            Futures.a(this.f6305a.a(GraphQLRequest.a(new StructuredLocationZipcodeQueryString()).a(m7737e())), new C07871(this), this.f6311g);
        }
    }

    private void m7736d() {
        if (this.f6307c.booleanValue()) {
            Futures.a(this.f6305a.a(GraphQLRequest.a(new StructuredLocationQueryString()).a(m7737e())), new C07882(this), this.f6311g);
        }
    }

    private GraphQlQueryParamSet m7737e() {
        ComposerLocation f = ((ComposerDataProviderImpl) Preconditions.checkNotNull(this.f6306b.get())).m7430f();
        if (f != null) {
            return new GraphQlQueryParamSet().a("latitude", Double.valueOf(f.latitude)).a("longitude", Double.valueOf(f.longitude));
        }
        return new GraphQlQueryParamSet();
    }

    private void m7738f() {
        if (this.f6309e.booleanValue()) {
            GraphQLRequest a = GraphQLRequest.a(FetchGroupCommercePreferredMarketplaceInfo.a()).a(GraphQLCachePolicy.c);
            GraphQlQueryString userGroupCommercePostToMarketplaceStateQueryString = new UserGroupCommercePostToMarketplaceStateQueryString();
            userGroupCommercePostToMarketplaceStateQueryString.a("group_id", Long.valueOf(this.f6316l));
            GraphQLRequest a2 = GraphQLRequest.a(userGroupCommercePostToMarketplaceStateQueryString).a(GraphQLCachePolicy.c);
            GraphQLQueryFuture a3 = this.f6305a.a(a);
            GraphQLQueryFuture a4 = this.f6305a.a(a2);
            Futures.a(a3, new C07893(this), this.f6311g);
            Futures.a(a4, new C07904(this), this.f6311g);
        }
    }
}
