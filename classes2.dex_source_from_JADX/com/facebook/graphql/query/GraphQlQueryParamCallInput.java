package com.facebook.graphql.query;

import com.facebook.graphql.calls.GraphQlCallInput;
import java.util.List;

/* compiled from: ro_RO */
class GraphQlQueryParamCallInput extends GraphQlCallInput {
    GraphQlQueryParamCallInput() {
    }

    final void m11385a(String str, Boolean bool) {
        m11397a(str, bool.toString());
    }

    final void m11386a(String str, Object obj) {
        if (obj != null) {
            if (obj instanceof String) {
                m11397a(str, (String) obj);
            } else if (obj instanceof Number) {
                m11391a().m5420a(str, (Number) obj);
            } else if (obj instanceof Boolean) {
                m11385a(str, (Boolean) obj);
            } else if (obj instanceof Enum) {
                m11395a(str, (Enum) obj);
            } else if (obj instanceof List) {
                m11398a(str, (List) obj);
            } else if (obj instanceof GraphQlCallInput) {
                m11393a(str, (GraphQlCallInput) obj);
            } else {
                throw new IllegalArgumentException("Value is not type that can be added. Actual value type: " + obj.getClass());
            }
        }
    }
}
