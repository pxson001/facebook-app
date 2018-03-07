package com.facebook.http.protocol;

import com.facebook.crudolib.params.ParamsCollectionMap;
import com.facebook.http.entity.mime.apache.FormBodyPart;
import com.google.common.collect.ImmutableList;

/* compiled from: features_extra_data */
public class MethodBatcherImpl$BatchRequest<PARAMS, RESULT> {
    final BatchOperation<PARAMS, RESULT> f11939a;
    final ApiRequest f11940b;
    final ParamsCollectionMap f11941c;
    public final ImmutableList<FormBodyPart> f11942d;

    MethodBatcherImpl$BatchRequest(BatchOperation<PARAMS, RESULT> batchOperation, ApiRequest apiRequest, ParamsCollectionMap paramsCollectionMap, ImmutableList<FormBodyPart> immutableList) {
        this.f11939a = batchOperation;
        this.f11940b = apiRequest;
        this.f11941c = paramsCollectionMap;
        this.f11942d = immutableList;
    }
}
