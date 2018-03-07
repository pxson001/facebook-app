package com.facebook.graphql.model;

import android.text.TextUtils;
import com.facebook.graphql.model.GraphQLImage.Builder;
import javax.annotation.Nullable;

/* compiled from: lead_gen_data */
public class GoodwillFeedUnitHelper {
    private GoodwillFeedUnitHelper() {
    }

    public static GraphQLImage m6336a(GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit, int i) {
        GraphQLGoodwillCampaign g = m6341g(graphQLGoodwillThrowbackPromotionFeedUnit);
        if (g == null || g.m7833k() == null) {
            return null;
        }
        GraphQLImage ae = g.m7833k().ae();
        if (ae == null) {
            ae = g.m7833k().ai();
        }
        if (ae == null) {
            ae = g.m7833k().af();
        }
        if (ae == null) {
            return null;
        }
        Builder a = Builder.a(ae);
        a.d = i;
        a = a;
        a.h = i;
        return a.a();
    }

    public static GraphQLImage m6335a(GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit) {
        GraphQLGoodwillCampaign g = m6341g(graphQLGoodwillThrowbackPromotionFeedUnit);
        if (g == null || g.m7833k() == null) {
            return null;
        }
        GraphQLImage ae = g.m7833k().ae();
        if (ae == null) {
            ae = g.m7833k().ai();
        }
        if (ae == null) {
            ae = g.m7833k().af();
        }
        if (ae != null) {
            return Builder.a(ae).a();
        }
        return null;
    }

    public static boolean m6338b(GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit) {
        return (m6337a(graphQLGoodwillThrowbackPromotionFeedUnit.I()) || m6337a(graphQLGoodwillThrowbackPromotionFeedUnit.u()) || (!m6339e(graphQLGoodwillThrowbackPromotionFeedUnit) && !m6340f(graphQLGoodwillThrowbackPromotionFeedUnit))) ? false : true;
    }

    public static boolean m6339e(GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit) {
        return (graphQLGoodwillThrowbackPromotionFeedUnit.E() == null || graphQLGoodwillThrowbackPromotionFeedUnit.E().m8083a() == null || graphQLGoodwillThrowbackPromotionFeedUnit.E().m8083a().isEmpty()) ? false : true;
    }

    public static boolean m6340f(@Nullable GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit) {
        return (graphQLGoodwillThrowbackPromotionFeedUnit == null || graphQLGoodwillThrowbackPromotionFeedUnit.v() == null || graphQLGoodwillThrowbackPromotionFeedUnit.v().m8074a() == null || graphQLGoodwillThrowbackPromotionFeedUnit.v().m8074a().isEmpty()) ? false : true;
    }

    public static GraphQLGoodwillCampaign m6341g(GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit) {
        if (m6340f(graphQLGoodwillThrowbackPromotionFeedUnit)) {
            return (GraphQLGoodwillCampaign) graphQLGoodwillThrowbackPromotionFeedUnit.v().m8074a().get(0);
        }
        return null;
    }

    private static boolean m6337a(GraphQLTextWithEntities graphQLTextWithEntities) {
        return graphQLTextWithEntities == null || TextUtils.isEmpty(graphQLTextWithEntities.a());
    }

    public static int m6342h(GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit) {
        if (graphQLGoodwillThrowbackPromotionFeedUnit.E() == null || graphQLGoodwillThrowbackPromotionFeedUnit.E().m8083a() == null) {
            return 0;
        }
        return graphQLGoodwillThrowbackPromotionFeedUnit.E().m8083a().size();
    }
}
