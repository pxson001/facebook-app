package com.facebook.messaging.payment.model.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.FetchAllMoreTransactionsQueryModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.FetchAllThemesQueryModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.FetchAllTransactionListQueryModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.FetchIncomingMoreTransactionsQueryModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.FetchIncomingPaymentRequestsQueryModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.FetchIncomingTransactionListQueryModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.FetchOutgoingMoreTransactionsQueryModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.FetchOutgoingPaymentRequestsQueryModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.FetchOutgoingTransactionListQueryModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.FetchPaymentAccountEnabledStatusQueryModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.FetchPaymentPinStatusQueryModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.FetchPaymentPlatformContextsQueryModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.FetchShippingAddressQueryModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PageInfoModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformContextModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentTransactionModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: help_link */
public final class PaymentGraphQL {

    /* compiled from: help_link */
    public class FetchAllMoreTransactionsQueryString extends TypedGraphQlQueryString<FetchAllMoreTransactionsQueryModel> {
        public FetchAllMoreTransactionsQueryString() {
            super(FetchAllMoreTransactionsQueryModel.class, false, "FetchAllMoreTransactionsQuery", "469ef2c8164b2191c0968e7e5596e138", "viewer", "10154686281316729", RegularImmutableSet.a);
        }

        public final String m13556a(String str) {
            switch (str.hashCode()) {
                case -1094868083:
                    return "0";
                case -296865712:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: help_link */
    public class FetchAllThemesQueryString extends TypedGraphQlQueryString<FetchAllThemesQueryModel> {
        public FetchAllThemesQueryString() {
            super(FetchAllThemesQueryModel.class, false, "FetchAllThemesQuery", "fa9934cd8d3439f5f517b3ebf8cbd658", "messenger_pay_theme_list", "10154360844071729", RegularImmutableSet.a);
        }
    }

    /* compiled from: help_link */
    public class FetchAllTransactionListQueryString extends TypedGraphQlQueryString<FetchAllTransactionListQueryModel> {
        public FetchAllTransactionListQueryString() {
            super(FetchAllTransactionListQueryModel.class, false, "FetchAllTransactionListQuery", "60cb81c5ad85a859f80777295c178caa", "viewer", "10154686281291729", RegularImmutableSet.a);
        }

        public final String m13557a(String str) {
            switch (str.hashCode()) {
                case -296865712:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: help_link */
    public class FetchIncomingMoreTransactionsQueryString extends TypedGraphQlQueryString<FetchIncomingMoreTransactionsQueryModel> {
        public FetchIncomingMoreTransactionsQueryString() {
            super(FetchIncomingMoreTransactionsQueryModel.class, false, "FetchIncomingMoreTransactionsQuery", "0ce2af66f5cc75819586445a6ec17184", "viewer", "10154686378476729", RegularImmutableSet.a);
        }

        public final String m13558a(String str) {
            switch (str.hashCode()) {
                case -1094868083:
                    return "0";
                case -296865712:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: help_link */
    public class FetchIncomingPaymentRequestsQueryString extends TypedGraphQlQueryString<FetchIncomingPaymentRequestsQueryModel> {
        public FetchIncomingPaymentRequestsQueryString() {
            super(FetchIncomingPaymentRequestsQueryModel.class, false, "FetchIncomingPaymentRequestsQuery", "020083387db2b0970bee2a192acae7d8", "viewer", "10154686281536729", RegularImmutableSet.a);
        }
    }

    /* compiled from: help_link */
    public class FetchIncomingTransactionListQueryString extends TypedGraphQlQueryString<FetchIncomingTransactionListQueryModel> {
        public FetchIncomingTransactionListQueryString() {
            super(FetchIncomingTransactionListQueryModel.class, false, "FetchIncomingTransactionListQuery", "4f82181acb2f5a69afddde984f2f5d6a", "viewer", "10154686378391729", RegularImmutableSet.a);
        }

        public final String m13559a(String str) {
            switch (str.hashCode()) {
                case -296865712:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: help_link */
    public class FetchOutgoingMoreTransactionsQueryString extends TypedGraphQlQueryString<FetchOutgoingMoreTransactionsQueryModel> {
        public FetchOutgoingMoreTransactionsQueryString() {
            super(FetchOutgoingMoreTransactionsQueryModel.class, false, "FetchOutgoingMoreTransactionsQuery", "0826669916fd16548b80ba6d1d0b5d6e", "viewer", "10154686378411729", RegularImmutableSet.a);
        }

        public final String m13560a(String str) {
            switch (str.hashCode()) {
                case -1094868083:
                    return "0";
                case -296865712:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: help_link */
    public class FetchOutgoingPaymentRequestsQueryString extends TypedGraphQlQueryString<FetchOutgoingPaymentRequestsQueryModel> {
        public FetchOutgoingPaymentRequestsQueryString() {
            super(FetchOutgoingPaymentRequestsQueryModel.class, false, "FetchOutgoingPaymentRequestsQuery", "ca912ad3262f05715b4cf15610829f5d", "viewer", "10154686281516729", RegularImmutableSet.a);
        }
    }

    /* compiled from: help_link */
    public class FetchOutgoingTransactionListQueryString extends TypedGraphQlQueryString<FetchOutgoingTransactionListQueryModel> {
        public FetchOutgoingTransactionListQueryString() {
            super(FetchOutgoingTransactionListQueryModel.class, false, "FetchOutgoingTransactionListQuery", "588f6f605d5526b0cec07498292d45d2", "viewer", "10154686378396729", RegularImmutableSet.a);
        }

        public final String m13561a(String str) {
            switch (str.hashCode()) {
                case -296865712:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: help_link */
    public class FetchPageInfoQueryString extends TypedGraphQlQueryString<PageInfoModel> {
        public FetchPageInfoQueryString() {
            super(PageInfoModel.class, false, "FetchPageInfoQuery", "6943a35f2c2f3404e3c18be87fcd9af2", "page", "10154605800266729", RegularImmutableSet.a);
        }

        public final String m13562a(String str) {
            switch (str.hashCode()) {
                case -803548981:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: help_link */
    public class FetchPaymentAccountEnabledStatusQueryString extends TypedGraphQlQueryString<FetchPaymentAccountEnabledStatusQueryModel> {
        public FetchPaymentAccountEnabledStatusQueryString() {
            super(FetchPaymentAccountEnabledStatusQueryModel.class, false, "FetchPaymentAccountEnabledStatusQuery", "acd86800338bd14e0430d36fb2ee7270", "viewer", "10154453773766729", RegularImmutableSet.a);
        }
    }

    /* compiled from: help_link */
    public class FetchPaymentPinStatusQueryString extends TypedGraphQlQueryString<FetchPaymentPinStatusQueryModel> {
        public FetchPaymentPinStatusQueryString() {
            super(FetchPaymentPinStatusQueryModel.class, false, "FetchPaymentPinStatusQuery", "aa7c511a8b23f322c766e94141363255", "viewer", "10154542922916729", RegularImmutableSet.a);
        }
    }

    /* compiled from: help_link */
    public class FetchPaymentPlatformContextQueryString extends TypedGraphQlQueryString<PaymentPlatformContextModel> {
        public FetchPaymentPlatformContextQueryString() {
            super(PaymentPlatformContextModel.class, false, "FetchPaymentPlatformContextQuery", "9e2d4f78b8ee4e7644cd0fcb3044fadb", "node", "10154686281576729", RegularImmutableSet.a);
        }

        public final String m13563a(String str) {
            switch (str.hashCode()) {
                case 961470711:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: help_link */
    public class FetchPaymentPlatformContextsQueryString extends TypedGraphQlQueryString<FetchPaymentPlatformContextsQueryModel> {
        public FetchPaymentPlatformContextsQueryString() {
            super(FetchPaymentPlatformContextsQueryModel.class, false, "FetchPaymentPlatformContextsQuery", "43ae37138f14967e3704edd4f535e5df", "viewer", "10154686281476729", RegularImmutableSet.a);
        }
    }

    /* compiled from: help_link */
    public class FetchPaymentRequestQueryString extends TypedGraphQlQueryString<PaymentRequestModel> {
        public FetchPaymentRequestQueryString() {
            super(PaymentRequestModel.class, false, "FetchPaymentRequestQuery", "29c80b6600831bdb49cc05d27976d07a", "node", "10154686281551729", RegularImmutableSet.a);
        }

        public final String m13564a(String str) {
            switch (str.hashCode()) {
                case 37109963:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: help_link */
    public class FetchPaymentTransactionQueryString extends TypedGraphQlQueryString<PaymentTransactionModel> {
        public FetchPaymentTransactionQueryString() {
            super(PaymentTransactionModel.class, false, "FetchPaymentTransactionQuery", "046921c42801a8728b01a34e1b664355", "node", "10154686281326729", RegularImmutableSet.a);
        }

        public final String m13565a(String str) {
            switch (str.hashCode()) {
                case 1010584092:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: help_link */
    public class FetchShippingAddressQueryString extends TypedGraphQlQueryString<FetchShippingAddressQueryModel> {
        public FetchShippingAddressQueryString() {
            super(FetchShippingAddressQueryModel.class, false, "FetchShippingAddressQuery", "889a9404ad6ba6360895970250cdfa14", "user", "10154626030746729", RegularImmutableSet.a);
        }

        public final String m13566a(String str) {
            switch (str.hashCode()) {
                case -147132913:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
