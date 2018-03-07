package com.facebook.loom.upload;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.debug.log.BLog;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.inject.Assisted;
import com.facebook.loom.config.SystemControlConfiguration;
import com.facebook.loom.core.BackgroundUploadService;
import com.facebook.loom.core.BackgroundUploadService.BackgroundUploadListener;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: getNotOnMessengerFriends */
public class BackgroundUploadServiceImpl implements BackgroundUploadService {
    private final ExecutorService f11120a;
    private final ExecutorService f11121b;
    private final UploadConstraints f11122c;
    private final AbstractSingleMethodRunner f11123d;
    private final LoomUploadMethod f11124e;
    @GuardedBy("mInFlightTraces")
    public final Set<File> f11125f = new HashSet(10);

    @Inject
    public BackgroundUploadServiceImpl(UploadConstraints uploadConstraints, ExecutorService executorService, @Assisted ExecutorService executorService2, AbstractSingleMethodRunner abstractSingleMethodRunner, LoomUploadMethod loomUploadMethod) {
        this.f11121b = executorService2;
        this.f11122c = uploadConstraints;
        this.f11120a = executorService;
        this.f11123d = abstractSingleMethodRunner;
        this.f11124e = loomUploadMethod;
    }

    public final void m11586a(List<File> list, BackgroundUploadListener backgroundUploadListener) {
        m11583a(list, backgroundUploadListener, false);
    }

    public final void m11587b(List<File> list, BackgroundUploadListener backgroundUploadListener) {
        m11583a(list, backgroundUploadListener, true);
    }

    private synchronized void m11583a(List<File> list, BackgroundUploadListener backgroundUploadListener, boolean z) {
        for (File file : list) {
            synchronized (this.f11125f) {
                if (this.f11125f.contains(file)) {
                } else {
                    if (file.exists()) {
                        ExecutorDetour.a(this.f11121b, new 1(this, file, backgroundUploadListener, z), 13201855);
                    }
                }
            }
        }
    }

    public static void m11581a(BackgroundUploadServiceImpl backgroundUploadServiceImpl, @Nullable File file, BackgroundUploadListener backgroundUploadListener, boolean z) {
        if (z || backgroundUploadServiceImpl.f11122c.m11597a()) {
            ApiMethodRunnerParams apiMethodRunnerParams = new ApiMethodRunnerParams();
            apiMethodRunnerParams.a(RequestPriority.CAN_WAIT);
            try {
                if (((Boolean) backgroundUploadServiceImpl.f11123d.a(backgroundUploadServiceImpl.f11124e, file, apiMethodRunnerParams, CallerContext.a(BackgroundUploadServiceImpl.class))).booleanValue()) {
                    if (!z) {
                        backgroundUploadServiceImpl.f11122c.m11595a(file.length());
                    }
                    backgroundUploadServiceImpl.m11582a(file, backgroundUploadListener);
                    return;
                }
                BLog.a("Dextr", "Upload failed for trace %s", new Object[]{file.getName()});
                backgroundUploadServiceImpl.m11584b(file, backgroundUploadListener);
            } catch (Throwable e) {
                BLog.a("Dextr", e, "Upload failed for trace %s", new Object[]{file.getName()});
                backgroundUploadServiceImpl.m11584b(file, backgroundUploadListener);
            }
        }
    }

    private void m11582a(File file, @Nullable BackgroundUploadListener backgroundUploadListener) {
        if (backgroundUploadListener != null) {
            ExecutorDetour.a(this.f11120a, new 2(this, backgroundUploadListener, file), -655588649);
        }
    }

    private void m11584b(File file, @Nullable BackgroundUploadListener backgroundUploadListener) {
        if (backgroundUploadListener != null) {
            ExecutorDetour.a(this.f11120a, new 3(this, backgroundUploadListener, file), 1583016716);
        }
    }

    public final void m11585a(SystemControlConfiguration systemControlConfiguration) {
        this.f11122c.m11596a(systemControlConfiguration);
    }
}
