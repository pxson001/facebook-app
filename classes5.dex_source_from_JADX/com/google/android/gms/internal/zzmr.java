package com.google.android.gms.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.util.SparseArray;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzx;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzmr extends Fragment implements OnCancelListener {
    private static final GoogleApiAvailability f6897a = GoogleApiAvailability.b;
    public boolean f6898b;
    public boolean f6899c;
    private int f6900d = -1;
    private ConnectionResult f6901e;
    public final Handler f6902f = new Handler(Looper.getMainLooper());
    private zzmk f6903g;
    public final SparseArray<zza> f6904h = new SparseArray();

    public class zza implements OnConnectionFailedListener {
        public final int f6888a;
        public final GoogleApiClient f6889b;
        public final OnConnectionFailedListener f6890c;
        final /* synthetic */ zzmr f6891d;

        public zza(zzmr com_google_android_gms_internal_zzmr, int i, GoogleApiClient googleApiClient, OnConnectionFailedListener onConnectionFailedListener) {
            this.f6891d = com_google_android_gms_internal_zzmr;
            this.f6888a = i;
            this.f6889b = googleApiClient;
            this.f6890c = onConnectionFailedListener;
            googleApiClient.a(this);
        }

        public final void m12858a(ConnectionResult connectionResult) {
            HandlerDetour.a(this.f6891d.f6902f, new zzb(this.f6891d, this.f6888a, connectionResult), -287508579);
        }
    }

    class zzb implements Runnable {
        final /* synthetic */ zzmr f6894a;
        private final int f6895b;
        private final ConnectionResult f6896c;

        public zzb(zzmr com_google_android_gms_internal_zzmr, int i, ConnectionResult connectionResult) {
            this.f6894a = com_google_android_gms_internal_zzmr;
            this.f6895b = i;
            this.f6896c = connectionResult;
        }

        public void run() {
            if (this.f6894a.f6898b && !this.f6894a.f6899c) {
                this.f6894a.f6899c = true;
                this.f6894a.f6900d = this.f6895b;
                this.f6894a.f6901e = this.f6896c;
                if (this.f6896c.a()) {
                    try {
                        this.f6896c.a(this.f6894a.o(), ((this.f6894a.o().kO_().getFragments().indexOf(this.f6894a) + 1) << 16) + 1);
                        return;
                    } catch (SendIntentException e) {
                        zzmr.m12867b(this.f6894a);
                        return;
                    }
                }
                zzmr.f6897a;
                if (GooglePlayServicesUtil.c(this.f6896c.c())) {
                    GooglePlayServicesUtil.a(this.f6896c.c(), this.f6894a.o(), this.f6894a, 2, this.f6894a);
                } else if (this.f6896c.c() == 18) {
                    zzmr.f6897a;
                    final Dialog a = GoogleApiAvailability.a(this.f6894a.o(), this.f6894a);
                    this.f6894a.f6903g = zzmk.m12843a(this.f6894a.o().getApplicationContext(), new zzmk(this) {
                        final /* synthetic */ zzb f6893c;

                        protected final void mo841a() {
                            zzmr.m12867b(this.f6893c.f6894a);
                            a.dismiss();
                        }
                    });
                } else {
                    zzmr.m12865a(this.f6894a, this.f6895b, this.f6896c);
                }
            }
        }
    }

    public static zzmr m12864a(FragmentActivity fragmentActivity) {
        zzx.b("Must be called from main thread of process");
        try {
            zzmr com_google_android_gms_internal_zzmr = (zzmr) fragmentActivity.kO_().a("GmsSupportLifecycleFrag");
            return (com_google_android_gms_internal_zzmr == null || com_google_android_gms_internal_zzmr.w()) ? null : com_google_android_gms_internal_zzmr;
        } catch (Throwable e) {
            throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFrag is not a SupportLifecycleFragment", e);
        }
    }

    public static void m12865a(zzmr com_google_android_gms_internal_zzmr, int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLifecycleFrag", "Unresolved error while connecting client. Stopping auto-manage.");
        zza com_google_android_gms_internal_zzmr_zza = (zza) com_google_android_gms_internal_zzmr.f6904h.get(i);
        if (com_google_android_gms_internal_zzmr_zza != null) {
            zza com_google_android_gms_internal_zzmr_zza2 = (zza) com_google_android_gms_internal_zzmr.f6904h.get(i);
            com_google_android_gms_internal_zzmr.f6904h.remove(i);
            if (com_google_android_gms_internal_zzmr_zza2 != null) {
                com_google_android_gms_internal_zzmr_zza2.f6889b.b(com_google_android_gms_internal_zzmr_zza2);
                com_google_android_gms_internal_zzmr_zza2.f6889b.e();
            }
            OnConnectionFailedListener onConnectionFailedListener = com_google_android_gms_internal_zzmr_zza.f6890c;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.a(connectionResult);
            }
        }
        m12867b(com_google_android_gms_internal_zzmr);
    }

    public static void m12867b(zzmr com_google_android_gms_internal_zzmr) {
        com_google_android_gms_internal_zzmr.f6899c = false;
        com_google_android_gms_internal_zzmr.f6900d = -1;
        com_google_android_gms_internal_zzmr.f6901e = null;
        if (com_google_android_gms_internal_zzmr.f6903g != null) {
            com_google_android_gms_internal_zzmr.f6903g.m12846b();
            com_google_android_gms_internal_zzmr.f6903g = null;
        }
        for (int i = 0; i < com_google_android_gms_internal_zzmr.f6904h.size(); i++) {
            ((zza) com_google_android_gms_internal_zzmr.f6904h.valueAt(i)).f6889b.c();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m12868a(int r5, int r6, android.content.Intent r7) {
        /*
        r4 = this;
        r0 = 1;
        r1 = 0;
        switch(r5) {
            case 1: goto L_0x0017;
            case 2: goto L_0x000c;
            default: goto L_0x0005;
        };
    L_0x0005:
        r0 = r1;
    L_0x0006:
        if (r0 == 0) goto L_0x0027;
    L_0x0008:
        m12867b(r4);
    L_0x000b:
        return;
    L_0x000c:
        r2 = r4.o();
        r2 = com.google.android.gms.common.GoogleApiAvailability.a(r2);
        if (r2 != 0) goto L_0x0005;
    L_0x0016:
        goto L_0x0006;
    L_0x0017:
        r2 = -1;
        if (r6 == r2) goto L_0x0006;
    L_0x001a:
        if (r6 != 0) goto L_0x0005;
    L_0x001c:
        r0 = new com.google.android.gms.common.ConnectionResult;
        r2 = 13;
        r3 = 0;
        r0.<init>(r2, r3);
        r4.f6901e = r0;
        goto L_0x0005;
    L_0x0027:
        r0 = r4.f6900d;
        r1 = r4.f6901e;
        m12865a(r4, r0, r1);
        goto L_0x000b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzmr.a(int, int, android.content.Intent):void");
    }

    public final void m12869a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 575582762);
        super.a(bundle);
        if (bundle != null) {
            this.f6899c = bundle.getBoolean("resolving_error", false);
            this.f6900d = bundle.getInt("failed_client_id", -1);
            if (this.f6900d >= 0) {
                this.f6901e = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution"));
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -318922382, a);
    }

    public final void m12870a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.a(str, fileDescriptor, printWriter, strArr);
        for (int i = 0; i < this.f6904h.size(); i++) {
            zza com_google_android_gms_internal_zzmr_zza = (zza) this.f6904h.valueAt(i);
            printWriter.append(str).append("GoogleApiClient #").print(com_google_android_gms_internal_zzmr_zza.f6888a);
            printWriter.println(":");
            com_google_android_gms_internal_zzmr_zza.f6889b.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    public final void m12871e(Bundle bundle) {
        super.e(bundle);
        bundle.putBoolean("resolving_error", this.f6899c);
        if (this.f6900d >= 0) {
            bundle.putInt("failed_client_id", this.f6900d);
            bundle.putInt("failed_status", this.f6901e.c);
            bundle.putParcelable("failed_resolution", this.f6901e.d);
        }
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -52222579);
        super.mi_();
        this.f6898b = true;
        if (!this.f6899c) {
            for (int i = 0; i < this.f6904h.size(); i++) {
                ((zza) this.f6904h.valueAt(i)).f6889b.c();
            }
        }
        LogUtils.f(693453075, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -587625340);
        super.mj_();
        this.f6898b = false;
        for (int i = 0; i < this.f6904h.size(); i++) {
            ((zza) this.f6904h.valueAt(i)).f6889b.e();
        }
        LogUtils.f(772020943, a);
    }

    public void onCancel(DialogInterface dialogInterface) {
        m12865a(this, this.f6900d, new ConnectionResult(13, null));
    }
}
