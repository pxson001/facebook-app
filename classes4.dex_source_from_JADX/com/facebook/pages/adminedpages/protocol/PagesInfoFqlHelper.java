package com.facebook.pages.adminedpages.protocol;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.FBJsonFactory;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.pages.PageInfo;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import javax.inject.Inject;

/* compiled from: error closing input stream (ignored) */
public class PagesInfoFqlHelper {
    private static final String f12842a = PagesInfoFqlHelper.class.getCanonicalName();
    private final ObjectMapper f12843b;
    private final PerformanceLogger f12844c;
    private final AbstractFbErrorReporter f12845d;

    public static PagesInfoFqlHelper m13677b(InjectorLike injectorLike) {
        return new PagesInfoFqlHelper((ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), (PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public PagesInfoFqlHelper(ObjectMapper objectMapper, PerformanceLogger performanceLogger, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f12843b = objectMapper;
        this.f12844c = performanceLogger;
        this.f12845d = abstractFbErrorReporter;
    }

    public final ArrayList<PageInfo> m13678a(JsonNode jsonNode) {
        this.f12844c.d(1245205, "DeserializeAllPages");
        ArrayList arrayList = new ArrayList(jsonNode.e());
        Iterator it = jsonNode.iterator();
        while (it.hasNext()) {
            JsonParser b = FBJsonFactory.g.b(((JsonNode) it.next()).toString());
            b.a(this.f12843b);
            arrayList.add((PageInfo) b.a(PageInfo.class));
        }
        this.f12844c.c(1245205, "DeserializeAllPages");
        m13676a(arrayList);
        return arrayList;
    }

    private void m13676a(ArrayList<PageInfo> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            PageInfo pageInfo = (PageInfo) arrayList.get(i);
            if (pageInfo.pageId == 0 || StringUtil.c(pageInfo.accessToken)) {
                this.f12845d.b(f12842a, StringLocaleUtil.a("invalid page info found, id=%d, accessToken=%s", new Object[]{Long.valueOf(pageInfo.pageId), pageInfo.accessToken}));
            }
        }
    }

    public final JsonNode m13679c(JsonNode jsonNode) {
        this.f12844c.d(1245204, "DeserializePagesAttributes");
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        JsonNode b = jsonNode.b("data");
        Preconditions.checkNotNull(b);
        Iterator it = b.iterator();
        while (it.hasNext()) {
            b = (JsonNode) it.next();
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
            objectNode.a("page_id", Long.parseLong(JSONUtil.b(b.b("id"))));
            objectNode.a("name", JSONUtil.b(b.b("name")));
            objectNode.a("access_token", JSONUtil.b(b.b("access_token")));
            objectNode.c("perms", b.b("perms"));
            objectNode.c("page_url", b.b("link"));
            objectNode.a("square_pic_url", JSONUtil.b(b.b("picture").b("data").b("url")));
            arrayNode.a(objectNode);
        }
        this.f12844c.c(1245204, "DeserializePagesAttributes");
        return arrayNode;
    }
}
