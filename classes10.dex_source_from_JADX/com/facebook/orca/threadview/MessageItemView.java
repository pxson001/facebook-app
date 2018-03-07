package com.facebook.orca.threadview;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.support.v7.internal.widget.ViewStubCompat;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.util.LoggerMapUtils;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.appchoreographer.AppChoreographer;
import com.facebook.common.appchoreographer.AppChoreographer.Priority;
import com.facebook.common.appchoreographer.AppChoreographer.ThreadType;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.loader.AbstractFbLoaderCallback;
import com.facebook.common.numbers.FileSizeUtil;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.SystemClock;
import com.facebook.common.time.TimeConversions;
import com.facebook.common.ui.util.LayoutParamsUtil;
import com.facebook.common.ui.util.ViewReplacementUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.imagepipeline.animated.base.AnimatableDrawable;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messages.links.MessengerLinks;
import com.facebook.messaging.analytics.reliability.MessageItemLogger;
import com.facebook.messaging.analytics.reliability.MessagesReliabilityLogger;
import com.facebook.messaging.annotations.IsDisplayObjectCacheEnabled;
import com.facebook.messaging.annotations.IsMessengerMaterialDesignEnabled;
import com.facebook.messaging.applinks.ApplinkHelper;
import com.facebook.messaging.attachments.AttachmentDataFactory;
import com.facebook.messaging.attachments.ImageAttachmentData;
import com.facebook.messaging.attachments.VideoAttachmentData;
import com.facebook.messaging.attributionview.AttributionHelper;
import com.facebook.messaging.attributionview.AttributionHelper.AttributionSource;
import com.facebook.messaging.attributionview.AttributionView;
import com.facebook.messaging.attributionview.AttributionViewData;
import com.facebook.messaging.attributionview.AttributionViewHelper;
import com.facebook.messaging.business.commerce.gating.IsMessengerCommerceEnabled;
import com.facebook.messaging.business.commerceui.views.CommerceBubbleView;
import com.facebook.messaging.business.ride.helper.RideAddressTriggerHelper;
import com.facebook.messaging.business.ride.helper.RideKeywordTriggerHelper;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.cache.MessengerUserNameUtil;
import com.facebook.messaging.customthreads.CustomThreadsEmojiLike;
import com.facebook.messaging.customthreads.DefaultThreadViewTheme;
import com.facebook.messaging.customthreads.ThreadViewTheme.BubbleType;
import com.facebook.messaging.customthreads.ThreadViewTheme.Listener;
import com.facebook.messaging.customthreads.ThreadViewTheme.SenderType;
import com.facebook.messaging.customthreads.annotations.CanViewThreadCustomization;
import com.facebook.messaging.customthreads.annotations.IsHotEmojilikesHistoryEnabled;
import com.facebook.messaging.ephemeral.EphemeralMessageProgressManager;
import com.facebook.messaging.ephemeral.EphemeralProgressUtil;
import com.facebook.messaging.ephemeral.MessageLifetimeStringHelper;
import com.facebook.messaging.ephemeral.gating.EphemeralGatingUtil;
import com.facebook.messaging.forward.MessageForwardHandler;
import com.facebook.messaging.giftwrap.GiftWrapResolver;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.facebook.messaging.intents.MessagesBroadcastIntents;
import com.facebook.messaging.linkhandling.LinkHandlingHelper;
import com.facebook.messaging.lowdatamode.LowDataModePrefKeys;
import com.facebook.messaging.messageclassifier.MessageClassification;
import com.facebook.messaging.messageclassifier.MessageClassifier;
import com.facebook.messaging.messageclassifier.MessageExaminer;
import com.facebook.messaging.messagerendering.MessageRenderingUtil;
import com.facebook.messaging.model.attachment.Attachment;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.messages.MessageUserUtil;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.send.SendErrorType;
import com.facebook.messaging.model.share.Share;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.modifiers.flowerborder.FlowerBorderFeature;
import com.facebook.messaging.momentsinvite.ui.MomentsInviteView;
import com.facebook.messaging.montage.MontageMessagesHelper;
import com.facebook.messaging.montage.MontageTestHelper;
import com.facebook.messaging.montage.MontageTileView;
import com.facebook.messaging.payment.model.MessengerPayEntityType;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.thread.PaymentTriggerHelper;
import com.facebook.messaging.payment.thread.PaymentView;
import com.facebook.messaging.payment.thread.PaymentViewParams;
import com.facebook.messaging.payment.thread.PaymentViewParamsBuilder;
import com.facebook.messaging.payment.value.input.EnterPaymentValueActivity;
import com.facebook.messaging.photos.tiles.UserTileViewParamsFactory;
import com.facebook.messaging.send.client.SendMessageManager;
import com.facebook.messaging.threadview.hotlikes.HotLikesSpringConfig;
import com.facebook.messaging.threadview.rows.RowItemDeliveryState;
import com.facebook.messaging.threadview.rows.RowItemGrouping;
import com.facebook.messaging.threadview.rows.RowMessageItem;
import com.facebook.messaging.ui.mms.MmsDownloadView;
import com.facebook.messaging.ui.share.ShareView;
import com.facebook.messaging.util.date.MessagingDateUtil;
import com.facebook.messaging.xma.SimpleStyleRenderer;
import com.facebook.messaging.xma.StyleRendererManager;
import com.facebook.messaging.xma.XMAActionHandlerManager;
import com.facebook.messaging.xma.XMAContentContainer;
import com.facebook.messaging.xma.XMAView;
import com.facebook.orca.threadview.RowItemUiUtil.BubbleCornerRadius;
import com.facebook.orca.threadview.RowMessageItemDisplayCache.Entry;
import com.facebook.orca.threadview.ThreadViewLoader.Error;
import com.facebook.orca.threadview.ThreadViewLoader.Params;
import com.facebook.orca.threadview.ThreadViewLoader.Result;
import com.facebook.orca.threadview.hotlikes.HotLikesViewAnimationHelper;
import com.facebook.orca.threadview.montage.MontageViewActivity;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.presence.DefaultPresenceManager;
import com.facebook.presence.PresenceManager;
import com.facebook.presence.PresenceManager.OnContactPresenceStateChangedListener;
import com.facebook.presence.PresenceState;
import com.facebook.resources.ui.FbTextView;
import com.facebook.stickers.model.StickerUtil;
import com.facebook.stickers.ui.StickerDraweeView;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.emoji.EmojiUtil;
import com.facebook.ui.emoji.model.BigEmojis;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.facebook.user.tiles.UserTileView;
import com.facebook.user.tiles.UserTileViewParams;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.RoundedCornerOverlayDrawable;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.ViewStubHolder.OnInflateListener;
import com.facebook.widget.animatablelistview.AnimatingItemView;
import com.facebook.widget.listview.ListViewItemWithData;
import com.facebook.widget.text.BetterTextView;
import com.facebook.widget.text.SpanLinkHook;
import com.google.common.base.Absent;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: messenger_thread_list */
public class MessageItemView extends CustomLinearLayout implements FlowerBorderContainer, ThreadImageClickListener, VideoMessageContainer, ListViewItemWithData<RowMessageItem> {
    private static final CallerContext ae = CallerContext.a(MessageItemView.class, "sticker_thread_view");
    @Inject
    MonotonicClock f7116A;
    @Inject
    UserTileViewParamsFactory f7117B;
    @Inject
    PaymentTriggerHelper f7118C;
    @Inject
    PendingAndSentDrawableProvider f7119D;
    @Inject
    DefaultPresenceManager f7120E;
    @Inject
    Product f7121F;
    @Inject
    public Resources f7122G;
    @Inject
    RowMessageItemDisplayCache f7123H;
    @Inject
    public SecureContextHelper f7124I;
    @Inject
    FbSharedPreferences f7125J;
    @Inject
    ImagePipeline f7126K;
    @Inject
    ThreadViewLowDataModeUtils f7127L;
    @Inject
    FileSizeUtil f7128M;
    @Inject
    AttributionHelper f7129N;
    @Inject
    AnalyticsLogger f7130O;
    @Inject
    public MontageTestHelper f7131P;
    @Inject
    MontageMessagesHelper f7132Q;
    @Inject
    Lazy<EphemeralMessageProgressManager> f7133R;
    @Inject
    EphemeralGatingUtil f7134S;
    @Inject
    RideAddressTriggerHelper f7135T;
    @Inject
    RideKeywordTriggerHelper f7136U;
    @IsMessengerMaterialDesignEnabled
    @Inject
    public Provider<Boolean> f7137V;
    @Inject
    EphemeralProgressUtil f7138W;
    @Inject
    AnalyticsTagger f7139a;
    @Nullable
    private final ViewStubHolder<TextView> aA;
    private final ViewStubHolder<ShareView> aB;
    private final ViewStubHolder<PaymentView> aC;
    public final ViewStubHolder<StickerDraweeView> aD;
    private final ViewStubHolder<ThreadViewAudioAttachmentView> aE;
    public final ViewStubHolder<ThreadViewImageAttachmentView> aF;
    public final ViewStubHolder<ThreadViewVideoAttachmentView> aG;
    public final ViewStubHolder<MessageItemGutterView> aH;
    private final ViewStubHolder<ThreadViewOtherAttachmentsView> aI;
    public final ViewStubHolder<ThreadViewLowDataModeNuxView> aJ;
    private final ViewStubHolder<ThreadViewUnavailableAttachmentView> aK;
    @Nullable
    public final ViewStubHolder<FbTextView> aL;
    @Nullable
    public final ViewStubHolder<FbTextView> aM;
    @Nullable
    private final ViewStubHolder<DeliveryStatusView> aN;
    private final ViewStubHolder<AttributionView> aO;
    private final ViewStubHolder<XMAContentContainer> aP;
    private final ViewStubHolder<MomentsInviteView> aQ;
    private final ViewStubHolder<CommerceBubbleView> aR;
    private final ViewStubHolder<MmsDownloadView> aS;
    private final OnClickListener aT = new C10641(this);
    private final Listener aU = new C10652(this);
    @Nullable
    public AnimatingItemView aV;
    @Nullable
    public TextView aW;
    @Nullable
    public AnimatingItemView aX;
    @Nullable
    public FbTextView aY;
    @Nullable
    public TextView aZ;
    @Inject
    MessageXMACallbackHelper aa;
    @Inject
    UserCache ab;
    @Inject
    MessengerUserNameUtil ac;
    @Inject
    FlowerBorderFeature ad;
    @Inject
    @com.facebook.ultralight.Lazy
    private Lazy<StyleRendererManager> af = UltralightRuntime.b();
    @Inject
    @com.facebook.ultralight.Lazy
    private Lazy<MessageForwardHandler> ag = UltralightRuntime.b();
    @Inject
    @com.facebook.ultralight.Lazy
    public Lazy<MessageLifetimeStringHelper> ah = UltralightRuntime.b();
    @Inject
    @com.facebook.ultralight.Lazy
    private Lazy<ThreadViewLoader> ai = UltralightRuntime.b();
    @Inject
    @com.facebook.ultralight.Lazy
    public Lazy<SendMessageManager> aj = UltralightRuntime.b();
    private final int ak;
    private final int al;
    private final int am;
    private final int an;
    public final int ao;
    public final int ap;
    private final float aq = 0.5f;
    private final float ar = 1.0f;
    public final LinearLayout as;
    public final MessageContentContainer at;
    public final BetterTextView au;
    public final boolean av;
    @Nullable
    public final MessageItemForegroundDrawable aw;
    private final Drawable ax;
    private final Drawable ay = new ColorDrawable(0);
    @Nullable
    public final UserTileView az;
    @Inject
    public DefaultAppChoreographer f7140b;
    private final ControllerListener bA = new C10685(this);
    @Nullable
    private View ba;
    @Nullable
    public MontageTileView bb;
    @Nullable
    private View bc;
    @Nullable
    public DefaultThreadViewTheme bd;
    @Nullable
    public HotLikesViewAnimationHelper be;
    @Nullable
    private SimpleStyleRenderer bf;
    @Nullable
    public MessageListAdapter.Listener bg;
    @Nullable
    public AnonymousClass21 bh;
    public RowMessageItem bi;
    private boolean bj;
    public FragmentManager bk;
    public XMAActionHandlerManager<Message> bl;
    private DataSubscriber<CloseableReference<PooledByteBuffer>> bm = null;
    private DataSource<CloseableReference<PooledByteBuffer>> bn = null;
    private SelfRegistrableReceiverImpl bo;
    private ActionReceiver bp;
    private Message bq;
    public SelfRegistrableReceiverImpl br;
    private BubbleCornerRadius bs;
    private UserTileViewParams bt;
    private String bu = null;
    private int bv = 0;
    private long bw;
    private boolean bx;
    private final C10663 by = new C10663(this);
    private final OnContactPresenceStateChangedListener bz = new C10674(this);
    @Inject
    public ApplinkHelper f7141c;
    @Inject
    AttachmentDataFactory f7142d;
    @Inject
    AttributionViewHelper f7143e;
    @Inject
    Lazy<BigEmojis> f7144f;
    @Inject
    @CanViewThreadCustomization
    public Provider<Boolean> f7145g;
    @Inject
    public CustomThreadsEmojiLike f7146h;
    @IsDisplayObjectCacheEnabled
    @Inject
    Provider<Boolean> f7147i;
    @Inject
    Lazy<EmojiUtil> f7148j;
    @Inject
    DataCache f7149k;
    @Inject
    @ForUiThread
    Executor f7150l;
    @Inject
    GiftWrapResolver f7151m;
    @Inject
    @IsHotEmojilikesHistoryEnabled
    public Provider<Boolean> f7152n;
    @Inject
    @IsMessengerCommerceEnabled
    Provider<Boolean> f7153o;
    @Inject
    public Lazy<LinkHandlingHelper> f7154p;
    @Inject
    @LocalBroadcast
    public Lazy<FbBroadcastManager> f7155q;
    @Inject
    MessageClassifier f7156r;
    @Inject
    MessageExaminer f7157s;
    @Inject
    MessageItemLogger f7158t;
    @Inject
    MessageRenderingUtil f7159u;
    @Inject
    MessageUserUtil f7160v;
    @Inject
    MessageUtil f7161w;
    @Inject
    RowItemUiUtil f7162x;
    @Inject
    MessagesReliabilityLogger f7163y;
    @Inject
    MessagingDateUtil f7164z;

    /* compiled from: messenger_thread_list */
    class C10641 implements OnClickListener {
        final /* synthetic */ MessageItemView f7083a;

        C10641(MessageItemView messageItemView) {
            this.f7083a = messageItemView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1055157005);
            MessageItemView.au(this.f7083a);
            Logger.a(2, EntryType.UI_INPUT_END, -1622528246, a);
        }
    }

    /* compiled from: messenger_thread_list */
    class C10652 implements Listener {
        final /* synthetic */ MessageItemView f7096a;

        C10652(MessageItemView messageItemView) {
            this.f7096a = messageItemView;
        }

        public final void m6678a() {
            MessageItemView.m6738e(this.f7096a);
            MessageItemView.m6751t(this.f7096a);
        }
    }

    /* compiled from: messenger_thread_list */
    public class C10663 {
        public final /* synthetic */ MessageItemView f7105a;

        C10663(MessageItemView messageItemView) {
            this.f7105a = messageItemView;
        }
    }

    /* compiled from: messenger_thread_list */
    class C10674 extends OnContactPresenceStateChangedListener {
        final /* synthetic */ MessageItemView f7106a;

        C10674(MessageItemView messageItemView) {
            this.f7106a = messageItemView;
        }

        public final void m6687a(UserKey userKey, PresenceState presenceState) {
            MessageItemView messageItemView = this.f7106a;
            if (!messageItemView.av) {
                messageItemView.f7140b.a("updateUserBadging", new Runnable(messageItemView) {
                    final /* synthetic */ MessageItemView f7090a;

                    {
                        this.f7090a = r1;
                    }

                    public void run() {
                        MessageItemView.m6750s(this.f7090a);
                    }
                }, Priority.APPLICATION_LOADED_UI_IDLE, ThreadType.UI);
            }
        }
    }

    /* compiled from: messenger_thread_list */
    class C10685 extends BaseControllerListener {
        final /* synthetic */ MessageItemView f7107a;

        C10685(MessageItemView messageItemView) {
            this.f7107a = messageItemView;
        }

        public final void m6688a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                MessageItemView.setOnStickerImageReady(this.f7107a, animatable);
            }
        }
    }

    /* compiled from: messenger_thread_list */
    public class C10696 {
        final /* synthetic */ MessageItemView f7108a;

        C10696(MessageItemView messageItemView) {
            this.f7108a = messageItemView;
        }

        public final boolean m6689a(ClickableSpan clickableSpan) {
            Message message = this.f7108a.bi.f4732a;
            if (!(clickableSpan instanceof URLSpan)) {
                return false;
            }
            Object obj;
            URLSpan uRLSpan = (URLSpan) clickableSpan;
            String url = uRLSpan.getURL();
            MessageItemLogger messageItemLogger = this.f7108a.f7158t;
            if (messageItemLogger.c.a("message_link_clicked_type")) {
                HoneyClientEvent b = new HoneyClientEvent("message_link_clicked_type").b("message_id", message.a);
                String url2 = uRLSpan.getURL();
                if (url2.startsWith("mailto")) {
                    url2 = "email_address";
                } else if (url2.startsWith("tel")) {
                    url2 = "phone_number";
                } else if (url2.startsWith("geo")) {
                    url2 = "map_address";
                } else {
                    url2 = "web_url";
                }
                b.b("link_type", url2);
                b.a("message_age_sec", (SystemClock.a.a() - message.c) / 1000);
                messageItemLogger.a.a(b);
            }
            MessageItemView messageItemView = this.f7108a;
            Share T = MessageUtil.T(message);
            if (T == null || !Objects.equal(url, T.f) || messageItemView.bg == null) {
                obj = null;
            } else {
                messageItemView.bg.mo287a(messageItemView.bi, T);
                obj = 1;
            }
            if (obj != null) {
                return true;
            }
            Uri parse = Uri.parse(url);
            MessageItemView messageItemView2 = this.f7108a;
            if (!messageItemView2.f7141c.a(parse, messageItemView2.getContext())) {
                ((LinkHandlingHelper) messageItemView2.f7154p.get()).a(messageItemView2.getContext(), parse);
            }
            return true;
        }
    }

    /* compiled from: messenger_thread_list */
    class C10707 implements OnInflateListener<ShareView> {
        final /* synthetic */ MessageItemView f7109a;

        C10707(MessageItemView messageItemView) {
            this.f7109a = messageItemView;
        }

        public final void m6690a(View view) {
            ShareView shareView = (ShareView) view;
            shareView.setForMeUser(this.f7109a.av);
            shareView.setOnLongClickListener(new LongClickListener(this.f7109a));
        }
    }

    /* compiled from: messenger_thread_list */
    class C10718 implements OnInflateListener<StickerDraweeView> {
        final /* synthetic */ MessageItemView f7110a;

        C10718(MessageItemView messageItemView) {
            this.f7110a = messageItemView;
        }

        public final void m6691a(View view) {
            StickerDraweeView stickerDraweeView = (StickerDraweeView) view;
            stickerDraweeView.setOnLongClickListener(new LongClickListener(this.f7110a));
            LayoutParams layoutParams = (LayoutParams) stickerDraweeView.getLayoutParams();
            if (this.f7110a.f7160v.a(this.f7110a.bi.f4732a)) {
                layoutParams.gravity = 5;
            } else {
                layoutParams.gravity = 3;
            }
            stickerDraweeView.setLayoutParams(layoutParams);
        }
    }

    /* compiled from: messenger_thread_list */
    class C10729 implements OnInflateListener<ThreadViewAudioAttachmentView> {
        final /* synthetic */ MessageItemView f7111a;

        C10729(MessageItemView messageItemView) {
            this.f7111a = messageItemView;
        }

        public final void m6692a(View view) {
            ThreadViewAudioAttachmentView threadViewAudioAttachmentView = (ThreadViewAudioAttachmentView) view;
            threadViewAudioAttachmentView.setForMeUser(this.f7111a.av);
            threadViewAudioAttachmentView.m7135a(this.f7111a);
            threadViewAudioAttachmentView.f7488o = this.f7111a.bk;
        }
    }

    /* compiled from: messenger_thread_list */
    class LongClickListener implements OnLongClickListener {
        final /* synthetic */ MessageItemView f7112a;

        public LongClickListener(MessageItemView messageItemView) {
            this.f7112a = messageItemView;
        }

        public boolean onLongClick(View view) {
            MessageItemView messageItemView = this.f7112a;
            boolean z = false;
            if (!(messageItemView.bi == null || messageItemView.bg == null)) {
                z = messageItemView.bg.mo292a(messageItemView.bi);
            }
            return z;
        }
    }

    /* compiled from: messenger_thread_list */
    class MontageThreadViewLoaderCallback extends AbstractFbLoaderCallback<Params, Result, Error> {
        final /* synthetic */ MessageItemView f7115a;

        public MontageThreadViewLoaderCallback(MessageItemView messageItemView) {
            this.f7115a = messageItemView;
        }

        public final void m6693b(Object obj, Object obj2) {
            Result result = (Result) obj2;
            if (this.f7115a.f7132Q.b(result.f7613c)) {
                if (this.f7115a.bb == null) {
                    this.f7115a.bb = new MontageTileView(this.f7115a.getContext());
                }
                this.f7115a.bb.a(result.f7611a, result.f7613c);
                final ThreadKey threadKey = result.f7611a.a;
                this.f7115a.bb.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ MontageThreadViewLoaderCallback f7114b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 467595817);
                        Intent intent = new Intent(this.f7114b.f7115a.getContext(), MontageViewActivity.class);
                        intent.putExtra("thread_key", threadKey);
                        this.f7114b.f7115a.f7124I.a(intent, this.f7114b.f7115a.getContext());
                        Logger.a(2, EntryType.UI_INPUT_END, -1730019841, a);
                    }
                });
                MessageItemView.m6727a(this.f7115a, this.f7115a.bb);
                return;
            }
            MessageItemView.m6727a(this.f7115a, this.f7115a.az);
        }
    }

    private static <T extends View> void m6728a(Class<T> cls, T t) {
        m6729a((Object) t, t.getContext());
    }

    private static void m6729a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((MessageItemView) obj).m6725a(AnalyticsTagger.a(injectorLike), DefaultAppChoreographer.a(injectorLike), ApplinkHelper.a(injectorLike), AttachmentDataFactory.a(injectorLike), AttributionViewHelper.a(injectorLike), IdBasedLazy.a(injectorLike, 11501), IdBasedProvider.a(injectorLike, 4144), CustomThreadsEmojiLike.a(injectorLike), IdBasedProvider.a(injectorLike, 4055), IdBasedLazy.a(injectorLike, 3556), DataCache.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), GiftWrapResolver.a(injectorLike), IdBasedProvider.a(injectorLike, 4150), IdBasedProvider.a(injectorLike, 4113), IdBasedSingletonScopeProvider.b(injectorLike, 7898), IdBasedLazy.a(injectorLike, 401), MessageClassifier.a(injectorLike), MessageExaminer.a(injectorLike), MessageItemLogger.a(injectorLike), MessageRenderingUtil.a(injectorLike), MessageUserUtil.a(injectorLike), MessageUtil.a(injectorLike), RowItemUiUtil.m7015a(injectorLike), MessagesReliabilityLogger.a(injectorLike), MessagingDateUtil.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), UserTileViewParamsFactory.a(injectorLike), PaymentTriggerHelper.a(injectorLike), (PendingAndSentDrawableProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PendingAndSentDrawableProvider.class), DefaultPresenceManager.a(injectorLike), ProductMethodAutoProvider.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), RowMessageItemDisplayCache.m7028a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), IdBasedLazy.a(injectorLike, 8605), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), ImagePipelineMethodAutoProvider.a(injectorLike), ThreadViewLowDataModeUtils.m7358a(injectorLike), FileSizeUtil.a(injectorLike), AttributionHelper.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), MontageTestHelper.a(injectorLike), MontageMessagesHelper.a(injectorLike), IdBasedLazy.a(injectorLike, 7842), EphemeralGatingUtil.a(injectorLike), RideAddressTriggerHelper.a(injectorLike), RideKeywordTriggerHelper.a(injectorLike), IdBasedProvider.a(injectorLike, 4073), EphemeralProgressUtil.a(injectorLike), MessageXMACallbackHelper.m6918a(injectorLike), UserCache.a(injectorLike), MessengerUserNameUtil.a(injectorLike), FlowerBorderFeature.a(injectorLike), IdBasedLazy.a(injectorLike, 7858), IdBasedLazy.a(injectorLike, 7843), IdBasedLazy.a(injectorLike, 8862), IdBasedLazy.a(injectorLike, 8347));
    }

    public MessageItemView(Context context, boolean z) {
        super(context, null);
        TracerDetour.a("MessageItemView.ctor", -1250397926);
        try {
            m6728a(MessageItemView.class, (View) this);
            this.av = z;
            setOrientation(1);
            setContentView(z ? 2130905757 : 2130905729);
            this.as = (LinearLayout) a(2131564429);
            this.at = (MessageContentContainer) a(2131564908);
            this.au = (BetterTextView) a(2131564912);
            SpanLinkHook spanLinkHook = new SpanLinkHook(this.au);
            spanLinkHook.a(new C10696(this));
            this.au.a(spanLinkHook);
            this.aB = ViewStubHolder.a((ViewStubCompat) a(2131559723));
            this.aB.a(new C10707(this));
            this.aC = ViewStubHolder.a((ViewStubCompat) a(2131564898));
            this.aR = ViewStubHolder.a((ViewStubCompat) a(2131564900));
            this.aS = ViewStubHolder.a((ViewStubCompat) a(2131564902));
            this.aD = ViewStubHolder.a((ViewStubCompat) a(2131564893));
            this.aD.a(new C10718(this));
            this.aE = ViewStubHolder.a((ViewStubCompat) a(2131564894));
            this.aE.a(new C10729(this));
            this.aF = ViewStubHolder.a((ViewStubCompat) a(2131564897));
            this.aF.a(new OnInflateListener<ThreadViewImageAttachmentView>(this) {
                final /* synthetic */ MessageItemView f7070a;

                {
                    this.f7070a = r1;
                }

                public final void m6646a(View view) {
                    ((ThreadViewImageAttachmentView) view).f7566E = this.f7070a.av;
                }
            });
            this.aG = ViewStubHolder.a((ViewStubCompat) a(2131559722));
            this.aG.a(new OnInflateListener<ThreadViewVideoAttachmentView>(this) {
                final /* synthetic */ MessageItemView f7071a;

                {
                    this.f7071a = r1;
                }

                public final void m6647a(View view) {
                    ThreadViewVideoAttachmentView threadViewVideoAttachmentView = (ThreadViewVideoAttachmentView) view;
                    MessageItemView messageItemView = this.f7071a;
                    threadViewVideoAttachmentView.f8087M = messageItemView.bk;
                    threadViewVideoAttachmentView.f8078D = new ThreadViewVideoAttachmentView.Listener(messageItemView) {
                        final /* synthetic */ MessageItemView f7086a;

                        {
                            this.f7086a = r1;
                        }

                        public final void mo257a(String str) {
                            if (this.f7086a.bg != null) {
                                this.f7086a.bg.mo289a(str);
                            }
                        }

                        public final void mo258a(String str, EventTriggerType eventTriggerType) {
                            if (this.f7086a.bg != null) {
                                this.f7086a.bg.mo290a(str, eventTriggerType);
                            }
                        }

                        public final void mo261b(String str) {
                            if (this.f7086a.bg != null) {
                                this.f7086a.bg.mo295b(str);
                            }
                        }

                        public final void mo255a() {
                            if (this.f7086a.bg != null) {
                                this.f7086a.bg.mo293b();
                            }
                        }

                        public final void mo256a(VideoAttachmentData videoAttachmentData) {
                            if (this.f7086a.bg != null) {
                                MessageListAdapter.Listener listener = this.f7086a.bg;
                                RowMessageItem rowMessageItem = this.f7086a.bi;
                                listener.mo278a(videoAttachmentData);
                            }
                        }

                        public final void mo260b(VideoAttachmentData videoAttachmentData) {
                            this.f7086a.m6758a((Parcelable) videoAttachmentData);
                        }

                        public final void mo259b() {
                            MessageItemView.au(this.f7086a);
                        }
                    };
                }
            });
            this.aH = ViewStubHolder.a((ViewStubCompat) a(2131564913));
            this.aH.a(new OnInflateListener<MessageItemGutterView>(this) {
                final /* synthetic */ MessageItemView f7073a;

                /* compiled from: messenger_thread_list */
                class C10611 implements MessageItemGutterView.Listener {
                    final /* synthetic */ AnonymousClass12 f7072a;

                    C10611(AnonymousClass12 anonymousClass12) {
                        this.f7072a = anonymousClass12;
                    }

                    public final void mo253a() {
                        if (this.f7072a.f7073a.bg != null) {
                            this.f7072a.f7073a.bg.mo297c(this.f7072a.f7073a.bi);
                        }
                    }
                }

                {
                    this.f7073a = r1;
                }

                public final void m6649a(View view) {
                    ((MessageItemGutterView) view).f7069f = new C10611(this);
                }
            });
            this.aI = ViewStubHolder.a((ViewStubCompat) a(2131564895));
            this.aI.a(new OnInflateListener<ThreadViewOtherAttachmentsView>(this) {
                final /* synthetic */ MessageItemView f7074a;

                {
                    this.f7074a = r1;
                }

                public final void m6650a(View view) {
                    ((ThreadViewOtherAttachmentsView) view).f7968e = this.f7074a.av;
                }
            });
            this.aK = ViewStubHolder.a((ViewStubCompat) a(2131564896));
            this.aK.a(new OnInflateListener<ThreadViewUnavailableAttachmentView>(this) {
                final /* synthetic */ MessageItemView f7075a;

                {
                    this.f7075a = r1;
                }

                public final void m6651a(View view) {
                    ThreadViewUnavailableAttachmentView threadViewUnavailableAttachmentView = (ThreadViewUnavailableAttachmentView) view;
                    if (this.f7075a.av) {
                        threadViewUnavailableAttachmentView.m7946a();
                    }
                }
            });
            this.aO = ViewStubHolder.a((ViewStubCompat) a(2131564903));
            this.aO.a(new OnInflateListener<AttributionView>(this) {
                final /* synthetic */ MessageItemView f7077a;

                /* compiled from: messenger_thread_list */
                class C10621 implements AttributionView.Listener {
                    final /* synthetic */ AnonymousClass15 f7076a;

                    C10621(AnonymousClass15 anonymousClass15) {
                        this.f7076a = anonymousClass15;
                    }

                    public final void m6652a(AttributionViewData attributionViewData) {
                        if (this.f7076a.f7077a.bg != null) {
                            this.f7076a.f7077a.bg.mo279a(attributionViewData);
                        }
                    }
                }

                {
                    this.f7077a = r1;
                }

                public final void m6653a(View view) {
                    ((AttributionView) view).j = new C10621(this);
                }
            });
            this.aJ = ViewStubHolder.a((ViewStubCompat) a(2131564904));
            this.aJ.a(new OnInflateListener<ThreadViewLowDataModeNuxView>(this) {
                final /* synthetic */ MessageItemView f7079a;

                /* compiled from: messenger_thread_list */
                class C10631 implements ThreadViewLowDataModeNuxView.Listener {
                    final /* synthetic */ AnonymousClass16 f7078a;

                    C10631(AnonymousClass16 anonymousClass16) {
                        this.f7078a = anonymousClass16;
                    }

                    public final void mo254a() {
                        this.f7078a.f7079a.f7130O.a(new HoneyClientEvent("low_data_mode_nux_settings_pressed"));
                        MessageItemView messageItemView = this.f7078a.f7079a;
                        Intent intent = new Intent();
                        intent.setData(Uri.parse(MessengerLinks.l));
                        messageItemView.f7124I.a(intent, messageItemView.getContext());
                    }
                }

                {
                    this.f7079a = r1;
                }

                public final void m6656a(View view) {
                    ((ThreadViewLowDataModeNuxView) view).f7648c = new C10631(this);
                }
            });
            this.aP = ViewStubHolder.a((ViewStubCompat) a(2131564901));
            this.aP.a(new OnInflateListener<XMAContentContainer>(this) {
                final /* synthetic */ MessageItemView f7080a;

                {
                    this.f7080a = r1;
                }

                public final void m6657a(View view) {
                    ((XMAContentContainer) view).setOnLongClickListener(new LongClickListener(this.f7080a));
                }
            });
            this.aQ = ViewStubHolder.a((ViewStubCompat) a(2131564899));
            if (this.av) {
                this.az = null;
                this.aA = null;
                this.aL = ViewStubHolder.a((ViewStubCompat) a(2131564155));
                this.aM = ViewStubHolder.a((ViewStubCompat) a(2131564937));
                this.aN = ViewStubHolder.a((ViewStubCompat) a(2131564936));
            } else {
                this.az = (UserTileView) a(2131564859);
                this.aA = ViewStubHolder.a((ViewStubCompat) a(2131564911));
                this.aL = null;
                this.aM = null;
                this.aN = null;
                if (this.f7121F == Product.MESSENGER) {
                    this.az.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ MessageItemView f7081a;

                        {
                            this.f7081a = r1;
                        }

                        public void onClick(View view) {
                            int a = Logger.a(2, EntryType.UI_INPUT_START, -503071506);
                            UserKey userKey = this.f7081a.bi.f4732a.e.b;
                            MessageItemView messageItemView = this.f7081a;
                            if (messageItemView.bg != null) {
                                messageItemView.bg.mo276a(view, userKey);
                            }
                            Logger.a(2, EntryType.UI_INPUT_END, 754573573, a);
                        }
                    });
                }
            }
            this.bc = this.az;
            setClickable(true);
            this.ak = ContextUtils.d(context, 2130773131, 0);
            this.al = ContextUtils.d(context, 2130773132, 0);
            this.am = ContextUtils.e(context, 2130773133, 0);
            this.an = ContextUtils.e(context, 2130773134, 0);
            this.ao = this.f7122G.getDimensionPixelOffset(2131428623);
            this.ap = this.f7122G.getDimensionPixelOffset(2131428622);
            this.at.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ MessageItemView f7082a;

                {
                    this.f7082a = r1;
                }

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1101631884);
                    MessageItemView messageItemView = this.f7082a;
                    if (messageItemView.bg != null && messageItemView.aw != null && messageItemView.aw.m6633c() == 0.0f) {
                        messageItemView.bg.mo304f(messageItemView.bi);
                    } else if (!(messageItemView.bi == null || MessageUtil.Q(messageItemView.bi.f4732a) || messageItemView.bg == null)) {
                        messageItemView.bg.mo284a(messageItemView.bi);
                    }
                    Logger.a(2, EntryType.UI_INPUT_END, 1973307102, a);
                }
            });
            this.at.setOnLongClickListener(new LongClickListener(this));
            this.bp = new ActionReceiver(this) {
                final /* synthetic */ MessageItemView f7084a;

                {
                    this.f7084a = r1;
                }

                public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                    int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1538218523);
                    if ("com.facebook.orca.stickers.STICKER_CONFIG_CHANGED".equals(intent.getAction())) {
                        String str = this.f7084a.bi.f4732a.k;
                        MessageItemView.m6713S(this.f7084a);
                    }
                    Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 514510429, a);
                }
            };
            if (this.av) {
                Drawable a = this.f7119D.m6981a(this.f7122G.getDrawable(2130841996), this.f7122G.getDrawable(2130841514));
                a.m6980a(1.0f);
                this.ax = a;
            } else {
                this.ax = this.f7122G.getDrawable(2130841514);
            }
            this.ax.setColorFilter(this.f7122G.getColor(this.av ? 2131362327 : 2131362325), Mode.MULTIPLY);
            this.aw = new MessageItemForegroundDrawable(getContext());
            this.at.setForeground(this.aw);
            this.bs = new BubbleCornerRadius();
        } finally {
            TracerDetour.a(222235500);
        }
    }

    public void setThreadViewTheme(DefaultThreadViewTheme defaultThreadViewTheme) {
        if (this.bd != defaultThreadViewTheme) {
            if (this.bd != null) {
                this.bd.b(this.aU);
            }
            this.bd = defaultThreadViewTheme;
            if (this.bd != null) {
                this.bd.a(this.aU);
                m6738e(this);
            }
        }
    }

    public static void m6738e(MessageItemView messageItemView) {
        if (messageItemView.bd != null) {
            int c;
            SenderType senderType = messageItemView.av ? SenderType.ME : SenderType.OTHER;
            Message message = messageItemView.bi != null ? messageItemView.bi.f4732a : null;
            int a = messageItemView.bd.a(messageItemView.m6741g(message), senderType);
            if (!messageItemView.f7134S.a(message) || message == null || ThreadKey.g(message.b)) {
                c = messageItemView.bd.c(senderType);
            } else {
                c = messageItemView.bd.b(senderType);
            }
            messageItemView.ax.mutate().setColorFilter(a, Mode.MULTIPLY);
            messageItemView.ax.invalidateSelf();
            messageItemView.au.setTextColor(c);
            messageItemView.au.setLinkTextColor(c);
            messageItemView.aw.f7059b.a(messageItemView.bd.f());
            int d = messageItemView.bd.d();
            if (messageItemView.aA != null && messageItemView.aA.c()) {
                ((TextView) messageItemView.aA.a()).setTextColor(d);
            }
            if (messageItemView.aZ != null) {
                messageItemView.aZ.setTextColor(d);
            }
            if (messageItemView.aW != null) {
                messageItemView.aW.setTextColor(d);
            }
            if (messageItemView.aN != null && messageItemView.aN.c()) {
                int e;
                DefaultThreadViewTheme defaultThreadViewTheme = messageItemView.bd;
                if (message == null) {
                    e = defaultThreadViewTheme.e();
                } else if (ThreadKey.d(message.b)) {
                    e = defaultThreadViewTheme.a(BubbleType.NORMAL, SenderType.ME);
                } else if (ThreadKey.g(message.b)) {
                    e = defaultThreadViewTheme.a(BubbleType.TINCAN, SenderType.ME);
                } else if (defaultThreadViewTheme.a.a(message)) {
                    e = defaultThreadViewTheme.a(BubbleType.EPHEMERAL, SenderType.ME);
                } else {
                    e = defaultThreadViewTheme.e();
                }
                ((DeliveryStatusView) messageItemView.aN.a()).setTintColor(e);
            }
            if (messageItemView.aE.d()) {
                ((ThreadViewAudioAttachmentView) messageItemView.aE.a()).setColor(a);
            }
            if (messageItemView.bi != null) {
                messageItemView.m6696B();
            }
        }
    }

    private void m6739f() {
        if (!this.f7134S.a()) {
            Message message = this.bi.f4732a;
            m6743i(this);
            if (!this.f7134S.a(message)) {
                m6742g();
            } else if (!EphemeralProgressUtil.d(message)) {
                if (this.bh == null) {
                    this.bh = new Object(this) {
                        final /* synthetic */ MessageItemView f7085a;

                        {
                            this.f7085a = r1;
                        }

                        public final void m6658a(int i) {
                            String str;
                            MessageItemGutterView messageItemGutterView = (MessageItemGutterView) this.f7085a.aH.a();
                            this.f7085a.ah.get();
                            int d = (int) (TimeConversions.d((long) i) % 60);
                            int m = (int) (TimeConversions.m((long) i) % 60);
                            StringBuilder stringBuilder = new StringBuilder();
                            if (d < 10) {
                                str = "0";
                            } else {
                                str = "";
                            }
                            StringBuilder append = stringBuilder.append(str).append(d).append(":");
                            if (m < 10) {
                                str = "0";
                            } else {
                                str = "";
                            }
                            messageItemGutterView.m6642a(append.append(str).append(m).toString());
                            if (i <= 0 && this.f7085a.bg != null) {
                                ((MessageItemGutterView) this.f7085a.aH.a()).m6645f();
                                this.f7085a.bg.mo275a(this.f7085a.at);
                                MessageItemView.m6743i(this.f7085a);
                            }
                        }
                    };
                }
                ((EphemeralMessageProgressManager) this.f7133R.get()).b();
                ((EphemeralMessageProgressManager) this.f7133R.get()).a();
                ((EphemeralMessageProgressManager) this.f7133R.get()).a(this.bh);
                ((EphemeralMessageProgressManager) this.f7133R.get()).a(message);
            }
        }
    }

    private void m6742g() {
        if (this.bh != null) {
            ((EphemeralMessageProgressManager) this.f7133R.get()).b();
            ((EphemeralMessageProgressManager) this.f7133R.get()).a();
            this.bh = null;
        }
    }

    public static void m6743i(MessageItemView messageItemView) {
        if (messageItemView.aw != null) {
            if (messageItemView.f7138W.c(messageItemView.bi.f4732a)) {
                messageItemView.m6747m();
                messageItemView.aw.m6629a(true);
                messageItemView.aw.m6627a(messageItemView.f7122G.getColor(2131362331));
                messageItemView.aw.m6631b(messageItemView.aw.f7059b.b.getColor());
                messageItemView.at.setForeground(messageItemView.aw);
                messageItemView.bx = true;
                return;
            }
            messageItemView.aw.m6631b(0);
            messageItemView.bx = false;
        }
    }

    public void setRowMessageItem(@Nullable RowMessageItem rowMessageItem) {
        if (rowMessageItem != this.bi) {
            TracerDetour.a("setRowMessageItem", 1545179462);
            try {
                if (this.bi != null) {
                    if (this.bi.m4311j() == this.by) {
                        this.bi.m4303a(null);
                    }
                    this.f7120E.b(this.bi.f4732a.e.b, this.bz);
                }
                this.bi = rowMessageItem;
                if (this.bm != null) {
                    this.bm.c(this.bn);
                }
                if (this.bi != null) {
                    this.bi.m4303a(this.by);
                    this.f7120E.a(this.bi.f4732a.e.b, this.bz);
                    if (this.bi.m4308c().D) {
                        this.f7158t.b(this.bi.m4308c());
                    }
                    if (this.aw != null) {
                        this.aw.m6628a(this.f7151m.a(this.bi.f4732a));
                        this.aw.m6630b(this.bi.m4310e());
                    }
                }
                m6744j();
                this.bq = this.bi.m4308c();
            } finally {
                TracerDetour.a(1529952632);
            }
        } else if (rowMessageItem != null) {
            ai(this);
            m6714T();
            m6719Z();
            boolean z = this.aF.d() && !this.f7127L.m7360a() && ((ThreadViewImageAttachmentView) this.aF.a()).m7316a();
            if (z) {
                ((ThreadViewImageAttachmentView) this.aF.a()).setNeedsUserRequestToLoad(false);
                m6711Q(this);
            }
        }
    }

    public /* bridge */ /* synthetic */ Object getDataItem() {
        return this.bi;
    }

    public final void mo265a(Set<String> set) {
        if (set.contains(this.bi.f4732a.n) && this.aG.c()) {
            ((ThreadViewVideoAttachmentView) this.aG.a()).m8043b();
        }
    }

    public final void mo267d() {
        if (this.aG.c()) {
            ((ThreadViewVideoAttachmentView) this.aG.a()).f8089O;
        }
    }

    final void m6758a(@Nullable Parcelable parcelable) {
        if (this.bg != null) {
            this.bg.mo283a(this.bi, parcelable);
        }
    }

    public final void mo242a(ImageAttachmentData imageAttachmentData) {
        if (this.bg != null && !aB()) {
            this.bg.mo286a(this.bi, imageAttachmentData);
        }
    }

    public final void mo243b(ImageAttachmentData imageAttachmentData) {
        m6758a((Parcelable) imageAttachmentData);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1785332869);
        super.onAttachedToWindow();
        m6713S(this);
        if (m6699E()) {
            m6701G();
        }
        if (this.f7131P.b()) {
            if (this.br == null) {
                this.br = ((BaseFbBroadcastManager) this.f7155q.get()).a().a(MessagesBroadcastIntents.b, new ActionReceiver(this) {
                    final /* synthetic */ MessageItemView f7103a;

                    {
                        this.f7103a = r1;
                    }

                    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 101085416);
                        this.f7103a.m6722a(intent);
                        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1598892348, a);
                    }
                }).a(MessagesBroadcastIntents.d, new ActionReceiver(this) {
                    final /* synthetic */ MessageItemView f7102a;

                    {
                        this.f7102a = r1;
                    }

                    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -329865754);
                        MessageItemView messageItemView = this.f7102a;
                        ThreadKey b = messageItemView.f7131P.b(messageItemView.bi.f4732a.b);
                        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("multiple_thread_keys");
                        if (b != null && parcelableArrayListExtra.contains(b)) {
                            MessageItemView.m6727a(messageItemView, messageItemView.az);
                        }
                        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 694627266, a);
                    }
                }).a();
            }
            this.br.b();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 669264230, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1814589561);
        super.onDetachedFromWindow();
        if (this.bi != null) {
            this.bi.f4747p = null;
            this.f7120E.b(this.bi.f4732a.e.b, this.bz);
        }
        m6742g();
        m6702H();
        if (this.br != null) {
            this.br.c();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1905898008, a);
    }

    protected void dispatchSetPressed(boolean z) {
    }

    private void m6744j() {
        if (this.bi != null) {
            TracerDetour.a("MessageItemView.update", -982357160);
            try {
                AnalyticsTagger.a(this.as);
                this.au.setOnClickListener(null);
                this.au.setClickable(false);
                m6746l();
                if (m6745k()) {
                    m6749o();
                    m6752u();
                    m6754w();
                    m6757z();
                    m6696B();
                    m6703I();
                    m6707M();
                    m6709O();
                    m6710P();
                    m6713S(this);
                    m6714T();
                    m6716V();
                }
                m6750s(this);
                if (az()) {
                    ay();
                }
                m6751t(this);
                ab();
                ac(this);
                ae(this);
                ag(this);
                ap();
                ar();
                an();
                ai(this);
                m6719Z();
                as();
                m6705K();
                m6738e(this);
                m6739f();
            } finally {
                TracerDetour.a(356490678);
            }
        }
    }

    private boolean m6745k() {
        Message message = this.bi.f4732a;
        return this.bq == null || message == null || !this.bq.a.equals(this.bi.f4732a.a) || !Objects.equal(this.bq.f, this.bi.f4732a.f) || MessageUtil.f(this.bq) || MessageUtil.f(message) || MessageUtil.d(this.bq, message);
    }

    private void m6746l() {
        TracerDetour.a("MessageVisualStyle", -798320180);
        try {
            Boolean b;
            Boolean c;
            Message message = this.bi.f4732a;
            Boolean bool;
            if (((Boolean) this.f7147i.get()).booleanValue() && MessageUtil.U(message)) {
                Entry a = this.f7123H.m7030a(message);
                b = a.m7024b();
                c = a.m7026c();
                if (b == null || c == null) {
                    boolean a2 = m6730a(message);
                    if (b == null) {
                        b = a.m7025b(Boolean.valueOf(m6731a(a2)));
                    }
                    if (c == null) {
                        c = a.m7027c(Boolean.valueOf(m6735b(a2)));
                    }
                }
                bool = c;
                c = b;
                b = bool;
            } else {
                boolean a3 = m6730a(message);
                b = Boolean.valueOf(m6731a(a3));
                bool = Boolean.valueOf(m6735b(a3));
                c = b;
                b = bool;
            }
            this.at.setBackgroundDrawable(c.booleanValue() ? this.ax : this.ay);
            if (b.booleanValue()) {
                this.aw.m6627a(m6748n() ? 0 : this.f7122G.getColor(2131362331));
            }
            if (this.aw != null) {
                m6747m();
                this.aw.m6629a(b.booleanValue());
            }
            TracerDetour.a(846322753);
        } catch (Throwable th) {
            TracerDetour.a(1861092104);
        }
    }

    private boolean m6731a(boolean z) {
        Message message = this.bi.f4732a;
        return !(!MessageUtil.A(message) || z || m6699E()) || m6704J() || this.f7142d.h(message) || m6753v();
    }

    private boolean m6735b(boolean z) {
        Object obj;
        boolean E = m6699E();
        ImmutableList immutableList = this.bi.f4732a.i;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            Attachment attachment = (Attachment) immutableList.get(i);
            if (attachment.g != null && attachment.g.f) {
                obj = 1;
                break;
            }
        }
        obj = null;
        return (z || E || (!MessageUtil.A(this.bi.f4732a) && obj != null)) ? false : true;
    }

    private void m6747m() {
        this.f7162x.m7020a(this.av, this.bi.f4737f, this.bs);
        float f = (float) this.bs.f7366a;
        float f2 = (float) this.bs.f7367b;
        float f3 = (float) this.bs.f7368c;
        float f4 = (float) this.bs.f7369d;
        this.aw.f7059b.a(f, f2, f3, f4);
    }

    private boolean m6748n() {
        boolean z;
        Message message = this.bi.f4732a;
        boolean z2;
        if (this.f7156r.a(message) == MessageClassification.NORMAL) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (message.G != null) {
            z = true;
        } else {
            z = false;
        }
        if (z || (!r0 && this.f7142d.f(message).size() <= 1)) {
            return false;
        }
        return true;
    }

    private boolean m6730a(Message message) {
        if (!((Boolean) this.f7147i.get()).booleanValue()) {
            return this.f7159u.c(message);
        }
        Entry a = this.f7123H.m7030a(this.bi.f4732a);
        Boolean bool = a.f7374a;
        if (bool == null) {
            a.f7374a = Boolean.valueOf(this.f7159u.c(message));
            bool = a.f7374a;
        }
        return bool.booleanValue();
    }

    private void m6749o() {
        Object obj = null;
        TracerDetour.a("MessageText", 192697113);
        try {
            Message message = this.bi.f4732a;
            if (!(!MessageUtil.A(message) || m6699E() || MessageUtil.u(message))) {
                obj = 1;
            }
            if (obj == null) {
                this.bj = false;
                this.au.setVisibility(8);
                return;
            }
            this.au.setText(m6732b(message));
            this.au.setVisibility(0);
            TracerDetour.a(-947380760);
        } finally {
            TracerDetour.a(-585350160);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.text.Spannable m6732b(com.facebook.messaging.model.messages.Message r15) {
        /*
        r14 = this;
        r1 = r14.m6730a(r15);
        if (r1 == 0) goto L_0x0080;
    L_0x0006:
        r0 = r14.f7159u;
        r0 = r0.b(r15);
    L_0x000c:
        r9 = 0;
        if (r1 == 0) goto L_0x008c;
    L_0x000f:
        r6 = r14.au;
        r6.setPadding(r9, r9, r9, r9);
        r6 = r14.au;
        r7 = r14.f7122G;
        r8 = 2131428618; // 0x7f0b050a float:1.8478886E38 double:1.0530656567E-314;
        r7 = r7.getDimension(r8);
        r6.setTextSize(r9, r7);
    L_0x0022:
        r1 = android.text.Spannable.Factory.getInstance();
        r1 = r1.newSpannable(r0);
        r0 = r14.f7149k;
        r2 = r15.b;
        r0 = r0.a(r2);
        r2 = r15.b;
        r2 = com.facebook.messaging.model.threadkey.ThreadKey.d(r2);
        if (r2 != 0) goto L_0x0045;
    L_0x003a:
        r2 = r14.f7118C;
        if (r0 != 0) goto L_0x0087;
    L_0x003e:
        r0 = 0;
    L_0x003f:
        r0 = r2.a(r1, r0);
        if (r0 != 0) goto L_0x004d;
    L_0x0045:
        r0 = 15;
        r0 = com.facebook.text.linkify.SafeLinkifier.a(r1, r0);
        if (r0 == 0) goto L_0x008a;
    L_0x004d:
        r0 = 1;
    L_0x004e:
        r14.bj = r0;
        r0 = r14.f7118C;
        r2 = new com.facebook.orca.threadview.MessageItemView$23;
        r2.<init>(r14);
        r0.a = r2;
        r0 = r15.b;
        if (r0 == 0) goto L_0x006f;
    L_0x005d:
        r0 = r14.f7135T;
        r2 = r14.getContext();
        r3 = r15.b;
        r0.a(r2, r3, r1);
        r0 = r14.f7136U;
        r2 = r15.b;
        r0.a(r1, r2);
    L_0x006f:
        r0 = r14.f7140b;
        r2 = "Prefetch Span URIs";
        r3 = new com.facebook.orca.threadview.MessageItemView$24;
        r3.<init>(r14, r1);
        r4 = com.facebook.common.appchoreographer.AppChoreographer.Priority.APPLICATION_LOADED_UI_IDLE;
        r5 = com.facebook.common.appchoreographer.AppChoreographer.ThreadType.UI;
        r0.a(r2, r3, r4, r5);
        return r1;
    L_0x0080:
        r0 = r14.f7159u;
        r0 = r0.a(r15);
        goto L_0x000c;
    L_0x0087:
        r0 = r0.h;
        goto L_0x003f;
    L_0x008a:
        r0 = 0;
        goto L_0x004e;
    L_0x008c:
        r10 = r14.f7137V;
        r10 = r10.get();
        r10 = (java.lang.Boolean) r10;
        r10 = r10.booleanValue();
        if (r10 == 0) goto L_0x00c2;
    L_0x009a:
        r10 = r14.f7122G;
        r11 = 2131427854; // 0x7f0b020e float:1.8477336E38 double:1.0530652793E-314;
        r10 = r10.getDimensionPixelSize(r11);
    L_0x00a3:
        r11 = r14.f7122G;
        r12 = 2131428582; // 0x7f0b04e6 float:1.8478813E38 double:1.053065639E-314;
        r11 = r11.getDimensionPixelOffset(r12);
        r12 = r14.au;
        r12.setPadding(r10, r11, r10, r11);
        r10 = r14.au;
        r11 = 0;
        r12 = r14.f7122G;
        r13 = 2131428618; // 0x7f0b050a float:1.8478886E38 double:1.0530656567E-314;
        r12 = r12.getDimension(r13);
        r10.setTextSize(r11, r12);
        goto L_0x0022;
    L_0x00c2:
        r10 = r14.f7122G;
        r11 = 2131428583; // 0x7f0b04e7 float:1.8478815E38 double:1.0530656394E-314;
        r10 = r10.getDimensionPixelSize(r11);
        goto L_0x00a3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.threadview.MessageItemView.b(com.facebook.messaging.model.messages.Message):android.text.Spannable");
    }

    public static void m6750s(MessageItemView messageItemView) {
        if (!messageItemView.av) {
            TracerDetour.a("UserBadging", -99605752);
            try {
                Message message = messageItemView.bi.f4732a;
                ParticipantInfo participantInfo = message.e;
                UserTileViewParams a = messageItemView.f7117B.a(participantInfo.b, participantInfo.c, message.b);
                if (!a.equals(messageItemView.bt)) {
                    messageItemView.bt = a;
                    messageItemView.az.setParams(messageItemView.bt);
                }
                TracerDetour.a(-1196197933);
            } catch (Throwable th) {
                TracerDetour.a(1137083653);
            }
        }
    }

    public static void m6751t(MessageItemView messageItemView) {
        TracerDetour.a("UserIdentification", 2028609158);
        try {
            if (!messageItemView.av) {
                Message message = messageItemView.bi.f4732a;
                boolean E = messageItemView.m6699E();
                Object obj = (StickerUtil.a(message.k) || messageItemView.f7146h.a(message)) ? 1 : null;
                LayoutParams layoutParams = (LayoutParams) messageItemView.bc.getLayoutParams();
                if (E && obj == null) {
                    layoutParams.gravity = 19;
                } else {
                    layoutParams.gravity = 83;
                }
                m6724a(messageItemView.bc, messageItemView.bi.f4737f.groupWithNewerRow ? messageItemView.ak : 0);
                int i;
                if (messageItemView.bi.f4737f.groupWithOlderRow) {
                    i = messageItemView.al;
                } else {
                    i = 0;
                }
                if (messageItemView.m6740f(message) && r0 == 0 && !E) {
                    CharSequence valueOf = SpannableStringBuilder.valueOf(messageItemView.f7149k.b(message.b, message.e));
                    ((EmojiUtil) messageItemView.f7148j.get()).a(valueOf, (int) ((TextView) messageItemView.aA.a()).getTextSize());
                    ((TextView) messageItemView.aA.a()).setText(valueOf);
                    messageItemView.aA.f();
                } else {
                    messageItemView.aA.e();
                }
                TracerDetour.a(-1156380228);
            }
        } finally {
            TracerDetour.a(-1760742277);
        }
    }

    private void m6752u() {
        TracerDetour.a("AudioAttachment", -2019525655);
        try {
            if (m6753v()) {
                ((ThreadViewAudioAttachmentView) this.aE.a()).setAudioAttachmentData(this.f7142d.g(this.bi.f4732a));
                ((ThreadViewAudioAttachmentView) this.aE.a()).setHasText(MessageUtil.A(this.bi.f4732a));
                this.bg.mo303f();
                this.aE.f();
                TracerDetour.a(-941110002);
                return;
            }
            this.aE.e();
        } finally {
            TracerDetour.a(-1705905021);
        }
    }

    private boolean m6753v() {
        return this.f7156r.a(this.bi.f4732a) == MessageClassification.AUDIO_CLIP;
    }

    private void m6754w() {
        Object obj = 1;
        TracerDetour.a("MessageItemView.showVideoAttachment", -140539910);
        try {
            if (m6756y()) {
                VideoAttachmentData j = this.f7142d.j(this.bi.f4732a);
                if (j.j == null) {
                    obj = null;
                }
                if (this.f7127L.m7360a() && r0 == null) {
                    m6723a(j.g);
                    ((ThreadViewVideoAttachmentView) this.aG.a()).setNeedsUserRequestToLoad(true);
                } else {
                    ((ThreadViewVideoAttachmentView) this.aG.a()).setNeedsUserRequestToLoad(false);
                }
                m6755x(this);
                TracerDetour.a(149985455);
                return;
            }
            this.aG.e();
            if (this.aG.c()) {
                ((ThreadViewVideoAttachmentView) this.aG.a()).setMessage(null);
            }
            AnalyticsTagger.a(this.at);
        } finally {
            TracerDetour.a(1351795811);
        }
    }

    private void m6723a(Uri uri) {
        ImagePipeline imagePipeline = this.f7126K;
        ImageRequestBuilder a = ImageRequestBuilder.a(uri);
        a.b = RequestLevel.DISK_CACHE;
        this.bn = imagePipeline.d(a.m(), getContext());
        this.bm = new BaseDataSubscriber<CloseableReference<PooledByteBuffer>>(this) {
            final /* synthetic */ MessageItemView f7091a;

            {
                this.f7091a = r1;
            }

            public final void m6673e(DataSource<CloseableReference<PooledByteBuffer>> dataSource) {
                if (!dataSource.b()) {
                    return;
                }
                if (dataSource.c()) {
                    ((CloseableReference) dataSource.d()).close();
                    ((ThreadViewVideoAttachmentView) this.f7091a.aG.a()).setNeedsUserRequestToLoad(false);
                    MessageItemView.m6755x(this.f7091a);
                    MessageItemView.ai(this.f7091a);
                    return;
                }
                ((ThreadViewVideoAttachmentView) this.f7091a.aG.a()).setNeedsUserRequestToLoad(true);
                MessageItemView.m6755x(this.f7091a);
                MessageItemView.ai(this.f7091a);
            }

            public final void m6674f(DataSource<CloseableReference<PooledByteBuffer>> dataSource) {
            }
        };
        if (this.bn != null) {
            this.bn.a(this.bm, this.f7150l);
        }
    }

    public static void m6755x(MessageItemView messageItemView) {
        Message message = messageItemView.bi.f4732a;
        messageItemView.aG.f();
        ((ThreadViewVideoAttachmentView) messageItemView.aG.a()).setMessage(message);
        if (((ThreadViewVideoAttachmentView) messageItemView.aG.a()).f8096V) {
            ((ThreadViewVideoAttachmentView) messageItemView.aG.a()).setOnLoadClickListener(new OnClickListener(messageItemView) {
                final /* synthetic */ MessageItemView f7092a;

                {
                    this.f7092a = r1;
                }

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 161367699);
                    MessageItemView messageItemView = this.f7092a;
                    ((ThreadViewVideoAttachmentView) messageItemView.aG.a()).setNeedsUserRequestToLoad(false);
                    MessageItemView.m6755x(messageItemView);
                    MessageItemView.ai(messageItemView);
                    Logger.a(2, EntryType.UI_INPUT_END, -1401112146, a);
                }
            });
        }
    }

    private boolean m6756y() {
        Message message = this.bi.f4732a;
        return this.f7157s.b(message) || this.f7157s.c(message);
    }

    private void m6757z() {
        int i = ((m6753v() || m6756y()) && this.f7127L.m7360a() && this.bi.f4732a.i != null && this.bi.f4732a.i.size() > 0) ? 1 : 0;
        if (i == 0) {
            m6724a(this.aY, 8);
            return;
        }
        String string;
        if (this.aY == null) {
            FbTextView fbTextView = (FbTextView) LayoutInflater.from(getContext()).inflate(2130905726, this, false);
            fbTextView.setGravity(this.av ? 5 : 3);
            this.aY = fbTextView;
            addView(this.aY);
        }
        FbTextView fbTextView2 = this.aY;
        FileSizeUtil fileSizeUtil = this.f7128M;
        i = ((Attachment) this.bi.f4732a.i.get(0)).f;
        if (i < 2048) {
            string = fileSizeUtil.a.getString(2131235905, new Object[]{Integer.valueOf(i)});
        } else {
            int i2 = i / 1024;
            if (i2 < 2048) {
                string = fileSizeUtil.a.getString(2131235906, new Object[]{Integer.valueOf(i2)});
            } else {
                i2 /= 1024;
                string = fileSizeUtil.a.getString(2131235907, new Object[]{Integer.valueOf(i2)});
            }
        }
        fbTextView2.setText(string);
        this.aY.setVisibility(0);
    }

    private void m6696B() {
        int i = 0;
        int i2 = -1;
        TracerDetour.a("Sticker", 2036650653);
        try {
            if (m6699E()) {
                m6701G();
                if (this.bd != null) {
                    i2 = this.bd.f();
                } else {
                    Optional a = ContextUtils.a(getContext(), 2130773063);
                    if (a.isPresent() && ((Integer) a.get()).intValue() != 0) {
                        i2 = ContextUtils.c(getContext(), 2130773063, -1);
                    }
                }
                StickerDraweeView stickerDraweeView = (StickerDraweeView) this.aD.a();
                this.aD.f();
                Message message = this.bi.f4732a;
                final RowMessageItem rowMessageItem = this.bi;
                stickerDraweeView.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ MessageItemView f7094b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 1385955754);
                        if (this.f7094b.bg != null) {
                            this.f7094b.bg.mo300d(rowMessageItem);
                        }
                        Logger.a(2, EntryType.UI_INPUT_END, 1925622050, a);
                    }
                });
                if (this.bu != null && this.bu.equals(message.k) && this.bv == i2 && stickerDraweeView.b()) {
                    Animatable g = stickerDraweeView.getController().g();
                    if (g != null) {
                        setOnStickerImageReady(this, g);
                        TracerDetour.a(2068602287);
                        return;
                    }
                }
                stickerDraweeView.setController(null);
                int customLikeEmojiResourceId = getCustomLikeEmojiResourceId();
                if (customLikeEmojiResourceId != 0) {
                    float f;
                    stickerDraweeView.setDrawableResourceId(customLikeEmojiResourceId);
                    stickerDraweeView.setColorFilter(0);
                    if (m6697C()) {
                        f = HotLikesSpringConfig.SMALL.sizeEndValue;
                    } else if (m6698D()) {
                        f = HotLikesSpringConfig.MEDIUM.sizeEndValue;
                    } else {
                        f = HotLikesSpringConfig.LARGE.sizeEndValue;
                    }
                    i = (int) (HotLikesSpringConfig.convertSizeEndValueForHotEmojilikes(f) * ((float) this.f7122G.getDimensionPixelSize(2131428039)));
                    LayoutParamsUtil.a(stickerDraweeView, i, i);
                } else {
                    stickerDraweeView.a(message.k, i2, ae, this.bA);
                    this.bu = message.k;
                    this.bv = i2;
                    if (MessageUtil.R(message) && this.bd != null) {
                        BubbleType bubbleType = BubbleType.NORMAL;
                        if (ThreadKey.g(message.b)) {
                            bubbleType = BubbleType.TINCAN;
                        } else if (this.f7134S.a(message)) {
                            bubbleType = BubbleType.EPHEMERAL;
                        }
                        i = this.bd.a(bubbleType);
                    }
                    stickerDraweeView.setColorFilter(i);
                }
                TracerDetour.a(-2092695576);
                return;
            }
            m6702H();
            this.aD.e();
        } finally {
            TracerDetour.a(-2136324490);
        }
    }

    private int getCustomLikeEmojiResourceId() {
        Object obj;
        if (!((Boolean) this.f7145g.get()).booleanValue()) {
            obj = null;
        } else if (((Boolean) this.f7152n.get()).booleanValue() && this.f7146h.a(this.bi.f4732a)) {
            r3 = 1;
        } else if (this.bd == null || ((Boolean) this.f7152n.get()).booleanValue() || StringUtil.a(this.bd.g()) || !MessageUtil.R(this.bi.f4732a)) {
            obj = null;
        } else {
            r3 = 1;
        }
        if (obj == null) {
            return 0;
        }
        String str;
        if (((Boolean) this.f7152n.get()).booleanValue() && this.f7146h.a(this.bi.f4732a)) {
            str = this.bi.f4732a.f;
        } else {
            str = this.bd.g();
        }
        if (((EmojiUtil) this.f7148j.get()).a(str) != null) {
            return ((BigEmojis) this.f7144f.get()).a();
        }
        return 0;
    }

    private boolean m6697C() {
        if (!((Boolean) this.f7152n.get()).booleanValue()) {
            return "369239263222822".equals(this.bi.f4732a.k);
        }
        return "small".equals(this.f7146h.b(this.bi.f4732a));
    }

    private boolean m6698D() {
        if (!((Boolean) this.f7152n.get()).booleanValue()) {
            return "369239343222814".equals(this.bi.f4732a.k);
        }
        return "medium".equals(this.f7146h.b(this.bi.f4732a));
    }

    private boolean m6699E() {
        return MessageUtil.Q(this.bi.f4732a) || m6700F();
    }

    private boolean m6700F() {
        return getCustomLikeEmojiResourceId() != 0;
    }

    public static void setOnStickerImageReady(MessageItemView messageItemView, Animatable animatable) {
        if (messageItemView.bg != null) {
            Preconditions.checkArgument(animatable instanceof AnimatableDrawable, "Animatable an instance of " + animatable.getClass().getName());
            messageItemView.bg.mo285a(messageItemView.bi, (AnimatableDrawable) animatable);
        }
    }

    private void m6701G() {
        if (this.bo == null) {
            this.bo = ((BaseFbBroadcastManager) this.f7155q.get()).a().a("com.facebook.orca.stickers.STICKER_CONFIG_CHANGED", this.bp).a();
        }
        if (!this.bo.a()) {
            this.bo.b();
        }
    }

    private void m6702H() {
        if (this.bo != null && this.bo.a()) {
            this.bo.c();
        }
    }

    private void m6703I() {
        TracerDetour.a("ShareAttachment", 780566951);
        try {
            Message message = this.bi.f4732a;
            if (!m6704J() || message.D) {
                this.aB.e();
                AnalyticsTagger.a(this.at);
            } else {
                Share T = MessageUtil.T(message);
                this.f7139a.a(this.at, "share_thread_view", getClass());
                ShareView shareView = (ShareView) this.aB.a();
                if (T.f != null) {
                    this.f7141c.a(Uri.parse(T.f));
                }
                this.f7139a.a(shareView, "share_thread_view", getClass());
                shareView.setListener(new ShareView.Listener(this) {
                    final /* synthetic */ MessageItemView f7095a;

                    {
                        this.f7095a = r1;
                    }

                    public final void mo263a(Share share) {
                        if (this.f7095a.bg != null) {
                            this.f7095a.bg.mo287a(this.f7095a.bi, share);
                        }
                    }

                    public final void mo264b(Share share) {
                        this.f7095a.m6758a((Parcelable) share);
                    }

                    public final void mo262a() {
                        if (this.f7095a.bg != null) {
                            MessageListAdapter.Listener listener = this.f7095a.bg;
                            RowMessageItem rowMessageItem = this.f7095a.bi;
                            listener.mo296c();
                        }
                    }
                });
                shareView.getLayoutParams().width = -2;
                shareView.setVisibility(0);
                shareView.setShareNameTextColor(this.au.getCurrentTextColor());
                shareView.setShowDividingLine(MessageUtil.A(message));
                shareView.setShare(T);
            }
            TracerDetour.a(1102582231);
        } catch (Throwable th) {
            TracerDetour.a(1767030129);
        }
    }

    private boolean m6704J() {
        boolean z;
        if (MessageUtil.T(this.bi.f4732a) != null) {
            z = true;
        } else {
            z = false;
        }
        boolean z2;
        if (this.bi.f4732a.G != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z || aq() || r3 || m6706L() || ao() || m6756y()) {
            return false;
        }
        return true;
    }

    private void m6705K() {
        Share share = null;
        Message message = this.bi.f4732a;
        if (m6706L()) {
            this.aQ.f();
            if (message != null) {
                share = MessageUtil.T(message);
            }
            ((MomentsInviteView) this.aQ.a()).setModelFromShare(share);
            return;
        }
        if (this.aQ.c()) {
            ((MomentsInviteView) this.aQ.a()).setModelFromShare(null);
            this.aQ.e();
        }
        AnalyticsTagger.a(this.at);
    }

    private boolean m6706L() {
        if (this.bi.f4732a.G != null) {
            return false;
        }
        if (this.f7156r.a(this.bi.f4732a) == MessageClassification.MOMENTS_INVITE) {
            return true;
        }
        return false;
    }

    private void m6707M() {
        TracerDetour.a("StoryAttachment", -755666820);
        try {
            if (this.bf != null) {
                ((XMAContentContainer) this.aP.a()).removeView(this.ba);
                this.bf.a(this.ba);
                this.bf = null;
                if (this.ba instanceof XMAView) {
                    ((XMAView) this.ba).setXMACallback(null);
                }
                this.ba = null;
            }
            if (m6708N()) {
                XMAModel xMAModel = this.bi.f4732a.G;
                this.bf = ((StyleRendererManager) this.af.get()).a(xMAModel.c().aN_());
                this.ba = this.bf.a((ViewGroup) this.aP.a(), xMAModel);
                if (this.ba instanceof XMAView) {
                    ((XMAView) this.ba).setXMACallback(this.aa.m6919a(this.bi.m4308c(), this.bl, this.ba, this.bg));
                }
                this.ba.setOnLongClickListener(new LongClickListener(this));
                ((XMAContentContainer) this.aP.a()).addView(this.ba);
                this.aP.f();
                TracerDetour.a(-793080346);
                return;
            }
            this.aP.e();
        } finally {
            TracerDetour.a(1251106076);
        }
    }

    private boolean m6708N() {
        return (this.bi.f4732a.G == null || aq() || m6756y()) ? false : true;
    }

    private void m6709O() {
        TracerDetour.a("OtherAttachments", 1614555200);
        try {
            if (this.f7142d.h(this.bi.f4732a)) {
                ((ThreadViewOtherAttachmentsView) this.aI.a()).setMessage(this.bi.f4732a);
                ((ThreadViewOtherAttachmentsView) this.aI.a()).m7898a(this);
                this.aI.f();
                TracerDetour.a(509286914);
                return;
            }
            this.aI.e();
        } finally {
            TracerDetour.a(-1207743978);
        }
    }

    private void m6710P() {
        TracerDetour.a("InlineImage", -811103700);
        try {
            if (m6712R()) {
                ImmutableList f = this.f7142d.f(this.bi.f4732a);
                Object obj = !f.isEmpty() ? ((ImageAttachmentData) f.get(0)).f != null ? 1 : null : null;
                if (this.f7127L.m7360a() && r0 == null) {
                    ImageRequest a = ThreadViewLowDataModeUtils.m7357a((ImageAttachmentData) this.f7142d.f(this.bi.f4732a).get(0), this.f7142d.f(this.bi.f4732a).size());
                    if (a == null) {
                        ((ThreadViewImageAttachmentView) this.aF.a()).setNeedsUserRequestToLoad(false);
                    } else {
                        m6726a(a);
                        ((ThreadViewImageAttachmentView) this.aF.a()).setNeedsUserRequestToLoad(true);
                    }
                } else {
                    ((ThreadViewImageAttachmentView) this.aF.a()).setNeedsUserRequestToLoad(false);
                }
                m6711Q(this);
                TracerDetour.a(504745594);
                return;
            }
            this.aF.e();
        } finally {
            TracerDetour.a(1741263436);
        }
    }

    private void m6726a(ImageRequest imageRequest) {
        this.bn = this.f7126K.d(imageRequest, getContext());
        this.bm = new BaseDataSubscriber<CloseableReference<PooledByteBuffer>>(this) {
            final /* synthetic */ MessageItemView f7097a;

            {
                this.f7097a = r1;
            }

            public final void m6679e(DataSource<CloseableReference<PooledByteBuffer>> dataSource) {
                if (!dataSource.b()) {
                    return;
                }
                if (dataSource.c()) {
                    ((CloseableReference) dataSource.d()).close();
                    ((ThreadViewImageAttachmentView) this.f7097a.aF.a()).setNeedsUserRequestToLoad(false);
                    MessageItemView.m6711Q(this.f7097a);
                    MessageItemView.ai(this.f7097a);
                    return;
                }
                ((ThreadViewImageAttachmentView) this.f7097a.aF.a()).setNeedsUserRequestToLoad(true);
                MessageItemView.m6711Q(this.f7097a);
                MessageItemView.ai(this.f7097a);
            }

            public final void m6680f(DataSource<CloseableReference<PooledByteBuffer>> dataSource) {
            }
        };
        if (this.bn != null) {
            this.bn.a(this.bm, this.f7150l);
        }
    }

    public static void m6711Q(MessageItemView messageItemView) {
        ((ThreadViewImageAttachmentView) messageItemView.aF.a()).setMessage(messageItemView.bi.f4732a);
        ((ThreadViewImageAttachmentView) messageItemView.aF.a()).m7315a((ThreadImageClickListener) messageItemView);
        if (((ThreadViewImageAttachmentView) messageItemView.aF.a()).f7563B) {
            ((ThreadViewImageAttachmentView) messageItemView.aF.a()).setOnLoadClickListener(new OnClickListener(messageItemView) {
                final /* synthetic */ MessageItemView f7098a;

                {
                    this.f7098a = r1;
                }

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -284167015);
                    MessageItemView messageItemView = this.f7098a;
                    ((ThreadViewImageAttachmentView) messageItemView.aF.a()).setNeedsUserRequestToLoad(false);
                    MessageItemView.m6711Q(messageItemView);
                    MessageItemView.ai(messageItemView);
                    Logger.a(2, EntryType.UI_INPUT_END, -402490139, a);
                }
            });
        }
        messageItemView.aF.f();
    }

    private boolean m6712R() {
        return this.f7142d.a(this.bi.f4732a);
    }

    public static void m6713S(MessageItemView messageItemView) {
        TracerDetour.a("MessageAttribution", -399567249);
        try {
            Message message = messageItemView.bi.f4732a;
            AttributionSource a = messageItemView.f7129N.a(message, messageItemView.bi.m4312k(), messageItemView.bi.f4739h);
            if (a != AttributionSource.NONE) {
                messageItemView.f7143e.a((AttributionView) messageItemView.aO.a(), message, a);
                if (message.k == null) {
                    messageItemView.aO.f();
                }
            } else {
                messageItemView.aO.e();
            }
            TracerDetour.a(-1997886895);
        } catch (Throwable th) {
            TracerDetour.a(-2011691119);
        }
    }

    private void m6714T() {
        if (m6715U()) {
            if (StringUtil.a(this.f7125J.a(LowDataModePrefKeys.f3022b, null))) {
                this.f7130O.a(new HoneyClientEvent("low_data_mode_nux_first_seen"));
                this.f7125J.edit().a(LowDataModePrefKeys.f3022b, this.bi.f4732a.a).commit();
            }
            m6718X();
            this.aJ.f();
            return;
        }
        this.aJ.e();
    }

    private boolean m6715U() {
        if (!this.f7127L.m7360a()) {
            return false;
        }
        Object a = this.f7125J.a(LowDataModePrefKeys.f3022b, null);
        if (!StringUtil.a(a)) {
            return (m6712R() || m6756y()) && a.equals(this.bi.f4732a.a);
        } else {
            if (m6712R()) {
                return ((ThreadViewImageAttachmentView) this.aF.a()).f7563B;
            }
            return m6756y() && ((ThreadViewVideoAttachmentView) this.aG.a()).f8096V;
        }
    }

    private void m6716V() {
        TracerDetour.a("MessageItemView.updateMmsDownload", 586825512);
        try {
            if (m6717W()) {
                ((MmsDownloadView) this.aS.a()).setMessage(this.bi.f4732a);
                this.aS.f();
            } else {
                this.aS.e();
            }
            TracerDetour.a(24207870);
        } catch (Throwable th) {
            TracerDetour.a(-1077058777);
        }
    }

    private boolean m6717W() {
        return this.bi.f4732a.L.a();
    }

    private void m6718X() {
        ThreadViewLowDataModeNuxView threadViewLowDataModeNuxView = (ThreadViewLowDataModeNuxView) this.aJ.a();
        if (m6748n()) {
            ThreadViewLowDataModeNuxView threadViewLowDataModeNuxView2 = (ThreadViewLowDataModeNuxView) this.aJ.a();
            int dimensionPixelOffset = this.f7122G.getDimensionPixelOffset(2131428580);
            int dimensionPixelOffset2 = this.f7122G.getDimensionPixelOffset(2131428581);
            RoundedCornerOverlayDrawable roundedCornerOverlayDrawable = new RoundedCornerOverlayDrawable();
            roundedCornerOverlayDrawable.b(this.f7122G.getColor(2131362331));
            roundedCornerOverlayDrawable.c(getResources().getDimensionPixelSize(2131428585));
            roundedCornerOverlayDrawable.a((float) dimensionPixelOffset2, (float) dimensionPixelOffset2, this.av ? (float) dimensionPixelOffset2 : (float) dimensionPixelOffset, this.av ? (float) dimensionPixelOffset : (float) dimensionPixelOffset2);
            float f = (float) dimensionPixelOffset2;
            this.aw.f7059b.a(f, f, f, f);
            roundedCornerOverlayDrawable.a(this.bd.f());
            ((ThreadViewLowDataModeNuxView) this.aJ.a()).setForeground(roundedCornerOverlayDrawable);
            threadViewLowDataModeNuxView2.setPadding(0, 1, 0, 0);
            threadViewLowDataModeNuxView2.setShowDividers(0);
            return;
        }
        threadViewLowDataModeNuxView.setForeground(null);
        threadViewLowDataModeNuxView.setPadding(0, 0, 0, 0);
        threadViewLowDataModeNuxView.setShowDividers(1);
    }

    private void m6719Z() {
        if (this.av) {
            Object obj;
            Message message = this.bi.f4732a;
            if (this.bi.f4732a.l != MessageType.FAILED_SEND || this.bi.f4732a.w.b == SendErrorType.P2P_PAYMENT_RISK_FAILURE) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                m6736c(message);
                return;
            }
            this.aL.e();
            this.aM.e();
            this.at.setAlpha(1.0f);
            ((MessageItemContainer) this.as).f7057a = false;
            this.as.setClickable(false);
            this.as.setOnClickListener(null);
        }
    }

    private void m6736c(Message message) {
        this.aL.f();
        if (message.w.b.shouldNotBeRetried) {
            setErrorTextColor(this.f7122G.getColor(2131362300));
            ((FbTextView) this.aL.a()).setText(this.f7122G.getString(2131231083));
            this.aM.f();
            ((FbTextView) this.aM.a()).setText(this.f7122G.getString(2131231084));
        } else if (message.w.b == SendErrorType.HTTP_4XX_ERROR) {
            setErrorTextColor(this.f7122G.getColor(2131362299));
            ((FbTextView) this.aL.a()).setText(this.f7122G.getString(2131231081));
            this.aM.f();
            ((FbTextView) this.aM.a()).setText(this.f7122G.getString(2131231082));
        } else {
            setErrorTextColor(this.f7122G.getColor(2131362299));
            ((FbTextView) this.aL.a()).setText(this.f7122G.getString(2131231080));
        }
        this.at.setAlpha(0.5f);
        this.as.setClickable(true);
        ((MessageItemContainer) this.as).f7057a = true;
        this.as.setOnClickListener(this.aT);
        this.f7163y.f.a("msg_error_displayed", null, LoggerMapUtils.a(new String[]{"offline_threading_id", message.n, "send_error", message.w.b.serializedString}), null, null, null);
    }

    private void setErrorTextColor(int i) {
        ((FbTextView) this.aL.a()).setTextColor(i);
        ((FbTextView) this.aM.a()).setTextColor(i);
    }

    private void ab() {
        setPadding(0, this.bi.f4737f.groupWithOlderRow ? this.an : this.am, 0, 0);
    }

    public static void ac(MessageItemView messageItemView) {
        TracerDetour.a("SentAnimationDependentViews", 5512407);
        try {
            if (messageItemView.av) {
                float d = messageItemView.bi.m4309d();
                if (messageItemView.at.getBackground() != null && (messageItemView.at.getBackground() instanceof PendingAndSentDrawable)) {
                    ((PendingAndSentDrawable) messageItemView.at.getBackground()).m6980a(d);
                }
                float f = 0.5f + (0.5f * d);
                if (messageItemView.m6699E() && messageItemView.aD.c() && !MessageUtil.R(messageItemView.bi.f4732a) && !messageItemView.f7146h.a(messageItemView.bi.f4732a)) {
                    ((StickerDraweeView) messageItemView.aD.a()).setAlpha(f);
                }
                if (messageItemView.m6712R() && messageItemView.aF.c()) {
                    ((ThreadViewImageAttachmentView) messageItemView.aF.a()).setAlpha(f);
                }
                if (messageItemView.m6756y() && messageItemView.aG.c()) {
                    ((ThreadViewVideoAttachmentView) messageItemView.aG.a()).setSendingAnimationProgress(d);
                }
            }
            TracerDetour.a(337774995);
        } catch (Throwable th) {
            TracerDetour.a(567556349);
        }
    }

    public static void ad(MessageItemView messageItemView) {
        if (messageItemView.aq() && messageItemView.aC.c()) {
            ((PaymentView) messageItemView.aC.a()).setPaymentsAnimatingItemInfo(messageItemView.bi.f4754w);
        }
    }

    public static void ae(MessageItemView messageItemView) {
        Message message = messageItemView.bi.f4732a;
        messageItemView.at.setSelected(messageItemView.bi.f4751t);
        if (messageItemView.bi.f4750s != 0) {
            m6724a(messageItemView.aX, 8);
            return;
        }
        if (messageItemView.aX == null) {
            LayoutInflater from = LayoutInflater.from(messageItemView.getContext());
            AnimatingItemView animatingItemView = new AnimatingItemView(messageItemView.getContext());
            from.inflate(messageItemView.av ? 2130905756 : 2130905739, animatingItemView, true);
            messageItemView.aX = animatingItemView;
            messageItemView.aZ = (TextView) messageItemView.aX.findViewById(2131564926);
            if (messageItemView.bi.f4745n) {
                messageItemView.aX.setPadding(0, 0, messageItemView.f7122G.getDimensionPixelSize(2131428640), 0);
            }
            messageItemView.addView(messageItemView.aX);
        }
        messageItemView.aX.setVisibility(0);
        messageItemView.aX.setItemInfo(messageItemView.bi.f4753v);
        CharSequence c = messageItemView.f7164z.c(message.c);
        if (messageItemView.bi.f4745n && messageItemView.bi.f4740i != null) {
            switch (messageItemView.bi.f4740i) {
                case FAILED:
                    c = messageItemView.f7122G.getString(2131231183);
                    break;
                case SENDING:
                    c = messageItemView.f7122G.getString(2131231762);
                    break;
                case SENT:
                case SENT_WITH_HIDDEN_SEND_RECEIPT:
                    c = messageItemView.f7122G.getString(2131231550);
                    break;
                case DELIVERED:
                    c = messageItemView.f7122G.getString(2131231764);
                    break;
                case READ:
                case HIDDEN:
                    Editable valueOf = SpannableStringBuilder.valueOf(messageItemView.m6737d(message));
                    ((EmojiUtil) messageItemView.f7148j.get()).a(valueOf, (int) messageItemView.aZ.getTextSize());
                    Object obj = valueOf;
                    break;
            }
        }
        if (!messageItemView.aZ.getText().toString().equals(c.toString())) {
            messageItemView.aZ.setText(c);
        }
    }

    private CharSequence m6737d(Message message) {
        if (ThreadKey.d(message.b)) {
            if (!this.av) {
                return this.f7122G.getString(2131231808);
            }
            if (message.l == MessageType.PENDING_SEND) {
                return this.f7122G.getString(2131231762);
            }
            if (message.l == MessageType.REGULAR) {
                return this.f7122G.getString(2131231550);
            }
            return "";
        } else if (message.b.a == Type.ONE_TO_ONE || ThreadKey.g(message.b)) {
            int i = (this.av && this.bi.f4740i == RowItemDeliveryState.READ) ? 1 : 0;
            if (i == 0) {
                return this.f7122G.getString(2131231551);
            }
            r0 = this.f7164z.b(((ThreadParticipant) this.bi.f4741j.get(0)).b);
            return Html.fromHtml(this.f7122G.getString(2131231765, new Object[]{r0}));
        } else {
            List a = m6721a(this.bi.f4741j);
            List a2 = m6721a(this.bi.f4742k);
            if (a2.isEmpty()) {
                return this.f7122G.getString(2131231545);
            }
            if (a.isEmpty()) {
                return this.f7122G.getString(2131231542);
            }
            int size = a.size();
            int size2 = a2.size();
            if (size == 1) {
                return this.f7122G.getString(2131231546, new Object[]{a.get(0)});
            } else if (size == 2) {
                return this.f7122G.getString(2131231552, new Object[]{a.get(0), a.get(1)});
            } else if (size + size2 <= 15 || size2 > 3) {
                r0 = (String) a.get(0);
                String b = m6733b(a.subList(1, a.size() - 1));
                return this.f7122G.getString(2131231553, new Object[]{r0, b, a.get(size - 1)});
            } else if (size2 == 1) {
                return this.f7122G.getString(2131231555, new Object[]{a2.get(0)});
            } else if (size2 == 2) {
                return this.f7122G.getString(2131231556, new Object[]{a2.get(0), a2.get(1)});
            } else {
                return this.f7122G.getString(2131231557, new Object[]{a2.get(0), a2.get(1), a2.get(2)});
            }
        }
    }

    private List<String> m6721a(List<ThreadParticipant> list) {
        Collections.sort(list, new Comparator<ThreadParticipant>(this) {
            final /* synthetic */ MessageItemView f7099a;

            {
                this.f7099a = r1;
            }

            public int compare(Object obj, Object obj2) {
                ThreadParticipant threadParticipant = (ThreadParticipant) obj;
                ThreadParticipant threadParticipant2 = (ThreadParticipant) obj2;
                if (threadParticipant.b < threadParticipant2.b) {
                    return -1;
                }
                if (threadParticipant.b > threadParticipant2.b) {
                    return 1;
                }
                return ParticipantInfo.a.compare(threadParticipant.a, threadParticipant.a);
            }
        });
        List arrayList = new ArrayList(list.size());
        for (ThreadParticipant threadParticipant : list) {
            arrayList.add(threadParticipant.a);
        }
        return this.f7149k.a(this.bi.f4732a.b, arrayList, false, null);
    }

    private String m6733b(List<String> list) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            stringBuffer.append(this.f7122G.getString(2131231554, new Object[]{list.get(i)}));
        }
        return stringBuffer.toString();
    }

    private void m6725a(AnalyticsTagger analyticsTagger, AppChoreographer appChoreographer, ApplinkHelper applinkHelper, AttachmentDataFactory attachmentDataFactory, AttributionViewHelper attributionViewHelper, Lazy<BigEmojis> lazy, Provider<Boolean> provider, CustomThreadsEmojiLike customThreadsEmojiLike, Provider<Boolean> provider2, Lazy<EmojiUtil> lazy2, DataCache dataCache, Executor executor, GiftWrapResolver giftWrapResolver, Provider<Boolean> provider3, Provider<Boolean> provider4, Lazy<LinkHandlingHelper> lazy3, Lazy<FbBroadcastManager> lazy4, MessageClassifier messageClassifier, MessageExaminer messageExaminer, MessageItemLogger messageItemLogger, MessageRenderingUtil messageRenderingUtil, MessageUserUtil messageUserUtil, MessageUtil messageUtil, RowItemUiUtil rowItemUiUtil, MessagesReliabilityLogger messagesReliabilityLogger, MessagingDateUtil messagingDateUtil, MonotonicClock monotonicClock, UserTileViewParamsFactory userTileViewParamsFactory, PaymentTriggerHelper paymentTriggerHelper, PendingAndSentDrawableProvider pendingAndSentDrawableProvider, PresenceManager presenceManager, Product product, Resources resources, RowMessageItemDisplayCache rowMessageItemDisplayCache, SecureContextHelper secureContextHelper, Lazy<StyleRendererManager> lazy5, FbSharedPreferences fbSharedPreferences, ImagePipeline imagePipeline, ThreadViewLowDataModeUtils threadViewLowDataModeUtils, FileSizeUtil fileSizeUtil, AttributionHelper attributionHelper, AnalyticsLogger analyticsLogger, MontageTestHelper montageTestHelper, MontageMessagesHelper montageMessagesHelper, Lazy<EphemeralMessageProgressManager> lazy6, EphemeralGatingUtil ephemeralGatingUtil, RideAddressTriggerHelper rideAddressTriggerHelper, RideKeywordTriggerHelper rideKeywordTriggerHelper, Provider<Boolean> provider5, EphemeralProgressUtil ephemeralProgressUtil, MessageXMACallbackHelper messageXMACallbackHelper, UserCache userCache, MessengerUserNameUtil messengerUserNameUtil, FlowerBorderFeature flowerBorderFeature, Lazy<MessageForwardHandler> lazy7, Lazy<MessageLifetimeStringHelper> lazy8, Lazy<ThreadViewLoader> lazy9, Lazy<SendMessageManager> lazy10) {
        this.f7139a = analyticsTagger;
        this.f7140b = appChoreographer;
        this.f7141c = applinkHelper;
        this.f7142d = attachmentDataFactory;
        this.f7143e = attributionViewHelper;
        this.f7144f = lazy;
        this.f7145g = provider;
        this.f7146h = customThreadsEmojiLike;
        this.f7147i = provider2;
        this.f7148j = lazy2;
        this.f7149k = dataCache;
        this.f7150l = executor;
        this.f7151m = giftWrapResolver;
        this.f7152n = provider3;
        this.f7153o = provider4;
        this.f7154p = lazy3;
        this.f7155q = lazy4;
        this.f7156r = messageClassifier;
        this.f7157s = messageExaminer;
        this.f7158t = messageItemLogger;
        this.f7159u = messageRenderingUtil;
        this.f7160v = messageUserUtil;
        this.f7161w = messageUtil;
        this.f7162x = rowItemUiUtil;
        this.f7163y = messagesReliabilityLogger;
        this.f7164z = messagingDateUtil;
        this.f7116A = monotonicClock;
        this.f7117B = userTileViewParamsFactory;
        this.f7118C = paymentTriggerHelper;
        this.f7119D = pendingAndSentDrawableProvider;
        this.f7120E = presenceManager;
        this.f7121F = product;
        this.f7122G = resources;
        this.f7123H = rowMessageItemDisplayCache;
        this.f7124I = secureContextHelper;
        this.af = lazy5;
        this.f7125J = fbSharedPreferences;
        this.f7126K = imagePipeline;
        this.f7127L = threadViewLowDataModeUtils;
        this.f7128M = fileSizeUtil;
        this.f7129N = attributionHelper;
        this.f7130O = analyticsLogger;
        this.f7131P = montageTestHelper;
        this.f7132Q = montageMessagesHelper;
        this.f7133R = lazy6;
        this.f7134S = ephemeralGatingUtil;
        this.f7135T = rideAddressTriggerHelper;
        this.f7136U = rideKeywordTriggerHelper;
        this.f7137V = provider5;
        this.f7138W = ephemeralProgressUtil;
        this.aa = messageXMACallbackHelper;
        this.ab = userCache;
        this.ac = messengerUserNameUtil;
        this.ad = flowerBorderFeature;
        this.ag = lazy7;
        this.ah = lazy8;
        this.ai = lazy9;
        this.aj = lazy10;
    }

    public static void ag(MessageItemView messageItemView) {
        if (messageItemView.bi.f4745n && messageItemView.bi.f4737f != RowItemGrouping.DEFAULT_WITH_DIVIDER && messageItemView.bi.f4737f != RowItemGrouping.ONLY_WITH_NEWER_ROW_WITH_DIVIDER) {
            Message message = messageItemView.bi.f4732a;
            if (messageItemView.bi.f4750s != 0) {
                m6724a(messageItemView.aV, 8);
                return;
            }
            if (messageItemView.aV == null) {
                LayoutInflater from = LayoutInflater.from(messageItemView.getContext());
                AnimatingItemView animatingItemView = new AnimatingItemView(messageItemView.getContext());
                from.inflate(2130905765, animatingItemView, true);
                messageItemView.aV = animatingItemView;
                messageItemView.aW = (TextView) animatingItemView.findViewById(2131564906);
                ViewReplacementUtil.b(messageItemView, 2131564910, messageItemView.aV);
            }
            messageItemView.aV.setVisibility(0);
            AnimatingItemView animatingItemView2 = messageItemView.aV;
            animatingItemView2.setItemInfo(messageItemView.bi.f4753v);
            ((BetterTextView) animatingItemView2.getChildAt(0)).setText(messageItemView.f7164z.b(message.c));
        }
    }

    public static void ai(MessageItemView messageItemView) {
        Object obj;
        boolean ak;
        boolean a;
        LayoutParams layoutParams;
        Message message = messageItemView.bi.f4732a;
        if (messageItemView.av) {
            Object obj2;
            if (messageItemView.bi.f4745n || message.l != MessageType.PENDING_SEND || message.b == null || !((SendMessageManager) messageItemView.aj.get()).b(message)) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (obj2 != null) {
                obj = 1;
                ak = messageItemView.ak();
                a = messageItemView.f7134S.a(message);
                if (obj == null || ak || a) {
                    messageItemView.aH.f();
                    messageItemView.al();
                    if (obj != null) {
                        ((MessageItemGutterView) messageItemView.aH.a()).m6643b();
                    } else if (ak) {
                        ((MessageItemGutterView) messageItemView.aH.a()).m6641a();
                    }
                    if (messageItemView.av && messageItemView.bi.f4745n) {
                        layoutParams = (LayoutParams) messageItemView.at.getLayoutParams();
                        layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, messageItemView.getResources().getDimensionPixelSize(2131428641), layoutParams.bottomMargin);
                    }
                    if (a && !messageItemView.f7138W.c(message)) {
                        ((MessageItemGutterView) messageItemView.aH.a()).m6644e();
                        messageItemView.al();
                        return;
                    }
                }
                messageItemView.aH.e();
                messageItemView.as.setPadding(messageItemView.av ? messageItemView.ap : messageItemView.as.getPaddingLeft(), messageItemView.as.getPaddingTop(), messageItemView.av ? messageItemView.as.getPaddingRight() : messageItemView.ao, messageItemView.as.getPaddingBottom());
                return;
            }
        }
        obj = null;
        ak = messageItemView.ak();
        a = messageItemView.f7134S.a(message);
        if (obj == null) {
        }
        messageItemView.aH.f();
        messageItemView.al();
        if (obj != null) {
            ((MessageItemGutterView) messageItemView.aH.a()).m6643b();
        } else if (ak) {
            ((MessageItemGutterView) messageItemView.aH.a()).m6641a();
        }
        layoutParams = (LayoutParams) messageItemView.at.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, messageItemView.getResources().getDimensionPixelSize(2131428641), layoutParams.bottomMargin);
        if (a) {
        }
    }

    private boolean ak() {
        return (m6712R() || m6756y() || this.bj || MessageUtil.T(this.bi.f4732a) != null) && ((MessageForwardHandler) this.ag.get()).m2245a(this.bi.f4732a) && !((this.aF.d() && ((ThreadViewImageAttachmentView) this.aF.a()).f7563B) || (this.aG.d() && ((ThreadViewVideoAttachmentView) this.aG.a()).f8096V));
    }

    private void al() {
        int i = 0;
        LinearLayout linearLayout = this.as;
        int paddingLeft = this.av ? 0 : this.as.getPaddingLeft();
        int paddingTop = this.as.getPaddingTop();
        if (this.av) {
            i = this.as.getPaddingRight();
        }
        linearLayout.setPadding(paddingLeft, paddingTop, i, this.as.getPaddingBottom());
    }

    private void an() {
        TracerDetour.a("CommerceData", 422539544);
        try {
            if (ao()) {
                this.aR.f();
                ((CommerceBubbleView) this.aR.a()).setModel(this.bi.f4732a.H.a());
                TracerDetour.a(-1794516810);
                return;
            }
            this.aR.e();
        } finally {
            TracerDetour.a(906307187);
        }
    }

    private boolean ao() {
        if (this.bi.f4732a.G != null) {
            return false;
        }
        Message message = this.bi.f4732a;
        return (!((Boolean) this.f7153o.get()).booleanValue() || message.H == null || message.H.a == null) ? false : true;
    }

    private void ap() {
        TracerDetour.a("Payment", -1050583638);
        try {
            if (aq()) {
                this.aC.f();
                PaymentView paymentView = (PaymentView) this.aC.a();
                Message message = this.bi.f4732a;
                final String a = this.ac.a(message.e);
                AnonymousClass33 anonymousClass33 = new PaymentView.Listener(this) {
                    final /* synthetic */ MessageItemView f7101b;

                    public final void m6681a() {
                        this.f7101b.bg.mo302e(this.f7101b.bi);
                    }

                    public final void m6682b() {
                        ImmutableList immutableList;
                        boolean z = (this.f7101b.bi.f4743l == null || this.f7101b.bi.f4743l.b == null) ? false : true;
                        Preconditions.checkArgument(z);
                        if (this.f7101b.bi.f4743l.b.isPresent()) {
                            immutableList = (ImmutableList) this.f7101b.bi.f4743l.b.get();
                        } else {
                            immutableList = RegularImmutableList.a;
                        }
                        this.f7101b.bg.mo288a(immutableList, a, this.f7101b.bi.f4732a.B.a);
                    }

                    public final void m6683c() {
                        this.f7101b.bg.mo299d();
                    }

                    public final void m6684d() {
                        boolean z = (this.f7101b.bi.f4743l == null || this.f7101b.bi.f4743l.c == null) ? false : true;
                        Preconditions.checkArgument(z);
                        PaymentTransaction paymentTransaction = this.f7101b.bi.f4743l.c;
                        this.f7101b.bg.mo291a(paymentTransaction.b, String.valueOf(paymentTransaction.e.b()));
                    }

                    public final void m6685e() {
                        Preconditions.checkArgument(this.f7101b.bi.f4744m != null);
                        this.f7101b.f7124I.a(EnterPaymentValueActivity.b(this.f7101b.getContext(), String.valueOf(this.f7101b.bi.f4744m.lw_())), this.f7101b.getContext());
                    }

                    public final void m6686f() {
                        PaymentRequestModel paymentRequestModel = this.f7101b.bi.f4744m;
                        Preconditions.checkArgument(paymentRequestModel != null);
                        this.f7101b.bg.mo282a(paymentRequestModel, a);
                    }
                };
                Preconditions.checkNotNull(this.bd);
                PaymentViewParamsBuilder a2 = PaymentViewParams.newBuilder().a(message).a(this.bi.f4743l).a(this.bi.f4744m).a(a).a(this.bd.a(m6741g(message), SenderType.ME));
                if (message.b.b()) {
                    Optional optional = null;
                    if (message.B != null) {
                        optional = m6720a(Long.toString(message.B.c()));
                    } else if (message.C != null) {
                        optional = m6720a(Long.toString(message.C.c()));
                    } else if (!(message.u == null || message.u.c == null)) {
                        optional = m6720a(message.u.c.d);
                    }
                    if (optional != null) {
                        a2.a(optional);
                    }
                }
                if (message.B != null || (message.u != null && message.u.c != null)) {
                    a2.a(MessengerPayEntityType.PAYMENT_TRANSACTION);
                } else if (message.C != null) {
                    a2.a(MessengerPayEntityType.PAYMENT_REQUEST);
                } else {
                    throw new IllegalStateException("Unknown payment bubble type found.");
                }
                paymentView.a(a2.h(), anonymousClass33);
                TracerDetour.a(2066743505);
                return;
            }
            this.aC.e();
        } finally {
            TracerDetour.a(-318024384);
        }
    }

    private boolean aq() {
        return this.f7156r.a(this.bi.f4732a) == MessageClassification.PAYMENT;
    }

    private Optional<String> m6720a(String str) {
        User a = this.ab.a(UserKey.b(str));
        if (a == null || !a.a.equals(str)) {
            return Absent.INSTANCE;
        }
        return Optional.of(a.k());
    }

    private void ar() {
        if (!this.av) {
            return;
        }
        if (this.bi.f4745n) {
            ((DeliveryStatusView) this.aN.a()).m6527a(this.bi.f4740i);
            this.aN.f();
            return;
        }
        this.aN.e();
    }

    private void as() {
        if (this.bi.f4732a.D) {
            ThreadViewUnavailableAttachmentView threadViewUnavailableAttachmentView = (ThreadViewUnavailableAttachmentView) this.aK.a();
            threadViewUnavailableAttachmentView.setTitleTextColor(this.au.getCurrentTextColor());
            boolean A = MessageUtil.A(this.bi.f4732a);
            threadViewUnavailableAttachmentView.m7947a(A);
            threadViewUnavailableAttachmentView.m7948b(A);
            this.aK.f();
            return;
        }
        this.aK.e();
    }

    public static void au(MessageItemView messageItemView) {
        if (messageItemView.bg != null && !messageItemView.aB()) {
            messageItemView.bg.mo294b(messageItemView.bi);
        }
    }

    private static void m6724a(@Nullable View view, int i) {
        if (view != null) {
            view.setVisibility(i);
        }
    }

    private boolean m6740f(Message message) {
        if (message.b.b()) {
            return true;
        }
        if (ThreadKey.d(message.b)) {
            ThreadSummary a = this.f7149k.a(message.b);
            if (a != null && a.g()) {
                return true;
            }
        }
        return false;
    }

    private BubbleType m6741g(Message message) {
        BubbleType bubbleType = BubbleType.NORMAL;
        if (message != null && ThreadKey.g(message.b)) {
            return BubbleType.TINCAN;
        }
        if (this.f7134S.a(message)) {
            return BubbleType.EPHEMERAL;
        }
        return bubbleType;
    }

    private void ay() {
        ThreadKey b = this.f7131P.b(this.bi.f4732a.b);
        if (b != null) {
            ((ThreadViewLoader) this.ai.get()).m7350a(new MontageThreadViewLoaderCallback(this));
            ((ThreadViewLoader) this.ai.get()).m7351a(b);
            ((ThreadViewLoader) this.ai.get()).m7352a(Params.m7325a(false, false, true));
            return;
        }
        m6727a(this, this.az);
    }

    private boolean az() {
        return this.f7131P.b() && (this.bi == null || this.bq == null || this.bi.f4732a.b != this.bq.b);
    }

    public static void m6727a(MessageItemView messageItemView, View view) {
        if (view != messageItemView.bc && messageItemView.bc != null) {
            ViewGroup.LayoutParams layoutParams;
            ViewGroup viewGroup = (ViewGroup) messageItemView.bc.getParent();
            int indexOfChild = viewGroup.indexOfChild(messageItemView.bc);
            LayoutParams layoutParams2 = (LayoutParams) messageItemView.bc.getLayoutParams();
            if (VERSION.SDK_INT >= 19) {
                layoutParams = new LayoutParams(layoutParams2);
            } else {
                layoutParams = new LayoutParams(layoutParams2);
                layoutParams.weight = layoutParams2.weight;
                layoutParams.gravity = layoutParams2.gravity;
            }
            ViewGroup.LayoutParams layoutParams3 = layoutParams;
            viewGroup.removeView(messageItemView.bc);
            viewGroup.addView(view, indexOfChild, layoutParams3);
            messageItemView.bc = view;
        }
    }

    private void m6722a(Intent intent) {
        ThreadKey b = this.f7131P.b(this.bi.f4732a.b);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("multiple_thread_keys");
        if (b != null && parcelableArrayListExtra.contains(b)) {
            ay();
        }
    }

    private boolean aB() {
        long now = this.f7116A.now();
        if (this.bw != 0 && now - this.bw < 250) {
            return true;
        }
        this.bw = now;
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.bx;
    }

    public final boolean mo266a() {
        return this.ad.a(this.bi.f4732a);
    }

    public long getFlowerBorderId() {
        if (this.bi.f4732a.n != null) {
            return StringUtil.b(this.bi.f4732a.n);
        }
        return this.bi.m4299a();
    }

    public int getFlowerBorderLeft() {
        int left = this.at.getLeft();
        for (MessageItemView messageItemView = (ViewGroup) this.at.getParent(); messageItemView != this; ViewGroup viewGroup = (ViewGroup) messageItemView.getParent()) {
            left += messageItemView.getLeft();
        }
        return left;
    }

    public int getFlowerBorderTop() {
        int top = this.at.getTop();
        for (MessageItemView messageItemView = (ViewGroup) this.at.getParent(); messageItemView != this; ViewGroup viewGroup = (ViewGroup) messageItemView.getParent()) {
            top += messageItemView.getTop();
        }
        return top;
    }

    public int getFlowerBorderWidth() {
        return this.at.getWidth();
    }

    public int getFlowerBorderHeight() {
        return this.at.getHeight();
    }
}
