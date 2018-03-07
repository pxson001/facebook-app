package com.facebook.events.permalink.summary;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.common.time.SystemClock;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.ActionSource;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketTierPermalinkFragmentModel.TicketTiersModel.NodesModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.model.Event;
import com.facebook.events.model.EventTicketInfo;
import com.facebook.events.permalink.calltoaction.BuyTicketsCallToAction;
import com.facebook.events.protocol.EventGraphQLModelHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: background_location_miniphone_selected */
public class EventTicketInfoView extends FbTextView implements EventPermalinkSummaryRow {
    @Inject
    EventEventLogger f18930a;
    @Inject
    BuyTicketsCallToAction f18931b;
    @Inject
    SecureContextHelper f18932c;
    @Inject
    public TimeFormatUtil f18933d;
    @Inject
    EventSummaryRowBuilder f18934e;
    public FetchEventPermalinkFragmentModel f18935f;
    public EventAnalyticsParams f18936g;
    public ImmutableList<EventTicketInfo> f18937h;
    public String f18938i;
    public Uri f18939j;

    /* compiled from: background_location_miniphone_selected */
    class C26861 implements OnClickListener {
        final /* synthetic */ EventTicketInfoView f18929a;

        C26861(EventTicketInfoView eventTicketInfoView) {
            this.f18929a = eventTicketInfoView;
        }

        public void onClick(View view) {
            int paramValue;
            String str = null;
            int a = Logger.a(2, EntryType.UI_INPUT_START, -766633455);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(this.f18929a.f18939j);
            this.f18929a.f18932c.b(intent, this.f18929a.getContext());
            if (this.f18929a.f18936g == null) {
                paramValue = ActionSource.UNKNOWN.getParamValue();
            } else {
                paramValue = this.f18929a.f18936g.b.f.getParamValue();
            }
            EventEventLogger eventEventLogger = this.f18929a.f18930a;
            String str2 = this.f18929a.f18938i;
            String dL_ = this.f18929a.f18935f != null ? this.f18929a.f18935f.dL_() : null;
            int size = this.f18929a.f18937h.size();
            if (this.f18929a.f18936g != null) {
                str = this.f18929a.f18936g.f;
            }
            eventEventLogger.m18132a(str2, dL_, size, paramValue, str);
            LogUtils.a(1241635653, a);
        }
    }

    public static void m19172a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EventTicketInfoView) obj).m19169a(EventEventLogger.m18119b(fbInjector), BuyTicketsCallToAction.m18625b(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), (TimeFormatUtil) DefaultTimeFormatUtil.a(fbInjector), EventSummaryRowBuilder.m19164b(fbInjector));
    }

    public EventTicketInfoView(Context context) {
        super(context);
        Class cls = EventTicketInfoView.class;
        m19172a((Object) this, getContext());
    }

    private void m19169a(EventEventLogger eventEventLogger, BuyTicketsCallToAction buyTicketsCallToAction, SecureContextHelper secureContextHelper, TimeFormatUtil timeFormatUtil, EventSummaryRowBuilder eventSummaryRowBuilder) {
        this.f18930a = eventEventLogger;
        this.f18931b = buyTicketsCallToAction;
        this.f18932c = secureContextHelper;
        this.f18933d = timeFormatUtil;
        this.f18934e = eventSummaryRowBuilder;
    }

    public final boolean mo852a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel) {
        if (fetchEventPermalinkFragmentModel == null) {
            return false;
        }
        if (this.f18931b.m18629b(event, fetchEventPermalinkFragmentModel)) {
            return true;
        }
        boolean z = (EventGraphQLModelHelper.m19272a(fetchEventPermalinkFragmentModel.V()).isEmpty() && Strings.isNullOrEmpty(fetchEventPermalinkFragmentModel.U())) ? false : true;
        return z;
    }

    public final void mo851a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, EventAnalyticsParams eventAnalyticsParams, boolean z) {
        if (fetchEventPermalinkFragmentModel == null) {
            setVisibility(8);
            return;
        }
        this.f18935f = fetchEventPermalinkFragmentModel;
        this.f18936g = eventAnalyticsParams;
        if (this.f18931b.m18629b(event, fetchEventPermalinkFragmentModel)) {
            this.f18931b.m18628a(event.a, ActionMechanism.PERMALINK_CONTEXT_ROW);
            m19170a(event, fetchEventPermalinkFragmentModel, z);
            return;
        }
        m19173a(z);
    }

    private void m19170a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, boolean z) {
        CharSequence charSequence;
        CharSequence charSequence2;
        NodesModel nodesModel = (NodesModel) fetchEventPermalinkFragmentModel.ac().a().get(0);
        long a = SystemClock.b().a();
        long eb_ = 1000 * nodesModel.eb_();
        String string;
        Object obj;
        String str;
        if (!fetchEventPermalinkFragmentModel.T() && a < eb_) {
            string = getResources().getString(2131237234, new Object[]{this.f18933d.a(TimeFormatStyle.SHORT_DATE_STYLE, eb_), this.f18933d.a(TimeFormatStyle.HOUR_MINUTE_STYLE, eb_)});
            if (Strings.isNullOrEmpty(nodesModel.g())) {
                obj = string;
                charSequence = null;
            } else {
                str = string;
                charSequence = getResources().getString(2131237233, new Object[]{nodesModel.g()});
                charSequence2 = str;
            }
        } else if (Strings.isNullOrEmpty(fetchEventPermalinkFragmentModel.U())) {
            charSequence2 = getResources().getString(2131237232, new Object[]{nodesModel.g()});
            if (fetchEventPermalinkFragmentModel.T()) {
                setOnClickListener(this.f18931b.m18626a(event, fetchEventPermalinkFragmentModel, ActionMechanism.BUY_TICKETS_CTA, this.f18936g));
                charSequence = null;
            } else {
                charSequence = null;
            }
        } else {
            if (fetchEventPermalinkFragmentModel.T()) {
                string = getResources().getString(2131237012);
                if (Strings.isNullOrEmpty(nodesModel.g())) {
                    str = string;
                    Object host = Uri.parse(fetchEventPermalinkFragmentModel.U()).getHost();
                    obj = str;
                } else {
                    str = string;
                    charSequence = getResources().getString(2131237235, new Object[]{nodesModel.g()});
                    charSequence2 = str;
                }
            } else {
                charSequence2 = getResources().getString(2131237011);
                charSequence = Uri.parse(fetchEventPermalinkFragmentModel.U()).getHost();
            }
            this.f18939j = Uri.parse(fetchEventPermalinkFragmentModel.U());
            m19175c();
        }
        this.f18934e.m19166a((TextView) this, charSequence2, charSequence, z);
        this.f18934e.m19165a(this, 2130838284, z);
    }

    private void m19171a(@Nonnull EventTicketInfo eventTicketInfo) {
        Uri uri;
        this.f18938i = eventTicketInfo.a;
        if (eventTicketInfo.f) {
            uri = null;
        } else {
            uri = eventTicketInfo.l;
        }
        this.f18939j = uri;
        m19175c();
    }

    private String m19177e(EventTicketInfo eventTicketInfo) {
        if (eventTicketInfo.e) {
            return getContext().getString(2131237006);
        }
        if (!eventTicketInfo.p() || !eventTicketInfo.m()) {
            return null;
        }
        String str;
        if (eventTicketInfo.n()) {
            if (eventTicketInfo.o()) {
                String a;
                if (eventTicketInfo.o()) {
                    a = eventTicketInfo.c.a();
                } else {
                    a = null;
                }
                str = a;
            } else {
                str = m19178g(eventTicketInfo);
            }
            return getContext().getString(2131237009, new Object[]{str});
        }
        str = eventTicketInfo.c.a();
        return getContext().getString(2131236996, new Object[]{str});
    }

    private void m19173a(boolean z) {
        CharSequence charSequence;
        CharSequence charSequence2 = null;
        this.f18937h = EventGraphQLModelHelper.m19272a(this.f18935f.V());
        Object string;
        Object obj;
        if (this.f18937h.isEmpty()) {
            if (Strings.isNullOrEmpty(this.f18935f.U())) {
                setVisibility(8);
                charSequence = null;
            } else {
                setVisibility(0);
                string = getContext().getString(2131237011);
                FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel = this.f18935f;
                String W = fetchEventPermalinkFragmentModel.W();
                if (Strings.isNullOrEmpty(W)) {
                    W = fetchEventPermalinkFragmentModel.U();
                    W = !Strings.isNullOrEmpty(W) ? Uri.parse(W).getHost() : null;
                }
                obj = W;
                this.f18939j = Uri.parse(this.f18935f.U());
                m19175c();
            }
        } else if (this.f18937h.size() == 1) {
            setVisibility(0);
            EventTicketInfo eventTicketInfo = (EventTicketInfo) this.f18937h.get(0);
            String d = m19176d(eventTicketInfo);
            String a = m19168a(eventTicketInfo, 0);
            m19171a(eventTicketInfo);
            obj = a;
            string = d;
        } else {
            EventTicketInfo a2 = m19167a(this.f18937h);
            if (a2 == null) {
                setVisibility(8);
                charSequence = null;
            } else {
                setVisibility(0);
                charSequence = m19176d(a2);
                charSequence2 = m19168a(a2, this.f18937h.size() - 1);
                m19171a(a2);
            }
        }
        this.f18934e.m19166a((TextView) this, charSequence, charSequence2, z);
        this.f18934e.m19165a(this, 2130838284, z);
    }

    private EventTicketInfo m19167a(ImmutableList<EventTicketInfo> immutableList) {
        EventTicketInfo eventTicketInfo = null;
        int size = immutableList.size();
        int i = 0;
        EventTicketInfo eventTicketInfo2 = null;
        while (i < size) {
            EventTicketInfo eventTicketInfo3 = (EventTicketInfo) immutableList.get(i);
            if (!Strings.isNullOrEmpty(m19174c(eventTicketInfo3))) {
                if (eventTicketInfo3.h) {
                    return eventTicketInfo3;
                }
                if (eventTicketInfo3.i && eventTicketInfo2 == null) {
                    EventTicketInfo eventTicketInfo4 = eventTicketInfo;
                    eventTicketInfo = eventTicketInfo3;
                    eventTicketInfo3 = eventTicketInfo4;
                    i++;
                    eventTicketInfo2 = eventTicketInfo;
                    eventTicketInfo = eventTicketInfo3;
                } else if (eventTicketInfo3.j && eventTicketInfo == null) {
                    eventTicketInfo = eventTicketInfo2;
                    i++;
                    eventTicketInfo2 = eventTicketInfo;
                    eventTicketInfo = eventTicketInfo3;
                }
            }
            eventTicketInfo3 = eventTicketInfo;
            eventTicketInfo = eventTicketInfo2;
            i++;
            eventTicketInfo2 = eventTicketInfo;
            eventTicketInfo = eventTicketInfo3;
        }
        return eventTicketInfo2 != null ? eventTicketInfo2 : eventTicketInfo;
    }

    private String m19176d(EventTicketInfo eventTicketInfo) {
        String c = m19174c(eventTicketInfo);
        if (!Strings.isNullOrEmpty(c)) {
            return c;
        }
        if (eventTicketInfo.f) {
            return getContext().getString(2131237010);
        }
        if (eventTicketInfo.l != null) {
            return getContext().getString(2131237011);
        }
        return null;
    }

    private String m19174c(EventTicketInfo eventTicketInfo) {
        String string;
        if (eventTicketInfo.f()) {
            string = getContext().getString(2131237008, new Object[]{this.f18933d.a(TimeFormatStyle.DATE_PICKER_STYLE, eventTicketInfo.g)});
        } else {
            string = null;
        }
        String str = string;
        if (Strings.isNullOrEmpty(str)) {
            return m19177e(eventTicketInfo);
        }
        return str;
    }

    private String m19178g(EventTicketInfo eventTicketInfo) {
        if (!eventTicketInfo.m() || !eventTicketInfo.n()) {
            return null;
        }
        String a = eventTicketInfo.c.a();
        String a2 = eventTicketInfo.d.a();
        return getContext().getString(2131237004, new Object[]{a, a2});
    }

    private String m19168a(EventTicketInfo eventTicketInfo, int i) {
        String quantityString;
        String string = !Strings.isNullOrEmpty(eventTicketInfo.k) ? getContext().getString(2131237007, new Object[]{eventTicketInfo.k}) : eventTicketInfo.l != null ? eventTicketInfo.l.getHost() : null;
        if (i > 0) {
            quantityString = getContext().getResources().getQuantityString(2131689663, i, new Object[]{Integer.valueOf(i)});
        } else {
            quantityString = null;
        }
        if (!Strings.isNullOrEmpty(string) && !Strings.isNullOrEmpty(quantityString)) {
            return getContext().getString(2131237013, new Object[]{string, quantityString});
        } else if (!Strings.isNullOrEmpty(string)) {
            return string;
        } else {
            if (Strings.isNullOrEmpty(quantityString)) {
                return null;
            }
            return quantityString;
        }
    }

    private void m19175c() {
        if (this.f18939j == null) {
            setOnClickListener(null);
        } else {
            setOnClickListener(new C26861(this));
        }
    }
}
