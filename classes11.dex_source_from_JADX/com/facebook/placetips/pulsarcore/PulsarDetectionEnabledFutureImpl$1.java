package com.facebook.placetips.pulsarcore;

import com.facebook.placetips.pulsarcore.abtest.PlaceTipsPulsarQe.Config;
import com.facebook.placetips.settings.PlaceTipsSettingsPrefs.Accessor;
import com.google.common.base.Function;
import java.util.List;

/* compiled from: The given position is not within the Friend Requests section */
class PulsarDetectionEnabledFutureImpl$1 implements Function<List<Object>, Boolean> {
    final /* synthetic */ PulsarDetectionEnabledFutureImpl f10672a;

    PulsarDetectionEnabledFutureImpl$1(PulsarDetectionEnabledFutureImpl pulsarDetectionEnabledFutureImpl) {
        this.f10672a = pulsarDetectionEnabledFutureImpl;
    }

    public Object apply(Object obj) {
        List list = (List) obj;
        boolean z = ((Config) list.get(0)).f10682a && ((Accessor) list.get(1)).c();
        return Boolean.valueOf(z);
    }
}
