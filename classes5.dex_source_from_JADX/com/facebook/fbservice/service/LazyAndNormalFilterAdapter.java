package com.facebook.fbservice.service;

import com.facebook.fbservice.service.BlueServiceHandler.Filter;
import com.facebook.inject.Lazy;

/* compiled from: response_method */
public abstract class LazyAndNormalFilterAdapter implements Filter {
    public abstract OperationResult m4212a(OperationParams operationParams, Lazy<? extends BlueServiceHandler> lazy);
}
