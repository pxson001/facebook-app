package com.facebook.commerce.storefront.ui;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceProductSectionType;
import com.facebook.commerce.core.analytics.CommerceAnalyticsEventBuilder;
import com.facebook.commerce.core.intent.MerchantInfoViewData;
import com.facebook.commerce.core.util.CommerceNavigationUtil;
import com.facebook.commerce.storefront.adapters.CommerceProductAdapter;
import com.facebook.commerce.storefront.util.CollectionViewData;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: count_guest_statuses_loaded */
public class CollectionView extends CustomLinearLayout {
    @Inject
    public CommerceNavigationUtil f15767a;
    @Inject
    public AnalyticsLogger f15768b;
    public TextView f15769c = ((TextView) a(2131559636));
    public TextView f15770d = ((TextView) a(2131560461));
    public RecyclerView f15771e = ((RecyclerView) a(2131560462));
    public CommerceProductAdapter f15772f;
    public MerchantInfoViewData f15773g;
    public CollectionViewData f15774h;

    /* compiled from: count_guest_statuses_loaded */
    public class C21971 implements OnClickListener {
        final /* synthetic */ CollectionView f15766a;

        public C21971(CollectionView collectionView) {
            this.f15766a = collectionView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1093656674);
            this.f15766a.f15768b.a(CommerceAnalyticsEventBuilder.a(this.f15766a.f15774h.f15844a, Boolean.valueOf(false), CommerceProductSectionType.STOREFRONT_COLLECTION_HEADER));
            this.f15766a.f15767a.a(this.f15766a.f15774h.f15844a, this.f15766a.f15773g.e, null);
            Logger.a(2, EntryType.UI_INPUT_END, 1067852779, a);
        }
    }

    public static void m16257a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        CollectionView collectionView = (CollectionView) obj;
        CommerceNavigationUtil a = CommerceNavigationUtil.a(fbInjector);
        AnalyticsLogger a2 = AnalyticsLoggerMethodAutoProvider.a(fbInjector);
        collectionView.f15767a = a;
        collectionView.f15768b = a2;
    }

    public CollectionView(Context context) {
        super(context);
        Class cls = CollectionView.class;
        m16257a(this, getContext());
        setContentView(2130903641);
        setOrientation(1);
        getContext();
        this.f15771e.setLayoutManager(new LinearLayoutManager(0, false));
        this.f15772f = new CommerceProductAdapter(this.f15767a, this.f15768b);
        this.f15771e.setAdapter(this.f15772f);
    }
}
