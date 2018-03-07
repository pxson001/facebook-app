package com.facebook.saved.controller;

import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.common.network.NetworkMonitor;
import com.facebook.inject.InjectorLike;
import com.facebook.saved.controller.SavedDataAndListStateController.C13802;
import javax.inject.Inject;

/* compiled from: isTokenEnabled */
public class SavedItemsReconnectController {
    public final NetworkMonitor f9091a;
    public SelfRegistrableReceiverImpl f9092b = null;
    public C13802 f9093c = null;

    /* compiled from: isTokenEnabled */
    public class C13871 implements Runnable {
        final /* synthetic */ SavedItemsReconnectController f9090a;

        public C13871(SavedItemsReconnectController savedItemsReconnectController) {
            this.f9090a = savedItemsReconnectController;
        }

        public void run() {
            if (this.f9090a.f9093c != null) {
                this.f9090a.f9093c.f9058a.b(true);
            }
        }
    }

    public static SavedItemsReconnectController m9101a(InjectorLike injectorLike) {
        return new SavedItemsReconnectController(NetworkMonitor.a(injectorLike));
    }

    @Inject
    public SavedItemsReconnectController(NetworkMonitor networkMonitor) {
        this.f9091a = networkMonitor;
    }
}
