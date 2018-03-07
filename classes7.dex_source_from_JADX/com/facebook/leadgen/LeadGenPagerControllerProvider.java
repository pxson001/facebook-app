package com.facebook.leadgen;

import android.support.v4.view.ViewPager;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.leadgen.cache.LeadGenFormPendingInputEntry;
import com.facebook.leadgen.data.LeadGenDataExtractor;

/* compiled from: place_edit_review_error */
public class LeadGenPagerControllerProvider extends AbstractAssistedProvider<LeadGenPagerController> {
    public final LeadGenPagerController m8164a(ViewPager viewPager, LeadGenDataExtractor leadGenDataExtractor, LeadGenFormPendingInputEntry leadGenFormPendingInputEntry) {
        return new LeadGenPagerController((LeadGenFormPagesAdapterProvider) getOnDemandAssistedProviderForStaticDi(LeadGenFormPagesAdapterProvider.class), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(this), LeadGenLogger.m8134a((InjectorLike) this), viewPager, leadGenDataExtractor, leadGenFormPendingInputEntry);
    }
}
