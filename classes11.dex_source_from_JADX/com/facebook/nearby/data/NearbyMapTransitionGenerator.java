package com.facebook.nearby.data;

import com.facebook.nearby.cluster.MapDisplayData;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* compiled from: user_defined_search_location */
public class NearbyMapTransitionGenerator {
    public static MapPinTransition m398a(@Nullable MapDisplayData mapDisplayData, MapDisplayData mapDisplayData2) {
        if (mapDisplayData == null) {
            mapDisplayData = new MapDisplayData(new ArrayList(), new ArrayList(), new ArrayList());
        }
        return new MapPinTransition(Sets.c(mapDisplayData2.f301a, mapDisplayData.f301a), Sets.c(mapDisplayData.f301a, mapDisplayData2.f301a), Sets.c(mapDisplayData2.f302b, mapDisplayData.f302b), Sets.c(mapDisplayData.f302b, mapDisplayData2.f302b), Sets.c(mapDisplayData2.f303c, mapDisplayData.f303c), Sets.c(mapDisplayData.f303c, mapDisplayData2.f303c));
    }
}
