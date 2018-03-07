package com.facebook.events.dashboard.prompts;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.create.EventCreationNikumanActivity;
import com.facebook.events.eventsevents.EventsEventBus;
import com.facebook.events.eventsevents.EventsEvents.PromptDeletedEvent;
import com.facebook.events.graphql.EventsMutations.EventPromptXOutMutationString;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.graphql.calls.EventPromotionXoutInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: com.facebook.platform.action.request.SHARE_DIALOG */
public class EventsBirthdayPrompt extends CustomLinearLayout {
    @Inject
    public EventsEventBus f17140a;
    @Inject
    public EventEventLogger f17141b;
    @Inject
    public GraphQLQueryExecutor f17142c;
    @Inject
    public SecureContextHelper f17143d;
    public View f17144e;
    public FbDraweeView f17145f;
    public FbTextView f17146g;
    public FbTextView f17147h;
    public FbButton f17148i;
    public GlyphView f17149j;
    public String f17150k;
    public String f17151l;
    public long f17152m = -1;
    public String f17153n;
    public String f17154o;
    public EventAnalyticsParams f17155p;

    /* compiled from: com.facebook.platform.action.request.SHARE_DIALOG */
    public class C24001 implements OnClickListener {
        final /* synthetic */ EventsBirthdayPrompt f17138a;

        public C24001(EventsBirthdayPrompt eventsBirthdayPrompt) {
            this.f17138a = eventsBirthdayPrompt;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2142057813);
            EventEventLogger eventEventLogger = this.f17138a.f17141b;
            String str = this.f17138a.f17155p.c;
            String str2 = this.f17138a.f17155p.d;
            ActionMechanism actionMechanism = ActionMechanism.EVENT_PROMPT_ACTION_BUTTON;
            String str3 = this.f17138a.f17150k;
            HoneyClientEventFast a2 = eventEventLogger.f17787i.a("event_prompt_action_button_click", false);
            if (a2.a()) {
                a2.a("event_dashboard").d(eventEventLogger.f17788j.b(eventEventLogger.f17785g)).b("EventPrompt").c(str3).a("ref_module", str).a("source_module", str2).a("action_mechanism", actionMechanism).b();
            }
            Intent intent = new Intent(this.f17138a.getContext(), EventCreationNikumanActivity.class);
            if (!Strings.isNullOrEmpty(this.f17138a.f17151l)) {
                intent.putExtra("events_creation_prefill_title", this.f17138a.f17151l);
            }
            if (this.f17138a.f17152m >= 0) {
                intent.putExtra("events_creation_prefill_start_time", this.f17138a.f17152m);
            }
            if (!Strings.isNullOrEmpty(this.f17138a.f17153n)) {
                intent.putExtra("events_creation_prefill_theme_id", this.f17138a.f17153n);
            }
            if (!Strings.isNullOrEmpty(this.f17138a.f17154o)) {
                intent.putExtra("events_creation_prefill_theme_url", this.f17138a.f17154o);
            }
            if (!Strings.isNullOrEmpty(this.f17138a.f17150k)) {
                intent.putExtra("events_creation_prompt_id", this.f17138a.f17150k);
            }
            this.f17138a.f17143d.a(intent, this.f17138a.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, -1767425524, a);
        }
    }

    /* compiled from: com.facebook.platform.action.request.SHARE_DIALOG */
    public class C24012 implements OnClickListener {
        final /* synthetic */ EventsBirthdayPrompt f17139a;

        public C24012(EventsBirthdayPrompt eventsBirthdayPrompt) {
            this.f17139a = eventsBirthdayPrompt;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 208731341);
            if (!Strings.isNullOrEmpty(this.f17139a.f17150k)) {
                this.f17139a.f17140a.a(new PromptDeletedEvent(this.f17139a.f17150k));
                EventPromotionXoutInputData eventPromotionXoutInputData = new EventPromotionXoutInputData();
                eventPromotionXoutInputData.a("event_promotion_id", this.f17139a.f17150k);
                this.f17139a.f17142c.a(GraphQLRequest.a((EventPromptXOutMutationString) new EventPromptXOutMutationString().a("input", eventPromotionXoutInputData)));
            }
            Logger.a(2, EntryType.UI_INPUT_END, 2056765749, a);
        }
    }

    public static void m17484a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        EventsBirthdayPrompt eventsBirthdayPrompt = (EventsBirthdayPrompt) obj;
        EventsEventBus a = EventsEventBus.a(fbInjector);
        EventEventLogger b = EventEventLogger.m18119b(fbInjector);
        GraphQLQueryExecutor a2 = GraphQLQueryExecutor.a(fbInjector);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        eventsBirthdayPrompt.f17140a = a;
        eventsBirthdayPrompt.f17141b = b;
        eventsBirthdayPrompt.f17142c = a2;
        eventsBirthdayPrompt.f17143d = secureContextHelper;
    }

    public EventsBirthdayPrompt(Context context) {
        super(context);
        Class cls = EventsBirthdayPrompt.class;
        m17484a(this, getContext());
        setContentView(2130904112);
        setOrientation(1);
        setBackgroundResource(2131361920);
        this.f17144e = a(2131561470);
        this.f17145f = (FbDraweeView) a(2131561471);
        this.f17146g = (FbTextView) a(2131561473);
        this.f17147h = (FbTextView) a(2131561474);
        this.f17148i = (FbButton) a(2131561475);
        this.f17148i.setOnClickListener(new C24001(this));
        this.f17149j = (GlyphView) a(2131561472);
        this.f17149j.setOnClickListener(new C24012(this));
    }
}
