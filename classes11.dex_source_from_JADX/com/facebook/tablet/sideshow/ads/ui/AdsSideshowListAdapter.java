package com.facebook.tablet.sideshow.ads.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.renderer.spannable.NativeThirdPartyUriClickHandler;
import com.facebook.tablet.sideshow.ads.model.AppAdsSideshowDataHolder;
import com.facebook.tablet.sideshow.ads.model.AppAdsSideshowRow;
import com.facebook.tablet.sideshow.analytics.SideshowAnalyticsLogger;
import com.facebook.tablet.sideshow.widget.SideShowExpandableListAdapter;
import com.facebook.tablet.sideshow.widget.SideshowExpandableListView;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: onStickerSelect */
public class AdsSideshowListAdapter extends SideShowExpandableListAdapter {
    private final Context f4666a;
    public AppAdsSideshowDataHolder f4667b;
    private final Provider<FbDraweeControllerBuilder> f4668c;
    private final AnalyticsLogger f4669d;
    private final FbUriIntentHandler f4670e;
    private final NewsFeedAnalyticsEventBuilder f4671f;
    private final SideshowAnalyticsLogger f4672g;
    private final NativeThirdPartyUriClickHandler f4673h;
    public SideshowExpandableListView f4674i;

    public /* synthetic */ Object getItem(int i) {
        return m5863a(i);
    }

    @Inject
    public AdsSideshowListAdapter(Context context, Provider<FbDraweeControllerBuilder> provider, AnalyticsLogger analyticsLogger, FbUriIntentHandler fbUriIntentHandler, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, SideshowAnalyticsLogger sideshowAnalyticsLogger, NativeThirdPartyUriClickHandler nativeThirdPartyUriClickHandler) {
        this.f4666a = context;
        this.f4668c = provider;
        this.f4669d = analyticsLogger;
        this.f4670e = fbUriIntentHandler;
        this.f4671f = newsFeedAnalyticsEventBuilder;
        this.f4672g = sideshowAnalyticsLogger;
        this.f4673h = nativeThirdPartyUriClickHandler;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (i < this.f4667b.f4648e) {
            return m5860a(i, view, viewGroup);
        }
        return null;
    }

    private View m5860a(int i, View view, ViewGroup viewGroup) {
        View appAdsSideshowRowView;
        AppAdsSideshowRow b = m5861b(i);
        if (view == null) {
            appAdsSideshowRowView = new AppAdsSideshowRowView(viewGroup.getContext(), this.f4668c, this.f4669d, this.f4670e, this.f4671f, this.f4672g, this.f4673h, this.f4674i, this);
        } else {
            appAdsSideshowRowView = view;
        }
        ((AppAdsSideshowRowView) appAdsSideshowRowView).m5865a(b);
        return appAdsSideshowRowView;
    }

    public final AppAdsSideshowRow m5863a(int i) {
        return m5861b(i);
    }

    private AppAdsSideshowRow m5861b(int i) {
        AppAdsSideshowRow appAdsSideshowRow;
        AppAdsSideshowDataHolder appAdsSideshowDataHolder = this.f4667b;
        if (appAdsSideshowDataHolder.f4647d == null || appAdsSideshowDataHolder.f4647d.size() <= i) {
            appAdsSideshowRow = null;
        } else {
            appAdsSideshowRow = (AppAdsSideshowRow) appAdsSideshowDataHolder.f4647d.get(i);
        }
        return appAdsSideshowRow;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getCount() {
        return this.f4667b.m5859e();
    }

    public final int m5862a() {
        return 2;
    }
}
