package com.facebook.groups.widget.groupeventrow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.facebook.events.connectionqe.EventsConnectionExperimentController;
import com.facebook.events.connectionqe.EventsConnectionStyleExperiment.PublicEventAction;
import com.facebook.events.model.Event;
import com.facebook.events.widget.rsvpaction.EventRsvpActionBarButtonHelper.C27901;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.ui.animations.HeightAnimation;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: THREADS_AND_UNITS_LOADING */
public class GroupEventRsvpStatusButtonsView extends CustomLinearLayout {
    @Inject
    public DefaultGroupEventRowViewManager f23237a;
    @Inject
    public EventsConnectionExperimentController f23238b;
    public GroupEventRsvpViewListener f23239c;
    private FbButton f23240d;
    private FbButton f23241e;
    private FbButton f23242f;
    private FbButton[] f23243g;
    private OnClickListener f23244h;
    private OnClickListener f23245i;
    private OnClickListener f23246j;
    private OnClickListener f23247k;
    private OnClickListener f23248l;
    private OnClickListener f23249m;
    public Event f23250n;
    private View f23251o;

    /* compiled from: THREADS_AND_UNITS_LOADING */
    class C33523 implements AnimationListener {
        final /* synthetic */ GroupEventRsvpStatusButtonsView f23235a;

        C33523(GroupEventRsvpStatusButtonsView groupEventRsvpStatusButtonsView) {
            this.f23235a = groupEventRsvpStatusButtonsView;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f23235a.f23239c != null) {
                this.f23235a.f23239c.mo957a();
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* compiled from: THREADS_AND_UNITS_LOADING */
    /* synthetic */ class C33534 {
        static final /* synthetic */ int[] f23236a = new int[PublicEventAction.values().length];

        static {
            try {
                f23236a[PublicEventAction.PRIVATE_GOING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f23236a[PublicEventAction.PRIVATE_MAYBE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f23236a[PublicEventAction.PRIVATE_NOT_GOING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f23236a[PublicEventAction.WATCH_INTERESTED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f23236a[PublicEventAction.GOING.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f23236a[PublicEventAction.NOT_INTERESTED_OR_NOT_GOING_OR_IGNORE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    private static <T extends View> void m24574a(Class<T> cls, T t) {
        m24575a((Object) t, t.getContext());
    }

    private static void m24575a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        GroupEventRsvpStatusButtonsView groupEventRsvpStatusButtonsView = (GroupEventRsvpStatusButtonsView) obj;
        DefaultGroupEventRowViewManager a = DefaultGroupEventRowViewManager.m24559a(fbInjector);
        EventsConnectionExperimentController a2 = EventsConnectionExperimentController.a(fbInjector);
        groupEventRsvpStatusButtonsView.f23237a = a;
        groupEventRsvpStatusButtonsView.f23238b = a2;
    }

    public GroupEventRsvpStatusButtonsView(Context context) {
        super(context);
        m24573a();
    }

    public GroupEventRsvpStatusButtonsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24573a();
    }

    public GroupEventRsvpStatusButtonsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24573a();
    }

    private void m24573a() {
        m24574a(GroupEventRsvpStatusButtonsView.class, (View) this);
        setContentView(2130904654);
        this.f23251o = a(2131562669);
        this.f23240d = (FbButton) a(2131562670);
        this.f23241e = (FbButton) a(2131562671);
        this.f23242f = (FbButton) a(2131562672);
        this.f23243g = new FbButton[]{this.f23240d, this.f23241e, this.f23242f};
        for (FbButton fbButton : this.f23243g) {
            DefaultGroupEventRowViewManager defaultGroupEventRowViewManager = this.f23237a;
            fbButton.setTextColor(defaultGroupEventRowViewManager.f23204a.getColor(17170444));
            fbButton.setBackgroundDrawable(defaultGroupEventRowViewManager.f23204a.getDrawable(2130840639));
        }
        this.f23244h = m24570a(GraphQLEventGuestStatus.GOING);
        this.f23245i = m24570a(GraphQLEventGuestStatus.MAYBE);
        this.f23246j = m24570a(GraphQLEventGuestStatus.NOT_GOING);
        this.f23247k = m24571a(GraphQLEventWatchStatus.WATCHED);
        this.f23248l = m24571a(GraphQLEventWatchStatus.GOING);
        this.f23249m = m24571a(GraphQLEventWatchStatus.UNWATCHED);
    }

    public final void m24581a(Event event, GroupEventRsvpViewListener groupEventRsvpViewListener) {
        m24578c();
        this.f23250n = event;
        if (!Event.a(event) || 1 == 0) {
            this.f23240d.setText(2131242100);
            this.f23240d.setOnClickListener(this.f23244h);
            this.f23241e.setText(2131242101);
            this.f23241e.setOnClickListener(this.f23245i);
            this.f23242f.setText(2131242102);
            this.f23242f.setOnClickListener(this.f23246j);
        } else {
            ImmutableList b = EventsConnectionExperimentController.b();
            for (int i = 0; i < this.f23243g.length; i++) {
                int i2;
                FbButton fbButton = this.f23243g[i];
                PublicEventAction publicEventAction = (PublicEventAction) b.get(i);
                switch (C27901.f19632a[publicEventAction.ordinal()]) {
                    case 1:
                    case 2:
                        i2 = 2131233837;
                        break;
                    case 3:
                        i2 = 2131233838;
                        break;
                    case 4:
                        i2 = 2131233839;
                        break;
                    case 5:
                        i2 = 2131233840;
                        break;
                    case 6:
                        i2 = 2131233842;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                fbButton.setText(i2);
                fbButton.setOnClickListener(m24569a(publicEventAction));
            }
        }
        if (this.f23239c == null && groupEventRsvpViewListener != null) {
            this.f23239c = groupEventRsvpViewListener;
        }
    }

    private OnClickListener m24569a(PublicEventAction publicEventAction) {
        switch (C33534.f23236a[publicEventAction.ordinal()]) {
            case 1:
                return this.f23244h;
            case 2:
                return this.f23245i;
            case 3:
                return this.f23246j;
            case 4:
                return this.f23247k;
            case 5:
                return this.f23248l;
            case 6:
                return this.f23249m;
            default:
                return null;
        }
    }

    private OnClickListener m24570a(final GraphQLEventGuestStatus graphQLEventGuestStatus) {
        return new OnClickListener(this) {
            final /* synthetic */ GroupEventRsvpStatusButtonsView f23232b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 987569498);
                if (!(this.f23232b.f23250n == null || this.f23232b.f23239c == null)) {
                    GroupEventRsvpViewListener groupEventRsvpViewListener = this.f23232b.f23239c;
                    Event event = this.f23232b.f23250n;
                    GraphQLEventGuestStatus graphQLEventGuestStatus = graphQLEventGuestStatus;
                    this.f23232b.f23250n.D();
                    groupEventRsvpViewListener.mo960b(event, graphQLEventGuestStatus);
                    this.f23232b.f23239c;
                }
                Logger.a(2, EntryType.UI_INPUT_END, -2115446632, a);
            }
        };
    }

    private OnClickListener m24571a(final GraphQLEventWatchStatus graphQLEventWatchStatus) {
        return new OnClickListener(this) {
            final /* synthetic */ GroupEventRsvpStatusButtonsView f23234b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -212497395);
                if (!(this.f23234b.f23250n == null || this.f23234b.f23239c == null)) {
                    GroupEventRsvpViewListener groupEventRsvpViewListener = this.f23234b.f23239c;
                    Event event = this.f23234b.f23250n;
                    GraphQLEventWatchStatus graphQLEventWatchStatus = graphQLEventWatchStatus;
                    GraphQLEventWatchStatus graphQLEventWatchStatus2 = this.f23234b.f23250n.C;
                    groupEventRsvpViewListener.mo961b(event, graphQLEventWatchStatus);
                    this.f23234b.f23239c;
                }
                Logger.a(2, EntryType.UI_INPUT_END, 1168830557, a);
            }
        };
    }

    public static void m24577b(GroupEventRsvpStatusButtonsView groupEventRsvpStatusButtonsView) {
        HeightAnimation heightAnimation = new HeightAnimation(groupEventRsvpStatusButtonsView.f23251o, 0);
        heightAnimation.setDuration(200);
        heightAnimation.setAnimationListener(new C33523(groupEventRsvpStatusButtonsView));
        groupEventRsvpStatusButtonsView.startAnimation(heightAnimation);
    }

    private void m24578c() {
        if (getAnimation() != null) {
            clearAnimation();
        }
        m24579c(-1);
    }

    private void m24579c(int i) {
        this.f23251o.getLayoutParams().height = i;
        requestLayout();
    }

    public void setHorizontalMargin(int i) {
        if (this.f23251o != null) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f23251o.getLayoutParams();
            marginLayoutParams.setMargins(i, marginLayoutParams.topMargin, i, marginLayoutParams.bottomMargin);
        }
    }
}
