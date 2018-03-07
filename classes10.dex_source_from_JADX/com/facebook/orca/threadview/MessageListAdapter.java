package com.facebook.orca.threadview;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.util.ContextUtils;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.imagepipeline.animated.base.AnimatableDrawable;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.attachments.ImageAttachmentData;
import com.facebook.messaging.attachments.OtherAttachmentData;
import com.facebook.messaging.attachments.VideoAttachmentData;
import com.facebook.messaging.attributionview.AttributionViewData;
import com.facebook.messaging.blocking.ManageBlockingParam;
import com.facebook.messaging.business.common.view.BusinessGreetingView;
import com.facebook.messaging.business.common.view.BusinessGreetingView.1;
import com.facebook.messaging.business.common.view.BusinessNuxView;
import com.facebook.messaging.business.ride.utils.RideServiceParams;
import com.facebook.messaging.contextbanner.ui.ContextBannerView;
import com.facebook.messaging.customthreads.CustomThreadsEmojiLike;
import com.facebook.messaging.customthreads.DefaultThreadViewTheme;
import com.facebook.messaging.customthreads.annotations.IsCustomBubbleColorsEnabled;
import com.facebook.messaging.customthreads.annotations.IsCustomNicknamesEnabled;
import com.facebook.messaging.customthreads.annotations.IsHotEmojilikesEnabled;
import com.facebook.messaging.ephemeral.gating.EphemeralGatingUtil;
import com.facebook.messaging.messageclassifier.MessageClassification;
import com.facebook.messaging.messageclassifier.MessageClassifier;
import com.facebook.messaging.model.messages.GenericAdminMessageInfo.BotChoice;
import com.facebook.messaging.model.messages.GenericAdminMessageInfo.NicknameChoice;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.share.Share;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.threadview.rows.RowBusinessGreetingItem;
import com.facebook.messaging.threadview.rows.RowBusinessNuxItem;
import com.facebook.messaging.threadview.rows.RowEmojilikePickerItem;
import com.facebook.messaging.threadview.rows.RowGloballyDeletedMessagePlaceholderItem;
import com.facebook.messaging.threadview.rows.RowGroupCreatedItem;
import com.facebook.messaging.threadview.rows.RowHotLikePreviewItem;
import com.facebook.messaging.threadview.rows.RowItem;
import com.facebook.messaging.threadview.rows.RowMessageItem;
import com.facebook.messaging.threadview.rows.RowMontageStatusItem;
import com.facebook.messaging.threadview.rows.RowReceiptItem;
import com.facebook.messaging.threadview.rows.RowSocialContextItem;
import com.facebook.messaging.threadview.rows.RowThemePickerItem;
import com.facebook.messaging.threadview.rows.RowTimestampDividerItem;
import com.facebook.messaging.threadview.rows.RowType;
import com.facebook.messaging.threadview.rows.RowTypingItem;
import com.facebook.messaging.threadview.rows.RowViewType;
import com.facebook.messaging.threadview.rows.SimpleRowItem;
import com.facebook.messaging.threadview.xma.MessageXMAActionHandlerManager;
import com.facebook.messaging.xma.XMAActionHandlerManager;
import com.facebook.orca.threadview.AdminMessageWithLinkViewModel.Builder;
import com.facebook.orca.threadview.MessageListAdapterForListView.C10811;
import com.facebook.orca.threadview.MessageListAdapterForRecyclerView.C10821;
import com.facebook.orca.threadview.PaymentsAnimationManager.C11022;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.AnonymousClass14;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.BotPromptViewListener;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.EmojilikePickerViewListener;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.NicknamePromptViewListener;
import com.facebook.orca.threadview.hotlikes.HotLikePreviewItemView;
import com.facebook.orca.threadview.hotlikes.HotLikesAnimationManager;
import com.facebook.orca.threadview.hotlikes.HotLikesAnimationState;
import com.facebook.orca.threadview.hotlikes.HotLikesViewAnimationHelper;
import com.facebook.orca.threadview.messagelist.MessageListViewTypeHelper;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.widget.animatablelistview.AnimatingItemInfo;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: messenger_search_business_impression */
public class MessageListAdapter {
    public static final RowItem f7172a = new SimpleRowItem(RowType.LOAD_MORE, RowViewType.LOAD_MORE_PLACEHOLDER);
    public static final RowItem f7173b = new SimpleRowItem(RowType.LOAD_MORE, RowViewType.LOAD_MORE);
    public static final RowItem f7174c = new SimpleRowItem(RowType.LOAD_MORE, RowViewType.LOADING_MORE);
    public Listener f7175A;
    public AnonymousClass14 f7176B;
    public EmojilikePickerViewListener f7177C;
    public NicknamePromptViewListener f7178D;
    public BotPromptViewListener f7179E;
    public C10811 f7180F = new C10811(this);
    public AdapterDataObserver f7181G = new C10821(this);
    public FragmentManager f7182H;
    private DefaultThreadViewTheme f7183I;
    public ImmutableList<RowItem> f7184J = ImmutableList.of();
    private final Context f7185d;
    private final ContextBannerMessageListAdapterHelper f7186e;
    private final CustomThreadsEmojiLike f7187f;
    private final GatekeeperStoreImpl f7188g;
    @IsCustomBubbleColorsEnabled
    private final Provider<Boolean> f7189h;
    @IsCustomNicknamesEnabled
    private final Provider<Boolean> f7190i;
    @IsHotEmojilikesEnabled
    private final Provider<Boolean> f7191j;
    private final LayoutInflater f7192k;
    public final SendMessageAnimationManager f7193l;
    public final GiftWrapAnimationManager f7194m;
    public final HotLikesAnimationManager f7195n;
    public final MessageDetailViewManager f7196o;
    public final PaymentsAnimationManager f7197p;
    private final XMAActionHandlerManager<Message> f7198q;
    private final MessageUtil f7199r;
    private final MessageClassifier f7200s;
    private final MessageListViewTypeHelper f7201t;
    private Lazy<AdminMessageWithLinkViewModelFactory> f7202u;
    private final C10741 f7203v;
    private final C10752 f7204w;
    private final C10763 f7205x;
    private final C10774 f7206y;
    private final OnClickListener f7207z;

    /* compiled from: messenger_search_business_impression */
    public class C10741 {
        public final /* synthetic */ MessageListAdapter f7165a;

        C10741(MessageListAdapter messageListAdapter) {
            this.f7165a = messageListAdapter;
        }

        public final void m6764a(ManageBlockingParam manageBlockingParam) {
            if (this.f7165a.f7175A != null) {
                this.f7165a.f7175A.mo280a(manageBlockingParam);
            }
        }
    }

    /* compiled from: messenger_search_business_impression */
    public class C10752 {
        public final /* synthetic */ MessageListAdapter f7166a;

        C10752(MessageListAdapter messageListAdapter) {
            this.f7166a = messageListAdapter;
        }
    }

    /* compiled from: messenger_search_business_impression */
    public class C10763 {
        public final /* synthetic */ MessageListAdapter f7167a;

        C10763(MessageListAdapter messageListAdapter) {
            this.f7167a = messageListAdapter;
        }
    }

    /* compiled from: messenger_search_business_impression */
    public class C10774 {
        public final /* synthetic */ MessageListAdapter f7168a;

        C10774(MessageListAdapter messageListAdapter) {
            this.f7168a = messageListAdapter;
        }
    }

    /* compiled from: messenger_search_business_impression */
    class C10785 implements OnClickListener {
        final /* synthetic */ MessageListAdapter f7169a;

        C10785(MessageListAdapter messageListAdapter) {
            this.f7169a = messageListAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1554062586);
            if (this.f7169a.f7175A != null) {
                this.f7169a.f7175A.mo301e();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 984038810, a);
        }
    }

    /* compiled from: messenger_search_business_impression */
    class C10796 implements OnClickListener {
        final /* synthetic */ MessageListAdapter f7170a;

        C10796(MessageListAdapter messageListAdapter) {
            this.f7170a = messageListAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -512620128);
            if (this.f7170a.f7175A != null) {
                this.f7170a.f7175A.mo273a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1434924798, a);
        }
    }

    /* compiled from: messenger_search_business_impression */
    public interface Listener {
        void mo273a();

        void mo274a(Intent intent, int i);

        void mo275a(View view);

        void mo276a(View view, UserKey userKey);

        void mo277a(OtherAttachmentData otherAttachmentData);

        void mo278a(VideoAttachmentData videoAttachmentData);

        void mo279a(AttributionViewData attributionViewData);

        void mo280a(ManageBlockingParam manageBlockingParam);

        void mo281a(RideServiceParams rideServiceParams);

        void mo282a(PaymentRequestModel paymentRequestModel, String str);

        void mo283a(RowItem rowItem, Parcelable parcelable);

        void mo284a(RowMessageItem rowMessageItem);

        void mo285a(RowMessageItem rowMessageItem, AnimatableDrawable animatableDrawable);

        void mo286a(RowMessageItem rowMessageItem, ImageAttachmentData imageAttachmentData);

        void mo287a(RowMessageItem rowMessageItem, Share share);

        void mo288a(ImmutableList<PaymentCard> immutableList, String str, String str2);

        void mo289a(String str);

        void mo290a(String str, EventTriggerType eventTriggerType);

        void mo291a(String str, String str2);

        boolean mo292a(RowItem rowItem);

        void mo293b();

        void mo294b(RowMessageItem rowMessageItem);

        void mo295b(String str);

        void mo296c();

        void mo297c(RowMessageItem rowMessageItem);

        void mo298c(String str);

        void mo299d();

        void mo300d(RowMessageItem rowMessageItem);

        void mo301e();

        void mo302e(RowMessageItem rowMessageItem);

        void mo303f();

        void mo304f(RowMessageItem rowMessageItem);

        void mo305g();

        void mo306h();

        void mo307i();
    }

    /* compiled from: messenger_search_business_impression */
    public class SimpleListener implements Listener {
        public final void mo284a(RowMessageItem rowMessageItem) {
        }

        public final boolean mo292a(RowItem rowItem) {
            return false;
        }

        public final void mo287a(RowMessageItem rowMessageItem, Share share) {
        }

        public final void mo294b(RowMessageItem rowMessageItem) {
        }

        public final void mo273a() {
        }

        public final void mo289a(String str) {
        }

        public final void mo290a(String str, EventTriggerType eventTriggerType) {
        }

        public final void mo295b(String str) {
        }

        public final void mo293b() {
        }

        public final void mo278a(VideoAttachmentData videoAttachmentData) {
        }

        public final void mo283a(RowItem rowItem, Parcelable parcelable) {
        }

        public final void mo297c(RowMessageItem rowMessageItem) {
        }

        public final void mo296c() {
        }

        public final void mo300d(RowMessageItem rowMessageItem) {
        }

        public void mo285a(RowMessageItem rowMessageItem, AnimatableDrawable animatableDrawable) {
        }

        public final void mo302e(RowMessageItem rowMessageItem) {
        }

        public final void mo298c(String str) {
        }

        public final void mo288a(ImmutableList<PaymentCard> immutableList, String str, String str2) {
        }

        public final void mo299d() {
        }

        public final void mo291a(String str, String str2) {
        }

        public final void mo282a(PaymentRequestModel paymentRequestModel, String str) {
        }

        public final void mo277a(OtherAttachmentData otherAttachmentData) {
        }

        public final void mo301e() {
        }

        public final void mo286a(RowMessageItem rowMessageItem, ImageAttachmentData imageAttachmentData) {
        }

        public final void mo279a(AttributionViewData attributionViewData) {
        }

        public final void mo303f() {
        }

        public final void mo305g() {
        }

        public final void mo306h() {
        }

        public final void mo307i() {
        }

        public final void mo274a(Intent intent, int i) {
        }

        public final void mo276a(View view, UserKey userKey) {
        }

        public final void mo275a(View view) {
        }

        public final void mo280a(ManageBlockingParam manageBlockingParam) {
        }

        public final void mo281a(RideServiceParams rideServiceParams) {
        }

        public final void mo304f(RowMessageItem rowMessageItem) {
        }
    }

    public static MessageListAdapter m6861b(InjectorLike injectorLike) {
        return new MessageListAdapter((Context) injectorLike.getInstance(Context.class), ContextBannerMessageListAdapterHelper.m6519a(injectorLike), CustomThreadsEmojiLike.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4145), IdBasedProvider.a(injectorLike, 4147), IdBasedProvider.a(injectorLike, 4149), LayoutInflaterMethodAutoProvider.a(injectorLike), SendMessageAnimationManager.m7055a(injectorLike), GiftWrapAnimationManager.m6558a(injectorLike), HotLikesAnimationManager.m8087a(injectorLike), MessageDetailViewManager.m6609a(injectorLike), PaymentsAnimationManager.m6978a(injectorLike), (XMAActionHandlerManager) MessageXMAActionHandlerManager.m4385a(injectorLike), MessageUtil.a(injectorLike), MessageClassifier.a(injectorLike), MessageListViewTypeHelper.m8235a(injectorLike), IdBasedLazy.a(injectorLike, 8831));
    }

    private static void m6837a(BusinessGreetingView businessGreetingView, RowBusinessGreetingItem rowBusinessGreetingItem) {
        ListenableFuture listenableFuture = rowBusinessGreetingItem.f4723a;
        Long valueOf = Long.valueOf(rowBusinessGreetingItem.m4285a());
        if (!valueOf.equals(businessGreetingView.c)) {
            businessGreetingView.c = valueOf;
            businessGreetingView.setVisibility(8);
            Futures.a(listenableFuture, new 1(businessGreetingView), businessGreetingView.a);
        }
    }

    private static void m6838a(BusinessNuxView businessNuxView, RowBusinessNuxItem rowBusinessNuxItem) {
        ThreadKey threadKey = rowBusinessNuxItem.f4726b;
        ListenableFuture listenableFuture = rowBusinessNuxItem.f4725a;
        if (businessNuxView.e == null || !threadKey.equals(businessNuxView.e)) {
            businessNuxView.setVisibility(8);
            if (businessNuxView.f != null) {
                businessNuxView.f.cancel(true);
                businessNuxView.f = null;
            }
            if (listenableFuture == null) {
                businessNuxView.e = null;
                return;
            }
            businessNuxView.e = threadKey;
            businessNuxView.f = listenableFuture;
            Futures.a(businessNuxView.f, businessNuxView.h, businessNuxView.a);
        }
    }

    private static void m6856a(TimestampDividerItemView timestampDividerItemView, RowTimestampDividerItem rowTimestampDividerItem) {
        timestampDividerItemView.f8132d = rowTimestampDividerItem;
        if (timestampDividerItemView.f8132d != null) {
            timestampDividerItemView.f8131c.setText(timestampDividerItemView.f8129a.b(timestampDividerItemView.f8132d.f4773a));
        }
    }

    private static void m6844a(GloballyDeletedMessagePlaceholderItemView globallyDeletedMessagePlaceholderItemView, RowGloballyDeletedMessagePlaceholderItem rowGloballyDeletedMessagePlaceholderItem) {
        int i;
        globallyDeletedMessagePlaceholderItemView.f6937d = rowGloballyDeletedMessagePlaceholderItem;
        globallyDeletedMessagePlaceholderItemView.f6935b.setText(rowGloballyDeletedMessagePlaceholderItem.f4728a.f);
        if (globallyDeletedMessagePlaceholderItemView.f6937d.f4729b.groupWithNewerRow) {
            globallyDeletedMessagePlaceholderItemView.f6938e.setVisibility(8);
        } else {
            globallyDeletedMessagePlaceholderItemView.f6938e.setParams(globallyDeletedMessagePlaceholderItemView.f6934a.a(globallyDeletedMessagePlaceholderItemView.f6937d.f4728a.e.b));
            globallyDeletedMessagePlaceholderItemView.f6938e.setVisibility(0);
        }
        int dimensionPixelOffset = globallyDeletedMessagePlaceholderItemView.getResources().getDimensionPixelOffset(2131428580);
        int dimensionPixelOffset2 = globallyDeletedMessagePlaceholderItemView.getResources().getDimensionPixelOffset(2131428581);
        if (globallyDeletedMessagePlaceholderItemView.f6937d.f4729b.groupWithOlderRow) {
            i = dimensionPixelOffset2;
        } else {
            i = dimensionPixelOffset;
        }
        if (!globallyDeletedMessagePlaceholderItemView.f6937d.f4729b.groupWithNewerRow) {
            dimensionPixelOffset2 = dimensionPixelOffset;
        }
        globallyDeletedMessagePlaceholderItemView.f6936c.a((float) i, (float) dimensionPixelOffset, (float) dimensionPixelOffset, (float) dimensionPixelOffset2);
        i = ContextUtils.e(globallyDeletedMessagePlaceholderItemView.getContext(), 2130773134, 0);
        dimensionPixelOffset2 = ContextUtils.e(globallyDeletedMessagePlaceholderItemView.getContext(), 2130773133, 0);
        if (!globallyDeletedMessagePlaceholderItemView.f6937d.f4729b.groupWithOlderRow) {
            i = dimensionPixelOffset2;
        }
        globallyDeletedMessagePlaceholderItemView.setPadding(0, i, 0, 0);
    }

    private static void m6847a(JourneyPromptSetupView journeyPromptSetupView, RowMessageItem rowMessageItem) {
        ThreadSummary a = journeyPromptSetupView.f7000a.a(rowMessageItem.f4732a.b);
        if (a != null) {
            User a2 = journeyPromptSetupView.f7004e.a(journeyPromptSetupView.f7002c.a(a).b());
            if (a2 != null) {
                journeyPromptSetupView.f7006g.setParams(journeyPromptSetupView.f7003d.a((User) journeyPromptSetupView.f7001b.get()));
                journeyPromptSetupView.f7007h.setParams(journeyPromptSetupView.f7003d.a(a2));
                journeyPromptSetupView.f7008i.setText(journeyPromptSetupView.getResources().getString(2131231868, new Object[]{a2.e.a()}));
            }
        }
    }

    private static void m6846a(JourneyPromptBotView journeyPromptBotView, RowMessageItem rowMessageItem) {
        Preconditions.checkNotNull(rowMessageItem.f4732a.I);
        ImmutableList immutableList = rowMessageItem.f4732a.I.l;
        if (!Objects.equal(immutableList, journeyPromptBotView.f6996i)) {
            journeyPromptBotView.f6996i = immutableList;
            int i = (journeyPromptBotView.f6996i == null || journeyPromptBotView.f6996i.size() != 1) ? 0 : 1;
            Resources resources = journeyPromptBotView.getResources();
            journeyPromptBotView.f6993f.setText(i != 0 ? resources.getString(2131231870, new Object[]{((BotChoice) journeyPromptBotView.f6996i.get(0)).title}) : resources.getString(2131231871));
            i = 1;
            if (journeyPromptBotView.f6996i == null || journeyPromptBotView.f6996i.size() != 1) {
                i = 0;
            }
            journeyPromptBotView.f6994g.setVisibility(i != 0 ? 0 : 8);
            if (i != 0) {
                journeyPromptBotView.f6994g.setText(((BotChoice) journeyPromptBotView.f6996i.get(0)).description);
            }
            journeyPromptBotView.f6991d.notifyDataSetChanged();
        }
    }

    private static void m6857a(TypingItemView typingItemView, RowTypingItem rowTypingItem) {
        typingItemView.f8145k = rowTypingItem;
        typingItemView.f8138d.setParams(typingItemView.f8136b.a(typingItemView.f8145k.f4774a.b));
        typingItemView.setPadding(0, typingItemView.f8145k.f4776c ? typingItemView.f8142h : typingItemView.f8141g, 0, 0);
        int dimensionPixelOffset = typingItemView.getResources().getDimensionPixelOffset(2131428580);
        int dimensionPixelOffset2 = typingItemView.getResources().getDimensionPixelOffset(2131428581);
        if (!typingItemView.f8145k.f4776c) {
            dimensionPixelOffset2 = dimensionPixelOffset;
        }
        typingItemView.f8140f.a((float) dimensionPixelOffset2, (float) dimensionPixelOffset, (float) dimensionPixelOffset, (float) dimensionPixelOffset);
    }

    private static void m6850a(MontageStatusItemView montageStatusItemView, RowMontageStatusItem rowMontageStatusItem) {
        montageStatusItemView.f7270i.m6950a(rowMontageStatusItem.f4757b, rowMontageStatusItem.f4756a);
    }

    @Inject
    public MessageListAdapter(Context context, ContextBannerMessageListAdapterHelper contextBannerMessageListAdapterHelper, CustomThreadsEmojiLike customThreadsEmojiLike, GatekeeperStore gatekeeperStore, Provider<Boolean> provider, Provider<Boolean> provider2, Provider<Boolean> provider3, LayoutInflater layoutInflater, SendMessageAnimationManager sendMessageAnimationManager, GiftWrapAnimationManager giftWrapAnimationManager, HotLikesAnimationManager hotLikesAnimationManager, MessageDetailViewManager messageDetailViewManager, PaymentsAnimationManager paymentsAnimationManager, XMAActionHandlerManager xMAActionHandlerManager, MessageUtil messageUtil, MessageClassifier messageClassifier, MessageListViewTypeHelper messageListViewTypeHelper, Lazy<AdminMessageWithLinkViewModelFactory> lazy) {
        this.f7185d = context;
        this.f7186e = contextBannerMessageListAdapterHelper;
        this.f7187f = customThreadsEmojiLike;
        this.f7188g = gatekeeperStore;
        this.f7189h = provider;
        this.f7190i = provider2;
        this.f7191j = provider3;
        this.f7192k = layoutInflater;
        this.f7193l = sendMessageAnimationManager;
        this.f7194m = giftWrapAnimationManager;
        this.f7195n = hotLikesAnimationManager;
        this.f7196o = messageDetailViewManager;
        this.f7197p = paymentsAnimationManager;
        this.f7198q = xMAActionHandlerManager;
        this.f7199r = messageUtil;
        this.f7200s = messageClassifier;
        this.f7201t = messageListViewTypeHelper;
        this.f7202u = lazy;
        this.f7203v = new C10741(this);
        this.f7204w = new C10752(this);
        this.f7205x = new C10763(this);
        this.f7206y = new C10774(this);
        this.f7207z = new C10785(this);
    }

    public final void m6887a(DefaultThreadViewTheme defaultThreadViewTheme) {
        this.f7183I = defaultThreadViewTheme;
        this.f7195n.f8191k = this.f7183I;
    }

    public final void m6888a(List<RowItem> list) {
        this.f7184J = ImmutableList.copyOf(list);
        if (this.f7180F != null) {
            AdapterDetour.a(this.f7180F.f7208a, -2019571746);
        }
        if (this.f7181G != null) {
            this.f7181G.bb_();
        }
    }

    final int m6889g() {
        return this.f7184J.size();
    }

    final RowItem m6885a(int i) {
        if (i < 0 || i >= this.f7184J.size()) {
            return null;
        }
        return (RowItem) this.f7184J.get(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final android.view.View m6884a(com.facebook.messaging.threadview.rows.RowViewType r4, android.view.ViewGroup r5) {
        /*
        r3 = this;
        com.google.common.base.Preconditions.checkNotNull(r4);
        r0 = "MessageListAdapter#createView";
        r1 = -290002292; // 0xffffffffeeb6ea8c float:-2.830491E28 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0, r1);
        r0 = com.facebook.orca.threadview.MessageListAdapter.C10807.f7171a;	 Catch:{ all -> 0x01ec }
        r1 = r4.ordinal();	 Catch:{ all -> 0x01ec }
        r0 = r0[r1];	 Catch:{ all -> 0x01ec }
        switch(r0) {
            case 1: goto L_0x0031;
            case 2: goto L_0x003c;
            case 3: goto L_0x0047;
            case 4: goto L_0x0052;
            case 5: goto L_0x005e;
            case 6: goto L_0x006a;
            case 7: goto L_0x006a;
            case 8: goto L_0x006a;
            case 9: goto L_0x006a;
            case 10: goto L_0x006a;
            case 11: goto L_0x006a;
            case 12: goto L_0x006a;
            case 13: goto L_0x006a;
            case 14: goto L_0x006a;
            case 15: goto L_0x006a;
            case 16: goto L_0x0076;
            case 17: goto L_0x0076;
            case 18: goto L_0x0076;
            case 19: goto L_0x0076;
            case 20: goto L_0x0076;
            case 21: goto L_0x0076;
            case 22: goto L_0x0076;
            case 23: goto L_0x0076;
            case 24: goto L_0x0076;
            case 25: goto L_0x0076;
            case 26: goto L_0x0082;
            case 27: goto L_0x008d;
            case 28: goto L_0x008d;
            case 29: goto L_0x0098;
            case 30: goto L_0x00a3;
            case 31: goto L_0x00af;
            case 32: goto L_0x00bb;
            case 33: goto L_0x00c7;
            case 34: goto L_0x00d3;
            case 35: goto L_0x00df;
            case 36: goto L_0x00eb;
            case 37: goto L_0x00f7;
            case 38: goto L_0x0103;
            case 39: goto L_0x010f;
            case 40: goto L_0x011b;
            case 41: goto L_0x0127;
            case 42: goto L_0x014d;
            case 43: goto L_0x0173;
            case 44: goto L_0x0199;
            case 45: goto L_0x01bc;
            case 46: goto L_0x01c8;
            case 47: goto L_0x01d4;
            case 48: goto L_0x01e0;
            default: goto L_0x0016;
        };
    L_0x0016:
        r0 = -576130329; // 0xffffffffdda8f2e7 float:-1.52175584E18 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r2 = "Unknown row type ";
        r1.<init>(r2);
        r1 = r1.append(r4);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0031:
        r0 = r3.m6835a(r5);	 Catch:{  }
        r1 = -1289522365; // 0xffffffffb3237343 float:-3.8056225E-8 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
    L_0x003b:
        return r0;
    L_0x003c:
        r0 = r3.m6859b(r5);	 Catch:{  }
        r1 = -1072631794; // 0xffffffffc010f00e float:-2.2646518 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x003b;
    L_0x0047:
        r0 = r3.m6862c(r5);	 Catch:{  }
        r1 = 1903614994; // 0x7176dc12 float:1.2223898E30 double:9.405107714E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x003b;
    L_0x0052:
        r0 = 0;
        r0 = r3.m6836a(r0);	 Catch:{  }
        r1 = -835338735; // 0xffffffffce35be11 float:-7.6228307E8 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x003b;
    L_0x005e:
        r0 = 1;
        r0 = r3.m6836a(r0);	 Catch:{  }
        r1 = -1633009628; // 0xffffffff9eaa4024 float:-1.8025978E-20 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x003b;
    L_0x006a:
        r0 = 0;
        r0 = r3.m6860b(r0);	 Catch:{  }
        r1 = 1710792319; // 0x65f89e7f float:1.4675883E23 double:8.45243712E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x003b;
    L_0x0076:
        r0 = 1;
        r0 = r3.m6860b(r0);	 Catch:{  }
        r1 = 2143869558; // 0x7fc8da76 float:NaN double:1.059212298E-314;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x003b;
    L_0x0082:
        r0 = r3.m6865h();	 Catch:{  }
        r1 = 819740181; // 0x30dc3e15 float:1.6024752E-9 double:4.05005462E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x003b;
    L_0x008d:
        r0 = r3.m6866i();	 Catch:{  }
        r1 = -1519588530; // 0xffffffffa56ceb4e float:-2.0549461E-16 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x003b;
    L_0x0098:
        r0 = r3.m6867j();	 Catch:{  }
        r1 = 169567595; // 0xa1b656b float:7.482053E-33 double:8.37775233E-316;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x003b;
    L_0x00a3:
        r0 = 0;
        r0 = r3.m6863c(r0);	 Catch:{  }
        r1 = 1910067041; // 0x71d94f61 float:2.1521347E30 double:9.43698506E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x003b;
    L_0x00af:
        r0 = 1;
        r0 = r3.m6863c(r0);	 Catch:{  }
        r1 = 889300902; // 0x3501a7a6 float:4.8300205E-7 double:4.393730245E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x003b;
    L_0x00bb:
        r0 = r3.m6868k();	 Catch:{  }
        r1 = -910791903; // 0xffffffffc9b66b21 float:-1494372.1 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x003b;
    L_0x00c7:
        r0 = r3.m6869l();	 Catch:{  }
        r1 = -461510128; // 0xffffffffe47dea10 float:-1.8735569E22 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x003b;
    L_0x00d3:
        r0 = r3.m6864d(r5);	 Catch:{  }
        r1 = 1840664463; // 0x6db64f8f float:7.0528065E27 double:9.094090767E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x003b;
    L_0x00df:
        r0 = r3.m6870m();	 Catch:{  }
        r1 = -772822734; // 0xffffffffd1efa932 float:-1.28666976E11 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x003b;
    L_0x00eb:
        r0 = r3.m6871n();	 Catch:{  }
        r1 = -182859681; // 0xfffffffff519c85f float:-1.9494273E32 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x003b;
    L_0x00f7:
        r0 = r3.m6872o();	 Catch:{  }
        r1 = 655377562; // 0x2710449a float:2.0021203E-15 double:3.237995384E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x003b;
    L_0x0103:
        r0 = r3.m6873p();	 Catch:{  }
        r1 = 1108463594; // 0x4211cfea float:36.45304 double:5.476537815E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x003b;
    L_0x010f:
        r0 = r3.m6874q();	 Catch:{  }
        r1 = -1727423738; // 0xffffffff99099b06 float:-7.114041E-24 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x003b;
    L_0x011b:
        r0 = r3.m6875r();	 Catch:{  }
        r1 = 1823305161; // 0x6cad6dc9 float:1.6773009E27 double:9.00832442E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x003b;
    L_0x0127:
        r0 = r3.f7189h;	 Catch:{  }
        r0 = r0.get();	 Catch:{  }
        r0 = (java.lang.Boolean) r0;	 Catch:{  }
        r0 = r0.booleanValue();	 Catch:{  }
        if (r0 == 0) goto L_0x0141;
    L_0x0135:
        r0 = r3.m6876s();	 Catch:{  }
        r1 = -242073996; // 0xfffffffff1923e74 float:-1.44833E30 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x003b;
    L_0x0141:
        r0 = r3.m6866i();	 Catch:{  }
        r1 = 1158199331; // 0x4508b823 float:2187.5085 double:5.722265005E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x003b;
    L_0x014d:
        r0 = r3.f7191j;	 Catch:{  }
        r0 = r0.get();	 Catch:{  }
        r0 = (java.lang.Boolean) r0;	 Catch:{  }
        r0 = r0.booleanValue();	 Catch:{  }
        if (r0 == 0) goto L_0x0167;
    L_0x015b:
        r0 = r3.m6877t();	 Catch:{  }
        r1 = -953663380; // 0xffffffffc728406c float:-43072.42 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x003b;
    L_0x0167:
        r0 = r3.m6866i();	 Catch:{  }
        r1 = -1247599795; // 0xffffffffb5a3234d float:-1.215472E-6 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x003b;
    L_0x0173:
        r0 = r3.f7190i;	 Catch:{  }
        r0 = r0.get();	 Catch:{  }
        r0 = (java.lang.Boolean) r0;	 Catch:{  }
        r0 = r0.booleanValue();	 Catch:{  }
        if (r0 == 0) goto L_0x018d;
    L_0x0181:
        r0 = r3.m6878u();	 Catch:{  }
        r1 = 1916951161; // 0x72425a79 float:3.849566E30 double:9.470997134E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x003b;
    L_0x018d:
        r0 = r3.m6866i();	 Catch:{  }
        r1 = -431307595; // 0xffffffffe64ac4b5 float:-2.3938666E23 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x003b;
    L_0x0199:
        r0 = r3.f7188g;	 Catch:{  }
        r1 = 910; // 0x38e float:1.275E-42 double:4.496E-321;
        r2 = 0;
        r0 = r0.a(r1, r2);	 Catch:{  }
        if (r0 == 0) goto L_0x01b0;
    L_0x01a4:
        r0 = r3.m6879v();	 Catch:{  }
        r1 = -437255755; // 0xffffffffe5f001b5 float:-1.4167493E23 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x003b;
    L_0x01b0:
        r0 = r3.m6866i();	 Catch:{  }
        r1 = -2119426102; // 0xffffffff81ac1fca float:-6.3228436E-38 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x003b;
    L_0x01bc:
        r0 = r3.m6880w();	 Catch:{  }
        r1 = -322085866; // 0xffffffffeccd5c16 float:-1.9861173E27 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x003b;
    L_0x01c8:
        r0 = r3.m6881x();	 Catch:{  }
        r1 = -316696828; // 0xffffffffed1f9704 float:-3.0869177E27 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x003b;
    L_0x01d4:
        r0 = r3.m6882y();	 Catch:{  }
        r1 = 819628319; // 0x30da891f float:1.590056E-9 double:4.04950195E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x003b;
    L_0x01e0:
        r0 = r3.m6883z();	 Catch:{  }
        r1 = -8180484; // 0xffffffffff832cfc float:NaN double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x003b;
    L_0x01ec:
        r0 = move-exception;
        r1 = 2090857821; // 0x7c9ff55d float:6.644414E36 double:1.0330210197E-314;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.threadview.MessageListAdapter.a(com.facebook.messaging.threadview.rows.RowViewType, android.view.ViewGroup):android.view.View");
    }

    private View m6835a(ViewGroup viewGroup) {
        View inflate = this.f7192k.inflate(2130905710, viewGroup, false);
        inflate.setOnClickListener(this.f7207z);
        return inflate;
    }

    private View m6859b(ViewGroup viewGroup) {
        View inflate = this.f7192k.inflate(2130905709, viewGroup, false);
        inflate.setOnClickListener(new C10796(this));
        return inflate;
    }

    private View m6862c(ViewGroup viewGroup) {
        return this.f7192k.inflate(2130905711, viewGroup, false);
    }

    private View m6836a(boolean z) {
        MessageHScrollAttachmentView messageHScrollAttachmentView = new MessageHScrollAttachmentView(this.f7185d, z);
        DefaultThreadViewTheme defaultThreadViewTheme = this.f7183I;
        if (messageHScrollAttachmentView.f7056n != defaultThreadViewTheme) {
            if (messageHScrollAttachmentView.f7056n != null) {
                messageHScrollAttachmentView.f7056n.b(messageHScrollAttachmentView.f7055m);
            }
            messageHScrollAttachmentView.f7056n = defaultThreadViewTheme;
            if (messageHScrollAttachmentView.f7056n != null) {
                messageHScrollAttachmentView.f7056n.a(messageHScrollAttachmentView.f7055m);
            }
        }
        messageHScrollAttachmentView.f7049g = this.f7198q;
        messageHScrollAttachmentView.f7051i = this.f7175A;
        return messageHScrollAttachmentView;
    }

    private View m6860b(boolean z) {
        Object messageItemView = new MessageItemView(this.f7185d, z);
        messageItemView.bk = this.f7182H;
        messageItemView.bl = this.f7198q;
        messageItemView.setThreadViewTheme(this.f7183I);
        messageItemView.setOnClickListener(this.f7207z);
        messageItemView.bg = this.f7175A;
        return messageItemView;
    }

    private View m6865h() {
        MontageStatusItemView montageStatusItemView = new MontageStatusItemView(this.f7185d);
        DefaultThreadViewTheme defaultThreadViewTheme = this.f7183I;
        if (montageStatusItemView.f7273l != defaultThreadViewTheme) {
            if (montageStatusItemView.f7273l != null) {
                montageStatusItemView.f7273l.b(montageStatusItemView.f7276o);
            }
            montageStatusItemView.f7273l = defaultThreadViewTheme;
            if (montageStatusItemView.f7273l != null) {
                MontageStatusItemView.m6934g(montageStatusItemView);
                montageStatusItemView.f7273l.a(montageStatusItemView.f7276o);
            }
        }
        return montageStatusItemView;
    }

    private View m6866i() {
        Object adminMessageItemView = new AdminMessageItemView(this.f7185d);
        DefaultThreadViewTheme defaultThreadViewTheme = this.f7183I;
        if (adminMessageItemView.f6829v != null) {
            adminMessageItemView.f6829v.b(adminMessageItemView.f6826s);
        }
        adminMessageItemView.f6829v = defaultThreadViewTheme;
        if (adminMessageItemView.f6829v != null) {
            adminMessageItemView.f6829v.a(adminMessageItemView.f6826s);
            AdminMessageItemView.m6494h(adminMessageItemView);
        }
        adminMessageItemView.f6808H = this.f7203v;
        return adminMessageItemView;
    }

    private View m6867j() {
        GroupCreatedItemView groupCreatedItemView = new GroupCreatedItemView(this.f7185d);
        groupCreatedItemView.setThreadViewTheme(this.f7183I);
        C10752 c10752 = this.f7204w;
        groupCreatedItemView.f6941a.setOnClickListener(groupCreatedItemView.f6946f);
        groupCreatedItemView.f6942b.setOnClickListener(groupCreatedItemView.f6947g);
        groupCreatedItemView.f6944d = c10752;
        return groupCreatedItemView;
    }

    private View m6863c(boolean z) {
        ReceiptItemView receiptItemView = new ReceiptItemView(this.f7185d, z);
        DefaultThreadViewTheme defaultThreadViewTheme = this.f7183I;
        if (receiptItemView.f7357i != defaultThreadViewTheme) {
            if (receiptItemView.f7357i != null) {
                receiptItemView.f7357i.b(receiptItemView.f7355g);
            }
            receiptItemView.f7357i = defaultThreadViewTheme;
            if (receiptItemView.f7357i != null) {
                receiptItemView.f7357i.a(receiptItemView.f7355g);
                ReceiptItemView.m6992k(receiptItemView);
            }
        }
        return receiptItemView;
    }

    private View m6868k() {
        return new SeenHeadsSpaceView(this.f7185d);
    }

    private View m6869l() {
        TypingItemView typingItemView = new TypingItemView(this.f7185d);
        DefaultThreadViewTheme defaultThreadViewTheme = this.f7183I;
        if (typingItemView.f8146l != null) {
            typingItemView.f8146l.b(typingItemView.f8144j);
        }
        typingItemView.f8146l = defaultThreadViewTheme;
        if (typingItemView.f8146l != null) {
            typingItemView.f8146l.a(typingItemView.f8144j);
        }
        TypingItemView.m8060a(typingItemView);
        return typingItemView;
    }

    private View m6864d(ViewGroup viewGroup) {
        return this.f7192k.inflate(2130905750, viewGroup, false);
    }

    private View m6870m() {
        TimestampDividerItemView timestampDividerItemView = new TimestampDividerItemView(this.f7185d);
        DefaultThreadViewTheme defaultThreadViewTheme = this.f7183I;
        if (timestampDividerItemView.f8133e != null) {
            timestampDividerItemView.f8133e.b(timestampDividerItemView.f8130b);
        }
        timestampDividerItemView.f8133e = defaultThreadViewTheme;
        if (timestampDividerItemView.f8133e != null) {
            timestampDividerItemView.f8133e.a(timestampDividerItemView.f8130b);
            TimestampDividerItemView.m8057a(timestampDividerItemView);
        }
        return timestampDividerItemView;
    }

    private View m6871n() {
        HotLikePreviewItemView hotLikePreviewItemView = new HotLikePreviewItemView(this.f7185d);
        DefaultThreadViewTheme defaultThreadViewTheme = this.f7183I;
        if (hotLikePreviewItemView.f8177h != null) {
            hotLikePreviewItemView.f8177h.b(hotLikePreviewItemView.f8176g);
        }
        hotLikePreviewItemView.f8177h = defaultThreadViewTheme;
        if (hotLikePreviewItemView.f8177h != null) {
            hotLikePreviewItemView.f8177h.a(hotLikePreviewItemView.f8176g);
        }
        HotLikePreviewItemView.m8086b(hotLikePreviewItemView);
        hotLikePreviewItemView.setOnClickListener(this.f7207z);
        return hotLikePreviewItemView;
    }

    private View m6872o() {
        ContextBannerView contextBannerView = new ContextBannerView(this.f7185d);
        DefaultThreadViewTheme defaultThreadViewTheme = this.f7183I;
        if (contextBannerView.f2242k != null) {
            contextBannerView.f2242k.b(contextBannerView.f2234c);
        }
        contextBannerView.f2242k = defaultThreadViewTheme;
        if (contextBannerView.f2242k != null) {
            contextBannerView.f2242k.a(contextBannerView.f2234c);
            ContextBannerView.m2109c(contextBannerView);
        }
        return contextBannerView;
    }

    private View m6873p() {
        ThreadThemePickerView threadThemePickerView = new ThreadThemePickerView(this.f7185d);
        threadThemePickerView.setThreadViewTheme(this.f7183I);
        threadThemePickerView.f7448j = this.f7176B;
        threadThemePickerView.f7445g = "inline";
        return threadThemePickerView;
    }

    private View m6874q() {
        EmojilikePickerView emojilikePickerView = new EmojilikePickerView(this.f7185d);
        emojilikePickerView.setThreadViewTheme(this.f7183I);
        emojilikePickerView.f6911k = this.f7177C;
        emojilikePickerView.f6909i = "inline";
        return emojilikePickerView;
    }

    private View m6875r() {
        JourneyPromptSetupView journeyPromptSetupView = new JourneyPromptSetupView(this.f7185d);
        DefaultThreadViewTheme defaultThreadViewTheme = this.f7183I;
        if (journeyPromptSetupView.f7010k != null) {
            journeyPromptSetupView.f7010k.b(journeyPromptSetupView.f7005f);
        }
        journeyPromptSetupView.f7010k = defaultThreadViewTheme;
        if (journeyPromptSetupView.f7010k != null) {
            journeyPromptSetupView.f7010k.a(journeyPromptSetupView.f7005f);
            JourneyPromptSetupView.m6584b(journeyPromptSetupView);
        }
        return journeyPromptSetupView;
    }

    private View m6876s() {
        ThreadThemePickerView threadThemePickerView = new ThreadThemePickerView(this.f7185d);
        threadThemePickerView.setThreadViewTheme(this.f7183I);
        threadThemePickerView.f7448j = this.f7176B;
        threadThemePickerView.f7445g = "journey_prompt";
        return threadThemePickerView;
    }

    private View m6877t() {
        EmojilikePickerView emojilikePickerView = new EmojilikePickerView(this.f7185d);
        emojilikePickerView.setThreadViewTheme(this.f7183I);
        emojilikePickerView.f6909i = "journey_prompt";
        emojilikePickerView.f6911k = this.f7177C;
        return emojilikePickerView;
    }

    private View m6878u() {
        NicknamePromptView nicknamePromptView = new NicknamePromptView(this.f7185d);
        DefaultThreadViewTheme defaultThreadViewTheme = this.f7183I;
        if (nicknamePromptView.f7333i != null) {
            nicknamePromptView.f7333i.b(nicknamePromptView.f7337m);
        }
        nicknamePromptView.f7333i = defaultThreadViewTheme;
        if (nicknamePromptView.f7333i != null) {
            nicknamePromptView.f7333i.a(nicknamePromptView.f7337m);
            NicknamePromptView.m6977b(nicknamePromptView);
        }
        nicknamePromptView.f7336l = this.f7178D;
        return nicknamePromptView;
    }

    private View m6879v() {
        JourneyPromptBotView journeyPromptBotView = new JourneyPromptBotView(this.f7185d);
        journeyPromptBotView.f6997j = this.f7179E;
        DefaultThreadViewTheme defaultThreadViewTheme = this.f7183I;
        if (journeyPromptBotView.f6998k != null) {
            journeyPromptBotView.f6998k.b(journeyPromptBotView.f6992e);
        }
        journeyPromptBotView.f6998k = defaultThreadViewTheme;
        if (journeyPromptBotView.f6998k != null) {
            journeyPromptBotView.f6998k.a(journeyPromptBotView.f6992e);
            JourneyPromptBotView.m6580f(journeyPromptBotView);
        }
        return journeyPromptBotView;
    }

    private View m6880w() {
        AdminMessageWithLinkView adminMessageWithLinkView = new AdminMessageWithLinkView(this.f7185d);
        adminMessageWithLinkView.f6841e = this.f7206y;
        DefaultThreadViewTheme defaultThreadViewTheme = this.f7183I;
        if (adminMessageWithLinkView.f6843g != null) {
            adminMessageWithLinkView.f6843g.b(adminMessageWithLinkView.f6838b);
        }
        adminMessageWithLinkView.f6843g = defaultThreadViewTheme;
        if (adminMessageWithLinkView.f6843g != null) {
            adminMessageWithLinkView.f6843g.a(adminMessageWithLinkView.f6838b);
            AdminMessageWithLinkView.m6499b(adminMessageWithLinkView);
        }
        return adminMessageWithLinkView;
    }

    private View m6881x() {
        return new GloballyDeletedMessagePlaceholderItemView(this.f7185d);
    }

    private View m6882y() {
        BusinessNuxView businessNuxView = new BusinessNuxView(this.f7185d);
        DefaultThreadViewTheme defaultThreadViewTheme = this.f7183I;
        if (businessNuxView.g != null) {
            businessNuxView.g.b(businessNuxView.i);
        }
        businessNuxView.g = defaultThreadViewTheme;
        if (businessNuxView.g != null) {
            businessNuxView.g.a(businessNuxView.i);
            BusinessNuxView.a(businessNuxView);
        }
        return businessNuxView;
    }

    private View m6883z() {
        return new BusinessGreetingView(this.f7185d);
    }

    final void m6886a(View view, RowItem rowItem) {
        TracerDetour.a("MessageListAdapter#bindView", -157503537);
        try {
            switch (this.f7201t.m8237a(rowItem)) {
                case MESSAGE_WITH_XMA_HSCROLL:
                case MESSAGE_WITH_XMA_HSCROLL_ME_USER:
                    m6848a((MessageHScrollAttachmentView) view, (RowMessageItem) rowItem);
                    break;
                case MESSAGE:
                case MESSAGE_WITH_1_IMAGE_LANDSCAPE:
                case MESSAGE_WITH_1_IMAGE_PORTRAIT_SQUARE:
                case MESSAGE_WITH_2_IMAGES:
                case MESSAGE_WITH_3_IMAGES:
                case MESSAGE_WITH_4_IMAGES:
                case MESSAGE_WITH_5_IMAGES:
                case MESSAGE_WITH_6_OR_MORE_IMAGES:
                case MESSAGE_WITH_AUDIO:
                case MESSAGE_WITH_XMA:
                case MESSAGE_ME_USER:
                case MESSAGE_WITH_1_IMAGE_LANDSCAPE_ME_USER:
                case MESSAGE_WITH_1_IMAGE_PORTRAIT_SQUARE_ME_USER:
                case MESSAGE_WITH_2_IMAGES_ME_USER:
                case MESSAGE_WITH_3_IMAGES_ME_USER:
                case MESSAGE_WITH_4_IMAGES_ME_USER:
                case MESSAGE_WITH_5_IMAGES_ME_USER:
                case MESSAGE_WITH_6_OR_MORE_IMAGES_ME_USER:
                case MESSAGE_WITH_AUDIO_ME_USER:
                case MESSAGE_WITH_XMA_ME_USER:
                    m6849a((MessageItemView) view, (RowMessageItem) rowItem);
                    break;
                case MONTAGE_STATUS:
                    m6850a((MontageStatusItemView) view, (RowMontageStatusItem) rowItem);
                    break;
                case ADMIN_MESSAGE:
                case RIDE_ORDERED_MESSAGE:
                    m6840a((AdminMessageItemView) view, (RowMessageItem) rowItem);
                    break;
                case GROUP_CREATED:
                    m6845a((GroupCreatedItemView) view, (RowGroupCreatedItem) rowItem);
                    break;
                case RECEIPT_MESSAGE:
                case RECEIPT_MESSAGE_ME_USER:
                    m6852a((ReceiptItemView) view, (RowReceiptItem) rowItem);
                    break;
                case SEEN_HEADS:
                    m6853a((SeenHeadsSpaceView) view, (RowReceiptItem) rowItem);
                    break;
                case TYPING:
                    m6857a((TypingItemView) view, (RowTypingItem) rowItem);
                    break;
                case TIMESTAMP_DIVIDER:
                    m6856a((TimestampDividerItemView) view, (RowTimestampDividerItem) rowItem);
                    break;
                case HOT_LIKE_PREVIEW:
                    m6858a((HotLikePreviewItemView) view, (RowHotLikePreviewItem) rowItem);
                    break;
                case SOCIAL_CONTEXT:
                    m6839a((ContextBannerView) view, (RowSocialContextItem) rowItem);
                    break;
                case THEME_PICKER:
                    m6855a((ThreadThemePickerView) view, (RowThemePickerItem) rowItem);
                    break;
                case EMOJILIKE_PICKER:
                    m6842a((EmojilikePickerView) view, (RowEmojilikePickerItem) rowItem);
                    break;
                case JOURNEY_PROMPT_SETUP:
                    m6847a((JourneyPromptSetupView) view, (RowMessageItem) rowItem);
                    break;
                case JOURNEY_PROMPT_COLOR:
                    if (!((Boolean) this.f7189h.get()).booleanValue()) {
                        m6840a((AdminMessageItemView) view, (RowMessageItem) rowItem);
                        break;
                    } else {
                        m6854a((ThreadThemePickerView) view, (RowMessageItem) rowItem);
                        break;
                    }
                case JOURNEY_PROMPT_LIKE:
                    if (!((Boolean) this.f7191j.get()).booleanValue()) {
                        m6840a((AdminMessageItemView) view, (RowMessageItem) rowItem);
                        break;
                    } else {
                        m6843a((EmojilikePickerView) view, (RowMessageItem) rowItem);
                        break;
                    }
                case JOURNEY_PROMPT_NICKNAME:
                    if (!((Boolean) this.f7190i.get()).booleanValue()) {
                        m6840a((AdminMessageItemView) view, (RowMessageItem) rowItem);
                        break;
                    } else {
                        m6851a((NicknamePromptView) view, (RowMessageItem) rowItem);
                        break;
                    }
                case JOURNEY_PROMPT_BOT:
                    if (!this.f7188g.a(910, false)) {
                        m6840a((AdminMessageItemView) view, (RowMessageItem) rowItem);
                        break;
                    } else {
                        m6846a((JourneyPromptBotView) view, (RowMessageItem) rowItem);
                        break;
                    }
                case ADMIN_TEXT_WITH_LINK:
                    m6841a((AdminMessageWithLinkView) view, (RowMessageItem) rowItem);
                    break;
                case GLOBALLY_DELETED_MESSAGE_PLACEHOLDER:
                    m6844a((GloballyDeletedMessagePlaceholderItemView) view, (RowGloballyDeletedMessagePlaceholderItem) rowItem);
                    break;
                case BUSINESS_NUX:
                    m6838a((BusinessNuxView) view, (RowBusinessNuxItem) rowItem);
                    break;
                case BUSINESS_GREETING:
                    m6837a((BusinessGreetingView) view, (RowBusinessGreetingItem) rowItem);
                    break;
            }
            TracerDetour.a(-1156397472);
        } catch (Throwable th) {
            TracerDetour.a(-1650028695);
        }
    }

    private static void m6848a(MessageHScrollAttachmentView messageHScrollAttachmentView, RowMessageItem rowMessageItem) {
        messageHScrollAttachmentView.setRowMessageItem(rowMessageItem);
    }

    private void m6849a(MessageItemView messageItemView, RowMessageItem rowMessageItem) {
        messageItemView.setRowMessageItem(rowMessageItem);
        if (MessageUtil.R(rowMessageItem.f4732a) || this.f7187f.a(rowMessageItem.f4732a)) {
            HotLikesAnimationManager hotLikesAnimationManager = this.f7195n;
            if (messageItemView.be == null) {
                messageItemView.be = new HotLikesViewAnimationHelper(messageItemView.f7122G, messageItemView.aD.a());
            }
            HotLikesViewAnimationHelper hotLikesViewAnimationHelper = messageItemView.be;
            HotLikesAnimationState hotLikesAnimationState = (HotLikesAnimationState) hotLikesAnimationManager.f8187g.get(rowMessageItem.f4732a.n);
            if (hotLikesAnimationState == null) {
                hotLikesViewAnimationHelper.f8215e.setRotation(0.0f);
                hotLikesViewAnimationHelper.f8214d.requestLayout();
            } else {
                hotLikesAnimationState.f8210n = hotLikesViewAnimationHelper;
            }
        }
        if (this.f7200s.a(rowMessageItem.f4732a) == MessageClassification.PAYMENT) {
            PaymentsAnimationManager paymentsAnimationManager = this.f7197p;
            ValueAnimator valueAnimator = (ValueAnimator) paymentsAnimationManager.f7342a.get(rowMessageItem.f4732a.n);
            if (valueAnimator != null && valueAnimator.isRunning()) {
                AnimatingItemInfo animatingItemInfo = new AnimatingItemInfo();
                rowMessageItem.f4754w = animatingItemInfo;
                if (rowMessageItem.f4747p != null) {
                    MessageItemView.ad(rowMessageItem.f4747p.f7105a);
                }
                AnimatorUpdateListener c11022 = new C11022(paymentsAnimationManager, animatingItemInfo);
                valueAnimator.removeAllUpdateListeners();
                valueAnimator.addUpdateListener(c11022);
            }
        }
        if (rowMessageItem.f4739h) {
            this.f7193l.m7056a(rowMessageItem);
        }
        this.f7194m.m6560b(rowMessageItem);
        this.f7196o.m6616a(rowMessageItem);
    }

    private static void m6840a(AdminMessageItemView adminMessageItemView, RowMessageItem rowMessageItem) {
        adminMessageItemView.setRowMessageItem(rowMessageItem);
    }

    private static void m6845a(GroupCreatedItemView groupCreatedItemView, RowGroupCreatedItem rowGroupCreatedItem) {
        groupCreatedItemView.m6564a(rowGroupCreatedItem);
    }

    private static void m6852a(ReceiptItemView receiptItemView, RowReceiptItem rowReceiptItem) {
        receiptItemView.setRowReceiptItem(rowReceiptItem);
    }

    private static void m6853a(SeenHeadsSpaceView seenHeadsSpaceView, RowReceiptItem rowReceiptItem) {
        seenHeadsSpaceView.setRowReceiptItem(rowReceiptItem);
    }

    private void m6858a(HotLikePreviewItemView hotLikePreviewItemView, RowHotLikePreviewItem rowHotLikePreviewItem) {
        HotLikesAnimationManager hotLikesAnimationManager = this.f7195n;
        HotLikesViewAnimationHelper hotLikesViewAnimationHelper = hotLikePreviewItemView.f8174e;
        HotLikesAnimationState hotLikesAnimationState = (HotLikesAnimationState) hotLikesAnimationManager.f8187g.get(rowHotLikePreviewItem.f4731a);
        if (hotLikesAnimationState != null) {
            hotLikesViewAnimationHelper.m8101a(hotLikesAnimationState);
            hotLikesAnimationState.f8210n = hotLikesViewAnimationHelper;
        }
    }

    private void m6839a(ContextBannerView contextBannerView, RowSocialContextItem rowSocialContextItem) {
        this.f7186e.m6520a(rowSocialContextItem, contextBannerView, this.f7205x);
    }

    private static void m6855a(ThreadThemePickerView threadThemePickerView, RowThemePickerItem rowThemePickerItem) {
        threadThemePickerView.setThreadKey(rowThemePickerItem.f4772a);
    }

    private static void m6842a(EmojilikePickerView emojilikePickerView, RowEmojilikePickerItem rowEmojilikePickerItem) {
        emojilikePickerView.setThreadKey(rowEmojilikePickerItem.f4727a);
    }

    private static void m6854a(ThreadThemePickerView threadThemePickerView, RowMessageItem rowMessageItem) {
        Preconditions.checkNotNull(rowMessageItem.f4732a.I);
        threadThemePickerView.setThreadKey(rowMessageItem.f4732a.b);
        threadThemePickerView.setColorChoices(rowMessageItem.f4732a.I.i);
    }

    private static void m6843a(EmojilikePickerView emojilikePickerView, RowMessageItem rowMessageItem) {
        Preconditions.checkNotNull(rowMessageItem.f4732a.I);
        emojilikePickerView.setThreadKey(rowMessageItem.f4732a.b);
        List list = rowMessageItem.f4732a.I.j;
        if (list != null) {
            emojilikePickerView.f6902b.a(list);
        }
    }

    private static void m6851a(NicknamePromptView nicknamePromptView, RowMessageItem rowMessageItem) {
        String str;
        String str2;
        Object string;
        Preconditions.checkNotNull(rowMessageItem.f4732a.I);
        ThreadKey threadKey = rowMessageItem.f4732a.b;
        ImmutableList immutableList = rowMessageItem.f4732a.I.k;
        int i = 0;
        nicknamePromptView.f7334j = null;
        nicknamePromptView.f7335k = null;
        User user = (User) nicknamePromptView.f7327c.get();
        String str3 = user.a;
        boolean z = threadKey.b() || threadKey.e();
        int size = immutableList.size();
        for (int i2 = 0; i2 < size; i2++) {
            NicknameChoice nicknameChoice = (NicknameChoice) immutableList.get(i2);
            if (str3.equals(nicknameChoice.participantId) == z) {
                str = nicknameChoice.participantId;
                nicknamePromptView.f7335k = nicknameChoice.suggestions;
                str2 = str;
                break;
            }
        }
        str2 = null;
        str = "";
        if (z) {
            nicknamePromptView.f7334j = user;
            string = nicknamePromptView.getResources().getString(2131231856);
        } else {
            nicknamePromptView.f7334j = nicknamePromptView.f7326b.a(UserKey.b(str2));
            if (nicknamePromptView.f7334j != null) {
                string = nicknamePromptView.getResources().getString(2131231857, new Object[]{nicknamePromptView.f7334j.h()});
            } else {
                String str4 = str;
            }
        }
        nicknamePromptView.f7328d.setText(string);
        nicknamePromptView.f7329e.setText(nicknamePromptView.f7325a.m2128a(threadKey));
        RecyclerView recyclerView = nicknamePromptView.f7330f;
        if (string.length() <= 0) {
            i = 8;
        }
        recyclerView.setVisibility(i);
        nicknamePromptView.f7332h.notifyDataSetChanged();
    }

    private void m6841a(AdminMessageWithLinkView adminMessageWithLinkView, RowMessageItem rowMessageItem) {
        AdminMessageWithLinkViewModel a;
        AdminMessageWithLinkViewModelFactory adminMessageWithLinkViewModelFactory = (AdminMessageWithLinkViewModelFactory) this.f7202u.get();
        Builder builder;
        if (MessageUtil.H(rowMessageItem.f4732a)) {
            int i = rowMessageItem.f4732a.I.d;
            Drawable mutate = adminMessageWithLinkViewModelFactory.f6855b.getDrawable(2130838336).mutate();
            if (i == 0) {
                i = adminMessageWithLinkViewModelFactory.f6855b.getColor(2131362241);
            }
            mutate.setColorFilter(i, Mode.SRC_ATOP);
            builder = new Builder();
            builder.f6845b = mutate;
            builder = builder;
            builder.f6846c = 2;
            builder = builder;
            builder.f6847d = rowMessageItem.f4732a.f;
            a = builder.m6500a();
        } else if (MessageUtil.s(rowMessageItem.f4732a)) {
            boolean z;
            builder = new Builder();
            builder.f6847d = rowMessageItem.f4732a.f;
            builder = builder;
            Message message = rowMessageItem.f4732a;
            if (MessageUtil.s(message)) {
                EphemeralGatingUtil ephemeralGatingUtil = adminMessageWithLinkViewModelFactory.f6854a;
                boolean z2 = false;
                if (ephemeralGatingUtil.a.a(215, false) && MessageUtil.s(message) && !ephemeralGatingUtil.a()) {
                    z2 = true;
                }
                if (!z2) {
                    z = true;
                    builder.f6844a = z;
                    a = builder.m6500a();
                }
            }
            z = false;
            builder.f6844a = z;
            a = builder.m6500a();
        } else if (MessageUtil.L(rowMessageItem.f4732a)) {
            builder = new Builder();
            builder.f6847d = rowMessageItem.f4732a.f;
            builder = builder;
            builder.f6848e = adminMessageWithLinkViewModelFactory.f6855b.getString(2131240814);
            a = builder.m6500a();
        } else {
            builder = new Builder();
            builder.f6847d = rowMessageItem.f4732a.f;
            a = builder.m6500a();
        }
        AdminMessageWithLinkViewModel adminMessageWithLinkViewModel = a;
        adminMessageWithLinkView.f6839c.setImageDrawable(adminMessageWithLinkViewModel.f6850b);
        adminMessageWithLinkView.f6839c.setOrientation(adminMessageWithLinkViewModel.f6851c);
        adminMessageWithLinkView.f6839c.setText(adminMessageWithLinkViewModel.f6852d);
        adminMessageWithLinkView.f6840d.setVisibility(adminMessageWithLinkViewModel.f6849a ? 8 : 0);
        if (Strings.isNullOrEmpty(adminMessageWithLinkViewModel.f6853e)) {
            adminMessageWithLinkView.f6840d.setText(2131231794);
        } else {
            adminMessageWithLinkView.f6840d.setText(adminMessageWithLinkViewModel.f6853e);
        }
        Preconditions.checkNotNull(rowMessageItem.f4732a.I);
        adminMessageWithLinkView.f6842f = rowMessageItem;
    }
}
