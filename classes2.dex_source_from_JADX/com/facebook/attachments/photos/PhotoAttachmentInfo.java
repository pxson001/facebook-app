package com.facebook.attachments.photos;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;

/* compiled from: graph_search_query_result_data */
public class PhotoAttachmentInfo {
    private final ImageRequest[] f21991a;
    private final ImageRequest f21992b;
    private final ImageRequest f21993c;
    private final String f21994d;
    public final int f21995e;
    public final int f21996f;
    public final int f21997g;
    public final int f21998h;

    /* compiled from: graph_search_query_result_data */
    public final class Builder {
        public String f21983a;
        public int f21984b;
        public int f21985c;
        public int f21986d;
        public int f21987e;
        public ImageRequest[] f21988f;
        public ImageRequest f21989g;
        public ImageRequest f21990h;

        public final PhotoAttachmentInfo m29768a() {
            return new PhotoAttachmentInfo(this);
        }
    }

    public PhotoAttachmentInfo(Builder builder) {
        this.f21991a = builder.f21988f;
        this.f21992b = builder.f21989g;
        this.f21993c = builder.f21990h;
        this.f21994d = builder.f21983a;
        this.f21995e = builder.f21984b;
        this.f21996f = builder.f21985c;
        this.f21997g = builder.f21986d;
        this.f21998h = builder.f21987e;
    }

    public final Uri m29775a() {
        return this.f21992b == null ? null : this.f21992b.f12746c;
    }

    public final String m29776b() {
        return this.f21994d;
    }

    public final int m29777e() {
        return this.f21997g;
    }

    public final int m29778f() {
        return this.f21998h;
    }

    public final ImageRequest[] m29779g() {
        return this.f21991a;
    }

    public final ImageRequest m29780h() {
        return this.f21992b;
    }

    public final ImageRequest m29781i() {
        return this.f21993c;
    }
}
