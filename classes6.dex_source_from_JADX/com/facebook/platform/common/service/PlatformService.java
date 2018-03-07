package com.facebook.platform.common.service;

import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.facebook.base.service.FbService;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.platform.common.util.PlatformPackageUtilities;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: stories */
public class PlatformService extends FbService {
    public static final Class<?> f4089a = PlatformService.class;
    private Map<Integer, PlatformServiceHandler> f4090b;
    private Set<PlatformServiceHandler> f4091c;
    public PlatformPackageUtilities f4092d;

    /* compiled from: stories */
    class MessageHandler extends Handler {
        final /* synthetic */ PlatformService f4087a;
        private String f4088b;

        MessageHandler(PlatformService platformService) {
            this.f4087a = platformService;
        }

        public boolean sendMessageAtTime(Message message, long j) {
            String a;
            PlatformPackageUtilities platformPackageUtilities = this.f4087a.f4092d;
            String[] packagesForUid = platformPackageUtilities.f4098b.getPackagesForUid(Binder.getCallingUid());
            if (packagesForUid.length > 0) {
                a = platformPackageUtilities.m6012a(packagesForUid[0]);
            } else {
                a = "";
            }
            this.f4088b = a;
            return super.sendMessageAtTime(message, j);
        }

        public void handleMessage(Message message) {
            PlatformServiceHandler a = this.f4087a.m5997a(message.what);
            if (a == null) {
                super.handleMessage(message);
                return;
            }
            PlatformServiceRequest b = a.mo294b();
            if (b.m5986a(message, this.f4088b)) {
                a.mo293a(message, b);
            } else if (message.replyTo != null) {
                try {
                    message.replyTo.send(b.m5989d());
                } catch (Throwable e) {
                    BLog.a(PlatformService.f4089a, "Unable to send platform service reply", e);
                }
            } else {
                BLog.a(PlatformService.f4089a, "Error parsing platform service message");
            }
        }
    }

    private static <T extends Context> void m6000a(Class<T> cls, T t) {
        m6001a((Object) t, (Context) t);
    }

    public static void m6001a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PlatformService) obj).m6002a((Set) new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$PlatformServiceHandler(injectorLike)), PlatformPackageUtilities.m6010b(injectorLike));
    }

    public final void m6004a() {
        super.a();
        AppInitLockHelper.a(this);
        Class cls = PlatformService.class;
        m6001a((Object) this, (Context) this);
    }

    @Inject
    private void m6002a(Set<PlatformServiceHandler> set, PlatformPackageUtilities platformPackageUtilities) {
        this.f4091c = set;
        this.f4092d = platformPackageUtilities;
    }

    public IBinder onBind(Intent intent) {
        return new Messenger(new MessageHandler(this)).getBinder();
    }

    private PlatformServiceHandler m5997a(int i) {
        if (this.f4090b == null) {
            this.f4090b = Maps.c();
            if (this.f4091c != null) {
                for (PlatformServiceHandler platformServiceHandler : this.f4091c) {
                    this.f4090b.put(Integer.valueOf(platformServiceHandler.mo292a()), platformServiceHandler);
                }
            }
        }
        return (PlatformServiceHandler) this.f4090b.get(Integer.valueOf(i));
    }
}
