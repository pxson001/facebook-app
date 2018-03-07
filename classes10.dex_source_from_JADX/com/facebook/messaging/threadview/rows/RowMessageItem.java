package com.facebook.messaging.threadview.rows;

import com.facebook.common.util.StringUtil;
import com.facebook.messaging.attachments.AudioAttachmentData;
import com.facebook.messaging.attachments.ImageAttachmentData;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.PaymentRequest;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.thread.model.ThreadPaymentTransactionData;
import com.facebook.orca.threadview.MessageContentContainer;
import com.facebook.orca.threadview.MessageItemView;
import com.facebook.orca.threadview.MessageItemView.C10663;
import com.facebook.widget.animatablelistview.AnimatingItemInfo;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: plutonium_enabled */
public class RowMessageItem implements RowItem {
    public final Message f4732a;
    public final RowReceiptItem f4733b;
    public final List<ImageAttachmentData> f4734c;
    public final AudioAttachmentData f4735d;
    public final MessageRecency f4736e;
    public final RowItemGrouping f4737f;
    public final boolean f4738g;
    public final boolean f4739h;
    @Nullable
    public final RowItemDeliveryState f4740i;
    public final List<ThreadParticipant> f4741j;
    public final List<ThreadParticipant> f4742k;
    @Nullable
    public final ThreadPaymentTransactionData f4743l;
    @Nullable
    public final PaymentRequestModel f4744m;
    public final boolean f4745n;
    private final MessageUtil f4746o;
    public C10663 f4747p;
    private float f4748q = 1.0f;
    public float f4749r = 1.0f;
    public int f4750s = 8;
    public boolean f4751t;
    private boolean f4752u;
    public AnimatingItemInfo f4753v;
    public AnimatingItemInfo f4754w;
    public int f4755x = 0;

    /* compiled from: plutonium_enabled */
    public enum MessageRecency {
        MOST_RECENT,
        OTHER
    }

    private RowMessageItem(Message message, boolean z, boolean z2, @Nullable List<ImageAttachmentData> list, @Nullable AudioAttachmentData audioAttachmentData, @Nullable RowReceiptItem rowReceiptItem, RowItemGrouping rowItemGrouping, MessageRecency messageRecency, MessageUtil messageUtil, @Nullable RowItemDeliveryState rowItemDeliveryState, List<ThreadParticipant> list2, List<ThreadParticipant> list3, @Nullable ThreadPaymentTransactionData threadPaymentTransactionData, @Nullable PaymentRequest paymentRequest, boolean z3) {
        this.f4732a = message;
        this.f4738g = z2;
        this.f4739h = z;
        this.f4734c = list;
        this.f4735d = audioAttachmentData;
        this.f4733b = rowReceiptItem;
        this.f4737f = rowItemGrouping;
        this.f4736e = messageRecency;
        this.f4740i = rowItemDeliveryState;
        this.f4741j = list2;
        this.f4742k = list3;
        this.f4743l = threadPaymentTransactionData;
        this.f4744m = paymentRequest;
        this.f4745n = z3;
        this.f4746o = messageUtil;
    }

    public static RowMessageItem m4298a(Message message, boolean z, boolean z2, @Nullable List<ImageAttachmentData> list, @Nullable AudioAttachmentData audioAttachmentData, @Nullable RowReceiptItem rowReceiptItem, RowItemGrouping rowItemGrouping, MessageRecency messageRecency, MessageUtil messageUtil, @Nullable RowItemDeliveryState rowItemDeliveryState, List<ThreadParticipant> list2, List<ThreadParticipant> list3, @Nullable ThreadPaymentTransactionData threadPaymentTransactionData, @Nullable PaymentRequest paymentRequest, boolean z3) {
        return new RowMessageItem(message, z, z2, list, audioAttachmentData, rowReceiptItem, rowItemGrouping, messageRecency, messageUtil, rowItemDeliveryState, list2, list3, threadPaymentTransactionData, paymentRequest, z3);
    }

    public static RowMessageItem m4297a(Message message, boolean z, boolean z2, @Nullable List<ImageAttachmentData> list, @Nullable AudioAttachmentData audioAttachmentData, MessageUtil messageUtil, @Nullable ThreadPaymentTransactionData threadPaymentTransactionData, @Nullable PaymentRequest paymentRequest, boolean z3) {
        return new RowMessageItem(message, z, z2, list, audioAttachmentData, null, RowItemGrouping.DEFAULT, MessageRecency.OTHER, messageUtil, null, null, null, threadPaymentTransactionData, paymentRequest, z3);
    }

    public final Message m4308c() {
        return this.f4732a;
    }

    public final RowType mo131b() {
        return RowType.MESSAGE;
    }

    public final long m4299a() {
        return StringUtil.b(this.f4732a.a);
    }

    public final float m4309d() {
        return this.f4748q;
    }

    public final void m4300a(float f) {
        this.f4748q = f;
        if (this.f4747p != null) {
            MessageItemView.ac(this.f4747p.f7105a);
        }
    }

    public final float m4310e() {
        return this.f4749r;
    }

    public final void m4305b(float f) {
        this.f4749r = f;
        if (this.f4747p != null) {
            MessageItemView messageItemView = this.f4747p.f7105a;
            boolean z = false;
            if (messageItemView.aw == null || !messageItemView.aw.m6632b()) {
                messageItemView.at.f7025g = false;
                return;
            }
            float f2 = messageItemView.bi.f4749r;
            messageItemView.aw.m6630b(f2);
            MessageContentContainer messageContentContainer = messageItemView.at;
            if (f2 < 0.5f) {
                z = true;
            }
            messageContentContainer.f7025g = z;
        }
    }

    public final void m4301a(int i) {
        this.f4750s = i;
        if (this.f4747p != null) {
            C10663 c10663 = this.f4747p;
            Object obj = c10663.f7105a.aZ == null ? 1 : null;
            MessageItemView.ae(c10663.f7105a);
            MessageItemView.ag(c10663.f7105a);
            if (obj != null && c10663.f7105a.aZ != null) {
                MessageItemView.m6738e(c10663.f7105a);
            }
        }
    }

    public final C10663 m4311j() {
        return this.f4747p;
    }

    public final void m4303a(@Nullable C10663 c10663) {
        this.f4747p = c10663;
    }

    public final void m4307b(boolean z) {
        this.f4752u = z;
    }

    public final boolean m4312k() {
        return this.f4752u;
    }

    public final MessageType m4313l() {
        if (this.f4732a.l == MessageType.PENDING_SEND && this.f4738g) {
            return MessageType.REGULAR;
        }
        return this.f4732a.l;
    }

    public final int m4314m() {
        return this.f4755x;
    }

    public final void m4306b(int i) {
        this.f4755x = i;
    }

    public String toString() {
        return "RowMessageItem{message=" + this.f4732a + ", rowReceiptItem=" + (this.f4733b != null ? this.f4733b : "") + '}';
    }

    public final void m4302a(RowMessageItem rowMessageItem) {
        this.f4755x = rowMessageItem.f4755x;
    }
}
