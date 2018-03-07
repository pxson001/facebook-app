package com.facebook.groups.create.protocol;

import com.facebook.graphql.enums.GraphQLGroupPurposeType;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import org.apache.http.HttpException;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: payments_select_new_payment_method_initiated */
public class CreateGroupMethod implements ApiMethod<CreateGroupParams, String> {
    public final ApiRequest m7107a(Object obj) {
        CreateGroupParams createGroupParams = (CreateGroupParams) obj;
        Builder builder = ImmutableList.builder();
        builder.c(new BasicNameValuePair("name", createGroupParams.f6800a)).c(new BasicNameValuePair("privacy", createGroupParams.f6801b));
        if (createGroupParams.f6802c != null) {
            builder.c(new BasicNameValuePair("description", createGroupParams.f6802c));
        }
        if (createGroupParams.f6803d != null) {
            builder.c(new BasicNameValuePair("group_icon_id", createGroupParams.f6803d));
        }
        if (createGroupParams.f6804e != null) {
            builder.c(new BasicNameValuePair("ref", createGroupParams.f6804e));
        }
        if (createGroupParams.f6805f != null) {
            builder.c(new BasicNameValuePair("suggestion_category", createGroupParams.f6805f));
        }
        if (createGroupParams.f6806g != null) {
            builder.c(new BasicNameValuePair("suggestion_identifier", createGroupParams.f6806g));
        }
        if (!(createGroupParams.f6807h == null || createGroupParams.f6807h.equals(GraphQLGroupPurposeType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE.toString()))) {
            builder.c(new BasicNameValuePair("group_type", createGroupParams.f6807h));
        }
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "create_group";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "/me/groups";
        newBuilder = newBuilder;
        newBuilder.g = builder.b();
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    public final Object m7108a(Object obj, ApiResponse apiResponse) {
        if (apiResponse.b == 200) {
            return apiResponse.c().b("id").B();
        }
        throw new HttpException("Group creation failed," + apiResponse.toString());
    }
}
