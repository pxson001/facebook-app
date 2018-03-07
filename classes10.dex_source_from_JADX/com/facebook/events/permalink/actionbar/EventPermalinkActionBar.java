package com.facebook.events.permalink.actionbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.feed.protocol.EventPinnedPostAndRecentStoryGraphQLModels.EventPinnedPostAndRecentStoryFragmentModel.BoostableStoryModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.model.Event;
import com.facebook.events.permalink.relationshipbar.AbstractRelationshipBar;
import com.facebook.events.permalink.relationshipbar.DeclinedEventRelationshipBar;
import com.facebook.events.permalink.relationshipbar.EventRelationshipBar;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: callback */
public class EventPermalinkActionBar extends CustomFrameLayout implements EventPermalinkStandardActionBar {
    public EventsActionBar f18066a = ((EventsActionBar) c(2131561340));
    public LinearLayout f18067b = ((LinearLayout) c(2131561339));
    public AbstractRelationshipBar f18068c;
    public ViewGroup f18069d;

    /* compiled from: callback */
    public class C25581 implements OnClickListener {
        final /* synthetic */ EventPermalinkActionBar f18064a;

        public C25581(EventPermalinkActionBar eventPermalinkActionBar) {
            this.f18064a = eventPermalinkActionBar;
        }

        public void onClick(View view) {
            Logger.a(2, EntryType.UI_INPUT_END, 418676603, Logger.a(2, EntryType.UI_INPUT_START, 2057851815));
        }
    }

    public EventPermalinkActionBar(Context context) {
        super(context);
        setContentView(2130904054);
    }

    public void setBoostableStory(BoostableStoryModel boostableStoryModel) {
        this.f18066a.f18083k.m18470a(boostableStoryModel);
    }

    public final void m18432a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, @Nonnull EventAnalyticsParams eventAnalyticsParams, ActionItemPost actionItemPost, ActionItemInvite actionItemInvite) {
        this.f18066a.m18454a(event, fetchEventPermalinkFragmentModel, eventAnalyticsParams, actionItemPost, actionItemInvite);
        m18429a(event, fetchEventPermalinkFragmentModel, eventAnalyticsParams);
        if (this.f18069d != null) {
            this.f18069d.setVisibility(8);
        }
    }

    private void m18429a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, EventAnalyticsParams eventAnalyticsParams) {
        EventRelationshipBarType eventRelationshipBarType;
        GraphQLEventGuestStatus D = event.D();
        if (event.G) {
            if (Event.a(event)) {
                eventRelationshipBarType = EventRelationshipBarType.PUBLIC_INVITED;
            } else {
                eventRelationshipBarType = EventRelationshipBarType.PRIVATE_INVITED;
            }
        } else if (event.ai == null || D != GraphQLEventGuestStatus.NOT_GOING) {
            eventRelationshipBarType = null;
        } else {
            eventRelationshipBarType = EventRelationshipBarType.INVITE_DECLINED;
        }
        EventRelationshipBarType eventRelationshipBarType2 = eventRelationshipBarType;
        if (eventRelationshipBarType2 != null) {
            boolean z;
            if (this.f18068c != null) {
                switch (eventRelationshipBarType2) {
                    case PRIVATE_INVITED:
                    case PUBLIC_INVITED:
                        z = this.f18068c instanceof EventRelationshipBar;
                        break;
                    case INVITE_DECLINED:
                        z = this.f18068c instanceof DeclinedEventRelationshipBar;
                        break;
                    default:
                        z = false;
                        break;
                }
            }
            z = true;
            if (!z) {
                this.f18067b.removeView(this.f18068c);
                this.f18068c = null;
            }
            if (this.f18068c == null) {
                LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                this.f18068c = m18430b(eventRelationshipBarType2);
                this.f18067b.addView(this.f18068c, layoutParams);
            }
            this.f18068c.setVisibility(0);
            this.f18068c.mo849a(event, fetchEventPermalinkFragmentModel, eventAnalyticsParams);
        } else if (this.f18068c != null) {
            this.f18068c.setVisibility(8);
        }
    }

    private AbstractRelationshipBar m18430b(EventRelationshipBarType eventRelationshipBarType) {
        switch (eventRelationshipBarType) {
            case PRIVATE_INVITED:
            case PUBLIC_INVITED:
                return new EventRelationshipBar(getContext());
            case INVITE_DECLINED:
                return new DeclinedEventRelationshipBar(getContext());
            default:
                throw new IllegalArgumentException(eventRelationshipBarType + " unexpected");
        }
    }

    public final void mo820a(boolean z) {
        if (this.f18069d == null) {
            LayoutInflater.from(getContext()).inflate(2130904068, this, true);
            this.f18069d = (ViewGroup) c(2131561354);
            this.f18069d.setOnClickListener(new C25581(this));
        }
        this.f18069d.setVisibility(0);
        View findViewById = this.f18069d.findViewById(2131561355);
        View findViewById2 = this.f18069d.findViewById(2131561356);
        if (z) {
            findViewById.setVisibility(0);
            findViewById2.setVisibility(0);
            return;
        }
        findViewById.setVisibility(8);
        findViewById2.setVisibility(8);
    }

    public final void mo819a() {
        if (this.f18069d != null) {
            this.f18069d.setVisibility(8);
        }
    }
}
