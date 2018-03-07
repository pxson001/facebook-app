package com.facebook.events.dashboard;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.ContentResolver;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.dashboard.EventsDashboardRowInlineRsvpView.RsvpActionListener;
import com.facebook.events.dashboard.EventsDashboardRowRsvpStatusView.State;
import com.facebook.events.data.EventsCommonContract;
import com.facebook.events.data.EventsProvider;
import com.facebook.events.eventsevents.EventsEventBus;
import com.facebook.events.eventsevents.EventsEvents.EventIgnoredEvent;
import com.facebook.events.eventsevents.EventsEvents.EventStatus;
import com.facebook.events.model.Event;
import com.facebook.events.model.Event.Builder;
import com.facebook.events.mutators.PublicEventsRsvpMutator;
import com.facebook.events.permalink.actionbar.ActionItemRsvp;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.inject.Assisted;
import com.facebook.ui.animations.BaseAnimatorListener;
import com.facebook.ui.animations.BounceAnimationCreator;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.inject.Inject;

/* compiled from: com.facebook.work.reauth.POP_REAUTH_NOTIF */
public class InlineRsvpActionController implements RsvpActionListener {
    private final ActionItemRsvp f16947a;
    private final PublicEventsRsvpMutator f16948b;
    private final EventsDashboardRowView f16949c;
    public final EventsEventBus f16950d;
    private final TasksManager f16951e;
    public final ContentResolver f16952f;
    public final EventsCommonContract f16953g;
    public final ListeningExecutorService f16954h;
    public Animator f16955i;
    public AnimationState f16956j;
    public EventAnalyticsParams f16957k = EventAnalyticsParams.a;

    /* compiled from: com.facebook.work.reauth.POP_REAUTH_NOTIF */
    class C23817 extends BaseAnimatorListener {
        final /* synthetic */ InlineRsvpActionController f16946a;

        C23817(InlineRsvpActionController inlineRsvpActionController) {
            this.f16946a = inlineRsvpActionController;
        }

        public void onAnimationStart(Animator animator) {
            this.f16946a.f16955i = animator;
        }

        public void onAnimationEnd(Animator animator) {
            this.f16946a.f16955i = null;
        }

        public void onAnimationCancel(Animator animator) {
            this.f16946a.f16955i = null;
        }
    }

    /* compiled from: com.facebook.work.reauth.POP_REAUTH_NOTIF */
    enum AnimationState {
        RSVP_BAR_HIDDEN,
        SET_OPTIMISTIC_GUEST_STATUS
    }

    @Inject
    public InlineRsvpActionController(@Assisted EventsDashboardRowView eventsDashboardRowView, ListeningExecutorService listeningExecutorService, ActionItemRsvp actionItemRsvp, ContentResolver contentResolver, EventsCommonContract eventsCommonContract, PublicEventsRsvpMutator publicEventsRsvpMutator, EventsEventBus eventsEventBus, TasksManager tasksManager) {
        this.f16949c = eventsDashboardRowView;
        this.f16947a = actionItemRsvp;
        this.f16948b = publicEventsRsvpMutator;
        this.f16950d = eventsEventBus;
        this.f16951e = tasksManager;
        this.f16952f = contentResolver;
        this.f16953g = eventsCommonContract;
        this.f16954h = listeningExecutorService;
    }

    public final void mo791a(Event event, GraphQLEventGuestStatus graphQLEventGuestStatus) {
        final State boundModelAndState = this.f16949c.f16751j.getBoundModelAndState();
        Builder builder = new Builder(event);
        builder.G = false;
        builder = builder;
        builder.B = graphQLEventGuestStatus;
        Event b = builder.b();
        m17284b(b);
        this.f16947a.m18406a(event, this.f16957k);
        this.f16947a.m18409a(graphQLEventGuestStatus, b, ActionMechanism.DASHBOARD_ROW_INLINE_ACTIONS, true, new FutureCallback<EventStatus>(this) {
            final /* synthetic */ InlineRsvpActionController f16931b;

            public void onSuccess(Object obj) {
                if (((EventStatus) obj) == EventStatus.FAILURE) {
                    InlineRsvpActionController.m17283a(this.f16931b, boundModelAndState);
                }
            }

            public void onFailure(Throwable th) {
                InlineRsvpActionController.m17283a(this.f16931b, boundModelAndState);
            }
        }, null);
    }

    public final void mo790a(final Event event, ActionMechanism actionMechanism, final GraphQLEventWatchStatus graphQLEventWatchStatus) {
        final State boundModelAndState = this.f16949c.f16751j.getBoundModelAndState();
        GraphQLEventGuestStatus a = Event.a(graphQLEventWatchStatus);
        Builder builder = new Builder(event);
        builder.G = false;
        builder = builder;
        builder.B = a;
        Builder builder2 = builder;
        builder2.C = graphQLEventWatchStatus;
        Event b = builder2.b();
        boolean z = graphQLEventWatchStatus == GraphQLEventWatchStatus.UNWATCHED;
        if (z) {
            this.f16949c.m17144a();
        }
        m17284b(b);
        if (z) {
            this.f16950d.a(new EventIgnoredEvent(b, false));
        }
        EventsProvider.a(this.f16952f, this.f16953g, b, this.f16954h);
        this.f16951e.a(this, this.f16948b.a(event.a, graphQLEventWatchStatus, this.f16957k, actionMechanism), new AbstractDisposableFutureCallback(this) {
            final /* synthetic */ InlineRsvpActionController f16935d;

            protected final void m17280a(Object obj) {
            }

            protected final void m17281a(Throwable th) {
                InlineRsvpActionController.m17283a(this.f16935d, boundModelAndState);
                if (graphQLEventWatchStatus == GraphQLEventWatchStatus.UNWATCHED) {
                    this.f16935d.f16950d.a(new EventIgnoredEvent(event, true));
                }
                EventsProvider.a(this.f16935d.f16952f, this.f16935d.f16953g, event, this.f16935d.f16954h);
            }
        });
    }

    private AnimatorSet m17285c() {
        final EventsDashboardRowInlineRsvpView eventsDashboardRowInlineRsvpView = this.f16949c.f16750i;
        Preconditions.checkArgument(eventsDashboardRowInlineRsvpView != null);
        final int i = eventsDashboardRowInlineRsvpView.getLayoutParams().height;
        TimeInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, 0});
        ofInt.setInterpolator(accelerateDecelerateInterpolator);
        ofInt.addUpdateListener(new AnimatorUpdateListener(this) {
            final /* synthetic */ InlineRsvpActionController f16937b;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                eventsDashboardRowInlineRsvpView.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                eventsDashboardRowInlineRsvpView.requestLayout();
            }
        });
        ofInt.addListener(new BaseAnimatorListener(this) {
            final /* synthetic */ InlineRsvpActionController f16940c;

            public void onAnimationEnd(Animator animator) {
                eventsDashboardRowInlineRsvpView.getLayoutParams().height = i;
            }

            public void onAnimationCancel(Animator animator) {
                eventsDashboardRowInlineRsvpView.getLayoutParams().height = i;
            }
        });
        ofInt.setDuration(200);
        Animator ofFloat = ObjectAnimator.ofFloat(eventsDashboardRowInlineRsvpView, "alpha", new float[]{1.0f, 0.0f});
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.setDuration(200);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofInt, ofFloat});
        animatorSet.addListener(new BaseAnimatorListener(this) {
            final /* synthetic */ InlineRsvpActionController f16942b;

            public void onAnimationEnd(Animator animator) {
                this.f16942b.f16956j = AnimationState.RSVP_BAR_HIDDEN;
                eventsDashboardRowInlineRsvpView.setVisibility(8);
                eventsDashboardRowInlineRsvpView.setAlpha(1.0f);
            }

            public void onAnimationCancel(Animator animator) {
                eventsDashboardRowInlineRsvpView.setAlpha(1.0f);
            }
        });
        return animatorSet;
    }

    private AnimatorSet m17282a(final Event event) {
        final EventsDashboardRowRsvpStatusView eventsDashboardRowRsvpStatusView = this.f16949c.f16751j;
        Animator ofFloat = ObjectAnimator.ofFloat(eventsDashboardRowRsvpStatusView, "scaleX", new float[]{0.25f, 1.25f});
        Animator ofFloat2 = ObjectAnimator.ofFloat(eventsDashboardRowRsvpStatusView, "scaleY", new float[]{0.25f, 1.25f});
        ofFloat.setDuration(200);
        ofFloat2.setDuration(200);
        Animator ofFloat3 = ObjectAnimator.ofFloat(eventsDashboardRowRsvpStatusView, "scaleX", new float[]{1.0f});
        Animator ofFloat4 = ObjectAnimator.ofFloat(eventsDashboardRowRsvpStatusView, "scaleY", new float[]{1.0f});
        ofFloat3.setDuration(200);
        ofFloat4.setDuration(200);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.play(ofFloat).before(ofFloat3);
        animatorSet.play(ofFloat3).with(ofFloat4);
        animatorSet.play(ofFloat3).before(BounceAnimationCreator.a(eventsDashboardRowRsvpStatusView, "scaleX", "scaleY"));
        animatorSet.addListener(new BaseAnimatorListener(this) {
            final /* synthetic */ InlineRsvpActionController f16945c;

            public void onAnimationStart(Animator animator) {
                this.f16945c.f16956j = AnimationState.SET_OPTIMISTIC_GUEST_STATUS;
                eventsDashboardRowRsvpStatusView.setOptimisticEvent(event);
            }
        });
        return animatorSet;
    }

    private void m17284b(Event event) {
        this.f16956j = null;
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSet.Builder play = animatorSet.play(m17285c());
        if (play != null) {
            if (event.D() != GraphQLEventGuestStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
                play.before(m17282a(event));
            }
            animatorSet.addListener(new C23817(this));
            animatorSet.start();
        }
    }

    public static void m17283a(InlineRsvpActionController inlineRsvpActionController, State state) {
        EventsDashboardRowInlineRsvpView eventsDashboardRowInlineRsvpView = inlineRsvpActionController.f16949c.f16750i;
        Preconditions.checkArgument(eventsDashboardRowInlineRsvpView != null);
        if (inlineRsvpActionController.f16956j == AnimationState.RSVP_BAR_HIDDEN) {
            eventsDashboardRowInlineRsvpView.setVisibility(0);
        } else if (inlineRsvpActionController.f16956j == AnimationState.SET_OPTIMISTIC_GUEST_STATUS) {
            eventsDashboardRowInlineRsvpView.setVisibility(0);
            inlineRsvpActionController.f16949c.f16751j.m17134a(state);
        }
        inlineRsvpActionController.m17288b();
    }

    public final void m17288b() {
        this.f16956j = null;
        if (this.f16955i != null) {
            this.f16955i.cancel();
        }
    }
}
