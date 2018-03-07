package com.facebook.pages.adminedpages.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.time.Clock;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchGraphQL.AdminedPagesPrefetchQueryString;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchGraphQLInterfaces.AdminedPagesPrefetchQuery.AdminedPages;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.base.Optional;
import javax.inject.Inject;

/* compiled from: push_reg_initial_status */
public class AdminedPagesPrefetchMethod extends AbstractPersistedGraphQlApiMethod<Params, Result> {
    private final Clock f12848c;

    /* compiled from: push_reg_initial_status */
    public class Result extends BaseResult implements Parcelable {
        public static final Creator<Result> CREATOR = new C01891();
        private AdminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel f4009a;

        /* compiled from: push_reg_initial_status */
        final class C01891 implements Creator<Result> {
            C01891() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Result(parcel);
            }

            public final Object[] newArray(int i) {
                return new Result[i];
            }
        }

        public Result(DataFreshnessResult dataFreshnessResult, long j, AdminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel adminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel) {
            super(dataFreshnessResult, j);
            this.f4009a = adminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel;
        }

        public Result(Parcel parcel) {
            super(parcel);
            this.f4009a = (AdminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel) FlatBufferModelHelper.a(parcel);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            FlatBufferModelHelper.a(parcel, (Flattenable) this.f4009a);
        }

        public int describeContents() {
            return 0;
        }

        public final Optional<AdminedPages> m4511c() {
            return Optional.fromNullable(this.f4009a.m4504a());
        }
    }

    /* compiled from: push_reg_initial_status */
    public class Params implements Parcelable {
        public static final Creator<Params> CREATOR = new C05871();
        public final int f12428a;

        /* compiled from: push_reg_initial_status */
        final class C05871 implements Creator<Params> {
            C05871() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Params(parcel);
            }

            public final Object[] newArray(int i) {
                return new Params[i];
            }
        }

        public Params(int i) {
            this.f12428a = i;
        }

        public Params(Parcel parcel) {
            this.f12428a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f12428a);
        }

        public int describeContents() {
            return 0;
        }
    }

    public final GraphQlQueryString m13705f(Object obj) {
        return new AdminedPagesPrefetchQueryString().b(true).a("num_most_recently_used_pages", String.valueOf(((Params) obj).f12428a));
    }

    @Inject
    public AdminedPagesPrefetchMethod(GraphQLProtocolHelper graphQLProtocolHelper, Clock clock) {
        super(graphQLProtocolHelper);
        this.f12848c = clock;
    }

    public final Object m13703a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        AdminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel adminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel = (AdminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel) jsonParser.a(AdminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel.class);
        if (adminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel != null) {
            return new Result(DataFreshnessResult.FROM_SERVER, this.f12848c.a(), adminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel);
        }
        throw new RuntimeException("Invalid JSON result");
    }

    public final int m13704b(Object obj, ApiResponse apiResponse) {
        return 1;
    }
}
