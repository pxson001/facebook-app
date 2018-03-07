package com.facebook.trace;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.base.service.FbIntentService;
import com.facebook.common.fileupload.FileUploadUtils;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.config.versioninfo.module.AppVersionInfoMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import java.io.File;
import javax.inject.Inject;

/* compiled from: segment_start_offset */
public class DebugTraceUploadService extends FbIntentService {
    private static final Class<?> f5078h = DebugTraceUploadService.class;
    @Inject
    FileUploadUtils f5079a;
    @Inject
    AbstractSingleMethodRunner f5080b;
    @Inject
    DebugTraceUploadMethod f5081c;
    @Inject
    Lazy<FbNetworkManager> f5082d;
    @Inject
    DebugTraceData f5083e;
    @Inject
    DebugTraceUtils f5084f;
    @Inject
    AppVersionInfo f5085g;

    private static <T extends Context> void m7837a(Class<T> cls, T t) {
        m7838a((Object) t, (Context) t);
    }

    public static void m7838a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((DebugTraceUploadService) obj).m7836a(FileUploadUtils.a(fbInjector), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(fbInjector), new DebugTraceUploadMethod(), IdBasedSingletonScopeProvider.b(fbInjector, 585), DebugTraceData.a(fbInjector), DebugTraceUtils.a(fbInjector), AppVersionInfoMethodAutoProvider.a(fbInjector));
    }

    private void m7836a(FileUploadUtils fileUploadUtils, SingleMethodRunner singleMethodRunner, DebugTraceUploadMethod debugTraceUploadMethod, Lazy<FbNetworkManager> lazy, DebugTraceData debugTraceData, DebugTraceUtils debugTraceUtils, AppVersionInfo appVersionInfo) {
        this.f5079a = fileUploadUtils;
        this.f5080b = singleMethodRunner;
        this.f5081c = debugTraceUploadMethod;
        this.f5082d = lazy;
        this.f5083e = debugTraceData;
        this.f5084f = debugTraceUtils;
        this.f5085g = appVersionInfo;
    }

    public DebugTraceUploadService() {
        super("DebugTraceUploadService");
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 98325502);
        super.onCreate();
        Class cls = DebugTraceUploadService.class;
        m7838a((Object) this, (Context) this);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 1917453509, a);
    }

    public final void m7842a(Intent intent) {
        File[] a = this.f5084f.a();
        if (a != null) {
            m7839a(a);
        }
        a = this.f5084f.b();
        if (a != null) {
            m7841b(a);
        }
    }

    private void m7839a(File[] fileArr) {
        for (File file : fileArr) {
            if (!this.f5083e.c(file)) {
                if (file.length() == 0) {
                    m7840b(file);
                } else {
                    File file2 = new File(file.getAbsolutePath() + ".gz");
                    try {
                        file.getName();
                        this.f5079a.a(file, file2);
                        file.getName();
                        m7840b(file);
                    } catch (Throwable e) {
                        BLog.a(f5078h, e, "Error: failed to compress %s", new Object[]{file.getName()});
                    }
                }
            }
        }
    }

    private void m7841b(File[] fileArr) {
        int length = fileArr.length;
        int i = 0;
        while (i < length) {
            File file = fileArr[i];
            if (((FbNetworkManager) this.f5082d.get()).v()) {
                if (!this.f5083e.c(file)) {
                    DebugTraceUploadParams a = m7835a(file);
                    try {
                        file.getName();
                        boolean booleanValue = ((Boolean) this.f5080b.a(this.f5081c, a)).booleanValue();
                        Boolean.valueOf(booleanValue);
                        if (booleanValue) {
                            m7840b(file);
                        } else {
                            BLog.a(f5078h, "Error: failed to upload file %s", new Object[]{file.getName()});
                        }
                    } catch (Throwable e) {
                        BLog.a(f5078h, e, "Error: failed to upload file %s", new Object[]{file.getName()});
                    }
                }
                i++;
            } else {
                return;
            }
        }
    }

    private DebugTraceUploadParams m7835a(File file) {
        return new DebugTraceUploadParams(file, Build.MODEL, VERSION.RELEASE, this.f5085g.a(), this.f5084f);
    }

    private void m7840b(File file) {
        if (!file.delete()) {
            this.f5083e.a(file);
            BLog.a(f5078h, "Error: failed to delete traceFile %s", new Object[]{file.getName()});
        }
    }
}
