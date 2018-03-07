package com.facebook.adinterfaces.model;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: \d{3} */
public class AdInterfacesInsightsViewModel {
    public final int f21704a;
    public final String f21705b;
    public final String f21706c;
    public ImmutableList<String> f21707d;
    public ImmutableList<String> f21708e;
    public ImmutableList<Float> f21709f;
    public ImmutableList<Integer> f21710g;

    /* compiled from: \d{3} */
    public class Builder {
        public String f21697a;
        public String f21698b;
        public ImmutableList<String> f21699c;
        public ImmutableList<String> f21700d;
        public ImmutableList<Float> f21701e;
        public ImmutableList<Integer> f21702f;
        public int f21703g;

        public final AdInterfacesInsightsViewModel m22829a() {
            return new AdInterfacesInsightsViewModel(this);
        }
    }

    public AdInterfacesInsightsViewModel(Builder builder) {
        boolean z = true;
        boolean z2 = builder.f21703g == 2 || builder.f21703g == 3;
        Preconditions.checkArgument(z2);
        this.f21704a = builder.f21703g;
        if (builder.f21700d.size() == this.f21704a) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "The number of components does not match the size of the label list");
        if (builder.f21699c.size() == this.f21704a) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "The number of components does not match the size of the data text list");
        if (builder.f21701e.size() == this.f21704a) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "The number of components does not match the size of the weight list");
        if (builder.f21702f.size() != this.f21704a) {
            z = false;
        }
        Preconditions.checkArgument(z, "The number of components does not match the size of the color list");
        this.f21708e = builder.f21700d;
        this.f21707d = builder.f21699c;
        this.f21709f = builder.f21701e;
        this.f21710g = builder.f21702f;
        this.f21705b = builder.f21697a;
        this.f21706c = builder.f21698b;
    }
}
