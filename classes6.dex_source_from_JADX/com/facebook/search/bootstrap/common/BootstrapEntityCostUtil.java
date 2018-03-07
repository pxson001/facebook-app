package com.facebook.search.bootstrap.common;

import com.facebook.search.graphql.SearchEntityInterfaces.StructuredGrammarCost;
import com.facebook.search.graphql.SearchEntityModels.StructuredGrammarCostModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

/* compiled from: extra_has_explicit_place */
public class BootstrapEntityCostUtil {
    private static final ImmutableSet<String> f15578a = ImmutableSet.of("{user}", "{page}", "{group}", "{app}", "{topic}");

    public static double m23187a(ImmutableList<? extends StructuredGrammarCost> immutableList) {
        if (immutableList.isEmpty()) {
            return -1.0d;
        }
        double d = 1.0d;
        int size = immutableList.size();
        int i = 0;
        while (i < size) {
            double d2;
            StructuredGrammarCostModel structuredGrammarCostModel = (StructuredGrammarCostModel) immutableList.get(i);
            double a = structuredGrammarCostModel.m23522a();
            if (a >= d || !f15578a.contains(structuredGrammarCostModel.m23526b())) {
                d2 = d;
            } else {
                d2 = a;
            }
            i++;
            d = d2;
        }
        return d;
    }
}
