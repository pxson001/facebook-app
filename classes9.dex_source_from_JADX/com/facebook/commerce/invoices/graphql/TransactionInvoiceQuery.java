package com.facebook.commerce.invoices.graphql;

import com.facebook.commerce.invoices.graphql.TransactionInvoiceQueryModels.TransactionInvoiceQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: quickcam_popup */
public final class TransactionInvoiceQuery {

    /* compiled from: quickcam_popup */
    public class TransactionInvoiceQueryString extends TypedGraphQlQueryString<TransactionInvoiceQueryModel> {
        public TransactionInvoiceQueryString() {
            super(TransactionInvoiceQueryModel.class, false, "TransactionInvoiceQuery", "b4cea841b9c5e30ab60e13237a3aeaf8", "node", "10154686010506729", RegularImmutableSet.a);
        }

        public final String m6148a(String str) {
            switch (str.hashCode()) {
                case 316618177:
                    return "2";
                case 1010584092:
                    return "0";
                case 1872584908:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
