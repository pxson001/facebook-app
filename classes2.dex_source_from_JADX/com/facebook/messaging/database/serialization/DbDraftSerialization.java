package com.facebook.messaging.database.serialization;

import com.facebook.common.json.ObjectMapperWithUncheckedException;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.MessageDraft;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mStrokeWidth */
public class DbDraftSerialization {
    private final DbMediaResourceSerialization f15384a;
    private final ObjectMapperWithUncheckedException f15385b;

    public static DbDraftSerialization m21918b(InjectorLike injectorLike) {
        return new DbDraftSerialization(DbMediaResourceSerialization.m21926b(injectorLike), ObjectMapperWithUncheckedException.m21860a(injectorLike));
    }

    @Inject
    public DbDraftSerialization(DbMediaResourceSerialization dbMediaResourceSerialization, ObjectMapperWithUncheckedException objectMapperWithUncheckedException) {
        this.f15384a = dbMediaResourceSerialization;
        this.f15385b = objectMapperWithUncheckedException;
    }

    public final String m21920a(@Nullable MessageDraft messageDraft) {
        if (messageDraft == null) {
            return null;
        }
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.f3121a);
        objectNode.m5137a("text", messageDraft.a);
        objectNode.m5129a("cursorPosition", messageDraft.b);
        if (!messageDraft.c.isEmpty()) {
            objectNode.m5137a("attachmentData", this.f15384a.m21927a(messageDraft.c));
        }
        if (!StringUtil.m3589a((CharSequence) messageDraft.d)) {
            objectNode.m5137a("offlineMessageId", messageDraft.d);
        }
        return objectNode.toString();
    }

    public static DbDraftSerialization m21917a(InjectorLike injectorLike) {
        return m21918b(injectorLike);
    }

    public final MessageDraft m21919a(@Nullable String str) {
        String str2 = null;
        if (StringUtil.m3589a((CharSequence) str)) {
            return null;
        }
        JsonNode a = this.f15385b.m21862a(str);
        String s = a.mo709b("text").mo728s();
        int i = 0;
        if (a.mo730d("cursorPosition")) {
            i = a.mo709b("cursorPosition").mo1283w();
        }
        if (a.mo730d("offlineMessageId")) {
            str2 = a.mo709b("offlineMessageId").mo728s();
        }
        if (!a.mo730d("attachmentData")) {
            return new MessageDraft(s, i, str2);
        }
        return new MessageDraft(s, i, this.f15384a.m21928a(a.mo709b("attachmentData").mo728s()), str2);
    }
}
