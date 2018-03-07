package com.facebook.appupdate;

import android.app.DownloadManager;
import android.content.Context;
import android.os.Handler;
import android.util.Pair;
import com.facebook.selfupdate.AppUpdateLoggerFbImpl;
import java.io.ByteArrayInputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Provider;

@ThreadSafe
/* compiled from: ranking_data */
public class AppUpdateOperationFactory {
    private final Context f8271a;
    private final DownloadManager f8272b;
    private final Provider<String> f8273c;
    private final Provider<String> f8274d;
    private final AppUpdatePersistence f8275e;
    private final Handler f8276f;
    private final AppUpdateLoggerFbImpl f8277g;
    private final AppUpdateNotificationsCreator f8278h;
    private final AppUpdateFilesManager f8279i;
    private final SelfUpdateOperationsCallback f8280j;
    private final int f8281k;
    @GuardedBy("this")
    private final List<AppUpdateOperation> f8282l = new ArrayList();
    @GuardedBy("this")
    private boolean f8283m = false;

    public AppUpdateOperationFactory(Context context, DownloadManager downloadManager, Provider<String> provider, Provider<String> provider2, AppUpdatePersistence appUpdatePersistence, Handler handler, AppUpdateLogger appUpdateLogger, AppUpdateNotificationsCreator appUpdateNotificationsCreator, AppUpdateFilesManager appUpdateFilesManager, int i) {
        this.f8271a = context;
        this.f8272b = downloadManager;
        this.f8273c = provider;
        this.f8274d = provider2;
        this.f8275e = appUpdatePersistence;
        this.f8276f = handler;
        this.f8277g = appUpdateLogger;
        this.f8278h = appUpdateNotificationsCreator;
        this.f8279i = appUpdateFilesManager;
        this.f8281k = i;
        this.f8280j = new SelfUpdateOperationsCallback(this);
    }

    public final synchronized void m12798a() {
        if (!this.f8283m) {
            try {
                m12795d();
            } catch (Throwable th) {
                this.f8277g.m12753a(AppUpdateOperationFactory.class.getName() + ": Could not unpersist operations", null, th);
            }
            this.f8283m = true;
        }
    }

    public final synchronized void m12800b() {
        Preconditions.m12787a(this.f8283m);
        for (AppUpdateOperation appUpdateOperation : this.f8282l) {
            appUpdateOperation.a();
            this.f8278h.m12810a(appUpdateOperation.c());
        }
    }

    public final synchronized AppUpdateOperation m12796a(ReleaseInfo releaseInfo, boolean z, boolean z2, boolean z3) {
        AppUpdateOperation appUpdateOperation;
        Preconditions.m12787a(this.f8283m);
        appUpdateOperation = null;
        for (AppUpdateOperation appUpdateOperation2 : this.f8282l) {
            AppUpdateOperation appUpdateOperation22;
            AppUpdateState c = appUpdateOperation22.c();
            if (c.isBackgroundMode != z || c.isSelfUpdate != z2 || c.isWifiOnly != z3 || !c.releaseInfo.equals(releaseInfo)) {
                appUpdateOperation22 = appUpdateOperation;
            }
            appUpdateOperation = appUpdateOperation22;
        }
        if (appUpdateOperation == null) {
            appUpdateOperation = m12794b(releaseInfo, z, z2, z3);
        }
        return appUpdateOperation;
    }

    @Nullable
    public final synchronized AppUpdateOperation m12797a(String str) {
        AppUpdateOperation appUpdateOperation;
        for (AppUpdateOperation appUpdateOperation2 : this.f8282l) {
            if (appUpdateOperation2.c().operationUuid.equals(str)) {
                break;
            }
        }
        appUpdateOperation2 = null;
        return appUpdateOperation2;
    }

    public final synchronized List<AppUpdateOperation> m12801c() {
        return new ArrayList(this.f8282l);
    }

    public final synchronized void m12799a(AppUpdateOperation appUpdateOperation) {
        Preconditions.m12787a(this.f8283m);
        if (this.f8282l.contains(appUpdateOperation)) {
            this.f8282l.remove(appUpdateOperation);
        }
        appUpdateOperation.e();
    }

    private synchronized AppUpdateOperation m12794b(ReleaseInfo releaseInfo, boolean z, boolean z2, boolean z3) {
        AppUpdateOperation appUpdateOperation;
        AppUpdatePersistenceHelper appUpdatePersistenceHelper = new AppUpdatePersistenceHelper(null, this.f8275e);
        appUpdateOperation = new AppUpdateOperation(new AppUpdateState(releaseInfo, UUID.randomUUID().toString(), z, z2, z3), appUpdatePersistenceHelper, this.f8271a, this.f8272b, this.f8276f, this.f8281k, this.f8273c, this.f8274d, this.f8279i);
        this.f8282l.add(appUpdateOperation);
        appUpdateOperation.a(this.f8278h, false);
        appUpdateOperation.a(this.f8280j, false);
        appUpdateOperation.a();
        if (z) {
            appUpdateOperation.b();
        }
        return appUpdateOperation;
    }

    private synchronized void m12795d() {
        for (Pair pair : this.f8275e.m12803a()) {
            try {
                AppUpdateOperation appUpdateOperation = new AppUpdateOperation(m12793a((byte[]) pair.second), new AppUpdatePersistenceHelper((Long) pair.first, this.f8275e), this.f8271a, this.f8272b, this.f8276f, this.f8281k, this.f8273c, this.f8274d, this.f8279i);
                this.f8282l.add(appUpdateOperation);
                appUpdateOperation.a(this.f8278h, false);
                appUpdateOperation.a(this.f8280j, false);
            } catch (ClassNotFoundException e) {
                this.f8275e.m12804a(((Long) pair.first).longValue());
            } catch (InvalidClassException e2) {
                this.f8275e.m12804a(((Long) pair.first).longValue());
            }
        }
    }

    private static AppUpdateState m12793a(byte[] bArr) {
        ObjectInputStream objectInputStream;
        Throwable th;
        try {
            objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bArr));
            try {
                AppUpdateState appUpdateState = (AppUpdateState) objectInputStream.readObject();
                objectInputStream.close();
                return appUpdateState;
            } catch (Throwable th2) {
                th = th2;
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            objectInputStream = null;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            throw th;
        }
    }
}
