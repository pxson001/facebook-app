package com.facebook.events.permalink.summary;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.model.Event;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: background_location_reporting_gcm_upload */
public class EventGroupInfoView extends FbTextView implements OnClickListener, EventPermalinkSummaryRow {
    @Inject
    public EventEventLogger f18861a;
    @Inject
    public EventSummaryRowBuilder f18862b;
    @Inject
    public SecureContextHelper f18863c;
    private EventAnalyticsParams f18864d;
    private Event f18865e;

    public static void m19134a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        EventGroupInfoView eventGroupInfoView = (EventGroupInfoView) obj;
        EventEventLogger b = EventEventLogger.m18119b(fbInjector);
        EventSummaryRowBuilder b2 = EventSummaryRowBuilder.m19164b(fbInjector);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        eventGroupInfoView.f18861a = b;
        eventGroupInfoView.f18862b = b2;
        eventGroupInfoView.f18863c = secureContextHelper;
    }

    public EventGroupInfoView(Context context) {
        super(context);
        Class cls = EventGroupInfoView.class;
        m19134a((Object) this, getContext());
        setOnClickListener(this);
    }

    public final void mo851a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, EventAnalyticsParams eventAnalyticsParams, boolean z) {
        this.f18865e = event;
        this.f18864d = eventAnalyticsParams;
        String str = this.f18865e.r;
        this.f18862b.m19166a((TextView) this, getContext().getString(2131236989, new Object[]{str}), null, z);
        this.f18862b.m19165a(this, 2130838286, z);
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1853207844);
        if (this.f18865e != null) {
            String str = this.f18865e.q;
            EventEventLogger eventEventLogger = this.f18861a;
            String str2 = this.f18865e.a;
            int paramValue = this.f18864d.b.e.getParamValue();
            int paramValue2 = this.f18864d.b.f.getParamValue();
            HoneyClientEventFast a2 = eventEventLogger.f17787i.a("event_group_summary_click", false);
            if (a2.a()) {
                a2.a("event_permalink").d(eventEventLogger.f17788j.b(eventEventLogger.f17785g)).b("Event").c(str2).a("action_source", paramValue).a("action_ref", paramValue2).a("group_id", str).b();
            }
            Intent intent = new Intent();
            intent.setData(Uri.parse(StringFormatUtil.a(FBLinks.u, new Object[]{this.f18865e.q})));
            this.f18863c.a(intent, view.getContext());
        }
        Logger.a(2, EntryType.UI_INPUT_END, 1072884760, a);
    }

    public final boolean mo852a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel) {
        return (StringUtil.a(event.r) || StringUtil.a(event.q) || (!StringUtil.a(event.s) && event.q.equals(event.s))) ? false : true;
    }
}
