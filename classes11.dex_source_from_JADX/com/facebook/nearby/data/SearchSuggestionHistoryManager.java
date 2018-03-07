package com.facebook.nearby.data;

import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.model.GraphQLGeoRectangle;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.nearby.common.NearbyTopic;
import com.facebook.nearby.common.SearchSuggestion;
import com.facebook.nearby.prefs.NearbyPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: user_bulk_rejected */
public class SearchSuggestionHistoryManager {
    private final FbSharedPreferences f318a;
    private final String f319b;
    private final SearchSuggestionSerialization f320c;
    public ImmutableList<SearchSuggestion> f321d = m410b();

    /* compiled from: user_bulk_rejected */
    public class SearchSuggestionSerialization {
        private final ObjectMapper f317a;

        public SearchSuggestionSerialization(ObjectMapper objectMapper) {
            this.f317a = objectMapper;
        }

        public final String m409a(List<SearchSuggestion> list) {
            ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
            for (SearchSuggestion searchSuggestion : list) {
                ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
                objectNode.a("title", searchSuggestion.a);
                objectNode.a("suggestionSearchBarText", searchSuggestion.b);
                if (searchSuggestion.c != null) {
                    GraphQLGeoRectangle graphQLGeoRectangle = searchSuggestion.c;
                    ObjectNode objectNode2 = new ObjectNode(JsonNodeFactory.a);
                    objectNode2.a("north", graphQLGeoRectangle.j());
                    objectNode2.a("west", graphQLGeoRectangle.l());
                    objectNode2.a("south", graphQLGeoRectangle.k());
                    objectNode2.a("east", graphQLGeoRectangle.a());
                    objectNode.c("bounds", objectNode2);
                }
                if (searchSuggestion.d != null) {
                    objectNode.c("topic", m406a(searchSuggestion.d));
                }
                arrayNode.a(objectNode);
            }
            return arrayNode.toString();
        }

        public final Iterable<SearchSuggestion> m408a(String str) {
            Builder builder = new Builder();
            try {
                Iterator it = this.f317a.a(str).iterator();
                while (it.hasNext()) {
                    JsonNode jsonNode = (JsonNode) it.next();
                    String a = JSONUtil.a(jsonNode.b("title"), null);
                    if (a != null) {
                        String a2;
                        GraphQLGeoRectangle b;
                        NearbyTopic a3;
                        if (jsonNode.d("suggestionSearchBarText")) {
                            a2 = JSONUtil.a(jsonNode.b("suggestionSearchBarText"), null);
                        } else {
                            a2 = null;
                        }
                        if (jsonNode.d("bounds")) {
                            b = m407b(jsonNode.b("bounds"));
                        } else {
                            b = null;
                        }
                        if (jsonNode.d("topic")) {
                            a3 = m405a(jsonNode.b("topic"));
                        } else {
                            a3 = null;
                        }
                        builder.c(new SearchSuggestion(a, a2, b, a3));
                    }
                }
                return builder.b();
            } catch (Throwable e) {
                throw new RuntimeException("Unexpected serialization exception", e);
            }
        }

        private static NearbyTopic m405a(JsonNode jsonNode) {
            String a = JSONUtil.a(jsonNode.b("name"), null);
            Set a2 = Sets.a();
            Iterator it = jsonNode.b("ids").iterator();
            while (it.hasNext()) {
                a2.add(Long.valueOf(JSONUtil.a((JsonNode) it.next(), 0)));
            }
            return new NearbyTopic(a2, a);
        }

        private static GraphQLGeoRectangle m407b(JsonNode jsonNode) {
            return GraphQLHelper.a((float) JSONUtil.e(jsonNode.b("north")), (float) JSONUtil.e(jsonNode.b("west")), (float) JSONUtil.e(jsonNode.b("south")), (float) JSONUtil.e(jsonNode.b("east")));
        }

        private ObjectNode m406a(NearbyTopic nearbyTopic) {
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
            String str = "ids";
            ImmutableSet<Long> immutableSet = nearbyTopic.b;
            ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
            for (Long a : immutableSet) {
                arrayNode.a(a);
            }
            objectNode.c(str, arrayNode);
            objectNode.a("name", nearbyTopic.a);
            return objectNode;
        }
    }

    @Inject
    public SearchSuggestionHistoryManager(FbSharedPreferences fbSharedPreferences, ObjectMapper objectMapper, Provider<String> provider) {
        this.f318a = fbSharedPreferences;
        this.f319b = (String) provider.get();
        this.f320c = new SearchSuggestionSerialization(objectMapper);
    }

    public final void m412a(SearchSuggestion searchSuggestion) {
        Builder builder = new Builder();
        builder.c(searchSuggestion);
        int i = 1;
        int size = this.f321d.size();
        int i2 = 0;
        while (i2 < size) {
            int i3;
            SearchSuggestion searchSuggestion2 = (SearchSuggestion) this.f321d.get(i2);
            if (!searchSuggestion2.equals(searchSuggestion)) {
                builder.c(searchSuggestion2);
                i3 = i + 1;
                if (i3 == 10) {
                    break;
                }
            } else {
                i3 = i;
            }
            i2++;
            i = i3;
        }
        this.f321d = builder.b();
        this.f318a.edit().a(m411c(), this.f320c.m409a(this.f321d)).commit();
    }

    private ImmutableList<SearchSuggestion> m410b() {
        String a = this.f318a.a(m411c(), "");
        if (StringUtil.a(a)) {
            return RegularImmutableList.a;
        }
        return ImmutableList.copyOf(this.f320c.m408a(a));
    }

    private PrefKey m411c() {
        return (PrefKey) NearbyPrefKeys.f507a.a("category_history/" + this.f319b);
    }
}
