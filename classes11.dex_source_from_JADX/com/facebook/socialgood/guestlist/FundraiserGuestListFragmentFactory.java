package com.facebook.socialgood.guestlist;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: PAGE_TIPS */
public class FundraiserGuestListFragmentFactory implements IFragmentFactory {
    public final Fragment m13052a(Intent intent) {
        FundraiserGuestListFrameFragment fundraiserGuestListFrameFragment = new FundraiserGuestListFrameFragment();
        fundraiserGuestListFrameFragment.g(intent.getExtras());
        return fundraiserGuestListFrameFragment;
    }
}
