package com.facebook.orca.threadview;

import com.facebook.auth.module.UserKey_ViewerContextUserKeyMethodAutoProvider;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.util.StringUtil;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.attachments.AttachmentDataFactory;
import com.facebook.messaging.business.common.loader.BusinessGreetingContentsLoader;
import com.facebook.messaging.business.common.loader.BusinessNuxContentsLoader;
import com.facebook.messaging.contextbanner.ContextItemsFuturesGenerator;
import com.facebook.messaging.contextbanner.ContextRowHelper;
import com.facebook.messaging.contextbanner.model.ContextItems;
import com.facebook.messaging.customthreads.CustomThreadsHoldout;
import com.facebook.messaging.customthreads.DefaultThreadViewTheme;
import com.facebook.messaging.customthreads.EmojilikeNuxAnchorProvider;
import com.facebook.messaging.customthreads.ThreadViewTheme;
import com.facebook.messaging.deliveryreceipt.MessageDeliveredReadInfo;
import com.facebook.messaging.deliveryreceipt.MessageDeliveredReadInfo.Type;
import com.facebook.messaging.deliveryreceipt.MessageReceiptCalculationUtil;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.messages.MessageUserUtil;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.send.SendErrorType;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.montage.MontageTestHelper;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.thread.PaymentRowMessageItemHelper;
import com.facebook.messaging.payment.thread.model.ThreadPaymentTransactionData;
import com.facebook.messaging.photos.tiles.MessengerThreadTileViewDataFactory;
import com.facebook.messaging.threadview.rows.RowBusinessGreetingItem;
import com.facebook.messaging.threadview.rows.RowBusinessNuxItem;
import com.facebook.messaging.threadview.rows.RowHotLikePreviewItem;
import com.facebook.messaging.threadview.rows.RowItem;
import com.facebook.messaging.threadview.rows.RowItemDeliveryState;
import com.facebook.messaging.threadview.rows.RowMessageItem;
import com.facebook.messaging.threadview.rows.RowReceiptItem;
import com.facebook.messaging.threadview.rows.RowSocialContextItem;
import com.facebook.messaging.threadview.rows.RowSpacerItem;
import com.facebook.messaging.threadview.rows.RowTimestampDividerItem;
import com.facebook.messaging.threadview.rows.RowType;
import com.facebook.messaging.ui.name.MessengerThreadNameViewDataFactory;
import com.facebook.messaging.ui.name.ThreadNameViewData;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.facebook.user.model.User.CommercePageSetting;
import com.facebook.user.model.UserKey;
import com.facebook.widget.tiles.ThreadTileViewData;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListenableFuture;
import java.security.InvalidParameterException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: message_link_clicked_type */
public class RowMessageItemGenerator {
    private static final Object f7379v = new Object();
    private final AttachmentDataFactory f7380a;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ContextItemsFuturesGenerator> f7381b = UltralightRuntime.b();
    private final ContextRowHelper f7382c;
    private final EmojilikeNuxAnchorProvider f7383d;
    private final Provider<Boolean> f7384e;
    private final Provider<Boolean> f7385f;
    private final Provider<Boolean> f7386g;
    private final MessageReceiptCalculationUtil f7387h;
    private final MessageUserUtil f7388i;
    private final MessageUtil f7389j;
    private final MessengerThreadNameViewDataFactory f7390k;
    private final MessengerThreadTileViewDataFactory f7391l;
    private final MontageTestHelper f7392m;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PaymentRowMessageItemHelper> f7393n = UltralightRuntime.b();
    private final RowItemUiUtil f7394o;
    private final UserKey f7395p;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<CustomThreadsHoldout> f7396q = UltralightRuntime.b();
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<BusinessNuxContentsLoader> f7397r = UltralightRuntime.b();
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<BusinessGreetingContentsLoader> f7398s = UltralightRuntime.b();
    private final GatekeeperStoreImpl f7399t;
    private final Provider<UserCache> f7400u;

    /* compiled from: message_link_clicked_type */
    /* synthetic */ class C11071 {
        static final /* synthetic */ int[] f7378a = new int[Type.values().length];

        static {
            try {
                f7378a[Type.READER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f7378a[Type.SENDER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f7378a[Type.DELIVEREE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private java.util.List<com.facebook.messaging.threadview.rows.RowItem> m7037a(java.util.List<com.facebook.messaging.model.messages.Message> r36, com.facebook.messaging.model.threads.ThreadSummary r37, java.util.Set<java.lang.String> r38, boolean r39, @javax.annotation.Nullable com.facebook.messaging.model.messages.ParticipantInfo r40, java.util.Collection<com.facebook.messaging.threadview.rows.RowHotLikePreviewItem> r41, com.facebook.messaging.customthreads.ThreadViewTheme r42, boolean r43, boolean r44) {
        /* JADX: method processing error */
/*
Error: java.lang.OutOfMemoryError: Java heap space
	at java.util.Arrays.copyOf(Arrays.java:3181)
	at java.util.ArrayList.grow(ArrayList.java:261)
	at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:235)
	at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:227)
	at java.util.ArrayList.add(ArrayList.java:458)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:463)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
*/
        /*
        r35 = this;
        r32 = com.google.common.collect.Lists.a();
        r4 = "RMIG-generate";
        r5 = -1656686108; // 0xffffffff9d40f9e4 float:-2.5540179E-21 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r4, r5);
        r0 = r37;	 Catch:{ all -> 0x02a5 }
        r0 = r0.a;	 Catch:{ all -> 0x02a5 }
        r33 = r0;	 Catch:{ all -> 0x02a5 }
        r7 = com.google.common.collect.Lists.a(r36);	 Catch:{ all -> 0x02a5 }
        r0 = r35;	 Catch:{ all -> 0x02a5 }
        r4 = r0.f7387h;	 Catch:{ all -> 0x02a5 }
        r0 = r35;	 Catch:{ all -> 0x02a5 }
        r5 = r0.f7395p;	 Catch:{ all -> 0x02a5 }
        r0 = r37;	 Catch:{ all -> 0x02a5 }
        r1 = r43;	 Catch:{ all -> 0x02a5 }
        r9 = r4.a(r7, r0, r5, r1);	 Catch:{ all -> 0x02a5 }
        r6 = 0;	 Catch:{ all -> 0x02a5 }
        r5 = 0;	 Catch:{ all -> 0x02a5 }
        r8 = r7.iterator();	 Catch:{ all -> 0x02a5 }
    L_0x002c:
        r4 = r8.hasNext();	 Catch:{ all -> 0x02a5 }
        if (r4 == 0) goto L_0x0055;	 Catch:{ all -> 0x02a5 }
    L_0x0032:
        r4 = r8.next();	 Catch:{ all -> 0x02a5 }
        r4 = (com.facebook.messaging.model.messages.Message) r4;	 Catch:{ all -> 0x02a5 }
        r0 = r35;	 Catch:{ all -> 0x02a5 }
        r10 = r0.f7388i;	 Catch:{ all -> 0x02a5 }
        r10 = r10.a(r4);	 Catch:{ all -> 0x02a5 }
        if (r6 != 0) goto L_0x0045;	 Catch:{ all -> 0x02a5 }
    L_0x0042:
        if (r10 == 0) goto L_0x0045;	 Catch:{ all -> 0x02a5 }
    L_0x0044:
        r6 = r4;	 Catch:{ all -> 0x02a5 }
    L_0x0045:
        if (r5 != 0) goto L_0x03f7;	 Catch:{ all -> 0x02a5 }
    L_0x0047:
        if (r10 != 0) goto L_0x03f7;	 Catch:{ all -> 0x02a5 }
    L_0x0049:
        r10 = r4.l;	 Catch:{ all -> 0x02a5 }
        r11 = com.facebook.messaging.model.messages.MessageType.GLOBALLY_DELETED_MESSAGE_PLACEHOLDER;	 Catch:{ all -> 0x02a5 }
        if (r10 == r11) goto L_0x03f7;	 Catch:{ all -> 0x02a5 }
    L_0x004f:
        if (r6 == 0) goto L_0x0053;	 Catch:{ all -> 0x02a5 }
    L_0x0051:
        if (r4 != 0) goto L_0x03fa;	 Catch:{ all -> 0x02a5 }
    L_0x0053:
        r5 = r4;	 Catch:{ all -> 0x02a5 }
        goto L_0x002c;	 Catch:{ all -> 0x02a5 }
    L_0x0055:
        r30 = r5;	 Catch:{ all -> 0x02a5 }
        r31 = r6;	 Catch:{ all -> 0x02a5 }
    L_0x0059:
        r5 = 0;	 Catch:{ all -> 0x02a5 }
        r0 = r35;	 Catch:{ all -> 0x02a5 }
        r1 = r33;	 Catch:{ all -> 0x02a5 }
        r2 = r42;	 Catch:{ all -> 0x02a5 }
        r4 = r0.m7042a(r1, r2);	 Catch:{ all -> 0x02a5 }
        if (r4 == 0) goto L_0x03f3;	 Catch:{ all -> 0x02a5 }
    L_0x0066:
        r0 = r35;	 Catch:{ all -> 0x02a5 }
        r4 = r0.f7383d;	 Catch:{ all -> 0x02a5 }
        r0 = r33;	 Catch:{ all -> 0x02a5 }
        r4 = r4.a(r0);	 Catch:{ all -> 0x02a5 }
        if (r4 == 0) goto L_0x03f3;	 Catch:{ all -> 0x02a5 }
    L_0x0072:
        r6 = r7.iterator();	 Catch:{ all -> 0x02a5 }
    L_0x0076:
        r4 = r6.hasNext();	 Catch:{ all -> 0x02a5 }
        if (r4 == 0) goto L_0x03f3;	 Catch:{ all -> 0x02a5 }
    L_0x007c:
        r4 = r6.next();	 Catch:{ all -> 0x02a5 }
        r4 = (com.facebook.messaging.model.messages.Message) r4;	 Catch:{ all -> 0x02a5 }
        r0 = r35;	 Catch:{ all -> 0x02a5 }
        r7 = r0.f7383d;	 Catch:{ all -> 0x02a5 }
        r0 = r33;	 Catch:{ all -> 0x02a5 }
        r7 = r7.a(r0, r4);	 Catch:{ all -> 0x02a5 }
        if (r7 == 0) goto L_0x0076;	 Catch:{ all -> 0x02a5 }
    L_0x008e:
        r29 = r4;	 Catch:{ all -> 0x02a5 }
    L_0x0090:
        r0 = r35;	 Catch:{ all -> 0x02a5 }
        r4 = r0.f7385f;	 Catch:{ all -> 0x02a5 }
        r4 = r4.get();	 Catch:{ all -> 0x02a5 }
        r4 = (java.lang.Boolean) r4;	 Catch:{ all -> 0x02a5 }
        r12 = r4.booleanValue();	 Catch:{ all -> 0x02a5 }
        r0 = r35;	 Catch:{ all -> 0x02a5 }
        r1 = r33;	 Catch:{ all -> 0x02a5 }
        r34 = r0.m7036a(r1);	 Catch:{ all -> 0x02a5 }
        r0 = r35;	 Catch:{ all -> 0x02a5 }
        r4 = r0.f7400u;	 Catch:{ all -> 0x02a5 }
        r11 = r4.get();	 Catch:{ all -> 0x02a5 }
        r11 = (com.facebook.user.cache.UserCache) r11;	 Catch:{ all -> 0x02a5 }
        r4 = 0;	 Catch:{ all -> 0x02a5 }
        r28 = r4;	 Catch:{ all -> 0x02a5 }
    L_0x00b3:
        r4 = r36.size();	 Catch:{ all -> 0x02a5 }
        r0 = r28;	 Catch:{ all -> 0x02a5 }
        if (r0 >= r4) goto L_0x0359;	 Catch:{ all -> 0x02a5 }
    L_0x00bb:
        r0 = r36;	 Catch:{ all -> 0x02a5 }
        r1 = r28;	 Catch:{ all -> 0x02a5 }
        r5 = r0.get(r1);	 Catch:{ all -> 0x02a5 }
        r5 = (com.facebook.messaging.model.messages.Message) r5;	 Catch:{ all -> 0x02a5 }
        r0 = r35;	 Catch:{ all -> 0x02a5 }
        r4 = r0.f7388i;	 Catch:{ all -> 0x02a5 }
        r14 = r4.a(r5);	 Catch:{ all -> 0x02a5 }
        r18 = 0;	 Catch:{ all -> 0x02a5 }
        r4 = r9.get(r5);	 Catch:{ all -> 0x02a5 }
        r4 = (com.facebook.messaging.deliveryreceipt.MessageDeliveredReadInfo) r4;	 Catch:{ all -> 0x02a5 }
        if (r4 == 0) goto L_0x00df;	 Catch:{ all -> 0x02a5 }
    L_0x00d7:
        r0 = r37;	 Catch:{ all -> 0x02a5 }
        r1 = r43;	 Catch:{ all -> 0x02a5 }
        r18 = m7034a(r5, r4, r0, r14, r1);	 Catch:{ all -> 0x02a5 }
    L_0x00df:
        r0 = r35;	 Catch:{ all -> 0x02a5 }
        r4 = r0.f7395p;	 Catch:{ all -> 0x02a5 }
        r0 = r37;	 Catch:{ all -> 0x02a5 }
        r13 = com.facebook.messaging.deliveryreceipt.MessageReceiptCalculationUtil.a(r5, r0, r4);	 Catch:{ all -> 0x02a5 }
        if (r14 == 0) goto L_0x0271;	 Catch:{ all -> 0x02a5 }
    L_0x00eb:
        if (r30 == 0) goto L_0x026e;	 Catch:{ all -> 0x02a5 }
    L_0x00ed:
        r0 = r30;	 Catch:{ all -> 0x02a5 }
        r6 = r0.c;	 Catch:{ all -> 0x02a5 }
        r0 = r5.c;	 Catch:{ all -> 0x02a5 }
        r16 = r0;	 Catch:{ all -> 0x02a5 }
        r4 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1));	 Catch:{ all -> 0x02a5 }
        if (r4 <= 0) goto L_0x026e;	 Catch:{ all -> 0x02a5 }
    L_0x00f9:
        r10 = 1;	 Catch:{ all -> 0x02a5 }
    L_0x00fa:
        r4 = r5.n;	 Catch:{ all -> 0x02a5 }
        r0 = r38;	 Catch:{ all -> 0x02a5 }
        r6 = r0.contains(r4);	 Catch:{ all -> 0x02a5 }
        r0 = r35;	 Catch:{ all -> 0x02a5 }
        r8 = r0.f7395p;	 Catch:{ all -> 0x02a5 }
        r4 = r35;	 Catch:{ all -> 0x02a5 }
        r7 = r37;	 Catch:{ all -> 0x02a5 }
        r22 = r4.m7033a(r5, r6, r7, r8, r9, r10, r11, r12);	 Catch:{ all -> 0x02a5 }
    L_0x010e:
        r20 = com.facebook.messaging.threadview.rows.RowMessageItem.MessageRecency.OTHER;	 Catch:{ all -> 0x02a5 }
        r0 = r31;	 Catch:{ all -> 0x02a5 }
        if (r5 != r0) goto L_0x011c;	 Catch:{ all -> 0x02a5 }
    L_0x0114:
        r4 = r5.l;	 Catch:{ all -> 0x02a5 }
        r6 = com.facebook.messaging.model.messages.MessageType.REGULAR;	 Catch:{ all -> 0x02a5 }
        if (r4 != r6) goto L_0x011c;	 Catch:{ all -> 0x02a5 }
    L_0x011a:
        r20 = com.facebook.messaging.threadview.rows.RowMessageItem.MessageRecency.MOST_RECENT;	 Catch:{ all -> 0x02a5 }
    L_0x011c:
        if (r28 != 0) goto L_0x0275;	 Catch:{ all -> 0x02a5 }
    L_0x011e:
        r4 = 1;	 Catch:{ all -> 0x02a5 }
        r6 = r4;	 Catch:{ all -> 0x02a5 }
    L_0x0120:
        if (r6 == 0) goto L_0x0279;	 Catch:{ all -> 0x02a5 }
    L_0x0122:
        if (r39 == 0) goto L_0x0279;	 Catch:{ all -> 0x02a5 }
    L_0x0124:
        r4 = 1;	 Catch:{ all -> 0x02a5 }
        r10 = r4;	 Catch:{ all -> 0x02a5 }
    L_0x0126:
        if (r6 == 0) goto L_0x027d;	 Catch:{ all -> 0x02a5 }
    L_0x0128:
        r4 = 0;	 Catch:{ all -> 0x02a5 }
        r8 = r4;	 Catch:{ all -> 0x02a5 }
    L_0x012a:
        r4 = r28 + 1;	 Catch:{ all -> 0x02a5 }
        r6 = r36.size();	 Catch:{ all -> 0x02a5 }
        if (r4 >= r6) goto L_0x028a;	 Catch:{ all -> 0x02a5 }
    L_0x0132:
        r4 = r28 + 1;	 Catch:{ all -> 0x02a5 }
        r0 = r36;	 Catch:{ all -> 0x02a5 }
        r4 = r0.get(r4);	 Catch:{ all -> 0x02a5 }
        r4 = (com.facebook.messaging.model.messages.Message) r4;	 Catch:{ all -> 0x02a5 }
        r7 = r4;	 Catch:{ all -> 0x02a5 }
    L_0x013d:
        if (r7 != 0) goto L_0x028e;	 Catch:{ all -> 0x02a5 }
    L_0x013f:
        if (r40 == 0) goto L_0x028e;	 Catch:{ all -> 0x02a5 }
    L_0x0141:
        r0 = r35;	 Catch:{ all -> 0x02a5 }
        r4 = r0.f7394o;	 Catch:{ all -> 0x02a5 }
        r0 = r40;	 Catch:{ all -> 0x02a5 }
        r19 = r4.m7019a(r5, r10, r8, r0);	 Catch:{ all -> 0x02a5 }
    L_0x014b:
        r0 = r19;	 Catch:{ all -> 0x02a5 }
        r4 = r0.groupWithNewerRow;	 Catch:{ all -> 0x02a5 }
        if (r4 == 0) goto L_0x0155;	 Catch:{ all -> 0x02a5 }
    L_0x0151:
        if (r43 != 0) goto L_0x0155;	 Catch:{ all -> 0x02a5 }
    L_0x0153:
        r18 = 0;	 Catch:{ all -> 0x02a5 }
    L_0x0155:
        r25 = 0;	 Catch:{ all -> 0x02a5 }
        r4 = m7046b(r5);	 Catch:{ all -> 0x02a5 }
        if (r4 == 0) goto L_0x016b;	 Catch:{ all -> 0x02a5 }
    L_0x015d:
        r0 = r35;	 Catch:{ all -> 0x02a5 }
        r4 = r0.f7393n;	 Catch:{ all -> 0x02a5 }
        r4 = r4.get();	 Catch:{ all -> 0x02a5 }
        r4 = (com.facebook.messaging.payment.thread.PaymentRowMessageItemHelper) r4;	 Catch:{ all -> 0x02a5 }
        r25 = r4.a(r5);	 Catch:{ all -> 0x02a5 }
    L_0x016b:
        r26 = 0;	 Catch:{ all -> 0x02a5 }
        r4 = m7048c(r5);	 Catch:{ all -> 0x02a5 }
        if (r4 == 0) goto L_0x0181;	 Catch:{ all -> 0x02a5 }
    L_0x0173:
        r0 = r35;	 Catch:{ all -> 0x02a5 }
        r4 = r0.f7393n;	 Catch:{ all -> 0x02a5 }
        r4 = r4.get();	 Catch:{ all -> 0x02a5 }
        r4 = (com.facebook.messaging.payment.thread.PaymentRowMessageItemHelper) r4;	 Catch:{ all -> 0x02a5 }
        r26 = r4.b(r5);	 Catch:{ all -> 0x02a5 }
    L_0x0181:
        r4 = r5.l;	 Catch:{ all -> 0x02a5 }
        r6 = com.facebook.messaging.model.messages.MessageType.GLOBALLY_DELETED_MESSAGE_PLACEHOLDER;	 Catch:{ all -> 0x02a5 }
        if (r4 != r6) goto L_0x0298;	 Catch:{ all -> 0x02a5 }
    L_0x0187:
        r6 = new com.facebook.messaging.threadview.rows.RowGloballyDeletedMessagePlaceholderItem;	 Catch:{ all -> 0x02a5 }
        r0 = r19;	 Catch:{ all -> 0x02a5 }
        r6.<init>(r5, r0);	 Catch:{ all -> 0x02a5 }
    L_0x018e:
        r0 = r35;	 Catch:{ all -> 0x02a5 }
        r4 = r0.f7382c;	 Catch:{ all -> 0x02a5 }
        r0 = r33;	 Catch:{ all -> 0x02a5 }
        r1 = r34;	 Catch:{ all -> 0x02a5 }
        r4 = r4.m2013a(r10, r0, r1);	 Catch:{ all -> 0x02a5 }
        if (r4 == 0) goto L_0x01dd;	 Catch:{ all -> 0x02a5 }
    L_0x019c:
        r4 = com.facebook.messaging.model.threadkey.ThreadKey.b(r33);	 Catch:{ all -> 0x02a5 }
        if (r4 != 0) goto L_0x01a8;	 Catch:{ all -> 0x02a5 }
    L_0x01a2:
        r4 = com.facebook.messaging.model.threadkey.ThreadKey.g(r33);	 Catch:{ all -> 0x02a5 }
        if (r4 == 0) goto L_0x02ea;	 Catch:{ all -> 0x02a5 }
    L_0x01a8:
        r0 = r35;	 Catch:{ all -> 0x02a5 }
        r4 = r0.f7381b;	 Catch:{ all -> 0x02a5 }
        r4 = r4.get();	 Catch:{ all -> 0x02a5 }
        r4 = (com.facebook.messaging.contextbanner.ContextItemsFuturesGenerator) r4;	 Catch:{ all -> 0x02a5 }
        r0 = r34;	 Catch:{ all -> 0x02a5 }
        r1 = r33;	 Catch:{ all -> 0x02a5 }
        r2 = r37;	 Catch:{ all -> 0x02a5 }
        r4 = r4.m2007a(r0, r1, r2);	 Catch:{ all -> 0x02a5 }
    L_0x01bc:
        r0 = r35;	 Catch:{ all -> 0x02a5 }
        r13 = r0.f7390k;	 Catch:{ all -> 0x02a5 }
        r0 = r37;	 Catch:{ all -> 0x02a5 }
        r13 = r13.a(r0);	 Catch:{ all -> 0x02a5 }
        r0 = r35;	 Catch:{ all -> 0x02a5 }
        r14 = r0.f7391l;	 Catch:{ all -> 0x02a5 }
        r0 = r37;	 Catch:{ all -> 0x02a5 }
        r14 = r14.a(r0);	 Catch:{ all -> 0x02a5 }
        r0 = r33;	 Catch:{ all -> 0x02a5 }
        r1 = r34;	 Catch:{ all -> 0x02a5 }
        r4 = m7032a(r4, r0, r1, r13, r14);	 Catch:{ all -> 0x02a5 }
        r0 = r32;	 Catch:{ all -> 0x02a5 }
        r0.add(r4);	 Catch:{ all -> 0x02a5 }
    L_0x01dd:
        r0 = r36;	 Catch:{ all -> 0x02a5 }
        r1 = r34;	 Catch:{ all -> 0x02a5 }
        r4 = m7043a(r0, r1);	 Catch:{ all -> 0x02a5 }
        if (r4 == 0) goto L_0x0205;	 Catch:{ all -> 0x02a5 }
    L_0x01e7:
        r13 = new com.facebook.messaging.threadview.rows.RowBusinessNuxItem;	 Catch:{ all -> 0x02a5 }
        r0 = r35;	 Catch:{ all -> 0x02a5 }
        r4 = r0.f7397r;	 Catch:{ all -> 0x02a5 }
        r4 = r4.get();	 Catch:{ all -> 0x02a5 }
        r4 = (com.facebook.messaging.business.common.loader.BusinessNuxContentsLoader) r4;	 Catch:{ all -> 0x02a5 }
        r14 = r34.d();	 Catch:{ all -> 0x02a5 }
        r4 = r4.a(r14);	 Catch:{ all -> 0x02a5 }
        r0 = r33;	 Catch:{ all -> 0x02a5 }
        r13.<init>(r4, r0);	 Catch:{ all -> 0x02a5 }
        r0 = r32;	 Catch:{ all -> 0x02a5 }
        r0.add(r13);	 Catch:{ all -> 0x02a5 }
    L_0x0205:
        r0 = r35;	 Catch:{ all -> 0x02a5 }
        r1 = r37;	 Catch:{ all -> 0x02a5 }
        r2 = r34;	 Catch:{ all -> 0x02a5 }
        r4 = r0.m7044a(r10, r1, r2);	 Catch:{ all -> 0x02a5 }
        if (r4 == 0) goto L_0x021d;	 Catch:{ all -> 0x02a5 }
    L_0x0211:
        r4 = new com.facebook.messaging.threadview.rows.RowThemePickerItem;	 Catch:{ all -> 0x02a5 }
        r0 = r33;	 Catch:{ all -> 0x02a5 }
        r4.<init>(r0);	 Catch:{ all -> 0x02a5 }
        r0 = r32;	 Catch:{ all -> 0x02a5 }
        r0.add(r4);	 Catch:{ all -> 0x02a5 }
    L_0x021d:
        r0 = r35;	 Catch:{ all -> 0x02a5 }
        r4 = r0.f7394o;	 Catch:{ all -> 0x02a5 }
        r4 = r4.m7022a(r5, r10, r8);	 Catch:{ all -> 0x02a5 }
        if (r4 == 0) goto L_0x0235;	 Catch:{ all -> 0x02a5 }
    L_0x0227:
        r4 = new com.facebook.messaging.threadview.rows.RowTimestampDividerItem;	 Catch:{ all -> 0x02a5 }
        r14 = com.facebook.messaging.model.messages.MessageUtil.d(r5);	 Catch:{ all -> 0x02a5 }
        r4.<init>(r14);	 Catch:{ all -> 0x02a5 }
        r0 = r32;	 Catch:{ all -> 0x02a5 }
        r0.add(r4);	 Catch:{ all -> 0x02a5 }
    L_0x0235:
        r0 = r32;	 Catch:{ all -> 0x02a5 }
        r0.add(r6);	 Catch:{ all -> 0x02a5 }
        if (r43 == 0) goto L_0x024a;	 Catch:{ all -> 0x02a5 }
    L_0x023c:
        r0 = r33;	 Catch:{ all -> 0x02a5 }
        r4 = r0.a;	 Catch:{ all -> 0x02a5 }
        r6 = com.facebook.messaging.model.threadkey.ThreadKey.Type.GROUP;	 Catch:{ all -> 0x02a5 }
        if (r4 == r6) goto L_0x024a;	 Catch:{ all -> 0x02a5 }
    L_0x0244:
        r4 = com.facebook.messaging.model.messages.MessageUtil.W(r5);	 Catch:{ all -> 0x02a5 }
        if (r4 == 0) goto L_0x0308;	 Catch:{ all -> 0x02a5 }
    L_0x024a:
        r4 = 1;	 Catch:{ all -> 0x02a5 }
    L_0x024b:
        if (r7 == 0) goto L_0x030b;	 Catch:{ all -> 0x02a5 }
    L_0x024d:
        if (r18 == 0) goto L_0x0258;	 Catch:{ all -> 0x02a5 }
    L_0x024f:
        if (r4 == 0) goto L_0x0258;	 Catch:{ all -> 0x02a5 }
    L_0x0251:
        r0 = r32;	 Catch:{ all -> 0x02a5 }
        r1 = r18;	 Catch:{ all -> 0x02a5 }
        r0.add(r1);	 Catch:{ all -> 0x02a5 }
    L_0x0258:
        r0 = r29;	 Catch:{ all -> 0x02a5 }
        if (r5 != r0) goto L_0x0268;	 Catch:{ all -> 0x02a5 }
    L_0x025c:
        r4 = new com.facebook.messaging.threadview.rows.RowEmojilikePickerItem;	 Catch:{ all -> 0x02a5 }
        r0 = r33;	 Catch:{ all -> 0x02a5 }
        r4.<init>(r0);	 Catch:{ all -> 0x02a5 }
        r0 = r32;	 Catch:{ all -> 0x02a5 }
        r0.add(r4);	 Catch:{ all -> 0x02a5 }
    L_0x0268:
        r4 = r28 + 1;	 Catch:{ all -> 0x02a5 }
        r28 = r4;	 Catch:{ all -> 0x02a5 }
        goto L_0x00b3;	 Catch:{ all -> 0x02a5 }
    L_0x026e:
        r10 = 0;	 Catch:{ all -> 0x02a5 }
        goto L_0x00fa;	 Catch:{ all -> 0x02a5 }
    L_0x0271:
        r22 = com.facebook.messaging.threadview.rows.RowItemDeliveryState.READ;	 Catch:{ all -> 0x02a5 }
        goto L_0x010e;	 Catch:{ all -> 0x02a5 }
    L_0x0275:
        r4 = 0;	 Catch:{ all -> 0x02a5 }
        r6 = r4;	 Catch:{ all -> 0x02a5 }
        goto L_0x0120;	 Catch:{ all -> 0x02a5 }
    L_0x0279:
        r4 = 0;	 Catch:{ all -> 0x02a5 }
        r10 = r4;	 Catch:{ all -> 0x02a5 }
        goto L_0x0126;	 Catch:{ all -> 0x02a5 }
    L_0x027d:
        r4 = r28 + -1;	 Catch:{ all -> 0x02a5 }
        r0 = r36;	 Catch:{ all -> 0x02a5 }
        r4 = r0.get(r4);	 Catch:{ all -> 0x02a5 }
        r4 = (com.facebook.messaging.model.messages.Message) r4;	 Catch:{ all -> 0x02a5 }
        r8 = r4;	 Catch:{ all -> 0x02a5 }
        goto L_0x012a;	 Catch:{ all -> 0x02a5 }
    L_0x028a:
        r4 = 0;	 Catch:{ all -> 0x02a5 }
        r7 = r4;	 Catch:{ all -> 0x02a5 }
        goto L_0x013d;	 Catch:{ all -> 0x02a5 }
    L_0x028e:
        r0 = r35;	 Catch:{ all -> 0x02a5 }
        r4 = r0.f7394o;	 Catch:{ all -> 0x02a5 }
        r19 = r4.m7018a(r5, r10, r8, r7);	 Catch:{ all -> 0x02a5 }
        goto L_0x014b;	 Catch:{ all -> 0x02a5 }
    L_0x0298:
        r4 = com.facebook.messaging.model.messages.MessageUtil.l(r5);	 Catch:{ all -> 0x02a5 }
        if (r4 == 0) goto L_0x02ad;	 Catch:{ all -> 0x02a5 }
    L_0x029e:
        r6 = new com.facebook.messaging.threadview.rows.RowGroupCreatedItem;	 Catch:{ all -> 0x02a5 }
        r6.<init>(r5);	 Catch:{ all -> 0x02a5 }
        goto L_0x018e;
    L_0x02a5:
        r4 = move-exception;
        r5 = -289723050; // 0xffffffffeebb2d56 float:-2.8964252E28 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r5);
        throw r4;
    L_0x02ad:
        r4 = r5.n;	 Catch:{  }
        r0 = r38;	 Catch:{  }
        r15 = r0.contains(r4);	 Catch:{  }
        r0 = r35;	 Catch:{  }
        r4 = r0.f7380a;	 Catch:{  }
        r16 = r4.f(r5);	 Catch:{  }
        r0 = r35;	 Catch:{  }
        r4 = r0.f7380a;	 Catch:{  }
        r17 = r4.g(r5);	 Catch:{  }
        r0 = r35;	 Catch:{  }
        r0 = r0.f7389j;	 Catch:{  }
        r21 = r0;	 Catch:{  }
        r0 = r13.first;	 Catch:{  }
        r23 = r0;	 Catch:{  }
        r23 = (java.util.List) r23;	 Catch:{  }
        r0 = r13.second;	 Catch:{  }
        r24 = r0;	 Catch:{  }
        r24 = (java.util.List) r24;	 Catch:{  }
        r13 = r5;	 Catch:{  }
        r27 = r43;	 Catch:{  }
        r6 = com.facebook.messaging.threadview.rows.RowMessageItem.m4298a(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27);	 Catch:{  }
        if (r44 != 0) goto L_0x018e;	 Catch:{  }
    L_0x02e0:
        r0 = r6;	 Catch:{  }
        r0 = (com.facebook.messaging.threadview.rows.RowMessageItem) r0;	 Catch:{  }
        r4 = r0;	 Catch:{  }
        r13 = 0;	 Catch:{  }
        r4.m4306b(r13);	 Catch:{  }
        goto L_0x018e;	 Catch:{  }
    L_0x02ea:
        r0 = r35;	 Catch:{  }
        r4 = r0.f7381b;	 Catch:{  }
        r4 = r4.get();	 Catch:{  }
        r4 = (com.facebook.messaging.contextbanner.ContextItemsFuturesGenerator) r4;	 Catch:{  }
        r13 = r5.e;	 Catch:{  }
        r13 = r13.c;	 Catch:{  }
        r0 = r35;	 Catch:{  }
        r1 = r37;	 Catch:{  }
        r14 = r0.m7031a(r1);	 Catch:{  }
        r0 = r37;	 Catch:{  }
        r4 = r4.m2008a(r13, r0, r14);	 Catch:{  }
        goto L_0x01bc;	 Catch:{  }
    L_0x0308:
        r4 = 0;	 Catch:{  }
        goto L_0x024b;	 Catch:{  }
    L_0x030b:
        if (r40 != 0) goto L_0x0318;	 Catch:{  }
    L_0x030d:
        if (r18 == 0) goto L_0x0318;	 Catch:{  }
    L_0x030f:
        if (r4 == 0) goto L_0x0318;	 Catch:{  }
    L_0x0311:
        r0 = r32;	 Catch:{  }
        r1 = r18;	 Catch:{  }
        r0.add(r1);	 Catch:{  }
    L_0x0318:
        if (r40 != 0) goto L_0x0320;	 Catch:{  }
    L_0x031a:
        r4 = r41.isEmpty();	 Catch:{  }
        if (r4 != 0) goto L_0x0338;	 Catch:{  }
    L_0x0320:
        r0 = r35;	 Catch:{  }
        r4 = r0.f7394o;	 Catch:{  }
        r6 = r4.m7023b(r8);	 Catch:{  }
        r14 = 0;	 Catch:{  }
        r4 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1));	 Catch:{  }
        if (r4 < 0) goto L_0x0338;	 Catch:{  }
    L_0x032e:
        r4 = new com.facebook.messaging.threadview.rows.RowTimestampDividerItem;	 Catch:{  }
        r4.<init>(r6);	 Catch:{  }
        r0 = r32;	 Catch:{  }
        r0.add(r4);	 Catch:{  }
    L_0x0338:
        if (r40 == 0) goto L_0x0350;	 Catch:{  }
    L_0x033a:
        r0 = r35;	 Catch:{  }
        r4 = r0.f7394o;	 Catch:{  }
        r0 = r40;	 Catch:{  }
        r4 = r4.m7021a(r5, r0);	 Catch:{  }
        r6 = new com.facebook.messaging.threadview.rows.RowTypingItem;	 Catch:{  }
        r0 = r40;	 Catch:{  }
        r6.<init>(r0, r5, r4);	 Catch:{  }
        r0 = r32;	 Catch:{  }
        r0.add(r6);	 Catch:{  }
    L_0x0350:
        r0 = r32;	 Catch:{  }
        r1 = r41;	 Catch:{  }
        r0.addAll(r1);	 Catch:{  }
        goto L_0x0258;	 Catch:{  }
    L_0x0359:
        r4 = r32.size();	 Catch:{  }
        r5 = 1;	 Catch:{  }
        if (r4 <= r5) goto L_0x03cf;	 Catch:{  }
    L_0x0360:
        r4 = r32.size();	 Catch:{  }
        r4 = r4 + -2;	 Catch:{  }
        r0 = r32;	 Catch:{  }
        r4 = r0.get(r4);	 Catch:{  }
        r4 = (com.facebook.messaging.threadview.rows.RowItem) r4;	 Catch:{  }
        r5 = r4;	 Catch:{  }
    L_0x036f:
        r4 = r32.isEmpty();	 Catch:{  }
        if (r4 == 0) goto L_0x03d1;	 Catch:{  }
    L_0x0375:
        r4 = 0;	 Catch:{  }
    L_0x0376:
        if (r4 == 0) goto L_0x038c;	 Catch:{  }
    L_0x0378:
        r6 = new com.facebook.messaging.threadview.rows.RowSpacerItem;	 Catch:{  }
        r6.<init>(r4);	 Catch:{  }
        r0 = r32;	 Catch:{  }
        r0.add(r6);	 Catch:{  }
        r6 = r4 instanceof com.facebook.messaging.threadview.rows.RowMessageItem;	 Catch:{  }
        if (r6 == 0) goto L_0x03e0;	 Catch:{  }
    L_0x0386:
        r4 = (com.facebook.messaging.threadview.rows.RowMessageItem) r4;	 Catch:{  }
        r5 = 1;	 Catch:{  }
        r4.m4307b(r5);	 Catch:{  }
    L_0x038c:
        r4 = com.facebook.messaging.model.threadkey.ThreadKey.b(r33);	 Catch:{  }
        if (r4 == 0) goto L_0x03c8;	 Catch:{  }
    L_0x0392:
        r4 = r33.e();	 Catch:{  }
        if (r4 != 0) goto L_0x03c8;	 Catch:{  }
    L_0x0398:
        if (r34 == 0) goto L_0x03c8;	 Catch:{  }
    L_0x039a:
        r4 = r34.U();	 Catch:{  }
        if (r4 == 0) goto L_0x03c8;	 Catch:{  }
    L_0x03a0:
        r4 = r34.Z();	 Catch:{  }
        if (r4 != 0) goto L_0x03c8;	 Catch:{  }
    L_0x03a6:
        r0 = r35;	 Catch:{  }
        r4 = r0.f7392m;	 Catch:{  }
        r4 = r4.c();	 Catch:{  }
        if (r4 == 0) goto L_0x03c8;	 Catch:{  }
    L_0x03b0:
        r0 = r35;	 Catch:{  }
        r4 = r0.f7392m;	 Catch:{  }
        r5 = r34.e();	 Catch:{  }
        r4 = r4.a(r5);	 Catch:{  }
        r5 = new com.facebook.messaging.threadview.rows.RowMontageStatusItem;	 Catch:{  }
        r0 = r34;	 Catch:{  }
        r5.<init>(r0, r4);	 Catch:{  }
        r0 = r32;	 Catch:{  }
        r0.add(r5);	 Catch:{  }
    L_0x03c8:
        r4 = -1516134326; // 0xffffffffa5a1a04a float:-2.8037664E-16 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r4);
        return r32;
    L_0x03cf:
        r5 = 0;
        goto L_0x036f;
    L_0x03d1:
        r4 = r32.size();	 Catch:{  }
        r4 = r4 + -1;	 Catch:{  }
        r0 = r32;	 Catch:{  }
        r4 = r0.get(r4);	 Catch:{  }
        r4 = (com.facebook.messaging.threadview.rows.RowItem) r4;	 Catch:{  }
        goto L_0x0376;	 Catch:{  }
    L_0x03e0:
        r4 = r4 instanceof com.facebook.messaging.threadview.rows.RowReceiptItem;	 Catch:{  }
        if (r4 == 0) goto L_0x038c;	 Catch:{  }
    L_0x03e4:
        if (r5 == 0) goto L_0x038c;	 Catch:{  }
    L_0x03e6:
        r4 = r5 instanceof com.facebook.messaging.threadview.rows.RowMessageItem;	 Catch:{  }
        if (r4 == 0) goto L_0x038c;	 Catch:{  }
    L_0x03ea:
        r0 = r5;	 Catch:{  }
        r0 = (com.facebook.messaging.threadview.rows.RowMessageItem) r0;	 Catch:{  }
        r4 = r0;	 Catch:{  }
        r5 = 1;	 Catch:{  }
        r4.m4307b(r5);	 Catch:{  }
        goto L_0x038c;
    L_0x03f3:
        r29 = r5;
        goto L_0x0090;
    L_0x03f7:
        r4 = r5;
        goto L_0x004f;
    L_0x03fa:
        r30 = r4;
        r31 = r6;
        goto L_0x0059;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.threadview.RowMessageItemGenerator.a(java.util.List, com.facebook.messaging.model.threads.ThreadSummary, java.util.Set, boolean, com.facebook.messaging.model.messages.ParticipantInfo, java.util.Collection, com.facebook.messaging.customthreads.DefaultThreadViewTheme, boolean, boolean):java.util.List<com.facebook.messaging.threadview.rows.RowItem>");
    }

    private static RowMessageItemGenerator m7045b(InjectorLike injectorLike) {
        RowMessageItemGenerator rowMessageItemGenerator = new RowMessageItemGenerator(AttachmentDataFactory.a(injectorLike), ContextRowHelper.m2010a(injectorLike), EmojilikeNuxAnchorProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4145), IdBasedProvider.a(injectorLike, 4155), IdBasedProvider.a(injectorLike, 4149), MessageReceiptCalculationUtil.a(injectorLike), MessageUserUtil.a(injectorLike), MessageUtil.a(injectorLike), MessengerThreadNameViewDataFactory.a(injectorLike), MessengerThreadTileViewDataFactory.a(injectorLike), MontageTestHelper.a(injectorLike), RowItemUiUtil.m7015a(injectorLike), UserKey_ViewerContextUserKeyMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3593));
        rowMessageItemGenerator.m7038a(IdBasedLazy.a(injectorLike, 7775), IdBasedLazy.a(injectorLike, 8183), IdBasedSingletonScopeProvider.b(injectorLike, 7785), IdBasedLazy.a(injectorLike, 7633), IdBasedLazy.a(injectorLike, 7632));
        return rowMessageItemGenerator;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.orca.threadview.RowMessageItemGenerator m7035a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f7379v;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m7045b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f7379v;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.orca.threadview.RowMessageItemGenerator) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.orca.threadview.RowMessageItemGenerator) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f7379v;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.orca.threadview.RowMessageItemGenerator) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.threadview.RowMessageItemGenerator.a(com.facebook.inject.InjectorLike):com.facebook.orca.threadview.RowMessageItemGenerator");
    }

    @Inject
    public RowMessageItemGenerator(AttachmentDataFactory attachmentDataFactory, ContextRowHelper contextRowHelper, EmojilikeNuxAnchorProvider emojilikeNuxAnchorProvider, Provider<Boolean> provider, Provider<Boolean> provider2, Provider<Boolean> provider3, MessageReceiptCalculationUtil messageReceiptCalculationUtil, MessageUserUtil messageUserUtil, MessageUtil messageUtil, MessengerThreadNameViewDataFactory messengerThreadNameViewDataFactory, MessengerThreadTileViewDataFactory messengerThreadTileViewDataFactory, MontageTestHelper montageTestHelper, RowItemUiUtil rowItemUiUtil, UserKey userKey, GatekeeperStore gatekeeperStore, Provider<UserCache> provider4) {
        this.f7380a = attachmentDataFactory;
        this.f7382c = contextRowHelper;
        this.f7383d = emojilikeNuxAnchorProvider;
        this.f7384e = provider;
        this.f7385f = provider2;
        this.f7386g = provider3;
        this.f7387h = messageReceiptCalculationUtil;
        this.f7388i = messageUserUtil;
        this.f7389j = messageUtil;
        this.f7390k = messengerThreadNameViewDataFactory;
        this.f7391l = messengerThreadTileViewDataFactory;
        this.f7392m = montageTestHelper;
        this.f7394o = rowItemUiUtil;
        this.f7395p = userKey;
        this.f7399t = gatekeeperStore;
        this.f7400u = provider4;
    }

    private void m7038a(com.facebook.inject.Lazy<ContextItemsFuturesGenerator> lazy, com.facebook.inject.Lazy<PaymentRowMessageItemHelper> lazy2, com.facebook.inject.Lazy<CustomThreadsHoldout> lazy3, com.facebook.inject.Lazy<BusinessNuxContentsLoader> lazy4, com.facebook.inject.Lazy<BusinessGreetingContentsLoader> lazy5) {
        this.f7381b = lazy;
        this.f7393n = lazy2;
        this.f7396q = lazy3;
        this.f7397r = lazy4;
        this.f7398s = lazy5;
    }

    public final RowItem m7049a(Message message) {
        return RowMessageItem.m4297a(message, true, false, this.f7380a.f(message), this.f7380a.g(message), this.f7389j, null, null, true);
    }

    public final List<RowItem> m7052a(List<Message> list, Set<String> set, Collection<RowHotLikePreviewItem> collection, boolean z, ThreadKey threadKey) {
        List a = Lists.a();
        User a2 = m7036a(threadKey);
        if (this.f7382c.m2012a(threadKey, a2)) {
            a.add(m7032a(((ContextItemsFuturesGenerator) this.f7381b.get()).m2007a(a2, threadKey, null), threadKey, a2, MessengerThreadNameViewDataFactory.a(a2), this.f7391l.a(a2)));
        }
        if (m7043a(null, a2)) {
            a.add(new RowBusinessNuxItem(((BusinessNuxContentsLoader) this.f7397r.get()).a(a2.d()), threadKey));
        } else if (m7047b((List) list) && a2 != null && (a2.T() || a2.P())) {
            String d = a2.d();
            a.add(new RowBusinessGreetingItem(((BusinessGreetingContentsLoader) this.f7398s.get()).a(d), d));
        }
        int i = 0;
        while (i < list.size()) {
            Message message = (Message) list.get(i);
            if (this.f7394o.m7022a(message, i == 0, i == 0 ? null : (Message) list.get(i - 1))) {
                a.add(new RowTimestampDividerItem(MessageUtil.d(message)));
            }
            ThreadPaymentTransactionData threadPaymentTransactionData = null;
            if (m7046b(message)) {
                threadPaymentTransactionData = ((PaymentRowMessageItemHelper) this.f7393n.get()).a(message);
            }
            PaymentRequestModel paymentRequestModel = null;
            if (m7048c(message)) {
                paymentRequestModel = ((PaymentRowMessageItemHelper) this.f7393n.get()).b(message);
            }
            a.add(RowMessageItem.m4297a(message, true, set.contains(message.n), this.f7380a.f(message), this.f7380a.g(message), this.f7389j, threadPaymentTransactionData, paymentRequestModel, z));
            i++;
        }
        RowItem rowItem = a.isEmpty() ? null : (RowItem) a.get(a.size() - 1);
        if (!(rowItem == null || (rowItem instanceof RowSocialContextItem) || (rowItem instanceof RowBusinessGreetingItem))) {
            a.add(new RowSpacerItem(rowItem));
        }
        a.addAll(collection);
        return Lists.a(a);
    }

    public final List<RowItem> m7051a(List<Message> list, ThreadSummary threadSummary, Set<String> set, boolean z, @Nullable ParticipantInfo participantInfo, Collection<RowHotLikePreviewItem> collection, ThreadViewTheme threadViewTheme, boolean z2, boolean z3, boolean z4) {
        List a = m7037a((List) list, threadSummary, (Set) set, z, participantInfo, (Collection) collection, (DefaultThreadViewTheme) threadViewTheme, z2, true);
        if (z3) {
            m7040a(a, z4);
        }
        return Lists.a(a);
    }

    private static void m7040a(List<RowItem> list, boolean z) {
        list.add(0, z ? MessageListAdapter.f7173b : MessageListAdapter.f7172a);
    }

    public final List<RowItem> m7050a(List<Message> list, ThreadSummary threadSummary, Set<String> set, boolean z, @Nullable ParticipantInfo participantInfo, Collection<RowHotLikePreviewItem> collection, ThreadViewTheme threadViewTheme, boolean z2, List<RowItem> list2) {
        Preconditions.checkArgument(list.size() > 2);
        List a = Lists.a();
        a.add(list.get(2));
        a.add(list.get(1));
        a.add(list.get(0));
        a = m7037a(a, threadSummary, (Set) set, z, participantInfo, (Collection) collection, (DefaultThreadViewTheme) threadViewTheme, z2, false);
        if (a.get(0) instanceof RowSocialContextItem) {
            a.remove(0);
        }
        a.remove(0);
        a.remove(0);
        if (((RowItem) a.get(0)).mo131b() == RowType.RECEIPT) {
            a.remove(0);
        }
        Collection a2 = Lists.a(a);
        list2.remove(0);
        if (list2.get(0) instanceof RowHotLikePreviewItem) {
            if (!collection.contains(((RowHotLikePreviewItem) list2.get(0)).f4731a)) {
                m7039a((List) list2);
            }
        }
        m7039a((List) list2);
        list2.addAll(0, a2);
        return list2;
    }

    private static void m7039a(List<RowItem> list) {
        if (((RowItem) list.get(0)).mo131b() == RowType.RECEIPT) {
            list.remove(0);
        }
        list.remove(0);
        if (!list.isEmpty() && (list.get(0) instanceof RowTimestampDividerItem)) {
            list.remove(0);
        }
    }

    private static RowItem m7032a(ListenableFuture<ContextItems> listenableFuture, ThreadKey threadKey, User user, ThreadNameViewData threadNameViewData, ThreadTileViewData threadTileViewData) {
        boolean z = (user == null || user.E) ? false : true;
        return new RowSocialContextItem(listenableFuture, threadKey, z, threadNameViewData, threadTileViewData);
    }

    private boolean m7044a(boolean z, ThreadSummary threadSummary, User user) {
        return z && ((Boolean) this.f7384e.get()).booleanValue() && !threadSummary.A.isMessageRequestFolders() && ((CustomThreadsHoldout) this.f7396q.get()).a(threadSummary.a) && (user == null || !user.u);
    }

    private boolean m7042a(ThreadKey threadKey, DefaultThreadViewTheme defaultThreadViewTheme) {
        Object obj;
        if (defaultThreadViewTheme == null || StringUtil.a(defaultThreadViewTheme.g())) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null && ((Boolean) this.f7386g.get()).booleanValue() && ((CustomThreadsHoldout) this.f7396q.get()).a(threadKey)) {
            return true;
        }
        return false;
    }

    @Nullable
    private User m7036a(ThreadKey threadKey) {
        if (!ThreadKey.b(threadKey) && !ThreadKey.g(threadKey)) {
            return null;
        }
        return ((UserCache) this.f7400u.get()).a(UserKey.b(Long.toString(threadKey.d)));
    }

    private RowItemDeliveryState m7033a(Message message, boolean z, ThreadSummary threadSummary, UserKey userKey, Map<Message, MessageDeliveredReadInfo> map, boolean z2, UserCache userCache, boolean z3) {
        Object obj;
        ImmutableList immutableList = threadSummary.h;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            UserKey b = ((ThreadParticipant) immutableList.get(i)).b();
            if (!b.equals(userKey)) {
                User a = userCache.a(b);
                if (a != null && a.O()) {
                    obj = 1;
                    break;
                }
            }
        }
        obj = null;
        Object obj2 = (obj == null && z3) ? 1 : null;
        if (obj2 != null) {
            return RowItemDeliveryState.HIDDEN;
        }
        if (message.l == MessageType.FAILED_SEND) {
            return message.w.b == SendErrorType.PERMANENT_FAILURE ? RowItemDeliveryState.FAILED_NON_RETRYABLE : RowItemDeliveryState.FAILED;
        } else {
            if (message.l == MessageType.PENDING_SEND && !z) {
                return RowItemDeliveryState.SENDING;
            }
            long d = MessageUtil.d(message);
            if (z2) {
                return RowItemDeliveryState.HIDDEN;
            }
            ThreadParticipant threadParticipant;
            immutableList = threadSummary.h;
            int size2 = immutableList.size();
            int i2 = 0;
            while (i2 < size2) {
                threadParticipant = (ThreadParticipant) immutableList.get(i2);
                if (!threadParticipant.b().equals(userKey) && threadParticipant.b >= d) {
                    return m7041a(message, (Map) map) ? RowItemDeliveryState.READ : RowItemDeliveryState.HIDDEN;
                } else {
                    i2++;
                }
            }
            immutableList = threadSummary.h;
            size2 = immutableList.size();
            for (i2 = 0; i2 < size2; i2++) {
                threadParticipant = (ThreadParticipant) immutableList.get(i2);
                if (!threadParticipant.b().equals(userKey) && threadParticipant.d >= d && (obj != null || !((Boolean) this.f7385f.get()).booleanValue())) {
                    return RowItemDeliveryState.DELIVERED;
                }
            }
            return RowItemDeliveryState.SENT;
        }
    }

    private static boolean m7041a(Message message, Map<Message, MessageDeliveredReadInfo> map) {
        return map.containsKey(message) && ((MessageDeliveredReadInfo) map.get(message)).a == Type.READER;
    }

    private static RowReceiptItem m7034a(Message message, MessageDeliveredReadInfo messageDeliveredReadInfo, ThreadSummary threadSummary, boolean z, boolean z2) {
        ThreadKey threadKey = threadSummary.a;
        ParticipantInfo participantInfo;
        switch (C11071.f7378a[messageDeliveredReadInfo.a.ordinal()]) {
            case 1:
                if (!ThreadKey.b(threadKey) && !ThreadKey.g(threadKey)) {
                    return RowReceiptItem.m4318a(messageDeliveredReadInfo.a(), message, threadSummary.h.size(), z, z2);
                }
                return RowReceiptItem.m4319a(messageDeliveredReadInfo.a(), message, messageDeliveredReadInfo.d, z, z2);
            case 2:
                if (messageDeliveredReadInfo.a == Type.SENDER) {
                    participantInfo = messageDeliveredReadInfo.c;
                } else {
                    participantInfo = null;
                }
                return RowReceiptItem.m4317a(participantInfo, message, z, z2);
            case 3:
                if (messageDeliveredReadInfo.a == Type.DELIVEREE) {
                    participantInfo = messageDeliveredReadInfo.c;
                } else {
                    participantInfo = null;
                }
                return RowReceiptItem.m4320b(participantInfo, message, z, z2);
            default:
                throw new InvalidParameterException("Row receipt item not supported");
        }
    }

    private static boolean m7046b(Message message) {
        return (message.B == null && (message.u == null || message.u.c == null)) ? false : true;
    }

    private static boolean m7048c(Message message) {
        return message.C != null;
    }

    private boolean m7047b(List<Message> list) {
        return list.isEmpty() && this.f7399t.a(171, false);
    }

    private static boolean m7043a(@Nullable List<Message> list, @Nullable User user) {
        if ((list == null || list.size() <= 1) && user != null && user.u && user.w != null && user.w.contains(CommercePageSetting.COMMERCE_NUX_ENABLED)) {
            return true;
        }
        return false;
    }

    private int m7031a(ThreadSummary threadSummary) {
        int i = 0;
        for (ThreadParticipant b : threadSummary.h) {
            int i2;
            User a = ((UserCache) this.f7400u.get()).a(b.b());
            if (a == null || !a.z) {
                i2 = i;
            } else {
                i2 = i + 1;
            }
            i = i2;
        }
        return i;
    }
}
