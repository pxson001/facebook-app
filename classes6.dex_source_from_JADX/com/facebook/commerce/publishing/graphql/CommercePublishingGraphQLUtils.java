package com.facebook.commerce.publishing.graphql;

import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsModels.ProductItemPriceFieldsModel;
import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsInterfaces.AdminCommerceProductItem;
import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsModels.AdminCommerceProductItemModel.Builder;
import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsModels.AdminCommerceProductItemModel.OrderedImagesModel;
import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsModels.AdminCommerceProductItemModel.OrderedImagesModel.ImageModel;
import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsModels.AdminCommerceProductItemModel.ProductImageLargeModel;
import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsModels.FeaturedProductCountModel.OrderedCollectionsModel;
import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsModels.FeaturedProductCountModel.OrderedCollectionsModel.NodesModel;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: post_composition_opened */
public class CommercePublishingGraphQLUtils {
    private CommercePublishingGraphQLUtils() {
    }

    public static AdminCommerceProductItem m10733a(String str, String str2, String str3, boolean z, ProductItemPriceFieldsModel productItemPriceFieldsModel, String str4) {
        Builder builder = new Builder();
        builder.f7603d = str;
        builder = builder;
        builder.f7604e = str2;
        builder = builder;
        builder.f7602c = str3;
        builder = builder;
        builder.f7600a = z;
        builder = builder;
        ProductItemPriceFieldsModel.Builder builder2 = new ProductItemPriceFieldsModel.Builder();
        builder2.f7498b = productItemPriceFieldsModel.m10619b();
        builder2 = builder2;
        builder2.f7497a = productItemPriceFieldsModel.m10615a();
        builder.f7607h = builder2.m10611a();
        builder = builder;
        ImmutableList.Builder builder3 = new ImmutableList.Builder();
        OrderedImagesModel.Builder builder4 = new OrderedImagesModel.Builder();
        ImageModel.Builder builder5 = new ImageModel.Builder();
        builder5.f7610a = str4;
        builder5 = builder5;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int b = flatBufferBuilder.b(builder5.f7610a);
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        builder4.f7609b = new ImageModel(new MutableFlatBuffer(wrap, null, null, true, null));
        builder.f7605f = builder3.c(builder4.m10742a()).b();
        builder = builder;
        builder3 = new ImmutableList.Builder();
        ProductImageLargeModel.Builder builder6 = new ProductImageLargeModel.Builder();
        ProductImageLargeModel.ImageModel.Builder builder7 = new ProductImageLargeModel.ImageModel.Builder();
        builder7.f7616a = str4;
        builder6.f7615b = builder7.m10758a();
        builder.f7606g = builder3.c(builder6.m10756a()).b();
        return builder.m10740a();
    }

    public static int m10732a(@Nullable OrderedCollectionsModel orderedCollectionsModel) {
        if (orderedCollectionsModel == null || orderedCollectionsModel.m10799a().isEmpty() || ((NodesModel) orderedCollectionsModel.m10799a().get(0)).m10794a() == null) {
            return 0;
        }
        return ((NodesModel) orderedCollectionsModel.m10799a().get(0)).m10794a().m10786a();
    }

    public static void m10734c(CommerceProductItemMutateParams commerceProductItemMutateParams) {
        ImmutableList immutableList = commerceProductItemMutateParams.f7594i;
        if (immutableList != null) {
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                boolean z;
                if ("pending_media_item_upload".equals((String) immutableList.get(i))) {
                    z = false;
                } else {
                    z = true;
                }
                Preconditions.checkState(z);
            }
        }
    }
}
