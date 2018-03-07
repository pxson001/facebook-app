package com.facebook.orca.threadview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.internal.widget.ViewStubCompat;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.text.ClipboardManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.ViewTreeObserver.OnGlobalFocusChangeListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.util.LoggerMapUtils;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.base.fragment.FbFragment;
import com.facebook.bugreporter.BugReportCategory;
import com.facebook.bugreporter.BugReportFlowStartParams;
import com.facebook.bugreporter.BugReportOperationLogger;
import com.facebook.bugreporter.BugReportSource;
import com.facebook.bugreporter.BugReporter;
import com.facebook.common.android.ClipboardManagerMethodAutoProvider;
import com.facebook.common.android.ConnectivityManagerMethodAutoProvider;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.appchoreographer.AppChoreographer;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ForNonUiThread;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.loader.FbLoader.Callback;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.common.pillstub.PillViewStub;
import com.facebook.common.random.InsecureRandom;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.DeviceUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.contacts.picker.ContactPickerUserRow;
import com.facebook.contacts.picker.ContactPickerUserRow.MenuHandler;
import com.facebook.contacts.picker.ContactPickerUserRowBuilder;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.debug.tracer.AsyncTracer;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.calls.AgentThreadStartInputData;
import com.facebook.graphql.enums.GraphQLExtensibleMessageAdminTextType;
import com.facebook.graphql.enums.GraphQLMessageThreadCannotReplyReason;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiMethodRunner;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.imagepipeline.animated.base.AnimatableDrawable;
import com.facebook.infer.annotation.Assertions;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.iorg.common.upsell.ui.FbZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.analytics.base.MessagingAnalyticsConstants.MessageSendTrigger;
import com.facebook.messaging.analytics.navigation.MessagingAnalyticsLogger;
import com.facebook.messaging.analytics.perf.MessagingPerformanceLogger;
import com.facebook.messaging.analytics.reliability.MessagesReliabilityLogger;
import com.facebook.messaging.annotations.IsCantReplyBottomBarEnabled;
import com.facebook.messaging.annotations.IsGlobalMessageDeleteEnabled;
import com.facebook.messaging.annotations.IsStickerInlineDownloadEnabled;
import com.facebook.messaging.annotations.IsTapPhotoToViewAllImagesEnabled;
import com.facebook.messaging.applinks.ApplinkHelper;
import com.facebook.messaging.attachments.AttachmentDataFactory;
import com.facebook.messaging.attachments.DownloadableAttachment;
import com.facebook.messaging.attachments.ImageAttachmentData;
import com.facebook.messaging.attachments.ImageAttachmentDataBuilder;
import com.facebook.messaging.attachments.ImageAttachmentUris;
import com.facebook.messaging.attachments.ImageAttachmentUrisBuilder;
import com.facebook.messaging.attachments.IsPopOutVideoPlayerSupported;
import com.facebook.messaging.attachments.OtherAttachmentData;
import com.facebook.messaging.attachments.VideoAttachmentData;
import com.facebook.messaging.attribution.AttributionActionType;
import com.facebook.messaging.attribution.AttributionReportFragment;
import com.facebook.messaging.attribution.PlatformLaunchHelper;
import com.facebook.messaging.attributionview.AttributionViewData;
import com.facebook.messaging.audio.playback.AudioClipPlayerQueue;
import com.facebook.messaging.bball.BballActivity;
import com.facebook.messaging.bball.BballGameAnalyticsLogger;
import com.facebook.messaging.bball.BballGameFeature;
import com.facebook.messaging.blocking.BlockingAnalyticsLogger;
import com.facebook.messaging.blocking.ManageBlockingFragment;
import com.facebook.messaging.blocking.ManageBlockingParam;
import com.facebook.messaging.blocking.annotations.IsBlockeeExperienceEnabled;
import com.facebook.messaging.bots.api.BotSubscribeMethod;
import com.facebook.messaging.bots.api.BotSubscribeMethod.Params;
import com.facebook.messaging.business.agent.helper.AgentTermsStatusHelper;
import com.facebook.messaging.business.agent.helper.AgentTermsStatusHelper.C02491;
import com.facebook.messaging.business.common.activity.BusinessActivity;
import com.facebook.messaging.business.common.analytics.BusinessMessageImpressionListener;
import com.facebook.messaging.business.common.calltoaction.CallToActionXMAHandler;
import com.facebook.messaging.business.common.helper.BusinessMutationHelper;
import com.facebook.messaging.business.promotion.gating.BusinessPromotionGatekeepers;
import com.facebook.messaging.business.ride.helper.RideOauthHelper;
import com.facebook.messaging.business.ride.utils.RideServiceParams;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.cache.GloballyDeletedMessagesPlaceholderCache;
import com.facebook.messaging.cache.MessagesBroadcaster.ThreadUpdateCause;
import com.facebook.messaging.cache.ReadThreadManager;
import com.facebook.messaging.cache.SaveDraftManager;
import com.facebook.messaging.cache.SaveDraftManager.1;
import com.facebook.messaging.cache.ThreadParticipantUtils;
import com.facebook.messaging.cache.ThreadRecipientUtil;
import com.facebook.messaging.cache.ThreadUnreadCountUtil;
import com.facebook.messaging.chatheads.detect.ChatHeadsContextDetector;
import com.facebook.messaging.composer.block.BlockComposerView;
import com.facebook.messaging.composer.block.BlockComposerViewParamsFactory;
import com.facebook.messaging.composer.block.CantReplyDialogFragment;
import com.facebook.messaging.composer.botcomposer.QuickReplyMessageUpdater;
import com.facebook.messaging.customthreads.CustomThreadTheme;
import com.facebook.messaging.customthreads.CustomThreadsEmojiLike;
import com.facebook.messaging.customthreads.CustomThreadsLogger;
import com.facebook.messaging.customthreads.DefaultThreadViewTheme;
import com.facebook.messaging.customthreads.ModifyThreadCustomizationHelper;
import com.facebook.messaging.customthreads.ThreadViewTheme;
import com.facebook.messaging.customthreads.ThreadViewTheme.Listener;
import com.facebook.messaging.customthreads.annotations.CanViewThreadCustomization;
import com.facebook.messaging.customthreads.annotations.IsCustomBubbleColorsEnabled;
import com.facebook.messaging.customthreads.annotations.IsHotEmojilikesEnabled;
import com.facebook.messaging.customthreads.threadsettings.HotEmojilikePickerFragment;
import com.facebook.messaging.customthreads.threadsettings.SetNicknameDialogFragment;
import com.facebook.messaging.customthreads.threadsettings.ThreadThemePickerFragment;
import com.facebook.messaging.database.threads.DbClock;
import com.facebook.messaging.database.threads.NeedsDbClock;
import com.facebook.messaging.deliveryreceipt.IsNewSendingStatesUIEnabled;
import com.facebook.messaging.dialog.MenuDialogFragment;
import com.facebook.messaging.dialog.MenuDialogItem;
import com.facebook.messaging.dialog.MenuDialogItemBuilder;
import com.facebook.messaging.dialog.MenuDialogParamsBuilder;
import com.facebook.messaging.ephemeral.ModifyThreadEphemeralityDialog;
import com.facebook.messaging.ephemeral.ShatterView;
import com.facebook.messaging.events.banner.EventReminderEditTimeDialogFragment;
import com.facebook.messaging.events.banner.EventReminderEditTitleDialogFragment;
import com.facebook.messaging.events.banner.EventReminderPromptCreationDialogFragment;
import com.facebook.messaging.forward.MessageForwardHandler;
import com.facebook.messaging.fullscreendialog.FullScreenDialogFragment;
import com.facebook.messaging.fullscreendialog.FullScreenDialogParams;
import com.facebook.messaging.giftwrap.GiftWrapAnalyticsLogger;
import com.facebook.messaging.giftwrap.GiftWrapPrefKeys;
import com.facebook.messaging.giftwrap.GiftWrapResolver;
import com.facebook.messaging.graphql.threads.CommerceAgentMutations.AgentThreadStartMutationString;
import com.facebook.messaging.graphql.threads.business.AgentThreadFragments.BusinessIsPageLinkedQueryString;
import com.facebook.messaging.groups.admin.GroupsAdminLogger;
import com.facebook.messaging.groups.sharesheet.GroupShareSheetCreator;
import com.facebook.messaging.groups.threadactions.GroupThreadActionHandler;
import com.facebook.messaging.intents.MessagesBroadcastIntents;
import com.facebook.messaging.linkhandling.LinkHandlingHelper;
import com.facebook.messaging.location.renderer.LocationMapDialogFragment;
import com.facebook.messaging.media.download.DownloadPhotosParams;
import com.facebook.messaging.media.download.DownloadedMedia;
import com.facebook.messaging.media.download.DownloadedMedia.ResultCode;
import com.facebook.messaging.media.download.MediaDownloadManager;
import com.facebook.messaging.media.download.PhotoDownloadDestination;
import com.facebook.messaging.media.download.PhotoToDownload;
import com.facebook.messaging.media.download.SaveMmsPhotoParams;
import com.facebook.messaging.media.upload.MediaUploadManager;
import com.facebook.messaging.media.upload.MediaUploadManagerImpl;
import com.facebook.messaging.messageclassifier.MessageClassification;
import com.facebook.messaging.messageclassifier.MessageClassifier;
import com.facebook.messaging.model.attachment.Attachment;
import com.facebook.messaging.model.attribution.ContentAppAttribution;
import com.facebook.messaging.model.messages.ForMessageXMAContext;
import com.facebook.messaging.model.messages.GenericAdminMessageInfo.BotChoice;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageBuilder;
import com.facebook.messaging.model.messages.MessageDraft;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.messages.MessageUserUtil;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.messages.RecentMessageSource;
import com.facebook.messaging.model.send.SendError;
import com.facebook.messaging.model.send.SendErrorType;
import com.facebook.messaging.model.share.Share;
import com.facebook.messaging.model.share.ShareMedia;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.model.threads.ThreadCustomization;
import com.facebook.messaging.model.threads.ThreadEventReminder;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.modifiers.flowerborder.FlowerBorderFeature;
import com.facebook.messaging.mutators.AskToOpenThreadDialogFragment;
import com.facebook.messaging.mutators.DeleteMessagesDialogFragment;
import com.facebook.messaging.mutators.ThreadNotificationsDialogFragment;
import com.facebook.messaging.particles.FloatingHeartStickersXConfig;
import com.facebook.messaging.particles.ThreadViewParticleEffectResolver;
import com.facebook.messaging.particles.ThreadViewParticleSystemController;
import com.facebook.messaging.payment.analytics.PaymentFlowType;
import com.facebook.messaging.payment.dialog.PaymentDialogsBuilder;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformContextModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.photos.service.PhotoMessageDataCache;
import com.facebook.messaging.photos.view.DefaultPhotoMessageItem;
import com.facebook.messaging.photos.view.PhotoViewFragment;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.messaging.quickpromotion.QuickPromotionBannerView.ComposerPointerLocation;
import com.facebook.messaging.quickpromotion.QuickPromotionTriggers;
import com.facebook.messaging.quickpromotion.ThreadViewBannerReason;
import com.facebook.messaging.send.client.OutgoingMessageFactory;
import com.facebook.messaging.send.client.PendingThreadsManager;
import com.facebook.messaging.send.client.PendingThreadsManager.PendingThreadException;
import com.facebook.messaging.send.client.SendMessageManager;
import com.facebook.messaging.send.trigger.NavigationTrigger;
import com.facebook.messaging.service.methods.RecentMessagesTracker;
import com.facebook.messaging.service.model.SaveDraftParams;
import com.facebook.messaging.sms.SmsContactRowMenuHelper;
import com.facebook.messaging.sms.SmsThreadManager;
import com.facebook.messaging.sms.analytics.SmsCallerContext;
import com.facebook.messaging.sms.broadcast.SmsTakeoverStateChecker;
import com.facebook.messaging.sms.defaultapp.SmsDefaultAppManager;
import com.facebook.messaging.sms.readonly.ReadOnlyModeObserver;
import com.facebook.messaging.sounds.MessengerSoundUtil;
import com.facebook.messaging.sync.annotations.RtcCallInfoDataEnabled;
import com.facebook.messaging.sync.tempcache.UncommittedThreadModificationsCache;
import com.facebook.messaging.threadview.rows.RowItem;
import com.facebook.messaging.threadview.rows.RowItemDeliveryState;
import com.facebook.messaging.threadview.rows.RowMessageItem;
import com.facebook.messaging.threadview.rows.RowType;
import com.facebook.messaging.threadview.rows.RowTypingItem;
import com.facebook.messaging.threadview.xma.MessageXMAActionHandlerManager;
import com.facebook.messaging.tincan.messenger.TincanSendMessageManager;
import com.facebook.messaging.ui.name.MessengerThreadNameViewDataFactory;
import com.facebook.messaging.users.CanonicalThreadPresenceHelper;
import com.facebook.messaging.users.MessengerUserCheckHelper;
import com.facebook.messaging.util.launchtimeline.LaunchTimelineHelper;
import com.facebook.messaging.viewport.MessageEventMonitor;
import com.facebook.messaging.viewport.MessageEventMonitorProvider;
import com.facebook.messaging.xma.XMAAction;
import com.facebook.messaging.xma.XMAActionHandler;
import com.facebook.messaging.xma.XMAActionHandlerManager;
import com.facebook.messaging.xma.XMAViewHostEventDispatcher;
import com.facebook.messaging.xma.XMAViewHostEventListener;
import com.facebook.orca.compose.ComposeFragment;
import com.facebook.orca.compose.ComposeFragment.OnSaveDraftListener;
import com.facebook.orca.compose.ComposeFragment.SimpleComposerListener;
import com.facebook.orca.compose.ComposeMode;
import com.facebook.orca.compose.ComposerInitParams;
import com.facebook.orca.compose.ComposerInitParamsBuilder;
import com.facebook.orca.notify.NotificationSettingsUtil;
import com.facebook.orca.stickers.ui.StickersAnimationManager;
import com.facebook.orca.threadview.GiftWrapAnimationManager.C10432;
import com.facebook.orca.threadview.InternalAttributionCallToActionHelper.C10501;
import com.facebook.orca.threadview.ThreadViewFragment.C11304;
import com.facebook.orca.threadview.ThreadViewLoader.Result;
import com.facebook.orca.threadview.ThreadViewMessagesFragmentPaymentsHelper.C11945;
import com.facebook.orca.threadview.ThreadViewMessagesFragmentPaymentsHelper.C11956;
import com.facebook.orca.threadview.annotations.IsMessengerDelaySendEnabled;
import com.facebook.orca.threadview.annotations.IsSliceMessageCollectionEnabled;
import com.facebook.orca.threadview.annotations.IsStickerTapToOpenPackEnabled;
import com.facebook.orca.threadview.hotlikes.HotLikesAnimationManager;
import com.facebook.orca.threadview.messagelist.MessageListAccessibilityDelegate;
import com.facebook.orca.threadview.messagelist.MessageListHelper;
import com.facebook.orca.threadview.messagelist.MessageListHelperForListView;
import com.facebook.orca.threadview.messagelist.MessageListHelperForRecyclerView;
import com.facebook.orca.threadview.seenheads.SeenHeadsDecoration;
import com.facebook.orca.threadview.seenheads.SeenHeadsDecorationProvider;
import com.facebook.orca.threadview.seenheads.SeenHeadsEligibilityChecker;
import com.facebook.orca.threadview.seenheads.ThreadViewSeenHeadsController;
import com.facebook.orca.threadview.seenheads.ThreadViewSeenHeadsControllerProvider;
import com.facebook.particles.ParticleSystemView;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.presence.PresenceState;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rtc.fbwebrtc.abtests.ExperimentsForRtcModule;
import com.facebook.rtc.helpers.RtcCallHandler;
import com.facebook.rtc.models.RecentCallsDb;
import com.facebook.rtc.models.RecentCallsDb.5;
import com.facebook.rtcpresence.RtcPresenceHandler;
import com.facebook.rtcpresence.RtcPresenceState;
import com.facebook.rtcpresence.annotations.IsVoipEnabledForUser;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.sounds.FBSoundUtil;
import com.facebook.stickers.abtest.StickerContentSearchExperimentAccessor;
import com.facebook.stickers.client.StickerToPackMetadataLoader;
import com.facebook.stickers.client.StickerToPackMetadataLoader.Results;
import com.facebook.stickers.model.StickerUtil;
import com.facebook.stickers.service.FetchStickerPacksResult.Availability;
import com.facebook.stickers.ui.StickerAnimator;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.dialogs.DialogWindowUtils;
import com.facebook.ui.emoji.model.Emoji;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogParamsBuilder;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.Name;
import com.facebook.user.model.User;
import com.facebook.user.model.User.CommercePageSetting;
import com.facebook.user.model.User.CommercePageType;
import com.facebook.user.model.UserKey;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.engine.VideoPlayerManager;
import com.facebook.widget.AdvancedVerticalLinearLayout;
import com.facebook.widget.AdvancedVerticalLinearLayout.LayoutParams;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.ViewStubHolder.OnInflateListener;
import com.facebook.widget.listview.EmptyListViewItem;
import com.facebook.widget.listview.ScrollPerfHelper;
import com.facebook.widget.listview.ScrollState;
import com.facebook.widget.listview.WrappingListItemView;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: message has app attribution */
public class ThreadViewMessagesFragment extends FbFragment {
    @Inject
    AnalyticsLogger f7764a;
    @Inject
    GroupsAdminLogger aA;
    @Inject
    Lazy<GroupPhotoSettingsDialogFactory> aB;
    @Inject
    InputMethodManager aC;
    @Inject
    @IsCantReplyBottomBarEnabled
    Provider<Boolean> aD;
    @IsCustomBubbleColorsEnabled
    @Inject
    Provider<Boolean> aE;
    @Inject
    @IsMessengerDelaySendEnabled
    Provider<Boolean> aF;
    @Inject
    @IsHotEmojilikesEnabled
    Provider<Boolean> aG;
    @Inject
    @IsNewSendingStatesUIEnabled
    Provider<Boolean> aH;
    @Inject
    @IsPopOutVideoPlayerSupported
    Provider<Boolean> aI;
    @Inject
    @IsSliceMessageCollectionEnabled
    Provider<Boolean> aJ;
    @Inject
    @IsStickerInlineDownloadEnabled
    Provider<Boolean> aK;
    @Inject
    @IsTapPhotoToViewAllImagesEnabled
    Provider<Boolean> aL;
    @Inject
    @IsStickerTapToOpenPackEnabled
    Provider<Boolean> aM;
    @IsVoipEnabledForUser
    @Inject
    Provider<Boolean> aN;
    @Inject
    @LocalBroadcast
    BaseFbBroadcastManager aO;
    @Inject
    MessageClassifier aP;
    @Inject
    MessageDeduper aQ;
    @Inject
    MessageDeliveryStatesSoundHelper aR;
    @Inject
    Lazy<MessageListHelperForListView> aS;
    @Inject
    Lazy<MessageListHelperForRecyclerView> aT;
    @Inject
    MessageUserUtil aU;
    @Inject
    MessageUtil aV;
    @Inject
    MessagingAnalyticsLogger aW;
    @Inject
    MessagingPerformanceLogger aX;
    @Inject
    MessengerSoundUtil aY;
    @Inject
    MessengerThreadNameViewDataFactory aZ;
    @Inject
    BotSubscribeMethod al;
    @Inject
    CanonicalThreadPresenceHelper am;
    @Inject
    @CanViewThreadCustomization
    Provider<Boolean> an;
    @Inject
    ClipboardManager ao;
    @Inject
    ConnectivityManager ap;
    @Inject
    CustomThreadsEmojiLike aq;
    @Inject
    CustomThreadsLogger ar;
    @Inject
    DataCache as;
    @Inject
    ErrorDialogs at;
    @Inject
    AbstractFbErrorReporter au;
    @Inject
    FbSharedPreferences av;
    @Inject
    @ForUiThread
    Executor aw;
    @DefaultExecutorService
    @Inject
    ListeningExecutorService ax;
    @Inject
    GiftWrapAnalyticsLogger ay;
    @Inject
    GiftWrapResolver az;
    @Inject
    AnalyticsTagger f7765b;
    @Inject
    ThreadViewMessagesFragmentSendFailuresHelper bA;
    @Inject
    Lazy<ThreadViewOperationsHelper> bB;
    @Inject
    Lazy<LaunchTimelineHelper> bC;
    @Inject
    ThreadViewRowItemCacheForBugReporter bD;
    @Inject
    ThreadViewSeenHeadsControllerProvider bE;
    @Inject
    Toaster bF;
    @Inject
    UncommittedThreadModificationsCache bG;
    @Inject
    UnreadMessagesPillController bH;
    @Inject
    VideoPlayerManager bI;
    @Inject
    RtcCallHandler bJ;
    @Inject
    QeAccessor bK;
    @Inject
    XMAViewHostEventDispatcher bL;
    @Inject
    @IsGlobalMessageDeleteEnabled
    Provider<Boolean> bM;
    @Inject
    @InsecureRandom
    Random bN;
    @Inject
    Lazy<LinkHandlingHelper> bO;
    @Inject
    @IsBlockeeExperienceEnabled
    Provider<Boolean> bP;
    @Inject
    GloballyDeletedMessagesPlaceholderCache bQ;
    @Inject
    Lazy<BusinessMutationHelper> bR;
    @Inject
    Lazy<AgentTermsStatusHelper> bS;
    @Inject
    MessageSendFailedDataFileProviderProvider bT;
    @Inject
    BugReportOperationLogger bU;
    @Inject
    BlockingAnalyticsLogger bV;
    @Inject
    AutoContactAddController bW;
    @Inject
    RemoveMembersHelper bX;
    @Inject
    MessengerContactRowMenuHelper bY;
    @Inject
    ZeroDialogController bZ;
    @Inject
    ModifyThreadCustomizationHelper ba;
    @Inject
    @NeedsDbClock
    Clock bb;
    @Inject
    PerformanceLogger bc;
    @Inject
    PerfTestConfig bd;
    @Inject
    PlatformLaunchHelper be;
    @Inject
    PhotoMessageDataCache bf;
    @Inject
    ReadThreadManager bg;
    @Inject
    RecentMessagesTracker bh;
    @Inject
    RowItemUiUtil bi;
    @Inject
    RowMessageItemGenerator bj;
    @Inject
    RtcPresenceHandler bk;
    @Inject
    RuntimePermissionsUtil bl;
    @Inject
    SaveDraftManager bm;
    @Inject
    Lazy<ScrollPerfHelper> bn;
    @Inject
    SecureContextHelper bo;
    @Inject
    SeenHeadsEligibilityChecker bp;
    @Inject
    StickersAnimationManager bq;
    @Inject
    StickerContentSearchExperimentAccessor br;
    @Inject
    ThreadParticipantUtils bs;
    @Inject
    ThreadUnreadCountUtil bt;
    @Inject
    DefaultThreadViewTheme bu;
    @Inject
    Provider<BugReporter> bv;
    @Inject
    ThreadViewMessagesFragmentBannerNotificationControllerProvider bw;
    @Inject
    ThreadViewMessagesFragmentMessageRequestsControllerProvider bx;
    @Inject
    ThreadViewMessagesFragmentNullStateCallToActionController by;
    @Inject
    ThreadViewMessagesFragmentPaymentsHelper bz;
    @Inject
    DefaultAndroidThreadUtil f7766c;
    @Inject
    @com.facebook.ultralight.Lazy
    private Lazy<MessengerUserCheckHelper> cA = UltralightRuntime.b;
    @Inject
    @com.facebook.ultralight.Lazy
    public Lazy<NewMessageAnchorController> cB = UltralightRuntime.b;
    @Inject
    @com.facebook.ultralight.Lazy
    public Lazy<OutgoingMessageFactory> cC = UltralightRuntime.b;
    @Inject
    @com.facebook.ultralight.Lazy
    private Lazy<PendingThreadsManager> cD = UltralightRuntime.b;
    @Inject
    @com.facebook.ultralight.Lazy
    public Lazy<SendMessageManager> cE = UltralightRuntime.b;
    @Inject
    @com.facebook.ultralight.Lazy
    private Lazy<StickerToPackMetadataLoader> cF = UltralightRuntime.b;
    @Inject
    @com.facebook.ultralight.Lazy
    private Lazy<ThreadViewParticleEffectResolver> cG = UltralightRuntime.b;
    @Inject
    @com.facebook.ultralight.Lazy
    public Lazy<ThreadRecipientUtil> cH = UltralightRuntime.b;
    @Inject
    @com.facebook.ultralight.Lazy
    public Lazy<RideOauthHelper> cI = UltralightRuntime.b;
    @Inject
    @com.facebook.ultralight.Lazy
    private Lazy<MediaUploadManager> cJ = UltralightRuntime.b;
    @Inject
    @com.facebook.ultralight.Lazy
    private Lazy<MessageForwardHandler> cK = UltralightRuntime.b;
    @Inject
    @com.facebook.ultralight.Lazy
    public Lazy<InternalAttributionCallToActionHelper> cL = UltralightRuntime.b;
    @Inject
    @com.facebook.ultralight.Lazy
    private Lazy<GroupShareSheetCreator> cM = UltralightRuntime.b;
    private Context cN;
    private SendMessageAnimationManager cO;
    private GiftWrapAnimationManager cP;
    public HotLikesAnimationManager cQ;
    private MessageDetailViewManager cR;
    private PaymentsAnimationManager cS;
    private AdvancedVerticalLinearLayout cT;
    private View cU;
    public ThreadViewSeenHeadsController cV;
    private FrameLayout cW;
    private EmptyListViewItem cX;
    public EmptyListViewItem cY;
    private View cZ;
    @Inject
    SmsContactRowMenuHelper ca;
    @Inject
    SmsTakeoverStateChecker cb;
    @ForNonUiThread
    @Inject
    Lazy<Handler> cc;
    @Inject
    Lazy<SmsThreadManager> cd;
    @Inject
    RecentCallsDb ce;
    @Inject
    GatekeeperStoreImpl cf;
    @Inject
    SmsDefaultAppManager cg;
    @Inject
    Lazy<GroupThreadActionHandler> ch;
    @Inject
    @ForMessageXMAContext
    XMAActionHandlerManager ci;
    @Inject
    MessageEventMonitorProvider cj;
    @Inject
    BusinessMessageImpressionListener ck;
    @Inject
    BusinessPromotionGatekeepers cl;
    @Inject
    MessageListAccessibilityDelegate cm;
    @Inject
    CallToActionXMAHandler cn;
    @Inject
    UserCache co;
    @Inject
    FlowerBorderFeature cp;
    @Inject
    FlowerBordersDecorationProvider cq;
    @Inject
    NotificationSettingsUtil cr;
    @Inject
    ThreadViewManageMenuHelper cs;
    @Inject
    @RtcCallInfoDataEnabled
    Provider<Boolean> ct;
    @Inject
    QuickReplyMessageUpdater cu;
    private final Listener cv = new C11571(this);
    private final C11592 cw = new C11592(this);
    @Inject
    @com.facebook.ultralight.Lazy
    private Lazy<ApplinkHelper> cx = UltralightRuntime.b;
    @Inject
    @com.facebook.ultralight.Lazy
    public Lazy<MediaDownloadManager> cy = UltralightRuntime.b;
    @Inject
    @com.facebook.ultralight.Lazy
    private Lazy<MessagesReliabilityLogger> cz = UltralightRuntime.b;
    @Inject
    ApiMethodRunnerImpl f7767d;
    private Message dA;
    private long dB;
    public com.facebook.orca.threadview.ThreadViewFragment.AnonymousClass16 dC;
    private Message dD;
    private List<Message> dE;
    private List<Message> dF;
    private final Set<String> dG = Sets.a();
    public final Set<String> dH = Sets.a();
    public String dI;
    @Nullable
    public NavigationTrigger dJ;
    private boolean dK;
    private boolean dL;
    private boolean dM;
    private boolean dN;
    private MenuDialogFragment dO;
    private MenuDialogFragment.Listener dP;
    private RowMessageItem dQ;
    private AskToOpenThreadDialogFragment dR;
    private final C11603 dS = new C11603(this);
    private MenuDialogFragment dT;
    private MenuDialogFragment.Listener dU;
    private ComposerInitParams dV;
    private Result dW;
    @Nullable
    private Result dX;
    private SeenHeadsDecoration dY;
    private boolean dZ;
    private ProgressDialog da;
    private ViewStubHolder<BlockComposerView> db;
    public ViewStubHolder<NewMessageAnchorView> dc;
    private Handler dd;
    public boolean de;
    private boolean df;
    private SelfRegistrableReceiverImpl dg;
    public ComposeFragment dh;
    private View di;
    private boolean dj;
    public ThreadViewMessagesFragmentBannerNotificationController dk;
    private ThreadViewMessagesFragmentMessageRequestsController dl;
    public MessageEventMonitor<Message> dm;
    public C11304 dn;
    private OnGlobalFocusChangeListener f7768do;
    public ThreadKey dp;
    private ComposeMode dq = ComposeMode.SHRUNK;
    public Name dr;
    private TriState ds;
    private GraphQLMessageThreadCannotReplyReason dt = GraphQLMessageThreadCannotReplyReason.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    private boolean du;
    private PresenceState dv = PresenceState.a;
    public MessagesCollection dw;
    @Nullable
    public ThreadSummary dx;
    private List<Message> dy;
    private List<RowItem> dz;
    @Inject
    DefaultAppChoreographer f7769e;
    private FlowerBordersDecoration ea;
    @Nullable
    private String eb;
    @Nullable
    public String ec;
    private ScrollState ed;
    private final OnPreDrawListener ee = new C11644(this);
    private boolean ef = false;
    private int eg = -1;
    @Nullable
    private ThreadViewParticleSystemController eh;
    @Nullable
    private ParticleSystemView ei;
    @Nullable
    public ShatterView ej;
    public MessageListHelper ek;
    private XMAActionHandler<Message> el;
    private XMAActionHandler<Message> em;
    private XMAActionHandler<Message> en;
    private boolean eo = false;
    @GuardedBy("mAsyncSendRunnables")
    private final List<Runnable> ep = new ArrayList(1);
    @Inject
    AttachmentDataFactory f7770f;
    @Inject
    AudioClipPlayerQueue f7771g;
    @Inject
    BballGameAnalyticsLogger f7772h;
    @Inject
    BballGameFeature f7773i;

    /* compiled from: message has app attribution */
    class C11571 implements Listener {
        final /* synthetic */ ThreadViewMessagesFragment f7704a;

        C11571(ThreadViewMessagesFragment threadViewMessagesFragment) {
            this.f7704a = threadViewMessagesFragment;
        }

        public final void m7447a() {
            ThreadViewMessagesFragment.aN(this.f7704a);
            ThreadViewMessagesFragment.aO(this.f7704a);
        }
    }

    /* compiled from: message has app attribution */
    public class C11592 {
        final /* synthetic */ ThreadViewMessagesFragment f7716a;

        C11592(ThreadViewMessagesFragment threadViewMessagesFragment) {
            this.f7716a = threadViewMessagesFragment;
        }

        public final void m7460a() {
            ThreadViewMessagesFragment.bd(this.f7716a);
        }
    }

    /* compiled from: message has app attribution */
    public class C11603 {
        final /* synthetic */ ThreadViewMessagesFragment f7733a;

        C11603(ThreadViewMessagesFragment threadViewMessagesFragment) {
            this.f7733a = threadViewMessagesFragment;
        }

        public final void m7465a() {
            this.f7733a.dn.m7146b();
        }
    }

    /* compiled from: message has app attribution */
    class C11644 implements OnPreDrawListener {
        final /* synthetic */ ThreadViewMessagesFragment f7749a;

        C11644(ThreadViewMessagesFragment threadViewMessagesFragment) {
            this.f7749a = threadViewMessagesFragment;
        }

        public boolean onPreDraw() {
            return ThreadViewMessagesFragment.bu(this.f7749a);
        }
    }

    /* compiled from: message has app attribution */
    /* synthetic */ class AnonymousClass50 {
        static final /* synthetic */ int[] f7750a = new int[AttributionActionType.values().length];
        static final /* synthetic */ int[] f7751b = new int[Availability.values().length];

        static {
            try {
                f7751b[Availability.DOWNLOADED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f7751b[Availability.IN_STORE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f7751b[Availability.NOT_AVAILABLE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f7750a[AttributionActionType.PLATFORM_APP_INSTALL.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f7750a[AttributionActionType.PLATFORM_APP_REPLY.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f7750a[AttributionActionType.PLATFORM_APP_OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* compiled from: message has app attribution */
    class C11655 implements ActionReceiver {
        final /* synthetic */ ThreadViewMessagesFragment f7752a;

        C11655(ThreadViewMessagesFragment threadViewMessagesFragment) {
            this.f7752a = threadViewMessagesFragment;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -840287706);
            ThreadViewMessagesFragment.cg(this.f7752a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 139113786, a);
        }
    }

    /* compiled from: message has app attribution */
    class C11666 implements ActionReceiver {
        final /* synthetic */ ThreadViewMessagesFragment f7753a;

        C11666(ThreadViewMessagesFragment threadViewMessagesFragment) {
            this.f7753a = threadViewMessagesFragment;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1900934133);
            ThreadViewMessagesFragment.m7590b(this.f7753a, intent);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 750779840, a);
        }
    }

    /* compiled from: message has app attribution */
    class C11677 implements ZeroDialogController.Listener {
        final /* synthetic */ ThreadViewMessagesFragment f7754a;

        C11677(ThreadViewMessagesFragment threadViewMessagesFragment) {
            this.f7754a = threadViewMessagesFragment;
        }

        public final void m7488a(Object obj) {
            VideoAttachmentData videoAttachmentData = (VideoAttachmentData) obj;
            ThreadViewMessagesFragment.m7631j(this.f7754a, "MENU_ITEM_SAVE_VIDEO");
            ((MediaDownloadManager) this.f7754a.cy.get()).c(((MediaDownloadManager) this.f7754a.cy.get()).a(videoAttachmentData, CallerContext.a(getClass(), "video_save_thread_view")));
        }

        public final void m7487a() {
        }
    }

    /* compiled from: message has app attribution */
    class C11688 implements OnSaveDraftListener {
        final /* synthetic */ ThreadViewMessagesFragment f7755a;

        C11688(ThreadViewMessagesFragment threadViewMessagesFragment) {
            this.f7755a = threadViewMessagesFragment;
        }

        public final void mo331a() {
            ThreadViewMessagesFragment.bx(this.f7755a);
        }
    }

    /* compiled from: message has app attribution */
    class C11699 extends SimpleComposerListener {
        final /* synthetic */ ThreadViewMessagesFragment f7756a;

        C11699(ThreadViewMessagesFragment threadViewMessagesFragment) {
            this.f7756a = threadViewMessagesFragment;
        }

        public final void mo147a(Message message, MessageSendTrigger messageSendTrigger) {
            this.f7756a.m7539a(message, messageSendTrigger);
        }

        public final boolean mo148a(View view, MotionEvent motionEvent) {
            ThreadViewMessagesFragment.m7640l(this.f7756a, "Click on Like Button");
            return this.f7756a.cQ.m8095a(view, motionEvent);
        }

        public final void mo149b() {
            if (this.f7756a.de) {
                ThreadViewMessagesFragment.aS(this.f7756a);
                this.f7756a.dk.m7762j();
            }
        }

        @Nullable
        public final String mo151d() {
            if (this.f7756a.dp.a != Type.ONE_TO_ONE) {
                return null;
            }
            String b = ((ThreadRecipientUtil) this.f7756a.cH.get()).b(this.f7756a.dx);
            if (StringUtil.a(b)) {
                return this.f7756a.dr != null ? this.f7756a.dr.i() : null;
            } else {
                return b;
            }
        }
    }

    /* compiled from: message has app attribution */
    public class BotPromptViewListener {
        final /* synthetic */ ThreadViewMessagesFragment f7759a;

        public BotPromptViewListener(ThreadViewMessagesFragment threadViewMessagesFragment) {
            this.f7759a = threadViewMessagesFragment;
        }

        public final void m7494a(BotChoice botChoice) {
            final Params params = new Params(this.f7759a.dp, botChoice.id);
            ExecutorDetour.a(this.f7759a.ax, new Runnable(this) {
                final /* synthetic */ BotPromptViewListener f7758b;

                public void run() {
                    try {
                        this.f7758b.f7759a.f7767d.a(this.f7758b.f7759a.al, params);
                    } catch (Throwable e) {
                        BLog.b("ThreadViewMessagesFragment", "Failed to subscribe to bot", e);
                    }
                }
            }, 1239459709);
        }
    }

    /* compiled from: message has app attribution */
    public class EmojilikePickerViewListener {
        final /* synthetic */ ThreadViewMessagesFragment f7760a;

        public EmojilikePickerViewListener(ThreadViewMessagesFragment threadViewMessagesFragment) {
            this.f7760a = threadViewMessagesFragment;
        }

        public final void m7496a(@Nullable Emoji emoji, String str) {
            this.f7760a.m7567a(emoji, "like_sticker_inline", str);
        }

        public final void m7495a() {
            this.f7760a.ar.b(this.f7760a.dx.a, "inline");
            this.f7760a.m7683e("inline");
        }
    }

    /* compiled from: message has app attribution */
    public class MessageListListener {
        final /* synthetic */ ThreadViewMessagesFragment f7761a;

        public MessageListListener(ThreadViewMessagesFragment threadViewMessagesFragment) {
            this.f7761a = threadViewMessagesFragment;
        }

        public final boolean m7499a() {
            if (this.f7761a.ek.mo334a().getChildCount() > 0) {
                this.f7761a.aW.c("thread");
                this.f7761a.aX.a(this.f7761a.dp.g(), !this.f7761a.ap());
            }
            for (String str : ThreadViewMessagesFragment.aP(this.f7761a)) {
                MessagingPerformanceLogger messagingPerformanceLogger = this.f7761a.aX;
                if (messagingPerformanceLogger.d.a(5505025, str.hashCode(), 1)) {
                    messagingPerformanceLogger.d.a(5505025, str.hashCode(), (short) 5);
                }
                AsyncTracer asyncTracer = (AsyncTracer) messagingPerformanceLogger.i.remove(str);
                if (asyncTracer != null) {
                    asyncTracer.a();
                }
            }
            this.f7761a.m7618f("onAfterMessageListDraw");
            if (this.f7761a.aE()) {
                this.f7761a.aC();
            }
            return false;
        }

        public void mo332a(int i) {
            ThreadViewMessagesFragment.bH(this.f7761a);
        }

        public final void m7498a(ViewGroup viewGroup, int i, int i2, int i3, int i4) {
            this.f7761a.m7531a(viewGroup, i, i2, i3, i4);
            if (this.f7761a.dm != null) {
                this.f7761a.dm.a(this.f7761a.ek.mo370r(), i, i2, i3);
            }
        }

        public final void m7500b() {
            this.f7761a.cV.m8300a(this.f7761a.ek.mo361i());
        }
    }

    /* compiled from: message has app attribution */
    class MessageListListenerForPerfTesting extends MessageListListener {
        final /* synthetic */ ThreadViewMessagesFragment f7762b;

        public MessageListListenerForPerfTesting(ThreadViewMessagesFragment threadViewMessagesFragment) {
            this.f7762b = threadViewMessagesFragment;
            super(threadViewMessagesFragment);
        }

        public final void mo332a(int i) {
            super.mo332a(i);
            ((ScrollPerfHelper) this.f7762b.bn.get()).a(i);
        }
    }

    /* compiled from: message has app attribution */
    public class NicknamePromptViewListener {
        final /* synthetic */ ThreadViewMessagesFragment f7763a;

        public NicknamePromptViewListener(ThreadViewMessagesFragment threadViewMessagesFragment) {
            this.f7763a = threadViewMessagesFragment;
        }

        public final void m7502a(User user) {
            this.f7763a.m7573a(user.a, "journey_prompt_write_in");
        }

        public final void m7503a(User user, String str) {
            this.f7763a.m7574a(user.a, str, "journey_prompt");
        }
    }

    /* compiled from: message has app attribution */
    public enum Source {
        OTHER,
        SINGLE_PICKER,
        OMNI_PICKER,
        FLOWER_MESSAGE_PICKER
    }

    @Deprecated
    private static <T> void m7571a(Class<T> cls, T t, Context context) {
        m7572a((Object) t, context);
    }

    public static void m7572a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ThreadViewMessagesFragment) obj).m7532a(AnalyticsLoggerMethodAutoProvider.a(injectorLike), AnalyticsTagger.a(injectorLike), DefaultAndroidThreadUtil.a(injectorLike), ApiMethodRunnerImpl.a(injectorLike), IdBasedLazy.a(injectorLike, 7521), DefaultAppChoreographer.a(injectorLike), AttachmentDataFactory.a(injectorLike), AudioClipPlayerQueue.a(injectorLike), BballGameAnalyticsLogger.a(injectorLike), BballGameFeature.a(injectorLike), BotSubscribeMethod.a(injectorLike), CanonicalThreadPresenceHelper.a(injectorLike), IdBasedProvider.a(injectorLike, 4144), ClipboardManagerMethodAutoProvider.a(injectorLike), ConnectivityManagerMethodAutoProvider.a(injectorLike), CustomThreadsEmojiLike.a(injectorLike), CustomThreadsLogger.a(injectorLike), DataCache.a(injectorLike), ErrorDialogs.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), GiftWrapAnalyticsLogger.a(injectorLike), GiftWrapResolver.a(injectorLike), GroupsAdminLogger.m2348a(injectorLike), IdBasedLazy.a(injectorLike, 8836), InputMethodManagerMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4052), IdBasedProvider.a(injectorLike, 4145), IdBasedProvider.a(injectorLike, 4240), IdBasedProvider.a(injectorLike, 4149), IdBasedProvider.a(injectorLike, 4156), IdBasedProvider.a(injectorLike, 4104), IdBasedProvider.a(injectorLike, 4242), IdBasedProvider.a(injectorLike, 4090), IdBasedProvider.a(injectorLike, 4093), IdBasedProvider.a(injectorLike, 4243), IdBasedProvider.a(injectorLike, 4314), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), IdBasedLazy.a(injectorLike, 7908), MessageClassifier.a(injectorLike), MessageDeduper.m6606a(injectorLike), MessageDeliveryStatesSoundHelper.m6608a(injectorLike), IdBasedLazy.a(injectorLike, 8883), IdBasedLazy.a(injectorLike, 8884), MessageUserUtil.a(injectorLike), MessageUtil.a(injectorLike), IdBasedLazy.a(injectorLike, 7514), MessagingAnalyticsLogger.a(injectorLike), MessagingPerformanceLogger.a(injectorLike), MessengerSoundUtil.a(injectorLike), MessengerThreadNameViewDataFactory.a(injectorLike), IdBasedLazy.a(injectorLike, 8592), ModifyThreadCustomizationHelper.a(injectorLike), (Clock) DbClock.a(injectorLike), IdBasedLazy.a(injectorLike, 8847), IdBasedLazy.a(injectorLike, 8341), IdBasedLazy.a(injectorLike, 8342), (PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike), PerfTestConfig.a(injectorLike), PlatformLaunchHelper.a(injectorLike), PhotoMessageDataCache.a(injectorLike), ReadThreadManager.a(injectorLike), RecentMessagesTracker.a(injectorLike), RowItemUiUtil.m7015a(injectorLike), RowMessageItemGenerator.m7035a(injectorLike), RtcPresenceHandler.a(injectorLike), RuntimePermissionsUtil.a(injectorLike), SaveDraftManager.a(injectorLike), IdBasedLazy.a(injectorLike, 3731), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), SeenHeadsEligibilityChecker.m8295a(injectorLike), IdBasedLazy.a(injectorLike, 8347), IdBasedLazy.a(injectorLike, 11024), StickersAnimationManager.m6089a(injectorLike), StickerContentSearchExperimentAccessor.a(injectorLike), ThreadParticipantUtils.a(injectorLike), ThreadUnreadCountUtil.a(injectorLike), DefaultThreadViewTheme.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 5011), (ThreadViewMessagesFragmentBannerNotificationControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ThreadViewMessagesFragmentBannerNotificationControllerProvider.class), (ThreadViewMessagesFragmentMessageRequestsControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ThreadViewMessagesFragmentMessageRequestsControllerProvider.class), ThreadViewMessagesFragmentNullStateCallToActionController.m7812a(injectorLike), ThreadViewMessagesFragmentPaymentsHelper.m7832a(injectorLike), ThreadViewMessagesFragmentSendFailuresHelper.m7860a(injectorLike), IdBasedLazy.a(injectorLike, 8869), IdBasedLazy.a(injectorLike, 8009), IdBasedLazy.a(injectorLike, 8599), IdBasedLazy.a(injectorLike, 7707), ThreadViewRowItemCacheForBugReporter.m7900a(injectorLike), (ThreadViewSeenHeadsControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ThreadViewSeenHeadsControllerProvider.class), Toaster.a(injectorLike), UncommittedThreadModificationsCache.m4224a(injectorLike), UnreadMessagesPillController.m8062a(injectorLike), VideoPlayerManager.a(injectorLike), RtcCallHandler.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), XMAViewHostEventDispatcher.a(injectorLike), IdBasedProvider.a(injectorLike, 4063), Random_InsecureRandomMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 7898), IdBasedProvider.a(injectorLike, 4111), GloballyDeletedMessagesPlaceholderCache.a(injectorLike), IdBasedLazy.a(injectorLike, 7629), IdBasedLazy.a(injectorLike, 7561), (MessageSendFailedDataFileProviderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MessageSendFailedDataFileProviderProvider.class), BugReportOperationLogger.a(injectorLike), BlockingAnalyticsLogger.a(injectorLike), AutoContactAddController.m6509a(injectorLike), RemoveMembersHelper.m6996a(injectorLike), MessengerContactRowMenuHelper.m6926a(injectorLike), (ZeroDialogController) FbZeroDialogController.a(injectorLike), SmsContactRowMenuHelper.a(injectorLike), SmsTakeoverStateChecker.m3763a(injectorLike), IdBasedLazy.a(injectorLike, 42), IdBasedLazy.a(injectorLike, 8446), IdBasedLazy.a(injectorLike, 7668), RecentCallsDb.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), SmsDefaultAppManager.a(injectorLike), IdBasedLazy.a(injectorLike, 7872), (XMAActionHandlerManager) MessageXMAActionHandlerManager.m4385a(injectorLike), (MessageEventMonitorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MessageEventMonitorProvider.class), BusinessMessageImpressionListener.a(injectorLike), BusinessPromotionGatekeepers.a(injectorLike), MessageListAccessibilityDelegate.m8105a(injectorLike), CallToActionXMAHandler.a(injectorLike), UserCache.a(injectorLike), FlowerBorderFeature.a(injectorLike), (FlowerBordersDecorationProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FlowerBordersDecorationProvider.class), NotificationSettingsUtil.a(injectorLike), ThreadViewManageMenuHelper.m7361a(injectorLike), IdBasedProvider.a(injectorLike, 4213), QuickReplyMessageUpdater.m1725a(injectorLike), IdBasedLazy.a(injectorLike, 2644), IdBasedLazy.a(injectorLike, 7858), IdBasedLazy.a(injectorLike, 8838), IdBasedLazy.a(injectorLike, 7871));
    }

    private static boolean m7582a(RowMessageItem rowMessageItem) {
        return rowMessageItem.f4732a.l == MessageType.PENDING_SEND && !rowMessageItem.f4738g;
    }

    private static boolean m7597b(RowMessageItem rowMessageItem) {
        return rowMessageItem.f4732a.l == MessageType.REGULAR || rowMessageItem.f4738g;
    }

    private boolean aU() {
        return this.G != null && this.G.K;
    }

    public final void m7676c(Bundle bundle) {
        int i;
        super.c(bundle);
        if (BuildConstants.j) {
            i = 2131625128;
        } else {
            i = 2131625127;
        }
        this.cN = ContextUtils.a(getContext(), 2130772971, i);
        Class cls = ThreadViewMessagesFragment.class;
        m7572a((Object) this, this.cN);
        this.dg = this.aO.a().a(MessagesBroadcastIntents.r, new C11666(this)).a(MessagesBroadcastIntents.z, new C11655(this)).a();
        this.bc.d(3604481, "ThreadViewMessageFragment.onCreateThroughOnResume");
        this.aX.a(5505049, cf(), "onFragmentCreate");
        this.dg.b();
        if (this.cf.a(964, false)) {
            this.ek = (MessageListHelper) this.aT.get();
        } else {
            this.ek = (MessageListHelper) this.aS.get();
        }
        this.dk = this.bw.m7765a(b(null));
        cb();
        this.dk.m7742a();
        this.dl = this.bx.m7810a(s());
        cc();
        cd();
        this.bz.m7844a();
        ce();
        this.aX.a(5505049, cf(), (short) 44);
        this.bZ.a(ZeroFeatureKey.VIDEO_PLAY_INTERSTITIAL, b(2131232932), new C11677(this));
        bQ();
    }

    private void m7536a(FullScreenDialogFragment fullScreenDialogFragment) {
        if (this.y) {
            FullScreenDialogParams.a(this).a(fullScreenDialogFragment.s);
            fullScreenDialogFragment.a(s(), "open_fullscreen_dialog");
        }
    }

    private void bk() {
        if (this.y && z()) {
            this.bQ.b(this.dp);
        }
    }

    public final View m7659a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1704113977);
        this.aX.a(5505049, cf(), "onCreateView");
        View inflate = layoutInflater.cloneInContext(this.cN).inflate(2130905892, viewGroup, false);
        this.f7765b.a(inflate, "thread", this);
        this.aX.a(5505049, cf(), (short) 45);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -840725905, a);
        return inflate;
    }

    public final void m7661a(Fragment fragment) {
        super.a(fragment);
        if (fragment instanceof ComposeFragment) {
            this.dh = (ComposeFragment) fragment;
            this.dh.aO();
            this.dh.bu = new C11688(this);
            this.dh.bt = new C11699(this);
            ((InternalAttributionCallToActionHelper) this.cL.get()).f6980b = this.dh;
        } else if (fragment instanceof PhotoViewFragment) {
            aC();
            ((PhotoViewFragment) fragment).aW = new Object(this) {
                final /* synthetic */ ThreadViewMessagesFragment f7688a;

                {
                    this.f7688a = r1;
                }

                public final void m7401a() {
                    ThreadViewMessagesFragment.bX(this.f7688a);
                }
            };
        } else if (fragment instanceof ThreadThemePickerFragment) {
            final ThreadThemePickerFragment threadThemePickerFragment = (ThreadThemePickerFragment) fragment;
            threadThemePickerFragment.at = new Object(this) {
                final /* synthetic */ ThreadViewMessagesFragment f7690b;

                public final void m7402a(@Nullable CustomThreadTheme customThreadTheme) {
                    this.f7690b.m7535a(customThreadTheme, "like_sticker_fullscreen", threadThemePickerFragment.au);
                    threadThemePickerFragment.a();
                }
            };
        } else if (fragment instanceof HotEmojilikePickerFragment) {
            final HotEmojilikePickerFragment hotEmojilikePickerFragment = (HotEmojilikePickerFragment) fragment;
            hotEmojilikePickerFragment.ax = new Object(this) {
                final /* synthetic */ ThreadViewMessagesFragment f7692b;

                public final void m7403a(@Nullable Emoji emoji) {
                    this.f7692b.m7567a(emoji, "like_sticker_fullscreen", hotEmojilikePickerFragment.ay);
                    hotEmojilikePickerFragment.a();
                }
            };
        } else if (fragment instanceof SetNicknameDialogFragment) {
            ((SetNicknameDialogFragment) fragment).au = new Object(this) {
                final /* synthetic */ ThreadViewMessagesFragment f7693a;

                {
                    this.f7693a = r1;
                }

                public final void m7405a(String str, String str2) {
                    this.f7693a.m7574a(str, str2, this.f7693a.ec);
                }

                public final void m7404a(String str) {
                    this.f7693a.m7574a(str, null, this.f7693a.ec);
                }
            };
        }
    }

    public final void m7679d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1627479139);
        super.d(bundle);
        this.cT = (AdvancedVerticalLinearLayout) e(2131565214);
        this.cU = e(2131565215);
        this.cW = (FrameLayout) e(2131565217);
        this.ek.mo337a(this.cW, (ViewStub) e(2131565218));
        this.ek.mo347a(this.cm);
        this.ek.mo338a(this.bu);
        if (PerfTestConfigBase.a()) {
            this.ek.mo344a(new MessageListListenerForPerfTesting(this));
        } else {
            this.ek.mo344a(new MessageListListener(this));
        }
        this.ek.mo341a(new Object(this) {
            final /* synthetic */ ThreadViewMessagesFragment f7694a;

            {
                this.f7694a = r1;
            }

            public final void m7406a(@Nullable CustomThreadTheme customThreadTheme, @Nullable String str) {
                this.f7694a.m7535a(customThreadTheme, "chat_colors_inline", str);
            }
        });
        this.ek.mo343a(new EmojilikePickerViewListener(this));
        this.ek.mo345a(new NicknamePromptViewListener(this));
        this.ek.mo342a(new BotPromptViewListener(this));
        this.ek.mo354b(this.dM);
        this.cX = (EmptyListViewItem) e(2131565219);
        this.cY = (EmptyListViewItem) e(2131565220);
        this.cZ = e(2131565222);
        UnreadMessagesPillController unreadMessagesPillController = this.bH;
        PillViewStub pillViewStub = (PillViewStub) e(2131565223);
        MessageListHelper messageListHelper = this.ek;
        unreadMessagesPillController.f8153g = pillViewStub;
        unreadMessagesPillController.f8149c = messageListHelper;
        unreadMessagesPillController.f8153g.i = unreadMessagesPillController;
        this.dk.m7743a((ViewStubCompat) e(2131565216));
        this.dk.m7753b((ViewStubCompat) e(2131565230));
        this.dk.m7755c((ViewStubCompat) e(2131565232));
        this.dl.m7805a((ViewStubCompat) e(2131565225));
        this.by.m7821a((ViewStubCompat) e(2131565227));
        this.db = ViewStubHolder.a((ViewStubCompat) e(2131565226));
        this.dc = ViewStubHolder.a((ViewStubCompat) e(2131565228));
        this.dc.c = new OnInflateListener<NewMessageAnchorView>(this) {
            final /* synthetic */ ThreadViewMessagesFragment f7696a;

            /* compiled from: message has app attribution */
            class C11551 implements OnClickListener {
                final /* synthetic */ AnonymousClass15 f7695a;

                C11551(AnonymousClass15 anonymousClass15) {
                    this.f7695a = anonymousClass15;
                }

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1445048055);
                    ((NewMessageAnchorController) this.f7695a.f7696a.cB.get()).m6964a(this.f7695a.f7696a.dc);
                    this.f7695a.f7696a.aB();
                    Logger.a(2, EntryType.UI_INPUT_END, -704925744, a);
                }
            }

            {
                this.f7696a = r1;
            }

            public final void m7407a(View view) {
                ((NewMessageAnchorView) view).setOnClickListener(new C11551(this));
            }
        };
        this.dP = new MenuDialogFragment.Listener(this) {
            final /* synthetic */ ThreadViewMessagesFragment f7697a;

            {
                this.f7697a = r1;
            }

            public final boolean m7408a(MenuDialogItem menuDialogItem, Object obj) {
                if (!(obj instanceof Bundle)) {
                    return false;
                }
                return this.f7697a.m7578a(menuDialogItem, (Message) ((Bundle) obj).getParcelable("rowMessage"));
            }
        };
        this.dU = new MenuDialogFragment.Listener(this) {
            final /* synthetic */ ThreadViewMessagesFragment f7698a;

            {
                this.f7698a = r1;
            }

            public final boolean m7409a(MenuDialogItem menuDialogItem, Object obj) {
                if (!(obj instanceof Bundle)) {
                    return false;
                }
                return this.f7698a.m7577a(menuDialogItem, (ManageBlockingParam) ((Bundle) obj).getParcelable("manageBlockParam"));
            }
        };
        this.cO = this.ek.mo365m();
        this.cP = this.ek.mo369q();
        this.cQ = this.ek.mo367o();
        this.cR = this.ek.mo366n();
        this.cS = this.ek.mo368p();
        aF();
        GiftWrapAnimationManager giftWrapAnimationManager = this.cP;
        AnonymousClass18 anonymousClass18 = new Object(this) {
            final /* synthetic */ ThreadViewMessagesFragment f7699a;

            {
                this.f7699a = r1;
            }

            public final void m7410a(String str) {
                ThreadViewMessagesFragment.m7628i(this.f7699a, str);
            }
        };
        if (anonymousClass18 == null) {
            giftWrapAnimationManager.f6933d.f7226b = null;
        } else {
            giftWrapAnimationManager.f6933d.f7226b = new C10432(giftWrapAnimationManager, anonymousClass18);
        }
        this.ek.mo336a(kO_());
        this.ek.mo340a(new MessageListAdapter.Listener(this) {
            final /* synthetic */ ThreadViewMessagesFragment f7703a;

            public final void mo277a(OtherAttachmentData otherAttachmentData) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("attachment_data", otherAttachmentData);
                DownloadAttachmentDialogFragment downloadAttachmentDialogFragment = new DownloadAttachmentDialogFragment();
                downloadAttachmentDialogFragment.g(bundle);
                downloadAttachmentDialogFragment.a(this.f7703a.s(), "download_attachment_dialog");
            }

            {
                this.f7703a = r1;
            }

            public final void mo284a(RowMessageItem rowMessageItem) {
                ThreadViewMessagesFragment.m7593b(this.f7703a, (RowItem) rowMessageItem);
            }

            public final boolean mo292a(RowItem rowItem) {
                return this.f7703a.m7580a(rowItem, null);
            }

            public final void mo301e() {
                ThreadViewMessagesFragment.bE(this.f7703a);
            }

            public final void mo287a(RowMessageItem rowMessageItem, Share share) {
                this.f7703a.m7542a(rowMessageItem, share);
            }

            public final void mo294b(RowMessageItem rowMessageItem) {
                ThreadViewMessagesFragment.m7610d(this.f7703a, rowMessageItem);
            }

            public final void mo273a() {
                this.f7703a.dn.m7145a(true);
            }

            public final void mo289a(String str) {
                this.f7703a.dH.add(str);
            }

            public final void mo290a(String str, EventTriggerType eventTriggerType) {
                if (eventTriggerType != EventTriggerType.BY_THREAD_VIEW_DISMISS) {
                    this.f7703a.dH.remove(str);
                }
            }

            public final void mo295b(String str) {
                ThreadViewMessagesFragment.m7640l(this.f7703a, "Enter full screen");
                this.f7703a.dI = str;
                this.f7703a.dh.aF();
            }

            public final void mo293b() {
                ThreadViewMessagesFragment.m7640l(this.f7703a, "Exit full screen");
                this.f7703a.dh.aG();
                this.f7703a.dI = null;
            }

            public final void mo278a(VideoAttachmentData videoAttachmentData) {
                ThreadViewMessagesFragment.m7640l(this.f7703a, "Click on full screen video");
                this.f7703a.au();
                this.f7703a.m7534a(videoAttachmentData);
            }

            public final void mo283a(RowItem rowItem, Parcelable parcelable) {
                this.f7703a.m7580a(rowItem, parcelable);
            }

            public final void mo297c(RowMessageItem rowMessageItem) {
                ThreadViewMessagesFragment.m7612e(this.f7703a, rowMessageItem);
            }

            public final void mo296c() {
                ThreadViewMessagesFragment.bF(this.f7703a);
            }

            public final void mo302e(RowMessageItem rowMessageItem) {
                ThreadViewMessagesFragment.m7640l(this.f7703a, "Click on payment");
                this.f7703a.bz.m7856b(rowMessageItem);
            }

            public final void mo298c(String str) {
                this.f7703a.dh.m4960a(str, PaymentFlowType.SEND, null);
            }

            public final void mo288a(ImmutableList<PaymentCard> immutableList, String str, String str2) {
                ThreadViewMessagesFragment.m7640l(this.f7703a, "Click on Add payment card");
                this.f7703a.bz.m7852a(immutableList, this.f7703a, str, str2);
            }

            public final void mo299d() {
                this.f7703a.bz.m7859e();
            }

            public final void mo291a(String str, String str2) {
                this.f7703a.bz.m7853a(str, str2);
            }

            public final void mo282a(PaymentRequestModel paymentRequestModel, String str) {
                ThreadViewMessagesFragmentPaymentsHelper threadViewMessagesFragmentPaymentsHelper = this.f7703a.bz;
                PaymentDialogsBuilder.a(threadViewMessagesFragmentPaymentsHelper.f7884a, threadViewMessagesFragmentPaymentsHelper.f7884a.getResources().getString(2131240565, new Object[]{str}), threadViewMessagesFragmentPaymentsHelper.f7884a.getResources().getString(2131240566, new Object[]{str}), threadViewMessagesFragmentPaymentsHelper.f7884a.getResources().getString(2131240567), new C11945(threadViewMessagesFragmentPaymentsHelper, paymentRequestModel), threadViewMessagesFragmentPaymentsHelper.f7884a.getResources().getString(2131230727), new C11956(threadViewMessagesFragmentPaymentsHelper)).show();
                threadViewMessagesFragmentPaymentsHelper.f7898o.a("p2p_initiate_decline_request", paymentRequestModel);
            }

            public final void mo300d(RowMessageItem rowMessageItem) {
                Message message = rowMessageItem.f4732a;
                ThreadViewMessagesFragment.m7640l(this.f7703a, "Click on sticker: " + message.k);
                if (this.f7703a.f7773i.a(message)) {
                    this.f7703a.m7538a(message);
                } else if (((Boolean) this.f7703a.aM.get()).booleanValue() && message.k != null) {
                    ThreadViewMessagesFragment.m7636k(this.f7703a, message.k);
                } else if (this.f7703a.bq.f6389a.containsKey(StickersAnimationManager.m6090d(message))) {
                    StickersAnimationManager stickersAnimationManager = this.f7703a.bq;
                    String d = StickersAnimationManager.m6090d(message);
                    if (stickersAnimationManager.f6389a.containsKey(d)) {
                        StickerAnimator stickerAnimator = (StickerAnimator) stickersAnimationManager.f6389a.get(d);
                        if (stickerAnimator.e()) {
                            stickerAnimator.c();
                        } else {
                            stickerAnimator.b();
                        }
                    }
                } else {
                    ThreadViewMessagesFragment.m7593b(this.f7703a, (RowItem) rowMessageItem);
                }
            }

            public final void mo285a(RowMessageItem rowMessageItem, AnimatableDrawable animatableDrawable) {
                StickerAnimator stickerAnimator;
                Message message = rowMessageItem.f4732a;
                StickersAnimationManager stickersAnimationManager = this.f7703a.bq;
                String d = StickersAnimationManager.m6090d(message);
                if (stickersAnimationManager.f6389a.containsKey(d)) {
                    stickerAnimator = (StickerAnimator) stickersAnimationManager.f6389a.get(d);
                    if (stickerAnimator.a != animatableDrawable) {
                        stickerAnimator.a = animatableDrawable;
                        stickerAnimator.b.removeAllUpdateListeners();
                        stickerAnimator.b.addUpdateListener(animatableDrawable.a());
                    }
                } else {
                    StickerAnimator stickerAnimator2 = new StickerAnimator(animatableDrawable);
                    if (((Boolean) stickersAnimationManager.f6390b.get()).booleanValue()) {
                        stickerAnimator2.b.setRepeatCount(-1);
                        stickerAnimator2.b.setRepeatMode(1);
                    }
                    stickersAnimationManager.f6389a.put(d, stickerAnimator2);
                }
                stickersAnimationManager = this.f7703a.bq;
                String d2 = StickersAnimationManager.m6090d(message);
                if (stickersAnimationManager.f6389a.containsKey(d2)) {
                    stickerAnimator = (StickerAnimator) stickersAnimationManager.f6389a.get(d2);
                    if (!stickerAnimator.c) {
                        stickerAnimator.b();
                    }
                }
            }

            public final void mo286a(RowMessageItem rowMessageItem, ImageAttachmentData imageAttachmentData) {
                FragmentManager s = this.f7703a.s();
                if (s != null && s.c()) {
                    Message message = rowMessageItem.f4732a;
                    if (((Boolean) this.f7703a.aL.get()).booleanValue() && !this.f7703a.f7770f.c(message)) {
                        ImmutableList bY = ThreadViewMessagesFragment.bY(this.f7703a);
                        if (bY != null) {
                            this.f7703a.bf.a(message.b, bY);
                        }
                    }
                    AnalyticsLogger analyticsLogger = this.f7703a.f7764a;
                    HoneyClientEvent honeyClientEvent = new HoneyClientEvent("click");
                    honeyClientEvent.d = "message_image";
                    honeyClientEvent = honeyClientEvent;
                    honeyClientEvent.e = message.a;
                    analyticsLogger.a(honeyClientEvent.a("thread_key", message.b).a("num_images", this.f7703a.f7770f.f(message)));
                    ThreadViewMessagesFragment.m7640l(this.f7703a, "Click on image");
                    if ((!imageAttachmentData.g ? 1 : null) != null) {
                        PhotoViewFragment.aq().m3436a(message).m3435a(imageAttachmentData).m3437a().a(s, "photo_view_fragment");
                    } else {
                        ThreadViewMessagesFragment.m7593b(this.f7703a, (RowItem) rowMessageItem);
                    }
                }
            }

            public final void mo279a(AttributionViewData attributionViewData) {
                Message a = attributionViewData.a();
                switch (AnonymousClass50.f7750a[attributionViewData.d().ordinal()]) {
                    case 1:
                        ContentAppAttribution contentAppAttribution = a.F;
                        this.f7703a.be.a(contentAppAttribution.b, contentAppAttribution.e);
                        return;
                    case 2:
                    case 3:
                        this.f7703a.be.a(a, this.f7703a, this.f7703a.dx);
                        return;
                    default:
                        InternalAttributionCallToActionHelper internalAttributionCallToActionHelper = (InternalAttributionCallToActionHelper) this.f7703a.cL.get();
                        if (internalAttributionCallToActionHelper.f6980b != null) {
                            switch (C10501.f6978b[attributionViewData.d().ordinal()]) {
                                case 1:
                                    switch (C10501.f6977a[((MediaResource) attributionViewData.a().a().get(0)).e.ordinal()]) {
                                        case 1:
                                            internalAttributionCallToActionHelper.f6980b.aH();
                                            return;
                                        case 2:
                                            internalAttributionCallToActionHelper.f6980b.aI();
                                            return;
                                        default:
                                            return;
                                    }
                                case 2:
                                    ((MessageForwardHandler) internalAttributionCallToActionHelper.f6979a.get()).m2244a(attributionViewData.a(), NavigationTrigger.b(AttributionActionType.MONTAGE_ADD.loggingString));
                                    return;
                                default:
                                    return;
                            }
                        }
                        return;
                }
            }

            public final void mo303f() {
                this.f7703a.dk.m7764l();
            }

            public final void mo305g() {
                this.f7703a.dn.m7144a(0);
            }

            public final void mo306h() {
                this.f7703a.bB.get();
                ThreadViewOperationsHelper.m7877c(this.f7703a.kO_(), this.f7703a.dp);
                this.f7703a.f7764a.a(new HoneyClientEvent("thread_group_upsell_name").a("thread_key", this.f7703a.dp));
            }

            public final void mo307i() {
                ((GroupPhotoSettingsDialogFactory) this.f7703a.aB.get()).m6570a(this.f7703a.dx).show();
                this.f7703a.f7764a.a(new HoneyClientEvent("thread_group_upsell_photo").a("thread_key", this.f7703a.dp));
            }

            public final void mo274a(Intent intent, int i) {
                this.f7703a.bo.a(intent, i, this.f7703a);
            }

            public final void mo276a(View view, UserKey userKey) {
                User a = this.f7703a.co.a(userKey);
                if (a != null && this.f7703a.mx_()) {
                    MenuHandler menuHandler;
                    PopupMenu popupMenu = new PopupMenu(this.f7703a.getContext(), view);
                    ContactPickerUserRowBuilder contactPickerUserRowBuilder = new ContactPickerUserRowBuilder();
                    contactPickerUserRowBuilder.a = a;
                    final ContactPickerUserRow a2 = contactPickerUserRowBuilder.a();
                    if (ThreadKey.d(this.f7703a.dp)) {
                        this.f7703a.ca.f = this.f7703a.dx.g();
                        menuHandler = this.f7703a.ca.a;
                    } else {
                        MessengerContactRowMenuHelper messengerContactRowMenuHelper = this.f7703a.bY;
                        messengerContactRowMenuHelper.f7257p = this.f7703a.dx;
                        boolean z = messengerContactRowMenuHelper.f7257p == null || messengerContactRowMenuHelper.f7257p.a == null || !messengerContactRowMenuHelper.f7257p.a.d();
                        Preconditions.checkArgument(z);
                        menuHandler = this.f7703a.bY.f7253l;
                    }
                    menuHandler.a(a2, popupMenu.b, popupMenu.b());
                    popupMenu.e = new OnMenuItemClickListener(this) {
                        final /* synthetic */ AnonymousClass19 f7702c;

                        public final boolean m7411a(MenuItem menuItem) {
                            return menuHandler.a(menuItem, a2);
                        }
                    };
                    menuHandler.a(view);
                    this.f7703a.aA.m2350a(this.f7703a.dx, "tile_menu");
                    popupMenu.c();
                }
            }

            public final void mo275a(View view) {
                ThreadViewMessagesFragment.bJ(this.f7703a);
                this.f7703a.ej.a(view);
            }

            public final void mo280a(ManageBlockingParam manageBlockingParam) {
                this.f7703a.m7662a(manageBlockingParam);
            }

            public final void mo281a(RideServiceParams rideServiceParams) {
                ((RideOauthHelper) this.f7703a.cI.get()).a(rideServiceParams);
            }

            public final void mo304f(RowMessageItem rowMessageItem) {
                this.f7703a.m7602c(rowMessageItem);
            }
        });
        AnonymousClass20 anonymousClass20 = new Object(this) {
            final /* synthetic */ ThreadViewMessagesFragment f7705a;

            {
                this.f7705a = r1;
            }

            public final void m7448a(User user, Boolean bool) {
                if (bool.booleanValue()) {
                    ((LaunchTimelineHelper) this.f7705a.bC.get()).a(user, this.f7705a.D);
                }
            }
        };
        aK();
        MessengerContactRowMenuHelper messengerContactRowMenuHelper = this.bY;
        RemoveMembersHelper removeMembersHelper = this.bX;
        FragmentManager fragmentManager = this.D;
        messengerContactRowMenuHelper.f7254m = removeMembersHelper;
        messengerContactRowMenuHelper.f7255n = anonymousClass20;
        messengerContactRowMenuHelper.f7256o = fragmentManager;
        this.cX.setVisibility(8);
        this.cQ.f8189i = this.ek;
        this.cR.f7037f = this.ek;
        this.cS.f7343b = this.ek;
        aQ();
        if (this.cp.c()) {
            FlowerBordersDecorationProvider flowerBordersDecorationProvider = this.cq;
            this.ea = new FlowerBordersDecoration(IdBasedProvider.a(flowerBordersDecorationProvider, 7979), this.ek, ResourcesMethodAutoProvider.a(flowerBordersDecorationProvider));
            this.ek.mo346a(this.ea);
        }
        this.ek.mo334a().setOnCreateContextMenuListener(this);
        bP();
        this.dk.m7744a((ViewGroup) e(2131565214));
        this.f7768do = new OnGlobalFocusChangeListener(this) {
            final /* synthetic */ ThreadViewMessagesFragment f7706a;

            {
                this.f7706a = r1;
            }

            public void onGlobalFocusChanged(View view, View view2) {
                ThreadViewMessagesFragment.m7591b(this.f7706a, view2);
            }
        };
        this.di = this.dh.T;
        this.dh.m4954a(ComposeMode.SHRUNK);
        aS(this);
        aY();
        this.am.s = new CanonicalThreadPresenceHelper.Listener(this) {
            final /* synthetic */ ThreadViewMessagesFragment f7707a;

            {
                this.f7707a = r1;
            }

            public final void m7449a(PresenceState presenceState) {
                this.f7707a.m7565a(presenceState);
            }
        };
        this.dd = new Handler(Looper.getMainLooper());
        Bundle bundle2 = this.s;
        if (bundle2 != null && bundle2.getBoolean("chatStyle", false)) {
            this.dL = true;
        }
        if (bundle != null) {
            m7643n(bundle);
        }
        aN(this);
        this.bu.a(this.cv);
        this.de = true;
        ba();
        if (this.dW != null) {
            m7667a(this.dW, null);
            this.dW = null;
        }
        this.cQ.f8190j = new Object(this) {
            final /* synthetic */ ThreadViewMessagesFragment f7708a;

            {
                this.f7708a = r1;
            }

            public final void m7450a() {
                ThreadViewMessagesFragment.bh(this.f7708a);
            }

            public final void m7451a(String str, String str2) {
                if (ThreadViewMessagesFragment.aL(this.f7708a)) {
                    this.f7708a.cQ.m8093a();
                }
                this.f7708a.dh.m4961a(str, str2);
                ComposeFragment.bd(this.f7708a.dh);
            }

            public final void m7452b() {
                ThreadViewMessagesFragment.bh(this.f7708a);
            }
        };
        e(true);
        this.be.v = new PlatformLaunchHelper.Listener(this) {
            final /* synthetic */ ThreadViewMessagesFragment f7709a;

            {
                this.f7709a = r1;
            }

            public final void m7453a(ThreadKey threadKey, String str, List<MediaResource> list, ContentAppAttribution contentAppAttribution) {
                Message b;
                if (ThreadKey.d(threadKey)) {
                    b = ((OutgoingMessageFactory) this.f7709a.cC.get()).b(threadKey, str, list, contentAppAttribution);
                } else {
                    b = ((OutgoingMessageFactory) this.f7709a.cC.get()).a(threadKey, str, list, contentAppAttribution);
                }
                this.f7709a.m7539a(b, MessageSendTrigger.PLATFORM_APP);
            }
        };
        this.aX.a(5505049, cf(), (short) 46);
        LogUtils.f(-320743344, a);
    }

    private void aF() {
        aG();
        aH();
        aI();
        aJ();
    }

    private void aG() {
        this.el = new XMAActionHandler<Message>(this) {
            final /* synthetic */ ThreadViewMessagesFragment f7710a;

            {
                this.f7710a = r1;
            }

            public final boolean m7454a(Object obj, XMAAction xMAAction, View view) {
                Bundle bundle = (Bundle) xMAAction.a("extra_location_map_details");
                this.f7710a.m7536a(LocationMapDialogFragment.m2989a(bundle.getString("title"), bundle.getString("description"), bundle.getDouble("latitude"), bundle.getDouble("longitude"), ((Message) obj).b));
                return true;
            }
        };
        this.ci.a(this.el, "xma_action_view_map");
    }

    private void aH() {
        this.ci.a(this.cn, "xma_action_cta_clicked");
    }

    private void aI() {
        this.em = new XMAActionHandler<Message>(this) {
            final /* synthetic */ ThreadViewMessagesFragment f7711a;

            {
                this.f7711a = r1;
            }

            public final boolean m7455a(Object obj, XMAAction xMAAction, View view) {
                if ("xma_action_send_message".equals(xMAAction)) {
                    String string = xMAAction.c.getString("extra_message_text", null);
                    this.f7711a.at();
                    ComposerInitParamsBuilder composerInitParamsBuilder = new ComposerInitParamsBuilder();
                    composerInitParamsBuilder.f5433a = string;
                    this.f7711a.dh.m4956a(composerInitParamsBuilder.m5014i());
                    return true;
                } else if (!"xma_action_leave_conversation".equals(xMAAction)) {
                    return false;
                } else {
                    Preconditions.checkNotNull(this.f7711a.dx);
                    this.f7711a.aA.m2350a(this.f7711a.dx, "xma_leave_converation");
                    ((GroupThreadActionHandler) this.f7711a.ch.get()).m2575a(this.f7711a.D, this.f7711a.dx);
                    return true;
                }
            }
        };
        this.ci.a(this.em, "xma_action_send_message");
        this.ci.a(this.em, "xma_action_leave_conversation");
    }

    private void aJ() {
        this.en = new XMAActionHandler<Message>(this) {
            final /* synthetic */ ThreadViewMessagesFragment f7712a;

            {
                this.f7712a = r1;
            }

            public final boolean m7456a(Object obj, XMAAction xMAAction, View view) {
                Bundle bundle = (Bundle) xMAAction.a("extra_boarding_pass");
                bundle.putParcelable("message", (Message) obj);
                Intent a = BusinessActivity.a(this.f7712a.getContext(), "AirlineBoardingPassDetailFragment", bundle);
                a.setFlags(67108864);
                this.f7712a.bo.a(a, this.f7712a.getContext());
                return true;
            }
        };
        this.ci.a(this.en, "xma_action_view_boarding_pass");
    }

    private void m7538a(Message message) {
        String str;
        BballGameAnalyticsLogger bballGameAnalyticsLogger = this.f7772h;
        boolean P = bballGameAnalyticsLogger.b.P(message);
        if (!MessageUtil.K(message)) {
            str = "emoji_message";
        } else if (message.I.t) {
            str = "high_score_message";
        } else {
            str = "played_message";
        }
        bballGameAnalyticsLogger.a.a(BballGameAnalyticsLogger.a("msgr_bball_start").b("thread_key", message.b.h()).a("is_own_message", P).b("source", str));
        this.bo.a(BballActivity.a(getContext(), this.dp), getContext());
    }

    private void aK() {
        this.bX.f7363c = new RemoveMembersHelper.Listener(this) {
            final /* synthetic */ ThreadViewMessagesFragment f7714a;

            /* compiled from: message has app attribution */
            class C11581 implements DialogInterface.OnClickListener {
                final /* synthetic */ AnonymousClass28 f7713a;

                C11581(AnonymousClass28 anonymousClass28) {
                    this.f7713a = anonymousClass28;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }

            {
                this.f7714a = r1;
            }

            public final void mo213a() {
            }

            public final void mo214a(ServiceException serviceException) {
                ErrorDialogs errorDialogs = this.f7714a.at;
                ErrorDialogParamsBuilder b = ErrorDialogParams.a(this.f7714a.jW_()).a(2131230721).b(2131230762);
                b.g = new C11581(this);
                errorDialogs.a(b.l());
            }
        };
    }

    public static boolean aL(ThreadViewMessagesFragment threadViewMessagesFragment) {
        if (threadViewMessagesFragment.dp != null && threadViewMessagesFragment.dp.b()) {
            return false;
        }
        User a = threadViewMessagesFragment.co.a(ThreadKey.a(threadViewMessagesFragment.dp));
        if (a != null && a.I) {
            return true;
        }
        if (((Boolean) threadViewMessagesFragment.bP.get()).booleanValue()) {
            return threadViewMessagesFragment.aM();
        }
        return false;
    }

    private boolean aM() {
        return this.ds == TriState.NO && this.dt == GraphQLMessageThreadCannotReplyReason.BLOCKED;
    }

    public static void aN(ThreadViewMessagesFragment threadViewMessagesFragment) {
        int f = threadViewMessagesFragment.bu.f();
        if (f == -1) {
            f = 0;
        }
        threadViewMessagesFragment.ek.mo334a().setBackgroundDrawable(new ColorDrawable(f));
    }

    public final void m7684g(int i) {
        this.dh.m4974g(i);
    }

    public static void aO(ThreadViewMessagesFragment threadViewMessagesFragment) {
        String g = threadViewMessagesFragment.bu.g();
        if (!Objects.equal(g, threadViewMessagesFragment.eb)) {
            threadViewMessagesFragment.eb = g;
            threadViewMessagesFragment.dh.m4958a(threadViewMessagesFragment.eb);
        }
    }

    public final void m7660a(int i, int i2, Intent intent) {
        switch (i) {
            case 1000:
                this.bz.m7845a(i, i2, intent);
                break;
            case 1001:
                this.bz.m7855b(i, i2, intent);
                break;
            case 1003:
                this.be.a(intent, this.dp, this);
                break;
            case 10001:
                this.bz.m7846a(intent);
                break;
        }
        super.a(i, i2, intent);
    }

    public static List aP(ThreadViewMessagesFragment threadViewMessagesFragment) {
        List arrayList = new ArrayList();
        int e = threadViewMessagesFragment.ek.mo357e();
        int f = threadViewMessagesFragment.ek.mo358f();
        for (int i = e; i < f; i++) {
            RowItem a = threadViewMessagesFragment.ek.mo335a(i);
            if (a != null && a.mo131b() == RowType.MESSAGE) {
                RowMessageItem rowMessageItem = (RowMessageItem) a;
                Message message = rowMessageItem.f4732a;
                if (!(message == null || message.n == null)) {
                    arrayList.add(rowMessageItem.f4732a.n);
                }
            }
        }
        return arrayList;
    }

    private void aQ() {
        if (this.dx != null && this.ek != null) {
            boolean z;
            boolean a = this.bp.m8297a(this.dx.h.size(), this.dx.A);
            if (a != this.dZ) {
                if (a) {
                    aR();
                    this.ek.mo346a(this.dY);
                } else {
                    this.ek.mo353b(this.dY);
                }
                m7625h(a);
                if (this.dw != null) {
                    bh(this);
                }
            }
            if (this.dx.h.size() > this.bp.f8335a) {
                z = true;
            } else {
                z = false;
            }
            this.cO.f7410d = z;
        }
    }

    private void m7625h(boolean z) {
        this.dZ = z;
        this.ek.mo350a(z);
    }

    private void aR() {
        if (this.cV == null) {
            ThreadViewSeenHeadsControllerProvider threadViewSeenHeadsControllerProvider = this.bE;
            this.cV = new ThreadViewSeenHeadsController((SeenHeadsDecorationProvider) threadViewSeenHeadsControllerProvider.getOnDemandAssistedProviderForStaticDi(SeenHeadsDecorationProvider.class), this.ek);
            this.dY = this.cV.f8337a;
            this.dY.f8332k = new Object(this) {
                final /* synthetic */ ThreadViewMessagesFragment f7715a;

                {
                    this.f7715a = r1;
                }

                public final void m7459a(long j) {
                    this.f7715a.m7530a(j);
                }
            };
        }
    }

    public static void aS(ThreadViewMessagesFragment threadViewMessagesFragment) {
        boolean z = threadViewMessagesFragment.cT.b;
        if (threadViewMessagesFragment.ef != z) {
            threadViewMessagesFragment.ef = z;
            if (threadViewMessagesFragment.dn != null) {
                threadViewMessagesFragment.dn.m7143a();
            }
        }
        int b = threadViewMessagesFragment.dh.m4964b();
        threadViewMessagesFragment.dj = b > 0;
        LayoutParams layoutParams = (LayoutParams) threadViewMessagesFragment.di.getLayoutParams();
        if (layoutParams.b != b) {
            layoutParams.b = b;
            threadViewMessagesFragment.di.setLayoutParams(layoutParams);
            ViewGroup a = threadViewMessagesFragment.ek.mo334a();
            if (a != null) {
                a.setPadding(0, 0, 0, b);
            }
        }
    }

    public final void m7658I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 968720395);
        super.I();
        this.am.a(false);
        this.dn = null;
        this.dg.c();
        this.dk.m7756d();
        this.bz.m7854b();
        this.bu.b(this.cv);
        this.ci.a(this.el);
        this.ci.a(this.cn);
        this.ci.a(this.em);
        this.ci.a(this.en);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -261438481, a);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2107862086);
        this.aX.a(5505049, cf(), "onStart");
        super.mi_();
        this.am.a(true);
        m7566a(this.am.r, false);
        this.aX.a(5505049, cf(), (short) 47);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 837201115, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 111335425);
        super.mj_();
        this.am.a(false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1346081795, a);
    }

    public final void m7656G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 928528572);
        super.G();
        if (!ChatHeadsContextDetector.a(getContext())) {
            this.bJ.g();
        }
        SmsTakeoverStateChecker smsTakeoverStateChecker = this.cb;
        smsTakeoverStateChecker.f4106n++;
        if (smsTakeoverStateChecker.f4106n == 1 && (smsTakeoverStateChecker.f4095c.b() || smsTakeoverStateChecker.f4095c.c())) {
            ((ReadOnlyModeObserver) smsTakeoverStateChecker.f4100h.get()).a(true);
        }
        this.T.getViewTreeObserver().addOnGlobalFocusChangeListener(this.f7768do);
        this.dk.m7752b();
        this.aX.a(5505049, cf());
        this.bc.c(3604481, "ThreadViewMessageFragment.onCreateThroughOnResume");
        if (!this.dH.isEmpty()) {
            ImmutableList bV = bV();
            int size = bV.size();
            for (int i = 0; i < size; i++) {
                ((VideoMessageContainer) bV.get(i)).mo265a(this.dH);
            }
        }
        this.bQ.j = new Object(this) {
            final /* synthetic */ ThreadViewMessagesFragment f7717a;

            {
                this.f7717a = r1;
            }

            public final void m7461a() {
                ThreadViewMessagesFragment.bh(this.f7717a);
            }
        };
        this.bQ.b(this.dp);
        GloballyDeletedMessagesPlaceholderCache globallyDeletedMessagesPlaceholderCache = this.bQ;
        if (globallyDeletedMessagesPlaceholderCache.j != null && globallyDeletedMessagesPlaceholderCache.k) {
            globallyDeletedMessagesPlaceholderCache.j.m7461a();
            globallyDeletedMessagesPlaceholderCache.k = false;
        }
        this.be.a(this);
        for (XMAViewHostEventListener xMAViewHostEventListener : this.bL.a.keySet()) {
            if (xMAViewHostEventListener != null) {
                xMAViewHostEventListener.a();
            }
        }
        if (bp() && ((this.dw == null || this.dw.f()) && !((AgentTermsStatusHelper) this.bS.get()).m1467c())) {
            bm(this);
        }
        if (ThreadKey.d(this.dp)) {
            this.cb.m3768a(this.f7769e);
            if (this.dN) {
                ch();
                this.dN = false;
            }
        }
        if (this.dm != null) {
            this.dm.c = true;
            this.dm.d = aT();
        }
        LogUtils.f(3549135, a);
    }

    public final void m7657H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2055703138);
        super.H();
        SmsTakeoverStateChecker smsTakeoverStateChecker = this.cb;
        smsTakeoverStateChecker.f4106n--;
        if (smsTakeoverStateChecker.f4106n == 0 && (smsTakeoverStateChecker.f4095c.b() || smsTakeoverStateChecker.f4095c.c())) {
            ((ReadOnlyModeObserver) smsTakeoverStateChecker.f4100h.get()).a(false);
        }
        this.aX.d.e(5505025);
        this.dk.m7754c();
        this.T.getViewTreeObserver().removeOnGlobalFocusChangeListener(this.f7768do);
        bx(this);
        m7681e();
        aW();
        this.dd.removeCallbacksAndMessages(null);
        if (ChatHeadsContextDetector.a(getContext())) {
            this.bJ.g();
        }
        this.bQ.j = null;
        bU(this);
        this.bc.a(3604481, "ThreadViewMessageFragment.onCreateThroughOnResume");
        for (XMAViewHostEventListener xMAViewHostEventListener : this.bL.a.keySet()) {
            if (xMAViewHostEventListener != null) {
                xMAViewHostEventListener.b();
            }
        }
        AgentTermsStatusHelper agentTermsStatusHelper = (AgentTermsStatusHelper) this.bS.get();
        if (agentTermsStatusHelper.f1483h.compareAndSet(true, false)) {
            agentTermsStatusHelper.f1482g.dismiss();
        }
        this.cm.b();
        m7618f("onPause");
        if (this.dm != null) {
            this.dm.c = false;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 54222354, a);
    }

    public final void m7685g(boolean z) {
        super.g(z);
        if (this.dm != null) {
            this.dm.d = aT();
        }
    }

    private void m7618f(String str) {
        Runnable runnable;
        do {
            synchronized (this.ep) {
                runnable = this.ep.isEmpty() ? null : (Runnable) this.ep.remove(0);
            }
            if (runnable != null) {
                HandlerDetour.a(this.dd, runnable, 498647487);
                continue;
            }
        } while (runnable != null);
    }

    public final void m7682e(Bundle bundle) {
        super.e(bundle);
        bundle.putSerializable("composeMode", this.dq);
        bundle.putSerializable("canReplyTo", this.ds);
        bundle.putString("cannotReplyReason", this.dt.toString());
        bundle.putParcelable("trigger", this.dJ);
    }

    public final void m7678c(boolean z) {
        super.c(z);
        if (this.y && z) {
            m7681e();
            aq();
        }
    }

    private boolean aT() {
        return D() && z() && !aU();
    }

    private void aV() {
        if (this.dI != null) {
            ImmutableList bV = bV();
            int size = bV.size();
            for (int i = 0; i < size; i++) {
                ((VideoMessageContainer) bV.get(i)).mo267d();
            }
        }
    }

    public final void m7671a(boolean z) {
        this.df = z;
        if (z) {
            this.cQ.m8093a();
            this.dh.as();
        } else {
            this.dh.at();
        }
        for (XMAViewHostEventListener xMAViewHostEventListener : this.bL.a.keySet()) {
            if (xMAViewHostEventListener != null) {
                xMAViewHostEventListener.a(z);
            }
        }
    }

    public final boolean m7675b() {
        this.cQ.m8093a();
        return this.dh.au();
    }

    public static void m7590b(ThreadViewMessagesFragment threadViewMessagesFragment, Intent intent) {
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("multiple_thread_keys");
        Bundle bundleExtra = intent.getBundleExtra("thread_update_bundles");
        if (parcelableArrayListExtra.contains(threadViewMessagesFragment.dp)) {
            if (threadViewMessagesFragment.dx != null) {
                threadViewMessagesFragment.dx = threadViewMessagesFragment.bG.m4229a(threadViewMessagesFragment.dx);
            }
            List<Bundle> parcelableArrayList = bundleExtra.getParcelableArrayList(threadViewMessagesFragment.dp.g());
            if (parcelableArrayList != null) {
                for (Bundle bundle : parcelableArrayList) {
                    if (((ThreadUpdateCause) bundle.getSerializable("broadcast_cause")) == ThreadUpdateCause.DELIVERY_RECEIPT) {
                        Iterable stringArrayList = bundle.getStringArrayList("message_ids");
                        MessagesReliabilityLogger messagesReliabilityLogger = (MessagesReliabilityLogger) threadViewMessagesFragment.cz.get();
                        ThreadKey threadKey = threadViewMessagesFragment.dp;
                        Map a = LoggerMapUtils.a(new String[0]);
                        MessagesReliabilityLogger.a(a, threadKey);
                        if (stringArrayList != null) {
                            a.put("message_id", Joiner.on(",").join(stringArrayList));
                        }
                        messagesReliabilityLogger.f.a("delivery_receipt_rendered", null, a, null, null, null);
                    }
                }
            }
            bh(threadViewMessagesFragment);
        }
    }

    public final void m7681e() {
        this.f7771g.a();
    }

    private void aW() {
        this.bI.a(EventTriggerType.BY_THREAD_VIEW_DISMISS);
    }

    public final void aq() {
        this.bI.b(EventTriggerType.BY_THREAD_VIEW_DISMISS);
    }

    public final void ar() {
        this.dk.m7761i();
    }

    private void aX() {
        Fragment a = s().a("resend_dialog");
        if (a instanceof DialogFragment) {
            ((DialogFragment) a).a();
        }
        a = s().a("message_menu_dialog");
        if (a instanceof DialogFragment) {
            ((DialogFragment) a).b();
        }
    }

    public final void m7664a(ThreadKey threadKey, Name name) {
        if (Objects.equal(threadKey, this.dp) && !Objects.equal(name, this.dr)) {
            m7568a(name);
            bP();
        }
        this.dk.m7763k();
    }

    public final void m7674b(boolean z) {
        this.dM = z;
        if (this.ek != null) {
            this.ek.mo354b(z);
        }
    }

    public final void m7663a(ThreadKey threadKey) {
        boolean z = true;
        if (!Objects.equal(threadKey, this.dp)) {
            boolean z2;
            Preconditions.checkNotNull(threadKey);
            Preconditions.checkArgument(!threadKey.d());
            aB();
            TracerDetour.a("ThreadViewMF.setThreadKey", -1498353240);
            try {
                z2 = this.dp != null && this.dp.f() && threadKey.equals(((PendingThreadsManager) this.cD.get()).d(this.dp));
            } catch (PendingThreadException e) {
                z2 = false;
            }
            if (z2) {
                z = false;
            }
            try {
                m7637k(z);
                this.dp = threadKey;
                this.dA = null;
                this.dB = 0;
                this.dV = null;
                this.dr = null;
                if (this.cQ != null) {
                    this.cQ.m8093a();
                }
                aY();
                this.dk.m7746a(this.dp);
                this.dk.m7763k();
                if (this.ei != null) {
                    this.ei.a();
                }
                this.bW.m6512a(this.dp);
                bP();
                Intent intent = new Intent(MessagesBroadcastIntents.u);
                intent.putExtra("thread_key", threadKey);
                this.aO.a(intent);
                this.by.m7822a(this.dp, this.co.a(ThreadKey.a(this.dp)));
                if (this.dm != null) {
                    this.dm.a();
                }
                TracerDetour.a(-622871533);
            } catch (Throwable th) {
                TracerDetour.a(-1925352967);
            }
        }
    }

    public final void m7668a(@Nullable ThreadViewMessagesInitParams threadViewMessagesInitParams) {
        if (threadViewMessagesInitParams != null) {
            if (this.di != null) {
                at();
                this.dh.m4956a(threadViewMessagesInitParams.f7904a);
            } else {
                this.dV = threadViewMessagesInitParams.f7904a;
            }
            this.bz.m7851a(threadViewMessagesInitParams);
            this.bA.m7862a(getContext(), threadViewMessagesInitParams);
        }
    }

    private void aY() {
        if (this.dh != null && this.dp != null) {
            this.dh.m4951a(this.dp);
            if (this.dV != null) {
                at();
                this.dh.m4956a(this.dV);
                this.dV = null;
                return;
            }
            this.dh.aA();
        }
    }

    @Nullable
    private User aZ() {
        if (this.dp == null || this.dp.a != Type.ONE_TO_ONE) {
            return null;
        }
        return this.co.a(UserKey.b(Long.toString(this.dp.d)));
    }

    public final void m7669a(String str) {
        this.dk.m7751a(str);
    }

    private void ba() {
        this.dO = (MenuDialogFragment) s().a("message_menu_dialog");
        if (this.dO != null) {
            this.dO.an = this.dP;
        }
        this.dR = (AskToOpenThreadDialogFragment) s().a("ask_to_open_dialog");
        if (this.dR != null) {
            this.dR.aq = this.dS;
        }
        this.dT = (MenuDialogFragment) s().a("manage_message_menu_dialog");
        if (this.dT != null) {
            this.dT.an = this.dU;
        }
    }

    private void m7643n(Bundle bundle) {
        this.dq = (ComposeMode) bundle.getSerializable("composeMode");
        this.ds = (TriState) bundle.getSerializable("canReplyTo");
        this.dt = GraphQLMessageThreadCannotReplyReason.fromString(bundle.getString("cannotReplyReason"));
        if (this.dq != ComposeMode.SHRUNK) {
            at();
        }
        if (bundle.containsKey("trigger")) {
            this.dJ = (NavigationTrigger) bundle.getParcelable("trigger");
        }
    }

    public static void m7591b(ThreadViewMessagesFragment threadViewMessagesFragment, View view) {
        Object obj = null;
        ViewParent parent = view != null ? view.getParent() : null;
        while (parent != null) {
            if (parent == threadViewMessagesFragment.di) {
                obj = 1;
                break;
            }
            parent = parent.getParent();
        }
        if (obj != null) {
            threadViewMessagesFragment.at();
        }
    }

    public final void as() {
        m7541a(MessageListAdapter.f7174c);
    }

    private void m7541a(@Nullable RowItem rowItem) {
        this.ek.mo339a(rowItem);
    }

    private boolean bb() {
        if (this.dl.m7809b() || this.by.m7823a()) {
            return false;
        }
        return ((Boolean) this.bP.get()).booleanValue() ? this.ds != TriState.NO || this.dt == GraphQLMessageThreadCannotReplyReason.BLOCKED : this.ds != TriState.NO;
    }

    public final void at() {
        if (bb()) {
            this.di.setVisibility(0);
            m7543a(ComposeMode.EXPANDED);
            this.dq = ComposeMode.EXPANDED;
            aB();
        }
    }

    public final void au() {
        if (!bb()) {
            return;
        }
        if (this.dq != ComposeMode.SHRUNK || this.di.getVisibility() == 8) {
            this.di.setVisibility(0);
            m7543a(ComposeMode.SHRUNK);
            this.dq = ComposeMode.SHRUNK;
            this.cU.requestFocus();
            this.aC.hideSoftInputFromWindow(this.cU.getWindowToken(), 0);
        }
    }

    private void bc() {
        this.di.setVisibility(8);
        m7543a(ComposeMode.SHRUNK);
        this.cU.requestFocus();
        this.aC.hideSoftInputFromWindow(this.cU.getWindowToken(), 0);
    }

    public static void bd(ThreadViewMessagesFragment threadViewMessagesFragment) {
        if (threadViewMessagesFragment.bb() && threadViewMessagesFragment.di.getVisibility() == 8) {
            threadViewMessagesFragment.au();
        } else if (!threadViewMessagesFragment.bb() && threadViewMessagesFragment.di.getVisibility() != 8) {
            threadViewMessagesFragment.bc();
        }
    }

    private void m7543a(ComposeMode composeMode) {
        this.dh.m4954a(composeMode);
        this.dk.m7759g();
        this.cT.requestLayout();
    }

    public final ComposeFragment av() {
        return this.dh;
    }

    public final void m7673b(String str) {
        if (this.dx != null) {
            this.dG.add(str);
            bh(this);
        }
    }

    public final void m7670a(String str, boolean z) {
        if (this.dx != null) {
            if (z) {
                this.cS.m6979a(str);
            }
            m7621g(str);
        }
    }

    private void be() {
        ImmutableList immutableList = this.dw.b;
        int size = immutableList.size();
        int i = 0;
        while (i < size) {
            Message message = (Message) immutableList.get(i);
            if (message.c <= this.dB) {
                break;
            } else if (message.I == null || !message.I.o()) {
                i++;
            } else {
                this.dA = message;
                if (this.dC != null) {
                    this.dC.m7139a();
                }
            }
        }
        if (this.dw.c() != null) {
            this.dB = this.dw.c().c;
        }
    }

    public final boolean aw() {
        if (this.dp == null || this.dp.a != Type.GROUP) {
            return false;
        }
        if (((Boolean) this.ct.get()).booleanValue()) {
            if (this.dx == null || !this.dx.E.a()) {
                return false;
            }
            return true;
        } else if (this.dA == null || this.dA.I == null) {
            return false;
        } else {
            boolean z;
            if (StringUtil.a(this.dA.I.m) || !this.dA.I.m.contentEquals("call_started")) {
                z = false;
            } else {
                z = true;
            }
            return z;
        }
    }

    @Nullable
    public final String ax() {
        if (this.dA == null || this.dA.I == null) {
            return null;
        }
        return this.dA.I.n;
    }

    public final void m7667a(Result result, @Nullable Source source) {
        if (this.de) {
            this.dX = result;
            this.cY.setVisibility(8);
            this.by.m7822a(this.dp, this.co.a(ThreadKey.a(this.dp)));
            if (result.f7611a == this.dx && result.f7613c == this.dw && result.f7614d == this.dy && this.bG.m4232a(this.dp, this.dE) && !((SendMessageManager) this.cE.get()).b() && !bp()) {
                this.dk.m7760h();
                return;
            }
            TracerDetour.a("TVMF.update", -1014683484);
            try {
                boolean b = m7598b(result);
                m7544a(result);
                m7629i(b);
                this.dk.m7763k();
                if (b) {
                    this.dk.m7748a(source);
                }
                TracerDetour.a(-2084527529);
            } catch (Throwable th) {
                TracerDetour.a(925817010);
            }
        } else {
            this.dW = result;
        }
    }

    private void m7629i(boolean z) {
        bd(this);
        this.dh.aE();
        this.dl.m7806a(this.ds);
        if (bb() || this.dl.m7808a() || this.by.m7824b() || ThreadKey.d(this.dp)) {
            this.db.e();
        } else {
            bf();
        }
        bh(this);
        if (z) {
            bg();
        }
        if (this.eo || !ChatHeadsContextDetector.a(getContext())) {
            this.bH.m8067a(this.dx);
        }
    }

    private void bf() {
        if (((Boolean) this.aD.get()).booleanValue()) {
            ((BlockComposerView) this.db.a()).setParams(BlockComposerViewParamsFactory.m1693a(this.dp));
            this.db.f();
            return;
        }
        bZ();
    }

    public final void m7677c(String str) {
        this.cY.setVisibility(0);
        this.cY.a(false);
        this.cY.setMessage(str);
    }

    private void m7544a(Result result) {
        TracerDetour.a("ThreadViewMessagesFragment.forceUpdateMessageListState", -246787311);
        try {
            m7540a(result.f7611a);
            if (this.dw != result.f7613c) {
                this.dw = result.f7613c;
                this.dF = MessageDeduper.m6607a(this.dw, this.dE);
            }
            if (this.dw != null) {
                Message c = this.dw.c();
                this.bh.a(RecentMessageSource.LOADED_BY_THREADVIEW, c);
                ((NewMessageAnchorController) this.cB.get()).m6963a(c, result.f7611a.D, bN(), this.dc);
                if (this.dp != null && c != null && this.dp.a == Type.GROUP && c.c > this.dB) {
                    be();
                }
            }
            ca();
            this.dy = result.f7614d;
            this.dD = null;
            this.dh.ay();
            this.am.a(this.aZ.a(this.dx));
            if (this.dx != null) {
                this.ds = this.dx.u ? TriState.YES : TriState.NO;
                this.dt = this.dx.v;
            } else {
                this.ds = TriState.YES;
                this.dt = GraphQLMessageThreadCannotReplyReason.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            }
            this.by.m7822a(this.dp, this.co.a(ThreadKey.a(this.dp)));
        } finally {
            TracerDetour.a(-1294305385);
        }
    }

    private boolean m7598b(Result result) {
        return this.dx == null || result.f7611a == null || !Objects.equal(result.f7611a.a, this.dx.a);
    }

    private void bg() {
        this.am.a(true);
        m7566a(this.am.r, false);
    }

    public static void bh(ThreadViewMessagesFragment threadViewMessagesFragment) {
        TracerDetour.a("ThreadViewMessagesFragment.forceUpdateMessageListUI", -1806578682);
        try {
            ScrollState bt = threadViewMessagesFragment.bt();
            if (threadViewMessagesFragment.dx != null || threadViewMessagesFragment.dy != null) {
                threadViewMessagesFragment.bl();
                if (!threadViewMessagesFragment.dF.isEmpty()) {
                    threadViewMessagesFragment.cm.m8106a((Message) threadViewMessagesFragment.dF.get(threadViewMessagesFragment.dF.size() - 1));
                }
                threadViewMessagesFragment.dz = threadViewMessagesFragment.by();
                threadViewMessagesFragment.bk();
                threadViewMessagesFragment.m7596b(threadViewMessagesFragment.dz);
                threadViewMessagesFragment.m7575a(threadViewMessagesFragment.dz);
                threadViewMessagesFragment.ed = bt;
                threadViewMessagesFragment.ek.mo334a().getViewTreeObserver().addOnPreDrawListener(threadViewMessagesFragment.ee);
                threadViewMessagesFragment.du = false;
                TracerDetour.a(-1558228712);
            }
        } finally {
            TracerDetour.a(-450309323);
        }
    }

    private void bi() {
        TracerDetour.a("ThreadViewMessagesFragment.forceUpdateMessageListUIForPendingSend", -96532825);
        try {
            ScrollState bt = bt();
            if (this.dx != null || this.dy != null) {
                bl();
                this.dz = bj();
                bk();
                m7596b(this.dz);
                m7575a(this.dz);
                this.ed = bt;
                this.ek.mo334a().getViewTreeObserver().addOnPreDrawListener(this.ee);
                this.du = false;
                TracerDetour.a(2049607997);
            }
        } finally {
            TracerDetour.a(16411749);
        }
    }

    private List<RowItem> bj() {
        boolean z = this.dx != null && this.dX.f7613c.g() >= 2;
        Preconditions.checkArgument(z);
        TracerDetour.a("ThreadViewMessagesFragment.computeRowItemsForSendToExistingThread", -770374347);
        try {
            List<RowItem> a = this.bj.m7050a(bC(), this.dx, this.dG, this.dw.e(), bA(), this.cQ.m8096b(), this.bu, this.dZ, this.dz);
            return a;
        } finally {
            TracerDetour.a(16346464);
        }
    }

    private void bl() {
        if ((!this.bG.m4232a(this.dp, this.dE) ? 1 : null) != null) {
            this.dE = this.bG.m4233b(this.dp);
            this.dF = MessageDeduper.m6607a(this.dw, this.dE);
        }
    }

    private void m7575a(List<RowItem> list) {
        int i = 0;
        List<RowItem> a = Lists.a(list);
        if (((Boolean) this.aH.get()).booleanValue()) {
            MessageDeliveryStatesSoundHelper messageDeliveryStatesSoundHelper = this.aR;
            Message message = null;
            for (RowItem rowItem : a) {
                if (rowItem instanceof RowMessageItem) {
                    Message message2;
                    RowMessageItem rowMessageItem = (RowMessageItem) rowItem;
                    if (rowMessageItem.f4739h && rowMessageItem.f4740i == RowItemDeliveryState.SENT) {
                        message2 = rowMessageItem.f4732a;
                    } else {
                        message2 = message;
                    }
                    message = message2;
                }
            }
            if (message != null) {
                if (messageDeliveryStatesSoundHelper.f7027b == null || !Objects.equal(messageDeliveryStatesSoundHelper.f7027b.b, message.b)) {
                    messageDeliveryStatesSoundHelper.f7027b = message;
                } else if (message.d > messageDeliveryStatesSoundHelper.f7027b.d) {
                    messageDeliveryStatesSoundHelper.f7027b = message;
                    messageDeliveryStatesSoundHelper.f7026a.c(ThreadUpdateCause.DELIVERY_RECEIPT + messageDeliveryStatesSoundHelper.f7027b.n);
                }
            }
        }
        this.bD.f7970a = Collections.unmodifiableList(a);
        this.ek.mo349a((List) a);
        this.cX.setVisibility(a.isEmpty() ? 0 : 8);
        bm(this);
        m7632j(this, true);
        ImmutableList i2 = this.ek.mo361i();
        int size = i2.size();
        while (i < size) {
            RowItem rowItem2 = (RowItem) i2.get(i);
            if (rowItem2 instanceof RowMessageItem) {
                RowMessageItem rowMessageItem2 = (RowMessageItem) rowItem2;
                this.cO.m7056a(rowMessageItem2);
                this.cP.m6560b(rowMessageItem2);
                this.cR.m6616a(rowMessageItem2);
            }
            i++;
        }
    }

    public static void bm(ThreadViewMessagesFragment threadViewMessagesFragment) {
        if (threadViewMessagesFragment.bo()) {
            threadViewMessagesFragment.cX.setVisibility(8);
            if (!threadViewMessagesFragment.bp() || ((AgentTermsStatusHelper) threadViewMessagesFragment.bS.get()).m1467c()) {
                BusinessMutationHelper businessMutationHelper = (BusinessMutationHelper) threadViewMessagesFragment.bR.get();
                String l = Long.toString(threadViewMessagesFragment.dp.d);
                GraphQlQueryString agentThreadStartMutationString = new AgentThreadStartMutationString();
                AgentThreadStartInputData agentThreadStartInputData = new AgentThreadStartInputData();
                agentThreadStartInputData.a("page_id", l);
                agentThreadStartMutationString.a("input", agentThreadStartInputData);
                businessMutationHelper.a.a(GraphQLRequest.a(agentThreadStartMutationString));
                return;
            }
            threadViewMessagesFragment.bn();
        }
    }

    private void bn() {
        Object obj;
        if (((AgentTermsStatusHelper) this.bS.get()).f1484i != null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            ((AgentTermsStatusHelper) this.bS.get()).f1484i = new Object(this) {
                final /* synthetic */ ThreadViewMessagesFragment f7718a;

                {
                    this.f7718a = r1;
                }

                public final void m7462a() {
                    this.f7718a.cY.setVisibility(8);
                    ThreadViewMessagesFragment.bm(this.f7718a);
                }

                public final void m7463a(String str) {
                    this.f7718a.m7677c(str);
                }
            };
        }
        bM();
        AgentTermsStatusHelper agentTermsStatusHelper = (AgentTermsStatusHelper) this.bS.get();
        long j = this.dp.d;
        AnonymousClass32 anonymousClass32 = new Object(this) {
            final /* synthetic */ ThreadViewMessagesFragment f7719a;

            {
                this.f7719a = r1;
            }

            public final void m7464a() {
                this.f7719a.dn.m7146b();
            }
        };
        if (agentTermsStatusHelper.f1481f == null) {
            GraphQlQueryString businessIsPageLinkedQueryString = new BusinessIsPageLinkedQueryString();
            businessIsPageLinkedQueryString.a("business_page_id", Long.toString(j));
            agentTermsStatusHelper.f1481f = agentTermsStatusHelper.f1476a.a(GraphQLRequest.a(businessIsPageLinkedQueryString).a(GraphQLCachePolicy.a).a(60));
            Futures.a(agentTermsStatusHelper.f1481f, new C02491(agentTermsStatusHelper, anonymousClass32), agentTermsStatusHelper.f1477b);
        }
    }

    private boolean bo() {
        return br() && bq() && (this.dw == null || this.dw.f());
    }

    private boolean bp() {
        User aZ = aZ();
        return (aZ == null || aZ.v == null || aZ.v != CommercePageType.COMMERCE_PAGE_TYPE_AGENT) ? false : true;
    }

    private boolean bq() {
        User aZ = aZ();
        return aZ != null && aZ.u;
    }

    private boolean br() {
        User aZ = aZ();
        return (aZ == null || aZ.w == null || !aZ.w.contains(CommercePageSetting.COMMERCE_NUX_ENABLED)) ? false : true;
    }

    private boolean bs() {
        if (this.dw != null && this.dw.g() == 1) {
            User a = this.co.a(this.dw.c().e.b);
            if (a != null && a.u) {
                return true;
            }
        }
        return false;
    }

    private ScrollState bt() {
        if (this.ed == null) {
            return this.ek.mo363k();
        }
        return this.ed;
    }

    public static boolean bu(ThreadViewMessagesFragment threadViewMessagesFragment) {
        threadViewMessagesFragment.ek.mo334a().getViewTreeObserver().removeOnPreDrawListener(threadViewMessagesFragment.ee);
        if (threadViewMessagesFragment.dm != null) {
            threadViewMessagesFragment.dm.a(threadViewMessagesFragment.ek.mo370r());
        }
        if (threadViewMessagesFragment.ed == null) {
            return true;
        }
        ScrollState scrollState = threadViewMessagesFragment.ed;
        threadViewMessagesFragment.ed = null;
        threadViewMessagesFragment.m7569a(scrollState);
        return false;
    }

    private void m7596b(List<RowItem> list) {
        ImmutableList<RowItem> j = this.ek.mo362j();
        TracerDetour.a("TVMF-process changes", -2067427627);
        try {
            HashMap c = Maps.c();
            for (RowItem rowItem : j) {
                if (rowItem instanceof RowMessageItem) {
                    c.put(((RowMessageItem) rowItem).m4308c().n, (RowMessageItem) rowItem);
                }
            }
            Object obj = 1;
            RowMessageItem rowMessageItem = null;
            for (RowItem rowItem2 : list) {
                RowMessageItem rowMessageItem2;
                if (rowItem2 instanceof RowMessageItem) {
                    rowMessageItem2 = (RowMessageItem) rowItem2;
                    Message c2 = rowMessageItem2.m4308c();
                    String str = c2.n;
                    if (c.containsKey(str)) {
                        RowMessageItem rowMessageItem3 = (RowMessageItem) c.get(str);
                        if (m7582a(rowMessageItem3) && m7597b(rowMessageItem2)) {
                            m7588b(c2);
                        }
                        rowMessageItem2.m4302a(rowMessageItem3);
                    } else if (obj != null) {
                        m7620g(c2);
                    }
                    obj = null;
                    if (rowMessageItem2.m4312k()) {
                        rowMessageItem = rowMessageItem2;
                    }
                }
                rowMessageItem2 = rowMessageItem;
                rowMessageItem = rowMessageItem2;
            }
            if (!(rowMessageItem == null || rowMessageItem.f4739h)) {
                this.cu.m1726a(rowMessageItem, this.dp.d);
            }
            TracerDetour.a(-21681678);
        } catch (Throwable th) {
            TracerDetour.a(-301483019);
        }
    }

    public static void m7632j(ThreadViewMessagesFragment threadViewMessagesFragment, boolean z) {
        if (threadViewMessagesFragment.getContext() != null) {
            RowTypingItem bL = threadViewMessagesFragment.bL();
            if (bL != null && bL.f4776c) {
                long d = (MessageUtil.d(bL.f4775b) + 60000) - threadViewMessagesFragment.bb.a();
                ViewGroup a = threadViewMessagesFragment.ek.mo334a();
                if (a == null) {
                    return;
                }
                if (d > 0) {
                    a.postDelayed(new Runnable(threadViewMessagesFragment) {
                        final /* synthetic */ ThreadViewMessagesFragment f7720a;

                        {
                            this.f7720a = r1;
                        }

                        public void run() {
                            ThreadViewMessagesFragment.m7632j(this.f7720a, false);
                        }
                    }, d);
                } else if (z) {
                    a.post(new Runnable(threadViewMessagesFragment) {
                        final /* synthetic */ ThreadViewMessagesFragment f7721a;

                        {
                            this.f7721a = r1;
                        }

                        public void run() {
                            ThreadViewMessagesFragment.m7632j(this.f7721a, false);
                        }
                    });
                } else {
                    bh(threadViewMessagesFragment);
                }
            }
        }
    }

    private void m7588b(Message message) {
        String str = message.n;
        if (this.aP.a(message) == MessageClassification.PAYMENT) {
            this.aY.f(ThreadUpdateCause.MESSAGE_SENT + str);
        } else if (!((Boolean) this.aH.get()).booleanValue() && message.k == null) {
            this.aY.c(ThreadUpdateCause.MESSAGE_SENT + str);
        }
        SendMessageAnimationManager sendMessageAnimationManager = this.cO;
        if (sendMessageAnimationManager.f7410d) {
            sendMessageAnimationManager.f7409c.m6915a(str, 0.0f, 1.0f, 300, SendMessageAnimationManager.f7408b);
        }
        this.cS.m6979a(str);
    }

    private void m7621g(String str) {
        if (this.dG.remove(str)) {
            m7624h(str);
            bh(this);
        }
    }

    private void m7624h(String str) {
        SendMessageAnimationManager sendMessageAnimationManager = this.cO;
        if (sendMessageAnimationManager.f7410d) {
            ValueAnimator valueAnimator = (ValueAnimator) sendMessageAnimationManager.f7409c.f7225a.get(str);
            if (valueAnimator != null) {
                valueAnimator.reverse();
            }
        }
    }

    public final void m7672a(boolean z, String str) {
        this.dh.m4963a(z, str);
    }

    private void m7602c(RowMessageItem rowMessageItem) {
        GiftWrapResolver giftWrapResolver = this.az;
        PrefKey a = GiftWrapPrefKeys.a(rowMessageItem.f4732a);
        Editor edit = giftWrapResolver.a.edit();
        if (1 != 0) {
            edit.putBoolean(a, true);
        } else {
            edit.a(a);
        }
        edit.commit();
        GiftWrapAnimationManager giftWrapAnimationManager = this.cP;
        giftWrapAnimationManager.f6933d.m6915a(GiftWrapAnimationManager.m6559c(rowMessageItem), 0.0f, 1.0f, 2000, GiftWrapAnimationManager.f6930a);
        giftWrapAnimationManager.m6560b(rowMessageItem);
        String str = ChatHeadsContextDetector.a(getContext()) ? "chat_head_thread_view" : "thread_view";
        if (this.aV.P(rowMessageItem.f4732a)) {
            this.ay.a.a(GiftWrapAnalyticsLogger.c("unwrap").a("is_own_message", true).b("source", str));
        } else {
            this.ay.a.a(GiftWrapAnalyticsLogger.c("unwrap").a("is_own_message", false).b("source", str));
        }
    }

    public static void m7628i(ThreadViewMessagesFragment threadViewMessagesFragment, String str) {
        ImmutableList immutableList = threadViewMessagesFragment.dw.b;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            Message message = (Message) immutableList.get(i);
            if (Objects.equal(str, message.n) || Objects.equal(str, message.a)) {
                threadViewMessagesFragment.m7620g(message);
            }
        }
    }

    private void m7540a(ThreadSummary threadSummary) {
        ThreadSummary threadSummary2 = this.dx;
        this.dx = threadSummary;
        if (threadSummary2 == null) {
            bw();
        }
        if (this.dx != null) {
            this.dk.m7747a(this.dx);
            this.dl.m7807a(this.dx);
            aQ();
            if (((Boolean) this.an.get()).booleanValue()) {
                this.bu.a(this.dx);
            }
            if (this.dh != null) {
                this.dh.m4951a(this.dx.a);
            }
            if (this.cV != null) {
                ThreadViewSeenHeadsController threadViewSeenHeadsController = this.cV;
                ThreadSummary threadSummary3 = this.dx;
                if (threadViewSeenHeadsController.f8338b == null || threadSummary3 == null || !threadViewSeenHeadsController.f8338b.a.equals(threadSummary3.a)) {
                    threadViewSeenHeadsController.m8301b();
                }
                threadViewSeenHeadsController.f8338b = threadSummary3;
            }
        }
    }

    public static void bv(ThreadViewMessagesFragment threadViewMessagesFragment) {
        if (threadViewMessagesFragment.dX != null && threadViewMessagesFragment.dX.f7611a != null) {
            threadViewMessagesFragment.m7540a(threadViewMessagesFragment.dX.f7611a);
        }
    }

    private void bw() {
        if (this.dp != null) {
            MessageDraft messageDraft = null;
            SaveDraftManager saveDraftManager = this.bm;
            if (saveDraftManager.b.containsKey(this.dp)) {
                SaveDraftManager saveDraftManager2 = this.bm;
                messageDraft = (MessageDraft) saveDraftManager2.b.get(this.dp);
            } else if (this.dx != null) {
                messageDraft = this.dx.B;
            }
            this.dh.m4950a(messageDraft);
        }
    }

    public static void bx(ThreadViewMessagesFragment threadViewMessagesFragment) {
        if (threadViewMessagesFragment.dx != null && !threadViewMessagesFragment.dh.ax()) {
            MessageDraft av = threadViewMessagesFragment.dh.av();
            threadViewMessagesFragment.dh.aw();
            SaveDraftManager saveDraftManager = threadViewMessagesFragment.bm;
            ThreadKey threadKey = threadViewMessagesFragment.dx.a;
            saveDraftManager.b.put(threadKey, av);
            SaveDraftParams saveDraftParams = new SaveDraftParams(threadKey, av);
            Bundle bundle = new Bundle();
            bundle.putParcelable("saveDraftParams", saveDraftParams);
            Futures.a(BlueServiceOperationFactoryDetour.a(saveDraftManager.a, "save_draft", bundle, 580970787).a(), new 1(saveDraftManager, threadKey));
        }
    }

    private List<RowItem> by() {
        TracerDetour.a("TMVF-compute row items", -726252661);
        try {
            List<RowItem> bz;
            boolean z = (this.dx == null && this.dy == null) ? false : true;
            Preconditions.checkArgument(z);
            if (this.dx != null) {
                bz = bz();
            } else {
                bz = bD();
                TracerDetour.a(770216066);
            }
            return bz;
        } finally {
            TracerDetour.a(-1404785337);
        }
    }

    private List<RowItem> bz() {
        boolean z;
        Preconditions.checkArgument(this.dx != null);
        if (this.dw.f() || this.dw.c) {
            z = false;
        } else {
            z = true;
        }
        return this.bj.m7051a(Lists.a(bC()), this.dx, this.dG, this.dw.c, bA(), this.cQ.m8096b(), this.bu, this.dZ, z, this.du);
    }

    @Nullable
    private ParticipantInfo bA() {
        if (bs() || bB() || !this.dv.e || !this.am.c()) {
            return null;
        }
        Object obj;
        ThreadParticipantUtils threadParticipantUtils = this.bs;
        ImmutableList immutableList = this.dx.h;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            if (!Objects.equal(((ThreadParticipant) immutableList.get(i)).b(), threadParticipantUtils.a)) {
                obj = null;
                break;
            }
        }
        obj = 1;
        if (obj == null) {
            return this.am.n;
        }
        return null;
    }

    private boolean bB() {
        if (this.dx != null && this.dx.u) {
            return false;
        }
        return true;
    }

    private List<Message> bC() {
        List subList;
        if (((Boolean) this.aJ.get()).booleanValue() && bN()) {
            subList = this.dw.b.subList(0, Math.min(20, this.dw.g()));
        } else {
            subList = this.dw.b;
        }
        return m7599c(subList);
    }

    private List<RowItem> bD() {
        Preconditions.checkArgument(this.dy != null);
        return this.bj.m7052a(ImmutableList.builder().b(this.dy).b(), this.dG, this.cQ.m8096b(), ((Boolean) this.aH.get()).booleanValue(), this.dp);
    }

    private ImmutableList<Message> m7599c(List<Message> list) {
        Builder builder = ImmutableList.builder();
        if (this.dD != null) {
            builder.c(this.dD);
        }
        builder.b(this.dy);
        m7570a(builder, this.dF, (List) list);
        return builder.b();
    }

    private void m7570a(Builder<Message> builder, List<Message> list, List<Message> list2) {
        UnmodifiableIterator it = this.bQ.a(this.dp).iterator();
        Message message = it.hasNext() ? (Message) it.next() : null;
        Object obj = message;
        for (Message message2 : list) {
            while (obj != null && obj.c > message2.c) {
                builder.c(obj);
                obj = it.hasNext() ? (Message) it.next() : null;
            }
            builder.c(message2);
        }
        for (Message message22 : list2) {
            while (obj != null && obj.c > message22.c) {
                builder.c(obj);
                obj = it.hasNext() ? (Message) it.next() : null;
            }
            builder.c(message22);
        }
        while (obj != null) {
            builder.c(obj);
            if (it.hasNext()) {
                message22 = (Message) it.next();
            } else {
                message22 = null;
            }
            obj = message22;
        }
    }

    public final void ay() {
        m7541a(MessageListAdapter.f7173b);
        this.du = true;
    }

    public final int az() {
        ViewGroup a = this.ek.mo334a();
        if (a == null) {
            return -1;
        }
        int i = 0;
        if (this.dX != null) {
            if (this.dX.f7613c != null) {
                i = this.dX.f7613c.g();
            }
            i += this.dX.f7614d.size();
        }
        if (i == 0) {
            return -1;
        }
        if (a.getChildCount() == 0) {
            return -1;
        }
        i = (i - this.ek.mo357e()) + 10;
        if (i >= 20) {
            return i;
        }
        Integer.valueOf(i);
        return -1;
    }

    public static void m7593b(ThreadViewMessagesFragment threadViewMessagesFragment, RowItem rowItem) {
        if (threadViewMessagesFragment.dq == ComposeMode.EXPANDED) {
            threadViewMessagesFragment.au();
        } else if ((rowItem instanceof RowMessageItem) && threadViewMessagesFragment.dx != null) {
            RowMessageItem rowMessageItem = (RowMessageItem) rowItem;
            Message message = rowMessageItem.f4732a;
            if (threadViewMessagesFragment.f7773i.a(message)) {
                threadViewMessagesFragment.m7538a(message);
            } else if (MessageUtil.j(message)) {
                m7640l(threadViewMessagesFragment, "Click on message: " + message.a);
                AnalyticsLogger analyticsLogger = threadViewMessagesFragment.f7764a;
                HoneyClientEvent honeyClientEvent = new HoneyClientEvent("click");
                honeyClientEvent.d = "message";
                honeyClientEvent = honeyClientEvent;
                honeyClientEvent.e = message.a;
                analyticsLogger.a(honeyClientEvent.a("thread_key", message.b));
                threadViewMessagesFragment.m7609d(message);
            } else if (MessageUtil.k(message)) {
                threadViewMessagesFragment.f7764a.a(new HoneyClientEvent("messenger_thread_settings_opened_from_admin_message").b("message_type", message.l.toString()));
                threadViewMessagesFragment.dn.m7144a(0);
            } else if (message.l == MessageType.ADMIN && message.I != null && message.I.c()) {
                m7640l(threadViewMessagesFragment, "Click on Change thread theme");
                threadViewMessagesFragment.ar.a(threadViewMessagesFragment.dx.a, "admin_msg");
                threadViewMessagesFragment.m7680d("admin_msg");
            } else if (message.l == MessageType.ADMIN && message.I != null && message.I.d()) {
                m7640l(threadViewMessagesFragment, "Click on Change thread icon");
                threadViewMessagesFragment.ar.b(threadViewMessagesFragment.dx.a, "admin_msg");
                threadViewMessagesFragment.m7683e("admin_msg");
            } else if (message.l == MessageType.ADMIN && message.I != null && message.I.e()) {
                m7640l(threadViewMessagesFragment, "Click on Change nickname");
                r0 = message.I.g;
                if (r0 != null) {
                    threadViewMessagesFragment.m7573a(r0, "admin_msg");
                }
            } else if ((MessageUtil.t(message) || MessageUtil.x(message)) && ((Boolean) threadViewMessagesFragment.aN.get()).booleanValue() && threadViewMessagesFragment.am.c()) {
                m7640l(threadViewMessagesFragment, "Click on Voip Call");
                threadViewMessagesFragment.m7600c(message);
            } else if (MessageUtil.z(message)) {
                m7640l(threadViewMessagesFragment, "Click on Payment Admin Message");
                threadViewMessagesFragment.bz.m7856b(rowMessageItem);
            } else if (MessageUtil.q(message) || MessageUtil.r(message)) {
                threadViewMessagesFragment.dh.az();
            } else if (MessageUtil.y(message)) {
                m7640l(threadViewMessagesFragment, "Click on Sms Event");
            } else if (MessageUtil.s(message)) {
                m7640l(threadViewMessagesFragment, "Click on Change ephemeral mode");
                ModifyThreadEphemeralityDialog.a(threadViewMessagesFragment.dx, "admin_link").a(threadViewMessagesFragment.kO_());
            } else if (MessageUtil.Y(message)) {
                ThreadEventReminder ci = threadViewMessagesFragment.ci();
                if (ci == null) {
                    r0 = Long.toString(threadViewMessagesFragment.dp.i());
                    String str = "messenger_thread";
                    String str2 = "event_reminder_delta_cta";
                    Preconditions.checkNotNull(r0);
                    Preconditions.checkNotNull(str);
                    Preconditions.checkNotNull(str2);
                    Bundle bundle = new Bundle();
                    bundle.putString("thread_id", r0);
                    bundle.putString("source_surface", str);
                    bundle.putString("source_module", str2);
                    EventReminderPromptCreationDialogFragment eventReminderPromptCreationDialogFragment = new EventReminderPromptCreationDialogFragment();
                    eventReminderPromptCreationDialogFragment.g(bundle);
                    eventReminderPromptCreationDialogFragment.a(threadViewMessagesFragment.s(), "set_new_event_reminder");
                    return;
                }
                Object obj;
                if (message.I.c == GraphQLExtensibleMessageAdminTextType.LIGHTWEIGHT_EVENT_UPDATE_TITLE) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    EventReminderEditTitleDialogFragment.m2163a(ci.a, ci.c, "messenger_thread", "event_reminder_delta_cta").a(threadViewMessagesFragment.s(), "edit_event_reminder_title");
                    return;
                }
                if (message.I.c == GraphQLExtensibleMessageAdminTextType.LIGHTWEIGHT_EVENT_UPDATE_TIME) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    EventReminderEditTimeDialogFragment.m2159a(ci.a, TimeUnit.SECONDS.toMillis(ci.b), "messenger_thread", "event_reminder_delta_cta").a(threadViewMessagesFragment.s(), "edit_event_reminder_time");
                }
            } else if (MessageUtil.L(message)) {
                ((GroupShareSheetCreator) threadViewMessagesFragment.cM.get()).m2540a(threadViewMessagesFragment.cN, threadViewMessagesFragment.dx).show();
            }
        }
    }

    private void m7600c(Message message) {
        if (!this.bJ.d()) {
            ParticipantInfo participantInfo = this.am.n;
            if (participantInfo != null) {
                String str;
                RtcPresenceState a = this.bk.a(participantInfo.b);
                CharSequence charSequence = "";
                if (!(message == null || message.G == null || message.G.l() == null)) {
                    charSequence = message.G.l().l();
                }
                if (StringUtil.a(charSequence)) {
                    str = message.f;
                } else {
                    CharSequence charSequence2 = charSequence;
                }
                if (a.a) {
                    this.bJ.a(this.cN, participantInfo.b, b(2131232036), str, b(2131232091), !this.aU.a(message), "admin_message");
                } else {
                    this.bJ.a(this.cN, a.c);
                }
            }
        }
    }

    private void m7530a(long j) {
        ImmutableList i = this.ek.mo361i();
        int size = i.size();
        for (int i2 = 0; i2 < size; i2++) {
            RowItem rowItem = (RowItem) i.get(i2);
            if (rowItem.a() == j && (rowItem instanceof RowMessageItem)) {
                m7609d(((RowMessageItem) rowItem).f4732a);
                return;
            }
        }
    }

    private void m7609d(Message message) {
        this.cR.m6615a(message);
        bh(this);
    }

    private boolean m7580a(RowItem rowItem, @Nullable Parcelable parcelable) {
        m7640l(this, "Long click on " + rowItem.mo131b() + ": " + rowItem.a());
        return m7581a(rowItem, parcelable, "forward_longclick");
    }

    private boolean m7581a(RowItem rowItem, @Nullable Parcelable parcelable, @Nullable String str) {
        if (!(rowItem instanceof RowMessageItem) || !mx_() || !s().c()) {
            return false;
        }
        MenuDialogItemBuilder menuDialogItemBuilder;
        Object obj;
        this.dQ = (RowMessageItem) rowItem;
        Message message = this.dQ.f4732a;
        Bundle bundle = new Bundle();
        bundle.putParcelable("rowMessage", message);
        MenuDialogParamsBuilder menuDialogParamsBuilder = new MenuDialogParamsBuilder();
        menuDialogParamsBuilder.a = 2131231046;
        menuDialogParamsBuilder.d = bundle;
        if ((parcelable instanceof ImageAttachmentData) && m7579a(message, parcelable)) {
            menuDialogItemBuilder = new MenuDialogItemBuilder();
            menuDialogItemBuilder.a = 4;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.b = 2131231644;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.e = parcelable;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.d = "save_image";
            menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
            if (DeviceUtil.a(getContext().getPackageManager(), BuildConstants.n()) && !ThreadKey.g(message.b)) {
                menuDialogItemBuilder = new MenuDialogItemBuilder();
                menuDialogItemBuilder.a = 9;
                menuDialogItemBuilder = menuDialogItemBuilder;
                menuDialogItemBuilder.b = 2131231054;
                menuDialogItemBuilder = menuDialogItemBuilder;
                menuDialogItemBuilder.e = parcelable;
                menuDialogItemBuilder = menuDialogItemBuilder;
                menuDialogItemBuilder.d = "share_image";
                menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
            }
        }
        if ((parcelable instanceof VideoAttachmentData) && m7579a(message, parcelable)) {
            menuDialogItemBuilder = new MenuDialogItemBuilder();
            menuDialogItemBuilder.a = 7;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.b = 2131231648;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.e = parcelable;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.d = "save_video";
            menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
            if (!((Boolean) this.aI.get()).booleanValue()) {
                menuDialogItemBuilder = new MenuDialogItemBuilder();
                menuDialogItemBuilder.a = 8;
                menuDialogItemBuilder = menuDialogItemBuilder;
                menuDialogItemBuilder.b = 2131231057;
                menuDialogItemBuilder = menuDialogItemBuilder;
                menuDialogItemBuilder.e = parcelable;
                menuDialogItemBuilder = menuDialogItemBuilder;
                menuDialogItemBuilder.d = "fullscreen";
                menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
            }
        }
        MessageUtil messageUtil = this.aV;
        if (StringUtil.a(MessageUtil.i(message))) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            menuDialogItemBuilder = new MenuDialogItemBuilder();
            menuDialogItemBuilder.a = 0;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.b = 2131231047;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.d = "copy";
            menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
        }
        if (((MessageForwardHandler) this.cK.get()).m2245a(message)) {
            menuDialogItemBuilder = new MenuDialogItemBuilder();
            menuDialogItemBuilder.a = 1;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.b = 2131231048;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.e = new ForwardMenuItemExtraData(str);
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.d = "forward";
            menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
        }
        MenuDialogParamsBuilder a = m7526a(menuDialogParamsBuilder, this.dQ);
        if (MessageUtil.j(message)) {
            MenuDialogItemBuilder menuDialogItemBuilder2 = new MenuDialogItemBuilder();
            menuDialogItemBuilder2.a = 3;
            menuDialogItemBuilder2 = menuDialogItemBuilder2;
            menuDialogItemBuilder2.b = 2131231053;
            menuDialogItemBuilder2 = menuDialogItemBuilder2;
            menuDialogItemBuilder2.d = "details";
            a.a(menuDialogItemBuilder2.f());
        }
        a = m7586b(message, a);
        m7601c(message, a);
        if (message.F == null || message.F.a == null) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            menuDialogItemBuilder2 = new MenuDialogItemBuilder();
            menuDialogItemBuilder2.a = 10;
            menuDialogItemBuilder2 = menuDialogItemBuilder2;
            menuDialogItemBuilder2.b = 2131231058;
            menuDialogItemBuilder2 = menuDialogItemBuilder2;
            menuDialogItemBuilder2.d = "report_app_attribution";
            a.a(menuDialogItemBuilder2.f());
        }
        this.dO = MenuDialogFragment.a(a.e());
        this.dO.an = this.dP;
        this.dO.a(s(), "message_menu_dialog");
        return true;
    }

    private boolean m7579a(Message message, @Nullable Parcelable parcelable) {
        if (message.l != MessageType.REGULAR || !(parcelable instanceof DownloadableAttachment) || !this.bl.a("android.permission.WRITE_EXTERNAL_STORAGE")) {
            return false;
        }
        if (((parcelable instanceof ImageAttachmentData) && ThreadKey.d(message.b)) || ((DownloadableAttachment) parcelable).a()) {
            return true;
        }
        return false;
    }

    private MenuDialogParamsBuilder m7526a(MenuDialogParamsBuilder menuDialogParamsBuilder, RowMessageItem rowMessageItem) {
        MenuDialogItemBuilder menuDialogItemBuilder = new MenuDialogItemBuilder();
        menuDialogItemBuilder.a = 2;
        menuDialogItemBuilder = menuDialogItemBuilder;
        menuDialogItemBuilder.d = "delete";
        MenuDialogItemBuilder menuDialogItemBuilder2 = menuDialogItemBuilder;
        if (!((Boolean) this.bM.get()).booleanValue() || rowMessageItem.f4739h) {
            menuDialogItemBuilder2.b = 2131231050;
        } else {
            menuDialogItemBuilder2.b = 2131231051;
        }
        return menuDialogParamsBuilder.a(menuDialogItemBuilder2.f());
    }

    public static void bE(ThreadViewMessagesFragment threadViewMessagesFragment) {
        threadViewMessagesFragment.dh.aq();
    }

    public final void m7680d(@Nullable String str) {
        if (((Boolean) this.aE.get()).booleanValue()) {
            ThreadThemePickerFragment threadThemePickerFragment = new ThreadThemePickerFragment();
            threadThemePickerFragment.aq = this.dx.a;
            threadThemePickerFragment.au = str;
            threadThemePickerFragment.a(s(), "thread_theme_picker");
        }
    }

    public final void m7683e(@Nullable String str) {
        if (((Boolean) this.aG.get()).booleanValue()) {
            HotEmojilikePickerFragment hotEmojilikePickerFragment = new HotEmojilikePickerFragment();
            hotEmojilikePickerFragment.m2137a(this.dx);
            hotEmojilikePickerFragment.ay = str;
            hotEmojilikePickerFragment.a(s(), "like_icon_picker");
        }
    }

    private void m7573a(String str, @Nullable String str2) {
        this.ec = str2;
        this.ar.c(this.dx.a, str2);
        ThreadSummary threadSummary = this.dx;
        Bundle bundle = new Bundle();
        bundle.putParcelable("thread_summary", threadSummary);
        bundle.putString("participant_id", str);
        SetNicknameDialogFragment setNicknameDialogFragment = new SetNicknameDialogFragment();
        setNicknameDialogFragment.g(bundle);
        setNicknameDialogFragment.a(s(), "set_nickname");
    }

    public final void m7662a(ManageBlockingParam manageBlockingParam) {
        boolean z;
        MenuDialogItemBuilder menuDialogItemBuilder;
        Bundle bundle = new Bundle();
        UserKey a = ThreadKey.a(this.dp);
        bundle.putParcelable("manageBlockParam", manageBlockingParam);
        ThreadViewManageMenuHelper threadViewManageMenuHelper = this.cs;
        ThreadSummary threadSummary = this.dx;
        User a2 = ((MessengerUserCheckHelper) this.cA.get()).c.a(a);
        if (a2 == null) {
            z = false;
        } else {
            z = a2.S;
        }
        boolean z2 = z;
        MenuDialogParamsBuilder menuDialogParamsBuilder = new MenuDialogParamsBuilder();
        menuDialogParamsBuilder.a = 2131231060;
        if (threadSummary != null) {
            Object obj;
            if (threadViewManageMenuHelper.f7653a.a(threadSummary.a).b()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                menuDialogItemBuilder = new MenuDialogItemBuilder();
                menuDialogItemBuilder.a = 1;
                menuDialogItemBuilder = menuDialogItemBuilder;
                menuDialogItemBuilder.b = 2131231362;
                menuDialogItemBuilder = menuDialogItemBuilder;
                menuDialogItemBuilder.d = "unmute";
                menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
            } else {
                menuDialogItemBuilder = new MenuDialogItemBuilder();
                menuDialogItemBuilder.a = 0;
                menuDialogItemBuilder = menuDialogItemBuilder;
                menuDialogItemBuilder.b = 2131231361;
                menuDialogItemBuilder = menuDialogItemBuilder;
                menuDialogItemBuilder.d = "mute";
                menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
            }
        }
        if (z2 && threadViewManageMenuHelper.f7654b.f1666a.a(287, false)) {
            menuDialogItemBuilder = new MenuDialogItemBuilder();
            menuDialogItemBuilder.a = 2;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.b = 2131231363;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.d = "leave feedback";
            menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
        }
        menuDialogItemBuilder = new MenuDialogItemBuilder();
        menuDialogItemBuilder.a = 3;
        menuDialogItemBuilder = menuDialogItemBuilder;
        menuDialogItemBuilder.b = 2131240217;
        menuDialogItemBuilder = menuDialogItemBuilder;
        menuDialogItemBuilder.d = "block messages";
        menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
        MenuDialogParamsBuilder menuDialogParamsBuilder2 = menuDialogParamsBuilder;
        menuDialogParamsBuilder2.d = bundle;
        this.dT = MenuDialogFragment.a(menuDialogParamsBuilder2.e());
        this.dT.an = this.dU;
        this.dT.a(s(), "manage_message_menu_dialog");
    }

    public static void bF(ThreadViewMessagesFragment threadViewMessagesFragment) {
        threadViewMessagesFragment.ek.mo351b();
    }

    private void m7542a(RowMessageItem rowMessageItem, Share share) {
        if (!Strings.isNullOrEmpty(share.f) && !((ApplinkHelper) this.cx.get()).a(Uri.parse(share.f), getContext())) {
            String str = share.k;
            if (str != null) {
                ((LinkHandlingHelper) this.bO.get()).a(getContext(), Uri.parse(str));
                return;
            }
            ShareMedia a = MessageUtil.a(share);
            if (!StringUtil.a(share.f)) {
                ((LinkHandlingHelper) this.bO.get()).a(getContext(), Uri.parse(share.f));
            } else if (ShareMedia.Type.LINK.equals(a.a)) {
                if (StringUtil.a(a.b)) {
                    BLog.c("ThreadViewMessagesFragment", "ShareMedia of type link has no href: %s", new Object[]{a.toString()});
                    return;
                }
                ((LinkHandlingHelper) this.bO.get()).a(getContext(), Uri.parse(a.b));
            } else if (ShareMedia.Type.PHOTO.equals(a.a)) {
                ImageAttachmentData i;
                AttachmentDataFactory attachmentDataFactory = this.f7770f;
                if (ShareMedia.Type.PHOTO.equals(a.a)) {
                    Uri parse = Uri.parse(a.c);
                    String str2 = a.c;
                    Matcher matcher = AttachmentDataFactory.b.matcher(str2);
                    if (matcher.find()) {
                        str2 = matcher.replaceFirst("_n.jpg");
                    }
                    matcher = AttachmentDataFactory.c.matcher(str2);
                    if (matcher.find()) {
                        str2 = matcher.replaceFirst("/n" + matcher.group(1));
                    }
                    Uri parse2 = Uri.parse(str2);
                    ImageAttachmentUrisBuilder newBuilder = ImageAttachmentUris.newBuilder();
                    newBuilder.a = parse2;
                    ImageAttachmentUrisBuilder imageAttachmentUrisBuilder = newBuilder;
                    imageAttachmentUrisBuilder.b = parse;
                    ImageAttachmentUris f = imageAttachmentUrisBuilder.f();
                    ImageAttachmentDataBuilder imageAttachmentDataBuilder = new ImageAttachmentDataBuilder();
                    imageAttachmentDataBuilder.a = f;
                    i = imageAttachmentDataBuilder.i();
                } else {
                    i = null;
                }
                PhotoViewFragment.aq().m3436a(rowMessageItem.f4732a).m3435a(i).m3437a().a(s(), "photo_view_fragment");
            } else if (ShareMedia.Type.VIDEO.equals(a.a) && a.d != null) {
                ((LinkHandlingHelper) this.bO.get()).a(getContext(), Uri.parse(a.d.replaceAll("https://", "http://")));
            }
        }
    }

    public static void m7610d(ThreadViewMessagesFragment threadViewMessagesFragment, RowMessageItem rowMessageItem) {
        if (threadViewMessagesFragment.s().a("resend_dialog") == null) {
            Message message = rowMessageItem.f4732a;
            if (message.w.b == SendErrorType.PERMANENT_FAILURE) {
                threadViewMessagesFragment.bZ();
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("rowMessage", message);
            MenuDialogParamsBuilder menuDialogParamsBuilder = new MenuDialogParamsBuilder();
            if (ThreadKey.d(message.b)) {
                menuDialogParamsBuilder.a = 2131231071;
            } else {
                menuDialogParamsBuilder.a = 2131231070;
            }
            menuDialogParamsBuilder.d = bundle;
            if (!message.w.b.shouldNotBeRetried) {
                MenuDialogItemBuilder menuDialogItemBuilder = new MenuDialogItemBuilder();
                menuDialogItemBuilder.a = 12;
                menuDialogItemBuilder = menuDialogItemBuilder;
                menuDialogItemBuilder.b = 2131231189;
                menuDialogItemBuilder = menuDialogItemBuilder;
                menuDialogItemBuilder.d = "retry";
                menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
            }
            MenuDialogParamsBuilder a = threadViewMessagesFragment.m7527a(message, threadViewMessagesFragment.m7586b(message, menuDialogParamsBuilder));
            if (threadViewMessagesFragment.aP.a(message) == MessageClassification.PHOTOS) {
                MenuDialogItemBuilder menuDialogItemBuilder2 = new MenuDialogItemBuilder();
                menuDialogItemBuilder2.a = 11;
                menuDialogItemBuilder2 = menuDialogItemBuilder2;
                menuDialogItemBuilder2.d = "view_photo";
                menuDialogItemBuilder2 = menuDialogItemBuilder2;
                menuDialogItemBuilder2.c = threadViewMessagesFragment.jW_().getQuantityString(2131689481, threadViewMessagesFragment.f7770f.b(message));
                a.a(menuDialogItemBuilder2.f());
            }
            threadViewMessagesFragment.dO = MenuDialogFragment.a(m7525a(threadViewMessagesFragment.m7526a(a, rowMessageItem)).e());
            threadViewMessagesFragment.dO.an = threadViewMessagesFragment.dP;
            threadViewMessagesFragment.dO.a(threadViewMessagesFragment.s(), "message_menu_dialog");
        }
    }

    private static MenuDialogParamsBuilder m7525a(MenuDialogParamsBuilder menuDialogParamsBuilder) {
        MenuDialogItemBuilder menuDialogItemBuilder = new MenuDialogItemBuilder();
        menuDialogItemBuilder.a = 13;
        menuDialogItemBuilder = menuDialogItemBuilder;
        menuDialogItemBuilder.b = 2131231190;
        menuDialogItemBuilder = menuDialogItemBuilder;
        menuDialogItemBuilder.d = "send_report";
        menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
        return menuDialogParamsBuilder;
    }

    private MenuDialogParamsBuilder m7527a(Message message, MenuDialogParamsBuilder menuDialogParamsBuilder) {
        if (this.aP.a(message) == MessageClassification.VIDEO_CLIP) {
            MenuDialogItemBuilder menuDialogItemBuilder = new MenuDialogItemBuilder();
            menuDialogItemBuilder.a = 8;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.b = 2131231057;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.e = this.f7770f.j(message);
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.d = "view_video";
            menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
        }
        return menuDialogParamsBuilder;
    }

    private MenuDialogParamsBuilder m7586b(Message message, MenuDialogParamsBuilder menuDialogParamsBuilder) {
        if (MessageUtil.Q(message) && !StickerUtil.a(message.k) && !this.aq.a(message) && ((Boolean) this.aK.get()).booleanValue()) {
            MenuDialogItemBuilder menuDialogItemBuilder = new MenuDialogItemBuilder();
            menuDialogItemBuilder.a = 6;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.b = 2131231055;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.d = "view_pack";
            menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
        }
        return menuDialogParamsBuilder;
    }

    private void m7601c(Message message, MenuDialogParamsBuilder menuDialogParamsBuilder) {
        if (this.cf.a(214, false)) {
            boolean R = MessageUtil.R(message);
            boolean a = this.aq.a(message);
            if (R || a) {
                MenuDialogItemBuilder menuDialogItemBuilder = new MenuDialogItemBuilder();
                menuDialogItemBuilder.a = 14;
                menuDialogItemBuilder = menuDialogItemBuilder;
                menuDialogItemBuilder.b = 2131231056;
                menuDialogItemBuilder = menuDialogItemBuilder;
                menuDialogItemBuilder.d = "change_hotlike";
                menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
            }
        }
    }

    public static void m7612e(ThreadViewMessagesFragment threadViewMessagesFragment, RowMessageItem rowMessageItem) {
        ((MessageForwardHandler) threadViewMessagesFragment.cK.get()).m2244a(rowMessageItem.f4732a, NavigationTrigger.b("forward_gutter"));
    }

    private boolean m7578a(MenuDialogItem menuDialogItem, Message message) {
        boolean z = true;
        if (this.dQ != null) {
            message = this.dQ.f4732a;
        }
        if (message != null) {
            this.dQ = null;
            int i = menuDialogItem.a;
            if (i == 0) {
                m7640l(this, "CLick on Menu Item: Copy");
                m7631j(this, "MENU_ITEM_COPY");
                this.ao.setText(MessageUtil.i(message));
                return true;
            } else if (i == 1) {
                m7640l(this, "CLick on Menu Item: Forward");
                m7631j(this, "MENU_ITEM_FORWARD");
                ((MessageForwardHandler) this.cK.get()).m2244a(message, NavigationTrigger.b(((ForwardMenuItemExtraData) menuDialogItem.e).f6926a));
            } else if (i == 2) {
                m7640l(this, "CLick on Menu Item: Delete");
                m7631j(this, "MENU_ITEM_DELETE");
                if (this.cg.a(message.b)) {
                    this.cg.a(SmsCallerContext.DELETE_MESSAGE, new Runnable(this) {
                        final /* synthetic */ ThreadViewMessagesFragment f7723b;

                        public void run() {
                            ThreadViewMessagesFragment.m7611e(this.f7723b, message);
                        }
                    });
                    return true;
                }
                m7611e(this, message);
                return true;
            } else if (i == 3) {
                m7640l(this, "CLick on Menu Item: Details");
                m7631j(this, "MENU_ITEM_DETAILS");
                m7609d(message);
                return true;
            } else if (i == 4) {
                m7640l(this, "CLick on Menu Item: Save image");
                if (bG()) {
                    m7631j(this, "MENU_ITEM_SAVE_IMAGE");
                    ImageAttachmentData imageAttachmentData = (ImageAttachmentData) menuDialogItem.e;
                    if (ThreadKey.g(this.dp)) {
                        r0 = imageAttachmentData.e;
                        m7537a(new PhotoToDownload(r0, m7529a(message, r0)));
                        return true;
                    } else if (ThreadKey.d(this.dp)) {
                        m7533a(imageAttachmentData);
                        return true;
                    } else {
                        this.cy.get();
                        m7537a(MediaDownloadManager.a(imageAttachmentData));
                        return true;
                    }
                }
                this.bF.b(new ToastBuilder(2131230763));
                return true;
            } else if (i == 7) {
                m7640l(this, "CLick on Menu Item: Save video");
                if (bG()) {
                    this.bZ.a(ZeroFeatureKey.VIDEO_PLAY_INTERSTITIAL, this.D, menuDialogItem.e);
                    return true;
                }
                this.bF.b(new ToastBuilder(2131230763));
                return true;
            } else if (i == 6) {
                m7640l(this, "CLick on Menu Item: View sticker pack");
                m7631j(this, "MENU_ITEM_VIEW_STICKER_PACK");
                m7636k(this, message.k);
                return true;
            } else if (i == 8) {
                m7640l(this, "CLick on Menu Item: Video view fullscreen");
                m7631j(this, "MENU_ITEM_VIDEO_VIEW_FULLSCREEN");
                m7534a((VideoAttachmentData) menuDialogItem.e);
            } else if (i == 9) {
                m7640l(this, "CLick on Menu Item: Share image");
                if (bG()) {
                    m7631j(this, "MENU_ITEM_SHARE_IMAGE");
                    m7587b((ImageAttachmentData) menuDialogItem.e);
                } else {
                    this.bF.b(new ToastBuilder(2131230763));
                }
            } else if (i == 10) {
                Preconditions.checkArgument(message.F != null);
                if (message.F.a == null) {
                    z = false;
                }
                Preconditions.checkArgument(z);
                r0 = message.F.a;
                AttributionReportFragment attributionReportFragment = new AttributionReportFragment();
                Bundle bundle = new Bundle();
                bundle.putString("attachment_fbid", r0);
                attributionReportFragment.g(bundle);
                attributionReportFragment.a(kO_(), "report_attribution_fragment");
            } else if (i == 11) {
                m7640l(this, "CLick on Menu Item: Image view fullscreen");
                m7634k(message);
            } else if (i == 12) {
                m7640l(this, "CLick on Menu Item: Retry");
                if (this.cg.a(message.b)) {
                    this.cg.a(SmsCallerContext.RETRY_MESSAGE, new Runnable(this) {
                        final /* synthetic */ ThreadViewMessagesFragment f7725b;

                        public void run() {
                            ThreadViewMessagesFragment.m7616f(this.f7725b, message);
                        }
                    });
                } else {
                    m7616f(this, message);
                }
            } else if (i == 13) {
                aX();
                m7640l(this, "CLick on Menu Item: Send report");
                ((BugReporter) this.bv.get()).a(BugReportFlowStartParams.newBuilder().a(getContext()).a(BugReportSource.MESSENGER_FAILED_TO_SEND_MESSAGE).a(ImmutableSet.of(this.bT.m6913a(message))).a());
            } else if (i == 14) {
                m7640l(this, "CLick on Menu Item: Hotlike");
                m7631j(this, "MENU_ITEM_CHANGE_HOTLIKE");
                m7683e("inline");
                return true;
            }
        }
        return false;
    }

    private boolean m7577a(MenuDialogItem menuDialogItem, ManageBlockingParam manageBlockingParam) {
        UserKey a;
        switch (menuDialogItem.a) {
            case 0:
                ThreadNotificationsDialogFragment.m3248a(this.dp).a(kO_(), "notificationSettingsDialog");
                return true;
            case 1:
                this.cr.b(this.dp);
                C();
                return true;
            case 2:
                a = ThreadKey.a(this.dp);
                if (a == null) {
                    return true;
                }
                Context context = getContext();
                String b = a.b();
                Parcelable bundle = new Bundle();
                bundle.putString("page_id", b);
                this.bo.a(BusinessActivity.a(context, "ReviewUpdateFragment", bundle), getContext());
                return true;
            case 3:
                a = ThreadKey.a(this.dp);
                if (a == null) {
                    return true;
                }
                ManageBlockingFragment a2 = ManageBlockingFragment.a(this.co.a(a));
                Bundle bundle2 = a2.s;
                bundle2.putParcelable("arg_param", manageBlockingParam);
                a2.g(bundle2);
                a2.a(this.D, "manageBlockingFragment");
                return true;
            default:
                return false;
        }
    }

    private static String m7529a(Message message, String str) {
        ImmutableList immutableList = message.i;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            Attachment attachment = (Attachment) immutableList.get(i);
            if (attachment.c.equals(str)) {
                return attachment.j;
            }
        }
        throw Assertions.a("Missing attachment encryption key");
    }

    public static void m7611e(ThreadViewMessagesFragment threadViewMessagesFragment, Message message) {
        DeleteMessagesDialogFragment deleteMessagesDialogFragment = new DeleteMessagesDialogFragment();
        deleteMessagesDialogFragment.m3232a(message);
        deleteMessagesDialogFragment.a(threadViewMessagesFragment.s(), "delete_message_dialog_tag");
    }

    public static void m7616f(ThreadViewMessagesFragment threadViewMessagesFragment, Message message) {
        threadViewMessagesFragment.aX.a(message.n);
        ((MediaUploadManagerImpl) threadViewMessagesFragment.cJ.get()).a(message);
        SendMessageManager sendMessageManager = (SendMessageManager) threadViewMessagesFragment.cE.get();
        sendMessageManager.r.a(message.n, "retry_send");
        long a = sendMessageManager.n.a();
        MessageBuilder a2 = Message.newBuilder().a(message);
        a2.l = MessageType.PENDING_SEND;
        a2 = a2;
        a2.u = SendError.a;
        a2 = a2;
        a2.A = sendMessageManager.e(message);
        a2 = a2;
        a2.c = a;
        a2 = a2;
        a2.d = a;
        Message R = a2.R();
        ListenableFuture a3;
        if (ThreadKey.g(R.b)) {
            a3 = ((TincanSendMessageManager) sendMessageManager.z.get()).a(R);
        } else {
            a3 = sendMessageManager.c(R);
        }
        ((MessagesReliabilityLogger) threadViewMessagesFragment.cz.get()).f.a("msg_error_retry_selected", null, LoggerMapUtils.a(new String[]{"offline_threading_id", message.n, "send_error", message.w.b.serializedString}), null, null, null);
    }

    private void m7537a(PhotoToDownload photoToDownload) {
        ((MediaDownloadManager) this.cy.get()).a(((MediaDownloadManager) this.cy.get()).a(new DownloadPhotosParams(ImmutableList.of(photoToDownload), PhotoDownloadDestination.GALLERY, false), CallerContext.a(getClass(), "photo_save_thread_view")));
        if (!ThreadKey.g(this.dp)) {
            ((MediaDownloadManager) this.cy.get()).a(this.cN);
        }
    }

    private void m7533a(ImageAttachmentData imageAttachmentData) {
        ((MediaDownloadManager) this.cy.get()).a(((MediaDownloadManager) this.cy.get()).a(new SaveMmsPhotoParams(imageAttachmentData.a.a), CallerContext.a(getClass(), "photo_save_photo_view")));
    }

    private void m7587b(ImageAttachmentData imageAttachmentData) {
        ListenableFuture a;
        if (ThreadKey.d(this.dp)) {
            a = ((MediaDownloadManager) this.cy.get()).a(new SaveMmsPhotoParams(imageAttachmentData.a.a), CallerContext.a(getClass(), "photo_save_temp_thread_view"));
        } else {
            this.cy.get();
            a = ((MediaDownloadManager) this.cy.get()).a(new DownloadPhotosParams(ImmutableList.of(MediaDownloadManager.a(imageAttachmentData)), PhotoDownloadDestination.GALLERY, false), CallerContext.a(getClass(), "photo_save_temp_thread_view"));
        }
        Futures.a(a, new FutureCallback<DownloadedMedia>(this) {
            final /* synthetic */ ThreadViewMessagesFragment f7726a;

            {
                this.f7726a = r1;
            }

            public void onSuccess(Object obj) {
                DownloadedMedia downloadedMedia = (DownloadedMedia) obj;
                if (downloadedMedia.a.equals(ResultCode.FAILURE)) {
                    this.f7726a.au.a("ThreadViewMessagesFragment", "Could not save photo to temp storage for sharing");
                    this.f7726a.bF.b(new ToastBuilder(2131231000));
                    return;
                }
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("image/jpeg");
                intent.putExtra("android.intent.extra.STREAM", downloadedMedia.b);
                intent.setPackage(BuildConstants.n());
                this.f7726a.bo.b(Intent.createChooser(intent, this.f7726a.b(2131231343)), this.f7726a.getContext());
            }

            public void onFailure(Throwable th) {
                this.f7726a.au.a("ThreadViewMessagesFragment", "Could not save photo to temp storage for sharing", th);
                this.f7726a.bF.b(new ToastBuilder(2131231000));
            }
        }, this.aw);
    }

    private boolean bG() {
        NetworkInfo activeNetworkInfo = this.ap.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.isAvailable();
    }

    private void m7534a(VideoAttachmentData videoAttachmentData) {
        Intent intent = new Intent(this.cN, ThreadViewVideoActivity.class);
        intent.putExtra("video_attachment", videoAttachmentData);
        intent.putExtra("player_origin", PlayerOrigin.MESSENGER_THREAD.toString());
        intent.putExtra("thread_key", this.dp);
        this.bo.a(intent, this.cN);
    }

    public static void m7631j(ThreadViewMessagesFragment threadViewMessagesFragment, String str) {
        AnalyticsLogger analyticsLogger = threadViewMessagesFragment.f7764a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("click");
        honeyClientEvent.c = "thread";
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.d = "context_menu_item";
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.e = str;
        analyticsLogger.a(honeyClientEvent);
    }

    public static void bH(ThreadViewMessagesFragment threadViewMessagesFragment) {
        threadViewMessagesFragment.dh.m4972e();
    }

    private void m7531a(ViewGroup viewGroup, int i, int i2, int i3, int i4) {
        this.bH.m8071f();
        aS(this);
        if (this.dj) {
            if (i3 == 0) {
                this.dh.m4944a(0, -this.dh.m4964b());
            } else {
                int i5;
                if (i2 <= 0 || i + i2 != i3) {
                    i5 = 0;
                } else {
                    i5 = Math.max(0, viewGroup.getHeight() - viewGroup.getChildAt((i3 - i) - 1).getBottom());
                }
                this.dh.m4944a(i4, i5);
            }
        }
        if (!this.du && this.ed == null) {
            if (i == 0 && i2 > 0 && i3 > 0) {
                RowItem a = this.ek.mo335a(0);
                if (a == MessageListAdapter.f7173b || a == MessageListAdapter.f7172a) {
                    if (this.dn != null) {
                        this.dn.m7145a(false);
                    } else {
                        return;
                    }
                }
            }
            aA();
            bO();
        }
    }

    public final void aA() {
        if (this.dx != null && this.y && z() && bN() && this.bt.a(this.dx)) {
            ((NewMessageAnchorController) this.cB.get()).m6964a(this.dc);
            this.bg.a(this.dx.a);
            if (this.bK.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.m, false) && this.dx.a != null && this.dx.a.a == Type.ONE_TO_ONE) {
                RecentCallsDb recentCallsDb = this.ce;
                ExecutorDetour.a(recentCallsDb.e, new 5(recentCallsDb, Long.toString(this.dp.d)), 1487334506);
            }
        }
    }

    private void m7539a(final Message message, final MessageSendTrigger messageSendTrigger) {
        if (this.cg.a(message.b)) {
            this.cg.a(SmsCallerContext.SEND_MESSAGE, new Runnable(this) {
                final /* synthetic */ ThreadViewMessagesFragment f7729c;

                public void run() {
                    this.f7729c.m7539a(message, messageSendTrigger);
                }
            });
            return;
        }
        this.aX.a(message.n);
        boolean a = ChatHeadsContextDetector.a(getContext());
        if (a) {
            this.aX.a(message.n, "thread_view_in_chat_heads");
        }
        TracerDetour.a("ThreadViewMessagesFragment.onMessageSent", -1953553829);
        try {
            if (message.b == null) {
                this.au.a("send_null_threadkey", new IllegalArgumentException("null outgoingMessage.threadKey in onMessageSent. mThreadKey = " + this.dp));
                return;
            }
            if (MessageUtil.R(message) || this.aq.a(message)) {
                this.cQ.m8094a(message.n);
            }
            this.aW.a(message, this.dJ, messageSendTrigger);
            if (a) {
                this.aW.b("chat_heads");
            }
            if (!bN()) {
                this.aW.b("not_scrolled_to_bottom");
            }
            this.dk.m7757e();
            if (((Boolean) this.aF.get()).booleanValue()) {
                AnonymousClass39 anonymousClass39 = new Runnable(this) {
                    final /* synthetic */ ThreadViewMessagesFragment f7732c;

                    public void run() {
                        ((SendMessageManager) this.f7732c.cE.get()).a(message, "thread_view", this.f7732c.dJ, messageSendTrigger);
                    }
                };
                synchronized (this.ep) {
                    this.ep.add(anonymousClass39);
                }
            } else {
                ((SendMessageManager) this.cE.get()).a(message, "thread_view", this.dJ, messageSendTrigger);
            }
            aB();
            m7672a(false, "send_message");
            m7622h(message);
            this.bz.m7857c();
            if (this.dX != null) {
                this.dX = Result.m7328a(this.dX, message);
                this.dy = this.dX.f7614d;
                if (this.dx == null || this.dX.f7613c.g() < 2) {
                    bh(this);
                } else {
                    bi();
                }
            }
            this.bW.m6513b();
            if (!(MessageUtil.R(message) || this.aq.a(message))) {
                if (StickerUtil.a(message.k)) {
                    this.aY.c();
                } else if (MessageUtil.Q(message)) {
                    this.aY.e();
                } else if (this.aP.a(message) == MessageClassification.AUDIO_CLIP) {
                    this.aY.l();
                } else {
                    this.aY.a();
                }
            }
            this.bH.m8070e();
            TracerDetour.a(1980473317);
        } finally {
            TracerDetour.a(-334623333);
        }
    }

    private void m7620g(Message message) {
        if (getContext() != null) {
            boolean z;
            FlowerBorderFeature flowerBorderFeature = this.cp;
            if (flowerBorderFeature.a(message)) {
                ((FBSoundUtil) flowerBorderFeature.c.get()).a(2131165254, 2, 0.15f);
            }
            ThreadViewParticleEffectResolver threadViewParticleEffectResolver = (ThreadViewParticleEffectResolver) this.cG.get();
            if (!((Boolean) threadViewParticleEffectResolver.f3429m.get()).booleanValue()) {
                z = false;
            } else if (threadViewParticleEffectResolver.f3428l.b(message)) {
                z = threadViewParticleEffectResolver.f3427k.b.a(213, false);
            } else if (StringUtil.a(message.k)) {
                String str = message.f;
                z = !StringUtil.a(str) && (str.equals(ThreadViewParticleEffectResolver.f3417a) || str.equals("<3") || str.equals("&lt;3"));
            } else {
                if (threadViewParticleEffectResolver.f3435s == null) {
                    Object a = threadViewParticleEffectResolver.f3434r.a(FloatingHeartStickersXConfig.c, "");
                    if (StringUtil.a(a)) {
                        threadViewParticleEffectResolver.f3435s = new String[0];
                    } else {
                        String[] split = a.split(",");
                        Arrays.sort(split);
                        threadViewParticleEffectResolver.f3435s = split;
                    }
                }
                z = Arrays.binarySearch(threadViewParticleEffectResolver.f3435s, message.k) >= 0;
            }
            if (z) {
                bI();
                this.eh.m3330b();
            } else if (((ThreadViewParticleEffectResolver) this.cG.get()).m3321b(message)) {
                bI();
                this.eh.m3328a();
            } else {
                threadViewParticleEffectResolver = (ThreadViewParticleEffectResolver) this.cG.get();
                int b = (((Boolean) threadViewParticleEffectResolver.f3430n.get()).booleanValue() && threadViewParticleEffectResolver.f3433q.a(message) == MessageClassification.PAYMENT) ? message.B != null ? message.B.d : (message.u == null || message.u.c == null) ? 0 : threadViewParticleEffectResolver.f3432p.b(message.u.c.a, message.u.c.b) : 0;
                int i = b;
                if (i > 0) {
                    bI();
                    this.eh.m3329a(i);
                }
            }
        }
    }

    private void bI() {
        if (this.ei == null) {
            this.ei = new ParticleSystemView(getContext());
            this.cW.addView(this.ei);
            this.eh = new ThreadViewParticleSystemController(this.ei);
        }
    }

    public static void bJ(ThreadViewMessagesFragment threadViewMessagesFragment) {
        if (threadViewMessagesFragment.ej == null) {
            threadViewMessagesFragment.ej = new ShatterView(threadViewMessagesFragment.getContext());
            threadViewMessagesFragment.cW.addView(threadViewMessagesFragment.ej);
        }
    }

    private void m7622h(Message message) {
        TracerDetour.a("ThreadViewMessagesFragment.maybeClearComposerComponents", -747493402);
        try {
            m7627i(message);
            m7630j(message);
            m7672a(false, null);
            if (StringUtil.a(message.k) || this.br.c()) {
                this.dh.m4977i(false);
            }
            TracerDetour.a(2115730193);
        } catch (Throwable th) {
            TracerDetour.a(961098139);
        }
    }

    private void m7627i(Message message) {
        if (!StringUtil.a(message.f)) {
            this.dh.aC();
        }
    }

    private void m7630j(Message message) {
        if (this.aP.a(message) == MessageClassification.AUDIO_CLIP) {
            return;
        }
        if (this.f7770f.a(message) || this.f7770f.e(message)) {
            this.dh.aD();
        }
    }

    public final void aB() {
        TracerDetour.a("ThreadViewMessagesFragment.maybeScrollListToBottom", 2078244695);
        try {
            this.ek.mo359g();
        } finally {
            TracerDetour.a(173034252);
        }
    }

    private void m7565a(PresenceState presenceState) {
        if (this.dv != presenceState) {
            m7566a(presenceState, true);
        }
    }

    private void m7569a(ScrollState scrollState) {
        this.ek.mo348a(scrollState);
        bO();
    }

    private void m7566a(PresenceState presenceState, boolean z) {
        this.dv = presenceState;
        m7576a(true, z);
    }

    private void m7576a(boolean z, final boolean z2) {
        Object obj;
        Object obj2 = 1;
        boolean bK = bK();
        if (bK || !this.dv.e) {
            obj = null;
        } else {
            obj = 1;
        }
        if (!bK || this.dv.e) {
            obj2 = null;
        }
        if (obj2 == null || !z) {
            if (obj != null || obj2 != null) {
                bh(this);
                this.cm.f8218e = bK();
                if (!bB() && obj != null && z2 && this.y && z()) {
                    this.aY.b();
                }
            }
        } else if (this.ek.mo334a() != null) {
            this.ek.mo334a().postDelayed(new Runnable(this) {
                final /* synthetic */ ThreadViewMessagesFragment f7735b;

                public void run() {
                    this.f7735b.m7576a(false, z2);
                }
            }, 1000);
        }
    }

    private boolean bK() {
        return bL() != null;
    }

    private RowTypingItem bL() {
        if (this.ek.mo355c()) {
            return null;
        }
        List a = Lists.a(this.ek.mo362j());
        int i = 0;
        while (i < 2 && i < a.size()) {
            if (a.get(i) instanceof RowTypingItem) {
                return (RowTypingItem) a.get(i);
            }
            i++;
        }
        return null;
    }

    public final void m7665a(@Nullable NavigationTrigger navigationTrigger) {
        this.dJ = navigationTrigger;
    }

    private void m7637k(boolean z) {
        TracerDetour.a("TVMF-resetfragmentandlistadapter", 790063913);
        try {
            aV();
            if (this.cV != null) {
                this.cV.m8301b();
            }
            if (this.ea != null) {
                this.ea.m6553b();
            }
            if (z) {
                this.ek.mo364l();
                if (this.dh != null) {
                    this.dh.aN();
                }
                bM();
                this.dw = null;
                this.dy = null;
            }
            this.dx = null;
            this.dX = null;
            this.dA = null;
            this.dB = 0;
            this.dE = Lists.a();
            this.dF = Lists.a();
            this.dp = null;
            this.dk.m7758f();
            this.bz.m7858d();
            m7568a(null);
            this.dv = PresenceState.a;
            if (this.am != null) {
                this.am.a(null);
            }
            this.bq.m6091a();
            this.dG.clear();
            ((NewMessageAnchorController) this.cB.get()).m6964a(this.dc);
            this.bW.m6511a();
            this.bu.b();
        } finally {
            TracerDetour.a(-77295174);
        }
    }

    private void bM() {
        if (this.cY != null) {
            this.cY.setVisibility(0);
            boolean a = this.cf.a(299, false);
            if (!a) {
                this.cY.setMessage(jW_().getString(2131231063));
            }
            this.cY.a(a);
        }
    }

    private void m7568a(Name name) {
        this.dr = name;
        this.dk.f7802K = name;
    }

    private boolean bN() {
        return this.ek.mo360h();
    }

    private void bO() {
        int i = 0;
        if (this.dL) {
            boolean z;
            if (bN()) {
                z = false;
            } else {
                z = true;
            }
            if (this.dK != z) {
                this.dK = z;
                View view = this.cZ;
                if (!z) {
                    i = 8;
                }
                view.setVisibility(i);
            }
        }
    }

    private void bP() {
        if (this.cX != null) {
            if (ThreadKey.f(this.dp)) {
                this.cX.setMessage(null);
            } else if (this.dp == null || this.dp.a == Type.GROUP || this.dr == null || StringUtil.a(this.dr.a())) {
                this.cX.setMessage(jW_().getString(2131231064));
            } else {
                this.cX.setMessage(m7639l(((MessengerUserCheckHelper) this.cA.get()).a(UserKey.b(Long.toString(this.dp.d)))));
            }
        }
    }

    private void bQ() {
        if (this.cl.b()) {
            this.dm = this.cj.a(new Function<Object, Message>(this) {
                final /* synthetic */ ThreadViewMessagesFragment f7736a;

                {
                    this.f7736a = r1;
                }

                @Nullable
                public Object apply(Object obj) {
                    if (obj instanceof RowMessageItem) {
                        return ((RowMessageItem) obj).f4732a;
                    }
                    return null;
                }
            });
            this.dm.a(this.ck.b);
            this.dm.c = false;
        }
    }

    private static String bR() {
        return "thread";
    }

    public static void m7636k(ThreadViewMessagesFragment threadViewMessagesFragment, String str) {
        if (!StickerUtil.a(str)) {
            StickerToPackMetadataLoader.Params params = new StickerToPackMetadataLoader.Params(str);
            ((StickerToPackMetadataLoader) threadViewMessagesFragment.cF.get()).a();
            ((StickerToPackMetadataLoader) threadViewMessagesFragment.cF.get()).a(new Callback<StickerToPackMetadataLoader.Params, Results, Throwable>(threadViewMessagesFragment) {
                final /* synthetic */ ThreadViewMessagesFragment f7741a;

                /* compiled from: message has app attribution */
                class C11611 implements Runnable {
                    final /* synthetic */ AnonymousClass42 f7737a;

                    C11611(AnonymousClass42 anonymousClass42) {
                        this.f7737a = anonymousClass42;
                    }

                    public void run() {
                        ThreadViewMessagesFragment.bT(this.f7737a.f7741a);
                    }
                }

                /* compiled from: message has app attribution */
                class C11633 implements Runnable {
                    final /* synthetic */ AnonymousClass42 f7740a;

                    C11633(AnonymousClass42 anonymousClass42) {
                        this.f7740a = anonymousClass42;
                    }

                    public void run() {
                        ThreadViewMessagesFragment.bS(this.f7740a.f7741a);
                        this.f7740a.f7741a.bF.b(new ToastBuilder(this.f7740a.f7741a.jW_().getString(2131230758)));
                    }
                }

                {
                    this.f7741a = r1;
                }

                public final void m7468b(Object obj, Object obj2) {
                    final Results results = (Results) obj2;
                    this.f7741a.f7766c.a(new Runnable(this) {
                        final /* synthetic */ AnonymousClass42 f7739b;

                        public void run() {
                            ThreadViewMessagesFragment.bS(this.f7739b.f7741a);
                            switch (AnonymousClass50.f7751b[results.b.ordinal()]) {
                                case 1:
                                    this.f7739b.f7741a.dh.m4967b(results.a.a);
                                    return;
                                case 2:
                                    this.f7739b.f7741a.dh.m4957a(results.a);
                                    return;
                                default:
                                    this.f7739b.f7741a.at.a(ErrorDialogParams.a(this.f7739b.f7741a.jW_()).b(2131231059).l());
                                    return;
                            }
                        }
                    });
                }

                public final void m7469c(Object obj, Object obj2) {
                    StickerToPackMetadataLoader.Params params = (StickerToPackMetadataLoader.Params) obj;
                    Throwable th = (Throwable) obj2;
                    this.f7741a.f7766c.a(new C11633(this));
                    this.f7741a.au.a("ThreadViewMessagesFragment", "View sticker pack failed (id = " + params.a + ")", th);
                }

                public final void m7466a(Object obj, ListenableFuture listenableFuture) {
                    this.f7741a.f7766c.a(new C11611(this));
                }
            });
            ((StickerToPackMetadataLoader) threadViewMessagesFragment.cF.get()).a(params);
        }
    }

    public static void bS(ThreadViewMessagesFragment threadViewMessagesFragment) {
        if (threadViewMessagesFragment.da != null) {
            threadViewMessagesFragment.da.cancel();
            threadViewMessagesFragment.da = null;
        }
    }

    public static void bT(ThreadViewMessagesFragment threadViewMessagesFragment) {
        if (threadViewMessagesFragment.da == null || !threadViewMessagesFragment.da.isShowing()) {
            threadViewMessagesFragment.da = new ProgressDialog(threadViewMessagesFragment.getContext());
            threadViewMessagesFragment.da.a(true);
            threadViewMessagesFragment.da.setCanceledOnTouchOutside(true);
            threadViewMessagesFragment.da.a(threadViewMessagesFragment.jW_().getText(2131230739));
            threadViewMessagesFragment.da.setOnCancelListener(new OnCancelListener(threadViewMessagesFragment) {
                final /* synthetic */ ThreadViewMessagesFragment f7742a;

                {
                    this.f7742a = r1;
                }

                public void onCancel(DialogInterface dialogInterface) {
                    ThreadViewMessagesFragment.bU(this.f7742a);
                }
            });
            DialogWindowUtils.a(threadViewMessagesFragment.da);
            threadViewMessagesFragment.da.show();
        }
    }

    public static void bU(ThreadViewMessagesFragment threadViewMessagesFragment) {
        ((StickerToPackMetadataLoader) threadViewMessagesFragment.cF.get()).a();
    }

    private ImmutableList<VideoMessageContainer> bV() {
        Builder builder = ImmutableList.builder();
        ViewGroup a = this.ek.mo334a();
        if (a == null) {
            return builder.b();
        }
        int childCount = a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = a.getChildAt(i);
            if (childAt instanceof WrappingListItemView) {
                WrappingListItemView wrappingListItemView = (WrappingListItemView) childAt;
                if (wrappingListItemView.getWrappedView() instanceof VideoMessageContainer) {
                    builder.c((VideoMessageContainer) wrappingListItemView.getWrappedView());
                }
            }
        }
        return builder.b();
    }

    private ImmutableList<Animatable> bW() {
        ViewGroup a = this.ek.mo334a();
        if (a == null) {
            return RegularImmutableList.a;
        }
        Builder builder = ImmutableList.builder();
        int childCount = a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = a.getChildAt(i);
            if (childAt instanceof WrappingListItemView) {
                WrappingListItemView wrappingListItemView = (WrappingListItemView) childAt;
                if (wrappingListItemView.getWrappedView() instanceof MessageItemView) {
                    ImmutableList animatables;
                    MessageItemView messageItemView = (MessageItemView) wrappingListItemView.getWrappedView();
                    if (messageItemView.aF.c()) {
                        animatables = ((ThreadViewImageAttachmentView) messageItemView.aF.a()).getAnimatables();
                    } else {
                        animatables = RegularImmutableList.a;
                    }
                    builder.b(animatables);
                }
            }
        }
        return builder.b();
    }

    public final void aC() {
        ImmutableList bW = bW();
        int size = bW.size();
        for (int i = 0; i < size; i++) {
            ((Animatable) bW.get(i)).stop();
        }
    }

    public static void bX(ThreadViewMessagesFragment threadViewMessagesFragment) {
        ImmutableList bW = threadViewMessagesFragment.bW();
        int size = bW.size();
        for (int i = 0; i < size; i++) {
            ((Animatable) bW.get(i)).start();
        }
    }

    public static ImmutableList bY(ThreadViewMessagesFragment threadViewMessagesFragment) {
        if (threadViewMessagesFragment.dw == null) {
            return null;
        }
        Builder builder = new Builder();
        for (int g = threadViewMessagesFragment.dw.g() - 1; g >= 0; g--) {
            Message b = threadViewMessagesFragment.dw.b(g);
            if (threadViewMessagesFragment.f7770f.a(b)) {
                ImmutableList f = threadViewMessagesFragment.f7770f.f(b);
                int size = f.size();
                for (int i = 0; i < size; i++) {
                    ImageAttachmentData imageAttachmentData = (ImageAttachmentData) f.get(i);
                    if (imageAttachmentData.b == null) {
                        builder.c(new DefaultPhotoMessageItem(imageAttachmentData, b));
                    }
                }
            }
        }
        return builder.b();
    }

    private void bZ() {
        FragmentManager s = s();
        if (((CantReplyDialogFragment) s.a("cant_reply_dialog")) == null) {
            FragmentTransaction a = s.a();
            a.a(new CantReplyDialogFragment(), "cant_reply_dialog");
            a.c();
        }
    }

    private void ca() {
        long a = this.av.a(MessagingPrefKeys.au, 0);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.dw != null && uptimeMillis - a >= 30000) {
            MessagingAnalyticsLogger messagingAnalyticsLogger = this.aW;
            int g = this.dw.g();
            messagingAnalyticsLogger.a.a(new HoneyClientEvent("android_messages_collection_size").a("size", g).a("thread_key", this.dp));
            this.av.edit().a(MessagingPrefKeys.au, uptimeMillis);
        }
    }

    private void cb() {
        this.dk.f7803L = new ThreadViewMessagesFragmentBannerNotificationController.Listener(this) {
            final /* synthetic */ ThreadViewMessagesFragment f7743a;

            {
                this.f7743a = r1;
            }

            public final int mo324a(ComposerPointerLocation composerPointerLocation, boolean z) {
                return this.f7743a.dh.m4942a(composerPointerLocation, z);
            }

            public final void mo326a(PaymentPlatformContextModel paymentPlatformContextModel) {
                Preconditions.checkNotNull(paymentPlatformContextModel.g());
                this.f7743a.bz.m7848a(paymentPlatformContextModel);
            }

            public final void mo327b(PaymentPlatformContextModel paymentPlatformContextModel) {
                this.f7743a.bz.m7847a(this.f7743a.dw, paymentPlatformContextModel);
            }

            public final void mo325a() {
                if (this.f7743a.dn != null) {
                    this.f7743a.dn.m7144a(1001);
                }
            }
        };
    }

    private void cc() {
        this.dl.f7862n = this.cw;
    }

    private void cd() {
        this.by.f7870e = this.cw;
    }

    private void ce() {
        this.bz.f7902s = new Listener(this) {
            final /* synthetic */ ThreadViewMessagesFragment f7744a;

            {
                this.f7744a = r1;
            }

            public final void mo328a() {
                ThreadViewMessagesFragment.bh(this.f7744a);
            }

            public final void mo329a(String str, PaymentFlowType paymentFlowType, @Nullable PaymentPlatformContextModel paymentPlatformContextModel) {
                this.f7744a.dh.m4960a(str, paymentFlowType, paymentPlatformContextModel);
            }

            public final void mo330b(String str, PaymentFlowType paymentFlowType, @Nullable PaymentPlatformContextModel paymentPlatformContextModel) {
                ComposeFragment composeFragment = this.f7744a.dh;
                composeFragment.av.m5007a(str, paymentPlatformContextModel, composeFragment.bt.mo151d());
            }
        };
    }

    public final void aD() {
        if (this.de) {
            this.dk.m7745a(QuickPromotionTriggers.f3785e, ThreadViewBannerReason.RTC_PRESENCE_CHANGED);
        }
    }

    private int cf() {
        if (this.eg == -1) {
            this.eg = this.bN.nextInt(Integer.MAX_VALUE);
        }
        return this.eg;
    }

    public final boolean aE() {
        PhotoViewFragment photoViewFragment = (PhotoViewFragment) s().a("photo_view_fragment");
        return photoViewFragment != null && photoViewFragment.mx_();
    }

    private void m7535a(CustomThreadTheme customThreadTheme, String str, String str2) {
        CustomThreadsLogger customThreadsLogger = this.ar;
        ThreadKey threadKey = this.dp;
        int d = customThreadTheme.d();
        HoneyClientEventFast a = customThreadsLogger.a.a("messenger_customthreads_picker_save", false);
        if (a.a()) {
            a.a("picker_type", "chat_colors_picker");
            a.a("picker_location", str);
            a.a("new_theme_color", Integer.toHexString(d));
            a.a("thread_key", threadKey.h());
            a.b();
        }
        ThreadCustomization a2 = m7528a(customThreadTheme);
        this.bu.a(a2);
        this.ba.a(this.dp, a2, 1, str2, new ModifyThreadCustomizationHelper.Listener(this) {
            final /* synthetic */ ThreadViewMessagesFragment f7745a;

            {
                this.f7745a = r1;
            }

            public final void m7484a() {
                Toast.makeText(this.f7745a.getContext(), 2131231854, 0).show();
                ThreadViewMessagesFragment.bv(this.f7745a);
            }
        });
    }

    private ThreadCustomization m7528a(CustomThreadTheme customThreadTheme) {
        ThreadCustomization.Builder a = ThreadCustomization.newBuilder().a(this.dx.D);
        a.a = customThreadTheme.a;
        a = a;
        a.b = customThreadTheme.b;
        a = a;
        a.c = customThreadTheme.c;
        a = a;
        a.d = customThreadTheme.d();
        return a.g();
    }

    private void m7634k(Message message) {
        ImmutableList f = this.f7770f.f(message);
        if (((Boolean) this.aL.get()).booleanValue() && !this.f7770f.c(message)) {
            this.bf.a(message.b, bY(this));
        }
        PhotoViewFragment.aq().m3436a(message).m3435a((ImageAttachmentData) f.get(0)).m3437a().a(s(), "photo_view_fragment");
    }

    private void m7567a(@Nullable Emoji emoji, String str, @Nullable String str2) {
        String emoji2;
        CustomThreadsLogger customThreadsLogger = this.ar;
        ThreadKey threadKey = this.dp;
        if (emoji != null) {
            emoji2 = emoji.toString();
        } else {
            emoji2 = "";
        }
        HoneyClientEventFast a = customThreadsLogger.a.a("messenger_customthreads_picker_save", false);
        if (a.a()) {
            a.a("picker_type", "like_sticker_picker");
            a.a("picker_location", str);
            a.a("new_emoji", emoji2);
            a.a("thread_key", threadKey.h());
            a.b();
        }
        ThreadCustomization.Builder a2 = ThreadCustomization.newBuilder().a(this.dx.D);
        if (emoji != null) {
            emoji2 = emoji.f();
        } else {
            emoji2 = null;
        }
        a2.e = emoji2;
        ThreadCustomization g = a2.g();
        this.bu.a(g);
        this.ba.a(this.dp, g, 2, str2, new ModifyThreadCustomizationHelper.Listener(this) {
            final /* synthetic */ ThreadViewMessagesFragment f7746a;

            {
                this.f7746a = r1;
            }

            public final void m7485a() {
                Toast.makeText(this.f7746a.getContext(), 2131231855, 0).show();
                ThreadViewMessagesFragment.bv(this.f7746a);
            }
        });
    }

    private void m7574a(String str, String str2, String str3) {
        this.ba.a(this.dp, str, str2, str3, new ModifyThreadCustomizationHelper.Listener(this) {
            final /* synthetic */ ThreadViewMessagesFragment f7747a;

            {
                this.f7747a = r1;
            }

            public final void m7486a() {
                Toast.makeText(this.f7747a.getContext(), 2131231867, 0).show();
            }
        });
    }

    public final void dE_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -365512036);
        super.dE_();
        this.bJ.g();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1966560349, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2053921668);
        super.mY_();
        this.bJ.g();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 862804990, a);
    }

    public static void m7640l(ThreadViewMessagesFragment threadViewMessagesFragment, String str) {
        threadViewMessagesFragment.bU.a(str, BugReportCategory.COMPOSE_MESSAGE_FLOW);
    }

    private String m7639l(boolean z) {
        int i = 2131231065;
        if (z) {
            if (BuildConstants.j) {
                i = 2131231067;
            } else {
                i = 2131231066;
            }
        }
        return jW_().getString(i, new Object[]{this.dr.a()});
    }

    public static void cg(ThreadViewMessagesFragment threadViewMessagesFragment) {
        if (!ThreadKey.d(threadViewMessagesFragment.dp)) {
            return;
        }
        if (threadViewMessagesFragment.y && threadViewMessagesFragment.D()) {
            threadViewMessagesFragment.ch();
        } else {
            threadViewMessagesFragment.dN = true;
        }
    }

    private void m7532a(AnalyticsLogger analyticsLogger, AnalyticsTagger analyticsTagger, AndroidThreadUtil androidThreadUtil, ApiMethodRunner apiMethodRunner, Lazy<ApplinkHelper> lazy, AppChoreographer appChoreographer, AttachmentDataFactory attachmentDataFactory, AudioClipPlayerQueue audioClipPlayerQueue, BballGameAnalyticsLogger bballGameAnalyticsLogger, BballGameFeature bballGameFeature, BotSubscribeMethod botSubscribeMethod, CanonicalThreadPresenceHelper canonicalThreadPresenceHelper, Provider<Boolean> provider, ClipboardManager clipboardManager, ConnectivityManager connectivityManager, CustomThreadsEmojiLike customThreadsEmojiLike, CustomThreadsLogger customThreadsLogger, DataCache dataCache, ErrorDialogs errorDialogs, FbErrorReporter fbErrorReporter, FbSharedPreferences fbSharedPreferences, Executor executor, ListeningExecutorService listeningExecutorService, GiftWrapAnalyticsLogger giftWrapAnalyticsLogger, GiftWrapResolver giftWrapResolver, GroupsAdminLogger groupsAdminLogger, Lazy<GroupPhotoSettingsDialogFactory> lazy2, InputMethodManager inputMethodManager, Provider<Boolean> provider2, Provider<Boolean> provider3, Provider<Boolean> provider4, Provider<Boolean> provider5, Provider<Boolean> provider6, Provider<Boolean> provider7, Provider<Boolean> provider8, Provider<Boolean> provider9, Provider<Boolean> provider10, Provider<Boolean> provider11, Provider<Boolean> provider12, FbBroadcastManager fbBroadcastManager, Lazy<MediaDownloadManager> lazy3, MessageClassifier messageClassifier, MessageDeduper messageDeduper, MessageDeliveryStatesSoundHelper messageDeliveryStatesSoundHelper, Lazy<MessageListHelperForListView> lazy4, Lazy<MessageListHelperForRecyclerView> lazy5, MessageUserUtil messageUserUtil, MessageUtil messageUtil, Lazy<MessagesReliabilityLogger> lazy6, MessagingAnalyticsLogger messagingAnalyticsLogger, MessagingPerformanceLogger messagingPerformanceLogger, MessengerSoundUtil messengerSoundUtil, MessengerThreadNameViewDataFactory messengerThreadNameViewDataFactory, Lazy<MessengerUserCheckHelper> lazy7, ModifyThreadCustomizationHelper modifyThreadCustomizationHelper, Clock clock, Lazy<NewMessageAnchorController> lazy8, Lazy<OutgoingMessageFactory> lazy9, Lazy<PendingThreadsManager> lazy10, PerformanceLogger performanceLogger, PerfTestConfig perfTestConfig, PlatformLaunchHelper platformLaunchHelper, PhotoMessageDataCache photoMessageDataCache, ReadThreadManager readThreadManager, RecentMessagesTracker recentMessagesTracker, RowItemUiUtil rowItemUiUtil, RowMessageItemGenerator rowMessageItemGenerator, RtcPresenceHandler rtcPresenceHandler, RuntimePermissionsUtil runtimePermissionsUtil, SaveDraftManager saveDraftManager, Lazy<ScrollPerfHelper> lazy11, SecureContextHelper secureContextHelper, SeenHeadsEligibilityChecker seenHeadsEligibilityChecker, Lazy<SendMessageManager> lazy12, Lazy<StickerToPackMetadataLoader> lazy13, StickersAnimationManager stickersAnimationManager, StickerContentSearchExperimentAccessor stickerContentSearchExperimentAccessor, ThreadParticipantUtils threadParticipantUtils, ThreadUnreadCountUtil threadUnreadCountUtil, ThreadViewTheme threadViewTheme, Provider<BugReporter> provider13, ThreadViewMessagesFragmentBannerNotificationControllerProvider threadViewMessagesFragmentBannerNotificationControllerProvider, ThreadViewMessagesFragmentMessageRequestsControllerProvider threadViewMessagesFragmentMessageRequestsControllerProvider, ThreadViewMessagesFragmentNullStateCallToActionController threadViewMessagesFragmentNullStateCallToActionController, ThreadViewMessagesFragmentPaymentsHelper threadViewMessagesFragmentPaymentsHelper, ThreadViewMessagesFragmentSendFailuresHelper threadViewMessagesFragmentSendFailuresHelper, Lazy<ThreadViewOperationsHelper> lazy14, Lazy<ThreadViewParticleEffectResolver> lazy15, Lazy<LaunchTimelineHelper> lazy16, Lazy<ThreadRecipientUtil> lazy17, ThreadViewRowItemCacheForBugReporter threadViewRowItemCacheForBugReporter, ThreadViewSeenHeadsControllerProvider threadViewSeenHeadsControllerProvider, Toaster toaster, UncommittedThreadModificationsCache uncommittedThreadModificationsCache, UnreadMessagesPillController unreadMessagesPillController, VideoPlayerManager videoPlayerManager, RtcCallHandler rtcCallHandler, QeAccessor qeAccessor, XMAViewHostEventDispatcher xMAViewHostEventDispatcher, Provider<Boolean> provider14, Random random, Lazy<LinkHandlingHelper> lazy18, Provider<Boolean> provider15, GloballyDeletedMessagesPlaceholderCache globallyDeletedMessagesPlaceholderCache, Lazy<BusinessMutationHelper> lazy19, Lazy<AgentTermsStatusHelper> lazy20, MessageSendFailedDataFileProviderProvider messageSendFailedDataFileProviderProvider, BugReportOperationLogger bugReportOperationLogger, BlockingAnalyticsLogger blockingAnalyticsLogger, AutoContactAddController autoContactAddController, RemoveMembersHelper removeMembersHelper, MessengerContactRowMenuHelper messengerContactRowMenuHelper, ZeroDialogController zeroDialogController, SmsContactRowMenuHelper smsContactRowMenuHelper, SmsTakeoverStateChecker smsTakeoverStateChecker, Lazy<Handler> lazy21, Lazy<SmsThreadManager> lazy22, Lazy<RideOauthHelper> lazy23, RecentCallsDb recentCallsDb, GatekeeperStore gatekeeperStore, SmsDefaultAppManager smsDefaultAppManager, Lazy<GroupThreadActionHandler> lazy24, XMAActionHandlerManager xMAActionHandlerManager, MessageEventMonitorProvider messageEventMonitorProvider, BusinessMessageImpressionListener businessMessageImpressionListener, BusinessPromotionGatekeepers businessPromotionGatekeepers, MessageListAccessibilityDelegate messageListAccessibilityDelegate, CallToActionXMAHandler callToActionXMAHandler, UserCache userCache, FlowerBorderFeature flowerBorderFeature, FlowerBordersDecorationProvider flowerBordersDecorationProvider, NotificationSettingsUtil notificationSettingsUtil, ThreadViewManageMenuHelper threadViewManageMenuHelper, Provider<Boolean> provider16, QuickReplyMessageUpdater quickReplyMessageUpdater, Lazy<MediaUploadManager> lazy25, Lazy<MessageForwardHandler> lazy26, Lazy<InternalAttributionCallToActionHelper> lazy27, Lazy<GroupShareSheetCreator> lazy28) {
        this.f7764a = analyticsLogger;
        this.f7765b = analyticsTagger;
        this.f7766c = androidThreadUtil;
        this.f7767d = apiMethodRunner;
        this.cx = lazy;
        this.f7769e = appChoreographer;
        this.f7770f = attachmentDataFactory;
        this.f7771g = audioClipPlayerQueue;
        this.f7772h = bballGameAnalyticsLogger;
        this.f7773i = bballGameFeature;
        this.al = botSubscribeMethod;
        this.am = canonicalThreadPresenceHelper;
        this.an = provider;
        this.ao = clipboardManager;
        this.ap = connectivityManager;
        this.aq = customThreadsEmojiLike;
        this.ar = customThreadsLogger;
        this.as = dataCache;
        this.at = errorDialogs;
        this.au = fbErrorReporter;
        this.av = fbSharedPreferences;
        this.aw = executor;
        this.ax = listeningExecutorService;
        this.ay = giftWrapAnalyticsLogger;
        this.az = giftWrapResolver;
        this.aA = groupsAdminLogger;
        this.aB = lazy2;
        this.aC = inputMethodManager;
        this.aD = provider2;
        this.aE = provider3;
        this.aF = provider4;
        this.aG = provider5;
        this.aH = provider6;
        this.aI = provider7;
        this.aJ = provider8;
        this.aK = provider9;
        this.aL = provider10;
        this.aM = provider11;
        this.aN = provider12;
        this.aO = fbBroadcastManager;
        this.cy = lazy3;
        this.aP = messageClassifier;
        this.aQ = messageDeduper;
        this.aR = messageDeliveryStatesSoundHelper;
        this.aS = lazy4;
        this.aT = lazy5;
        this.aU = messageUserUtil;
        this.aV = messageUtil;
        this.cz = lazy6;
        this.aW = messagingAnalyticsLogger;
        this.aX = messagingPerformanceLogger;
        this.aY = messengerSoundUtil;
        this.aZ = messengerThreadNameViewDataFactory;
        this.cA = lazy7;
        this.ba = modifyThreadCustomizationHelper;
        this.bb = clock;
        this.cB = lazy8;
        this.cC = lazy9;
        this.cD = lazy10;
        this.bc = performanceLogger;
        this.bd = perfTestConfig;
        this.be = platformLaunchHelper;
        this.bf = photoMessageDataCache;
        this.bg = readThreadManager;
        this.bh = recentMessagesTracker;
        this.bi = rowItemUiUtil;
        this.bj = rowMessageItemGenerator;
        this.bk = rtcPresenceHandler;
        this.bl = runtimePermissionsUtil;
        this.bm = saveDraftManager;
        this.bn = lazy11;
        this.bo = secureContextHelper;
        this.bp = seenHeadsEligibilityChecker;
        this.cE = lazy12;
        this.cF = lazy13;
        this.bq = stickersAnimationManager;
        this.br = stickerContentSearchExperimentAccessor;
        this.bs = threadParticipantUtils;
        this.bt = threadUnreadCountUtil;
        this.bu = threadViewTheme;
        this.bv = provider13;
        this.bw = threadViewMessagesFragmentBannerNotificationControllerProvider;
        this.bx = threadViewMessagesFragmentMessageRequestsControllerProvider;
        this.by = threadViewMessagesFragmentNullStateCallToActionController;
        this.bz = threadViewMessagesFragmentPaymentsHelper;
        this.bA = threadViewMessagesFragmentSendFailuresHelper;
        this.bB = lazy14;
        this.cG = lazy15;
        this.bC = lazy16;
        this.cH = lazy17;
        this.bD = threadViewRowItemCacheForBugReporter;
        this.bE = threadViewSeenHeadsControllerProvider;
        this.bF = toaster;
        this.bG = uncommittedThreadModificationsCache;
        this.bH = unreadMessagesPillController;
        this.bI = videoPlayerManager;
        this.bJ = rtcCallHandler;
        this.bK = qeAccessor;
        this.bL = xMAViewHostEventDispatcher;
        this.bM = provider14;
        this.bN = random;
        this.bO = lazy18;
        this.bP = provider15;
        this.bQ = globallyDeletedMessagesPlaceholderCache;
        this.bR = lazy19;
        this.bS = lazy20;
        this.bT = messageSendFailedDataFileProviderProvider;
        this.bU = bugReportOperationLogger;
        this.bV = blockingAnalyticsLogger;
        this.bW = autoContactAddController;
        this.bX = removeMembersHelper;
        this.bY = messengerContactRowMenuHelper;
        this.bZ = zeroDialogController;
        this.ca = smsContactRowMenuHelper;
        this.cb = smsTakeoverStateChecker;
        this.cc = lazy21;
        this.cd = lazy22;
        this.cI = lazy23;
        this.ce = recentCallsDb;
        this.cf = gatekeeperStore;
        this.cg = smsDefaultAppManager;
        this.ch = lazy24;
        this.ci = xMAActionHandlerManager;
        this.cj = messageEventMonitorProvider;
        this.ck = businessMessageImpressionListener;
        this.cl = businessPromotionGatekeepers;
        this.cm = messageListAccessibilityDelegate;
        this.cn = callToActionXMAHandler;
        this.co = userCache;
        this.cp = flowerBorderFeature;
        this.cq = flowerBordersDecorationProvider;
        this.cr = notificationSettingsUtil;
        this.cs = threadViewManageMenuHelper;
        this.ct = provider16;
        this.cu = quickReplyMessageUpdater;
        this.cJ = lazy25;
        this.cK = lazy26;
        this.cL = lazy27;
        this.cM = lazy28;
    }

    private void ch() {
        HandlerDetour.a((Handler) this.cc.get(), new Runnable(this) {
            final /* synthetic */ ThreadViewMessagesFragment f7748a;

            {
                this.f7748a = r1;
            }

            public void run() {
                ((SmsThreadManager) this.f7748a.cd.get()).a(this.f7748a.dx);
            }
        }, -768954733);
    }

    public final void m7666a(com.facebook.orca.threadview.ThreadViewFragment.AnonymousClass16 anonymousClass16) {
        this.dC = anonymousClass16;
    }

    private ThreadEventReminder ci() {
        if (this.dx == null || this.dx.J == null || this.dx.J.isEmpty()) {
            return null;
        }
        ImmutableList immutableList = this.dx.J;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ThreadEventReminder threadEventReminder = (ThreadEventReminder) immutableList.get(i);
            if (!threadEventReminder.d) {
                return threadEventReminder;
            }
        }
        return null;
    }
}
