package com.facebook.quickpromotion.controller;

import com.facebook.quickpromotion.asset.QuickPromotionAssetManagerImpl;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;

/* compiled from: record_remote_raw_video */
public class QuickPromotionControllerDelegate$2 implements Runnable {
    final /* synthetic */ QuickPromotionControllerDelegate f3555a;

    public QuickPromotionControllerDelegate$2(QuickPromotionControllerDelegate quickPromotionControllerDelegate) {
        this.f3555a = quickPromotionControllerDelegate;
    }

    public void run() {
        QuickPromotionControllerDelegate quickPromotionControllerDelegate = this.f3555a;
        QuickPromotionAssetManagerImpl quickPromotionAssetManagerImpl = (QuickPromotionAssetManagerImpl) quickPromotionControllerDelegate.g.get();
        int size = quickPromotionControllerDelegate.p.size();
        for (int i = 0; i < size; i++) {
            QuickPromotionDefinition quickPromotionDefinition = (QuickPromotionDefinition) quickPromotionControllerDelegate.p.get(i);
            if (!quickPromotionAssetManagerImpl.m4403a(quickPromotionDefinition)) {
                quickPromotionAssetManagerImpl.m4404b(quickPromotionDefinition);
            }
        }
    }
}
