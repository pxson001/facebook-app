package com.facebook.crowdsourcing.suggestedits.data;

import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.SuggestEditsField;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedAddressModel.CityModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedAddressModel.CityModel.LocationModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedCategoryModel.CategoryModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedFieldModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedFieldModel.UserValuesModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedFieldModel.UserValuesModel.EdgesModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedFieldModel.UserValuesModel.EdgesModel.NodeModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedPhotoModel.PhotoModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedPhotoModel.PhotoModel.ImageModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.SuggestEditsFieldModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.SuggestEditsFieldModel.Builder;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.SuggestEditsHeaderModel;
import com.facebook.crowdsourcing.suggestedits.helper.ExtractValuesHelper;
import com.facebook.graphql.enums.GraphQLSuggestEditsFieldOptionType;
import com.facebook.ipc.model.PageTopic;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: column */
public class SuggestEditsFieldMutator {
    public static SuggestEditsField m21495a(SuggestEditsField suggestEditsField, GraphQLSuggestEditsFieldOptionType graphQLSuggestEditsFieldOptionType) {
        Builder builder = new Builder();
        builder = Builder.m2724a(SuggestEditsFieldModel.m2741a(suggestEditsField));
        builder.f2489g = graphQLSuggestEditsFieldOptionType;
        return builder.m2725a();
    }

    public static SuggestEditsField m21496a(SuggestEditsField suggestEditsField, PageTopic pageTopic) {
        SuggestEditsFieldModel a = SuggestEditsFieldModel.m2741a(suggestEditsField);
        if (a == null) {
            return suggestEditsField;
        }
        ImmutableList a2 = a.m2750k().m2602j().m2595a();
        String l = Long.toString(pageTopic.id);
        int size = a2.size();
        for (int i = 0; i < size; i++) {
            EdgesModel edgesModel = (EdgesModel) a2.get(i);
            if (edgesModel.m2590j() != null && edgesModel.m2590j().m2581q() != null && edgesModel.m2590j().m2581q().m2547a() != null && edgesModel.m2590j().m2581q().m2547a().equals(l)) {
                return suggestEditsField;
            }
        }
        CategoryModel.Builder builder = new CategoryModel.Builder();
        builder.f2395a = l;
        builder = builder;
        builder.f2396b = pageTopic.displayName;
        CategoryModel a3 = builder.m2541a();
        NodeModel.Builder builder2 = new NodeModel.Builder();
        builder2.f2405b = a3;
        NodeModel a4 = builder2.m2563a();
        EdgesModel.Builder builder3 = new EdgesModel.Builder();
        builder3.f2403a = a4;
        return m21494a(suggestEditsField, builder3.m2560a());
    }

    public static SuggestEditsField m21500a(String str, SuggestEditsField suggestEditsField) {
        if (SuggestEditsFieldModel.m2741a(suggestEditsField) == null) {
            return suggestEditsField;
        }
        NodeModel.Builder builder = new NodeModel.Builder();
        builder.f2414k = str;
        NodeModel a = builder.m2563a();
        EdgesModel.Builder builder2 = new EdgesModel.Builder();
        builder2.f2403a = a;
        return m21494a(suggestEditsField, builder2.m2560a());
    }

    public static SuggestEditsField m21492a(SuggestEditsField suggestEditsField, int i, EdgesModel edgesModel) {
        if (ExtractValuesHelper.m21537e(suggestEditsField) == null) {
            return suggestEditsField;
        }
        SuggestEditsFieldModel a = SuggestEditsFieldModel.m2741a(suggestEditsField);
        ImmutableList a2 = a.m2750k().m2602j().m2595a();
        EdgesModel a3 = EdgesModel.m2586a(edgesModel);
        ImmutableList.Builder builder = new ImmutableList.Builder();
        builder.b(a2.subList(0, i));
        builder.c(a3);
        builder.b(a2.subList(i, a2.size()));
        return m21503a(a, builder.b());
    }

    public static SuggestEditsField m21491a(SuggestEditsField suggestEditsField, int i) {
        UserValuesModel e = ExtractValuesHelper.m21537e(suggestEditsField);
        if (e == null || e.m2595a().size() <= i) {
            return suggestEditsField;
        }
        SuggestEditsFieldModel a = SuggestEditsFieldModel.m2741a(suggestEditsField);
        ImmutableList a2 = a.m2750k().m2602j().m2595a();
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (int i2 = 0; i2 < a2.size(); i2++) {
            if (i2 != i) {
                builder.c(a2.get(i2));
            }
        }
        return m21503a(a, builder.b());
    }

    public static SuggestEditsField m21498a(SuggestEditsField suggestEditsField, ImmutableList<String> immutableList) {
        SuggestEditsFieldModel a = SuggestEditsFieldModel.m2741a(suggestEditsField);
        if (a == null) {
            return suggestEditsField;
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) immutableList.get(i);
            NodeModel.Builder builder2 = new NodeModel.Builder();
            builder2.f2414k = str;
            NodeModel a2 = builder2.m2563a();
            EdgesModel.Builder builder3 = new EdgesModel.Builder();
            builder3.f2403a = a2;
            builder.c(builder3.m2560a());
        }
        return m21503a(a, builder.b());
    }

    public static SuggestEditsField m21497a(SuggestEditsField suggestEditsField, @Nullable CheckinPlaceModel checkinPlaceModel) {
        NodeModel a = NodeModel.m2566a(ExtractValuesHelper.m21538f(suggestEditsField));
        if (a == null || checkinPlaceModel == null) {
            return suggestEditsField;
        }
        LocationModel.Builder builder = new LocationModel.Builder();
        if (checkinPlaceModel.cg_() != null) {
            builder.f2385a = checkinPlaceModel.cg_().a();
            builder.f2386b = checkinPlaceModel.cg_().b();
        }
        CityModel.Builder builder2 = new CityModel.Builder();
        builder2.f2382a = checkinPlaceModel.cf_();
        builder2 = builder2;
        builder2.f2384c = checkinPlaceModel.j();
        builder2 = builder2;
        builder2.f2383b = builder.m2514a();
        CityModel a2 = builder2.m2512a();
        NodeModel.Builder builder3 = new NodeModel.Builder();
        NodeModel.Builder a3 = NodeModel.Builder.m2562a(a);
        a3.f2406c = a2;
        return m21493a(suggestEditsField, a3.m2563a());
    }

    public static SuggestEditsField m21499a(SuggestEditsField suggestEditsField, String str, String str2) {
        NodeModel a = NodeModel.m2566a(ExtractValuesHelper.m21538f(suggestEditsField));
        if (a == null) {
            return suggestEditsField;
        }
        NodeModel.Builder builder = new NodeModel.Builder();
        NodeModel.Builder a2 = NodeModel.Builder.m2562a(a);
        a2.f2412i = str;
        a2 = a2;
        a2.f2418o = str2;
        return m21493a(suggestEditsField, a2.m2563a());
    }

    public static SuggestEditsHeaderModel m21504a(SuggestEditsHeaderModel suggestEditsHeaderModel, String str) {
        SuggestEditsHeaderModel a = SuggestEditsHeaderModel.m2756a(suggestEditsHeaderModel);
        if (a == null || a.m2765j() == null) {
            return suggestEditsHeaderModel;
        }
        NodeModel a2 = NodeModel.m2566a(ExtractValuesHelper.m21529a(suggestEditsHeaderModel.m2758a()));
        if (a2 == null) {
            a2 = new NodeModel.Builder().m2563a();
        }
        a2 = m21501a(a2, str);
        EdgesModel.Builder builder = new EdgesModel.Builder();
        builder.f2403a = a2;
        CrowdsourcedFieldModel a3 = m21502a(a.m2765j(), ImmutableList.of(builder.m2560a()));
        SuggestEditsHeaderModel.Builder builder2 = new SuggestEditsHeaderModel.Builder();
        SuggestEditsHeaderModel.Builder a4 = SuggestEditsHeaderModel.Builder.m2752a(a);
        a4.f2505a = a3;
        return a4.m2753a();
    }

    public static SuggestEditsField m21493a(SuggestEditsField suggestEditsField, NodeModel nodeModel) {
        SuggestEditsFieldModel a = SuggestEditsFieldModel.m2741a(suggestEditsField);
        EdgesModel.Builder builder = new EdgesModel.Builder();
        builder.f2403a = nodeModel;
        return m21503a(a, ImmutableList.of(builder.m2560a()));
    }

    private static SuggestEditsField m21494a(SuggestEditsField suggestEditsField, EdgesModel edgesModel) {
        return (suggestEditsField.mo108c() == null || suggestEditsField.mo108c().m2601b() == null) ? suggestEditsField : m21492a(suggestEditsField, suggestEditsField.mo108c().m2601b().m2595a().size(), edgesModel);
    }

    public static SuggestEditsHeaderModel m21505b(SuggestEditsHeaderModel suggestEditsHeaderModel, String str) {
        CrowdsourcedFieldModel a = CrowdsourcedFieldModel.m2596a(suggestEditsHeaderModel.m2763b());
        SuggestEditsHeaderModel a2 = SuggestEditsHeaderModel.m2756a(suggestEditsHeaderModel);
        ImageModel.Builder builder = new ImageModel.Builder();
        builder.f2479a = str;
        ImageModel a3 = builder.m2707a();
        PhotoModel.Builder builder2 = new PhotoModel.Builder();
        builder2.f2478a = a3;
        PhotoModel a4 = builder2.m2705a();
        NodeModel.Builder builder3 = new NodeModel.Builder();
        builder3.f2410g = a4;
        NodeModel a5 = builder3.m2563a();
        EdgesModel.Builder builder4 = new EdgesModel.Builder();
        builder4.f2403a = a5;
        EdgesModel a6 = builder4.m2560a();
        UserValuesModel j = a.m2602j();
        UserValuesModel.Builder builder5 = new UserValuesModel.Builder();
        builder5.f2402a = j.m2595a();
        UserValuesModel.Builder builder6 = builder5;
        builder6.f2402a = ImmutableList.of(a6);
        UserValuesModel a7 = builder6.m2558a();
        CrowdsourcedFieldModel.Builder a8 = CrowdsourcedFieldModel.Builder.m2554a(a);
        a8.f2401b = a7;
        a = a8.m2555a();
        SuggestEditsHeaderModel.Builder a9 = SuggestEditsHeaderModel.Builder.m2752a(a2);
        a9.f2506b = a;
        return a9.m2753a();
    }

    private static SuggestEditsFieldModel m21503a(SuggestEditsFieldModel suggestEditsFieldModel, ImmutableList<EdgesModel> immutableList) {
        CrowdsourcedFieldModel a = m21502a(suggestEditsFieldModel.m2750k(), (ImmutableList) immutableList);
        Builder builder = new Builder();
        builder = Builder.m2724a(suggestEditsFieldModel);
        builder.f2485c = a;
        return builder.m2725a();
    }

    private static CrowdsourcedFieldModel m21502a(CrowdsourcedFieldModel crowdsourcedFieldModel, ImmutableList<EdgesModel> immutableList) {
        UserValuesModel.Builder builder = new UserValuesModel.Builder();
        builder.f2402a = immutableList;
        UserValuesModel a = builder.m2558a();
        CrowdsourcedFieldModel.Builder builder2 = new CrowdsourcedFieldModel.Builder();
        builder2 = CrowdsourcedFieldModel.Builder.m2554a(crowdsourcedFieldModel);
        builder2.f2401b = a;
        return builder2.m2555a();
    }

    public static NodeModel m21501a(NodeModel nodeModel, String str) {
        NodeModel.Builder builder = new NodeModel.Builder();
        builder = NodeModel.Builder.m2562a(nodeModel);
        builder.f2414k = str;
        return builder.m2563a();
    }
}
