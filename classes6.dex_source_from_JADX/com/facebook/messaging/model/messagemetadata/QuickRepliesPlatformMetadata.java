package com.facebook.messaging.model.messagemetadata;

import android.os.Parcel;
import com.facebook.common.util.JSONUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: upsell_dialog_confirm */
public class QuickRepliesPlatformMetadata extends PlatformMetadata {
    public static final PlatformMetadataCreator<QuickRepliesPlatformMetadata> CREATOR = new C00861();
    public final ImmutableList<QuickReplyItem> f1944a;

    /* compiled from: upsell_dialog_confirm */
    final class C00861 implements PlatformMetadataCreator<QuickRepliesPlatformMetadata> {
        C00861() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new QuickRepliesPlatformMetadata(parcel);
        }

        public final Object[] newArray(int i) {
            return new QuickRepliesPlatformMetadata[i];
        }

        public final PlatformMetadata mo149a(JsonNode jsonNode) {
            Builder builder = ImmutableList.builder();
            if (jsonNode.h()) {
                Iterator it = jsonNode.iterator();
                while (it.hasNext()) {
                    JsonNode jsonNode2 = (JsonNode) it.next();
                    QuickReplyItem a = QuickReplyItem.m3299a(JSONUtil.b(jsonNode2.b("title")), JSONUtil.b(jsonNode2.b("content_type")), JSONUtil.b(jsonNode2.b("payload")));
                    if (a != null) {
                        builder.c(a);
                    }
                }
            }
            return new QuickRepliesPlatformMetadata(builder.b());
        }
    }

    public QuickRepliesPlatformMetadata(ImmutableList<QuickReplyItem> immutableList) {
        this.f1944a = immutableList;
    }

    protected QuickRepliesPlatformMetadata(Parcel parcel) {
        this.f1944a = ImmutableList.copyOf(parcel.readArrayList(QuickReplyItem.class.getClassLoader()));
    }

    public final PlatformMetadataType mo150a() {
        return PlatformMetadataType.QUICK_REPLIES;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f1944a);
    }

    public final JsonNode mo151b() {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        int size = this.f1944a.size();
        for (int i = 0; i < size; i++) {
            QuickReplyItem quickReplyItem = (QuickReplyItem) this.f1944a.get(i);
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
            if (quickReplyItem.f1946a != null) {
                objectNode.a("title", quickReplyItem.f1946a);
            }
            if (quickReplyItem.f1947b != null) {
                objectNode.a("content_type", quickReplyItem.f1947b.dbValue);
            }
            if (quickReplyItem.f1948c != null) {
                objectNode.a("payload", quickReplyItem.f1948c);
            }
            arrayNode.a(objectNode);
        }
        return arrayNode;
    }
}
