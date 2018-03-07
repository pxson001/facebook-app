package com.facebook.imagepipeline.core;

import com.facebook.common.webp.WebpSupportStatus;

/* compiled from: org.apache.http.client.methods.HttpUriRequest */
public class ImagePipelineExperiments {
    private final int f10833a;
    public final boolean f10834b;
    private boolean f10835c;

    /* compiled from: org.apache.http.client.methods.HttpUriRequest */
    public class Builder {
        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder f10820a;
        public int f10821b = 0;
        public boolean f10822c = false;
        public boolean f10823d = false;

        public Builder(com.facebook.imagepipeline.core.ImagePipelineConfig.Builder builder) {
            this.f10820a = builder;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder m16049a(boolean z) {
            this.f10823d = z;
            return this.f10820a;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder m16048a(int i) {
            this.f10821b = i;
            return this.f10820a;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder m16050b(boolean z) {
            this.f10822c = z;
            return this.f10820a;
        }
    }

    public ImagePipelineExperiments(Builder builder, com.facebook.imagepipeline.core.ImagePipelineConfig.Builder builder2) {
        boolean z;
        boolean z2 = true;
        this.f10833a = builder.f10821b;
        if (builder.f10822c && WebpSupportStatus.f17782e) {
            z = true;
        } else {
            z = false;
        }
        this.f10834b = z;
        if (!(builder2.f10802f && builder.f10823d)) {
            z2 = false;
        }
        this.f10835c = z2;
    }

    public final boolean m16057a() {
        return this.f10835c;
    }

    public final int m16058b() {
        return this.f10833a;
    }
}
