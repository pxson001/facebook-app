package com.facebook.fbservice.handlers;

import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.google.common.collect.ImmutableMap;
import java.util.Map;

/* compiled from: pending_shares */
public class BlueServiceAggregateHandler implements BlueServiceHandler {
    private final ImmutableMap<String, BlueServiceHandler> f6727a;

    public BlueServiceAggregateHandler(Map<String, BlueServiceHandler> map) {
        this.f6727a = ImmutableMap.copyOf(map);
    }

    public final OperationResult m7021a(OperationParams operationParams) {
        String str = operationParams.b;
        BlueServiceHandler blueServiceHandler = (BlueServiceHandler) this.f6727a.get(str);
        if (blueServiceHandler == null) {
            return OperationResult.a(ErrorCode.ORCA_SERVICE_UNKNOWN_OPERATION, "Unknown operation type " + str);
        }
        return blueServiceHandler.a(operationParams);
    }
}
