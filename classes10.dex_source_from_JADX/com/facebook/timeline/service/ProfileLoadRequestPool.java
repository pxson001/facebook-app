package com.facebook.timeline.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.inject.InjectorLike;
import com.facebook.timeline.service.ProfileLoadRequest.Parameters.Builder;
import com.facebook.ultralight.Inject;
import com.google.common.collect.ImmutableList;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: extra_page_event_host_id */
public class ProfileLoadRequestPool {
    @GuardedBy("this")
    private final Set<ProfileLoadRequest> f12697a = new HashSet();
    @GuardedBy("this")
    private final Set<ProfileLoadRequest> f12698b = new HashSet();
    public final SharedPreferences f12699c;

    public static ProfileLoadRequestPool m12637b(InjectorLike injectorLike) {
        return new ProfileLoadRequestPool((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    private ProfileLoadRequestPool(Context context) {
        this.f12699c = context.getSharedPreferences("get_notified", 0);
        m12640e();
    }

    private synchronized void m12640e() {
        m12636a(this.f12697a, "in_flight_profiles");
        m12636a(this.f12698b, "retry_queue");
    }

    private void m12636a(Set<ProfileLoadRequest> set, String str) {
        Set<String> stringSet = this.f12699c.getStringSet(str, new HashSet());
        Builder builder = new Builder();
        for (String parseLong : stringSet) {
            long parseLong2 = Long.parseLong(parseLong);
            builder.f12687a = parseLong2;
            Builder builder2 = builder;
            builder2.f12688b = this.f12699c.getString(m12638c(parseLong2), "");
            ProfileLoadRequest profileLoadRequest = new ProfileLoadRequest(builder2.m12631a());
            profileLoadRequest.f12696b = this.f12699c.getInt(m12639d(parseLong2), 0);
            set.add(profileLoadRequest);
        }
    }

    public final synchronized void m12643a(ProfileLoadRequest profileLoadRequest) {
        this.f12697a.add(profileLoadRequest);
        this.f12698b.remove(profileLoadRequest);
        this.f12699c.edit().putStringSet("in_flight_profiles", m12641f()).putStringSet("retry_queue", m12642g()).putString(m12638c(profileLoadRequest.m12632a()), profileLoadRequest.m12633b()).putInt(m12639d(profileLoadRequest.m12632a()), profileLoadRequest.m12635e()).commit();
    }

    public final synchronized void m12646b(ProfileLoadRequest profileLoadRequest) {
        this.f12697a.remove(profileLoadRequest);
        this.f12699c.edit().putStringSet("in_flight_profiles", m12641f()).remove(m12638c(profileLoadRequest.m12632a())).remove(m12639d(profileLoadRequest.m12632a())).commit();
    }

    public final synchronized void m12648c(ProfileLoadRequest profileLoadRequest) {
        this.f12697a.remove(profileLoadRequest);
        this.f12698b.add(profileLoadRequest);
        this.f12699c.edit().putStringSet("in_flight_profiles", m12641f()).putStringSet("retry_queue", m12642g()).commit();
    }

    public final synchronized boolean m12644a() {
        boolean z;
        z = this.f12697a.size() > 0 || this.f12698b.size() > 0;
        return z;
    }

    public final synchronized ImmutableList<ProfileLoadRequest> m12645b() {
        return ImmutableList.copyOf(this.f12697a);
    }

    public final synchronized ImmutableList<ProfileLoadRequest> m12647c() {
        return ImmutableList.copyOf(this.f12698b);
    }

    public final synchronized boolean m12649d(ProfileLoadRequest profileLoadRequest) {
        return this.f12697a.contains(profileLoadRequest);
    }

    public static String m12638c(long j) {
        return "profile_name_" + j;
    }

    public static String m12639d(long j) {
        return "retry_count_" + j;
    }

    private Set<String> m12641f() {
        Set<String> hashSet = new HashSet();
        for (ProfileLoadRequest a : this.f12697a) {
            hashSet.add(String.valueOf(a.m12632a()));
        }
        return hashSet;
    }

    private Set<String> m12642g() {
        Set<String> hashSet = new HashSet();
        for (ProfileLoadRequest a : this.f12698b) {
            hashSet.add(String.valueOf(a.m12632a()));
        }
        return hashSet;
    }
}
