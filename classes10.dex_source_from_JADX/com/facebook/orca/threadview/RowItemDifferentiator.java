package com.facebook.orca.threadview;

import com.facebook.common.util.StringUtil;
import com.facebook.messaging.attachments.AudioAttachmentData;
import com.facebook.messaging.deliveryreceipt.RowReceiptParticipant;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.thread.model.ThreadPaymentTransactionData;
import com.facebook.messaging.threadview.rows.RowGloballyDeletedMessagePlaceholderItem;
import com.facebook.messaging.threadview.rows.RowHotLikePreviewItem;
import com.facebook.messaging.threadview.rows.RowItem;
import com.facebook.messaging.threadview.rows.RowMessageItem;
import com.facebook.messaging.threadview.rows.RowReceiptItem;
import com.facebook.messaging.threadview.rows.RowSocialContextItem;
import com.facebook.messaging.threadview.rows.RowSpacerItem;
import com.facebook.messaging.threadview.rows.RowTimestampDividerItem;
import com.facebook.messaging.threadview.rows.RowTypingItem;
import com.facebook.messaging.threadview.rows.SimpleRowItem;
import com.google.common.base.Objects;
import difflib.Differentiator;
import java.util.List;

/* compiled from: message_send_fail_json.txt */
public class RowItemDifferentiator implements Differentiator<RowItem> {
    public boolean f7364a;

    public final boolean m7008a(RowItem rowItem, RowItem rowItem2) {
        Object obj;
        if ((rowItem instanceof RowMessageItem) && (rowItem2 instanceof RowMessageItem)) {
            RowMessageItem rowMessageItem = (RowMessageItem) rowItem;
            RowMessageItem rowMessageItem2 = (RowMessageItem) rowItem2;
            obj = (rowMessageItem.f4736e == rowMessageItem2.f4736e && rowMessageItem.f4737f.groupWithNewerRow == rowMessageItem2.f4737f.groupWithNewerRow && rowMessageItem.f4737f.groupWithOlderRow == rowMessageItem2.f4737f.groupWithOlderRow) ? 1 : null;
            if (obj == null || !m7006c(rowMessageItem, rowMessageItem2)) {
                return true;
            }
            return false;
        } else if ((rowItem instanceof RowReceiptItem) && (rowItem2 instanceof RowReceiptItem)) {
            if (m7005a((RowReceiptItem) rowItem, (RowReceiptItem) rowItem2)) {
                return false;
            }
            return true;
        } else if ((rowItem instanceof RowTypingItem) && (rowItem2 instanceof RowTypingItem)) {
            RowTypingItem rowTypingItem = (RowTypingItem) rowItem;
            RowTypingItem rowTypingItem2 = (RowTypingItem) rowItem2;
            if (Objects.equal(rowTypingItem.f4774a.b, rowTypingItem2.f4774a.b) && rowTypingItem.f4776c == rowTypingItem2.f4776c && m7004a(rowTypingItem.f4775b, rowTypingItem2.f4775b)) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                return true;
            }
            return false;
        } else if ((rowItem instanceof SimpleRowItem) && (rowItem2 instanceof SimpleRowItem)) {
            if (((SimpleRowItem) rowItem).f4778b != ((SimpleRowItem) rowItem2).f4778b) {
                return true;
            }
            return false;
        } else if ((rowItem instanceof RowSpacerItem) && (rowItem2 instanceof RowSpacerItem)) {
            return m7008a(((RowSpacerItem) rowItem).f4771a, ((RowSpacerItem) rowItem2).f4771a);
        } else if ((rowItem instanceof RowHotLikePreviewItem) && (rowItem2 instanceof RowHotLikePreviewItem)) {
            if (Objects.equal(((RowHotLikePreviewItem) rowItem).f4731a, ((RowHotLikePreviewItem) rowItem2).f4731a)) {
                r4 = false;
            } else {
                r4 = true;
            }
            return r4;
        } else if ((rowItem instanceof RowTimestampDividerItem) && (rowItem2 instanceof RowTimestampDividerItem)) {
            if (((RowTimestampDividerItem) rowItem).f4773a != ((RowTimestampDividerItem) rowItem2).f4773a) {
                r4 = true;
            } else {
                r4 = false;
            }
            return r4;
        } else if ((rowItem instanceof RowGloballyDeletedMessagePlaceholderItem) && (rowItem2 instanceof RowGloballyDeletedMessagePlaceholderItem)) {
            RowGloballyDeletedMessagePlaceholderItem rowGloballyDeletedMessagePlaceholderItem = (RowGloballyDeletedMessagePlaceholderItem) rowItem;
            RowGloballyDeletedMessagePlaceholderItem rowGloballyDeletedMessagePlaceholderItem2 = (RowGloballyDeletedMessagePlaceholderItem) rowItem2;
            if (m7004a(rowGloballyDeletedMessagePlaceholderItem.f4728a, rowGloballyDeletedMessagePlaceholderItem2.f4728a) && Objects.equal(rowGloballyDeletedMessagePlaceholderItem.f4729b, rowGloballyDeletedMessagePlaceholderItem2.f4729b)) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                return true;
            }
            return false;
        } else if ((rowItem instanceof RowSocialContextItem) && (rowItem2 instanceof RowSocialContextItem)) {
            return !Objects.equal((RowSocialContextItem) rowItem, (RowSocialContextItem) rowItem2);
        } else if (rowItem.mo131b() != rowItem2.mo131b()) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean m7009a(RowMessageItem rowMessageItem, RowMessageItem rowMessageItem2) {
        return !m7006c(rowMessageItem, rowMessageItem2);
    }

    private boolean m7006c(RowMessageItem rowMessageItem, RowMessageItem rowMessageItem2) {
        Message message = rowMessageItem.f4732a;
        Message message2 = rowMessageItem2.f4732a;
        if (MessageUtil.a(message, message2)) {
            return false;
        }
        if (!m7004a(message, message2)) {
            return false;
        }
        if (!Objects.equal(message.e, message2.e)) {
            return false;
        }
        Object obj = this.f7364a ? rowMessageItem.f4740i : rowMessageItem.f4733b;
        Object obj2 = this.f7364a ? rowMessageItem2.f4740i : rowMessageItem2.f4733b;
        if ((obj != null || obj2 != null) && (obj == null || obj2 == null || !obj.equals(obj2))) {
            return false;
        }
        if ((message.i != null || message2.i != null) && (message.i == null || message2.i == null || message.i.size() != message2.i.size())) {
            return false;
        }
        if ((message.j != null || message2.j != null) && (message.j == null || message2.j == null || message.j.size() != message2.j.size())) {
            return false;
        }
        if (rowMessageItem.f4745n != rowMessageItem2.f4745n) {
            return false;
        }
        if ((rowMessageItem.f4741j != null || rowMessageItem2.f4741j != null) && (rowMessageItem.f4741j == null || rowMessageItem2.f4741j == null || rowMessageItem.f4741j.size() != rowMessageItem2.f4741j.size())) {
            return false;
        }
        AudioAttachmentData audioAttachmentData = rowMessageItem.f4735d;
        AudioAttachmentData audioAttachmentData2 = rowMessageItem2.f4735d;
        if ((audioAttachmentData != null || audioAttachmentData2 != null) && (audioAttachmentData == null || audioAttachmentData2 == null || audioAttachmentData.b != audioAttachmentData2.b || audioAttachmentData.a != audioAttachmentData2.a())) {
            return false;
        }
        if (rowMessageItem.f4750s != rowMessageItem2.f4750s) {
            return false;
        }
        if (rowMessageItem.f4753v != null || rowMessageItem2.f4753v != null) {
            return false;
        }
        if (message.w == null || message2.w == null || message.w.b != message2.w.b) {
            return false;
        }
        if (!Objects.equal(message.K, message2.K)) {
            return false;
        }
        if (MessageUtil.d(message, message2)) {
            return false;
        }
        return m7007d(rowMessageItem, rowMessageItem2) && message.c == message2.c && message.d == message2.d && rowMessageItem.m4313l() == rowMessageItem2.m4313l() && message.q == message2.q;
    }

    private boolean m7005a(RowReceiptItem rowReceiptItem, RowReceiptItem rowReceiptItem2) {
        if (m7004a(rowReceiptItem.f4758a, rowReceiptItem2.f4758a) && rowReceiptItem.f4761d.equals(rowReceiptItem2.f4761d)) {
            Object obj = null;
            List list = rowReceiptItem2.f4759b;
            if (rowReceiptItem.f4759b == null && list == null) {
                obj = 1;
            } else if (rowReceiptItem.f4759b != null && list != null && rowReceiptItem.f4759b.size() == list.size()) {
                for (int i = 0; i < rowReceiptItem.f4759b.size(); i++) {
                    Object obj2;
                    ParticipantInfo participantInfo = ((RowReceiptParticipant) rowReceiptItem.f4759b.get(i)).b;
                    ParticipantInfo participantInfo2 = ((RowReceiptParticipant) list.get(i)).b;
                    if (Objects.equal(participantInfo.d, participantInfo2.d) && Objects.equal(participantInfo.b, participantInfo2.b) && Objects.equal(participantInfo.c, participantInfo2.c)) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if (obj2 == null) {
                        break;
                    }
                }
                int i2 = 1;
            }
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean m7004a(Message message, Message message2) {
        if (message.a != null && message2.a != null && Objects.equal(message.a, message2.a)) {
            return true;
        }
        if (message.n == null || message2.n == null) {
            return false;
        }
        return Objects.equal(message.n, message2.n);
    }

    private boolean m7007d(RowMessageItem rowMessageItem, RowMessageItem rowMessageItem2) {
        ThreadPaymentTransactionData threadPaymentTransactionData = rowMessageItem.f4743l;
        ThreadPaymentTransactionData threadPaymentTransactionData2 = rowMessageItem2.f4743l;
        Object obj = 1;
        if (!(threadPaymentTransactionData == null && threadPaymentTransactionData2 == null)) {
            if (threadPaymentTransactionData == null || threadPaymentTransactionData2 == null) {
                obj = null;
            } else {
                PaymentTransaction paymentTransaction = threadPaymentTransactionData.c;
                PaymentTransaction paymentTransaction2 = threadPaymentTransactionData2.c;
                if (!(paymentTransaction == null && paymentTransaction2 == null)) {
                    if (paymentTransaction == null || paymentTransaction2 == null) {
                        obj = null;
                    } else if (!(StringUtil.a(paymentTransaction.b, paymentTransaction2.b) && paymentTransaction.g == paymentTransaction2.g)) {
                        obj = null;
                    }
                }
            }
        }
        if (obj != null) {
            PaymentRequestModel paymentRequestModel = rowMessageItem.f4744m;
            PaymentRequestModel paymentRequestModel2 = rowMessageItem2.f4744m;
            obj = 1;
            if (!(paymentRequestModel == null && paymentRequestModel2 == null)) {
                if (paymentRequestModel == null || paymentRequestModel2 == null) {
                    obj = null;
                } else if (!(paymentRequestModel.lw_().equals(paymentRequestModel2.lw_()) && paymentRequestModel.lx_() == paymentRequestModel2.lx_())) {
                    obj = null;
                }
            }
            if (obj != null) {
                return true;
            }
        }
        return false;
    }
}
