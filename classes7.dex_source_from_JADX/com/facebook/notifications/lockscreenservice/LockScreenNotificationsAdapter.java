package com.facebook.notifications.lockscreenservice;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ViewAnimator;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.apptab.state.TabTag;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.feed.PermalinkStoryIdParams.Builder;
import com.facebook.notifications.lockscreen.util.LockScreenNotification;
import com.facebook.notifications.lockscreen.util.PushNotification;
import com.facebook.notifications.lockscreenservice.LockScreenService.C06699;
import com.facebook.notifications.logging.NotificationType;
import com.facebook.notifications.util.NotificationStoryHelper$NotificationLocation;
import com.facebook.springs.SpringSystem;
import com.facebook.ui.animations.AnimationUtil;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@TargetApi(11)
@ContextScoped
/* compiled from: network_weak */
public class LockScreenNotificationsAdapter extends ArrayAdapter<LockScreenNotification> {
    public static final int f8239a = 2131558556;
    private static LockScreenNotificationsAdapter f8240k;
    private static final Object f8241l = new Object();
    public C06699 f8242b;
    private final Context f8243c;
    private final Provider<TimeFormatUtil> f8244d;
    private final PushNotificationRenderer f8245e;
    private final MessageNotificationRenderer f8246f;
    public final SpringSystem f8247g;
    public final AnimationUtil f8248h;
    public final LayoutInflater f8249i;
    private final Lazy<NavigationLogger> f8250j;

    private static LockScreenNotificationsAdapter m9830b(InjectorLike injectorLike) {
        return new LockScreenNotificationsAdapter((Context) injectorLike.getInstance(Context.class), IdBasedSingletonScopeProvider.a(injectorLike, 610), PushNotificationRenderer.m9965a(injectorLike), MessageNotificationRenderer.m9959a(injectorLike), SpringSystem.b(injectorLike), AnimationUtil.a(injectorLike), LayoutInflaterMethodAutoProvider.b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 137));
    }

    @Inject
    public LockScreenNotificationsAdapter(Context context, Provider<TimeFormatUtil> provider, PushNotificationRenderer pushNotificationRenderer, MessageNotificationRenderer messageNotificationRenderer, SpringSystem springSystem, AnimationUtil animationUtil, LayoutInflater layoutInflater, Lazy<NavigationLogger> lazy) {
        super(context, 2130905137);
        this.f8243c = context;
        this.f8244d = provider;
        this.f8245e = pushNotificationRenderer;
        this.f8246f = messageNotificationRenderer;
        this.f8247g = springSystem;
        this.f8248h = animationUtil;
        this.f8249i = layoutInflater;
        this.f8250j = lazy;
    }

    public static LockScreenNotificationsAdapter m9828a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LockScreenNotificationsAdapter b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8241l) {
                LockScreenNotificationsAdapter lockScreenNotificationsAdapter;
                if (a2 != null) {
                    lockScreenNotificationsAdapter = (LockScreenNotificationsAdapter) a2.a(f8241l);
                } else {
                    lockScreenNotificationsAdapter = f8240k;
                }
                if (lockScreenNotificationsAdapter == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9830b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8241l, b3);
                        } else {
                            f8240k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = lockScreenNotificationsAdapter;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public View getView(int i, @Nullable View view, ViewGroup viewGroup) {
        if (view == null) {
            View inflate = this.f8249i.inflate(2130905137, viewGroup, false);
            OnTouchListener springyPressStateTouchHandler = new SpringyPressStateTouchHandler(inflate, this.f8242b, this.f8247g, this.f8248h);
            springyPressStateTouchHandler.f8387g = true;
            inflate.setOnTouchListener(springyPressStateTouchHandler);
            view = inflate;
        }
        m9829a(view, (LockScreenNotification) getItem(i));
        return view;
    }

    public final void m9832a(List<? extends LockScreenNotification> list) {
        setNotifyOnChange(false);
        clear();
        setNotifyOnChange(true);
        addAll(list);
    }

    private void m9829a(View view, LockScreenNotification lockScreenNotification) {
        view.setTag(f8239a, lockScreenNotification);
        ((TextView) view.findViewById(2131563621)).setText(((TimeFormatUtil) this.f8244d.get()).a(TimeFormatStyle.HOUR_MINUTE_STYLE, lockScreenNotification.f8227a));
        if (lockScreenNotification instanceof PushNotification) {
            PushNotificationRenderer pushNotificationRenderer = this.f8245e;
            PushNotification pushNotification = (PushNotification) lockScreenNotification;
            TextView textView = (TextView) view.findViewById(2131563623);
            FbDraweeView fbDraweeView = (FbDraweeView) view.findViewById(2131563626);
            TextView textView2 = (TextView) view.findViewById(2131563622);
            ((ViewAnimator) view.findViewById(2131563625)).setDisplayedChild(0);
            textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, pushNotificationRenderer.f8372k, null);
            textView2.setText("");
            if (pushNotification.f8234g == null) {
                textView.setText(pushNotification.f8231d);
                if (pushNotification.f8233f == NotificationType.FRIEND_REQUEST && pushNotification.f8235h != null) {
                    Uri parse = Uri.parse(pushNotification.f8235h);
                    if (parse.isAbsolute()) {
                        fbDraweeView.a(parse, PushNotificationRenderer.f8361b);
                        return;
                    }
                }
                fbDraweeView.a(null, PushNotificationRenderer.f8361b);
                return;
            }
            GraphQLStory graphQLStory = (GraphQLStory) pushNotification.f8234g.a;
            String b = (StoryActorHelper.b(graphQLStory) == null || StoryActorHelper.b(graphQLStory).ai() == null) ? null : StoryActorHelper.b(graphQLStory).ai().b();
            if (b != null) {
                Uri parse2 = Uri.parse(b);
                if (parse2.isAbsolute()) {
                    fbDraweeView.a(parse2, PushNotificationRenderer.f8361b);
                }
            } else {
                fbDraweeView.a(null, PushNotificationRenderer.f8361b);
            }
            textView.setText(pushNotificationRenderer.f8366e.b(graphQLStory, NotificationStoryHelper$NotificationLocation.LOCK_SCREEN));
        } else if (lockScreenNotification instanceof MessageNotification) {
            this.f8246f.m9964a(view, (MessageNotification) lockScreenNotification);
        }
    }

    public final HoneyClientEvent m9831a(LockScreenNotification lockScreenNotification) {
        ((NavigationLogger) this.f8250j.get()).a("tap_lockscreen_notification");
        if (lockScreenNotification instanceof PushNotification) {
            GraphQLStory graphQLStory;
            Intent intent;
            PushNotificationRenderer pushNotificationRenderer = this.f8245e;
            PushNotification pushNotification = (PushNotification) lockScreenNotification;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("lockscreen_notification_click");
            honeyClientEvent.c = "notifications";
            HoneyClientEvent a = honeyClientEvent.a("notification_type_clicked", pushNotification.f8233f);
            if (pushNotification.f8234g != null) {
                a.a("notification_tracking", TrackableFeedProps.a(pushNotification.f8234g));
            }
            if (pushNotification.f8236i != null) {
                a.b("ndid", pushNotification.f8236i);
            }
            if (pushNotification.f8234g != null) {
                graphQLStory = (GraphQLStory) pushNotification.f8234g.a;
            } else {
                graphQLStory = null;
            }
            Intent a2 = pushNotificationRenderer.f8366e.a(pushNotificationRenderer.f8364c, graphQLStory);
            if (a2 == null) {
                a2 = pushNotificationRenderer.f8371j.a(pushNotification.f8233f, pushNotification.f8235h);
            }
            if (a2 != null || pushNotification.f8232e == null) {
                intent = a2;
            } else {
                Builder f = new Builder().e(graphQLStory).f(graphQLStory);
                f.a = pushNotification.f8232e;
                intent = pushNotificationRenderer.f8368g.a(f.a());
            }
            if (intent == null) {
                intent = pushNotificationRenderer.f8370i.a(pushNotificationRenderer.f8364c, FBLinks.cj);
            }
            if (!intent.hasExtra("target_tab_name")) {
                intent.putExtra("target_tab_name", TabTag.Notifications.name());
            }
            intent.putExtra("notification_launch_source", "source_lockscreen");
            if (BLog.b(4)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Notification intent: ");
                stringBuilder.append(intent.toString());
                stringBuilder.append(", type=");
                stringBuilder.append(intent.getType());
                stringBuilder.append(", extra=");
                stringBuilder.append(intent.getExtras());
                stringBuilder.append(", notification type=");
                stringBuilder.append(pushNotification.f8233f);
            }
            intent.setFlags(268435456);
            pushNotificationRenderer.f8369h.a(intent, pushNotificationRenderer.f8364c);
            if (pushNotification.f8232e != null) {
                pushNotificationRenderer.f8367f.a(ImmutableList.of(pushNotification.f8232e), GraphQLStorySeenState.SEEN_AND_READ);
            }
            return a;
        } else if (lockScreenNotification instanceof MessageNotification) {
            return MessageNotificationRenderer.m9958a((MessageNotification) lockScreenNotification);
        } else {
            return null;
        }
    }
}
