package com.facebook.messaging.events.banner;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.calls.LightweightEventRsvpInputData.GuestListState;
import com.facebook.graphql.enums.GraphQLLightweightEventGuestStatus;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.events.abtest.LightweightEventsGatekeepers;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadEventReminder;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: stale_time_seconds */
public class EventReminderBannerView extends CustomLinearLayout {
    public ThreadEventReminder f2281a;
    public ThreadKey f2282b;
    @Nullable
    public EventReminderMembers f2283c;
    public CustomLinearLayout f2284d;
    public CustomLinearLayout f2285e;
    public BetterTextView f2286f;
    public BetterTextView f2287g;
    public BetterTextView f2288h;
    public BetterTextView f2289i;
    @Inject
    public LightweightEventsGatekeepers f2290j;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<EventReminderMutator> f2291k = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<SecureContextHelper> f2292l = UltralightRuntime.b;
    @Inject
    public EventRemindersUtil f2293m;

    /* compiled from: stale_time_seconds */
    public class C03791 implements OnClickListener {
        final /* synthetic */ EventReminderBannerView f2278a;

        public C03791(EventReminderBannerView eventReminderBannerView) {
            this.f2278a = eventReminderBannerView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1575860356);
            Context context = this.f2278a.getContext();
            ThreadEventReminder threadEventReminder = this.f2278a.f2281a;
            ThreadKey threadKey = this.f2278a.f2282b;
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(threadEventReminder);
            Preconditions.checkNotNull(threadKey);
            ((SecureContextHelper) this.f2278a.f2292l.get()).a(new Intent(context, EventReminderSettingsActivity.class).putExtra("thread_event_reminder_model_extra", threadEventReminder).putExtra("thread_key_extra", threadKey), this.f2278a.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, 1021182138, a);
        }
    }

    /* compiled from: stale_time_seconds */
    class C03802 implements OnClickListener {
        final /* synthetic */ EventReminderBannerView f2279a;

        C03802(EventReminderBannerView eventReminderBannerView) {
            this.f2279a = eventReminderBannerView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1327944650);
            ((EventReminderMutator) this.f2279a.f2291k.get()).m2189a(this.f2279a.f2281a.a, GuestListState.GOING);
            EventReminderBannerView.m2157d(this.f2279a);
            Logger.a(2, EntryType.UI_INPUT_END, -1500874155, a);
        }
    }

    /* compiled from: stale_time_seconds */
    class C03813 implements OnClickListener {
        final /* synthetic */ EventReminderBannerView f2280a;

        C03813(EventReminderBannerView eventReminderBannerView) {
            this.f2280a = eventReminderBannerView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1233420310);
            ((EventReminderMutator) this.f2280a.f2291k.get()).m2189a(this.f2280a.f2281a.a, GuestListState.DECLINED);
            EventReminderBannerView.m2157d(this.f2280a);
            Logger.a(2, EntryType.UI_INPUT_END, 545384788, a);
        }
    }

    public static void m2155a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        EventReminderBannerView eventReminderBannerView = (EventReminderBannerView) obj;
        LightweightEventsGatekeepers b = LightweightEventsGatekeepers.m2154b(fbInjector);
        com.facebook.inject.Lazy a = IdBasedLazy.a(fbInjector, 7852);
        com.facebook.inject.Lazy b2 = IdBasedSingletonScopeProvider.b(fbInjector, 968);
        EventRemindersUtil b3 = EventRemindersUtil.m2207b(fbInjector);
        eventReminderBannerView.f2290j = b;
        eventReminderBannerView.f2291k = a;
        eventReminderBannerView.f2292l = b2;
        eventReminderBannerView.f2293m = b3;
    }

    public EventReminderBannerView(Context context) {
        super(context);
        Class cls = EventReminderBannerView.class;
        m2155a(this, getContext());
        setContentView(2130904093);
        setOrientation(1);
        this.f2284d = (CustomLinearLayout) a(2131561379);
        this.f2286f = (BetterTextView) a(2131561380);
        this.f2285e = (CustomLinearLayout) a(2131561382);
        this.f2287g = (BetterTextView) a(2131561381);
        this.f2288h = (BetterTextView) a(2131561383);
        this.f2289i = (BetterTextView) a(2131561384);
    }

    public final void m2158a(ThreadEventReminder threadEventReminder, ThreadKey threadKey, @Nullable EventReminderMembers eventReminderMembers) {
        this.f2281a = threadEventReminder;
        this.f2282b = threadKey;
        this.f2283c = eventReminderMembers;
        if (this.f2283c != null && this.f2290j.f2277a.a(252, false)) {
            this.f2286f.setOnClickListener(new C03791(this));
            if (!this.f2293m.m2208b(this.f2282b, this.f2281a, this.f2283c) || this.f2283c.f2310b.isEmpty()) {
                this.f2287g.setVisibility(8);
            } else {
                int size = this.f2283c.f2310b.size();
                this.f2287g.setText(getResources().getQuantityString(2131689791, size, new Object[]{Integer.valueOf(size)}));
                this.f2287g.setVisibility(0);
            }
        }
        m2156c();
    }

    private void m2156c() {
        Object obj;
        EventRemindersUtil eventRemindersUtil = this.f2293m;
        ThreadKey threadKey = this.f2282b;
        ThreadEventReminder threadEventReminder = this.f2281a;
        EventReminderMembers eventReminderMembers = this.f2283c;
        if (!eventRemindersUtil.m2208b(threadKey, threadEventReminder, eventReminderMembers) || eventReminderMembers.f2309a == GraphQLLightweightEventGuestStatus.GOING || eventReminderMembers.f2309a == GraphQLLightweightEventGuestStatus.DECLINED) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            m2157d(this);
            return;
        }
        this.f2285e.setVisibility(0);
        this.f2284d.setBackgroundResource(2130839519);
        this.f2288h.setOnClickListener(new C03802(this));
        this.f2289i.setOnClickListener(new C03813(this));
    }

    public static void m2157d(EventReminderBannerView eventReminderBannerView) {
        eventReminderBannerView.f2285e.setVisibility(8);
        eventReminderBannerView.f2284d.setBackgroundResource(2130839518);
    }
}
