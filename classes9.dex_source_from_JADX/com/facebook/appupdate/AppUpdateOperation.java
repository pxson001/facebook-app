package com.facebook.appupdate;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.facebook.appupdate.AppUpdateState.Builder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Provider;

@ThreadSafe
/* compiled from: UPDATE %s SET %s = ? WHERE %s < %s */
public class AppUpdateOperation {
    private static final Class<?> f23774a = AppUpdateOperation.class;
    public final AppUpdatePersistenceHelper f23775b;
    private final Context f23776c;
    public final DownloadManager f23777d;
    private final Handler f23778e;
    private final int f23779f;
    private final PersistNotStartedOperationTask f23780g;
    private final PollDownloadProgressTasks f23781h;
    private final StartOperationTask f23782i;
    public final TryCompletingDownloadTask f23783j;
    private final VerifyDownloadTask f23784k;
    @GuardedBy("this")
    public AppUpdateState f23785l;
    @GuardedBy("this")
    private final Set<StateCallback> f23786m = new HashSet();
    @GuardedBy("this")
    private final Set<StateCallback> f23787n = new HashSet();
    private boolean f23788o = false;
    @GuardedBy("this")
    private boolean f23789p;
    private final BroadcastReceiver f23790q = new C28791(this);
    public final AppUpdateTask f23791r = new C28813(this);

    /* compiled from: UPDATE %s SET %s = ? WHERE %s < %s */
    class C28791 extends BroadcastReceiver {
        final /* synthetic */ AppUpdateOperation f23770a;

        C28791(AppUpdateOperation appUpdateOperation) {
            this.f23770a = appUpdateOperation;
        }

        public void onReceive(Context context, Intent intent) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 534938318);
            long longExtra = intent.getLongExtra("extra_download_id", -1);
            synchronized (this.f23770a) {
                if (longExtra != -1) {
                    try {
                        if (longExtra == this.f23770a.f23785l.downloadId) {
                            AppUpdateOperation.m25790a(this.f23770a, this.f23770a.f23783j, 0);
                        }
                    } catch (Throwable th) {
                        LogUtils.a(intent, 1054675324, a);
                    }
                }
            }
            LogUtils.a(intent, -1038761830, a);
        }
    }

    /* compiled from: UPDATE %s SET %s = ? WHERE %s < %s */
    class C28813 implements AppUpdateTask {
        final /* synthetic */ AppUpdateOperation f23773a;

        C28813(AppUpdateOperation appUpdateOperation) {
            this.f23773a = appUpdateOperation;
        }

        public final AppUpdateTaskResult mo1098a(AppUpdateState appUpdateState) {
            this.f23773a.f23775b.m25806a();
            if (appUpdateState.downloadId >= 0) {
                this.f23773a.f23777d.remove(new long[]{appUpdateState.downloadId});
            }
            if (appUpdateState.localFile != null) {
                appUpdateState.localFile.delete();
            }
            return new AppUpdateTaskResult();
        }
    }

    public AppUpdateOperation(AppUpdateState appUpdateState, AppUpdatePersistenceHelper appUpdatePersistenceHelper, Context context, DownloadManager downloadManager, Handler handler, int i, Provider<String> provider, Provider<String> provider2, AppUpdateFilesManager appUpdateFilesManager) {
        this.f23785l = appUpdateState;
        this.f23775b = appUpdatePersistenceHelper;
        this.f23776c = context;
        this.f23777d = downloadManager;
        this.f23778e = handler;
        this.f23779f = i;
        this.f23780g = new PersistNotStartedOperationTask();
        this.f23782i = new StartOperationTask(downloadManager, provider, provider2);
        this.f23781h = new PollDownloadProgressTasks(downloadManager);
        this.f23784k = new VerifyDownloadTask(downloadManager);
        this.f23783j = new TryCompletingDownloadTask(appUpdateFilesManager, downloadManager, this.f23784k);
    }

    public final synchronized void m25797a() {
        if (!this.f23789p) {
            if (!this.f23785l.isSelfUpdate || this.f23785l.releaseInfo.versionCode > this.f23779f) {
                if (this.f23785l.operationState == 0) {
                    m25790a(this, this.f23780g, 0);
                } else if (this.f23785l.operationState == 2) {
                    m25794h();
                    m25790a(this, this.f23783j, 0);
                } else if (this.f23785l.operationState == 3) {
                    m25790a(this, this.f23784k, 0);
                }
                m25796j();
                this.f23789p = true;
            } else {
                Integer.valueOf(this.f23785l.releaseInfo.versionCode);
                Integer.valueOf(this.f23779f);
                m25803e();
            }
        }
    }

    public final synchronized boolean m25800b() {
        boolean z = true;
        synchronized (this) {
            if (this.f23785l.operationState == 0) {
                m25794h();
                m25790a(this, this.f23782i, 0);
                m25791b(this, new Builder(this.f23785l).m25816a(1).m25818a());
            } else {
                z = false;
            }
        }
        return z;
    }

    public final synchronized boolean m25799a(StateCallback stateCallback, boolean z) {
        boolean add;
        if (z) {
            m25792f();
            add = this.f23787n.add(stateCallback);
        } else {
            add = this.f23786m.add(stateCallback);
        }
        return add;
    }

    public final synchronized boolean m25798a(StateCallback stateCallback) {
        boolean z;
        z = false;
        if (this.f23786m.contains(stateCallback)) {
            z = this.f23786m.remove(stateCallback) | 0;
        }
        if (this.f23787n.contains(stateCallback)) {
            z |= this.f23787n.remove(stateCallback);
            if (this.f23787n.isEmpty()) {
                m25793g();
            }
        }
        return z;
    }

    public final synchronized AppUpdateState m25801c() {
        return this.f23785l;
    }

    public final synchronized void m25802d() {
        if (this.f23785l.operationState == 2) {
            m25790a(this, this.f23783j, 0);
        }
    }

    private synchronized void m25792f() {
        m25790a(this, this.f23781h.m25825a(), 0);
    }

    private synchronized void m25793g() {
        m25790a(this, this.f23781h.m25826b(), 0);
    }

    public final synchronized boolean m25803e() {
        boolean z;
        if (this.f23785l.operationState != 6) {
            m25790a(this, this.f23791r, 0);
            m25795i();
            m25791b(this, new Builder(this.f23785l).m25816a(6).m25818a());
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    private synchronized void m25794h() {
        if (!this.f23788o) {
            this.f23776c.registerReceiver(this.f23790q, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
            this.f23788o = true;
        }
    }

    private synchronized void m25795i() {
        Preconditions.a();
        if (this.f23788o) {
            this.f23776c.unregisterReceiver(this.f23790q);
            this.f23788o = false;
        }
    }

    public static synchronized void m25790a(AppUpdateOperation appUpdateOperation, final AppUpdateTask appUpdateTask, long j) {
        synchronized (appUpdateOperation) {
            Long.valueOf(j);
            HandlerDetour.b(appUpdateOperation.f23778e, new Runnable(appUpdateOperation) {
                final /* synthetic */ AppUpdateOperation f23772b;

                public void run() {
                    AppUpdateState c = this.f23772b.m25801c();
                    try {
                        if (c.operationState != 6 || appUpdateTask == this.f23772b.f23791r) {
                            AppUpdateTaskResult a = appUpdateTask.mo1098a(c);
                            AppUpdateOperation.m25789a(this.f23772b, a.f23813a);
                            if (a.f23814b != null) {
                                AppUpdateOperation.m25790a(this.f23772b, a.f23814b, a.f23815c);
                            }
                        }
                    } catch (Throwable th) {
                        this.f23772b.f23775b.m25806a();
                        AppUpdateOperation.m25791b(this.f23772b, new Builder(c).m25816a(5).m25817a(th).m25818a());
                    }
                }
            }, j, 753044952);
        }
    }

    public static synchronized void m25789a(@Nullable AppUpdateOperation appUpdateOperation, AppUpdateState appUpdateState) {
        synchronized (appUpdateOperation) {
            if (m25791b(appUpdateOperation, appUpdateState)) {
                appUpdateOperation.f23775b.m25807a(appUpdateState);
            }
        }
    }

    public static synchronized boolean m25791b(@Nullable AppUpdateOperation appUpdateOperation, AppUpdateState appUpdateState) {
        boolean z;
        synchronized (appUpdateOperation) {
            if (appUpdateState != null) {
                if (appUpdateState.operationState >= appUpdateOperation.f23785l.operationState) {
                    appUpdateOperation.f23785l = appUpdateState;
                    appUpdateOperation.m25796j();
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }

    private synchronized void m25796j() {
        for (StateCallback a : this.f23786m) {
            a.a(this, this.f23785l);
        }
        for (StateCallback a2 : this.f23787n) {
            a2.a(this, this.f23785l);
        }
    }

    public String toString() {
        AppUpdateState c = m25801c();
        return AppUpdateOperation.class.getSimpleName() + "(id=" + c.operationUuid.substring(0, 4) + ", state=" + c.operationState + ", package=" + c.releaseInfo.packageName + ", version=" + c.releaseInfo.versionCode + ")";
    }
}
