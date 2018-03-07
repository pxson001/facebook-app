package com.facebook.backstage.api;

/* compiled from: security_error */
public class ShotCreateParams {
    public final String f4294a;
    public final String f4295b;
    public final String f4296c;
    public final String f4297d;
    public final String f4298e;
    public final String f4299f;
    public final int f4300g;
    public final String f4301h;

    /* compiled from: security_error */
    public class Builder {
        private String f4286a;
        public String f4287b;
        private String f4288c;
        private String f4289d;
        private String f4290e;
        public String f4291f;
        public int f4292g;
        private String f4293h;

        public Builder(String str, String str2, String str3, String str4) {
            this.f4286a = str;
            this.f4288c = str2;
            this.f4289d = str3;
            this.f4290e = str4;
        }

        public final ShotCreateParams m4280a() {
            return new ShotCreateParams(this.f4286a, this.f4287b, this.f4288c, this.f4289d, this.f4290e, this.f4291f, this.f4292g, this.f4293h);
        }
    }

    private ShotCreateParams(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7) {
        this.f4294a = str;
        this.f4295b = str2;
        this.f4296c = str3;
        this.f4297d = str4;
        this.f4298e = str5;
        this.f4299f = str6;
        this.f4300g = i;
        this.f4301h = str7;
    }
}
