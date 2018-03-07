package com.facebook.composer.minutiae.protocol;

import android.location.Location;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: timeline_fetch_header */
public class FetchTaggableSuggestionsAtPlaceParams {
    public final String f1661a;
    public final String f1662b;
    @Nullable
    public final String f1663c;
    public final int f1664d;
    public final String f1665e;
    public final String f1666f;
    public final Location f1667g;

    /* compiled from: timeline_fetch_header */
    public class Builder {
        public String f1654a;
        public String f1655b;
        public String f1656c;
        public int f1657d;
        public String f1658e;
        public String f1659f;
        public Location f1660g;
    }

    public FetchTaggableSuggestionsAtPlaceParams(Builder builder) {
        this.f1664d = builder.f1657d;
        this.f1665e = builder.f1658e;
        this.f1661a = (String) Preconditions.checkNotNull(builder.f1654a);
        this.f1662b = (String) Preconditions.checkNotNull(builder.f1655b);
        this.f1663c = builder.f1656c;
        this.f1666f = builder.f1659f;
        this.f1667g = builder.f1660g;
    }
}
