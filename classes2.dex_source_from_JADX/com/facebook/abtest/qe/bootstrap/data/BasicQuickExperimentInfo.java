package com.facebook.abtest.qe.bootstrap.data;

import com.google.common.base.Preconditions;

/* compiled from: photo_story */
public abstract class BasicQuickExperimentInfo {
    public final String f10004a;
    public final String f10005b;
    public final boolean f10006c;
    public final boolean f10007d;
    public final String f10008e;
    public final String f10009f;

    /* compiled from: photo_story */
    public class Builder {
        protected String f9996a;
        protected String f9997b;
        protected boolean f9998c;
        protected boolean f9999d;
        protected String f10000e;
        protected String f10001f;

        protected Builder() {
        }

        public Builder mo1960a(String str) {
            this.f9996a = str;
            return this;
        }

        public Builder mo1962b(String str) {
            this.f9997b = str;
            return this;
        }

        public Builder mo1961a(boolean z) {
            this.f9998c = z;
            return this;
        }

        public Builder mo1963b(boolean z) {
            this.f9999d = z;
            return this;
        }

        public Builder mo1964c(String str) {
            this.f10000e = str;
            return this;
        }

        public Builder mo1965d(String str) {
            this.f10001f = str;
            return this;
        }
    }

    protected BasicQuickExperimentInfo(Builder builder) {
        this.f10004a = (String) Preconditions.checkNotNull(builder.f9996a);
        this.f10008e = (String) Preconditions.checkNotNull(builder.f9997b);
        this.f10006c = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f9998c))).booleanValue();
        this.f10007d = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f9999d))).booleanValue();
        this.f10005b = builder.f10000e;
        this.f10009f = (String) Preconditions.checkNotNull(builder.f10001f);
    }

    public final String m15055g() {
        return this.f10004a;
    }

    public final String m15056h() {
        return this.f10008e;
    }

    public final String m15057j() {
        return this.f10009f;
    }
}
