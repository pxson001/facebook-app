package com.facebook.photos.tagging.store;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.facebook.common.executors.FbAsyncTask;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.photos.PhotosContract;
import com.facebook.ipc.photos.PhotosContract.RemovedPreFilledTagsTableProp.Columns;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.base.util.PhotoHashUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: group_icon */
public class RemovedPrefilledTagsDataStore {
    private static volatile RemovedPrefilledTagsDataStore f13440c;
    private final PhotosContract f13441a;
    private final MonotonicClock f13442b;

    /* compiled from: group_icon */
    class AddRemovedTag extends FbAsyncTask<Void, Void, Void> {
        private final PhotosContract f13432a;
        private final MonotonicClock f13433b;
        private Context f13434c;
        private PhotoItem f13435d;
        private long f13436e;

        public AddRemovedTag(Context context, PhotosContract photosContract, MonotonicClock monotonicClock, PhotoItem photoItem, long j) {
            this.f13434c = context;
            this.f13432a = photosContract;
            this.f13433b = monotonicClock;
            this.f13435d = photoItem;
            this.f13436e = j;
        }

        protected final Object m21145a(Object[] objArr) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(Columns.b.d, PhotoHashUtil.m20206a(this.f13435d));
            contentValues.put(Columns.a.d, Long.valueOf(this.f13436e));
            contentValues.put(Columns.c.d, Long.valueOf(this.f13433b.now()));
            this.f13434c.getContentResolver().insert(this.f13432a.f, contentValues);
            return null;
        }
    }

    /* compiled from: group_icon */
    class QueryRemovedTags extends FbAsyncTask<Void, Void, Map<String, List<Long>>> {
        private final PhotosContract f13437a;
        private Context f13438b;
        private List<MediaItem> f13439c;

        protected final Object m21146a(Object[] objArr) {
            HashMap c = Maps.c();
            Cursor query = this.f13438b.getContentResolver().query(this.f13437a.f, null, null, null, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        for (MediaItem mediaItem : this.f13439c) {
                            if (mediaItem instanceof PhotoItem) {
                                c.put(PhotoHashUtil.m20206a(mediaItem), Lists.a());
                            }
                        }
                        int a = Columns.b.a(query);
                        int a2 = Columns.a.a(query);
                        while (query.moveToNext()) {
                            String string = query.getString(a);
                            if (c.containsKey(string)) {
                                ((List) c.get(string)).add(Long.valueOf((long) query.getInt(a2)));
                            }
                        }
                    }
                } catch (Throwable th) {
                    query.close();
                }
            }
            query.close();
            return c;
        }

        public QueryRemovedTags(Context context, PhotosContract photosContract, List<MediaItem> list) {
            this.f13438b = context;
            this.f13437a = photosContract;
            this.f13439c = list;
        }
    }

    public static com.facebook.photos.tagging.store.RemovedPrefilledTagsDataStore m21147a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13440c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.tagging.store.RemovedPrefilledTagsDataStore.class;
        monitor-enter(r1);
        r0 = f13440c;	 Catch:{ all -> 0x003a }
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
        r0 = m21148b(r0);	 Catch:{ all -> 0x0035 }
        f13440c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13440c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.tagging.store.RemovedPrefilledTagsDataStore.a(com.facebook.inject.InjectorLike):com.facebook.photos.tagging.store.RemovedPrefilledTagsDataStore");
    }

    private static RemovedPrefilledTagsDataStore m21148b(InjectorLike injectorLike) {
        return new RemovedPrefilledTagsDataStore(PhotosContract.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public RemovedPrefilledTagsDataStore(PhotosContract photosContract, MonotonicClock monotonicClock) {
        this.f13441a = photosContract;
        this.f13442b = monotonicClock;
    }

    public final void m21150a(Context context, PhotoItem photoItem, long j) {
        new AddRemovedTag(context, this.f13441a, this.f13442b, photoItem, j).a(context, new Void[0]);
    }

    @Nullable
    public final Map<String, List<Long>> m21149a(Context context, List<MediaItem> list) {
        try {
            return (Map) new QueryRemovedTags(context, this.f13441a, list).a(context, new Void[0]).get();
        } catch (Exception e) {
            return null;
        }
    }
}
