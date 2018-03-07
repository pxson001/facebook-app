package com.facebook.commerce.publishing.graphql;

import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsModels.ProductItemPriceFieldsModel;
import com.facebook.graphql.enums.GraphQLCommerceProductVisibility;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: post_composition_closed */
public class CommercePublishingQueryFragmentsInterfaces {

    /* compiled from: post_composition_closed */
    public interface AdminCommerceProductItem {
        boolean mo910b();

        @Nullable
        GraphQLCommerceProductVisibility mo911c();

        @Nullable
        String cu_();

        @Nonnull
        ImmutableList<? extends OrderedImages> cv_();

        @Nonnull
        ImmutableList<? extends ProductImageLarge> cw_();

        @Nullable
        String mo915d();

        @Nullable
        String mo916g();

        @Nullable
        ProductItemPriceFieldsModel mo917j();
    }

    /* compiled from: post_composition_closed */
    public interface FeaturedProductCount {
    }
}
