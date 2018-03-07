package com.facebook.today.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.inject.Lazy;
import com.facebook.today.abtest.TodayExperimentController;
import com.facebook.today.ui.TodayFragment;
import com.facebook.today.ui.TodayFragmentArgumentsBuilder;
import javax.inject.Inject;

/* compiled from: Ljava/lang/Enum */
public class TodayFragmentFactory implements IFragmentFactory {
    private final TodayExperimentController f13988a;
    private final Lazy<TodayFragmentArgumentsBuilder> f13989b;

    @Inject
    public TodayFragmentFactory(TodayExperimentController todayExperimentController, Lazy<TodayFragmentArgumentsBuilder> lazy) {
        this.f13988a = todayExperimentController;
        this.f13989b = lazy;
    }

    public final Fragment m15112a(Intent intent) {
        boolean z;
        TodayFragment todayFragment = new TodayFragment();
        TodayFragmentArgumentsBuilder todayFragmentArgumentsBuilder = (TodayFragmentArgumentsBuilder) this.f13989b.get();
        Bundle bundle = new Bundle();
        String str = "ptr_enabled";
        if (Surface.ANDROID_TODAY == Surface.ANDROID_TODAY) {
            z = true;
        } else {
            z = false;
        }
        bundle.putBoolean(str, z);
        bundle.putString("source_name", todayFragmentArgumentsBuilder.a.getResources().getString(2131239646));
        todayFragment.g(bundle);
        return todayFragment;
    }
}
