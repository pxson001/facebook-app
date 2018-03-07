package com.facebook.photos.creativeediting.utilities;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.file.FileTree;
import com.facebook.common.file.MoreFileUtils;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: includeReshareContext */
public class CreativeEditingFileManager {
    private static volatile CreativeEditingFileManager f12826f;
    public final Context f12827a;
    private final MoreFileUtils f12828b;
    public final AtomicBoolean f12829c = new AtomicBoolean(false);
    public final ListeningScheduledExecutorService f12830d;
    private final DeleteOldDirectoryScheduler f12831e = new DeleteOldDirectoryScheduler(this);

    /* compiled from: includeReshareContext */
    public class DeleteOldDirectoryScheduler {
        public final /* synthetic */ CreativeEditingFileManager f12823a;
        public final Runnable f12824b = new C08161(this);
        public final Runnable f12825c = new C08172(this);

        /* compiled from: includeReshareContext */
        class C08161 implements Runnable {
            final /* synthetic */ DeleteOldDirectoryScheduler f12821a;

            C08161(DeleteOldDirectoryScheduler deleteOldDirectoryScheduler) {
                this.f12821a = deleteOldDirectoryScheduler;
            }

            public void run() {
                int i = 0;
                File dir = this.f12821a.f12823a.f12827a.getDir("ce", 0);
                if (dir != null) {
                    File[] listFiles = dir.listFiles();
                    int length = listFiles.length;
                    while (i < length) {
                        File file = listFiles[i];
                        Preconditions.checkNotNull(file);
                        Preconditions.checkArgument(file.isDirectory());
                        if (System.currentTimeMillis() - file.lastModified() >= 86400000) {
                            FileTree.a(file);
                            file.delete();
                        }
                        i++;
                    }
                }
            }
        }

        /* compiled from: includeReshareContext */
        class C08172 implements Runnable {
            final /* synthetic */ DeleteOldDirectoryScheduler f12822a;

            C08172(DeleteOldDirectoryScheduler deleteOldDirectoryScheduler) {
                this.f12822a = deleteOldDirectoryScheduler;
            }

            public void run() {
                this.f12822a.f12823a.f12829c.set(false);
            }
        }

        public DeleteOldDirectoryScheduler(CreativeEditingFileManager creativeEditingFileManager) {
            this.f12823a = creativeEditingFileManager;
        }
    }

    public static com.facebook.photos.creativeediting.utilities.CreativeEditingFileManager m20215a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12826f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.creativeediting.utilities.CreativeEditingFileManager.class;
        monitor-enter(r1);
        r0 = f12826f;	 Catch:{ all -> 0x003a }
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
        r0 = m20218b(r0);	 Catch:{ all -> 0x0035 }
        f12826f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12826f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.creativeediting.utilities.CreativeEditingFileManager.a(com.facebook.inject.InjectorLike):com.facebook.photos.creativeediting.utilities.CreativeEditingFileManager");
    }

    private static CreativeEditingFileManager m20218b(InjectorLike injectorLike) {
        return new CreativeEditingFileManager((Context) injectorLike.getInstance(Context.class), MoreFileUtils.a(injectorLike), ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public CreativeEditingFileManager(Context context, MoreFileUtils moreFileUtils, ListeningScheduledExecutorService listeningScheduledExecutorService) {
        this.f12827a = context;
        this.f12828b = moreFileUtils;
        this.f12830d = listeningScheduledExecutorService;
    }

    @Nullable
    public final File m20219a(String str, String str2) {
        String l = Long.toString(System.currentTimeMillis());
        Preconditions.checkArgument(!StringUtil.a(str));
        File a = m20216a(str, true);
        if (a == null) {
            return null;
        }
        return new File(a, StringFormatUtil.a("%s.%s", new Object[]{l, str2}));
    }

    public static void m20217a(Uri uri) {
        new File(uri.getEncodedPath()).delete();
    }

    @Nullable
    private File m20216a(String str, boolean z) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(str));
        File file = new File(this.f12827a.getDir("ce", 0), str);
        if (z) {
            if (file.isDirectory() || file.mkdir()) {
                DeleteOldDirectoryScheduler deleteOldDirectoryScheduler = this.f12831e;
                if (!deleteOldDirectoryScheduler.f12823a.f12829c.getAndSet(true)) {
                    deleteOldDirectoryScheduler.f12823a.f12830d.a(deleteOldDirectoryScheduler.f12824b, 10, TimeUnit.SECONDS).a(deleteOldDirectoryScheduler.f12825c, deleteOldDirectoryScheduler.f12823a.f12830d);
                }
            } else {
                throw new IOException("Could not create directory");
            }
        }
        return file;
    }

    public final void m20220a(String str) {
        boolean z = false;
        if (!Strings.isNullOrEmpty(str)) {
            z = true;
        }
        Preconditions.checkArgument(z);
        try {
            File a = m20216a(str, false);
            FileTree.a(a);
            a.delete();
        } catch (IOException e) {
        }
    }
}
