package com.facebook.graphql.model;

import com.facebook.graphql.model.interfaces.HasTracking;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: is_aldrin_enabled_fb4a_logged_out */
public class VisibleItemHelper {
    public static void m26979a(ScrollableItemListFeedUnit scrollableItemListFeedUnit, int i) {
        m26980a(scrollableItemListFeedUnit, scrollableItemListFeedUnit.mo2882v(), i);
    }

    public static void m26980a(ScrollableItemListFeedUnit scrollableItemListFeedUnit, List list, int i) {
        Object obj;
        PropertyHelper.m21261a((Object) scrollableItemListFeedUnit).f14849F = Integer.valueOf(i);
        if (list == null || i < 0 || i >= list.size()) {
            obj = null;
        } else {
            obj = list.get(i);
        }
        Object obj2 = obj;
        PropertyHelper.m21261a((Object) scrollableItemListFeedUnit).f14850G = m26977a(obj2);
        PropertyHelper.m21261a((Object) scrollableItemListFeedUnit).f14851H = m26978a((HasTracking) scrollableItemListFeedUnit, obj2);
    }

    public static int m26976a(ScrollableItemListFeedUnit scrollableItemListFeedUnit) {
        Integer a = PropertyHelper.m21263a(scrollableItemListFeedUnit);
        return a != null ? a.intValue() : 0;
    }

    @Nullable
    public static SponsoredImpression m26981b(ScrollableItemListFeedUnit scrollableItemListFeedUnit) {
        if (PropertyHelper.m21263a(scrollableItemListFeedUnit) == null) {
            m26979a(scrollableItemListFeedUnit, 0);
        }
        return PropertyHelper.m21261a((Object) scrollableItemListFeedUnit).f14850G;
    }

    @Nullable
    public static ArrayNode m26982c(ScrollableItemListFeedUnit scrollableItemListFeedUnit) {
        if (PropertyHelper.m21263a(scrollableItemListFeedUnit) == null) {
            m26979a(scrollableItemListFeedUnit, 0);
        }
        return PropertyHelper.m21261a((Object) scrollableItemListFeedUnit).f14851H;
    }

    @Nullable
    private static SponsoredImpression m26977a(Object obj) {
        if (obj == null || !(obj instanceof HasSponsoredImpression)) {
            return null;
        }
        return ((HasSponsoredImpression) obj).ab_();
    }

    @Nullable
    private static ArrayNode m26978a(HasTracking hasTracking, Object obj) {
        if (obj == null || !(obj instanceof HasTracking)) {
            return null;
        }
        return GraphQLHelper.m22468a((HasTracking) obj, hasTracking);
    }
}
