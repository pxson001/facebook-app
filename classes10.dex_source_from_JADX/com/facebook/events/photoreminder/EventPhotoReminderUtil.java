package com.facebook.events.photoreminder;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.InjectorLike;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: background_location_chat_context_disabled_miniphone_selected */
public class EventPhotoReminderUtil {
    private static final Uri f18965a = Media.EXTERNAL_CONTENT_URI;
    private static final String[] f18966b = new String[]{"Count(1)"};
    private static volatile EventPhotoReminderUtil f18967f;
    private final Context f18968c;
    private final DefaultAndroidThreadUtil f18969d;
    private ListeningExecutorService f18970e;

    public static com.facebook.events.photoreminder.EventPhotoReminderUtil m19199a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f18967f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.events.photoreminder.EventPhotoReminderUtil.class;
        monitor-enter(r1);
        r0 = f18967f;	 Catch:{ all -> 0x003a }
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
        r0 = m19202b(r0);	 Catch:{ all -> 0x0035 }
        f18967f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f18967f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.photoreminder.EventPhotoReminderUtil.a(com.facebook.inject.InjectorLike):com.facebook.events.photoreminder.EventPhotoReminderUtil");
    }

    private static EventPhotoReminderUtil m19202b(InjectorLike injectorLike) {
        return new EventPhotoReminderUtil((Context) injectorLike.getInstance(Context.class), DefaultAndroidThreadUtil.b(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    private static String m19200a(long j, long j2) {
        return StringFormatUtil.a("%1s = 'image/jpeg' AND (LOWER(%2s) LIKE '%%dcim%%' or LOWER(%3s) LIKE '%%camera%%') AND (%4s >= %5d AND %6s <= %7d)", new Object[]{"mime_type", "_data", "_data", "datetaken", Long.valueOf(j), "datetaken", Long.valueOf(j2)});
    }

    @Inject
    public EventPhotoReminderUtil(Context context, DefaultAndroidThreadUtil defaultAndroidThreadUtil, ListeningExecutorService listeningExecutorService) {
        this.f18968c = context;
        this.f18969d = defaultAndroidThreadUtil;
        this.f18970e = listeningExecutorService;
    }

    public final void m19203a(long j, long j2, AbstractDisposableFutureCallback<Integer> abstractDisposableFutureCallback) {
        final long j3 = j;
        final long j4 = j2;
        Futures.a(this.f18970e.a(new Callable<Integer>(this) {
            final /* synthetic */ EventPhotoReminderUtil f18964c;

            public Object call() {
                return Integer.valueOf(EventPhotoReminderUtil.m19201b(this.f18964c, j3, j4));
            }
        }), abstractDisposableFutureCallback, MoreExecutors.a());
    }

    public static int m19201b(EventPhotoReminderUtil eventPhotoReminderUtil, long j, long j2) {
        eventPhotoReminderUtil.f18969d.b();
        Cursor query = eventPhotoReminderUtil.f18968c.getContentResolver().query(f18965a, f18966b, m19200a(1000 * j, 1000 * j2), null, null);
        if (query == null) {
            return 0;
        }
        try {
            query.moveToNext();
            int i = query.getInt(0);
            return i;
        } finally {
            query.close();
        }
    }
}
