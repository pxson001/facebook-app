package com.facebook.auth.protocol;

import com.facebook.auth.protocol.GetLoggedInUserGraphQL.GetLoggedInUserQueryString;
import com.facebook.auth.protocol.LoggedInUserQueryFragmentModels$LoggedInUserQueryFragmentModel.AllPhonesModel;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.enums.GraphQLPhoneType;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels$DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.facebook.user.gender.Gender;
import com.facebook.user.model.PicSquare;
import com.facebook.user.model.PicSquareUrlWithSize;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserBuilder;
import com.facebook.user.model.UserEmailAddress;
import com.facebook.user.model.UserPhoneNumber;
import com.facebook.user.module.UserNameUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: strings/ */
public class GetLoggedInUserGraphQLMethod extends AbstractPersistedGraphQlApiMethod<Void, GetLoggedInUserGraphQLResult> {
    private final Clock f1643c;
    private final UserNameUtil f1644d;

    /* compiled from: strings/ */
    public final class C00921 implements Function<String, UserEmailAddress> {
        @Nullable
        public final Object apply(@Nullable Object obj) {
            return new UserEmailAddress((String) obj, 0);
        }
    }

    /* compiled from: strings/ */
    public final class C00932 implements Function<AllPhonesModel, UserPhoneNumber> {
        @Nullable
        public final Object apply(@Nullable Object obj) {
            AllPhonesModel allPhonesModel = (AllPhonesModel) obj;
            if (allPhonesModel == null || allPhonesModel.m2088j() == null) {
                return null;
            }
            return new UserPhoneNumber(allPhonesModel.m2088j().a(), allPhonesModel.m2088j().j(), allPhonesModel.m2088j().j(), GraphQLPhoneType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE.ordinal(), TriState.valueOf(allPhonesModel.m2087a()));
        }
    }

    /* compiled from: strings/ */
    public final class C00943 implements Predicate<UserPhoneNumber> {
        public final boolean apply(@Nullable Object obj) {
            return ((UserPhoneNumber) obj) != null;
        }
    }

    public static GetLoggedInUserGraphQLMethod m1872b(InjectorLike injectorLike) {
        return new GetLoggedInUserGraphQLMethod(GraphQLProtocolHelper.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), UserNameUtil.m10377a(injectorLike));
    }

    @Inject
    public GetLoggedInUserGraphQLMethod(GraphQLProtocolHelper graphQLProtocolHelper, Clock clock, UserNameUtil userNameUtil) {
        super(graphQLProtocolHelper);
        this.f1643c = clock;
        this.f1644d = userNameUtil;
    }

    public final GraphQlQueryString m1875f(Object obj) {
        return new GetLoggedInUserQueryString().a("square_profile_pic_size_small", Integer.valueOf(GraphQlQueryDefaults.b())).a("square_profile_pic_size_big", Integer.valueOf(GraphQlQueryDefaults.c())).a("square_profile_pic_size_huge", Integer.valueOf(GraphQlQueryDefaults.d()));
    }

    public final Object m1873a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        Gender gender;
        TriState triState;
        GetLoggedInUserGraphQLModels$GetLoggedInUserQueryModel getLoggedInUserGraphQLModels$GetLoggedInUserQueryModel = (GetLoggedInUserGraphQLModels$GetLoggedInUserQueryModel) jsonParser.a(GetLoggedInUserGraphQLModels$GetLoggedInUserQueryModel.class);
        UserBuilder userBuilder = new UserBuilder();
        userBuilder.g = UserNameUtil.m10376a(getLoggedInUserGraphQLModels$GetLoggedInUserQueryModel.m2023a().m2071w());
        userBuilder.l = getLoggedInUserGraphQLModels$GetLoggedInUserQueryModel.m2023a().m2072x();
        switch (getLoggedInUserGraphQLModels$GetLoggedInUserQueryModel.m2023a().m2060l()) {
            case FEMALE:
                gender = Gender.FEMALE;
                break;
            case MALE:
                gender = Gender.MALE;
                break;
            default:
                gender = Gender.UNKNOWN;
                break;
        }
        userBuilder.m = gender;
        userBuilder.a(Type.FACEBOOK, getLoggedInUserGraphQLModels$GetLoggedInUserQueryModel.m2023a().m2061m());
        userBuilder.c = Lists.a(getLoggedInUserGraphQLModels$GetLoggedInUserQueryModel.m2023a().m2059k(), new C00921());
        userBuilder.d = Lists.a(Iterables.c(Lists.a(getLoggedInUserGraphQLModels$GetLoggedInUserQueryModel.m2023a().m2058j(), new C00932()), new C00943()));
        userBuilder.p = m1871a(getLoggedInUserGraphQLModels$GetLoggedInUserQueryModel.m2023a());
        if (getLoggedInUserGraphQLModels$GetLoggedInUserQueryModel.m2023a().m2064p()) {
            triState = TriState.YES;
        } else {
            triState = TriState.NO;
        }
        userBuilder.u = triState;
        userBuilder.w = getLoggedInUserGraphQLModels$GetLoggedInUserQueryModel.m2023a().m2066r();
        userBuilder.L = getLoggedInUserGraphQLModels$GetLoggedInUserQueryModel.m2023a().m2065q();
        userBuilder.M = getLoggedInUserGraphQLModels$GetLoggedInUserQueryModel.m2023a().m2063o();
        userBuilder.N = TriState.valueOf(getLoggedInUserGraphQLModels$GetLoggedInUserQueryModel.m2023a().m2067s());
        userBuilder.v = getLoggedInUserGraphQLModels$GetLoggedInUserQueryModel.m2026j();
        userBuilder.R = getLoggedInUserGraphQLModels$GetLoggedInUserQueryModel.m2023a().m2062n();
        return new GetLoggedInUserGraphQLResult(DataFreshnessResult.FROM_SERVER, userBuilder.aa(), this.f1643c.a());
    }

    private static PicSquare m1871a(LoggedInUserQueryFragmentModels$LoggedInUserQueryFragmentModel loggedInUserQueryFragmentModels$LoggedInUserQueryFragmentModel) {
        PicSquareUrlWithSize picSquareUrlWithSize;
        PicSquareUrlWithSize picSquareUrlWithSize2;
        PicSquareUrlWithSize picSquareUrlWithSize3 = null;
        CommonGraphQLModels$DefaultImageFieldsModel v = loggedInUserQueryFragmentModels$LoggedInUserQueryFragmentModel.m2070v();
        if (v != null) {
            picSquareUrlWithSize = new PicSquareUrlWithSize(v.m2095c(), v.m2094b());
        } else {
            picSquareUrlWithSize = null;
        }
        CommonGraphQLModels$DefaultImageFieldsModel t = loggedInUserQueryFragmentModels$LoggedInUserQueryFragmentModel.m2068t();
        if (t != null) {
            picSquareUrlWithSize2 = new PicSquareUrlWithSize(t.m2095c(), t.m2094b());
        } else {
            picSquareUrlWithSize2 = null;
        }
        t = loggedInUserQueryFragmentModels$LoggedInUserQueryFragmentModel.m2069u();
        if (t != null) {
            picSquareUrlWithSize3 = new PicSquareUrlWithSize(t.m2095c(), t.m2094b());
        }
        return new PicSquare(picSquareUrlWithSize, picSquareUrlWithSize2, picSquareUrlWithSize3);
    }

    public final int m1874b(Object obj, ApiResponse apiResponse) {
        return 1;
    }
}
