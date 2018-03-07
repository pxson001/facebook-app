package com.facebook.zero.onboarding;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.calls.AssistedRegSendInviteWithSourceInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.growth.contactinviter.ContactInviterFragment;
import com.facebook.growth.contactinviter.ContactInviterFragment.OnCompleteListener;
import com.facebook.growth.contactinviter.PhoneContactToken;
import com.facebook.growth.friendfinder.FriendFinderIntroFragment;
import com.facebook.growth.friendfinder.FriendFinderIntroFragment.LegalCallback;
import com.facebook.growth.friendfinder.FriendFinderPreferenceSetter;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.ipc.katana.findfriends.CIFlow;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.zero.onboarding.fragment.FreeFacebookConfirmationFragment;
import com.facebook.zero.onboarding.graphql.AssistedOnboarding;
import com.facebook.zero.onboarding.graphql.AssistedOnboarding.AssistedRegSendInviteWithSourceString;
import com.facebook.zero.onboarding.utils.AssistedOnboardingLogger;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.inject.Inject;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: modelNumber */
public class FbInviteIncentiveActivity extends FbFragmentActivity implements OnCompleteListener, LegalCallback {
    @Inject
    public GraphQLQueryExecutor f5342p;
    @Inject
    public FriendFinderPreferenceSetter f5343q;
    @Inject
    public Lazy<AssistedOnboardingLogger> f5344r;
    @Inject
    public FunnelLoggerImpl f5345s;
    private Fb4aTitleBar f5346t;
    private boolean f5347u;

    /* compiled from: modelNumber */
    class C06991 implements OnClickListener {
        final /* synthetic */ FbInviteIncentiveActivity f5340a;

        C06991(FbInviteIncentiveActivity fbInviteIncentiveActivity) {
            this.f5340a = fbInviteIncentiveActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1936313185);
            this.f5340a.finish();
            Logger.a(2, EntryType.UI_INPUT_END, -224223482, a);
        }
    }

    /* compiled from: modelNumber */
    class C07002 implements OnClickListener {
        final /* synthetic */ FbInviteIncentiveActivity f5341a;

        C07002(FbInviteIncentiveActivity fbInviteIncentiveActivity) {
            this.f5341a = fbInviteIncentiveActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1497113323);
            this.f5341a.finish();
            Logger.a(2, EntryType.UI_INPUT_END, -1990537352, a);
        }
    }

    private static <T extends Context> void m6582a(Class<T> cls, T t) {
        m6583a((Object) t, (Context) t);
    }

    public static void m6583a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        FbInviteIncentiveActivity fbInviteIncentiveActivity = (FbInviteIncentiveActivity) obj;
        GraphQLQueryExecutor a = GraphQLQueryExecutor.a(fbInjector);
        FriendFinderPreferenceSetter b = FriendFinderPreferenceSetter.b(fbInjector);
        Lazy a2 = IdBasedLazy.a(fbInjector, 11831);
        FunnelLoggerImpl a3 = FunnelLoggerImpl.a(fbInjector);
        fbInviteIncentiveActivity.f5342p = a;
        fbInviteIncentiveActivity.f5343q = b;
        fbInviteIncentiveActivity.f5344r = a2;
        fbInviteIncentiveActivity.f5345s = a3;
    }

    protected final void m6591b(Bundle bundle) {
        super.b(bundle);
        Class cls = FbInviteIncentiveActivity.class;
        m6583a((Object) this, (Context) this);
        setContentView(2130903295);
        this.f5345s.a(FunnelRegistry.E);
        this.f5346t = (Fb4aTitleBar) a(2131558563);
        m6587i();
        boolean a = this.f5343q.a();
        this.f5345s.a(FunnelRegistry.E, "start_funnel", Boolean.toString(a));
        if (a) {
            m6585b(false);
            return;
        }
        this.f5345s.b(FunnelRegistry.E, "ccu_legal_open");
        m6586c(true);
        FriendFinderIntroFragment b = FriendFinderIntroFragment.b(CIFlow.IORG_INCENTIVE_INVITE, null);
        FragmentTransaction a2 = kO_().a();
        a2.b(2131558429, b);
        a2.b();
    }

    private void m6587i() {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("fb_incentive_activity_open");
        honeyClientEvent.a("ccu_enabled", this.f5343q.a());
        ((AssistedOnboardingLogger) this.f5344r.get()).m6628a(honeyClientEvent);
    }

    public final void m6589a() {
        this.f5345s.b(FunnelRegistry.E, "cc_legal_accepted");
        m6585b(true);
    }

    private void m6585b(boolean z) {
        m6586c(false);
        this.f5345s.a(FunnelRegistry.E, "contact_invite_list_open", z ? "from_legal" : "ccu_enabled");
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("fb_incentive_start_contact_inviter_fragment");
        honeyClientEvent.a("ccu_enabled", this.f5343q.a());
        honeyClientEvent.a("accepted_legal", z);
        ((AssistedOnboardingLogger) this.f5344r.get()).m6628a(honeyClientEvent);
        FragmentTransaction a = kO_().a();
        ContactInviterFragment contactInviterFragment = new ContactInviterFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("has_title_bar", true);
        bundle.putInt("title_bar_title_string_id", 2131241765);
        bundle.putString("analytics_tag", "assisted_onboarding");
        contactInviterFragment.g(bundle);
        a.b(2131558429, contactInviterFragment);
        a.c();
    }

    private void m6586c(boolean z) {
        if (z) {
            this.f5346t.setVisibility(0);
            this.f5346t.setTitle(2131241765);
            this.f5346t.setTitlebarAsModal(new C06991(this));
            return;
        }
        this.f5346t.setVisibility(8);
    }

    public final void m6590a(List<PhoneContactToken> list) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("fb_incentive_finish_contact_inviter_fragment");
        honeyClientEvent.a("num_invites_sent", list.size());
        ((AssistedOnboardingLogger) this.f5344r.get()).m6628a(honeyClientEvent);
        m6584b((List) list);
        if (list.isEmpty()) {
            finish();
        } else {
            m6588j();
        }
    }

    public void onBackPressed() {
        Fragment a = kO_().a(2131558429);
        if (a instanceof ContactInviterFragment) {
            ContactInviterFragment contactInviterFragment = (ContactInviterFragment) a;
            contactInviterFragment.g.a(FunnelRegistry.E, "contact_invite_list_close", "device_back");
            ContactInviterFragment.as(contactInviterFragment);
            return;
        }
        super.onBackPressed();
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -830668395);
        Fragment a2 = kO_().a(2131558429);
        if ((a2 instanceof ContactInviterFragment) && !this.f5347u) {
            m6584b((List) ImmutableList.copyOf(((ContactInviterFragment) a2).aq));
        }
        this.f5345s.b(FunnelRegistry.E);
        super.onDestroy();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1857593004, a);
    }

    private void m6588j() {
        this.f5346t.setVisibility(0);
        this.f5346t.setTitle(2131241765);
        this.f5346t.setTitlebarAsModal(new C07002(this));
        FragmentTransaction a = kO_().a();
        a.b(2131558429, new FreeFacebookConfirmationFragment());
        a.b();
    }

    private void m6584b(List<PhoneContactToken> list) {
        this.f5347u = true;
        this.f5345s.a(FunnelRegistry.E, "send_invites", Integer.toString(list.size()));
        for (PhoneContactToken phoneContactToken : list) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("hash", phoneContactToken.a());
            } catch (JSONException e) {
            }
            AssistedRegSendInviteWithSourceInputData d = new AssistedRegSendInviteWithSourceInputData().a(phoneContactToken.a).b(phoneContactToken.a).c(phoneContactToken.b).a(Integer.valueOf(3)).d(jSONObject.toString());
            AssistedRegSendInviteWithSourceString a = AssistedOnboarding.m6616a();
            a.a("input", d);
            this.f5342p.a(GraphQLRequest.a(a));
        }
    }
}
