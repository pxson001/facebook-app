package com.facebook.offers.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.offers.graphql.OfferQueriesModels.OfferDetailQueryModel;
import com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: current_page */
public final class OfferQueries {

    /* compiled from: current_page */
    public class OfferDetailQueryString extends TypedGraphQlQueryString<OfferDetailQueryModel> {
        public OfferDetailQueryString() {
            super(OfferDetailQueryModel.class, false, "OfferDetailQuery", "98a71abb98664e7bd01a9ebfbaca6dbe", "node", "10154648648101729", RegularImmutableSet.a);
        }

        public final String m19079a(String str) {
            switch (str.hashCode()) {
                case -1054754885:
                    return "2";
                case -958703219:
                    return "1";
                case 3355:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: current_page */
    public class OffersWalletQueryString extends TypedGraphQlQueryString<OffersWalletQueryModel> {
        public OffersWalletQueryString() {
            super(OffersWalletQueryModel.class, false, "OffersWalletQuery", "72be453c675ebced28fd420f8c9a2ac2", "viewer", "10154648648056729", RegularImmutableSet.a);
        }

        public final String m19080a(String str) {
            switch (str.hashCode()) {
                case -1422950650:
                    return "0";
                case -1054754885:
                    return "4";
                case -958703219:
                    return "3";
                case 16907033:
                    return "1";
                case 94851343:
                    return "2";
                default:
                    return str;
            }
        }

        protected final boolean m19081a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 50:
                    if (str.equals("2")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "30".equals(obj);
                    }
                    return (obj instanceof Integer) && ((Integer) obj).intValue() == 30;
                default:
                    return false;
            }
        }
    }
}
