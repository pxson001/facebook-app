package com.google.android.gms.common.stats;

import com.google.android.gms.internal.zzmt;

public final class zzc {
    public static zzmt<Integer> f6664a = zzmt.a("gms:common:stats:max_num_of_events", Integer.valueOf(100));
    public static zzmt<Integer> f6665b = zzmt.a("gms:common:stats:max_chunk_size", Integer.valueOf(100));

    public final class zza {
        public static zzmt<Integer> f6658a = zzmt.a("gms:common:stats:connections:level", Integer.valueOf(zzd.b));
        public static zzmt<String> f6659b = zzmt.a("gms:common:stats:connections:ignored_calling_processes", "");
        public static zzmt<String> f6660c = zzmt.a("gms:common:stats:connections:ignored_calling_services", "");
        public static zzmt<String> f6661d = zzmt.a("gms:common:stats:connections:ignored_target_processes", "");
        public static zzmt<String> f6662e = zzmt.a("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");
        public static zzmt<Long> f6663f = zzmt.a("gms:common:stats:connections:time_out_duration", Long.valueOf(600000));
    }
}
