package com.google.android.gms.wearable.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzlx.zzb;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.LargeAssetApi.zza;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.PutDataRequest;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class zzce extends zzj<zzbb> {
    private final ExecutorService f13396d = Executors.newCachedThreadPool();
    private final zzbl<Object> f13397e = new zzbl();
    private final zzbl<Object> f13398f = new zzbl();
    private final zzbl<ChannelListener> f13399g = new zzbl();
    private final zzbl<zza> f13400h = new zzbl();
    private final zzbl<DataListener> f13401i = new zzbl();
    private final zzbl<MessageListener> f13402j = new zzbl();
    private final zzbl<NodeListener> f13403k = new zzbl();
    private final zzbl<Object> f13404l = new zzbl();
    private final zzbl<CapabilityListener> f13405m = new zzbl();

    public zzce(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzf com_google_android_gms_common_internal_zzf) {
        super(context, looper, 14, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
    }

    private FutureTask<Boolean> m13584a(final ParcelFileDescriptor parcelFileDescriptor, final byte[] bArr) {
        return new FutureTask(new Callable<Boolean>(this) {
            final /* synthetic */ zzce f13395c;

            public java.lang.Object call() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x00ab in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r5 = this;
                r1 = 3;
                r0 = "WearableClient";
                r0 = android.util.Log.isLoggable(r0, r1);
                if (r0 == 0) goto L_0x001f;
            L_0x0009:
                r0 = "WearableClient";
                r1 = new java.lang.StringBuilder;
                r2 = "processAssets: writing data to FD : ";
                r1.<init>(r2);
                r2 = r3;
                r1 = r1.append(r2);
                r1 = r1.toString();
                android.util.Log.d(r0, r1);
            L_0x001f:
                r1 = new android.os.ParcelFileDescriptor$AutoCloseOutputStream;
                r0 = r3;
                r1.<init>(r0);
                r0 = r4;	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
                r1.write(r0);	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
                r1.flush();	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
                r0 = "WearableClient";	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
                r2 = 3;	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
                r0 = android.util.Log.isLoggable(r0, r2);	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
                if (r0 == 0) goto L_0x004d;	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
            L_0x0037:
                r0 = "WearableClient";	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
                r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
                r3 = "processAssets: wrote data: ";	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
                r2.<init>(r3);	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
                r3 = r3;	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
                r2 = r2.append(r3);	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
                r2 = r2.toString();	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
                android.util.Log.d(r0, r2);	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
            L_0x004d:
                r0 = 1;	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
                r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
                r2 = "WearableClient";	 Catch:{ IOException -> 0x00dc }
                r3 = 3;	 Catch:{ IOException -> 0x00dc }
                r2 = android.util.Log.isLoggable(r2, r3);	 Catch:{ IOException -> 0x00dc }
                if (r2 == 0) goto L_0x0071;	 Catch:{ IOException -> 0x00dc }
            L_0x005b:
                r2 = "WearableClient";	 Catch:{ IOException -> 0x00dc }
                r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00dc }
                r4 = "processAssets: closing: ";	 Catch:{ IOException -> 0x00dc }
                r3.<init>(r4);	 Catch:{ IOException -> 0x00dc }
                r4 = r3;	 Catch:{ IOException -> 0x00dc }
                r3 = r3.append(r4);	 Catch:{ IOException -> 0x00dc }
                r3 = r3.toString();	 Catch:{ IOException -> 0x00dc }
                android.util.Log.d(r2, r3);	 Catch:{ IOException -> 0x00dc }
            L_0x0071:
                r1.close();	 Catch:{ IOException -> 0x00dc }
            L_0x0074:
                return r0;
            L_0x0075:
                r0 = move-exception;
                r0 = "WearableClient";	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
                r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
                r3 = "processAssets: writing data failed: ";	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
                r2.<init>(r3);	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
                r3 = r3;	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
                r2 = r2.append(r3);	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
                r2 = r2.toString();	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
                android.util.Log.w(r0, r2);	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
                r0 = "WearableClient";
                r2 = 3;
                r0 = android.util.Log.isLoggable(r0, r2);
                if (r0 == 0) goto L_0x00ab;
            L_0x0095:
                r0 = "WearableClient";
                r2 = new java.lang.StringBuilder;
                r3 = "processAssets: closing: ";
                r2.<init>(r3);
                r3 = r3;
                r2 = r2.append(r3);
                r2 = r2.toString();
                android.util.Log.d(r0, r2);
            L_0x00ab:
                r1.close();
            L_0x00ae:
                r0 = 0;
                r0 = java.lang.Boolean.valueOf(r0);
                goto L_0x0074;
            L_0x00b4:
                r0 = move-exception;
                r2 = "WearableClient";	 Catch:{ IOException -> 0x00d8 }
                r3 = 3;	 Catch:{ IOException -> 0x00d8 }
                r2 = android.util.Log.isLoggable(r2, r3);	 Catch:{ IOException -> 0x00d8 }
                if (r2 == 0) goto L_0x00d4;	 Catch:{ IOException -> 0x00d8 }
            L_0x00be:
                r2 = "WearableClient";	 Catch:{ IOException -> 0x00d8 }
                r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00d8 }
                r4 = "processAssets: closing: ";	 Catch:{ IOException -> 0x00d8 }
                r3.<init>(r4);	 Catch:{ IOException -> 0x00d8 }
                r4 = r3;	 Catch:{ IOException -> 0x00d8 }
                r3 = r3.append(r4);	 Catch:{ IOException -> 0x00d8 }
                r3 = r3.toString();	 Catch:{ IOException -> 0x00d8 }
                android.util.Log.d(r2, r3);	 Catch:{ IOException -> 0x00d8 }
            L_0x00d4:
                r1.close();	 Catch:{ IOException -> 0x00d8 }
            L_0x00d7:
                throw r0;
            L_0x00d8:
                r1 = move-exception;
                goto L_0x00d7;
            L_0x00da:
                r0 = move-exception;
                goto L_0x00ae;
            L_0x00dc:
                r1 = move-exception;
                goto L_0x0074;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.internal.zzce.1.call():java.lang.Object");
            }
        });
    }

    protected final IInterface m13585a(IBinder iBinder) {
        return zzbb.zza.m13560a(iBinder);
    }

    public final void m13586a() {
        this.f13397e.m13566a(this);
        this.f13398f.m13566a(this);
        this.f13399g.m13566a(this);
        this.f13400h.m13566a(this);
        this.f13401i.m13566a(this);
        this.f13402j.m13566a(this);
        this.f13403k.m13566a(this);
        this.f13404l.m13566a(this);
        this.f13405m.m13566a(this);
        super.a();
    }

    protected final void m13587a(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (Log.isLoggable("WearableClient", 2)) {
            Log.d("WearableClient", "onPostInitHandler: statusCode " + i);
        }
        if (i == 0) {
            this.f13397e.m13565a(iBinder);
            this.f13398f.m13565a(iBinder);
            this.f13399g.m13565a(iBinder);
            this.f13400h.m13565a(iBinder);
            this.f13401i.m13565a(iBinder);
            this.f13402j.m13565a(iBinder);
            this.f13403k.m13565a(iBinder);
            this.f13404l.m13565a(iBinder);
            this.f13405m.m13565a(iBinder);
        }
        super.a(i, iBinder, bundle, i2);
    }

    public final void m13588a(zzb<DataItemResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_DataApi_DataItemResult, PutDataRequest putDataRequest) {
        for (Entry value : putDataRequest.m13287c().entrySet()) {
            Asset asset = (Asset) value.getValue();
            if (asset.m13227a() == null && asset.m13228b() == null && asset.m13229c() == null && asset.m13230d() == null) {
                throw new IllegalArgumentException("Put for " + putDataRequest.m13283a() + " contains invalid asset: " + asset);
            }
        }
        PutDataRequest a = PutDataRequest.m13281a(putDataRequest.m13283a());
        a.m13285a(putDataRequest.m13286b());
        if (putDataRequest.m13288f()) {
            a.m13289g();
        }
        List arrayList = new ArrayList();
        for (Entry value2 : putDataRequest.m13287c().entrySet()) {
            Asset asset2 = (Asset) value2.getValue();
            if (asset2.m13227a() != null) {
                try {
                    ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                    if (Log.isLoggable("WearableClient", 3)) {
                        Log.d("WearableClient", "processAssets: replacing data with FD in asset: " + asset2 + " read:" + createPipe[0] + " write:" + createPipe[1]);
                    }
                    a.m13284a((String) value2.getKey(), Asset.m13224a(createPipe[0]));
                    Runnable a2 = m13584a(createPipe[1], asset2.m13227a());
                    arrayList.add(a2);
                    ExecutorDetour.a(this.f13396d, a2, -1425608059);
                } catch (Throwable e) {
                    throw new IllegalStateException("Unable to create ParcelFileDescriptor for asset in request: " + putDataRequest, e);
                }
            } else if (asset2.m13230d() != null) {
                try {
                    a.m13284a((String) value2.getKey(), Asset.m13224a(l().getContentResolver().openFileDescriptor(asset2.m13230d(), "r")));
                } catch (FileNotFoundException e2) {
                    new zzcd$zzq(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_DataApi_DataItemResult, arrayList).mo608a(new PutDataResponse(4005, null));
                    Log.w("WearableClient", "Couldn't resolve asset URI: " + asset2.m13230d());
                    return;
                }
            } else {
                a.m13284a((String) value2.getKey(), asset2);
            }
        }
        ((zzbb) q()).mo625a(new zzcd$zzq(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_DataApi_DataItemResult, arrayList), a);
    }

    protected final String m13589g() {
        return "com.google.android.gms.wearable.BIND";
    }

    protected final String m13590h() {
        return "com.google.android.gms.wearable.internal.IWearableService";
    }
}
