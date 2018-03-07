package com.facebook.events.ui.privacy;

import android.content.Context;
import com.facebook.events.model.PrivacyType;
import com.facebook.events.prefs.EventsPrefKeys;
import com.facebook.graphql.calls.EventCreateInputData.EventVisibility;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: appcenter */
public class PrivacyPickerNikumanController {
    private PrivacyPickerNikuman f19534a;
    private PrivacyOptionCheckbox f19535b;
    @Nullable
    private EventCreationEducationWidget f19536c;
    @Nullable
    private EventCreationPrivacyEducationWidgetRedesign f19537d;
    public PrivacyType f19538e;
    public boolean f19539f;
    private boolean f19540g;
    private boolean f19541h;
    private final Context f19542i;
    public boolean f19543j;
    public final InterstitialManager f19544k;
    public final TipSeenTracker f19545l;
    public String f19546m;

    /* compiled from: appcenter */
    class C27801 implements OnDrawListener {
        final /* synthetic */ PrivacyPickerNikumanController f19531a;

        C27801(PrivacyPickerNikumanController privacyPickerNikumanController) {
            this.f19531a = privacyPickerNikumanController;
        }

        public final boolean gD_() {
            this.f19531a.f19545l.a();
            this.f19531a.f19544k.a().a("3764");
            this.f19531a.f19543j = true;
            return true;
        }
    }

    /* compiled from: appcenter */
    class C27812 implements OnDrawListener {
        final /* synthetic */ PrivacyPickerNikumanController f19532a;

        C27812(PrivacyPickerNikumanController privacyPickerNikumanController) {
            this.f19532a = privacyPickerNikumanController;
        }

        public final boolean gD_() {
            this.f19532a.f19545l.a();
            this.f19532a.f19544k.a().a("3764");
            this.f19532a.f19543j = true;
            return true;
        }
    }

    /* compiled from: appcenter */
    /* synthetic */ class C27823 {
        static final /* synthetic */ int[] f19533a = new int[PrivacyType.values().length];

        static {
            try {
                f19533a[PrivacyType.FRIENDS_OF_FRIENDS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f19533a[PrivacyType.FRIENDS_OF_GUESTS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f19533a[PrivacyType.INVITE_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f19533a[PrivacyType.PAGE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f19533a[PrivacyType.USER_PUBLIC.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f19533a[PrivacyType.COMMUNITY.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f19533a[PrivacyType.GROUP.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public static PrivacyPickerNikumanController m19735b(InjectorLike injectorLike) {
        return new PrivacyPickerNikumanController((Context) injectorLike.getInstance(Context.class), InterstitialManager.a(injectorLike), TipSeenTracker.b(injectorLike));
    }

    public static PrivacyPickerNikumanController m19732a(InjectorLike injectorLike) {
        return m19735b(injectorLike);
    }

    @Inject
    public PrivacyPickerNikumanController(Context context, InterstitialManager interstitialManager, TipSeenTracker tipSeenTracker) {
        this.f19542i = context;
        this.f19544k = interstitialManager;
        this.f19545l = tipSeenTracker;
        this.f19545l.a(EventsPrefKeys.f19008b);
        this.f19545l.b = 5;
    }

    public final void m19748a(PrivacyPickerNikuman privacyPickerNikuman, PrivacyOptionCheckbox privacyOptionCheckbox) {
        this.f19534a = privacyPickerNikuman;
        this.f19535b = privacyOptionCheckbox;
        this.f19543j = false;
    }

    public final void m19751a(boolean z) {
        this.f19541h = z;
        if (this.f19534a != null) {
            this.f19534a.setPrivacyLocked(z);
        }
    }

    public final void m19750a(String str, GraphQLGroupVisibility graphQLGroupVisibility, @Nullable String str2) {
        if (str != null && graphQLGroupVisibility != null && graphQLGroupVisibility != GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            m19751a(true);
            if (!Strings.isNullOrEmpty(str2) && graphQLGroupVisibility == GraphQLGroupVisibility.OPEN) {
                this.f19546m = str2;
                m19744a(PrivacyType.COMMUNITY, true);
            } else if (graphQLGroupVisibility != GraphQLGroupVisibility.OPEN) {
                this.f19546m = str;
                m19744a(PrivacyType.GROUP, true);
            } else {
                m19744a(PrivacyType.USER_PUBLIC, true);
            }
        }
    }

    public final void m19742a() {
        m19751a(true);
        m19743a(PrivacyType.PAGE);
    }

    public final void m19743a(PrivacyType privacyType) {
        if (privacyType == null) {
            privacyType = this.f19538e;
        }
        m19745a(privacyType, this.f19539f, this.f19540g);
    }

    public final void m19744a(PrivacyType privacyType, boolean z) {
        if (privacyType == null) {
            privacyType = this.f19538e;
        }
        m19745a(privacyType, z, true);
    }

    public final void m19745a(PrivacyType privacyType, boolean z, boolean z2) {
        CharSequence a;
        this.f19538e = privacyType;
        this.f19539f = z;
        this.f19540g = z2;
        if (this.f19535b != null) {
            this.f19535b.m19681a(privacyType, z);
        }
        if (this.f19534a != null) {
            boolean z3;
            this.f19534a.m19729a(privacyType, z, this.f19540g, m19752b());
            PrivacyPickerNikuman privacyPickerNikuman = this.f19534a;
            if (privacyType == PrivacyType.FRIENDS_OF_GUESTS) {
                z3 = true;
            } else {
                z3 = false;
            }
            privacyPickerNikuman.f19519e = z3;
        }
        if (this.f19536c != null) {
            a = this.f19536c.m19667a(privacyType, z);
            if (a == null || this.f19543j) {
                this.f19536c.m19668a(a);
            } else if (this.f19545l.c() && m19739g()) {
                this.f19536c.m19668a(a);
            } else {
                this.f19536c.m19668a(null);
            }
        }
        if (this.f19537d != null) {
            a = this.f19537d.m19670a(privacyType);
            if (a == null || this.f19543j) {
                this.f19537d.m19671a(a);
            } else if (this.f19545l.c() && m19739g()) {
                this.f19537d.m19671a(a);
            } else {
                this.f19537d.m19671a(null);
            }
        }
    }

    private boolean m19739g() {
        EventsPrivacyEducationInterstitialController eventsPrivacyEducationInterstitialController = (EventsPrivacyEducationInterstitialController) this.f19544k.a(EventsPrivacyEducationInterstitialController.a, EventsPrivacyEducationInterstitialController.class);
        return eventsPrivacyEducationInterstitialController != null && Objects.equal(eventsPrivacyEducationInterstitialController.b(), "3764");
    }

    public final void m19749a(String str) {
        this.f19546m = str;
    }

    public final String m19752b() {
        if (this.f19540g || this.f19541h) {
            return m19737b(this.f19538e);
        }
        return this.f19542i.getResources().getString(m19738c(this.f19538e));
    }

    public final PrivacyType m19753c() {
        return this.f19538e;
    }

    public final EventVisibility m19754d() {
        switch (C27823.f19533a[this.f19538e.ordinal()]) {
            case 1:
                return EventVisibility.FRIENDS_OF_FRIENDS;
            case 2:
                return EventVisibility.FRIENDS_OF_GUESTS;
            case 3:
                return EventVisibility.INVITE_ONLY;
            case 4:
                return EventVisibility.PAGE;
            case 5:
                return EventVisibility.USER_PUBLIC;
            case 6:
                return EventVisibility.COMMUNITY;
            default:
                return EventVisibility.GROUP;
        }
    }

    public final boolean m19755e() {
        return this.f19539f;
    }

    private String m19740h() {
        if (this.f19546m == null) {
            return this.f19542i.getResources().getString(2131241654);
        }
        return this.f19542i.getResources().getString(2131241652, new Object[]{this.f19546m});
    }

    private String m19741i() {
        if (Strings.isNullOrEmpty(this.f19534a.f19530p)) {
            return "Community Event";
        }
        return this.f19542i.getResources().getString(2131241652, new Object[]{r0});
    }

    private String m19737b(PrivacyType privacyType) {
        switch (C27823.f19533a[privacyType.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return this.f19542i.getResources().getString(2131241638);
            case 4:
                if (this.f19541h) {
                    return this.f19542i.getResources().getString(2131241665);
                }
                break;
            case 5:
                break;
            case 6:
                return m19741i();
            case 7:
                return m19740h();
            default:
                throw new IllegalArgumentException("Unsupported events privacy type: " + privacyType);
        }
        return this.f19542i.getResources().getString(2131241639);
    }

    private static int m19738c(PrivacyType privacyType) {
        switch (C27823.f19533a[privacyType.ordinal()]) {
            case 2:
                return 2131241643;
            case 3:
                return 2131241649;
            case 5:
                return 2131241637;
            default:
                throw new IllegalArgumentException("Unsupported events privacy type: " + privacyType);
        }
    }

    public final void m19746a(@Nullable EventCreationEducationWidget eventCreationEducationWidget) {
        this.f19536c = eventCreationEducationWidget;
        if (eventCreationEducationWidget != null) {
            eventCreationEducationWidget.setOnDrawListenerTo(new C27801(this));
        }
    }

    public final void m19747a(@Nullable EventCreationPrivacyEducationWidgetRedesign eventCreationPrivacyEducationWidgetRedesign) {
        this.f19537d = eventCreationPrivacyEducationWidgetRedesign;
        if (this.f19537d != null) {
            this.f19537d.setOnDrawListenerTo(new C27812(this));
        }
    }

    public final String m19756f() {
        switch (C27823.f19533a[this.f19538e.ordinal()]) {
            case 4:
                return "page_create_dialog";
            case 5:
                return "user_public_create_dialog";
            case 7:
                return "group_create_dialog";
            default:
                return "user_create_dialog";
        }
    }
}
