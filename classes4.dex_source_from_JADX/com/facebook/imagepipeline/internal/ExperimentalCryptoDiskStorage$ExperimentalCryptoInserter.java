package com.facebook.imagepipeline.internal;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.DiskStorage$Inserter;

/* compiled from: see_all */
class ExperimentalCryptoDiskStorage$ExperimentalCryptoInserter implements DiskStorage$Inserter {
    final /* synthetic */ ExperimentalCryptoDiskStorage f2924a;
    public final ExperimentalCryptoConfig f2925b;
    private final DiskStorage$Inserter f2926c;

    public ExperimentalCryptoDiskStorage$ExperimentalCryptoInserter(ExperimentalCryptoDiskStorage experimentalCryptoDiskStorage, ExperimentalCryptoConfig experimentalCryptoConfig, DiskStorage$Inserter diskStorage$Inserter) {
        this.f2924a = experimentalCryptoDiskStorage;
        this.f2925b = experimentalCryptoConfig;
        this.f2926c = diskStorage$Inserter;
    }

    public final void mo264a(final WriterCallback writerCallback, Object obj) {
        this.f2926c.mo264a(new WriterCallback(this) {
            final /* synthetic */ ExperimentalCryptoDiskStorage$ExperimentalCryptoInserter f2931b;

            public final void mo259a(java.io.OutputStream r5) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:17:0x0060 in {5, 19, 20, 23, 26, 36, 38, 39, 42, 45, 47, 49, 51, 52, 53, 54, 56} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r4 = this;
                r2 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
                r0 = r4.f2931b;
                r0 = r0.f2925b;
                r1 = com.facebook.imagepipeline.internal.ExperimentalCryptoConfig.NONE;
                if (r0 == r1) goto L_0x001e;
            L_0x000a:
                r0 = r4.f2931b;
                r0 = r0.f2925b;
                r1 = com.facebook.imagepipeline.internal.ExperimentalCryptoConfig.ENCRYPTED;
                if (r0 != r1) goto L_0x0024;
            L_0x0012:
                r0 = r4.f2931b;
                r0 = r0.f2924a;
                r0 = r0.f;
                r0 = r0.a();
                if (r0 != 0) goto L_0x0024;
            L_0x001e:
                r0 = r3;
                r0.mo259a(r5);
            L_0x0023:
                return;
            L_0x0024:
                r0 = r4.f2931b;
                r0 = r0.f2925b;
                r1 = com.facebook.imagepipeline.internal.ExperimentalCryptoConfig.FIXED_KEY;
                if (r0 != r1) goto L_0x0078;
            L_0x002c:
                r0 = com.facebook.imagepipeline.internal.ExperimentalCryptoDiskStorage.m;
                r5.write(r0);
                r0 = r4.f2931b;
                r0 = r0.f2924a;
                r0 = r0.g;
                r0 = r0.a(r2);
                r0 = (byte[]) r0;
                r1 = r4.f2931b;	 Catch:{ CryptoInitializationException -> 0x0064, KeyChainException -> 0x00c9 }
                r1 = r1.f2924a;	 Catch:{ CryptoInitializationException -> 0x0064, KeyChainException -> 0x00c9 }
                r1 = r1.e;	 Catch:{ CryptoInitializationException -> 0x0064, KeyChainException -> 0x00c9 }
                r2 = com.facebook.common.iolite.Streams.m5987a(r5);	 Catch:{ CryptoInitializationException -> 0x0064, KeyChainException -> 0x00c9 }
                r3 = com.facebook.imagepipeline.internal.ExperimentalCryptoDiskStorage.a;	 Catch:{ CryptoInitializationException -> 0x0064, KeyChainException -> 0x00c9 }
                r2 = r1.a(r2, r3, r0);	 Catch:{ CryptoInitializationException -> 0x0064, KeyChainException -> 0x00c9 }
                r1 = r3;	 Catch:{ all -> 0x005f }
                r1.mo259a(r2);	 Catch:{ all -> 0x005f }
                r2.close();
                r1 = r4.f2931b;
                r1 = r1.f2924a;
                r1 = r1.g;
                r1.a(r0);
                goto L_0x0023;
            L_0x005f:
                r1 = move-exception;
                r2.close();	 Catch:{ all -> 0x005f }
                throw r1;	 Catch:{ all -> 0x005f }
            L_0x0064:
                r1 = move-exception;
            L_0x0065:
                r2 = new java.io.IOException;	 Catch:{ all -> 0x006d }
                r3 = "Error encrypting";	 Catch:{ all -> 0x006d }
                r2.<init>(r3, r1);	 Catch:{ all -> 0x006d }
                throw r2;	 Catch:{ all -> 0x006d }
            L_0x006d:
                r1 = move-exception;
                r2 = r4.f2931b;
                r2 = r2.f2924a;
                r2 = r2.g;
                r2.a(r0);
                throw r1;
            L_0x0078:
                r0 = com.facebook.imagepipeline.internal.ExperimentalCryptoDiskStorage.l;
                r5.write(r0);
                r0 = r4.f2931b;
                r0 = r0.f2924a;
                r0 = r0.g;
                r0 = r0.a(r2);
                r0 = (byte[]) r0;
                r1 = r4.f2931b;	 Catch:{ CryptoInitializationException -> 0x00b1, KeyChainException -> 0x00c5, UserCryptoNotAvailableException -> 0x00c7 }
                r1 = r1.f2924a;	 Catch:{ CryptoInitializationException -> 0x00b1, KeyChainException -> 0x00c5, UserCryptoNotAvailableException -> 0x00c7 }
                r1 = r1.f;	 Catch:{ CryptoInitializationException -> 0x00b1, KeyChainException -> 0x00c5, UserCryptoNotAvailableException -> 0x00c7 }
                r2 = com.facebook.common.iolite.Streams.m5987a(r5);	 Catch:{ CryptoInitializationException -> 0x00b1, KeyChainException -> 0x00c5, UserCryptoNotAvailableException -> 0x00c7 }
                r3 = com.facebook.imagepipeline.internal.ExperimentalCryptoDiskStorage.a;	 Catch:{ CryptoInitializationException -> 0x00b1, KeyChainException -> 0x00c5, UserCryptoNotAvailableException -> 0x00c7 }
                r2 = r1.a(r2, r3, r0);	 Catch:{ CryptoInitializationException -> 0x00b1, KeyChainException -> 0x00c5, UserCryptoNotAvailableException -> 0x00c7 }
                r1 = r3;	 Catch:{ all -> 0x00ac }
                r1.mo259a(r2);	 Catch:{ all -> 0x00ac }
                r2.close();
                r1 = r4.f2931b;
                r1 = r1.f2924a;
                r1 = r1.g;
                r1.a(r0);
                goto L_0x0023;
            L_0x00ac:
                r1 = move-exception;
                r2.close();	 Catch:{ all -> 0x00ac }
                throw r1;	 Catch:{ all -> 0x00ac }
            L_0x00b1:
                r1 = move-exception;
            L_0x00b2:
                r2 = new java.io.IOException;	 Catch:{ all -> 0x00ba }
                r3 = "Error encrypting";	 Catch:{ all -> 0x00ba }
                r2.<init>(r3, r1);	 Catch:{ all -> 0x00ba }
                throw r2;	 Catch:{ all -> 0x00ba }
            L_0x00ba:
                r1 = move-exception;
                r2 = r4.f2931b;
                r2 = r2.f2924a;
                r2 = r2.g;
                r2.a(r0);
                throw r1;
            L_0x00c5:
                r1 = move-exception;
                goto L_0x00b2;
            L_0x00c7:
                r1 = move-exception;
                goto L_0x00b2;
            L_0x00c9:
                r1 = move-exception;
                goto L_0x0065;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.internal.ExperimentalCryptoDiskStorage.ExperimentalCryptoInserter.1.a(java.io.OutputStream):void");
            }
        }, obj);
    }

    public final BinaryResource mo263a(Object obj) {
        return this.f2926c.mo263a(obj);
    }

    public final boolean mo265a() {
        return this.f2926c.mo265a();
    }
}
