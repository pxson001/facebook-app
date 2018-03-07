package com.facebook.composer.lifeevent.protocol;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Locale;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: place_creation */
public class PublishLifeEventMethod implements ApiMethod<ComposerLifeEventParam, String> {
    public static PublishLifeEventMethod m11431a(InjectorLike injectorLike) {
        return new PublishLifeEventMethod();
    }

    public final ApiRequest m11434a(Object obj) {
        String str;
        ComposerLifeEventParam composerLifeEventParam = (ComposerLifeEventParam) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("icon", composerLifeEventParam.iconId));
        a.add(new BasicNameValuePair("title", composerLifeEventParam.description));
        a.add(new BasicNameValuePair("surface", composerLifeEventParam.surface));
        a.add(new BasicNameValuePair("privacy", composerLifeEventParam.privacy));
        a.add(new BasicNameValuePair("life_event_type", composerLifeEventParam.lifeEventType.toString().toLowerCase(Locale.US)));
        if (composerLifeEventParam.story != null) {
            a.add(new BasicNameValuePair("description", composerLifeEventParam.story));
        }
        if (composerLifeEventParam.startDate != null) {
            a.add(new BasicNameValuePair("start_date", composerLifeEventParam.startDate));
        }
        if (composerLifeEventParam.place != null) {
            a.add(new BasicNameValuePair("place", composerLifeEventParam.place));
        }
        if (!(composerLifeEventParam.tags == null || composerLifeEventParam.tags.isEmpty())) {
            a.add(new BasicNameValuePair("tags", m11432a(composerLifeEventParam.tags)));
        }
        if (!(composerLifeEventParam.photoFbids == null || composerLifeEventParam.photoFbids.isEmpty())) {
            a.add(new BasicNameValuePair("photos", m11432a(composerLifeEventParam.photoFbids)));
        }
        StringBuilder stringBuilder = new StringBuilder("{");
        if (composerLifeEventParam.shouldUpdateRelationshipStatus) {
            m11433a(stringBuilder, "update_relationship_status", composerLifeEventParam.shouldUpdateRelationshipStatus ? "1" : "0");
        }
        if (composerLifeEventParam.endDate != null) {
            StringBuilder append = stringBuilder.append('\"').append("end_date").append("\":").append(composerLifeEventParam.endDate).append(',');
        }
        if (composerLifeEventParam.isGraduated) {
            m11433a(stringBuilder, "graduated", composerLifeEventParam.isGraduated ? "1" : "0");
        }
        if (composerLifeEventParam.schoolType != null) {
            m11433a(stringBuilder, "school_type", composerLifeEventParam.schoolType.toLowerCase(Locale.US));
        }
        if (composerLifeEventParam.schoolHubId != null) {
            m11433a(stringBuilder, "school_hub_id", composerLifeEventParam.schoolHubId);
        }
        if (composerLifeEventParam.isCurrent) {
            m11433a(stringBuilder, "current", composerLifeEventParam.isCurrent ? "1" : "0");
        }
        if (composerLifeEventParam.employerHubId != null) {
            m11433a(stringBuilder, "employer_hub_id", composerLifeEventParam.employerHubId);
        }
        if (stringBuilder.length() <= 1) {
            str = "";
        } else {
            str = stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "}").toString();
        }
        String str2 = str;
        if (!StringUtil.a(str2)) {
            a.add(new BasicNameValuePair("extras", str2));
        }
        return new ApiRequest("graphObjectPosts", "POST", StringFormatUtil.a("%s/milestones", new Object[]{composerLifeEventParam.userId}), RequestPriority.INTERACTIVE, a, ApiResponseType.JSON);
    }

    public final Object m11435a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return apiResponse.c().b("id").B();
    }

    private static String m11432a(ImmutableList<String> immutableList) {
        return "[" + Joiner.on(',').skipNulls().join(immutableList) + "]";
    }

    public static StringBuilder m11433a(StringBuilder stringBuilder, String str, String str2) {
        return stringBuilder.append('\"').append(str).append("\":\"").append(str2).append("\",");
    }
}
