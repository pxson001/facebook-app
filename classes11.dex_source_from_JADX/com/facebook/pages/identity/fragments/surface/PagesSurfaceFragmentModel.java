package com.facebook.pages.identity.fragments.surface;

import android.location.Location;
import android.os.ParcelUuid;
import com.facebook.common.util.TriState;
import com.facebook.ipc.pages.PageViewReferrer;
import com.google.common.base.Objects;

/* compiled from: page_video_list_id */
public class PagesSurfaceFragmentModel {
    public final long f4120a;
    public final TriState f4121b;
    public final ParcelUuid f4122c;
    public final Location f4123d;
    public final boolean f4124e;
    public final PageViewReferrer f4125f;
    public final boolean f4126g;

    /* compiled from: page_video_list_id */
    public final class Builder {
        public long f4113a;
        public TriState f4114b;
        public ParcelUuid f4115c;
        public Location f4116d;
        public boolean f4117e;
        public PageViewReferrer f4118f;
        public boolean f4119g;

        public static Builder m5055a(PagesSurfaceFragmentModel pagesSurfaceFragmentModel) {
            Builder builder = new Builder();
            builder.f4113a = pagesSurfaceFragmentModel.f4120a;
            builder.f4114b = pagesSurfaceFragmentModel.f4121b;
            builder.f4115c = pagesSurfaceFragmentModel.f4122c;
            builder.f4116d = pagesSurfaceFragmentModel.f4123d;
            builder.f4117e = pagesSurfaceFragmentModel.f4124e;
            builder.f4118f = pagesSurfaceFragmentModel.f4125f;
            builder.f4119g = pagesSurfaceFragmentModel.f4126g;
            return builder;
        }

        public final PagesSurfaceFragmentModel m5056a() {
            return new PagesSurfaceFragmentModel(this);
        }
    }

    public PagesSurfaceFragmentModel(Builder builder) {
        this.f4120a = builder.f4113a;
        this.f4121b = builder.f4114b;
        this.f4122c = builder.f4115c;
        this.f4123d = builder.f4116d;
        this.f4124e = builder.f4117e;
        this.f4125f = builder.f4118f;
        this.f4126g = builder.f4119g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PagesSurfaceFragmentModel pagesSurfaceFragmentModel = (PagesSurfaceFragmentModel) obj;
        if (Objects.equal(Long.valueOf(this.f4120a), Long.valueOf(pagesSurfaceFragmentModel.f4120a)) && Objects.equal(this.f4121b, pagesSurfaceFragmentModel.f4121b) && Objects.equal(this.f4122c, pagesSurfaceFragmentModel.f4122c) && Objects.equal(this.f4123d, pagesSurfaceFragmentModel.f4123d) && Objects.equal(Boolean.valueOf(this.f4124e), Boolean.valueOf(pagesSurfaceFragmentModel.f4124e)) && Objects.equal(this.f4125f, pagesSurfaceFragmentModel.f4125f) && Objects.equal(Boolean.valueOf(this.f4126g), Boolean.valueOf(pagesSurfaceFragmentModel.f4126g))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Long.valueOf(this.f4120a), this.f4121b, this.f4122c, this.f4123d, Boolean.valueOf(this.f4124e), this.f4125f, Boolean.valueOf(this.f4126g)});
    }

    public final long m5057a() {
        return this.f4120a;
    }

    public final TriState m5058b() {
        return this.f4121b;
    }

    public final PageViewReferrer m5059f() {
        return this.f4125f;
    }
}
