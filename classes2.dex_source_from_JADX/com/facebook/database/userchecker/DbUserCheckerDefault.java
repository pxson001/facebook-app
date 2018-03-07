package com.facebook.database.userchecker;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.common.util.TriState;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.user.model.User;
import com.google.common.collect.Maps;
import com.google.common.io.Closeables;
import com.google.common.io.Files;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: network_prioritization_snapshot */
public class DbUserCheckerDefault implements DbUserChecker {
    private static volatile DbUserCheckerDefault f12438d;
    private final Provider<TriState> f12439a;
    private final Provider<User> f12440b;
    private Map<String, String> f12441c = Maps.m838c();

    public static com.facebook.database.userchecker.DbUserCheckerDefault m18514a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12438d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.database.userchecker.DbUserCheckerDefault.class;
        monitor-enter(r1);
        r0 = f12438d;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m18516b(r0);	 Catch:{ all -> 0x0035 }
        f12438d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12438d;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.database.userchecker.DbUserCheckerDefault.a(com.facebook.inject.InjectorLike):com.facebook.database.userchecker.DbUserCheckerDefault");
    }

    private static DbUserCheckerDefault m18516b(InjectorLike injectorLike) {
        return new DbUserCheckerDefault(IdBasedProvider.m1811a(injectorLike, 3595), IdBasedProvider.m1811a(injectorLike, 661));
    }

    @Inject
    public DbUserCheckerDefault(Provider<User> provider, Provider<TriState> provider2) {
        this.f12440b = provider;
        this.f12439a = provider2;
    }

    public final boolean mo2483a(SQLiteDatabase sQLiteDatabase) {
        if (!TriState.YES.equals(this.f12439a.get())) {
            return true;
        }
        User user = (User) this.f12440b.get();
        String e = m18519e(sQLiteDatabase);
        if (user == null) {
            return e == null;
        } else {
            if (e != null) {
                return e.equals(user.f3598a);
            }
            return m18515a(sQLiteDatabase, user.f3598a);
        }
    }

    public final void mo2484b(SQLiteDatabase sQLiteDatabase) {
        this.f12441c.remove(m18517c(sQLiteDatabase));
        m18518d(sQLiteDatabase).delete();
    }

    private static String m18517c(SQLiteDatabase sQLiteDatabase) {
        String path = sQLiteDatabase.getPath();
        return path.substring(path.lastIndexOf(47) + 1);
    }

    private static File m18518d(SQLiteDatabase sQLiteDatabase) {
        return new File(sQLiteDatabase.getPath() + "-uid");
    }

    private String m18519e(SQLiteDatabase sQLiteDatabase) {
        String c = m18517c(sQLiteDatabase);
        String str = (String) this.f12441c.get(c);
        if (str != null) {
            return str;
        }
        File d = m18518d(sQLiteDatabase);
        if (!d.exists()) {
            return null;
        }
        try {
            str = new String(Files.b(d), "UTF-8");
            this.f12441c.put(c, str);
            return str;
        } catch (IOException e) {
            throw new IllegalStateException("Cannot Read From UID File");
        }
    }

    private boolean m18515a(SQLiteDatabase sQLiteDatabase, String str) {
        Closeable randomAccessFile;
        Closeable closeable;
        Throwable th;
        this.f12441c.put(m18517c(sQLiteDatabase), str);
        try {
            randomAccessFile = new RandomAccessFile(m18518d(sQLiteDatabase), "rw");
            try {
                randomAccessFile.setLength(0);
                randomAccessFile.write(str.getBytes("UTF-8"));
                try {
                    Closeables.m21581a(randomAccessFile, false);
                    return true;
                } catch (IOException e) {
                    return false;
                }
            } catch (IOException e2) {
                closeable = randomAccessFile;
                try {
                    Closeables.m21581a(closeable, true);
                    return false;
                } catch (IOException e3) {
                    return false;
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    Closeables.m21581a(randomAccessFile, true);
                } catch (IOException e4) {
                }
                throw th;
            }
        } catch (IOException e5) {
            closeable = null;
            Closeables.m21581a(closeable, true);
            return false;
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            Closeables.m21581a(randomAccessFile, true);
            throw th;
        }
    }
}
