package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.zzh;

public class zzbj implements zzh {
    private final LargeAssetSyncRequestPayload f13378a;
    private final zzay f13379b;
    private boolean f13380c;
    private ParcelFileDescriptor f13381d;
    private long f13382e;
    private int f13383f;

    public zzbj(LargeAssetSyncRequestPayload largeAssetSyncRequestPayload, zzay com_google_android_gms_wearable_internal_zzay) {
        this.f13378a = (LargeAssetSyncRequestPayload) zzx.a(largeAssetSyncRequestPayload);
        this.f13379b = (zzay) zzx.a(com_google_android_gms_wearable_internal_zzay);
        zzx.a(largeAssetSyncRequestPayload.f13330b);
        zzx.b(largeAssetSyncRequestPayload.f13331c >= 0, "Got negative offset: %s", new Object[]{Long.valueOf(largeAssetSyncRequestPayload.f13331c)});
    }

    public final void m13563a() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x001d in list [B:6:0x0018]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        r0 = r4.f13380c;	 Catch:{ all -> 0x0026 }
        r1 = "Received onLargeAssetSyncRequest but didn't set a response.";	 Catch:{ all -> 0x0026 }
        com.google.android.gms.common.internal.zzx.a(r0, r1);	 Catch:{ all -> 0x0026 }
        r0 = r4.f13381d;	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x001e;	 Catch:{ all -> 0x0026 }
    L_0x000b:
        r0 = r4.f13379b;	 Catch:{ all -> 0x0026 }
        r1 = r4.f13381d;	 Catch:{ all -> 0x0026 }
        r2 = r4.f13382e;	 Catch:{ all -> 0x0026 }
        r0.mo617a(r1, r2);	 Catch:{ all -> 0x0026 }
    L_0x0014:
        r0 = r4.f13381d;
        if (r0 == 0) goto L_0x001d;
    L_0x0018:
        r0 = r4.f13381d;
        com.google.android.gms.internal.zznt.a(r0);
    L_0x001d:
        return;
    L_0x001e:
        r0 = r4.f13379b;	 Catch:{  }
        r1 = r4.f13383f;	 Catch:{  }
        r0.mo616a(r1);	 Catch:{  }
        goto L_0x0014;
    L_0x0026:
        r0 = move-exception;
        r1 = r4.f13381d;
        if (r1 == 0) goto L_0x0030;
    L_0x002b:
        r1 = r4.f13381d;
        com.google.android.gms.internal.zznt.a(r1);
    L_0x0030:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.internal.zzbj.a():void");
    }

    public final void mo670a(int i) {
        zzx.a(!this.f13380c, "createOutputFileDescriptor called when response already set");
        this.f13383f = i;
        this.f13380c = true;
    }
}
