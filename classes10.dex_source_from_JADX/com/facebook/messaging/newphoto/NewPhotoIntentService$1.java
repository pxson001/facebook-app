package com.facebook.messaging.newphoto;

import android.content.Context;
import android.content.Intent;

/* compiled from: return_ssl_resources */
class NewPhotoIntentService$1 implements Runnable {
    final /* synthetic */ NewPhotoIntentHandler f3361a;
    final /* synthetic */ Context f3362b;
    final /* synthetic */ Intent f3363c;
    final /* synthetic */ NewPhotoIntentService f3364d;

    public void run() {
        NewPhotoIntentService.f--;
    }

    NewPhotoIntentService$1(NewPhotoIntentService newPhotoIntentService, NewPhotoIntentHandler newPhotoIntentHandler, Context context, Intent intent) {
        this.f3364d = newPhotoIntentService;
        this.f3361a = newPhotoIntentHandler;
        this.f3362b = context;
        this.f3363c = intent;
    }
}
