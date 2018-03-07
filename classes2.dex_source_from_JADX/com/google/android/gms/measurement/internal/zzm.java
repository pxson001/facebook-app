package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.measurement.zza;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

public class zzm extends zzw {
    private static final X500Principal f218a = new X500Principal("CN=Android Debug,O=Android,C=US");
    private String f219b;
    private String f220c;
    private String f221d;
    private String f222e;
    public long f223f;
    private String f224h;

    public zzm(zzt com_google_android_gms_measurement_internal_zzt) {
        super(com_google_android_gms_measurement_internal_zzt);
    }

    private static long m393a(byte[] bArr) {
        long j = null;
        zzx.m104a((Object) bArr);
        zzx.m108a(bArr.length > 0);
        long j2 = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j2 += (((long) bArr[length]) & 255) << j;
            j += 8;
            length--;
        }
        return j2;
    }

    private boolean m394p() {
        try {
            PackageInfo packageInfo = mo32i().getPackageManager().getPackageInfo(mo32i().getPackageName(), 64);
            if (!(packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0)) {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(f218a);
            }
        } catch (CertificateException e) {
            mo35l().m335b().m356a("Error obtaining certificate", e);
        } catch (NameNotFoundException e2) {
            mo35l().m335b().m356a("Package name not found", e2);
        }
        return true;
    }

    final AppMetadata m395a(String str) {
        String str2 = this.f219b;
        String b = m397b();
        String str3 = this.f220c;
        String str4 = this.f221d;
        long A = zzc.m122A();
        m303x();
        return new AppMetadata(str2, b, str3, str4, A, this.f223f, str, mo36m().m300r());
    }

    protected final void mo24a() {
        String str = "Unknown";
        String str2 = "Unknown";
        PackageManager packageManager = mo32i().getPackageManager();
        String packageName = mo32i().getPackageName();
        String installerPackageName = packageManager.getInstallerPackageName(packageName);
        if (installerPackageName == null) {
            installerPackageName = "manual_install";
        } else if ("com.android.vending".equals(installerPackageName)) {
            installerPackageName = "";
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(mo32i().getPackageName(), 0);
            if (packageInfo != null) {
                CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                if (!TextUtils.isEmpty(applicationLabel)) {
                    str2 = applicationLabel.toString();
                }
                str = packageInfo.versionName;
            }
        } catch (NameNotFoundException e) {
            mo35l().m335b().m356a("Error retrieving package info: appName", str2);
        }
        this.f219b = packageName;
        this.f221d = installerPackageName;
        this.f220c = str;
        this.f222e = str2;
        long j = 0;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            if (!m394p()) {
                PackageInfo packageInfo2 = packageManager.getPackageInfo(mo32i().getPackageName(), 64);
                if (!(instance == null || packageInfo2.signatures == null || packageInfo2.signatures.length <= 0)) {
                    j = m393a(instance.digest(packageInfo2.signatures[0].toByteArray()));
                }
            }
        } catch (NoSuchAlgorithmException e2) {
            mo35l().m335b().m356a("Could not get MD5 instance", e2);
        } catch (NameNotFoundException e3) {
            mo35l().m335b().m356a("Package name not found", e3);
        }
        this.f223f = j;
    }

    final String m397b() {
        m303x();
        if (zzc.m123B()) {
            return "";
        }
        if (this.f224h == null) {
            Status a = zza.m639a(mo32i());
            if (a == null || !a.m734e()) {
                this.f224h = "";
                mo35l().m335b().m356a("getGoogleAppId failed with status", Integer.valueOf(a == null ? 0 : a.m735f()));
                if (!(a == null || a.m733c() == null)) {
                    mo35l().m349s().m355a(a.m733c());
                }
            } else {
                try {
                    if (zza.m641b()) {
                        String a2 = zza.m640a();
                        if (TextUtils.isEmpty(a2)) {
                            a2 = "";
                        }
                        this.f224h = a2;
                    } else {
                        this.f224h = "";
                    }
                } catch (IllegalStateException e) {
                    this.f224h = "";
                    mo35l().m335b().m356a("getGoogleAppId or isMeasurementEnabled failed with exception", e);
                }
            }
        }
        return this.f224h;
    }

    public final /* bridge */ /* synthetic */ void mo26c() {
        super.mo26c();
    }

    public final /* bridge */ /* synthetic */ void mo27d() {
        super.mo27d();
    }

    public final /* bridge */ /* synthetic */ void mo28e() {
        super.mo28e();
    }

    public final /* bridge */ /* synthetic */ zzm mo29f() {
        return super.mo29f();
    }

    public final /* bridge */ /* synthetic */ zzz mo30g() {
        return super.mo30g();
    }

    public final /* bridge */ /* synthetic */ zznl mo31h() {
        return super.mo31h();
    }

    public final /* bridge */ /* synthetic */ Context mo32i() {
        return super.mo32i();
    }

    public final /* bridge */ /* synthetic */ zzae mo33j() {
        return super.mo33j();
    }

    public final /* bridge */ /* synthetic */ zzs mo34k() {
        return super.mo34k();
    }

    public final /* bridge */ /* synthetic */ zzo mo35l() {
        return super.mo35l();
    }

    public final /* bridge */ /* synthetic */ zzr mo36m() {
        return super.mo36m();
    }

    public final /* bridge */ /* synthetic */ zzc mo37n() {
        return super.mo37n();
    }
}
