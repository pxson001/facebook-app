package com.facebook.messaging.business.airline.view;

import android.content.Context;
import android.view.View;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsInterfaces.AirlineBoardingPass;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsInterfaces.AirlineBoardingPassBubble;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsModels.AirlineBoardingPassModel;
import com.facebook.messaging.model.messages.Message;
import com.facebook.ui.recyclablepager.PagerViewType;
import com.facebook.ui.recyclablepager.RecyclablePagerAdapter;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.RecyclableView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: thread_id=? and type=? and date>=? */
public class AirlineBoardingPassAdapter extends RecyclablePagerAdapter<AirlineBoardingPass> {
    private final PagerViewType f1547a = new C02561(this);
    public ImmutableList<? extends AirlineBoardingPass> f1548b = RegularImmutableList.a;
    @Nullable
    public AirlineBoardingPassBubble f1549c;
    @Nullable
    public Message f1550d;

    /* compiled from: thread_id=? and type=? and date>=? */
    class C02561 implements PagerViewType {
        final /* synthetic */ AirlineBoardingPassAdapter f1544a;

        C02561(AirlineBoardingPassAdapter airlineBoardingPassAdapter) {
            this.f1544a = airlineBoardingPassAdapter;
        }

        public final Class m1550a() {
            return ViewHolder.class;
        }

        public final View m1549a(Context context) {
            return new ViewHolder(context);
        }
    }

    /* compiled from: thread_id=? and type=? and date>=? */
    public class ViewHolder extends CustomFrameLayout implements RecyclableView {
        public final AirlineBoardingPassDetailView f1545a = ((AirlineBoardingPassDetailView) c(2131559480));
        public boolean f1546b;

        public ViewHolder(Context context) {
            super(context);
            setContentView(2130903204);
        }

        protected void onAttachedToWindow() {
            int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1129313758);
            super.onAttachedToWindow();
            this.f1546b = true;
            Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1270250024, a);
        }

        protected void onDetachedFromWindow() {
            int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1297857936);
            super.onDetachedFromWindow();
            this.f1546b = false;
            Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1770153894, a);
        }

        public final boolean m1551a() {
            return this.f1546b;
        }
    }

    protected final void m1553a(View view, Object obj, int i) {
        AirlineBoardingPassModel airlineBoardingPassModel = (AirlineBoardingPassModel) obj;
        AirlineBoardingPassDetailView airlineBoardingPassDetailView = ((ViewHolder) view).f1545a;
        airlineBoardingPassDetailView.m1566a(this.f1549c);
        airlineBoardingPassDetailView.m1567a(airlineBoardingPassModel);
        airlineBoardingPassDetailView.m1568a(this.f1550d);
    }

    @Inject
    public AirlineBoardingPassAdapter(RecyclableViewPoolManager recyclableViewPoolManager) {
        super(recyclableViewPoolManager);
    }

    protected final PagerViewType m1552a(int i) {
        return this.f1547a;
    }

    protected final Object m1555b(int i) {
        return (AirlineBoardingPassModel) this.f1548b.get(i);
    }

    public final int m1554b() {
        return this.f1548b.size();
    }
}
