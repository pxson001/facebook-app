package com.facebook.messaging.newphoto;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import java.util.Iterator;

/* compiled from: return_ssl_resources */
class NewPhotoIntentService$2 implements Runnable {
    final /* synthetic */ boolean f3365a;
    final /* synthetic */ PackageManager f3366b;
    final /* synthetic */ ComponentName f3367c;
    final /* synthetic */ NewPhotoIntentService f3368d;

    NewPhotoIntentService$2(NewPhotoIntentService newPhotoIntentService, boolean z, PackageManager packageManager, ComponentName componentName) {
        this.f3368d = newPhotoIntentService;
        this.f3365a = z;
        this.f3366b = packageManager;
        this.f3367c = componentName;
    }

    public void run() {
        String str = NewPhotoIntentService.e;
        this.f3366b.setComponentEnabledSetting(this.f3367c, this.f3365a ? 1 : 2, 1);
        Iterator it = this.f3368d.d.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }
}
