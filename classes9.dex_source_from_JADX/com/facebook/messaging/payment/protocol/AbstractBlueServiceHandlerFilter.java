package com.facebook.messaging.payment.protocol;

import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.BlueServiceHandler.Filter;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;

/* compiled from: mfpsRanges */
public class AbstractBlueServiceHandlerFilter implements Filter {
    private final String f14482a;

    protected AbstractBlueServiceHandlerFilter(String str) {
        this.f14482a = str;
    }

    public final OperationResult m14888a(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        TracerDetour.a(this.f14482a, 1361784850);
        try {
            OperationResult b;
            String a = operationParams.a();
            if ("fetch_payment_cards".equals(a)) {
                b = mo571b(operationParams, blueServiceHandler);
            } else if ("fetch_transaction_payment_card".equals(a)) {
                b = mo572c(operationParams, blueServiceHandler);
                TracerDetour.a(233367466);
            } else if ("fetch_payment_transaction".equals(a)) {
                b = mo565d(operationParams, blueServiceHandler);
                TracerDetour.a(446104211);
            } else if ("fetch_transaction_list".equals(a)) {
                b = mo575l(operationParams, blueServiceHandler);
                TracerDetour.a(-1478485041);
            } else if ("fetch_more_transactions".equals(a)) {
                b = mo576m(operationParams, blueServiceHandler);
                TracerDetour.a(-2130166251);
            } else if ("decline_payment".equals(a)) {
                b = mo582e(operationParams, blueServiceHandler);
                TracerDetour.a(1029099863);
            } else if ("add_payment_card".equals(a)) {
                b = mo583f(operationParams, blueServiceHandler);
                TracerDetour.a(622196407);
            } else if ("edit_payment_card".equals(a)) {
                b = mo584g(operationParams, blueServiceHandler);
                TracerDetour.a(-272368763);
            } else if ("delete_payment_card".equals(a)) {
                b = mo573h(operationParams, blueServiceHandler);
                TracerDetour.a(-582896717);
            } else if ("set_primary_payment_card".equals(a)) {
                b = mo574i(operationParams, blueServiceHandler);
                TracerDetour.a(1460133762);
            } else if ("fetch_p2p_send_eligibility".equals(a)) {
                b = mo566j(operationParams, blueServiceHandler);
                TracerDetour.a(899278771);
            } else if ("fetch_primary_email_address".equals(a)) {
                b = mo585k(operationParams, blueServiceHandler);
                TracerDetour.a(714361052);
            } else if ("send_campaign_payment_message".equals(a)) {
                b = mo586n(operationParams, blueServiceHandler);
                TracerDetour.a(274417042);
            } else if ("validate_payment_card_bin".equals(a)) {
                b = mo587o(operationParams, blueServiceHandler);
                TracerDetour.a(395446644);
            } else if ("money_penny_place_order".equals(a)) {
                b = mo588p(operationParams, blueServiceHandler);
                TracerDetour.a(-1647795655);
            } else if ("mc_place_order".equals(a)) {
                b = mo589q(operationParams, blueServiceHandler);
                TracerDetour.a(365344155);
            } else if ("verify_payment".equals(a)) {
                b = mo590r(operationParams, blueServiceHandler);
                TracerDetour.a(1560238225);
            } else if ("payment_platform_contexts".equals(a)) {
                b = mo567s(operationParams, blueServiceHandler);
                TracerDetour.a(296997877);
            } else if ("payment_platform_context".equals(a)) {
                b = mo591t(operationParams, blueServiceHandler);
                TracerDetour.a(335696157);
            } else if ("create_payment_request".equals(a)) {
                b = mo592u(operationParams, blueServiceHandler);
                TracerDetour.a(218001754);
            } else if ("fetch_payment_request".equals(a)) {
                b = mo568v(operationParams, blueServiceHandler);
                TracerDetour.a(1163174273);
            } else if ("fetch_payment_requests".equals(a)) {
                b = mo569w(operationParams, blueServiceHandler);
                TracerDetour.a(285963207);
            } else if ("decline_payment_request".equals(a)) {
                b = mo593x(operationParams, blueServiceHandler);
                TracerDetour.a(-33871891);
            } else if ("cancel_payment_request".equals(a)) {
                b = mo594y(operationParams, blueServiceHandler);
                TracerDetour.a(-816525255);
            } else if ("cancel_payment_transaction".equals(a)) {
                b = mo595z(operationParams, blueServiceHandler);
                TracerDetour.a(1721055786);
            } else if ("mutate_payment_platform_context".equals(a)) {
                b = mo577A(operationParams, blueServiceHandler);
                TracerDetour.a(1034612860);
            } else if ("add_shipping_address".equals(a)) {
                b = mo578B(operationParams, blueServiceHandler);
                TracerDetour.a(1757214014);
            } else if ("edit_shipping_address".equals(a)) {
                b = mo579C(operationParams, blueServiceHandler);
                TracerDetour.a(-354823494);
            } else if ("fetch_shipping_addresses".equals(a)) {
                b = mo580D(operationParams, blueServiceHandler);
                TracerDetour.a(-415905804);
            } else if ("fetch_theme_list".equals(a)) {
                b = mo564E(operationParams, blueServiceHandler);
                TracerDetour.a(-980880617);
            } else if ("fetch_payment_account_enabled_status".equals(a)) {
                b = mo570F(operationParams, blueServiceHandler);
                TracerDetour.a(896329212);
            } else if ("send_payment".equals(a)) {
                b = mo581G(operationParams, blueServiceHandler);
                TracerDetour.a(-1900101653);
            } else {
                b = blueServiceHandler.a(operationParams);
                TracerDetour.a(825424660);
            }
            return b;
        } finally {
            TracerDetour.a(763713208);
        }
    }

    protected OperationResult mo571b(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo572c(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo565d(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo582e(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo583f(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo584g(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo573h(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo574i(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo566j(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo585k(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo575l(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo576m(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo586n(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo587o(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo588p(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo589q(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo590r(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo567s(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo591t(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo592u(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo568v(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo569w(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo593x(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo594y(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo595z(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo577A(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo578B(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo579C(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo580D(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo564E(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo570F(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }

    protected OperationResult mo581G(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return blueServiceHandler.a(operationParams);
    }
}
