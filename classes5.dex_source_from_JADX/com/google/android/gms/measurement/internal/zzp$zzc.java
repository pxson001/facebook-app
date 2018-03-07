package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class zzp$zzc implements Runnable {
    final /* synthetic */ zzp f7090a;
    private final URL f7091b;
    private final byte[] f7092c;
    private final zzp$zza f7093d;

    public zzp$zzc(zzp com_google_android_gms_measurement_internal_zzp, URL url, byte[] bArr, zzp$zza com_google_android_gms_measurement_internal_zzp_zza) {
        this.f7090a = com_google_android_gms_measurement_internal_zzp;
        this.f7091b = url;
        this.f7092c = bArr;
        this.f7093d = com_google_android_gms_measurement_internal_zzp_zza;
    }

    public void run() {
        HttpURLConnection a;
        OutputStream outputStream;
        Throwable e;
        int i;
        Object obj;
        Throwable th;
        int i2;
        this.f7090a.d();
        try {
            byte[] a2 = this.f7090a.j().a(this.f7092c);
            a = this.f7090a.a(this.f7091b);
            try {
                a.setDoOutput(true);
                a.addRequestProperty("Content-Encoding", "gzip");
                a.setFixedLengthStreamingMode(a2.length);
                a.connect();
                outputStream = a.getOutputStream();
            } catch (IOException e2) {
                e = e2;
                i = 0;
                outputStream = null;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e3) {
                        this.f7090a.l().b().a("Error closing HTTP compressed POST connection output stream", e3);
                    }
                }
                if (a != null) {
                    a.disconnect();
                }
                obj = null;
                this.f7090a.k().a(new zzp$zzb(this.f7093d, i, e, null));
            } catch (Throwable th2) {
                th = th2;
                i2 = 0;
                outputStream = null;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e32) {
                        this.f7090a.l().b().a("Error closing HTTP compressed POST connection output stream", e32);
                    }
                }
                if (a != null) {
                    a.disconnect();
                }
                this.f7090a.k().a(new zzp$zzb(this.f7093d, i2, null, null));
                throw th;
            }
            try {
                outputStream.write(a2);
                outputStream.close();
                i2 = a.getResponseCode();
                try {
                    byte[] a3 = zzp.a(this.f7090a, a);
                    if (a != null) {
                        a.disconnect();
                    }
                    this.f7090a.k().a(new zzp$zzb(this.f7093d, i2, null, a3));
                } catch (IOException e4) {
                    e = e4;
                    i = i2;
                    outputStream = null;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (a != null) {
                        a.disconnect();
                    }
                    obj = null;
                    this.f7090a.k().a(new zzp$zzb(this.f7093d, i, e, null));
                } catch (Throwable th22) {
                    th = th22;
                    outputStream = null;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (a != null) {
                        a.disconnect();
                    }
                    this.f7090a.k().a(new zzp$zzb(this.f7093d, i2, null, null));
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                i = 0;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (a != null) {
                    a.disconnect();
                }
                obj = null;
                this.f7090a.k().a(new zzp$zzb(this.f7093d, i, e, null));
            } catch (Throwable th3) {
                th = th3;
                i2 = 0;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (a != null) {
                    a.disconnect();
                }
                this.f7090a.k().a(new zzp$zzb(this.f7093d, i2, null, null));
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            i = 0;
            outputStream = null;
            a = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (a != null) {
                a.disconnect();
            }
            obj = null;
            this.f7090a.k().a(new zzp$zzb(this.f7093d, i, e, null));
        } catch (Throwable th222) {
            th = th222;
            i2 = 0;
            a = null;
            outputStream = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (a != null) {
                a.disconnect();
            }
            this.f7090a.k().a(new zzp$zzb(this.f7093d, i2, null, null));
            throw th;
        }
    }
}
