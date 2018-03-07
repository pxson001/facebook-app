package com.facebook.events.permalink.guestlist;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.permalink.guestlist.common.EventGuestListType;
import com.facebook.events.permalink.guestlist.common.EventsGuestListInitializationModel;
import com.facebook.events.prefs.EventsPrefKeys;
import com.facebook.fbui.widget.megaphone.Megaphone;
import com.facebook.fbui.widget.megaphone.Megaphone.OnDismissListener;
import com.facebook.graphql.enums.GraphQLEventPrivacyType;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import javax.inject.Inject;

/* compiled from: boarding_pass_data */
public class EventSeenStateMegaphoneController {
    public Context f18506a;
    public AnalyticsLogger f18507b;
    public String f18508c;
    private boolean f18509d;
    private boolean f18510e;
    public InterstitialManager f18511f;
    private View f18512g;
    public SecureContextHelper f18513h;
    private String f18514i;
    private Megaphone f18515j;
    public TipSeenTracker f18516k;

    /* compiled from: boarding_pass_data */
    class C26281 implements OnClickListener {
        final /* synthetic */ EventSeenStateMegaphoneController f18504a;

        C26281(EventSeenStateMegaphoneController eventSeenStateMegaphoneController) {
            this.f18504a = eventSeenStateMegaphoneController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1936211226);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("https://m.facebook.com/help/317897961560790"));
            this.f18504a.f18513h.b(intent, this.f18504a.f18506a);
            Logger.a(2, EntryType.UI_INPUT_END, -1945177256, a);
        }
    }

    /* compiled from: boarding_pass_data */
    class C26292 implements OnDismissListener {
        final /* synthetic */ EventSeenStateMegaphoneController f18505a;

        C26292(EventSeenStateMegaphoneController eventSeenStateMegaphoneController) {
            this.f18505a = eventSeenStateMegaphoneController;
        }

        public final void m18844a(Megaphone megaphone) {
            megaphone.setVisibility(8);
            this.f18505a.f18516k.b();
        }
    }

    public static EventSeenStateMegaphoneController m18847b(InjectorLike injectorLike) {
        return new EventSeenStateMegaphoneController((Context) injectorLike.getInstance(Context.class), AnalyticsLoggerMethodAutoProvider.a(injectorLike), InterstitialManager.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), TipSeenTracker.b(injectorLike));
    }

    @Inject
    public EventSeenStateMegaphoneController(Context context, AnalyticsLogger analyticsLogger, InterstitialManager interstitialManager, SecureContextHelper secureContextHelper, TipSeenTracker tipSeenTracker) {
        this.f18506a = context;
        this.f18507b = analyticsLogger;
        this.f18511f = interstitialManager;
        this.f18513h = secureContextHelper;
        this.f18516k = tipSeenTracker;
    }

    public final void m18851a(String str, Boolean bool, GraphQLEventPrivacyType graphQLEventPrivacyType, View view) {
        this.f18508c = str;
        this.f18509d = bool.booleanValue();
        this.f18510e = m18846a(graphQLEventPrivacyType);
        this.f18512g = view;
        this.f18514i = this.f18506a.getResources().getString(2131237207);
        m18845a();
    }

    private void m18845a() {
        this.f18516k.a(EventsPrefKeys.f19007a);
        this.f18516k.b = 2;
    }

    public final void m18849a(EventGuestListType eventGuestListType) {
        if (m18848b(eventGuestListType) && this.f18516k.c()) {
            Object obj;
            InterstitialController a = this.f18511f.a(GuestListSeenStateInterstitialController.a, GuestListSeenStateInterstitialController.class);
            if (a == null || !Objects.equal(a.b(), "3763")) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                if (this.f18512g == null) {
                    this.f18515j.setVisibility(0);
                    return;
                }
                ViewStub viewStub = (ViewStub) this.f18512g;
                viewStub.setLayoutResource(2130904167);
                this.f18515j = (Megaphone) viewStub.inflate();
                this.f18515j.setSubtitle(this.f18514i);
                this.f18515j.setShowSecondaryButton(false);
                this.f18515j.setVisibility(0);
                this.f18515j.setOnPrimaryButtonClickListener(new C26281(this));
                this.f18515j.m = new C26292(this);
                HoneyClientEvent honeyClientEvent = new HoneyClientEvent("event_seen_state_megaphone_show");
                honeyClientEvent.c = "event_guest_list";
                honeyClientEvent = honeyClientEvent;
                honeyClientEvent.e = this.f18508c;
                this.f18507b.c(honeyClientEvent);
                this.f18516k.a();
                this.f18511f.a().a("3763");
                this.f18512g = null;
                return;
            }
        }
        if (this.f18515j != null) {
            this.f18515j.setVisibility(8);
        }
    }

    public final void m18850a(EventsGuestListInitializationModel eventsGuestListInitializationModel, View view) {
        String string;
        this.f18508c = eventsGuestListInitializationModel.b;
        this.f18509d = eventsGuestListInitializationModel.i;
        this.f18510e = m18846a(eventsGuestListInitializationModel.d());
        this.f18512g = view;
        if (eventsGuestListInitializationModel.g) {
            string = this.f18506a.getResources().getString(2131237207);
        } else {
            string = this.f18506a.getResources().getString(2131237208);
        }
        this.f18514i = string;
        m18845a();
    }

    @VisibleForTesting
    private boolean m18848b(EventGuestListType eventGuestListType) {
        return this.f18510e && this.f18509d && eventGuestListType == EventGuestListType.PRIVATE_INVITED;
    }

    private static boolean m18846a(GraphQLEventPrivacyType graphQLEventPrivacyType) {
        return graphQLEventPrivacyType == GraphQLEventPrivacyType.PRIVATE_TYPE || graphQLEventPrivacyType == GraphQLEventPrivacyType.GROUP;
    }
}
