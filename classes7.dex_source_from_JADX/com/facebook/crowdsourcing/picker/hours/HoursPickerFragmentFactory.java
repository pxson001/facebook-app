package com.facebook.crowdsourcing.picker.hours;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: com.facebook.katana.profile.id */
public class HoursPickerFragmentFactory implements IFragmentFactory {
    public final Fragment m21408a(Intent intent) {
        HoursPickerFragment hoursPickerFragment = new HoursPickerFragment();
        hoursPickerFragment.g(intent.getExtras());
        return hoursPickerFragment;
    }
}
