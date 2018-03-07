package com.facebook.omnistore.module;

import com.facebook.omnistore.module.OmnistoreComponentManager.OmnistoreComponentManagerBroadcastReceiverRegistration;

/* compiled from: shimmedMutation */
public class C0118x77b9944b implements Runnable {
    final /* synthetic */ OmnistoreComponentManagerBroadcastReceiverRegistration this$0;
    final /* synthetic */ OmnistoreComponentManager val$componentManager;

    public C0118x77b9944b(OmnistoreComponentManagerBroadcastReceiverRegistration omnistoreComponentManagerBroadcastReceiverRegistration, OmnistoreComponentManager omnistoreComponentManager) {
        this.this$0 = omnistoreComponentManagerBroadcastReceiverRegistration;
        this.val$componentManager = omnistoreComponentManager;
    }

    public void run() {
        for (OmnistoreComponent maybeUpdateComponent : this.val$componentManager.mStartupOmnistoreComponents) {
            this.val$componentManager.maybeUpdateComponent(maybeUpdateComponent);
        }
    }
}
