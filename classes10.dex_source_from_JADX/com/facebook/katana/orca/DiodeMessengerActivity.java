package com.facebook.katana.orca;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.market.GooglePlayIntentHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.abtest.DiodeExperimentController;
import com.facebook.messaging.abtest.ExperimentsForMessagingAbTestModule;
import com.facebook.messaging.appspecific.PackageNameResolver;
import com.facebook.messaging.forcemessenger.ClickThroughDestination;
import com.facebook.messaging.util.MessengerAppUtils;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import javax.inject.Inject;

/* compiled from: unknown_sources_checked */
public class DiodeMessengerActivity extends FbFragmentActivity implements AnalyticsActivity {
    @Inject
    MessengerAppUtils f963p;
    @Inject
    DiodeExperimentController f964q;
    @Inject
    GooglePlayIntentHelper f965r;
    private DiodeHostFragment f966s;

    private static <T extends Context> void m1016a(Class<T> cls, T t) {
        m1017a((Object) t, (Context) t);
    }

    public static void m1017a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((DiodeMessengerActivity) obj).m1015a(MessengerAppUtils.a(fbInjector), DiodeExperimentController.a(fbInjector), GooglePlayIntentHelper.b(fbInjector));
    }

    private void m1015a(MessengerAppUtils messengerAppUtils, DiodeExperimentController diodeExperimentController, GooglePlayIntentHelper googlePlayIntentHelper) {
        this.f963p = messengerAppUtils;
        this.f964q = diodeExperimentController;
        this.f965r = googlePlayIntentHelper;
    }

    protected final void m1019b(Bundle bundle) {
        super.b(bundle);
        Class cls = DiodeMessengerActivity.class;
        m1017a((Object) this, (Context) this);
        if (!this.f963p.a() && this.f964q.a.a(ExperimentsForMessagingAbTestModule.b, false)) {
            this.f965r.a(this, PackageNameResolver.a());
        }
        setContentView(2130903914);
        FbTitleBarUtil.b(this);
        FbTitleBar fbTitleBar = (FbTitleBar) findViewById(2131558563);
        final FragmentManager kO_ = kO_();
        fbTitleBar.a(new OnClickListener(this) {
            final /* synthetic */ DiodeMessengerActivity f962b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1367972608);
                if (!kO_.c()) {
                    Logger.a(2, EntryType.UI_INPUT_END, 1585908531, a);
                } else if (kO_.e()) {
                    LogUtils.a(1966595517, a);
                } else {
                    this.f962b.finish();
                    LogUtils.a(127552133, a);
                }
            }
        });
        m1014a(getIntent().hasExtra("click_through") ? (ClickThroughDestination) getIntent().getSerializableExtra("click_through") : ClickThroughDestination.THREAD_LIST);
    }

    public final void m1018a(Fragment fragment) {
        if (fragment instanceof DiodeHostFragment) {
            this.f966s = (DiodeHostFragment) fragment;
        }
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 250400369);
        super.onResume();
        if (this.f963p.a() && this.f963p.d()) {
            finish();
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 562821813, a);
    }

    public final String am_() {
        return "diode_messenger_activity";
    }

    private void m1014a(ClickThroughDestination clickThroughDestination) {
        if (this.f966s == null) {
            DiodeHostFragment diodeHostFragment = new DiodeHostFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("click_through", clickThroughDestination);
            diodeHostFragment.g(bundle);
            this.f966s = diodeHostFragment;
            kO_().a().b(2131558429, this.f966s).b();
        }
    }
}
