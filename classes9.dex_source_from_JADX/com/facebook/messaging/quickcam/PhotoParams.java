package com.facebook.messaging.quickcam;

import com.facebook.ui.media.attachments.MediaResource.Source;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: deltaPlatformItemInterest */
public class PhotoParams {
    public final int f16434a;
    public final int f16435b;
    public final int f16436c;
    public final int f16437d;
    public final int f16438e;
    public final Source f16439f;
    public final CaptureType f16440g;
    public final boolean f16441h;
    public final String f16442i;

    /* compiled from: deltaPlatformItemInterest */
    public class Builder {
        public int f16426a;
        public int f16427b;
        public int f16428c;
        public int f16429d;
        public int f16430e;
        public Source f16431f;
        public CaptureType f16432g;
        public boolean f16433h;

        public final Builder m16480a(int i, int i2) {
            this.f16426a = i;
            this.f16427b = i2;
            return this;
        }

        public final Builder m16483b(int i, int i2) {
            this.f16428c = i;
            this.f16429d = i2;
            return this;
        }

        public final Builder m16484c(int i) {
            boolean z = true;
            if (!(i == -1 || i == 0 || i == 1 || i == 2 || i == 3)) {
                z = false;
            }
            Preconditions.checkArgument(z);
            this.f16430e = i;
            return this;
        }

        public final Builder m16481a(Source source) {
            Preconditions.checkNotNull(source);
            this.f16431f = source;
            return this;
        }

        public final PhotoParams m16482a() {
            return new PhotoParams(this);
        }
    }

    /* compiled from: deltaPlatformItemInterest */
    public enum CaptureType {
        TEXTURE,
        CAMERA_PREVIEW,
        CAMERA
    }

    public PhotoParams(Builder builder) {
        String str;
        this.f16434a = builder.f16426a;
        this.f16435b = builder.f16427b;
        this.f16436c = builder.f16428c;
        this.f16437d = builder.f16429d;
        this.f16438e = builder.f16430e;
        this.f16439f = builder.f16431f;
        this.f16440g = builder.f16432g;
        this.f16441h = builder.f16433h;
        switch (builder.f16430e) {
            case 0:
            case 2:
                str = "portrait";
                break;
            case 1:
            case 3:
                str = "landscape";
                break;
            default:
                str = "unknown";
                break;
        }
        this.f16442i = str;
    }
}
