package com.facebook.messaging.threadview.rows;

import com.facebook.messaging.deliveryreceipt.RowReceiptParticipant;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.google.common.base.Preconditions;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: played_message */
public class RowReceiptItem implements RowItem {
    public final Message f4758a;
    public final List<RowReceiptParticipant> f4759b;
    public final ParticipantInfo f4760c;
    public final Type f4761d;
    public final long f4762e;
    public final int f4763f;
    public final boolean f4764g;
    public final boolean f4765h;

    /* compiled from: played_message */
    public enum Type {
        PENDING,
        SENT_BY_ME_TO_SERVER,
        FAILED_TO_SEND,
        SENT_FROM_RECEIPT,
        READ,
        DELIVERED,
        GROUP_READ
    }

    private RowReceiptItem(Type type, Message message, @Nullable ParticipantInfo participantInfo, @Nullable List<RowReceiptParticipant> list, long j, int i, boolean z, boolean z2) {
        boolean z3 = list == null || participantInfo == null;
        Preconditions.checkArgument(z3);
        this.f4761d = type;
        this.f4758a = message;
        this.f4760c = participantInfo;
        this.f4759b = list;
        this.f4762e = j;
        this.f4763f = i;
        this.f4764g = z;
        this.f4765h = z2;
    }

    public static RowReceiptItem m4319a(List<RowReceiptParticipant> list, Message message, long j, boolean z, boolean z2) {
        return new RowReceiptItem(Type.READ, message, null, list, j, 0, z, z2);
    }

    public static RowReceiptItem m4318a(List<RowReceiptParticipant> list, Message message, int i, boolean z, boolean z2) {
        return new RowReceiptItem(Type.GROUP_READ, message, null, list, -1, i, z, z2);
    }

    public static RowReceiptItem m4317a(ParticipantInfo participantInfo, Message message, boolean z, boolean z2) {
        return new RowReceiptItem(Type.SENT_FROM_RECEIPT, message, participantInfo, null, -1, 0, z, z2);
    }

    public static RowReceiptItem m4320b(ParticipantInfo participantInfo, Message message, boolean z, boolean z2) {
        return new RowReceiptItem(Type.DELIVERED, message, participantInfo, null, -1, 0, z, z2);
    }

    public final RowType mo131b() {
        return RowType.RECEIPT;
    }

    public final long m4321a() {
        return Long.MIN_VALUE;
    }

    public String toString() {
        return "RowReceiptItem{, readers=" + (this.f4759b != null ? this.f4759b : "") + ", senderOrDeliveree=" + (this.f4760c != null ? this.f4760c : "") + ", messageSource='" + this.f4758a.p + "', type=" + this.f4761d + ", messageId='" + this.f4758a.a + "', offlineThreadingId='" + this.f4758a.n + "', timestampMs=" + this.f4758a.c + ", sentTimestampMs=" + this.f4758a.d + ", receiptTimestampMs=" + this.f4762e + '}';
    }
}
