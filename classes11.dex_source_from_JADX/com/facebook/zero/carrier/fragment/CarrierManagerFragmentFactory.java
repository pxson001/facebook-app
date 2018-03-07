package com.facebook.zero.carrier.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.inject.InjectorLike;

/* compiled from: music_play_requested */
public class CarrierManagerFragmentFactory implements IFragmentFactory {
    public static CarrierManagerFragmentFactory m6568a(InjectorLike injectorLike) {
        return new CarrierManagerFragmentFactory();
    }

    public final Fragment m6569a(Intent intent) {
        CarrierManagerFragment carrierManagerFragment = new CarrierManagerFragment();
        carrierManagerFragment.g(intent.getExtras());
        return carrierManagerFragment;
    }
}
