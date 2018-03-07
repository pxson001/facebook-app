package com.facebook.pages.identity.ui.carousel;

import android.content.Context;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.content.event.FbEvent;
import com.facebook.events.common.ActionMechanism;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.graphql.enums.GraphQLEventsCalendarSubscriptionStatus;
import com.facebook.graphql.model.GraphQLEvent;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventBus;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.EventsSubscribeStatusChangedEvent;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.EventsSubscribeStatusChangedEventSubscriber;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageSecondaryCardView;
import com.facebook.pages.data.graphql.cards.EventCardGraphQLModels.EventCardQueryModel;
import com.facebook.pages.data.graphql.cards.EventCardGraphQLModels.PageEventsConnectionModel;
import com.facebook.pages.data.graphql.cards.PagesCardsModelConversionHelper;
import com.facebook.pages.identity.cards.events.PageIdentityEventsCardController;
import com.facebook.pages.identity.cards.events.PageIdentityEventsCardController.C04743;
import com.facebook.pages.identity.cards.events.PageIdentityEventsCardControllerProvider;
import com.facebook.pages.identity.cards.events.PageIdentityEventsCarouselAdapter;
import com.facebook.pages.identity.ui.PageIdentityCarouselView;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: page_identity_get_notification_fail */
public class PageIdentityUpcomingEventsCardView extends CustomLinearLayout implements PageSecondaryCardView {
    @Inject
    public PageIdentityEventsCarouselAdapter f4264a;
    @Inject
    public PageIdentityEventsCardControllerProvider f4265b;
    @Inject
    public PageScopedEventBus f4266c;
    public PageIdentityCarouselView f4267d = ((PageIdentityCarouselView) a(2131565493));
    public TextView f4268e = ((TextView) a(2131565490));
    public TextView f4269f = ((TextView) a(2131565491));
    public TextView f4270g = ((TextView) a(2131565494));
    public TextView f4271h = ((TextView) a(2131565492));
    public PageIdentityEventsCardController f4272i;
    private EventsSubscribeStatusChangedEventSubscriber f4273j;

    public static void m5233a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PageIdentityUpcomingEventsCardView pageIdentityUpcomingEventsCardView = (PageIdentityUpcomingEventsCardView) obj;
        PageIdentityEventsCarouselAdapter pageIdentityEventsCarouselAdapter = new PageIdentityEventsCarouselAdapter((Context) fbInjector.getInstance(Context.class), RecyclableViewPoolManager.a(fbInjector));
        PageIdentityEventsCardControllerProvider pageIdentityEventsCardControllerProvider = (PageIdentityEventsCardControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(PageIdentityEventsCardControllerProvider.class);
        PageScopedEventBus a = PageScopedEventBus.a(fbInjector);
        pageIdentityUpcomingEventsCardView.f4264a = pageIdentityEventsCarouselAdapter;
        pageIdentityUpcomingEventsCardView.f4265b = pageIdentityEventsCardControllerProvider;
        pageIdentityUpcomingEventsCardView.f4266c = a;
    }

    public PageIdentityUpcomingEventsCardView(Context context) {
        super(context);
        Class cls = PageIdentityUpcomingEventsCardView.class;
        m5233a(this, getContext());
        setContentView(2130906017);
        setOrientation(1);
        this.f4267d.setAdapter(this.f4264a);
    }

    private void m5232a(final PageIdentityEventsCardController pageIdentityEventsCardController) {
        Object obj;
        String string;
        this.f4267d.setOnPageChangeListener(null);
        TextView textView = this.f4268e;
        if (pageIdentityEventsCardController.f3481f == null || pageIdentityEventsCardController.f3481f.b.isEmpty()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            string = pageIdentityEventsCardController.f3480e.getString(2131235476);
        } else {
            string = pageIdentityEventsCardController.f3480e.getString(2131235477);
        }
        textView.setText(string);
        this.f4271h.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PageIdentityUpcomingEventsCardView f4258b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -631986581);
                PageIdentityEventsCardController pageIdentityEventsCardController = pageIdentityEventsCardController;
                pageIdentityEventsCardController.f3490o.a(pageIdentityEventsCardController.f3491p.a(pageIdentityEventsCardController.f3477b, pageIdentityEventsCardController.f3478c, "pages_identity".toString(), ActionMechanism.PAGE_UPCOMING_EVENTS_CARD.toString()), pageIdentityEventsCardController.f3480e);
                Logger.a(2, EntryType.UI_INPUT_END, 2001290418, a);
            }
        });
        PageIdentityEventsCarouselAdapter pageIdentityEventsCarouselAdapter = this.f4264a;
        pageIdentityEventsCarouselAdapter.f3514b = pageIdentityEventsCardController.f3477b;
        pageIdentityEventsCarouselAdapter.f3516d = pageIdentityEventsCardController.f3481f;
        pageIdentityEventsCarouselAdapter.a(pageIdentityEventsCarouselAdapter.f3516d.b());
        this.f4264a.f3515c = new Object(this) {
            final /* synthetic */ PageIdentityUpcomingEventsCardView f4260b;
        };
        this.f4267d.setOnPageChangeListener(new SimpleOnPageChangeListener(this) {
            final /* synthetic */ PageIdentityUpcomingEventsCardView f4262b;

            public final void e_(int i) {
                pageIdentityEventsCardController.m4545b(i);
            }
        });
        CharSequence charSequence = null;
        if (charSequence != null) {
            this.f4269f.setText(charSequence);
            this.f4269f.setVisibility(0);
        }
        if (pageIdentityEventsCardController.f3479d) {
            this.f4270g.setVisibility(0);
            View view = this.f4270g;
            pageIdentityEventsCardController.f3483h = (TextView) view;
            pageIdentityEventsCardController.m4544a(pageIdentityEventsCardController.f3483h, pageIdentityEventsCardController.f3482g, pageIdentityEventsCardController.f3480e);
            pageIdentityEventsCardController.f3483h.setOnClickListener(new C04743(pageIdentityEventsCardController));
            pageIdentityEventsCardController.f3488m.a(PageIdentityEventsCardController.f3476a);
            if (pageIdentityEventsCardController.f3482g == GraphQLEventsCalendarSubscriptionStatus.NONE && pageIdentityEventsCardController.f3488m.c()) {
                pageIdentityEventsCardController.f3484i = new Tooltip(pageIdentityEventsCardController.f3480e, 2);
                pageIdentityEventsCardController.f3484i.t = -1;
                pageIdentityEventsCardController.f3484i.b(pageIdentityEventsCardController.f3480e.getString(2131235481, new Object[]{pageIdentityEventsCardController.f3478c}));
                view.getViewTreeObserver().addOnScrollChangedListener(pageIdentityEventsCardController.f3494s);
            }
        }
    }

    public final void m5235a(long j, String str, EventCardQueryModel eventCardQueryModel) {
        this.f4272i = this.f4265b.m4546a(Long.valueOf(j), str, Boolean.valueOf(eventCardQueryModel.a()), eventCardQueryModel.j(), m5231a(eventCardQueryModel), getContext());
        m5234b();
        m5232a(this.f4272i);
    }

    public static ImmutableList<GraphQLEvent> m5231a(EventCardQueryModel eventCardQueryModel) {
        PageEventsConnectionModel k = eventCardQueryModel.k();
        if (k == null) {
            return null;
        }
        return PagesCardsModelConversionHelper.a(k).a();
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -192358837);
        super.onAttachedToWindow();
        this.f4266c.a(this.f4273j);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1067749109, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -2119379993);
        this.f4266c.b(this.f4273j);
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -2003913190, a);
    }

    private void m5234b() {
        this.f4266c.b(this.f4273j);
        this.f4273j = new EventsSubscribeStatusChangedEventSubscriber(this, Long.valueOf(this.f4272i.f3477b)) {
            final /* synthetic */ PageIdentityUpcomingEventsCardView f4263b;

            public final void m5230b(FbEvent fbEvent) {
                this.f4263b.f4272i.m4544a(this.f4263b.f4270g, ((EventsSubscribeStatusChangedEvent) fbEvent).b, this.f4263b.getContext());
            }
        };
        this.f4266c.a(this.f4273j);
    }
}
