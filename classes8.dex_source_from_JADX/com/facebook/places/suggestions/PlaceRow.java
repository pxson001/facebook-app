package com.facebook.places.suggestions;

import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.google.common.base.Preconditions;

/* compiled from: secondary_text */
public class PlaceRow {
    public final CheckinPlaceModel f3645a;
    public final boolean f3646b;
    public final boolean f3647c;
    public final boolean f3648d;
    public boolean f3649e;

    /* compiled from: secondary_text */
    public class Builder {
        public final CheckinPlaceModel f3641a;
        public boolean f3642b = false;
        public boolean f3643c = false;
        public boolean f3644d = true;

        public Builder(CheckinPlaceModel checkinPlaceModel) {
            this.f3641a = (CheckinPlaceModel) Preconditions.checkNotNull(checkinPlaceModel);
        }

        public final PlaceRow m3582a() {
            return new PlaceRow(this);
        }
    }

    public static Builder m3583a(CheckinPlaceModel checkinPlaceModel) {
        return new Builder(checkinPlaceModel);
    }

    public final void m3584a(boolean z) {
        Preconditions.checkState(this.f3646b);
        this.f3649e = z;
    }

    public PlaceRow(Builder builder) {
        this.f3645a = builder.f3641a;
        this.f3646b = builder.f3642b;
        this.f3647c = builder.f3643c;
        this.f3648d = builder.f3644d;
    }
}
