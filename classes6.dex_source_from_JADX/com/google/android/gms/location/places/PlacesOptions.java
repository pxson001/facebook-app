package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Api.ApiOptions.Optional;

public final class PlacesOptions implements Optional {
    public final String f6475a;
    public final int f6476b;

    public class Builder {
        public String f6473a;
        public int f6474b = 0;

        public final PlacesOptions m8971a() {
            return new PlacesOptions(this);
        }
    }

    public PlacesOptions(Builder builder) {
        this.f6475a = builder.f6473a;
        this.f6476b = builder.f6474b;
    }
}
