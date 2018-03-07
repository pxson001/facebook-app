package com.facebook.groupcommerce.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.groupcommerce.protocol.GroupCommerceProductItemMutationsModels.ProductItemChangeAvailabilityCoreMutationFieldsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: recent_live_viewer_invitees */
public final class GroupCommerceProductItemMutations {

    /* compiled from: recent_live_viewer_invitees */
    public class ProductItemChangeAvailabilityCoreMutationString extends TypedGraphQLMutationString<ProductItemChangeAvailabilityCoreMutationFieldsModel> {
        public ProductItemChangeAvailabilityCoreMutationString() {
            super(ProductItemChangeAvailabilityCoreMutationFieldsModel.class, false, "ProductItemChangeAvailabilityCoreMutation", "7a054a811649ff486cc412423db94bb0", "product_item_change_availability", "0", "10154529823201729", RegularImmutableSet.a);
        }

        public final String m5964a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
