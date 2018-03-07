package com.facebook.events.permalink;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.events.activity.EventCreationActivity;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventActionContext;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.create.EventCreationNikumanActivity;
import com.facebook.events.dashboard.suggestions.EventsSuggestionsFragment;
import com.facebook.events.model.Event;
import com.facebook.events.model.EventArtist;
import com.facebook.events.model.EventUser;
import com.facebook.events.model.EventUser.EventUserType;
import com.facebook.events.permalinkintent.EventPermalinkIntentBuilder;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.timeline.intent.ModelBundle;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: canvas_depth */
public class EventPermalinkController {
    public final Provider<IFeedIntentBuilder> f17854a;
    public final SecureContextHelper f17855b;
    private final Product f17856c;
    public final Provider<ComponentName> f17857d;
    private final Provider<ViewerContext> f17858e;
    private final EventPermalinkIntentBuilder f17859f;

    /* compiled from: canvas_depth */
    /* synthetic */ class C25261 {
        static final /* synthetic */ int[] f17853a = new int[EventUserType.values().length];

        static {
            try {
                f17853a[EventUserType.USER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f17853a[EventUserType.PAGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static EventPermalinkController m18262b(InjectorLike injectorLike) {
        return new EventPermalinkController(IdBasedSingletonScopeProvider.a(injectorLike, 2347), ProductMethodAutoProvider.b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), IdBasedProvider.a(injectorLike, 12), IdBasedProvider.a(injectorLike, 372), EventPermalinkIntentBuilder.a(injectorLike));
    }

    public static EventPermalinkController m18257a(InjectorLike injectorLike) {
        return m18262b(injectorLike);
    }

    @Inject
    public EventPermalinkController(Provider<IFeedIntentBuilder> provider, Product product, SecureContextHelper secureContextHelper, @FragmentChromeActivity Provider<ComponentName> provider2, Provider<ViewerContext> provider3, EventPermalinkIntentBuilder eventPermalinkIntentBuilder) {
        this.f17854a = provider;
        this.f17856c = product;
        this.f17855b = secureContextHelper;
        this.f17857d = provider2;
        this.f17858e = provider3;
        this.f17859f = eventPermalinkIntentBuilder;
    }

    public final void m18266a(@Nonnull Context context, Event event, EventActionContext eventActionContext) {
        this.f17859f.a(context, event.a, eventActionContext);
    }

    public final void m18268a(Context context, EventUser eventUser) {
        Bundle bundle;
        String formatStrLocaleSafe;
        switch (C25261.f17853a[eventUser.a.ordinal()]) {
            case 1:
                Bundle bundle2 = new Bundle();
                ModelBundle.a(bundle2, eventUser.b, eventUser.d, eventUser.c);
                bundle = bundle2;
                formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, eventUser.b);
                break;
            case 2:
                formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.af, eventUser.b);
                bundle = null;
                break;
            default:
                BLog.b("EventPermalinkController", "Unknown event eventUser type %s", new Object[]{eventUser.a});
                return;
        }
        ((IFeedIntentBuilder) this.f17854a.get()).a(context, formatStrLocaleSafe, bundle, null);
    }

    public final void m18267a(Context context, EventArtist eventArtist) {
        this.f17855b.a(((IFeedIntentBuilder) this.f17854a.get()).b(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.af, eventArtist.a)), context);
    }

    public final void m18273b(Context context, String str, ImmutableList<EventArtist> immutableList) {
        Intent component = new Intent().setComponent((ComponentName) this.f17857d.get());
        component.putExtra("target_fragment", ContentFragmentType.EVENTS_HOSTS_FRAGMENT.ordinal());
        Bundle bundle = new Bundle();
        bundle.putString("EVENT_ID", str);
        bundle.putParcelableArrayList("ARTISTS", Lists.a(immutableList));
        component.putExtras(bundle);
        this.f17855b.a(component, context);
    }

    public final void m18263a(Context context) {
        m18260a(context, false);
    }

    public final void m18270b(Context context) {
        m18260a(context, true);
    }

    private void m18260a(Context context, boolean z) {
        Intent component = new Intent().setComponent((ComponentName) this.f17857d.get());
        component.putExtra("target_fragment", ContentFragmentType.EVENTS_UPCOMING_BIRTHDAYS_FRAGMENT.ordinal());
        component.putExtra("birthday_view_referrer_param", "EventsDashboardFragment");
        if (z) {
            component.setFlags(268435456);
        }
        this.f17855b.a(component, context);
    }

    public final void m18265a(Context context, EventAnalyticsParams eventAnalyticsParams, ActionMechanism actionMechanism) {
        m18259a(context, eventAnalyticsParams, actionMechanism, false);
    }

    public final void m18272b(Context context, EventAnalyticsParams eventAnalyticsParams, ActionMechanism actionMechanism) {
        m18259a(context, eventAnalyticsParams, actionMechanism, true);
    }

    private void m18259a(Context context, EventAnalyticsParams eventAnalyticsParams, ActionMechanism actionMechanism, boolean z) {
        Activity activity = (Activity) ContextUtils.a(context, Activity.class);
        if (activity == null) {
            this.f17855b.a(m18261b(context, eventAnalyticsParams, actionMechanism, z), context);
            return;
        }
        this.f17855b.a(m18261b(activity, eventAnalyticsParams, actionMechanism, z), 106, activity);
    }

    private Intent m18261b(Context context, EventAnalyticsParams eventAnalyticsParams, ActionMechanism actionMechanism, boolean z) {
        Intent a;
        Long valueOf = Long.valueOf(Long.parseLong(((ViewerContext) this.f17858e.get()).mUserId));
        if (this.f17856c != Product.PAA) {
            a = EventCreationNikumanActivity.m16516a(context, valueOf, eventAnalyticsParams.d, actionMechanism);
        } else {
            a = EventCreationActivity.m16340a(context, valueOf, eventAnalyticsParams.d, actionMechanism);
        }
        if (z) {
            a.setFlags(268435456);
        }
        return a;
    }

    public final void m18269a(Context context, String str, String str2, EventActionContext eventActionContext, String str3) {
        Intent component = new Intent().setComponent((ComponentName) this.f17857d.get());
        component.putExtra("target_fragment", ContentFragmentType.EVENTS_SUGGESTIONS_FRAGMENT.ordinal());
        component.putExtras(EventsSuggestionsFragment.m17525a(str, str2, eventActionContext, str3));
        component.setFlags(268435456);
        this.f17855b.a(component, context);
    }

    public final void m18264a(Context context, EventActionContext eventActionContext, String str) {
        m18258a(context, eventActionContext, str, false);
    }

    public final void m18271b(Context context, EventActionContext eventActionContext, String str) {
        m18258a(context, eventActionContext, str, true);
    }

    private void m18258a(Context context, EventActionContext eventActionContext, String str, boolean z) {
        Intent component = new Intent().setComponent((ComponentName) this.f17857d.get());
        component.putExtra("target_fragment", ContentFragmentType.EVENTS_SUBSCRIPTIONS_FRAGMENT.ordinal());
        Bundle bundle = new Bundle();
        bundle.putParcelable("extras_event_action_context", eventActionContext);
        bundle.putString("extra_ref_module", str.toString());
        component.putExtras(bundle);
        if (z) {
            component.setFlags(268435456);
        }
        this.f17855b.a(component, context);
    }
}
