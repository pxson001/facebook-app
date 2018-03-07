package com.facebook.placetips.gpscore;

import com.facebook.placetips.bootstrap.PlaceTipsDebugStatusDataProvider;
import com.facebook.placetips.gpscore.abtest.ExperimentsForPlaceTipsGpsAbTestModule;
import com.facebook.qe.api.QeAccessor;
import javax.inject.Inject;

/* compiled from: TimelineCollectionPlusButton */
public class PlaceTipsGpsDebugStatusProvider implements PlaceTipsDebugStatusDataProvider {
    private final QeAccessor f10605a;

    @Inject
    public PlaceTipsGpsDebugStatusProvider(QeAccessor qeAccessor) {
        this.f10605a = qeAccessor;
    }

    public final CharSequence m11091a() {
        return new StringBuilder("-------------GPS QE-------------\nEnabled: ").append(this.f10605a.a(ExperimentsForPlaceTipsGpsAbTestModule.a, false)).append("\nFeedUnitFormatString: ").append(this.f10605a.a(ExperimentsForPlaceTipsGpsAbTestModule.b, "%s"));
    }
}
