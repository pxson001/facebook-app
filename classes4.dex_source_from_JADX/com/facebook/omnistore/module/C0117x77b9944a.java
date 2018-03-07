package com.facebook.omnistore.module;

import com.facebook.omnistore.module.OmnistoreComponentManager.OmnistoreComponentManagerBroadcastReceiverRegistration;

/* compiled from: shimmedMutation */
public class C0117x77b9944a implements Runnable {
    final /* synthetic */ OmnistoreComponentManagerBroadcastReceiverRegistration this$0;
    final /* synthetic */ OmnistoreComponentManager val$componentManager;

    public C0117x77b9944a(OmnistoreComponentManagerBroadcastReceiverRegistration omnistoreComponentManagerBroadcastReceiverRegistration, OmnistoreComponentManager omnistoreComponentManager) {
        this.this$0 = omnistoreComponentManagerBroadcastReceiverRegistration;
        this.val$componentManager = omnistoreComponentManager;
    }

    public void run() {
        this.val$componentManager.init();
    }
}
