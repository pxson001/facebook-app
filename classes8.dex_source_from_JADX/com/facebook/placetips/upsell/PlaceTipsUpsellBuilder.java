package com.facebook.placetips.upsell;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feedplugins.placetips.PlaceTipsFeedAdapter$10;
import com.facebook.feedplugins.placetips.PlaceTipsFeedAdapter$9;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: canceled */
public class PlaceTipsUpsellBuilder {
    private final Context f18498a;
    private final SecureContextHelper f18499b;
    private final UriIntentMapper f18500c;
    public final List<UpsellPageConfig> f18501d = new ArrayList();
    public String f18502e;
    @Nullable
    public PlaceTipsFeedAdapter$10 f18503f;
    @Nullable
    public PlaceTipsFeedAdapter$9 f18504g;

    @Inject
    public PlaceTipsUpsellBuilder(Context context, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper) {
        this.f18498a = context;
        this.f18499b = secureContextHelper;
        this.f18500c = uriIntentMapper;
    }

    public final void m22418a(FragmentManager fragmentManager, String str) {
        PlaceTipsUpsellContainerFragment placeTipsUpsellContainerFragment = new PlaceTipsUpsellContainerFragment();
        Parcelable upsellFragmentParams = new UpsellFragmentParams(ImmutableList.copyOf(this.f18501d), this.f18502e);
        Bundle bundle = new Bundle();
        bundle.putParcelable("upsell_params", upsellFragmentParams);
        placeTipsUpsellContainerFragment.g(bundle);
        placeTipsUpsellContainerFragment.ar = this.f18503f;
        placeTipsUpsellContainerFragment.as = this.f18504g;
        placeTipsUpsellContainerFragment.a(fragmentManager, str);
    }
}
