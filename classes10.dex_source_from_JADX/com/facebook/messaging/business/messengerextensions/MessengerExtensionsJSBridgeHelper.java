package com.facebook.messaging.business.messengerextensions;

import android.webkit.WebView;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.SecureWebViewHelper;
import com.facebook.messaging.analytics.base.MessagingAnalyticsConstants.MessageSendTrigger;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.payment.value.input.EnterPaymentValueActivity;
import com.facebook.messaging.payment.value.input.MoneyPennyItemParams;
import com.facebook.messaging.payment.value.input.MoneyPennyItemParamsBuilder;
import com.facebook.messaging.send.client.OutgoingMessageFactory;
import com.facebook.messaging.send.client.SendMessageManager;
import com.facebook.messaging.send.trigger.NavigationTrigger;
import com.facebook.user.model.User;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: thread_blocking_flow */
public final class MessengerExtensionsJSBridgeHelper {
    @LoggedInUser
    public final Provider<User> f1631a;
    private final SecureContextHelper f1632b;
    public final OutgoingMessageFactory f1633c;
    public final SendMessageManager f1634d;
    @ForUiThread
    public final ExecutorService f1635e;
    public final SecureWebViewHelper f1636f;
    @Nullable
    public String f1637g;
    @Nullable
    public ThreadKey f1638h;
    public MessengerExtensionsEventListener f1639i;
    @Nullable
    public String f1640j;
    public WebView f1641k;

    /* compiled from: thread_blocking_flow */
    public class C02621 implements Runnable {
        final /* synthetic */ String f1622a;
        final /* synthetic */ String f1623b;
        final /* synthetic */ MessengerExtensionsJSBridgeHelper f1624c;

        public C02621(MessengerExtensionsJSBridgeHelper messengerExtensionsJSBridgeHelper, String str, String str2) {
            this.f1624c = messengerExtensionsJSBridgeHelper;
            this.f1622a = str;
            this.f1623b = str2;
        }

        public void run() {
            this.f1624c.f1634d.a(this.f1624c.f1633c.a(this.f1624c.f1638h, this.f1622a), "MessengerExtensions", NavigationTrigger.b("MessengerExtensions"), MessageSendTrigger.SHARE);
            MessengerExtensionsJSBridgeHelper.m1592a(this.f1624c, this.f1623b, "send success");
        }
    }

    /* compiled from: thread_blocking_flow */
    public class C02632 implements Runnable {
        final /* synthetic */ MessengerExtensionsJSBridgeHelper f1625a;

        public C02632(MessengerExtensionsJSBridgeHelper messengerExtensionsJSBridgeHelper) {
            this.f1625a = messengerExtensionsJSBridgeHelper;
        }

        public void run() {
            if (this.f1625a.f1639i != null) {
                this.f1625a.f1639i.mo55b();
            }
        }
    }

    /* compiled from: thread_blocking_flow */
    public class C02643 implements Runnable {
        final /* synthetic */ boolean f1626a;
        final /* synthetic */ MessengerExtensionsJSBridgeHelper f1627b;

        public C02643(MessengerExtensionsJSBridgeHelper messengerExtensionsJSBridgeHelper, boolean z) {
            this.f1627b = messengerExtensionsJSBridgeHelper;
            this.f1626a = z;
        }

        public void run() {
            if (this.f1627b.f1639i != null) {
                this.f1627b.f1639i.mo54a(this.f1626a);
            }
        }
    }

    @Inject
    public MessengerExtensionsJSBridgeHelper(Provider<User> provider, SecureContextHelper secureContextHelper, OutgoingMessageFactory outgoingMessageFactory, SendMessageManager sendMessageManager, ExecutorService executorService, SecureWebViewHelper secureWebViewHelper) {
        this.f1631a = provider;
        this.f1632b = secureContextHelper;
        this.f1633c = outgoingMessageFactory;
        this.f1634d = sendMessageManager;
        this.f1635e = executorService;
        this.f1636f = secureWebViewHelper;
    }

    public final void m1593a(String str, String str2, String str3, String str4, String str5, String str6) {
        MoneyPennyItemParamsBuilder newBuilder = MoneyPennyItemParams.newBuilder();
        newBuilder.a = 1111;
        newBuilder = newBuilder;
        newBuilder.b = str2;
        newBuilder = newBuilder;
        newBuilder.c = str3;
        newBuilder = newBuilder;
        newBuilder.d = str4;
        newBuilder = newBuilder;
        newBuilder.e = str5;
        newBuilder = newBuilder;
        newBuilder.f = str6;
        newBuilder = newBuilder;
        newBuilder.g = "USD";
        this.f1632b.a(EnterPaymentValueActivity.a(this.f1641k.getContext(), newBuilder.h()), this.f1641k.getContext());
        m1592a(this, str, "payment success");
    }

    public static void m1592a(MessengerExtensionsJSBridgeHelper messengerExtensionsJSBridgeHelper, final String str, final Object... objArr) {
        messengerExtensionsJSBridgeHelper.f1641k.post(new Runnable(messengerExtensionsJSBridgeHelper) {
            final /* synthetic */ MessengerExtensionsJSBridgeHelper f1630c;

            public void run() {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < objArr.length; i++) {
                    stringBuilder.append('\"');
                    stringBuilder.append(objArr[i]);
                    stringBuilder.append('\"');
                    if (i < objArr.length - 1) {
                        stringBuilder.append(",");
                    }
                }
                this.f1630c.f1636f.b(this.f1630c.f1641k, StringFormatUtil.formatStrLocaleSafe("javascript:%s(\\\"%s\\\",%s);", this.f1630c.f1640j, str, stringBuilder.toString()));
            }
        });
    }
}
