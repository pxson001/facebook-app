package com.facebook.commerce.publishing.mutator;

import com.facebook.commerce.publishing.event.CommercePublishingEventBus;
import com.facebook.commerce.publishing.event.CommercePublishingMutationEvent.Method;
import com.facebook.commerce.publishing.event.ProductItemMutationEvent;
import com.facebook.commerce.publishing.graphql.CommerceProductCreateMutation.CommerceProductCreateMutationString;
import com.facebook.commerce.publishing.graphql.CommerceProductCreateMutationModels.CommerceProductCreateMutationFieldsModel;
import com.facebook.commerce.publishing.graphql.CommerceProductDeleteMutationModels.CommerceProductDeleteMutationModel;
import com.facebook.commerce.publishing.graphql.CommerceProductEditMutation.CommerceProductEditMutationString;
import com.facebook.commerce.publishing.graphql.CommerceProductEditMutationModels.CommerceProductEditMutationFieldsModel;
import com.facebook.commerce.publishing.graphql.CommerceProductItemMutateParams;
import com.facebook.commerce.publishing.graphql.CommercePublishingGraphQLUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.graphql.calls.CommerceProductItemCreateInputData;
import com.facebook.graphql.calls.CommerceProductItemCreateInputData.CommerceFeaturedItem;
import com.facebook.graphql.calls.CommerceProductItemCreateInputData.ProductItemPrice;
import com.facebook.graphql.calls.CommerceProductItemCreateInputData.ShareToTimeline;
import com.facebook.graphql.calls.CommerceProductItemUpdateInputData;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: place_website_uri */
public class ProductItemMutator {
    public final GraphQLQueryExecutor f7677a;
    public final CommercePublishingEventBus f7678b;
    public final ProductItemPendingMutationsCache f7679c;
    private final GraphQLCacheManager f7680d;

    /* compiled from: place_website_uri */
    public class C04531 implements FutureCallback<GraphQLResult<CommerceProductDeleteMutationModel>> {
        final /* synthetic */ String f7671a;
        final /* synthetic */ ProductItemMutator f7672b;

        public C04531(ProductItemMutator productItemMutator, String str) {
            this.f7672b = productItemMutator;
            this.f7671a = str;
        }

        public void onSuccess(@Nullable Object obj) {
            ProductItemMutator.m10985a(this.f7672b);
            this.f7672b.f7678b.a(ProductItemMutationEvent.m10705a(Method.DELETE, null, this.f7671a));
        }

        public void onFailure(Throwable th) {
            this.f7672b.f7678b.a(ProductItemMutationEvent.m10706a(Method.DELETE, this.f7671a));
        }
    }

    public static ProductItemMutator m10984a(InjectorLike injectorLike) {
        return new ProductItemMutator(GraphQLQueryExecutor.a(injectorLike), CommercePublishingEventBus.m10701a(injectorLike), ProductItemPendingMutationsCache.m10990a(injectorLike), GraphQLCacheManager.a(injectorLike));
    }

    @Inject
    public ProductItemMutator(GraphQLQueryExecutor graphQLQueryExecutor, CommercePublishingEventBus commercePublishingEventBus, ProductItemPendingMutationsCache productItemPendingMutationsCache, GraphQLCacheManager graphQLCacheManager) {
        this.f7677a = graphQLQueryExecutor;
        this.f7678b = commercePublishingEventBus;
        this.f7679c = productItemPendingMutationsCache;
        this.f7680d = graphQLCacheManager;
    }

    public final void m10987a(final CommerceProductItemMutateParams commerceProductItemMutateParams) {
        if (StringUtil.a(commerceProductItemMutateParams.f7586a)) {
            CommercePublishingGraphQLUtils.m10734c(commerceProductItemMutateParams);
            CommerceProductItemCreateInputData commerceProductItemCreateInputData = new CommerceProductItemCreateInputData();
            commerceProductItemCreateInputData.a("actor_id", commerceProductItemMutateParams.f7587b);
            GraphQlCallInput graphQlCallInput = commerceProductItemCreateInputData;
            graphQlCallInput.a("page_id", commerceProductItemMutateParams.f7588c);
            graphQlCallInput = graphQlCallInput;
            if (commerceProductItemMutateParams.f7589d != null) {
                graphQlCallInput.a("name", commerceProductItemMutateParams.f7589d);
            }
            if (commerceProductItemMutateParams.f7590e != null) {
                graphQlCallInput.a("description", commerceProductItemMutateParams.f7590e);
            }
            if (commerceProductItemMutateParams.f7593h != null) {
                graphQlCallInput.a("group_id", commerceProductItemMutateParams.f7593h);
            }
            if (commerceProductItemMutateParams.f7592g != null) {
                ProductItemPrice productItemPrice = new ProductItemPrice();
                productItemPrice.a("amount_in_hundredths", commerceProductItemMutateParams.f7592g);
                GraphQlCallInput graphQlCallInput2 = productItemPrice;
                graphQlCallInput2.a("currency", commerceProductItemMutateParams.f7591f);
                graphQlCallInput.a("product_item_price", graphQlCallInput2);
            }
            if (!(commerceProductItemMutateParams.f7594i == null || commerceProductItemMutateParams.f7594i.isEmpty())) {
                graphQlCallInput.a("image_ids", commerceProductItemMutateParams.f7594i);
            }
            if (commerceProductItemMutateParams.f7595j == TriState.YES) {
                graphQlCallInput.a(CommerceFeaturedItem.TRUE);
            } else if (commerceProductItemMutateParams.f7595j == TriState.NO) {
                graphQlCallInput.a(CommerceFeaturedItem.FALSE);
            }
            if (commerceProductItemMutateParams.f7596k == TriState.YES) {
                graphQlCallInput.a(ShareToTimeline.TRUE);
            } else if (commerceProductItemMutateParams.f7596k == TriState.NO) {
                graphQlCallInput.a(ShareToTimeline.FALSE);
            }
            MutationRequest a = GraphQLRequest.a((CommerceProductCreateMutationString) new CommerceProductCreateMutationString().a("input", graphQlCallInput));
            a.e = commerceProductItemMutateParams.f7599n;
            Futures.a(this.f7677a.a(a), new FutureCallback<GraphQLResult<CommerceProductCreateMutationFieldsModel>>(this) {
                final /* synthetic */ ProductItemMutator f7674b;

                public void onSuccess(@Nullable Object obj) {
                    GraphQLResult graphQLResult = (GraphQLResult) obj;
                    this.f7674b.f7679c.m10995a(commerceProductItemMutateParams.f7598m);
                    ProductItemMutator.m10985a(this.f7674b);
                    if (graphQLResult != null) {
                        this.f7674b.f7678b.a(ProductItemMutationEvent.m10705a(Method.CREATE, ((CommerceProductCreateMutationFieldsModel) graphQLResult.e).m10711a(), commerceProductItemMutateParams.f7598m));
                    } else {
                        this.f7674b.f7678b.a(ProductItemMutationEvent.m10706a(Method.CREATE, commerceProductItemMutateParams.f7598m));
                    }
                }

                public void onFailure(Throwable th) {
                    this.f7674b.f7679c.m10995a(commerceProductItemMutateParams.f7598m);
                    this.f7674b.f7678b.a(ProductItemMutationEvent.m10706a(Method.CREATE, commerceProductItemMutateParams.f7598m));
                }
            }, MoreExecutors.a());
            return;
        }
        m10986c(commerceProductItemMutateParams);
    }

    private void m10986c(final CommerceProductItemMutateParams commerceProductItemMutateParams) {
        CommercePublishingGraphQLUtils.m10734c(commerceProductItemMutateParams);
        CommerceProductItemUpdateInputData commerceProductItemUpdateInputData = new CommerceProductItemUpdateInputData();
        commerceProductItemUpdateInputData.a("id", commerceProductItemMutateParams.f7586a);
        GraphQlCallInput graphQlCallInput = commerceProductItemUpdateInputData;
        graphQlCallInput.a("actor_id", commerceProductItemMutateParams.f7587b);
        graphQlCallInput = graphQlCallInput;
        if (commerceProductItemMutateParams.f7589d != null) {
            graphQlCallInput.a("name", commerceProductItemMutateParams.f7589d);
        }
        if (commerceProductItemMutateParams.f7590e != null) {
            graphQlCallInput.a("description", commerceProductItemMutateParams.f7590e);
        }
        if (commerceProductItemMutateParams.f7593h != null) {
            graphQlCallInput.a("group_id", commerceProductItemMutateParams.f7593h);
        }
        if (commerceProductItemMutateParams.f7592g != null) {
            CommerceProductItemUpdateInputData.ProductItemPrice productItemPrice = new CommerceProductItemUpdateInputData.ProductItemPrice();
            productItemPrice.a("amount_in_hundredths", commerceProductItemMutateParams.f7592g);
            GraphQlCallInput graphQlCallInput2 = productItemPrice;
            graphQlCallInput2.a("currency", commerceProductItemMutateParams.f7591f);
            graphQlCallInput.a("product_item_price", graphQlCallInput2);
        }
        if (!(commerceProductItemMutateParams.f7594i == null || commerceProductItemMutateParams.f7594i.isEmpty())) {
            graphQlCallInput.a("image_ids", commerceProductItemMutateParams.f7594i);
        }
        if (commerceProductItemMutateParams.f7595j == TriState.YES) {
            graphQlCallInput.a(CommerceProductItemUpdateInputData.CommerceFeaturedItem.TRUE);
        } else if (commerceProductItemMutateParams.f7595j == TriState.NO) {
            graphQlCallInput.a(CommerceProductItemUpdateInputData.CommerceFeaturedItem.FALSE);
        }
        MutationRequest a = GraphQLRequest.a((CommerceProductEditMutationString) new CommerceProductEditMutationString().a("input", graphQlCallInput));
        a.e = commerceProductItemMutateParams.f7599n;
        Futures.a(this.f7677a.a(a), new FutureCallback<GraphQLResult<CommerceProductEditMutationFieldsModel>>(this) {
            final /* synthetic */ ProductItemMutator f7676b;

            public void onSuccess(@Nullable Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                this.f7676b.f7679c.m10995a(commerceProductItemMutateParams.f7598m);
                ProductItemMutator.m10985a(this.f7676b);
                if (graphQLResult != null) {
                    this.f7676b.f7678b.a(ProductItemMutationEvent.m10705a(Method.EDIT, ((CommerceProductEditMutationFieldsModel) graphQLResult.e).m10725a(), commerceProductItemMutateParams.f7598m));
                } else {
                    this.f7676b.f7678b.a(ProductItemMutationEvent.m10706a(Method.EDIT, commerceProductItemMutateParams.f7598m));
                }
            }

            public void onFailure(Throwable th) {
                this.f7676b.f7679c.m10995a(commerceProductItemMutateParams.f7598m);
                this.f7676b.f7678b.a(ProductItemMutationEvent.m10706a(Method.EDIT, commerceProductItemMutateParams.f7598m));
            }
        }, MoreExecutors.a());
    }

    public static void m10985a(ProductItemMutator productItemMutator) {
        productItemMutator.f7680d.a(ImmutableSet.of("GraphQLCommerceRequestTag"));
    }
}
