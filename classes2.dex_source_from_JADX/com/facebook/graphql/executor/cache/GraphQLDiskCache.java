package com.facebook.graphql.executor.cache;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.disk.DiskTrimmable;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.iface.CacheVisitor;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: saved_more_menu_imp */
public interface GraphQLDiskCache extends IHaveUserData, DiskTrimmable, GraphQLRequestDiskCache {
    Map<String, Map<String, Object>> mo1440a(Collection<String> collection);

    void mo1442a(CacheVisitor cacheVisitor);

    void mo1443a(Map<String, Map<String, Object>> map);

    void mo1444a(Set<String> set);

    void mo1445c();

    void mo1446c(GraphQLRequest graphQLRequest);
}
