package com.facebook.graphql.query;

import com.facebook.crudolib.params.ParamsCollectionMap;
import com.facebook.crudolib.params.ParamsCollectionPool;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.annotation.Nullable;

@JsonDeserialize(using = GraphQlQueryParamSetDeserializer.class)
/* compiled from: robotext */
public class GraphQlQueryParamSet implements JsonSerializable {
    public static final GraphQlQueryParamSet f6570a = new GraphQlQueryParamSet();
    protected Map<String, GraphQLRefParam> f6571b;
    protected Map<String, Object> f6572c;
    @JsonProperty("params")
    protected GraphQlQueryParamCallInput mParams;

    public GraphQlQueryParamSet() {
        this.mParams = new GraphQlQueryParamCallInput();
        this.f6571b = new TreeMap();
        this.f6572c = new TreeMap();
    }

    public GraphQlQueryParamSet(Map<String, Object> map) {
        this();
        GraphQlCallInput graphQlCallInput = this.mParams;
        graphQlCallInput.m11392a(graphQlCallInput.m11391a(), (Map) map);
    }

    public final ParamsCollectionPool m11369a() {
        return this.mParams.f6574a;
    }

    @Deprecated
    public final Object m11378a(String str) {
        return this.mParams.m11401n(str);
    }

    public final Map<String, GraphQLRefParam> m11381b() {
        return this.f6571b;
    }

    public final Map<String, Object> m11382c() {
        return this.f6572c;
    }

    public final GraphQlQueryParamSet m11379b(String str) {
        ParamsCollectionMap a = this.mParams.m11391a();
        for (int i = 0; i < a.f3273c; i++) {
            if (a.m5423b(i).equals(str)) {
                a.f3272b.remove((i * 2) + 1);
                a.f3272b.remove(i * 2);
                a.f3273c--;
                break;
            }
        }
        return this;
    }

    @Deprecated
    public final GraphQlQueryParamSet m11375a(String str, Object obj) {
        if (obj != null) {
            this.mParams.m11386a(str, obj);
        }
        return this;
    }

    public final GraphQlQueryParamSet m11376a(String str, @Nullable String str2) {
        if (str2 != null) {
            this.mParams.m11397a(str, str2);
        }
        return this;
    }

    public final GraphQlQueryParamSet m11374a(String str, Number number) {
        if (number != null) {
            this.mParams.m11391a().m5420a(str, number);
        }
        return this;
    }

    public final GraphQlQueryParamSet m11372a(String str, Boolean bool) {
        if (bool != null) {
            this.mParams.m11385a(str, bool);
        }
        return this;
    }

    public final GraphQlQueryParamSet m11377a(String str, @Nullable List<?> list) {
        if (list != null) {
            this.mParams.m11398a(str, (List) list);
        }
        return this;
    }

    public final GraphQlQueryParamSet m11370a(String str, GraphQlCallInput graphQlCallInput) {
        if (graphQlCallInput != null) {
            this.mParams.m11393a(str, graphQlCallInput);
        }
        return this;
    }

    public final GraphQlQueryParamSet m11373a(String str, Enum enumR) {
        if (enumR != null) {
            this.mParams.m11395a(str, enumR);
        }
        return this;
    }

    public final ParamsCollectionMap m11383d() {
        return this.mParams.f6575b;
    }

    public final Map<String, Object> m11384e() {
        return this.mParams.m11399b();
    }

    public final GraphQlQueryParamSet m11371a(String str, GraphQLRefParam graphQLRefParam) {
        if (graphQLRefParam != null) {
            this.f6571b.put(str, graphQLRefParam);
        }
        return this;
    }

    public final GraphQlQueryParamSet m11380b(String str, Object obj) {
        if (obj != null) {
            this.f6572c.put(str, obj);
        }
        return this;
    }

    public void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.mo1134f();
        jsonGenerator.mo1115a("params");
        jsonGenerator.mo1114a(m11384e());
        jsonGenerator.mo1115a("input_name");
        jsonGenerator.mo1123b(null);
        jsonGenerator.mo1136g();
    }

    public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        throw new UnsupportedOperationException();
    }
}
