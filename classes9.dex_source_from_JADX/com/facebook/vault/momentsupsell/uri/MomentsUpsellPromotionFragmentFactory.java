package com.facebook.vault.momentsupsell.uri;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.vault.momentsupsell.ui.MomentsAppPromotionFragment;

/* compiled from: thread_ids */
public class MomentsUpsellPromotionFragmentFactory implements IFragmentFactory {
    public final Fragment m1920a(Intent intent) {
        MomentsAppPromotionFragment momentsAppPromotionFragment = new MomentsAppPromotionFragment();
        momentsAppPromotionFragment.g(intent.getExtras());
        return momentsAppPromotionFragment;
    }
}
