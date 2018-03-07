package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.internal.zzx;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.UUID;

public class zzr extends zzw {
    static final Pair<String, Long> f149a = new Pair("", Long.valueOf(0));
    public final zzb f150b = new zzb(this, "health_monitor", Math.max(0, ((Long) zzk.f172e.m314a()).longValue()));
    public final zza f151c = new zza(this, "last_upload", 0);
    public final zza f152d = new zza(this, "last_upload_attempt", 0);
    public final zza f153e = new zza(this, "backoff", 0);
    public final zza f154f = new zza(this, "last_delete_stale", 0);
    public SharedPreferences f155h;
    private String f156i;
    private boolean f157j;
    private long f158k;
    public final SecureRandom f159l = new SecureRandom();

    public final class zzb {
        final String f163a;
        final /* synthetic */ zzr f164b;
        private final String f165c;
        private final String f166d;
        private final long f167e;

        public zzb(zzr com_google_android_gms_measurement_internal_zzr, String str, long j) {
            this.f164b = com_google_android_gms_measurement_internal_zzr;
            zzx.m106a(str);
            zzx.m112b(j > 0);
            this.f163a = str + ":start";
            this.f165c = str + ":count";
            this.f166d = str + ":value";
            this.f167e = j;
        }

        private void m305b() {
            this.f164b.mo28e();
            long a = this.f164b.mo31h().mo11a();
            Editor edit = this.f164b.f155h.edit();
            edit.remove(this.f165c);
            edit.remove(this.f166d);
            edit.putLong(this.f163a, a);
            edit.apply();
        }

        private long m306c() {
            this.f164b.mo28e();
            long d = m307d();
            if (d != 0) {
                return Math.abs(d - this.f164b.mo31h().mo11a());
            }
            m305b();
            return 0;
        }

        private long m307d() {
            return zzr.m295s(this.f164b).getLong(this.f163a, 0);
        }

        public final Pair<String, Long> m308a() {
            this.f164b.mo28e();
            long c = m306c();
            if (c < this.f167e) {
                return null;
            }
            if (c > this.f167e * 2) {
                m305b();
                return null;
            }
            String string = zzr.m295s(this.f164b).getString(this.f166d, null);
            c = zzr.m295s(this.f164b).getLong(this.f165c, 0);
            m305b();
            return (string == null || c <= 0) ? zzr.f149a : new Pair(string, Long.valueOf(c));
        }

        public final void m309a(String str, long j) {
            this.f164b.mo28e();
            if (m307d() == 0) {
                m305b();
            }
            if (str == null) {
                str = "";
            }
            long j2 = this.f164b.f155h.getLong(this.f165c, 0);
            if (j2 <= 0) {
                Editor edit = this.f164b.f155h.edit();
                edit.putString(this.f166d, str);
                edit.putLong(this.f165c, j);
                edit.apply();
                return;
            }
            Object obj = (this.f164b.f159l.nextLong() & Long.MAX_VALUE) < (Long.MAX_VALUE / (j2 + j)) * j ? 1 : null;
            Editor edit2 = this.f164b.f155h.edit();
            if (obj != null) {
                edit2.putString(this.f166d, str);
            }
            edit2.putLong(this.f165c, j2 + j);
            edit2.apply();
        }
    }

    public final class zza {
        public final /* synthetic */ zzr f195a;
        public final String f196b;
        public final long f197c;
        public boolean f198d;
        public long f199e;

        public zza(zzr com_google_android_gms_measurement_internal_zzr, String str, long j) {
            this.f195a = com_google_android_gms_measurement_internal_zzr;
            zzx.m106a(str);
            this.f196b = str;
            this.f197c = j;
        }

        public final long m326a() {
            if (!this.f198d) {
                this.f198d = true;
                this.f199e = this.f195a.f155h.getLong(this.f196b, this.f197c);
            }
            return this.f199e;
        }

        public final void m327a(long j) {
            Editor edit = this.f195a.f155h.edit();
            edit.putLong(this.f196b, j);
            edit.apply();
            this.f199e = j;
        }
    }

    public zzr(zzt com_google_android_gms_measurement_internal_zzt) {
        super(com_google_android_gms_measurement_internal_zzt);
    }

    private static MessageDigest m293a(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return null;
    }

    static String m294p() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static SharedPreferences m295s(zzr com_google_android_gms_measurement_internal_zzr) {
        com_google_android_gms_measurement_internal_zzr.mo28e();
        com_google_android_gms_measurement_internal_zzr.m303x();
        return com_google_android_gms_measurement_internal_zzr.f155h;
    }

    protected final void mo24a() {
        this.f155h = mo32i().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
    }

    final Pair<String, Boolean> m297b() {
        mo28e();
        long b = mo31h().mo12b();
        if (this.f156i != null && b < this.f158k) {
            return new Pair(this.f156i, Boolean.valueOf(this.f157j));
        }
        this.f158k = b + zzc.m134w();
        AdvertisingIdClient.a(true);
        try {
            Info a = AdvertisingIdClient.a(mo32i());
            this.f156i = a.a();
            this.f157j = a.b();
        } catch (Throwable th) {
            mo35l().m349s().m356a("Unable to get advertising id", th);
            this.f156i = "";
        }
        AdvertisingIdClient.a(false);
        return new Pair(this.f156i, Boolean.valueOf(this.f157j));
    }

    final String m298o() {
        String str = (String) m297b().first;
        if (m293a("MD5") == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, m293a("MD5").digest(str.getBytes()))});
    }

    final Boolean m299q() {
        mo28e();
        return !m295s(this).contains("use_service") ? null : Boolean.valueOf(m295s(this).getBoolean("use_service", false));
    }

    final boolean m300r() {
        mo28e();
        return m295s(this).getBoolean("measurement_enabled", true);
    }
}
