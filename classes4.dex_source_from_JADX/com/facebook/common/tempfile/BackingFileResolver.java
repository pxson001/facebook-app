package com.facebook.common.tempfile;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Images.Media;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.tempfile.TempFileManager.Privacy;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mLastSyncTime */
public class BackingFileResolver {
    private static volatile BackingFileResolver f8650e;
    public final Context f8651a;
    public final ContentResolver f8652b;
    private final TempFileManager f8653c;
    private final DefaultAndroidThreadUtil f8654d;

    public static com.facebook.common.tempfile.BackingFileResolver m8895a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8650e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.tempfile.BackingFileResolver.class;
        monitor-enter(r1);
        r0 = f8650e;	 Catch:{ all -> 0x003a }
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
        r0 = m8897b(r0);	 Catch:{ all -> 0x0035 }
        f8650e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8650e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.tempfile.BackingFileResolver.a(com.facebook.inject.InjectorLike):com.facebook.common.tempfile.BackingFileResolver");
    }

    private static BackingFileResolver m8897b(InjectorLike injectorLike) {
        return new BackingFileResolver((Context) injectorLike.getInstance(Context.class), ContentResolverMethodAutoProvider.b(injectorLike), TempFileManager.m8903a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike));
    }

    @Inject
    public BackingFileResolver(Context context, ContentResolver contentResolver, TempFileManager tempFileManager, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f8651a = context;
        this.f8652b = contentResolver;
        this.f8653c = tempFileManager;
        this.f8654d = defaultAndroidThreadUtil;
    }

    public final BackingFileResult m8899a(Uri uri, Privacy privacy) {
        File a = m8900a(uri);
        if (a != null) {
            return new BackingFileResult(a, false);
        }
        a = this.f8653c.m8907a("backing_file_copy", ".tmp", privacy);
        if (a == null) {
            throw new IOException("Failed to create temp file");
        }
        new 1(this, uri).m11935a(Files.m11916a(a, new FileWriteMode[0]));
        return new BackingFileResult(a, true);
    }

    public final File m8900a(Uri uri) {
        this.f8654d.b();
        if (uri == null) {
            return null;
        }
        if ("file".equals(uri.getScheme())) {
            return new File(uri.getPath());
        }
        if (VERSION.SDK_INT >= 19 && DocumentsContract.isDocumentUri(this.f8651a, uri)) {
            return m8898d(uri);
        }
        if ("media".equals(uri.getAuthority())) {
            return m8896a(uri, null, null);
        }
        return null;
    }

    @TargetApi(19)
    private File m8898d(Uri uri) {
        if (((String[]) Iterables.a(Splitter.on(":").limit(2).split(DocumentsContract.getDocumentId(uri)), String.class)).length != 2) {
            return null;
        }
        String str = "_id=?";
        String[] strArr = new String[]{((String[]) Iterables.a(Splitter.on(":").limit(2).split(DocumentsContract.getDocumentId(uri)), String.class))[1]};
        File a = m8896a(Media.EXTERNAL_CONTENT_URI, str, strArr);
        return a == null ? m8896a(Media.INTERNAL_CONTENT_URI, str, strArr) : a;
    }

    private File m8896a(Uri uri, @Nullable String str, @Nullable String[] strArr) {
        Cursor query = this.f8652b.query(uri, new String[]{"_data"}, str, strArr, null);
        if (query == null) {
            return null;
        }
        try {
            int columnIndex = query.getColumnIndex("_data");
            if (columnIndex < 0 || !query.moveToNext()) {
                query.close();
                return null;
            }
            String string = query.getString(columnIndex);
            if (string == null) {
                return null;
            }
            File file = new File(string);
            if (string.startsWith("http") || !file.exists()) {
                query.close();
                return null;
            }
            query.close();
            return file;
        } finally {
            query.close();
        }
    }

    public final long m8901b(Uri uri) {
        this.f8654d.b();
        try {
            File a = m8900a(uri);
            if (a != null) {
                return a.length();
            }
            ParcelFileDescriptor openFileDescriptor = this.f8652b.openFileDescriptor(uri, "r");
            try {
                long statSize = openFileDescriptor.getStatSize();
                return statSize;
            } finally {
                openFileDescriptor.close();
            }
        } catch (IOException e) {
            return 0;
        }
    }
}
