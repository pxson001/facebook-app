package com.facebook.messaging.model.attachment;

import com.google.common.base.Preconditions;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: value_type */
public class AttachmentBuilder {
    public final String f1872a;
    public final String f1873b;
    public String f1874c;
    public String f1875d;
    public String f1876e;
    public int f1877f;
    public ImageData f1878g;
    public VideoData f1879h;
    public AudioData f1880i;
    public String f1881j;

    /* compiled from: value_type */
    public class UrlBuilder {
        public int f1869a;
        public int f1870b;
        public String f1871c;

        public final ImageUrl m3251d() {
            return new ImageUrl(this);
        }
    }

    public AttachmentBuilder(String str, String str2) {
        this.f1872a = (String) Preconditions.checkNotNull(str);
        this.f1873b = (String) Preconditions.checkNotNull(str2);
    }

    public final AttachmentBuilder m3254a(String str) {
        this.f1874c = str;
        return this;
    }

    public final String m3257d() {
        return this.f1875d;
    }

    public final AttachmentBuilder m3255b(String str) {
        this.f1875d = str;
        return this;
    }

    public final AttachmentBuilder m3256c(String str) {
        this.f1876e = str;
        return this;
    }

    public final AttachmentBuilder m3252a(int i) {
        this.f1877f = i;
        return this;
    }

    public final AttachmentBuilder m3253a(ImageData imageData) {
        this.f1878g = imageData;
        return this;
    }

    public final Attachment m3258k() {
        return new Attachment(this);
    }
}
