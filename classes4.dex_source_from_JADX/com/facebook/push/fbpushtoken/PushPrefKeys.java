package com.facebook.push.fbpushtoken;

import com.facebook.prefs.shared.PrefKey;

/* compiled from: include_headers */
public abstract class PushPrefKeys {
    public final PrefKey f10372a = ((PrefKey) mo801a().a("token"));
    public final PrefKey f10373b = ((PrefKey) mo801a().a("token_owner"));
    public final PrefKey f10374c = ((PrefKey) mo801a().a("last_register_time"));
    public final PrefKey f10375d = ((PrefKey) mo801a().a("last_change_time"));
    public final PrefKey f10376e = ((PrefKey) mo801a().a("backoff_ms"));
    public final PrefKey f10377f = ((PrefKey) mo801a().a("last_push_time"));
    public final PrefKey f10378g = ((PrefKey) mo801a().a("last_service_attempt_type"));
    public final PrefKey f10379h = ((PrefKey) mo801a().a("service_type"));
    public final PrefKey f10380i = ((PrefKey) mo801a().a("fb_server_registered"));
    public final PrefKey f10381j = ((PrefKey) mo801a().a("fb_server_registered_hash"));
    public final PrefKey f10382k = ((PrefKey) mo801a().a("fb_server_last_register_time"));
    public final PrefKey f10383l = ((PrefKey) mo801a().a("fb_server_build"));
    public final PrefKey f10384m = ((PrefKey) mo801a().a("is_c2dm"));

    public abstract PrefKey mo801a();

    public final PrefKey m10929h() {
        return this.f10378g;
    }
}
