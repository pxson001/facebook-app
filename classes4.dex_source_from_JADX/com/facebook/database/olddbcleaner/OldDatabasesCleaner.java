package com.facebook.database.olddbcleaner;

import android.content.Context;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.init.INeedInit;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import java.io.File;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: markResearchPollCompletedParamsKey */
public class OldDatabasesCleaner implements INeedInit {
    private static final ImmutableList<String> f8321d = ImmutableList.of("bookmarks.db", "fb.db", "graphql", "non_cached_preferences_db", "notifications.db", "pages_db", "pages_db2", "threads_db", "uploadmanager.db", "users_db", "users_db2", "zero_rating_db", new String[0]);
    private static final ImmutableList<String> f8322e = ImmutableList.of("", "-journal", "-shm", "-wal", "-uid");
    private static final ImmutableList<String> f8323f = ImmutableList.of("-corrupted", ".back", ".old");
    private static volatile OldDatabasesCleaner f8324g;
    private final Context f8325a;
    private final AppStateManager f8326b;
    private final AbstractFbErrorReporter f8327c;

    public static com.facebook.database.olddbcleaner.OldDatabasesCleaner m8589a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8324g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.database.olddbcleaner.OldDatabasesCleaner.class;
        monitor-enter(r1);
        r0 = f8324g;	 Catch:{ all -> 0x003a }
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
        r0 = m8593b(r0);	 Catch:{ all -> 0x0035 }
        f8324g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8324g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.database.olddbcleaner.OldDatabasesCleaner.a(com.facebook.inject.InjectorLike):com.facebook.database.olddbcleaner.OldDatabasesCleaner");
    }

    private static OldDatabasesCleaner m8593b(InjectorLike injectorLike) {
        return new OldDatabasesCleaner((Context) injectorLike.getInstance(Context.class), AppStateManager.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public OldDatabasesCleaner(Context context, AppStateManager appStateManager, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f8325a = context;
        this.f8326b = appStateManager;
        this.f8327c = abstractFbErrorReporter;
    }

    public void init() {
        if (this.f8326b.V) {
            m8594b();
            File a = m8590a();
            if (a != null) {
                File[] listFiles = a.listFiles();
                if (listFiles == null) {
                    this.f8327c.a("old_databases_cleaner", "OldDatabasesCleaner: Databases folder doesn't exist");
                    return;
                }
                m8592a(listFiles, a);
                m8591a(listFiles);
            }
        }
    }

    private File m8590a() {
        try {
            return this.f8325a.getDatabasePath("db").getParentFile();
        } catch (Throwable th) {
            this.f8327c.a("old_databases_cleaner", "OldDatabasesCleaner: Could not find databases folder", th);
            return null;
        }
    }

    private void m8594b() {
        int size = f8321d.size();
        for (int i = 0; i < size; i++) {
            String str = (String) f8321d.get(i);
            try {
                this.f8325a.deleteDatabase(str);
            } catch (Throwable th) {
                this.f8327c.a("old_databases_cleaner", "OldDatabasesCleaner: cannot delete old db: " + str, th);
            }
        }
    }

    private void m8592a(File[] fileArr, File file) {
        Set a = Sets.a();
        for (File name : fileArr) {
            a.add(name.getName());
        }
        int size = f8321d.size();
        for (int i = 0; i < size; i++) {
            String str = (String) f8321d.get(i);
            int size2 = f8322e.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String str2 = (String) f8322e.get(i2);
                if (a.contains(str + str2)) {
                    File file2 = new File(file, str + str2);
                    if (file2.exists()) {
                        try {
                            file2.delete();
                        } catch (Throwable th) {
                            this.f8327c.a("old_databases_cleaner", "OldDatabasesCleaner: cannot delete old db file " + file2.getName(), th);
                        }
                    }
                }
            }
        }
    }

    private void m8591a(File[] fileArr) {
        for (File file : fileArr) {
            int size = f8323f.size();
            for (int i = 0; i < size; i++) {
                if (file.getName().endsWith((String) f8323f.get(i)) && file.exists()) {
                    try {
                        file.delete();
                    } catch (Throwable th) {
                        this.f8327c.a("old_databases_cleaner", "OldDatabasesCleaner: cannot delete invalid db file " + file.getName(), th);
                    }
                }
            }
        }
    }
}
