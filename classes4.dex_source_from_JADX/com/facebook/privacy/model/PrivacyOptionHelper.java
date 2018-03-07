package com.facebook.privacy.model;

import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.enums.GraphQLPrivacyBaseState;
import com.facebook.graphql.enums.GraphQLPrivacyOptionTagExpansionType;
import com.facebook.graphql.enums.GraphQLPrivacyOptionType;
import com.facebook.graphql.enums.GraphQLPrivacyTagExpansionState;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.graphql.model.GraphQLPrivacyRowInput;
import com.facebook.graphql.model.GraphQLPrivacyRowInput.Builder;
import com.facebook.graphql.model.GraphQLPrivacyScope;
import com.facebook.privacy.model.PrivacyParameter.Allow;
import com.facebook.privacy.model.PrivacyParameter.Value;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyAudienceMember;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyIconFields;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFields;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFieldsForComposer;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionWithIconFields;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionWithLegacyJsonFields;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: sim_current_location */
public class PrivacyOptionHelper {
    public static GraphQLPrivacyOptionType m2343a(PrivacyOptionWithIconFields privacyOptionWithIconFields) {
        if (privacyOptionWithIconFields.b() == null) {
            return GraphQLPrivacyOptionType.CUSTOM;
        }
        return GraphQLPrivacyOptionType.fromIconName(privacyOptionWithIconFields.b().d());
    }

    public static boolean m2347a(GraphQLPrivacyScope graphQLPrivacyScope) {
        if (graphQLPrivacyScope != null && GraphQLPrivacyOptionType.fromIconName(graphQLPrivacyScope.s()) == GraphQLPrivacyOptionType.EVERYONE) {
            return true;
        }
        return false;
    }

    @Nullable
    public static PrivacyParameter m2344a(PrivacyOptionWithLegacyJsonFields privacyOptionWithLegacyJsonFields) {
        if (privacyOptionWithLegacyJsonFields.c() == null) {
            return null;
        }
        try {
            return (PrivacyParameter) FbObjectMapper.i().a(privacyOptionWithLegacyJsonFields.c(), PrivacyParameter.class);
        } catch (IOException e) {
            return null;
        }
    }

    public static boolean m2356f(PrivacyOptionFieldsForComposer privacyOptionFieldsForComposer) {
        return (privacyOptionFieldsForComposer.F_() == null || privacyOptionFieldsForComposer.F_().isEmpty()) ? false : true;
    }

    private static boolean m2357g(PrivacyOptionFieldsForComposer privacyOptionFieldsForComposer) {
        return (privacyOptionFieldsForComposer.g() == null || privacyOptionFieldsForComposer.g().isEmpty()) ? false : true;
    }

    public static boolean m2352b(PrivacyOptionFieldsForComposer privacyOptionFieldsForComposer) {
        if (m2356f(privacyOptionFieldsForComposer) || !m2357g(privacyOptionFieldsForComposer)) {
            return false;
        }
        PrivacyParameter a = m2344a((PrivacyOptionWithLegacyJsonFields) privacyOptionFieldsForComposer);
        if (a != null && Objects.equal(a.value, Value.CUSTOM.name()) && Objects.equal(a.allow, Allow.ALL_FRIENDS.name())) {
            return true;
        }
        return false;
    }

    public static boolean m2353c(PrivacyOptionFieldsForComposer privacyOptionFieldsForComposer) {
        if (m2357g(privacyOptionFieldsForComposer)) {
            return false;
        }
        if (!m2356f(privacyOptionFieldsForComposer)) {
            return false;
        }
        ImmutableList F_ = privacyOptionFieldsForComposer.F_();
        if (F_.size() == 1 && ((PrivacyAudienceMember) F_.get(0)).b() != null && ((PrivacyAudienceMember) F_.get(0)).b().g() != 2645995) {
            return false;
        }
        PrivacyParameter a = m2344a((PrivacyOptionWithLegacyJsonFields) privacyOptionFieldsForComposer);
        if (a == null) {
            return false;
        }
        return Objects.equal(a.value, Value.CUSTOM.name());
    }

    public static boolean m2354d(PrivacyOptionFieldsForComposer privacyOptionFieldsForComposer) {
        PrivacyParameter a = m2344a((PrivacyOptionWithLegacyJsonFields) privacyOptionFieldsForComposer);
        if (a != null && a.settings != null && a.settings.noTagExpansion) {
            return true;
        }
        if (privacyOptionFieldsForComposer.G_() == null || privacyOptionFieldsForComposer.G_().size() <= 1) {
            return false;
        }
        if (privacyOptionFieldsForComposer.E_() != GraphQLPrivacyOptionTagExpansionType.TAGGEES) {
            return false;
        }
        return true;
    }

    public static boolean m2348a(PrivacyOptionFields privacyOptionFields, PrivacyOptionFields privacyOptionFields2) {
        PrivacyParameter a = m2344a((PrivacyOptionWithLegacyJsonFields) privacyOptionFields);
        PrivacyParameter a2 = m2344a((PrivacyOptionWithLegacyJsonFields) privacyOptionFields2);
        if (!Objects.equal(a.value, a2.value)) {
            String a3 = m2345a(a);
            if (!Objects.equal(a3, m2345a(a2))) {
                return false;
            }
            if (!Objects.equal(a3, Value.CUSTOM.toString())) {
                return true;
            }
        }
        if (Objects.equal(m2346a(a.deny), m2346a(a2.deny)) && Objects.equal(m2346a(a.allow), m2346a(a2.allow))) {
            return true;
        }
        return false;
    }

    private static String m2345a(PrivacyParameter privacyParameter) {
        if (StringUtil.a(privacyParameter.value)) {
            return "";
        }
        if (!privacyParameter.value.equals(Value.CUSTOM.toString())) {
            return privacyParameter.value;
        }
        if (!StringUtil.a(privacyParameter.deny)) {
            return Value.CUSTOM.toString();
        }
        if (m2346a(privacyParameter.allow).size() == 1) {
            if (privacyParameter.allow.equals(Allow.ALL_FRIENDS.toString())) {
                return Value.ALL_FRIENDS.toString();
            }
            if (privacyParameter.allow.equals(Allow.FRIENDS_OF_FRIENDS.toString())) {
                return Value.FRIENDS_OF_FRIENDS.toString();
            }
        }
        return Value.CUSTOM.toString();
    }

    private static HashSet<String> m2346a(@Nullable String str) {
        HashSet<String> hashSet = new HashSet();
        if (str == null) {
            return hashSet;
        }
        for (String str2 : Arrays.asList(str.split(","))) {
            if (!StringUtil.a(str2)) {
                hashSet.add(str2);
            }
        }
        return hashSet;
    }

    public static GraphQLPrivacyRowInput m2355e(PrivacyOptionFieldsForComposer privacyOptionFieldsForComposer) {
        Builder builder = new Builder();
        builder.e = GraphQLPrivacyBaseState.SELF;
        builder = builder;
        PrivacyParameter a = m2344a((PrivacyOptionWithLegacyJsonFields) privacyOptionFieldsForComposer);
        if (a == null) {
            return builder.a();
        }
        if (Objects.equal(a.value, Value.SELF.toString())) {
            return builder.a();
        }
        if (Objects.equal(a.value, Value.ALL_FRIENDS.toString())) {
            builder.e = GraphQLPrivacyBaseState.FRIENDS;
            return builder.a();
        } else if (Objects.equal(a.value, Value.FRIENDS_OF_FRIENDS.toString())) {
            builder.e = GraphQLPrivacyBaseState.FRIENDS_OF_FRIENDS;
            return builder.a();
        } else if (Objects.equal(a.value, Value.EVERYONE.toString())) {
            builder.e = GraphQLPrivacyBaseState.EVERYONE;
            return builder.a();
        } else if (Objects.equal(a.value, Value.CUSTOM.toString())) {
            Set a2 = m2346a(a.allow);
            Collection a3 = m2346a(a.deny);
            if (a2.contains(Allow.SOME_FRIENDS.toString())) {
                builder.e = GraphQLPrivacyBaseState.SELF;
                a2.remove(Allow.SOME_FRIENDS.toString());
            } else if (a2.contains(Allow.ALL_FRIENDS.toString())) {
                builder.e = GraphQLPrivacyBaseState.FRIENDS;
                a2.remove(Allow.ALL_FRIENDS.toString());
            } else if (a2.contains(Allow.FRIENDS_OF_FRIENDS.toString())) {
                builder.e = GraphQLPrivacyBaseState.FRIENDS_OF_FRIENDS;
                a2.remove(Allow.FRIENDS_OF_FRIENDS.toString());
            }
            builder.d = ImmutableList.copyOf(a2);
            builder.f = ImmutableList.copyOf(a3);
            if (m2354d(privacyOptionFieldsForComposer)) {
                builder.g = GraphQLPrivacyTagExpansionState.TAGGEES;
            }
            return builder.a();
        } else {
            BLog.c(GraphQLPrivacyOption.class, "unexpected_privacy_json_when_convert_option_to_row_input: %s", new Object[]{privacyOptionFieldsForComposer.c()});
            return builder.a();
        }
    }

    public static boolean m2351b(PrivacyOptionFields privacyOptionFields, PrivacyOptionFields privacyOptionFields2) {
        if (privacyOptionFields == null && privacyOptionFields2 == null) {
            return true;
        }
        if (privacyOptionFields2 == null || privacyOptionFields == null) {
            return false;
        }
        if (Objects.equal(privacyOptionFields.d(), privacyOptionFields2.d())) {
            PrivacyIconFields b = privacyOptionFields.b();
            PrivacyIconFields b2 = privacyOptionFields2.b();
            Object obj = 1;
            if (!(b == null && b2 == null) && (b == null || b2 == null || !Objects.equal(b.d(), b2.d()))) {
                obj = null;
            }
            if (obj != null && Objects.equal(privacyOptionFields.c(), privacyOptionFields2.c())) {
                return true;
            }
        }
        return false;
    }

    public static boolean m2349a(PrivacyOptionFieldsForComposer privacyOptionFieldsForComposer, PrivacyOptionFieldsForComposer privacyOptionFieldsForComposer2) {
        if (privacyOptionFieldsForComposer == null && privacyOptionFieldsForComposer2 == null) {
            return true;
        }
        if (m2351b(privacyOptionFieldsForComposer, privacyOptionFieldsForComposer2)) {
            return Objects.equal(privacyOptionFieldsForComposer.E_(), privacyOptionFieldsForComposer2.E_());
        }
        return false;
    }

    public static boolean m2350a(Collection<? extends PrivacyOptionFieldsForComposer> collection, PrivacyOptionFieldsForComposer privacyOptionFieldsForComposer) {
        for (PrivacyOptionFieldsForComposer a : collection) {
            if (m2349a(a, privacyOptionFieldsForComposer)) {
                return true;
            }
        }
        return false;
    }

    public static int m2342a(List<? extends PrivacyOptionFieldsForComposer> list, PrivacyOptionFieldsForComposer privacyOptionFieldsForComposer) {
        for (int i = 0; i < list.size(); i++) {
            if (m2349a((PrivacyOptionFieldsForComposer) list.get(i), privacyOptionFieldsForComposer)) {
                return i;
            }
        }
        return -1;
    }
}
