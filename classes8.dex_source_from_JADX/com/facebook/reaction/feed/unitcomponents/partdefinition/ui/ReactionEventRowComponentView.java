package com.facebook.reaction.feed.unitcomponents.partdefinition.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.events.mutators.PrivateEventsRsvpMutator;
import com.facebook.events.mutators.PublicEventsRsvpMutator;
import com.facebook.events.widget.eventcard.EventActionButtonStateSelectorProvider;
import com.facebook.events.widget.eventcard.EventActionButtonView;
import com.facebook.events.widget.eventcard.EventCalendarTimeView;
import com.facebook.events.widget.eventcard.EventsRsvpActionListener;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionAnalyticsParams;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionActionFatFieldsModel.ProfileModel;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: accelerometer_rotation */
public class ReactionEventRowComponentView extends ImageBlockLayout implements EventsRsvpActionListener {
    private static final CallerContext f20162l = CallerContext.a(ReactionEventRowComponentView.class, "event_profile_pic");
    public static final int[] f20163m = new int[]{2130773601, 2130773602};
    @Inject
    public EventActionButtonStateSelectorProvider f20164h;
    @Inject
    public PublicEventsRsvpMutator f20165i;
    @Inject
    public PrivateEventsRsvpMutator f20166j;
    @Inject
    public Provider<FbDraweeControllerBuilder> f20167k;
    public BetterTextView f20168n;
    public BetterTextView f20169o;
    public EventCalendarTimeView f20170p = ((EventCalendarTimeView) getView(2131566707));
    public EventActionButtonView f20171q;
    public BetterTextView f20172r;
    public Resources f20173s = getResources();
    public ProfileModel f20174t;
    public DraweeHolder f20175u;
    public ReactionAnalyticsParams f20176v;
    public ReactionInteractionTracker f20177w;
    public String f20178x;
    public String f20179y;

    /* compiled from: accelerometer_rotation */
    /* synthetic */ class C21531 {
        static final /* synthetic */ int[] f20160a = new int[GraphQLEventWatchStatus.values().length];
        static final /* synthetic */ int[] f20161b = new int[GraphQLEventGuestStatus.values().length];

        static {
            try {
                f20161b[GraphQLEventGuestStatus.GOING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f20161b[GraphQLEventGuestStatus.MAYBE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f20161b[GraphQLEventGuestStatus.NOT_GOING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f20160a[GraphQLEventWatchStatus.WATCHED.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f20160a[GraphQLEventWatchStatus.GOING.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f20160a[GraphQLEventWatchStatus.UNWATCHED.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f20160a[GraphQLEventWatchStatus.DECLINED.ordinal()] = 4;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public static void m24043a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ReactionEventRowComponentView reactionEventRowComponentView = (ReactionEventRowComponentView) obj;
        EventActionButtonStateSelectorProvider eventActionButtonStateSelectorProvider = (EventActionButtonStateSelectorProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(EventActionButtonStateSelectorProvider.class);
        PublicEventsRsvpMutator b = PublicEventsRsvpMutator.b(fbInjector);
        PrivateEventsRsvpMutator b2 = PrivateEventsRsvpMutator.b(fbInjector);
        Provider a = IdBasedProvider.a(fbInjector, 1117);
        reactionEventRowComponentView.f20164h = eventActionButtonStateSelectorProvider;
        reactionEventRowComponentView.f20165i = b;
        reactionEventRowComponentView.f20166j = b2;
        reactionEventRowComponentView.f20167k = a;
    }

    public ReactionEventRowComponentView(Context context) {
        super(context);
        Class cls = ReactionEventRowComponentView.class;
        m24043a((Object) this, getContext());
        setContentView(2130906663);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(f20163m);
        int resourceId = obtainStyledAttributes.getResourceId(0, 2131625842);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 2131625843);
        obtainStyledAttributes.recycle();
        this.f20170p.a(resourceId, resourceId2);
        this.f20175u = DraweeHolder.a(new GenericDraweeHierarchyBuilder(this.f20173s).f(this.f20173s.getDrawable(2130839523)).u(), getContext());
        this.f20168n = (BetterTextView) getView(2131566708);
        this.f20169o = (BetterTextView) getView(2131566709);
        this.f20171q = (EventActionButtonView) getView(2131566711);
        this.f20172r = (BetterTextView) getView(2131566710);
        setGravity(16);
        setBackgroundDrawable(new ColorDrawable(this.f20173s.getColor(2131361920)));
    }

    public void setEventTitle(String str) {
        this.f20168n.setText(str);
    }

    public void setEventInfo(String str) {
        this.f20169o.setText(str);
    }

    public final void m24046a(@Nullable String str, @Nullable String str2) {
        this.f20170p.setVisibility(this.f20170p.a(str, str2) ? 0 : 8);
    }

    public final void m24047a(boolean z, @Nullable String str) {
        if (z) {
            if (str == null) {
                this.f20175u.a(null);
            } else {
                this.f20175u.a(((FbDraweeControllerBuilder) this.f20167k.get()).a(f20162l).a(str).s());
            }
            this.f20170p.setBackgroundDrawable(this.f20175u.h());
        }
    }

    public void setEventSocialContext(@Nullable String str) {
        if (StringUtil.a(str)) {
            this.f20172r.setVisibility(8);
            return;
        }
        this.f20172r.setVisibility(0);
        this.f20172r.setText(str);
    }

    public final void m24044a(GraphQLEventGuestStatus graphQLEventGuestStatus, GraphQLEventGuestStatus graphQLEventGuestStatus2) {
        if (this.f20174t != null) {
            this.f20166j.a(this.f20174t.eL_(), graphQLEventGuestStatus2, this.f20176v != null ? this.f20176v.f18809a : "unknown", this.f20176v != null ? this.f20176v.f18810b : "unknown", this.f20176v != null ? this.f20176v.f18811c : "unknown", this.f20176v != null ? this.f20176v.f18812d : "unknown");
            m24040a(graphQLEventGuestStatus2);
        }
    }

    public final void m24045a(GraphQLEventWatchStatus graphQLEventWatchStatus, GraphQLEventWatchStatus graphQLEventWatchStatus2) {
        if (this.f20174t != null) {
            this.f20165i.a(this.f20174t.eL_(), graphQLEventWatchStatus2, this.f20176v != null ? this.f20176v.f18809a : "unknown", this.f20176v != null ? this.f20176v.f18810b : "unknown", this.f20176v != null ? this.f20176v.f18811c : "unknown", this.f20176v != null ? this.f20176v.f18812d : "unknown");
            m24041a(graphQLEventWatchStatus2);
        }
    }

    private void m24041a(GraphQLEventWatchStatus graphQLEventWatchStatus) {
        UnitInteractionType unitInteractionType;
        switch (C21531.f20160a[graphQLEventWatchStatus.ordinal()]) {
            case 1:
                unitInteractionType = UnitInteractionType.EVENT_CARD_WATCHED_TAP;
                break;
            case 2:
                unitInteractionType = UnitInteractionType.EVENT_CARD_GOING_TAP;
                break;
            case 3:
                unitInteractionType = UnitInteractionType.EVENT_CARD_UNWATCHED_TAP;
                break;
            case 4:
                unitInteractionType = UnitInteractionType.EVENT_CARD_NOT_GOING_TAP;
                break;
            default:
                return;
        }
        m24042a(unitInteractionType);
    }

    private void m24040a(GraphQLEventGuestStatus graphQLEventGuestStatus) {
        UnitInteractionType unitInteractionType;
        switch (C21531.f20161b[graphQLEventGuestStatus.ordinal()]) {
            case 1:
                unitInteractionType = UnitInteractionType.EVENT_CARD_GOING_TAP;
                break;
            case 2:
                unitInteractionType = UnitInteractionType.EVENT_CARD_MAYBE_TAP;
                break;
            case 3:
                unitInteractionType = UnitInteractionType.EVENT_CARD_NOT_GOING_TAP;
                break;
            default:
                return;
        }
        m24042a(unitInteractionType);
    }

    private void m24042a(UnitInteractionType unitInteractionType) {
        if (this.f20177w != null && this.f20178x != null && this.f20179y != null) {
            this.f20177w.m18941a(this.f20178x, this.f20179y, null, unitInteractionType, this.f20174t.eL_());
        }
    }
}
