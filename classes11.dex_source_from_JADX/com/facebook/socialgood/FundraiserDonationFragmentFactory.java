package com.facebook.socialgood;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.socialgood.ui.FundraiserDonationFragment;

/* compiled from: PERSON_YOU_MAY_KNOW */
public class FundraiserDonationFragmentFactory implements IFragmentFactory {
    public final Fragment m13022a(Intent intent) {
        FundraiserDonationFragment fundraiserDonationFragment = new FundraiserDonationFragment();
        fundraiserDonationFragment.g(intent.getExtras());
        return fundraiserDonationFragment;
    }
}
