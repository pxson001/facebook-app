package com.facebook.search.protocol;

import com.facebook.inject.InjectorLike;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQLInterfaces.FB4AGraphSearchUserResultDecoration;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQLModels.FB4AGraphSearchUserResultDecorationModel.LineageSnippetsModel;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/* compiled from: nearby_places_result_list_model */
public class SnippetsUtil {
    public static SnippetsUtil m8990a(InjectorLike injectorLike) {
        return new SnippetsUtil();
    }

    public final ImmutableList<String> m8991a(FB4AGraphSearchUserResultDecoration fB4AGraphSearchUserResultDecoration) {
        String str;
        String[] strArr = new String[2];
        String a = (fB4AGraphSearchUserResultDecoration.m8361c() == null || fB4AGraphSearchUserResultDecoration.m8361c().m8354a() == null) ? null : fB4AGraphSearchUserResultDecoration.m8361c().m8354a().m8349a();
        strArr[0] = a;
        if (fB4AGraphSearchUserResultDecoration.m8359a() == null || fB4AGraphSearchUserResultDecoration.m8359a().isEmpty() || ((LineageSnippetsModel) fB4AGraphSearchUserResultDecoration.m8359a().get(0)).m8331a() == null) {
            str = null;
        } else {
            str = ((LineageSnippetsModel) fB4AGraphSearchUserResultDecoration.m8359a().get(0)).m8331a().m8326a();
        }
        a = str;
        if (a == null) {
            if (fB4AGraphSearchUserResultDecoration.m8360b() == null || fB4AGraphSearchUserResultDecoration.m8360b().m8343a() == null) {
                str = null;
            } else {
                str = fB4AGraphSearchUserResultDecoration.m8360b().m8343a().m8338a();
            }
            a = str;
        }
        strArr[1] = a;
        return ImmutableList.copyOf(Iterables.c(Lists.a(strArr), Predicates.notNull()));
    }
}
