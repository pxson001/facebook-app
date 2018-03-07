package com.facebook.common.appstate;

import android.content.Context;
import android.content.Intent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.fragment.FragmentCreateDestroyCallbacks;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.inject.Inject;

/* compiled from: placeTipsUpsell */
public class AppBackgroundFragmentController extends BaseController implements FragmentCreateDestroyCallbacks {
    public final BaseFbBroadcastManager f9829a;
    public SelfRegistrableReceiverImpl f9830b;
    public OnBackgroundForegroundCallback f9831c;

    /* compiled from: placeTipsUpsell */
    public class C04792 implements ActionReceiver {
        final /* synthetic */ AppBackgroundFragmentController f11475a;

        public C04792(AppBackgroundFragmentController appBackgroundFragmentController) {
            this.f11475a = appBackgroundFragmentController;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 490258301);
            this.f11475a.f9831c.kH_();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1259658804, a);
        }
    }

    /* compiled from: placeTipsUpsell */
    public class C04801 implements ActionReceiver {
        final /* synthetic */ AppBackgroundFragmentController f11476a;

        public C04801(AppBackgroundFragmentController appBackgroundFragmentController) {
            this.f11476a = appBackgroundFragmentController;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -2064869434);
            this.f11476a.f9831c.kI_();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1852348631, a);
        }
    }

    public static AppBackgroundFragmentController m14855a(InjectorLike injectorLike) {
        return new AppBackgroundFragmentController(LocalFbBroadcastManager.m2946a(injectorLike));
    }

    @Inject
    public AppBackgroundFragmentController(BaseFbBroadcastManager baseFbBroadcastManager) {
        this.f9829a = baseFbBroadcastManager;
    }

    public final void mo1949b() {
        this.f9830b.m3297c();
    }
}
