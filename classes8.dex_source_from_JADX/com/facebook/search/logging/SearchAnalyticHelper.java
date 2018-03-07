package com.facebook.search.logging;

import com.facebook.search.model.EntityTypeaheadUnit;
import com.facebook.search.model.TypeaheadUnit;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Locale;

/* compiled from: There are no eligible promotions associated with this trigger. */
public abstract class SearchAnalyticHelper {
    abstract void mo1203a(ObjectNode objectNode, TypeaheadUnit typeaheadUnit);

    protected final ArrayNode m25446a(List<? extends TypeaheadUnit> list) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        if (list == null) {
            return arrayNode;
        }
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            TypeaheadUnit typeaheadUnit = (TypeaheadUnit) list.get(i2);
            if (typeaheadUnit.l()) {
                ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
                objectNode.a("index_in_group", i2 - i);
                objectNode.a("is_scoped", typeaheadUnit.y());
                mo1203a(objectNode, typeaheadUnit);
                arrayNode.a(objectNode);
            } else {
                i++;
            }
        }
        return arrayNode;
    }

    protected static int m25444a(TypeaheadUnit typeaheadUnit, ImmutableList<? extends TypeaheadUnit> immutableList) {
        if (immutableList == null) {
            return -1;
        }
        Preconditions.checkArgument(typeaheadUnit.l(), "We should not look for the position of a non-result row");
        int i = 0;
        for (int i2 = 0; i2 < immutableList.size(); i2++) {
            TypeaheadUnit typeaheadUnit2 = (TypeaheadUnit) immutableList.get(i2);
            if (!typeaheadUnit2.l()) {
                i++;
            }
            if (typeaheadUnit2 == typeaheadUnit) {
                return i2 - i;
            }
        }
        return -1;
    }

    protected static void m25445a(ObjectNode objectNode, EntityTypeaheadUnit entityTypeaheadUnit) {
        objectNode.a("connected_state", entityTypeaheadUnit.f22053i);
        objectNode.a("semantic", entityTypeaheadUnit.f22045a);
        objectNode.a("text", entityTypeaheadUnit.f22046b);
        objectNode.a("result_style_list", entityTypeaheadUnit.f22047c.e());
        objectNode.a("type", entityTypeaheadUnit.f22047c.e().toLowerCase(Locale.getDefault()));
    }
}
