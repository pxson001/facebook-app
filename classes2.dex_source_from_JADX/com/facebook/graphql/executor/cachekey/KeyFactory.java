package com.facebook.graphql.executor.cachekey;

import com.facebook.common.hashcode.HashCodeBuilder;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.query.GraphQLRefParam;
import com.facebook.graphql.query.GraphQlQueryParamSet;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.query.JsonPathValue;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Throwables;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: saved_dashboard_section_list_item_clicked */
public class KeyFactory {
    private final Provider<Locale> f6159a;
    private final ObjectMapper f6160b;

    /* compiled from: saved_dashboard_section_list_item_clicked */
    enum ListType {
        EXCLUSIVE_PARAMS,
        INCLUSIVE_PARAMS
    }

    public static KeyFactory m10333b(InjectorLike injectorLike) {
        return new KeyFactory(IdBasedProvider.m1811a(injectorLike, 4483), FbObjectMapperMethodAutoProvider.m6609a(injectorLike));
    }

    @Inject
    public KeyFactory(Provider<Locale> provider, ObjectMapper objectMapper) {
        this.f6159a = provider;
        this.f6160b = objectMapper;
    }

    private HashCodeBuilder m10329a(HashCodeBuilder hashCodeBuilder, Object obj) {
        if (obj instanceof List) {
            hashCodeBuilder.m20430a((List) obj);
        } else if (obj instanceof Array) {
            hashCodeBuilder.m20429a(Arrays.deepHashCode((Object[]) obj));
        } else if (obj instanceof String) {
            hashCodeBuilder.m20430a((String) obj);
        } else if (obj instanceof Number) {
            hashCodeBuilder.m20430a((Number) obj);
        } else if (obj instanceof JsonPathValue) {
            hashCodeBuilder.m20430a(obj.toString());
        } else if (obj instanceof Boolean) {
            hashCodeBuilder.m20430a((Boolean) obj);
        } else if (obj instanceof Enum) {
            hashCodeBuilder.m20430a((Enum) obj);
        } else if (obj instanceof GraphQlCallInput) {
            hashCodeBuilder.m20430a(this.f6160b.m6659a(obj));
        } else if (obj instanceof JsonSerializable) {
            hashCodeBuilder.m20430a(this.f6160b.m6659a(obj));
        } else {
            hashCodeBuilder.m20430a(obj);
        }
        return hashCodeBuilder;
    }

    public static KeyFactory m10331a(InjectorLike injectorLike) {
        return m10333b(injectorLike);
    }

    private HashCodeBuilder m10330a(GraphQlQueryParamSet graphQlQueryParamSet, Collection<String> collection, ListType listType) {
        HashCodeBuilder a = HashCodeBuilder.m20428a();
        HashCodeBuilder hashCodeBuilder = a;
        for (Entry entry : graphQlQueryParamSet.m11384e().entrySet()) {
            if (collection == null || ((!collection.contains(entry.getKey()) && listType == ListType.EXCLUSIVE_PARAMS) || (collection.contains(entry.getKey()) && listType == ListType.INCLUSIVE_PARAMS))) {
                hashCodeBuilder.m20430a(entry.getKey());
                a = m10329a(hashCodeBuilder, entry.getValue());
            } else {
                a = hashCodeBuilder;
            }
            hashCodeBuilder = a;
        }
        for (Entry entry2 : graphQlQueryParamSet.m11381b().entrySet()) {
            hashCodeBuilder.m20430a(entry2.getKey());
            hashCodeBuilder.m20430a(((GraphQLRefParam) entry2.getValue()).a.m11600a());
            hashCodeBuilder.m20430a(((GraphQLRefParam) entry2.getValue()).b);
            hashCodeBuilder.m20430a(((GraphQLRefParam) entry2.getValue()).c.toString());
        }
        return hashCodeBuilder;
    }

    public final HashCodeBuilder m10336a(GraphQlQueryParamSet graphQlQueryParamSet, Collection<String> collection) {
        return m10330a(graphQlQueryParamSet, (Collection) collection, ListType.EXCLUSIVE_PARAMS);
    }

    private HashCodeBuilder m10332b(GraphQlQueryParamSet graphQlQueryParamSet, Collection<String> collection) {
        return m10330a(graphQlQueryParamSet, (Collection) collection, ListType.INCLUSIVE_PARAMS);
    }

    private String m10334c(GraphQlQueryParamSet graphQlQueryParamSet, Collection<String> collection) {
        return Integer.toString(m10336a(graphQlQueryParamSet, (Collection) collection).hashCode());
    }

    private String m10335d(GraphQlQueryParamSet graphQlQueryParamSet, Collection<String> collection) {
        return Integer.toString(m10332b(graphQlQueryParamSet, collection).hashCode());
    }

    public final String m10337a(GraphQlQueryString graphQlQueryString, Class<?> cls, GraphQlQueryParamSet graphQlQueryParamSet, Collection<String> collection) {
        if (graphQlQueryParamSet == null) {
            return m10338a(graphQlQueryString, (Class) cls, null);
        }
        try {
            return m10338a(graphQlQueryString, (Class) cls, m10334c(graphQlQueryParamSet, collection));
        } catch (JsonProcessingException e) {
            throw Throwables.propagate(e);
        }
    }

    public final String m10339b(GraphQlQueryString graphQlQueryString, Class<?> cls, GraphQlQueryParamSet graphQlQueryParamSet, Collection<String> collection) {
        if (graphQlQueryParamSet == null) {
            return m10338a(graphQlQueryString, (Class) cls, null);
        }
        try {
            return m10338a(graphQlQueryString, (Class) cls, m10335d(graphQlQueryParamSet, collection));
        } catch (JsonProcessingException e) {
            throw Throwables.propagate(e);
        }
    }

    public final String m10338a(GraphQlQueryString graphQlQueryString, Class<?> cls, String str) {
        StringBuilder stringBuilder = new StringBuilder(110);
        stringBuilder.append(graphQlQueryString.f6530b);
        stringBuilder.append(':');
        if (cls != null) {
            stringBuilder.append(cls.getSimpleName());
            stringBuilder.append(':');
            ModelWithFlatBufferFormatHash modelWithFlatBufferFormatHash = (ModelWithFlatBufferFormatHash) cls.getAnnotation(ModelWithFlatBufferFormatHash.class);
            if (modelWithFlatBufferFormatHash != null) {
                stringBuilder.append(StringFormatUtil.formatStrLocaleSafe("%x", Integer.valueOf(modelWithFlatBufferFormatHash.m20431a())));
                stringBuilder.append(':');
            }
        }
        stringBuilder.append(graphQlQueryString.f6531c);
        stringBuilder.append(':');
        stringBuilder.append(((Locale) this.f6159a.get()).toString());
        if (str != null) {
            stringBuilder.append(':');
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }
}
