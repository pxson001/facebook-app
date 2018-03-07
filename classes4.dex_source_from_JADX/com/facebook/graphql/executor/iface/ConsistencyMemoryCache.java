package com.facebook.graphql.executor.iface;

import com.facebook.graphql.visitor.GraphQLVisitableModel;
import java.util.Map;

/* compiled from: fetchDialtoneQuota */
public interface ConsistencyMemoryCache {
    boolean mo871a(GraphQLVisitableModel graphQLVisitableModel);

    boolean mo872a(String str, String str2, Object obj);

    boolean mo873a(Map<String, Object> map);

    <T extends GraphQLVisitableModel> T mo874b(T t);

    boolean mo875b();

    <T extends GraphQLVisitableModel> T mo876c(T t);

    void mo877c();

    CacheVisitor mo878d();

    boolean mo879d(GraphQLVisitableModel graphQLVisitableModel);
}
