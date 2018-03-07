package com.facebook.graphql.calls;

import java.util.List;

/* compiled from: pymk_email */
public final class GeocodeAddressInputQueryParams extends GraphQlCallInput {

    /* compiled from: pymk_email */
    public final class Addresses extends GraphQlCallInput {

        /* compiled from: pymk_email */
        public final class City extends GraphQlCallInput {
        }

        /* compiled from: pymk_email */
        public final class Street extends GraphQlCallInput {
        }

        public final Addresses m4424a(String str) {
            a("street_address", str);
            return this;
        }
    }

    public final GeocodeAddressInputQueryParams m4425a(List<Addresses> list) {
        a("addresses", list);
        return this;
    }
}
