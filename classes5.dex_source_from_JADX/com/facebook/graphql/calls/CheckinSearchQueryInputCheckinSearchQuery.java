package com.facebook.graphql.calls;

/* compiled from: redspace_story */
public final class CheckinSearchQueryInputCheckinSearchQuery extends GraphQlCallInput {

    /* compiled from: redspace_story */
    public final class ViewerCoordinates extends GraphQlCallInput {
        public final ViewerCoordinates m4331a(Double d) {
            a("latitude", d);
            return this;
        }

        public final ViewerCoordinates m4332b(Double d) {
            a("longitude", d);
            return this;
        }

        public final ViewerCoordinates m4333c(Double d) {
            a("accuracy", d);
            return this;
        }

        public final ViewerCoordinates m4334d(Double d) {
            a("speed", d);
            return this;
        }

        public final ViewerCoordinates m4335e(Double d) {
            a("stale_time", d);
            return this;
        }
    }

    public final CheckinSearchQueryInputCheckinSearchQuery m4337a(String str) {
        a("query", str);
        return this;
    }

    public final CheckinSearchQueryInputCheckinSearchQuery m4336a(ViewerCoordinates viewerCoordinates) {
        a("viewer_coordinates", viewerCoordinates);
        return this;
    }

    public final CheckinSearchQueryInputCheckinSearchQuery m4338b(String str) {
        a("location_extra_data", str);
        return this;
    }
}
