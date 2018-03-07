package com.facebook.places.graphql;

import com.facebook.common.util.StringUtil;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel.AddressModel;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: subscribed */
public abstract class PlacesGraphQLHelper {
    @Nullable
    public static String m5512a(CheckinPlaceModel checkinPlaceModel) {
        AddressModel c = checkinPlaceModel.m5621c();
        if (c == null) {
            return null;
        }
        List a = Lists.a();
        if (!StringUtil.c(c.m5554b())) {
            a.add(c.m5554b());
        }
        if (!StringUtil.c(c.m5553a())) {
            a.add(c.m5553a());
        }
        if (a.size() <= 0) {
            return null;
        }
        return StringUtil.b(", ", new Object[]{a});
    }
}
