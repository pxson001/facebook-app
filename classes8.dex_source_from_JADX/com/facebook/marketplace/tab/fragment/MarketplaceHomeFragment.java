package com.facebook.marketplace.tab.fragment;

import android.content.Context;
import android.os.Bundle;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbreact.fragment.ImmersiveReactFragment;
import com.facebook.fbreact.interfaces.RCTViewEventEmitter;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.common.JewelCounters;
import com.facebook.notifications.common.JewelCounters.Jewel;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.GraphSearchQuery.ModifierKeys;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.facebook.search.api.GraphSearchQuery.ScopedSearchStyle;
import com.facebook.search.api.GraphSearchQueryProvider;
import javax.inject.Inject;

/* compiled from: disable_unit_tap */
public class MarketplaceHomeFragment extends ImmersiveReactFragment implements GraphSearchQueryProvider {
    private static final GraphSearchQuery f15282h;
    @Inject
    public JewelCounters f15283f;
    private boolean f15284g = false;

    /* compiled from: disable_unit_tap */
    public class Builder extends com.facebook.fbreact.fragment.ImmersiveReactFragment.Builder {
        protected final ImmersiveReactFragment m17722c() {
            return new MarketplaceHomeFragment();
        }
    }

    public static void m17723a(Object obj, Context context) {
        ((MarketplaceHomeFragment) obj).f15283f = JewelCounters.a(FbInjector.get(context));
    }

    static {
        GraphSearchQuery a = GraphSearchQuery.a(ScopedEntityType.MARKETPLACE, "", "", ScopedSearchStyle.TAB, true);
        f15282h = a;
        ModifierKeys modifierKeys = ModifierKeys.SCOPED_TAB;
        com.facebook.search.api.GraphSearchQueryTabModifier.Builder builder = new com.facebook.search.api.GraphSearchQueryTabModifier.Builder();
        builder.a = true;
        a.a(modifierKeys, builder.a());
    }

    public final void m17729g(boolean z) {
        super.g(z);
        if (!this.f15284g) {
            return;
        }
        if (z) {
            aw();
            m17724a("viewDidAppear");
            return;
        }
        ax();
        m17724a("viewDidDisappear");
    }

    public final void m17728c(Bundle bundle) {
        Class cls = MarketplaceHomeFragment.class;
        m17723a((Object) this, getContext());
        super.c(bundle);
    }

    public final void m17726G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 113281541);
        super.G();
        this.f15284g = true;
        m17724a("viewDidAppear");
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -350154799, a);
    }

    public final void m17727H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1112915837);
        super.H();
        this.f15284g = false;
        m17724a("viewDidDisappear");
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1648734371, a);
    }

    private void aw() {
        int a = this.f15283f.a(Jewel.MARKETPLACE);
        WritableMap b = Arguments.b();
        b.putInt("jewelBadgeCount", a);
        Object b2 = Arguments.b();
        b2.a("body", b);
        m17725a("MarketplaceTabDidAppear", b2);
    }

    private void ax() {
        m17725a("MarketplaceTabDidDisappear", null);
    }

    public final boolean O_() {
        return false;
    }

    private void m17724a(String str) {
        ReactContext as = as();
        if (as != null) {
            ReactRootView reactRootView = this.am;
            if (reactRootView != null) {
                ((RCTViewEventEmitter) as.a(RCTViewEventEmitter.class)).emit(StringFormatUtil.formatStrLocaleSafe("%d/%s", Integer.valueOf(reactRootView.getId()), str), null);
            }
        }
    }

    private void m17725a(String str, Object obj) {
        ReactContext as = as();
        if (as != null && this.am != null) {
            ((RCTNativeAppEventEmitter) as.a(RCTNativeAppEventEmitter.class)).emit(str, obj);
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public final GraphSearchQuery m17730q() {
        return f15282h;
    }

    public final int av() {
        ReactRootView reactRootView = this.am;
        return reactRootView != null ? reactRootView.getId() : 0;
    }
}
