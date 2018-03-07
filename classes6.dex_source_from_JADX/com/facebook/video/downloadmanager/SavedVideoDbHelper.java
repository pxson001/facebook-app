package com.facebook.video.downloadmanager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.common.executors.DefaultSerialListeningExecutorService;
import com.facebook.common.executors.DefaultSerialListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.database.supplier.AbstractDatabaseSupplier;
import com.facebook.database.threadchecker.DbThreadChecker;
import com.facebook.database.threadchecker.DbThreadCheckerDisallowUiThread;
import com.facebook.debug.log.BLog;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.video.abtest.ExperimentsForVideoAbTestModule;
import com.facebook.video.downloadmanager.DownloadException.ExceptionCode;
import com.facebook.video.events.VideoDownloadStatus.DownloadStatus;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@SuppressLint({"ConstructorMayLeakThis"})
/* compiled from: connection_state */
public class SavedVideoDbHelper extends AbstractDatabaseSupplier {
    public static final String f18680a = SavedVideoDbHelper.class.getName();
    private static final SavedVideoDbSchemaPart f18681c = new SavedVideoDbSchemaPart();
    private static volatile SavedVideoDbHelper f18682j;
    public final String f18683b;
    private HashMap<String, VideoDownloadRecord> f18684d;
    private DefaultSerialListeningExecutorService f18685e;
    private ListenableFuture f18686f;
    private final DownloadManagerConfig f18687g;
    private long f18688h = 0;
    private Clock f18689i;

    /* compiled from: connection_state */
    class C13941 implements Callable {
        final /* synthetic */ SavedVideoDbHelper f18679a;

        C13941(SavedVideoDbHelper savedVideoDbHelper) {
            this.f18679a = savedVideoDbHelper;
        }

        public Object call() {
            try {
                SavedVideoDbHelper.m27434l(this.f18679a);
                return null;
            } catch (Throwable e) {
                BLog.b(SavedVideoDbHelper.f18680a, "Exception", e);
                throw new IllegalStateException(e);
            }
        }
    }

    public static com.facebook.video.downloadmanager.SavedVideoDbHelper m27429a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f18682j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.downloadmanager.SavedVideoDbHelper.class;
        monitor-enter(r1);
        r0 = f18682j;	 Catch:{ all -> 0x003a }
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
        r0 = m27432b(r0);	 Catch:{ all -> 0x0035 }
        f18682j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f18682j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.downloadmanager.SavedVideoDbHelper.a(com.facebook.inject.InjectorLike):com.facebook.video.downloadmanager.SavedVideoDbHelper");
    }

    private static SavedVideoDbHelper m27432b(InjectorLike injectorLike) {
        return new SavedVideoDbHelper((Context) injectorLike.getInstance(Context.class, ForAppContext.class), (DbThreadChecker) DbThreadCheckerDisallowUiThread.a(injectorLike), SavedVideoDbSchemaPart.m27443a(injectorLike), SavedVideoDbAnalyticsSchemaPart.m27420a(injectorLike), DefaultSerialListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.b(injectorLike), DownloadManagerConfig.m27417a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SavedVideoDbHelper(@ForAppContext Context context, DbThreadChecker dbThreadChecker, SavedVideoDbSchemaPart savedVideoDbSchemaPart, SavedVideoDbAnalyticsSchemaPart savedVideoDbAnalyticsSchemaPart, DefaultSerialListeningExecutorService defaultSerialListeningExecutorService, DownloadManagerConfig downloadManagerConfig, Clock clock) {
        super(context, dbThreadChecker, ImmutableList.of(savedVideoDbSchemaPart, savedVideoDbAnalyticsSchemaPart), "savedvideos.db");
        this.f18683b = context.getFilesDir() + "/SavedVideos" + "/";
        this.f18684d = new HashMap();
        this.f18685e = defaultSerialListeningExecutorService;
        this.f18687g = downloadManagerConfig;
        this.f18689i = clock;
        this.f18686f = this.f18685e.a(new C13941(this));
        File file = new File(this.f18683b);
        if (!file.exists()) {
            file.mkdir();
        } else if (!file.isDirectory()) {
            file.delete();
            file.mkdir();
        }
    }

    private synchronized void m27433k() {
        boolean z = false;
        synchronized (this) {
            if (this.f18686f != null) {
                z = true;
            }
            Preconditions.checkState(z);
            try {
                FutureDetour.a(this.f18686f, 10000, TimeUnit.MILLISECONDS, 486143890);
            } catch (Throwable e) {
                BLog.b(f18680a, e, "Exception initializing db", new Object[0]);
                throw new IllegalStateException(e);
            }
        }
    }

    public static synchronized void m27434l(com.facebook.video.downloadmanager.SavedVideoDbHelper r8) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        monitor-enter(r8);
        r1 = r8.a();	 Catch:{ all -> 0x004b }
        r0 = 958000779; // 0x3919ee8b float:1.4680081E-4 double:4.733152736E-315;	 Catch:{ all -> 0x004b }
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r1, r0);	 Catch:{ all -> 0x004b }
        r0 = com.facebook.video.downloadmanager.SavedVideoDbSchemaPart.m27456d(r1);	 Catch:{ all -> 0x0043 }
        r2 = r0.iterator();	 Catch:{ all -> 0x0043 }
    L_0x0013:
        r0 = r2.hasNext();	 Catch:{ all -> 0x0043 }
        if (r0 == 0) goto L_0x0078;	 Catch:{ all -> 0x0043 }
    L_0x0019:
        r0 = r2.next();	 Catch:{ all -> 0x0043 }
        r0 = (com.facebook.video.downloadmanager.VideoDownloadRecord) r0;	 Catch:{ all -> 0x0043 }
        r3 = r0.f18730f;	 Catch:{ all -> 0x0043 }
        r3.toString();	 Catch:{ all -> 0x0043 }
        r3 = r0.f18730f;	 Catch:{ all -> 0x0043 }
        r4 = com.facebook.video.events.VideoDownloadStatus.DownloadStatus.DOWNLOAD_ABORTED;	 Catch:{ all -> 0x0043 }
        if (r3 == r4) goto L_0x003f;	 Catch:{ all -> 0x0043 }
    L_0x002a:
        r4 = r0.f18727c;	 Catch:{ all -> 0x0043 }
        r6 = 0;	 Catch:{ all -> 0x0043 }
        r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));	 Catch:{ all -> 0x0043 }
        if (r3 <= 0) goto L_0x003f;	 Catch:{ all -> 0x0043 }
    L_0x0032:
        r3 = new java.io.File;	 Catch:{ all -> 0x0043 }
        r4 = r0.f18729e;	 Catch:{ all -> 0x0043 }
        r3.<init>(r4);	 Catch:{ all -> 0x0043 }
        r3 = r3.exists();	 Catch:{ all -> 0x0043 }
        if (r3 != 0) goto L_0x004e;	 Catch:{ all -> 0x0043 }
    L_0x003f:
        r8.m27431a(r0);	 Catch:{ all -> 0x0043 }
        goto L_0x0013;
    L_0x0043:
        r0 = move-exception;
        r2 = -1080743128; // 0xffffffffbf952b28 float:-1.1653795 double:NaN;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r1, r2);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x004b:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x004e:
        r4 = r8.f18688h;	 Catch:{  }
        r6 = r0.f18727c;	 Catch:{  }
        r4 = r4 + r6;	 Catch:{  }
        r8.f18688h = r4;	 Catch:{  }
        r3 = r0.f18730f;	 Catch:{  }
        r4 = com.facebook.video.events.VideoDownloadStatus.DownloadStatus.DOWNLOAD_IN_PROGRESS;	 Catch:{  }
        if (r3 != r4) goto L_0x006b;	 Catch:{  }
    L_0x005b:
        r0 = r0.f18725a;	 Catch:{  }
        r3 = com.facebook.video.events.VideoDownloadStatus.DownloadStatus.DOWNLOAD_PAUSED;	 Catch:{  }
        r0 = com.facebook.video.downloadmanager.SavedVideoDbSchemaPart.m27447a(r1, r0, r3);	 Catch:{  }
        r0 = r0.f18725a;	 Catch:{  }
        r3 = com.facebook.video.events.VideoDownloadStatus.DownloadStatus.DOWNLOAD_NOT_STARTED;	 Catch:{  }
        r0 = com.facebook.video.downloadmanager.SavedVideoDbSchemaPart.m27447a(r1, r0, r3);	 Catch:{  }
    L_0x006b:
        r3 = r0.f18730f;	 Catch:{  }
        r3.toString();	 Catch:{  }
        r3 = r8.f18684d;	 Catch:{  }
        r4 = r0.f18725a;	 Catch:{  }
        r3.put(r4, r0);	 Catch:{  }
        goto L_0x0013;	 Catch:{  }
    L_0x0078:
        r1.setTransactionSuccessful();	 Catch:{  }
        r0 = -353751170; // 0xffffffffeaea2f7e float:-1.4155646E26 double:NaN;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r1, r0);	 Catch:{  }
        monitor-exit(r8);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.downloadmanager.SavedVideoDbHelper.l(com.facebook.video.downloadmanager.SavedVideoDbHelper):void");
    }

    private void m27430a(long j) {
        long a = this.f18687g.f18666a.a(ExperimentsForVideoAbTestModule.cV, Long.MAX_VALUE);
        long freeSpace = new File(this.f18683b).getFreeSpace();
        if (a < this.f18688h || a - this.f18688h < j || freeSpace < j) {
            Long.valueOf(freeSpace);
            Long.valueOf(a);
            Long.valueOf(j);
            Long.valueOf(this.f18688h);
            if (this.f18688h + freeSpace > j) {
                throw new DownloadException("Insufficient space. Delete one or more videos", ExceptionCode.INSUFFICIENT_SPACE_INTERNAL);
            }
            throw new DownloadException("Insufficient space. Delete one or more file from device", ExceptionCode.INSUFFICIENT_SPACE_DEVICE);
        }
    }

    public final void m27438a(VideoDownloadRecord videoDownloadRecord, String str) {
        m27433k();
        Preconditions.checkState(videoDownloadRecord.f18727c > 0);
        SQLiteDatabase a = a();
        SQLiteDetour.a(a, -607867953);
        try {
            m27430a(videoDownloadRecord.f18727c);
            SavedVideoDbSchemaPart.m27452a(a, videoDownloadRecord);
            SavedVideoDbAnalyticsSchemaPart.m27423a(a, videoDownloadRecord.f18725a, this.f18689i.a(), str);
            this.f18688h += videoDownloadRecord.f18727c;
            synchronized (this) {
                this.f18684d.put(videoDownloadRecord.f18725a, videoDownloadRecord);
            }
            a.setTransactionSuccessful();
            SQLiteDetour.b(a, 1453938597);
        } catch (Throwable e) {
            BLog.b(f18680a, "Exception", e);
            throw e;
        } catch (Throwable th) {
            SQLiteDetour.b(a, 217455076);
        }
    }

    public final synchronized VideoDownloadRecord m27436a(String str) {
        m27433k();
        return (VideoDownloadRecord) this.f18684d.get(str);
    }

    public final VideoDownloadRecord m27435a(DownloadStatus downloadStatus) {
        m27433k();
        SQLiteDatabase a = a();
        SQLiteDetour.a(a, 1711386378);
        try {
            VideoDownloadRecord a2 = SavedVideoDbSchemaPart.m27445a(a, downloadStatus);
            a.setTransactionSuccessful();
            SQLiteDetour.b(a, 824613474);
            return a2;
        } catch (Throwable e) {
            BLog.b(f18680a, "Exception", e);
            throw e;
        } catch (Throwable th) {
            SQLiteDetour.b(a, -1605117852);
        }
    }

    private boolean m27431a(VideoDownloadRecord videoDownloadRecord) {
        SQLiteDatabase a = a();
        SQLiteDetour.a(a, 2030428867);
        try {
            SavedVideoDbAnalyticsSchemaPart.m27425c(a, videoDownloadRecord.f18725a);
            SavedVideoDbSchemaPart.m27454b(a, videoDownloadRecord.f18725a);
            this.f18688h -= videoDownloadRecord.f18727c;
            a.setTransactionSuccessful();
            SQLiteDetour.b(a, -1673282872);
            return true;
        } catch (Throwable e) {
            BLog.b(f18680a, "Exception in deleting video", e);
            throw e;
        } catch (Throwable th) {
            SQLiteDetour.b(a, -998017487);
        }
    }

    public final boolean m27440b(String str) {
        m27433k();
        VideoDownloadRecord a = m27436a(str);
        if (a == null || !m27431a(a)) {
            return false;
        }
        synchronized (this) {
            this.f18684d.remove(str);
        }
        return true;
    }

    public final VideoDownloadRecord m27437a(String str, DownloadStatus downloadStatus) {
        m27433k();
        SQLiteDatabase a = a();
        SQLiteDetour.a(a, 795829811);
        try {
            VideoDownloadRecord a2 = SavedVideoDbSchemaPart.m27446a(a, str);
            if (a2 == null) {
                throw new IllegalArgumentException("Unknown video id " + str);
            } else if (a2.f18730f == downloadStatus) {
                SQLiteDetour.b(a, 983041010);
                return a2;
            } else {
                VideoDownloadRecord a3 = SavedVideoDbSchemaPart.m27447a(a, str, downloadStatus);
                if (a3.f18730f == DownloadStatus.DOWNLOAD_COMPLETED || a3.f18730f == DownloadStatus.DOWNLOAD_ABORTED) {
                    SavedVideoDbAnalyticsSchemaPart.m27422a(a, str, this.f18689i.a());
                }
                if (a3.f18730f == DownloadStatus.DOWNLOAD_IN_PROGRESS) {
                    SavedVideoDbAnalyticsSchemaPart.m27424b(a, str);
                }
                synchronized (this) {
                    Preconditions.checkState(this.f18684d.containsKey(str));
                    ((VideoDownloadRecord) this.f18684d.get(str)).f18730f = a3.f18730f;
                }
                a.setTransactionSuccessful();
                SQLiteDetour.b(a, 1731743091);
                return a3;
            }
        } catch (Throwable e) {
            BLog.b(f18680a, "Exception", e);
            throw e;
        } catch (Throwable th) {
            SQLiteDetour.b(a, 587196526);
        }
    }

    public final void m27439a(String str, long j) {
        m27433k();
        SQLiteDatabase a = a();
        SQLiteDetour.a(a, -1886069425);
        try {
            SavedVideoDbSchemaPart.m27450a(a, str, j);
            synchronized (this) {
                Preconditions.checkState(this.f18684d.containsKey(str));
                ((VideoDownloadRecord) this.f18684d.get(str)).f18728d = j;
            }
            a.setTransactionSuccessful();
            SQLiteDetour.b(a, -765876266);
        } catch (Throwable e) {
            BLog.b(f18680a, "Exception", e);
            throw e;
        } catch (Throwable th) {
            SQLiteDetour.b(a, 128102731);
        }
    }

    public final VideoDownloadAnalyticsRecord m27441c(String str) {
        m27433k();
        SQLiteDatabase a = a();
        SQLiteDetour.a(a, 312224876);
        try {
            VideoDownloadAnalyticsRecord a2 = SavedVideoDbAnalyticsSchemaPart.m27421a(a, str);
            a.setTransactionSuccessful();
            SQLiteDetour.b(a, 367722910);
            return a2;
        } catch (Throwable e) {
            BLog.b(f18680a, "Exception", e);
            throw e;
        } catch (Throwable th) {
            SQLiteDetour.b(a, 927372216);
        }
    }
}
