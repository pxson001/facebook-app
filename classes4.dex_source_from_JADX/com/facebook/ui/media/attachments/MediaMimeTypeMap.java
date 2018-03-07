package com.facebook.ui.media.attachments;

import android.webkit.MimeTypeMap;
import com.google.common.collect.ImmutableBiMap;
import javax.inject.Singleton;

@Singleton
/* compiled from: mHTTPTraceControl */
public class MediaMimeTypeMap {
    private static volatile MediaMimeTypeMap f8704c;
    private final MimeTypeMap f8705a = MimeTypeMap.getSingleton();
    private final ImmutableBiMap<String, String> f8706b = ImmutableBiMap.b("image/webp", "webp");

    public static com.facebook.ui.media.attachments.MediaMimeTypeMap m8984a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f8704c;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.ui.media.attachments.MediaMimeTypeMap.class;
        monitor-enter(r1);
        r0 = f8704c;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m8983a();	 Catch:{ all -> 0x0034 }
        f8704c = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f8704c;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ui.media.attachments.MediaMimeTypeMap.a(com.facebook.inject.InjectorLike):com.facebook.ui.media.attachments.MediaMimeTypeMap");
    }

    private static MediaMimeTypeMap m8983a() {
        return new MediaMimeTypeMap();
    }

    public final String m8985a(String str) {
        String str2 = (String) this.f8706b.get(str);
        return str2 != null ? str2 : this.f8705a.getExtensionFromMimeType(str);
    }

    public final String m8986b(String str) {
        String str2 = (String) this.f8706b.e().get(str);
        return str2 != null ? str2 : this.f8705a.getMimeTypeFromExtension(str);
    }
}
