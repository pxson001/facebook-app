package com.facebook.fbuploader;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: null retry intent */
public final class Config {
    private final Namespace f10043a;
    public final Map<String, String> f10044b;
    private final RetryPolicy f10045c;
    public final RetryEvaluator f10046d;

    /* compiled from: null retry intent */
    public enum Namespace {
        DEFAULT("up", UploadResponseFieldType.MEDIA_ID),
        MESSENGER("up", UploadResponseFieldType.MEDIA_ID),
        FACEBOOK("fb_video", UploadResponseFieldType.HANDLE),
        INSTAGRAM("ig", UploadResponseFieldType.HANDLE),
        GROUPS("groups", UploadResponseFieldType.HANDLE);
        
        private final UploadResponseFieldType mJsonResponseFieldType;
        private final String mUriPathElement;

        private Namespace(String str, UploadResponseFieldType uploadResponseFieldType) {
            this.mUriPathElement = str;
            this.mJsonResponseFieldType = uploadResponseFieldType;
        }

        public final String getUriPathElement() {
            return this.mUriPathElement;
        }

        public final UploadResponseFieldType getJsonResponseFieldType() {
            return this.mJsonResponseFieldType;
        }
    }

    @Immutable
    /* compiled from: null retry intent */
    public final class RetryPolicy {
        public final int f10040a;
        public final int f10041b;
        public final int f10042c;

        public RetryPolicy(int i, int i2, int i3) {
            this.f10040a = Math.max(Math.min(i, 500), 0);
            this.f10041b = Math.max(Math.min(i2, 5000), 1);
            this.f10042c = Math.max(Math.min(i3, 5000), 1);
        }

        public RetryPolicy() {
            this.f10040a = 50;
            this.f10041b = 1;
            this.f10042c = 500;
        }
    }

    /* compiled from: null retry intent */
    public enum UploadResponseFieldType {
        MEDIA_ID,
        HANDLE
    }

    public Config(Namespace namespace, @Nullable Map<String, String> map, @Nullable RetryPolicy retryPolicy) {
        this.f10043a = namespace;
        if (map == null) {
            map = new HashMap();
        }
        this.f10044b = map;
        if (retryPolicy == null) {
            retryPolicy = new RetryPolicy();
        }
        this.f10045c = retryPolicy;
        this.f10046d = new RetryEvaluator(this.f10045c);
    }

    public final boolean m15734a() {
        RetryEvaluator retryEvaluator = this.f10046d;
        int i = retryEvaluator.f10063b;
        retryEvaluator.f10063b = i + 1;
        return i < retryEvaluator.f10062a.f10040a;
    }

    public final int m15735b() {
        RetryEvaluator retryEvaluator = this.f10046d;
        int i = retryEvaluator.f10064c;
        retryEvaluator.f10064c = Math.min(retryEvaluator.f10064c << 1, retryEvaluator.f10062a.f10042c);
        return i;
    }

    public final String m15736c() {
        return this.f10043a.getUriPathElement();
    }

    public final UploadResponseFieldType m15737d() {
        return this.f10043a.getJsonResponseFieldType();
    }
}
