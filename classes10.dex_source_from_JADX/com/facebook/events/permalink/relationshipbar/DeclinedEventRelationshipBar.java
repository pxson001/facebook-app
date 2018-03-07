package com.facebook.events.permalink.relationshipbar;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.model.Event;
import com.facebook.events.model.EventUser;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.forcemessenger.ForceMessengerHandler;
import com.facebook.messaging.util.MessengerAppUtils;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.utils.TextViewUtils;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: background_location_settings_perf_init */
public class DeclinedEventRelationshipBar extends AbstractRelationshipBar {
    @Inject
    public MessengerAppUtils f18831c;
    @Inject
    public EventEventLogger f18832d;
    @Inject
    public ForceMessengerHandler f18833e;
    @Inject
    public GlyphColorizer f18834f;
    public Event f18835g;
    public EventAnalyticsParams f18836h;
    public FbButton f18837i = ((FbButton) a(2131560930));

    /* compiled from: background_location_settings_perf_init */
    public class C26751 implements OnClickListener {
        final /* synthetic */ DeclinedEventRelationshipBar f18830a;

        public C26751(DeclinedEventRelationshipBar declinedEventRelationshipBar) {
            this.f18830a = declinedEventRelationshipBar;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -986080287);
            if (this.f18830a.f18835g != null) {
                String str;
                EventUser eventUser = this.f18830a.f18835g.ai;
                if (eventUser == null) {
                    str = null;
                } else {
                    str = eventUser.b;
                }
                if (str != null) {
                    this.f18830a.f18832d.m18129a(this.f18830a.f18836h.d, ActionMechanism.PERMALINK_RELATIONSHIP_BAR, this.f18830a.f18836h.c, this.f18830a.f18835g.a, this.f18830a.f18831c.c());
                    this.f18830a.f18833e.a(str, "events");
                }
            }
            LogUtils.a(-1210495656, a);
        }
    }

    public static void m19125a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        DeclinedEventRelationshipBar declinedEventRelationshipBar = (DeclinedEventRelationshipBar) obj;
        MessengerAppUtils a = MessengerAppUtils.a(fbInjector);
        EventEventLogger b = EventEventLogger.m18119b(fbInjector);
        ForceMessengerHandler b2 = ForceMessengerHandler.b(fbInjector);
        GlyphColorizer a2 = GlyphColorizer.a(fbInjector);
        declinedEventRelationshipBar.f18831c = a;
        declinedEventRelationshipBar.f18832d = b;
        declinedEventRelationshipBar.f18833e = b2;
        declinedEventRelationshipBar.f18834f = a2;
    }

    public DeclinedEventRelationshipBar(Context context) {
        super(context);
        Class cls = DeclinedEventRelationshipBar.class;
        m19125a(this, getContext());
        setContentView(2130903865);
        TextViewUtils.a(this.f18837i, this.f18834f.a(2130839551, -1), null, null, null);
        this.f18837i.setOnClickListener(new C26751(this));
    }

    public final void mo849a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, EventAnalyticsParams eventAnalyticsParams) {
        this.f18835g = event;
        this.f18836h = eventAnalyticsParams;
        EventUser eventUser = event.ai;
        if (eventUser == null || eventUser.c == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        String str = eventUser.c;
        if (event.D() == GraphQLEventGuestStatus.NOT_GOING) {
            setSocialSentence(getResources().getString(2131237064, new Object[]{str}));
        } else {
            setSocialSentence("");
        }
        this.f18837i.setText(getResources().getString(2131237065, new Object[]{str}));
    }
}
