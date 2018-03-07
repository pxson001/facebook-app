package com.facebook.widget.images;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.common.base.Objects;

@Deprecated
/* compiled from: reportStickyGuardrailAction */
public class DrawableFetchRequest {
    public final Drawable f5780a;
    private final Drawable f5781b;
    public final int f5782c;
    public final int f5783d;
    private final int f5784e;
    public final Uri f5785f;
    private final Uri f5786g;
    public final boolean f5787h;
    private final Matrix f5788i;
    private final PointF f5789j;
    private final boolean f5790k;

    /* compiled from: reportStickyGuardrailAction */
    public class Builder {
        public Drawable f5769a;
        public Drawable f5770b;
        public int f5771c = -1;
        public int f5772d = -1;
        public int f5773e = 0;
        public Uri f5774f;
        public PointF f5775g;
        public Uri f5776h;
        public boolean f5777i = false;
        public boolean f5778j = false;
        public Matrix f5779k = null;
    }

    public DrawableFetchRequest(Builder builder) {
        this.f5780a = builder.f5769a;
        this.f5781b = builder.f5770b;
        this.f5782c = builder.f5771c;
        this.f5783d = builder.f5772d;
        this.f5784e = builder.f5773e;
        this.f5785f = builder.f5774f;
        this.f5786g = builder.f5776h;
        this.f5787h = builder.f5777i;
        this.f5788i = builder.f5779k;
        this.f5789j = builder.f5775g;
        this.f5790k = builder.f5778j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DrawableFetchRequest)) {
            return false;
        }
        DrawableFetchRequest drawableFetchRequest = (DrawableFetchRequest) obj;
        if (Objects.equal(this.f5785f, drawableFetchRequest.f5785f) && Objects.equal(Integer.valueOf(this.f5783d), Integer.valueOf(drawableFetchRequest.f5783d)) && Objects.equal(Integer.valueOf(this.f5782c), Integer.valueOf(drawableFetchRequest.f5782c)) && Objects.equal(Integer.valueOf(this.f5784e), Integer.valueOf(drawableFetchRequest.f5784e)) && Objects.equal(this.f5780a, drawableFetchRequest.f5780a) && Objects.equal(Boolean.valueOf(this.f5787h), Boolean.valueOf(drawableFetchRequest.f5787h)) && Objects.equal(this.f5788i, drawableFetchRequest.f5788i) && Objects.equal(this.f5789j, drawableFetchRequest.f5789j) && Objects.equal(this.f5786g, drawableFetchRequest.f5786g) && Objects.equal(this.f5781b, drawableFetchRequest.f5781b) && Objects.equal(Boolean.valueOf(this.f5790k), Boolean.valueOf(drawableFetchRequest.f5790k))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f5785f, Integer.valueOf(this.f5783d), Integer.valueOf(this.f5782c), Integer.valueOf(this.f5784e), this.f5780a, Boolean.valueOf(this.f5787h), this.f5788i, this.f5789j, this.f5786g, this.f5781b, Boolean.valueOf(this.f5790k)});
    }
}
