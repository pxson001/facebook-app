package com.facebook.orca.threadview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.facebook.actionbar.AppCompatActivityOverrider;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.auth.module.ViewerContextMethodAutoProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.bugreporter.activity.ActivityWithDebugInfo;
import com.facebook.common.ui.util.StatusBarUtil;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.divebar.DivebarController;
import com.facebook.divebar.DrawerBasedDivebarControllerImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.menu.ExportMenuToFbHostActivity;
import com.facebook.menu.ExportMenuToFbHostActivity.CustomFbHostMenuItem;
import com.facebook.messaging.activity.DivebarEnabledActivity;
import com.facebook.messaging.annotations.IsMessengerMaterialDesignEnabled;
import com.facebook.messaging.audio.playback.AudioClipPlayerQueue;
import com.facebook.messaging.chatheads.ipc.ChatHeadsControlActivity;
import com.facebook.messaging.chatheads.ipc.ChatHeadsControlActivity.DisplayPolicy;
import com.facebook.messaging.intents.MessagingIntents;
import com.facebook.messaging.material.MessengerMaterialThemeUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.send.trigger.NavigationTrigger;
import com.facebook.messaging.threadview.titlebar.ThreadTitleBarTheme;
import com.facebook.orca.compose.ComposerInitParams;
import com.facebook.orca.compose.ComposerInitParamsFactory;
import com.facebook.orca.notify.ThreadViewStatusHostActivity;
import com.facebook.orca.threadview.ThreadViewFragment.ThreadViewFragmentListener;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.Source;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.titlebar.ActionBarBasedFbTitleBar;
import com.facebook.widget.titlebar.FbActionBarUtil;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.google.common.base.Preconditions;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: message_block_select_see_conversation_from_blocked_warning_alert */
public class ThreadViewActivity extends FbFragmentActivity implements AnalyticsActivity, ActivityWithDebugInfo, ExportMenuToFbHostActivity, DivebarEnabledActivity, ChatHeadsControlActivity, ThreadViewStatusHostActivity {
    private DrawerBasedDivebarControllerImpl f7452A;
    @Inject
    AppCompatActivityOverrider f7453p;
    @Inject
    AnalyticsLogger f7454q;
    @Inject
    AudioClipPlayerQueue f7455r;
    @Inject
    FbActionBarUtil f7456s;
    @Inject
    Lazy<DivebarController> f7457t;
    @IsMessengerMaterialDesignEnabled
    @Inject
    Provider<Boolean> f7458u;
    @Inject
    Product f7459v;
    @Inject
    ViewerContext f7460w;
    public boolean f7461x;
    private ActionBarBasedFbTitleBar f7462y;
    private ThreadViewFragment f7463z;

    /* compiled from: message_block_select_see_conversation_from_blocked_warning_alert */
    public class C11181 {
        final /* synthetic */ ThreadViewActivity f7450a;

        C11181(ThreadViewActivity threadViewActivity) {
            this.f7450a = threadViewActivity;
        }

        public final void m7081a(ThreadTitleBarTheme threadTitleBarTheme) {
            if (this.f7450a.f7461x) {
                View findViewById = this.f7450a.findViewById(2131559130);
                if (findViewById != null) {
                    CustomViewUtils.b(findViewById, threadTitleBarTheme.f4818a);
                }
            }
        }
    }

    /* compiled from: message_block_select_see_conversation_from_blocked_warning_alert */
    class C11192 implements ThreadViewFragmentListener {
        final /* synthetic */ ThreadViewActivity f7451a;

        C11192(ThreadViewActivity threadViewActivity) {
            this.f7451a = threadViewActivity;
        }

        public final void mo313a() {
            this.f7451a.finish();
        }

        public final void mo314a(int i) {
            if (((Boolean) this.f7451a.f7458u.get()).booleanValue()) {
                StatusBarUtil.a(this.f7451a.getWindow(), i);
            }
        }
    }

    private static <T extends Context> void m7089a(Class<T> cls, T t) {
        m7090a((Object) t, (Context) t);
    }

    public static void m7090a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ThreadViewActivity) obj).m7088a(AppCompatActivityOverrider.b(fbInjector), AnalyticsLoggerMethodAutoProvider.a(fbInjector), AudioClipPlayerQueue.a(fbInjector), FbActionBarUtil.a(fbInjector), IdBasedLazy.a(fbInjector, 1109), IdBasedProvider.a(fbInjector, 4073), ProductMethodAutoProvider.b(fbInjector), ViewerContextMethodAutoProvider.b(fbInjector));
    }

    private void m7088a(AppCompatActivityOverrider appCompatActivityOverrider, AnalyticsLogger analyticsLogger, AudioClipPlayerQueue audioClipPlayerQueue, FbActionBarUtil fbActionBarUtil, Lazy<DivebarController> lazy, Provider<Boolean> provider, Product product, ViewerContext viewerContext) {
        this.f7453p = appCompatActivityOverrider;
        this.f7454q = analyticsLogger;
        this.f7455r = audioClipPlayerQueue;
        this.f7456s = fbActionBarUtil;
        this.f7457t = lazy;
        this.f7458u = provider;
        this.f7459v = product;
        this.f7460w = viewerContext;
    }

    public static Intent m7086a(Context context, ThreadKey threadKey) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(threadKey);
        Intent intent = new Intent(context, ThreadViewActivity.class);
        intent.putExtra("thread_key", threadKey);
        return intent;
    }

    public final String am_() {
        return "thread";
    }

    public final void m7099a(Fragment fragment) {
        super.a(fragment);
        if (fragment instanceof ThreadViewFragment) {
            this.f7463z = (ThreadViewFragment) fragment;
            m7093i();
            this.f7463z.bQ = new C11181(this);
            this.f7463z.bO = new C11192(this);
        }
    }

    protected final void m7098a(Bundle bundle) {
        MessengerMaterialThemeUtil.a(this, 2131625175);
        Class cls = ThreadViewActivity.class;
        m7090a((Object) this, (Context) this);
        this.f7461x = this.f7456s.a();
        if (this.f7461x) {
            a(this.f7453p);
        }
        if (!(this.f7461x || this.f7460w.mIsPageContext)) {
            this.f7452A = (DrawerBasedDivebarControllerImpl) this.f7457t.get();
        }
        m7093i();
        if (getIntent().hasExtra("set_theme")) {
            setTheme(getIntent().getIntExtra("set_theme", 0));
        }
    }

    private void m7093i() {
        if (this.f7463z != null) {
            this.f7463z.bF = true;
        }
    }

    public final void m7100b(Bundle bundle) {
        FbTitleBar fbTitleBar;
        super.b(bundle);
        setContentView(2130905889);
        if (this.f7459v != Product.PAA) {
            m7094j();
        }
        if (this.f7461x) {
            this.f7462y = new ActionBarBasedFbTitleBar(this, this.f7453p.g());
            fbTitleBar = this.f7462y;
        } else {
            FbTitleBarUtil.b(this);
            fbTitleBar = (FbTitleBar) a(2131558563);
        }
        this.f7463z.m7232a(fbTitleBar);
        m7087a(getIntent(), bundle);
        if (this.f7452A != null) {
            this.f7452A.a(this);
        }
        getWindow().getDecorView().setBackgroundDrawable(new ColorDrawable(Color.rgb(255, 255, 255)));
    }

    public void startActivity(Intent intent) {
        if (this.f7463z != null && !this.f7463z.m7247b(intent)) {
            super.startActivity(intent);
        }
    }

    private void m7094j() {
        ViewGroup viewGroup = (ViewGroup) findViewById(2131559125);
        if (viewGroup != null) {
            viewGroup.addView(getLayoutInflater().inflate(2130907749, viewGroup, false), 0, new LayoutParams(-1, -2));
        }
    }

    private void m7087a(Intent intent, Bundle bundle) {
        Preconditions.checkArgument(intent.hasExtra("thread_key"), "Intent has no threadKey. Intent = " + intent);
        this.f7463z.m7238a((ThreadKey) intent.getParcelableExtra("thread_key"), Source.OTHER);
        if (bundle == null) {
            m7092b(intent);
        }
        if (MessagingIntents.a(intent, "from_notification", false)) {
            this.f7463z.m7254e();
        }
        if (MessagingIntents.a(intent, "focus_compose", false)) {
            this.f7463z.m7246b(false);
        }
        if (intent.hasExtra("business_extension_uri")) {
            this.f7463z.m7245b(intent.getStringExtra("business_extension_uri"));
        }
    }

    private void m7092b(Intent intent) {
        ThreadViewMessagesInitParamsBuilder threadViewMessagesInitParamsBuilder;
        ThreadViewMessagesInitParams threadViewMessagesInitParams = (ThreadViewMessagesInitParams) intent.getParcelableExtra("thread_view_messages_init_params");
        if (threadViewMessagesInitParams == null) {
            threadViewMessagesInitParamsBuilder = new ThreadViewMessagesInitParamsBuilder();
        } else {
            ThreadViewMessagesInitParamsBuilder threadViewMessagesInitParamsBuilder2 = new ThreadViewMessagesInitParamsBuilder();
            threadViewMessagesInitParamsBuilder2.f7909a = threadViewMessagesInitParams.f7904a;
            threadViewMessagesInitParamsBuilder2 = threadViewMessagesInitParamsBuilder2;
            threadViewMessagesInitParamsBuilder2.f7910b = threadViewMessagesInitParams.f7905b;
            threadViewMessagesInitParamsBuilder2 = threadViewMessagesInitParamsBuilder2;
            threadViewMessagesInitParamsBuilder2.f7911c = threadViewMessagesInitParams.f7906c;
            threadViewMessagesInitParamsBuilder2 = threadViewMessagesInitParamsBuilder2;
            threadViewMessagesInitParamsBuilder2.f7912d = threadViewMessagesInitParams.f7907d;
            threadViewMessagesInitParamsBuilder2 = threadViewMessagesInitParamsBuilder2;
            threadViewMessagesInitParamsBuilder2.f7913e = threadViewMessagesInitParams.f7908e;
            threadViewMessagesInitParamsBuilder = threadViewMessagesInitParamsBuilder2;
        }
        ComposerInitParams a = ComposerInitParamsFactory.m5015a(intent);
        if (a != null) {
            threadViewMessagesInitParamsBuilder.f7909a = a;
        }
        this.f7463z.m7241a(new ThreadViewMessagesInitParams(threadViewMessagesInitParamsBuilder));
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.f7463z.m7257h(z);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            AnalyticsLogger analyticsLogger = this.f7454q;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("click");
            honeyClientEvent.c = am_();
            honeyClientEvent = honeyClientEvent;
            honeyClientEvent.d = "android_button";
            honeyClientEvent = honeyClientEvent;
            honeyClientEvent.e = "back";
            analyticsLogger.a(honeyClientEvent);
        }
        return this.f7463z.m7243a(keyEvent) || super.onKeyDown(i, keyEvent);
    }

    public void onUserInteraction() {
        super.onUserInteraction();
        if (this.f7463z != null) {
            this.f7463z.aq();
        }
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -841102741);
        super.onPause();
        this.f7455r.a();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1741123809, a);
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1947358230);
        super.onResume();
        Intent intent = getIntent();
        if (intent != null) {
            String a2 = MessagingIntents.a(intent, "trigger");
            if (a2 != null) {
                this.f7463z.bU = NavigationTrigger.a(a2);
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 622001461, a);
    }

    public void onBackPressed() {
        if (!m7096l()) {
            super.onBackPressed();
            m7095k();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        closeOptionsMenu();
        super.onSaveInstanceState(bundle);
    }

    public final List<CustomFbHostMenuItem> m7102d() {
        return this.f7463z.m7252d();
    }

    public final void B_(int i) {
        this.f7463z.B_(i);
    }

    public final DrawerBasedDivebarControllerImpl m7104f() {
        return this.f7452A;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        if (this.f7461x && onCreateOptionsMenu) {
            this.f7462y.a(menu);
        }
        return onCreateOptionsMenu;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        boolean z;
        if (menuItem.getItemId() == 16908332) {
            if (this.f7459v != Product.PAA) {
                this.f7453p.j(this);
                m7095k();
            } else {
                finish();
            }
            z = true;
        } else {
            z = this.f7461x ? this.f7462y.a(menuItem) : false;
        }
        if (z || super.onOptionsItemSelected(menuItem)) {
            return true;
        }
        return false;
    }

    private void m7095k() {
        if (this.f7461x) {
            overridePendingTransition(2130968682, 2130968687);
        }
    }

    private boolean m7096l() {
        return !kO_().c() || ((this.f7452A != null && this.f7452A.kY_()) || this.f7463z.m7244a(null));
    }

    public final DisplayPolicy m7097a() {
        return DisplayPolicy.HIDE;
    }

    public final ThreadKey mo315c() {
        return this.f7463z.bA;
    }

    public final boolean mo316e() {
        return false;
    }

    public Map<String, String> getDebugInfo() {
        if (this.f7463z == null || !this.f7463z.z()) {
            return null;
        }
        return this.f7463z.getDebugInfo();
    }
}
