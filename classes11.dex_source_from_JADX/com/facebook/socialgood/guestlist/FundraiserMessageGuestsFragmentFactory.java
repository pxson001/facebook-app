package com.facebook.socialgood.guestlist;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: PAGES_FEED */
public class FundraiserMessageGuestsFragmentFactory implements IFragmentFactory {
    public final Fragment m13198a(Intent intent) {
        FundraiserMessageGuestsFrameFragment fundraiserMessageGuestsFrameFragment = new FundraiserMessageGuestsFrameFragment();
        fundraiserMessageGuestsFrameFragment.g(intent.getExtras());
        return fundraiserMessageGuestsFrameFragment;
    }
}
