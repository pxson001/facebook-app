package com.facebook.pages.identity.cards.events;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.TextView;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.ActionSource;
import com.facebook.events.model.EventsCollection;
import com.facebook.events.mutators.SubscribeToPageEventsMutator;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.graphql.calls.ProfileSetEventsCalendarSubscriptionStatusInputData.SubscriptionStatus;
import com.facebook.graphql.enums.GraphQLEventsCalendarSubscriptionStatus;
import com.facebook.graphql.model.GraphQLEvent;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.intent_builder.DefaultPageSurfaceIntentBuilder;
import com.facebook.pages.common.intent_builder.IPageIdentityIntentBuilder;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventBus;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.EventsSubscribeStatusChangedEvent;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: privacy_checkup_manager_composer_options_fetch_failed */
public class PageIdentityEventsCardController {
    public static final PrefKey f3476a = ((PrefKey) ((PrefKey) SharedPrefKeys.a.a("events/")).a("page_event_card_subscribe_calendar_nux"));
    public final long f3477b;
    public final String f3478c;
    public final boolean f3479d;
    public final Context f3480e;
    public final EventsCollection<GraphQLEvent> f3481f;
    public GraphQLEventsCalendarSubscriptionStatus f3482g;
    public TextView f3483h;
    public Tooltip f3484i;
    public int f3485j = -1;
    private final FbUriIntentHandler f3486k;
    private final PagesAnalytics f3487l;
    public final TipSeenTracker f3488m;
    public final PageScopedEventBus f3489n;
    public final SecureContextHelper f3490o;
    public final DefaultPageSurfaceIntentBuilder f3491p;
    public final SubscribeToPageEventsMutator f3492q;
    private final GlyphColorizer f3493r;
    public final OnScrollChangedListener f3494s = new C04721(this);
    public final Runnable f3495t = new C04732(this);

    /* compiled from: privacy_checkup_manager_composer_options_fetch_failed */
    class C04721 implements OnScrollChangedListener {
        final /* synthetic */ PageIdentityEventsCardController f3473a;

        C04721(PageIdentityEventsCardController pageIdentityEventsCardController) {
            this.f3473a = pageIdentityEventsCardController;
        }

        public void onScrollChanged() {
            this.f3473a.f3483h.removeCallbacks(this.f3473a.f3495t);
            PageIdentityEventsCardController pageIdentityEventsCardController = this.f3473a;
            View view = this.f3473a.f3483h;
            int i = 1;
            if (pageIdentityEventsCardController.f3485j < 0) {
                pageIdentityEventsCardController.f3485j = view.getResources().getDisplayMetrics().heightPixels;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int height = iArr[1] + view.getHeight();
            if (iArr[1] <= 0 || height >= pageIdentityEventsCardController.f3485j) {
                i = 0;
            }
            if (i != 0) {
                this.f3473a.f3483h.postDelayed(this.f3473a.f3495t, 500);
            }
        }
    }

    /* compiled from: privacy_checkup_manager_composer_options_fetch_failed */
    class C04732 implements Runnable {
        final /* synthetic */ PageIdentityEventsCardController f3474a;

        C04732(PageIdentityEventsCardController pageIdentityEventsCardController) {
            this.f3474a = pageIdentityEventsCardController;
        }

        public void run() {
            this.f3474a.f3483h.getViewTreeObserver().removeOnScrollChangedListener(this.f3474a.f3494s);
            if ((this.f3474a.f3480e instanceof Activity) && !((Activity) this.f3474a.f3480e).isFinishing()) {
                this.f3474a.f3484i.f(this.f3474a.f3483h);
                this.f3474a.f3488m.a();
            }
        }
    }

    /* compiled from: privacy_checkup_manager_composer_options_fetch_failed */
    public class C04743 implements OnClickListener {
        final /* synthetic */ PageIdentityEventsCardController f3475a;

        public C04743(PageIdentityEventsCardController pageIdentityEventsCardController) {
            this.f3475a = pageIdentityEventsCardController;
        }

        public void onClick(View view) {
            SubscriptionStatus subscriptionStatus;
            int a = Logger.a(2, EntryType.UI_INPUT_START, 312623634);
            if (this.f3475a.f3482g == GraphQLEventsCalendarSubscriptionStatus.NONE) {
                subscriptionStatus = SubscriptionStatus.LOCAL;
                this.f3475a.f3482g = GraphQLEventsCalendarSubscriptionStatus.LOCAL;
            } else {
                subscriptionStatus = SubscriptionStatus.NONE;
                this.f3475a.f3482g = GraphQLEventsCalendarSubscriptionStatus.NONE;
            }
            this.f3475a.f3492q.a(String.valueOf(this.f3475a.f3477b), subscriptionStatus, ActionMechanism.PAGE_UPCOMING_EVENTS_CARD, "unknown", "pages_identity");
            this.f3475a.m4544a(this.f3475a.f3483h, this.f3475a.f3482g, this.f3475a.f3480e);
            this.f3475a.f3489n.a(new EventsSubscribeStatusChangedEvent(Long.valueOf(this.f3475a.f3477b), this.f3475a.f3482g));
            LogUtils.a(-1450971458, a);
        }
    }

    @Inject
    public PageIdentityEventsCardController(@Assisted Long l, @Assisted String str, @Assisted Boolean bool, @Assisted GraphQLEventsCalendarSubscriptionStatus graphQLEventsCalendarSubscriptionStatus, @Assisted ImmutableList<GraphQLEvent> immutableList, @Assisted Context context, FbUriIntentHandler fbUriIntentHandler, PagesAnalytics pagesAnalytics, TipSeenTracker tipSeenTracker, PageScopedEventBus pageScopedEventBus, SecureContextHelper secureContextHelper, IPageIdentityIntentBuilder iPageIdentityIntentBuilder, SubscribeToPageEventsMutator subscribeToPageEventsMutator, GlyphColorizer glyphColorizer) {
        this.f3477b = l.longValue();
        this.f3478c = str;
        this.f3479d = bool.booleanValue();
        this.f3482g = graphQLEventsCalendarSubscriptionStatus;
        this.f3481f = new EventsCollection(immutableList);
        this.f3480e = context;
        this.f3486k = fbUriIntentHandler;
        this.f3487l = pagesAnalytics;
        this.f3488m = tipSeenTracker;
        this.f3489n = pageScopedEventBus;
        this.f3490o = secureContextHelper;
        this.f3491p = iPageIdentityIntentBuilder;
        this.f3492q = subscribeToPageEventsMutator;
        this.f3493r = glyphColorizer;
    }

    private String m4542c(int i) {
        return ((GraphQLEvent) ((GraphQLPersistableNode) this.f3481f.b.get(i))).as();
    }

    public final void m4543a(int i) {
        String c = m4542c(i);
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.t, c);
        Bundle bundle = new Bundle();
        bundle.putParcelable("action_ref", ActionSource.PAGE_UPCOMING_EVENTS_CARD);
        this.f3486k.a(this.f3480e, formatStrLocaleSafe, bundle);
        this.f3487l.g(this.f3477b, c);
    }

    public final void m4545b(int i) {
        this.f3487l.f(this.f3477b, m4542c(i));
    }

    public final void m4544a(TextView textView, GraphQLEventsCalendarSubscriptionStatus graphQLEventsCalendarSubscriptionStatus, Context context) {
        CharSequence string;
        int color;
        Drawable a;
        if (graphQLEventsCalendarSubscriptionStatus == GraphQLEventsCalendarSubscriptionStatus.NONE) {
            string = context.getString(2131235479);
            color = context.getResources().getColor(2131361973);
            a = this.f3493r.a(2130839868, -7235677);
        } else {
            string = context.getString(2131235480);
            color = context.getResources().getColor(2131361917);
            a = this.f3493r.a(2130839868, -10972929);
        }
        textView.setText(string);
        textView.setTextColor(color);
        this.f3483h.setCompoundDrawablesWithIntrinsicBounds(a, null, null, null);
    }
}
