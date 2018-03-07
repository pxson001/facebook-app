package com.facebook.bookmark.db;

import android.content.ContentResolver;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.bookmark.ipc.BookmarkContract;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.inject.InjectorLike;
import com.facebook.languages.switchercommonex.LocaleChangeController;
import com.facebook.languages.switchercommonex.LocaleChangeListener;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: message_preview */
public class BookmarkDatabaseCleaner implements IHaveUserData, INeedInit, LocaleChangeListener {
    private static volatile BookmarkDatabaseCleaner f8112d;
    private final ContentResolver f8113a;
    private final ListeningExecutorService f8114b;
    private final LocaleChangeController f8115c;

    public static com.facebook.bookmark.db.BookmarkDatabaseCleaner m8391a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f8112d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.bookmark.db.BookmarkDatabaseCleaner.class;
        monitor-enter(r1);
        r0 = f8112d;	 Catch:{ all -> 0x003a }
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
        r0 = m8392b(r0);	 Catch:{ all -> 0x0035 }
        f8112d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8112d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.bookmark.db.BookmarkDatabaseCleaner.a(com.facebook.inject.InjectorLike):com.facebook.bookmark.db.BookmarkDatabaseCleaner");
    }

    private static BookmarkDatabaseCleaner m8392b(InjectorLike injectorLike) {
        return new BookmarkDatabaseCleaner(ContentResolverMethodAutoProvider.b(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), LocaleChangeController.a(injectorLike));
    }

    @Inject
    public BookmarkDatabaseCleaner(ContentResolver contentResolver, ListeningExecutorService listeningExecutorService, LocaleChangeController localeChangeController) {
        this.f8113a = contentResolver;
        this.f8114b = listeningExecutorService;
        this.f8115c = localeChangeController;
    }

    public void init() {
        this.f8115c.a(this);
    }

    public void clearUserData() {
        this.f8113a.delete(BookmarkContract.b, null, null);
    }

    public final ListenableFuture m8393a(Locale locale) {
        return this.f8114b.a(new 1(this));
    }
}
