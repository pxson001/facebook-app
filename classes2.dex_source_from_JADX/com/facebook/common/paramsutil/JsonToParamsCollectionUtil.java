package com.facebook.common.paramsutil;

import com.facebook.crudolib.params.ParamsCollectionArray;
import com.facebook.crudolib.params.ParamsCollectionMap;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.annotation.Nullable;

/* compiled from: tags_to_visit_count */
public class JsonToParamsCollectionUtil {
    public static void m5474a(String str, @Nullable JsonNode jsonNode, ParamsCollectionMap paramsCollectionMap) {
        if (jsonNode == null || jsonNode.m5205q()) {
            paramsCollectionMap.m5421a(str, null);
        } else if (jsonNode.m5203o()) {
            paramsCollectionMap.m5421a(str, jsonNode.mo728s());
        } else if (jsonNode.m5201m()) {
            paramsCollectionMap.m5420a(str, jsonNode.mo1282v());
        } else if (jsonNode.m5204p()) {
            paramsCollectionMap.m5419a(str, Boolean.valueOf(jsonNode.mo1647u()));
        } else if (jsonNode.m5197i()) {
            m5473a((ObjectNode) jsonNode, paramsCollectionMap.m5422b(str));
        } else if (jsonNode.m5196h()) {
            m5472a((ArrayNode) jsonNode, str, paramsCollectionMap.m5425c(str));
        } else {
            throw new IllegalArgumentException("Unsupported JSON type: " + jsonNode.mo715k());
        }
    }

    public static void m5473a(ObjectNode objectNode, ParamsCollectionMap paramsCollectionMap) {
        Iterator H = objectNode.mo705H();
        while (H.hasNext()) {
            Entry entry = (Entry) H.next();
            String str = (String) entry.getKey();
            JsonNode jsonNode = (JsonNode) entry.getValue();
            if (jsonNode.m5205q()) {
                paramsCollectionMap.m5421a(str, null);
            } else if (jsonNode.m5203o()) {
                paramsCollectionMap.m5421a(str, jsonNode.mo728s());
            } else if (jsonNode.m5201m()) {
                paramsCollectionMap.m5420a(str, jsonNode.mo1282v());
            } else if (jsonNode.m5204p()) {
                paramsCollectionMap.m5419a(str, Boolean.valueOf(jsonNode.mo1647u()));
            } else if (jsonNode.m5197i()) {
                m5473a((ObjectNode) jsonNode, paramsCollectionMap.m5422b(str));
            } else if (jsonNode.m5196h()) {
                m5472a((ArrayNode) jsonNode, str, paramsCollectionMap.m5425c(str));
            } else {
                throw new IllegalArgumentException("Unsupported JSON type for '" + str + "': " + jsonNode.mo715k());
            }
        }
    }

    private static void m5472a(ArrayNode arrayNode, @Nullable String str, ParamsCollectionArray paramsCollectionArray) {
        Iterator G = arrayNode.mo704G();
        while (G.hasNext()) {
            JsonNode jsonNode = (JsonNode) G.next();
            if (jsonNode.m5205q()) {
                paramsCollectionArray.m11500a(null);
            } else if (jsonNode.m5203o()) {
                paramsCollectionArray.m11500a(jsonNode.mo728s());
            } else if (jsonNode.m5201m()) {
                paramsCollectionArray.m11499a(jsonNode.mo1282v());
            } else if (jsonNode.m5204p()) {
                paramsCollectionArray.m11498a(Boolean.valueOf(jsonNode.mo1647u()));
            } else if (jsonNode.m5197i()) {
                m5473a((ObjectNode) jsonNode, paramsCollectionArray.mo1634k());
            } else if (jsonNode.m5196h()) {
                m5472a((ArrayNode) jsonNode, str, paramsCollectionArray.mo1635l());
            } else {
                throw new IllegalArgumentException("Unsupported JSON type for '" + str + "': " + jsonNode.mo715k());
            }
        }
    }
}
