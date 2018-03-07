package com.facebook.photos.upload.retry;

import com.facebook.photos.base.analytics.ExceptionInterpreter;
import java.util.concurrent.Semaphore;

/* compiled from: fullindex_education_type */
public interface ImmediateRetryPolicy {
    void mo1146a();

    void mo1147a(ExceptionInterpreter exceptionInterpreter);

    void mo1148a(Exception exception);

    void mo1149a(Semaphore semaphore);

    void mo1150a(boolean z);

    int mo1151b();

    boolean mo1152c();
}
