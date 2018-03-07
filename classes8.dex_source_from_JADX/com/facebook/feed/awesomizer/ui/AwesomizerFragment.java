package com.facebook.feed.awesomizer.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.awesomizer.abtest.ExperimentsForFeedAwesomizerTestModule;
import com.facebook.feed.awesomizer.ui.AwesomizerEventSubscriber.C12571;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.util.event.AwesomizerViewEvents.CardClosedEvent;
import com.facebook.inject.FbInjector;
import com.facebook.katana.app.module.common.ComponentName_FragmentChromeActivityMethodAutoProvider;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Function;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: has_friend_context */
public class AwesomizerFragment extends FbFragment {
    @Inject
    @FragmentChromeActivity
    ComponentName f11737a;
    private final Set al = new HashSet();
    public final String am = SafeUUIDGenerator.a().toString();
    @Inject
    FeedAwesomizerLogger f11738b;
    @Inject
    AwesomizerEventSubscriberProvider f11739c;
    @Inject
    SecureContextHelper f11740d;
    @Inject
    UriIntentMapper f11741e;
    @Inject
    QeAccessor f11742f;
    private AwesomizerEventSubscriber f11743g;
    public boolean f11744h = true;
    private final int f11745i = 4;

    /* compiled from: has_friend_context */
    class C12581 implements Function<CardClosedEvent, Void> {
        final /* synthetic */ AwesomizerFragment f11732a;

        C12581(AwesomizerFragment awesomizerFragment) {
            this.f11732a = awesomizerFragment;
        }

        public Object apply(Object obj) {
            this.f11732a.m13843a((CardClosedEvent) obj);
            return null;
        }
    }

    /* compiled from: has_friend_context */
    public class C12603 implements OnClickListener {
        final /* synthetic */ AwesomizerFragment f11736a;

        public C12603(AwesomizerFragment awesomizerFragment) {
            this.f11736a = awesomizerFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -4650541);
            Intent a2 = this.f11736a.f11741e.a(this.f11736a.getContext(), FBLinks.cr.concat("/feed/panel/advanced_prep/"));
            a2.putExtra("titlebar_with_modal_done", true);
            this.f11736a.f11740d.a(a2, this.f11736a.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, -2044377213, a);
        }
    }

    /* compiled from: has_friend_context */
    public enum AwesomizerCards {
        SEEFIRST("see_first"),
        UNFOLLOW("following"),
        REFOLLOW("unfollowed"),
        DISCOVER("discover");
        
        private String mName;

        private AwesomizerCards(String str) {
            this.mName = str;
        }

        public final String getName() {
            return this.mName;
        }

        public final int getIndex() {
            return ordinal() + 1;
        }
    }

    public static void m13837a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((AwesomizerFragment) obj).m13834a(ComponentName_FragmentChromeActivityMethodAutoProvider.b(fbInjector), FeedAwesomizerLogger.m13942b(fbInjector), (AwesomizerEventSubscriberProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(AwesomizerEventSubscriberProvider.class), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), (UriIntentMapper) Fb4aUriIntentMapper.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector));
    }

    private void m13834a(ComponentName componentName, FeedAwesomizerLogger feedAwesomizerLogger, AwesomizerEventSubscriberProvider awesomizerEventSubscriberProvider, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper, QeAccessor qeAccessor) {
        this.f11737a = componentName;
        this.f11738b = feedAwesomizerLogger;
        this.f11739c = awesomizerEventSubscriberProvider;
        this.f11740d = secureContextHelper;
        this.f11741e = uriIntentMapper;
        this.f11742f = qeAccessor;
    }

    public final void m13844c(Bundle bundle) {
        super.c(bundle);
        Class cls = AwesomizerFragment.class;
        m13837a((Object) this, getContext());
        this.f11743g = new AwesomizerEventSubscriber(new C12581(this), EventsStream.a(this.f11739c));
        AwesomizerEventSubscriber awesomizerEventSubscriber = this.f11743g;
        C12571 c12571 = new C12571(awesomizerEventSubscriber);
        awesomizerEventSubscriber.f11731c.add(awesomizerEventSubscriber.f11730b.a(CardClosedEvent.class, null, c12571));
    }

    public final View m13841a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2033679348);
        View inflate = layoutInflater.inflate(2130904352, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -547410138, a);
        return inflate;
    }

    public final void m13842a(View view, Bundle bundle) {
        super.a(view, bundle);
        m13835a(jW_().getDrawable(2130840185));
        m13836a(e(2131562041), ContentFragmentType.AWESOMIZER_SEEFIRST_FRAGMENT.ordinal(), AwesomizerCards.SEEFIRST.getIndex());
        m13836a(e(2131562042), ContentFragmentType.AWESOMIZER_UNFOLLOW_FRAGMENT.ordinal(), AwesomizerCards.UNFOLLOW.getIndex());
        m13836a(e(2131562043), ContentFragmentType.AWESOMIZER_REFOLLOW_FRAGMENT.ordinal(), AwesomizerCards.REFOLLOW.getIndex());
        if (this.f11742f.a(ExperimentsForFeedAwesomizerTestModule.f11603a, false)) {
            m13836a(e(2131562044), ContentFragmentType.AWESOMIZER_DISCOVER_FRAGMENT.ordinal(), AwesomizerCards.DISCOVER.getIndex());
        } else {
            e(2131562044).setVisibility(8);
        }
        e(2131562045).setOnClickListener(new C12603(this));
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -996290976);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131236138);
            hasTitleBar.c(true);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1019103529, a);
    }

    public final void m13840I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1022945950);
        super.I();
        FeedAwesomizerLogger feedAwesomizerLogger = this.f11738b;
        String str = this.am;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("feed_awesomizer_home_close");
        honeyClientEvent.c = "feed_awesomizer";
        honeyClientEvent.b("awesomizer_session_identifier", str);
        honeyClientEvent.a("home_time_spent", ((double) feedAwesomizerLogger.f11844j) / 1000.0d);
        honeyClientEvent.a("num_cards_available", 4);
        honeyClientEvent.a("num_cards_opened", feedAwesomizerLogger.f11838d);
        honeyClientEvent.a("selected_cards", feedAwesomizerLogger.f11847m);
        honeyClientEvent.a("time_to_select_first_card", ((double) feedAwesomizerLogger.f11839e) / 1000.0d);
        honeyClientEvent.a("total_time_spent", (((double) feedAwesomizerLogger.f11844j) + ((double) feedAwesomizerLogger.f11845k)) / 1000.0d);
        feedAwesomizerLogger.f11835a.a(honeyClientEvent);
        this.f11743g.m13833b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1314513319, a);
    }

    public final void m13839H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -880693236);
        super.H();
        this.f11738b.m13945d();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -820841530, a);
    }

    public final void m13838G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -887828110);
        super.G();
        this.f11738b.m13946e();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1677863546, a);
    }

    public final void m13843a(CardClosedEvent cardClosedEvent) {
        FeedAwesomizerLogger feedAwesomizerLogger = this.f11738b;
        feedAwesomizerLogger.f11845k += cardClosedEvent.c;
        if (cardClosedEvent.b) {
            this.al.add(Integer.valueOf(cardClosedEvent.a));
            ((AwesomizerLandscreenCardView) e(cardClosedEvent.a)).setCardCheckVisibility(0);
        }
        if (cardClosedEvent.b || this.al.size() == 4) {
            m13835a(jW_().getDrawable(2130840186));
        } else {
            m13835a(jW_().getDrawable(2130840185));
        }
    }

    private void m13836a(View view, final int i, final int i2) {
        view.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AwesomizerFragment f11735c;

            public void onClick(View view) {
                FeedAwesomizerLogger feedAwesomizerLogger;
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1778556807);
                if (this.f11735c.f11744h) {
                    this.f11735c.f11744h = false;
                    feedAwesomizerLogger = this.f11735c.f11738b;
                    feedAwesomizerLogger.f11839e = (feedAwesomizerLogger.f11844j + feedAwesomizerLogger.f11836b.a()) - feedAwesomizerLogger.f11843i;
                }
                feedAwesomizerLogger = this.f11735c.f11738b;
                int i = i2;
                if (!feedAwesomizerLogger.f11847m.contains(Integer.valueOf(i))) {
                    feedAwesomizerLogger.f11838d++;
                }
                feedAwesomizerLogger.f11847m.add(Integer.valueOf(i));
                this.f11735c.a(new Intent().setComponent(this.f11735c.f11737a).putExtra("target_fragment", i).putExtra("session_id", this.f11735c.am));
                Logger.a(2, EntryType.UI_INPUT_END, 330737385, a);
            }
        });
    }

    private void m13835a(Drawable drawable) {
        FbTextView fbTextView = (FbTextView) e(2131562040);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        fbTextView.setCompoundDrawables(null, drawable, null, null);
    }
}
