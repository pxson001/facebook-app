package com.facebook.messaging.payment.model.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.messaging.payment.model.graphql.PaymentMutationsModels.CreateCommerceCartP2pPlatformContextCoreMutationModel;
import com.facebook.messaging.payment.model.graphql.PaymentMutationsModels.CreateP2pPlatformContextCoreMutationModel;
import com.facebook.messaging.payment.model.graphql.PaymentMutationsModels.P2pPlatformContextSetShippingAddressMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: headerTitle */
public final class PaymentMutations {

    /* compiled from: headerTitle */
    public class CreateCommerceCartP2pPlatformContextCoreMutationString extends TypedGraphQLMutationString<CreateCommerceCartP2pPlatformContextCoreMutationModel> {
        public CreateCommerceCartP2pPlatformContextCoreMutationString() {
            super(CreateCommerceCartP2pPlatformContextCoreMutationModel.class, false, "CreateCommerceCartP2pPlatformContextCoreMutation", "25280628b3fc0af24e1d0596c31d6195", "create_commerce_cart_p2p_platform_context", "0", "10154686281486729", RegularImmutableSet.a);
        }

        public final String m14034a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: headerTitle */
    public class CreateP2pPlatformContextCoreMutationString extends TypedGraphQLMutationString<CreateP2pPlatformContextCoreMutationModel> {
        public CreateP2pPlatformContextCoreMutationString() {
            super(CreateP2pPlatformContextCoreMutationModel.class, false, "CreateP2pPlatformContextCoreMutation", "9960189e480a3952d21c87a46389cb70", "create_p2p_platform_context", "0", "10154204803876729", RegularImmutableSet.a);
        }

        public final String m14035a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: headerTitle */
    public class P2pPlatformContextSetShippingAddressMutationString extends TypedGraphQLMutationString<P2pPlatformContextSetShippingAddressMutationModel> {
        public P2pPlatformContextSetShippingAddressMutationString() {
            super(P2pPlatformContextSetShippingAddressMutationModel.class, false, "P2pPlatformContextSetShippingAddressMutation", "39bf709d5b5dff4c179452ffa98a922e", "p2p_platform_context_set_shipping_address", "0", "10154686281526729", RegularImmutableSet.a);
        }

        public final String m14036a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
