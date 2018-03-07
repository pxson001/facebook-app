package com.facebook.photos.data.method;

import com.facebook.common.util.JSONUtil;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLPrivacyScope;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.GraphQLTextWithEntities.Builder;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

/* compiled from: image[%d][%s] */
public class CreatePhotoAlbumMethod implements ApiMethod<CreatePhotoAlbumParams, GraphQLAlbum> {
    public static CreatePhotoAlbumMethod m20279a(InjectorLike injectorLike) {
        return new CreatePhotoAlbumMethod();
    }

    public final ApiRequest m20280a(Object obj) {
        CreatePhotoAlbumParams createPhotoAlbumParams = (CreatePhotoAlbumParams) obj;
        List a = Lists.a();
        JSONObject jSONObject = new JSONObject();
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("name", createPhotoAlbumParams.f12896a));
        if (createPhotoAlbumParams.f12898c != null) {
            a.add(new BasicNameValuePair("place", createPhotoAlbumParams.f12898c));
        } else if (createPhotoAlbumParams.f12897b != null) {
            a.add(new BasicNameValuePair("location", createPhotoAlbumParams.f12897b));
        }
        if (createPhotoAlbumParams.f12899d != null) {
            a.add(new BasicNameValuePair("description", createPhotoAlbumParams.f12899d));
        }
        if (createPhotoAlbumParams.f12901f != null) {
            a.add(new BasicNameValuePair("privacy", createPhotoAlbumParams.f12901f));
        } else if (createPhotoAlbumParams.f12900e != null) {
            a.add(new BasicNameValuePair("privacy", jSONObject.put("value", createPhotoAlbumParams.f12900e).toString()));
        }
        if (createPhotoAlbumParams.f12902g != null) {
            a.add(new BasicNameValuePair("id", createPhotoAlbumParams.f12902g));
        }
        return new ApiRequest("createPhotoAlbum", "POST", "method/photos.createAlbum", a, ApiResponseType.JSON);
    }

    public final Object m20281a(Object obj, ApiResponse apiResponse) {
        JsonNode c = apiResponse.c();
        Builder builder = new Builder();
        builder.i = JSONUtil.b(c.b("name"));
        GraphQLTextWithEntities a = builder.a();
        String b = JSONUtil.b(c.b("visible"));
        GraphQLPrivacyScope.Builder builder2 = new GraphQLPrivacyScope.Builder();
        builder2.i = b;
        builder2 = builder2;
        GraphQLImage.Builder builder3 = new GraphQLImage.Builder();
        builder3.e = b;
        builder2.h = builder3.a();
        GraphQLPrivacyScope a2 = builder2.a();
        String b2 = JSONUtil.b(c.b("media_owner_object_id"));
        GraphQLProfile.Builder builder4 = new GraphQLProfile.Builder();
        builder4.G = b2;
        GraphQLProfile a3 = builder4.a();
        GraphQLAlbum.Builder builder5 = new GraphQLAlbum.Builder();
        builder5.y = a2;
        GraphQLAlbum.Builder builder6 = builder5;
        builder6.z = a;
        GraphQLAlbum.Builder builder7 = builder6;
        builder7.s = a3;
        builder7 = builder7;
        builder7.o = JSONUtil.b(c.b("object_id"));
        return builder7.a();
    }
}
