package com.facebook.pages.browser.data.methods;

import android.content.res.Resources;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.pages.browser.data.graphql.RecommendedPages.AllSectionsRecommendedPagesString;
import com.facebook.pages.browser.data.graphql.RecommendedPagesModels.AllSectionsRecommendedPagesModel;
import com.fasterxml.jackson.core.JsonParser;
import javax.inject.Inject;

/* compiled from: strokeDash */
public class FetchInitialRecommendedPages extends AbstractPersistedGraphQlApiMethod<Void, AllSectionsRecommendedPagesModel> {
    private final Resources f1281c;

    @Inject
    public FetchInitialRecommendedPages(Resources resources, GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
        this.f1281c = resources;
    }

    public final GraphQlQueryString m1927f(Object obj) {
        return new AllSectionsRecommendedPagesString().a("num_recommended_pages_in_carousel", "10").a("profile_pic_image_size", String.valueOf(this.f1281c.getDimensionPixelSize(2131434411)));
    }

    public final Object m1925a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        AllSectionsRecommendedPagesModel allSectionsRecommendedPagesModel = (AllSectionsRecommendedPagesModel) jsonParser.a(AllSectionsRecommendedPagesModel.class);
        if (allSectionsRecommendedPagesModel != null) {
            return allSectionsRecommendedPagesModel;
        }
        throw new RuntimeException("Invalid JSON result");
    }

    public final int m1926b(Object obj, ApiResponse apiResponse) {
        return 1;
    }
}
