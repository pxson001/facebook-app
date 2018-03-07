package com.facebook.reportaproblem.fb;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.debug.log.BLog;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.reportaproblem.base.bugreport.BugReportRequest;
import javax.inject.Inject;

/* compiled from: setOgSurface */
public class FbBugReportUploader {
    private static final Class<?> f4609a = FbBugReportUploader.class;
    private final AbstractSingleMethodRunner f4610b;
    private final FbBugReportUploadMethod f4611c;

    @Inject
    public FbBugReportUploader(AbstractSingleMethodRunner abstractSingleMethodRunner, FbBugReportUploadMethod fbBugReportUploadMethod) {
        this.f4610b = abstractSingleMethodRunner;
        this.f4611c = fbBugReportUploadMethod;
    }

    public final boolean m7120a(BugReportRequest bugReportRequest) {
        try {
            return ((Boolean) this.f4610b.a(this.f4611c, bugReportRequest, CallerContext.a(FbBugReportUploader.class))).booleanValue();
        } catch (Throwable e) {
            BLog.b(f4609a.getName(), "Unable to upload bug report.", e);
            return false;
        }
    }
}
