package com.facebook.messaging.business.airline.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.airline.utils.AirlineColorUtil;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment.EventListener;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsInterfaces.AirlineBoardingPassBubble;
import com.facebook.messaging.model.messages.Message;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.CustomViewPager;
import com.facebook.widget.viewpageindicator.CirclePageIndicator;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: thread_id=? and type=? */
public class AirlineBoardingPassDetailFragment extends FbFragment implements BusinessActivityFragment {
    @Inject
    AirlineBoardingPassAdapter f1551a;
    @Inject
    AirlineColorUtil f1552b;
    private Message f1553c;
    private AirlineBoardingPassBubble f1554d;
    @Nullable
    private EventListener f1555e;

    public final void m1558a(Parcelable parcelable) {
        this.f1554d = (AirlineBoardingPassBubble) FlatBufferModelHelper.a((Bundle) parcelable, "boarding_pass_data");
        this.f1553c = (Message) ((Bundle) parcelable).getParcelable("message");
    }

    public final String m1557a(Context context) {
        return context.getString(2131241161);
    }

    public final void m1560a(EventListener eventListener) {
        this.f1555e = eventListener;
    }

    public final void m1561c(Bundle bundle) {
        super.c(bundle);
        FbInjector.a(AirlineBoardingPassDetailFragment.class, this);
    }

    public final View m1556a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1347964515);
        View inflate = layoutInflater.inflate(2130903202, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -671012296, a);
        return inflate;
    }

    public final void m1559a(View view, Bundle bundle) {
        super.a(view, bundle);
        if (this.f1554d.V() == null) {
            o().kO_().a().a(this).b();
            return;
        }
        int b;
        CustomRelativeLayout customRelativeLayout = (CustomRelativeLayout) e(2131559472);
        CustomViewPager customViewPager = (CustomViewPager) e(2131559473);
        CirclePageIndicator circlePageIndicator = (CirclePageIndicator) e(2131559474);
        customViewPager.setAdapter(this.f1551a);
        circlePageIndicator.setViewPager(customViewPager);
        AirlineBoardingPassAdapter airlineBoardingPassAdapter = this.f1551a;
        AirlineBoardingPassBubble airlineBoardingPassBubble = this.f1554d;
        Preconditions.checkNotNull(airlineBoardingPassBubble.V());
        airlineBoardingPassAdapter.f1549c = airlineBoardingPassBubble;
        airlineBoardingPassAdapter.f1548b = airlineBoardingPassBubble.V().a();
        this.f1551a.f1550d = this.f1553c;
        this.f1551a.kR_();
        AirlineColorUtil airlineColorUtil = this.f1552b;
        String bq = this.f1554d.bq();
        if (Strings.isNullOrEmpty(bq)) {
            b = ContextCompat.b(airlineColorUtil.f1538a, 2131363824);
        } else {
            b = Color.parseColor(AirlineColorUtil.m1546b(bq));
        }
        int i = b;
        customRelativeLayout.setBackgroundColor(i);
        circlePageIndicator.setFillColor(i);
        circlePageIndicator.setVisibility(this.f1554d.V().a().size() <= 1 ? 8 : 0);
    }
}
