package com.facebook.events.permalink.actionbar;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.provider.CalendarContract.Events;
import android.widget.Toast;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.model.Event;
import com.facebook.inject.Assisted;
import com.facebook.intent.feed.IFeedIntentBuilder;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: caller_data */
public class EventActionsHandlerUtil {
    private final Event f18057a;
    private final EventAnalyticsParams f18058b;
    private final Context f18059c;
    private final EventEventLogger f18060d;
    private final IFeedIntentBuilder f18061e;
    private final Provider<ComponentName> f18062f;
    private final SecureContextHelper f18063g;

    @Inject
    public EventActionsHandlerUtil(@Assisted Event event, @Assisted EventAnalyticsParams eventAnalyticsParams, Context context, EventEventLogger eventEventLogger, IFeedIntentBuilder iFeedIntentBuilder, @FragmentChromeActivity Provider<ComponentName> provider, SecureContextHelper secureContextHelper) {
        this.f18059c = context;
        this.f18057a = event;
        this.f18058b = eventAnalyticsParams;
        this.f18060d = eventEventLogger;
        this.f18061e = iFeedIntentBuilder;
        this.f18062f = provider;
        this.f18063g = secureContextHelper;
    }

    public final void m18422a(@Nullable String str, @Nullable String str2) {
        if (this.f18057a != null && this.f18057a.U != null) {
            CharSequence uri;
            ClipboardManager clipboardManager = (ClipboardManager) this.f18059c.getSystemService("clipboard");
            String str3 = this.f18057a.b;
            if (str == null || str2 == null) {
                uri = this.f18057a.U.toString();
            } else {
                uri = FacebookUriUtil.a(this.f18057a.U, str, str2).toString();
            }
            clipboardManager.setPrimaryClip(ClipData.newPlainText(str3, uri));
            Toast.makeText(this.f18059c, this.f18059c.getResources().getString(2131236853), 0).show();
        }
    }

    public final void m18421a() {
        Intent component = new Intent().setComponent((ComponentName) this.f18062f.get());
        component.putExtra("event_id", this.f18057a.a);
        component.putExtra("target_fragment", ContentFragmentType.EVENTS_NOTIFICATION_SETTINGS_FRAGMENT.ordinal());
        this.f18063g.a(component, this.f18059c);
    }

    public final void m18423b() {
        Intent component = new Intent().setComponent((ComponentName) this.f18062f.get());
        component.putExtra("event_id", this.f18057a.a);
        component.putExtra("extras_event_analytics_params", this.f18058b);
        component.putExtra("extra_is_event_canceled", this.f18057a.x);
        component.putExtra("target_fragment", ContentFragmentType.EVENTS_CANCEL_EVENT_FRAGMENT.ordinal());
        this.f18063g.a(component, 111, (Activity) ContextUtils.a(this.f18059c, Activity.class));
    }

    public final void m18424c() {
        if (this.f18057a != null) {
            this.f18061e.a(this.f18059c, StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, StringFormatUtil.formatStrLocaleSafe("/report/id/?fbid=%s", this.f18057a.a)));
        }
    }

    public final void m18425d() {
        if (this.f18057a != null) {
            Intent putExtra = new Intent("android.intent.action.INSERT").setData(Events.CONTENT_URI).putExtra("allDay", this.f18057a.M).putExtra("beginTime", this.f18057a.K()).putExtra("title", this.f18057a.b).putExtra("availability", 0);
            if (this.f18057a.Q != null) {
                putExtra.putExtra("eventLocation", this.f18057a.Q);
            } else if (this.f18057a.P != null) {
                putExtra.putExtra("eventLocation", this.f18057a.P);
            }
            if (!(this.f18057a.c == null || StringUtil.a(this.f18057a.c.a()))) {
                putExtra.putExtra("description", this.f18057a.c.a());
            }
            putExtra.putExtra("beginTime", this.f18057a.K());
            if (this.f18057a.L != null) {
                putExtra.putExtra("eventTimezone", this.f18057a.L.getID());
            }
            if (this.f18057a.L() != null) {
                putExtra.putExtra("endTime", this.f18057a.M());
            }
            putExtra.putExtra("guestsCanInviteOthers", this.f18057a.h);
            putExtra.putExtra("eventColor", this.f18059c.getResources().getColor(2131361916));
            this.f18063g.b(putExtra, this.f18059c);
            EventEventLogger eventEventLogger = this.f18060d;
            String str = this.f18057a.a;
            ActionMechanism actionMechanism = ActionMechanism.PERMALINK_ACTION_BAR;
            HoneyClientEventFast a = eventEventLogger.f17787i.a("event_export_to_calendar_click", false);
            if (a.a()) {
                a.a("action_mechanism", actionMechanism).a("event_permalink").d(eventEventLogger.f17788j.b(eventEventLogger.f17785g)).b("Event").c(str).b();
            }
        }
    }
}
