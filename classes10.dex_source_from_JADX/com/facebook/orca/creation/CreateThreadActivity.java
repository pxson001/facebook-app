package com.facebook.orca.creation;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import com.facebook.actionbar.AppCompatActivityOverrider;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.activity.RunningTaskInfoManager;
import com.facebook.bugreporter.BugReportCategory;
import com.facebook.bugreporter.BugReportOperationLogger;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.common.ui.keyboard.CustomKeyboardContainer;
import com.facebook.common.ui.keyboard.CustomKeyboardLayout;
import com.facebook.common.util.StringUtil;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.activity.CheckBeforeLeaveActivity;
import com.facebook.messaging.activity.CheckBeforeLeaveActivity.LeaveCheckListener;
import com.facebook.messaging.analytics.base.MessagingAnalyticsConstants.MessageSendTrigger;
import com.facebook.messaging.blocking.BlockingUtils;
import com.facebook.messaging.chatheads.ipc.ChatHeadsControlActivity;
import com.facebook.messaging.chatheads.ipc.ChatHeadsControlActivity.DisplayPolicy;
import com.facebook.messaging.forward.MessageForwardHandler;
import com.facebook.messaging.intents.MessagingIntents;
import com.facebook.messaging.material.MessengerMaterialThemeUtil;
import com.facebook.messaging.media.upload.MediaUploadManagerImpl;
import com.facebook.messaging.media.upload.MessageMediaUploadState.UploadState;
import com.facebook.messaging.messageclassifier.MessageClassification;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.send.SendError;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.send.client.NewMessageSenderFragment;
import com.facebook.messaging.send.common.SendMessageException;
import com.facebook.messaging.send.trigger.NavigationTrigger;
import com.facebook.messaging.send.ui.SendDialogUtils;
import com.facebook.messaging.send.ui.SendErrorHelper;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.facebook.orca.common.ui.widgets.CreateThreadCustomLayout;
import com.facebook.orca.compose.ComposeFragment;
import com.facebook.orca.compose.ComposeFragment.SimpleComposerListener;
import com.facebook.orca.compose.ComposeMode;
import com.facebook.orca.compose.ComposerInitParams;
import com.facebook.orca.compose.ComposerInitParamsFactory;
import com.facebook.orca.contacts.picker.ContactMultipickerFragment;
import com.facebook.orca.contacts.picker.ContactPickerFragment;
import com.facebook.orca.contacts.picker.ContactPickerFragment.ListType;
import com.facebook.orca.contacts.picker.ContactPickerFragment.OnContactAddedOrRemovedListener;
import com.facebook.orca.contacts.picker.ContactPickerFragment.OnContactPickerTextChangedListener;
import com.facebook.orca.contacts.picker.ContactPickerFragment.OnPrimaryContactTypeChangedListener;
import com.facebook.orca.threadview.ThreadViewActivity;
import com.facebook.platform.common.annotations.TaskRunningInPlatformContext;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogParamsBuilder;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.facebook.widget.OverlayLayout;
import com.facebook.widget.titlebar.ActionBarBasedFbTitleBar;
import com.facebook.widget.titlebar.FbActionBarUtil;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: null ViewerContextUser found when sending payment message from group thread */
public class CreateThreadActivity extends FbFragmentActivity implements AnalyticsActivity, CustomKeyboardContainer, CheckBeforeLeaveActivity, ChatHeadsControlActivity {
    private static final Class<?> f6129y = CreateThreadActivity.class;
    private static final ImmutableList<User> f6130z = RegularImmutableList.a;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<MessageForwardHandler> f6131A = UltralightRuntime.b;
    private final MessengerMaterialThemeUtil f6132B = new MessengerMaterialThemeUtil(this, 2131625184);
    private FbActionBarUtil f6133C;
    public AppCompatActivityOverrider f6134D;
    private ActionBarBasedFbTitleBar f6135E;
    private OverlayLayout f6136F;
    private LinearLayout f6137G;
    private CreateThreadCustomLayout f6138H;
    public ContactPickerFragment f6139I;
    private ComposeFragment f6140J;
    private boolean f6141K;
    private NavigationTrigger f6142L;
    private Message f6143M;
    private MediaResource f6144N;
    private boolean f6145O;
    private boolean f6146P;
    public ContactMultipickerFragment f6147Q;
    @Inject
    BlockingUtils f6148p;
    @Inject
    BugReportOperationLogger f6149q;
    @Inject
    ErrorDialogs f6150r;
    @Inject
    InputMethodManager f6151s;
    @Inject
    Provider<AppCompatActivityOverrider> f6152t;
    @Inject
    RunningTaskInfoManager f6153u;
    @Inject
    SendDialogUtils f6154v;
    @Inject
    UserCache f6155w;
    boolean f6156x;

    /* compiled from: null ViewerContextUser found when sending payment message from group thread */
    public class C09341 {
        final /* synthetic */ CreateThreadActivity f6116a;

        C09341(CreateThreadActivity createThreadActivity) {
            this.f6116a = createThreadActivity;
        }

        public final void m5833a(FetchThreadResult fetchThreadResult) {
            this.f6116a.m5851a(fetchThreadResult);
        }

        public final void m5834a(Throwable th) {
            CreateThreadActivity.m5865b(this.f6116a, th);
        }

        public final void m5832a(ThreadKey threadKey) {
            this.f6116a.m5850a(threadKey);
        }
    }

    /* compiled from: null ViewerContextUser found when sending payment message from group thread */
    class C09352 implements OnGlobalFocusChangeListener {
        final /* synthetic */ CreateThreadActivity f6117a;

        C09352(CreateThreadActivity createThreadActivity) {
            this.f6117a = createThreadActivity;
        }

        public void onGlobalFocusChanged(View view, View view2) {
            this.f6117a.m5847a(view2);
        }
    }

    /* compiled from: null ViewerContextUser found when sending payment message from group thread */
    class C09363 extends SimpleComposerListener {
        final /* synthetic */ CreateThreadActivity f6118a;

        C09363(CreateThreadActivity createThreadActivity) {
            this.f6118a = createThreadActivity;
        }

        public final void mo147a(Message message, MessageSendTrigger messageSendTrigger) {
            this.f6118a.m5849a(message);
        }

        public final void mo146a() {
            this.f6118a.onBackPressed();
        }

        @Nullable
        public final String mo150c() {
            if (CreateThreadActivity.m5885v(this.f6118a) != 1) {
                return null;
            }
            return ((User) this.f6118a.f6139I.m5772e().get(0)).a;
        }

        @Nullable
        public final String mo151d() {
            if (CreateThreadActivity.m5885v(this.f6118a) != 1) {
                return null;
            }
            return ((User) this.f6118a.f6139I.m5772e().get(0)).k();
        }
    }

    /* compiled from: null ViewerContextUser found when sending payment message from group thread */
    class C09374 implements OnContactPickerTextChangedListener {
        final /* synthetic */ CreateThreadActivity f6119a;

        C09374(CreateThreadActivity createThreadActivity) {
            this.f6119a = createThreadActivity;
        }

        public final void mo223a(String str, boolean z) {
            if (z || !CreateThreadActivity.m5873j(this.f6119a)) {
                this.f6119a.f6147Q.ar();
            } else {
                this.f6119a.f6147Q.aq();
            }
            this.f6119a.f6147Q.as();
        }
    }

    /* compiled from: null ViewerContextUser found when sending payment message from group thread */
    class C09385 implements OnPrimaryContactTypeChangedListener {
        final /* synthetic */ CreateThreadActivity f6120a;

        C09385(CreateThreadActivity createThreadActivity) {
            this.f6120a = createThreadActivity;
        }

        public final void mo227a() {
            CreateThreadActivity.m5875l(this.f6120a);
        }
    }

    /* compiled from: null ViewerContextUser found when sending payment message from group thread */
    class C09396 implements OnContactAddedOrRemovedListener {
        final /* synthetic */ CreateThreadActivity f6121a;

        C09396(CreateThreadActivity createThreadActivity) {
            this.f6121a = createThreadActivity;
        }

        public final void mo228a(User user) {
            CreateThreadActivity.m5864b(this.f6121a, "Add user: " + user.a);
            CreateThreadActivity.m5877n(this.f6121a);
        }

        public final void mo229b(User user) {
            CreateThreadActivity.m5864b(this.f6121a, "Remove user: " + user.a);
            CreateThreadActivity.m5877n(this.f6121a);
        }
    }

    /* compiled from: null ViewerContextUser found when sending payment message from group thread */
    class C09429 implements Runnable {
        final /* synthetic */ CreateThreadActivity f6126a;

        C09429(CreateThreadActivity createThreadActivity) {
            this.f6126a = createThreadActivity;
        }

        public void run() {
            this.f6126a.finish();
            CreateThreadActivity.m5882s(this.f6126a);
        }
    }

    /* compiled from: null ViewerContextUser found when sending payment message from group thread */
    class ThemeHelper extends View {
        @Inject
        FbActionBarUtil f6127a;
        @Inject
        @IsWorkBuild
        Boolean f6128b;

        private static <T extends View> void m5844a(Class<T> cls, T t) {
            m5845a((Object) t, t.getContext());
        }

        private static void m5845a(Object obj, Context context) {
            FbInjector fbInjector = FbInjector.get(context);
            ((ThemeHelper) obj).m5843a(FbActionBarUtil.a(fbInjector), Boolean_IsWorkBuildMethodAutoProvider.a(fbInjector));
        }

        private void m5843a(FbActionBarUtil fbActionBarUtil, Boolean bool) {
            this.f6127a = fbActionBarUtil;
            this.f6128b = bool;
        }

        public ThemeHelper(Context context) {
            super(context);
            m5844a(ThemeHelper.class, (View) this);
        }
    }

    private static <T extends Context> void m5858a(Class<T> cls, T t) {
        m5859a((Object) t, (Context) t);
    }

    public static void m5859a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((CreateThreadActivity) obj).m5848a(BlockingUtils.b(fbInjector), BugReportOperationLogger.a(fbInjector), ErrorDialogs.a(fbInjector), InputMethodManagerMethodAutoProvider.b(fbInjector), IdBasedProvider.a(fbInjector, 4577), RunningTaskInfoManager.a(fbInjector), SendDialogUtils.m3710b(fbInjector), UserCache.a(fbInjector), IdBasedLazy.a(fbInjector, 7858));
    }

    public final String am_() {
        return "create_thread";
    }

    private void m5848a(BlockingUtils blockingUtils, BugReportOperationLogger bugReportOperationLogger, ErrorDialogs errorDialogs, InputMethodManager inputMethodManager, Provider<AppCompatActivityOverrider> provider, RunningTaskInfoManager runningTaskInfoManager, SendDialogUtils sendDialogUtils, UserCache userCache, com.facebook.inject.Lazy<MessageForwardHandler> lazy) {
        this.f6148p = blockingUtils;
        this.f6149q = bugReportOperationLogger;
        this.f6150r = errorDialogs;
        this.f6151s = inputMethodManager;
        this.f6152t = provider;
        this.f6153u = runningTaskInfoManager;
        this.f6154v = sendDialogUtils;
        this.f6155w = userCache;
        this.f6131A = lazy;
    }

    protected final void m5888a(Bundle bundle) {
        super.a(bundle);
        m5872i();
        Class cls = CreateThreadActivity.class;
        m5859a((Object) this, (Context) this);
        this.f6141K = this.f6133C.a();
        if (this.f6141K) {
            this.f6134D = (AppCompatActivityOverrider) this.f6152t.get();
            a(this.f6134D);
        }
    }

    private void m5872i() {
        ThemeHelper themeHelper = new ThemeHelper(this);
        this.f6133C = themeHelper.f6127a;
        if (!this.f6132B.a()) {
            int i;
            boolean booleanValue = themeHelper.f6128b.booleanValue();
            if (this.f6133C.a()) {
                i = 2131625110;
            } else if (booleanValue) {
                i = 2131626445;
            } else {
                i = 2131625109;
            }
            setTheme(i);
        }
    }

    public final void m5889a(Fragment fragment) {
        super.a(fragment);
        if (fragment instanceof NewMessageSenderFragment) {
            ((NewMessageSenderFragment) fragment).aF = new C09341(this);
        } else if (fragment instanceof ComposeFragment) {
            ((ComposeFragment) fragment).m4962a(m5883t());
        }
    }

    public final void m5891b(Bundle bundle) {
        User user;
        boolean z;
        super.b(bundle);
        this.f6146P = this.f6153u.b(this, TaskRunningInPlatformContext.class);
        setContentView(2130905678);
        this.f6136F = (OverlayLayout) a(2131564810);
        this.f6137G = (LinearLayout) a(2131564811);
        this.f6138H = (CreateThreadCustomLayout) a(2131564812);
        if (this.f6141K) {
            this.f6135E = new ActionBarBasedFbTitleBar(this, this.f6134D.g());
        } else {
            FbTitleBarUtil.b(this);
        }
        if (bundle != null) {
            this.f6142L = (NavigationTrigger) bundle.getParcelable("trigger");
        }
        if (this.f6142L == null) {
            this.f6142L = NavigationTrigger.b(am_().toString());
        }
        Intent intent = getIntent();
        if (bundle == null) {
            Parcelable parcelableExtra = intent.getParcelableExtra("to");
            if (parcelableExtra != null) {
                if (parcelableExtra instanceof User) {
                    user = (User) parcelableExtra;
                    if (!this.f6141K || (!intent.getBooleanExtra("disable_create_thread_suggestions", false) && intent.getParcelableExtra("extra_messenger_share_preview") == null)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    this.f6145O = z;
                    if (intent.hasExtra("message")) {
                        this.f6143M = (Message) intent.getParcelableExtra("message");
                    } else if (intent.hasExtra("media_resource")) {
                        this.f6144N = (MediaResource) intent.getParcelableExtra("media_resource");
                    }
                    getWindow().getDecorView().getViewTreeObserver().addOnGlobalFocusChangeListener(new C09352(this));
                    this.f6147Q = (ContactMultipickerFragment) kO_().a(2131564813);
                    this.f6147Q.aJ = m5873j(this);
                    this.f6139I = this.f6147Q.at;
                    this.f6140J = (ComposeFragment) kO_().a(2131564814);
                    if (user != null && intent.getBooleanExtra("disableContactPicker", false)) {
                        this.f6139I.at();
                    }
                    m5876m();
                    this.f6147Q.m5709a(am_().toString());
                    this.f6147Q.m5713b(getString(2131230923));
                    if (intent.getStringArrayExtra("hoistedUserIds") != null) {
                        this.f6147Q.m5712b(ImmutableList.copyOf(intent.getStringArrayExtra("hoistedUserIds")));
                    }
                    m5875l(this);
                    m5878o();
                    if (m5873j(this)) {
                        this.f6147Q.ar();
                    } else {
                        m5874k();
                    }
                    this.f6140J.m4976h(this.f6146P);
                    this.f6140J.bw = false;
                    this.f6140J.bt = new C09363(this);
                    if (user != null) {
                        this.f6139I.m5762a(user);
                    }
                    if (bundle == null) {
                        this.f6140J.m4956a(ComposerInitParamsFactory.m5015a(getIntent()));
                    }
                    getWindow().setBackgroundDrawable(null);
                }
                BLog.a(f6129y, "\"to\" extra is not of expected type, ignoring");
            }
        }
        user = null;
        if (this.f6141K) {
        }
        z = false;
        this.f6145O = z;
        if (intent.hasExtra("message")) {
            this.f6143M = (Message) intent.getParcelableExtra("message");
        } else if (intent.hasExtra("media_resource")) {
            this.f6144N = (MediaResource) intent.getParcelableExtra("media_resource");
        }
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalFocusChangeListener(new C09352(this));
        this.f6147Q = (ContactMultipickerFragment) kO_().a(2131564813);
        this.f6147Q.aJ = m5873j(this);
        this.f6139I = this.f6147Q.at;
        this.f6140J = (ComposeFragment) kO_().a(2131564814);
        this.f6139I.at();
        m5876m();
        this.f6147Q.m5709a(am_().toString());
        this.f6147Q.m5713b(getString(2131230923));
        if (intent.getStringArrayExtra("hoistedUserIds") != null) {
            this.f6147Q.m5712b(ImmutableList.copyOf(intent.getStringArrayExtra("hoistedUserIds")));
        }
        m5875l(this);
        m5878o();
        if (m5873j(this)) {
            this.f6147Q.ar();
        } else {
            m5874k();
        }
        this.f6140J.m4976h(this.f6146P);
        this.f6140J.bw = false;
        this.f6140J.bt = new C09363(this);
        if (user != null) {
            this.f6139I.m5762a(user);
        }
        if (bundle == null) {
            this.f6140J.m4956a(ComposerInitParamsFactory.m5015a(getIntent()));
        }
        getWindow().setBackgroundDrawable(null);
    }

    public static boolean m5873j(CreateThreadActivity createThreadActivity) {
        return !createThreadActivity.f6145O;
    }

    private void m5874k() {
        this.f6139I.aC = new C09374(this);
    }

    public static void m5875l(CreateThreadActivity createThreadActivity) {
        createThreadActivity.f6139I.m5774g(2131230922);
        createThreadActivity.f6139I.aI = Integer.MAX_VALUE;
        ListType listType = (!createThreadActivity.f6141K || createThreadActivity.f6139I.aB || createThreadActivity.f6146P) ? ListType.FACEBOOK_LIST : ListType.DIVEBAR_LIST;
        createThreadActivity.f6139I.m5755a(listType);
        createThreadActivity.f6139I.aw();
        m5877n(createThreadActivity);
        if (m5873j(createThreadActivity)) {
            createThreadActivity.f6147Q.aq();
        } else {
            createThreadActivity.f6147Q.ar();
        }
    }

    private void m5876m() {
        this.f6139I.ar = new C09385(this);
    }

    public static void m5877n(CreateThreadActivity createThreadActivity) {
        createThreadActivity.f6140J.m4975h(m5885v(createThreadActivity));
        boolean a = m5861a(createThreadActivity.m5886w());
        createThreadActivity.f6140J.m4978j(a);
        createThreadActivity.f6140J.m4974g(a ? createThreadActivity.getResources().getColor(2131362305) : 0);
        createThreadActivity.m5879p();
    }

    private static boolean m5861a(ImmutableList<User> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            if (!((User) immutableList.get(i)).b()) {
                return false;
            }
        }
        return true;
    }

    private void m5878o() {
        this.f6139I.at = new C09396(this);
    }

    protected void onResume() {
        boolean z = false;
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1850955776);
        super.onResume();
        Intent intent = getIntent();
        if (intent != null) {
            if (MessagingIntents.a(intent, "focus_compose", false)) {
                z = true;
            }
            String a2 = MessagingIntents.a(intent, "trigger");
            if (a2 != null) {
                this.f6142L = NavigationTrigger.a(a2);
            }
        }
        if (z) {
            m5881r();
            this.f6140J.T.requestFocus();
        } else if (!m5873j(this) || this.f6141K) {
            this.f6139I.T.requestFocus();
        }
        if (m5873j(this)) {
            this.f6147Q.aq();
        } else {
            this.f6147Q.ar();
        }
        LogUtils.c(-1766894667, a);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("composeExpanded", this.f6156x);
        if (this.f6142L != null) {
            bundle.putParcelable("trigger", this.f6142L);
        }
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (bundle.getBoolean("composeExpanded")) {
            m5881r();
        }
    }

    public final void m5890a(final LeaveCheckListener leaveCheckListener) {
        if (this.f6140J.aB()) {
            leaveCheckListener.a(true);
        } else {
            new FbAlertDialogBuilder(this).a(2131231252).b(2131231253).b(2131231254, new OnClickListener(this) {
                final /* synthetic */ CreateThreadActivity f6125b;

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    leaveCheckListener.a(false);
                }
            }).a(2131231255, new OnClickListener(this) {
                final /* synthetic */ CreateThreadActivity f6123b;

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    leaveCheckListener.a(true);
                }
            }).b();
        }
    }

    public void onBackPressed() {
        if (!this.f6140J.au()) {
            if (this.f6140J.aB()) {
                finish();
                m5882s(this);
                return;
            }
            m5860a(new C09429(this));
        }
    }

    private void m5879p() {
        if (!this.f6146P) {
            Object obj = (this.f6143M == null && this.f6144N == null) ? null : 1;
            FragmentTransaction a;
            if (m5884u() && obj == null && this.f6140J.K) {
                a = kO_().a();
                a.a(2130968680, 2130968686);
                a.c(this.f6140J);
                a.b();
                this.f6140J.at();
            } else if ((!m5884u() || obj != null) && !this.f6140J.K) {
                a = kO_().a();
                a.b(this.f6140J);
                a.b();
                this.f6140J.as();
            }
        }
    }

    private void m5847a(View view) {
        ViewParent parent = view != null ? view.getParent() : null;
        while (parent != null) {
            if (parent == this.f6147Q.T) {
                m5880q();
                return;
            } else if (parent == this.f6140J.T) {
                m5881r();
                return;
            } else {
                parent = parent.getParent();
            }
        }
    }

    private void m5880q() {
        if (this.f6156x) {
            this.f6140J.m4954a(ComposeMode.SHRUNK);
            this.f6138H.setComposeMode(ComposeMode.SHRUNK);
            this.f6156x = false;
            this.f6136F.requestLayout();
        }
    }

    private void m5881r() {
        if (!this.f6156x) {
            this.f6140J.m4954a(ComposeMode.EXPANDED);
            this.f6138H.setComposeMode(ComposeMode.EXPANDED);
            this.f6156x = true;
            this.f6136F.requestLayout();
        }
    }

    private void m5849a(Message message) {
        ImmutableList e = this.f6139I.m5772e();
        if (e.isEmpty()) {
            this.f6150r.a(ErrorDialogParams.a(this).a(2131230721).b(2131231239).l());
            return;
        }
        if (!this.f6148p.a(this.f6155w.a(this.f6139I.ar()), kO_())) {
            boolean z;
            String str = am_().toString();
            NavigationTrigger navigationTrigger = this.f6142L;
            if (getCallingActivity() != null) {
                z = true;
            } else {
                z = false;
            }
            NewMessageSenderFragment newMessageSenderFragment = new NewMessageSenderFragment();
            Bundle bundle = new Bundle();
            if (e != null) {
                bundle.putParcelableArrayList("r", Lists.a(e));
            }
            bundle.putParcelable("m", message);
            bundle.putString("om", str);
            bundle.putParcelable("t", navigationTrigger);
            bundle.putBoolean("rtv", z);
            newMessageSenderFragment.g(bundle);
            newMessageSenderFragment.a(kO_(), "send_fragment");
        }
    }

    private void m5850a(ThreadKey threadKey) {
        if (getCallingActivity() != null) {
            setResult(-1);
        } else {
            m5863b(threadKey);
        }
        finish();
    }

    private void m5851a(FetchThreadResult fetchThreadResult) {
        ComponentName callingActivity = getCallingActivity();
        if (callingActivity != null) {
            int size = fetchThreadResult.e.size() - 1;
            boolean z = !StringUtil.a(fetchThreadResult.c.p);
            Intent intent = new Intent();
            intent.putExtra("intent_result_has_message", z);
            intent.putExtra("intent_result_num_recipients", size);
            setResult(-1, intent);
        }
        finish();
        ThreadSummary threadSummary = fetchThreadResult.c;
        this.f6140J.m4966b(threadSummary.a);
        if (callingActivity == null) {
            m5863b(threadSummary.a);
        }
    }

    private void m5863b(ThreadKey threadKey) {
        startActivity(ThreadViewActivity.m7086a((Context) this, threadKey));
        overridePendingTransition(2130968681, 2130968689);
    }

    public static void m5865b(CreateThreadActivity createThreadActivity, Throwable th) {
        if (!(th instanceof CancellationException)) {
            Message message;
            BLog.b(f6129y, th, "Failed to create thread for non-cancellation reason", new Object[0]);
            if (th instanceof SendMessageException) {
                message = ((SendMessageException) th).failedMessage;
            } else {
                message = null;
            }
            SendError sendError = message == null ? null : message.w;
            if (sendError == null || !sendError.b.shouldNotBeRetried) {
                Object obj;
                String string;
                SendDialogUtils sendDialogUtils = createThreadActivity.f6154v;
                SendErrorHelper sendErrorHelper = sendDialogUtils.f3985d;
                if (message != null && ((MediaUploadManagerImpl) sendErrorHelper.f3994f.get()).b(message).b == UploadState.FAILED && sendErrorHelper.f3989a.a(message) == MessageClassification.VIDEO_CLIP) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    string = sendErrorHelper.f3992d.getString(2131231736);
                } else {
                    string = sendErrorHelper.f3992d.getString(2131231183);
                }
                String str = string;
                String b = sendDialogUtils.f3985d.m3719b(message);
                if (b == null) {
                    b = createThreadActivity.getString(2131231240);
                }
                ErrorDialogs errorDialogs = sendDialogUtils.f3986e;
                ErrorDialogParamsBuilder a = ErrorDialogParams.a(sendDialogUtils.f3983b);
                a.b = str;
                ErrorDialogParamsBuilder errorDialogParamsBuilder = a;
                errorDialogParamsBuilder.c = b;
                errorDialogs.a(errorDialogParamsBuilder.l());
                return;
            }
            createThreadActivity.f6154v.m3711a(createThreadActivity, message.a, sendError.d, sendError.c, message.b);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (!(this.f6143M == null && this.f6144N == null)) {
            getMenuInflater().inflate(2131820559, menu);
        }
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        if (this.f6141K && onCreateOptionsMenu) {
            this.f6135E.a(menu);
        }
        return onCreateOptionsMenu;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        boolean z;
        if (menuItem.getItemId() == 16908332) {
            m5860a(new Runnable(this) {
                final /* synthetic */ CreateThreadActivity f6113a;

                {
                    this.f6113a = r1;
                }

                public void run() {
                    this.f6113a.f6134D.j(this.f6113a);
                    CreateThreadActivity.m5882s(this.f6113a);
                }
            });
            z = true;
        } else {
            if (menuItem.getItemId() == 2131568636) {
                MessageForwardHandler messageForwardHandler;
                if (this.f6143M != null) {
                    messageForwardHandler = (MessageForwardHandler) this.f6131A.get();
                    m5849a(messageForwardHandler.f2388b.a(this.f6143M, null, null));
                    z = false;
                } else if (this.f6144N != null) {
                    messageForwardHandler = (MessageForwardHandler) this.f6131A.get();
                    m5849a(messageForwardHandler.f2388b.a(this.f6144N, null, null));
                    z = false;
                }
            } else if (this.f6141K) {
                z = this.f6135E.a(menuItem);
            }
            z = false;
        }
        if (z || super.onOptionsItemSelected(menuItem)) {
            return true;
        }
        return false;
    }

    private void m5860a(final Runnable runnable) {
        m5890a(new LeaveCheckListener(this) {
            final /* synthetic */ CreateThreadActivity f6115b;

            public final void m5831a(boolean z) {
                if (z) {
                    this.f6115b.f6151s.hideSoftInputFromWindow(this.f6115b.getWindow().getDecorView().getWindowToken(), 0);
                    runnable.run();
                }
            }
        });
    }

    public static void m5882s(CreateThreadActivity createThreadActivity) {
        if (createThreadActivity.f6141K) {
            createThreadActivity.overridePendingTransition(2130968682, 2130968686);
        }
    }

    public final CustomKeyboardLayout m5892c() {
        return (CustomKeyboardLayout) a(2131560874);
    }

    private boolean m5883t() {
        ComposerInitParams a = ComposerInitParamsFactory.m5015a(getIntent());
        if (a == null) {
            return false;
        }
        if (a.f5426b != null && !a.f5426b.isEmpty()) {
            return true;
        }
        if (a.f5429e != null) {
            return true;
        }
        return false;
    }

    public final DisplayPolicy m5887a() {
        return DisplayPolicy.HIDE;
    }

    private boolean m5884u() {
        return m5885v(this) > 0;
    }

    public static int m5885v(CreateThreadActivity createThreadActivity) {
        return createThreadActivity.m5886w().size();
    }

    private ImmutableList<User> m5886w() {
        return this.f6139I == null ? f6130z : this.f6139I.m5772e();
    }

    public static void m5864b(CreateThreadActivity createThreadActivity, String str) {
        createThreadActivity.f6149q.a(str, BugReportCategory.COMPOSE_MESSAGE_FLOW);
        m5877n(createThreadActivity);
    }
}
