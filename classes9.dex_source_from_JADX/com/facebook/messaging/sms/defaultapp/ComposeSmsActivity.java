package com.facebook.messaging.sms.defaultapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.messages.ipc.MessagingIntentUris;
import com.facebook.messages.links.MessengerLinks;
import com.google.common.base.Strings;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: command */
public class ComposeSmsActivity extends FbFragmentActivity {
    @Inject
    public SecureContextHelper f17532p;

    public static void m17514a(Object obj, Context context) {
        ((ComposeSmsActivity) obj).f17532p = (SecureContextHelper) DefaultSecureContextHelper.a(FbInjector.get(context));
    }

    protected final void m17516b(Bundle bundle) {
        Object obj = 1;
        super.b(bundle);
        Class cls = ComposeSmsActivity.class;
        m17514a(this, this);
        Intent intent = getIntent();
        if (!(bundle != null || intent == null || intent.getData() == null)) {
            String str;
            String b = m17515b(intent.getData());
            Object obj2 = !Strings.isNullOrEmpty(intent.getStringExtra("address")) ? 1 : null;
            if (Strings.isNullOrEmpty(intent.getStringExtra("android.intent.extra.EMAIL"))) {
                obj = null;
            }
            if (b != null || (obj2 == null && r1 == null)) {
                str = b;
            } else if (obj2 != null) {
                str = intent.getStringExtra("address");
            } else {
                str = intent.getStringExtra("android.intent.extra.EMAIL");
            }
            String stringExtra = intent.getStringExtra("sms_body");
            if (Strings.isNullOrEmpty(stringExtra)) {
                stringExtra = m17513a(intent.getData());
                if (Strings.isNullOrEmpty(stringExtra)) {
                    stringExtra = intent.getStringExtra("android.intent.extra.TEXT");
                }
            }
            if (str != null) {
                Intent intent2 = new Intent("com.facebook.messaging.sms.COMPOSE_SMS", null, this, SmsReceiver.class);
                intent2.putExtra("addresses", str);
                intent2.putExtra("message", stringExtra);
                sendBroadcast(intent2);
            } else if (stringExtra != null) {
                Intent intent3 = new Intent(MessagingIntentUris.a);
                intent3.setData(Uri.parse(MessengerLinks.o));
                intent3.putExtra("android.intent.extra.TEXT", stringExtra);
                this.f17532p.a(intent3, this);
            }
        }
        finish();
    }

    @Nullable
    private static String m17513a(Uri uri) {
        String str = null;
        if (uri != null) {
            String schemeSpecificPart = uri.getSchemeSpecificPart();
            if (schemeSpecificPart.contains("?")) {
                String[] split = schemeSpecificPart.substring(schemeSpecificPart.indexOf(63) + 1).split("&");
                int length = split.length;
                int i = 0;
                while (i < length) {
                    String str2 = split[i];
                    if (str2.startsWith("body=")) {
                        try {
                            str = URLDecoder.decode(str2.substring(5), "UTF-8");
                            break;
                        } catch (UnsupportedEncodingException e) {
                        }
                    } else {
                        i++;
                    }
                }
            }
        }
        return str;
    }

    @Nullable
    private static String m17515b(Uri uri) {
        String[] split = uri.getSchemeSpecificPart().split("\\?");
        if (Strings.isNullOrEmpty(split[0])) {
            return null;
        }
        String str = split[0];
        StringBuilder stringBuilder = new StringBuilder(str.length());
        for (char c : str.toCharArray()) {
            int digit = Character.digit(c, 10);
            if (digit != -1) {
                stringBuilder.append(digit);
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString().replace(';', ',');
    }
}
