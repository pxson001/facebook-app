package com.facebook.photos.db;

import android.content.ContentResolver;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.photos.PhotosContract;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: source_entity_id */
public class PhotosDatabaseCleaner implements IHaveUserData {
    private static volatile PhotosDatabaseCleaner f2342c;
    private final ContentResolver f2343a;
    private final PhotosContract f2344b;

    public static com.facebook.photos.db.PhotosDatabaseCleaner m2455a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f2342c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.db.PhotosDatabaseCleaner.class;
        monitor-enter(r1);
        r0 = f2342c;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m2456b(r0);	 Catch:{ all -> 0x0035 }
        f2342c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2342c;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.db.PhotosDatabaseCleaner.a(com.facebook.inject.InjectorLike):com.facebook.photos.db.PhotosDatabaseCleaner");
    }

    private static PhotosDatabaseCleaner m2456b(InjectorLike injectorLike) {
        return new PhotosDatabaseCleaner(ContentResolverMethodAutoProvider.b(injectorLike), PhotosContract.a(injectorLike));
    }

    @Inject
    public PhotosDatabaseCleaner(ContentResolver contentResolver, PhotosContract photosContract) {
        this.f2343a = contentResolver;
        this.f2344b = photosContract;
    }

    public void clearUserData() {
        this.f2343a.delete(this.f2344b.c, null, null);
    }
}
