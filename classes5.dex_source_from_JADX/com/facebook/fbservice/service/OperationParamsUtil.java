package com.facebook.fbservice.service;

import android.os.Parcelable;
import com.google.common.base.Preconditions;

/* compiled from: resource_ */
public class OperationParamsUtil {
    public static <T extends Parcelable> T m4215a(OperationParams operationParams, String str) {
        return (Parcelable) Preconditions.checkNotNull(operationParams.c.getParcelable(str));
    }
}
