package com.facebook.pages.common.protocol.methods;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.common.protocol.graphql.FetchPageActivityGraphQL;
import com.facebook.pages.common.protocol.graphql.FetchPageActivityGraphQLModels.FetchPageActivityQueryModel;
import com.fasterxml.jackson.core.JsonParser;
import javax.inject.Inject;

/* compiled from: setOnRequestCloseListener must be called by the manager */
public class FetchPageActivityMethod extends AbstractPersistedGraphQlApiMethod<PageIdParam, Result> {

    /* compiled from: setOnRequestCloseListener must be called by the manager */
    public class Result extends BaseResult implements Parcelable {
        public static final Creator<Result> CREATOR = new C02431();
        private FetchPageActivityQueryModel f1837a;

        /* compiled from: setOnRequestCloseListener must be called by the manager */
        final class C02431 implements Creator<Result> {
            C02431() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Result(parcel);
            }

            public final Object[] newArray(int i) {
                return new Result[i];
            }
        }

        public Result(DataFreshnessResult dataFreshnessResult, long j, FetchPageActivityQueryModel fetchPageActivityQueryModel) {
            super(dataFreshnessResult, j);
            this.f1837a = fetchPageActivityQueryModel;
        }

        public Result(Parcel parcel) {
            super(parcel);
            this.f1837a = (FetchPageActivityQueryModel) FlatBufferModelHelper.a(parcel);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            FlatBufferModelHelper.a(parcel, (Flattenable) this.f1837a);
        }

        public int describeContents() {
            return 0;
        }
    }

    private static FetchPageActivityMethod m2884b(InjectorLike injectorLike) {
        return new FetchPageActivityMethod(GraphQLProtocolHelper.a(injectorLike));
    }

    public final GraphQlQueryString m2887f(Object obj) {
        return FetchPageActivityGraphQL.m2688a().a("page_id", ((PageIdParam) obj).f1838a);
    }

    @Inject
    public FetchPageActivityMethod(GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
    }

    public final Object m2885a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        FetchPageActivityQueryModel fetchPageActivityQueryModel = (FetchPageActivityQueryModel) jsonParser.a(FetchPageActivityQueryModel.class);
        if (fetchPageActivityQueryModel != null) {
            return new Result(DataFreshnessResult.FROM_SERVER, System.currentTimeMillis(), fetchPageActivityQueryModel);
        }
        throw new RuntimeException("Invalid JSON result");
    }

    public final int m2886b(Object obj, ApiResponse apiResponse) {
        return 1;
    }
}
