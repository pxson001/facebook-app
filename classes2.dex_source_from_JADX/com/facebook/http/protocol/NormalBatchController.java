package com.facebook.http.protocol;

import com.facebook.crudolib.params.ParamsCollectionMap;
import com.facebook.http.protocol.BatchOperation.ProcessedBatchResponse;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;

/* compiled from: payment_settings */
public class NormalBatchController implements BatchOperation$BatchController {
    private final boolean f10350a;

    public NormalBatchController(boolean z) {
        this.f10350a = z;
    }

    public final void mo1990a(ParamsCollectionMap paramsCollectionMap) {
    }

    public final ProcessedBatchResponse mo1989a(BatchOperation batchOperation, JsonParser jsonParser, ApiResponseChecker apiResponseChecker) {
        if (jsonParser.mo1794g() == JsonToken.VALUE_NULL) {
            return ProcessedBatchResponse.a;
        }
        jsonParser.mo1766c();
        if ("code".equals(jsonParser.mo1778i())) {
            int a = jsonParser.mo1759a(-1);
            if (a == -1) {
                throw new JsonMappingException("Invalid format. 'code' value not found.", jsonParser.mo1781l());
            }
            jsonParser.mo1766c();
            jsonParser.mo1766c();
            jsonParser.mo1766c();
            if ("body".equals(jsonParser.mo1778i())) {
                jsonParser.mo1766c();
                PartialJsonParser partialJsonParser = new PartialJsonParser(jsonParser, this.f10350a);
                apiResponseChecker.m11765a(a, null, partialJsonParser);
                return new ProcessedBatchResponse(a, null, null, partialJsonParser);
            }
            throw new JsonMappingException("Invalid format. 'body' node not found.", jsonParser.mo1781l());
        }
        throw new JsonMappingException("Invalid format. 'code' node not found.", jsonParser.mo1781l());
    }
}
