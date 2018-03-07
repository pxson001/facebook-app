package com.facebook.tagging.protocol;

import com.facebook.common.util.StringUtil;
import com.facebook.fql.FqlHelper;
import com.facebook.fql.FqlHelper.BasicCondition;
import com.facebook.fql.FqlHelper.Condition;
import com.facebook.fql.FqlHelper.Field;
import com.facebook.fql.FqlHelper.OrCondition;
import com.facebook.fql.FqlHelper.QueryWithWhere;
import com.facebook.fql.FqlHelper.Table;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.ipc.model.FacebookProfile;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: deltaPagesManagerEvent */
public class FetchGroupMembersMethod implements ApiMethod<FetchGroupMembersParams, ArrayList<FacebookProfile>> {
    public static final Field f17555a = new Field("id");
    public static final Field f17556b = new Field("first_name");
    public static final Field f17557c = new Field("gid");
    public static final Field f17558d = new Field("last_name");
    public static final Field f17559e = new Field("name");
    public static final Field f17560f = new Field("pic_square");
    public static final Field f17561g = new Field("type");
    public static final Field f17562h = new Field("uid");

    public final ApiRequest m25561a(Object obj) {
        FetchGroupMembersParams fetchGroupMembersParams = (FetchGroupMembersParams) obj;
        List a = Lists.a();
        String str = "query";
        Condition a2 = f17562h.a(FqlHelper.a().a(new Field[]{f17562h}).a(Table.GROUP_MEMBER).a(f17557c.a(fetchGroupMembersParams.f17566a)));
        if (!StringUtil.a(fetchGroupMembersParams.f17567b)) {
            a2 = ((BasicCondition) a2).a(new OrCondition(f17556b.b(fetchGroupMembersParams.f17567b), f17558d.b(fetchGroupMembersParams.f17567b)));
        }
        QueryWithWhere a3 = FqlHelper.a().a(new Field[]{f17562h}).a(Table.USER).a(a2);
        a.add(new BasicNameValuePair(str, FqlHelper.a().a(new Field[]{f17555a, f17559e, f17560f, f17561g}).a(Table.PROFILE).a(f17555a.a(a3)).a(fetchGroupMembersParams.f17568c).toString()));
        a.add(new BasicNameValuePair("format", "JSON"));
        return new ApiRequest("groupMembers", "GET", "method/fql.query", a, ApiResponseType.JSONPARSER);
    }

    public final Object m25562a(Object obj, ApiResponse apiResponse) {
        JsonParser d = apiResponse.d();
        d.c();
        if (d.g() == JsonToken.START_ARRAY) {
            d.c();
        }
        return Lists.a(d.b(FacebookProfile.class));
    }
}
