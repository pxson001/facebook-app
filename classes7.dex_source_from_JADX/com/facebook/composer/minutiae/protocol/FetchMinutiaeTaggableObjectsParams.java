package com.facebook.composer.minutiae.protocol;

import android.location.Location;
import com.google.common.base.Objects;

/* compiled from: timeline_staging_grouund */
public class FetchMinutiaeTaggableObjectsParams {
    public final String f1636a;
    public final String f1637b;
    public final String f1638c;
    public final int f1639d;
    public final boolean f1640e;
    public final int f1641f;
    public final String f1642g;
    public final boolean f1643h;
    public final String f1644i;
    public final String f1645j;
    public final boolean f1646k;
    public final Location f1647l;

    /* compiled from: timeline_staging_grouund */
    public class Builder {
        public int f1624a;
        public String f1625b;
        public String f1626c;
        public String f1627d;
        public boolean f1628e;
        public Location f1629f;
        public String f1630g;
        public String f1631h;
        public String f1632i;
        public int f1633j;
        public boolean f1634k;
        public boolean f1635l;

        public final FetchMinutiaeTaggableObjectsParams m1666a() {
            if (this.f1630g != null && this.f1633j > 0) {
                return new FetchMinutiaeTaggableObjectsParams(this);
            }
            throw new IllegalStateException("Required attribute not set. mTaggableActivityId = " + this.f1630g + " mNumItems = " + this.f1633j);
        }
    }

    public FetchMinutiaeTaggableObjectsParams(Builder builder) {
        this.f1636a = builder.f1630g;
        this.f1637b = builder.f1631h;
        this.f1638c = builder.f1632i;
        this.f1639d = builder.f1633j;
        this.f1640e = builder.f1634k;
        this.f1643h = builder.f1635l;
        this.f1641f = builder.f1624a;
        this.f1642g = builder.f1625b;
        this.f1644i = builder.f1626c;
        this.f1645j = builder.f1627d;
        this.f1646k = builder.f1628e;
        this.f1647l = builder.f1629f;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("taggableActivityId", this.f1636a).add("query", this.f1637b).add("cursor", this.f1638c).add("numItems", this.f1639d).add("allowOfflinePosting", this.f1640e).add("sessionId", this.f1641f).add("requestId", this.f1642g).add("placeId", this.f1644i).add("surface", this.f1645j).add("isPrefetch", this.f1646k).add("location", this.f1647l).toString();
    }
}
