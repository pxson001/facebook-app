package com.facebook.graphql.protocol.parsing;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.graphql.error.GraphQLError;
import com.facebook.graphql.error.GraphQLException;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.http.protocol.ApiErrorResult.Builder;
import com.facebook.http.protocol.ApiErrorResult.ErrorDomain;
import com.facebook.http.protocol.GraphQLAuthException;
import com.facebook.http.protocol.GraphQlInvalidQueryIdException;
import com.facebook.http.protocol.GraphQlUnpersistableQueryException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: graphql_token */
public class GraphQLProtocolParseHelper {
    private static String m29713a(JsonParser jsonParser, ObjectMapper objectMapper) {
        if (jsonParser.mo1794g() == null) {
            jsonParser.mo1766c();
        }
        m29717a(jsonParser, JsonToken.START_OBJECT);
        JsonToken c = jsonParser.mo1766c();
        m29717a(jsonParser, JsonToken.FIELD_NAME, JsonToken.END_OBJECT);
        String i = jsonParser.mo1778i();
        if (c == JsonToken.FIELD_NAME) {
            jsonParser.mo1766c();
        }
        if (!"error".equals(jsonParser.mo1778i())) {
            return i;
        }
        throw m29712a((GraphQLError) objectMapper.mo908a(jsonParser, GraphQLError.class));
    }

    private static void m29717a(JsonParser jsonParser, JsonToken... jsonTokenArr) {
        Object obj = 1;
        for (JsonToken jsonToken : jsonTokenArr) {
            if (jsonParser.mo1794g() == jsonToken) {
                obj = null;
            }
        }
        if (obj != null) {
            throw new IOException("Expected token(s) " + Joiner.on(',').join((Object[]) jsonTokenArr) + " but found " + FbJsonDeserializer.m13806a(jsonParser));
        }
    }

    public static Exception m29712a(GraphQLError graphQLError) {
        Builder a = ApiErrorResult.a(graphQLError.code, graphQLError.description);
        a.d = graphQLError.debugInfo;
        ApiErrorResult a2 = a.a(ErrorDomain.GRAPHQL_KERROR_DOMAIN).a();
        switch (graphQLError.code) {
            case 102:
            case 190:
                return new GraphQLAuthException(a2);
            case 1675007:
                return new GraphQlInvalidQueryIdException(a2);
            case 1675013:
                return new GraphQlUnpersistableQueryException(a2);
            default:
                return new GraphQLException(graphQLError);
        }
    }

    @Deprecated
    public static <T> Map<String, T> m29715a(Class<T> cls, JsonParser jsonParser, int i, ObjectMapper objectMapper) {
        if (jsonParser.mo1794g() == null) {
            jsonParser.mo1766c();
        }
        Map c = Maps.m838c();
        JsonToken g = jsonParser.mo1794g();
        if (g == JsonToken.START_OBJECT) {
            g = jsonParser.mo1766c();
        }
        while (g == JsonToken.FIELD_NAME) {
            Object a;
            String i2 = jsonParser.mo1778i();
            jsonParser.mo1766c();
            if (i2.equals("error")) {
                TreeNode J = jsonParser.m13251J();
                GraphQLError graphQLError = (GraphQLError) J.mo720a((ObjectCodec) objectMapper).m13259a(GraphQLError.class);
                if (graphQLError == null || graphQLError.code < 0) {
                    a = J.mo720a((ObjectCodec) objectMapper).m13259a((Class) cls);
                } else {
                    throw m29712a(graphQLError);
                }
            }
            int i3 = i;
            while (true) {
                int i4 = i3 - 1;
                if (i3 <= 0) {
                    break;
                }
                m29716a(jsonParser);
                i3 = i4;
            }
            a = jsonParser.m13259a((Class) cls);
            c.put(i2, a);
            g = jsonParser.mo1766c();
        }
        return c;
    }

    public static <T> List<T> m29714a(Class<T> cls, JsonParser jsonParser, ObjectMapper objectMapper) {
        if (jsonParser.mo1794g() == null) {
            jsonParser.mo1766c();
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        JsonToken g = jsonParser.mo1794g();
        if (g == JsonToken.START_OBJECT) {
            g = jsonParser.mo1766c();
        }
        while (g == JsonToken.FIELD_NAME) {
            String i = jsonParser.mo1778i();
            jsonParser.mo1766c();
            if (i.equals("error")) {
                TreeNode J = jsonParser.m13251J();
                GraphQLError graphQLError = (GraphQLError) J.mo720a((ObjectCodec) objectMapper).m13259a(GraphQLError.class);
                if (graphQLError == null || graphQLError.code < 0) {
                    Object a = J.mo720a((ObjectCodec) objectMapper).m13259a((Class) cls);
                } else {
                    throw m29712a(graphQLError);
                }
            }
            a = jsonParser.m13259a((Class) cls);
            if (a != null) {
                builder.m1069c(a);
            }
            g = jsonParser.mo1766c();
        }
        return builder.m1068b();
    }

    private static void m29716a(JsonParser jsonParser) {
        if (jsonParser.mo1794g() == JsonToken.START_ARRAY) {
            jsonParser.mo1766c();
        }
        m29717a(jsonParser, JsonToken.START_OBJECT);
        jsonParser.mo1766c();
        m29717a(jsonParser, JsonToken.FIELD_NAME, JsonToken.END_OBJECT);
        jsonParser.mo1766c();
        if ("__type__".equals(jsonParser.mo1778i())) {
            jsonParser.mo1793f();
            jsonParser.mo1766c();
            m29717a(jsonParser, JsonToken.FIELD_NAME);
            jsonParser.mo1766c();
        }
    }

    public static JsonParser m29711a(int i, JsonParser jsonParser, ObjectMapper objectMapper) {
        if (i > 0) {
            m29713a(jsonParser, objectMapper);
            while (true) {
                i--;
                if (i <= 0) {
                    break;
                }
                m29716a(jsonParser);
            }
        } else if (jsonParser.mo1794g() == null) {
            jsonParser.mo1766c();
        }
        m29717a(jsonParser, JsonToken.VALUE_NULL, JsonToken.START_OBJECT, JsonToken.START_ARRAY, JsonToken.END_OBJECT);
        return jsonParser;
    }
}
