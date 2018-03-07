package com.facebook.http.protocol;

import com.facebook.crudolib.params.ParamsCollectionMap;
import com.facebook.http.protocol.BatchOperation.ProcessedBatchResponse;
import com.fasterxml.jackson.core.JsonParser;

/* compiled from: payment_platform_contexts */
public interface BatchOperation$BatchController {
    ProcessedBatchResponse mo1989a(BatchOperation batchOperation, JsonParser jsonParser, ApiResponseChecker apiResponseChecker);

    void mo1990a(ParamsCollectionMap paramsCollectionMap);
}
