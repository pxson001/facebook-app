package com.facebook.messaging.database.serialization;

import com.facebook.common.json.ObjectMapperWithUncheckedException;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.payment.SentPayment;
import com.facebook.messaging.model.payment.SentPaymentBuilder;
import com.facebook.messaging.model.share.SentShareAttachment;
import com.facebook.messaging.model.share.SentShareAttachment.Type;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: lon */
public class DbSentShareAttachmentSerialization {
    private final DbShareSerialization f8837a;
    private final DbSentPaymentSerialization f8838b;
    private final ObjectMapperWithUncheckedException f8839c;

    public static DbSentShareAttachmentSerialization m9179a(InjectorLike injectorLike) {
        return new DbSentShareAttachmentSerialization(DbShareSerialization.m9156b(injectorLike), new DbSentPaymentSerialization(ObjectMapperWithUncheckedException.a(injectorLike)), ObjectMapperWithUncheckedException.a(injectorLike));
    }

    @Inject
    public DbSentShareAttachmentSerialization(DbShareSerialization dbShareSerialization, DbSentPaymentSerialization dbSentPaymentSerialization, ObjectMapperWithUncheckedException objectMapperWithUncheckedException) {
        this.f8837a = dbShareSerialization;
        this.f8838b = dbSentPaymentSerialization;
        this.f8839c = objectMapperWithUncheckedException;
    }

    public final String m9181a(@Nullable SentShareAttachment sentShareAttachment) {
        if (sentShareAttachment == null) {
            return null;
        }
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("type", sentShareAttachment.a.DBSerialValue);
        switch (1.a[sentShareAttachment.a.ordinal()]) {
            case 1:
                objectNode.c("attachment", this.f8837a.m9159a(sentShareAttachment.b));
                break;
            case 2:
                ObjectNode objectNode2;
                String str = "attachment";
                SentPayment sentPayment = sentShareAttachment.c;
                if (sentPayment == null) {
                    objectNode2 = null;
                } else {
                    objectNode2 = new ObjectNode(JsonNodeFactory.a);
                    objectNode2.a("amount", sentPayment.a);
                    objectNode2.a("currency", sentPayment.b);
                    objectNode2.a("senderCredentialId", sentPayment.c);
                    objectNode2.a("recipientId", sentPayment.d);
                    objectNode2.a("memoText", sentPayment.e);
                    objectNode2.a("pin", sentPayment.f);
                    objectNode2.a("fromPaymentTrigger", sentPayment.g);
                    objectNode2.a("groupThreadId", sentPayment.j);
                }
                objectNode.c(str, objectNode2);
                break;
        }
        return objectNode.toString();
    }

    public final SentShareAttachment m9180a(@Nullable String str) {
        if (StringUtil.a(str)) {
            return null;
        }
        JsonNode a = this.f8839c.a(str);
        Type fromDBSerialValue = Type.fromDBSerialValue(JSONUtil.b(a.b("type")));
        a = a.b("attachment");
        switch (1.a[fromDBSerialValue.ordinal()]) {
            case 1:
                return SentShareAttachment.a(this.f8837a.m9158a(a));
            case 2:
                SentPaymentBuilder newBuilder = SentPayment.newBuilder();
                newBuilder.a = JSONUtil.b(a.b("amount"));
                newBuilder = newBuilder;
                newBuilder.b = JSONUtil.b(a.b("currency"));
                newBuilder = newBuilder;
                newBuilder.c = JSONUtil.c(a.b("senderCredentialId"));
                newBuilder = newBuilder;
                newBuilder.d = JSONUtil.b(a.b("recipientId"));
                newBuilder = newBuilder;
                newBuilder.e = JSONUtil.b(a.b("memoText"));
                newBuilder = newBuilder;
                newBuilder.f = JSONUtil.b(a.b("pin"));
                newBuilder = newBuilder;
                newBuilder.g = JSONUtil.g(a.b("fromPaymentTrigger"));
                newBuilder = newBuilder;
                newBuilder.j = JSONUtil.b(a.b("groupThreadId"));
                return SentShareAttachment.a(newBuilder.l());
            default:
                return null;
        }
    }
}
