package com.facebook.messaging.payment.pin.protocol;

import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.BlueServiceHandler.Filter;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;

/* compiled from: mfpsRanges */
public class AbstractBlueServiceHandlerFilter implements Filter {
    private final String f13733a;

    protected AbstractBlueServiceHandlerFilter(String str) {
        this.f13733a = str;
    }

    public final OperationResult m14267a(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        TracerDetour.a(this.f13733a, -1527582667);
        try {
            OperationResult b;
            String a = operationParams.a();
            if ("set_payment_pin".equals(a)) {
                b = mo532b(operationParams, blueServiceHandler);
            } else if ("fetch_payment_pin".equals(a)) {
                b = mo533c(operationParams, blueServiceHandler);
                TracerDetour.a(1995638319);
            } else if ("update_payment_pin_status".equals(a)) {
                b = mo535d(operationParams, blueServiceHandler);
                TracerDetour.a(-1352608236);
            } else if ("delete_payment_pin".equals(a)) {
                b = mo534e(operationParams, blueServiceHandler);
                TracerDetour.a(-295362053);
            } else if ("check_payment_pin".equals(a)) {
                b = mo536f(operationParams, blueServiceHandler);
                TracerDetour.a(721268035);
            } else if ("fetch_payment_pin_status".equals(a)) {
                b = mo537g(operationParams, blueServiceHandler);
                TracerDetour.a(-859974458);
            } else if ("fetch_page_info".equals(a)) {
                b = mo538h(operationParams, blueServiceHandler);
                TracerDetour.a(2038369881);
            } else {
                b = blueServiceHandler.a(operationParams);
                TracerDetour.a(1456178948);
            }
            return b;
        } finally {
            TracerDetour.a(1517819372);
        }
    }

    protected OperationResult mo532b(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo533c(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo535d(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo534e(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo536f(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo537g(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo538h(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }
}
