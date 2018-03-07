package com.facebook.feed.util;

import android.os.Bundle;
import com.facebook.api.feed.SetHScrollUnitVisibleItemIndexParams;
import com.facebook.api.feed.data.FeedUnitDataController;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: phone_type */
public class HScrollUnitCacheUtils {
    protected final DefaultBlueServiceOperationFactory f10116a;
    private final FeedUnitDataController f10117b;
    private final boolean f10118c;

    public static HScrollUnitCacheUtils m15234b(InjectorLike injectorLike) {
        return new HScrollUnitCacheUtils(DefaultBlueServiceOperationFactory.m3782b(injectorLike), Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike).m2189a(676, false)), FeedUnitDataController.m14175a(injectorLike));
    }

    @Inject
    public HScrollUnitCacheUtils(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, Boolean bool, FeedUnitDataController feedUnitDataController) {
        this.f10116a = defaultBlueServiceOperationFactory;
        this.f10117b = feedUnitDataController;
        this.f10118c = bool.booleanValue();
    }

    public final ListenableFuture<OperationResult> m15235a(ScrollableItemListFeedUnit scrollableItemListFeedUnit, int i) {
        if (!this.f10118c) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("setHScrollUnitVisibleItemIndexKey", new SetHScrollUnitVisibleItemIndexParams(scrollableItemListFeedUnit.mo2507g(), scrollableItemListFeedUnit.getType().toString(), Integer.valueOf(i)));
        return BlueServiceOperationFactoryDetour.a(this.f10116a, "set_hscroll_unit_visible_item_index", bundle, ErrorPropagation.BY_ERROR_CODE, null, 1016194731).mo3452a();
    }

    public static HScrollUnitCacheUtils m15233a(InjectorLike injectorLike) {
        return m15234b(injectorLike);
    }

    public final void m15236a(FeedUnit feedUnit, int i) {
        this.f10117b.m14177a(feedUnit).f19502i = i;
    }
}
