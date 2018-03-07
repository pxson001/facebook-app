package com.google.android.gms.measurement.internal;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqq.zzb;
import com.google.android.gms.internal.zzqq.zzc;
import com.google.android.gms.internal.zzqq.zze;
import com.google.android.gms.internal.zztd;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class zzae extends zzv {
    public zzae(zzt com_google_android_gms_measurement_internal_zzt) {
        super(com_google_android_gms_measurement_internal_zzt);
    }

    public static Object m359a(int i, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Float)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        } else if (obj instanceof Double) {
            return Float.valueOf((float) ((Double) obj).doubleValue());
        } else {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return null;
            }
            String valueOf = String.valueOf(obj);
            return valueOf.length() > i ? z ? valueOf.substring(0, i) : null : valueOf;
        }
    }

    private static void m360a(String str, int i, String str2) {
        if (str2 == null) {
            throw new IllegalArgumentException(str + " name is required and can't be null");
        } else if (str2.length() == 0) {
            throw new IllegalArgumentException(str + " name is required and can't be empty");
        } else {
            char charAt = str2.charAt(0);
            if (Character.isLetter(charAt) || charAt == '_') {
                int i2 = 1;
                while (i2 < str2.length()) {
                    char charAt2 = str2.charAt(i2);
                    if (charAt2 == '_' || Character.isLetterOrDigit(charAt2)) {
                        i2++;
                    } else {
                        throw new IllegalArgumentException(str + " name must consist of letters, digits or _ (underscores)");
                    }
                }
                if (str2.length() > i) {
                    throw new IllegalArgumentException(str + " name is too long. The maximum supported length is " + i);
                }
                return;
            }
            throw new IllegalArgumentException(str + " name must start with a letter or _");
        }
    }

    private void m361a(String str, String str2, int i, Object obj) {
        if (obj == null) {
            mo35l().f208j.m356a(str + " value can't be null. Ignoring " + str, str2);
        } else if (!(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                String valueOf = String.valueOf(obj);
                if (valueOf.length() > i) {
                    mo35l().f208j.m357a("Ignoring " + str + ". Value is too long. name, value length", str2, Integer.valueOf(valueOf.length()));
                }
            }
        }
    }

    public static boolean m362a(Context context, Class<? extends Service> cls) {
        try {
            ComponentInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, cls), 4);
            if (serviceInfo != null && serviceInfo.enabled) {
                return true;
            }
        } catch (NameNotFoundException e) {
        }
        return false;
    }

    public static boolean m363a(Context context, Class<? extends BroadcastReceiver> cls, boolean z) {
        try {
            ComponentInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, cls), 2);
            if (receiverInfo != null && receiverInfo.enabled && (!z || receiverInfo.exported)) {
                return true;
            }
        } catch (NameNotFoundException e) {
        }
        return false;
    }

    private int m364c(String str) {
        return "_ldl".equals(str) ? 2048 : 36;
    }

    public final void m365a(Bundle bundle, String str, Object obj) {
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            bundle.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
        } else if (str != null) {
            mo35l().f208j.m357a("Not putting event parameter. Invalid value type. name, type", str, obj.getClass().getSimpleName());
        }
    }

    public final void m366a(zzb com_google_android_gms_internal_zzqq_zzb, Object obj) {
        zzx.m104a(obj);
        com_google_android_gms_internal_zzqq_zzb.c = null;
        com_google_android_gms_internal_zzqq_zzb.d = null;
        com_google_android_gms_internal_zzqq_zzb.e = null;
        if (obj instanceof String) {
            com_google_android_gms_internal_zzqq_zzb.c = (String) obj;
        } else if (obj instanceof Long) {
            com_google_android_gms_internal_zzqq_zzb.d = (Long) obj;
        } else if (obj instanceof Float) {
            com_google_android_gms_internal_zzqq_zzb.e = (Float) obj;
        } else {
            mo35l().f203d.m356a("Ignoring invalid (type) event param value", obj);
        }
    }

    public final void m367a(zze com_google_android_gms_internal_zzqq_zze, Object obj) {
        zzx.m104a(obj);
        com_google_android_gms_internal_zzqq_zze.d = null;
        com_google_android_gms_internal_zzqq_zze.e = null;
        com_google_android_gms_internal_zzqq_zze.f = null;
        if (obj instanceof String) {
            com_google_android_gms_internal_zzqq_zze.d = (String) obj;
        } else if (obj instanceof Long) {
            com_google_android_gms_internal_zzqq_zze.e = (Long) obj;
        } else if (obj instanceof Float) {
            com_google_android_gms_internal_zzqq_zze.f = (Float) obj;
        } else {
            mo35l().f203d.m356a("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public final void m368a(String str) {
        m360a("user attribute", 24, str);
    }

    public final boolean m369a(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(mo31h().mo11a() - j) > j2;
    }

    public final byte[] m370a(zzc com_google_android_gms_internal_zzqq_zzc) {
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_zzqq_zzc.d()];
            zztd a = zztd.a(bArr);
            com_google_android_gms_internal_zzqq_zzc.a(a);
            a.a();
            return bArr;
        } catch (IOException e) {
            mo35l().m335b().m356a("Data loss. Failed to serialize batch", e);
            return null;
        }
    }

    public final byte[] m371a(byte[] bArr) {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            mo35l().m335b().m356a("Failed to gzip content", e);
            throw e;
        }
    }

    public final void m372b(String str, Object obj) {
        if ("_ldl".equals(str)) {
            m361a("user attribute referrer", str, m364c(str), obj);
        } else {
            m361a("user attribute", str, m364c(str), obj);
        }
    }

    public final boolean m373b(String str) {
        mo28e();
        return mo32i().checkCallingOrSelfPermission(str) == 0;
    }

    public final byte[] m374b(byte[] bArr) {
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            mo35l().m335b().m356a("Failed to ungzip content", e);
            throw e;
        }
    }

    public final Object m375c(String str, Object obj) {
        return "_ldl".equals(str) ? m359a(m364c(str), obj, true) : m359a(m364c(str), obj, false);
    }
}
