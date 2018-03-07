package com.facebook.adinterfaces.ui.selector;

import android.content.Context;
import android.content.Intent;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.GeoLocationModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.InterestModel;
import com.facebook.adinterfaces.ui.selector.TargetingSelectorFragmentFactory.SelectorType;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: Unknown host */
public class TargetingSelectorActivityHelper {
    public static Intent m25223a(Context context, @Nullable List<InterestModel> list) {
        Intent intent = new Intent(context, TargetingSelectorActivity.class);
        if (!(list == null || list.isEmpty())) {
            FlatBufferModelHelper.a(intent, "initialData", Lists.a(list));
        }
        return intent.putExtra("selectorArgument", new TargetingSelectorArgument(SelectorType.INTEREST, 2131234086));
    }

    public static Intent m25224a(Context context, @Nullable List<GeoLocationModel> list, @Nullable List<GeoLocationModel> list2) {
        Intent intent = new Intent(context, TargetingSelectorActivity.class);
        if (!(list == null || list.isEmpty())) {
            FlatBufferModelHelper.a(intent, "defaultLocations", Lists.a(list));
        }
        if (!(list2 == null || list2.isEmpty())) {
            FlatBufferModelHelper.a(intent, "initialData", Lists.a(list2));
        }
        return intent.putExtra("selectorArgument", new TargetingSelectorArgument(SelectorType.LOCATION, 2131234078));
    }
}
