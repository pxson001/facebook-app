package com.facebook.marketplace.tab;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.fbreact.fragment.ImmersiveReactFragment;
import com.facebook.inject.InjectorLike;
import com.facebook.marketplace.tab.fragment.MarketplaceHomeFragment;
import com.facebook.marketplace.tab.fragment.MarketplaceHomeFragment.Builder;
import com.google.common.base.Strings;

/* compiled from: discNumber */
public class MarketplaceTabFragmentFactory implements IFragmentFactory {
    public static MarketplaceTabFragmentFactory m17720a(InjectorLike injectorLike) {
        return new MarketplaceTabFragmentFactory();
    }

    public final Fragment m17721a(Intent intent) {
        if (intent == null || Strings.isNullOrEmpty(intent.getStringExtra("ReactRouteName")) || Strings.isNullOrEmpty(intent.getStringExtra("ReactURI"))) {
            Builder newBuilder = MarketplaceHomeFragment.newBuilder();
            newBuilder.b = "LocalSellHomeRoute";
            ImmersiveReactFragment.Builder builder = newBuilder;
            builder.a = "/localsell_home";
            builder = builder;
            builder.h = 1;
            return builder.b();
        }
        Builder newBuilder2 = MarketplaceHomeFragment.newBuilder();
        newBuilder2.b = intent.getStringExtra("ReactRouteName");
        ImmersiveReactFragment.Builder builder2 = newBuilder2;
        builder2.a = "/" + intent.getStringExtra("ReactURI");
        builder2 = builder2;
        builder2.h = 1;
        return builder2.b();
    }
}
