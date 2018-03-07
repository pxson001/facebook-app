package com.facebook.pages.adminedpages.service;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.BlueServiceHandler$Filter;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.adminedpages.AdminedPagesRamCache;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchGraphQLInterfaces.AdminedPagesPrefetchQuery.AdminedPages.Nodes;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel.AdminedPagesModel;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel.AdminedPagesModel.NodesModel;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchMethod.Result;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchNode;
import com.facebook.pages.adminedpages.protocol.PagesAccessTokenPrefetchMethod;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: errorDomain cannot be null */
public class AdminedPagesCacheServiceHandler implements BlueServiceHandler$Filter {
    private AdminedPagesRamCache f12814a;
    private Clock f12815b;

    public static AdminedPagesCacheServiceHandler m13657b(InjectorLike injectorLike) {
        return new AdminedPagesCacheServiceHandler(AdminedPagesRamCache.m13121a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    AdminedPagesCacheServiceHandler(AdminedPagesRamCache adminedPagesRamCache, Clock clock) {
        this.f12814a = adminedPagesRamCache;
        this.f12815b = clock;
    }

    public final OperationResult mo57a(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        if ("admined_pages_prefetch".equals(operationParams.b)) {
            return m13656b(operationParams, blueServiceHandler);
        }
        return blueServiceHandler.a(operationParams);
    }

    private OperationResult m13656b(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        OperationResult a = blueServiceHandler.a(operationParams);
        ArrayList l = a.l();
        if (l == null) {
            return a;
        }
        Result result = (Result) l.get(0);
        PagesAccessTokenPrefetchMethod.Result result2 = (PagesAccessTokenPrefetchMethod.Result) l.get(1);
        if (result == null || !result.m4511c().isPresent()) {
            return a;
        }
        AdminedPagesModel adminedPagesModel = (AdminedPagesModel) result.m4511c().get();
        int a2 = adminedPagesModel.m4513a();
        long min = Math.min(result.clientTimeMs, result2.clientTimeMs);
        this.f12814a.m13123a(a2);
        m13655a(Lists.a(adminedPagesModel.m4517b()).iterator(), result2.f4011a, min);
        return a;
    }

    private void m13655a(Iterator<? extends Nodes> it, Map<String, String> map, long j) {
        List linkedList = new LinkedList();
        List<String> arrayList = new ArrayList();
        while (it.hasNext()) {
            long j2;
            NodesModel nodesModel = (NodesModel) it.next();
            if (this.f12814a.m13131a(nodesModel.m4524c()) == null) {
                j2 = -1;
            } else {
                j2 = this.f12814a.m13131a(nodesModel.m4524c()).b;
            }
            if (j2 > j) {
                arrayList.add(nodesModel.m4524c());
            } else {
                Object adminedPagesPrefetchNode;
                String c = nodesModel.m4524c();
                if (map.containsKey(c)) {
                    adminedPagesPrefetchNode = new AdminedPagesPrefetchNode(nodesModel, (String) map.get(c));
                } else {
                    AdminedPagesPrefetchNode adminedPagesPrefetchNode2 = new AdminedPagesPrefetchNode(nodesModel);
                }
                linkedList.add(adminedPagesPrefetchNode);
            }
        }
        this.f12814a.m13127a(linkedList.iterator(), j);
        for (String b : arrayList) {
            this.f12814a.m13137b(b);
        }
        this.f12814a.m13124a(this.f12815b.a());
    }
}
