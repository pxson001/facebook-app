package com.facebook.socialgood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.socialgood.ui.FundraiserPageFragment;

/* compiled from: PERMISSION_DENIED */
public class FundraiserPageFragmentFactory implements IFragmentFactory {
    public final Fragment m13023a(Intent intent) {
        FundraiserPageFragment fundraiserPageFragment = new FundraiserPageFragment();
        Bundle extras = intent.getExtras();
        extras.putBoolean("ptr_enabled", true);
        fundraiserPageFragment.g(extras);
        return fundraiserPageFragment;
    }
}
