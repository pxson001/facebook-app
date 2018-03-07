package com.facebook.contactlogs.migrator;

/* compiled from: profile_photo_method_unknown */
public class TopSmsContact {
    public String f6161a;
    public String f6162b;
    public int f6163c;
    public int f6164d = -1;
    public int f6165e;

    /* compiled from: profile_photo_method_unknown */
    public class Builder {
        public String f6156a;
        public String f6157b;
        public int f6158c;
        public int f6159d;
        public int f6160e = -1;

        public final String m6499a() {
            return this.f6156a;
        }

        public final Builder m6500b(String str) {
            this.f6157b = str;
            return this;
        }

        public final Builder m6501c(int i) {
            this.f6160e = i;
            return this;
        }
    }

    public TopSmsContact(String str, String str2, int i, int i2) {
        this.f6161a = str;
        this.f6162b = str2;
        this.f6163c = i;
        this.f6164d = i2;
    }

    public TopSmsContact(Builder builder) {
        this.f6161a = builder.f6156a;
        this.f6162b = builder.f6157b;
        this.f6163c = builder.f6158c;
        this.f6165e = builder.f6159d;
        this.f6164d = builder.f6160e;
    }
}
