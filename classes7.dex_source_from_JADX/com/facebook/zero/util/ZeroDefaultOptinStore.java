package com.facebook.zero.util;

import com.facebook.debug.log.BLog;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.zero.common.constants.ZeroPrefKeys;
import com.facebook.zero.sdk.util.StringListDataSerializer;
import com.google.common.collect.ImmutableList;

/* compiled from: visible_duration */
public class ZeroDefaultOptinStore {
    private static final Class<?> f340c = ZeroDefaultOptinStore.class;
    public String f341A;
    FbSharedPreferences f342a;
    StringListDataSerializer f343b;
    private String f344d;
    private String f345e;
    private int f346f;
    private int f347g;
    public String f348h;
    public String f349i;
    public String f350j;
    public String f351k;
    public boolean f352l;
    public String f353m;
    public ImmutableList<String> f354n;
    public String f355o;
    public String f356p;
    public String f357q;
    public String f358r;
    public String f359s;
    public String f360t;
    public String f361u;
    public String f362v;
    public String f363w;
    public String f364x;
    public String f365y;
    public boolean f366z;

    /* compiled from: visible_duration */
    public class Builder {
        public String f314a;
        public String f315b;
        public int f316c;
        public int f317d;
        public String f318e;
        public String f319f;
        public String f320g;
        public String f321h;
        public boolean f322i;
        public String f323j;
        public ImmutableList<String> f324k;
        public String f325l;
        public String f326m;
        public String f327n;
        public String f328o;
        public String f329p;
        public String f330q;
        public String f331r;
        public String f332s;
        public String f333t;
        public String f334u;
        public String f335v;
        public boolean f336w;
        public String f337x;
        private FbSharedPreferences f338y;
        private StringListDataSerializer f339z;

        public Builder(FbSharedPreferences fbSharedPreferences, StringListDataSerializer stringListDataSerializer) {
            this.f338y = fbSharedPreferences;
            this.f339z = stringListDataSerializer;
        }

        public final ZeroDefaultOptinStore m350a() {
            return new ZeroDefaultOptinStore(this.f338y, this.f339z, this);
        }
    }

    private ZeroDefaultOptinStore(FbSharedPreferences fbSharedPreferences, StringListDataSerializer stringListDataSerializer) {
        this.f342a = fbSharedPreferences;
        this.f343b = stringListDataSerializer;
    }

    public ZeroDefaultOptinStore(FbSharedPreferences fbSharedPreferences, StringListDataSerializer stringListDataSerializer, Builder builder) {
        this.f342a = fbSharedPreferences;
        this.f343b = stringListDataSerializer;
        this.f344d = builder.f314a;
        this.f345e = builder.f315b;
        this.f346f = builder.f316c;
        this.f347g = builder.f317d;
        this.f348h = builder.f318e;
        this.f349i = builder.f319f;
        this.f350j = builder.f320g;
        this.f351k = builder.f321h;
        this.f352l = builder.f322i;
        this.f353m = builder.f323j;
        this.f354n = builder.f324k;
        this.f355o = builder.f325l;
        this.f356p = builder.f326m;
        this.f357q = builder.f327n;
        this.f358r = builder.f328o;
        this.f359s = builder.f329p;
        this.f360t = builder.f330q;
        this.f361u = builder.f331r;
        this.f362v = builder.f332s;
        this.f363w = builder.f333t;
        this.f364x = builder.f334u;
        this.f365y = builder.f335v;
        this.f366z = builder.f336w;
        this.f341A = builder.f337x;
    }

    public static ZeroDefaultOptinStore m351a(FbSharedPreferences fbSharedPreferences, StringListDataSerializer stringListDataSerializer) {
        return new ZeroDefaultOptinStore(fbSharedPreferences, stringListDataSerializer).m353v();
    }

    private ZeroDefaultOptinStore m353v() {
        this.f344d = this.f342a.a(ZeroPrefKeys.x, "");
        this.f345e = this.f342a.a(ZeroPrefKeys.y, "");
        this.f346f = this.f342a.a(ZeroPrefKeys.z, 0);
        this.f347g = this.f342a.a(ZeroPrefKeys.A, 0);
        this.f348h = this.f342a.a(ZeroPrefKeys.B, "");
        this.f349i = this.f342a.a(ZeroPrefKeys.C, "");
        this.f350j = this.f342a.a(ZeroPrefKeys.D, "");
        this.f351k = this.f342a.a(ZeroPrefKeys.E, "");
        this.f352l = this.f342a.a(ZeroPrefKeys.F, false);
        this.f353m = this.f342a.a(ZeroPrefKeys.G, "");
        this.f355o = this.f342a.a(ZeroPrefKeys.I, "");
        this.f356p = this.f342a.a(ZeroPrefKeys.J, "");
        this.f357q = this.f342a.a(ZeroPrefKeys.K, "");
        this.f358r = this.f342a.a(ZeroPrefKeys.L, "");
        this.f359s = this.f342a.a(ZeroPrefKeys.M, "");
        this.f360t = this.f342a.a(ZeroPrefKeys.N, "");
        this.f361u = this.f342a.a(ZeroPrefKeys.O, "");
        this.f362v = this.f342a.a(ZeroPrefKeys.P, "");
        this.f363w = this.f342a.a(ZeroPrefKeys.Q, "");
        this.f364x = this.f342a.a(ZeroPrefKeys.R, "");
        this.f365y = this.f342a.a(ZeroPrefKeys.S, "");
        this.f366z = this.f342a.a(ZeroPrefKeys.T, false);
        this.f341A = this.f342a.a(ZeroPrefKeys.U, "");
        this.f354n = ImmutableList.of();
        try {
            this.f354n = this.f343b.a(this.f342a.a(ZeroPrefKeys.H, ""));
        } catch (Throwable e) {
            BLog.a(f340c, "Failed to read zero optin facepile URLs from shared prefs", e);
        }
        return this;
    }

    public final void m354a() {
        Editor edit = this.f342a.edit();
        edit.a(ZeroPrefKeys.x, this.f344d).a(ZeroPrefKeys.y, this.f345e).a(ZeroPrefKeys.z, this.f346f).a(ZeroPrefKeys.A, this.f347g).a(ZeroPrefKeys.B, this.f348h).a(ZeroPrefKeys.C, this.f349i).a(ZeroPrefKeys.D, this.f350j).a(ZeroPrefKeys.E, this.f351k).putBoolean(ZeroPrefKeys.F, this.f352l).a(ZeroPrefKeys.G, this.f353m).a(ZeroPrefKeys.I, this.f355o).a(ZeroPrefKeys.J, this.f356p).a(ZeroPrefKeys.K, this.f357q).a(ZeroPrefKeys.L, this.f358r).a(ZeroPrefKeys.M, this.f359s).a(ZeroPrefKeys.N, this.f360t).a(ZeroPrefKeys.O, this.f361u).a(ZeroPrefKeys.P, this.f362v).a(ZeroPrefKeys.Q, this.f363w).a(ZeroPrefKeys.R, this.f364x).a(ZeroPrefKeys.S, this.f365y).putBoolean(ZeroPrefKeys.T, this.f366z).a(ZeroPrefKeys.U, this.f341A);
        try {
            edit.a(ZeroPrefKeys.H, this.f343b.a(this.f354n));
        } catch (Throwable e) {
            BLog.a(f340c, "Failed to write zero optin facepile URLs to shared prefs", e);
        }
        edit.commit();
    }

    public static void m352a(FbSharedPreferences fbSharedPreferences) {
        fbSharedPreferences.edit().b(ZeroPrefKeys.w).commit();
    }
}
