package com.facebook.orca.compose;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Service;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.support.v7.internal.widget.ViewStubCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.bugreporter.BugReportCategory;
import com.facebook.bugreporter.BugReportOperationLogger;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.appchoreographer.AppChoreographer;
import com.facebook.common.appchoreographer.AppChoreographer.Priority;
import com.facebook.common.appchoreographer.AppChoreographer.ThreadType;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.ui.keyboard.SoftInputDetector;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.MathUtil;
import com.facebook.common.util.TriState;
import com.facebook.config.application.Product;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.listeners.GatekeeperListenersImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperListeners;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.gk.store.OnGatekeeperChangeListener;
import com.facebook.gk.store.internal.GatekeeperListenersImpl;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.iorg.common.upsell.ui.FbZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController.Listener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.analytics.perf.MessagingPerformanceLogger;
import com.facebook.messaging.bots.Boolean_IsBotCommandSearchEnabledGatekeeperAutoProvider;
import com.facebook.messaging.bots.IsBotCommandSearchEnabled;
import com.facebook.messaging.bots.service.BotCommandsGraphQLFetcher;
import com.facebook.messaging.business.commerce.gating.IsMessengerCommerceEnabled;
import com.facebook.messaging.business.common.abtest.ExperimentsForBusinessAbtestModule;
import com.facebook.messaging.business.ride.enums.RideServiceComposerIconMode;
import com.facebook.messaging.business.ride.gating.IsRideServiceComposerEnabled;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.cache.ThreadParticipantUtils;
import com.facebook.messaging.cache.ThreadRecipientUtil;
import com.facebook.messaging.composer.edit.MessageComposerEditor;
import com.facebook.messaging.composer.triggers.Boolean_IsContentSearchEnabledGatekeeperAutoProvider;
import com.facebook.messaging.composer.triggers.ContentSearchController;
import com.facebook.messaging.composer.triggers.ContentSearchControllerProvider;
import com.facebook.messaging.composer.triggers.ContentSearchResultsView;
import com.facebook.messaging.composer.triggers.ContentSearchType;
import com.facebook.messaging.composer.triggers.MediaPreviewDialogManager_ForMediaResourcePreviewMethodAutoProvider;
import com.facebook.messaging.composer.triggers.MentionsSearchController;
import com.facebook.messaging.composer.triggers.MentionsSearchControllerProvider;
import com.facebook.messaging.composer.triggers.OpenCloseAnimator;
import com.facebook.messaging.composer.triggers.analytics.ContentSearchLogger;
import com.facebook.messaging.composer.triggers.annotations.IsContentSearchEnabled;
import com.facebook.messaging.composershortcuts.ComposerButton;
import com.facebook.messaging.composershortcuts.ComposerButton.ComposerButtonStateObserver;
import com.facebook.messaging.composershortcuts.ComposerShortcutItem;
import com.facebook.messaging.composershortcuts.ComposerShortcutsContainer;
import com.facebook.messaging.composershortcuts.ComposerShortcutsContainer.ComposerShortcutState;
import com.facebook.messaging.composershortcuts.ComposerShortcutsContainerLogic;
import com.facebook.messaging.composershortcuts.ComposerShortcutsFilter;
import com.facebook.messaging.composershortcuts.ComposerShortcutsGatekeepers;
import com.facebook.messaging.ephemeral.ModifyThreadEphemeralityDialog;
import com.facebook.messaging.ephemeral.gating.EphemeralGatingUtil;
import com.facebook.messaging.media.externalmedia.ExternalMediaGraphQLFetcher;
import com.facebook.messaging.media.mediapicker.DynamicMediaPickerPreference;
import com.facebook.messaging.media.mediapicker.ExperimentsForMediaPickerModule;
import com.facebook.messaging.media.mediapicker.MediaPickerPrefKeys;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.modifiers.flowerborder.FlowerBorderFeature;
import com.facebook.messaging.modifiers.flowerborder.FlowerBorderPrefKeys;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.messaging.quickcam.annotations.IsQuickCamKeyboardEnabled;
import com.facebook.messaging.quickpromotion.QuickPromotionBannerView.ComposerPointerLocation;
import com.facebook.messaging.sms.abtest.SmsGatekeepers;
import com.facebook.messaging.sms.analytics.SmsCallerContext;
import com.facebook.messaging.sms.defaultapp.SmsDefaultAppManager;
import com.facebook.messaging.sounds.MessengerSoundUtil;
import com.facebook.messaging.tincan.gatekeepers.TincanGatekeepers;
import com.facebook.orca.compose.ComposeFragment.AnonymousClass32;
import com.facebook.orca.compose.annotations.IsHotLikeNuxAllowed;
import com.facebook.orca.compose.annotations.IsMediaTrayEnabled;
import com.facebook.orca.compose.annotations.IsOptimisticInflationEnabled;
import com.facebook.orca.compose.annotations.IsVoiceClipEnabled;
import com.facebook.prefs.counters.UiCounters;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.springs.SpringSystem;
import com.facebook.stickers.abtest.StickerContentSearchExperimentAccessor;
import com.facebook.stickers.model.Sticker;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.facebook.user.model.User.CommercePageType;
import com.facebook.user.model.UserKey;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.OverlayLayout;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.ViewStubHolder.OnInflateListener;
import com.facebook.zero.capping.IsMessageCapEligibleGK;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: openTextComposer */
public class TwoLineComposerView extends CustomLinearLayout implements MessageComposer {
    private static final int[] f5628a = new int[2];
    @Inject
    public DefaultAppChoreographer f5629A;
    @IsOptimisticInflationEnabled
    @Inject
    public Provider<Boolean> f5630B;
    @Inject
    private DynamicMediaPickerPreference f5631C;
    @Inject
    public SmsDefaultAppManager f5632D;
    @Inject
    private SmsGatekeepers f5633E;
    @Inject
    private ComposerShortcutsGatekeepers f5634F;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<EphemeralGatingUtil> f5635G = UltralightRuntime.b;
    @Inject
    private UserCache f5636H;
    @Inject
    public DefaultAndroidThreadUtil f5637I;
    @Inject
    public StickerContentSearchExperimentAccessor f5638J;
    @Inject
    private FlowerBorderFeature f5639K;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<TincanGatekeepers> f5640L = UltralightRuntime.b;
    private ViewGroup f5641M;
    private ViewGroup f5642N;
    public TextLineComposer f5643O;
    private ComposerShortcutsContainer f5644P;
    private View f5645Q;
    public ComposerShortcutsContainerLogic f5646R;
    private OverlayLayout f5647S;
    public ContentSearchController f5648T;
    private MentionsSearchController f5649U;
    private ViewStubHolder<View> f5650V;
    private ViewStubHolder<ImageButton> f5651W;
    private NuxBubbleController aa;
    public AnonymousClass32 ab;
    private boolean ac;
    private boolean ad;
    private int ae;
    private TwoLineMode af = TwoLineMode.TEXT_VISIBLE;
    private TwoLineMode ag;
    private TriState ah = TriState.UNSET;
    public String ai;
    private boolean aj;
    private int ak;
    private boolean al;
    private ContentSearchParams am;
    private Drawable an;
    private FragmentManager ao;
    public OnGatekeeperChangeListener ap;
    private boolean aq = true;
    public boolean ar = false;
    private final Set<String> as = new HashSet();
    private ThreadKey at;
    private final Runnable au = new C08031(this);
    public final OnClickListener av = new C08042(this);
    public final OnTouchListener aw = new C08053(this);
    public final OnClickListener ax = new C08064(this);
    @Inject
    private MessengerSoundUtil f5652b;
    @Inject
    @IsQuickCamKeyboardEnabled
    private Provider<Boolean> f5653c;
    @Inject
    @IsMediaTrayEnabled
    private Provider<Boolean> f5654d;
    @IsHotLikeNuxAllowed
    @Inject
    private Provider<Boolean> f5655e;
    @IsVoiceClipEnabled
    @Inject
    private Provider<Boolean> f5656f;
    @Inject
    private AnalyticsLogger f5657g;
    @Inject
    public FbSharedPreferences f5658h;
    @Inject
    public UiCounters f5659i;
    @Inject
    private NuxBubbleControllerProvider f5660j;
    @Inject
    private NavigationLogger f5661k;
    @Inject
    private SoftInputDetector f5662l;
    @Inject
    public DataCache f5663m;
    @Inject
    public ThreadRecipientUtil f5664n;
    @Inject
    @IsMessengerCommerceEnabled
    private Provider<Boolean> f5665o;
    @Inject
    private MentionsSearchControllerProvider f5666p;
    @Inject
    private ContentSearchControllerProvider f5667q;
    @IsContentSearchEnabled
    @Inject
    private Boolean f5668r;
    @IsBotCommandSearchEnabled
    @Inject
    private Boolean f5669s;
    @Inject
    private BugReportOperationLogger f5670t;
    @Inject
    private QeAccessor f5671u;
    @IsRideServiceComposerEnabled
    @Inject
    private Provider<Boolean> f5672v;
    @Inject
    private ZeroDialogController f5673w;
    @Inject
    public GatekeeperListenersImpl f5674x;
    @IsMessageCapEligibleGK
    @Inject
    public Provider<Boolean> f5675y;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<MessageCapButtonController> f5676z = UltralightRuntime.b;

    /* compiled from: openTextComposer */
    class C08031 implements Runnable {
        final /* synthetic */ TwoLineComposerView f5617a;

        C08031(TwoLineComposerView twoLineComposerView) {
            this.f5617a = twoLineComposerView;
        }

        public void run() {
            TwoLineComposerView.ac(this.f5617a);
        }
    }

    /* compiled from: openTextComposer */
    class C08042 implements OnClickListener {
        final /* synthetic */ TwoLineComposerView f5618a;

        C08042(TwoLineComposerView twoLineComposerView) {
            this.f5618a = twoLineComposerView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1323381927);
            TwoLineComposerView.m5301h(this.f5618a, "Click on like button");
            if (this.f5618a.ar) {
                this.f5618a.ab.m4784t();
            } else {
                this.f5618a.f5659i.c("orca_composer_hot_like_clicks");
                TwoLineComposerView.aa(this.f5618a);
            }
            LogUtils.a(-2051490879, a);
        }
    }

    /* compiled from: openTextComposer */
    class C08053 implements OnTouchListener {
        final /* synthetic */ TwoLineComposerView f5619a;

        C08053(TwoLineComposerView twoLineComposerView) {
            this.f5619a = twoLineComposerView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            TwoLineComposerView.ae(this.f5619a);
            return this.f5619a.ab.m4764a(view, motionEvent);
        }
    }

    /* compiled from: openTextComposer */
    class C08064 implements OnClickListener {
        final /* synthetic */ TwoLineComposerView f5620a;

        C08064(TwoLineComposerView twoLineComposerView) {
            this.f5620a = twoLineComposerView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1021869392);
            TwoLineComposerView.m5301h(this.f5620a, "Click on send button");
            this.f5620a.ab.m4780p();
            this.f5620a.f5659i.c("orca_composer_texts_sent_since_video_feature");
            Logger.a(2, EntryType.UI_INPUT_END, -1216509486, a);
        }
    }

    /* compiled from: openTextComposer */
    class C08085 implements OnInflateListener<ImageButton> {
        final /* synthetic */ TwoLineComposerView f5622a;

        /* compiled from: openTextComposer */
        class C08071 implements OnClickListener {
            final /* synthetic */ C08085 f5621a;

            C08071(C08085 c08085) {
                this.f5621a = c08085;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1643342855);
                this.f5621a.f5622a.f5646R;
                Logger.a(2, EntryType.UI_INPUT_END, 1110037397, a);
            }
        }

        C08085(TwoLineComposerView twoLineComposerView) {
            this.f5622a = twoLineComposerView;
        }

        public final void m5207a(View view) {
            ((ImageButton) view).setOnClickListener(new C08071(this));
        }
    }

    /* compiled from: openTextComposer */
    class C08096 extends Listener {
        final /* synthetic */ TwoLineComposerView f5623a;

        C08096(TwoLineComposerView twoLineComposerView) {
            this.f5623a = twoLineComposerView;
        }

        final boolean mo171a(String str, View view, MotionEvent motionEvent) {
            boolean z = true;
            switch (str.hashCode()) {
                case 3321751:
                    if (str.equals("like")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    return this.f5623a.aw.onTouch(view, motionEvent);
                default:
                    return false;
            }
        }

        final void mo172b(String str, View view) {
            Object obj = -1;
            switch (str.hashCode()) {
                case -872787046:
                    if (str.equals("message_cap")) {
                        obj = 6;
                        break;
                    }
                    break;
                case -231258536:
                    if (str.equals("content_search_back")) {
                        obj = 4;
                        break;
                    }
                    break;
                case 3321751:
                    if (str.equals("like")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 3526536:
                    if (str.equals("send")) {
                        obj = 3;
                        break;
                    }
                    break;
                case 96632902:
                    if (str.equals("emoji")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 529642498:
                    if (str.equals("overflow")) {
                        obj = null;
                        break;
                    }
                    break;
                case 563386781:
                    if (str.equals("ephemeral")) {
                        obj = 7;
                        break;
                    }
                    break;
                case 1422172924:
                    if (str.equals("content_search_clear")) {
                        obj = 5;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    this.f5623a.m5313p();
                    return;
                case 1:
                    this.f5623a.f5643O;
                    return;
                case 2:
                    this.f5623a.av.onClick(view);
                    return;
                case 3:
                    this.f5623a.ax.onClick(view);
                    return;
                case 4:
                    this.f5623a.m5319s();
                    return;
                case 5:
                    this.f5623a.ai;
                    return;
                case 6:
                    ((MessageCapButtonController) this.f5623a.f5676z.get()).m5126e();
                    return;
                case 7:
                    this.f5623a.m5242N();
                    return;
                default:
                    return;
            }
        }

        final void mo168a(String str, View view) {
            Object obj = -1;
            switch (str.hashCode()) {
                case -872787046:
                    if (str.equals("message_cap")) {
                        obj = 3;
                        break;
                    }
                    break;
                case 3321751:
                    if (str.equals("like")) {
                        obj = null;
                        break;
                    }
                    break;
                case 3526536:
                    if (str.equals("send")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 96632902:
                    if (str.equals("emoji")) {
                        obj = 2;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    this.f5623a.f5643O.m5181a("like", this.f5623a.m5343c("like"));
                    this.f5623a.f5643O.m5186b("like", TwoLineComposerView.m5297f(this.f5623a, "like"));
                    return;
                case 1:
                    this.f5623a.f5643O.m5181a("send", this.f5623a.m5343c("send"));
                    this.f5623a.f5643O.m5186b("send", TwoLineComposerView.m5297f(this.f5623a, "send"));
                    return;
                case 2:
                    this.f5623a.f5643O.m5181a("emoji", this.f5623a.m5343c("emoji"));
                    this.f5623a.f5643O.m5186b("emoji", TwoLineComposerView.m5297f(this.f5623a, "emoji"));
                    return;
                case 3:
                    this.f5623a.f5643O.m5181a("message_cap", this.f5623a.m5343c("message_cap"));
                    this.f5623a.f5643O.m5186b("message_cap", TwoLineComposerView.m5297f(this.f5623a, "message_cap"));
                    ((MessageCapButtonController) this.f5623a.f5676z.get()).m5124a(view, this.f5623a.f5643O, this.f5623a.f5646R);
                    return;
                default:
                    return;
            }
        }

        final boolean mo170a() {
            this.f5623a.m5244O();
            this.f5623a.ab.m4765b();
            return false;
        }

        final void mo169a(boolean z) {
            if (z && !this.f5623a.mo191i()) {
                this.f5623a.mo180c();
                this.f5623a.ab.m4759a();
            }
        }
    }

    /* compiled from: openTextComposer */
    class C08107 implements TextWatcher {
        final /* synthetic */ TwoLineComposerView f5624a;

        C08107(TwoLineComposerView twoLineComposerView) {
            this.f5624a = twoLineComposerView;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            TwoLineComposerView.ae(this.f5624a);
            MessageComposerEditor messageComposerEditor = this.f5624a.f5643O.f5591l;
            if (this.f5624a.ai == null && messageComposerEditor.a().length() > 0) {
                this.f5624a.mo180c();
            }
            if (i3 > 0 && messageComposerEditor.a(i, i3)) {
                this.f5624a.ab.m4790z();
            }
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: openTextComposer */
    class C08128 extends OnGatekeeperChangeListener {
        final /* synthetic */ TwoLineComposerView f5626a;

        /* compiled from: openTextComposer */
        class C08111 implements Runnable {
            final /* synthetic */ C08128 f5625a;

            C08111(C08128 c08128) {
                this.f5625a = c08128;
            }

            public void run() {
                this.f5625a.f5626a.m5309n();
            }
        }

        C08128(TwoLineComposerView twoLineComposerView) {
            this.f5626a = twoLineComposerView;
        }

        public final void m5213a(GatekeeperStoreImpl gatekeeperStoreImpl, int i) {
            if (((Boolean) this.f5626a.f5675y.get()).booleanValue()) {
                this.f5626a.f5674x.b(this.f5626a.ap, 899);
                this.f5626a.ap = null;
                this.f5626a.f5637I.a(new C08111(this));
            }
        }
    }

    /* compiled from: openTextComposer */
    class C08139 implements Listener {
        final /* synthetic */ TwoLineComposerView f5627a;

        C08139(TwoLineComposerView twoLineComposerView) {
            this.f5627a = twoLineComposerView;
        }

        public final void m5215a(Object obj) {
            ContentSearchParams contentSearchParams = (ContentSearchParams) obj;
            if (this.f5627a.f5648T != null) {
                TwoLineComposerView.setShowShortcutsContainer(this.f5627a, false);
                this.f5627a.f5674x;
                this.f5627a.f5643O.m5180a();
                this.f5627a.m5272a(contentSearchParams);
            }
        }

        public final void m5214a() {
        }
    }

    /* compiled from: openTextComposer */
    enum TwoLineMode {
        TEXT_VISIBLE,
        TEXT_ACTIVE,
        EMOJI_KEYBOARD_ACTIVE,
        OTHER_CUSTOM_KEYBOARD_OPEN,
        MORE_MODE_IN_ADAPTIVE
    }

    private static <T extends View> void m5280a(Class<T> cls, T t) {
        m5281a((Object) t, t.getContext());
    }

    private static void m5281a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((TwoLineComposerView) obj).m5271a(MessengerSoundUtil.a(fbInjector), IdBasedProvider.a(fbInjector, 4197), IdBasedProvider.a(fbInjector, 4233), IdBasedProvider.a(fbInjector, 4232), IdBasedProvider.a(fbInjector, 4235), AnalyticsLoggerMethodAutoProvider.a(fbInjector), (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), UiCounters.a(fbInjector), (NuxBubbleControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(NuxBubbleControllerProvider.class), NavigationLogger.a(fbInjector), SoftInputDetector.a(fbInjector), DataCache.a(fbInjector), ThreadRecipientUtil.a(fbInjector), IdBasedProvider.a(fbInjector, 4113), (MentionsSearchControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(MentionsSearchControllerProvider.class), (ContentSearchControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ContentSearchControllerProvider.class), Boolean_IsContentSearchEnabledGatekeeperAutoProvider.a(fbInjector), Boolean_IsBotCommandSearchEnabledGatekeeperAutoProvider.a(fbInjector), BugReportOperationLogger.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), IdBasedProvider.a(fbInjector, 4121), (ZeroDialogController) FbZeroDialogController.a(fbInjector), GatekeeperListenersImplMethodAutoProvider.a(fbInjector), IdBasedProvider.a(fbInjector, 4390), IdBasedLazy.a(fbInjector, 8781), DefaultAppChoreographer.a(fbInjector), IdBasedProvider.a(fbInjector, 4234), DynamicMediaPickerPreference.a(fbInjector), SmsDefaultAppManager.a(fbInjector), SmsGatekeepers.a(fbInjector), ComposerShortcutsGatekeepers.a(fbInjector), IdBasedLazy.a(fbInjector, 2618), UserCache.a(fbInjector), DefaultAndroidThreadUtil.a(fbInjector), StickerContentSearchExperimentAccessor.a(fbInjector), FlowerBorderFeature.a(fbInjector), IdBasedLazy.a(fbInjector, 2726));
    }

    public TwoLineComposerView(Context context) {
        super(context);
        m5266a();
    }

    public TwoLineComposerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5266a();
    }

    public TwoLineComposerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5266a();
    }

    private void m5266a() {
        m5280a(TwoLineComposerView.class, (View) this);
        setOrientation(1);
        setContentView(2130905904);
        m5334z();
        setWillNotDraw(false);
        this.f5641M = (ViewGroup) a(2131565260);
        this.f5643O = (TextLineComposer) a(2131565261);
        this.f5642N = (ViewGroup) a(2131565255);
        this.f5650V = ViewStubHolder.a((ViewStubCompat) a(2131565252));
        this.f5651W = ViewStubHolder.a((ViewStubCompat) a(2131565259));
        this.f5651W.c = new C08085(this);
        this.f5643O.f5593n = new C08096(this);
        this.f5643O.f5591l.a(new C08107(this));
        m5306l();
        m5307m();
        this.an = getResources().getDrawable(2130842359);
        this.an.setCallback(this);
        this.al = this.f5634F.a();
        this.f5676z;
        if (((Boolean) this.f5675y.get()).booleanValue()) {
            m5309n();
        } else {
            this.ap = new C08128(this);
            this.f5674x.a(this.ap, 899);
        }
        this.f5673w.a(ZeroFeatureKey.IMAGE_SEARCH_INTERSTITIAL, getContext().getString(2131232937), new C08139(this));
    }

    private void m5306l() {
        if (this.f5668r.booleanValue()) {
            ViewStubCompat viewStubCompat = (ViewStubCompat) findViewById(2131565256);
            ContentSearchControllerProvider contentSearchControllerProvider = this.f5667q;
            this.f5648T = new ContentSearchController(ResourcesMethodAutoProvider.a(contentSearchControllerProvider), ExternalMediaGraphQLFetcher.b(contentSearchControllerProvider), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(contentSearchControllerProvider), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(contentSearchControllerProvider), viewStubCompat, getEditor(), GatekeeperStoreImplMethodAutoProvider.a(contentSearchControllerProvider), MediaPreviewDialogManager_ForMediaResourcePreviewMethodAutoProvider.b(contentSearchControllerProvider), ContentSearchLogger.a(contentSearchControllerProvider), MessagingPerformanceLogger.a(contentSearchControllerProvider), StickerContentSearchExperimentAccessor.b(contentSearchControllerProvider));
            this.f5648T.t = new Object(this) {
                final /* synthetic */ TwoLineComposerView f5601a;

                {
                    this.f5601a = r1;
                }

                public final void m5193a(boolean z) {
                    if (TwoLineComposerView.m5299g(this.f5601a, "contentsearch")) {
                        this.f5601a.f5643O.setEnableComposerContentSearchLoadingProgress(z);
                    }
                }

                public final void m5191a(Sticker sticker, String str, int i) {
                    this.f5601a.ab.m4761a(sticker);
                    this.f5601a.m5282a("sticker", str, i);
                    if (this.f5601a.f5638J.c()) {
                        this.f5601a.mo177a(true, "media_sent");
                    }
                }

                public final void m5192a(MediaResource mediaResource, String str, int i) {
                    this.f5601a.ab.m4766b(mediaResource);
                    this.f5601a.mo177a(true, "media_sent");
                    this.f5601a.m5282a("media_resource", str, i);
                }
            };
        }
    }

    private void m5307m() {
        if (this.f5669s.booleanValue()) {
            ViewStubCompat viewStubCompat = (ViewStubCompat) findViewById(2131565253);
            MentionsSearchControllerProvider mentionsSearchControllerProvider = this.f5666p;
            this.f5649U = new MentionsSearchController(DefaultAndroidThreadUtil.b(mentionsSearchControllerProvider), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(mentionsSearchControllerProvider), ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(mentionsSearchControllerProvider), viewStubCompat, getEditor(), SpringSystem.b(mentionsSearchControllerProvider), new BotCommandsGraphQLFetcher(GraphQLQueryExecutor.a(mentionsSearchControllerProvider)), ThreadParticipantUtils.a(mentionsSearchControllerProvider), MessagingPerformanceLogger.a(mentionsSearchControllerProvider));
            this.f5649U.q = new Object(this) {
                final /* synthetic */ TwoLineComposerView f5602a;

                {
                    this.f5602a = r1;
                }

                public final void m5195b() {
                    this.f5602a.f5676z;
                }

                public final void m5194a() {
                    this.f5602a.f5676z;
                }
            };
            this.f5649U.a(new Object(this) {
                final /* synthetic */ TwoLineComposerView f5603a;

                {
                    this.f5603a = r1;
                }

                public final ImmutableList<User> m5196a(@Nullable ThreadKey threadKey) {
                    if (threadKey == null) {
                        return RegularImmutableList.a;
                    }
                    return this.f5603a.f5664n.c(this.f5603a.f5663m.a(threadKey));
                }
            });
            this.f5649U.a(true);
        }
    }

    private void m5309n() {
        this.f5646R.b("message_cap", true);
        this.f5646R.c("message_cap", true);
        this.f5643O.m5181a("message_cap", true);
        this.f5643O.m5186b("message_cap", true);
    }

    public static void m5312o(TwoLineComposerView twoLineComposerView) {
        boolean z = false;
        boolean c = twoLineComposerView.f5646R.c("contentsearch");
        if (!(twoLineComposerView.m5332y() || ((twoLineComposerView.af != TwoLineMode.TEXT_ACTIVE && twoLineComposerView.af != TwoLineMode.TEXT_VISIBLE && twoLineComposerView.af != TwoLineMode.EMOJI_KEYBOARD_ACTIVE) || twoLineComposerView.al || c))) {
            z = true;
        }
        twoLineComposerView.f5643O.m5181a("emoji", z);
    }

    public void setLikeIconIdOverride(int i) {
        this.f5644P.setLikeIconIdOverride(i);
        this.f5643O.setLikeIconIdOverride(i);
    }

    public void setComposerButtonActiveColorFilterOverride(int i) {
        ComposerShortcutsContainerLogic composerShortcutsContainerLogic = this.f5646R;
        composerShortcutsContainerLogic.x = i;
        for (String str : composerShortcutsContainerLogic.l.keySet()) {
            ((ComposerButton) composerShortcutsContainerLogic.l.get(str)).setSelectedColorFilterColorOverride(composerShortcutsContainerLogic.x);
        }
        for (String str2 : composerShortcutsContainerLogic.k.keySet()) {
            ((ComposerButton) composerShortcutsContainerLogic.k.get(str2)).setSelectedColorFilterColorOverride(composerShortcutsContainerLogic.x);
        }
        this.f5643O.setComposerButtonActiveColorFilterOverride(i);
    }

    private void m5313p() {
        m5301h(this, "Click on Overflow Button");
        m5273a(TwoLineMode.MORE_MODE_IN_ADAPTIVE, "onOverflowButtonClicked");
    }

    public static void m5316q(TwoLineComposerView twoLineComposerView) {
        m5301h(twoLineComposerView, "Click on Emoji Button");
        if (twoLineComposerView.f5643O.m5189d("emoji")) {
            twoLineComposerView.f5643O.m5188c("emoji", false);
            twoLineComposerView.mo180c();
            return;
        }
        twoLineComposerView.ab.m4767c();
        twoLineComposerView.f5652b.j();
        twoLineComposerView.m5293d("emoji");
    }

    public static void m5318r(TwoLineComposerView twoLineComposerView) {
        twoLineComposerView.ab.m4763a(!((ImageButton) twoLineComposerView.f5651W.a()).isSelected(), "composer_button");
    }

    private void m5319s() {
        mo177a(true, "back_pressed");
        mo180c();
    }

    public static void m5322t(TwoLineComposerView twoLineComposerView) {
        twoLineComposerView.f5643O.f5591l.d();
    }

    public static void m5324u(TwoLineComposerView twoLineComposerView) {
        if (!twoLineComposerView.mo191i()) {
            m5301h(twoLineComposerView, "Click on Content Search Button");
            twoLineComposerView.mo175a(ContentSearchType.ANIMATION, null, true, "search_pressed");
        }
    }

    public final void mo177a(boolean z, @Nullable String str) {
        if (this.f5648T != null) {
            m5287b(z, str);
            m5326v();
        }
    }

    private void m5326v() {
        if (this.f5646R.c("contentsearch")) {
            this.f5643O.m5184b();
            this.f5646R.a("contentsearch", false);
        }
        setShowShortcutsContainer(this, true);
    }

    private void m5287b(boolean z, String str) {
        m5286b(((ContentSearchResultsView) this.f5648T.e.a()).getMaxVisiblePosition(), str);
        this.f5643O.m5182a(false, null);
        this.f5648T.b(z);
        if (this.f5649U != null) {
            this.f5649U.a(true);
        }
    }

    public final void mo175a(ContentSearchType contentSearchType, String str, boolean z, String str2) {
        this.f5673w.a(ZeroFeatureKey.IMAGE_SEARCH_INTERSTITIAL, this.ao, new ContentSearchParams(contentSearchType, str, z, str2));
    }

    private void m5272a(ContentSearchParams contentSearchParams) {
        this.am = contentSearchParams;
        m5295e(contentSearchParams.f5500d);
        this.f5643O.m5182a(true, contentSearchParams.f5497a);
        this.f5648T.w = contentSearchParams.f5497a;
        ContentSearchController contentSearchController = this.f5648T;
        contentSearchController.i.a(contentSearchParams.f5498b);
        MessageComposerEditor messageComposerEditor = contentSearchController.i;
        messageComposerEditor.a(messageComposerEditor.c.length());
        contentSearchController = this.f5648T;
        boolean z = contentSearchParams.f5499c;
        contentSearchController.v = true;
        if (z) {
            contentSearchController.f.a(true);
        } else {
            OpenCloseAnimator openCloseAnimator = contentSearchController.f;
            if (!(openCloseAnimator.c && openCloseAnimator.d == null)) {
                if (openCloseAnimator.d != null) {
                    openCloseAnimator.d.cancel();
                    openCloseAnimator.d = null;
                }
                openCloseAnimator.a.a().getLayoutParams().height = openCloseAnimator.b;
                openCloseAnimator.a.f();
                openCloseAnimator.c = true;
            }
        }
        ContentSearchController.d(contentSearchController);
        if (this.f5649U != null) {
            this.f5649U.a(false);
        }
        mo180c();
        this.ab.m4759a();
    }

    public static void m5328w(TwoLineComposerView twoLineComposerView) {
        twoLineComposerView.f5646R.a("contentsearch", true);
    }

    public final boolean mo191i() {
        return m5299g(this, "contentsearch");
    }

    public ContentSearchParams getContentSearchParams() {
        return mo191i() ? this.am : null;
    }

    public void setIsSecretMode(boolean z) {
        this.f5643O.setIsSecretMode(z);
    }

    public void setIsEphemeralModeActive(boolean z) {
        m5284a(z);
    }

    private void m5329x() {
        if (this.f5649U != null) {
            MentionsSearchController.c(this.f5649U, false);
        }
    }

    private boolean m5332y() {
        if (this.f5649U != null) {
            if ((this.f5649U.l.i != 0.0d ? 1 : null) != null) {
                return true;
            }
        }
        return false;
    }

    private void m5334z() {
        this.f5644P = (ComposerShortcutsContainer) a(2131565258);
        this.f5645Q = (View) this.f5644P;
        this.f5646R = this.f5644P.getComposerShortcutsContainerLogic();
        this.f5646R.b("voice_clip", ((Boolean) this.f5656f.get()).booleanValue());
        setRideServiceButtonsVisible(RideServiceComposerIconMode.DEFAULT);
        setMQuickReplyButtonVisible(false);
        ag();
        this.f5644P.setListener(new Object(this) {
            final /* synthetic */ TwoLineComposerView f5608a;

            {
                this.f5608a = r1;
            }

            public final void m5197a(final ComposerShortcutItem composerShortcutItem) {
                String str = composerShortcutItem.b;
                if (("camera".equals(str) || "voice_clip".equals(str)) && this.f5608a.f5632D.a(this.f5608a.ar)) {
                    this.f5608a.f5632D.a(SmsCallerContext.SEND_MESSAGE, new Runnable(this) {
                        final /* synthetic */ AnonymousClass13 f5605b;

                        public void run() {
                            this.f5605b.m5197a(composerShortcutItem);
                        }
                    });
                    return;
                }
                if ("text".equals(str)) {
                    this.f5608a.m5216A();
                } else if ("camera".equals(str)) {
                    this.f5608a.m5220C();
                } else if ("gallery".equals(str)) {
                    this.f5608a.f5664n;
                } else if ("payment".equals(str)) {
                    this.f5608a.f5632D;
                } else if ("stickers".equals(str)) {
                    this.f5608a.m5228G();
                } else if ("voice_clip".equals(str)) {
                    this.f5608a.m5230H();
                } else if ("react_sample".equals(str)) {
                    this.f5608a.m5232I();
                } else if ("sendlocation".equals(str)) {
                    this.f5608a.m5234J();
                } else if ("ride_service".equals(str) || "ride_service_promotion".equals(str)) {
                    this.f5608a.m5236K();
                } else if ("quick_reply".equals(str)) {
                    this.f5608a.m5238L();
                } else if ("emoji".equals(str)) {
                    this.f5608a.f5643O;
                } else if ("contentsearch".equals(str)) {
                    this.f5608a.f5675y;
                } else if ("message_cap".equals(str)) {
                    ((MessageCapButtonController) this.f5608a.f5676z.get()).m5126e();
                } else if ("like".equals(str)) {
                    this.f5608a.av.onClick(null);
                } else if ("send".equals(str)) {
                    this.f5608a.ax.onClick(null);
                } else if ("send_event".equals(str)) {
                    this.f5608a.m5240M();
                } else if ("ephemeral".equals(str)) {
                    this.f5608a.m5242N();
                } else {
                    this.f5608a.m5269a(composerShortcutItem);
                }
                if (composerShortcutItem.s != null && ((Boolean) this.f5608a.f5630B.get()).booleanValue()) {
                    final int[] iArr = composerShortcutItem.s;
                    this.f5608a.f5629A.a("Optimistically load row item", new Runnable(this) {
                        final /* synthetic */ AnonymousClass13 f5607b;

                        public void run() {
                            Context context = this.f5607b.f5608a.getContext();
                            int[] iArr = iArr;
                            Preconditions.checkState(ViewStubHolder.g(), "Must be called from GUI thread");
                            for (int i : iArr) {
                                if (i != 0) {
                                    context.getResources().getResourceName(i);
                                    SparseArray sparseArray = (SparseArray) ViewStubHolder.d.get(context);
                                    if (sparseArray == null) {
                                        sparseArray = new SparseArray();
                                        ViewStubHolder.d.put(context, sparseArray);
                                    }
                                    if (sparseArray.get(i) == null) {
                                        View inflate = LayoutInflater.from(context).inflate(i, null);
                                        if (inflate != null) {
                                            sparseArray.put(i, new WeakReference(inflate));
                                        }
                                    }
                                }
                            }
                        }
                    }, Priority.APPLICATION_LOADED_UI_IDLE, ThreadType.UI);
                }
            }

            public final boolean m5199a(ComposerShortcutItem composerShortcutItem, View view, MotionEvent motionEvent) {
                if (!"like".equals(composerShortcutItem.b)) {
                    return false;
                }
                this.f5608a.aw.onTouch(view, motionEvent);
                return true;
            }

            public final void m5200b(ComposerShortcutItem composerShortcutItem) {
                if ("camera".equals(composerShortcutItem.b)) {
                    this.f5608a.f5663m;
                }
            }

            public final void m5198a(MediaResource mediaResource) {
                this.f5608a.ab.m4762a(mediaResource);
            }
        });
        this.f5644P.setComposerButtonStateObserver(new ComposerButtonStateObserver(this) {
            final /* synthetic */ TwoLineComposerView f5609a;

            {
                this.f5609a = r1;
            }

            public final float m5202a(ComposerShortcutItem composerShortcutItem) {
                return AnonymousClass14.m5201c(composerShortcutItem) ? 0.0f : 0.0f;
            }

            public final float m5203b(ComposerShortcutItem composerShortcutItem) {
                if (!AnonymousClass14.m5201c(composerShortcutItem) && TwoLineComposerView.m5262X(this.f5609a)) {
                    return 0.15f;
                }
                return 0.0f;
            }

            private static boolean m5201c(ComposerShortcutItem composerShortcutItem) {
                return Objects.equal("like", composerShortcutItem.b) || Objects.equal("send", composerShortcutItem.b);
            }
        });
    }

    private void m5216A() {
        m5301h(this, "Click on text button");
        if (this.af == TwoLineMode.TEXT_ACTIVE) {
            m5219B();
        }
        mo177a(true, "other_tab_pressed");
        mo180c();
        if (!this.f5662l.f) {
            this.f5661k.b("keyboard_popup", "press_text_button", "open_keyboard", null);
        }
        this.f5652b.j();
    }

    private void m5219B() {
        ThreadSummary a = this.f5663m.a(this.at);
        if (a != null && !ThreadKey.d(this.at)) {
            EphemeralGatingUtil ephemeralGatingUtil = (EphemeralGatingUtil) this.f5635G.get();
            boolean z = false;
            if (!(!ephemeralGatingUtil.a.a(217, false) || ephemeralGatingUtil.a() || ephemeralGatingUtil.b == Product.PAA)) {
                z = true;
            }
            if (z) {
                ModifyThreadEphemeralityDialog.a(a, "text_button").a(this.ao);
            }
        }
    }

    private void m5220C() {
        m5301h(this, "Click on camera button");
        if (((Boolean) this.f5653c.get()).booleanValue()) {
            this.ab.m4775k();
            this.f5652b.j();
        } else {
            this.ab.m4770f();
        }
        if (!m5299g(this, "camera")) {
            m5293d("camera");
        }
    }

    public static void m5223D(TwoLineComposerView twoLineComposerView) {
        if (((Boolean) twoLineComposerView.f5653c.get()).booleanValue() && !m5299g(twoLineComposerView, "camera")) {
            twoLineComposerView.m5293d("camera");
            twoLineComposerView.ab.m4775k();
            twoLineComposerView.f5652b.j();
            twoLineComposerView.m5293d("camera");
        }
    }

    public static void m5225E(TwoLineComposerView twoLineComposerView) {
        m5301h(twoLineComposerView, "Click on gallery button");
        if (((Boolean) twoLineComposerView.f5654d.get()).booleanValue()) {
            DynamicMediaPickerPreference dynamicMediaPickerPreference = twoLineComposerView.f5631C;
            boolean z = false;
            if (dynamicMediaPickerPreference.a.a(Liveness.Cached, ExperimentsForMediaPickerModule.a, false)) {
                long a = dynamicMediaPickerPreference.c.a(MediaPickerPrefKeys.b, 0);
                long a2 = dynamicMediaPickerPreference.c.a(MediaPickerPrefKeys.c, 0);
                if (a == 0 || a2 == 0) {
                    dynamicMediaPickerPreference.e = dynamicMediaPickerPreference.a.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForMediaPickerModule.b, false);
                    z = dynamicMediaPickerPreference.e;
                } else if (a2 < dynamicMediaPickerPreference.b.a()) {
                    dynamicMediaPickerPreference.e = true;
                    z = dynamicMediaPickerPreference.e;
                }
            }
            if (!z) {
                twoLineComposerView.ab.m4776l();
                twoLineComposerView.f5652b.j();
                if (!m5299g(twoLineComposerView, "gallery")) {
                    twoLineComposerView.m5293d("gallery");
                }
            }
        }
        twoLineComposerView.ab.m4771g();
        twoLineComposerView.f5652b.j();
        if (!m5299g(twoLineComposerView, "gallery")) {
            twoLineComposerView.m5293d("gallery");
        }
    }

    public static void m5227F(TwoLineComposerView twoLineComposerView) {
        m5301h(twoLineComposerView, "Click on payment button");
        twoLineComposerView.f5652b.k();
        twoLineComposerView.ab.m4779o();
    }

    private void m5228G() {
        m5301h(this, "Click on sticker button");
        this.ab.m4774j();
        this.f5652b.j();
        if (!m5299g(this, "stickers")) {
            m5293d("stickers");
        }
    }

    private void m5230H() {
        m5301h(this, "Click on VoiceClip button");
        this.ab.m4772h();
        this.f5652b.j();
        if (!m5299g(this, "voice_clip")) {
            m5293d("voice_clip");
        }
    }

    private void m5232I() {
        this.ab.m4773i();
    }

    private void m5234J() {
        m5301h(this, "Click on send location button");
        this.ab.m4781q();
    }

    private void m5236K() {
        this.ab.m4782r();
    }

    private void m5238L() {
        this.ab.m4783s();
    }

    private void m5240M() {
        m5301h(this, "Click on send event button");
        this.ab.m4785u();
    }

    private void m5242N() {
        m5301h(this, "Click on ephemeral button");
        this.ab.m4786v();
    }

    private void m5269a(ComposerShortcutItem composerShortcutItem) {
        this.ab.m4760a(composerShortcutItem);
    }

    public void setMessageComposerCallback(AnonymousClass32 anonymousClass32) {
        this.ab = anonymousClass32;
    }

    public String getUnsentMessageText() {
        return this.f5643O.getUnsentMessageText();
    }

    public MessageComposerEditor getEditor() {
        return this.f5643O.f5591l;
    }

    public final void mo181d() {
        MessageCapButtonController messageCapButtonController = (MessageCapButtonController) this.f5676z.get();
        messageCapButtonController.f5526b.b(messageCapButtonController.f5534j);
        MessageCapButtonController.m5123i(messageCapButtonController);
    }

    public final void mo182e() {
        MessageCapButtonController messageCapButtonController = (MessageCapButtonController) this.f5676z.get();
        messageCapButtonController.f5526b.a(messageCapButtonController.f5534j);
        MessageCapButtonController.m5121g(messageCapButtonController);
    }

    public final void mo183f() {
        ((MessageCapButtonController) this.f5676z.get()).m5125c();
    }

    public final void mo184g() {
        ae(this);
        af();
        Context context = getContext();
        Preconditions.checkState(ViewStubHolder.g(), "Must be called from GUI thread");
        ViewStubHolder.d.remove(context);
        MessageCapButtonController messageCapButtonController = (MessageCapButtonController) this.f5676z.get();
        messageCapButtonController.f5539o = false;
        MessageCapButtonController.m5123i(messageCapButtonController);
    }

    public void setTextLengthLimit(int i) {
    }

    public void setComposeMode(ComposeMode composeMode) {
        if (composeMode == ComposeMode.SHRUNK) {
            ae(this);
        }
    }

    public final void mo178b() {
        boolean z;
        if (this.f5648T == null || !this.f5648T.v) {
            z = true;
        } else {
            z = false;
        }
        setShowShortcutsContainer(this, z);
        if (this.ar) {
            this.f5646R.a(ComposerShortcutsFilter.SMS);
        } else if (ThreadKey.g(this.at)) {
            this.f5646R.a(ComposerShortcutsFilter.TINCAN);
        } else {
            this.f5646R.a(ComposerShortcutsFilter.UNFILTERED);
            if (this.at != null) {
                m5270a(this.at);
            }
        }
        m5255T();
        ag();
    }

    public void setThreadKey(@Nullable ThreadKey threadKey) {
        this.at = threadKey;
        if (this.f5649U != null) {
            this.f5649U.a(threadKey);
        }
        m5255T();
    }

    public void setCreateThreadPickedUsersCount(int i) {
        boolean z = true;
        if (i != 1 || this.ar) {
            z = false;
        }
        setPaymentButtonVisible(z);
    }

    public void setIsSmsThread(boolean z) {
        this.ar = z;
        this.f5643O.setIsSmsThread(z);
        this.f5676z;
        m5255T();
    }

    public final void mo180c() {
        if (this.af == TwoLineMode.MORE_MODE_IN_ADAPTIVE && Objects.equal(this.ai, "emoji")) {
            m5273a(TwoLineMode.EMOJI_KEYBOARD_ACTIVE, "openTextComposerAndMakeActive");
            return;
        }
        this.ab.m4769e();
        m5273a(TwoLineMode.TEXT_ACTIVE, "openTextComposerAndMakeActive");
    }

    private void m5244O() {
        if (this.af == TwoLineMode.EMOJI_KEYBOARD_ACTIVE || this.af == TwoLineMode.TEXT_VISIBLE) {
            mo180c();
        } else if (this.af != TwoLineMode.TEXT_VISIBLE && this.af != TwoLineMode.TEXT_ACTIVE) {
            m5273a(TwoLineMode.TEXT_VISIBLE, "openTextComposer");
        }
    }

    private void m5273a(TwoLineMode twoLineMode, String str) {
        boolean z = true;
        boolean z2 = false;
        ComposerShortcutsContainerLogic composerShortcutsContainerLogic;
        String str2;
        switch (twoLineMode) {
            case TEXT_VISIBLE:
                this.f5646R.a("text", false);
                this.f5643O.m5188c("emoji", false);
                this.f5646R.a("emoji", false);
                break;
            case TEXT_ACTIVE:
                m5256U();
                m5246P();
                this.f5643O.m5188c("emoji", false);
                this.f5646R.a("emoji", false);
                composerShortcutsContainerLogic = this.f5646R;
                str2 = "text";
                if (this.f5646R.c("contentsearch")) {
                    z = false;
                }
                composerShortcutsContainerLogic.a(str2, z);
                ae(this);
                break;
            case EMOJI_KEYBOARD_ACTIVE:
                composerShortcutsContainerLogic = this.f5646R;
                str2 = "text";
                if (!this.al) {
                    z2 = true;
                }
                composerShortcutsContainerLogic.a(str2, z2);
                this.f5646R.a("emoji", true);
                this.f5643O.m5188c("emoji", true);
                ae(this);
                break;
            case OTHER_CUSTOM_KEYBOARD_OPEN:
                this.f5646R.a("text", false);
                this.f5646R.a("payment", false);
                ae(this);
                break;
            case MORE_MODE_IN_ADAPTIVE:
                this.f5646R.a("text", false);
                this.f5646R.a("payment", false);
                ae(this);
                break;
        }
        this.af = twoLineMode;
        this.f5676z;
        requestLayout();
    }

    private void m5246P() {
        MessageComposerEditor messageComposerEditor = this.f5643O.f5591l;
        if (messageComposerEditor.c.hasFocus()) {
            this.ab.m4759a();
        } else {
            this.f5643O.requestFocus();
        }
        if (!this.f5662l.f) {
            messageComposerEditor.b.showSoftInput(messageComposerEditor.c, 0);
        }
    }

    private void m5248Q() {
        if (this.f5647S == null) {
            this.f5647S = (OverlayLayout) ((ViewGroup) getRootView()).findViewById(2131567846);
        }
    }

    public final void mo176a(String str) {
        this.ai = str;
        boolean z = true;
        switch (str.hashCode()) {
            case -1897874326:
                if (str.equals("react_sample")) {
                    z = true;
                    break;
                }
                break;
            case -1515361731:
                if (str.equals("voice_clip")) {
                    z = true;
                    break;
                }
                break;
            case -1367751899:
                if (str.equals("camera")) {
                    z = true;
                    break;
                }
                break;
            case -196315310:
                if (str.equals("gallery")) {
                    z = true;
                    break;
                }
                break;
            case 32613394:
                if (str.equals("ride_service_promotion")) {
                    z = true;
                    break;
                }
                break;
            case 96632902:
                if (str.equals("emoji")) {
                    z = false;
                    break;
                }
                break;
            case 527873560:
                if (str.equals("quick_reply")) {
                    z = true;
                    break;
                }
                break;
            case 563386781:
                if (str.equals("ephemeral")) {
                    z = true;
                    break;
                }
                break;
            case 1531715286:
                if (str.equals("stickers")) {
                    z = true;
                    break;
                }
                break;
            case 1835818606:
                if (str.equals("ride_service")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                m5273a(TwoLineMode.EMOJI_KEYBOARD_ACTIVE, "onComposerPopupOpened");
                return;
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
                this.f5646R.a(str, true);
                m5273a(TwoLineMode.OTHER_CUSTOM_KEYBOARD_OPEN, "onComposerPopupOpened");
                mo177a(true, "other_tab_pressed");
                m5329x();
                return;
            default:
                return;
        }
    }

    public final void mo179b(String str) {
        this.ai = null;
        boolean z = true;
        switch (str.hashCode()) {
            case -1897874326:
                if (str.equals("react_sample")) {
                    z = true;
                    break;
                }
                break;
            case -1515361731:
                if (str.equals("voice_clip")) {
                    z = true;
                    break;
                }
                break;
            case -1367751899:
                if (str.equals("camera")) {
                    z = true;
                    break;
                }
                break;
            case -196315310:
                if (str.equals("gallery")) {
                    z = true;
                    break;
                }
                break;
            case 32613394:
                if (str.equals("ride_service_promotion")) {
                    z = true;
                    break;
                }
                break;
            case 96632902:
                if (str.equals("emoji")) {
                    z = false;
                    break;
                }
                break;
            case 527873560:
                if (str.equals("quick_reply")) {
                    z = true;
                    break;
                }
                break;
            case 1531715286:
                if (str.equals("stickers")) {
                    z = true;
                    break;
                }
                break;
            case 1835818606:
                if (str.equals("ride_service")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                this.f5646R.a("emoji", false);
                if (this.af == TwoLineMode.EMOJI_KEYBOARD_ACTIVE) {
                    m5273a(TwoLineMode.TEXT_VISIBLE, "onComposerPopupClosed");
                    return;
                }
                return;
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
                this.f5646R.a(str, false);
                if (this.af == TwoLineMode.OTHER_CUSTOM_KEYBOARD_OPEN) {
                    m5273a(TwoLineMode.TEXT_VISIBLE, "onComposerPopupClosed");
                }
                m5263Y();
                return;
            default:
                return;
        }
    }

    public void setCanSendStickers(boolean z) {
        if (z && this.ar) {
            z = this.f5633E.a();
        }
        this.f5646R.b("stickers", z);
    }

    public void setIsLikeEnabled(boolean z) {
        m5283a("like", z);
    }

    public void setIsSendEnabled(boolean z) {
        m5283a("send", z);
    }

    public final boolean mo190h() {
        return this.f5650V.c() && ((ImageButton) this.f5651W.a()).isSelected();
    }

    public void setIsFlowerBorderModeActive(boolean z) {
        m5255T();
        if (this.f5651W.c()) {
            ((ImageButton) this.f5651W.a()).setSelected(z);
            this.f5650V.a(z);
        }
    }

    private void m5283a(String str, boolean z) {
        if (m5297f(this, str) != z) {
            this.f5646R.c(str, z);
            if (this.f5643O.m5183a(str)) {
                this.f5643O.m5186b(str, z);
            }
        }
        boolean z2 = this.aq ^ 1;
        this.aq = z2;
        if (z2) {
            m5250R();
        }
    }

    public final boolean mo192j() {
        if (mo191i()) {
            mo177a(true, "back_pressed");
            mo180c();
            return true;
        } else if (!m5332y()) {
            return false;
        } else {
            m5329x();
            return true;
        }
    }

    private void m5250R() {
        boolean f = m5297f(this, "like");
        boolean z = !f;
        this.f5646R.b("like", f);
        this.f5646R.b("send", z);
        if (!this.f5646R.c("contentsearch")) {
            if (f) {
                this.f5643O.m5185b("like");
                this.f5643O.m5187c("send");
                return;
            }
            this.f5643O.m5185b("send");
            this.f5643O.m5187c("like");
        }
    }

    private boolean m5253S() {
        return this.f5645Q.getVisibility() == 0;
    }

    public static void setShowShortcutsContainer(TwoLineComposerView twoLineComposerView, boolean z) {
        twoLineComposerView.f5645Q.setVisibility(z ? 0 : 8);
        twoLineComposerView.m5255T();
    }

    private void m5255T() {
        boolean z;
        ViewStubHolder viewStubHolder = this.f5651W;
        if (!(this.ar || ThreadKey.g(this.at))) {
            FlowerBorderFeature flowerBorderFeature = this.f5639K;
            boolean z2 = true;
            if (!(flowerBorderFeature.a.a(FlowerBorderPrefKeys.a, true) && flowerBorderFeature.b())) {
                z2 = false;
            }
            if (z2 && this.f5645Q.getVisibility() == 0) {
                z = true;
                viewStubHolder.a(z);
            }
        }
        z = false;
        viewStubHolder.a(z);
    }

    public final void mo193k() {
        this.ac = true;
        this.ad = m5258V();
        this.ae = getScrollAwayOffset();
    }

    public final void mo174a(int i, int i2) {
        if (this.ac && !m5264Z()) {
            if (i > 0 || !this.ad) {
                this.ae += i;
            }
            int overlapY = getOverlapY() - Math.max(0, i2);
            int a = MathUtil.a(this.ae, 0, overlapY);
            Integer.valueOf(overlapY);
            Integer.valueOf(a);
            m5267a(a, "onListViewScroll");
        }
    }

    public int getOverlapY() {
        int a;
        int i = 0;
        if (this.f5649U != null) {
            a = this.f5649U.a();
        } else {
            a = 0;
        }
        if (m5253S()) {
            i = this.f5645Q.getMeasuredHeight();
        }
        a = (getMeasuredHeight() - i) - a;
        if (this.f5650V.d()) {
            return a - this.f5650V.a().getMeasuredHeight();
        }
        return a;
    }

    private int getScrollAwayOffset() {
        return -(this.f5642N.getScrollY() + getScrollY());
    }

    private void m5267a(int i, String str) {
        this.f5642N.getHeight();
        m5268a(i, str, i, 0, 0);
        this.ak = i;
        invalidate();
    }

    private void m5268a(int i, String str, int i2, int i3, int i4) {
        scrollTo(0, -i2);
        this.f5641M.scrollTo(0, -i3);
        this.f5642N.scrollTo(0, -i4);
        Object[] objArr = new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
    }

    private void m5256U() {
        Integer.valueOf(this.ak);
        this.ac = false;
        this.ad = false;
        m5267a(0, "resetTextInputScrollState");
    }

    private boolean m5258V() {
        return getScrollAwayOffset() >= getOverlapY();
    }

    private boolean m5261W() {
        return this.f5643O.getHeight() <= getScrollAwayOffset();
    }

    public static boolean m5262X(TwoLineComposerView twoLineComposerView) {
        return !twoLineComposerView.m5261W();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || this.an == drawable;
    }

    protected void onDraw(Canvas canvas) {
        int scrollY = this.ak + getScrollY();
        this.an.setBounds(0, scrollY, getWidth(), Math.max(scrollY + 1, (ContextUtils.a(getContext(), Service.class) != null ? 1 : 0) != 0 ? getOverlapY() + getScrollY() : getHeight() + getScrollY()));
        this.an.draw(canvas);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onMeasure(int r10, int r11) {
        /*
        r9 = this;
        r1 = 1;
        r2 = 0;
        r0 = r9.f5662l;
        r8 = r0.f;
        r4 = r8;
        r0 = r9.ai;
        if (r0 == 0) goto L_0x00a6;
    L_0x000b:
        r0 = r1;
    L_0x000c:
        r3 = r9.ab;
        r5 = r3.m4789y();
        if (r0 == 0) goto L_0x00a9;
    L_0x0014:
        if (r5 == 0) goto L_0x00a9;
    L_0x0016:
        r3 = r1;
    L_0x0017:
        java.lang.Boolean.valueOf(r5);
        r9.m5250R();
        if (r3 != 0) goto L_0x0024;
    L_0x001f:
        if (r4 != 0) goto L_0x0024;
    L_0x0021:
        r9.m5256U();
    L_0x0024:
        if (r4 != 0) goto L_0x0037;
    L_0x0026:
        r3 = r9.aj;
        if (r3 == 0) goto L_0x0037;
    L_0x002a:
        r3 = r9.af;
        r6 = com.facebook.orca.compose.TwoLineComposerView.TwoLineMode.TEXT_ACTIVE;
        if (r3 != r6) goto L_0x0037;
    L_0x0030:
        r3 = com.facebook.orca.compose.TwoLineComposerView.TwoLineMode.TEXT_VISIBLE;
        r6 = "onMeasure";
        r9.m5273a(r3, r6);
    L_0x0037:
        r3 = com.facebook.common.util.TriState.UNSET;
        r6 = r9.ag;
        r7 = r9.af;
        if (r6 == r7) goto L_0x004c;
    L_0x003f:
        r6 = com.facebook.orca.compose.TwoLineComposerView.AnonymousClass17.f5615a;
        r7 = r9.af;
        r7 = r7.ordinal();
        r6 = r6[r7];
        switch(r6) {
            case 1: goto L_0x00ac;
            case 2: goto L_0x00ac;
            case 3: goto L_0x00b7;
            case 4: goto L_0x00be;
            case 5: goto L_0x00c2;
            default: goto L_0x004c;
        };
    L_0x004c:
        r6 = com.facebook.common.util.TriState.YES;
        if (r3 != r6) goto L_0x00c9;
    L_0x0050:
        r6 = r9.ah;
        r7 = com.facebook.common.util.TriState.YES;
        if (r6 == r7) goto L_0x0065;
    L_0x0056:
        r6 = r9.f5643O;
        r7 = -2;
        com.facebook.common.ui.util.LayoutParamsUtil.b(r6, r7);
        r6 = "onMeasure";
        r9.m5267a(r2, r6);
        r6 = com.facebook.common.util.TriState.YES;
        r9.ah = r6;
    L_0x0065:
        r6 = com.facebook.common.util.TriState.YES;
        if (r3 != r6) goto L_0x00e2;
    L_0x0069:
        r3 = r1;
    L_0x006a:
        if (r3 == 0) goto L_0x00e4;
    L_0x006c:
        r3 = r9.aj;
        if (r3 == 0) goto L_0x00e4;
    L_0x0070:
        if (r4 != 0) goto L_0x00e4;
    L_0x0072:
        if (r1 == 0) goto L_0x0079;
    L_0x0074:
        r1 = r9.ab;
        r1.m4787w();
    L_0x0079:
        r9.aj = r4;
        r1 = r9.f5649U;
        if (r1 == 0) goto L_0x0093;
    L_0x007f:
        r1 = android.view.View.MeasureSpec.getSize(r11);
        r2 = r9.getMeasuredHeight();
        r3 = r9.f5649U;
        r3 = r3.a();
        r2 = r2 - r3;
        r1 = r1 - r2;
        r2 = r9.f5649U;
        r2.y = r1;
    L_0x0093:
        super.onMeasure(r10, r11);
        r1 = r9.ab;
        r1.m4788x();
        if (r0 == r5) goto L_0x00a5;
    L_0x009d:
        r0 = new com.facebook.orca.compose.TwoLineComposerView$15;
        r0.<init>(r9);
        r9.post(r0);
    L_0x00a5:
        return;
    L_0x00a6:
        r0 = r2;
        goto L_0x000c;
    L_0x00a9:
        r3 = r2;
        goto L_0x0017;
    L_0x00ac:
        if (r0 != 0) goto L_0x004c;
    L_0x00ae:
        if (r5 != 0) goto L_0x004c;
    L_0x00b0:
        r3 = com.facebook.common.util.TriState.YES;
        r6 = r9.af;
        r9.ag = r6;
        goto L_0x004c;
    L_0x00b7:
        r3 = com.facebook.common.util.TriState.YES;
        r6 = r9.af;
        r9.ag = r6;
        goto L_0x004c;
    L_0x00be:
        if (r0 == 0) goto L_0x004c;
    L_0x00c0:
        if (r5 == 0) goto L_0x004c;
    L_0x00c2:
        r3 = com.facebook.common.util.TriState.NO;
        r6 = r9.af;
        r9.ag = r6;
        goto L_0x004c;
    L_0x00c9:
        r6 = com.facebook.common.util.TriState.NO;
        if (r3 != r6) goto L_0x0065;
    L_0x00cd:
        r6 = r9.ah;
        r7 = com.facebook.common.util.TriState.NO;
        if (r6 == r7) goto L_0x0065;
    L_0x00d3:
        r6 = r9.f5643O;
        com.facebook.common.ui.util.LayoutParamsUtil.b(r6, r2);
        r6 = "onMeasure";
        r9.m5267a(r2, r6);
        r6 = com.facebook.common.util.TriState.NO;
        r9.ah = r6;
        goto L_0x0065;
    L_0x00e2:
        r3 = r2;
        goto L_0x006a;
    L_0x00e4:
        r1 = r2;
        goto L_0x0072;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.compose.TwoLineComposerView.onMeasure(int, int):void");
    }

    public int getAdditionalKeyboardHeight() {
        if (this.af == TwoLineMode.EMOJI_KEYBOARD_ACTIVE) {
            return 0;
        }
        return getResources().getDimensionPixelSize(2131428513);
    }

    private void m5293d(String str) {
        this.f5661k.b("two_line_composer_view", "tab", null, Collections.singletonMap("tab_tapped", str));
    }

    private void m5295e(String str) {
        HoneyClientEventFast a = this.f5657g.a("content_search_button_pressed", false);
        if (a.a()) {
            a.a("two_line_composer_view").a("num_chars", this.f5643O.f5591l.a().length()).a("reason", str);
            a.b();
        }
    }

    private void m5282a(String str, String str2, int i) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("content_search_send_pressed");
        honeyClientEvent.c = "two_line_composer_view";
        honeyClientEvent.b("content_type", str).b("query", str2.trim()).a("pos", i);
        this.f5657g.a(honeyClientEvent);
    }

    private void m5286b(int i, @Nullable String str) {
        if (str != null) {
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("content_search_collapsed");
            honeyClientEvent.c = "two_line_composer_view";
            honeyClientEvent.b("reason", str).a("max_pos", i);
            this.f5657g.a(honeyClientEvent);
        }
    }

    public final int mo173a(ComposerPointerLocation composerPointerLocation, boolean z) {
        String str = null;
        switch (composerPointerLocation) {
            case TEXT:
                str = "text";
                break;
            case QUICK_CAM:
                str = "camera";
                break;
            case MEDIA_TRAY:
                str = "gallery";
                break;
            case STICKERS:
                str = "stickers";
                break;
            case PAYMENTS:
                str = "payment";
                break;
            case VOICE_CLIPS:
                str = "voice_clip";
                break;
            case RIDE_SERVICE_PROMOTION:
                str = "ride_service_promotion";
                break;
            case EPHEMERAL:
                str = "ephemeral";
                break;
            case MORE:
                str = "overflow";
                break;
        }
        if (str == null || !this.f5645Q.isShown()) {
            return -1;
        }
        Optional b = b(this.f5644P.a(str, z));
        if (b == null) {
            return -1;
        }
        if (!b.isPresent()) {
            return 0;
        }
        return (((View) b.get()).getWidth() / 2) + ((View) b.get()).getLeft();
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.ao = fragmentManager;
    }

    private void m5263Y() {
        if (m5264Z()) {
            m5256U();
        }
    }

    private boolean m5264Z() {
        getLocationInWindow(f5628a);
        if (f5628a[1] > getResources().getDimensionPixelSize(2131428507)) {
            return true;
        }
        return false;
    }

    public static void aa(TwoLineComposerView twoLineComposerView) {
        twoLineComposerView.removeCallbacks(twoLineComposerView.au);
        if (twoLineComposerView.ab()) {
            twoLineComposerView.postDelayed(twoLineComposerView.au, 2000);
        }
    }

    private boolean ab() {
        return ((Boolean) this.f5655e.get()).booleanValue() && this.f5659i.a("orca_composer_hot_like_clicks", null) >= 3 && !this.f5658h.a(MessagingPrefKeys.ar, false) && !this.f5658h.a(MessagingPrefKeys.as, false);
    }

    public static void ac(TwoLineComposerView twoLineComposerView) {
        if (twoLineComposerView.aa == null) {
            twoLineComposerView.m5248Q();
            if (twoLineComposerView.f5647S != null) {
                NuxBubbleControllerProvider nuxBubbleControllerProvider = twoLineComposerView.f5660j;
                twoLineComposerView.aa = new NuxBubbleController(LayoutInflaterMethodAutoProvider.b(nuxBubbleControllerProvider), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(nuxBubbleControllerProvider), SpringSystem.b(nuxBubbleControllerProvider), twoLineComposerView.f5647S, Integer.valueOf(2130905707));
                twoLineComposerView.aa.f5564h = new Object(twoLineComposerView) {
                    final /* synthetic */ TwoLineComposerView f5613a;
                    private AnimatorSet f5614b;

                    {
                        this.f5613a = r1;
                    }

                    public final void m5205a(final View view) {
                        View findViewById = view.findViewById(2131564870);
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(findViewById, "scaleX", new float[]{0.8f, 1.2f}), ObjectAnimator.ofFloat(findViewById, "scaleY", new float[]{0.8f, 1.2f}), ObjectAnimator.ofFloat(findViewById, "rotation", new float[]{0.0f, -15.0f})});
                        animatorSet.setDuration(1000);
                        animatorSet.setInterpolator(new AccelerateInterpolator(1.0f));
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        r3 = new Animator[3];
                        r3[0] = ObjectAnimator.ofFloat(findViewById, "scaleX", new float[]{0.8f});
                        r3[1] = ObjectAnimator.ofFloat(findViewById, "scaleY", new float[]{0.8f});
                        r3[2] = ObjectAnimator.ofFloat(findViewById, "rotation", new float[]{0.0f});
                        animatorSet2.playTogether(r3);
                        animatorSet2.setDuration(200);
                        animatorSet2.setInterpolator(new DecelerateInterpolator(1.0f));
                        this.f5614b = new AnimatorSet();
                        this.f5614b.playSequentially(new Animator[]{animatorSet, animatorSet2});
                        this.f5614b.addListener(new AnimatorListenerAdapter(this) {
                            final /* synthetic */ AnonymousClass16 f5612b;

                            public void onAnimationEnd(Animator animator) {
                                if (view.getParent() != null) {
                                    animator.start();
                                }
                            }
                        });
                    }

                    public final void m5204a() {
                        this.f5614b.start();
                    }

                    public final void m5206b() {
                        this.f5613a.f5658h.edit().putBoolean(MessagingPrefKeys.ar, true).commit();
                    }
                };
            } else {
                return;
            }
        }
        twoLineComposerView.aa.m5152a();
    }

    private void ad() {
        removeCallbacks(this.au);
        if (this.aa != null) {
            this.aa.m5153b();
        }
    }

    public static void ae(TwoLineComposerView twoLineComposerView) {
        twoLineComposerView.ad();
    }

    private void af() {
        this.f5646R.g();
    }

    private void m5270a(ThreadKey threadKey) {
        boolean z = true;
        if (threadKey.a == Type.GROUP) {
            setRideServiceButtonsVisible(RideServiceComposerIconMode.DEFAULT);
            setPaymentButtonVisible(true);
            setMQuickReplyButtonVisible(false);
            return;
        }
        boolean z2;
        boolean z3;
        User a = this.f5636H.a(UserKey.b(Long.toString(threadKey.d)));
        if (!((Boolean) this.f5665o.get()).booleanValue() || a == null) {
            z2 = false;
            z3 = false;
        } else {
            z2 = a.u;
            if (a.v == CommercePageType.COMMERCE_PAGE_TYPE_AGENT) {
                z3 = z2;
                z2 = true;
            } else {
                z3 = z2;
                z2 = false;
            }
        }
        if (this.f5644P != null) {
            this.f5644P.setNonBuiltInShortcutsHidden(z3);
        }
        boolean z4 = (z3 || a == null) ? false : true;
        setPaymentButtonVisible(z4);
        RideServiceComposerIconMode rideServiceComposerIconMode = m5285a(a) ? RideServiceComposerIconMode.PROMOTE : z3 ? RideServiceComposerIconMode.HIDE : RideServiceComposerIconMode.DEFAULT;
        setRideServiceButtonsVisible(rideServiceComposerIconMode);
        if (!(z2 && this.f5671u.a(ExperimentsForBusinessAbtestModule.a, false))) {
            z = false;
        }
        setMQuickReplyButtonVisible(z);
        ag();
    }

    private void setPaymentButtonVisible(boolean z) {
        this.f5646R.b("payment", z);
    }

    private void setRideServiceButtonsVisible(RideServiceComposerIconMode rideServiceComposerIconMode) {
        boolean z = true;
        ComposerShortcutsContainerLogic composerShortcutsContainerLogic = this.f5646R;
        String str = "ride_service";
        boolean z2 = ((Boolean) this.f5672v.get()).booleanValue() && rideServiceComposerIconMode == RideServiceComposerIconMode.DEFAULT;
        composerShortcutsContainerLogic.b(str, z2);
        composerShortcutsContainerLogic = this.f5646R;
        str = "ride_service_promotion";
        if (!(((Boolean) this.f5672v.get()).booleanValue() && rideServiceComposerIconMode == RideServiceComposerIconMode.PROMOTE)) {
            z = false;
        }
        composerShortcutsContainerLogic.b(str, z);
    }

    private void setMQuickReplyButtonVisible(boolean z) {
        this.f5646R.b("quick_reply", z);
    }

    private void ag() {
        boolean z = true;
        ComposerShortcutsContainerLogic composerShortcutsContainerLogic = this.f5646R;
        String str = "ephemeral";
        boolean z2 = ThreadKey.g(this.at) && ((TincanGatekeepers) this.f5640L.get()).d();
        composerShortcutsContainerLogic.b(str, z2);
        ThreadSummary a = this.f5663m.a(this.at);
        composerShortcutsContainerLogic = this.f5646R;
        str = "ephemeral";
        if (a == null || !a.h()) {
            z = false;
        }
        composerShortcutsContainerLogic.a(str, z);
    }

    private void m5284a(boolean z) {
        if (m5343c("ephemeral")) {
            this.f5646R.a("ephemeral", z);
        }
    }

    public final boolean m5343c(String str) {
        boolean z;
        ComposerShortcutState composerShortcutState = (ComposerShortcutState) this.f5646R.q.get(str);
        if (composerShortcutState != null) {
            z = composerShortcutState.b;
        } else {
            z = false;
        }
        return z;
    }

    public static boolean m5297f(TwoLineComposerView twoLineComposerView, String str) {
        ComposerShortcutState composerShortcutState = (ComposerShortcutState) twoLineComposerView.f5646R.q.get(str);
        boolean z = composerShortcutState != null && composerShortcutState.c;
        return z;
    }

    public static boolean m5299g(TwoLineComposerView twoLineComposerView, String str) {
        return twoLineComposerView.f5646R.c(str);
    }

    public static void m5301h(TwoLineComposerView twoLineComposerView, String str) {
        twoLineComposerView.f5670t.a(str, BugReportCategory.COMPOSE_MESSAGE_FLOW);
    }

    private static boolean m5285a(@Nullable User user) {
        return (user == null || user.v == null || !user.v.equals(CommercePageType.COMMERCE_PAGE_TYPE_RIDE_SHARE)) ? false : true;
    }

    private void m5271a(MessengerSoundUtil messengerSoundUtil, Provider<Boolean> provider, Provider<Boolean> provider2, Provider<Boolean> provider3, Provider<Boolean> provider4, AnalyticsLogger analyticsLogger, FbSharedPreferences fbSharedPreferences, UiCounters uiCounters, NuxBubbleControllerProvider nuxBubbleControllerProvider, NavigationLogger navigationLogger, SoftInputDetector softInputDetector, DataCache dataCache, ThreadRecipientUtil threadRecipientUtil, Provider<Boolean> provider5, MentionsSearchControllerProvider mentionsSearchControllerProvider, ContentSearchControllerProvider contentSearchControllerProvider, Boolean bool, Boolean bool2, BugReportOperationLogger bugReportOperationLogger, QeAccessor qeAccessor, Provider<Boolean> provider6, ZeroDialogController zeroDialogController, GatekeeperListeners gatekeeperListeners, Provider<Boolean> provider7, com.facebook.inject.Lazy<MessageCapButtonController> lazy, AppChoreographer appChoreographer, Provider<Boolean> provider8, DynamicMediaPickerPreference dynamicMediaPickerPreference, SmsDefaultAppManager smsDefaultAppManager, SmsGatekeepers smsGatekeepers, ComposerShortcutsGatekeepers composerShortcutsGatekeepers, com.facebook.inject.Lazy<EphemeralGatingUtil> lazy2, UserCache userCache, AndroidThreadUtil androidThreadUtil, StickerContentSearchExperimentAccessor stickerContentSearchExperimentAccessor, FlowerBorderFeature flowerBorderFeature, com.facebook.inject.Lazy<TincanGatekeepers> lazy3) {
        this.f5652b = messengerSoundUtil;
        this.f5653c = provider;
        this.f5654d = provider2;
        this.f5655e = provider3;
        this.f5656f = provider4;
        this.f5657g = analyticsLogger;
        this.f5658h = fbSharedPreferences;
        this.f5659i = uiCounters;
        this.f5660j = nuxBubbleControllerProvider;
        this.f5661k = navigationLogger;
        this.f5662l = softInputDetector;
        this.f5663m = dataCache;
        this.f5664n = threadRecipientUtil;
        this.f5665o = provider5;
        this.f5666p = mentionsSearchControllerProvider;
        this.f5667q = contentSearchControllerProvider;
        this.f5668r = bool;
        this.f5669s = bool2;
        this.f5670t = bugReportOperationLogger;
        this.f5671u = qeAccessor;
        this.f5672v = provider6;
        this.f5673w = zeroDialogController;
        this.f5674x = gatekeeperListeners;
        this.f5675y = provider7;
        this.f5676z = lazy;
        this.f5629A = appChoreographer;
        this.f5630B = provider8;
        this.f5631C = dynamicMediaPickerPreference;
        this.f5632D = smsDefaultAppManager;
        this.f5633E = smsGatekeepers;
        this.f5634F = composerShortcutsGatekeepers;
        this.f5635G = lazy2;
        this.f5636H = userCache;
        this.f5637I = androidThreadUtil;
        this.f5638J = stickerContentSearchExperimentAccessor;
        this.f5639K = flowerBorderFeature;
        this.f5640L = lazy3;
    }
}
