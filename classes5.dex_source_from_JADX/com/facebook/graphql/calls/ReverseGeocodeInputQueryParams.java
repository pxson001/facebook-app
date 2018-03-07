package com.facebook.graphql.calls;

import java.util.List;

/* compiled from: post_approval_required */
public final class ReverseGeocodeInputQueryParams extends GraphQlCallInput {

    /* compiled from: post_approval_required */
    public final class GpsPoints extends GraphQlCallInput {
        public final GpsPoints m4482a(Double d) {
            a("latitude", d);
            return this;
        }

        public final GpsPoints m4483b(Double d) {
            a("longitude", d);
            return this;
        }
    }

    public final ReverseGeocodeInputQueryParams m4484a(List<GpsPoints> list) {
        a("gps_points", list);
        return this;
    }
}
