package com.facebook.messaging.service.base;

import com.facebook.common.stringformat.StringFormatUtil;
import com.google.common.collect.ImmutableList;
import java.util.Collection;

/* compiled from: default+1 */
public class OperationMultipleFailureException extends Exception {
    private final ImmutableList<Exception> mFailureCauses;

    public OperationMultipleFailureException(Collection<Exception> collection) {
        this(StringFormatUtil.formatStrLocaleSafe("Operation failed with %d exceptions. Setting cause to first exception", Integer.valueOf(collection.size())), collection);
    }

    protected OperationMultipleFailureException(String str, Collection<Exception> collection) {
        Throwable th;
        if (collection.isEmpty()) {
            th = null;
        } else {
            Exception exception = (Exception) collection.iterator().next();
        }
        super(str, th);
        this.mFailureCauses = ImmutableList.copyOf(collection);
    }
}
