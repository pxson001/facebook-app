package com.facebook.events.dashboard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.data.EventsCommonContract;
import com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil;
import com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil.CalendarBucket;
import com.facebook.events.eventsevents.EventsEventBus;
import com.facebook.events.model.Event;
import com.facebook.events.model.EventViewerCapability;
import com.facebook.events.mutators.PublicEventsRsvpMutator;
import com.facebook.events.permalink.actionbar.ActionItemRsvp;
import com.facebook.events.socialcontext.EventSocialContextFormatter;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.google.android.googlequicksearchbox */
public class EventsDashboardRowView extends CustomLinearLayout {
    @Inject
    EventsDashboardTimeFormatUtil f16742a;
    @Inject
    InlineRsvpActionControllerProvider f16743b;
    @Inject
    EventSocialContextFormatter f16744c;
    private EventProfilePictureView f16745d;
    private FbTextView f16746e;
    private FbTextView f16747f;
    private FbTextView f16748g;
    private FbTextView f16749h;
    @Nullable
    public EventsDashboardRowInlineRsvpView f16750i;
    public EventsDashboardRowRsvpStatusView f16751j;
    private ImageBlockLayout f16752k;
    private int f16753l;
    public Event f16754m;
    private DashboardFilterType f16755n;
    @Nullable
    private InlineRsvpActionController f16756o;
    private EventAnalyticsParams f16757p;

    private static <T extends View> void m17137a(Class<T> cls, T t) {
        m17138a((Object) t, t.getContext());
    }

    private static void m17138a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EventsDashboardRowView) obj).m17136a(EventsDashboardTimeFormatUtil.a(fbInjector), (InlineRsvpActionControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(InlineRsvpActionControllerProvider.class), EventSocialContextFormatter.b(fbInjector));
    }

    public EventsDashboardRowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m17141b();
    }

    public EventsDashboardRowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17141b();
    }

    public EventsDashboardRowView(Context context) {
        super(context);
        m17141b();
    }

    private void m17141b() {
        m17137a(EventsDashboardRowView.class, (View) this);
        setContentView(2130904133);
        setOrientation(1);
        setBackgroundResource(2130843556);
        this.f16752k = (ImageBlockLayout) a(2131561518);
        this.f16745d = (EventProfilePictureView) a(2131561519);
        this.f16746e = (FbTextView) a(2131561520);
        this.f16747f = (FbTextView) a(2131561521);
        this.f16748g = (FbTextView) a(2131561522);
        this.f16749h = (FbTextView) a(2131561523);
        this.f16751j = (EventsDashboardRowRsvpStatusView) a(2131561524);
        this.f16753l = this.f16752k.w;
    }

    private void m17142c() {
        this.f16750i = (EventsDashboardRowInlineRsvpView) ((ViewStub) a(2131561525)).inflate();
        InjectorLike injectorLike = this.f16743b;
        this.f16756o = new InlineRsvpActionController(this, ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), ActionItemRsvp.m18397b(injectorLike), ContentResolverMethodAutoProvider.b(injectorLike), EventsCommonContract.b(injectorLike), PublicEventsRsvpMutator.b(injectorLike), EventsEventBus.a(injectorLike), TasksManager.b(injectorLike));
        this.f16750i.f16719l = this.f16756o;
    }

    public final void m17145a(Event event, boolean z, EventAnalyticsParams eventAnalyticsParams, DashboardFilterType dashboardFilterType, boolean z2) {
        m17146a(event, z, eventAnalyticsParams, dashboardFilterType, z2, false);
    }

    public final void m17146a(Event event, boolean z, EventAnalyticsParams eventAnalyticsParams, DashboardFilterType dashboardFilterType, boolean z2, boolean z3) {
        setFocusable(true);
        setClickable(true);
        if (this.f16756o != null) {
            Object obj;
            if (this.f16756o.f16955i != null) {
                obj = 1;
            } else {
                obj = null;
            }
            if (!(obj == null || this.f16754m == null || !Objects.equal(this.f16754m.a, event.a))) {
                return;
            }
        }
        this.f16755n = dashboardFilterType;
        if (this.f16756o != null) {
            this.f16756o.m17288b();
        }
        this.f16754m = event;
        if (m17140a(event)) {
            if (this.f16750i == null) {
                m17142c();
            }
            this.f16750i.setVisibility(0);
            this.f16750i.m17112a(this.f16754m);
        } else if (this.f16750i != null) {
            this.f16750i.setVisibility(8);
        }
        if (!this.f16754m.x || this.f16754m.a(EventViewerCapability.ADMIN)) {
            this.f16751j.setVisibility(0);
            this.f16751j.m17135a(event, this.f16751j.m17133a(event, z3), eventAnalyticsParams);
        } else {
            this.f16751j.setVisibility(8);
        }
        this.f16745d.m16936a(event);
        this.f16746e.setText(this.f16754m.b);
        this.f16746e.setContentDescription(this.f16754m.b);
        CharSequence a = this.f16742a.a(this.f16754m.M, this.f16754m.J(), this.f16754m.L(), false);
        this.f16747f.setText(a);
        this.f16747f.setContentDescription(a);
        m17143d();
        if (dashboardFilterType == null || dashboardFilterType != DashboardFilterType.PAST) {
            if (z) {
                this.f16749h.setVisibility(0);
                this.f16749h.setText(getResources().getString(2131237027));
                this.f16749h.setContentDescription(getResources().getString(2131237027));
            } else {
                a = this.f16744c.b(event);
                if (!StringUtil.a(a)) {
                    this.f16749h.setVisibility(0);
                    this.f16749h.setText(a);
                    this.f16749h.setContentDescription(a);
                    this.f16749h.setTextColor(getResources().getColor(event.y ? 2131361917 : 2131361974));
                }
            }
            this.f16748g.setVisibility(0);
            if (!StringUtil.a(event.P)) {
                this.f16748g.setText(event.P);
                this.f16748g.setContentDescription(event.P);
            } else if (StringUtil.a(event.Q)) {
                this.f16748g.setText(event.Q);
                this.f16748g.setContentDescription(event.Q);
            } else {
                this.f16748g.setVisibility(8);
            }
            m17139a(z2);
            this.f16757p = eventAnalyticsParams;
            if (this.f16756o != null) {
                this.f16756o.f16957k = this.f16757p;
            }
        }
        this.f16751j.setVisibility(8);
        this.f16749h.setVisibility(8);
        this.f16748g.setVisibility(0);
        if (!StringUtil.a(event.P)) {
            this.f16748g.setText(event.P);
            this.f16748g.setContentDescription(event.P);
        } else if (StringUtil.a(event.Q)) {
            this.f16748g.setVisibility(8);
        } else {
            this.f16748g.setText(event.Q);
            this.f16748g.setContentDescription(event.Q);
        }
        m17139a(z2);
        this.f16757p = eventAnalyticsParams;
        if (this.f16756o != null) {
            this.f16756o.f16957k = this.f16757p;
        }
    }

    public Event getEvent() {
        return this.f16754m;
    }

    private boolean m17140a(Event event) {
        boolean z = this.f16755n != null && this.f16755n == DashboardFilterType.PAST;
        return (z || event.a(EventViewerCapability.ADMIN) || !event.G || event.x) ? false : true;
    }

    @SuppressLint({"BadMethodUse-java.lang.System.currentTimeMillis"})
    private void m17143d() {
        this.f16747f.setTextColor(getContext().getResources().getColor(2131361974));
        if (this.f16755n == null || this.f16755n != DashboardFilterType.PAST) {
            CalendarBucket a = this.f16742a.a(this.f16754m.K(), System.currentTimeMillis());
            if (a == CalendarBucket.PAST || a == CalendarBucket.YESTERDAY || a == CalendarBucket.TODAY) {
                this.f16747f.setTextColor(getContext().getResources().getColor(2131361917));
            }
        }
    }

    private void m17139a(boolean z) {
        boolean z2;
        if (this.f16752k.w > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 != z) {
            int i;
            ImageBlockLayout imageBlockLayout = this.f16752k;
            if (z) {
                i = this.f16753l;
            } else {
                i = 0;
            }
            imageBlockLayout.a(0, i, 0, 0);
        }
    }

    @Nullable
    public EventsDashboardRowInlineRsvpView getInlineRsvpView() {
        return this.f16750i;
    }

    public EventsDashboardRowRsvpStatusView getRsvpStatusView() {
        return this.f16751j;
    }

    public final void m17144a() {
        this.f16749h.setVisibility(0);
        this.f16749h.setText(getResources().getString(2131237027));
    }

    private void m17136a(EventsDashboardTimeFormatUtil eventsDashboardTimeFormatUtil, InlineRsvpActionControllerProvider inlineRsvpActionControllerProvider, EventSocialContextFormatter eventSocialContextFormatter) {
        this.f16742a = eventsDashboardTimeFormatUtil;
        this.f16743b = inlineRsvpActionControllerProvider;
        this.f16744c = eventSocialContextFormatter;
    }
}
