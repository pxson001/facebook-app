package com.facebook.growth.contactimporter;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.activity.UsesSimpleStringTitle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.growth.logging.FriendFinderAnalyticsLogger;
import com.facebook.growth.logging.FriendFinderAnalyticsLogger.ApiType;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.katana.findfriends.CIFlow;
import com.facebook.ipc.model.FacebookPhonebookContact;
import com.facebook.ipc.model.FacebookPhonebookContactMap;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: paymentMethodId */
public class StepInviteActivity extends FbFragmentActivity implements UsesSimpleStringTitle {
    public static final CallerContext f7118p = CallerContext.a(StepInviteActivity.class);
    private SendInviteClient f7119A;
    private long f7120B;
    @Inject
    FriendFinderAnalyticsLogger f7121q;
    @Inject
    GatekeeperStoreImpl f7122r;
    @Inject
    SendInviteClientProvider f7123s;
    @Inject
    SendInviteLogger f7124t;
    @Inject
    InvitesAdapterProvider f7125u;
    private boolean f7126v = false;
    public boolean f7127w = false;
    private CIFlow f7128x;
    private Map<Long, FacebookPhonebookContact> f7129y;
    private InvitesAdapter f7130z;

    /* compiled from: paymentMethodId */
    class C07511 extends OnToolbarButtonListener {
        final /* synthetic */ StepInviteActivity f7115a;

        C07511(StepInviteActivity stepInviteActivity) {
            this.f7115a = stepInviteActivity;
        }

        public final void m7398a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            StepInviteActivity.m7405b(this.f7115a, "done_button");
            StepInviteActivity.m7414n(this.f7115a);
        }
    }

    /* compiled from: paymentMethodId */
    class C07522 implements OnClickListener {
        final /* synthetic */ StepInviteActivity f7116a;

        C07522(StepInviteActivity stepInviteActivity) {
            this.f7116a = stepInviteActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -669718728);
            if (this.f7116a.f7127w) {
                StepInviteActivity.m7412l(this.f7116a);
                StepInviteActivity.m7414n(this.f7116a);
            } else {
                StepInviteActivity.m7411k(this.f7116a);
            }
            LogUtils.a(2116413871, a);
        }
    }

    /* compiled from: paymentMethodId */
    class C07533 implements DialogInterface.OnClickListener {
        final /* synthetic */ StepInviteActivity f7117a;

        C07533(StepInviteActivity stepInviteActivity) {
            this.f7117a = stepInviteActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            StepInviteActivity.m7412l(this.f7117a);
            StepInviteActivity.m7414n(this.f7117a);
        }
    }

    private static <T extends Context> void m7403a(Class<T> cls, T t) {
        m7404a((Object) t, (Context) t);
    }

    public static void m7404a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((StepInviteActivity) obj).m7402a(FriendFinderAnalyticsLogger.a(fbInjector), GatekeeperStoreImplMethodAutoProvider.a(fbInjector), (SendInviteClientProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(SendInviteClientProvider.class), new SendInviteLogger(AnalyticsLoggerMethodAutoProvider.a(fbInjector)), (InvitesAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(InvitesAdapterProvider.class));
    }

    public final void m7416b(Bundle bundle) {
        super.b(bundle);
        Class cls = StepInviteActivity.class;
        m7404a((Object) this, (Context) this);
        this.f7120B = SystemClock.uptimeMillis();
        this.f7129y = ((FacebookPhonebookContactMap) getIntent().getParcelableExtra("invitee_credentials")).a;
        this.f7128x = (CIFlow) getIntent().getSerializableExtra("ci_flow");
        this.f7119A = this.f7123s.m7395a(this.f7128x);
        this.f7127w = this.f7122r.a(1017, false);
        this.f7124t.m7396a(this.f7129y.size());
        if (this.f7129y.size() == 0) {
            this.f7124t.m7397a(0, 0, "no_contacts", this.f7120B);
            m7414n(this);
            setResult(-1);
            finish();
            return;
        }
        String string;
        if (this.f7127w) {
            setContentView(2130904374);
            string = getString(2131230751);
        } else {
            setContentView(2130904375);
            string = getString(2131230752);
            if (this.f7122r.a(31, false)) {
                findViewById(2131562075).setVisibility(8);
            }
            this.f7130z = this.f7125u.m7393a(this, this.f7128x, this.f7129y, m7409i(), this.f7120B, this.f7119A, this.f7124t);
            BetterListView betterListView = (BetterListView) a(2131562074);
            betterListView.setAdapter(this.f7130z);
            betterListView.setFastScrollAlwaysVisible(true);
        }
        FbTitleBarUtil.b(this);
        FbTitleBar fbTitleBar = (FbTitleBar) a(2131558563);
        TitleBarButtonSpec[] titleBarButtonSpecArr = new TitleBarButtonSpec[1];
        Builder a = TitleBarButtonSpec.a();
        a.g = string;
        titleBarButtonSpecArr[0] = a.a();
        fbTitleBar.setButtonSpecs(Arrays.asList(titleBarButtonSpecArr));
        fbTitleBar.setOnToolbarButtonListener(new C07511(this));
        m7410j();
    }

    private void m7402a(FriendFinderAnalyticsLogger friendFinderAnalyticsLogger, GatekeeperStoreImpl gatekeeperStoreImpl, SendInviteClientProvider sendInviteClientProvider, SendInviteLogger sendInviteLogger, InvitesAdapterProvider invitesAdapterProvider) {
        this.f7121q = friendFinderAnalyticsLogger;
        this.f7122r = gatekeeperStoreImpl;
        this.f7123s = sendInviteClientProvider;
        this.f7124t = sendInviteLogger;
        this.f7125u = invitesAdapterProvider;
    }

    public void onBackPressed() {
        m7405b(this, "back_button");
        super.onBackPressed();
    }

    public static void m7405b(StepInviteActivity stepInviteActivity, String str) {
        if (stepInviteActivity.f7127w) {
            stepInviteActivity.f7124t.m7397a(0, stepInviteActivity.f7129y.size(), str, stepInviteActivity.f7120B);
        } else if (!stepInviteActivity.f7126v) {
            ArrayList arrayList = new ArrayList(stepInviteActivity.f7130z.f7098n.keySet());
            stepInviteActivity.f7119A.m7394a(stepInviteActivity.m7399a(arrayList), false, false, f7118p);
            stepInviteActivity.f7130z.f7097m.clear();
            stepInviteActivity.f7124t.m7397a(arrayList.size(), stepInviteActivity.f7129y.size(), str, stepInviteActivity.f7120B);
            stepInviteActivity.f7126v = true;
        }
    }

    private Spanned m7409i() {
        return new SpannableString(getString(2131236379));
    }

    public final String m7415a() {
        return this.f7127w ? getString(2131236385) : getString(2131236389);
    }

    private void m7410j() {
        findViewById(2131562073).setOnClickListener(new C07522(this));
    }

    public static void m7411k(StepInviteActivity stepInviteActivity) {
        new AlertDialog.Builder(stepInviteActivity).c(17301543).b(stepInviteActivity.getString(2131236384)).a(2131230735, new C07533(stepInviteActivity)).b(2131230736, null).a(false).a().show();
    }

    public static void m7412l(StepInviteActivity stepInviteActivity) {
        if (!stepInviteActivity.f7126v) {
            stepInviteActivity.f7119A.m7394a(stepInviteActivity.m7413m(), true, stepInviteActivity.f7127w, f7118p);
            int size = stepInviteActivity.f7129y.size();
            stepInviteActivity.f7124t.m7397a(size, size, "invite_all", stepInviteActivity.f7120B);
            stepInviteActivity.f7121q.a(stepInviteActivity.f7128x.value, size, ApiType.FRIEND_FINDER_API);
            stepInviteActivity.f7126v = true;
        }
    }

    private ArrayList<String> m7399a(ArrayList<Long> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add(((FacebookPhonebookContact) this.f7129y.get((Long) arrayList.get(i))).a());
        }
        return arrayList2;
    }

    private ArrayList<String> m7413m() {
        ArrayList<String> arrayList = new ArrayList();
        for (FacebookPhonebookContact a : this.f7129y.values()) {
            arrayList.add(a.a());
        }
        return arrayList;
    }

    public static void m7414n(StepInviteActivity stepInviteActivity) {
        stepInviteActivity.f7124t.f7114a.a(new FindFriendsAnalyticsEvent("end"));
        stepInviteActivity.setResult(-1);
        stepInviteActivity.finish();
    }
}
