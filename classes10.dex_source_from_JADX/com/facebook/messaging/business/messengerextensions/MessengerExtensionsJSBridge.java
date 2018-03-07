package com.facebook.messaging.business.messengerextensions;

import android.webkit.JavascriptInterface;
import com.facebook.messaging.business.messengerextensions.MessengerExtensionsJSBridgeHelper.C02621;
import com.facebook.messaging.business.messengerextensions.MessengerExtensionsJSBridgeHelper.C02632;
import com.facebook.messaging.business.messengerextensions.MessengerExtensionsJSBridgeHelper.C02643;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.user.model.User;

/* compiled from: thread_data_obj */
public final class MessengerExtensionsJSBridge {
    private final MessengerExtensionsJSBridgeHelper f1621a;

    MessengerExtensionsJSBridge(MessengerExtensionsJSBridgeHelper messengerExtensionsJSBridgeHelper) {
        this.f1621a = messengerExtensionsJSBridgeHelper;
    }

    @JavascriptInterface
    public final void setupCallbackHandler(String str) {
        this.f1621a.f1640j = str;
    }

    @JavascriptInterface
    public final void requestUserProfile(String str) {
        String j;
        String x;
        MessengerExtensionsJSBridgeHelper messengerExtensionsJSBridgeHelper = this.f1621a;
        User user = (User) messengerExtensionsJSBridgeHelper.f1631a.get();
        if (user != null) {
            j = user.j();
            x = user.x();
        } else {
            x = null;
            j = null;
        }
        MessengerExtensionsJSBridgeHelper.m1592a(messengerExtensionsJSBridgeHelper, str, j, x, null);
    }

    @JavascriptInterface
    public final void requestSendMessageWithAttachment(String str, String str2, String str3, String str4, String str5, String str6) {
        MessengerExtensionsJSBridgeHelper messengerExtensionsJSBridgeHelper = this.f1621a;
        if (messengerExtensionsJSBridgeHelper.f1638h == null) {
            MessengerExtensionsJSBridgeHelper.m1592a(messengerExtensionsJSBridgeHelper, str, "send failed!");
        }
        ExecutorDetour.a(messengerExtensionsJSBridgeHelper.f1635e, new C02621(messengerExtensionsJSBridgeHelper, str2, str), 1058712316);
    }

    @JavascriptInterface
    public final void requestPaymentFlow(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f1621a.m1593a(str, str2, str3, str4, str5, str6);
    }

    @JavascriptInterface
    public final void requestClose(String str) {
        MessengerExtensionsJSBridgeHelper messengerExtensionsJSBridgeHelper = this.f1621a;
        ExecutorDetour.a(messengerExtensionsJSBridgeHelper.f1635e, new C02632(messengerExtensionsJSBridgeHelper), -534992763);
    }

    @JavascriptInterface
    public final void requestShow(boolean z) {
        MessengerExtensionsJSBridgeHelper messengerExtensionsJSBridgeHelper = this.f1621a;
        ExecutorDetour.a(messengerExtensionsJSBridgeHelper.f1635e, new C02643(messengerExtensionsJSBridgeHelper, z), -766711903);
    }
}
