package com.facebook.http.protocol;

import com.facebook.crudolib.params.ParamsCollectionMap;
import com.facebook.http.protocol.BatchOperation.ProcessedBatchResponse;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.base.Preconditions;

/* compiled from: payment_platform_context */
public class StreamingBatchController implements BatchOperation$BatchController {
    private final NormalBatchController f10351a;

    public StreamingBatchController(NormalBatchController normalBatchController) {
        this.f10351a = normalBatchController;
    }

    public final void mo1990a(ParamsCollectionMap paramsCollectionMap) {
        paramsCollectionMap.m5421a("flush", "1");
    }

    public final ProcessedBatchResponse mo1989a(BatchOperation batchOperation, JsonParser jsonParser, ApiResponseChecker apiResponseChecker) {
        Preconditions.checkNotNull(batchOperation.c, "All operations in a streaming batch must be named");
        return this.f10351a.mo1989a(batchOperation, jsonParser, apiResponseChecker);
    }
}
