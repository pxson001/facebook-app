package com.facebook.photos.tagging.store;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.facebook.common.executors.FbAsyncTask;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.photos.PhotosContract;
import com.facebook.ipc.photos.PhotosContract.LocalPhotoMetaDataTableProp.Columns;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.base.util.PhotoHashUtil;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: group_icon_scale */
public class LocalPhotoMetaDataStore {
    private static volatile LocalPhotoMetaDataStore f13429c;
    public final PhotosContract f13430a;
    public final MonotonicClock f13431b;

    /* compiled from: group_icon_scale */
    public class SetAutoTagState extends FbAsyncTask<Void, Void, Void> {
        private final PhotosContract f13424a;
        private final MonotonicClock f13425b;
        private Context f13426c;
        private PhotoItem f13427d;
        private boolean f13428e;

        protected final Object m21142a(Object[] objArr) {
            int i = 1;
            String a = PhotoHashUtil.m20206a(this.f13427d);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Columns.b.d);
            stringBuilder.append(" = ? ");
            String stringBuilder2 = stringBuilder.toString();
            String[] strArr = new String[]{a};
            boolean a2 = m21141a(stringBuilder2, strArr);
            ContentValues contentValues = new ContentValues();
            contentValues.put(Columns.b.d, a);
            a = Columns.d.d;
            if (!this.f13428e) {
                i = 0;
            }
            contentValues.put(a, Integer.valueOf(i));
            contentValues.put(Columns.f.d, Long.valueOf(this.f13425b.now()));
            if (a2) {
                this.f13426c.getContentResolver().update(this.f13424a.e, contentValues, stringBuilder2, strArr);
            } else {
                this.f13426c.getContentResolver().insert(this.f13424a.e, contentValues);
            }
            return null;
        }

        public SetAutoTagState(Context context, PhotosContract photosContract, MonotonicClock monotonicClock, PhotoItem photoItem, boolean z) {
            this.f13426c = context;
            this.f13427d = photoItem;
            this.f13424a = photosContract;
            this.f13425b = monotonicClock;
            this.f13428e = z;
        }

        private boolean m21141a(String str, String[] strArr) {
            Cursor query = this.f13426c.getContentResolver().query(this.f13424a.e, new String[]{Columns.d.d}, str, strArr, null);
            if (query == null || query.getCount() <= 0) {
                if (query != null) {
                    query.close();
                }
                return false;
            }
            query.close();
            return true;
        }
    }

    public static com.facebook.photos.tagging.store.LocalPhotoMetaDataStore m21143a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13429c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.tagging.store.LocalPhotoMetaDataStore.class;
        monitor-enter(r1);
        r0 = f13429c;	 Catch:{ all -> 0x003a }
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
        r0 = m21144b(r0);	 Catch:{ all -> 0x0035 }
        f13429c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13429c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.tagging.store.LocalPhotoMetaDataStore.a(com.facebook.inject.InjectorLike):com.facebook.photos.tagging.store.LocalPhotoMetaDataStore");
    }

    private static LocalPhotoMetaDataStore m21144b(InjectorLike injectorLike) {
        return new LocalPhotoMetaDataStore(PhotosContract.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public LocalPhotoMetaDataStore(PhotosContract photosContract, MonotonicClock monotonicClock) {
        this.f13430a = photosContract;
        this.f13431b = monotonicClock;
    }
}
