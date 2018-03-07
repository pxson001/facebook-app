package com.facebook.pages.common.surface.ui.metabox;

import android.content.Context;
import android.os.ParcelUuid;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.common.locale.Locales;
import com.facebook.graphql.enums.GraphQLPageOpenHoursDisplayDecisionEnum;
import com.facebook.graphql.enums.GraphQLPagePresenceTabType;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.abtest.qe.PagesExperimentUtils;
import com.facebook.pages.common.eventbus.PageEventBus;
import com.facebook.pages.common.eventbus.PageEvents.PagesSurfaceSwitchToTabEvent;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventBus;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.PageFragmentScopedHeaderPerfLoggingEvent;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.PageFragmentScopedHeaderPerfLoggingEvent.HeaderPerfLoggingEventType;
import com.facebook.pages.common.surface.ui.metabox.PagesMetaboxViewModel.MetaboxTopRowState;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.reviews.util.helper.ReviewsRatingHelper;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.OnDispatchDrawListener;
import com.facebook.widget.ratingbar.FractionalRatingBar;
import com.google.common.base.Absent;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: region_north_latitude */
public class PagesMetaboxView extends CustomLinearLayout {
    @Inject
    PagesMetaboxController f2662a;
    @Inject
    PageScopedEventBus f2663b;
    @Inject
    PageEventBus f2664c;
    private TextView f2665d;
    private View f2666e;
    private TextView f2667f;
    private TextView f2668g;
    private FractionalRatingBar f2669h;
    private TextView f2670i;
    private PagesMetaboxViewModel f2671j;
    public boolean f2672k = false;
    public ParcelUuid f2673l;
    private OnClickListener f2674m;
    private OnClickListener f2675n;

    /* compiled from: region_north_latitude */
    class C03531 implements OnClickListener {
        final /* synthetic */ PagesMetaboxView f2658a;

        C03531(PagesMetaboxView pagesMetaboxView) {
            this.f2658a = pagesMetaboxView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -519230959);
            this.f2658a.f2664c.a(new PagesSurfaceSwitchToTabEvent(GraphQLPagePresenceTabType.REVIEWS));
            Logger.a(2, EntryType.UI_INPUT_END, -2032342473, a);
        }
    }

    /* compiled from: region_north_latitude */
    class C03542 implements OnClickListener {
        final /* synthetic */ PagesMetaboxView f2659a;

        C03542(PagesMetaboxView pagesMetaboxView) {
            this.f2659a = pagesMetaboxView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1890190155);
            this.f2659a.f2664c.a(new PagesSurfaceSwitchToTabEvent(GraphQLPagePresenceTabType.ABOUT));
            Logger.a(2, EntryType.UI_INPUT_END, 1933102014, a);
        }
    }

    /* compiled from: region_north_latitude */
    class C03553 implements OnDispatchDrawListener {
        final /* synthetic */ PagesMetaboxView f2660a;

        C03553(PagesMetaboxView pagesMetaboxView) {
            this.f2660a = pagesMetaboxView;
        }

        public final boolean m3617a() {
            if (!this.f2660a.f2672k || this.f2660a.f2673l == null) {
                return false;
            }
            this.f2660a.f2663b.a(new PageFragmentScopedHeaderPerfLoggingEvent(this.f2660a.f2673l, HeaderPerfLoggingEventType.METABAX, Absent.INSTANCE));
            return true;
        }
    }

    /* compiled from: region_north_latitude */
    /* synthetic */ class C03564 {
        static final /* synthetic */ int[] f2661a = new int[GraphQLPageOpenHoursDisplayDecisionEnum.values().length];

        static {
            try {
                f2661a[GraphQLPageOpenHoursDisplayDecisionEnum.SHOW_AVAILABLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2661a[GraphQLPageOpenHoursDisplayDecisionEnum.SHOW_UNAVAILABLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2661a[GraphQLPageOpenHoursDisplayDecisionEnum.SHOW_UNDETERMINED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private static <T extends View> void m3620a(Class<T> cls, T t) {
        m3621a((Object) t, t.getContext());
    }

    private static void m3621a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PagesMetaboxView) obj).m3619a(new PagesMetaboxController(ReviewsRatingHelper.a(fbInjector), Locales.a(fbInjector), PagesExperimentUtils.a(fbInjector)), PageScopedEventBus.a(fbInjector), PageEventBus.m2423a(fbInjector));
    }

    private void m3619a(PagesMetaboxController pagesMetaboxController, PageScopedEventBus pageScopedEventBus, PageEventBus pageEventBus) {
        this.f2662a = pagesMetaboxController;
        this.f2663b = pageScopedEventBus;
        this.f2664c = pageEventBus;
    }

    public PagesMetaboxView(Context context) {
        super(context);
        m3618a();
    }

    public PagesMetaboxView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m3618a();
    }

    public PagesMetaboxView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3618a();
    }

    private void m3618a() {
        m3620a(PagesMetaboxView.class, (View) this);
        setContentView(2130906119);
        setOrientation(1);
        this.f2665d = (TextView) a(2131565726);
        this.f2666e = a(2131565721);
        this.f2667f = (TextView) a(2131565722);
        this.f2669h = (FractionalRatingBar) a(2131565723);
        this.f2668g = (TextView) a(2131565724);
        this.f2670i = (TextView) a(2131565725);
        this.f2674m = new C03531(this);
        this.f2675n = new C03542(this);
        CustomViewUtils.b(this, ContextCompat.a(getContext(), 2130842524));
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131427425);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(2131427427);
        setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
        m3624b();
    }

    public final void m3625a(PageHeaderData pageHeaderData) {
        this.f2671j = this.f2662a.m3616a(pageHeaderData);
        this.f2672k = true;
        this.f2665d.setText(this.f2671j.f2676a);
        if (this.f2671j.f2677b == MetaboxTopRowState.HIDDEN) {
            this.f2666e.setVisibility(8);
            return;
        }
        this.f2666e.setVisibility(0);
        if (this.f2671j.f2677b == MetaboxTopRowState.RATING_AND_OPEN_HOURS || this.f2671j.f2677b == MetaboxTopRowState.RATING_ONLY) {
            this.f2669h.setRating(this.f2671j.f2678c);
            this.f2667f.setText(this.f2671j.f2681f);
            this.f2667f.setVisibility(0);
            this.f2669h.setVisibility(0);
            if (this.f2671j.f2684i) {
                this.f2667f.setOnClickListener(this.f2674m);
                this.f2669h.setOnClickListener(this.f2674m);
                this.f2668g.setOnClickListener(this.f2674m);
            }
            if (this.f2671j.f2680e) {
                this.f2668g.setText("(" + this.f2671j.f2679d + ")");
                this.f2668g.setVisibility(0);
            } else {
                this.f2668g.setVisibility(8);
            }
        } else {
            this.f2667f.setVisibility(8);
            this.f2669h.setVisibility(8);
        }
        if (this.f2671j.f2677b == MetaboxTopRowState.RATING_AND_OPEN_HOURS || this.f2671j.f2677b == MetaboxTopRowState.OPEN_HOURS_ONLY) {
            this.f2670i.setText(this.f2671j.f2682g);
            switch (C03564.f2661a[this.f2671j.f2683h.ordinal()]) {
                case 1:
                    this.f2670i.setTextColor(getResources().getColor(2131362986));
                    break;
                case 2:
                    this.f2670i.setTextColor(getResources().getColor(2131362987));
                    break;
                case 3:
                    this.f2670i.setTextColor(getResources().getColor(2131362988));
                    break;
            }
            this.f2670i.setVisibility(0);
            if (this.f2671j.f2684i) {
                this.f2670i.setOnClickListener(this.f2675n);
                return;
            }
            return;
        }
        this.f2670i.setVisibility(8);
    }

    public void setLoggingUuid(ParcelUuid parcelUuid) {
        this.f2673l = parcelUuid;
    }

    private void m3624b() {
        a(new C03553(this));
    }
}
