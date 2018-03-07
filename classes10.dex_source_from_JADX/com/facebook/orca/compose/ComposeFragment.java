package com.facebook.orca.compose;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.internal.widget.ViewStubCompat;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.android.maps.model.LatLng;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.base.fragment.FbFragment;
import com.facebook.bugreporter.BugReportCategory;
import com.facebook.bugreporter.BugReportOperationLogger;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.ui.keyboard.SoftInputDetector;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.ExifOrientation;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.crypto.exception.KeyChainException;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.enums.GraphQLMessageThreadCannotReplyReason;
import com.facebook.infer.annotation.Assertions;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.inject.InjectorLike;
import com.facebook.iorg.common.upsell.ui.FbZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController;
import com.facebook.ipc.media.MediaItem;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.analytics.base.MessagingAnalyticsConstants.MessageSendTrigger;
import com.facebook.messaging.analytics.perf.MessagingPerformanceLogger;
import com.facebook.messaging.annotations.IsMultipickerInMessageComposerEnabled;
import com.facebook.messaging.attachments.AttachmentDataFactory;
import com.facebook.messaging.attachments.ImageAttachmentDataBuilder;
import com.facebook.messaging.attachments.ImageAttachmentUris;
import com.facebook.messaging.attribution.PlatformLaunchHelper;
import com.facebook.messaging.attribution.SampleContentReplyFragment;
import com.facebook.messaging.audio.composer.AudioComposerPrefKeys;
import com.facebook.messaging.blocking.BlockingUtils;
import com.facebook.messaging.business.agent.view.MQuickReplyKeyboardView;
import com.facebook.messaging.business.ride.helper.RideOauthHelper;
import com.facebook.messaging.business.ride.utils.RideServiceParams;
import com.facebook.messaging.business.ride.utils.RideServiceParams.RideServiceParamsBuilder;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.composer.botcomposer.BotComposerView;
import com.facebook.messaging.composer.botcomposer.BotComposerView.Callback;
import com.facebook.messaging.composer.edit.MessageComposerEditor;
import com.facebook.messaging.composer.triggers.ContentSearchType;
import com.facebook.messaging.composershortcuts.ComposerShortcutItem;
import com.facebook.messaging.composershortcuts.ComposerShortcutsAnalyticsLogger;
import com.facebook.messaging.customthreads.CustomThreadsPrefKeys;
import com.facebook.messaging.customthreads.EmojilikeNuxAnchorProvider;
import com.facebook.messaging.customthreads.annotations.IsHotEmojilikesEnabled;
import com.facebook.messaging.customthreads.annotations.IsHotEmojilikesHistoryEnabled;
import com.facebook.messaging.emoji.MessagingEmojiGatingUtil;
import com.facebook.messaging.emoji.MessengerEmojiColorNuxFragment;
import com.facebook.messaging.ephemeral.ModifyThreadEphemeralityHelper;
import com.facebook.messaging.ephemeral.gating.EphemeralGatingUtil;
import com.facebook.messaging.event.sending.EventMessageParams;
import com.facebook.messaging.event.sending.EventSendingDialogFragment;
import com.facebook.messaging.fullscreendialog.FullScreenDialogParams;
import com.facebook.messaging.intents.MessagingIntents;
import com.facebook.messaging.keyboard.AbstractComposerKeyboard;
import com.facebook.messaging.location.sending.LocationSendingDialogConfig;
import com.facebook.messaging.location.sending.LocationSendingDialogConfig.Builder;
import com.facebook.messaging.location.sending.LocationSendingDialogConfig.ButtonStyle;
import com.facebook.messaging.location.sending.LocationSendingDialogFragment;
import com.facebook.messaging.location.sending.NearbyPlace;
import com.facebook.messaging.media.mediapicker.DynamicMediaPickerPreference;
import com.facebook.messaging.media.mediapicker.dialog.PickMediaDialogFragment;
import com.facebook.messaging.media.mediapicker.dialog.PickMediaDialogFragment.Listener;
import com.facebook.messaging.media.mediapicker.dialog.PickMediaDialogParams;
import com.facebook.messaging.media.mediapicker.dialog.PickMediaDialogParamsBuilder;
import com.facebook.messaging.media.mediapicker.dialog.PickMediaSource;
import com.facebook.messaging.media.mediatray.MediaTrayKeyboard;
import com.facebook.messaging.media.mediatray.MediaTrayKeyboardView;
import com.facebook.messaging.media.mediatray.MediaTrayKeyboardView.MediaEditCallback;
import com.facebook.messaging.media.picking.MessengerStartVideoEditHelper;
import com.facebook.messaging.media.picking.MessengerVideoEditDialogFragment;
import com.facebook.messaging.media.picking.VideoFormatChecker;
import com.facebook.messaging.media.picking.VideoSizeChecker;
import com.facebook.messaging.media.picking.VideoSizeChecker.2;
import com.facebook.messaging.media.picking.VideoSizeChecker.3;
import com.facebook.messaging.media.picking.VideoSizeChecker.DialogListener;
import com.facebook.messaging.media.upload.MediaUploadManager;
import com.facebook.messaging.media.upload.MediaUploadManagerImpl;
import com.facebook.messaging.model.attribution.ContentAppAttribution;
import com.facebook.messaging.model.messagemetadata.PlatformMetadata;
import com.facebook.messaging.model.messagemetadata.PlatformMetadataUtil;
import com.facebook.messaging.model.messagemetadata.QuickRepliesPlatformMetadata;
import com.facebook.messaging.model.messagemetadata.QuickReplyItem;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageBuilder;
import com.facebook.messaging.model.messages.MessageDraft;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.share.SentShareAttachment;
import com.facebook.messaging.model.share.ShareBuilder;
import com.facebook.messaging.model.share.ShareFactory;
import com.facebook.messaging.model.share.ShareMedia;
import com.facebook.messaging.model.share.ShareMediaBuilder;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.modifiers.flowerborder.FlowerBorderAnalyticsLogger;
import com.facebook.messaging.modifiers.flowerborder.FlowerBorderFeature;
import com.facebook.messaging.payment.analytics.PaymentFlowType;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformContextModel;
import com.facebook.messaging.payment.value.input.OrionMessengerPayParams;
import com.facebook.messaging.photos.editing.MessengerPhotoEditDialogFragment;
import com.facebook.messaging.photos.view.DefaultPhotoMessageItem;
import com.facebook.messaging.photos.view.PhotoViewFragment;
import com.facebook.messaging.photos.view.PhotoViewFragment.PhotoViewFragmentBuilder;
import com.facebook.messaging.photos.view.PhotoViewFragment.PhotoViewMode;
import com.facebook.messaging.platform.utilities.PlatformShareUploadManager;
import com.facebook.messaging.quickcam.QuickCamKeyboard;
import com.facebook.messaging.quickcam.QuickCamKeyboardView;
import com.facebook.messaging.quickpromotion.QuickPromotionBannerView.ComposerPointerLocation;
import com.facebook.messaging.send.client.OfflineThreadingIdGenerator;
import com.facebook.messaging.send.client.OutgoingMessageFactory;
import com.facebook.messaging.sms.analytics.SmsCallerContext;
import com.facebook.messaging.sms.defaultapp.SmsDefaultAppManager;
import com.facebook.messaging.tincan.view.EphemeralKeyboard;
import com.facebook.messaging.tincan.view.EphemeralKeyboardView;
import com.facebook.messaging.widget.anchorabletoast.AnchorableToast;
import com.facebook.orca.compose.ComposeObserver.OnSendListener;
import com.facebook.orca.compose.ComposerKeyboardManager.KeyboardHolder;
import com.facebook.orca.compose.ComposerKeyboardManager.KeyboardState;
import com.facebook.orca.compose.KeyboardBroadcastHandler.Mode;
import com.facebook.orca.emoji.ClassicAttachmentKeyboard;
import com.facebook.orca.threadview.ThreadViewActivity;
import com.facebook.orca.threadview.ThreadViewVideoActivity;
import com.facebook.photos.base.media.MediaItemFactory.PhotoItemBuilder;
import com.facebook.prefs.counters.UiCounters;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.presence.ConversationTypingContext;
import com.facebook.presence.ConversationTypingContextProvider;
import com.facebook.runtimepermissions.RequestPermissionsActivity;
import com.facebook.share.model.ComposerAppAttribution;
import com.facebook.share.model.ShareItem;
import com.facebook.share.ui.SharePreviewLayout;
import com.facebook.stickers.abtest.StickerContentSearchExperimentAccessor;
import com.facebook.stickers.keyboard.StickerKeyboard;
import com.facebook.stickers.keyboard.StickerKeyboardPackPopupTabItem;
import com.facebook.stickers.keyboard.StickerKeyboardPackPopupTabItem.TabType;
import com.facebook.stickers.keyboard.StickerKeyboardView;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.model.StickerPack;
import com.facebook.stickers.preferences.StickerPrefKeys;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.emoji.EmojiUtil;
import com.facebook.ui.emoji.Emojis;
import com.facebook.ui.emoji.model.BigEmojis;
import com.facebook.ui.emoji.model.Emoji;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogParamsBuilder;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.ui.media.attachments.MediaResourceBuilder;
import com.facebook.ui.media.attachments.MediaResourceHelper;
import com.facebook.ui.media.attachments.MediaResourceHelper.1;
import com.facebook.ui.media.attachments.MediaResourceUtil;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.videocodec.base.VideoMetadata;
import com.facebook.videocodec.base.VideoMetadataExtractor;
import com.facebook.videocodec.base.VideoTranscoderException;
import com.facebook.videocodec.extract.DefaultVideoMetadataExtractor;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.ViewStubHolder.OnInflateListener;
import com.facebook.zero.MessageCapKeyboardGuardController;
import com.facebook.zero.capping.IsMessageCapEligibleGK;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: original message is not set */
public class ComposeFragment extends FbFragment implements InjectableComponentWithContext {
    public static final String f5394a = ComposeFragment.class.getName();
    private static final CallerContext f5395b = CallerContext.a(ComposeFragment.class, "composer");
    private static final ImmutableSet<Type> f5396c = ImmutableSet.of(Type.PHOTO, Type.VIDEO);
    private static final ImmutableSet<Type> f5397d = ImmutableSet.of(Type.PHOTO);
    @Inject
    public DynamicMediaPickerPreference aA;
    @Inject
    private EmojilikeNuxAnchorProvider aB;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<EmojiUtil> aC = UltralightRuntime.b;
    @Inject
    private EncryptionKeyGenerator aD;
    @Inject
    private EphemeralGatingUtil aE;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<ModifyThreadEphemeralityHelper> aF = UltralightRuntime.b;
    @Inject
    private ExtraShortcutsHandler aG;
    @Inject
    public AbstractFbErrorReporter aH;
    @Inject
    public FbSharedPreferences aI;
    @Inject
    private FlowerBorderAnalyticsLogger aJ;
    @Inject
    private FlowerBorderFeature aK;
    @Inject
    private InputMethodManager aL;
    @Inject
    private KeyboardBroadcastHandler aM;
    @Inject
    public MediaResourceHelper aN;
    @Inject
    private MediaResourceUtil aO;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<MediaUploadManager> aP = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<MessageCapKeyboardGuardController> aQ = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<MessagingEmojiGatingUtil> aR = UltralightRuntime.b;
    @Inject
    public MessagingPerformanceLogger aS;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<MessengerStartVideoEditHelper> aT = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<NavigationLogger> aU = UltralightRuntime.b;
    @Inject
    private OfflineThreadingIdGenerator aV;
    @Inject
    public OutgoingMessageFactory aW;
    @Inject
    private PlatformLaunchHelper aX;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PlatformShareUploadManager> aY = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RideOauthHelper> aZ = UltralightRuntime.b;
    @Inject
    @IsMultipickerInMessageComposerEnabled
    private Provider<Boolean> al;
    @IsMessageCapEligibleGK
    @Inject
    private Provider<Boolean> am;
    @Inject
    @LocalBroadcast
    private BaseFbBroadcastManager an;
    @Inject
    private AnchorableToast ao;
    @Inject
    private AttachmentDataFactory ap;
    @Inject
    public AttachmentsManager aq;
    @Inject
    private AutoComposeBroadcastHandler ar;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<BigEmojis> as = UltralightRuntime.b;
    @Inject
    private BlockingUtils at;
    @Inject
    public BugReportOperationLogger au;
    @Inject
    public ComposeFragmentPaymentsHelper av;
    @Inject
    private ComposerKeyboardManagerProvider aw;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ComposerShortcutsAnalyticsLogger> ax = UltralightRuntime.b;
    @Inject
    private ConversationTypingContextProvider ay;
    @Inject
    private DataCache az;
    private int bA;
    private int bB;
    public boolean bC;
    private boolean bD;
    public String bE;
    private boolean bF;
    public ShareItem bG;
    private ViewStub bH;
    private SharePreviewLayout bI;
    private ListenableFuture<ShareItem> bJ;
    private boolean bK;
    private SelfRegistrableReceiverImpl bL;
    private boolean bM;
    public boolean bN;
    private boolean bO;
    private ComposerAppAttribution bP;
    @Nullable
    private String bQ;
    @Nullable
    private ComposeObserver bR;
    @Nullable
    private Integer bS;
    private C07521 bT = new C07521(this);
    private final C07542 bU = new C07542(this);
    private Listener bV = new C07553(this);
    private final VideoEditDialogFragmentListener bW = new VideoEditDialogFragmentListener(this);
    private final PhotoEditDialogFragmentListener bX = new PhotoEditDialogFragmentListener(this);
    private final LocationSendingDialogFragment.Listener bY = new C07564(this);
    private final C07575 bZ = new C07575(this);
    @Inject
    public SecureContextHelper ba;
    @Inject
    private ShareFactory bb;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SmsDefaultAppManager> bc = UltralightRuntime.b;
    @Inject
    private SoftInputDetector bd;
    @Inject
    public StickerContentSearchExperimentAccessor be;
    @Inject
    public Toaster bf;
    @Inject
    private UiCounters bg;
    @Inject
    private UserCache bh;
    @Inject
    private VideoFormatChecker bi;
    @Inject
    public VideoMetadataExtractor bj;
    @Inject
    public VideoSizeChecker bk;
    @Inject
    public ZeroDialogController bl;
    public ComposerKeyboardManager bm;
    private Context bn;
    public MessageComposer bo;
    private ViewStubHolder bp;
    private boolean bq = false;
    public ThreadKey br;
    private ThreadKey bs;
    public ComposerListener bt;
    public OnSaveDraftListener bu;
    private boolean bv;
    public boolean bw = true;
    private boolean bx;
    public ConversationTypingContext by;
    public boolean bz;
    @DefaultExecutorService
    @Inject
    private ListeningExecutorService f5398e;
    @Inject
    @ForUiThread
    private ExecutorService f5399f;
    @Inject
    @ForUiThread
    private Handler f5400g;
    @Inject
    @IsHotEmojilikesEnabled
    private Provider<Boolean> f5401h;
    @IsHotEmojilikesHistoryEnabled
    @Inject
    private Provider<Boolean> f5402i;

    /* compiled from: original message is not set */
    public class C07521 {
        final /* synthetic */ ComposeFragment f5356a;

        C07521(ComposeFragment composeFragment) {
            this.f5356a = composeFragment;
        }

        public final void m4752a(boolean z, String str) {
            ComposeFragment.m4902b(this.f5356a, z, str);
        }
    }

    /* compiled from: original message is not set */
    public class C07542 {
        final /* synthetic */ ComposeFragment f5376a;

        C07542(ComposeFragment composeFragment) {
            this.f5376a = composeFragment;
        }

        public final void m4755a(Mode mode) {
            this.f5376a.m4883a(mode);
        }
    }

    /* compiled from: original message is not set */
    class C07553 implements Listener {
        final /* synthetic */ ComposeFragment f5383a;

        C07553(ComposeFragment composeFragment) {
            this.f5383a = composeFragment;
        }

        public final void m4796a(List<MediaResource> list) {
            this.f5383a.m4905b((List) list);
        }

        public final void m4795a() {
            ComposeFragment.bu(this.f5383a);
        }

        public final void m4797b() {
            ComposeFragment.bt(this.f5383a);
            if (this.f5383a.bm.m5084a("gallery") == null) {
                this.f5383a.aA.c();
                this.f5383a.bm.m5095j();
            }
        }
    }

    /* compiled from: original message is not set */
    class C07564 implements LocationSendingDialogFragment.Listener {
        final /* synthetic */ ComposeFragment f5384a;

        C07564(ComposeFragment composeFragment) {
            this.f5384a = composeFragment;
        }

        public final void m4798a(LatLng latLng) {
            this.f5384a.m4948a(latLng);
        }

        public final void m4800b(LatLng latLng) {
            this.f5384a.m4965b(latLng);
        }

        public final void m4799a(NearbyPlace nearbyPlace) {
            this.f5384a.m4949a(nearbyPlace);
        }
    }

    /* compiled from: original message is not set */
    public class C07575 {
        final /* synthetic */ ComposeFragment f5385a;

        C07575(ComposeFragment composeFragment) {
            this.f5385a = composeFragment;
        }

        public final void m4801a(MediaResource mediaResource) {
            this.f5385a.m4866a(this.f5385a.aW.a(this.f5385a.br, "", ImmutableList.of(mediaResource), mediaResource.x), MessageSendTrigger.COMPOSER_SAMPLE_CONTENT_PAGE);
        }
    }

    /* compiled from: original message is not set */
    public class C07586 {
        final /* synthetic */ ComposeFragment f5386a;

        C07586(ComposeFragment composeFragment) {
            this.f5386a = composeFragment;
        }

        public final void m4809a(String str) {
            if (Objects.equal("voice_clip", str) && this.f5386a.bz && this.f5386a.br != null) {
                this.f5386a.aI.edit().a(AudioComposerPrefKeys.a(this.f5386a.br), 1).commit();
            }
            this.f5386a.bo.mo176a(str);
            ComposeFragment.aQ(this.f5386a);
        }

        public final void m4813b(String str) {
            if (Objects.equal("voice_clip", str) && this.f5386a.bz && this.f5386a.br != null) {
                this.f5386a.aI.edit().a(AudioComposerPrefKeys.a(this.f5386a.br), 0).commit();
            }
            this.f5386a.bo.mo179b(str);
            ComposeFragment.bA(this.f5386a);
        }

        public final void m4805a(Sticker sticker) {
            this.f5386a.au.a("Click on sticker: " + sticker.a, BugReportCategory.STICKERS);
            this.f5386a.m4959a(sticker.a, MessageSendTrigger.COMPOSER_STICKER_TAB);
        }

        public final void m4816c(String str) {
            if (!ThreadKey.d(this.f5386a.br) && this.f5386a.be.a()) {
                this.f5386a.bm.m5090d();
                this.f5386a.bo.mo175a(ContentSearchType.STICKER, str, false, "switch_from_sticker_search");
            }
        }

        public final void m4807a(MediaResource mediaResource) {
            this.f5386a.au.a("Send QuickCam", BugReportCategory.QUICK_CAM);
            this.f5386a.m4884a(mediaResource);
        }

        public final void m4810a(List<MediaResource> list) {
            this.f5386a.m4893a((List) list);
        }

        public final void m4812b(MediaResource mediaResource) {
            this.f5386a.au.a("Send media", BugReportCategory.MEDIA_TRAY);
            this.f5386a.m4903b(mediaResource);
        }

        public final void m4808a(MediaResource mediaResource, @Nullable MediaEditCallback mediaEditCallback) {
            this.f5386a.au.a("Edit media", BugReportCategory.MEDIA_TRAY);
            this.f5386a.m4886a(mediaResource, mediaEditCallback);
        }

        public final void m4804a(PickMediaSource pickMediaSource) {
            this.f5386a.m4864a(pickMediaSource);
        }

        public final void m4806a(Emoji emoji) {
            this.f5386a.au.a("Select emoji: " + emoji.toString(), BugReportCategory.COMPOSE_MESSAGE_FLOW);
            MessageComposerEditor editor = this.f5386a.bo.getEditor();
            EmojiUtil emojiUtil = editor.a;
            Object text = editor.c.getText();
            int selectionStart = Selection.getSelectionStart(text);
            int selectionEnd = Selection.getSelectionEnd(text);
            StringBuilder stringBuilder = new StringBuilder(4);
            stringBuilder.append(Character.toChars(emoji.b));
            if (emoji.c != 0) {
                stringBuilder.append(Character.toChars(emoji.c));
            }
            if (emoji.e != null) {
                ImmutableList immutableList = emoji.e;
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    stringBuilder.append(Character.toChars(((Integer) immutableList.get(i)).intValue()));
                }
            }
            text.replace(selectionStart, selectionEnd, stringBuilder);
            ComposeFragment.bd(this.f5386a);
        }

        public final void m4817d(String str) {
            this.f5386a.bo.getEditor().a(str);
            ComposeFragment.bh(this.f5386a);
            this.f5386a.bm.m5092g();
        }

        public final void m4802a() {
            this.f5386a.au.a("Back space key", BugReportCategory.COMPOSE_MESSAGE_FLOW);
            this.f5386a.bo.getEditor().c.dispatchKeyEvent(new KeyEvent(0, 67));
            ComposeFragment.bd(this.f5386a);
        }

        public final void m4815c(MediaResource mediaResource) {
            this.f5386a.au.a("Send audio clip", BugReportCategory.VOICE_CLIPS);
            this.f5386a.m4885a(mediaResource, MessageSendTrigger.COMPOSER_AUDIO_CLIP_TAB);
        }

        public final boolean m4814b() {
            return ComposeFragment.br(this.f5386a);
        }

        public final void m4811a(String[] strArr) {
            Intent intent = new Intent(this.f5386a.getContext(), RequestPermissionsActivity.class);
            intent.putExtra("extra_permissions", strArr);
            this.f5386a.ba.a(intent, 7373, this.f5386a);
        }

        public final void m4803a(int i) {
            ((ModifyThreadEphemeralityHelper) this.f5386a.aF.get()).b(this.f5386a.br, i, ComposeFragment.bo(this.f5386a).H);
        }
    }

    /* compiled from: original message is not set */
    class C07597 implements ActionReceiver {
        final /* synthetic */ ComposeFragment f5387a;

        C07597(ComposeFragment composeFragment) {
            this.f5387a = composeFragment;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1184390682);
            ComposeFragment.bd(this.f5387a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1983316353, a);
        }
    }

    /* compiled from: original message is not set */
    public class C07608 {
        final /* synthetic */ ComposeFragment f5388a;

        C07608(ComposeFragment composeFragment) {
            this.f5388a = composeFragment;
        }

        public final void m4818a() {
            ComposeFragment.bd(this.f5388a);
        }
    }

    /* compiled from: original message is not set */
    class C07619 implements ZeroDialogController.Listener {
        final /* synthetic */ ComposeFragment f5389a;

        C07619(ComposeFragment composeFragment) {
            this.f5389a = composeFragment;
        }

        public final void m4820a(Object obj) {
            this.f5389a.aJ();
        }

        public final void m4819a() {
        }
    }

    /* compiled from: original message is not set */
    public interface ComposerListener {
        void mo146a();

        void mo147a(Message message, MessageSendTrigger messageSendTrigger);

        boolean mo148a(View view, MotionEvent motionEvent);

        void mo149b();

        @Nullable
        String mo150c();

        @Nullable
        String mo151d();
    }

    /* compiled from: original message is not set */
    enum InvalidAttachmentCompositionErrorSource {
        SEND_BUTTON("send_button"),
        MEDIA_PICKER("media_picker");
        
        private String name;

        private InvalidAttachmentCompositionErrorSource(String str) {
            this.name = str;
        }

        public final String getName() {
            return this.name;
        }
    }

    /* compiled from: original message is not set */
    public interface OnSaveDraftListener {
        void mo331a();
    }

    /* compiled from: original message is not set */
    public class PhotoEditDialogFragmentListener implements MessengerPhotoEditDialogFragment.Listener {
        final /* synthetic */ ComposeFragment f5390a;
        @Nullable
        public MediaEditCallback f5391b;

        public PhotoEditDialogFragmentListener(ComposeFragment composeFragment) {
            this.f5390a = composeFragment;
        }

        public final void m4829a(MediaEditCallback mediaEditCallback) {
            this.f5391b = mediaEditCallback;
        }

        public final void m4830a(MediaResource mediaResource) {
            ComposeFragment.m4917e(this.f5390a, mediaResource);
        }

        public final void m4831b(MediaResource mediaResource) {
            if (this.f5391b != null) {
                this.f5391b.mo110a(mediaResource);
            }
        }

        public final void m4828a() {
            this.f5390a.aH();
        }
    }

    /* compiled from: original message is not set */
    public abstract class SimpleComposerListener implements ComposerListener {
        public void mo147a(Message message, MessageSendTrigger messageSendTrigger) {
        }

        public void mo146a() {
        }

        public boolean mo148a(View view, MotionEvent motionEvent) {
            return false;
        }

        public void mo149b() {
        }

        @Nullable
        public String mo150c() {
            return null;
        }

        @Nullable
        public String mo151d() {
            return null;
        }
    }

    /* compiled from: original message is not set */
    public class VideoEditDialogFragmentListener implements MessengerVideoEditDialogFragment.Listener {
        final /* synthetic */ ComposeFragment f5392a;
        @Nullable
        public MediaEditCallback f5393b;

        public VideoEditDialogFragmentListener(ComposeFragment composeFragment) {
            this.f5392a = composeFragment;
        }

        public final void m4839a(MediaEditCallback mediaEditCallback) {
            this.f5393b = mediaEditCallback;
        }

        public final void m4840a(MediaResource mediaResource) {
            ComposeFragment.m4917e(this.f5392a, mediaResource);
        }

        public final void m4841b(MediaResource mediaResource) {
            if (this.f5393b != null) {
                this.f5393b.mo110a(mediaResource);
            }
        }

        public final void m4838a() {
            MediaTrayKeyboard mediaTrayKeyboard = (MediaTrayKeyboard) this.f5392a.bm.m5087b("gallery");
            if (mediaTrayKeyboard != null) {
                ((MediaTrayKeyboardView) mediaTrayKeyboard.a).m3097g();
            }
            this.f5392a.aH();
        }
    }

    private static <T extends InjectableComponentWithContext> void m4891a(Class<T> cls, T t) {
        m4892a((Object) t, t.getContext());
    }

    private static void m4892a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ComposeFragment) obj).m4889a(ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), Handler_ForUiThreadMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4149), IdBasedProvider.a(injectorLike, 4150), IdBasedProvider.a(injectorLike, 4078), IdBasedProvider.a(injectorLike, 4390), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), AnchorableToast.m4479a(injectorLike), AttachmentDataFactory.a(injectorLike), AttachmentsManager.m4730a(injectorLike), AutoComposeBroadcastHandler.m4740a(injectorLike), IdBasedLazy.a(injectorLike, 11501), BlockingUtils.a(injectorLike), BugReportOperationLogger.a(injectorLike), ComposeFragmentPaymentsHelper.m4987a(injectorLike), (ComposerKeyboardManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ComposerKeyboardManagerProvider.class), IdBasedSingletonScopeProvider.b(injectorLike, 7729), (ConversationTypingContextProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ConversationTypingContextProvider.class), DataCache.a(injectorLike), DynamicMediaPickerPreference.a(injectorLike), EmojilikeNuxAnchorProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 3556), EncryptionKeyGenerator.m5111a(injectorLike), EphemeralGatingUtil.a(injectorLike), IdBasedLazy.a(injectorLike, 7844), ExtraShortcutsHandler.m5114a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), FlowerBorderAnalyticsLogger.a(injectorLike), FlowerBorderFeature.a(injectorLike), InputMethodManagerMethodAutoProvider.a(injectorLike), KeyboardBroadcastHandler.m5115a(injectorLike), MediaResourceHelper.a(injectorLike), MediaResourceUtil.a(injectorLike), IdBasedLazy.a(injectorLike, 2644), IdBasedLazy.a(injectorLike, 11790), IdBasedLazy.a(injectorLike, 7833), MessagingPerformanceLogger.a(injectorLike), IdBasedLazy.a(injectorLike, 7917), IdBasedSingletonScopeProvider.b(injectorLike, 137), OfflineThreadingIdGenerator.a(injectorLike), OutgoingMessageFactory.a(injectorLike), PlatformLaunchHelper.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 8298), IdBasedLazy.a(injectorLike, 7668), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), ShareFactory.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2709), SoftInputDetector.a(injectorLike), StickerContentSearchExperimentAccessor.a(injectorLike), Toaster.a(injectorLike), UiCounters.a(injectorLike), UserCache.a(injectorLike), VideoFormatChecker.a(injectorLike), (VideoMetadataExtractor) DefaultVideoMetadataExtractor.a(injectorLike), VideoSizeChecker.a(injectorLike), (ZeroDialogController) FbZeroDialogController.a(injectorLike));
    }

    private void m4863a(ComposerShortcutItem composerShortcutItem) {
        if (null == null) {
            m4897b(composerShortcutItem);
        }
    }

    public final void a_(Context context) {
        super.a_(context);
        this.bn = ContextUtils.a(getContext(), 2130773078, 2131625130);
        m4891a(ComposeFragment.class, (InjectableComponentWithContext) this);
        this.aM.f5512e = this.bU;
        this.ar.f5339f = this.bT;
        this.bm = this.aw.m5110a(this);
        this.bm.f5489s = new C07586(this);
    }

    private boolean m4906b(Fragment fragment) {
        if (fragment.G == null) {
            return fragment.K;
        }
        return fragment.K || m4906b(fragment.G);
    }

    public static void aQ(ComposeFragment composeFragment) {
        composeFragment.bm.m5085a(composeFragment.bo.getAdditionalKeyboardHeight());
    }

    public Context getContext() {
        return this.bn != null ? this.bn : super.getContext();
    }

    public final void m4969c(Bundle bundle) {
        super.c(bundle);
        this.bL = this.an.a().a("com.facebook.orca.CONNECTIVITY_CHANGED", new C07597(this)).a();
        this.aq.f5331g = new C07608(this);
        this.bv = true;
        bH();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.bA != configuration.orientation) {
            this.bm.m5083C();
        }
        this.bA = configuration.orientation;
    }

    public final View m4943a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1556973972);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(this.bn);
        this.bm.f5488r = cloneInContext;
        if (this.bM) {
            i = 2130905589;
        } else {
            i = 2130905903;
        }
        View inflate = cloneInContext.inflate(i, viewGroup, false);
        if (this.bM) {
            m4908c(inflate);
        } else {
            m4896b(inflate);
        }
        if (this.bS != null) {
            m4974g(this.bS.intValue());
        }
        bz();
        this.bl.a(ZeroFeatureKey.LOCATION_SERVICES_INTERSTITIAL, getContext().getString(2131232930), new C07619(this));
        m4954a(ComposeMode.SHRUNK);
        bd(this);
        LogUtils.f(955702770, a);
        return inflate;
    }

    private void m4896b(View view) {
        this.bo = (MessageComposer) view.findViewById(2131565250);
        this.bo.setFragmentManager(this.D);
        this.bp = ViewStubHolder.a((ViewStubCompat) view.findViewById(2131565251));
        final Callback anonymousClass10 = new Callback(this) {
            final /* synthetic */ ComposeFragment f5341a;

            {
                this.f5341a = r1;
            }

            public final void mo140a() {
                ComposeFragment.bB(this.f5341a);
                this.f5341a.bo.mo180c();
            }

            public final void mo141a(QuickReplyItem quickReplyItem) {
                this.f5341a.m4865a(quickReplyItem);
            }
        };
        this.bp.c = new OnInflateListener(this) {
            final /* synthetic */ ComposeFragment f5343b;

            public final void m4748a(View view) {
                ((BotComposerView) view).f1719d = anonymousClass10;
            }
        };
    }

    private void m4865a(QuickReplyItem quickReplyItem) {
        m4866a(this.aW.a(this.br, quickReplyItem.a, PlatformMetadataUtil.a(new PlatformMetadata[]{new QuickRepliesPlatformMetadata(ImmutableList.of(quickReplyItem))})), MessageSendTrigger.QUICK_REPLY);
    }

    private void m4908c(View view) {
        this.bz = true;
        this.bo = (MessageComposer) view;
        this.bH = (ViewStub) view.findViewById(2131564517);
        this.bo.setTextLengthLimit(5000);
        if (view instanceof AttachmentContainer) {
            AttachmentContainer attachmentContainer = (AttachmentContainer) view;
            attachmentContainer.setAttachmentContainerCallback(new AttachmentContainer.Callback(this) {
                final /* synthetic */ ComposeFragment f5344a;

                {
                    this.f5344a = r1;
                }

                public final void mo142a(MediaResource mediaResource) {
                    this.f5344a.m4894a(this.f5344a.aq.m4738d(), mediaResource);
                }

                public final void mo143b(MediaResource mediaResource) {
                    AttachmentsManager attachmentsManager = this.f5344a.aq;
                    attachmentsManager.f5328d.remove(mediaResource);
                    ((MediaUploadManagerImpl) attachmentsManager.f5327c.get()).b(mediaResource);
                    if (attachmentsManager.f5329e != null) {
                        attachmentsManager.f5329e.mo211b(mediaResource);
                    }
                    attachmentsManager.f5331g.m4818a();
                }
            });
            this.aq.f5329e = attachmentContainer;
        }
    }

    public final void m4947a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        if (this.bs != null) {
            m4951a(this.bs);
        }
    }

    public final void m4946a(Fragment fragment) {
        super.a(fragment);
        if (fragment instanceof PickMediaDialogFragment) {
            ((PickMediaDialogFragment) fragment).aE = this.bV;
        } else if (fragment instanceof MessengerVideoEditDialogFragment) {
            ((MessengerVideoEditDialogFragment) fragment).av = this.bW;
        } else if (fragment instanceof MessengerPhotoEditDialogFragment) {
            ((MessengerPhotoEditDialogFragment) fragment).ax = this.bX;
        } else if (fragment instanceof LocationSendingDialogFragment) {
            ((LocationSendingDialogFragment) fragment).ar = this.bY;
        } else if (fragment instanceof SampleContentReplyFragment) {
            ((SampleContentReplyFragment) fragment).ar = this.bZ;
        }
    }

    public final int m4964b() {
        if (this.bq && this.bp.d()) {
            return ((BotComposerView) this.bp.a()).getOverlapY();
        }
        return this.bo.getOverlapY();
    }

    public final void m4972e() {
        if (this.bq && this.bp.d()) {
            ((BotComposerView) this.bp.a()).m1714a();
        }
        this.bo.mo193k();
    }

    public final void m4944a(int i, int i2) {
        if (this.bq && this.bp.d()) {
            ((BotComposerView) this.bp.a()).m1715c(i2);
        } else {
            this.bo.mo174a(i, i2);
        }
    }

    public final void aq() {
        this.au.a("Click on outside", BugReportCategory.COMPOSE_MESSAGE_FLOW);
        ((NavigationLogger) this.aU.get()).a("tap_outside");
        this.bm.m5083C();
        if (this.aL == null || this.T == null) {
            this.aH.a("T7449197:NullCheck", "IMM: " + (this.aL != null ? "good" : "NULL") + ", getView: " + (this.T != null ? "good" : "NULL"));
        } else {
            this.aL.hideSoftInputFromWindow(this.T.getWindowToken(), 0);
        }
    }

    private boolean aR() {
        return !this.bm.m5089c("voice_clip");
    }

    public final void ar() {
        if (aR()) {
            this.bo.mo180c();
        }
    }

    public final void m4971d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 781717017);
        super.d(bundle);
        if (ContextUtils.a(getContext(), Activity.class) != null) {
            this.ao.f4938j = true;
            this.bA = jW_().getConfiguration().orientation;
        }
        if (bundle != null) {
            this.bx = bundle.getBoolean("runningInPlatformContext", false);
            ComposerKeyboardManager composerKeyboardManager = this.bm;
            Bundle bundle2 = (Bundle) bundle.getParcelable("openPopup");
            if (bundle2 != null) {
                String string = bundle2.getString("id");
                if (string != null) {
                    Object obj = -1;
                    switch (string.hashCode()) {
                        case -1897874326:
                            if (string.equals("react_sample")) {
                                obj = 3;
                                break;
                            }
                            break;
                        case -1515361731:
                            if (string.equals("voice_clip")) {
                                obj = 2;
                                break;
                            }
                            break;
                        case -1367751899:
                            if (string.equals("camera")) {
                                obj = null;
                                break;
                            }
                            break;
                        case -196315310:
                            if (string.equals("gallery")) {
                                obj = 6;
                                break;
                            }
                            break;
                        case 96632902:
                            if (string.equals("emoji")) {
                                obj = 4;
                                break;
                            }
                            break;
                        case 527873560:
                            if (string.equals("quick_reply")) {
                                obj = 7;
                                break;
                            }
                            break;
                        case 853620882:
                            if (string.equals("classic")) {
                                obj = 5;
                                break;
                            }
                            break;
                        case 1531715286:
                            if (string.equals("stickers")) {
                                obj = 1;
                                break;
                            }
                            break;
                    }
                    switch (obj) {
                        case null:
                            composerKeyboardManager.m5093h();
                            break;
                        case 1:
                            composerKeyboardManager.m5088c();
                            break;
                        case 2:
                            composerKeyboardManager.m5101p();
                            break;
                        case 3:
                            composerKeyboardManager.m5103r();
                            break;
                        case 4:
                            composerKeyboardManager.m5097l();
                            break;
                        case 5:
                            composerKeyboardManager.m5099n();
                            break;
                        case 6:
                            composerKeyboardManager.m5095j();
                            break;
                        case 7:
                            composerKeyboardManager.m5091e();
                            break;
                    }
                }
                if (composerKeyboardManager.f5491u != null) {
                    composerKeyboardManager.f5491u.f5452c.a(bundle2.getBundle("bundle"));
                }
            }
            this.bF = bundle.getBoolean("isComingFromInitMediaOperation", false);
            if (this.bE == null) {
                this.bE = bundle.getString("offlineMessageId");
                ContentSearchParams contentSearchParams = (ContentSearchParams) bundle.getParcelable("contentSearchParams");
                if (contentSearchParams != null) {
                    this.bo.mo175a(contentSearchParams.f5497a, contentSearchParams.f5498b, false, null);
                }
            }
            this.av.m5002a(bundle);
            if (bundle.getBoolean("flowerBorderActive")) {
                m4963a(true, "restored");
            }
            if (this.bG == null) {
                this.bG = (ShareItem) bundle.getParcelable("shareItem");
                aZ(this);
            }
            if (this.aq.m4736b()) {
                for (MediaResource mediaResource : bundle.getParcelableArrayList("attachmentResources")) {
                    if (MediaResourceUtil.a(mediaResource)) {
                        this.aq.m4733a(mediaResource, this.bE, this.br);
                    }
                }
            }
            bc();
            if (((Boolean) this.am.get()).booleanValue()) {
                ((MessageCapKeyboardGuardController) this.aQ.get()).o = true;
            }
        }
        this.aX.v = new PlatformLaunchHelper.Listener(this) {
            final /* synthetic */ ComposeFragment f5345a;

            {
                this.f5345a = r1;
            }

            public final void m4751a(ThreadKey threadKey, String str, List<MediaResource> list, ContentAppAttribution contentAppAttribution) {
                this.f5345a.m4866a(this.f5345a.aW.a(threadKey, str, list, contentAppAttribution), MessageSendTrigger.PLATFORM_APP);
            }
        };
        if (((Boolean) this.am.get()).booleanValue()) {
            MessageCapKeyboardGuardController messageCapKeyboardGuardController = (MessageCapKeyboardGuardController) this.aQ.get();
            View view = this.T;
            ComposerKeyboardManager composerKeyboardManager2 = this.bm;
            if (view != null && messageCapKeyboardGuardController.h == null) {
                messageCapKeyboardGuardController.h = view;
                messageCapKeyboardGuardController.m = composerKeyboardManager2;
            }
        }
        LogUtils.f(1930917342, a);
    }

    public final void m4962a(boolean z) {
        boolean z2;
        if (this.T == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2);
        this.bM = z;
    }

    public final void m4945a(int i, int i2, Intent intent) {
        if (i == 10000 && i2 == -1) {
            this.av.m5001a(intent);
        } else if (i == 1003) {
            this.aX.a(intent, this.br, this);
        } else if (i == 7376 && i2 == -1) {
            m4866a((Message) intent.getParcelableExtra("extra_message"), MessageSendTrigger.PLATFORM_APP);
        } else if (i == 7373 && i2 == -1) {
            HashMap hashMap = (HashMap) intent.getSerializableExtra("extra_permission_results");
            ComposerKeyboardManager composerKeyboardManager = this.bm;
            if (composerKeyboardManager.f5491u != null && composerKeyboardManager.f5491u.f5455f == KeyboardState.OPENED) {
                composerKeyboardManager.f5491u.f5452c.a(hashMap);
            }
        }
    }

    public final void m4973e(Bundle bundle) {
        super.e(bundle);
        bundle.putBoolean("runningInPlatformContext", this.bx);
        String str = "openPopup";
        ComposerKeyboardManager composerKeyboardManager = this.bm;
        Bundle bundle2 = new Bundle();
        if (composerKeyboardManager.f5491u != null) {
            bundle2.putString("id", composerKeyboardManager.f5491u.f5451b);
            bundle2.putBundle("bundle", composerKeyboardManager.f5491u.f5452c.i());
        }
        bundle.putParcelable(str, bundle2);
        bundle.putBoolean("isComingFromInitMediaOperation", this.bF);
        bundle.putParcelableArrayList("attachmentResources", Lists.a(this.aq.m4738d()));
        bundle.putString("offlineMessageId", this.bE);
        bundle.putParcelable("shareItem", this.bG);
        bundle.putParcelable("contentSearchParams", this.bo.getContentSearchParams());
        this.av.m5009b(bundle);
        bundle.putBoolean("flowerBorderActive", this.bK);
    }

    public final void m4940H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1896258639);
        super.H();
        this.bm.m5086a(false);
        this.bo.mo181d();
        this.ao.m4482a();
        bw();
        this.bL.c();
        if (((Boolean) this.am.get()).booleanValue()) {
            MessageCapKeyboardGuardController messageCapKeyboardGuardController = (MessageCapKeyboardGuardController) this.aQ.get();
            if (messageCapKeyboardGuardController.l != null) {
                messageCapKeyboardGuardController.c.b(messageCapKeyboardGuardController.l);
            }
            messageCapKeyboardGuardController.d();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1765142715, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1187419432);
        super.mj_();
        this.aq.m4734a(false);
        this.aM.m5117b();
        this.ar.m4744b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1066443798, a);
    }

    public final void as() {
        this.aM.m5117b();
        this.ar.m4744b();
        this.bo.mo184g();
        this.bm.m5086a(false);
        aS();
        aT();
        aW();
        aX();
        bE();
        if (((Boolean) this.am.get()).booleanValue()) {
            ((MessageCapKeyboardGuardController) this.aQ.get()).d();
        }
    }

    public final void at() {
        if (!m4906b((Fragment) this)) {
            this.aM.m5116a();
            this.ar.m4742a();
            this.bm.m5086a(true);
        }
        this.bo.mo183f();
        if (((Boolean) this.am.get()).booleanValue()) {
            ((MessageCapKeyboardGuardController) this.aQ.get()).c();
        }
    }

    public final void m4970c(boolean z) {
        super.c(z);
        ComposerKeyboardManager composerKeyboardManager = this.bm;
        boolean z2 = (z || m4906b((Fragment) this)) ? false : true;
        composerKeyboardManager.m5086a(z2);
    }

    private void aS() {
        MessengerVideoEditDialogFragment messengerVideoEditDialogFragment = (MessengerVideoEditDialogFragment) s().a("VIDEO_EDIT");
        if (messengerVideoEditDialogFragment != null && !StringUtil.a(messengerVideoEditDialogFragment.at.g(), this.br.g())) {
            messengerVideoEditDialogFragment.b();
        }
    }

    private void aT() {
        MessengerPhotoEditDialogFragment messengerPhotoEditDialogFragment = (MessengerPhotoEditDialogFragment) s().a("PHOTO_EDIT");
        if (messengerPhotoEditDialogFragment != null && !StringUtil.a(messengerPhotoEditDialogFragment.au.g(), this.br.g())) {
            messengerPhotoEditDialogFragment.b();
        }
    }

    private void aU() {
        MessengerPhotoEditDialogFragment messengerPhotoEditDialogFragment = (MessengerPhotoEditDialogFragment) s().a("PHOTO_EDIT");
        if (messengerPhotoEditDialogFragment != null) {
            messengerPhotoEditDialogFragment.au = this.br;
        }
    }

    private void aV() {
        MessengerVideoEditDialogFragment messengerVideoEditDialogFragment = (MessengerVideoEditDialogFragment) s().a("VIDEO_EDIT");
        if (messengerVideoEditDialogFragment != null) {
            messengerVideoEditDialogFragment.at = this.br;
        }
    }

    private void aW() {
        LocationSendingDialogFragment locationSendingDialogFragment = (LocationSendingDialogFragment) s().a("LOCATION_SHARE_FRAGMENT_TAG");
        if (locationSendingDialogFragment != null) {
            locationSendingDialogFragment.b();
        }
    }

    private void aX() {
        SampleContentReplyFragment sampleContentReplyFragment = (SampleContentReplyFragment) s().a("sample_content_reply_fragment");
        if (sampleContentReplyFragment != null) {
            sampleContentReplyFragment.b();
        }
    }

    public final void m4941I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2018824375);
        super.I();
        if (this.bo != null) {
            this.bo.clearFocus();
        }
        this.bm.m5107w();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1056679270, a);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 60518291);
        super.mi_();
        this.aq.m4734a(this.bv);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -451495774, a);
    }

    public final void m4939G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1515876538);
        TracerDetour.a("ComposeFragment.onResume", 736431251);
        try {
            super.G();
            if (!m4906b((Fragment) this)) {
                this.aM.m5116a();
                this.ar.m4742a();
                this.bm.m5086a(true);
            }
            bd(this);
            this.bL.b();
            TracerDetour.a(47859768);
            Activity ao = ao();
            if (ao != null) {
                Intent intent = ao.getIntent();
                boolean a2 = MessagingIntents.a(intent, "focus_audio_compose", false);
                boolean a3 = MessagingIntents.a(intent, "focus_compose", false);
                if (a2) {
                    this.bm.m5101p();
                } else if (a3) {
                    ar();
                }
            }
            aY();
            this.bo.mo182e();
            if (((Boolean) this.am.get()).booleanValue()) {
                ((MessageCapKeyboardGuardController) this.aQ.get()).a();
            }
            this.bm.m5106v();
            LogUtils.f(340409494, a);
        } catch (Throwable th) {
            TracerDetour.a(-1965489088);
            LogUtils.f(1410495219, a);
        }
    }

    private void aY() {
        this.av.m5010b((Fragment) this);
        this.aX.a(this);
    }

    public final void m4956a(ComposerInitParams composerInitParams) {
        if (composerInitParams != null) {
            if (composerInitParams.f5431g) {
                m4902b(this, true, composerInitParams.f5425a);
                return;
            }
            if (composerInitParams.f5425a != null) {
                this.bo.getEditor().a(composerInitParams.f5425a);
                this.bo.getEditor().a(composerInitParams.f5425a.length());
            }
            if (composerInitParams.f5426b != null) {
                final List a = Lists.a();
                for (MediaResource mediaResource : composerInitParams.f5426b) {
                    if (MediaResourceUtil.a(mediaResource)) {
                        a.add(mediaResource);
                    } else {
                        m4890a(m4907c(this, jW_().getString(2131231250)));
                    }
                }
                if (!a.isEmpty()) {
                    if (Iterables.e(a, new 1(this.aN))) {
                        m4905b(a);
                    } else {
                        Futures.a(this.f5398e.a(new Callable<List<MediaResource>>(this) {
                            final /* synthetic */ ComposeFragment f5347b;

                            public Object call() {
                                return this.f5347b.aN.b(a);
                            }
                        }), new FutureCallback<List<MediaResource>>(this) {
                            final /* synthetic */ ComposeFragment f5348a;

                            {
                                this.f5348a = r1;
                            }

                            public void onSuccess(Object obj) {
                                this.f5348a.m4905b((List) obj);
                            }

                            public void onFailure(Throwable th) {
                                this.f5348a.m4890a(ComposeFragment.m4907c(this.f5348a, this.f5348a.jW_().getString(2131230758)));
                            }
                        }, this.f5399f);
                    }
                }
            }
            bd(this);
            if (composerInitParams.f5427c != null) {
                PickMediaDialogFragment.a(composerInitParams.f5427c).a(s(), "pick_media_dialog");
                this.bF = true;
            }
            this.av.m5006a(composerInitParams);
            if (composerInitParams.f5430f) {
                this.bm.m5088c();
            }
            this.bG = composerInitParams.f5429e;
            if (!(this.bG == null || this.bG.a() != null || this.aY.get() == null)) {
                this.bJ = ((PlatformShareUploadManager) this.aY.get()).m3489a(this.bG);
                Futures.a(this.bJ, new FutureCallback<ShareItem>(this) {
                    final /* synthetic */ ComposeFragment f5349a;

                    {
                        this.f5349a = r1;
                    }

                    public void onSuccess(Object obj) {
                        this.f5349a.bG = (ShareItem) obj;
                        ComposeFragment.aZ(this.f5349a);
                    }

                    public void onFailure(Throwable th) {
                        this.f5349a.bG = null;
                        Bundle bundle = new Bundle();
                        bundle.putString("com.facebook.platform.extra.COMPOSER_ERROR", "Failed to upload share");
                        if (th != null) {
                            bundle.putSerializable("com.facebook.platform.extra.COMPOSER_EXCEPTION", th);
                        }
                        this.f5349a.ao().setResult(0, new Intent().putExtras(bundle));
                        this.f5349a.ao().finish();
                    }
                }, this.f5399f);
            }
            this.bP = composerInitParams.f5432h;
            aZ(this);
        }
    }

    public static void m4902b(ComposeFragment composeFragment, boolean z, String str) {
        if (z) {
            if (StringUtil.a(composeFragment.bE)) {
                composeFragment.bE = Long.toString(composeFragment.aV.a());
            }
            composeFragment.m4866a(composeFragment.aW.a(composeFragment.br, composeFragment.bE, str), MessageSendTrigger.ACTION_LINK);
            return;
        }
        composeFragment.bo.getEditor().a(str);
        composeFragment.bo.getEditor().a(str.length());
    }

    private void m4883a(Mode mode) {
        if (mode == Mode.STICKER) {
            this.bm.m5088c();
        } else if (mode == Mode.GIF) {
            this.bo.mo175a(ContentSearchType.ANIMATION, null, true, "action_link_pressed");
        }
    }

    public final boolean au() {
        ((NavigationLogger) this.aU.get()).a("tap_back_button");
        if (this.bo.mo192j()) {
            return true;
        }
        if (this.bm.m5108x()) {
            return true;
        }
        ((NavigationLogger) this.aU.get()).a(null);
        return false;
    }

    public final int m4942a(ComposerPointerLocation composerPointerLocation, boolean z) {
        return this.bo.mo173a(composerPointerLocation, z);
    }

    public static void aZ(ComposeFragment composeFragment) {
        composeFragment.bc();
        if (composeFragment.bH != null && composeFragment.bG != null) {
            boolean z;
            if (composeFragment.bI == null) {
                composeFragment.bI = (SharePreviewLayout) composeFragment.bH.inflate();
            }
            if (composeFragment.bJ != null) {
                composeFragment.bI.h = false;
                if (!composeFragment.bJ.isDone()) {
                    z = true;
                    if (composeFragment.bG.j == null || composeFragment.bG.g != null) {
                        composeFragment.bI.a(SharePreviewLayout.Mode.OPEN_GRAPH);
                    } else {
                        composeFragment.bI.a(SharePreviewLayout.Mode.LINK_SHARE);
                    }
                    if (z) {
                        composeFragment.bI.b(false).a(composeFragment.bG.a).b(composeFragment.bG.b).c(composeFragment.bG.c).a(composeFragment.bG.d, f5395b).d(composeFragment.bG.g).a(composeFragment.bG.h);
                    } else {
                        composeFragment.bI.b(true);
                    }
                    bd(composeFragment);
                }
            }
            z = false;
            if (composeFragment.bG.j == null) {
            }
            composeFragment.bI.a(SharePreviewLayout.Mode.OPEN_GRAPH);
            if (z) {
                composeFragment.bI.b(false).a(composeFragment.bG.a).b(composeFragment.bG.b).c(composeFragment.bG.c).a(composeFragment.bG.d, f5395b).d(composeFragment.bG.g).a(composeFragment.bG.h);
            } else {
                composeFragment.bI.b(true);
            }
            bd(composeFragment);
        }
    }

    public final MessageDraft av() {
        if (ba()) {
            return null;
        }
        int i;
        if (this.bo.mo191i()) {
            i = 0;
        } else {
            i = this.bo.getEditor().c.getSelectionStart();
        }
        return new MessageDraft(this.bo.getUnsentMessageText(), i, this.aq.m4738d(), this.bE);
    }

    public final void aw() {
        this.bO = ba();
    }

    private boolean ba() {
        return StringUtil.a(this.bo.getEditor().a().toString()) && this.aq.m4736b();
    }

    public final boolean ax() {
        return this.bO && ba();
    }

    public final void m4950a(@Nullable MessageDraft messageDraft) {
        this.bO = messageDraft == null;
        if (messageDraft != null) {
            String str = messageDraft.a;
            this.bo.getEditor().a(str);
            this.bo.getEditor().a(messageDraft.b);
            bd(this);
            List<MediaResource> list = messageDraft.c;
            this.bE = messageDraft.d;
            if (!list.isEmpty()) {
                aD();
                for (MediaResource mediaResource : list) {
                    if (MediaResourceUtil.a(mediaResource)) {
                        this.aq.m4733a(mediaResource, this.bE, this.br);
                    } else {
                        BLog.a(f5394a, "cannot create attachment for draft");
                    }
                }
            }
            bc();
            if (!StringUtil.a(str) || !list.isEmpty()) {
                ar();
            }
        }
    }

    public final void m4951a(ThreadKey threadKey) {
        if (this.T == null) {
            this.bs = threadKey;
            return;
        }
        Preconditions.checkNotNull(threadKey);
        int i = !threadKey.equals(this.br) ? 1 : 0;
        if (i != 0) {
            aW();
            aX();
            bE();
        }
        this.br = threadKey;
        this.bC = ThreadKey.d(threadKey);
        this.bB = 0;
        this.ar.m4743a(this.br);
        ComposerKeyboardManager composerKeyboardManager = this.bm;
        ThreadKey threadKey2 = this.br;
        composerKeyboardManager.f5490t = threadKey2;
        for (KeyboardHolder keyboardHolder : composerKeyboardManager.f5487q.values()) {
            keyboardHolder.f5452c.a(threadKey2);
        }
        this.bo.setThreadKey(this.br);
        this.bo.setIsSmsThread(this.bC);
        aE();
        this.av.f5420o = this.br;
        aU();
        aV();
        aT();
        aS();
        bb();
        bA(this);
        MediaTrayKeyboard mediaTrayKeyboard = (MediaTrayKeyboard) this.bm.m5087b("gallery");
        if (mediaTrayKeyboard != null && i != 0) {
            ((MediaTrayKeyboardView) mediaTrayKeyboard.a).m3100j();
        }
    }

    public final void m4974g(int i) {
        if (this.bo == null) {
            this.bS = Integer.valueOf(i);
        } else {
            this.bo.setComposerButtonActiveColorFilterOverride(i);
        }
    }

    public final void m4958a(@Nullable String str) {
        int i;
        this.bQ = str;
        if (this.bQ == null || ((EmojiUtil) this.aC.get()).a(this.bQ) == null) {
            i = 0;
        } else {
            i = ((BigEmojis) this.as.get()).a();
        }
        this.bo.setLikeIconIdOverride(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void bb() {
        /*
        r12 = this;
        r2 = 0;
        r0 = 1;
        r1 = 0;
        r3 = r12.bz;
        if (r3 == 0) goto L_0x008c;
    L_0x0007:
        r3 = r12.br;
        if (r3 == 0) goto L_0x008c;
    L_0x000b:
        r3 = r12.br;
        r3 = com.facebook.messaging.audio.composer.AudioComposerPrefKeys.a(r3);
        if (r3 == 0) goto L_0x008c;
    L_0x0013:
        r4 = r12.aI;
        r3 = r4.a(r3, r1);
        if (r3 != r0) goto L_0x008c;
    L_0x001b:
        r1 = r12.bM;
        if (r1 == 0) goto L_0x0026;
    L_0x001f:
        if (r0 == 0) goto L_0x0081;
    L_0x0021:
        r0 = r12.bm;
        r0.m5101p();
    L_0x0026:
        r12.bc();
        r0 = r12.br;
        if (r0 == 0) goto L_0x008a;
    L_0x002d:
        r0 = r12.br;
        r0 = r0.a;
        r1 = com.facebook.messaging.model.threadkey.ThreadKey.Type.ONE_TO_ONE;
        if (r0 != r1) goto L_0x008a;
    L_0x0035:
        r0 = r12.br;
        r0 = r0.d;
        r0 = java.lang.Long.toString(r0);
        r0 = com.facebook.user.model.UserKey.b(r0);
    L_0x0041:
        r1 = bo(r12);
        r3 = com.facebook.messaging.blocking.BlockingUtils.a(r1);
        if (r3 == 0) goto L_0x0087;
    L_0x004b:
        r2 = r12.ay;
        r8 = new com.facebook.presence.ConversationTypingContext;
        r9 = new com.facebook.presence.ConversationTypingManager;
        r10 = 3210; // 0xc8a float:4.498E-42 double:1.586E-320;
        r10 = com.facebook.inject.IdBasedSingletonScopeProvider.b(r2, r10);
        r11 = 3194; // 0xc7a float:4.476E-42 double:1.578E-320;
        r11 = com.facebook.inject.IdBasedSingletonScopeProvider.b(r2, r11);
        r9.<init>(r10, r11);
        r5 = r9;
        r5 = (com.facebook.presence.TypingPresenceManager) r5;
        r6 = com.facebook.common.executors.ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider.a(r2);
        r6 = (java.util.concurrent.ScheduledExecutorService) r6;
        r7 = com.facebook.common.time.SystemClockMethodAutoProvider.a(r2);
        r7 = (com.facebook.common.time.Clock) r7;
        r8.<init>(r5, r6, r7, r0);
        r0 = r8;
        r12.by = r0;
    L_0x0075:
        r0 = r12.bo;
        r2 = r12.aE;
        r1 = r2.a(r1);
        r0.setIsSecretMode(r1);
        return;
    L_0x0081:
        r0 = r12.bm;
        r0.m5102q();
        goto L_0x0026;
    L_0x0087:
        r12.by = r2;
        goto L_0x0075;
    L_0x008a:
        r0 = r2;
        goto L_0x0041;
    L_0x008c:
        r0 = r1;
        goto L_0x001b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.compose.ComposeFragment.bb():void");
    }

    public final void m4968b(boolean z) {
        this.bw = z;
    }

    public final void m4976h(boolean z) {
        this.bx = z;
        bc();
    }

    public final void ay() {
        bd(this);
    }

    public final void m4967b(String str) {
        ((StickerKeyboardView) this.bm.m5088c().a).a(str);
    }

    public final void m4957a(StickerPack stickerPack) {
        StickerKeyboardView stickerKeyboardView = (StickerKeyboardView) this.bm.m5088c().a;
        StickerPack stickerPack2 = stickerKeyboardView.E;
        if (stickerPack2 != null && stickerPack2.a.equals(stickerPack.a)) {
            stickerKeyboardView.a(stickerPack2.a);
        }
        stickerKeyboardView.E = stickerPack;
        stickerKeyboardView.p.edit().a(StickerPrefKeys.c, stickerPack.a).commit();
        stickerKeyboardView.u = stickerPack.a;
        if (!stickerKeyboardView.g.n) {
            return;
        }
        if (stickerPack2 == null) {
            StickerKeyboardView.c(stickerKeyboardView, stickerPack);
            stickerKeyboardView.E = stickerPack;
            StickerKeyboardPackPopupTabItem stickerKeyboardPackPopupTabItem = new StickerKeyboardPackPopupTabItem(stickerPack, TabType.PULSING_DOWNLOAD_PREVIEW);
            stickerKeyboardView.D.add(stickerKeyboardView.F, stickerKeyboardPackPopupTabItem);
            stickerKeyboardView.g.a(stickerKeyboardView.F, stickerKeyboardPackPopupTabItem);
            stickerKeyboardView.g.a(stickerPack.a);
            return;
        }
        StickerKeyboardView.i(stickerKeyboardView);
    }

    public final void az() {
        this.bm.m5088c();
    }

    public final void aA() {
        if (!this.bM) {
            this.bm.m5102q();
        }
        this.bm.m5100o();
        this.bm.m5098m();
        this.bm.m5090d();
        this.bm.m5094i();
        this.bm.m5104s();
        this.bm.m5096k();
        this.bm.m5105u();
        this.bm.m5092g();
    }

    public final void m4954a(ComposeMode composeMode) {
        if (composeMode != ComposeMode.EXPANDED && aB()) {
            this.ao.m4482a();
        }
        this.bo.setComposeMode(composeMode);
        bc();
    }

    public final void m4952a(ComposerListener composerListener) {
        this.bt = composerListener;
    }

    public final boolean aB() {
        return StringUtil.a(CharMatcher.WHITESPACE.trimFrom(this.bo.getEditor().a().toString())) && this.aq.m4736b() && this.bG == null;
    }

    public final void aC() {
        this.bo.getEditor().d();
        this.bE = null;
        bd(this);
    }

    public final void aD() {
        TracerDetour.a("ComposeFragment.clearAttachments", -549522965);
        try {
            this.aq.m4737c();
            this.bE = null;
        } finally {
            TracerDetour.a(-2010829263);
        }
    }

    public final void m4966b(ThreadKey threadKey) {
        if (this.bM) {
            this.aI.edit().a(AudioComposerPrefKeys.a(threadKey), this.bm.m5089c("voice_clip") ? 1 : 0).commit();
        }
    }

    public final void aE() {
        this.bo.mo178b();
        if ((this.bo instanceof TwoLineComposerView) && ((TwoLineComposerView) this.bo).m5343c("quick_reply")) {
            ComposerKeyboardManager composerKeyboardManager = this.bm;
            ImmutableList a = MQuickReplyKeyboardView.m1471a(composerKeyboardManager.f5470B, composerKeyboardManager.f5490t);
            if (a != null && !a.isEmpty()) {
                composerKeyboardManager.m5091e();
            }
        }
    }

    private void bc() {
        boolean z = bx() && (!this.bx || (this.bG == null && this.aq.m4736b()));
        this.bo.setCanSendStickers(z);
    }

    public final void m4977i(boolean z) {
        this.bo.mo177a(z, null);
    }

    public static SpannableString m4907c(ComposeFragment composeFragment, String str) {
        Resources jW_ = composeFragment.jW_();
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(composeFragment.jW_());
        styledStringBuilder.a(new ForegroundColorSpan(jW_.getColor(2131362277)), 33);
        styledStringBuilder.a(str);
        styledStringBuilder.a();
        return styledStringBuilder.b();
    }

    private void m4890a(CharSequence charSequence) {
        this.ao.m4483a(this.T, charSequence);
    }

    public static void bd(ComposeFragment composeFragment) {
        composeFragment.be();
        composeFragment.bf();
    }

    private void be() {
        boolean z = true;
        boolean z2;
        if (this.bJ == null || this.bJ.isDone()) {
            z2 = false;
        } else {
            z2 = true;
        }
        MessageComposer messageComposer = this.bo;
        if (aB() || r0) {
            z = false;
        }
        messageComposer.setIsSendEnabled(z);
    }

    private void bf() {
        this.bo.setIsLikeEnabled(bg(this));
    }

    public static boolean bg(ComposeFragment composeFragment) {
        return composeFragment.aB() && composeFragment.bw;
    }

    public static void bh(ComposeFragment composeFragment) {
        if (composeFragment.aq.m4739e()) {
            composeFragment.m4867a(InvalidAttachmentCompositionErrorSource.SEND_BUTTON);
            return;
        }
        if (!composeFragment.aB()) {
            composeFragment.bi();
        }
        bd(composeFragment);
    }

    private void bi() {
        m4866a(bk(), MessageSendTrigger.COMPOSER_TEXT_TAB);
        bm();
    }

    private void m4862a(MessageSendTrigger messageSendTrigger) {
        m4866a(bl(), messageSendTrigger);
    }

    public static boolean bj(ComposeFragment composeFragment) {
        if (StringUtil.a(composeFragment.bE)) {
            composeFragment.bE = Long.toString(composeFragment.aV.a());
        }
        composeFragment.m4866a(composeFragment.aW.a(composeFragment.br, composeFragment.bE, Emojis.a), MessageSendTrigger.COMPOSER_HOT_LIKE);
        composeFragment.bm();
        return true;
    }

    private Message bk() {
        if (StringUtil.a(this.bE)) {
            this.bE = Long.toString(this.aV.a());
        }
        SentShareAttachment sentShareAttachment = null;
        if (this.bG != null) {
            ShareItem shareItem = this.bG;
            ShareMediaBuilder shareMediaBuilder = new ShareMediaBuilder();
            shareMediaBuilder.b = shareItem.e;
            shareMediaBuilder = shareMediaBuilder;
            shareMediaBuilder.a = ShareMedia.Type.LINK;
            shareMediaBuilder = shareMediaBuilder;
            shareMediaBuilder.c = shareItem.d;
            ShareMedia e = shareMediaBuilder.e();
            ShareBuilder shareBuilder = new ShareBuilder();
            shareBuilder.a = shareItem.a();
            shareBuilder = shareBuilder;
            shareBuilder.c = shareItem.a;
            shareBuilder = shareBuilder;
            shareBuilder.d = "";
            shareBuilder = shareBuilder;
            shareBuilder.e = shareItem.c;
            shareBuilder = shareBuilder;
            shareBuilder.f = shareItem.e;
            shareBuilder = shareBuilder;
            shareBuilder.g = ImmutableList.of(e);
            ShareBuilder shareBuilder2 = shareBuilder;
            shareBuilder2.j = shareItem.i.a();
            sentShareAttachment = SentShareAttachment.a(shareBuilder2.n());
        }
        String trim = this.bo.getEditor().a().toString().trim();
        ImmutableList d = this.aq.m4738d();
        if (this.bC) {
            return this.aW.b(this.br, this.bE, trim, d, sentShareAttachment, this.bP, RegularImmutableBiMap.a);
        }
        return this.aW.a(this.br, this.bE, trim, d, sentShareAttachment, this.bP, RegularImmutableBiMap.a);
    }

    private Message bl() {
        if (StringUtil.a(this.bE)) {
            this.bE = Long.toString(this.aV.a());
        }
        if (this.bC) {
            return this.aW.b(this.br, this.bE, "", this.aq.m4738d(), null, this.bP, RegularImmutableBiMap.a);
        }
        return this.aW.a(this.br, this.bE, "", this.aq.m4738d(), null, this.bP, RegularImmutableBiMap.a);
    }

    public final void m4961a(String str, String str2) {
        Message b;
        if (!((Boolean) this.f5402i.get()).booleanValue() || StringUtil.a(this.bQ)) {
            b = this.aW.b(this.br, str, str2);
        } else {
            b = this.aW.a(this.br, str, str2, this.bQ);
        }
        if (((Boolean) this.f5401h.get()).booleanValue() && !this.aB.a(this.br)) {
            EmojilikeNuxAnchorProvider emojilikeNuxAnchorProvider = this.aB;
            ThreadKey threadKey = this.br;
            String str3 = b.n;
            emojilikeNuxAnchorProvider.b.put(threadKey, str3);
            emojilikeNuxAnchorProvider.a.edit().a(CustomThreadsPrefKeys.a(threadKey), str3).commit();
        }
        m4866a(b, MessageSendTrigger.COMPOSER_HOT_LIKE);
        bm();
    }

    public final void m4959a(String str, MessageSendTrigger messageSendTrigger) {
        m4866a(this.aW.b(this.br, str), messageSendTrigger);
    }

    private void bm() {
        this.bN = true;
        HandlerDetour.b(this.f5400g, new Runnable(this) {
            final /* synthetic */ ComposeFragment f5350a;

            {
                this.f5350a = r1;
            }

            public void run() {
                this.f5350a.bN = false;
            }
        }, 1000, 1957512605);
    }

    private void m4885a(MediaResource mediaResource, MessageSendTrigger messageSendTrigger) {
        m4904b(mediaResource, messageSendTrigger);
    }

    private void m4884a(MediaResource mediaResource) {
        boolean z = mediaResource.d == Type.PHOTO || mediaResource.d == Type.VIDEO;
        Preconditions.checkState(z);
        m4904b(mediaResource, MessageSendTrigger.COMPOSER_QUICK_CAM_TAB);
    }

    private void m4904b(MediaResource mediaResource, MessageSendTrigger messageSendTrigger) {
        Message b;
        String l = Long.toString(this.aV.a());
        MediaResourceBuilder a = MediaResource.a().a(mediaResource);
        a.k = l;
        a = a;
        a.l = this.br;
        a = a;
        if (ThreadKey.g(this.br)) {
            m4888a(a);
        }
        if (mediaResource.d != Type.AUDIO && mediaResource.l == ExifOrientation.UNDEFINED) {
            ExifOrientation exifOrientation;
            int i = this.bA;
            if (i == 1) {
                exifOrientation = ExifOrientation.NORMAL;
            } else if (i == 2) {
                exifOrientation = ExifOrientation.FLIP_HORIZONTAL;
            } else {
                exifOrientation = ExifOrientation.UNDEFINED;
            }
            a.j = exifOrientation;
        }
        MediaResource C = a.C();
        if (this.bC) {
            b = this.aW.b(this.br, C, l);
        } else {
            ((MediaUploadManagerImpl) this.aP.get()).a(C);
            b = this.aW.a(this.br, C, l);
        }
        m4866a(b, messageSendTrigger);
    }

    private void m4888a(MediaResourceBuilder mediaResourceBuilder) {
        try {
            mediaResourceBuilder.a(Type.ENCRYPTED_PHOTO).d(Base64.encodeToString(this.aD.m5112a(), 0));
        } catch (KeyChainException e) {
            Assertions.a("Unable to generate key for attachment encryption " + e.getMessage());
        }
    }

    public final void m4948a(LatLng latLng) {
        Message b;
        if (this.bC || ThreadKey.g(this.br)) {
            b = this.aW.b(this.br, latLng);
        } else {
            b = this.aW.a(this.br, latLng);
        }
        m4866a(b, MessageSendTrigger.COMPOSER_LOCATION_TAB);
    }

    public final void m4965b(LatLng latLng) {
        Message d;
        if (this.bC || ThreadKey.g(this.br)) {
            d = this.aW.d(this.br, latLng);
        } else {
            d = this.aW.c(this.br, latLng);
        }
        m4866a(d, MessageSendTrigger.COMPOSER_LOCATION_TAB);
    }

    public final void m4949a(NearbyPlace nearbyPlace) {
        Message b;
        if (this.bC || ThreadKey.g(this.br)) {
            b = this.aW.b(this.br, nearbyPlace);
        } else {
            b = this.aW.a(this.br, nearbyPlace);
        }
        m4866a(b, MessageSendTrigger.COMPOSER_LOCATION_TAB);
    }

    private void m4866a(Message message, final MessageSendTrigger messageSendTrigger) {
        if (message.f == null || message.f.length() <= 5000) {
            if (this.bo.mo190h()) {
                MessageBuilder a = Message.newBuilder().a(message);
                a.O = true;
                message = a.R();
            }
            if (this.bt != null && this.E != null && !bn(this)) {
                if (((SmsDefaultAppManager) this.bc.get()).a(this.bC)) {
                    ((SmsDefaultAppManager) this.bc.get()).a(SmsCallerContext.SEND_MESSAGE, new Runnable(this) {
                        final /* synthetic */ ComposeFragment f5353c;

                        public void run() {
                            this.f5353c.m4866a(message, messageSendTrigger);
                        }
                    });
                    return;
                }
                this.bg.c(messageSendTrigger.toString());
                this.bt.mo147a(message, messageSendTrigger);
            }
        }
    }

    public static boolean bn(ComposeFragment composeFragment) {
        Object obj;
        boolean z;
        BlockingUtils blockingUtils = composeFragment.at;
        User bp = composeFragment.bp();
        ThreadKey threadKey = composeFragment.br;
        ThreadSummary bo = bo(composeFragment);
        FragmentManager s = composeFragment.s();
        if (threadKey == null || !threadKey.b()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null || bp == null) {
            z = false;
        } else if (BlockingUtils.a(bp, s)) {
            z = true;
        } else if (((Boolean) blockingUtils.d.get()).booleanValue()) {
            String string;
            ErrorDialogs errorDialogs;
            ErrorDialogParamsBuilder a;
            if (!BlockingUtils.a(bo)) {
                GraphQLMessageThreadCannotReplyReason graphQLMessageThreadCannotReplyReason;
                if (bo == null) {
                    graphQLMessageThreadCannotReplyReason = GraphQLMessageThreadCannotReplyReason.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
                } else {
                    graphQLMessageThreadCannotReplyReason = bo.v;
                }
                if (graphQLMessageThreadCannotReplyReason == GraphQLMessageThreadCannotReplyReason.BLOCKED) {
                    obj = 1;
                    if (obj == null) {
                        obj = null;
                        if (threadKey == null && !bp.K) {
                            obj = 1;
                        }
                        if (obj == null) {
                            z = false;
                        }
                    }
                    if (bp != null) {
                        if (bp.U()) {
                            string = blockingUtils.f.getResources().getString(2131240231, new Object[]{bp.j()});
                        } else {
                            string = blockingUtils.f.getResources().getString(2131240232);
                        }
                        errorDialogs = blockingUtils.e;
                        a = ErrorDialogParams.a(blockingUtils.f);
                        a.c = string;
                        errorDialogs.a(a.l());
                    }
                    z = true;
                }
            }
            obj = null;
            if (obj == null) {
                obj = null;
                obj = 1;
                if (obj == null) {
                    z = false;
                }
            }
            if (bp != null) {
                if (bp.U()) {
                    string = blockingUtils.f.getResources().getString(2131240231, new Object[]{bp.j()});
                } else {
                    string = blockingUtils.f.getResources().getString(2131240232);
                }
                errorDialogs = blockingUtils.e;
                a = ErrorDialogParams.a(blockingUtils.f);
                a.c = string;
                errorDialogs.a(a.l());
            }
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public static ThreadSummary bo(ComposeFragment composeFragment) {
        return composeFragment.az.a(composeFragment.br);
    }

    @Nullable
    private User bp() {
        if (this.br != null) {
            return this.bh.a(ThreadKey.a(this.br));
        }
        Object c = this.bt.mo150c();
        if (StringUtil.a(c)) {
            return null;
        }
        return this.bh.a(UserKey.b(c));
    }

    public static void bq(ComposeFragment composeFragment) {
        if (composeFragment.bI()) {
            composeFragment.bm.m5109z();
        }
    }

    private void m4860a(Parcelable parcelable) {
        m4861a(parcelable, this.br);
    }

    private void m4861a(Parcelable parcelable, ThreadKey threadKey) {
        String obj = this.bo.getEditor().a().toString();
        Intent a = ThreadViewActivity.m7086a(getContext(), threadKey);
        a.putExtra("show_composer", true);
        a.putExtra("composer_initial_text", obj);
        if (parcelable instanceof PickMediaDialogParams) {
            a.putExtra("open_media_picker_params", parcelable);
        } else if (parcelable instanceof OrionMessengerPayParams) {
            a.putExtra("orion_messenger_pay_params", parcelable);
        }
        a.setFlags(67108864);
        a(a);
    }

    public final void aF() {
        ComposerKeyboardManager composerKeyboardManager = this.bm;
        if (composerKeyboardManager.f5491u != null && composerKeyboardManager.f5491u.f5455f == KeyboardState.SHOWN) {
            composerKeyboardManager.f5491u.f5452c.g();
        }
    }

    public final void aG() {
        ComposerKeyboardManager composerKeyboardManager = this.bm;
        if (composerKeyboardManager.f5491u != null && composerKeyboardManager.f5491u.f5455f == KeyboardState.SHOWN) {
            composerKeyboardManager.f5491u.f5452c.h();
        }
    }

    public final void aH() {
        this.bm.m5095j();
    }

    public final void aI() {
        this.bm.m5101p();
    }

    private void m4893a(List<MediaResource> list) {
        final ThreadKey threadKey = this.br;
        Iterable arrayList = new ArrayList();
        for (final MediaResource mediaResource : list) {
            arrayList.add(this.f5398e.a(new Callable<MediaResource>(this) {
                final /* synthetic */ ComposeFragment f5355b;

                public Object call() {
                    if (mediaResource.d == Type.VIDEO) {
                        Object obj;
                        VideoMetadata a = this.f5355b.bj.a(mediaResource.c);
                        VideoSizeChecker videoSizeChecker = this.f5355b.bk;
                        MediaResource mediaResource = mediaResource;
                        if (videoSizeChecker.a.a(a, mediaResource.s, mediaResource.t).c > videoSizeChecker.d.a()) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            throw new VideoTranscoderException("Video is too large to send.");
                        }
                    }
                    return this.f5355b.aN.b(mediaResource);
                }
            }));
        }
        Futures.a(Futures.a(arrayList), new FutureCallback<List<MediaResource>>(this) {
            final /* synthetic */ ComposeFragment f5359b;

            /* compiled from: original message is not set */
            class C07531 implements DialogListener {
                final /* synthetic */ AnonymousClass20 f5357a;

                C07531(AnonymousClass20 anonymousClass20) {
                    this.f5357a = anonymousClass20;
                }

                public final void m4753a() {
                }
            }

            public void onSuccess(@Nullable Object obj) {
                List<MediaResource> list = (List) obj;
                if (Objects.equal(threadKey, this.f5359b.br) && list != null) {
                    Object obj2 = null;
                    for (MediaResource mediaResource : list) {
                        if (mediaResource.d == Type.PHOTO) {
                            obj2 = 1;
                            this.f5359b.aq.m4733a(mediaResource, this.f5359b.bE, this.f5359b.br);
                        } else if (mediaResource.d == Type.VIDEO) {
                            this.f5359b.m4904b(mediaResource, MessageSendTrigger.COMPOSER_MEDIA_TRAY_TAB);
                        }
                    }
                    if (obj2 != null) {
                        this.f5359b.m4862a(MessageSendTrigger.COMPOSER_MEDIA_TRAY_TAB);
                    }
                }
            }

            public void onFailure(Throwable th) {
                if (th instanceof VideoTranscoderException) {
                    VideoSizeChecker videoSizeChecker = this.f5359b.bk;
                    new FbAlertDialogBuilder(videoSizeChecker.b).a(2131231752).b(2131231753).c(17039370, new 3(videoSizeChecker, new C07531(this))).b();
                    videoSizeChecker.c.a("messenger_videos_too_big_dialog", true, Collections.singletonMap("fromModule", "media_tray_popup"));
                    return;
                }
                this.f5359b.bf.b(new ToastBuilder(2131231948));
            }
        }, this.f5399f);
    }

    private void m4903b(MediaResource mediaResource) {
        if (mediaResource.d == Type.VIDEO) {
            m4911c(mediaResource);
        } else {
            m4917e(this, mediaResource);
        }
    }

    private void m4911c(final MediaResource mediaResource) {
        if (m4914d(mediaResource)) {
            final ThreadKey threadKey = this.br;
            Futures.a(this.f5398e.a(new Callable<VideoMetadata>(this) {
                final /* synthetic */ ComposeFragment f5361b;

                public Object call() {
                    return this.f5361b.bj.a(mediaResource.c);
                }
            }), new FutureCallback<VideoMetadata>(this) {
                final /* synthetic */ ComposeFragment f5364c;

                public void onSuccess(Object obj) {
                    VideoMetadata videoMetadata = (VideoMetadata) obj;
                    if (Objects.equal(threadKey, this.f5364c.br)) {
                        this.f5364c.m4887a(mediaResource, videoMetadata);
                    }
                }

                public void onFailure(Throwable th) {
                    this.f5364c.aH.a("failed_video_length_retrieval", "Failed to get meta data for video", th);
                }
            }, this.f5399f);
        }
    }

    private boolean m4914d(MediaResource mediaResource) {
        return this.bi.a(mediaResource.c, "media_tray_popup");
    }

    private void m4887a(final MediaResource mediaResource, VideoMetadata videoMetadata) {
        Object obj;
        VideoSizeChecker videoSizeChecker = this.bk;
        if (videoSizeChecker.a.a(videoMetadata, -1, -2).c > videoSizeChecker.d.a()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            videoSizeChecker = this.bk;
            AnonymousClass23 anonymousClass23 = new DialogListener(this) {
                final /* synthetic */ ComposeFragment f5366b;

                public final void m4754a() {
                    this.f5366b.m4886a(mediaResource, null);
                }
            };
            new FbAlertDialogBuilder(videoSizeChecker.b).a(2131231749).b(2131231750).b(17039360, new 2(videoSizeChecker, anonymousClass23)).a(2131231751, new VideoSizeChecker.1(videoSizeChecker, anonymousClass23)).b();
            videoSizeChecker.c.a("messenger_video_too_big_dialog", true, Collections.singletonMap("fromModule", "media_tray_popup"));
            return;
        }
        m4917e(this, mediaResource);
    }

    private void m4886a(MediaResource mediaResource, @Nullable MediaEditCallback mediaEditCallback) {
        boolean z = true;
        FullScreenDialogParams a = FullScreenDialogParams.a(this);
        if (mediaResource.d == Type.VIDEO) {
            this.bW.f5393b = mediaEditCallback;
            if (m4914d(mediaResource)) {
                if (bG()) {
                    this.bm.m5096k();
                }
                MessengerStartVideoEditHelper messengerStartVideoEditHelper = (MessengerStartVideoEditHelper) this.aT.get();
                Context context = getContext();
                FragmentManager s = s();
                String str = "VIDEO_EDIT";
                ThreadKey threadKey = this.br;
                if (mediaEditCallback == null) {
                    z = false;
                }
                messengerStartVideoEditHelper.a(context, mediaResource, s, str, a, threadKey, z);
            }
        } else if (mediaResource.d == Type.PHOTO) {
            this.bX.f5391b = mediaEditCallback;
            MediaTrayKeyboard mediaTrayKeyboard = (MediaTrayKeyboard) this.bm.m5084a("gallery");
            if (mediaTrayKeyboard != null) {
                ((MediaTrayKeyboardView) mediaTrayKeyboard.a).m3098h();
            }
            if (bG()) {
                this.bm.m5096k();
            }
            if (mediaEditCallback == null) {
                z = false;
            }
            MessengerPhotoEditDialogFragment a2 = MessengerPhotoEditDialogFragment.a(mediaResource, a, z);
            a2.au = this.br;
            a2.a(s(), "PHOTO_EDIT");
        }
    }

    public static void m4917e(ComposeFragment composeFragment, final MediaResource mediaResource) {
        final ThreadKey threadKey = composeFragment.br;
        Futures.a(composeFragment.f5398e.a(new Callable<MediaResource>(composeFragment) {
            final /* synthetic */ ComposeFragment f5368b;

            public Object call() {
                return this.f5368b.aN.b(mediaResource);
            }
        }), new FutureCallback<MediaResource>(composeFragment) {
            final /* synthetic */ ComposeFragment f5370b;

            public void onSuccess(Object obj) {
                MediaResource mediaResource = (MediaResource) obj;
                if (Objects.equal(this.f5370b.br, threadKey)) {
                    this.f5370b.m4904b(mediaResource, MessageSendTrigger.COMPOSER_MEDIA_TRAY_TAB);
                }
            }

            public void onFailure(Throwable th) {
                this.f5370b.bf.b(new ToastBuilder(2131231948));
                this.f5370b.aH.a(ComposeFragment.f5394a, "Failed to load media item to send", th);
            }
        }, composeFragment.f5399f);
    }

    private void m4897b(ComposerShortcutItem composerShortcutItem) {
        if (composerShortcutItem.k) {
            ComposerShortcutsAnalyticsLogger composerShortcutsAnalyticsLogger = (ComposerShortcutsAnalyticsLogger) this.ax.get();
            composerShortcutsAnalyticsLogger.a.a(ComposerShortcutsAnalyticsLogger.e("redirect_to_platform_app").b("app_id", composerShortcutItem.b));
            String d = m4913d(composerShortcutItem.b);
            ImmutableMap e = m4916e(composerShortcutItem.b);
            this.aX.a(this.br, this.az.a(this.br), composerShortcutItem.b, composerShortcutItem.i, d, e, this);
            return;
        }
        composerShortcutsAnalyticsLogger = (ComposerShortcutsAnalyticsLogger) this.ax.get();
        composerShortcutsAnalyticsLogger.a.a(ComposerShortcutsAnalyticsLogger.e("redirect_to_app_store").b("app_id", composerShortcutItem.b));
        this.aX.a(composerShortcutItem.b, composerShortcutItem.i);
    }

    private void m4889a(ListeningExecutorService listeningExecutorService, ExecutorService executorService, Handler handler, Provider<Boolean> provider, Provider<Boolean> provider2, Provider<Boolean> provider3, Provider<Boolean> provider4, FbBroadcastManager fbBroadcastManager, AnchorableToast anchorableToast, AttachmentDataFactory attachmentDataFactory, AttachmentsManager attachmentsManager, AutoComposeBroadcastHandler autoComposeBroadcastHandler, com.facebook.inject.Lazy<BigEmojis> lazy, BlockingUtils blockingUtils, BugReportOperationLogger bugReportOperationLogger, ComposeFragmentPaymentsHelper composeFragmentPaymentsHelper, ComposerKeyboardManagerProvider composerKeyboardManagerProvider, com.facebook.inject.Lazy<ComposerShortcutsAnalyticsLogger> lazy2, ConversationTypingContextProvider conversationTypingContextProvider, DataCache dataCache, DynamicMediaPickerPreference dynamicMediaPickerPreference, EmojilikeNuxAnchorProvider emojilikeNuxAnchorProvider, com.facebook.inject.Lazy<EmojiUtil> lazy3, EncryptionKeyGenerator encryptionKeyGenerator, EphemeralGatingUtil ephemeralGatingUtil, com.facebook.inject.Lazy<ModifyThreadEphemeralityHelper> lazy4, ExtraShortcutsHandler extraShortcutsHandler, FbErrorReporter fbErrorReporter, FbSharedPreferences fbSharedPreferences, FlowerBorderAnalyticsLogger flowerBorderAnalyticsLogger, FlowerBorderFeature flowerBorderFeature, InputMethodManager inputMethodManager, KeyboardBroadcastHandler keyboardBroadcastHandler, MediaResourceHelper mediaResourceHelper, MediaResourceUtil mediaResourceUtil, com.facebook.inject.Lazy<MediaUploadManager> lazy5, com.facebook.inject.Lazy<MessageCapKeyboardGuardController> lazy6, com.facebook.inject.Lazy<MessagingEmojiGatingUtil> lazy7, MessagingPerformanceLogger messagingPerformanceLogger, com.facebook.inject.Lazy<MessengerStartVideoEditHelper> lazy8, com.facebook.inject.Lazy<NavigationLogger> lazy9, OfflineThreadingIdGenerator offlineThreadingIdGenerator, OutgoingMessageFactory outgoingMessageFactory, PlatformLaunchHelper platformLaunchHelper, com.facebook.inject.Lazy<PlatformShareUploadManager> lazy10, com.facebook.inject.Lazy<RideOauthHelper> lazy11, SecureContextHelper secureContextHelper, ShareFactory shareFactory, com.facebook.inject.Lazy<SmsDefaultAppManager> lazy12, SoftInputDetector softInputDetector, StickerContentSearchExperimentAccessor stickerContentSearchExperimentAccessor, Toaster toaster, UiCounters uiCounters, UserCache userCache, VideoFormatChecker videoFormatChecker, VideoMetadataExtractor videoMetadataExtractor, VideoSizeChecker videoSizeChecker, ZeroDialogController zeroDialogController) {
        this.f5398e = listeningExecutorService;
        this.f5399f = executorService;
        this.f5400g = handler;
        this.f5401h = provider;
        this.f5402i = provider2;
        this.al = provider3;
        this.am = provider4;
        this.an = fbBroadcastManager;
        this.ao = anchorableToast;
        this.ap = attachmentDataFactory;
        this.aq = attachmentsManager;
        this.ar = autoComposeBroadcastHandler;
        this.as = lazy;
        this.at = blockingUtils;
        this.au = bugReportOperationLogger;
        this.av = composeFragmentPaymentsHelper;
        this.aw = composerKeyboardManagerProvider;
        this.ax = lazy2;
        this.ay = conversationTypingContextProvider;
        this.az = dataCache;
        this.aA = dynamicMediaPickerPreference;
        this.aB = emojilikeNuxAnchorProvider;
        this.aC = lazy3;
        this.aD = encryptionKeyGenerator;
        this.aE = ephemeralGatingUtil;
        this.aF = lazy4;
        this.aG = extraShortcutsHandler;
        this.aH = fbErrorReporter;
        this.aI = fbSharedPreferences;
        this.aJ = flowerBorderAnalyticsLogger;
        this.aK = flowerBorderFeature;
        this.aL = inputMethodManager;
        this.aM = keyboardBroadcastHandler;
        this.aN = mediaResourceHelper;
        this.aO = mediaResourceUtil;
        this.aP = lazy5;
        this.aQ = lazy6;
        this.aR = lazy7;
        this.aS = messagingPerformanceLogger;
        this.aT = lazy8;
        this.aU = lazy9;
        this.aV = offlineThreadingIdGenerator;
        this.aW = outgoingMessageFactory;
        this.aX = platformLaunchHelper;
        this.aY = lazy10;
        this.aZ = lazy11;
        this.ba = secureContextHelper;
        this.bb = shareFactory;
        this.bc = lazy12;
        this.bd = softInputDetector;
        this.be = stickerContentSearchExperimentAccessor;
        this.bf = toaster;
        this.bg = uiCounters;
        this.bh = userCache;
        this.bi = videoFormatChecker;
        this.bj = videoMetadataExtractor;
        this.bk = videoSizeChecker;
        this.bl = zeroDialogController;
    }

    private String m4913d(String str) {
        if (this.br == null) {
            return "";
        }
        MessagesCollection b = this.az.b(this.br);
        if (b == null) {
            return "";
        }
        ImmutableList immutableList = b.b;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            Message message = (Message) immutableList.get(i);
            if (message.F != null && Objects.equal(message.F.b, str) && !Strings.isNullOrEmpty(message.F.f)) {
                return message.F.f;
            }
        }
        return "";
    }

    private ImmutableMap<String, String> m4916e(String str) {
        if (this.br == null) {
            return RegularImmutableBiMap.a;
        }
        MessagesCollection b = this.az.b(this.br);
        if (b == null) {
            return RegularImmutableBiMap.a;
        }
        ImmutableList immutableList = b.b;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            Message message = (Message) immutableList.get(i);
            if (message.F != null && Objects.equal(message.F.b, str) && !message.F.g.isEmpty()) {
                return message.F.g;
            }
        }
        return RegularImmutableBiMap.a;
    }

    public static boolean br(ComposeFragment composeFragment) {
        return composeFragment.bx();
    }

    private void m4864a(PickMediaSource pickMediaSource) {
        if (mx_()) {
            boolean z;
            if (StringUtil.a(this.bE)) {
                this.bE = Long.toString(this.aV.a());
            }
            Set set = ThreadKey.g(this.br) ? f5397d : f5396c;
            PickMediaDialogParamsBuilder newBuilder = PickMediaDialogParams.newBuilder();
            newBuilder.a = pickMediaSource;
            newBuilder = newBuilder;
            newBuilder.d = set;
            PickMediaDialogParamsBuilder pickMediaDialogParamsBuilder = newBuilder;
            pickMediaDialogParamsBuilder.c = true;
            newBuilder = pickMediaDialogParamsBuilder;
            if (this.aq.m4735a()) {
                z = false;
            } else {
                z = true;
            }
            newBuilder.f = z;
            pickMediaDialogParamsBuilder = newBuilder;
            pickMediaDialogParamsBuilder.h = this.br;
            pickMediaDialogParamsBuilder = pickMediaDialogParamsBuilder;
            pickMediaDialogParamsBuilder.i = this.bE;
            pickMediaDialogParamsBuilder = pickMediaDialogParamsBuilder;
            if (this.aq.m4735a()) {
                pickMediaDialogParamsBuilder.g = bs();
            }
            Parcelable j = pickMediaDialogParamsBuilder.j();
            if (ContextUtils.a(getContext(), Activity.class) != null) {
                PickMediaDialogFragment.a(j).a(s(), "pick_media_dialog");
            } else {
                m4860a(j);
            }
        }
    }

    private ArrayList<MediaItem> bs() {
        AnonymousClass26 anonymousClass26 = new Predicate<MediaResource>(this) {
            final /* synthetic */ ComposeFragment f5371a;

            {
                this.f5371a = r1;
            }

            public boolean apply(@Nullable Object obj) {
                MediaResource mediaResource = (MediaResource) obj;
                return mediaResource != null && mediaResource.d == Type.PHOTO && mediaResource.e.isMediaPickerSource();
            }
        };
        return Lists.a(Collections2.a(Collections2.a(this.aq.m4738d(), anonymousClass26), new Function<MediaResource, MediaItem>(this) {
            final /* synthetic */ ComposeFragment f5372a;

            {
                this.f5372a = r1;
            }

            public Object apply(Object obj) {
                MediaResource mediaResource = (MediaResource) obj;
                return new PhotoItemBuilder().c(mediaResource.g).d(mediaResource.o).a();
            }
        }));
    }

    private void m4905b(List<MediaResource> list) {
        this.bF = false;
        if (this.aq.m4735a()) {
            this.aq.m4737c();
        }
        for (MediaResource mediaResource : list) {
            if (MediaResourceUtil.a(mediaResource)) {
                MediaResourceBuilder a = MediaResource.a().a(mediaResource);
                if (ThreadKey.g(this.br)) {
                    m4888a(a);
                }
                this.aq.m4733a(a.C(), by(), this.br);
            }
        }
        if (!this.aq.m4735a()) {
            m4862a(MessageSendTrigger.COMPOSER_MEDIA_TRAY_TAB);
        } else if (this.bu != null) {
            this.bu.mo331a();
        }
        if (this.aq.m4739e()) {
            m4867a(InvalidAttachmentCompositionErrorSource.MEDIA_PICKER);
        }
        this.bm.m5083C();
        bc();
    }

    private void m4867a(InvalidAttachmentCompositionErrorSource invalidAttachmentCompositionErrorSource) {
        new FbAlertDialogBuilder(getContext()).b(2131231732).a(17039370, new OnClickListener(this) {
            final /* synthetic */ ComposeFragment f5373a;

            {
                this.f5373a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).b();
        Map c = Maps.c();
        c.put("error_source", invalidAttachmentCompositionErrorSource.getName());
        ((NavigationLogger) this.aU.get()).a("messenger_invalid_attachment_composition_dialog", true, c);
    }

    public static void bt(ComposeFragment composeFragment) {
        if (composeFragment.bF) {
            composeFragment.bt.mo146a();
        }
        composeFragment.bF = false;
    }

    public static void bu(ComposeFragment composeFragment) {
        composeFragment.bF = false;
        composeFragment.m4890a(m4907c(composeFragment, composeFragment.jW_().getString(2131231248)));
        composeFragment.bm.m5100o();
    }

    public final void m4960a(String str, PaymentFlowType paymentFlowType, @Nullable PaymentPlatformContextModel paymentPlatformContextModel) {
        this.av.m5008a(str, bF(), this.bB, paymentFlowType, this.bt.mo150c(), paymentPlatformContextModel, this.bt.mo151d());
    }

    public final void aJ() {
        this.bm.m5083C();
        if (this.bd.f && bG()) {
            this.aL.hideSoftInputFromWindow(this.T.getWindowToken(), 0);
            final ViewTreeObserver viewTreeObserver = this.T.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                final /* synthetic */ ComposeFragment f5375b;

                public void onGlobalLayout() {
                    ComposeFragment.bv(this.f5375b);
                    if (VERSION.SDK_INT < 16) {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    } else {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    }
                }
            });
            return;
        }
        bv(this);
    }

    public static void bv(ComposeFragment composeFragment) {
        Builder a = LocationSendingDialogConfig.a(FullScreenDialogParams.a(composeFragment));
        a.a = ButtonStyle.SEND;
        LocationSendingDialogFragment.a(a.d()).a(composeFragment.s().a(), "LOCATION_SHARE_FRAGMENT_TAG", true);
    }

    public final void aK() {
        this.bm.m5083C();
        final EventSendingDialogFragment a = EventSendingDialogFragment.a(FullScreenDialogParams.a(this), null);
        a.an = new Object(this) {
            final /* synthetic */ ComposeFragment f5378b;

            public final void m4756a() {
                a.a();
            }

            public final void m4757a(EventMessageParams eventMessageParams) {
                a.a();
                this.f5378b.m4866a(this.f5378b.aW.a(this.f5378b.br, eventMessageParams.a, eventMessageParams.e, eventMessageParams.f, eventMessageParams.b, eventMessageParams.c.getTimeInMillis(), eventMessageParams.d.getTimeInMillis()), MessageSendTrigger.NEW_MESSAGE);
            }
        };
        a.a(s().a(), "EVENT_SEND_FRAGMENT_TAG", true);
    }

    public final void aL() {
        RideOauthHelper rideOauthHelper = (RideOauthHelper) this.aZ.get();
        RideServiceParamsBuilder newBuilder = RideServiceParams.newBuilder();
        newBuilder.a = "composer_icon";
        newBuilder = newBuilder;
        newBuilder.b = this.br;
        rideOauthHelper.a(newBuilder.j(), new Object(this) {
            final /* synthetic */ ComposeFragment f5379a;

            {
                this.f5379a = r1;
            }

            public final void m4758a() {
                this.f5379a.m4890a(ComposeFragment.m4907c(this.f5379a, this.f5379a.jW_().getString(2131230758)));
            }
        });
    }

    public final void aM() {
        this.bm.m5091e();
    }

    public final void aN() {
        this.br = null;
        m4977i(false);
        this.bo.setThreadKey(this.br);
        this.bo.setIsSmsThread(false);
        this.bB = 0;
        this.bE = null;
        this.bo.getEditor().d();
        if (this.bM) {
            this.bm.m5102q();
        }
        aD();
        bc();
        if (this.by != null && this.bo.getEditor().a().length() > 0) {
            this.by.b();
        }
        this.by = null;
    }

    private void bw() {
        if (this.by != null && this.bo.getEditor().a().length() > 0) {
            this.by.b();
        }
    }

    public final void m4975h(int i) {
        this.bB = i;
        bc();
        ClassicAttachmentKeyboard classicAttachmentKeyboard = (ClassicAttachmentKeyboard) this.bm.m5087b("classic");
        if (classicAttachmentKeyboard != null) {
            classicAttachmentKeyboard.m5897a(br(this));
        }
        this.bo.setCreateThreadPickedUsersCount(this.bB);
    }

    public final void m4978j(boolean z) {
        this.bC = z;
        this.bo.setIsSmsThread(z);
        this.bo.mo178b();
    }

    public final void m4963a(boolean z, @Nullable String str) {
        if (z != this.bK) {
            this.bK = z;
            this.bo.setIsFlowerBorderModeActive(z);
            if (!"restored".equals(str) && this.aK.b()) {
                String h;
                FlowerBorderAnalyticsLogger flowerBorderAnalyticsLogger = this.aJ;
                ThreadKey threadKey = this.br;
                boolean z2 = this.bK;
                AnalyticsLogger analyticsLogger = flowerBorderAnalyticsLogger.a;
                HoneyClientEvent honeyClientEvent = new HoneyClientEvent("msgr_flower_border_set_enabled");
                honeyClientEvent.c = "messenger_flower_border";
                HoneyClientEvent honeyClientEvent2 = honeyClientEvent;
                String str2 = "thread_key";
                if (threadKey != null) {
                    h = threadKey.h();
                } else {
                    h = null;
                }
                analyticsLogger.a(honeyClientEvent2.b(str2, h).a("is_enabled", z2).b("source", str));
            }
        }
    }

    private boolean bx() {
        return this.bB > 0 || this.br != null || this.bD;
    }

    public final void m4953a(OnSaveDraftListener onSaveDraftListener) {
        this.bu = onSaveDraftListener;
    }

    private String by() {
        if (!StringUtil.a(this.bE)) {
            return this.bE;
        }
        this.bE = Long.toString(this.aV.a());
        return this.bE;
    }

    public final void aO() {
        this.bv = false;
        this.aq.m4734a(false);
    }

    private void bz() {
        this.bo.setMessageComposerCallback(new Object(this) {
            final /* synthetic */ ComposeFragment f5380a;

            public final void m4762a(MediaResource mediaResource) {
                SampleContentReplyFragment sampleContentReplyFragment = new SampleContentReplyFragment();
                Bundle bundle = new Bundle();
                bundle.putParcelable("media_resource", mediaResource);
                sampleContentReplyFragment.g(bundle);
                sampleContentReplyFragment.a(this.f5380a.s(), "sample_content_reply_fragment");
            }

            {
                this.f5380a = r1;
            }

            public final void m4759a() {
                this.f5380a.bm.m5109z();
            }

            public final void m4765b() {
                this.f5380a.bm.m5109z();
            }

            public final void m4767c() {
                this.f5380a.bm.m5097l();
                if (((MessagingEmojiGatingUtil) this.f5380a.aR.get()).d()) {
                    ComposeFragment.bD(this.f5380a);
                }
            }

            public final void m4768d() {
                this.f5380a.bm.m5099n();
            }

            public final void m4769e() {
                ComposeFragment.bq(this.f5380a);
            }

            public final void m4770f() {
                this.f5380a.m4864a(PickMediaSource.CAMERA);
            }

            public final void m4771g() {
                this.f5380a.m4864a(PickMediaSource.GALLERY);
            }

            public final void m4772h() {
                this.f5380a.bm.m5101p();
            }

            public final void m4773i() {
                this.f5380a.bm.m5103r();
            }

            public final void m4774j() {
                this.f5380a.bm.m5088c();
            }

            public final void m4775k() {
                QuickCamKeyboard h = this.f5380a.bm.m5093h();
                if (h != null) {
                    QuickCamKeyboardView quickCamKeyboardView = (QuickCamKeyboardView) h.a;
                    quickCamKeyboardView.au = true;
                    quickCamKeyboardView.b();
                }
            }

            public final void m4776l() {
                MediaTrayKeyboard mediaTrayKeyboard = (MediaTrayKeyboard) this.f5380a.bm.m5084a("gallery");
                if (mediaTrayKeyboard != null) {
                    ((MediaTrayKeyboardView) mediaTrayKeyboard.a).m3099i();
                } else {
                    this.f5380a.bm.m5095j();
                }
            }

            public final void m4777m() {
                this.f5380a.bm.m5094i();
            }

            public final void m4778n() {
                this.f5380a.bm.m5090d();
            }

            public final void m4760a(ComposerShortcutItem composerShortcutItem) {
                this.f5380a.m4863a(composerShortcutItem);
            }

            public final void m4779o() {
                if (this.f5380a.E != null && !ComposeFragment.bn(this.f5380a)) {
                    this.f5380a.m4960a("", PaymentFlowType.SEND, null);
                }
            }

            public final void m4780p() {
                if (!this.f5380a.aB() || ComposeFragment.bg(this.f5380a)) {
                    ComposeFragment.bh(this.f5380a);
                }
            }

            public final void m4781q() {
                this.f5380a.bl.a(ZeroFeatureKey.LOCATION_SERVICES_INTERSTITIAL, this.f5380a.D);
            }

            public final void m4782r() {
                this.f5380a.aL();
            }

            public final void m4783s() {
                this.f5380a.aM();
            }

            public final void m4761a(Sticker sticker) {
                this.f5380a.m4959a(sticker.a, MessageSendTrigger.COMPOSER_CONTENT_SEARCH);
                StickerKeyboard stickerKeyboard = (StickerKeyboard) this.f5380a.bm.m5087b("stickers");
                if (stickerKeyboard != null) {
                    ((StickerKeyboardView) stickerKeyboard.a).a(sticker);
                }
            }

            public final void m4766b(MediaResource mediaResource) {
                this.f5380a.m4904b(mediaResource, MessageSendTrigger.COMPOSER_CONTENT_SEARCH);
            }

            public final boolean m4764a(View view, MotionEvent motionEvent) {
                if (this.f5380a.bC) {
                    return this.f5380a.bN;
                }
                if (this.f5380a.bt == null || this.f5380a.bN) {
                    return false;
                }
                return this.f5380a.bt.mo148a(view, motionEvent);
            }

            public final void m4784t() {
                if (!this.f5380a.bN) {
                    if (this.f5380a.bC) {
                        ComposeFragment.bj(this.f5380a);
                    } else {
                        BLog.a(ComposeFragment.f5394a, "Trying to send emoji-like on a thread that supports hotlikes.");
                    }
                }
            }

            public final void m4785u() {
                this.f5380a.aK();
            }

            public final void m4763a(boolean z, String str) {
                this.f5380a.m4963a(z, str);
            }

            public final void m4786v() {
                int i;
                ThreadSummary bo = ComposeFragment.bo(this.f5380a);
                if (bo != null && bo.H == 0) {
                    ((ModifyThreadEphemeralityHelper) this.f5380a.aF.get()).a(bo);
                }
                ComposerKeyboardManager composerKeyboardManager = this.f5380a.bm;
                ComposerKeyboardManager.m5077d(composerKeyboardManager, "ephemeral");
                AbstractComposerKeyboard abstractComposerKeyboard = (EphemeralKeyboard) composerKeyboardManager.m5084a("ephemeral");
                if (bo.h()) {
                    i = bo.H;
                } else {
                    i = -1;
                }
                EphemeralKeyboardView ephemeralKeyboardView = (EphemeralKeyboardView) abstractComposerKeyboard.a;
                int i2 = 0;
                while (i2 < EphemeralKeyboardView.f4846a.length) {
                    if (((long) EphemeralKeyboardView.f4846a[i2]) * 1000 == ((long) i)) {
                        break;
                    }
                    i2++;
                }
                i2 = 6;
                ephemeralKeyboardView.f4848c.setValue(i2);
                EphemeralKeyboardView.m4388c(ephemeralKeyboardView, i2);
                if (ephemeralKeyboardView.f4849d != null) {
                    ephemeralKeyboardView.f4849d.m5034a((int) (((long) EphemeralKeyboardView.f4846a[i2]) * 1000));
                }
            }

            public final void m4787w() {
                ComposeFragment.bA(this.f5380a);
            }

            public final void m4788x() {
                if (this.f5380a.bt != null) {
                    this.f5380a.bt.mo149b();
                }
            }

            public final boolean m4789y() {
                ComposerKeyboardManager composerKeyboardManager = this.f5380a.bm;
                boolean z = composerKeyboardManager.f5492v != null && composerKeyboardManager.f5492v.isShown() && composerKeyboardManager.f5492v.getMeasuredHeight() > 0;
                return z;
            }

            public final void m4790z() {
                if (((MessagingEmojiGatingUtil) this.f5380a.aR.get()).d()) {
                    ComposeFragment.bD(this.f5380a);
                }
            }
        });
        this.bo.getEditor().a(new TextWatcher(this) {
            final /* synthetic */ ComposeFragment f5381a;

            {
                this.f5381a = r1;
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.f5381a.aS.e("compose_fragment");
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ComposeFragment.bd(this.f5381a);
                Object obj = (charSequence.length() == 0 && i == 0 && i2 == 0 && i3 == 0) ? null : 1;
                if (obj != null && this.f5381a.by != null) {
                    if (this.f5381a.bo.getEditor().a().length() == 0) {
                        this.f5381a.by.b();
                    } else {
                        this.f5381a.by.a();
                    }
                }
            }

            public void afterTextChanged(Editable editable) {
                this.f5381a.aS.d();
            }
        });
    }

    public static void bA(ComposeFragment composeFragment) {
        if (!composeFragment.bM) {
            if (composeFragment.bq) {
                if (composeFragment.bd.f) {
                    bB(composeFragment);
                } else {
                    composeFragment.bC();
                }
                composeFragment.bt.mo149b();
                return;
            }
            bB(composeFragment);
        }
    }

    public static void bB(ComposeFragment composeFragment) {
        ((View) composeFragment.bo).setVisibility(0);
        composeFragment.bp.e();
    }

    private void bC() {
        ((View) this.bo).setVisibility(8);
        this.bp.f();
        this.bp.b().invalidate();
    }

    public static void bD(ComposeFragment composeFragment) {
        new MessengerEmojiColorNuxFragment().a(composeFragment.s(), "emoji_color_nux");
    }

    private void bE() {
        Fragment a = s().a("emoji_color_nux");
        if (a != null) {
            ((MessengerEmojiColorNuxFragment) a).b();
        }
    }

    private boolean bF() {
        return this.br == null;
    }

    private boolean bG() {
        return ((Service) ContextUtils.a(getContext(), Service.class)) != null;
    }

    private void m4894a(List<MediaResource> list, MediaResource mediaResource) {
        int i = 0;
        if (!((Boolean) this.al.get()).booleanValue()) {
            return;
        }
        if (mediaResource.d == Type.VIDEO) {
            Intent intent = new Intent(this.bn, ThreadViewVideoActivity.class);
            intent.putExtra("video_attachment", this.ap.a(mediaResource));
            intent.putExtra("player_origin", PlayerOrigin.MESSENGER_THREAD.toString());
            intent.putExtra("thread_key", this.br);
            this.ba.a(intent, this.bn);
        } else if (mediaResource.d == Type.PHOTO) {
            ImmutableList.Builder builder = new ImmutableList.Builder();
            int i2 = 0;
            while (i < list.size()) {
                MediaResource mediaResource2 = (MediaResource) list.get(i);
                if (mediaResource2.d == Type.PHOTO) {
                    if (mediaResource2.c.equals(mediaResource.c)) {
                        i2 = i;
                    }
                    ImageAttachmentDataBuilder imageAttachmentDataBuilder = new ImageAttachmentDataBuilder();
                    imageAttachmentDataBuilder.a = ImageAttachmentUris.a(mediaResource2.c);
                    imageAttachmentDataBuilder = imageAttachmentDataBuilder;
                    imageAttachmentDataBuilder.c = mediaResource2.j;
                    imageAttachmentDataBuilder = imageAttachmentDataBuilder;
                    imageAttachmentDataBuilder.d = mediaResource2.k;
                    builder.c(new DefaultPhotoMessageItem(imageAttachmentDataBuilder.i(), null));
                }
                i++;
            }
            PhotoViewFragmentBuilder aq = PhotoViewFragment.aq();
            aq.f3635a.putInt("selection_index", i2);
            aq = aq;
            aq.f3635a.putParcelableArrayList("media_list", Lists.a(builder.b()));
            aq = aq;
            aq.f3635a.putSerializable("photo_view_fragment_mode", PhotoViewMode.BACKED_BY_SHARED_IMAGE_LIST);
            aq.m3437a().a(kO_(), "photo_view_fragment_tag");
        }
    }

    private void bH() {
        this.av.f5421p = this;
        this.av.f5419n = new Listener(this) {
            final /* synthetic */ ComposeFragment f5382a;

            {
                this.f5382a = r1;
            }

            public final void mo145a(OrionMessengerPayParams orionMessengerPayParams) {
                this.f5382a.m4860a((Parcelable) orionMessengerPayParams);
            }

            public final void mo144a(Message message) {
                this.f5382a.m4866a(message, MessageSendTrigger.COMPOSER_PAYMENT_TAB);
            }
        };
    }

    private boolean bI() {
        return this.bm.m5089c("emoji") || this.bm.m5089c("classic");
    }

    public final void m4955a(OnSendListener onSendListener) {
        if (this.bR == null) {
            this.bR = new ComposeObserver();
        }
        this.bR.f5424a = onSendListener;
    }
}
