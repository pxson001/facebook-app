package com.facebook.user.module;

import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.TriState;
import com.facebook.inject.InjectorLike;
import com.facebook.user.gender.Gender;
import com.facebook.user.model.Name;
import com.facebook.user.model.PicSquare;
import com.facebook.user.model.PicSquareUrlWithSize;
import com.facebook.user.model.User;
import com.facebook.user.model.User.CommercePageSetting;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserBuilder;
import com.facebook.user.model.UserCustomTag;
import com.facebook.user.model.UserEmailAddress;
import com.facebook.user.model.UserPhoneNumber;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;
import javax.inject.Inject;

/* compiled from: mView= */
public class UserSerialization {
    private final Clock f15345a;
    private final ObjectMapper f15346b;

    public static UserSerialization m21850b(InjectorLike injectorLike) {
        return new UserSerialization(SystemClockMethodAutoProvider.m1498a(injectorLike), FbObjectMapperMethodAutoProvider.m6609a(injectorLike));
    }

    @Inject
    public UserSerialization(Clock clock, ObjectMapper objectMapper) {
        this.f15345a = clock;
        this.f15346b = objectMapper;
    }

    public final ImmutableList<User> m21859a(Type type, JsonNode jsonNode) {
        Builder builder = ImmutableList.builder();
        Iterator it = jsonNode.iterator();
        while (it.hasNext()) {
            builder.m1069c(m21849b(type, (JsonNode) it.next()));
        }
        return builder.m1068b();
    }

    private User m21849b(Type type, JsonNode jsonNode) {
        int d;
        int i = 0;
        UserBuilder userBuilder = new UserBuilder();
        Preconditions.checkArgument(jsonNode.mo730d("uid"), "Missing id field on profile");
        String b = JSONUtil.m13458b(jsonNode.mo709b("uid"));
        if (b == null) {
            b = JSONUtil.m13458b(jsonNode.mo709b("id"));
        }
        userBuilder.m5767a(type, b);
        if (JSONUtil.m13455a(jsonNode.mo709b("contact_email"))) {
            userBuilder.f3546c = ImmutableList.of(new UserEmailAddress(JSONUtil.m13458b(jsonNode.mo709b("contact_email")), 0));
        } else if (jsonNode.mo730d("emails")) {
            userBuilder.f3546c = m21856f(jsonNode.mo709b("emails"));
        }
        if (JSONUtil.m13455a(jsonNode.mo709b("phones"))) {
            JsonNode b2 = jsonNode.mo709b("phones");
            Builder builder = ImmutableList.builder();
            Iterator it = b2.iterator();
            while (it.hasNext()) {
                String b3;
                String b4;
                JsonNode jsonNode2 = (JsonNode) it.next();
                if (jsonNode2.mo730d("full_number")) {
                    b3 = JSONUtil.m13458b(jsonNode2.mo709b("full_number"));
                    b4 = JSONUtil.m13458b(jsonNode2.mo709b("display_number"));
                } else {
                    b4 = "+" + JSONUtil.m13458b(jsonNode2.mo709b("country_code")) + JSONUtil.m13458b(jsonNode2.mo709b("number"));
                    b3 = b4;
                }
                TriState triState = TriState.UNSET;
                if (jsonNode2.mo730d("is_verified")) {
                    triState = jsonNode2.mo709b("is_verified").mo1647u() ? TriState.YES : TriState.NO;
                }
                int i2 = 0;
                if (jsonNode2.mo730d("android_type")) {
                    i2 = JSONUtil.m13460d(jsonNode2.mo709b("android_type"));
                } else if (jsonNode2.mo730d("type")) {
                    String b5 = JSONUtil.m13458b(jsonNode2.mo709b("type"));
                    if ("other_phone".equals(b5)) {
                        i2 = 7;
                    } else if ("cell".equals(b5)) {
                        i2 = 2;
                    }
                }
                builder.m1069c(new UserPhoneNumber(b4, b3, b3, i2, triState));
            }
            userBuilder.f3547d = builder.m1068b();
        }
        userBuilder.f3550g = m21854d(jsonNode);
        int d2 = jsonNode.mo730d("birth_date_year") ? JSONUtil.m13460d(jsonNode.mo709b("birth_date_year")) : 0;
        if (jsonNode.mo730d("birth_date_month")) {
            d = JSONUtil.m13460d(jsonNode.mo709b("birth_date_month"));
        } else {
            d = 0;
        }
        if (jsonNode.mo730d("birth_date_day")) {
            i = JSONUtil.m13460d(jsonNode.mo709b("birth_date_day"));
        }
        userBuilder.m5762a(d2, d, i);
        userBuilder.f3556m = m21855e(jsonNode);
        if (jsonNode.mo730d("profile_pic_square")) {
            userBuilder.f3559p = m21847a(jsonNode.mo709b("profile_pic_square"));
        }
        if (jsonNode.mo730d("pic_square")) {
            userBuilder.f3557n = JSONUtil.m13458b(jsonNode.mo709b("pic_square"));
        }
        if (jsonNode.mo730d("pic_cover")) {
            userBuilder.f3558o = JSONUtil.m13458b(jsonNode.mo709b("pic_cover"));
        }
        if (jsonNode.mo730d("rank")) {
            userBuilder.f3563t = (float) JSONUtil.m13461e(jsonNode.mo709b("rank"));
        }
        if (jsonNode.mo730d("is_pushable")) {
            TriState triState2;
            if (jsonNode.mo709b("is_pushable").mo1647u()) {
                triState2 = TriState.YES;
            } else {
                triState2 = TriState.NO;
            }
            userBuilder.f3564u = triState2;
        } else {
            userBuilder.f3564u = TriState.UNSET;
        }
        if (jsonNode.mo730d("is_employee")) {
            userBuilder.f3565v = jsonNode.mo709b("is_employee").mo1647u();
        }
        if (jsonNode.mo730d("is_work_user")) {
            userBuilder.f3566w = jsonNode.mo709b("is_work_user").mo1647u();
        }
        if (jsonNode.mo730d("type")) {
            userBuilder.f3569z = JSONUtil.m13458b(jsonNode.mo709b("type"));
        }
        if (jsonNode.mo730d("is_messenger_user")) {
            userBuilder.f3518A = jsonNode.mo709b("is_messenger_user").mo1647u();
        }
        if (jsonNode.mo730d("is_commerce")) {
            userBuilder.f3519B = jsonNode.mo709b("is_commerce").mo1647u();
        }
        if (jsonNode.mo730d("messenger_install_time")) {
            userBuilder.m5763a(JSONUtil.m13459c(jsonNode.mo709b("messenger_install_time")));
        }
        if (jsonNode.mo730d("added_time")) {
            userBuilder.m5774b(JSONUtil.m13459c(jsonNode.mo709b("added_time")));
        }
        if (jsonNode.mo730d("is_partial")) {
            userBuilder.f3529L = jsonNode.mo709b("is_partial").mo1647u();
        }
        if (jsonNode.mo730d("is_minor")) {
            userBuilder.f3530M = jsonNode.mo709b("is_minor").mo1647u();
        }
        if (jsonNode.mo730d("can_viewer_message")) {
            userBuilder.f3540W = jsonNode.mo709b("can_viewer_message").mo1647u();
        }
        if (jsonNode.mo730d("profile_picture_is_silhouette")) {
            userBuilder.f3531N = TriState.valueOf(jsonNode.mo709b("profile_picture_is_silhouette").mo1647u());
        }
        userBuilder.m5780c(this.f15345a.mo211a());
        if (jsonNode.mo730d("montage_thread_fbid")) {
            userBuilder.m5784d(JSONUtil.m13459c(jsonNode.mo709b("montage_thread_fbid")));
        }
        if (jsonNode.mo730d("can_see_viewer_montage_thread")) {
            userBuilder.f3543Z = jsonNode.mo709b("can_see_viewer_montage_thread").mo1647u();
        }
        if (jsonNode.mo730d("is_deactivated_allowed_on_messenger")) {
            userBuilder.f3535R = jsonNode.mo709b("is_deactivated_allowed_on_messenger").mo1647u();
        }
        if (jsonNode.mo730d("user_custom_tags")) {
            userBuilder.f3548e = m21852b(jsonNode.mo709b("user_custom_tags"));
        }
        return userBuilder.aa();
    }

    public final User m21857a(Type type, String str) {
        try {
            return m21849b(type, this.f15346b.m6636a(str));
        } catch (Throwable e) {
            throw new RuntimeException("Unexpected serialization exception", e);
        }
    }

    private static Name m21854d(JsonNode jsonNode) {
        String b;
        String b2;
        String str = null;
        if (jsonNode.mo730d("first_name")) {
            b = JSONUtil.m13458b(jsonNode.mo709b("first_name"));
        } else {
            b = null;
        }
        if (jsonNode.mo730d("last_name")) {
            b2 = JSONUtil.m13458b(jsonNode.mo709b("last_name"));
        } else {
            b2 = null;
        }
        if (jsonNode.mo730d("name")) {
            str = JSONUtil.m13458b(jsonNode.mo709b("name"));
        }
        return new Name(b, b2, str);
    }

    private static Gender m21855e(JsonNode jsonNode) {
        try {
            String b = JSONUtil.m13458b(jsonNode.mo709b("gender"));
            if (b == null || b.isEmpty()) {
                return Gender.UNKNOWN;
            }
            return Gender.valueOf(b);
        } catch (IllegalArgumentException e) {
            return Gender.UNKNOWN;
        }
    }

    private static ImmutableList<UserEmailAddress> m21856f(JsonNode jsonNode) {
        Builder builder = ImmutableList.builder();
        Iterator it = jsonNode.iterator();
        while (it.hasNext()) {
            builder.m1069c(new UserEmailAddress(JSONUtil.m13458b((JsonNode) it.next()), 0));
        }
        return builder.m1068b();
    }

    public static PicSquare m21847a(JsonNode jsonNode) {
        Builder builder = ImmutableList.builder();
        Iterator it = jsonNode.iterator();
        while (it.hasNext()) {
            JsonNode jsonNode2 = (JsonNode) it.next();
            builder.m1069c(new PicSquareUrlWithSize(JSONUtil.m13460d(jsonNode2.mo709b("size")), JSONUtil.m13458b(jsonNode2.mo709b("url"))));
        }
        return new PicSquare(builder.m1068b());
    }

    public final JsonNode m21858a(PicSquare picSquare) {
        JsonNode arrayNode = new ArrayNode(JsonNodeFactory.f3121a);
        ImmutableList a = picSquare.a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            PicSquareUrlWithSize picSquareUrlWithSize = (PicSquareUrlWithSize) a.get(i);
            JsonNode objectNode = new ObjectNode(JsonNodeFactory.f3121a);
            objectNode.m5137a("url", picSquareUrlWithSize.url);
            objectNode.m5129a("size", picSquareUrlWithSize.size);
            arrayNode.m13381a(objectNode);
        }
        return arrayNode;
    }

    public static ImmutableList<UserCustomTag> m21852b(JsonNode jsonNode) {
        Builder builder = ImmutableList.builder();
        Iterator it = jsonNode.iterator();
        while (it.hasNext()) {
            JsonNode jsonNode2 = (JsonNode) it.next();
            builder.m1069c(new UserCustomTag(JSONUtil.m13458b(jsonNode2.mo709b("id")), JSONUtil.m13458b(jsonNode2.mo709b("name")), JSONUtil.m13460d(jsonNode2.mo709b("color")), JSONUtil.m13460d(jsonNode2.mo709b("fillColor")), JSONUtil.m13460d(jsonNode2.mo709b("borderColor"))));
        }
        return builder.m1068b();
    }

    public static JsonNode m21848a(ImmutableList<UserCustomTag> immutableList) {
        JsonNode arrayNode = new ArrayNode(JsonNodeFactory.f3121a);
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            UserCustomTag userCustomTag = (UserCustomTag) immutableList.get(i);
            JsonNode objectNode = new ObjectNode(JsonNodeFactory.f3121a);
            objectNode.m5137a("id", userCustomTag.a);
            objectNode.m5137a("name", userCustomTag.b);
            objectNode.m5129a("color", userCustomTag.c);
            objectNode.m5129a("fillColor", userCustomTag.d);
            objectNode.m5129a("borderColor", userCustomTag.e);
            arrayNode.m13381a(objectNode);
        }
        return arrayNode;
    }

    public static JsonNode m21851b(ImmutableList<CommercePageSetting> immutableList) {
        JsonNode objectNode = new ObjectNode(JsonNodeFactory.f3121a);
        objectNode.m5138a("commerce_faq_enabled", immutableList.contains(CommercePageSetting.COMMERCE_FAQ_ENABLED));
        objectNode.m5138a("in_messenger_shopping_enabled", immutableList.contains(CommercePageSetting.IN_MESSENGER_SHOPPING_ENABLED));
        objectNode.m5138a("commerce_nux_enabled", immutableList.contains(CommercePageSetting.COMMERCE_NUX_ENABLED));
        return objectNode;
    }

    public static ImmutableList<CommercePageSetting> m21853c(JsonNode jsonNode) {
        Builder builder = ImmutableList.builder();
        if (jsonNode.mo730d("commerce_faq_enabled") && JSONUtil.m13463g(jsonNode.mo709b("commerce_faq_enabled"))) {
            builder.m1069c(CommercePageSetting.COMMERCE_FAQ_ENABLED);
        }
        if (jsonNode.mo730d("in_messenger_shopping_enabled") && JSONUtil.m13463g(jsonNode.mo709b("in_messenger_shopping_enabled"))) {
            builder.m1069c(CommercePageSetting.IN_MESSENGER_SHOPPING_ENABLED);
        }
        if (jsonNode.mo730d("commerce_nux_enabled") && JSONUtil.m13463g(jsonNode.mo709b("commerce_nux_enabled"))) {
            builder.m1069c(CommercePageSetting.COMMERCE_NUX_ENABLED);
        }
        return builder.m1068b();
    }
}
