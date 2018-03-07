package com.facebook.socialgood.inviter;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: Original activity manager is null. */
public class FundraiserPageInviterFragmentFactory implements IFragmentFactory {
    public final Fragment m13213a(Intent intent) {
        FundraiserPageInviterFragment fundraiserPageInviterFragment = new FundraiserPageInviterFragment();
        fundraiserPageInviterFragment.g(intent.getExtras());
        return fundraiserPageInviterFragment;
    }
}
