package com.facebook.orca.threadview;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewCompat;
import android.support.v7.internal.widget.ViewStubCompat;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import com.facebook.analytics.InteractionLogger;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.appirater.InternalStarRatingController;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.base.fragment.FbFragment;
import com.facebook.bugreporter.BugReportCategory;
import com.facebook.bugreporter.BugReportFlowStartParams;
import com.facebook.bugreporter.BugReportFlowStartParams.BugReportFlowStartParamsBuilder;
import com.facebook.bugreporter.BugReportOperationLogger;
import com.facebook.bugreporter.BugReportSource;
import com.facebook.bugreporter.BugReporter;
import com.facebook.bugreporter.activity.FragmentWithDebugInfo;
import com.facebook.common.appchoreographer.AppChoreographer;
import com.facebook.common.appchoreographer.AppChoreographer.Priority;
import com.facebook.common.appchoreographer.AppChoreographer.ThreadType;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.loader.FbLoader.Callback;
import com.facebook.common.random.InsecureRandom;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.ui.keyboard.CustomKeyboardContainer;
import com.facebook.common.ui.keyboard.CustomKeyboardLayout;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.ExceptionUtil;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.contacts.graphql.Contact;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.divebar.DrawerBasedDivebarControllerImpl;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.menu.ExportMenuToFbHostActivity;
import com.facebook.menu.ExportMenuToFbHostActivity.CustomFbHostMenuItem;
import com.facebook.messages.ipc.MessagingIntentUris;
import com.facebook.messages.links.MessengerLinks;
import com.facebook.messaging.activity.DivebarEnabledActivity;
import com.facebook.messaging.analytics.navigation.MessagingAnalyticsLogger;
import com.facebook.messaging.analytics.perf.MessagingPerformanceLogger;
import com.facebook.messaging.annotations.IsMessengerMaterialDesignEnabled;
import com.facebook.messaging.blocking.ManageBlockingParam;
import com.facebook.messaging.business.commerceui.analytics.MessengerCommerceAnalyticsLogger;
import com.facebook.messaging.business.common.activity.BusinessActivity;
import com.facebook.messaging.business.messengerextensions.MessengerExtensionsManager;
import com.facebook.messaging.cache.ArchiveThreadManager;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.cache.SpamThreadManager;
import com.facebook.messaging.chatheads.detect.ChatHeadsContextDetector;
import com.facebook.messaging.chatheads.intents.ChatHeadsOpenHelper;
import com.facebook.messaging.chatheads.ipc.ChatHeadsBroadcaster;
import com.facebook.messaging.connectivity.ConnectionStatusMonitor;
import com.facebook.messaging.connectivity.ConnectionStatusMonitorMethodAutoProvider;
import com.facebook.messaging.connectivity.annotations.IsConnStatusBannerEnabled;
import com.facebook.messaging.groups.logging.GroupJoinableLinksLogger;
import com.facebook.messaging.groups.sharesheet.GroupShareSheetCreator;
import com.facebook.messaging.material.abtest.MaterialDesignExperimentHelper;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.model.threads.NotificationSetting;
import com.facebook.messaging.model.threads.NotificationState;
import com.facebook.messaging.model.threads.ThreadEventReminder;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.neue.threadsettings.extras.MessengerThreadSettingsExtras.ThreadSettingsType;
import com.facebook.messaging.notify.MessagesNotificationClient;
import com.facebook.messaging.phoneintegration.util.OutgoingPhoneCallManager;
import com.facebook.messaging.photos.service.PhotoMessageDataCache;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.messaging.rtc.dialog.RTCMultiwaySelectDialogBuilder;
import com.facebook.messaging.send.client.PendingThreadsManager;
import com.facebook.messaging.send.client.PendingThreadsManager.PendingThreadException;
import com.facebook.messaging.send.trigger.NavigationTrigger;
import com.facebook.messaging.send.ui.SendDialogUtils;
import com.facebook.messaging.sms.util.SmsContactUtil;
import com.facebook.messaging.threadview.theming.ThreadViewFragmentTheming;
import com.facebook.messaging.threadview.titlebar.ChatHeadsThreadViewFbTitleBar;
import com.facebook.messaging.threadview.titlebar.ThreadTitleBarTheme;
import com.facebook.messaging.threadview.titlebar.ThreadTitleBarThemeFactory;
import com.facebook.messaging.ui.name.MessengerThreadNameViewData;
import com.facebook.messaging.ui.name.MessengerThreadNameViewDataFactory;
import com.facebook.messaging.users.CanonicalThreadPresenceHelper;
import com.facebook.messaging.users.MessengerInviteEligibilityChecker;
import com.facebook.messaging.widget.anchorabletoast.AnchorableToast;
import com.facebook.orca.compose.ComposeObserver.OnSendListener;
import com.facebook.orca.notify.NotificationSettingsUtil;
import com.facebook.orca.threadview.ThreadViewActivity.C11181;
import com.facebook.orca.threadview.ThreadViewFragmentActionHandler.Listener;
import com.facebook.orca.threadview.ThreadViewLoader.Error;
import com.facebook.orca.threadview.ThreadViewLoader.LoadType;
import com.facebook.orca.threadview.ThreadViewLoader.Params;
import com.facebook.orca.threadview.ThreadViewLoader.Result;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.Source;
import com.facebook.orca.threadview.ThreadViewOptionsHandler.C12044;
import com.facebook.orca.threadview.ThreadViewOptionsHandler.Mode;
import com.facebook.orca.threadview.ThreadViewTooltip.TooltipShownType;
import com.facebook.orca.threadview.ephemeral.EphemeralToggleButton;
import com.facebook.orca.threadview.ephemeral.EphemeralToggleButtonHelper;
import com.facebook.orca.threadview.sms.SmsThreadViewButtonsHelper;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.presence.Availability;
import com.facebook.presence.DefaultPresenceManager;
import com.facebook.presence.PresenceManager;
import com.facebook.presence.PresenceState;
import com.facebook.presence.ThreadPresenceManager;
import com.facebook.presence.ThreadPresenceManager.OnThreadPresenceStateChangedListener;
import com.facebook.push.mqtt.capability.MqttVoipCapability;
import com.facebook.push.mqtt.capability.MqttVoipCapabilityImpl;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rtc.dialogs.RtcMergedAudioVideoDialogHelper;
import com.facebook.rtc.dialogs.WebrtcGroupDialogBuilder;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler;
import com.facebook.rtc.fbwebrtc.abtests.ExperimentsForRtcModule;
import com.facebook.rtc.helpers.RtcCallButtonIconProvider;
import com.facebook.rtc.helpers.RtcCallHandler;
import com.facebook.rtc.models.RtcCalleeInfo;
import com.facebook.rtc.prefs.VoipPrefKeys;
import com.facebook.rtcpresence.RtcPresenceHandler;
import com.facebook.rtcpresence.RtcPresenceListenerDefault;
import com.facebook.rtcpresence.annotations.IsVoipEnabledForUser;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.errordialog.ErrorMessageGenerator;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.facebook.webrtc.IWebrtcUiInterface.EndCallReason;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnBackPressedListener;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.ToolbarBasedFbTitleBar;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: message_block_select_leave_group_from_blocked_warning_alert */
public class ThreadViewFragment extends FbFragment implements AnalyticsFragment, FragmentWithDebugInfo, CustomKeyboardContainer, ExportMenuToFbHostActivity {
    private static final Class<?> bp = ThreadViewFragment.class;
    @Inject
    AnchorableToast f7515a;
    @Inject
    DefaultPresenceManager aA;
    @Inject
    ThreadPresenceManager aB;
    @Inject
    SecureContextHelper aC;
    @Inject
    SendDialogUtils aD;
    @Inject
    SpamThreadManager aE;
    @Inject
    ThreadTitleBarThemeFactory aF;
    @Inject
    Lazy<ThreadViewDebugHelper> aG;
    @Inject
    ThreadViewFragmentActionHandler aH;
    @Inject
    ThreadViewFragmentTheming aI;
    @Inject
    ThreadViewLoader aJ;
    @Inject
    Lazy<ThreadViewOperationsHelper> aK;
    @Inject
    ThreadViewOptionsHandler aL;
    @Inject
    ThreadViewTitleHelper aM;
    @Inject
    ThreadViewTooltipProvider aN;
    @Inject
    Lazy<ViewerContext> aO;
    @Inject
    RtcCallHandler aP;
    @Inject
    Lazy<WebrtcGroupDialogBuilder> aQ;
    @Inject
    RtcPresenceHandler aR;
    @Inject
    AbstractFbErrorReporter aS;
    @Inject
    Provider<BugReporter> aT;
    @Inject
    MessagingPerformanceLogger aU;
    @Inject
    @InsecureRandom
    Random aV;
    @Inject
    ThreadViewTitleBarButtonSpecHelper aW;
    @Inject
    BugReportOperationLogger aX;
    @Inject
    MessengerCommerceAnalyticsLogger aY;
    @Inject
    Lazy<EphemeralToggleButtonHelper> aZ;
    @Inject
    FbAppType al;
    @Inject
    FbSharedPreferences am;
    @Inject
    InteractionLogger an;
    @Inject
    InternalStarRatingController ao;
    @Inject
    @IsConnStatusBannerEnabled
    Provider<Boolean> ap;
    @IsVoipEnabledForUser
    @Inject
    Provider<Boolean> aq;
    @Inject
    MaterialDesignExperimentHelper ar;
    @Inject
    MessagesNotificationClient as;
    @Inject
    MessagingAnalyticsLogger at;
    @Inject
    MessengerInviteEligibilityChecker au;
    @Inject
    MessengerThreadNameViewDataFactory av;
    @Inject
    MqttVoipCapabilityImpl aw;
    @Inject
    NavigationLogger ax;
    @Inject
    NotificationSettingsUtil ay;
    @Inject
    PhotoMessageDataCache az;
    @Inject
    DefaultAppChoreographer f7516b;
    public ThreadKey bA;
    private List<TitleBarButtonSpec> bB;
    public ThreadViewMessagesFragment bC;
    private boolean bD;
    private boolean bE;
    public boolean bF = true;
    private boolean bG;
    private boolean bH;
    public User bI;
    private Source bJ;
    public ThreadViewLoaderResultState bK = ThreadViewLoaderResultState.f7642c;
    private boolean bL;
    private ThreadViewMessagesInitParams bM;
    private boolean bN;
    public ThreadViewFragmentListener bO;
    private ThreadSettingsLauncher bP;
    @Nullable
    public C11181 bQ;
    private OnSharedPreferenceChangeListener bR;
    private PresenceState bS = PresenceState.a;
    private OnSendListener bT;
    public NavigationTrigger bU;
    private int bV = -1;
    private ThreadTitleBarTheme bW;
    private Context bX;
    private SelfRegistrableReceiverImpl bY;
    public ScheduledFuture bZ = null;
    @Inject
    Lazy<OutgoingPhoneCallManager> ba;
    @Inject
    Lazy<GlyphColorizer> bb;
    @Inject
    Lazy<SmsThreadViewButtonsHelper> bc;
    @Inject
    @LocalBroadcast
    BaseFbBroadcastManager bd;
    @Inject
    QeAccessor be;
    @Inject
    Lazy<RtcMergedAudioVideoDialogHelper> bf;
    @Inject
    ThreadViewUserDataUtil bg;
    @Inject
    Lazy<PendingThreadsManager> bh;
    @Inject
    RTCMultiwaySelectDialogBuilder bi;
    @IsMessengerMaterialDesignEnabled
    @Inject
    Provider<Boolean> bj;
    @Inject
    SmsContactUtil bk;
    @Inject
    UserCache bl;
    @Inject
    WebrtcUiHandler bm;
    @Inject
    @ForUiThread
    ScheduledExecutorService bn;
    @Inject
    MessengerExtensionsManager bo;
    private RtcPresenceListenerDefault bq;
    private AnonymousClass16 br;
    private final List<TitleBarButtonSpec> bs = RegularImmutableList.a;
    @Inject
    @com.facebook.ultralight.Lazy
    private Lazy<GroupShareSheetCreator> bt = UltralightRuntime.b;
    @Inject
    @com.facebook.ultralight.Lazy
    private Lazy<ThreadEventReminderLoader> bu = UltralightRuntime.b;
    @Inject
    @com.facebook.ultralight.Lazy
    private Lazy<GroupJoinableLinksLogger> bv = UltralightRuntime.b;
    public ThreadViewTooltip bw;
    private FragmentManager bx;
    private boolean by;
    private FbTitleBar bz;
    @Inject
    ArchiveThreadManager f7517c;
    public long ca;
    private final OnSharedPreferenceChangeListener cb = new C11271(this);
    private final OnThreadPresenceStateChangedListener cc = new OnThreadPresenceStateChangedListener(this) {
        final /* synthetic */ ThreadViewFragment f7499a;

        {
            this.f7499a = r1;
        }

        public final void m7137a(boolean z) {
            this.f7499a.aC();
        }
    };
    @Inject
    CanonicalThreadPresenceHelper f7518d;
    @Inject
    ChatHeadsBroadcaster f7519e;
    @Inject
    ChatHeadsOpenHelper f7520f;
    @Inject
    ConnectionStatusMonitor f7521g;
    @Inject
    DataCache f7522h;
    @Inject
    ErrorMessageGenerator f7523i;

    /* compiled from: message_block_select_leave_group_from_blocked_warning_alert */
    public interface ThreadViewFragmentListener {
        void mo313a();

        void mo314a(int i);
    }

    /* compiled from: message_block_select_leave_group_from_blocked_warning_alert */
    class C11271 implements OnSharedPreferenceChangeListener {
        final /* synthetic */ ThreadViewFragment f7506a;

        C11271(ThreadViewFragment threadViewFragment) {
            this.f7506a = threadViewFragment;
        }

        public final void m7140a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
            if (Objects.equal(prefKey, MessagingPrefKeys.ae) && this.f7506a.mx_()) {
                ThreadViewFragment.aS(this.f7506a);
                this.f7506a.gE_();
            }
        }
    }

    /* compiled from: message_block_select_leave_group_from_blocked_warning_alert */
    class C11282 implements OnSharedPreferenceChangeListener {
        final /* synthetic */ ThreadViewFragment f7507a;

        C11282(ThreadViewFragment threadViewFragment) {
            this.f7507a = threadViewFragment;
        }

        public final void m7141a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
            if (this.f7507a.bC != null) {
                this.f7507a.bC.ar();
            }
        }
    }

    /* compiled from: message_block_select_leave_group_from_blocked_warning_alert */
    public class C11293 {
        final /* synthetic */ ThreadViewFragment f7508a;

        C11293(ThreadViewFragment threadViewFragment) {
            this.f7508a = threadViewFragment;
        }

        public final void m7142a() {
            this.f7508a.C();
        }
    }

    /* compiled from: message_block_select_leave_group_from_blocked_warning_alert */
    public class C11304 {
        final /* synthetic */ ThreadViewFragment f7509a;

        C11304(ThreadViewFragment threadViewFragment) {
            this.f7509a = threadViewFragment;
        }

        public final void m7145a(boolean z) {
            this.f7509a.aJ.m7352a(Params.m7323a(false, z));
        }

        public final void m7143a() {
            ThreadViewFragment.aS(this.f7509a);
        }

        public final void m7144a(int i) {
            ThreadViewFragment.m7218h(this.f7509a, i);
        }

        public final void m7146b() {
            if (this.f7509a.o() != null) {
                this.f7509a.o().onBackPressed();
            }
        }
    }

    /* compiled from: message_block_select_leave_group_from_blocked_warning_alert */
    class C11315 implements Callback<Params, Result, Error> {
        final /* synthetic */ ThreadViewFragment f7510a;

        C11315(ThreadViewFragment threadViewFragment) {
            this.f7510a = threadViewFragment;
        }

        public final void m7147a(Object obj, ListenableFuture listenableFuture) {
            Params params = (Params) obj;
            this.f7510a.f7516b.a(listenableFuture);
            this.f7510a.m7186a(params.f7606c);
        }

        public final void m7148a(Object obj, Object obj2) {
            this.f7510a.m7188a((Result) obj2);
        }

        public final void m7150c(Object obj, Object obj2) {
            Error error = (Error) obj2;
            this.f7510a.m7187a(((Params) obj).f7606c, error);
        }

        public final void m7149b(Object obj, Object obj2) {
            ThreadViewFragment.aH(this.f7510a);
        }
    }

    /* compiled from: message_block_select_leave_group_from_blocked_warning_alert */
    class C11326 implements Listener {
        final /* synthetic */ ThreadViewFragment f7511a;

        C11326(ThreadViewFragment threadViewFragment) {
            this.f7511a = threadViewFragment;
        }

        public final void mo317a() {
            this.f7511a.m7258i(false);
        }

        public final void mo322a(boolean z) {
            this.f7511a.m7258i(z);
        }

        public final void mo323b() {
            ThreadViewFragment.aW(this.f7511a);
        }

        public final void mo320a(String str) {
            this.f7511a.bC.m7673b(str);
        }

        public final void mo321a(String str, boolean z) {
            this.f7511a.bC.m7670a(str, z);
        }

        public final void mo319a(FailedMessageWithNoRetry failedMessageWithNoRetry) {
            this.f7511a.bC.m7670a(failedMessageWithNoRetry.f6915c, failedMessageWithNoRetry.f6918f);
            this.f7511a.aD.m3711a(this.f7511a.getContext(), failedMessageWithNoRetry.f6913a, failedMessageWithNoRetry.f6917e, failedMessageWithNoRetry.f6916d, failedMessageWithNoRetry.f6914b);
        }

        public final void mo318a(ThreadKey threadKey) {
            this.f7511a.m7238a(threadKey, Source.OTHER);
        }
    }

    /* compiled from: message_block_select_leave_group_from_blocked_warning_alert */
    class C11337 extends CanonicalThreadPresenceHelper.Listener {
        final /* synthetic */ ThreadViewFragment f7512a;

        C11337(ThreadViewFragment threadViewFragment) {
            this.f7512a = threadViewFragment;
        }

        public final void m7165a(PresenceState presenceState) {
            this.f7512a.m7189a(presenceState);
        }
    }

    /* compiled from: message_block_select_leave_group_from_blocked_warning_alert */
    class C11348 extends OnToolbarButtonListener {
        final /* synthetic */ ThreadViewFragment f7513a;

        C11348(ThreadViewFragment threadViewFragment) {
            this.f7513a = threadViewFragment;
        }

        public final void m7166a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            this.f7513a.ax.a("tap_top_right_nav");
            Result result = this.f7513a.bK.f7643a;
            if (titleBarButtonSpec.c == 1) {
                if (this.f7513a.o() != null) {
                    this.f7513a.o().openOptionsMenu();
                }
            } else if (titleBarButtonSpec.c == 5) {
                ThreadViewFragment.m7210d(this.f7513a, "Click on Voip call button");
                if (this.f7513a.bA == null || this.f7513a.bA.a != Type.GROUP) {
                    ThreadViewFragment.aB(this.f7513a);
                    this.f7513a.aP.a(this.f7513a.getContext(), ThreadKey.a(this.f7513a.bA), "thread_view_button");
                    ThreadViewFragment.aI(this.f7513a);
                    return;
                }
                ThreadViewFragment.au(this.f7513a);
            } else if (titleBarButtonSpec.c == 16) {
                ThreadViewFragment.m7221j(this.f7513a, false);
            } else if (titleBarButtonSpec.c == 25) {
                ThreadViewFragment.m7221j(this.f7513a, true);
            } else if (titleBarButtonSpec.c == 7) {
                ThreadViewFragment.m7210d(this.f7513a, "Click on invite button");
                this.f7513a.bC.m7669a("invite_button");
            } else if (titleBarButtonSpec.c == 6) {
                ThreadViewFragment.m7210d(this.f7513a, "Click on thread setting button");
                ThreadViewFragment.aY(this.f7513a);
            } else if (titleBarButtonSpec.c == 10) {
                ThreadViewFragment.m7210d(this.f7513a, "Click on video call button");
                this.f7513a.aP.b(this.f7513a.getContext(), ThreadKey.a(this.f7513a.bA), "thread_view_button_video");
                ThreadViewFragment.aI(this.f7513a);
            } else if (titleBarButtonSpec.c == 19) {
                ThreadViewFragment.aB(this.f7513a);
                this.f7513a.aP.a(ThreadKey.a(this.f7513a.bA), this.f7513a.getContext(), "thread_view_button_video", false);
            } else if (titleBarButtonSpec.c == 14) {
                ThreadViewOperationsHelper threadViewOperationsHelper = (ThreadViewOperationsHelper) this.f7513a.aK.get();
                threadViewOperationsHelper.f7922c.a(threadViewOperationsHelper.f7926g.a(threadViewOperationsHelper.f7920a, StringFormatUtil.formatStrLocaleSafe("fb://pma/sender_context_card/?sender_id=%s", Long.valueOf(this.f7513a.bA.d))), threadViewOperationsHelper.f7920a);
            } else if (titleBarButtonSpec.c == 15) {
                String l = Long.toString(this.f7513a.bA.d);
                Context context = this.f7513a.getContext();
                Parcelable bundle = new Bundle();
                bundle.putString("business_page_id", l);
                Intent a = BusinessActivity.a(context, "CommerceShoppingTrendingFragment", bundle);
                this.f7513a.aY.d(l);
                this.f7513a.aC.a(a, this.f7513a.getContext());
            } else if (titleBarButtonSpec.c == 17) {
                ((EphemeralToggleButtonHelper) this.f7513a.aZ.get()).m8082a((EphemeralToggleButton) view, result.f7611a);
            } else if (titleBarButtonSpec.c == 20) {
                String a2 = this.f7513a.bk.a(result.f7611a);
                if (a2 != null) {
                    this.f7513a.f7519e.b();
                    ((OutgoingPhoneCallManager) this.f7513a.ba.get()).a(a2);
                }
            } else if (titleBarButtonSpec.c == 21 || titleBarButtonSpec.c == 22) {
                ((SmsThreadViewButtonsHelper) this.f7513a.bc.get()).m8305a(result);
            } else if (titleBarButtonSpec.c == 23) {
                this.f7513a.bC.m7662a(ManageBlockingParam.c);
            } else if (titleBarButtonSpec.c == 24) {
                ((RtcMergedAudioVideoDialogHelper) this.f7513a.bf.get()).a(this.f7513a.bg.m7950a(result, this.f7513a.bA));
            } else if (titleBarButtonSpec.c == 26) {
                ThreadViewFragment.at(this.f7513a);
            }
        }
    }

    /* compiled from: message_block_select_leave_group_from_blocked_warning_alert */
    class C11359 implements OnBackPressedListener {
        final /* synthetic */ ThreadViewFragment f7514a;

        C11359(ThreadViewFragment threadViewFragment) {
            this.f7514a = threadViewFragment;
        }

        public final void m7167a() {
            ThreadViewFragment.aE(this.f7514a);
        }
    }

    /* compiled from: message_block_select_leave_group_from_blocked_warning_alert */
    public interface ThreadSettingsLauncher {
    }

    private static <T extends InjectableComponentWithContext> void m7190a(Class<T> cls, T t) {
        m7191a((Object) t, t.getContext());
    }

    private static void m7191a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ThreadViewFragment) obj).m7176a(AnchorableToast.m4479a(injectorLike), DefaultAppChoreographer.a(injectorLike), ArchiveThreadManager.a(injectorLike), CanonicalThreadPresenceHelper.a(injectorLike), ChatHeadsBroadcaster.a(injectorLike), ChatHeadsOpenHelper.a(injectorLike), ConnectionStatusMonitorMethodAutoProvider.a(injectorLike), DataCache.a(injectorLike), ErrorMessageGenerator.a(injectorLike), (FbAppType) injectorLike.getInstance(FbAppType.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), InteractionLogger.a(injectorLike), InternalStarRatingController.a(injectorLike), IdBasedProvider.a(injectorLike, 4141), IdBasedProvider.a(injectorLike, 4314), MaterialDesignExperimentHelper.a(injectorLike), MessagesNotificationClient.a(injectorLike), MessagingAnalyticsLogger.a(injectorLike), MessengerInviteEligibilityChecker.a(injectorLike), MessengerThreadNameViewDataFactory.a(injectorLike), MqttVoipCapabilityImpl.a(injectorLike), NavigationLogger.a(injectorLike), NotificationSettingsUtil.a(injectorLike), PhotoMessageDataCache.a(injectorLike), DefaultPresenceManager.a(injectorLike), ThreadPresenceManager.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), SendDialogUtils.m3709a(injectorLike), SpamThreadManager.a(injectorLike), ThreadTitleBarThemeFactory.m4370a(injectorLike), IdBasedLazy.a(injectorLike, 8860), ThreadViewFragmentActionHandler.m7259a(injectorLike), ThreadViewFragmentTheming.m4335a(injectorLike), ThreadViewLoader.m7333a(injectorLike), IdBasedLazy.a(injectorLike, 8869), ThreadViewOptionsHandler.m7884a(injectorLike), ThreadViewTitleHelper.m7931a(injectorLike), (ThreadViewTooltipProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ThreadViewTooltipProvider.class), IdBasedLazy.a(injectorLike, 372), RtcCallHandler.a(injectorLike), IdBasedLazy.a(injectorLike, 10369), RtcPresenceHandler.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 5011), MessagingPerformanceLogger.a(injectorLike), Random_InsecureRandomMethodAutoProvider.a(injectorLike), ThreadViewTitleBarButtonSpecHelper.m7904a(injectorLike), BugReportOperationLogger.a(injectorLike), MessengerCommerceAnalyticsLogger.a(injectorLike), IdBasedLazy.a(injectorLike, 8879), IdBasedSingletonScopeProvider.b(injectorLike, 8278), IdBasedSingletonScopeProvider.b(injectorLike, 1275), IdBasedLazy.a(injectorLike, 8888), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 10368), ThreadViewUserDataUtil.m7949a(injectorLike), IdBasedLazy.a(injectorLike, 8342), RTCMultiwaySelectDialogBuilder.m3600a(injectorLike), IdBasedProvider.a(injectorLike, 4073), SmsContactUtil.a(injectorLike), UserCache.a(injectorLike), WebrtcUiHandler.a(injectorLike), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), MessengerExtensionsManager.m1594a(injectorLike), IdBasedLazy.a(injectorLike, 7871), IdBasedLazy.a(injectorLike, 8857), IdBasedSingletonScopeProvider.b(injectorLike, 7868));
    }

    private static boolean m7201b(PresenceState presenceState) {
        return presenceState.b == Availability.AVAILABLE || presenceState.e;
    }

    public final String am_() {
        return "thread";
    }

    public final void a_(Context context) {
        super.a_(context);
        TracerDetour.a("TVF.onAttach", 1801250326);
        try {
            m7190a(ThreadViewFragment.class, (InjectableComponentWithContext) this);
            this.aU.a(5505047, aZ(), "onAttach");
            this.bx = s();
            this.bw = this.aN.m7945a(this);
            this.bR = new C11282(this);
            this.aL.m7889a(new C11293(this), mv_(), Mode.FOR_APP);
        } finally {
            if (this.aU != null) {
                this.aU.a(5505047, aZ(), (short) 43);
            }
            TracerDetour.a(-1521980067);
        }
    }

    public final void m7234a(Fragment fragment) {
        if (fragment instanceof ThreadViewMessagesFragment) {
            this.bC = (ThreadViewMessagesFragment) fragment;
            this.bC.dJ = this.bU;
            this.bC.m7674b(this.bH);
            this.bC.dn = new C11304(this);
        }
    }

    public final void m7250c(Bundle bundle) {
        super.c(bundle);
        TracerDetour.a("TVF.onFragmentCreate", -280930805);
        if (bundle != null) {
            try {
                ThreadKey threadKey = (ThreadKey) bundle.getParcelable("threadKey");
                if (threadKey != null) {
                    this.bA = threadKey;
                }
            } catch (Throwable th) {
                this.aU.a(5505047, aZ(), (short) 44);
                TracerDetour.a(-425346403);
            }
        }
        Bundle mt_ = mt_();
        if (mt_ != null) {
            this.by = mt_.containsKey("hostActionBar");
            if (mt_.getParcelable("args_thread_key") != null) {
                this.bA = (ThreadKey) mt_.getParcelable("args_thread_key");
                m7238a(this.bA, Source.OTHER);
            }
        }
        this.aU.a(5505047, aZ(), (short) 44);
        TracerDetour.a(1490918028);
    }

    protected final View m7248c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bX = ContextUtils.a(getContext(), 2130772971, 2131625128);
        return super.c(layoutInflater.cloneInContext(this.bX), viewGroup, bundle);
    }

    public final View m7230a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1669101759);
        this.aU.a(5505047, aZ(), "onCreateView");
        this.aU.a(5505047, aZ(), (short) 45);
        View inflate = layoutInflater.inflate(2130907386, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1766537504, a);
        return inflate;
    }

    public final void m7237a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.bC.dh.m4955a(this.bT);
    }

    public final void m7253d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1070328428);
        super.d(bundle);
        if (this.bA == null) {
            BLog.b(bp, "thread wasn't set before fragment was attached to activity!");
        }
        as();
        aQ();
        this.aJ.m7350a(new C11315(this));
        this.aH.f7535e = new C11326(this);
        this.aH.m7277a();
        if (((Boolean) this.aq.get()).booleanValue()) {
            this.f7518d.s = new C11337(this);
        }
        this.bG = true;
        az();
        e(true);
        this.aU.a(5505047, aZ(), (short) 46);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -207470730, a);
    }

    public final void m7242a(boolean z) {
        this.bF = z;
    }

    private void as() {
        if (this.by) {
            Toolbar toolbar = (Toolbar) ((ViewStubCompat) e(2131567844)).a();
            ViewCompat.g(toolbar, (float) ContextUtils.e(this.bX, 2130773225, 0));
            toolbar.setMinimumHeight(0);
            m7232a(ChatHeadsContextDetector.a(getContext()) ? new ChatHeadsThreadViewFbTitleBar(toolbar) : new ToolbarBasedFbTitleBar(toolbar));
        }
    }

    public final ThreadViewFragment m7232a(FbTitleBar fbTitleBar) {
        this.bz = fbTitleBar;
        this.bz.setOnToolbarButtonListener(new C11348(this));
        this.bz.setOnBackPressedListener(new C11359(this));
        this.aM.m7938a(this.bz);
        return this;
    }

    public static void at(ThreadViewFragment threadViewFragment) {
        ThreadSummary threadSummary = threadViewFragment.bK.f7643a.f7611a;
        if (threadSummary != null) {
            ((GroupShareSheetCreator) threadViewFragment.bt.get()).m2540a(threadViewFragment.bX, threadSummary).show();
            ((GroupJoinableLinksLogger) threadViewFragment.bv.get()).m2490a(threadSummary, "action_sheet");
        }
    }

    public final boolean m7247b(Intent intent) {
        return m7206c(intent);
    }

    private boolean m7206c(Intent intent) {
        Uri data = intent.getData();
        if (FacebookUriUtil.g(data) && "user".equals(data.getAuthority())) {
            List pathSegments = data.getPathSegments();
            if (pathSegments.size() == 2 && ((String) pathSegments.get(1)).equals("chatcolors") && ((String) pathSegments.get(0)).equals(String.valueOf(this.bA.d))) {
                this.bC.m7680d(null);
                return true;
            }
        }
        return false;
    }

    public static void m7221j(ThreadViewFragment threadViewFragment, boolean z) {
        if (threadViewFragment.bA != null && threadViewFragment.bA.a == Type.GROUP) {
            Result result = threadViewFragment.bK.f7643a;
            if (result == null || result.f7611a == null || result.f7611a.h == null) {
                BLog.b(bp, "Incomplete thread summary information, unable to start or join multiway call");
            } else if (threadViewFragment.bC.aw()) {
                Object ax = threadViewFragment.bC.ax();
                String str = z ? "multiway_join_thread_view_video_button" : "multiway_join_thread_view_button";
                if (StringUtil.a(ax)) {
                    BLog.b(bp, "Unable to join conference call, empty server info");
                } else {
                    threadViewFragment.aP.a(result.f7611a, ax, z, str, threadViewFragment.getContext());
                }
            } else {
                String str2 = z ? "multiway_call_thread_view_video_button" : "multiway_call_thread_view_button";
                if (threadViewFragment.bi.m3602a()) {
                    threadViewFragment.bi.m3601a(result.f7611a, z, str2);
                } else {
                    threadViewFragment.aP.a(result.f7611a, threadViewFragment.getContext(), z, str2);
                }
            }
        }
    }

    public static void au(ThreadViewFragment threadViewFragment) {
        Result result = threadViewFragment.bK.f7643a;
        if (result != null && result.f7611a != null) {
            ImmutableList immutableList = result.f7611a.h;
            if (immutableList != null) {
                Map hashMap = new HashMap();
                String str = ((ViewerContext) threadViewFragment.aO.get()).mUserId;
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    UserKey b = ((ThreadParticipant) immutableList.get(i)).b();
                    User a = threadViewFragment.bl.a(b);
                    if (!(a == null || a.e.f().isEmpty() || b.b().equals(str))) {
                        hashMap.put(b, new RtcCalleeInfo(a.j(), b));
                    }
                }
                ((WebrtcGroupDialogBuilder) threadViewFragment.aQ.get()).a(hashMap, "group_calling_button", "thread_group_button", "thread_group_button_video");
            }
        }
    }

    private boolean m7196a(User user) {
        Result result = this.bK.f7643a;
        return result != null && ((av() && result.f7611a != null) || user != null);
    }

    private boolean av() {
        return this.bA != null && this.bA.a == Type.GROUP;
    }

    private boolean aw() {
        return ThreadKey.d(this.bA);
    }

    private boolean ax() {
        return ThreadKey.f(this.bA);
    }

    private void ay() {
        if (this.bz != null) {
            aI(this);
            Result result = this.bK.f7643a;
            if (result != null) {
                m7208d(result.f7611a);
            } else {
                this.bz.setTitle(b(2131231096));
            }
            aS(this);
        }
    }

    public final void m7240a(ThreadViewFragmentListener threadViewFragmentListener) {
        this.bO = threadViewFragmentListener;
    }

    public final void m7255e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelable("threadKey", this.bA);
    }

    public final void m7238a(ThreadKey threadKey, Source source) {
        UserKey a;
        ThreadPresenceManager threadPresenceManager;
        Preconditions.checkNotNull(threadKey);
        if (!(this.bA == null || this.aB == null)) {
            a = ThreadKey.a(this.bA);
            threadPresenceManager = this.aB;
            if (((Boolean) threadPresenceManager.k.get()).booleanValue()) {
                ((DefaultAndroidThreadUtil) threadPresenceManager.c.get()).a();
                if (a != null) {
                    threadPresenceManager.s.d(a);
                }
            }
            if (this.bA.i() != threadKey.i()) {
                m7223k(false);
            }
        }
        this.bJ = source;
        this.bA = threadKey;
        this.bI = null;
        this.bM = null;
        if (this.aL != null) {
            this.aL.m7888a(threadKey);
        }
        if (this.bu.get() != null) {
            ((ThreadEventReminderLoader) this.bu.get()).a();
        }
        if (this.bG) {
            az();
        }
        if (!(av() || aw() || ax() || this.bA == null || this.aA == null || this.aB == null)) {
            a = ThreadKey.a(this.bA);
            threadPresenceManager = this.aB;
            OnThreadPresenceStateChangedListener onThreadPresenceStateChangedListener = this.cc;
            if (((Boolean) threadPresenceManager.k.get()).booleanValue()) {
                ((DefaultAndroidThreadUtil) threadPresenceManager.c.get()).a();
                if (a != null) {
                    threadPresenceManager.s.d(a);
                    threadPresenceManager.s.a(a, onThreadPresenceStateChangedListener);
                }
            }
        }
        if (this.bz != null && av()) {
            ThreadViewTooltip threadViewTooltip = this.bw;
            Optional a2 = FindViewUtil.a(this.T, 2131558459);
            if (threadViewTooltip.f8045j == TooltipShownType.NONE && a2.isPresent()) {
                int a3 = threadViewTooltip.f8039d.a(VoipPrefKeys.l, 0);
                if (a3 < 5) {
                    CharSequence string = threadViewTooltip.f8040e.getString(2131232181);
                    threadViewTooltip.f8047l = new Tooltip(threadViewTooltip.f8041f.getContext(), 2131624619);
                    threadViewTooltip.f8047l.b(string);
                    threadViewTooltip.f8047l.t = 20000;
                    threadViewTooltip.f8047l.H = threadViewTooltip.f8046k;
                    threadViewTooltip.f8047l.a((View) a2.get());
                    threadViewTooltip.f8045j = TooltipShownType.GROUPCALL;
                    threadViewTooltip.f8039d.edit().a(VoipPrefKeys.l, a3 + 1).commit();
                }
            }
        }
        m7223k(true);
    }

    private void az() {
        boolean z = true;
        String str = null;
        TracerDetour.a("setupThreadViewFragment", -1312858895);
        try {
            this.bS = PresenceState.a;
            if (this.f7518d != null) {
                this.f7518d.a(null);
            }
            if (this.bA != null) {
                m7173a(this.bA);
                ay();
            }
            aN();
            this.bK = ThreadViewLoaderResultState.m7354a();
            this.bC.m7663a(this.bA);
            this.bC.m7665a(this.bU);
            this.bC.aB();
            if (this.bM != null) {
                this.bC.m7668a(this.bM);
                this.bM = null;
            }
            this.aH.m7277a();
            aD();
            ba();
            this.bC.m7666a(this.br);
            boolean z2 = this.bJ == Source.FLOWER_MESSAGE_PICKER;
            ThreadViewMessagesFragment threadViewMessagesFragment = this.bC;
            if (this.bJ != Source.FLOWER_MESSAGE_PICKER) {
                z = false;
            }
            if (z2) {
                str = "inbox";
            }
            threadViewMessagesFragment.m7672a(z, str);
            if (this.bA != null) {
                m7258i(false);
                aT();
                C();
            }
            TracerDetour.a(-690110265);
        } catch (Throwable th) {
            TracerDetour.a(1364164004);
        }
    }

    private void m7215g(int i) {
        Optional fromNullable = Optional.fromNullable((ImageButton) this.T.findViewById(2131558401));
        if (fromNullable.isPresent()) {
            Drawable f = ContextUtils.f(getContext(), 2130772014, 2130837524);
            f.mutate().setColorFilter(((GlyphColorizer) this.bb.get()).a(i));
            ((ImageButton) fromNullable.get()).setImageDrawable(f);
            m7198b((View) fromNullable.get());
        }
    }

    private void m7173a(ThreadKey threadKey) {
        if (this.aJ != null) {
            this.aJ.m7351a(threadKey);
        }
        if (this.bu.get() != null) {
            ((ThreadEventReminderLoader) this.bu.get()).a();
        }
    }

    public final void m7254e() {
        this.bL = true;
    }

    public final void m7241a(@Nullable ThreadViewMessagesInitParams threadViewMessagesInitParams) {
        if (this.bG) {
            this.bC.m7668a(threadViewMessagesInitParams);
        } else {
            this.bM = threadViewMessagesInitParams;
        }
    }

    public final void m7246b(boolean z) {
        this.bN = true;
        if (z) {
            aD();
        }
    }

    private void aA() {
        ThreadKey threadKey = this.bK.f7643a.f7611a.a;
        if (this.ay.a(threadKey).e) {
            PrefKey a = MessagingPrefKeys.a(threadKey);
            Editor edit = this.am.edit();
            edit.a(a, NotificationSetting.a.a());
            edit.commit();
        }
    }

    public static void aB(ThreadViewFragment threadViewFragment) {
        if (threadViewFragment.bZ != null) {
            threadViewFragment.bZ.cancel(false);
            threadViewFragment.bZ = null;
        }
        threadViewFragment.bw.m7942a();
    }

    private void m7223k(boolean z) {
        if (!z) {
            aB(this);
            this.ca = 0;
        }
        if (!av() && this.bA != null && this.aB != null) {
            this.aB.a(String.valueOf(this.bA.d), z ? 1 : 0);
            if (!z) {
                WebrtcUiHandler webrtcUiHandler = this.bm;
                if (webrtcUiHandler.k() && !webrtcUiHandler.aB && !webrtcUiHandler.bL) {
                    webrtcUiHandler.a(EndCallReason.CallEndHangupCall);
                    webrtcUiHandler.r();
                }
            }
        }
    }

    private void aC() {
        boolean d = this.aB.d(ThreadKey.a(this.bA));
        if (!(d || av())) {
            aB(this);
        }
        aS(this);
        if (this.aW.m7929a()) {
            if (this.bZ == null && d && this.bA != null && this.ca != this.bA.i()) {
                this.bZ = this.bn.schedule(new Runnable(this) {
                    final /* synthetic */ ThreadViewFragment f7498a;

                    {
                        this.f7498a = r1;
                    }

                    public void run() {
                        if (this.f7498a.bw.m7943a(this.f7498a.bA) && this.f7498a.bA != null) {
                            this.f7498a.ca = this.f7498a.bA.i();
                        }
                        this.f7498a.bZ = null;
                    }
                }, 1000, TimeUnit.MILLISECONDS);
            }
        } else if (this.be.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.cw, 0) == 1) {
            this.bw.m7944b(this.bA);
        }
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -88119393);
        this.aU.a(5505047, aZ(), "onStart");
        super.mi_();
        this.aH.f7533c = true;
        if (((Boolean) this.aq.get()).booleanValue()) {
            this.f7518d.a(true);
        }
        aI(this);
        this.aU.a(5505047, aZ(), (short) 47);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1559637058, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -427853077);
        super.mj_();
        this.aH.f7533c = false;
        this.f7518d.a(false);
        m7223k(false);
        if (this.bC != null) {
            this.bC.dC = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2062292637, a);
    }

    public final void m7227G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1366326257);
        super.G();
        this.bD = true;
        aX();
        if (this.bA == null) {
            this.aU.a(5505047, aZ());
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1543096058, a);
            return;
        }
        this.f7520f.a();
        if (this.bL) {
            this.bL = false;
            aG();
        } else {
            m7258i(false);
        }
        Result result = this.bK.f7643a;
        if (!(result == null || result.f7611a == null)) {
            this.as.a(result.f7611a.a);
        }
        UserKey a2 = ThreadKey.a(this.bA);
        if (a2 != null) {
            this.as.a(a2.b());
        }
        aT();
        m7223k(true);
        this.am.a(MessagingPrefKeys.ae, this.cb);
        this.aU.a(5505047, aZ());
        if (this.bY == null) {
            this.bY = this.bd.a().a("com.facebook.orca.users.ACTION_USERS_UPDATED", new ActionReceiver(this) {
                final /* synthetic */ ThreadViewFragment f7500a;

                {
                    this.f7500a = r1;
                }

                public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                    int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1431340946);
                    if (this.f7500a.bI != null) {
                        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("updated_users");
                        if (parcelableArrayListExtra != null && parcelableArrayListExtra.contains(this.f7500a.bI.T)) {
                            ThreadViewFragment.aS(this.f7500a);
                        }
                    }
                    Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1794821074, a);
                }
            }).a();
        }
        this.bY.b();
        LogUtils.f(-1511139387, a);
    }

    public final Animation m7231a(int i, boolean z, int i2) {
        if (i2 != 0) {
            return AnimationUtils.loadAnimation(getContext(), i2);
        }
        return super.a(i, z, i2);
    }

    public final void m7228H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 119577108);
        super.H();
        this.bD = false;
        this.f7515a.m4482a();
        aB(this);
        this.ao.f();
        this.am.b(MessagingPrefKeys.ae, this.cb);
        if (this.bA != null) {
            this.aU.d(this.bA.g());
        }
        if (this.bY != null) {
            this.bY.c();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 19876821, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 244928036);
        m7173a(null);
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1348216509, a);
    }

    public final void m7229I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -295468241);
        super.I();
        this.aH.m7281b();
        if (this.f7515a != null) {
            this.f7515a.m4482a();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1419357035, a);
    }

    public final void m7257h(boolean z) {
        this.bE = z;
        aT();
        aD();
        if (z) {
            m7223k(true);
        }
    }

    private void aD() {
        if (this.bE && this.bN) {
            this.bN = false;
            Window j = this.E.j();
            if (j != null) {
                j.setSoftInputMode(4);
            }
            aF();
        }
    }

    public final void m7236a(Menu menu, MenuInflater menuInflater) {
        super.a(menu, menuInflater);
        if (mx_()) {
            aS(this);
            ThreadViewOptionsHandler threadViewOptionsHandler = this.aL;
            menuInflater.inflate(2131820590, menu);
            threadViewOptionsHandler.m7887a(menu);
        }
    }

    public final void m7235a(Menu menu) {
        super.a(menu);
        this.aL.m7887a(menu);
    }

    public final boolean a_(MenuItem menuItem) {
        boolean z;
        int itemId = menuItem.getItemId();
        if (itemId == 16908332 && this.by) {
            aE(this);
            z = true;
        } else {
            ThreadSummary threadSummary = this.bK.f7643a.f7611a;
            if (itemId == 9) {
                if (threadSummary != null) {
                    this.f7517c.a(threadSummary);
                }
                z = true;
            } else if (itemId == 8) {
                if (threadSummary != null) {
                    m7212e(threadSummary);
                }
                z = true;
            } else if (itemId == 2131568625) {
                if (threadSummary != null) {
                    this.aK.get();
                    ThreadViewOperationsHelper.m7875a(this.bx, threadSummary.a);
                }
                z = true;
            } else {
                z = this.aL.m7890a(menuItem, am_().toString());
            }
        }
        if (!z) {
            return super.a_(menuItem);
        }
        AnalyticsActivity analyticsActivity = (AnalyticsActivity) ContextUtils.a(getContext(), AnalyticsActivity.class);
        Preconditions.checkNotNull(analyticsActivity);
        InteractionLogger interactionLogger = this.an;
        interactionLogger.c.a(analyticsActivity.am_(), "opt_menu_item", interactionLogger.e.getResourceEntryName(menuItem.getItemId()), null);
        return true;
    }

    public static void aE(ThreadViewFragment threadViewFragment) {
        threadViewFragment.m7223k(false);
        m7210d(threadViewFragment, "Click on back_to_home button");
        threadViewFragment.bO.mo313a();
    }

    private void m7205c(String str) {
        this.ax.a(ao(), "opt_menu_item", str, null);
    }

    public final boolean m7243a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            if (keyEvent.getKeyCode() == 31) {
                aF();
                return true;
            } else if (keyEvent.getKeyCode() == 82 && m7196a(this.bI) && !aR()) {
                aY(this);
                return true;
            }
        }
        return false;
    }

    public final void aq() {
        aO();
        Result result = this.bK.f7643a;
        if (result != null && result.f7611a != null) {
            ThreadKey threadKey = result.f7611a.a;
            if (this.as != null) {
                this.as.a(threadKey);
                UserKey a = ThreadKey.a(this.bA);
                if (a != null) {
                    this.as.a(a.b());
                }
                aT();
            }
        }
    }

    public final ThreadKey ar() {
        return this.bA;
    }

    private void aF() {
        if (this.bK.f7643a.f7611a != null && this.bC != null) {
            this.bC.at();
            this.bC.dh.ar();
        }
    }

    public final void m7258i(boolean z) {
        m7194a(false, z);
    }

    private void aG() {
        m7194a(true, false);
    }

    private void m7194a(boolean z, boolean z2) {
        TracerDetour.a("TVF.refreshDataInternal", 1550502119);
        try {
            Params a;
            if (((Boolean) this.aq.get()).booleanValue() && z) {
                aI(this);
            }
            if (z) {
                a = Params.m7325a(true, true, z2);
            } else {
                int az;
                if (this.bC != null) {
                    az = this.bC.az();
                } else {
                    az = -1;
                }
                if (az != -1) {
                    Integer.valueOf(az);
                    a = Params.m7324a(false, false, az, z2);
                } else if (ax()) {
                    try {
                        a = ((PendingThreadsManager) this.bh.get()).a(this.bA) ? Params.m7322a(((PendingThreadsManager) this.bh.get()).c(this.bA)) : null;
                    } catch (PendingThreadException e) {
                        this.aS.a(bp.getName(), "PendingThreadsManager doesn't have pending thread key: " + this.bA, e);
                        a = null;
                    }
                } else {
                    a = Params.m7325a(false, false, z2);
                }
            }
            if (!(this.bA == null || a == null)) {
                m7173a(this.bA);
                this.aJ.m7352a(a);
            }
            TracerDetour.a(-2002035057);
        } catch (Throwable th) {
            TracerDetour.a(-522254565);
        }
    }

    private void m7186a(LoadType loadType) {
        this.f7515a.m4482a();
        if (loadType == LoadType.THREAD_VIEW) {
            aK();
        } else {
            this.bC.as();
        }
    }

    private void m7188a(Result result) {
        if (this.bA != null) {
            if (result.f7615e) {
                m7208d(result.f7611a);
                return;
            }
            this.bK = new ThreadViewLoaderResultState(result, null);
            aX();
            if (result.m7329a()) {
                this.aH.f7532b = result.f7611a.a;
                aA();
                this.am.a(MessagingPrefKeys.a(result.f7611a.a), this.bR);
                if (this.aL != null) {
                    this.aL.m7888a(result.f7611a.a);
                }
            } else if (result.m7330b()) {
                this.aH.f7532b = this.bA;
                m7175a(MessengerThreadNameViewDataFactory.a(result.f7612b));
                if (this.bC != null) {
                    this.bC.m7664a(this.bA, result.f7612b.e);
                }
            }
            UserKey a = ThreadKey.a(this.bA);
            if (a != null) {
                this.aA.a(a);
                if (((Boolean) this.aq.get()).booleanValue() && result.f7611a != null && this.f7518d.n == null) {
                    this.f7518d.a(this.av.a(result.f7611a));
                    this.f7518d.a(true);
                }
            }
            aM();
            if (m7195a(result.f7611a)) {
                ((ThreadEventReminderLoader) this.bu.get()).a(result.f7611a);
            }
        }
    }

    private boolean m7195a(ThreadSummary threadSummary) {
        if (threadSummary == null || threadSummary.J == null || threadSummary.J.isEmpty()) {
            return false;
        }
        ImmutableList immutableList = threadSummary.J;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            if (this.f7522h.a(threadSummary.a, ((ThreadEventReminder) immutableList.get(i)).a) == null) {
                return true;
            }
        }
        return false;
    }

    public static void aH(ThreadViewFragment threadViewFragment) {
        threadViewFragment.at.a("data_fetch_failed", Boolean.valueOf(false));
        threadViewFragment.aL();
    }

    private void m7187a(LoadType loadType, Error error) {
        if (this.bA != null) {
            aL();
            this.at.a("data_fetch_failed", Boolean.valueOf(true));
            Result result = this.bK.f7643a;
            if (loadType == LoadType.THREAD_VIEW) {
                if (result.f7611a == null || result.f7613c == null) {
                    this.bC.m7677c(this.f7523i.a(error.f7602a, false, true));
                } else {
                    aM();
                }
                if (error.f7603b) {
                    m7172a(error.f7602a, true);
                }
            } else {
                if (error.f7603b) {
                    m7172a(error.f7602a, false);
                }
                this.bC.ay();
            }
            this.bK = new ThreadViewLoaderResultState(this.bK.f7643a, error);
        }
    }

    private void m7189a(PresenceState presenceState) {
        if (!this.bS.equals(presenceState)) {
            Contact contact = this.aL.f7951t;
            if (this.aw.a(presenceState.g) && ((Boolean) this.aq.get()).booleanValue() && ThreadKey.a(this.bA) != null && contact != null && GraphQLFriendshipStatus.ARE_FRIENDS.equals(contact.x())) {
                this.aR.a(ThreadKey.a(this.bA), true, null, null);
            } else if (presenceState.c && !m7201b(this.bS) && m7201b(presenceState)) {
                aI(this);
            }
            aS(this);
            this.bS = presenceState;
        }
    }

    public static void aI(ThreadViewFragment threadViewFragment) {
        if (threadViewFragment.bA != null) {
            threadViewFragment.aJ();
            threadViewFragment.aR.a(ThreadKey.a(threadViewFragment.bA), threadViewFragment.bq);
        }
    }

    private void aJ() {
        if (this.bq == null) {
            this.bq = new RtcPresenceListenerDefault(this) {
                final /* synthetic */ ThreadViewFragment f7501a;

                {
                    this.f7501a = r1;
                }

                public final void m7138a() {
                    ThreadViewFragment.aS(this.f7501a);
                    this.f7501a.C();
                    if (this.f7501a.bC != null) {
                        this.f7501a.bC.aD();
                    }
                }
            };
        }
    }

    private void aK() {
        Object obj;
        ThreadViewLoader threadViewLoader = this.aJ;
        if (threadViewLoader.f7637t.f7604a || threadViewLoader.f7619b.b(threadViewLoader.f7633p)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            this.aM.m7939a(true);
        }
    }

    private void aL() {
        this.aM.m7939a(false);
    }

    private void m7172a(ServiceException serviceException, boolean z) {
        if (!((Boolean) this.ap.get()).booleanValue() || this.f7521g.b()) {
            View view;
            this.f7515a.f4940l = 5000;
            this.f7515a.f4938j = true;
            if (z) {
                view = this.bC.dh.T;
                this.f7515a.f4939k = 48;
            } else {
                view = e(2131567843);
                this.f7515a.f4939k = 80;
            }
            this.f7515a.m4483a(view, this.f7523i.a(serviceException, false, true));
        }
    }

    private void aM() {
        Result result = this.bK.f7643a;
        ThreadSummary threadSummary = result.f7611a;
        m7203c(threadSummary);
        if (threadSummary != null) {
            m7208d(threadSummary);
        }
        m7199b(threadSummary);
        aS(this);
        if (this.bC != null) {
            this.bC.m7667a(result, this.bJ);
        }
        if (this.aL.f7949r == null) {
            if (threadSummary != null) {
                this.aL.m7888a(threadSummary.a);
            } else {
                this.aL.m7888a(this.bA);
            }
        }
        ThreadViewOptionsHandler threadViewOptionsHandler = this.aL;
        if (threadViewOptionsHandler.f7951t == null) {
            Object obj;
            UserKey a = ThreadKey.a(threadViewOptionsHandler.f7949r);
            if (a == null) {
                obj = null;
            } else {
                User a2 = threadViewOptionsHandler.f7946o.a(a);
                if (a2 != null) {
                    obj = !a2.T() ? 1 : null;
                } else {
                    obj = 1;
                }
            }
            if (obj != null) {
                threadViewOptionsHandler.f7945n.a("ThreadViewOptionsHandler.setupContactLoader", new C12044(threadViewOptionsHandler), Priority.APPLICATION_LOADED_UI_IDLE, ThreadType.UI);
            }
        }
    }

    private void m7199b(ThreadSummary threadSummary) {
        this.bC.m7684g(this.aI.m4341a(threadSummary));
    }

    private void aN() {
        m7174a(this.aF.m4379a(this.bX, this.bA));
    }

    private void m7203c(@Nullable ThreadSummary threadSummary) {
        m7174a(this.aF.m4380a(this.bX, threadSummary));
    }

    private void m7174a(ThreadTitleBarTheme threadTitleBarTheme) {
        if (this.bW == null || !this.bW.equals(threadTitleBarTheme)) {
            this.bW = threadTitleBarTheme;
            m7171a(this.bW.f4818a);
            m7215g(this.bW.f4819b);
            ThreadViewTitleBarButtonSpecHelper threadViewTitleBarButtonSpecHelper = this.aW;
            int i = this.bW.f4822e;
            int i2 = this.bW.f4823f;
            int i3 = this.bW.f4824g;
            if (threadViewTitleBarButtonSpecHelper.f7998R != i2) {
                threadViewTitleBarButtonSpecHelper.f8027z = null;
                threadViewTitleBarButtonSpecHelper.f7984D = null;
                threadViewTitleBarButtonSpecHelper.f7985E = null;
                threadViewTitleBarButtonSpecHelper.f7981A = null;
                threadViewTitleBarButtonSpecHelper.f7982B = null;
                threadViewTitleBarButtonSpecHelper.f7983C = null;
                threadViewTitleBarButtonSpecHelper.f7987G = null;
                threadViewTitleBarButtonSpecHelper.f7988H = null;
                threadViewTitleBarButtonSpecHelper.f7989I = null;
                threadViewTitleBarButtonSpecHelper.f7990J = null;
                threadViewTitleBarButtonSpecHelper.f7991K = null;
                threadViewTitleBarButtonSpecHelper.f7992L = null;
                threadViewTitleBarButtonSpecHelper.f7993M = null;
                threadViewTitleBarButtonSpecHelper.f7994N = null;
                threadViewTitleBarButtonSpecHelper.f7996P = null;
                threadViewTitleBarButtonSpecHelper.f7997Q = null;
                threadViewTitleBarButtonSpecHelper.f7998R = i2;
            }
            RtcCallButtonIconProvider rtcCallButtonIconProvider = threadViewTitleBarButtonSpecHelper.f8014m;
            if (rtcCallButtonIconProvider.g != i) {
                rtcCallButtonIconProvider.g = i;
                rtcCallButtonIconProvider.o = null;
                rtcCallButtonIconProvider.q = null;
            }
            rtcCallButtonIconProvider = threadViewTitleBarButtonSpecHelper.f8014m;
            if (rtcCallButtonIconProvider.f != i3) {
                rtcCallButtonIconProvider.f = i3;
                rtcCallButtonIconProvider.j = null;
                rtcCallButtonIconProvider.p = null;
                rtcCallButtonIconProvider.r = null;
                rtcCallButtonIconProvider.s = null;
                rtcCallButtonIconProvider.t = null;
                rtcCallButtonIconProvider.l = null;
                rtcCallButtonIconProvider.w = null;
                rtcCallButtonIconProvider.x = null;
                rtcCallButtonIconProvider.m = null;
                rtcCallButtonIconProvider.n = null;
            }
            this.aM.m7935a(this.bW.f4820c);
            if (this.bO != null) {
                this.bO.mo314a(this.bW.f4821d);
            }
            if (this.bQ != null) {
                this.bQ.m7081a(this.bW);
            }
        }
    }

    private void m7171a(Drawable drawable) {
        Optional f = f(2131567845);
        if (f.isPresent()) {
            CustomViewUtils.b((View) f.get(), drawable);
        }
    }

    private void m7198b(View view) {
        Object obj;
        MaterialDesignExperimentHelper materialDesignExperimentHelper = this.ar;
        if (!materialDesignExperimentHelper.a() || materialDesignExperimentHelper.b()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            CustomViewUtils.b(view, ContextUtils.f(this.bX, 2130772019, 2130842164));
        }
    }

    private void m7208d(ThreadSummary threadSummary) {
        this.aM.m7936a(threadSummary);
    }

    private void m7175a(MessengerThreadNameViewData messengerThreadNameViewData) {
        this.aM.m7937a(messengerThreadNameViewData);
    }

    public final boolean m7244a(@Nullable String str) {
        if (this.bx == null || !this.bx.c()) {
            return true;
        }
        m7223k(false);
        if (this.al.j == Product.MESSENGER) {
            this.ao.a(o());
        }
        if (this.bC != null && this.bC.m7675b()) {
            return true;
        }
        if (this.bx.c()) {
            if (!this.bx.e()) {
                return false;
            }
            m7192a("thread", "thread", str);
            aM();
            return true;
        } else if (this.bx.f() <= 0) {
            return false;
        } else {
            return true;
        }
    }

    private void aO() {
        this.bd.a("com.facebook.rtc.fbwebrtc.RTC_VIDEO_CHAT_HEAD_SHRINK_BY_USER_INTERACTION");
    }

    private void aP() {
        if (this.bx.c()) {
            while (this.bx.f() > 0) {
                this.bx.e();
            }
            C();
            if (this.bO != null) {
                this.bO.mo313a();
            }
        }
    }

    private void aQ() {
        DrawerBasedDivebarControllerImpl drawerBasedDivebarControllerImpl = null;
        if (getContext() instanceof DivebarEnabledActivity) {
            drawerBasedDivebarControllerImpl = ((DivebarEnabledActivity) getContext()).f();
        }
        if (drawerBasedDivebarControllerImpl != null) {
            drawerBasedDivebarControllerImpl.i();
        }
    }

    private void m7192a(String str, String str2, @Nullable String str3) {
        if (str3 != null) {
            this.ax.a(str3);
        }
        this.at.a(str, str2, ao(), null);
    }

    private boolean aR() {
        Result result = this.bK.f7643a;
        return (result == null || result.f7611a == null || !result.f7611a.A.isMessageRequestFolders()) ? false : true;
    }

    public static void aS(ThreadViewFragment threadViewFragment) {
        if (threadViewFragment.bz != null && threadViewFragment.mx_()) {
            List a;
            if (threadViewFragment.al.j == Product.PAA) {
                a = threadViewFragment.aW.m7927a(threadViewFragment.bA, threadViewFragment.bK.f7643a);
            } else if (threadViewFragment.aR() || threadViewFragment.ax()) {
                a = threadViewFragment.bs;
            } else {
                boolean a2 = threadViewFragment.au.a(ThreadKey.a(threadViewFragment.bA));
                threadViewFragment.bI = threadViewFragment.bg.m7950a(threadViewFragment.bK.f7643a, threadViewFragment.bA);
                a = threadViewFragment.aW.m7928a(threadViewFragment.bA, threadViewFragment.bK.f7643a, a2, threadViewFragment.bC.aw(), threadViewFragment.bI);
            }
            if (!a.equals(threadViewFragment.bB)) {
                threadViewFragment.bB = a;
                threadViewFragment.bz.setButtonSpecs(threadViewFragment.bB);
            }
            threadViewFragment.bz.setHasBackButton(threadViewFragment.bF);
        }
    }

    private void aT() {
        if (this.bE && this.bD && this.bK.f7643a != Result.f7610h) {
            this.bC.aA();
        }
    }

    public final List<CustomFbHostMenuItem> m7252d() {
        List<CustomFbHostMenuItem> arrayList = new ArrayList();
        if (this.bA == null) {
            return arrayList;
        }
        arrayList.add(new CustomFbHostMenuItem(9, 2131231355, 2130842047, true, null));
        Result result = this.bK.f7643a;
        if (!(result == null || result.f7611a == null)) {
            arrayList.add(new CustomFbHostMenuItem(8, 2131231356, 2130842051, true, null));
        }
        arrayList.add(new CustomFbHostMenuItem(2131568625, 2131231358, 2130842049, true, null));
        return arrayList;
    }

    public final void B_(int i) {
        ThreadSummary threadSummary = this.bK.f7643a.f7611a;
        if (i == 9) {
            if (threadSummary != null) {
                m7205c("archive");
                this.f7517c.a(threadSummary);
            }
        } else if (i == 8) {
            if (threadSummary != null) {
                m7205c("mark_as_spam");
                m7212e(threadSummary);
            }
        } else if (i == 2131568625 && threadSummary != null) {
            m7205c("delete");
            this.aK.get();
            ThreadViewOperationsHelper.m7875a(this.bx, threadSummary.a);
        }
    }

    public final void m7251c(boolean z) {
        super.c(z);
        if (this.bC != null && this.bC.y) {
            this.bC.m7671a(z);
            if (z) {
                this.bC.au();
                this.bC.m7681e();
                this.bC.aq();
            }
            this.bC.g(!z);
        }
    }

    public final void m7233a(int i, int i2, Intent intent) {
        if (i == 101) {
            switch (i2) {
                case 101:
                    aU();
                    break;
                case 102:
                    aV();
                    break;
                case 103:
                    Bitmap d = m7207d(intent);
                    List arrayList = new ArrayList();
                    if (d != null) {
                        arrayList.add(d);
                    }
                    m7193a(arrayList);
                    break;
                case 104:
                    aW(this);
                    break;
                default:
                    m7258i(true);
                    break;
            }
        }
        super.a(i, i2, intent);
    }

    private void aU() {
        this.bC.m7680d("thread_settings");
    }

    private void aV() {
        this.bC.m7683e("thread_settings");
    }

    private void m7193a(List<Bitmap> list) {
        BugReporter bugReporter = (BugReporter) this.aT.get();
        BugReportFlowStartParamsBuilder a = BugReportFlowStartParams.newBuilder().a(getContext());
        a.e = (List) Preconditions.checkNotNull(list);
        bugReporter.a(a.a(BugReportSource.MESSENGER_THREAD_SETTINGS).a());
    }

    @Nullable
    private Bitmap m7207d(Intent intent) {
        String stringExtra = intent.getStringExtra("bug_screenshot_extra");
        if (Strings.isNullOrEmpty(stringExtra)) {
            return null;
        }
        this.aT.get();
        return BugReporter.a(getContext(), stringExtra);
    }

    private void m7212e(final ThreadSummary threadSummary) {
        new FbAlertDialogBuilder(getContext()).a(2131231357).a(false).a(2131230735, new OnClickListener(this) {
            final /* synthetic */ ThreadViewFragment f7504b;

            public void onClick(DialogInterface dialogInterface, int i) {
                ThreadViewFragment.m7214f(this.f7504b, threadSummary);
            }
        }).b(2131230736, new OnClickListener(this) {
            final /* synthetic */ ThreadViewFragment f7502a;

            {
                this.f7502a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).b();
    }

    public static void m7214f(ThreadViewFragment threadViewFragment, ThreadSummary threadSummary) {
        threadViewFragment.m7205c("mark_as_spam");
        threadViewFragment.aE.a(threadSummary);
    }

    public static void aW(ThreadViewFragment threadViewFragment) {
        Context context = threadViewFragment.getContext();
        if (!(context instanceof Activity)) {
            return;
        }
        if (threadViewFragment.bO != null) {
            threadViewFragment.aP();
        } else {
            ((Activity) context).finish();
        }
    }

    public final void m7239a(NavigationTrigger navigationTrigger) {
        this.bU = navigationTrigger;
    }

    public final CustomKeyboardLayout m7249c() {
        return (CustomKeyboardLayout) e(2131560874);
    }

    public final void m7256g(boolean z) {
        super.g(z);
        aX();
    }

    public Map<String, String> getDebugInfo() {
        ThreadViewDebugHelper threadViewDebugHelper = (ThreadViewDebugHelper) this.aG.get();
        ThreadKey threadKey = this.bA;
        ThreadViewLoaderResultState threadViewLoaderResultState = this.bK;
        boolean z = true;
        Builder builder = new Builder();
        Result result = threadViewLoaderResultState.f7643a;
        if (threadKey != null) {
            builder.b("thread.threadKey", threadKey.toString());
        }
        if (result != null) {
            builder.b("thread.isForUser", Boolean.toString(result.m7330b()));
            if (result.m7329a()) {
                builder.b("thread.canReplyTo", Boolean.toString(result.f7611a.u));
                builder.b("thread.cannotReplyReason", result.f7611a.v.toString());
                builder.b("thread.isSubscribed", Boolean.toString(result.f7611a.w));
                builder.b("thread.hasFailedMessageSend", Boolean.toString(result.f7611a.x));
                NotificationState c = threadViewDebugHelper.f7497a.a(result.f7611a.a).c();
                builder.b("thread.notif_muted", Boolean.toString(c == NotificationState.TemporarilyMuted));
                String str = "thread.notif_disabled";
                if (c != NotificationState.PermanentlyDisabled) {
                    z = false;
                }
                builder.b(str, Boolean.toString(z));
                if (result.f7611a.h != null) {
                    builder.b("thread.numParticipants", Long.toString((long) result.f7611a.h.size()));
                }
                if (result.f7611a.i != null) {
                    builder.b("thread.numFormerParticipants", Long.toString((long) result.f7611a.i.size()));
                }
                if (result.f7611a.j != null) {
                    builder.b("thread.numBotParticipants", Long.toString((long) result.f7611a.j.size()));
                }
            }
            if (!(result.f7613c == null || result.f7613c.f())) {
                builder.b("thread.latest_message_id", result.f7613c.b(0).a);
            }
        }
        if (threadViewLoaderResultState.f7644b != null) {
            ServiceException serviceException = threadViewLoaderResultState.f7644b.f7602a;
            builder.b("threadViewLoader.serviceException.errorCode", serviceException.errorCode.name());
            builder.b("threadViewLoader.serviceException.throwableMessage", serviceException.getMessage());
            builder.b("threadViewLoader.serviceException.stackTrace", ExceptionUtil.a(serviceException));
        }
        return builder.b();
    }

    private void aX() {
        if (D() && z()) {
            this.at.a("thread");
            Result result = this.bK.f7643a;
            if (result != null) {
                this.at.a("data_fetch_disposition", result.f7616f);
                this.at.a("thread_fetch_handler_changes", result.f7617g);
            }
        }
    }

    public static void aY(ThreadViewFragment threadViewFragment) {
        m7218h(threadViewFragment, 0);
    }

    public static void m7218h(ThreadViewFragment threadViewFragment, int i) {
        User user = threadViewFragment.bI;
        if (threadViewFragment.m7202b(user)) {
            ThreadSummary threadSummary = threadViewFragment.bK.f7643a.f7611a;
            if (threadViewFragment.bP == null) {
                Intent putExtra = new Intent().setAction(MessagingIntentUris.a).setData(Uri.parse(MessengerLinks.B)).putExtra("thread_summary_for_settings", threadSummary).putExtra("start_fragment", i);
                if (threadSummary != null && threadSummary.a.a == Type.GROUP) {
                    putExtra.putExtra("thread_settings_type_for_settings", ThreadSettingsType.GROUP);
                } else if (threadSummary == null || !ThreadKey.g(threadSummary.a)) {
                    putExtra.putExtra("user_for_settings", user).putExtra("thread_settings_type_for_settings", ThreadSettingsType.CANONICAL);
                } else {
                    putExtra.putExtra("user_for_settings", user).putExtra("thread_settings_type_for_settings", ThreadSettingsType.TINCAN);
                }
                threadViewFragment.aC.a(putExtra, 101, threadViewFragment);
                return;
            }
            threadViewFragment.bC.dh.aA();
        }
    }

    private boolean m7202b(@Nullable User user) {
        if (this.bA == null) {
            this.aS.a("ThreadViewFragment_ThreadSettings_NoUser", "Trying to open thread settings with no thread key");
            return false;
        }
        ThreadSummary threadSummary = this.bK.f7643a.f7611a;
        if (threadSummary == null || threadSummary.a.a != Type.GROUP) {
            if (user == null) {
                this.aS.a("ThreadViewFragment_ThreadSettings_NoUser", "Trying to open thread settings with a null stored user");
                return false;
            }
            UserKey userKey = user.T;
            UserKey b = UserKey.b(String.valueOf(this.bA.d));
            if (!userKey.equals(b)) {
                this.aS.a("ThreadViewFragment_ThreadSettings_NoUser", m7169a(userKey, b, this.bA));
                return false;
            }
        }
        return true;
    }

    private static String m7169a(UserKey userKey, @Nullable UserKey userKey2, ThreadKey threadKey) {
        return "Stored user does not match other user in thread." + " Thread key is " + threadKey + ". Stored user is " + userKey + ". Other user is " + userKey2;
    }

    private int aZ() {
        if (this.bV == -1 && this.aV != null) {
            this.bV = this.aV.nextInt(Integer.MAX_VALUE);
        }
        return this.bV;
    }

    public static void m7210d(ThreadViewFragment threadViewFragment, String str) {
        threadViewFragment.aX.a(str, BugReportCategory.COMPOSE_MESSAGE_FLOW);
    }

    private void ba() {
        if (this.br == null) {
            this.br = new Object(this) {
                final /* synthetic */ ThreadViewFragment f7505a;

                {
                    this.f7505a = r1;
                }

                public final void m7139a() {
                    ThreadViewFragment.aS(this.f7505a);
                    this.f7505a.C();
                }
            };
        }
    }

    private void m7176a(AnchorableToast anchorableToast, AppChoreographer appChoreographer, ArchiveThreadManager archiveThreadManager, CanonicalThreadPresenceHelper canonicalThreadPresenceHelper, ChatHeadsBroadcaster chatHeadsBroadcaster, ChatHeadsOpenHelper chatHeadsOpenHelper, ConnectionStatusMonitor connectionStatusMonitor, DataCache dataCache, ErrorMessageGenerator errorMessageGenerator, FbAppType fbAppType, FbSharedPreferences fbSharedPreferences, InteractionLogger interactionLogger, InternalStarRatingController internalStarRatingController, Provider<Boolean> provider, Provider<Boolean> provider2, MaterialDesignExperimentHelper materialDesignExperimentHelper, MessagesNotificationClient messagesNotificationClient, MessagingAnalyticsLogger messagingAnalyticsLogger, MessengerInviteEligibilityChecker messengerInviteEligibilityChecker, MessengerThreadNameViewDataFactory messengerThreadNameViewDataFactory, MqttVoipCapability mqttVoipCapability, NavigationLogger navigationLogger, NotificationSettingsUtil notificationSettingsUtil, PhotoMessageDataCache photoMessageDataCache, PresenceManager presenceManager, ThreadPresenceManager threadPresenceManager, SecureContextHelper secureContextHelper, SendDialogUtils sendDialogUtils, SpamThreadManager spamThreadManager, ThreadTitleBarThemeFactory threadTitleBarThemeFactory, Lazy<ThreadViewDebugHelper> lazy, ThreadViewFragmentActionHandler threadViewFragmentActionHandler, ThreadViewFragmentTheming threadViewFragmentTheming, ThreadViewLoader threadViewLoader, Lazy<ThreadViewOperationsHelper> lazy2, ThreadViewOptionsHandler threadViewOptionsHandler, ThreadViewTitleHelper threadViewTitleHelper, ThreadViewTooltipProvider threadViewTooltipProvider, Lazy<ViewerContext> lazy3, RtcCallHandler rtcCallHandler, Lazy<WebrtcGroupDialogBuilder> lazy4, RtcPresenceHandler rtcPresenceHandler, FbErrorReporter fbErrorReporter, Provider<BugReporter> provider3, MessagingPerformanceLogger messagingPerformanceLogger, Random random, ThreadViewTitleBarButtonSpecHelper threadViewTitleBarButtonSpecHelper, BugReportOperationLogger bugReportOperationLogger, MessengerCommerceAnalyticsLogger messengerCommerceAnalyticsLogger, Lazy<EphemeralToggleButtonHelper> lazy5, Lazy<OutgoingPhoneCallManager> lazy6, Lazy<GlyphColorizer> lazy7, Lazy<SmsThreadViewButtonsHelper> lazy8, FbBroadcastManager fbBroadcastManager, QeAccessor qeAccessor, Lazy<RtcMergedAudioVideoDialogHelper> lazy9, ThreadViewUserDataUtil threadViewUserDataUtil, Lazy<PendingThreadsManager> lazy10, RTCMultiwaySelectDialogBuilder rTCMultiwaySelectDialogBuilder, Provider<Boolean> provider4, SmsContactUtil smsContactUtil, UserCache userCache, WebrtcUiHandler webrtcUiHandler, ScheduledExecutorService scheduledExecutorService, MessengerExtensionsManager messengerExtensionsManager, Lazy<GroupShareSheetCreator> lazy11, Lazy<ThreadEventReminderLoader> lazy12, Lazy<GroupJoinableLinksLogger> lazy13) {
        this.f7515a = anchorableToast;
        this.f7516b = appChoreographer;
        this.f7517c = archiveThreadManager;
        this.f7518d = canonicalThreadPresenceHelper;
        this.f7519e = chatHeadsBroadcaster;
        this.f7520f = chatHeadsOpenHelper;
        this.f7521g = connectionStatusMonitor;
        this.f7522h = dataCache;
        this.f7523i = errorMessageGenerator;
        this.al = fbAppType;
        this.am = fbSharedPreferences;
        this.an = interactionLogger;
        this.ao = internalStarRatingController;
        this.ap = provider;
        this.aq = provider2;
        this.ar = materialDesignExperimentHelper;
        this.as = messagesNotificationClient;
        this.at = messagingAnalyticsLogger;
        this.au = messengerInviteEligibilityChecker;
        this.av = messengerThreadNameViewDataFactory;
        this.aw = mqttVoipCapability;
        this.ax = navigationLogger;
        this.ay = notificationSettingsUtil;
        this.az = photoMessageDataCache;
        this.aA = presenceManager;
        this.aB = threadPresenceManager;
        this.aC = secureContextHelper;
        this.aD = sendDialogUtils;
        this.aE = spamThreadManager;
        this.aF = threadTitleBarThemeFactory;
        this.aG = lazy;
        this.aH = threadViewFragmentActionHandler;
        this.aI = threadViewFragmentTheming;
        this.aJ = threadViewLoader;
        this.aK = lazy2;
        this.aL = threadViewOptionsHandler;
        this.aM = threadViewTitleHelper;
        this.aN = threadViewTooltipProvider;
        this.aO = lazy3;
        this.aP = rtcCallHandler;
        this.aQ = lazy4;
        this.aR = rtcPresenceHandler;
        this.aS = fbErrorReporter;
        this.aT = provider3;
        this.aU = messagingPerformanceLogger;
        this.aV = random;
        this.aW = threadViewTitleBarButtonSpecHelper;
        this.aX = bugReportOperationLogger;
        this.aY = messengerCommerceAnalyticsLogger;
        this.aZ = lazy5;
        this.ba = lazy6;
        this.bb = lazy7;
        this.bc = lazy8;
        this.bd = fbBroadcastManager;
        this.be = qeAccessor;
        this.bf = lazy9;
        this.bg = threadViewUserDataUtil;
        this.bh = lazy10;
        this.bi = rTCMultiwaySelectDialogBuilder;
        this.bj = provider4;
        this.bk = smsContactUtil;
        this.bl = userCache;
        this.bm = webrtcUiHandler;
        this.bn = scheduledExecutorService;
        this.bo = messengerExtensionsManager;
        this.bt = lazy11;
        this.bu = lazy12;
        this.bv = lazy13;
    }

    public final void m7245b(String str) {
        this.bo.m1596a(getContext(), str, this.bA);
    }
}
