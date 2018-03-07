package com.facebook.messaging.service.base;

import android.os.Parcelable;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbservice.service.OperationResult;
import java.util.Collection;

/* compiled from: decode failed */
public class OperationPartialResultException extends OperationMultipleFailureException {
    private final OperationResult mPartialSucessOperationResult;

    public OperationPartialResultException(Parcelable parcelable, Collection<Exception> collection) {
        super(StringFormatUtil.formatStrLocaleSafe("Operation completed with partial results plus %d exceptions. Setting cause to first exception", Integer.valueOf(collection.size())), collection);
        this.mPartialSucessOperationResult = OperationResult.a(parcelable);
    }
}
