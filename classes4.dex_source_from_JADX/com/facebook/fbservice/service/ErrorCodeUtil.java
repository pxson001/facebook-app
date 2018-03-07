package com.facebook.fbservice.service;

import android.os.Bundle;
import android.util.Log;
import com.facebook.fbservice.results.ExceptionWithExtraData;
import com.facebook.http.common.ProtocolExceptions;
import com.facebook.http.protocol.ApiException;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import org.apache.http.client.HttpResponseException;

/* compiled from: incoming_payment_message */
public class ErrorCodeUtil {
    public static ErrorCode m10889a(Throwable th) {
        if (ProtocolExceptions.m10891a(th)) {
            return ErrorCode.HTTP_400_AUTHENTICATION;
        }
        Object obj;
        HttpResponseException f = ProtocolExceptions.m10893f(th);
        if (f == null || f.getStatusCode() < 400 || f.getStatusCode() >= 500) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            return ErrorCode.HTTP_400_OTHER;
        }
        f = ProtocolExceptions.m10893f(th);
        if (f == null || f.getStatusCode() < 500 || f.getStatusCode() >= 600) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            return ErrorCode.HTTP_500_CLASS;
        }
        if (th instanceof ApiException) {
            return ErrorCode.API_ERROR;
        }
        if (ProtocolExceptions.m10892a(th, IOException.class)) {
            if (th == null || th.getMessage() == null || !th.getMessage().contains("Could not validate certificate")) {
                return ErrorCode.CONNECTION_FAILURE;
            }
            return ErrorCode.DATE_ERROR;
        } else if (ProtocolExceptions.m10892a(th, OutOfMemoryError.class)) {
            return ErrorCode.OUT_OF_MEMORY;
        } else {
            if ((th instanceof CancellationException) || (th instanceof InterruptedException)) {
                return ErrorCode.CANCELLED;
            }
            return ErrorCode.OTHER;
        }
    }

    public static Bundle m10890b(Throwable th) {
        Bundle bundle = new Bundle();
        bundle.putString("originalExceptionMessage", th.getClass().getSimpleName() + ":" + th.getMessage());
        bundle.putString("originalExceptionStack", Log.getStackTraceString(th));
        if (th instanceof ExceptionWithExtraData) {
            bundle.putParcelable("result", ((ExceptionWithExtraData) th).mo800a());
        }
        return bundle;
    }
}
