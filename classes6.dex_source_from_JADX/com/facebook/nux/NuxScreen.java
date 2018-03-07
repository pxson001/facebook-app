package com.facebook.nux;

import android.content.res.Resources;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: isRequestedServerSettings */
public class NuxScreen {
    public final boolean f12229a;
    public final boolean f12230b;
    @Nullable
    public final String f12231c;
    @Nullable
    public final String f12232d;
    public final Optional<String> f12233e;
    public final String f12234f;
    public final int f12235g;
    public final String f12236h;
    public final Optional<NuxScreenController> f12237i;

    /* compiled from: isRequestedServerSettings */
    public class Builder {
        public boolean f12218a = false;
        public boolean f12219b = false;
        public String f12220c = null;
        public String f12221d = null;
        public Optional<String> f12222e = Absent.INSTANCE;
        public String f12223f = null;
        public int f12224g;
        public boolean f12225h = false;
        public String f12226i = null;
        public Optional<NuxScreenController> f12227j = Absent.INSTANCE;
        public final Resources f12228k;

        public Builder(Resources resources) {
            this.f12228k = resources;
        }
    }

    public NuxScreen(Builder builder) {
        this.f12229a = builder.f12218a;
        this.f12230b = builder.f12219b;
        this.f12231c = builder.f12220c;
        this.f12232d = builder.f12221d;
        this.f12233e = builder.f12222e;
        this.f12234f = builder.f12223f;
        this.f12235g = builder.f12224g;
        this.f12236h = builder.f12226i;
        this.f12237i = builder.f12227j;
    }
}
