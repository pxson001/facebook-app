package com.facebook.graphql.query;

import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: edit_post_params */
public class ShimmedMutationRequestParams {
    public static final List<VariableType> f4802i = Lists.a(new VariableType[]{VariableType.ARRAY, VariableType.LITERAL, VariableType.EQUALS});
    public final String f4803a;
    public final String f4804b;
    private final String f4805c;
    private final Variable[] f4806d;
    private final String[] f4807e;
    private final Variable[] f4808f;
    private final ResultQuery[] f4809g;
    private final String f4810h;

    /* compiled from: edit_post_params */
    public class ResultQuery {
        public final String[] f4794a;
        public final Variable[] f4795b;
        public final String[] f4796c;
        public final TypedGraphQlQueryString f4797d;
        public final String f4798e;

        public ResultQuery(String[] strArr, Variable[] variableArr, String[] strArr2, TypedGraphQlQueryString typedGraphQlQueryString, String str) {
            this.f4794a = strArr;
            this.f4795b = variableArr;
            this.f4796c = strArr2;
            this.f4797d = typedGraphQlQueryString;
            this.f4798e = str;
        }

        public final String m9597a() {
            return this.f4798e;
        }

        public final TypedGraphQlQueryString m9598b() {
            return this.f4797d;
        }
    }

    /* compiled from: edit_post_params */
    public class Variable {
        public final VariableType f4799a;
        public final String f4800b;
        public final Object f4801c;

        private void m9599a(boolean z) {
            Preconditions.checkArgument(z, "Error trying to substitute variable \"" + this.f4800b + "\" (of type \"" + this.f4799a.name() + "\") for shimmed mutation");
        }

        public Variable(VariableType variableType, String str) {
            this.f4799a = variableType;
            this.f4800b = str;
            this.f4801c = null;
            m9599a(!ShimmedMutationRequestParams.f4802i.contains(variableType));
        }

        public Variable(VariableType variableType, String str, Object obj) {
            this.f4799a = variableType;
            this.f4800b = str;
            this.f4801c = obj;
            m9599a(ShimmedMutationRequestParams.f4802i.contains(variableType));
        }

        public final String m9600a(Map<String, Object> map, FbObjectMapper fbObjectMapper) {
            if (this.f4799a == VariableType.LITERAL) {
                return (String) this.f4801c;
            }
            boolean z;
            if (this.f4799a != VariableType.ARRAY) {
                z = true;
            } else {
                z = false;
            }
            m9599a(z);
            m9599a(map.containsKey(this.f4800b));
            if (this.f4799a == VariableType.FIELD) {
                return map.get(this.f4800b).toString();
            }
            if (this.f4799a == VariableType.EQUALS) {
                return Boolean.valueOf(((String) this.f4801c).equals(map.get(this.f4800b).toString())).toString();
            }
            if (this.f4799a == VariableType.JSON) {
                return fbObjectMapper.a(map.get(this.f4800b));
            }
            if (this.f4799a == VariableType.LIST) {
                z = true;
            } else {
                z = false;
            }
            m9599a(z);
            return StringUtil.b(",", new Object[]{map.get(this.f4800b)});
        }

        public final List<String> m9601b(Map<String, Object> map, FbObjectMapper fbObjectMapper) {
            boolean z;
            if (this.f4799a == VariableType.ARRAY) {
                z = true;
            } else {
                z = false;
            }
            m9599a(z);
            Variable[] variableArr = (Variable[]) this.f4801c;
            List<String> a = Lists.a();
            int i = 0;
            while (i < variableArr.length) {
                boolean z2;
                if (variableArr[i].f4799a != VariableType.ARRAY) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                m9599a(z2);
                if (variableArr[i].f4799a == VariableType.LITERAL || map.containsKey(variableArr[i].f4800b)) {
                    a.add(variableArr[i].m9600a(map, fbObjectMapper));
                }
                i++;
            }
            return a;
        }
    }

    /* compiled from: edit_post_params */
    public enum VariableType {
        ARRAY,
        FIELD,
        JSON,
        LIST,
        EQUALS,
        LITERAL
    }

    public ShimmedMutationRequestParams(String str, String str2, String str3, Variable[] variableArr, String[] strArr, Variable[] variableArr2, ResultQuery[] resultQueryArr, String str4) {
        this.f4803a = str;
        this.f4804b = str2;
        this.f4805c = str3;
        this.f4806d = variableArr;
        this.f4807e = strArr;
        this.f4808f = variableArr2;
        this.f4809g = resultQueryArr;
        this.f4810h = str4;
    }

    private Map<String, Object> m9602a(Map<String, Object> map) {
        Object obj = map.get(this.f4810h);
        if (obj instanceof GraphQlCallInput) {
            return ((GraphQlCallInput) obj).b();
        }
        return (Map) obj;
    }

    public final ResultQuery[] m9603a(Map<String, Object> map, FbObjectMapper fbObjectMapper) {
        Map a = m9602a(map);
        for (ResultQuery resultQuery : this.f4809g) {
            int i;
            GraphQlQueryParamSet j = resultQuery.f4797d.j();
            for (String str : resultQuery.f4796c) {
                j.a(str, map.get(str));
            }
            for (i = 0; i < resultQuery.f4794a.length; i++) {
                if (resultQuery.f4795b[i].f4799a == VariableType.ARRAY) {
                    j.a(resultQuery.f4794a[i], resultQuery.f4795b[i].m9601b(a, fbObjectMapper));
                } else {
                    j.a(resultQuery.f4794a[i], resultQuery.f4795b[i].m9600a(a, fbObjectMapper));
                }
            }
        }
        return this.f4809g;
    }

    public final String m9604b(Map<String, Object> map, FbObjectMapper fbObjectMapper) {
        Map a = m9602a(map);
        Object[] objArr = new Object[this.f4806d.length];
        for (int i = 0; i < this.f4806d.length; i++) {
            objArr[i] = this.f4806d[i].m9600a(a, fbObjectMapper);
        }
        return StringFormatUtil.a(this.f4805c, objArr);
    }

    public final List<NameValuePair> m9605c(Map<String, Object> map, FbObjectMapper fbObjectMapper) {
        List<NameValuePair> a = Lists.a();
        Map a2 = m9602a(map);
        for (int i = 0; i < this.f4808f.length; i++) {
            if (this.f4808f[i].f4799a == VariableType.ARRAY) {
                for (String basicNameValuePair : this.f4808f[i].m9601b(a2, fbObjectMapper)) {
                    a.add(new BasicNameValuePair(this.f4807e[i], basicNameValuePair));
                }
            } else if (this.f4808f[i].f4799a == VariableType.LITERAL) {
                a.add(new BasicNameValuePair(this.f4807e[i], (String) this.f4808f[i].f4801c));
            } else if (a2.containsKey(this.f4808f[i].f4800b)) {
                a.add(new BasicNameValuePair(this.f4807e[i], this.f4808f[i].m9600a(a2, fbObjectMapper)));
            }
        }
        return a;
    }
}
