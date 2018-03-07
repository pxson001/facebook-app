package com.facebook.photos.upload.uploaders;

import com.facebook.photos.base.analytics.ExceptionInterpreter;
import com.facebook.photos.base.analytics.PhotoFlowLogger$ExceptionReporter;

/* compiled from: getLocalization */
public class ReportedException extends Exception implements PhotoFlowLogger$ExceptionReporter {
    public ExceptionInterpreter mInterpreter;

    public static ExceptionInterpreter m21701a(Exception exception) {
        if (exception instanceof ReportedException) {
            return ((ReportedException) exception).mInterpreter;
        }
        return new ExceptionInterpreter(exception);
    }

    public ReportedException(ExceptionInterpreter exceptionInterpreter) {
        this.mInterpreter = exceptionInterpreter;
    }

    public final ExceptionInterpreter m21708h() {
        return this.mInterpreter;
    }

    public final String mo1088b() {
        return this.mInterpreter.mo1088b();
    }

    public final String mo1089c() {
        return getClass().getSimpleName();
    }

    public final String mo1090d() {
        return null;
    }

    public final int mo1091e() {
        return this.mInterpreter.mo1091e();
    }

    public final int mo1092f() {
        return this.mInterpreter.mo1092f();
    }

    public final String mo1093g() {
        return this.mInterpreter.mo1093g();
    }
}
