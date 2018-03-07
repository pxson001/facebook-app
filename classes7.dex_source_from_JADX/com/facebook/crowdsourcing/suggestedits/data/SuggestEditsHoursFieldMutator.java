package com.facebook.crowdsourcing.suggestedits.data;

import com.facebook.crowdsourcing.helper.HoursData;
import com.facebook.crowdsourcing.helper.HoursData.HoursForSingleDay;
import com.facebook.crowdsourcing.helper.HoursData.HoursInterval;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.SuggestEditsField;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedFieldModel.UserValuesModel.EdgesModel.NodeModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedHoursModel.FriModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedHoursModel.MonModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedHoursModel.SatModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedHoursModel.SunModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedHoursModel.ThuModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedHoursModel.TueModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedHoursModel.WedModel;
import com.facebook.graphql.enums.GraphQLSuggestEditsFieldOptionType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: co64 */
public class SuggestEditsHoursFieldMutator {
    private static final Map<Integer, GraphQLSuggestEditsFieldOptionType> f17675a = new Builder().b(Integer.valueOf(0), GraphQLSuggestEditsFieldOptionType.HAS_VALUE).b(Integer.valueOf(1), GraphQLSuggestEditsFieldOptionType.ALWAYS_OPEN).b(Integer.valueOf(2), GraphQLSuggestEditsFieldOptionType.DOESNT_HAVE_VALUE).b(Integer.valueOf(3), GraphQLSuggestEditsFieldOptionType.PERMANENTLY_CLOSED).b();

    public static SuggestEditsField m21516a(SuggestEditsField suggestEditsField, int i, @Nullable HoursData hoursData) {
        if (f17675a.containsKey(Integer.valueOf(i))) {
            if (hoursData != null) {
                suggestEditsField = m21517a(suggestEditsField, hoursData);
            }
            return suggestEditsField.ew_().equals(Boolean.valueOf(f17675a.containsKey(Integer.valueOf(i)))) ? suggestEditsField : SuggestEditsFieldMutator.m21495a(suggestEditsField, (GraphQLSuggestEditsFieldOptionType) f17675a.get(Integer.valueOf(i)));
        } else {
            throw new IllegalArgumentException("Trying to set invalid selected option for suggest edits field");
        }
    }

    private static SuggestEditsField m21517a(SuggestEditsField suggestEditsField, HoursData hoursData) {
        int i;
        int i2 = 0;
        ImmutableList.Builder builder = ImmutableList.builder();
        HoursForSingleDay a = hoursData.m21322a(1);
        if (a.m21321a()) {
            for (i = 0; i < a.f17418a.size(); i++) {
                builder.c(new SunModel.Builder().m2640b(((HoursInterval) a.f17418a.get(i)).f17420a).m2638a(((HoursInterval) a.f17418a.get(i)).f17421b).m2639a());
            }
        }
        ImmutableList.Builder builder2 = ImmutableList.builder();
        HoursForSingleDay a2 = hoursData.m21322a(2);
        if (a2.m21321a()) {
            for (i = 0; i < a2.f17418a.size(); i++) {
                builder2.c(new MonModel.Builder().m2617b(((HoursInterval) a2.f17418a.get(i)).f17420a).m2615a(((HoursInterval) a2.f17418a.get(i)).f17421b).m2616a());
            }
        }
        ImmutableList.Builder builder3 = ImmutableList.builder();
        HoursForSingleDay a3 = hoursData.m21322a(3);
        if (a3.m21321a()) {
            for (i = 0; i < a3.f17418a.size(); i++) {
                builder3.c(new TueModel.Builder().m2662b(((HoursInterval) a3.f17418a.get(i)).f17420a).m2660a(((HoursInterval) a3.f17418a.get(i)).f17421b).m2661a());
            }
        }
        ImmutableList.Builder builder4 = ImmutableList.builder();
        HoursForSingleDay a4 = hoursData.m21322a(4);
        if (a4.m21321a()) {
            for (i = 0; i < a4.f17418a.size(); i++) {
                builder4.c(new WedModel.Builder().m2673b(((HoursInterval) a4.f17418a.get(i)).f17420a).m2671a(((HoursInterval) a4.f17418a.get(i)).f17421b).m2672a());
            }
        }
        ImmutableList.Builder builder5 = ImmutableList.builder();
        HoursForSingleDay a5 = hoursData.m21322a(5);
        if (a5.m21321a()) {
            for (i = 0; i < a5.f17418a.size(); i++) {
                builder5.c(new ThuModel.Builder().m2651b(((HoursInterval) a5.f17418a.get(i)).f17420a).m2649a(((HoursInterval) a5.f17418a.get(i)).f17421b).m2650a());
            }
        }
        ImmutableList.Builder builder6 = ImmutableList.builder();
        HoursForSingleDay a6 = hoursData.m21322a(6);
        if (a6.m21321a()) {
            for (i = 0; i < a6.f17418a.size(); i++) {
                builder6.c(new FriModel.Builder().m2606b(((HoursInterval) a6.f17418a.get(i)).f17420a).m2604a(((HoursInterval) a6.f17418a.get(i)).f17421b).m2605a());
            }
        }
        ImmutableList.Builder builder7 = ImmutableList.builder();
        a6 = hoursData.m21322a(7);
        if (a6.m21321a()) {
            while (i2 < a6.f17418a.size()) {
                builder7.c(new SatModel.Builder().m2628b(((HoursInterval) a6.f17418a.get(i2)).f17420a).m2626a(((HoursInterval) a6.f17418a.get(i2)).f17421b).m2627a());
                i2++;
            }
        }
        NodeModel.Builder builder8 = new NodeModel.Builder();
        builder8.f2413j = builder.b();
        builder8 = builder8;
        builder8.f2408e = builder2.b();
        builder8 = builder8;
        builder8.f2416m = builder3.b();
        builder8 = builder8;
        builder8.f2417n = builder4.b();
        builder8 = builder8;
        builder8.f2415l = builder5.b();
        builder8 = builder8;
        builder8.f2407d = builder6.b();
        builder8 = builder8;
        builder8.f2411h = builder7.b();
        return SuggestEditsFieldMutator.m21493a(suggestEditsField, builder8.m2563a());
    }
}
