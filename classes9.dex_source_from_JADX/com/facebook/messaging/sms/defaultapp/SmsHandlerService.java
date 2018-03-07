package com.facebook.messaging.sms.defaultapp;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import com.facebook.base.service.FbService;
import com.facebook.inject.FbInjector;
import javax.inject.Inject;

/* compiled from: com.facebook.payments.paymentmethods.picker.PickerScreenActivity */
public class SmsHandlerService extends FbService {
    @Inject
    public SmsHandler f17612a;

    public static void m17588a(Object obj, Context context) {
        ((SmsHandlerService) obj).f17612a = SmsHandler.m17576a(FbInjector.get(context));
    }

    public final void m17590a() {
        super.a();
        Class cls = SmsHandlerService.class;
        m17588a(this, this);
        this.f17612a.f17611q = this;
    }

    public final int m17589a(Intent intent, int i, int i2) {
        Message obtainMessage = this.f17612a.obtainMessage();
        obtainMessage.obj = intent;
        obtainMessage.arg1 = i2;
        this.f17612a.sendMessage(obtainMessage);
        return 2;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }
}
