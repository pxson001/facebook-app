package com.facebook.messaging.newphoto;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.Nullable;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.base.service.FbService;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.messaging.newphoto.STATICDI_MULTIBIND_PROVIDER.NewPhotoIntentHandler;
import com.facebook.messaging.newphoto.STATICDI_MULTIBIND_PROVIDER.NewPhotoIntentReceiverStateChangeListener;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.user.model.User;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Future;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: getJsonFields */
public class NewPhotoIntentService extends FbService {
    public static final String f11137e = NewPhotoIntentService.class.getSimpleName();
    public static int f11138f = 0;
    @Inject
    @LoggedInUser
    public Provider<User> f11139a;
    @Inject
    public Set<NewPhotoIntentHandler> f11140b;
    @DefaultExecutorService
    @Inject
    public ListeningExecutorService f11141c;
    @Inject
    public Set<NewPhotoIntentReceiverStateChangeListener> f11142d;
    private Future f11143g;
    private Uri f11144h;

    public static void m11604a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        NewPhotoIntentService newPhotoIntentService = (NewPhotoIntentService) obj;
        Provider a = IdBasedProvider.a(fbInjector, 3595);
        Set multiBinderSet = new MultiBinderSet(fbInjector.getScopeAwareInjector(), new NewPhotoIntentHandler(fbInjector));
        ListeningExecutorService a2 = ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(fbInjector);
        Set multiBinderSet2 = new MultiBinderSet(fbInjector.getScopeAwareInjector(), new NewPhotoIntentReceiverStateChangeListener(fbInjector));
        newPhotoIntentService.f11139a = a;
        newPhotoIntentService.f11140b = multiBinderSet;
        newPhotoIntentService.f11141c = a2;
        newPhotoIntentService.f11142d = multiBinderSet2;
    }

    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    public final void m11608a() {
        super.a();
        AppInitLockHelper.a(getApplicationContext());
        Class cls = NewPhotoIntentService.class;
        m11604a(this, this);
        Integer.valueOf(this.f11140b.size());
        Integer.valueOf(this.f11142d.size());
    }

    public final int m11607a(Intent intent, int i, int i2) {
        if (intent != null) {
            if (intent.hasExtra("sync_receiver")) {
                m11606e();
            } else {
                m11603a(intent);
            }
        }
        return 2;
    }

    private void m11603a(Intent intent) {
        if (this.f11139a.get() == null) {
            BLog.b(f11137e, "Not a logged in user.");
        } else if (m11605d()) {
            Uri data = intent.getData();
            if (data != null && !data.equals(this.f11144h)) {
                this.f11144h = data;
                for (NewPhotoIntentHandler newPhotoIntentHandler : this.f11140b) {
                    if (newPhotoIntentHandler.a()) {
                        newPhotoIntentHandler.getClass().getSimpleName();
                        Integer.valueOf(f11138f);
                        f11138f++;
                        ExecutorDetour.a(this.f11141c, new 1(this, newPhotoIntentHandler, this, intent), 303227560);
                    }
                }
            }
        } else {
            m11606e();
        }
    }

    @VisibleForTesting
    private boolean m11605d() {
        for (NewPhotoIntentHandler a : this.f11140b) {
            if (a.a()) {
                return true;
            }
        }
        return false;
    }

    private void m11606e() {
        boolean z = true;
        Iterator it = this.f11142d.iterator();
        while (it.hasNext()) {
            it.next();
        }
        Context applicationContext = getApplicationContext();
        ComponentName componentName = new ComponentName(applicationContext, NewPhotoBroadcastReceiver.class);
        PackageManager packageManager = applicationContext.getPackageManager();
        if (this.f11143g != null) {
            this.f11143g.cancel(true);
        }
        boolean z2 = packageManager.getComponentEnabledSetting(componentName) == 1;
        if (this.f11139a.get() == null || !m11605d()) {
            z = false;
        }
        if (z2 != z) {
            this.f11143g = this.f11141c.a(new 2(this, z, packageManager, componentName));
        }
    }

    public static Intent m11602a(Context context) {
        Preconditions.checkNotNull(context);
        return new Intent(context, NewPhotoIntentService.class).putExtra("sync_receiver", true);
    }
}
