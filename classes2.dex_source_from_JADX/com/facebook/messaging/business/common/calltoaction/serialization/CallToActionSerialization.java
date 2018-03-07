package com.facebook.messaging.business.common.calltoaction.serialization;

import com.facebook.common.json.ObjectMapperWithUncheckedException;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.common.calltoaction.model.CallToAction;
import com.facebook.messaging.business.common.calltoaction.model.CallToAction.Type;
import com.facebook.messaging.business.common.calltoaction.model.CallToActionBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mTimingCurves */
public class CallToActionSerialization {
    private final ObjectMapperWithUncheckedException f15349a;

    public static CallToActionSerialization m21865b(InjectorLike injectorLike) {
        return new CallToActionSerialization(ObjectMapperWithUncheckedException.m21860a(injectorLike));
    }

    @Inject
    public CallToActionSerialization(ObjectMapperWithUncheckedException objectMapperWithUncheckedException) {
        this.f15349a = objectMapperWithUncheckedException;
    }

    @Nullable
    public static String m21864a(List<CallToAction> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.f3121a);
        for (CallToAction callToAction : list) {
            String str = null;
            JsonNode objectNode = new ObjectNode(JsonNodeFactory.f3121a);
            objectNode.m5137a("id", callToAction.a());
            objectNode.m5137a("title", callToAction.f);
            objectNode.m5137a("action_url", callToAction.a == null ? null : callToAction.a.toString());
            String str2 = "action_type";
            if (callToAction.b != null) {
                str = callToAction.b.name();
            }
            objectNode.m5137a(str2, str);
            str2 = "action_targets";
            List<String> list2 = callToAction.c;
            JsonNode arrayNode2 = new ArrayNode(JsonNodeFactory.f3121a);
            for (String h : list2) {
                arrayNode2.m13394h(h);
            }
            objectNode.m5143c(str2, arrayNode2);
            objectNode.m5138a("action_url", callToAction.d);
            arrayNode.m13381a(objectNode);
        }
        return arrayNode.toString();
    }

    public final ImmutableList<CallToAction> m21866a(String str) {
        if (StringUtil.m3589a((CharSequence) str)) {
            return RegularImmutableList.f535a;
        }
        Builder builder = ImmutableList.builder();
        Iterator it = this.f15349a.m21862a(str).iterator();
        while (it.hasNext()) {
            JsonNode jsonNode = (JsonNode) it.next();
            String b = JSONUtil.m13458b(jsonNode.mo709b("id"));
            String b2 = JSONUtil.m13458b(jsonNode.mo709b("title"));
            String b3 = JSONUtil.m13458b(jsonNode.mo709b("action_url"));
            String b4 = JSONUtil.m13458b(jsonNode.mo709b("action_type"));
            JsonNode b5 = jsonNode.mo709b("action_targets");
            Builder builder2 = ImmutableList.builder();
            Iterator it2 = b5.iterator();
            while (it2.hasNext()) {
                builder2.m1069c(((JsonNode) it2.next()).mo719B());
            }
            CallToAction a = m21863a(b, b2, b3, b4, builder2.m1068b(), JSONUtil.m13456a(jsonNode.mo709b("dff_enabled"), false));
            if (a != null) {
                builder.m1069c(a);
            }
        }
        return builder.m1068b();
    }

    @Nullable
    public static CallToAction m21863a(String str, String str2, String str3, String str4, ImmutableList<String> immutableList, boolean z) {
        if (str == null || str2 == null) {
            return null;
        }
        Type fromDbValue = Type.fromDbValue(str4);
        if (fromDbValue == null) {
            return null;
        }
        CallToActionBuilder callToActionBuilder = new CallToActionBuilder();
        callToActionBuilder.a = str;
        callToActionBuilder = callToActionBuilder;
        callToActionBuilder.b = str2;
        callToActionBuilder = callToActionBuilder.c(str3);
        callToActionBuilder.d = fromDbValue;
        callToActionBuilder = callToActionBuilder;
        callToActionBuilder.e = immutableList;
        callToActionBuilder = callToActionBuilder;
        callToActionBuilder.f = z;
        return callToActionBuilder.g();
    }
}
