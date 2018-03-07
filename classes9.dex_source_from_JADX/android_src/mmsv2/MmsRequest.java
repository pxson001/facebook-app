package android_src.mmsv2;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android_src.mmsv2.pdu.GenericPdu;
import android_src.mmsv2.pdu.PduParser;
import android_src.mmsv2.pdu.SendConf;
import com.facebook.debug.log.BLog;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: setThreadName */
public abstract class MmsRequest implements Parcelable {
    private static final Integer f3768f = Integer.valueOf(2);
    protected final String f3769a;
    protected final Uri f3770b;
    protected final PendingIntent f3771c;
    protected final ExecutorService f3772d = Executors.newCachedThreadPool();
    public boolean f3773e;

    protected abstract String mo118a(ApnSettingsLoader$Apn apnSettingsLoader$Apn);

    protected abstract boolean mo119a(Context context, Intent intent, byte[] bArr);

    protected abstract boolean mo120a(Context context, Bundle bundle);

    protected abstract byte[] mo121a(MmsNetworkManager mmsNetworkManager, ApnSettingsLoader$Apn apnSettingsLoader$Apn, Bundle bundle, String str, String str2);

    protected MmsRequest(String str, Uri uri, PendingIntent pendingIntent) {
        this.f3769a = str;
        this.f3770b = uri;
        this.f3771c = pendingIntent;
        this.f3773e = true;
    }

    final boolean m3515a() {
        return this.f3773e;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void m3514a(android.content.Context r14, android_src.mmsv2.MmsNetworkManager r15, android_src.mmsv2.DefaultApnSettingsLoader r16, android_src.mmsv2.CarrierConfigValuesLoader r17, android_src.mmsv2.DefaultUserAgentInfoLoader r18) {
        /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:410)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.fixIterableType(LoopRegionVisitor.java:308)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.checkIterableForEach(LoopRegionVisitor.java:249)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.processLoopRegion(LoopRegionVisitor.java:68)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.enterRegion(LoopRegionVisitor.java:52)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:56)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:18)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.visit(LoopRegionVisitor.java:46)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r13 = this;
        r1 = new java.lang.StringBuilder;
        r2 = "Execute ";
        r1.<init>(r2);
        r2 = r13.getClass();
        r2 = r2.getSimpleName();
        r1.append(r2);
        r9 = 1;
        r7 = 0;
        r1 = 0;
        r2 = -1;
        r0 = r17;
        r4 = r0.mo117a(r2);
        if (r4 != 0) goto L_0x002c;
    L_0x001e:
        r2 = "MmsLib";
        r3 = "Failed to load carrier configuration values";
        com.facebook.debug.log.BLog.b(r2, r3);
        r2 = 7;
        r3 = r2;
        r2 = r7;
    L_0x0028:
        r13.m3513a(r14, r3, r1, r2);
        return;
    L_0x002c:
        r2 = r13.mo120a(r14, r4);
        if (r2 != 0) goto L_0x003d;
    L_0x0032:
        r2 = "MmsLib";
        r3 = "Failed to load PDU";
        com.facebook.debug.log.BLog.b(r2, r3);
        r2 = 5;
        r3 = r2;
        r2 = r7;
        goto L_0x0028;
    L_0x003d:
        r15.m3555c();	 Catch:{ ApnException -> 0x0058, MmsNetworkException -> 0x00fb, MmsHttpException -> 0x0112, Exception -> 0x0124 }
        r2 = r15.m3557e();	 Catch:{ ApnException -> 0x0058, MmsNetworkException -> 0x00fb, MmsHttpException -> 0x0112, Exception -> 0x0124 }
        r0 = r16;	 Catch:{ ApnException -> 0x0058, MmsNetworkException -> 0x00fb, MmsHttpException -> 0x0112, Exception -> 0x0124 }
        r3 = r0.m3498a(r2);	 Catch:{ ApnException -> 0x0058, MmsNetworkException -> 0x00fb, MmsHttpException -> 0x0112, Exception -> 0x0124 }
        r2 = r3.size();	 Catch:{ ApnException -> 0x0058, MmsNetworkException -> 0x00fb, MmsHttpException -> 0x0112, Exception -> 0x0124 }
        if (r2 > 0) goto L_0x0067;	 Catch:{ ApnException -> 0x0058, MmsNetworkException -> 0x00fb, MmsHttpException -> 0x0112, Exception -> 0x0124 }
    L_0x0050:
        r2 = new android_src.mmsv2.ApnException;	 Catch:{ ApnException -> 0x0058, MmsNetworkException -> 0x00fb, MmsHttpException -> 0x0112, Exception -> 0x0124 }
        r3 = "No valid APN";	 Catch:{ ApnException -> 0x0058, MmsNetworkException -> 0x00fb, MmsHttpException -> 0x0112, Exception -> 0x0124 }
        r2.<init>(r3);	 Catch:{ ApnException -> 0x0058, MmsNetworkException -> 0x00fb, MmsHttpException -> 0x0112, Exception -> 0x0124 }
        throw r2;	 Catch:{ ApnException -> 0x0058, MmsNetworkException -> 0x00fb, MmsHttpException -> 0x0112, Exception -> 0x0124 }
    L_0x0058:
        r2 = move-exception;
    L_0x0059:
        r3 = "MmsLib";	 Catch:{ all -> 0x0134 }
        r4 = "MmsRequest: APN failure";	 Catch:{ all -> 0x0134 }
        com.facebook.debug.log.BLog.b(r3, r4, r2);	 Catch:{ all -> 0x0134 }
        r2 = 2;
        r15.m3556d();
        r3 = r2;
        r2 = r7;
        goto L_0x0028;
    L_0x0067:
        r2 = new java.lang.StringBuilder;	 Catch:{  }
        r5 = "Trying ";	 Catch:{  }
        r2.<init>(r5);	 Catch:{  }
        r5 = r3.size();	 Catch:{  }
        r2 = r2.append(r5);	 Catch:{  }
        r5 = " APNs";	 Catch:{  }
        r2.append(r5);	 Catch:{  }
        r5 = r18.m3506a();	 Catch:{  }
        r6 = r18.m3507b();	 Catch:{  }
        r2 = 0;	 Catch:{  }
        r11 = r3.iterator();	 Catch:{  }
        r10 = r2;
        r8 = r1;
    L_0x008a:
        r1 = r11.hasNext();	 Catch:{ ApnException -> 0x0154, MmsNetworkException -> 0x014b, MmsHttpException -> 0x0142, Exception -> 0x0139 }
        if (r1 == 0) goto L_0x0162;	 Catch:{ ApnException -> 0x0154, MmsNetworkException -> 0x014b, MmsHttpException -> 0x0142, Exception -> 0x0139 }
    L_0x0090:
        r3 = r11.next();	 Catch:{ ApnException -> 0x0154, MmsNetworkException -> 0x014b, MmsHttpException -> 0x0142, Exception -> 0x0139 }
        r3 = (android_src.mmsv2.ApnSettingsLoader$Apn) r3;	 Catch:{ ApnException -> 0x0154, MmsNetworkException -> 0x014b, MmsHttpException -> 0x0142, Exception -> 0x0139 }
        r1 = new java.lang.StringBuilder;	 Catch:{ ApnException -> 0x0154, MmsNetworkException -> 0x014b, MmsHttpException -> 0x0142, Exception -> 0x0139 }
        r2 = "Using APN [MMSC=";	 Catch:{ ApnException -> 0x0154, MmsNetworkException -> 0x014b, MmsHttpException -> 0x0142, Exception -> 0x0139 }
        r1.<init>(r2);	 Catch:{ ApnException -> 0x0154, MmsNetworkException -> 0x014b, MmsHttpException -> 0x0142, Exception -> 0x0139 }
        r2 = r3.mo113a();	 Catch:{ ApnException -> 0x0154, MmsNetworkException -> 0x014b, MmsHttpException -> 0x0142, Exception -> 0x0139 }
        r1 = r1.append(r2);	 Catch:{ ApnException -> 0x0154, MmsNetworkException -> 0x014b, MmsHttpException -> 0x0142, Exception -> 0x0139 }
        r2 = ", PROXY=";	 Catch:{ ApnException -> 0x0154, MmsNetworkException -> 0x014b, MmsHttpException -> 0x0142, Exception -> 0x0139 }
        r1 = r1.append(r2);	 Catch:{ ApnException -> 0x0154, MmsNetworkException -> 0x014b, MmsHttpException -> 0x0142, Exception -> 0x0139 }
        r2 = r3.mo114b();	 Catch:{ ApnException -> 0x0154, MmsNetworkException -> 0x014b, MmsHttpException -> 0x0142, Exception -> 0x0139 }
        r1 = r1.append(r2);	 Catch:{ ApnException -> 0x0154, MmsNetworkException -> 0x014b, MmsHttpException -> 0x0142, Exception -> 0x0139 }
        r2 = ", PORT=";	 Catch:{ ApnException -> 0x0154, MmsNetworkException -> 0x014b, MmsHttpException -> 0x0142, Exception -> 0x0139 }
        r1 = r1.append(r2);	 Catch:{ ApnException -> 0x0154, MmsNetworkException -> 0x014b, MmsHttpException -> 0x0142, Exception -> 0x0139 }
        r2 = r3.mo115c();	 Catch:{ ApnException -> 0x0154, MmsNetworkException -> 0x014b, MmsHttpException -> 0x0142, Exception -> 0x0139 }
        r1 = r1.append(r2);	 Catch:{ ApnException -> 0x0154, MmsNetworkException -> 0x014b, MmsHttpException -> 0x0142, Exception -> 0x0139 }
        r2 = "]";	 Catch:{ ApnException -> 0x0154, MmsNetworkException -> 0x014b, MmsHttpException -> 0x0142, Exception -> 0x0139 }
        r1.append(r2);	 Catch:{ ApnException -> 0x0154, MmsNetworkException -> 0x014b, MmsHttpException -> 0x0142, Exception -> 0x0139 }
        r1 = r13.mo118a(r3);	 Catch:{ MmsHttpException -> 0x015f, ApnException -> 0x0154, MmsNetworkException -> 0x014b, Exception -> 0x0139 }
        r2 = r15.m3553a();	 Catch:{ MmsHttpException -> 0x015f, ApnException -> 0x0154, MmsNetworkException -> 0x014b, Exception -> 0x0139 }
        m3509a(r2, r3, r1);	 Catch:{ MmsHttpException -> 0x015f, ApnException -> 0x0154, MmsNetworkException -> 0x014b, Exception -> 0x0139 }
        r1 = r13;	 Catch:{ MmsHttpException -> 0x015f, ApnException -> 0x0154, MmsNetworkException -> 0x014b, Exception -> 0x0139 }
        r2 = r15;	 Catch:{ MmsHttpException -> 0x015f, ApnException -> 0x0154, MmsNetworkException -> 0x014b, Exception -> 0x0139 }
        r2 = r1.mo121a(r2, r3, r4, r5, r6);	 Catch:{ MmsHttpException -> 0x015f, ApnException -> 0x0154, MmsNetworkException -> 0x014b, Exception -> 0x0139 }
        r1 = m3511a(r2, r4);	 Catch:{ MmsHttpException -> 0x00e6, ApnException -> 0x0159, MmsNetworkException -> 0x014f, Exception -> 0x013d }
        if (r1 == 0) goto L_0x00f1;	 Catch:{ MmsHttpException -> 0x00e6, ApnException -> 0x0159, MmsNetworkException -> 0x014f, Exception -> 0x013d }
    L_0x00dd:
        r1 = new android_src.mmsv2.MmsHttpException;	 Catch:{ MmsHttpException -> 0x00e6, ApnException -> 0x0159, MmsNetworkException -> 0x014f, Exception -> 0x013d }
        r3 = 0;	 Catch:{ MmsHttpException -> 0x00e6, ApnException -> 0x0159, MmsNetworkException -> 0x014f, Exception -> 0x013d }
        r8 = "Invalid sending address";	 Catch:{ MmsHttpException -> 0x00e6, ApnException -> 0x0159, MmsNetworkException -> 0x014f, Exception -> 0x013d }
        r1.<init>(r3, r8);	 Catch:{ MmsHttpException -> 0x00e6, ApnException -> 0x0159, MmsNetworkException -> 0x014f, Exception -> 0x013d }
        throw r1;	 Catch:{ MmsHttpException -> 0x00e6, ApnException -> 0x0159, MmsNetworkException -> 0x014f, Exception -> 0x013d }
    L_0x00e6:
        r1 = move-exception;
    L_0x00e7:
        r3 = "MmsLib";	 Catch:{ ApnException -> 0x0159, MmsNetworkException -> 0x014f, MmsHttpException -> 0x0146, Exception -> 0x013d }
        r8 = "HTTP or network failure";	 Catch:{ ApnException -> 0x0159, MmsNetworkException -> 0x014f, MmsHttpException -> 0x0146, Exception -> 0x013d }
        com.facebook.debug.log.BLog.a(r3, r8, r1);	 Catch:{ ApnException -> 0x0159, MmsNetworkException -> 0x014f, MmsHttpException -> 0x0146, Exception -> 0x013d }
        r10 = r1;
        r8 = r2;
        goto L_0x008a;
    L_0x00f1:
        r3.mo116d();	 Catch:{  }
        r1 = -1;
        r12 = r2;
        r2 = r1;
        r1 = r12;
    L_0x00f8:
        if (r10 == 0) goto L_0x010b;
    L_0x00fa:
        throw r10;	 Catch:{  }
    L_0x00fb:
        r2 = move-exception;
    L_0x00fc:
        r3 = "MmsLib";	 Catch:{  }
        r4 = "MmsRequest: MMS network acquiring failure";	 Catch:{  }
        com.facebook.debug.log.BLog.b(r3, r4, r2);	 Catch:{  }
        r2 = 3;
        r15.m3556d();
        r3 = r2;
        r2 = r7;
        goto L_0x0028;
    L_0x010b:
        r15.m3556d();
        r3 = r2;
        r2 = r7;
        goto L_0x0028;
    L_0x0112:
        r2 = move-exception;
    L_0x0113:
        r3 = "MmsLib";	 Catch:{  }
        r4 = "MmsRequest: HTTP or network I/O failure";	 Catch:{  }
        com.facebook.debug.log.BLog.b(r3, r4, r2);	 Catch:{  }
        r3 = 4;	 Catch:{  }
        r2 = r2.m3537a();	 Catch:{  }
        r15.m3556d();
        goto L_0x0028;
    L_0x0124:
        r2 = move-exception;
    L_0x0125:
        r3 = "MmsLib";	 Catch:{  }
        r4 = "MmsRequest: unexpected failure";	 Catch:{  }
        com.facebook.debug.log.BLog.b(r3, r4, r2);	 Catch:{  }
        r2 = 1;
        r15.m3556d();
        r3 = r2;
        r2 = r7;
        goto L_0x0028;
    L_0x0134:
        r1 = move-exception;
        r15.m3556d();
        throw r1;
    L_0x0139:
        r1 = move-exception;
        r2 = r1;
        r1 = r8;
        goto L_0x0125;
    L_0x013d:
        r1 = move-exception;
        r12 = r1;
        r1 = r2;
        r2 = r12;
        goto L_0x0125;
    L_0x0142:
        r1 = move-exception;
        r2 = r1;
        r1 = r8;
        goto L_0x0113;
    L_0x0146:
        r1 = move-exception;
        r12 = r1;
        r1 = r2;
        r2 = r12;
        goto L_0x0113;
    L_0x014b:
        r1 = move-exception;
        r2 = r1;
        r1 = r8;
        goto L_0x00fc;
    L_0x014f:
        r1 = move-exception;
        r12 = r1;
        r1 = r2;
        r2 = r12;
        goto L_0x00fc;
    L_0x0154:
        r1 = move-exception;
        r2 = r1;
        r1 = r8;
        goto L_0x0059;
    L_0x0159:
        r1 = move-exception;
        r12 = r1;
        r1 = r2;
        r2 = r12;
        goto L_0x0059;
    L_0x015f:
        r1 = move-exception;
        r2 = r8;
        goto L_0x00e7;
    L_0x0162:
        r1 = r8;
        r2 = r9;
        goto L_0x00f8;
        */
        throw new UnsupportedOperationException("Method not decompiled: android_src.mmsv2.MmsRequest.a(android.content.Context, android_src.mmsv2.MmsNetworkManager, android_src.mmsv2.DefaultApnSettingsLoader, android_src.mmsv2.CarrierConfigValuesLoader, android_src.mmsv2.DefaultUserAgentInfoLoader):void");
    }

    private static boolean m3511a(byte[] bArr, Bundle bundle) {
        if (bArr != null && bArr.length > 0) {
            try {
                GenericPdu a = new PduParser(bArr, bundle.getBoolean("supportMmsContentDisposition", true)).m3679a();
                if (a != null && (a instanceof SendConf)) {
                    int d = ((SendConf) a).m3730d();
                    return d == 227 || d == 132;
                }
            } catch (Throwable e) {
                BLog.a("MmsLib", "Parsing response failed", e);
            }
        }
        return false;
    }

    final void m3513a(Context context, int i, byte[] bArr, int i2) {
        if (this.f3771c != null) {
            Intent intent = new Intent();
            if (!(bArr == null || mo119a(context, intent, bArr))) {
                i = 5;
            }
            if (i == 4 && i2 != 0) {
                intent.putExtra("android.telephony.extra.MMS_HTTP_STATUS", i2);
            }
            try {
                this.f3771c.send(context, i, intent);
            } catch (Throwable e) {
                BLog.b("MmsLib", "Sending pending intent canceled", e);
            }
        }
    }

    private static void m3509a(ConnectivityManager connectivityManager, ApnSettingsLoader$Apn apnSettingsLoader$Apn, String str) {
        String b = apnSettingsLoader$Apn.mo114b();
        if (TextUtils.isEmpty(b)) {
            b = Uri.parse(str).getHost();
        }
        try {
            int i = 0;
            for (InetAddress inetAddress : InetAddress.getAllByName(b)) {
                if (m3510a(connectivityManager, inetAddress)) {
                    i = 1;
                    new StringBuilder("Requested route to ").append(inetAddress);
                } else {
                    new StringBuilder("Could not requested route to ").append(inetAddress);
                }
            }
            if (i == 0) {
                throw new MmsHttpException(0, "No route requested");
            }
        } catch (UnknownHostException e) {
            BLog.a("MmsLib", "Unknown host " + b);
            throw new MmsHttpException(0, "Unknown host");
        }
    }

    private static boolean m3510a(ConnectivityManager connectivityManager, InetAddress inetAddress) {
        Method method;
        try {
            method = connectivityManager.getClass().getMethod("requestRouteToHostAddress", new Class[]{Integer.TYPE, InetAddress.class});
            if (method != null) {
                return ((Boolean) method.invoke(connectivityManager, new Object[]{f3768f, inetAddress})).booleanValue();
            }
        } catch (Exception e) {
            BLog.a("MmsLib", "ConnectivityManager.requestRouteToHostAddress failed " + e);
        }
        if (inetAddress instanceof Inet4Address) {
            try {
                method = connectivityManager.getClass().getMethod("requestRouteToHost", new Class[]{Integer.TYPE, Integer.TYPE});
                if (method != null) {
                    return ((Boolean) method.invoke(connectivityManager, new Object[]{f3768f, Integer.valueOf(m3508a(inetAddress))})).booleanValue();
                }
            } catch (Exception e2) {
                BLog.a("MmsLib", "ConnectivityManager.requestRouteToHost failed " + e2);
            }
        }
        return false;
    }

    private static int m3508a(InetAddress inetAddress) {
        byte[] address = inetAddress.getAddress();
        return (address[0] & 255) | ((((address[3] & 255) << 24) | ((address[2] & 255) << 16)) | ((address[1] & 255) << 8));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        if (this.f3773e) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(this.f3769a);
        parcel.writeParcelable(this.f3770b, 0);
        parcel.writeParcelable(this.f3771c, 0);
    }

    protected MmsRequest(Parcel parcel) {
        ClassLoader classLoader = MmsRequest.class.getClassLoader();
        this.f3773e = parcel.readByte() != (byte) 0;
        this.f3769a = parcel.readString();
        this.f3770b = (Uri) parcel.readParcelable(classLoader);
        this.f3771c = (PendingIntent) parcel.readParcelable(classLoader);
    }
}
