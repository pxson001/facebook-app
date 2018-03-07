package com.facebook.imagepipeline.request;

import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest.ImageType;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import javax.annotation.Nullable;

/* compiled from: network_id */
public class ImageRequestBuilder {
    public Uri f12717a = null;
    public RequestLevel f12718b = RequestLevel.FULL_FETCH;
    public boolean f12719c = false;
    @Nullable
    public ResizeOptions f12720d = null;
    public ImageDecodeOptions f12721e = ImageDecodeOptions.f12728h;
    public ImageType f12722f = ImageType.DEFAULT;
    public boolean f12723g = false;
    public boolean f12724h = false;
    public Priority f12725i = Priority.HIGH;
    @Nullable
    public Postprocessor f12726j = null;
    public boolean f12727k = true;

    public static ImageRequestBuilder m18776a(Uri uri) {
        return new ImageRequestBuilder().m18783b(uri);
    }

    public static ImageRequestBuilder m18775a(int i) {
        return m18776a(new Builder().scheme("res").path(String.valueOf(i)).build());
    }

    private ImageRequestBuilder() {
    }

    public static ImageRequestBuilder m18777a(ImageRequest imageRequest) {
        ImageRequestBuilder a = m18776a(imageRequest.f12746c);
        a.f12719c = imageRequest.f12751h;
        a = a;
        a.f12721e = imageRequest.f12750g;
        a = a;
        a.f12722f = imageRequest.f12745b;
        a = a;
        a.f12724h = imageRequest.f12749f;
        a = a;
        a.f12718b = imageRequest.f12753j;
        a = a;
        a.f12726j = imageRequest.f12755l;
        a = a;
        a.f12723g = imageRequest.f12748e;
        a = a;
        a.f12725i = imageRequest.f12752i;
        a = a;
        a.f12720d = imageRequest.f12744a;
        return a;
    }

    public final ImageRequestBuilder m18783b(Uri uri) {
        Preconditions.a(uri);
        this.f12717a = uri;
        return this;
    }

    public final Uri m18779a() {
        return this.f12717a;
    }

    public final ImageRequestBuilder m18781a(RequestLevel requestLevel) {
        this.f12718b = requestLevel;
        return this;
    }

    public final ImageRequestBuilder m18780a(ResizeOptions resizeOptions) {
        this.f12720d = resizeOptions;
        return this;
    }

    public final ImageRequestBuilder m18784b(boolean z) {
        this.f12723g = z;
        return this;
    }

    public final ImageRequestBuilder m18782a(Postprocessor postprocessor) {
        this.f12726j = postprocessor;
        return this;
    }

    public final ImageRequest m18785m() {
        m18778n();
        return new ImageRequest(this);
    }

    private void m18778n() {
        if (this.f12717a == null) {
            throw new BuilderException("Source must be set!");
        }
        if (UriUtil.m18793g(this.f12717a)) {
            if (!this.f12717a.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            } else if (this.f12717a.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            } else {
                try {
                    Integer.parseInt(this.f12717a.getPath().substring(1));
                } catch (NumberFormatException e) {
                    throw new BuilderException("Resource URI path must be a resource id.");
                }
            }
        }
        if (UriUtil.m18792f(this.f12717a) && !this.f12717a.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
