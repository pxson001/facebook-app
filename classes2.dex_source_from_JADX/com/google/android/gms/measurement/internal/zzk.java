package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmt;
import com.google.android.gms.internal.zzmt.C00001;

public final class zzk {
    public static zza<Boolean> f168a = zza.m313a("measurement.service_enabled", true);
    public static zza<Boolean> f169b = zza.m313a("measurement.service_client_enabled", true);
    public static zza<String> f170c = zza.m312a("measurement.log_tag", "GMPM", "GMPM-SVC");
    public static zza<Long> f171d = zza.m311a("measurement.ad_id_cache_time", 10000);
    public static zza<Long> f172e = zza.m311a("measurement.monitoring.sample_period_millis", 86400000);
    public static zza<Integer> f173f = zza.m310a("measurement.upload.max_bundles", 100);
    public static zza<Integer> f174g = zza.m310a("measurement.upload.max_batch_size", 65536);
    public static zza<String> f175h;
    public static zza<Long> f176i = zza.m311a("measurement.upload.backoff_period", 43200000);
    public static zza<Long> f177j = zza.m311a("measurement.upload.window_interval", 3600000);
    public static zza<Long> f178k = zza.m311a("measurement.upload.interval", 3600000);
    public static zza<Long> f179l = zza.m311a("measurement.upload.stale_data_deletion_interval", 86400000);
    public static zza<Long> f180m = zza.m311a("measurement.upload.initial_upload_delay_time", 15000);
    public static zza<Long> f181n = zza.m311a("measurement.upload.retry_time", 1800000);
    public static zza<Integer> f182o = zza.m310a("measurement.upload.retry_count", 6);
    public static zza<Long> f183p = zza.m311a("measurement.upload.max_queue_time", 2419200000L);
    public static zza<Long> f184q = zza.m311a("measurement.service_client.idle_disconnect_millis", 5000);

    public final class zza<V> {
        private final V f185a;
        private final zzmt<V> f186b;
        private V f187c;

        public zza(zzmt<V> com_google_android_gms_internal_zzmt_V, V v) {
            zzx.m104a((Object) com_google_android_gms_internal_zzmt_V);
            this.f186b = com_google_android_gms_internal_zzmt_V;
            this.f185a = v;
        }

        static zza<Integer> m310a(String str, int i) {
            return new zza(zzmt.m316a(str, Integer.valueOf(i)), Integer.valueOf(i));
        }

        static zza<Long> m311a(String str, long j) {
            return new zza(zzmt.m317a(str, Long.valueOf(j)), Long.valueOf(j));
        }

        public static zza<String> m312a(String str, String str2, String str3) {
            return new zza(zzmt.m318a(str, str3), str2);
        }

        static zza<Boolean> m313a(String str, boolean z) {
            return new zza(new C00001(str, Boolean.valueOf(z)), Boolean.valueOf(z));
        }

        public final V m314a() {
            return this.f187c != null ? this.f187c : (zzd.f66a && zzmt.m319b()) ? this.f186b.m322d() : this.f185a;
        }
    }

    static {
        String str = "https://app-measurement.com/a";
        f175h = zza.m312a("measurement.upload.url", str, str);
    }
}
