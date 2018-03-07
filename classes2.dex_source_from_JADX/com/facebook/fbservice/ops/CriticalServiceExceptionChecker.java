package com.facebook.fbservice.ops;

import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.inject.InjectorLike;

/* compiled from: subscribe */
public class CriticalServiceExceptionChecker {
    public static CriticalServiceExceptionChecker m6535a(InjectorLike injectorLike) {
        return new CriticalServiceExceptionChecker();
    }

    public static boolean m6536a(Throwable th) {
        if (!(th instanceof ServiceException)) {
            return false;
        }
        ServiceException serviceException = (ServiceException) th;
        if (serviceException.errorCode != ErrorCode.API_ERROR) {
            return false;
        }
        ApiErrorResult apiErrorResult = (ApiErrorResult) serviceException.result.m30133k();
        if (apiErrorResult == null) {
            return false;
        }
        return apiErrorResult.a() == 190 || apiErrorResult.a() == 102;
    }
}
