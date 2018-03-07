package com.facebook.pages.browser.data.methods;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.pages.browser.data.graphql.RecommendedPages.RecommendedPagesInCategoryString;
import com.facebook.pages.browser.data.graphql.RecommendedPagesModels.RecommendedPagesInCategoryModel;
import com.fasterxml.jackson.core.JsonParser;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: strokeCap  */
public class FetchRecommendedPagesInCategory extends AbstractPersistedGraphQlApiMethod<Params, RecommendedPagesInCategoryModel> {
    private final Resources f1283c;

    /* compiled from: strokeCap  */
    public class Params implements Parcelable {
        public static final Creator<Params> CREATOR = new C01711();
        public final String f1282a;

        /* compiled from: strokeCap  */
        final class C01711 implements Creator<Params> {
            C01711() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Params(parcel);
            }

            public final Object[] newArray(int i) {
                return new Params[i];
            }
        }

        public Params(String str) {
            this.f1282a = str;
        }

        public Params(Parcel parcel) {
            this.f1282a = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f1282a);
        }

        public int describeContents() {
            return 0;
        }
    }

    public final GraphQlQueryString m1930f(@Nullable Object obj) {
        Params params = (Params) obj;
        return new RecommendedPagesInCategoryString().a("num_recommended_pages_in_list", "50").a("profile_pic_image_size", String.valueOf(this.f1283c.getDimensionPixelSize(2131434411))).a("category", params.f1282a);
    }

    @Inject
    public FetchRecommendedPagesInCategory(Resources resources, GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
        this.f1283c = resources;
    }

    public final Object m1928a(@Nullable Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        RecommendedPagesInCategoryModel recommendedPagesInCategoryModel = (RecommendedPagesInCategoryModel) jsonParser.a(RecommendedPagesInCategoryModel.class);
        if (recommendedPagesInCategoryModel != null) {
            return recommendedPagesInCategoryModel;
        }
        throw new RuntimeException("Invalid JSON result");
    }

    public final int m1929b(Object obj, ApiResponse apiResponse) {
        return 1;
    }
}
