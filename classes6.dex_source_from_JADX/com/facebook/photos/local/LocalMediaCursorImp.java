package com.facebook.photos.local;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.MediaStore.Files;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.media.MediaCursorHelper;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.SupportedMediaType;
import java.io.Closeable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@TargetApi(11)
/* compiled from: hashtag/{%s} */
public class LocalMediaCursorImp {
    private static final String[] f13083a = new String[]{"_id", "media_type", "mime_type"};
    private static final String f13084b = LocalMediaCursorImp.class.getSimpleName();
    private static volatile LocalMediaCursorImp f13085i;
    private ContentResolver f13086c;
    public Map<Long, MediaItem> f13087d;
    private MediaCursorUtil f13088e;
    @Nullable
    private CloseableReference f13089f = null;
    private Lazy<FbErrorReporter> f13090g;
    private final Closeable f13091h = new C08491(this);

    /* compiled from: hashtag/{%s} */
    class C08491 implements Closeable {
        final /* synthetic */ LocalMediaCursorImp f13082a;

        C08491(LocalMediaCursorImp localMediaCursorImp) {
            this.f13082a = localMediaCursorImp;
        }

        public void close() {
            this.f13082a.f13087d.clear();
        }
    }

    public static com.facebook.photos.local.LocalMediaCursorImp m20412a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13085i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.local.LocalMediaCursorImp.class;
        monitor-enter(r1);
        r0 = f13085i;	 Catch:{ all -> 0x003a }
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
        r0 = m20413b(r0);	 Catch:{ all -> 0x0035 }
        f13085i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13085i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.local.LocalMediaCursorImp.a(com.facebook.inject.InjectorLike):com.facebook.photos.local.LocalMediaCursorImp");
    }

    private static LocalMediaCursorImp m20413b(InjectorLike injectorLike) {
        return new LocalMediaCursorImp(ContentResolverMethodAutoProvider.b(injectorLike), MediaCursorUtil.m20427b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494));
    }

    @Inject
    public LocalMediaCursorImp(ContentResolver contentResolver, MediaCursorUtil mediaCursorUtil, Lazy<FbErrorReporter> lazy) {
        this.f13086c = contentResolver;
        this.f13088e = mediaCursorUtil;
        this.f13087d = Collections.synchronizedMap(new HashMap());
        this.f13090g = lazy;
    }

    public final synchronized CloseableReference<Closeable> m20416a() {
        CloseableReference<Closeable> closeableReference;
        if (this.f13089f == null || !this.f13089f.d()) {
            this.f13089f = CloseableReference.a(this.f13091h);
            closeableReference = this.f13089f;
        } else {
            closeableReference = this.f13089f.b();
        }
        return closeableReference;
    }

    @Nullable
    public final synchronized MediaItem m20417a(long j) {
        return (MediaItem) this.f13087d.get(Long.valueOf(j));
    }

    public final void m20420b(long j) {
        this.f13087d.remove(Long.valueOf(j));
    }

    public final synchronized MediaItem m20418a(long j, Cursor cursor, int i, int i2) {
        MediaItem mediaItem;
        mediaItem = (MediaItem) this.f13087d.get(Long.valueOf(j));
        if (mediaItem == null) {
            if (cursor.isClosed()) {
                mediaItem = null;
            } else {
                Object obj;
                cursor.moveToPosition(i);
                try {
                    obj = cursor.getInt(1) == 3 ? 1 : null;
                } catch (NullPointerException e) {
                    ((AbstractFbErrorReporter) this.f13090g.get()).a(f13084b, e.getClass().getSimpleName());
                    obj = null;
                }
                if (!cursor.moveToPosition(i + i2)) {
                    cursor.moveToLast();
                }
                long j2 = cursor.getLong(0);
                if (obj != null) {
                    this.f13088e.m20432b(j, j2, this.f13087d);
                } else {
                    this.f13088e.m20431a(j, j2, this.f13087d);
                }
                mediaItem = (MediaItem) this.f13087d.get(Long.valueOf(j));
            }
        }
        return mediaItem;
    }

    public final Cursor m20414a(SupportedMediaType supportedMediaType, @Nullable String str) {
        return m20415a(supportedMediaType, str, null, "_id");
    }

    public final Cursor m20415a(SupportedMediaType supportedMediaType, @Nullable String str, @Nullable String str2, String str3) {
        String a = MediaCursorHelper.a(supportedMediaType);
        if (str != null) {
            a = a + StringFormatUtil.a(" AND %s = '%s'", new Object[]{"bucket_display_name", str});
        }
        if (str2 != null) {
            a = a + " AND " + str2;
        }
        return this.f13086c.query(Files.getContentUri("external"), f13083a, a, null, str3 + " DESC");
    }

    public final synchronized List<MediaItem> m20419a(Cursor cursor, int i) {
        return this.f13088e.m20430a(cursor, i, this.f13087d);
    }
}
