package com.facebook.events.tickets;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketTierPermalinkFragmentModel.TicketTiersModel.NodesModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.tickets.modal.EventBuyTicketStringFormattingUtil;
import com.facebook.events.tickets.modal.EventTicketsOrdersActivity;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.inject.FbInjector;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: asset_key */
public class EventsPurchasedTicketsView extends ImageWithTextView {
    @Inject
    EventEventLogger f19187a;
    @Inject
    IFeedIntentBuilder f19188b;
    @Inject
    QeAccessor f19189c;
    @Inject
    SecureContextHelper f19190d;
    private OnClickListener f19191e;
    private Paint f19192f;
    public FetchEventPermalinkFragmentModel f19193g;
    private EventBuyTicketStringFormattingUtil f19194h;

    /* compiled from: asset_key */
    class C27211 implements OnClickListener {
        final /* synthetic */ EventsPurchasedTicketsView f19186a;

        C27211(EventsPurchasedTicketsView eventsPurchasedTicketsView) {
            this.f19186a = eventsPurchasedTicketsView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -525165043);
            if (this.f19186a.f19189c.a(ExperimentsForEventsGatingModule.j, false) && this.f19186a.f19193g.Z()) {
                EventsPurchasedTicketsView.m19377d(this.f19186a);
            } else {
                this.f19186a.m19375c();
            }
            LogUtils.a(-1822107154, a);
        }
    }

    private static <T extends View> void m19369a(Class<T> cls, T t) {
        m19370a((Object) t, t.getContext());
    }

    private static void m19370a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EventsPurchasedTicketsView) obj).m19368a(EventEventLogger.m18119b(fbInjector), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector));
    }

    private void m19368a(EventEventLogger eventEventLogger, IFeedIntentBuilder iFeedIntentBuilder, QeAccessor qeAccessor, SecureContextHelper secureContextHelper) {
        this.f19187a = eventEventLogger;
        this.f19188b = iFeedIntentBuilder;
        this.f19189c = qeAccessor;
        this.f19190d = secureContextHelper;
    }

    public EventsPurchasedTicketsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19373b();
    }

    public EventsPurchasedTicketsView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19373b();
    }

    private void m19373b() {
        m19369a(EventsPurchasedTicketsView.class, (View) this);
        this.f19192f = new Paint(1);
        this.f19192f.setStyle(Style.STROKE);
        Resources resources = getResources();
        this.f19192f.setColor(resources.getColor(2131363142));
        this.f19192f.setStrokeWidth((float) resources.getDimensionPixelSize(2131434219));
        this.f19194h = new EventBuyTicketStringFormattingUtil(getResources());
        this.f19191e = new C27211(this);
    }

    private void m19375c() {
        String dL_ = this.f19193g.dL_();
        this.f19188b.a(getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, Uri.encode(StringFormatUtil.formatStrLocaleSafe("/events/%s/tickets", dL_))));
        EventEventLogger eventEventLogger = this.f19187a;
        HoneyClientEventFast a = eventEventLogger.f17787i.a("event_purchased_tickets_button_tapped", false);
        if (a.a()) {
            a.a("event_permalink").d(eventEventLogger.f17788j.b(eventEventLogger.f17785g)).b("Event").c(dL_).a("event_id", dL_).b();
        }
    }

    public static void m19377d(EventsPurchasedTicketsView eventsPurchasedTicketsView) {
        eventsPurchasedTicketsView.f19190d.a(EventTicketsOrdersActivity.m19432a(eventsPurchasedTicketsView.getContext(), eventsPurchasedTicketsView.f19193g, null), eventsPurchasedTicketsView.getContext());
    }

    public final void m19378a(FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel) {
        this.f19193g = fetchEventPermalinkFragmentModel;
        int b = m19372b(fetchEventPermalinkFragmentModel);
        if (b > 0) {
            m19367a(b);
            return;
        }
        NodesModel nodesModel = (NodesModel) fetchEventPermalinkFragmentModel.ac().a().get(0);
        m19371a(nodesModel.ea_(), EventBuyTicketStringFormattingUtil.m19390a(nodesModel.ec_().b(), nodesModel.ec_().c(), nodesModel.ec_().a(), 1).toString());
    }

    private void m19367a(int i) {
        setOnClickListener(this.f19191e);
        setText(getContext().getResources().getQuantityString(2131689681, i, new Object[]{Integer.valueOf(i)}));
        setTextColor(getResources().getColor(2131361916));
    }

    private void m19371a(String str, String str2) {
        setOnClickListener(null);
        if (Strings.isNullOrEmpty(str)) {
            str = getResources().getString(2131241930);
        }
        setTextColor(getResources().getColor(2131361973));
        setText(StringLocaleUtil.a("%1$s · %2$s", new Object[]{str, str2}));
    }

    public static int m19372b(@Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel) {
        int i = 0;
        if (!(fetchEventPermalinkFragmentModel == null || fetchEventPermalinkFragmentModel.ac() == null)) {
            ImmutableList a = fetchEventPermalinkFragmentModel.ac().a();
            int size = a.size();
            int i2 = 0;
            while (i2 < size) {
                int b;
                NodesModel nodesModel = (NodesModel) a.get(i2);
                if (nodesModel.b() > 0) {
                    b = nodesModel.b() + i;
                } else {
                    b = i;
                }
                i2++;
                i = b;
            }
        }
        return i;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        int height = canvas.getHeight();
        float strokeWidth = ((float) height) - this.f19192f.getStrokeWidth();
        Canvas canvas2 = canvas;
        float f = strokeWidth;
        canvas2.drawLine(0.0f, strokeWidth, (float) canvas.getWidth(), f, this.f19192f);
        canvas.restore();
    }
}
