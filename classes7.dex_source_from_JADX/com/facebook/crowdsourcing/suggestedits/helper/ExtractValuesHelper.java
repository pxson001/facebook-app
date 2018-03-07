package com.facebook.crowdsourcing.suggestedits.helper;

import android.location.Location;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.CrowdsourcedField.UserValues.Edges;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.SuggestEditsField;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedAddressModel.CityModel.LocationModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedFieldModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedFieldModel.UserValuesModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedFieldModel.UserValuesModel.EdgesModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedFieldModel.UserValuesModel.EdgesModel.NodeModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.SuggestEditsFieldModel.OptionsModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.SuggestEditsHeaderModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.SuggestEditsOptionModel;
import com.facebook.graphql.enums.GraphQLSuggestEditsFieldOptionType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

/* compiled from: client_subscription_id */
public class ExtractValuesHelper {
    @Nullable
    public static String m21534c(SuggestEditsHeaderModel suggestEditsHeaderModel) {
        if (suggestEditsHeaderModel.m2758a() == null || suggestEditsHeaderModel.m2758a().m2601b() == null || suggestEditsHeaderModel.m2758a().m2601b().m2595a().isEmpty() || ((EdgesModel) suggestEditsHeaderModel.m2758a().m2601b().m2595a().get(0)).m2588a() == null) {
            return null;
        }
        return ((EdgesModel) suggestEditsHeaderModel.m2758a().m2601b().m2595a().get(0)).m2588a().m2576l();
    }

    @Nullable
    public static String m21536d(SuggestEditsHeaderModel suggestEditsHeaderModel) {
        if (suggestEditsHeaderModel.m2763b() == null || suggestEditsHeaderModel.m2763b().m2601b() == null || suggestEditsHeaderModel.m2763b().m2601b().m2595a().isEmpty() || ((EdgesModel) suggestEditsHeaderModel.m2763b().m2601b().m2595a().get(0)).m2588a() == null || ((EdgesModel) suggestEditsHeaderModel.m2763b().m2601b().m2595a().get(0)).m2588a().ev_() == null || ((EdgesModel) suggestEditsHeaderModel.m2763b().m2601b().m2595a().get(0)).m2588a().ev_().m2718a() == null) {
            return null;
        }
        return ((EdgesModel) suggestEditsHeaderModel.m2763b().m2601b().m2595a().get(0)).m2588a().ev_().m2718a().m2713a();
    }

    @Nullable
    public static String m21530a(SuggestEditsField suggestEditsField) {
        SuggestEditsOptionModel i = m21541i(suggestEditsField);
        if (i == null || i.m2835a() == null) {
            return null;
        }
        return i.m2835a().m2773a();
    }

    @Nullable
    public static String m21531a(SuggestEditsOptionModel suggestEditsOptionModel, boolean z) {
        if (z && suggestEditsOptionModel.m2839d() != null) {
            return suggestEditsOptionModel.m2839d().m2785a();
        }
        if (suggestEditsOptionModel.m2838c() != null) {
            return suggestEditsOptionModel.m2838c().m2779a();
        }
        return null;
    }

    public static String m21532b(SuggestEditsField suggestEditsField) {
        return m21543k(suggestEditsField) == GraphQLSuggestEditsFieldOptionType.DOESNT_HAVE_VALUE ? "<<not-applicable>>" : m21535d(suggestEditsField);
    }

    public static ImmutableList<String> m21533c(SuggestEditsField suggestEditsField) {
        return m21543k(suggestEditsField) == GraphQLSuggestEditsFieldOptionType.DOESNT_HAVE_VALUE ? ImmutableList.of("<<not-applicable>>") : m21542j(suggestEditsField);
    }

    @Nullable
    public static String m21535d(SuggestEditsField suggestEditsField) {
        NodeModel f = m21538f(suggestEditsField);
        return (f == null || "<<not-applicable>>".equals(f.m2576l())) ? null : f.m2576l();
    }

    @Nullable
    public static UserValuesModel m21537e(SuggestEditsField suggestEditsField) {
        if (suggestEditsField.mo108c() == null) {
            return null;
        }
        return suggestEditsField.mo108c().m2601b();
    }

    @Nullable
    public static NodeModel m21538f(SuggestEditsField suggestEditsField) {
        if (suggestEditsField.mo108c() == null) {
            return null;
        }
        return m21529a(suggestEditsField.mo108c());
    }

    @Nullable
    public static NodeModel m21529a(CrowdsourcedFieldModel crowdsourcedFieldModel) {
        UserValuesModel b = crowdsourcedFieldModel.m2601b();
        if (b == null || b.m2595a().isEmpty()) {
            return null;
        }
        return ((EdgesModel) b.m2595a().get(0)).m2588a();
    }

    public static ImmutableList<? extends Edges> m21539g(SuggestEditsField suggestEditsField) {
        if (suggestEditsField.mo108c() == null || suggestEditsField.mo108c().m2601b() == null || suggestEditsField.mo108c().m2601b().m2595a().isEmpty()) {
            return RegularImmutableList.a;
        }
        return suggestEditsField.mo108c().m2601b().m2595a();
    }

    @Nullable
    public static Location m21540h(SuggestEditsField suggestEditsField) {
        NodeModel f = m21538f(suggestEditsField);
        if (f == null || f.m2571c() == null || f.m2571c().m2532c() == null) {
            return null;
        }
        LocationModel c = f.m2571c().m2532c();
        Location location = new Location("");
        location.reset();
        location.setLatitude(c.m2518a());
        location.setLongitude(c.m2522b());
        return location;
    }

    @Nullable
    public static SuggestEditsOptionModel m21541i(SuggestEditsField suggestEditsField) {
        if (suggestEditsField.ew_() == null || suggestEditsField.ey_() == null || suggestEditsField.ey_().m2739a().isEmpty()) {
            return null;
        }
        ImmutableList a = suggestEditsField.ey_().m2739a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            OptionsModel.EdgesModel edgesModel = (OptionsModel.EdgesModel) a.get(i);
            if (edgesModel.m2733a() != null && edgesModel.m2733a().m2840g().equals(suggestEditsField.ew_())) {
                return edgesModel.m2733a();
            }
        }
        return null;
    }

    public static ImmutableList<String> m21542j(SuggestEditsField suggestEditsField) {
        Builder builder = ImmutableList.builder();
        ImmutableList g = m21539g(suggestEditsField);
        int size = g.size();
        for (int i = 0; i < size; i++) {
            EdgesModel edgesModel = (EdgesModel) g.get(i);
            if (!(edgesModel == null || edgesModel.m2588a() == null || edgesModel.m2588a().m2576l() == null)) {
                builder.c(edgesModel.m2588a().m2576l().equals("<<not-applicable>>") ? "" : edgesModel.m2588a().m2576l());
            }
        }
        return builder.b();
    }

    @Nullable
    public static GraphQLSuggestEditsFieldOptionType m21543k(SuggestEditsField suggestEditsField) {
        SuggestEditsOptionModel i = m21541i(suggestEditsField);
        if (i == null) {
            return null;
        }
        return i.m2840g();
    }
}
