package com.facebook.composer.location;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass73;
import com.facebook.composer.inlinesproutsinterfaces.InlineSproutItem;
import com.facebook.feed.util.composer.sprout.SproutSpec;
import com.facebook.feed.util.composer.sprout.SproutSpec.Builder;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsCheckinSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.model.ComposerLocationInfo;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.places.checkin.analytics.LightweightPlacePickerAnalytics;
import com.facebook.places.checkin.lightweight.LightweightPlacePickerAdapter;
import com.facebook.qe.api.QeAccessor;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

/* compiled from: fundraiser_campaign_donation_create */
public class LocationLightweightPickerSproutItem<DataProvider extends ProvidesIsCheckinSupported & ProvidesSessionId & ProvidesLocationInfo> implements InlineSproutItem {
    public final WeakReference<DataProvider> f6687a;
    private final SproutSpec f6688b;
    public final Context f6689c;
    public final AnonymousClass73 f6690d;
    public final LightweightPlacePickerAnalytics f6691e;
    public final QeAccessor f6692f;
    public boolean f6693g;

    /* compiled from: fundraiser_campaign_donation_create */
    public class ViewProvider {
        public final /* synthetic */ LocationLightweightPickerSproutItem f6685a;
        private final LightweightPlacePickerAdapter f6686b = new LightweightPlacePickerAdapter(new C08471(this));

        /* compiled from: fundraiser_campaign_donation_create */
        public class C08471 {
            public final /* synthetic */ ViewProvider f6683a;

            C08471(ViewProvider viewProvider) {
                this.f6683a = viewProvider;
            }
        }

        /* compiled from: fundraiser_campaign_donation_create */
        class C08482 extends OnScrollListener {
            final /* synthetic */ ViewProvider f6684a;

            C08482(ViewProvider viewProvider) {
                this.f6684a = viewProvider;
            }

            public final void m8105a(RecyclerView recyclerView, int i) {
                super.a(recyclerView, i);
                if (i == 2 && !this.f6684a.f6685a.f6693g) {
                    LocationLightweightPickerSproutItem.m8107a(this.f6684a.f6685a, "lightweight_place_picker_first_scroll");
                    this.f6684a.f6685a.f6693g = true;
                }
            }
        }

        public ViewProvider(LocationLightweightPickerSproutItem locationLightweightPickerSproutItem) {
            this.f6685a = locationLightweightPickerSproutItem;
        }

        public final View m8106a(View view, ViewGroup viewGroup) {
            if (view != null) {
                return view;
            }
            LocationLightweightPickerSproutItem.m8107a(this.f6685a, "lightweight_place_picker_started");
            view = new BetterRecyclerView(this.f6685a.f6689c);
            view.setLayoutParams(new LayoutParams(-1, 80));
            viewGroup.getContext();
            view.setLayoutManager(new LinearLayoutManager(0, false));
            ImmutableList g = ((ProvidesLocationInfo) ((ComposerDataProviderImpl) Preconditions.checkNotNull(this.f6685a.f6687a.get()))).g().g();
            this.f6686b.m11083a(g.subList(0, Math.min(g.size(), this.f6685a.f6692f.a(ExperimentsForComposerAbTestModule.J, 15))));
            view.setAdapter(this.f6686b);
            view.setOnScrollListener(new C08482(this));
            return view;
        }
    }

    @Inject
    public LocationLightweightPickerSproutItem(@Assisted DataProvider dataProvider, @Assisted Listener listener, Context context, LightweightPlacePickerAnalytics lightweightPlacePickerAnalytics, QeAccessor qeAccessor) {
        this.f6687a = new WeakReference(dataProvider);
        this.f6690d = listener;
        this.f6689c = context;
        this.f6691e = lightweightPlacePickerAnalytics;
        this.f6692f = qeAccessor;
        ViewProvider viewProvider = new ViewProvider(this);
        Builder builder = new Builder(0, 0, "", "location_lightweight_picker_sprout", null, (byte) 0);
        builder.k = viewProvider;
        this.f6688b = builder.a();
    }

    public static void m8107a(LocationLightweightPickerSproutItem locationLightweightPickerSproutItem, String str) {
        ComposerDataProviderImpl composerDataProviderImpl = (ComposerDataProviderImpl) Preconditions.checkNotNull(locationLightweightPickerSproutItem.f6687a.get());
        ComposerLocationInfo g = ((ProvidesLocationInfo) composerDataProviderImpl).g();
        locationLightweightPickerSproutItem.f6691e.a(str, ((ProvidesSessionId) composerDataProviderImpl).ab(), g.h(), g.i(), g.g());
    }

    public final SproutSpec mo205a() {
        return this.f6688b;
    }

    public final boolean mo206b() {
        ComposerDataProviderImpl composerDataProviderImpl = (ComposerDataProviderImpl) Preconditions.checkNotNull(this.f6687a.get());
        return composerDataProviderImpl.m7400A() && ((ProvidesLocationInfo) composerDataProviderImpl).g() != null && ((ProvidesLocationInfo) composerDataProviderImpl).g().g() != null && !((ProvidesLocationInfo) composerDataProviderImpl).g().g().isEmpty() && ((ProvidesLocationInfo) composerDataProviderImpl).g().a() == null && this.f6692f.a(ExperimentsForComposerAbTestModule.I, false);
    }

    public final boolean mo207c() {
        return ((ProvidesLocationInfo) ((ComposerDataProviderImpl) Preconditions.checkNotNull(this.f6687a.get()))).g().a() != null;
    }

    public final boolean mo208d() {
        return false;
    }

    public final boolean mo209e() {
        return false;
    }

    public final String mo210f() {
        return "";
    }
}
