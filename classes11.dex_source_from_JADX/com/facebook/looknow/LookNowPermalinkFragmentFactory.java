package com.facebook.looknow;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: valid_phone_number_submit */
public class LookNowPermalinkFragmentFactory implements IFragmentFactory {
    public final Fragment m289a(Intent intent) {
        LookNowPermalinkFragment lookNowPermalinkFragment = new LookNowPermalinkFragment();
        lookNowPermalinkFragment.g(intent.getExtras());
        return lookNowPermalinkFragment;
    }
}
