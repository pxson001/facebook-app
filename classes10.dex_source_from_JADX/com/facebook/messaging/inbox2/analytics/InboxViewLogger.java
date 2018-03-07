package com.facebook.messaging.inbox2.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.items.InboxItem;
import com.facebook.messaging.inbox2.items.InboxUnitItem;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.HashMultimap;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: settings_upsell */
public class InboxViewLogger {
    private static final Class<?> f2651a = InboxViewLogger.class;
    private final AnalyticsLogger f2652b;
    private final FbObjectMapper f2653c;

    public static InboxViewLogger m2623b(InjectorLike injectorLike) {
        return new InboxViewLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    public static InboxViewLogger m2618a(InjectorLike injectorLike) {
        return m2623b(injectorLike);
    }

    @Inject
    public InboxViewLogger(AnalyticsLogger analyticsLogger, FbObjectMapper fbObjectMapper) {
        this.f2652b = analyticsLogger;
        this.f2653c = fbObjectMapper;
    }

    public final void m2626a(Collection<ItemInfo> collection) {
        Integer.valueOf(collection.size());
        if (!collection.isEmpty()) {
            Object arrayNode = new ArrayNode(JsonNodeFactory.a);
            HashMultimap u = HashMultimap.u();
            for (ItemInfo itemInfo : collection) {
                if (itemInfo.f2654a instanceof InboxUnitItem) {
                    InboxUnitItem inboxUnitItem = (InboxUnitItem) itemInfo.f2654a;
                    if (inboxUnitItem.d.o()) {
                        arrayNode.a(m2619a(itemInfo));
                    } else {
                        u.a(inboxUnitItem.d, itemInfo);
                    }
                } else {
                    arrayNode.a(m2619a(itemInfo));
                }
            }
            for (Entry entry : u.b().entrySet()) {
                NodesModel nodesModel = (NodesModel) entry.getKey();
                Collection<ItemInfo> collection2 = (Collection) entry.getValue();
                int i = Integer.MAX_VALUE;
                long j = 0;
                for (ItemInfo itemInfo2 : collection2) {
                    j = itemInfo2.f2655b + j;
                    i = Math.min(i, itemInfo2.f2659f);
                }
                j /= (long) collection2.size();
                ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
                if (BLog.b(2)) {
                    objectNode.a("u", nodesModel.r().toString());
                }
                objectNode.a("id", nodesModel.j());
                objectNode.a("p", i);
                if (!StringUtil.a(nodesModel.n())) {
                    objectNode.a("ulg", nodesModel.n());
                }
                objectNode.a("t", m2620a(j));
                objectNode.a("n", collection2.size());
                arrayNode.a(objectNode);
            }
            m2622a(arrayNode);
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("inbox2_vpv");
            honeyClientEvent.c = "inbox2";
            this.f2652b.a(honeyClientEvent.a("is", arrayNode));
        }
    }

    private ObjectNode m2619a(ItemInfo itemInfo) {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        m2621a(objectNode, itemInfo.f2654a, itemInfo.f2659f);
        objectNode.a("t", m2620a(itemInfo.f2655b));
        objectNode.a("h", itemInfo.f2660g);
        return objectNode;
    }

    public final void m2624a(InboxItem inboxItem, int i) {
        m2625a(inboxItem, i, null, null);
    }

    public final void m2625a(InboxItem inboxItem, int i, @Nullable String str, @Nullable Map<String, String> map) {
        Object objectNode = new ObjectNode(JsonNodeFactory.a);
        m2621a(objectNode, inboxItem, i);
        if (str != null) {
            objectNode.a("ct", str);
        }
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                objectNode.a((String) entry.getKey(), (String) entry.getValue());
            }
        }
        m2622a(objectNode);
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("inbox2_click");
        honeyClientEvent.c = "inbox2";
        this.f2652b.a(honeyClientEvent.a("i", objectNode));
    }

    private static void m2621a(ObjectNode objectNode, InboxItem inboxItem, int i) {
        if (inboxItem instanceof InboxUnitItem) {
            InboxUnitItem inboxUnitItem = (InboxUnitItem) inboxItem;
            if (BLog.b(2)) {
                objectNode.a("u", inboxUnitItem.d.r().toString());
            }
            objectNode.a("id", inboxUnitItem.me_());
            objectNode.a("p", i);
            objectNode.a("rp", inboxUnitItem.g);
            if (!StringUtil.a(inboxUnitItem.d.n())) {
                objectNode.a("ulg", inboxUnitItem.d.n());
            }
            if (inboxUnitItem.e != null && !StringUtil.a(inboxUnitItem.e.o())) {
                objectNode.a("ilg", inboxUnitItem.e.o());
            }
        }
    }

    private void m2622a(Object obj) {
        if (BLog.b(2)) {
            try {
                this.f2653c.a(new DefaultPrettyPrinter()).a(obj);
            } catch (JsonProcessingException e) {
            }
        }
    }

    public static String m2620a(long j) {
        return StringFormatUtil.a("%.3f", new Object[]{Float.valueOf(((float) j) / 1000.0f)});
    }
}
