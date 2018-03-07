package com.facebook.orca.threadlist;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.internal.widget.ViewStubCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.InteractionLogger;
import com.facebook.analytics.InteractionLogger.ContentFlags;
import com.facebook.analytics.MessengerEntryLogger;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.impression.ImpressionManager;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.auth.module.ViewerContextMethodAutoProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.base.fragment.FbFragment;
import com.facebook.bugreporter.BugReportCategory;
import com.facebook.bugreporter.BugReportOperationLogger;
import com.facebook.common.android.AudioManagerMethodAutoProvider;
import com.facebook.common.android.FbLocalBroadcastManager;
import com.facebook.common.android.FbLocalBroadcastManagerMethodAutoProvider;
import com.facebook.common.appchoreographer.AppChoreographer;
import com.facebook.common.appchoreographer.AppChoreographer.Priority;
import com.facebook.common.appchoreographer.AppChoreographer.ThreadType;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.common.loader.AbstractFbLoaderCallback;
import com.facebook.common.loader.FbLoader.Callback;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.random.InsecureRandom;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.ui.util.ViewReplacementUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.contacts.picker.ContactPickerUserRow;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.tracer.Tracer;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.results.DataFetchDisposition;
import com.facebook.fbservice.results.DataFetchDisposition.DataSource;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLMessengerInboxUnitType;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.interstitial.manager.InterstitialTriggerContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messages.ipc.MessagingIntentUris;
import com.facebook.messages.links.MessengerLinks;
import com.facebook.messaging.analytics.navigation.MessagingAnalyticsLogger;
import com.facebook.messaging.analytics.perf.MessagingPerformanceLogger;
import com.facebook.messaging.annotations.IsMessengerSyncEnabled;
import com.facebook.messaging.annotations.IsThreadListChatHeadAttentionBadgingEnabled;
import com.facebook.messaging.badges.ExperimentsForBadgesModule;
import com.facebook.messaging.bannertriggers.BannerTriggersOmnistoreComponent;
import com.facebook.messaging.bannertriggers.BannerTriggersOmnistoreComponent.Listener;
import com.facebook.messaging.blocking.BlockingAnalyticsLogger;
import com.facebook.messaging.blocking.ManageBlockingFragment;
import com.facebook.messaging.business.common.analytics.BusinessMessageImpressionListener;
import com.facebook.messaging.business.promotion.gating.BusinessPromotionGatekeepers;
import com.facebook.messaging.cache.ArchiveThreadManager;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.cache.MessagesBroadcaster.ThreadUpdateCause;
import com.facebook.messaging.cache.ReadThreadManager;
import com.facebook.messaging.cache.ThreadUnreadCountUtil;
import com.facebook.messaging.chatheads.annotations.IsChatHeadsEnabled;
import com.facebook.messaging.chatheads.intents.ChatHeadsIntentDispatcher;
import com.facebook.messaging.chatheads.intents.ChatHeadsOpenHelper;
import com.facebook.messaging.connectivity.ConnectionStatusMonitor;
import com.facebook.messaging.connectivity.ConnectionStatusMonitorMethodAutoProvider;
import com.facebook.messaging.connectivity.annotations.IsConnStatusBannerEnabled;
import com.facebook.messaging.conversationstarters.ConversationStartersHeaderHandler;
import com.facebook.messaging.dialog.MenuDialogFragment;
import com.facebook.messaging.dialog.MenuDialogItem;
import com.facebook.messaging.dialog.MenuDialogItemBuilder;
import com.facebook.messaging.dialog.MenuDialogParamsBuilder;
import com.facebook.messaging.groups.admin.GroupsAdminLogger;
import com.facebook.messaging.groups.threadactions.GroupThreadActionHandler;
import com.facebook.messaging.inbox2.activenow.InboxActiveNowController;
import com.facebook.messaging.inbox2.activenow.InboxActiveNowControllerProvider;
import com.facebook.messaging.inbox2.analytics.InboxViewImpressionTracker;
import com.facebook.messaging.inbox2.analytics.InboxViewImpressionTrackerProvider;
import com.facebook.messaging.inbox2.analytics.InboxViewLogger;
import com.facebook.messaging.inbox2.cameraroll.CameraRollInboxItem;
import com.facebook.messaging.inbox2.data.common.InboxUnit;
import com.facebook.messaging.inbox2.data.common.InboxUnitSnapshot;
import com.facebook.messaging.inbox2.data.common.InboxUnitsToFetch;
import com.facebook.messaging.inbox2.data.loader.InboxUnitLoader;
import com.facebook.messaging.inbox2.data.loader.InboxUnitLoader.LoadBehavior;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel.MessengerInboxUnitTitleModel;
import com.facebook.messaging.inbox2.items.InboxAdapter;
import com.facebook.messaging.inbox2.items.InboxItem;
import com.facebook.messaging.inbox2.items.InboxUnitItem;
import com.facebook.messaging.inbox2.items.InboxUnitViewWithRecyclerView;
import com.facebook.messaging.inbox2.morefooter.InboxGenericMoreItem;
import com.facebook.messaging.inbox2.morefooter.InboxMoreThreadsItem;
import com.facebook.messaging.inbox2.morefooter.InboxMoreThreadsItem.MoreThreadsType;
import com.facebook.messaging.inbox2.recents.InboxRecentItem;
import com.facebook.messaging.intents.MessagesBroadcastIntents;
import com.facebook.messaging.media.editing.MultimediaEditorControllerProvider;
import com.facebook.messaging.messagerequests.loaders.MessageRequestsHeaderLoader;
import com.facebook.messaging.messagerequests.snippet.MessageRequestsSnippet;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.folders.ThreadTypeFilter;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.share.ShareBuilder;
import com.facebook.messaging.model.threadkey.DefaultThreadKeyFactory;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.model.threadkey.ThreadKeyFactory;
import com.facebook.messaging.model.threads.NotificationSetting;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.model.threads.ThreadsCollection;
import com.facebook.messaging.montage.MontageTestHelper;
import com.facebook.messaging.montage.composer.MontageCanvasViewUtilProvider;
import com.facebook.messaging.montage.composer.MontageComposerController;
import com.facebook.messaging.montage.composer.MontageComposerControllerProvider;
import com.facebook.messaging.montage.composer.MontageComposerFragmentFactory;
import com.facebook.messaging.montage.composer.MontageComposerNavigationControllerProvider;
import com.facebook.messaging.montage.composer.MontageMessageFactory;
import com.facebook.messaging.montage.composer.MontageSendUtilProvider;
import com.facebook.messaging.montage.inboxcomposer.MontageInboxComposerData;
import com.facebook.messaging.montage.inboxcomposer.MontageInboxComposerLoader;
import com.facebook.messaging.mutators.DeleteThreadDialogFragment;
import com.facebook.messaging.mutators.DeleteThreadDialogParams.Builder;
import com.facebook.messaging.mutators.MarkThreadAsSpamDialogFragment;
import com.facebook.messaging.mutators.ThreadNotificationsDialogFragment;
import com.facebook.messaging.nativesurvey.MessengerSurveyInterstitialController;
import com.facebook.messaging.nativesurvey.SurveyPromotionBannerView;
import com.facebook.messaging.neue.nullstate.MessagingNullStatesLogger;
import com.facebook.messaging.neue.nullstate.RecentsTabEmptyView;
import com.facebook.messaging.neue.nullstate.RecentsTabEmptyViewListener;
import com.facebook.messaging.notify.MessagesNotificationClient;
import com.facebook.messaging.nux.IsNeueNuxPending;
import com.facebook.messaging.peopleyoumaymessage.PeopleYouMayMessageLogger;
import com.facebook.messaging.photoreminders.PhotoRemindersGatekeepers;
import com.facebook.messaging.photoreminders.PhotoRemindersLogger;
import com.facebook.messaging.photoreminders.inboxheader.PhotoRemindersHeaderActionType;
import com.facebook.messaging.photoreminders.inboxheader.PhotoRemindersInboxData;
import com.facebook.messaging.photoreminders.inboxheader.PhotoRemindersInboxDataLoader;
import com.facebook.messaging.photoreminders.interfaces.PhotoSuggestionManager;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.messaging.quickpromotion.QuickPromotionBannerView;
import com.facebook.messaging.quickpromotion.QuickPromotionThreadListBannerController;
import com.facebook.messaging.quickpromotion.QuickPromotionTriggers;
import com.facebook.messaging.send.client.OfflineThreadingIdGenerator;
import com.facebook.messaging.send.client.OutgoingMessageFactory;
import com.facebook.messaging.send.client.SendMessageManager;
import com.facebook.messaging.send.common.SendResult;
import com.facebook.messaging.send.trigger.NavigationTrigger;
import com.facebook.messaging.shortcuts.MessengerShortcutHelper;
import com.facebook.messaging.sms.NeueSmsPreferenceActivity;
import com.facebook.messaging.sms.SmsTakeoverNuxController;
import com.facebook.messaging.sms.SmsTakeoverNuxController.NuxCallerContext;
import com.facebook.messaging.sms.analytics.SmsCallerContext;
import com.facebook.messaging.sms.analytics.SmsTakeoverAnalyticsLogger;
import com.facebook.messaging.sms.defaultapp.SmsDefaultAppManager;
import com.facebook.messaging.sms.defaultapp.SmsPermissionsUtil;
import com.facebook.messaging.sms.defaultapp.action.MmsSmsCacheUpdateAction;
import com.facebook.messaging.sms.prefs.SmsPrefKeys;
import com.facebook.messaging.sounds.MessengerSoundUtil;
import com.facebook.messaging.threadlist.InboxUnitCardDecoration;
import com.facebook.messaging.viewport.MessageEventMonitor;
import com.facebook.messaging.viewport.MessageEventMonitorProvider;
import com.facebook.messaging.widget.anchorabletoast.AnchorableToast;
import com.facebook.orca.background.FetchThreadsIntoMemoryCacheBackgroundTask;
import com.facebook.orca.notify.NotificationSettingsUtil;
import com.facebook.orca.threadlist.InboxItemCreator.RowListBuilder;
import com.facebook.orca.threadlist.ThreadListAdapter.LoadMoreState;
import com.facebook.orca.threadlist.ThreadListFragmentUpdateOrchestrator.Urgency;
import com.facebook.orca.threadlist.ThreadListLoader.Error;
import com.facebook.orca.threadlist.ThreadListLoader.LoadType;
import com.facebook.orca.threadlist.ThreadListLoader.Params;
import com.facebook.orca.threadlist.ThreadListLoader.Result;
import com.facebook.orca.threadlist.abtest.ExperimentsForThreadListExperimentsModule;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.push.mqtt.external.PushStateEvent;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.ui.QuickPromotionFragment.QuickPromotionFragmentHost;
import com.facebook.quickpromotion.ui.QuickPromotionFragmentFactory;
import com.facebook.rtc.helpers.RtcCallHandler;
import com.facebook.rtcpresence.annotations.IsVoipEnabledForUser;
import com.facebook.springs.SpringSystem;
import com.facebook.ssl.ui.SSLDialogHelper;
import com.facebook.structuredsurvey.StructuredSurveyConstants.ImpressionType;
import com.facebook.structuredsurvey.StructuredSurveyController;
import com.facebook.sync.connection.SyncConnectionHandler.ConnectionFreshness;
import com.facebook.sync.service.SyncOperationParamsUtil;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.errordialog.ErrorMessageGenerator;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.toaster.ClickableToastBuilder;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.listview.EmptyListViewItem;
import com.facebook.widget.listview.ListViewScrollHelper;
import com.facebook.widget.listview.ScrollPerfHelper;
import com.facebook.widget.listview.WrappingListItemViewUtil;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.zero.ui.ZeroIndicatorController;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Provider;

/* compiled from: native_event_listener_values */
public class ThreadListFragment extends FbFragment implements AnalyticsFragment, QuickPromotionFragmentHost {
    public static final CallerContext f6652a = CallerContext.a(ThreadListFragment.class, "messages");
    private static final int f6653b = 2131231015;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<QuickPromotionFragmentFactory> aA = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<ReadThreadManager> aB = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ThreadUnreadCountUtil> aC = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RtcCallHandler> aD = UltralightRuntime.b;
    @Inject
    private ListViewScrollHelper aE;
    @Inject
    public FbLocalBroadcastManager aF;
    @Inject
    private MessagesNotificationClient aG;
    @Inject
    public MessagingAnalyticsLogger aH;
    @Inject
    private MessengerEntryLogger aI;
    @Inject
    public MessengerSoundUtil aJ;
    @Inject
    private MontageComposerControllerProvider aK;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<MontageInboxComposerLoader> aL = UltralightRuntime.b;
    @Inject
    public MontageTestHelper aM;
    @Inject
    public NavigationLogger aN;
    @Inject
    private PerformanceLogger aO;
    @Inject
    private PerfTestConfig aP;
    @Inject
    public Product aQ;
    @Inject
    public Provider<AnchorableToast> aR;
    @IsConnStatusBannerEnabled
    @Inject
    public Provider<Boolean> aS;
    @IsChatHeadsEnabled
    @Inject
    private Provider<Boolean> aT;
    @IsMessengerSyncEnabled
    @Inject
    public Provider<Boolean> aU;
    @Inject
    @LoggedInUser
    private Provider<User> aV;
    @Inject
    private SyncOperationParamsUtil aW;
    @Inject
    public ThreadListAdapter aX;
    @Inject
    public ThreadListLoader aY;
    @Inject
    public ThreadListTooltip aZ;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<MessageRequestsHeaderLoader> al = UltralightRuntime.b;
    @Inject
    public ConnectionStatusMonitor am;
    @Inject
    public DataCache an;
    @Inject
    @LocalBroadcast
    public BaseFbBroadcastManager ao;
    @Inject
    public AbstractFbErrorReporter ap;
    @Inject
    public FbSharedPreferences aq;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GroupsAdminLogger> ar = UltralightRuntime.b;
    @Inject
    private ImpressionManager as;
    @Inject
    private InteractionLogger at;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<ArchiveThreadManager> au = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<ErrorMessageGenerator> av = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<InterstitialManager> aw = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<MessagingNullStatesLogger> ax = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<MessengerShortcutHelper> ay = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<NotificationSettingsUtil> az = UltralightRuntime.b;
    @Inject
    public InboxUnitLoader bA;
    @Inject
    public InboxViewLogger bB;
    @Inject
    private InboxViewImpressionTrackerProvider bC;
    @Inject
    private InboxActiveNowControllerProvider bD;
    @Inject
    public Context bE;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<SecureContextHelper> bF = UltralightRuntime.b;
    @Inject
    private QeAccessor bG;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SmsTakeoverNuxController> bH = UltralightRuntime.b;
    @Inject
    @IsNeueNuxPending
    private Provider<Boolean> bI;
    @Inject
    private Clock bJ;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SSLDialogHelper> bK = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ThreadListContextMenuHelper> bL = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SmsDefaultAppManager> bM = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SmsPermissionsUtil> bN = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<SmsTakeoverAnalyticsLogger> bO = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<GroupThreadActionHandler> bP = UltralightRuntime.b;
    @Inject
    private MessageEventMonitorProvider bQ;
    @Inject
    private BusinessMessageImpressionListener bR;
    @Inject
    private BusinessPromotionGatekeepers bS;
    @Inject
    private ThreadListAccessibilityDelegate bT;
    @Inject
    private OutgoingMessageFactory bU;
    @Inject
    private OfflineThreadingIdGenerator bV;
    @Inject
    private UserCache bW;
    @Inject
    public SecureContextHelper bX;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SendMessageManager> bY = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ThreadKeyFactory> bZ = UltralightRuntime.b;
    @Inject
    private ViewerContext ba;
    @Inject
    private ZeroIndicatorController bb;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<StructuredSurveyController> bc = UltralightRuntime.b;
    @Inject
    @ForUiThread
    private Executor bd;
    @Inject
    @ForUiThread
    private ScheduledExecutorService be;
    @Inject
    private ClickableToastBuilder bf;
    @Inject
    public FetchThreadsIntoMemoryCacheBackgroundTask bg;
    @Inject
    public MessagingPerformanceLogger bh;
    @Inject
    @InsecureRandom
    private Random bi;
    @Inject
    private DefaultAndroidThreadUtil bj;
    @Inject
    @IsThreadListChatHeadAttentionBadgingEnabled
    public Provider<Boolean> bk;
    @Inject
    private BugReportOperationLogger bl;
    @IsVoipEnabledForUser
    @Inject
    private Provider<Boolean> bm;
    @Inject
    private BlockingAnalyticsLogger bn;
    @Inject
    private BannerTriggersOmnistoreComponent bo;
    @Inject
    public PeopleYouMayMessageLogger bp;
    @Inject
    public PhotoRemindersGatekeepers bq;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<PhotoRemindersInboxDataLoader> br = UltralightRuntime.b;
    @Inject
    @Nullable
    public PhotoRemindersLogger bs;
    @Inject
    @Lazy
    @Nullable
    public com.facebook.inject.Lazy<PhotoSuggestionManager> bt = UltralightRuntime.b;
    @Inject
    private ConversationStartersHeaderHandler bu;
    @IsWorkBuild
    @Inject
    private Boolean bv;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<ScrollPerfHelper> bw = UltralightRuntime.b;
    @Inject
    public ThreadListConversationFilterer bx;
    @Inject
    public InboxItemCreator by;
    @Inject
    private ThreadListExperimentManager bz;
    @Inject
    public DefaultAppChoreographer f6654c;
    public MessageRequestsSnippet cA;
    public boolean cB;
    private MontageComposerController cC;
    @Nullable
    public MontageInboxComposerData cD;
    @Nullable
    public InboxActiveNowController cE;
    @Nullable
    private InboxViewImpressionTracker cF;
    public InboxUnitSnapshot cG;
    public boolean cH;
    public ThreadListItemClickListener cI;
    private OnSharedPreferenceChangeListener cJ;
    private String cK;
    public Context cL;
    private boolean cM;
    private ViewGroup cN;
    public SwipeRefreshLayout cO;
    public ViewStubHolder<QuickPromotionBannerView> cP;
    public ViewStubHolder<SurveyPromotionBannerView> cQ;
    public FutureAndCallbackHolder<OperationResult> cR;
    @Nullable
    public ScheduledFuture<?> cS;
    public AnchorableToast cT;
    private int cU = -1;
    public boolean cV;
    public boolean cW;
    public Set<ThreadKey> cX;
    public boolean cY;
    @Inject
    public ThreadListFragmentUpdateOrchestrator ca;
    @Inject
    public InboxFilterManager cb;
    @Inject
    private ThreadListItemBackgroundLoader cc;
    @Inject
    private ThreadListFragmentWarmUpHelper cd;
    private ContextMenuListener ce;
    @Nullable
    public RecentsTabEmptyViewListener cf;
    @GuardedBy("ui-thread")
    private boolean cg;
    @Nullable
    public ThreadListFragmentPTR ch;
    public BetterRecyclerView ci;
    public BetterLinearLayoutManager cj;
    private InboxUnitCardDecoration ck;
    public MessageEventMonitor<ThreadSummary> cl;
    public ViewGroup cm;
    private EmptyListViewItem cn;
    public View co;
    private boolean cp;
    private FolderName cq;
    public final SettableFuture<Boolean> cr = SettableFuture.f();
    public SelfRegistrableReceiverImpl cs;
    private final Map<ThreadTypeFilter, Result> ct = new EnumMap(ThreadTypeFilter.class);
    public Error cu;
    public boolean cv;
    public boolean cw;
    @Nullable
    public PhotoRemindersInboxData cx;
    @Nullable
    public PhotoRemindersInboxData cy;
    @Nullable
    public AnonymousClass44 cz;
    @Inject
    public AnalyticsLogger f6655d;
    @Inject
    private AnalyticsTagger f6656e;
    @Inject
    public AudioManager f6657f;
    @Inject
    public DefaultBlueServiceOperationFactory f6658g;
    @Inject
    public ChatHeadsIntentDispatcher f6659h;
    @Inject
    private ChatHeadsOpenHelper f6660i;

    /* compiled from: native_event_listener_values */
    class C09951 implements Listener {
        final /* synthetic */ ThreadListFragment f6608a;

        C09951(ThreadListFragment threadListFragment) {
            this.f6608a = threadListFragment;
        }

        public final void m6293a() {
            ThreadListFragment.m6327a(this.f6608a, QuickPromotionTriggers.f3781a);
        }
    }

    /* compiled from: native_event_listener_values */
    class C09962 implements Runnable {
        final /* synthetic */ ThreadListFragment f6621a;

        C09962(ThreadListFragment threadListFragment) {
            this.f6621a = threadListFragment;
        }

        public void run() {
            ThreadListFragment.aH(this.f6621a);
        }
    }

    /* compiled from: native_event_listener_values */
    public class C09973 implements ActionReceiver {
        final /* synthetic */ ThreadListFragment f6634a;

        public C09973(ThreadListFragment threadListFragment) {
            this.f6634a = threadListFragment;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1168287181);
            long longExtra = intent.getLongExtra("action_id", -1);
            Result au = ThreadListFragment.au(this.f6634a);
            if (longExtra == -1 || au.m6399a() || au.f6716d < longExtra) {
                Object obj;
                Bundle bundleExtra = intent.getBundleExtra("broadcast_extras");
                if (bundleExtra != null) {
                    ThreadUpdateCause threadUpdateCause = (ThreadUpdateCause) bundleExtra.getSerializable("broadcast_cause");
                    obj = (threadUpdateCause == ThreadUpdateCause.READ_RECEIPT || threadUpdateCause == ThreadUpdateCause.DELIVERY_RECEIPT) ? 1 : null;
                } else {
                    obj = null;
                }
                RefreshType refreshType = obj != null ? RefreshType.RECEIPTS_REFRESH : RefreshType.AUTOMATIC_REFRESH;
                if (intent.getAction().equals(MessagesBroadcastIntents.b)) {
                    this.f6634a.cX.addAll(intent.getParcelableArrayListExtra("multiple_thread_keys"));
                    ThreadListFragment.aq(this.f6634a);
                }
                ThreadListFragment.m6331a(this.f6634a, refreshType, "threadsUpdatedReceiver");
            }
            LogUtils.e(-1968791502, a);
        }
    }

    /* compiled from: native_event_listener_values */
    public class C09984 implements ActionReceiver {
        final /* synthetic */ ThreadListFragment f6641a;

        public C09984(ThreadListFragment threadListFragment) {
            this.f6641a = threadListFragment;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1002114436);
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("multiple_thread_keys");
            int size = parcelableArrayListExtra.size();
            for (int i = 0; i < size; i++) {
                ThreadSummary a2 = this.f6641a.an.a((ThreadKey) parcelableArrayListExtra.get(i));
                if (a2 != null) {
                    ThreadListFragment.m6329a(this.f6641a, a2.a);
                }
            }
            LogUtils.e(-1574395677, a);
        }
    }

    /* compiled from: native_event_listener_values */
    public class C09995 implements ActionReceiver {
        final /* synthetic */ ThreadListFragment f6642a;

        public C09995(ThreadListFragment threadListFragment) {
            this.f6642a = threadListFragment;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -48957909);
            if (PushStateEvent.fromValue(intent.getIntExtra("event", PushStateEvent.UNKNOWN.toValue())) == PushStateEvent.CHANNEL_CONNECTED) {
                ThreadListFragment.m6331a(this.f6642a, RefreshType.AUTOMATIC_REFRESH, "channelStateChangedReceiver");
            }
            if (intent.getBooleanExtra("clock_skew_detected", false)) {
                ThreadListFragment.av(this.f6642a);
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1637392590, a);
        }
    }

    /* compiled from: native_event_listener_values */
    public class C10006 implements ActionReceiver {
        final /* synthetic */ ThreadListFragment f6643a;

        public C10006(ThreadListFragment threadListFragment) {
            this.f6643a = threadListFragment;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1044580494);
            if (ThreadListFragment.aM(this.f6643a)) {
                ThreadListFragment.m6338a(this.f6643a, true, "message requests");
            } else {
                ThreadListFragment.az(this.f6643a);
                ((MessageRequestsHeaderLoader) this.f6643a.al.get()).a(null);
            }
            LogUtils.e(851057364, a);
        }
    }

    /* compiled from: native_event_listener_values */
    public class C10017 implements ActionReceiver {
        final /* synthetic */ ThreadListFragment f6644a;

        public C10017(ThreadListFragment threadListFragment) {
            this.f6644a = threadListFragment;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1465579928);
            ThreadListFragment.m6338a(this.f6644a, false, "inbox2 changed");
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 2104448311, a);
        }
    }

    /* compiled from: native_event_listener_values */
    public class C10028 implements Callback<Params, Result, Error> {
        final /* synthetic */ ThreadListFragment f6645a;

        public C10028(ThreadListFragment threadListFragment) {
            this.f6645a = threadListFragment;
        }

        public final void m6311a(Object obj, ListenableFuture listenableFuture) {
            Params params = (Params) obj;
            Tracer.b("ThreadListFragment: threads onLoadingAsync");
            this.f6645a.f6654c.a(listenableFuture);
            ThreadListFragment threadListFragment = this.f6645a;
            if (threadListFragment.cT != null) {
                threadListFragment.cT.m4482a();
            }
            if (params.f6709c == LoadType.THREAD_LIST) {
                Object obj2;
                threadListFragment.cu = null;
                threadListFragment.ca.m6377a(Urgency.THREADS, "onLoading");
                ThreadListLoader threadListLoader = threadListFragment.aY;
                if (threadListLoader.f6732o == null || !threadListLoader.f6732o.f6708b) {
                    obj2 = null;
                } else {
                    obj2 = 1;
                }
                if (obj2 != null && threadListFragment.ch != null) {
                    ThreadListFragmentPTR threadListFragmentPTR = threadListFragment.ch;
                    threadListFragmentPTR.f6662a.setRefreshing(true);
                    threadListFragmentPTR.f6664c = false;
                }
            } else if (params.f6709c == LoadType.MORE_THREADS) {
                threadListFragment.aX.m6267a(LoadMoreState.LOADING);
            }
        }

        public final void m6312a(Object obj, Object obj2) {
            Params params = (Params) obj;
            Result result = (Result) obj2;
            Tracer.b("ThreadListFragment: threads onNewResult");
            ThreadListFragment.m6333a(this.f6645a, params, result);
        }

        public final void m6313b(Object obj, Object obj2) {
            Params params = (Params) obj;
            Result result = (Result) obj2;
            Tracer.b("ThreadListFragment: threads onLoadSucceeded");
            ThreadListFragment threadListFragment = this.f6645a;
            if (result.f6717e.m != DataSource.SMS) {
                threadListFragment.cW = false;
            } else if (!(threadListFragment.cb.f6410E == ThreadTypeFilter.SMS || threadListFragment.cW)) {
                new FbAlertDialogBuilder(threadListFragment.bE).a(2131232352).b(2131232353).a(2131230726, null).a().show();
                threadListFragment.cW = true;
            }
            if (result.f6717e.r.asBoolean(false)) {
                if (((Boolean) threadListFragment.aU.get()).booleanValue()) {
                    BlueServiceOperationFactoryDetour.a(threadListFragment.f6658g, "ensure_sync", new Bundle(), CallerContext.a(threadListFragment.getClass()), -228669497).a(true).a();
                } else {
                    ThreadListFragment.m6331a(threadListFragment, RefreshType.AUTOMATIC_REFRESH, "sync disabled");
                }
            } else if (threadListFragment.T != null && params.f6709c == LoadType.THREAD_LIST) {
                threadListFragment.ch.m6372b();
            }
            FutureDetour.a(this.f6645a.cr, Boolean.valueOf(true), -1685253181);
        }

        public final void m6314c(Object obj, Object obj2) {
            ThreadListFragment.m6332a(this.f6645a, (Params) obj, (Error) obj2);
            FutureDetour.a(this.f6645a.cr, Boolean.valueOf(true), -1963383452);
        }
    }

    /* compiled from: native_event_listener_values */
    class C10039 implements InboxUnitViewWithRecyclerView {
        final /* synthetic */ ThreadListFragment f6646a;

        C10039(ThreadListFragment threadListFragment) {
            this.f6646a = threadListFragment;
        }

        public BetterRecyclerView getRecyclerView() {
            return this.f6646a.ci;
        }

        public InboxAdapter getInboxAdapter() {
            return this.f6646a.aX;
        }
    }

    /* compiled from: native_event_listener_values */
    class BannerAnimateUpdateListener implements AnimatorUpdateListener {
        final /* synthetic */ ThreadListFragment f6647a;
        private final View f6648b;

        public BannerAnimateUpdateListener(ThreadListFragment threadListFragment, View view) {
            this.f6647a = threadListFragment;
            this.f6648b = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int height = this.f6648b.getHeight();
            if (height <= 0) {
                this.f6648b.setTranslationY(10000.0f);
                return;
            }
            floatValue *= (float) height;
            this.f6648b.setTranslationY(floatValue);
            this.f6647a.cm.setTranslationY(floatValue);
        }
    }

    /* compiled from: native_event_listener_values */
    public interface ContextMenuListener {
        boolean m6315a();
    }

    /* compiled from: native_event_listener_values */
    public enum LoaderState {
        READY_WITH_THREADS_AND_UNITS,
        READY_WITH_THREADS,
        THREADS_AND_UNITS_LOADING,
        THREADS_LOADING,
        UNITS_LOADING,
        OTHER_LOADING;

        public final boolean isReady() {
            return this == READY_WITH_THREADS || this == READY_WITH_THREADS_AND_UNITS;
        }
    }

    /* compiled from: native_event_listener_values */
    class MyOnScrollListener extends OnScrollListener {
        final /* synthetic */ ThreadListFragment f6649a;

        public MyOnScrollListener(ThreadListFragment threadListFragment) {
            this.f6649a = threadListFragment;
        }

        public void mo237a(RecyclerView recyclerView, int i) {
            switch (i) {
                case 0:
                    ThreadListFragment.aU(this.f6649a);
                    ThreadListFragment.aW(this.f6649a);
                    break;
            }
            if (this.f6649a.cE != null) {
                InboxActiveNowController inboxActiveNowController = this.f6649a.cE;
                inboxActiveNowController.f2605l = i;
                InboxActiveNowController.m2585c(inboxActiveNowController);
            }
        }

        public final void m6317a(RecyclerView recyclerView, int i, int i2) {
            if (this.f6649a.ci.M == 0) {
                ThreadListFragment.aW(this.f6649a);
            }
            if (this.f6649a.cE != null) {
                InboxActiveNowController.m2585c(this.f6649a.cE);
            }
        }
    }

    /* compiled from: native_event_listener_values */
    public enum RefreshType {
        AUTOMATIC_REFRESH {
            final Params getThreadListLoaderParams(ThreadTypeFilter threadTypeFilter) {
                return Params.m6397a(false, false, false, threadTypeFilter, ThreadListFragment.f6652a);
            }
        },
        EXPLICIT_USER_REFRESH {
            final Params getThreadListLoaderParams(ThreadTypeFilter threadTypeFilter) {
                return Params.m6397a(true, true, false, threadTypeFilter, ThreadListFragment.f6652a);
            }
        },
        RECEIPTS_REFRESH {
            final Params getThreadListLoaderParams(ThreadTypeFilter threadTypeFilter) {
                return Params.m6397a(false, false, true, threadTypeFilter, ThreadListFragment.f6652a);
            }
        },
        INBOX_FILTER_CHANGE {
            final Params getThreadListLoaderParams(ThreadTypeFilter threadTypeFilter) {
                return Params.m6397a(false, true, true, threadTypeFilter, ThreadListFragment.f6652a);
            }
        };

        abstract Params getThreadListLoaderParams(ThreadTypeFilter threadTypeFilter);
    }

    /* compiled from: native_event_listener_values */
    public class ThemeHack extends View {
        @Inject
        public ThreadListThemeWrapper f6650a;

        public static void m6318a(Object obj, Context context) {
            FbInjector fbInjector = FbInjector.get(context);
            ((ThemeHack) obj).f6650a = new ThreadListThemeWrapper(ThreadListExperimentManager.m6283a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector));
        }

        ThemeHack(Context context) {
            super(context);
            Class cls = ThemeHack.class;
            m6318a(this, getContext());
        }
    }

    /* compiled from: native_event_listener_values */
    public interface ThreadListItemClickListener {
    }

    /* compiled from: native_event_listener_values */
    class ThreadListScrollListenerForPerfTesting extends MyOnScrollListener {
        final /* synthetic */ ThreadListFragment f6651b;

        public ThreadListScrollListenerForPerfTesting(ThreadListFragment threadListFragment) {
            this.f6651b = threadListFragment;
            super(threadListFragment);
        }

        public final void mo237a(RecyclerView recyclerView, int i) {
            ((ScrollPerfHelper) this.f6651b.bw.get()).a(i);
            super.mo237a(recyclerView, i);
        }
    }

    public static void m6340a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ThreadListFragment) obj).m6321a(DefaultAppChoreographer.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), AnalyticsTagger.a(injectorLike), AudioManagerMethodAutoProvider.a(injectorLike), DefaultBlueServiceOperationFactory.a(injectorLike), ChatHeadsIntentDispatcher.a(injectorLike), ChatHeadsOpenHelper.a(injectorLike), IdBasedLazy.a(injectorLike, 7963), ConnectionStatusMonitorMethodAutoProvider.a(injectorLike), DataCache.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedLazy.a(injectorLike, 7862), ImpressionManager.a(injectorLike), InteractionLogger.a(injectorLike), IdBasedLazy.a(injectorLike, 7689), IdBasedLazy.a(injectorLike, 3560), IdBasedSingletonScopeProvider.b(injectorLike, 2360), IdBasedLazy.a(injectorLike, 7997), IdBasedLazy.a(injectorLike, 8438), IdBasedLazy.a(injectorLike, 2906), IdBasedSingletonScopeProvider.b(injectorLike, 9822), IdBasedLazy.a(injectorLike, 7702), IdBasedLazy.a(injectorLike, 7709), IdBasedSingletonScopeProvider.b(injectorLike, 3342), ListViewScrollHelper.a(injectorLike), FbLocalBroadcastManagerMethodAutoProvider.a(injectorLike), MessagesNotificationClient.a(injectorLike), MessagingAnalyticsLogger.a(injectorLike), MessengerEntryLogger.a(injectorLike), MessengerSoundUtil.a(injectorLike), (MontageComposerControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MontageComposerControllerProvider.class), IdBasedLazy.a(injectorLike, 7992), MontageTestHelper.a(injectorLike), NavigationLogger.a(injectorLike), (PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike), PerfTestConfig.a(injectorLike), ProductMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 8600), IdBasedProvider.a(injectorLike, 4141), IdBasedProvider.a(injectorLike, 4128), IdBasedProvider.a(injectorLike, 4075), IdBasedProvider.a(injectorLike, 3595), SyncOperationParamsUtil.a(injectorLike), ThreadListAdapter.m6250a(injectorLike), ThreadListLoader.m6401a(injectorLike), ThreadListTooltip.m6424a(injectorLike), ViewerContextMethodAutoProvider.a(injectorLike), ZeroIndicatorController.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3480), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), ClickableToastBuilder.a(injectorLike), FetchThreadsIntoMemoryCacheBackgroundTask.a(injectorLike), MessagingPerformanceLogger.a(injectorLike), Random_InsecureRandomMethodAutoProvider.a(injectorLike), DefaultAndroidThreadUtil.a(injectorLike), IdBasedProvider.a(injectorLike, 4094), BugReportOperationLogger.a(injectorLike), IdBasedProvider.a(injectorLike, 4314), BlockingAnalyticsLogger.a(injectorLike), BannerTriggersOmnistoreComponent.a(injectorLike), PeopleYouMayMessageLogger.m3367a(injectorLike), PhotoRemindersGatekeepers.a(injectorLike), IdBasedLazy.a(injectorLike, 8285), PhotoRemindersLogger.a(injectorLike), IdBasedLazy.a(injectorLike, 8288), ConversationStartersHeaderHandler.m2124a(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 3731), ThreadListConversationFilterer.m6276a(injectorLike), InboxItemCreator.m6125a(injectorLike), ThreadListExperimentManager.m6283a(injectorLike), InboxUnitLoader.m2716a(injectorLike), InboxViewLogger.m2618a(injectorLike), (InboxViewImpressionTrackerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(InboxViewImpressionTrackerProvider.class), (InboxActiveNowControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(InboxActiveNowControllerProvider.class), (Context) injectorLike.getInstance(Context.class), IdBasedSingletonScopeProvider.b(injectorLike, 968), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 8445), IdBasedProvider.a(injectorLike, 4172), (Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 3438), IdBasedLazy.a(injectorLike, 8819), IdBasedSingletonScopeProvider.b(injectorLike, 2709), IdBasedSingletonScopeProvider.b(injectorLike, 8460), IdBasedLazy.a(injectorLike, 2706), IdBasedLazy.a(injectorLike, 7872), (MessageEventMonitorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MessageEventMonitorProvider.class), BusinessMessageImpressionListener.a(injectorLike), BusinessPromotionGatekeepers.a(injectorLike), ThreadListAccessibilityDelegate.m6240a(injectorLike), OutgoingMessageFactory.a(injectorLike), OfflineThreadingIdGenerator.a(injectorLike), UserCache.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), IdBasedLazy.a(injectorLike, 8347), IdBasedLazy.a(injectorLike, 2665), ThreadListFragmentUpdateOrchestrator.m6374a(injectorLike), InboxFilterManager.m6098a(injectorLike), ThreadListItemBackgroundLoader.m6384a(injectorLike), ThreadListFragmentWarmUpHelper.m6379a(injectorLike));
    }

    private void m6321a(AppChoreographer appChoreographer, AnalyticsLogger analyticsLogger, AnalyticsTagger analyticsTagger, AudioManager audioManager, BlueServiceOperationFactory blueServiceOperationFactory, ChatHeadsIntentDispatcher chatHeadsIntentDispatcher, ChatHeadsOpenHelper chatHeadsOpenHelper, com.facebook.inject.Lazy<MessageRequestsHeaderLoader> lazy, ConnectionStatusMonitor connectionStatusMonitor, DataCache dataCache, FbBroadcastManager fbBroadcastManager, FbErrorReporter fbErrorReporter, FbSharedPreferences fbSharedPreferences, com.facebook.inject.Lazy<GroupsAdminLogger> lazy2, ImpressionManager impressionManager, InteractionLogger interactionLogger, com.facebook.inject.Lazy<ArchiveThreadManager> lazy3, com.facebook.inject.Lazy<ErrorMessageGenerator> lazy4, com.facebook.inject.Lazy<InterstitialManager> lazy5, com.facebook.inject.Lazy<MessagingNullStatesLogger> lazy6, com.facebook.inject.Lazy<MessengerShortcutHelper> lazy7, com.facebook.inject.Lazy<NotificationSettingsUtil> lazy8, com.facebook.inject.Lazy<QuickPromotionFragmentFactory> lazy9, com.facebook.inject.Lazy<ReadThreadManager> lazy10, com.facebook.inject.Lazy<ThreadUnreadCountUtil> lazy11, com.facebook.inject.Lazy<RtcCallHandler> lazy12, ListViewScrollHelper listViewScrollHelper, FbLocalBroadcastManager fbLocalBroadcastManager, MessagesNotificationClient messagesNotificationClient, MessagingAnalyticsLogger messagingAnalyticsLogger, MessengerEntryLogger messengerEntryLogger, MessengerSoundUtil messengerSoundUtil, MontageComposerControllerProvider montageComposerControllerProvider, com.facebook.inject.Lazy<MontageInboxComposerLoader> lazy13, MontageTestHelper montageTestHelper, NavigationLogger navigationLogger, PerformanceLogger performanceLogger, PerfTestConfig perfTestConfig, Product product, Provider<AnchorableToast> provider, Provider<Boolean> provider2, Provider<Boolean> provider3, Provider<Boolean> provider4, Provider<User> provider5, SyncOperationParamsUtil syncOperationParamsUtil, ThreadListAdapter threadListAdapter, ThreadListLoader threadListLoader, ThreadListTooltip threadListTooltip, ViewerContext viewerContext, ZeroIndicatorController zeroIndicatorController, com.facebook.inject.Lazy<StructuredSurveyController> lazy14, Executor executor, ScheduledExecutorService scheduledExecutorService, ClickableToastBuilder clickableToastBuilder, FetchThreadsIntoMemoryCacheBackgroundTask fetchThreadsIntoMemoryCacheBackgroundTask, MessagingPerformanceLogger messagingPerformanceLogger, Random random, AndroidThreadUtil androidThreadUtil, Provider<Boolean> provider6, BugReportOperationLogger bugReportOperationLogger, Provider<Boolean> provider7, BlockingAnalyticsLogger blockingAnalyticsLogger, BannerTriggersOmnistoreComponent bannerTriggersOmnistoreComponent, PeopleYouMayMessageLogger peopleYouMayMessageLogger, PhotoRemindersGatekeepers photoRemindersGatekeepers, com.facebook.inject.Lazy<PhotoRemindersInboxDataLoader> lazy15, PhotoRemindersLogger photoRemindersLogger, com.facebook.inject.Lazy<PhotoSuggestionManager> lazy16, ConversationStartersHeaderHandler conversationStartersHeaderHandler, Boolean bool, com.facebook.inject.Lazy<ScrollPerfHelper> lazy17, ThreadListConversationFilterer threadListConversationFilterer, InboxItemCreator inboxItemCreator, ThreadListExperimentManager threadListExperimentManager, InboxUnitLoader inboxUnitLoader, InboxViewLogger inboxViewLogger, InboxViewImpressionTrackerProvider inboxViewImpressionTrackerProvider, InboxActiveNowControllerProvider inboxActiveNowControllerProvider, Context context, com.facebook.inject.Lazy<SecureContextHelper> lazy18, QeAccessor qeAccessor, com.facebook.inject.Lazy<SmsTakeoverNuxController> lazy19, Provider<Boolean> provider8, Clock clock, com.facebook.inject.Lazy<SSLDialogHelper> lazy20, com.facebook.inject.Lazy<ThreadListContextMenuHelper> lazy21, com.facebook.inject.Lazy<SmsDefaultAppManager> lazy22, com.facebook.inject.Lazy<SmsPermissionsUtil> lazy23, com.facebook.inject.Lazy<SmsTakeoverAnalyticsLogger> lazy24, com.facebook.inject.Lazy<GroupThreadActionHandler> lazy25, MessageEventMonitorProvider messageEventMonitorProvider, BusinessMessageImpressionListener businessMessageImpressionListener, BusinessPromotionGatekeepers businessPromotionGatekeepers, ThreadListAccessibilityDelegate threadListAccessibilityDelegate, OutgoingMessageFactory outgoingMessageFactory, OfflineThreadingIdGenerator offlineThreadingIdGenerator, UserCache userCache, SecureContextHelper secureContextHelper, com.facebook.inject.Lazy<SendMessageManager> lazy26, com.facebook.inject.Lazy<ThreadKeyFactory> lazy27, ThreadListFragmentUpdateOrchestrator threadListFragmentUpdateOrchestrator, InboxFilterManager inboxFilterManager, ThreadListItemBackgroundLoader threadListItemBackgroundLoader, ThreadListFragmentWarmUpHelper threadListFragmentWarmUpHelper) {
        this.f6654c = appChoreographer;
        this.f6655d = analyticsLogger;
        this.f6656e = analyticsTagger;
        this.f6657f = audioManager;
        this.f6658g = blueServiceOperationFactory;
        this.f6659h = chatHeadsIntentDispatcher;
        this.f6660i = chatHeadsOpenHelper;
        this.al = lazy;
        this.am = connectionStatusMonitor;
        this.an = dataCache;
        this.ao = fbBroadcastManager;
        this.ap = fbErrorReporter;
        this.aq = fbSharedPreferences;
        this.ar = lazy2;
        this.as = impressionManager;
        this.at = interactionLogger;
        this.au = lazy3;
        this.av = lazy4;
        this.aw = lazy5;
        this.ax = lazy6;
        this.ay = lazy7;
        this.az = lazy8;
        this.aA = lazy9;
        this.aB = lazy10;
        this.aC = lazy11;
        this.aD = lazy12;
        this.aE = listViewScrollHelper;
        this.aF = fbLocalBroadcastManager;
        this.aG = messagesNotificationClient;
        this.aH = messagingAnalyticsLogger;
        this.aI = messengerEntryLogger;
        this.aJ = messengerSoundUtil;
        this.aK = montageComposerControllerProvider;
        this.aL = lazy13;
        this.aM = montageTestHelper;
        this.aN = navigationLogger;
        this.aO = performanceLogger;
        this.aP = perfTestConfig;
        this.aQ = product;
        this.aR = provider;
        this.aS = provider2;
        this.aT = provider3;
        this.aU = provider4;
        this.aV = provider5;
        this.aW = syncOperationParamsUtil;
        this.aX = threadListAdapter;
        this.aY = threadListLoader;
        this.aZ = threadListTooltip;
        this.ba = viewerContext;
        this.bb = zeroIndicatorController;
        this.bc = lazy14;
        this.bd = executor;
        this.be = scheduledExecutorService;
        this.bf = clickableToastBuilder;
        this.bg = fetchThreadsIntoMemoryCacheBackgroundTask;
        this.bh = messagingPerformanceLogger;
        this.bi = random;
        this.bj = androidThreadUtil;
        this.bk = provider6;
        this.bl = bugReportOperationLogger;
        this.bm = provider7;
        this.bn = blockingAnalyticsLogger;
        this.bo = bannerTriggersOmnistoreComponent;
        this.bp = peopleYouMayMessageLogger;
        this.bq = photoRemindersGatekeepers;
        this.br = lazy15;
        this.bs = photoRemindersLogger;
        this.bt = lazy16;
        this.bu = conversationStartersHeaderHandler;
        this.bv = bool;
        this.bw = lazy17;
        this.bx = threadListConversationFilterer;
        this.by = inboxItemCreator;
        this.bz = threadListExperimentManager;
        this.bA = inboxUnitLoader;
        this.bB = inboxViewLogger;
        this.bC = inboxViewImpressionTrackerProvider;
        this.bD = inboxActiveNowControllerProvider;
        this.bE = context;
        this.bF = lazy18;
        this.bG = qeAccessor;
        this.bH = lazy19;
        this.bI = provider8;
        this.bJ = clock;
        this.bK = lazy20;
        this.bL = lazy21;
        this.bM = lazy22;
        this.bN = lazy23;
        this.bO = lazy24;
        this.bP = lazy25;
        this.bQ = messageEventMonitorProvider;
        this.bR = businessMessageImpressionListener;
        this.bS = businessPromotionGatekeepers;
        this.bT = threadListAccessibilityDelegate;
        this.bU = outgoingMessageFactory;
        this.bV = offlineThreadingIdGenerator;
        this.bW = userCache;
        this.bX = secureContextHelper;
        this.bY = lazy26;
        this.bZ = lazy27;
        this.ca = threadListFragmentUpdateOrchestrator;
        this.cb = inboxFilterManager;
        this.cc = threadListItemBackgroundLoader;
        this.cd = threadListFragmentWarmUpHelper;
    }

    public final void m6365c(@Nullable Bundle bundle) {
        int i = 0;
        super.c(bundle);
        if (this.s != null) {
            i = this.s.getInt("PARAM_CUSTOM_THEME", 0);
        }
        if (i > 0) {
            this.cL = new ContextThemeWrapper(getContext(), i);
            this.cd.f6676b = null;
        } else if (this.cL == null) {
            this.cL = new ThemeHack(getContext()).f6650a.m6423a(getContext());
        }
        this.cX = Sets.a();
        if (!this.cY) {
            this.cY = true;
            Class cls = ThreadListFragment.class;
            m6340a((Object) this, this.cL);
        }
        this.ca.m6376a();
        this.aY.m6416a(new C10028(this));
        C09973 c09973 = new C09973(this);
        C09984 c09984 = new C09984(this);
        C09995 c09995 = new C09995(this);
        C10006 c10006 = new C10006(this);
        this.cs = this.ao.a().a(MessagesBroadcastIntents.a, c09973).a(MessagesBroadcastIntents.b, c09973).a(MessagesBroadcastIntents.d, c09973).a(MessagesBroadcastIntents.c, c09984).a("com.facebook.push.mqtt.ACTION_CHANNEL_STATE_CHANGED", c09995).a(MessagesBroadcastIntents.t, c10006).a(MessagesBroadcastIntents.e, c09973).a(MessagesBroadcastIntents.A, new C10017(this)).a();
        this.cs.b();
        this.aO.d(3604482, "ThreadListFragment.onCreateThroughOnResume");
        this.bh.a(5505045, bj(), "onFragmentCreate");
        this.bh.a(5505045, bj(), (short) 44);
        this.bo.b(new C09951(this));
        this.ca.f6669d = new C09962(this);
        aq(this);
    }

    public static void aq(ThreadListFragment threadListFragment) {
        if (!threadListFragment.cg) {
            ThreadsCollection b = threadListFragment.an.b(FolderName.INBOX, ThreadTypeFilter.ALL);
            if (b != null && !b.c.isEmpty()) {
                threadListFragment.cg = true;
                int a = threadListFragment.aq.a(MessagingPrefKeys.aw, 8);
                List list = b.c;
                if (list.size() > a) {
                    list = list.subList(0, a);
                }
                threadListFragment.cc.m6391a(threadListFragment.getContext(), list);
            }
        }
    }

    private boolean bh() {
        return this.G != null && this.G.K;
    }

    public static Result au(ThreadListFragment threadListFragment) {
        Result result = (Result) threadListFragment.ct.get(threadListFragment.cb.f6410E);
        return result != null ? result : Result.f6713a;
    }

    public static void av(ThreadListFragment threadListFragment) {
        if (threadListFragment.bG.a(ExperimentsForThreadListExperimentsModule.f6756c, false)) {
            if (threadListFragment.aq.a(MessagingPrefKeys.aT, 0) < threadListFragment.bJ.a() - threadListFragment.bG.a(ExperimentsForThreadListExperimentsModule.f6755b, 604800000)) {
                ((SSLDialogHelper) threadListFragment.bK.get()).a(threadListFragment.bE, "SSL_CLOCK_SKEW");
                threadListFragment.aq.edit().a(MessagingPrefKeys.aT, threadListFragment.bJ.a()).commit();
            }
        }
    }

    public final View m6360a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1286745713);
        View a2 = this.cd.m6381a(this.cL, layoutInflater, viewGroup, bj(), ap());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -504020050, a);
        return a2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m6363a(android.view.View r7, @javax.annotation.Nullable android.os.Bundle r8) {
        /*
        r6 = this;
        r2 = 1;
        r3 = 0;
        r0 = "ThreadListFragment.onViewCreated";
        r1 = 1767597255; // 0x695b64c7 float:1.6576916E25 double:8.733090794E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0, r1);
        r0 = "ThreadListFragment.onViewCreatedFindViews";
        r1 = 2049081259; // 0x7a227fab float:2.1093538E35 double:1.0123806556E-314;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0, r1);	 Catch:{ all -> 0x01bf }
        r0 = 2131563825; // 0x7f0d1531 float:1.8753118E38 double:1.053132458E-314;
        r0 = r6.e(r0);	 Catch:{ all -> 0x01b7 }
        r0 = (android.view.ViewGroup) r0;	 Catch:{ all -> 0x01b7 }
        r6.cN = r0;	 Catch:{ all -> 0x01b7 }
        r0 = 2131565190; // 0x7f0d1a86 float:1.8755886E38 double:1.0531331323E-314;
        r0 = r6.e(r0);	 Catch:{ all -> 0x01b7 }
        r0 = (android.view.ViewGroup) r0;	 Catch:{ all -> 0x01b7 }
        r6.cm = r0;	 Catch:{ all -> 0x01b7 }
        r0 = 2131565088; // 0x7f0d1a20 float:1.875568E38 double:1.053133082E-314;
        r0 = r6.e(r0);	 Catch:{ all -> 0x01b7 }
        r0 = (android.support.v7.internal.widget.ViewStubCompat) r0;	 Catch:{ all -> 0x01b7 }
        r0 = com.facebook.widget.ViewStubHolder.a(r0);	 Catch:{ all -> 0x01b7 }
        r6.cP = r0;	 Catch:{ all -> 0x01b7 }
        r0 = 2131565189; // 0x7f0d1a85 float:1.8755884E38 double:1.053133132E-314;
        r0 = r6.e(r0);	 Catch:{ all -> 0x01b7 }
        r0 = (android.support.v7.internal.widget.ViewStubCompat) r0;	 Catch:{ all -> 0x01b7 }
        r0 = com.facebook.widget.ViewStubHolder.a(r0);	 Catch:{ all -> 0x01b7 }
        r6.cQ = r0;	 Catch:{ all -> 0x01b7 }
        r0 = 2131565196; // 0x7f0d1a8c float:1.8755899E38 double:1.053133135E-314;
        r0 = r6.e(r0);	 Catch:{ all -> 0x01b7 }
        r0 = (android.support.v7.widget.RecyclerView) r0;	 Catch:{ all -> 0x01b7 }
        r1 = 2131565195; // 0x7f0d1a8b float:1.8755897E38 double:1.0531331347E-314;
        r1 = r6.e(r1);	 Catch:{ all -> 0x01b7 }
        r1 = (android.support.v4.widget.SwipeRefreshLayout) r1;	 Catch:{ all -> 0x01b7 }
        r6.cO = r1;	 Catch:{ all -> 0x01b7 }
        r1 = -1419448038; // 0xffffffffab64f11a float:-8.133647E-13 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);	 Catch:{  }
        r1 = new com.facebook.orca.threadlist.ThreadListFragmentPTR;	 Catch:{  }
        r4 = r6.cO;	 Catch:{  }
        r1.<init>(r4);	 Catch:{  }
        r6.ch = r1;	 Catch:{  }
        r1 = "ThreadListFragment.onViewCreatedRecyclerView";
        r4 = 1113548898; // 0x425f6862 float:55.851936 double:5.501662555E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1, r4);	 Catch:{  }
        r0 = (com.facebook.widget.recyclerview.BetterRecyclerView) r0;	 Catch:{ all -> 0x01c7 }
        r6.ci = r0;	 Catch:{ all -> 0x01c7 }
        r0 = new com.facebook.widget.recyclerview.BetterLinearLayoutManager;	 Catch:{ all -> 0x01c7 }
        r1 = r6.getContext();	 Catch:{ all -> 0x01c7 }
        r0.<init>(r1);	 Catch:{ all -> 0x01c7 }
        r6.cj = r0;	 Catch:{ all -> 0x01c7 }
        r0 = r6.ci;	 Catch:{ all -> 0x01c7 }
        r1 = r6.cj;	 Catch:{ all -> 0x01c7 }
        r0.setLayoutManager(r1);	 Catch:{ all -> 0x01c7 }
        r0 = new com.facebook.messaging.threadlist.InboxUnitCardDecoration;	 Catch:{ all -> 0x01c7 }
        r1 = r6.cL;	 Catch:{ all -> 0x01c7 }
        r4 = r6.aX;	 Catch:{ all -> 0x01c7 }
        r0.<init>(r1, r4);	 Catch:{ all -> 0x01c7 }
        r6.ck = r0;	 Catch:{ all -> 0x01c7 }
        r0 = r6.ci;	 Catch:{ all -> 0x01c7 }
        r1 = r6.ck;	 Catch:{ all -> 0x01c7 }
        r0.a(r1);	 Catch:{ all -> 0x01c7 }
        r0 = r6.ci;	 Catch:{ all -> 0x01c7 }
        r1 = r6.aX;	 Catch:{ all -> 0x01c7 }
        r0.setAdapter(r1);	 Catch:{ all -> 0x01c7 }
        r0 = 523076272; // 0x1f2d82b0 float:3.6742277E-20 double:2.58434016E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);	 Catch:{  }
        r0 = "ThreadListFragment.onViewCreatedInbox2Views";
        r1 = 450011201; // 0x1ad2a041 float:8.711287E-23 double:2.223350747E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0, r1);	 Catch:{  }
        r0 = r6.bz;	 Catch:{ all -> 0x01cf }
        r0 = r0.m6285a();	 Catch:{ all -> 0x01cf }
        if (r0 == 0) goto L_0x00e0;
    L_0x00b6:
        r0 = new com.facebook.orca.threadlist.ThreadListFragment$9;	 Catch:{ all -> 0x01cf }
        r0.<init>(r6);	 Catch:{ all -> 0x01cf }
        r1 = r6.bC;	 Catch:{ all -> 0x01cf }
        r0 = r1.m2617a(r0);	 Catch:{ all -> 0x01cf }
        r6.cF = r0;	 Catch:{ all -> 0x01cf }
        r0 = r6.bD;	 Catch:{ all -> 0x01cf }
        r1 = r6.ci;	 Catch:{ all -> 0x01cf }
        r4 = r6.aX;	 Catch:{ all -> 0x01cf }
        r0 = r0.m2594a(r1, r4);	 Catch:{ all -> 0x01cf }
        r6.cE = r0;	 Catch:{ all -> 0x01cf }
        r0 = r6.aX;	 Catch:{ all -> 0x01cf }
        r1 = r6.cF;	 Catch:{ all -> 0x01cf }
        r0.m6266a(r1);	 Catch:{ all -> 0x01cf }
        r0 = r6.cE;	 Catch:{ all -> 0x01cf }
        r1 = new com.facebook.orca.threadlist.ThreadListFragment$10;	 Catch:{ all -> 0x01cf }
        r1.<init>(r6);	 Catch:{ all -> 0x01cf }
        r0.m2590a(r1);	 Catch:{ all -> 0x01cf }
    L_0x00e0:
        r0 = 1500680655; // 0x597291cf float:4.26732891E15 double:7.41434757E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);	 Catch:{  }
        r0 = r6.cb;	 Catch:{  }
        r1 = r6.cm;	 Catch:{  }
        r4 = new com.facebook.orca.threadlist.ThreadListFragment$11;	 Catch:{  }
        r4.<init>(r6);	 Catch:{  }
        r0.m6115a(r1, r4, r8);	 Catch:{  }
        r0 = r6.ci;	 Catch:{  }
        r1 = 1;
        r0.setBroadcastInteractionChanges(r1);	 Catch:{  }
        r0 = r6.ci;	 Catch:{  }
        r1 = 2;
        r0.setOverScrollMode(r1);	 Catch:{  }
        r0 = r6.ci;	 Catch:{  }
        r1 = r6.bT;	 Catch:{  }
        android.support.v4.view.ViewCompat.a(r0, r1);	 Catch:{  }
        r0 = r6.bT;	 Catch:{  }
        r1 = r6.ci;	 Catch:{  }
        r0.b(r1);	 Catch:{  }
        r0 = "ThreadListFragment.onViewCreatedListenerSetup";
        r1 = -51561097; // 0xfffffffffced3d77 float:-9.854568E36 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0, r1);	 Catch:{  }
        r1 = r6.aX;	 Catch:{ all -> 0x01e2 }
        r0 = r6.mt_();	 Catch:{ all -> 0x01e2 }
        if (r0 == 0) goto L_0x01d7;
    L_0x011c:
        r0 = r6.mt_();	 Catch:{ all -> 0x01e2 }
        r4 = "PARAM_ENABLE_CONTEXT_MENU";
        r5 = 0;
        r0 = r0.getBoolean(r4, r5);	 Catch:{ all -> 0x01e2 }
        if (r0 == 0) goto L_0x01d7;
    L_0x0129:
        r0 = r2;
    L_0x012a:
        r1.m6271b(r0);	 Catch:{ all -> 0x01e2 }
        r0 = r6.ci;	 Catch:{ all -> 0x01e2 }
        r0.m();	 Catch:{ all -> 0x01e2 }
        r0 = r6.ci;	 Catch:{ all -> 0x01e2 }
        r1 = new com.facebook.orca.threadlist.ThreadListFragment$12;	 Catch:{ all -> 0x01e2 }
        r1.<init>(r6);	 Catch:{ all -> 0x01e2 }
        r0.a(r1);	 Catch:{ all -> 0x01e2 }
        r1 = r6.ci;	 Catch:{ all -> 0x01e2 }
        r0 = com.facebook.common.perftest.base.PerfTestConfigBase.a();	 Catch:{ all -> 0x01e2 }
        if (r0 == 0) goto L_0x01da;
    L_0x0144:
        r0 = new com.facebook.orca.threadlist.ThreadListFragment$ThreadListScrollListenerForPerfTesting;	 Catch:{ all -> 0x01e2 }
        r2 = 0;
        r0.<init>(r6);	 Catch:{ all -> 0x01e2 }
    L_0x014a:
        r1.a(r0);	 Catch:{ all -> 0x01e2 }
        r0 = r6.bS;	 Catch:{ all -> 0x01e2 }
        r0 = r0.b();	 Catch:{ all -> 0x01e2 }
        if (r0 == 0) goto L_0x0172;
    L_0x0155:
        r0 = r6.bQ;	 Catch:{ all -> 0x01e2 }
        r1 = new com.facebook.orca.threadlist.ThreadListFragment$13;	 Catch:{ all -> 0x01e2 }
        r1.<init>(r6);	 Catch:{ all -> 0x01e2 }
        r0 = r0.a(r1);	 Catch:{ all -> 0x01e2 }
        r6.cl = r0;	 Catch:{ all -> 0x01e2 }
        r0 = r6.cl;	 Catch:{ all -> 0x01e2 }
        r1 = r6.bR;	 Catch:{ all -> 0x01e2 }
        r1 = r1.a;	 Catch:{ all -> 0x01e2 }
        r0.a(r1);	 Catch:{ all -> 0x01e2 }
        r0 = r6.ci;	 Catch:{ all -> 0x01e2 }
        r1 = r6.cl;	 Catch:{ all -> 0x01e2 }
        r0.a(r1);	 Catch:{ all -> 0x01e2 }
    L_0x0172:
        r0 = 2131563827; // 0x7f0d1533 float:1.8753122E38 double:1.053132459E-314;
        r0 = r6.e(r0);	 Catch:{ all -> 0x01e2 }
        r0 = (com.facebook.widget.listview.EmptyListViewItem) r0;	 Catch:{ all -> 0x01e2 }
        r6.cn = r0;	 Catch:{ all -> 0x01e2 }
        r0 = r6.f6656e;	 Catch:{ all -> 0x01e2 }
        r1 = r6.F();	 Catch:{ all -> 0x01e2 }
        r2 = "messenger_thread_list";
        r0.a(r1, r2, r6);	 Catch:{ all -> 0x01e2 }
        r1 = r6.bb;	 Catch:{ all -> 0x01e2 }
        r0 = 2131565197; // 0x7f0d1a8d float:1.87559E38 double:1.0531331357E-314;
        r0 = r6.e(r0);	 Catch:{ all -> 0x01e2 }
        r0 = (android.view.ViewStub) r0;	 Catch:{ all -> 0x01e2 }
        r0 = r1.a(r0);	 Catch:{ all -> 0x01e2 }
        r1 = com.facebook.zero.sdk.common.ZeroFeatureKey.ZERO_INDICATOR;	 Catch:{ all -> 0x01e2 }
        r0 = r0.a(r1);	 Catch:{ all -> 0x01e2 }
        r0.c();	 Catch:{ all -> 0x01e2 }
        r0 = r6.ch;	 Catch:{ all -> 0x01e2 }
        r1 = new com.facebook.orca.threadlist.ThreadListFragment$14;	 Catch:{ all -> 0x01e2 }
        r1.<init>(r6);	 Catch:{ all -> 0x01e2 }
        r0.m6371a(r1);	 Catch:{ all -> 0x01e2 }
        r0 = 1403088620; // 0x53a16eec float:1.38670139E12 double:6.93217885E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);	 Catch:{  }
        r0 = 935227795; // 0x37be7193 float:2.2702652E-5 double:4.620639245E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        return;
    L_0x01b7:
        r0 = move-exception;
        r1 = 517495004; // 0x1ed858dc float:2.2906641E-20 double:2.556765034E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x01bf:
        r0 = move-exception;
        r1 = -775484039; // 0xffffffffd1c70d79 float:-1.06865566E11 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        throw r0;
    L_0x01c7:
        r0 = move-exception;
        r1 = 1279134388; // 0x4c3e0ab4 float:4.981832E7 double:6.319763575E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x01cf:
        r0 = move-exception;
        r1 = 1647595970; // 0x623451c2 float:8.315763E20 double:8.14020567E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x01d7:
        r0 = r3;
        goto L_0x012a;
    L_0x01da:
        r0 = new com.facebook.orca.threadlist.ThreadListFragment$MyOnScrollListener;	 Catch:{  }
        r2 = 0;
        r0.<init>(r6);	 Catch:{  }
        goto L_0x014a;
    L_0x01e2:
        r0 = move-exception;
        r1 = -141303815; // 0xfffffffff793dff9 float:-5.998518E33 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);	 Catch:{  }
        throw r0;	 Catch:{  }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.threadlist.ThreadListFragment.a(android.view.View, android.os.Bundle):void");
    }

    public static boolean m6353g(ThreadListFragment threadListFragment, int i) {
        if (i == -1) {
            return false;
        }
        InboxItem b = threadListFragment.aX.m6270b(i);
        if ((b instanceof InboxUnitThreadItem) && threadListFragment.s().c()) {
            ThreadSummary threadSummary = ((InboxUnitThreadItem) b).f6491g;
            m6350c(threadListFragment, "Long click on thread: " + threadSummary.a.i());
            if (ThreadKey.e(threadSummary.a)) {
                ((SmsTakeoverAnalyticsLogger) threadListFragment.bO.get()).a("long_press_promo_row", ((SmsPermissionsUtil) threadListFragment.bN.get()).b());
            }
            if (threadListFragment.aQ == Product.MESSENGER) {
                threadListFragment.aw();
            }
            MenuDialogFragment.a(((ThreadListContextMenuHelper) threadListFragment.bL.get()).m6275a(threadSummary, threadListFragment.cM).e()).a(threadListFragment.s(), "thread_menu_dialog");
            return true;
        }
        if (b instanceof InboxUnitItem) {
            InboxUnitItem inboxUnitItem = (InboxUnitItem) b;
            if (inboxUnitItem.k() != InboxUnitItem.b) {
                threadListFragment.m6344b(inboxUnitItem);
                return true;
            }
        }
        return false;
    }

    public static void bg(ThreadListFragment threadListFragment) {
        if (threadListFragment.T != null) {
            threadListFragment.cP.e();
            threadListFragment.cQ.e();
            threadListFragment.cm.setTranslationY(0.0f);
        }
    }

    private void aw() {
        boolean z = ((Boolean) this.aT.get()).booleanValue() && !ax();
        this.cM = z;
    }

    private boolean ax() {
        return ContextUtils.a(getContext(), Service.class) != null;
    }

    public final void m6362a(Fragment fragment) {
        super.a(fragment);
        if ("thread_menu_dialog".equals(fragment.J)) {
            ((MenuDialogFragment) fragment).an = new MenuDialogFragment.Listener(this) {
                final /* synthetic */ ThreadListFragment f6603a;

                {
                    this.f6603a = r1;
                }

                public final boolean m6286a(MenuDialogItem menuDialogItem, Object obj) {
                    if (!(obj instanceof Bundle)) {
                        return false;
                    }
                    return ThreadListFragment.m6341a(this.f6603a, menuDialogItem, (ThreadSummary) ((Bundle) obj).getParcelable("thread_summary"));
                }
            };
        } else if ("inbox2_dialog".equals(fragment.J)) {
            ((MenuDialogFragment) fragment).an = new MenuDialogFragment.Listener(this) {
                final /* synthetic */ ThreadListFragment f6604a;

                {
                    this.f6604a = r1;
                }

                public final boolean m6287a(MenuDialogItem menuDialogItem, Object obj) {
                    if (!(obj instanceof InboxUnitItem)) {
                        return false;
                    }
                    InboxUnitItem inboxUnitItem = (InboxUnitItem) obj;
                    ThreadListFragment threadListFragment = this.f6604a;
                    boolean z = true;
                    switch (menuDialogItem.a) {
                        case 1:
                            NodesModel nodesModel = inboxUnitItem.d;
                            InboxUnitConfirmHideSectionDialogFragment inboxUnitConfirmHideSectionDialogFragment = new InboxUnitConfirmHideSectionDialogFragment();
                            Bundle bundle = new Bundle();
                            FlatBufferModelHelper.a(bundle, "node", nodesModel);
                            inboxUnitConfirmHideSectionDialogFragment.g(bundle);
                            inboxUnitConfirmHideSectionDialogFragment.a(threadListFragment.s(), "inbox2_huc_dialog");
                            break;
                        case 2:
                            threadListFragment.bA.m2718a(inboxUnitItem);
                            break;
                        default:
                            z = false;
                            break;
                    }
                    return z;
                }
            };
        } else if ("inbox2_huc_dialog".equals(fragment.J)) {
            ((InboxUnitConfirmHideSectionDialogFragment) fragment).al = new Object(this) {
                public final /* synthetic */ ThreadListFragment f6605a;

                {
                    this.f6605a = r1;
                }
            };
        }
    }

    public final void m6366d(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -939586297);
        super.d(bundle);
        this.aX.f6573j = new Object(this) {
            public final /* synthetic */ ThreadListFragment f6606a;

            {
                this.f6606a = r1;
            }

            public final void m6288a(ThreadKey threadKey) {
                ThreadListItemClickListener threadListItemClickListener = this.f6606a.cI;
            }

            public final void m6289a(PhotoRemindersHeaderActionType photoRemindersHeaderActionType) {
                if (this.f6606a.bq.a() && this.f6606a.bt.get() != null && this.f6606a.bs != null) {
                    int i;
                    if (this.f6606a.cy == null) {
                        i = 0;
                    } else {
                        i = this.f6606a.cy.f3566a;
                    }
                    PhotoRemindersLogger photoRemindersLogger;
                    switch (photoRemindersHeaderActionType) {
                        case CLOSE:
                            photoRemindersLogger = this.f6606a.bs;
                            Integer.valueOf(i);
                            photoRemindersLogger.b.a(PhotoRemindersLogger.a("inbox_banner_dismissed").a("num_suggestions", i));
                            this.f6606a.bt.get();
                            this.f6606a.cy = null;
                            this.f6606a.cx = null;
                            this.f6606a.cV = true;
                            this.f6606a.ca.m6377a(Urgency.OTHER, "PhotoReminders");
                            return;
                        case CLICK:
                            photoRemindersLogger = this.f6606a.bs;
                            Integer.valueOf(i);
                            photoRemindersLogger.b.a(PhotoRemindersLogger.a("inbox_banner_clicked").a("num_suggestions", i));
                            this.f6606a.bt.get();
                            this.f6606a.getContext();
                            return;
                        default:
                            return;
                    }
                }
            }

            public final boolean m6291a(InboxRecentItem inboxRecentItem) {
                this.f6606a.m6344b((InboxUnitItem) inboxRecentItem);
                return true;
            }

            public final void m6290a(ImmutableSet<MediaResource> immutableSet, CameraRollInboxItem cameraRollInboxItem, int i, User user, FutureCallback<SendResult> futureCallback) {
                ThreadListFragment.m6336a(this.f6606a, ImmutableList.copyOf(immutableSet), user, (FutureCallback) futureCallback, ThreadListFragment.m6320a(this.f6606a, (InboxItem) cameraRollInboxItem));
                this.f6606a.bB.m2624a(cameraRollInboxItem, i);
            }
        };
        e(true);
        this.cJ = new OnSharedPreferenceChangeListener(this) {
            final /* synthetic */ ThreadListFragment f6607a;

            {
                this.f6607a = r1;
            }

            public final void m6292a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
                ThreadListFragment threadListFragment = this.f6607a;
                ThreadKey a = MessagingPrefKeys.a(prefKey);
                if (a != null) {
                    ThreadListFragment.m6329a(threadListFragment, a);
                }
            }
        };
        this.aq.c(MessagingPrefKeys.T, this.cJ);
        this.bh.a(5505045, bj(), (short) 46);
        if (this.bq.a()) {
            ((PhotoRemindersInboxDataLoader) this.br.get()).a(new Callback<Void, PhotoRemindersInboxData, Throwable>(this) {
                final /* synthetic */ ThreadListFragment f6609a;

                {
                    this.f6609a = r1;
                }

                public final void m6295a(Object obj, Object obj2) {
                    PhotoRemindersInboxData photoRemindersInboxData = (PhotoRemindersInboxData) obj2;
                    Integer.valueOf(photoRemindersInboxData == null ? 0 : photoRemindersInboxData.f3566a);
                    this.f6609a.cx = photoRemindersInboxData;
                }

                public final /* bridge */ /* synthetic */ void m6297c(Object obj, Object obj2) {
                }

                public final void m6296b(Object obj, Object obj2) {
                    this.f6609a.cV = true;
                    this.f6609a.ca.m6377a(Urgency.OTHER, "PhotoReminders");
                }
            });
        }
        this.bA.a(new Callback<InboxUnitLoader.Params, InboxUnitSnapshot, Throwable>(this) {
            final /* synthetic */ ThreadListFragment f6612a;

            {
                this.f6612a = r1;
            }

            public final void m6306a(Object obj, Object obj2) {
                InboxUnitLoader.Params params = (InboxUnitLoader.Params) obj;
                this.f6612a.cG = (InboxUnitSnapshot) obj2;
                this.f6612a.cV = true;
                this.f6612a.ca.m6377a(params.f2763a == LoadBehavior.DEFAULT_WITH_TOP_UNITS_FIRST ? Urgency.INBOX_TOP_UNITS : Urgency.OTHER, "Inbox2");
            }

            public final /* bridge */ /* synthetic */ void m6308c(Object obj, Object obj2) {
            }

            public final void m6307b(Object obj, Object obj2) {
                this.f6612a.cH = true;
            }
        });
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1129703321, a);
    }

    public static void az(ThreadListFragment threadListFragment) {
        ((MessageRequestsHeaderLoader) threadListFragment.al.get()).a(new Callback<Void, MessageRequestsSnippet, Throwable>(threadListFragment) {
            final /* synthetic */ ThreadListFragment f6610a;

            {
                this.f6610a = r1;
            }

            public final void m6300b(Object obj, @Nullable Object obj2) {
                obj2 = (MessageRequestsSnippet) obj2;
                ThreadListFragment threadListFragment = this.f6610a;
                if (obj2 == null || obj2.f3257a <= 0) {
                    obj2 = null;
                }
                threadListFragment.cA = obj2;
                this.f6610a.cB = true;
                this.f6610a.cV = true;
                this.f6610a.ca.m6377a(Urgency.OTHER, "MessageRequests");
            }

            public final /* bridge */ /* synthetic */ void m6301c(Object obj, Object obj2) {
            }
        });
    }

    public static void m6335a(ThreadListFragment threadListFragment, ImmutableList immutableList, NavigationTrigger navigationTrigger) {
        Message a = threadListFragment.bU.a(null, immutableList, Long.toString(threadListFragment.bV.a()));
        Intent intent = new Intent();
        intent.setAction(MessagingIntentUris.a);
        intent.setData(Uri.parse(MessengerLinks.o));
        intent.putExtra("ShareType", "ShareType.newMessage");
        intent.putExtra("message", a);
        intent.putExtra("trigger2", navigationTrigger);
        ((SecureContextHelper) threadListFragment.bF.get()).a(intent, threadListFragment.getContext());
    }

    public static void m6336a(ThreadListFragment threadListFragment, ImmutableList immutableList, User user, FutureCallback futureCallback, NavigationTrigger navigationTrigger) {
        threadListFragment.m6324a(threadListFragment.bU.a(((DefaultThreadKeyFactory) threadListFragment.bZ.get()).a(user.T), immutableList, Long.toString(threadListFragment.bV.a())), futureCallback, navigationTrigger);
    }

    public static void m6337a(ThreadListFragment threadListFragment, String str, User user, FutureCallback futureCallback, NavigationTrigger navigationTrigger) {
        ThreadKey a = ((DefaultThreadKeyFactory) threadListFragment.bZ.get()).a(user.T);
        ShareBuilder shareBuilder = new ShareBuilder();
        shareBuilder.a = str;
        threadListFragment.m6324a(threadListFragment.bU.a(a, "", shareBuilder.n(), null), futureCallback, navigationTrigger);
    }

    private void m6324a(Message message, FutureCallback<SendResult> futureCallback, NavigationTrigger navigationTrigger) {
        Futures.a(((SendMessageManager) this.bY.get()).a(message, "", navigationTrigger, null), futureCallback, this.bd);
    }

    public static void aD(ThreadListFragment threadListFragment) {
        try {
            AssetFileDescriptor openRawResourceFd = threadListFragment.jW_().openRawResourceFd(2131165299);
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
            openRawResourceFd.close();
            mediaPlayer.setAudioStreamType(1);
            mediaPlayer.setVolume(0.3f, 0.3f);
            mediaPlayer.setOnCompletionListener(new OnCompletionListener(threadListFragment) {
                final /* synthetic */ ThreadListFragment f6613a;

                {
                    this.f6613a = r1;
                }

                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (Throwable th) {
        }
    }

    public static boolean m6341a(ThreadListFragment threadListFragment, MenuDialogItem menuDialogItem, final ThreadSummary threadSummary) {
        int i = menuDialogItem.a;
        String str = menuDialogItem.d;
        if (str == null) {
            str = "not recognized";
        }
        threadListFragment.aN.a(threadListFragment.ao(), "context_menu_item", str, null);
        m6350c(threadListFragment, "CLick on Menu Item: " + str);
        if (threadListFragment.ce != null && threadListFragment.ce.m6315a()) {
            return true;
        }
        switch (i) {
            case 0:
                if (!ThreadKey.d(threadSummary.a)) {
                    threadListFragment.m6364a(threadSummary);
                } else if (threadSummary != null && ThreadKey.d(threadSummary.a)) {
                    if (threadListFragment.aq.a(MessagingPrefKeys.an, false)) {
                        m6351e(threadListFragment, threadSummary);
                    } else {
                        ((SmsTakeoverAnalyticsLogger) threadListFragment.bO.get()).d("ThreadListFragment");
                        new FbAlertDialogBuilder(threadListFragment.bE).a(2131232354).b(2131232355).a(2131232356, new OnClickListener(threadListFragment) {
                            final /* synthetic */ ThreadListFragment f6631b;

                            public void onClick(DialogInterface dialogInterface, int i) {
                                ((SmsTakeoverAnalyticsLogger) this.f6631b.bO.get()).e("ThreadListFragment");
                                ThreadListFragment.m6351e(this.f6631b, threadSummary);
                            }
                        }).b(2131232357, new OnClickListener(threadListFragment) {
                            final /* synthetic */ ThreadListFragment f6629a;

                            {
                                this.f6629a = r1;
                            }

                            public void onClick(DialogInterface dialogInterface, int i) {
                                ((SmsTakeoverAnalyticsLogger) this.f6629a.bO.get()).f("ThreadListFragment");
                                Intent intent = new Intent(this.f6629a.getContext(), NeueSmsPreferenceActivity.class);
                                intent.putExtra("analytics_caller_context", SmsCallerContext.SETTINGS_FROM_THREAD_DELETE_CONFIRMATION_DIALOG);
                                ((SecureContextHelper) this.f6629a.bF.get()).a(intent, this.f6629a.getContext());
                            }
                        }).a().show();
                        threadListFragment.aq.edit().putBoolean(MessagingPrefKeys.an, true).commit();
                    }
                }
                return true;
            case 1:
                ((ArchiveThreadManager) threadListFragment.au.get()).a(threadSummary);
                threadListFragment.cV = true;
                threadListFragment.ca.m6377a(Urgency.USER_ACTION, "archiveThread");
                return true;
            case 2:
                threadListFragment.m6348c(threadSummary);
                return true;
            case 3:
                ThreadNotificationsDialogFragment.m3248a(threadSummary.a).a(threadListFragment.kO_(), "notificationSettingsDialog");
                return true;
            case 4:
                ((GroupsAdminLogger) threadListFragment.ar.get()).m2350a(threadSummary, "thread_list_context_menu");
                ((GroupThreadActionHandler) threadListFragment.bP.get()).m2575a(threadListFragment.D, threadSummary);
                return true;
            case 5:
                ((MessengerShortcutHelper) threadListFragment.ay.get()).m3758a(threadSummary, "context_menu_click");
                return true;
            case 6:
                threadListFragment.m6352g(threadSummary);
                return true;
            case 7:
                ((NotificationSettingsUtil) threadListFragment.az.get()).b(threadSummary.a);
                threadListFragment.C();
                return true;
            case 8:
                if (((SmsDefaultAppManager) threadListFragment.bM.get()).a(threadSummary.a)) {
                    ((SmsDefaultAppManager) threadListFragment.bM.get()).a(SmsCallerContext.MARK_READ, new Runnable(threadListFragment) {
                        final /* synthetic */ ThreadListFragment f6615b;

                        public void run() {
                            ((ReadThreadManager) this.f6615b.aB.get()).a(threadSummary);
                        }
                    });
                } else {
                    ((ReadThreadManager) threadListFragment.aB.get()).a(threadSummary);
                }
                return true;
            case 9:
                if (((SmsDefaultAppManager) threadListFragment.bM.get()).a(threadSummary.a)) {
                    ((SmsDefaultAppManager) threadListFragment.bM.get()).a(SmsCallerContext.MARK_UNREAD, new Runnable(threadListFragment) {
                        final /* synthetic */ ThreadListFragment f6617b;

                        public void run() {
                            ((ReadThreadManager) this.f6617b.aB.get()).b(threadSummary);
                        }
                    });
                } else {
                    ((ReadThreadManager) threadListFragment.aB.get()).b(threadSummary);
                }
                return true;
            case 10:
                threadListFragment.m6354h(threadSummary);
                return true;
            case 11:
                ((SmsTakeoverAnalyticsLogger) threadListFragment.bO.get()).a("context_menu_promo_row_dismiss", ((SmsPermissionsUtil) threadListFragment.bN.get()).b());
                SmsDefaultAppManager smsDefaultAppManager = (SmsDefaultAppManager) threadListFragment.bM.get();
                smsDefaultAppManager.e.edit().putBoolean(SmsPrefKeys.d, false).commit();
                ((MmsSmsCacheUpdateAction) smsDefaultAppManager.j.get()).a();
                return true;
            case 12:
                boolean b = ((SmsPermissionsUtil) threadListFragment.bN.get()).b();
                ((SmsTakeoverAnalyticsLogger) threadListFragment.bO.get()).a("context_menu_promo_row_enable", b);
                if (b) {
                    ((SmsDefaultAppManager) threadListFragment.bM.get()).a(SmsCallerContext.ANONYMOUS_ROW);
                } else {
                    ((SmsDefaultAppManager) threadListFragment.bM.get()).a(SmsCallerContext.ANONYMOUS_ROW, null);
                }
                return true;
            default:
                return false;
        }
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1283462764);
        this.ch = null;
        this.cb.m6114a();
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 18086095, a);
    }

    public final void m6359I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 653514323);
        super.I();
        if (this.cT != null) {
            this.cT.m4482a();
        }
        if (this.aY != null) {
            FutureDetour.a(this.cr, Boolean.valueOf(true), 937059110);
            this.aY.m6415a();
        }
        this.cc.f6699m.clear();
        if (this.aX != null) {
            this.aX.m6268a((List) RegularImmutableList.a);
        }
        if (this.bq.a() && this.br.get() != null) {
            ((PhotoRemindersInboxDataLoader) this.br.get()).a();
        }
        if (this.al.get() != null) {
            ((MessageRequestsHeaderLoader) this.al.get()).a();
        }
        if (this.aL.get() != null) {
            MontageInboxComposerLoader montageInboxComposerLoader = (MontageInboxComposerLoader) this.aL.get();
            montageInboxComposerLoader.f3309i = null;
            if (montageInboxComposerLoader.f3308h != null) {
                montageInboxComposerLoader.f3308h.a(false);
                montageInboxComposerLoader.f3308h = null;
            }
        }
        if (this.bA != null) {
            this.bA.a();
        }
        this.ct.clear();
        this.cw = false;
        this.cs.c();
        if (!(this.aq == null || this.cJ == null)) {
            this.aq.d(MessagingPrefKeys.T, this.cJ);
        }
        if (this.cR != null) {
            this.cR.a(true);
            this.cR = null;
        }
        this.bo.b(null);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 384075358, a);
    }

    public final void dE_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 350293289);
        super.dE_();
        this.cC = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2117724854, a);
    }

    public final void m6357G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1083801977);
        super.G();
        aE();
        this.ca.m6376a();
        bi();
        aw();
        this.f6660i.a();
        this.cv = false;
        ViewCompat.a(this.ci, this.bT);
        this.bT.d = this.ci;
        if (au(this) == Result.f6713a) {
            this.f6654c.a(this.cr);
            this.cN.postDelayed(new Runnable(this) {
                final /* synthetic */ ThreadListFragment f6618a;

                {
                    this.f6618a = r1;
                }

                public void run() {
                    FutureDetour.a(this.f6618a.cr, Boolean.valueOf(true), -611552865);
                }
            }, 2000);
            m6331a(this, RefreshType.AUTOMATIC_REFRESH, "onResume");
        }
        if (this.bq.c()) {
            ((PhotoRemindersInboxDataLoader) this.br.get()).a(null);
        }
        if (aM(this)) {
            if (!this.cH) {
                this.bA.a(new InboxUnitLoader.Params(aP() ? LoadBehavior.DEFAULT_WITH_TOP_UNITS_FIRST : LoadBehavior.DEFAULT));
            }
        } else if (!this.cB) {
            az(this);
            ((MessageRequestsHeaderLoader) this.al.get()).f3227c = true;
            ((MessageRequestsHeaderLoader) this.al.get()).a(null);
        }
        if (!(this.aQ != Product.MESSENGER || ((Boolean) this.bI.get()).booleanValue() || bd())) {
            this.f6654c.a("maybeShowPromotionHeader", new Runnable(this) {
                final /* synthetic */ ThreadListFragment f6619a;

                {
                    this.f6619a = r1;
                }

                public void run() {
                    if (!ThreadListFragment.bl(this.f6619a)) {
                        ThreadListFragment.m6327a(this.f6619a, QuickPromotionTriggers.f3781a);
                    }
                }
            }, Priority.APPLICATION_LOADED_UI_IDLE, ThreadType.UI);
        }
        if (this.aQ == Product.MESSENGER && !bc(this)) {
            this.f6654c.a("maybeShowThreadListTooltip", new Runnable(this) {
                final /* synthetic */ ThreadListFragment f6620a;

                {
                    this.f6620a = r1;
                }

                public void run() {
                    ThreadListFragment threadListFragment = this.f6620a;
                    ThreadListTooltip threadListTooltip = threadListFragment.aZ;
                    boolean z = true;
                    boolean a = threadListTooltip.f6740c.a(MessagingPrefKeys.ag, true);
                    boolean a2 = threadListTooltip.f6740c.a(MessagingPrefKeys.ah, true);
                    if (!(threadListTooltip.f6738a.a.a(ExperimentsForBadgesModule.b, false) && (a || a2))) {
                        z = false;
                    }
                    if (z) {
                        ThreadKey threadKey;
                        int l = threadListFragment.cj.l();
                        int n = threadListFragment.cj.n();
                        for (int i = l; i <= n; i++) {
                            View a3 = WrappingListItemViewUtil.a(threadListFragment.ci.getChildAt(i));
                            if (a3 instanceof ThreadItemView) {
                                threadKey = ((ThreadItemView) a3).getThreadKey();
                                break;
                            }
                        }
                        threadKey = null;
                        threadListFragment.aZ.m6426a(threadKey, threadListFragment.T, 2131564465);
                    }
                }
            }, Priority.APPLICATION_LOADED_UI_IDLE, ThreadType.UI);
        }
        this.bb.a();
        if (this.bq.a() && this.bq.c() && this.bt.get() != null) {
            if (this.cz == null) {
                this.cz = new Object(this) {
                    final /* synthetic */ ThreadListFragment f6639a;

                    {
                        this.f6639a = r1;
                    }
                };
            }
            this.bt.get();
        }
        this.ca.m6378b();
        this.bh.a(5505045, bj());
        this.aO.c(3604482, "ThreadListFragment.onCreateThroughOnResume");
        boolean z = D() && !bh();
        if (this.cF != null) {
            this.cF.m2615a(true);
            this.cF.m2616b(z);
        }
        if (this.cE != null) {
            this.cE.m2591a(true);
            this.cE.m2593b(z);
        }
        if (this.cl != null) {
            this.cl.c = true;
            this.cl.d = z;
        }
        this.ca.m6378b();
        LogUtils.f(-846462239, a);
    }

    private boolean aE() {
        return D() && z() && !bh();
    }

    public final void m6358H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -228304656);
        super.H();
        if (this.cT != null) {
            this.cT.m4482a();
        }
        if (this.bq.a() && this.bt.get() != null) {
            this.bt.get();
        }
        this.bg.k();
        this.aF.a(new Intent(MessagesBroadcastIntents.i));
        this.bb.b();
        this.bh.b();
        this.bT.b();
        this.aO.a(3604482, "ThreadListFragment.onCreateThroughOnResume");
        if (this.cF != null) {
            this.cF.m2615a(false);
        }
        if (this.cE != null) {
            this.cE.m2591a(false);
        }
        if (this.cl != null) {
            this.cl.c = false;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 845428362, a);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 688483605);
        this.bh.a(5505045, bj(), "onStart");
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(f6653b);
            hasTitleBar.kg_();
        }
        this.bh.a(5505045, bj(), (short) 47);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1946752967, a);
    }

    public final void m6361a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (this.bq.a() && this.bt.get() != null) {
            this.bt.get();
        }
    }

    public static void m6331a(ThreadListFragment threadListFragment, RefreshType refreshType, String str) {
        if (!threadListFragment.cb.f6415J) {
            if (aM(threadListFragment) && refreshType == RefreshType.EXPLICIT_USER_REFRESH) {
                m6338a(threadListFragment, true, str);
            }
            if (refreshType != RefreshType.EXPLICIT_USER_REFRESH || !((Boolean) threadListFragment.aU.get()).booleanValue()) {
                threadListFragment.cq = FolderName.INBOX;
                threadListFragment.aY.m6417a(threadListFragment.cq);
                threadListFragment.aY.m6419a(refreshType.getThreadListLoaderParams(threadListFragment.cb.f6410E));
            } else if (threadListFragment.cR == null) {
                OperationFuture a = BlueServiceOperationFactoryDetour.a(threadListFragment.f6658g, "ensure_sync", SyncOperationParamsUtil.a(ConnectionFreshness.REFRESH_CONNECTION), CallerContext.a(threadListFragment.getClass()), -2133475867).a();
                AnonymousClass30 anonymousClass30 = new AbstractDisposableFutureCallback<OperationResult>(threadListFragment) {
                    final /* synthetic */ ThreadListFragment f6622a;

                    {
                        this.f6622a = r1;
                    }

                    public final void m6309a(Object obj) {
                        this.f6622a.cR = null;
                        if (this.f6622a.ch != null) {
                            this.f6622a.ch.m6372b();
                        }
                    }

                    public final void m6310a(Throwable th) {
                        this.f6622a.ap.a("ThreadListFragment", "Failed sync refresh", th);
                        this.f6622a.cR = null;
                        if (this.f6622a.ch != null) {
                            this.f6622a.ch.m6372b();
                        }
                    }
                };
                threadListFragment.cR = FutureAndCallbackHolder.a(a, anonymousClass30);
                Futures.a(a, anonymousClass30);
            }
            if (threadListFragment.aM.b()) {
                ((MontageInboxComposerLoader) threadListFragment.aL.get()).m3216a(new AbstractFbLoaderCallback<MontageInboxComposerLoader.Params, MontageInboxComposerData, Throwable>(threadListFragment) {
                    final /* synthetic */ ThreadListFragment f6611a;

                    {
                        this.f6611a = r1;
                    }

                    public final void m6302a(Object obj, Object obj2) {
                        this.f6611a.cD = (MontageInboxComposerData) obj2;
                        this.f6611a.cV = true;
                        this.f6611a.ca.m6377a(Urgency.OTHER, "MontageInboxComposer");
                    }

                    public final /* bridge */ /* synthetic */ void m6303b(Object obj, Object obj2) {
                    }

                    public final /* bridge */ /* synthetic */ void m6304c(Object obj, Object obj2) {
                    }
                });
                boolean equals = RefreshType.EXPLICIT_USER_REFRESH.equals(refreshType);
                ((MontageInboxComposerLoader) threadListFragment.aL.get()).m3217a(new MontageInboxComposerLoader.Params(equals, equals));
            }
        }
    }

    public static void m6338a(ThreadListFragment threadListFragment, boolean z, String str) {
        Boolean.valueOf(z);
        threadListFragment.cG = null;
        threadListFragment.cH = false;
        threadListFragment.bA.a(new InboxUnitLoader.Params(z ? LoadBehavior.FORCE_SERVER_FETCH : LoadBehavior.DEFAULT));
    }

    private void aG() {
        if (!this.cb.f6415J) {
            boolean z = false;
            boolean z2 = true;
            this.aY.m6419a(new Params(z, z2, LoadType.MORE_THREADS, this.cb.f6410E, false, f6652a));
        }
    }

    public static void m6329a(ThreadListFragment threadListFragment, ThreadKey threadKey) {
        if (threadListFragment.ci != null) {
            for (int i = 0; i < threadListFragment.ci.getChildCount(); i++) {
                View a = WrappingListItemViewUtil.a(threadListFragment.ci.getChildAt(i));
                if (a instanceof ThreadItemView) {
                    ThreadItemView threadItemView = (ThreadItemView) a;
                    if (threadKey.equals(threadItemView.getThreadKey())) {
                        threadItemView.m6236a();
                    }
                }
            }
        }
    }

    public static void aH(ThreadListFragment threadListFragment) {
        LoaderState aL = threadListFragment.aL();
        if (aL == LoaderState.UNITS_LOADING && threadListFragment.cS == null) {
            long a = (threadListFragment.bA.f2767d + 8000) - threadListFragment.bJ.a();
            Long.valueOf(a);
            threadListFragment.cS = threadListFragment.be.schedule(new Runnable(threadListFragment) {
                final /* synthetic */ ThreadListFragment f6623a;

                {
                    this.f6623a = r1;
                }

                public void run() {
                    this.f6623a.cS = null;
                    ThreadListFragment.aH(this.f6623a);
                }
            }, a, TimeUnit.MILLISECONDS);
        } else if (aL.isReady() && threadListFragment.cS != null) {
            threadListFragment.cS.cancel(false);
            threadListFragment.cS = null;
        }
        if (threadListFragment.cV) {
            threadListFragment.aK();
            threadListFragment.m6326a(aL);
            threadListFragment.cV = false;
        }
        threadListFragment.m6349c(aL);
        threadListFragment.aJ();
        if (!threadListFragment.aQ()) {
            Integer.valueOf(au(threadListFragment).f6714b.e());
        }
        threadListFragment.ci.post(new Runnable(threadListFragment) {
            final /* synthetic */ ThreadListFragment f6624a;

            {
                this.f6624a = r1;
            }

            public void run() {
                if (this.f6624a.cl != null) {
                    this.f6624a.cl.a(this.f6624a.cj, this.f6624a.aX);
                }
                ThreadListFragment.aU(this.f6624a);
            }
        });
    }

    private void m6326a(LoaderState loaderState) {
        List list;
        this.cy = this.cx;
        if (aM(this)) {
            ImmutableList a;
            if (loaderState.isReady()) {
                Result au = au(this);
                a = this.by.m6132a(this.cG, this.bx.m6282a((Iterable) au.f6714b.c), this.cE.m2592b(), this.cD, this.cy, au.f6714b.d, this.cv);
            } else {
                a = RegularImmutableList.a;
            }
            list = a;
        } else {
            list = aI();
        }
        boolean a2 = this.by.m6134a(this.cG);
        this.ck.f4715h = a2;
        this.aX.f6575l = a2;
        this.aX.m6268a(list);
    }

    private ImmutableList<InboxItem> aI() {
        Object obj;
        MessageRequestsSnippet messageRequestsSnippet;
        PhotoRemindersInboxData photoRemindersInboxData;
        Result au = au(this);
        if (this.cb.f6410E == ThreadTypeFilter.SMS) {
            obj = 1;
        } else {
            obj = null;
        }
        InboxItemCreator inboxItemCreator = this.by;
        Iterable<ThreadSummary> a = this.bx.m6282a((Iterable) au.f6714b.c);
        if (obj != null) {
            messageRequestsSnippet = null;
        } else {
            messageRequestsSnippet = this.cA;
        }
        if (obj != null) {
            photoRemindersInboxData = null;
        } else {
            photoRemindersInboxData = this.cy;
        }
        boolean z = au.f6714b.d;
        RowListBuilder rowListBuilder = new RowListBuilder();
        if (photoRemindersInboxData != null) {
            InboxItemHelper.m6136a(rowListBuilder, InboxItemCreator.m6124a(photoRemindersInboxData));
        }
        if (messageRequestsSnippet != null) {
            inboxItemCreator.f6466b.m6143b(rowListBuilder, InboxItemCreator.m6123a(messageRequestsSnippet), false);
        }
        InboxUnit b = InboxItemCreator.m6129b();
        for (ThreadSummary a2 : a) {
            rowListBuilder.m6118a(inboxItemCreator.f6466b.m6139a(b.f2735b, a2));
        }
        if (!z) {
            rowListBuilder.m6118a(new InboxLoadMorePlaceholderItem(b.f2735b));
        }
        return rowListBuilder.m6120b();
    }

    private void m6349c(LoaderState loaderState) {
        if (!loaderState.isReady()) {
            this.cn.setVisibility(0);
            this.cn.a(true);
        } else if (this.cu == null || !au(this).m6399a()) {
            this.cn.setVisibility(8);
            if (aQ()) {
                this.aH.c("thread_list");
                if (this.co == null) {
                    RecentsTabEmptyView recentsTabEmptyView = (RecentsTabEmptyView) LayoutInflater.from(this.cL).inflate(2130905789, this.cm, false);
                    this.cm.addView(recentsTabEmptyView, 0);
                    recentsTabEmptyView.f3357b = this.cf;
                    MessagingNullStatesLogger messagingNullStatesLogger = (MessagingNullStatesLogger) this.ax.get();
                    HoneyClientEvent honeyClientEvent = new HoneyClientEvent("recents_tab_null_state_shown");
                    honeyClientEvent.c = "thread_list";
                    messagingNullStatesLogger.f3350a.c(honeyClientEvent);
                    this.co = recentsTabEmptyView;
                    this.cO.setVisibility(8);
                }
                return;
            }
        } else {
            this.cn.setVisibility(0);
            this.cn.setMessage(m6343b(((ErrorMessageGenerator) this.av.get()).a(this.cu.f6705a, false, true)));
            this.cn.a(false);
        }
        if (this.co != null) {
            this.cm.removeView(this.co);
            this.co = null;
        }
        if (!this.cb.f6415J && this.cO.getVisibility() != 0) {
            this.cO.setVisibility(0);
        }
    }

    private void aJ() {
        this.aX.m6267a(this.cp ? LoadMoreState.LOAD_MORE_AUTOMATICALLY_DISABLED : LoadMoreState.LOAD_MORE_AUTOMATICALLY_ENABLED);
    }

    private void aK() {
        if (this.cX != null && !this.cX.isEmpty() && this.bT.d != null) {
            List a = Lists.a();
            ImmutableList immutableList = au(this).f6714b.c;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                ThreadSummary threadSummary = (ThreadSummary) immutableList.get(i);
                if (this.cX.contains(threadSummary.a)) {
                    a.add(threadSummary);
                }
            }
            if (!a.isEmpty() && aE()) {
                this.bT.a(a);
            }
            this.cX.clear();
        }
    }

    private LoaderState aL() {
        if (aM(this)) {
            return aO();
        }
        LoaderState loaderState;
        Result au = au(this);
        if (!au.m6399a()) {
            loaderState = LoaderState.READY_WITH_THREADS;
        } else if (this.aY.m6421b()) {
            loaderState = LoaderState.THREADS_LOADING;
        } else if (au.f6717e.r.asBoolean(false)) {
            loaderState = LoaderState.THREADS_LOADING;
        } else if (this.cb.f6410E == ThreadTypeFilter.SMS) {
            loaderState = LoaderState.READY_WITH_THREADS;
        } else if (this.bq.a() && this.cx == null && ((PhotoRemindersInboxDataLoader) this.br.get()).b()) {
            loaderState = LoaderState.OTHER_LOADING;
        } else if (this.cA == null && ((MessageRequestsHeaderLoader) this.al.get()).b()) {
            loaderState = LoaderState.OTHER_LOADING;
        } else {
            if (this.cD == null) {
                Object obj;
                if (((MontageInboxComposerLoader) this.aL.get()).f3308h != null) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    loaderState = LoaderState.OTHER_LOADING;
                }
            }
            loaderState = LoaderState.READY_WITH_THREADS;
        }
        return loaderState;
    }

    public static boolean aM(ThreadListFragment threadListFragment) {
        return threadListFragment.cb.f6410E == ThreadTypeFilter.ALL && threadListFragment.bz.f6597b;
    }

    private LoaderState aO() {
        boolean z;
        boolean z2 = false;
        Result au = au(this);
        if (aP()) {
            if (!(au.m6399a() || this.cG == null)) {
                return LoaderState.READY_WITH_THREADS_AND_UNITS;
            }
        } else if (!au.m6399a()) {
            return LoaderState.READY_WITH_THREADS;
        }
        if (this.aY.m6421b()) {
            z = true;
        } else if (au.f6717e.r.asBoolean(false)) {
            z = true;
        } else {
            z = false;
        }
        if (this.cG == null && this.bA.b() && this.bJ.a() - this.bA.f2767d < 8000) {
            z2 = true;
        }
        if (z2 && z) {
            return LoaderState.THREADS_AND_UNITS_LOADING;
        }
        if (z) {
            return LoaderState.THREADS_LOADING;
        }
        if (z2) {
            return LoaderState.UNITS_LOADING;
        }
        return LoaderState.READY_WITH_THREADS_AND_UNITS;
    }

    private boolean aP() {
        if (this.bz.f6596a.a(243, false)) {
            InboxUnitLoader inboxUnitLoader = this.bA;
            Object obj = (inboxUnitLoader.f2765b.mo78a().contains(InboxUnitsToFetch.TOP) && inboxUnitLoader.f2765b.mo81b()) ? 1 : null;
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    private boolean aQ() {
        if (!au(this).m6399a()) {
            return false;
        }
        if (this.cy != null && this.cy.f3566a > 0) {
            return false;
        }
        if (this.cA != null && this.cA.f3257a > 0) {
            return false;
        }
        if ((this.cG == null || this.cG.f2757d.isEmpty()) && !this.cb.f6415J) {
            return true;
        }
        return false;
    }

    public static void m6355h(ThreadListFragment threadListFragment, final int i) {
        if (i != -1) {
            final InboxItem b = threadListFragment.aX.m6270b(i);
            if (b != null) {
                b.getClass().getSimpleName();
                threadListFragment.aN.a(b.d());
                if (b instanceof InboxUnitThreadItem) {
                    final ThreadSummary threadSummary = ((InboxUnitThreadItem) b).f6491g;
                    if (ThreadKey.e(threadSummary.a)) {
                        boolean b2 = ((SmsPermissionsUtil) threadListFragment.bN.get()).b();
                        ((SmsTakeoverAnalyticsLogger) threadListFragment.bO.get()).a("click_promo_row", b2);
                        if (b2) {
                            ((SmsDefaultAppManager) threadListFragment.bM.get()).a(SmsCallerContext.ANONYMOUS_ROW);
                        } else {
                            ((SmsDefaultAppManager) threadListFragment.bM.get()).a(SmsCallerContext.ANONYMOUS_ROW, null);
                        }
                    } else if (threadSummary.y && ((ThreadUnreadCountUtil) threadListFragment.aC.get()).a(threadSummary) && threadListFragment.m6347b(threadSummary) && ((Boolean) threadListFragment.bm.get()).booleanValue()) {
                        String string;
                        String str = StringUtil.a(threadSummary.p) ? threadSummary.q : threadSummary.p;
                        User a = threadListFragment.bW.a(threadSummary.r.b);
                        if (a == null || a.h() == null) {
                            string = threadListFragment.getContext().getString(2131232148);
                        } else {
                            string = threadListFragment.getContext().getString(2131232147, new Object[]{a.h()});
                        }
                        ((RtcCallHandler) threadListFragment.aD.get()).a(threadListFragment.cL, threadSummary.r.b, string, str, threadListFragment.getContext().getString(2131232149), true, "thread_summary", new OnClickListener(threadListFragment) {
                            final /* synthetic */ ThreadListFragment f6628d;

                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                ThreadListFragment.m6330a(this.f6628d, threadSummary, i, (InboxUnitThreadItem) b);
                            }
                        });
                    } else {
                        m6330a(threadListFragment, threadSummary, i, (InboxUnitThreadItem) b);
                    }
                } else if (b instanceof InboxMoreThreadsItem) {
                    InboxMoreThreadsItem inboxMoreThreadsItem = (InboxMoreThreadsItem) b;
                    if (threadListFragment.by.m6133a()) {
                        threadListFragment.cV = true;
                        threadListFragment.ca.m6377a(Urgency.USER_ACTION, "see_more");
                    } else if (inboxMoreThreadsItem.f2851f == MoreThreadsType.LOAD_MORE) {
                        threadListFragment.aG();
                    }
                } else if (b instanceof InboxUnitConversationStarterItem) {
                    threadListFragment.bu.m2125a(((InboxUnitConversationStarterItem) b).f6486f);
                } else if (b instanceof InboxUnitMessageRequestsItem) {
                    if (threadListFragment.cI != null) {
                    }
                } else if (b instanceof InboxUnitActiveNowItem) {
                    InboxUnitActiveNowItem inboxUnitActiveNowItem = (InboxUnitActiveNowItem) b;
                    if (threadListFragment.cI != null) {
                        ContactPickerUserRow contactPickerUserRow = inboxUnitActiveNowItem.f6483f;
                    }
                } else if (b instanceof InboxUnitMontageComposerItem) {
                    aT(threadListFragment);
                } else if (b instanceof InboxGenericMoreItem) {
                    threadListFragment.m6323a((InboxGenericMoreItem) b);
                }
                if (aM(threadListFragment) && b.e()) {
                    threadListFragment.cF.f2634b.m2624a(b, i);
                }
            }
        }
    }

    private void m6323a(InboxUnitItem inboxUnitItem) {
        inboxUnitItem.d.r();
        GraphQLMessengerInboxUnitType graphQLMessengerInboxUnitType = GraphQLMessengerInboxUnitType.ACTIVE_NOW;
    }

    private boolean m6347b(ThreadSummary threadSummary) {
        if (!threadSummary.y || threadSummary.r == null) {
            return false;
        }
        return !Objects.equal(threadSummary.r.b, ((User) this.aV.get()).T);
    }

    public static void m6330a(ThreadListFragment threadListFragment, ThreadSummary threadSummary, int i, InboxUnitThreadItem inboxUnitThreadItem) {
        threadListFragment.ci.getChildCount();
        if (threadListFragment.cI != null) {
            ThreadKey threadKey = threadSummary.a;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("click");
            honeyClientEvent.d = "thread";
            honeyClientEvent = honeyClientEvent;
            honeyClientEvent.e = threadKey.toString();
            honeyClientEvent = honeyClientEvent;
            honeyClientEvent.c = bb(threadListFragment);
            threadListFragment.f6655d.a(honeyClientEvent);
            m6320a(threadListFragment, (InboxItem) inboxUnitThreadItem);
            return;
        }
        threadListFragment.ap.a("ThreadListFragment_no_listener", "No listener for navigate to thread");
    }

    public static void aT(ThreadListFragment threadListFragment) {
        Object obj;
        if (threadListFragment.cC == null) {
            MontageComposerControllerProvider montageComposerControllerProvider = threadListFragment.aK;
            threadListFragment.cC = new MontageComposerController(threadListFragment.D, (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(montageComposerControllerProvider), (MontageCanvasViewUtilProvider) montageComposerControllerProvider.getOnDemandAssistedProviderForStaticDi(MontageCanvasViewUtilProvider.class), MontageComposerFragmentFactory.a(montageComposerControllerProvider), (MontageComposerNavigationControllerProvider) montageComposerControllerProvider.getOnDemandAssistedProviderForStaticDi(MontageComposerNavigationControllerProvider.class), MontageMessageFactory.b(montageComposerControllerProvider), (MontageSendUtilProvider) montageComposerControllerProvider.getOnDemandAssistedProviderForStaticDi(MontageSendUtilProvider.class), (MultimediaEditorControllerProvider) montageComposerControllerProvider.getOnDemandAssistedProviderForStaticDi(MultimediaEditorControllerProvider.class), SpringSystem.b(montageComposerControllerProvider));
        }
        MontageComposerController montageComposerController = threadListFragment.cC;
        if (montageComposerController.k == null || !montageComposerController.k.z()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            threadListFragment.cC.a();
        }
    }

    private void m6348c(ThreadSummary threadSummary) {
        this.f6660i.a(threadSummary.a, this.D, "context_pop_out_selected");
    }

    public static void aU(ThreadListFragment threadListFragment) {
        if (!threadListFragment.ba.mIsPageContext) {
            Object a = Lists.a();
            int l = threadListFragment.cj.l();
            int n = threadListFragment.cj.n();
            if (l >= 0) {
                for (int i = l; i <= n; i++) {
                    InboxItem b = threadListFragment.aX.m6270b(i);
                    if (b instanceof InboxUnitThreadItem) {
                        a.add(((InboxUnitThreadItem) b).f6491g.a);
                    }
                }
            }
            threadListFragment.bg.k();
            Intent intent = new Intent(MessagesBroadcastIntents.i);
            intent.putExtra("threads", a);
            threadListFragment.aF.a(intent);
            l = a.size();
            if (threadListFragment.aq.a(MessagingPrefKeys.aw, -1) < l) {
                threadListFragment.aq.edit().a(MessagingPrefKeys.aw, l).commit();
            }
        }
    }

    public static void m6351e(ThreadListFragment threadListFragment, final ThreadSummary threadSummary) {
        if (((SmsDefaultAppManager) threadListFragment.bM.get()).a(threadSummary.a)) {
            ((SmsDefaultAppManager) threadListFragment.bM.get()).a(SmsCallerContext.DELETE_THREAD, new Runnable(threadListFragment) {
                final /* synthetic */ ThreadListFragment f6633b;

                public void run() {
                    this.f6633b.m6364a(threadSummary);
                }
            });
        } else {
            threadListFragment.m6364a(threadSummary);
        }
    }

    private void m6352g(ThreadSummary threadSummary) {
        if (threadSummary != null) {
            MarkThreadAsSpamDialogFragment markThreadAsSpamDialogFragment = new MarkThreadAsSpamDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("thread_summary", threadSummary);
            markThreadAsSpamDialogFragment.g(bundle);
            markThreadAsSpamDialogFragment.a(this.D, "markThreadAsSpamDialog");
        }
    }

    public static void aW(ThreadListFragment threadListFragment) {
        boolean z;
        if (threadListFragment.cp) {
            z = false;
        } else {
            boolean z2;
            int b = threadListFragment.aX.m6269b();
            int n = threadListFragment.cj.n();
            if (b <= 0 || n != b - 1) {
                z2 = false;
            } else {
                z2 = threadListFragment.aX.m6270b(n) instanceof InboxMoreThreadsItem;
            }
            z = z2;
        }
        if (z) {
            threadListFragment.aG();
        }
    }

    public static void m6333a(ThreadListFragment threadListFragment, Params params, Result result) {
        boolean z;
        threadListFragment.ct.put(params.f6710d, result);
        if (threadListFragment.cb.f6410E == ThreadTypeFilter.SMS) {
            z = false;
        } else {
            Result au = au(threadListFragment);
            if (au == null && au.f6714b == null) {
                z = false;
            } else {
                ImmutableList immutableList = au.f6714b.c;
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    if (((ThreadSummary) immutableList.get(i)).a.a == Type.GROUP) {
                        z = true;
                        break;
                    }
                }
                z = false;
            }
        }
        threadListFragment.cw = z;
        threadListFragment.bi();
        if (params.f6709c == LoadType.MORE_THREADS) {
            threadListFragment.ci.a(0, 0);
        }
        threadListFragment.cp = false;
        threadListFragment.cV = true;
        threadListFragment.ca.m6377a(Urgency.THREADS, "TL onNewResult");
        threadListFragment.m6322a(result.f6717e, params.f6709c.toString());
    }

    public static void m6332a(ThreadListFragment threadListFragment, Params params, Error error) {
        if (params.f6709c == LoadType.THREAD_LIST) {
            threadListFragment.cX.clear();
            threadListFragment.cu = error;
            if (threadListFragment.ch != null) {
                threadListFragment.ch.m6372b();
            }
            threadListFragment.cV = true;
            threadListFragment.ca.m6377a(Urgency.THREADS, "onLoadFailedFullThreadList");
            if (error.f6706b && threadListFragment.z() && (!((Boolean) threadListFragment.aS.get()).booleanValue() || threadListFragment.am.b())) {
                ServiceException serviceException = error.f6705a;
                if (threadListFragment.cT == null) {
                    threadListFragment.cT = (AnchorableToast) threadListFragment.aR.get();
                }
                threadListFragment.cT.f4939k = 80;
                threadListFragment.cT.f4940l = 5000;
                threadListFragment.cT.f4938j = true;
                threadListFragment.cT.m4483a(threadListFragment.e(2131565188), m6343b(((ErrorMessageGenerator) threadListFragment.av.get()).a(serviceException, false, true)));
            }
            threadListFragment.aH.c("thread_list");
        } else if (params.f6709c == LoadType.MORE_THREADS) {
            threadListFragment.ba();
        }
    }

    private void ba() {
        new FbAlertDialogBuilder(getContext()).a(2131231759).b(2131231760).a(17039370, new OnClickListener(this) {
            final /* synthetic */ ThreadListFragment f6635a;

            {
                this.f6635a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).b();
        this.cp = true;
        aJ();
    }

    private void m6322a(DataFetchDisposition dataFetchDisposition, String str) {
        String b = this.as.b(getContext());
        ContentFlags contentFlags = ContentFlags.UNDEFINED;
        if (!dataFetchDisposition.l) {
            contentFlags = ContentFlags.NO_DATA;
        } else if (dataFetchDisposition.m.isLocal()) {
            contentFlags = ContentFlags.LOCAL_DATA;
        } else {
            contentFlags = ContentFlags.NETWORK_DATA;
        }
        HoneyClientEvent a = InteractionLogger.a(contentFlags, bb(this), b, -1);
        a.b("load_type", str);
        this.f6655d.a(a);
    }

    public static String bb(ThreadListFragment threadListFragment) {
        StringBuilder stringBuilder = new StringBuilder();
        if (threadListFragment.cK != null) {
            stringBuilder.append(threadListFragment.cK);
        }
        if (threadListFragment.getContext() instanceof AnalyticsActivity) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("_");
            }
            String am_ = ((AnalyticsActivity) threadListFragment.getContext()).am_();
            if (am_ != null) {
                am_ = am_.toString();
            } else {
                am_ = "unknown".toString();
            }
            stringBuilder.append(am_);
        }
        return stringBuilder.toString();
    }

    public final void m6364a(ThreadSummary threadSummary) {
        if (threadSummary != null) {
            Builder builder = new Builder();
            builder.f3320a = ImmutableList.of(threadSummary.a);
            DeleteThreadDialogFragment.m3235a(builder.m3239a()).a(this.D, "deleteThreadDialog");
        }
    }

    private void m6354h(ThreadSummary threadSummary) {
        if (threadSummary.a != null && !threadSummary.a.b()) {
            UserKey a = ThreadKey.a(threadSummary.a);
            Preconditions.checkNotNull(a);
            User a2 = this.bW.a(a);
            if (a2 != null) {
                this.bn.a(a2.a);
                ManageBlockingFragment.a(a2).a(this.D, "manageBlockingFragment");
            }
        }
    }

    public static boolean bc(ThreadListFragment threadListFragment) {
        return threadListFragment.cQ.d() || threadListFragment.cP.d();
    }

    public static void m6327a(ThreadListFragment threadListFragment, InterstitialTrigger interstitialTrigger) {
        InterstitialTrigger b = threadListFragment.m6342b(interstitialTrigger);
        bg(threadListFragment);
        InterstitialController a = ((InterstitialManager) threadListFragment.aw.get()).a(b);
        if (a instanceof QuickPromotionThreadListBannerController) {
            threadListFragment.m6325a((QuickPromotionThreadListBannerController) a);
        } else if ((a instanceof MessengerSurveyInterstitialController) && !threadListFragment.ax()) {
            threadListFragment.be();
        }
    }

    private boolean bd() {
        InterstitialController a = ((InterstitialManager) this.aw.get()).a(m6342b(new InterstitialTrigger(Action.MESSENGER_THREAD_LIST_BLOCKING)));
        if (a == null) {
            return false;
        }
        return "3923".equals(a.b()) && this.bq.a() && this.bt.get() != null && ((PhotoSuggestionManager) this.bt.get()).a();
    }

    private InterstitialTrigger m6342b(InterstitialTrigger interstitialTrigger) {
        Map hashMap = new HashMap();
        hashMap.put("is_in_chat_head", String.valueOf(ax()));
        return new InterstitialTrigger(interstitialTrigger, new InterstitialTriggerContext(hashMap));
    }

    private void be() {
        m6339a(this.cQ, 2131624676);
        ((SurveyPromotionBannerView) this.cQ.a()).setupSurveyParams(bf());
        final String str = "1409550936017447";
        if (((StructuredSurveyController) this.bc.get()).b(str)) {
            if ((((StructuredSurveyController) this.bc.get()).h() >= 0 ? 1 : null) == null) {
                m6334a(this, this.cQ);
                return;
            }
            return;
        }
        ((StructuredSurveyController) this.bc.get()).a(str, new Runnable(this) {
            final /* synthetic */ ThreadListFragment f6637b;

            public void run() {
                if (((StructuredSurveyController) this.f6637b.bc.get()).b(str)) {
                    ThreadListFragment.m6334a(this.f6637b, this.f6637b.cQ);
                }
            }
        }, true);
    }

    public static void m6334a(ThreadListFragment threadListFragment, ViewStubHolder viewStubHolder) {
        ((StructuredSurveyController) threadListFragment.bc.get()).a(ImpressionType.INVITATION_IMPRESSION, null);
        if (VERSION.SDK_INT >= 11) {
            threadListFragment.m6346b(threadListFragment.cQ);
        } else {
            viewStubHolder.f();
        }
    }

    private void m6325a(QuickPromotionThreadListBannerController quickPromotionThreadListBannerController) {
        Intent a = quickPromotionThreadListBannerController.a(getContext());
        if (a == null) {
            this.ap.b("ThreadListFragment_QPBanner_NullIntent", "Null intent to present from QP Banner Controller");
        } else if (a.hasExtra("qp_definition")) {
            QuickPromotionDefinition quickPromotionDefinition = (QuickPromotionDefinition) a.getExtras().get("qp_definition");
            m6356i(QuickPromotionBannerView.m3556a(quickPromotionDefinition));
            ((QuickPromotionBannerView) this.cP.a()).m3576a(QuickPromotionBannerView.Type.THREADLIST, quickPromotionDefinition, bf(), "3543", null);
            this.cP.f();
            ((QuickPromotionBannerView) this.cP.a()).m3575a();
        } else {
            this.ap.b("ThreadListFragment_QPBanner_MissingKey", "Intent missing QP_DEFINITION_KEY");
        }
    }

    private void m6356i(int i) {
        if (this.cP.c() && i != ((QuickPromotionBannerView) this.cP.a()).getColorSchemeThemeId()) {
            this.cP = ViewStubHolder.a((ViewStubCompat) b(null).inflate(2130905830, this.cN, false));
            ViewReplacementUtil.b(this.cN, 2131565088, this.cP.b());
            m6339a(this.cP, i);
        } else if (!this.cP.c()) {
            m6339a(this.cP, i);
        }
    }

    private void m6339a(ViewStubHolder viewStubHolder, int i) {
        viewStubHolder.a(b(null).cloneInContext(new ContextThemeWrapper(this.cL, i)));
    }

    private void m6346b(ViewStubHolder viewStubHolder) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{-1.0f, 0.0f});
        ofFloat.setDuration(300);
        ofFloat.addUpdateListener(new BannerAnimateUpdateListener(this, viewStubHolder.a()));
        ofFloat.start();
        viewStubHolder.f();
    }

    private View.OnClickListener bf() {
        return new View.OnClickListener(this) {
            final /* synthetic */ ThreadListFragment f6638a;

            {
                this.f6638a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 484963441);
                if (((Boolean) this.f6638a.bk.get()).booleanValue() && this.f6638a.cP.d()) {
                    this.f6638a.f6659h.a();
                }
                ThreadListFragment.bg(this.f6638a);
                Logger.a(2, EntryType.UI_INPUT_END, -2097800454, a);
            }
        };
    }

    public final void c_(boolean z) {
    }

    public final String am_() {
        return f6652a.c();
    }

    public final void m6368g(boolean z) {
        boolean D = D();
        super.g(z);
        if (z && !D) {
            aE();
        }
        bi();
        D = z && !bh();
        if (this.cF != null) {
            this.cF.m2616b(D);
        }
        if (this.cE != null) {
            this.cE.m2593b(D);
        }
        if (this.cl != null) {
            this.cl.d = D;
        }
    }

    private void bi() {
        if (aE()) {
            this.aH.a("thread_list");
            Result au = au(this);
            if (au != null) {
                this.aH.a("data_fetch_disposition", au.f6717e);
            }
        }
    }

    private void m6344b(InboxUnitItem inboxUnitItem) {
        this.bL.get();
        MenuDialogParamsBuilder menuDialogParamsBuilder = new MenuDialogParamsBuilder();
        MessengerInboxUnitTitleModel q = inboxUnitItem.d.q();
        if (q != null && q.a() != null) {
            menuDialogParamsBuilder.b = q.a();
        } else if (inboxUnitItem.l() != null) {
            menuDialogParamsBuilder.b = inboxUnitItem.l();
        } else {
            menuDialogParamsBuilder.a = 2131231817;
        }
        menuDialogParamsBuilder.d = inboxUnitItem;
        if ((inboxUnitItem.k() & InboxUnitItem.c) == InboxUnitItem.c) {
            MenuDialogItemBuilder menuDialogItemBuilder = new MenuDialogItemBuilder();
            menuDialogItemBuilder.a = 2;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.b = 2131231815;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.d = "hide";
            menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
        }
        if (inboxUnitItem.d.l() > 0) {
            menuDialogItemBuilder = new MenuDialogItemBuilder();
            menuDialogItemBuilder.a = 1;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.b = 2131231816;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.d = "hide";
            menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
        }
        MenuDialogFragment.a(menuDialogParamsBuilder.e()).a(s(), "inbox2_dialog");
    }

    public static String m6343b(String str) {
        if (StringUtil.a(str)) {
            return "";
        }
        return str;
    }

    private int bj() {
        if (this.cU == -1) {
            this.cU = this.bi.nextInt(Integer.MAX_VALUE);
        }
        return this.cU;
    }

    public static void m6350c(ThreadListFragment threadListFragment, String str) {
        threadListFragment.bl.a(str, BugReportCategory.RECENTS_TAB);
    }

    public static boolean bl(ThreadListFragment threadListFragment) {
        if (threadListFragment.aE() && !threadListFragment.ax() && ((SmsTakeoverNuxController) threadListFragment.bH.get()).a()) {
            Object obj = null;
            ThreadsCollection b = threadListFragment.an.b(FolderName.INBOX, ThreadTypeFilter.ALL);
            int i = 0;
            while (i < b.e() && i < 10) {
                ThreadSummary a = b.a(i);
                if (a.f() && ((NotificationSettingsUtil) threadListFragment.az.get()).a(a.a) == NotificationSetting.a) {
                    obj = 1;
                    break;
                }
                i++;
            }
            if (obj == null) {
                ((SecureContextHelper) threadListFragment.bF.get()).a(new Intent(MessagingIntentUris.a).setData(Uri.parse(StringFormatUtil.formatStrLocaleSafe(MessengerLinks.R, NuxCallerContext.THREAD_LIST_INTERSTITIAL.name()))), threadListFragment.bE);
                return true;
            }
        }
        return false;
    }

    public final void m6367e(Bundle bundle) {
        super.e(bundle);
        this.aX.m6263a(bundle);
        InboxFilterManager inboxFilterManager = this.cb;
        bundle.putSerializable("inbox_filter_selected_filter", inboxFilterManager.f6410E);
        for (ThreadTypeFilter threadTypeFilter : inboxFilterManager.f6412G.keySet()) {
            bundle.putParcelable("inbox_filter_states_" + threadTypeFilter.name(), (Parcelable) inboxFilterManager.f6412G.get(threadTypeFilter));
        }
    }

    public final void m6369h(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -288313919);
        super.h(bundle);
        if (bundle != null) {
            ThreadListAdapter threadListAdapter = this.aX;
            threadListAdapter.f6572i.clear();
            Bundle bundle2 = bundle.getBundle("inbox_item_states");
            if (bundle2 != null) {
                threadListAdapter.f6572i.putAll(bundle2);
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -280289243, a);
    }

    public static NavigationTrigger m6320a(ThreadListFragment threadListFragment, InboxItem inboxItem) {
        if (inboxItem instanceof InboxUnitThreadItem) {
            InboxUnitThreadItem inboxUnitThreadItem = (InboxUnitThreadItem) inboxItem;
            Preconditions.checkNotNull(inboxUnitThreadItem.d.j());
            return NavigationTrigger.a("thread_list", inboxUnitThreadItem.d.j());
        } else if (!(inboxItem instanceof InboxUnitItem)) {
            return NavigationTrigger.b("thread_list");
        } else {
            NavigationTrigger a;
            InboxUnitItem inboxUnitItem = (InboxUnitItem) inboxItem;
            Preconditions.checkNotNull(inboxUnitItem.d.r());
            if (inboxUnitItem.e == null) {
                a = NavigationTrigger.a("thread_list", inboxUnitItem.d.r().toString());
            } else {
                a = new NavigationTrigger("thread_list", inboxUnitItem.d.r().toString(), inboxUnitItem.g(), false);
            }
            return a;
        }
    }
}
