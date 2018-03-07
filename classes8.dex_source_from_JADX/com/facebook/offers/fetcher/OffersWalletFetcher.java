package com.facebook.offers.fetcher;

import android.content.Context;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.calls.OfferClaimEnableNotificationsInputData;
import com.facebook.graphql.calls.OfferClaimEnableNotificationsInputData.Enable;
import com.facebook.graphql.calls.OfferClaimMarkAsUsedInputData;
import com.facebook.graphql.calls.OfferClaimMarkAsUsedInputData.Used;
import com.facebook.graphql.calls.OfferClaimToWalletInputData;
import com.facebook.graphql.calls.OfferViewClaimToWalletInputData;
import com.facebook.graphql.calls.OfferViewRemoveFromWalletInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.offers.graphql.OfferMutations.OfferClaimEnableNotificationsMutationString;
import com.facebook.offers.graphql.OfferMutations.OfferClaimMarkAsUsedMutationString;
import com.facebook.offers.graphql.OfferMutations.OfferClaimToWalletMutationString;
import com.facebook.offers.graphql.OfferMutations.OfferViewClaimToWalletMutationString;
import com.facebook.offers.graphql.OfferMutations.OfferViewRemoveFromWalletMutationString;
import com.facebook.offers.graphql.OfferMutationsModels.OfferClaimEnableNotificationsMutationModel;
import com.facebook.offers.graphql.OfferMutationsModels.OfferClaimMarkAsUsedMutationModel;
import com.facebook.offers.graphql.OfferMutationsModels.OfferClaimToWalletMutationModel;
import com.facebook.offers.graphql.OfferMutationsModels.OfferViewClaimToWalletMutationModel;
import com.facebook.offers.graphql.OfferMutationsModels.OfferViewRemoveFromWalletMutationModel;
import com.facebook.offers.graphql.OfferQueriesInterfaces.OfferClaimData;
import com.facebook.offers.graphql.OfferQueriesModels.OfferClaimDataModel;
import com.facebook.offers.graphql.OfferQueriesModels.OfferClaimDataModel.Builder;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

@ContextScoped
/* compiled from: custom_cta_click_cancel_delete_mobile */
public final class OffersWalletFetcher {
    private static OffersWalletFetcher f16184b;
    private static final Object f16185c = new Object();
    public final GraphQLQueryExecutor f16186a;

    private static OffersWalletFetcher m18992b(InjectorLike injectorLike) {
        return new OffersWalletFetcher(GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public OffersWalletFetcher(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f16186a = graphQLQueryExecutor;
    }

    public static OffersWalletFetcher m18991a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OffersWalletFetcher b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f16185c) {
                OffersWalletFetcher offersWalletFetcher;
                if (a2 != null) {
                    offersWalletFetcher = (OffersWalletFetcher) a2.a(f16185c);
                } else {
                    offersWalletFetcher = f16184b;
                }
                if (offersWalletFetcher == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m18992b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f16185c, b3);
                        } else {
                            f16184b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = offersWalletFetcher;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ListenableFuture<GraphQLResult<OfferClaimMarkAsUsedMutationModel>> m18993a(String str, OfferClaimData offerClaimData, int i, boolean z, String str2) {
        Enum enumR;
        GraphQLVisitableModel graphQLVisitableModel = null;
        if (offerClaimData != null) {
            Builder a = Builder.m19152a(OfferClaimDataModel.m19156a(offerClaimData));
            a.f16362e = z;
            graphQLVisitableModel = a.m19153a();
        }
        OfferClaimMarkAsUsedInputData offerClaimMarkAsUsedInputData = new OfferClaimMarkAsUsedInputData();
        offerClaimMarkAsUsedInputData.a("offer_claim_id", str);
        if (z) {
            enumR = Used.TRUE;
        } else {
            enumR = Used.FALSE;
        }
        offerClaimMarkAsUsedInputData.a("used", enumR);
        offerClaimMarkAsUsedInputData.a("actor_id", str2);
        offerClaimMarkAsUsedInputData.a("client_mutation_id", SafeUUIDGenerator.a().toString());
        GraphQlQueryString offerClaimMarkAsUsedMutationString = new OfferClaimMarkAsUsedMutationString();
        offerClaimMarkAsUsedMutationString.a("input", offerClaimMarkAsUsedInputData).a("profile_pic_width", Integer.valueOf(Math.max(100, i / 4))).a("creative_img_size", Integer.valueOf(i));
        MutationRequest a2 = GraphQLRequest.a(offerClaimMarkAsUsedMutationString);
        if (graphQLVisitableModel != null) {
            a2.a(graphQLVisitableModel);
        }
        return this.f16186a.a(a2);
    }

    public final ListenableFuture<GraphQLResult<OfferClaimEnableNotificationsMutationModel>> m18996b(String str, OfferClaimData offerClaimData, int i, boolean z, String str2) {
        Enum enumR;
        GraphQLVisitableModel graphQLVisitableModel = null;
        if (offerClaimData != null) {
            Builder a = Builder.m19152a(OfferClaimDataModel.m19156a(offerClaimData));
            a.f16363f = z;
            graphQLVisitableModel = a.m19153a();
        }
        OfferClaimEnableNotificationsInputData offerClaimEnableNotificationsInputData = new OfferClaimEnableNotificationsInputData();
        offerClaimEnableNotificationsInputData.a("offer_claim_id", str);
        if (z) {
            enumR = Enable.TRUE;
        } else {
            enumR = Enable.FALSE;
        }
        offerClaimEnableNotificationsInputData.a("enable", enumR);
        offerClaimEnableNotificationsInputData.a("actor_id", str2);
        offerClaimEnableNotificationsInputData.a("client_mutation_id", SafeUUIDGenerator.a().toString());
        GraphQlQueryString offerClaimEnableNotificationsMutationString = new OfferClaimEnableNotificationsMutationString();
        offerClaimEnableNotificationsMutationString.a("input", offerClaimEnableNotificationsInputData).a("profile_pic_width", Integer.valueOf(Math.max(100, i / 4))).a("creative_img_size", Integer.valueOf(i));
        MutationRequest a2 = GraphQLRequest.a(offerClaimEnableNotificationsMutationString);
        if (graphQLVisitableModel != null) {
            a2.a(graphQLVisitableModel);
        }
        return this.f16186a.a(a2);
    }

    public final ListenableFuture<GraphQLResult<OfferClaimToWalletMutationModel>> m18995a(String str, String str2, int i, String str3) {
        OfferClaimToWalletInputData offerClaimToWalletInputData = new OfferClaimToWalletInputData();
        offerClaimToWalletInputData.a("offer_id", str);
        offerClaimToWalletInputData.a("share_id", str2);
        offerClaimToWalletInputData.a("actor_id", str3);
        offerClaimToWalletInputData.a("client_mutation_id", SafeUUIDGenerator.a().toString());
        GraphQlQueryString offerClaimToWalletMutationString = new OfferClaimToWalletMutationString();
        offerClaimToWalletMutationString.a("input", offerClaimToWalletInputData).a("profile_pic_width", Integer.valueOf(Math.max(100, i / 4))).a("creative_img_size", Integer.valueOf(i));
        return this.f16186a.a(GraphQLRequest.a(offerClaimToWalletMutationString));
    }

    public final ListenableFuture<GraphQLResult<OfferViewClaimToWalletMutationModel>> m18997b(String str, String str2, int i, String str3) {
        OfferViewClaimToWalletInputData offerViewClaimToWalletInputData = new OfferViewClaimToWalletInputData();
        offerViewClaimToWalletInputData.a("offer_view_id", str);
        offerViewClaimToWalletInputData.a("share_id", str2);
        offerViewClaimToWalletInputData.a("actor_id", str3);
        offerViewClaimToWalletInputData.a("client_mutation_id", SafeUUIDGenerator.a().toString());
        GraphQlQueryString offerViewClaimToWalletMutationString = new OfferViewClaimToWalletMutationString();
        offerViewClaimToWalletMutationString.a("input", offerViewClaimToWalletInputData).a("profile_pic_width", Integer.valueOf(Math.max(100, i / 4))).a("creative_img_size", Integer.valueOf(i));
        return this.f16186a.a(GraphQLRequest.a(offerViewClaimToWalletMutationString));
    }

    public final ListenableFuture<GraphQLResult<OfferViewRemoveFromWalletMutationModel>> m18994a(String str, String str2) {
        OfferViewRemoveFromWalletInputData offerViewRemoveFromWalletInputData = new OfferViewRemoveFromWalletInputData();
        offerViewRemoveFromWalletInputData.a("offer_view_id", str);
        offerViewRemoveFromWalletInputData.a("actor_id", str2);
        offerViewRemoveFromWalletInputData.a("client_mutation_id", SafeUUIDGenerator.a().toString());
        GraphQlQueryString offerViewRemoveFromWalletMutationString = new OfferViewRemoveFromWalletMutationString();
        offerViewRemoveFromWalletMutationString.a("input", offerViewRemoveFromWalletInputData);
        return this.f16186a.a(GraphQLRequest.a(offerViewRemoveFromWalletMutationString));
    }
}
