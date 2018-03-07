package com.facebook.events.permalink.messageguests;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.permalink.guestlist.EventSeenStateMegaphoneController;
import com.facebook.events.permalink.guestlist.common.EventGuestListType;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator;
import com.facebook.graphql.enums.GraphQLEventPrivacyType;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.sharing.sendasmessage.SendAsMessageUtil;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: best_device */
public class EventMessageGuestsFrameFragment extends FbFragment implements AnalyticsFragmentWithExtraData, CanHandleBackPressed {
    @Inject
    public EventSeenStateMegaphoneController f18659a;
    private int al;
    @Inject
    public SendAsMessageUtil f18660b;
    @Inject
    public EventEventLogger f18661c;
    public EventMessageGuestsPagerAdapter f18662d;
    private FbTextView f18663e;
    private HasTitleBar f18664f;
    private TitleBarButtonSpec f18665g;
    private FbTextView f18666h;
    private boolean f18667i;

    /* compiled from: best_device */
    public class C26571 {
        public final /* synthetic */ EventMessageGuestsFrameFragment f18654a;

        C26571(EventMessageGuestsFrameFragment eventMessageGuestsFrameFragment) {
            this.f18654a = eventMessageGuestsFrameFragment;
        }
    }

    /* compiled from: best_device */
    class C26582 extends OnToolbarButtonListener {
        final /* synthetic */ EventMessageGuestsFrameFragment f18655a;

        C26582(EventMessageGuestsFrameFragment eventMessageGuestsFrameFragment) {
            this.f18655a = eventMessageGuestsFrameFragment;
        }

        public final void m18965a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            Set d = this.f18655a.f18662d.m18979d();
            if (d != null && !d.isEmpty()) {
                EventMessageGuestsFrameFragment.at(this.f18655a);
                this.f18655a.f18660b.a(this.f18655a.ao(), this.f18655a.s.getString("EVENT_ID"), this.f18655a.s.getString("EVENT_NAME"), this.f18655a.s.getString("EVENT_PHOTO_URL"), this.f18655a.s.getString("EVENT_LOCATION"), this.f18655a.s.getString("EVENT_TIME"), d, "event", 100);
            }
        }
    }

    /* compiled from: best_device */
    class C26593 implements OnClickListener {
        final /* synthetic */ EventMessageGuestsFrameFragment f18656a;

        C26593(EventMessageGuestsFrameFragment eventMessageGuestsFrameFragment) {
            this.f18656a = eventMessageGuestsFrameFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: best_device */
    class C26604 implements OnClickListener {
        final /* synthetic */ EventMessageGuestsFrameFragment f18657a;

        C26604(EventMessageGuestsFrameFragment eventMessageGuestsFrameFragment) {
            this.f18657a = eventMessageGuestsFrameFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f18657a.f18661c.m18125a(EventMessageGuestsFrameFragment.au(this.f18657a), this.f18657a.f18662d.m18979d().size());
            this.f18657a.ao().finish();
        }
    }

    /* compiled from: best_device */
    /* synthetic */ class C26615 {
        static final /* synthetic */ int[] f18658a = new int[EventGuestListType.values().length];

        static {
            try {
                f18658a[EventGuestListType.PRIVATE_GOING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18658a[EventGuestListType.PUBLIC_GOING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18658a[EventGuestListType.PRIVATE_MAYBE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f18658a[EventGuestListType.PUBLIC_WATCHED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f18658a[EventGuestListType.PRIVATE_INVITED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f18658a[EventGuestListType.PUBLIC_INVITED.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public static void m18966a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        EventMessageGuestsFrameFragment eventMessageGuestsFrameFragment = (EventMessageGuestsFrameFragment) obj;
        EventSeenStateMegaphoneController b = EventSeenStateMegaphoneController.m18847b(injectorLike);
        SendAsMessageUtil a = SendAsMessageUtil.a(injectorLike);
        EventEventLogger b2 = EventEventLogger.m18119b(injectorLike);
        eventMessageGuestsFrameFragment.f18659a = b;
        eventMessageGuestsFrameFragment.f18660b = a;
        eventMessageGuestsFrameFragment.f18661c = b2;
    }

    public final void m18974c(Bundle bundle) {
        super.c(bundle);
        Class cls = EventMessageGuestsFrameFragment.class;
        m18966a((Object) this, getContext());
        this.f18662d = new EventMessageGuestsPagerAdapter(s(), getContext(), aq(), ar(), this.s);
    }

    private ImmutableList<Integer> ar() {
        Builder builder = new Builder();
        ImmutableList aq = aq();
        int size = aq.size();
        for (int i = 0; i < size; i++) {
            switch (C26615.f18658a[((EventGuestListType) aq.get(i)).ordinal()]) {
                case 1:
                case 2:
                    builder.c(Integer.valueOf(2131237083));
                    break;
                case 3:
                    builder.c(Integer.valueOf(2131237084));
                    break;
                case 4:
                    builder.c(Integer.valueOf(2131237204));
                    break;
                case 5:
                case 6:
                    builder.c(Integer.valueOf(2131237085));
                    break;
                default:
                    break;
            }
        }
        return builder.b();
    }

    public final View m18969a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 645830344);
        View inflate = layoutInflater.inflate(2130904050, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1796319796, a);
        return inflate;
    }

    public final void m18972a(View view, Bundle bundle) {
        super.a(view, bundle);
        ViewPager viewPager = (ViewPager) e(2131561307);
        viewPager.setAdapter(this.f18662d);
        ((TabbedViewPagerIndicator) e(2131561332)).setViewPager(viewPager);
        this.f18663e = (FbTextView) e(2131561334);
        this.f18666h = (FbTextView) e(2131561335);
        this.f18659a.m18851a(au(this), Boolean.valueOf(this.s.getBoolean("EVENT_HAS_SEEN_STATE")), GraphQLEventPrivacyType.fromString(this.s.getString("EVENT_KIND")), e(2131561333));
        this.f18662d.f18673f = new C26571(this);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -748796707);
        super.mi_();
        as();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1984395047, a);
    }

    private void as() {
        this.f18664f = (HasTitleBar) a(HasTitleBar.class);
        if (this.f18664f != null) {
            TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
            a.a = 1;
            a = a;
            a.g = b(2131237197);
            a = a;
            a.h = -2;
            a = a;
            a.d = this.f18667i;
            this.f18665g = a.a();
            this.f18664f.a(this.f18665g);
            this.f18664f.a(new C26582(this));
            this.f18664f.a_(m18967g(this.al));
            this.f18664f.c(true);
        }
    }

    public static void at(EventMessageGuestsFrameFragment eventMessageGuestsFrameFragment) {
        EventEventLogger eventEventLogger = eventMessageGuestsFrameFragment.f18661c;
        String string = eventMessageGuestsFrameFragment.s.getString("EVENT_ID");
        Set d = eventMessageGuestsFrameFragment.f18662d.m18979d();
        EventMessageGuestsPagerAdapter eventMessageGuestsPagerAdapter = eventMessageGuestsFrameFragment.f18662d;
        Map c = Maps.c();
        for (EventMessageGuestsFragment eventMessageGuestsFragment : eventMessageGuestsPagerAdapter.f18671d) {
            if (eventMessageGuestsFragment != null) {
                c.put(eventMessageGuestsFragment.ar().toString(), Integer.valueOf(eventMessageGuestsFragment.aq().size()));
            }
        }
        Map map = c;
        HoneyClientEventFast a = eventEventLogger.f17787i.a("message_event_guests", false);
        if (a.a()) {
            a.a("event_message_guests").d(eventEventLogger.f17788j.b(eventEventLogger.f17785g)).b("Event").c(string).a("selected_ids", d).a(map).a("send_as_group_message", false).b();
        }
    }

    private String m18967g(int i) {
        if (i == 0) {
            return b(2131237186);
        }
        return a(2131237187, new Object[]{Integer.valueOf(i)});
    }

    public final void m18971a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i == 100 && i2 == -1) {
            Activity ao = ao();
            if (ao != null) {
                ao.setResult(-1);
                ao.finish();
            }
        }
    }

    public final void m18968I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 479087872);
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 964825083, a);
    }

    public final String am_() {
        return "event_message_guests";
    }

    public final Map<String, Object> m18973c() {
        return EventEventLogger.m18117a(au(this));
    }

    public final boolean O_() {
        if (this.f18662d.m18979d() == null || this.f18662d.m18979d().isEmpty()) {
            this.f18661c.m18125a(au(this), 0);
            return false;
        }
        new AlertDialog.Builder(o()).a(2131237198).b(2131237199).a(2131237200, new C26604(this)).b(2131237201, new C26593(this)).a(false).a().show();
        return true;
    }

    public final void m18970a() {
        int size = this.f18662d.m18979d().size();
        this.al = size;
        this.f18667i = size > 0;
        this.f18665g.t = this.f18667i;
        this.f18664f.a(this.f18665g);
        int i = 50 - size;
        if (i < 0 || i > 20) {
            this.f18663e.setVisibility(8);
            this.f18666h.setVisibility(0);
        } else {
            String b;
            this.f18666h.setVisibility(8);
            this.f18663e.setVisibility(0);
            FbTextView fbTextView = this.f18663e;
            if (i == 0) {
                b = b(2131237202);
            } else {
                b = jW_().getQuantityString(2131689680, i, new Object[]{Integer.valueOf(i)});
            }
            fbTextView.setText(b);
            this.f18663e.setBackgroundColor(jW_().getColor(i <= 0 ? 2131363352 : 2131363351));
        }
        this.f18664f.a_(m18967g(size));
    }

    private ImmutableList<EventGuestListType> aq() {
        return EventGuestListType.readGuestListTypesList(this.s, "EVENT_GUEST_LIST_TYPES");
    }

    public static String au(EventMessageGuestsFrameFragment eventMessageGuestsFrameFragment) {
        return eventMessageGuestsFrameFragment.s.getString("EVENT_ID");
    }
}
