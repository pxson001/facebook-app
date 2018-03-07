package com.facebook.privacy.selector;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.TriState;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPrivacyOptionTagExpansionType;
import com.facebook.graphql.enums.GraphQLPrivacyOptionType;
import com.facebook.graphql.model.GraphQLPrivacyAudienceMember;
import com.facebook.graphql.model.GraphQLPrivacyAudienceMember.Builder;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.privacy.model.CustomPrivacyToken;
import com.facebook.privacy.model.FriendsExceptToken;
import com.facebook.privacy.model.PrivacyOptionHelper;
import com.facebook.privacy.model.PrivacyOptionsResult;
import com.facebook.privacy.model.PrivacyParameter;
import com.facebook.privacy.model.PrivacyParameter.Value;
import com.facebook.privacy.model.PrivacyToken;
import com.facebook.privacy.model.SelectablePrivacyData;
import com.facebook.privacy.model.SpecificFriendsToken;
import com.facebook.privacy.model.TagExpansionToken;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyAudienceMember;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFields;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFieldsForComposer;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFieldsWithExplanation;
import com.facebook.privacy.ui.PrivacyIcons;
import com.facebook.privacy.ui.PrivacyIcons.Size;
import com.facebook.privacy.ui.PrivacyOptionsSection;
import com.facebook.widget.listview.ExpandableSectionedListSection;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.model.SimpleFriendlistToken;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: fb4atux */
public class AudienceTypeaheadUtil {
    private final PrivacyIcons f15200a;
    private final Provider<TriState> f15201b;
    private final Provider<TriState> f15202c;
    private final Provider<TriState> f15203d;
    private final Provider<TriState> f15204e;
    private final int f15205f;

    public static AudienceTypeaheadUtil m22864b(InjectorLike injectorLike) {
        return new AudienceTypeaheadUtil((Context) injectorLike.getInstance(Context.class), PrivacyIcons.m22956a(injectorLike), IdBasedProvider.a(injectorLike, 742), IdBasedProvider.a(injectorLike, 748), IdBasedProvider.a(injectorLike, 743), IdBasedProvider.a(injectorLike, 749));
    }

    @Inject
    public AudienceTypeaheadUtil(Context context, PrivacyIcons privacyIcons, Provider<TriState> provider, Provider<TriState> provider2, Provider<TriState> provider3, Provider<TriState> provider4) {
        this.f15200a = privacyIcons;
        this.f15201b = provider;
        this.f15202c = provider2;
        this.f15203d = provider3;
        this.f15204e = provider4;
        this.f15205f = ContextUtils.b(context, 2130772543, ((TriState) this.f15204e.get()).asBoolean(false) ? 2131362877 : -1);
    }

    public final ImmutableList<BaseToken> m22872a(SelectablePrivacyData selectablePrivacyData, Resources resources, boolean z, boolean z2) {
        boolean z3 = true;
        if (selectablePrivacyData == null) {
            return RegularImmutableList.a;
        }
        PrivacyOptionFieldsWithExplanation privacyOptionFieldsWithExplanation = selectablePrivacyData.f15109d;
        int c = selectablePrivacyData.m22699c();
        if (privacyOptionFieldsWithExplanation == null) {
            return RegularImmutableList.a;
        }
        Collection a = Lists.a();
        boolean c2 = m22874c(privacyOptionFieldsWithExplanation);
        boolean d = m22875d(privacyOptionFieldsWithExplanation);
        if (c2) {
            a.add(m22866c(resources, privacyOptionFieldsWithExplanation.g()));
        }
        if (d) {
            a.add(m22867d(resources, privacyOptionFieldsWithExplanation.F_()));
        }
        if (!(c2 || d)) {
            a.add(m22868a(privacyOptionFieldsWithExplanation, c));
        }
        if (a.isEmpty() || !selectablePrivacyData.m22701f() || selectablePrivacyData.f15107b || !z) {
            return ImmutableList.copyOf(a);
        }
        if (privacyOptionFieldsWithExplanation.G_() == null || privacyOptionFieldsWithExplanation.G_().size() <= 1) {
            z3 = false;
        }
        a.add(m22869a(selectablePrivacyData.m22702g(), resources, z2, z3));
        return ImmutableList.copyOf(a);
    }

    public final TagExpansionToken m22869a(GraphQLPrivacyOptionTagExpansionType graphQLPrivacyOptionTagExpansionType, Resources resources, boolean z, boolean z2) {
        return new TagExpansionToken(graphQLPrivacyOptionTagExpansionType, resources, z, z2, ((TriState) this.f15204e.get()).asBoolean(false), this.f15205f);
    }

    private CustomPrivacyToken m22863b(Resources resources) {
        int a = this.f15200a.m22957a(GraphQLPrivacyOptionType.CUSTOM, Size.TOKEN);
        int a2 = m22857a(GraphQLPrivacyOptionType.CUSTOM);
        return new CustomPrivacyToken(resources.getString(2131234200), a, this.f15200a.m22957a(GraphQLPrivacyOptionType.CUSTOM, Size.LIST), a2, this.f15205f);
    }

    public static String m22860a(Resources resources) {
        return resources.getString(2131234200);
    }

    private FriendsExceptToken m22866c(Resources resources, List<? extends PrivacyAudienceMember> list) {
        int a = this.f15200a.m22957a(GraphQLPrivacyOptionType.FRIENDS_EXCEPT_ACQUAINTANCES, Size.TOKEN);
        int a2 = m22857a(GraphQLPrivacyOptionType.FRIENDS_EXCEPT_ACQUAINTANCES);
        int a3 = this.f15200a.m22957a(GraphQLPrivacyOptionType.FRIENDS_EXCEPT_ACQUAINTANCES, Size.LIST);
        if (list.isEmpty()) {
            return new FriendsExceptToken(resources.getString(2131234207), a, a3, a2, this.f15205f);
        }
        return new FriendsExceptToken(m22861a(resources, (List) list), a, a3, a2, this.f15205f);
    }

    public static String m22861a(Resources resources, List<? extends PrivacyAudienceMember> list) {
        if (list == null || list.isEmpty()) {
            return resources.getString(2131234195);
        }
        switch (list.size()) {
            case 1:
                return resources.getString(2131234209, new Object[]{((PrivacyAudienceMember) list.get(0)).d()});
            case 2:
                return resources.getString(2131234210, new Object[]{((PrivacyAudienceMember) list.get(0)).d(), ((PrivacyAudienceMember) list.get(1)).d()});
            case 3:
                return resources.getString(2131234211, new Object[]{((PrivacyAudienceMember) list.get(0)).d(), ((PrivacyAudienceMember) list.get(1)).d(), ((PrivacyAudienceMember) list.get(2)).d()});
            default:
                return resources.getString(2131234212, new Object[]{((PrivacyAudienceMember) list.get(0)).d(), ((PrivacyAudienceMember) list.get(1)).d(), ((PrivacyAudienceMember) list.get(2)).d()});
        }
    }

    private SpecificFriendsToken m22867d(Resources resources, List<? extends PrivacyAudienceMember> list) {
        int a = this.f15200a.m22957a(GraphQLPrivacyOptionType.CUSTOM, Size.TOKEN);
        int a2 = m22857a(GraphQLPrivacyOptionType.CUSTOM);
        int a3 = this.f15200a.m22957a(GraphQLPrivacyOptionType.CUSTOM, Size.LIST);
        if (list.isEmpty()) {
            return new SpecificFriendsToken(resources.getString(2131234214), a, a3, a2, this.f15205f);
        }
        return new SpecificFriendsToken(m22865b(resources, list), a, a3, a2, this.f15205f);
    }

    public static String m22865b(Resources resources, List<? extends PrivacyAudienceMember> list) {
        if (list == null || list.isEmpty()) {
            return resources.getString(2131234195);
        }
        switch (list.size()) {
            case 1:
                return resources.getString(2131234215, new Object[]{((PrivacyAudienceMember) list.get(0)).d()});
            case 2:
                return resources.getString(2131234216, new Object[]{((PrivacyAudienceMember) list.get(0)).d(), ((PrivacyAudienceMember) list.get(1)).d()});
            case 3:
                return resources.getString(2131234217, new Object[]{((PrivacyAudienceMember) list.get(0)).d(), ((PrivacyAudienceMember) list.get(1)).d(), ((PrivacyAudienceMember) list.get(2)).d()});
            default:
                return resources.getString(2131234218, new Object[]{((PrivacyAudienceMember) list.get(0)).d(), ((PrivacyAudienceMember) list.get(1)).d(), ((PrivacyAudienceMember) list.get(2)).d()});
        }
    }

    public final PrivacyToken m22868a(PrivacyOptionFieldsWithExplanation privacyOptionFieldsWithExplanation, int i) {
        return new PrivacyToken(Integer.valueOf(i), this.f15200a.m22957a(PrivacyOptionHelper.a(privacyOptionFieldsWithExplanation), Size.TOKEN), this.f15200a.m22957a(PrivacyOptionHelper.a(privacyOptionFieldsWithExplanation), Size.LIST), m22857a(PrivacyOptionHelper.a(privacyOptionFieldsWithExplanation)), this.f15205f, privacyOptionFieldsWithExplanation.d(), privacyOptionFieldsWithExplanation.j());
    }

    private int m22857a(GraphQLPrivacyOptionType graphQLPrivacyOptionType) {
        return ((TriState) this.f15204e.get()).asBoolean(false) ? this.f15200a.m22957a(graphQLPrivacyOptionType, Size.GLYPH) : -1;
    }

    public final SimpleFriendlistToken m22871a(PrivacyOptionFieldsForComposer privacyOptionFieldsForComposer) {
        int a = this.f15200a.m22957a(PrivacyOptionHelper.a(privacyOptionFieldsForComposer), Size.TOKEN);
        int a2 = this.f15200a.m22957a(PrivacyOptionHelper.a(privacyOptionFieldsForComposer), Size.LIST);
        int a3 = m22857a(PrivacyOptionHelper.a(privacyOptionFieldsForComposer));
        ImmutableList F_ = privacyOptionFieldsForComposer.F_();
        if (F_.size() != 1) {
            return null;
        }
        return new SimpleFriendlistToken(((PrivacyAudienceMember) F_.get(0)).c(), a, a2, a3, this.f15205f, privacyOptionFieldsForComposer.d());
    }

    protected static GraphQLPrivacyAudienceMember m22859a(SimpleUserToken simpleUserToken) {
        if (simpleUserToken == null) {
            return null;
        }
        Builder builder = new Builder();
        builder.d = simpleUserToken.f20125g.b();
        builder = builder;
        builder.e = simpleUserToken.mo1185b();
        builder = builder;
        builder.f = new GraphQLObjectType(2645995);
        return builder.a();
    }

    protected static GraphQLPrivacyAudienceMember m22858a(SimpleFriendlistToken simpleFriendlistToken) {
        if (simpleFriendlistToken == null || simpleFriendlistToken.f20117e == null) {
            return null;
        }
        Builder builder = new Builder();
        builder.d = simpleFriendlistToken.f20117e;
        builder = builder;
        builder.e = simpleFriendlistToken.mo1185b();
        builder = builder;
        builder.f = new GraphQLObjectType(236555388);
        return builder.a();
    }

    public final ExpandableSectionedListSection<PrivacyToken> m22870a(PrivacyOptionsResult privacyOptionsResult, GraphQLPrivacyOption graphQLPrivacyOption, Provider<Integer> provider, Resources resources, List<? extends PrivacyAudienceMember> list, List<? extends PrivacyAudienceMember> list2) {
        PrivacyToken a;
        PrivacyToken c;
        ImmutableList.Builder builder = ImmutableList.builder();
        Map c2 = Maps.c();
        Object obj = null;
        PrivacyToken privacyToken = null;
        Object obj2 = null;
        ImmutableList immutableList = privacyOptionsResult.basicPrivacyOptions;
        int size = immutableList.size();
        int i = 0;
        while (i < size) {
            PrivacyToken privacyToken2;
            Object obj3;
            Object obj4;
            PrivacyOptionFieldsWithExplanation privacyOptionFieldsWithExplanation = (GraphQLPrivacyOption) immutableList.get(i);
            a = m22868a(privacyOptionFieldsWithExplanation, privacyOptionsResult.b(privacyOptionFieldsWithExplanation));
            if (!((PrivacyOptionHelper.a(privacyOptionFieldsWithExplanation, graphQLPrivacyOption) && m22874c(graphQLPrivacyOption)) || ((PrivacyOptionHelper.a(privacyOptionFieldsWithExplanation, graphQLPrivacyOption) && m22875d(graphQLPrivacyOption)) || (PrivacyOptionHelper.a(privacyOptionFieldsWithExplanation, graphQLPrivacyOption) && m22873b((PrivacyOptionFieldsForComposer) graphQLPrivacyOption))))) {
                if (PrivacyOptionHelper.a(privacyOptionFieldsWithExplanation, privacyOptionsResult.selectedPrivacyOption)) {
                    privacyToken = a;
                } else if (PrivacyOptionHelper.a(privacyOptionFieldsWithExplanation, privacyOptionsResult.recentPrivacyOption)) {
                    privacyToken2 = a;
                }
                if (PrivacyOptionHelper.a(privacyOptionFieldsWithExplanation) == GraphQLPrivacyOptionType.ONLY_ME) {
                    obj = a;
                } else {
                    builder.c(a);
                    c2.put(PrivacyOptionHelper.a(privacyOptionFieldsWithExplanation), a);
                }
                if (PrivacyOptionHelper.a(privacyOptionFieldsWithExplanation) == GraphQLPrivacyOptionType.FRIENDS && !((TriState) this.f15203d.get()).asBoolean(false) && ((TriState) this.f15201b.get()).asBoolean(false)) {
                    c = m22866c(resources, list);
                    builder.c(c);
                    if (!list.isEmpty()) {
                        c2.put(GraphQLPrivacyOptionType.FRIENDS_EXCEPT, c);
                        obj3 = obj;
                        PrivacyToken privacyToken3 = c;
                        obj4 = obj2;
                        privacyToken2 = privacyToken3;
                        i++;
                        obj = obj3;
                        privacyToken = privacyToken2;
                        obj2 = obj4;
                    }
                }
            }
            obj4 = obj2;
            privacyToken2 = privacyToken;
            obj3 = obj;
            i++;
            obj = obj3;
            privacyToken = privacyToken2;
            obj2 = obj4;
        }
        if (((TriState) this.f15203d.get()).asBoolean(false)) {
            c = m22863b(resources);
            builder.c(c);
            if (!list2.isEmpty()) {
                c2.put(GraphQLPrivacyOptionType.CUSTOM, c);
                privacyToken = c;
            }
        }
        immutableList = privacyOptionsResult.friendListPrivacyOptions;
        size = immutableList.size();
        i = 0;
        a = privacyToken;
        while (i < size) {
            privacyOptionFieldsWithExplanation = (GraphQLPrivacyOption) immutableList.get(i);
            privacyToken = m22868a(privacyOptionFieldsWithExplanation, privacyOptionsResult.b(privacyOptionFieldsWithExplanation));
            builder.c(privacyToken);
            if (PrivacyOptionHelper.a(privacyOptionFieldsWithExplanation, privacyOptionsResult.selectedPrivacyOption)) {
                obj4 = obj2;
            } else if (PrivacyOptionHelper.a(privacyOptionFieldsWithExplanation, privacyOptionsResult.recentPrivacyOption)) {
                c = privacyToken;
                privacyToken = a;
            } else {
                obj4 = obj2;
                privacyToken = a;
            }
            i++;
            a = privacyToken;
            obj2 = obj4;
        }
        if (!((TriState) this.f15203d.get()).asBoolean(false) && ((TriState) this.f15202c.get()).asBoolean(false)) {
            SpecificFriendsToken d = m22867d(resources, list2);
            builder.c(d);
            if (!list2.isEmpty()) {
                c2.put(GraphQLPrivacyOptionType.SPECIFIC_FRIENDS, d);
                Object obj5 = d;
            }
        }
        if (obj != null) {
            builder.c(obj);
        }
        ImmutableList.Builder builder2 = ImmutableList.builder();
        boolean z = false;
        if (c2.containsKey(GraphQLPrivacyOptionType.EVERYONE)) {
            builder2.c(c2.get(GraphQLPrivacyOptionType.EVERYONE));
        } else if (c2.containsKey(GraphQLPrivacyOptionType.FRIENDS_OF_FRIENDS)) {
            builder2.c(c2.get(GraphQLPrivacyOptionType.FRIENDS_OF_FRIENDS));
            z = true;
        }
        if (c2.containsKey(GraphQLPrivacyOptionType.FRIENDS)) {
            builder2.c(c2.get(GraphQLPrivacyOptionType.FRIENDS));
        }
        boolean containsKey = c2.containsKey(GraphQLPrivacyOptionType.FRIENDS_EXCEPT);
        if (containsKey) {
            builder2.c(c2.get(GraphQLPrivacyOptionType.FRIENDS_EXCEPT));
        }
        boolean containsKey2 = c2.containsKey(GraphQLPrivacyOptionType.CUSTOM);
        if (containsKey2) {
            builder2.c(c2.get(GraphQLPrivacyOptionType.CUSTOM));
        }
        boolean containsKey3 = c2.containsKey(GraphQLPrivacyOptionType.SPECIFIC_FRIENDS);
        if (!(obj5 == null || containsKey || containsKey2 || containsKey3 || !m22862a(privacyOptionsResult.selectedPrivacyOption, r2))) {
            builder2.c(obj5);
        }
        if (obj2 != null && m22862a(privacyOptionsResult.recentPrivacyOption, r2)) {
            builder2.c(obj2);
        }
        if (containsKey3) {
            builder2.c(c2.get(GraphQLPrivacyOptionType.SPECIFIC_FRIENDS));
        }
        return new PrivacyOptionsSection(this, builder.b(), builder2.b(), provider) {
            final /* synthetic */ AudienceTypeaheadUtil f15199a;
        };
    }

    private static boolean m22862a(PrivacyOptionFields privacyOptionFields, boolean z) {
        return (privacyOptionFields == null || PrivacyOptionHelper.a(privacyOptionFields) == GraphQLPrivacyOptionType.EVERYONE || PrivacyOptionHelper.a(privacyOptionFields) == GraphQLPrivacyOptionType.FRIENDS || (PrivacyOptionHelper.a(privacyOptionFields) == GraphQLPrivacyOptionType.FRIENDS_OF_FRIENDS && z)) ? false : true;
    }

    public final boolean m22873b(PrivacyOptionFieldsForComposer privacyOptionFieldsForComposer) {
        if (privacyOptionFieldsForComposer == null) {
            return false;
        }
        boolean equal;
        if (PrivacyOptionHelper.f(privacyOptionFieldsForComposer)) {
            ImmutableList F_ = privacyOptionFieldsForComposer.F_();
            if (F_.size() != 1 || ((PrivacyAudienceMember) F_.get(0)).b() == null || ((PrivacyAudienceMember) F_.get(0)).b().g() == 2645995) {
                PrivacyParameter a = PrivacyOptionHelper.a(privacyOptionFieldsForComposer);
                equal = a == null ? false : Objects.equal(a.value, Value.CUSTOM.name());
            } else {
                equal = false;
            }
        } else {
            equal = false;
        }
        return equal && ((TriState) this.f15203d.get()).asBoolean(false);
    }

    public final boolean m22874c(PrivacyOptionFieldsForComposer privacyOptionFieldsForComposer) {
        if (privacyOptionFieldsForComposer == null) {
            return false;
        }
        return PrivacyOptionHelper.b(privacyOptionFieldsForComposer) && ((TriState) this.f15201b.get()).asBoolean(false) && !((TriState) this.f15203d.get()).asBoolean(false);
    }

    public final boolean m22875d(PrivacyOptionFieldsForComposer privacyOptionFieldsForComposer) {
        if (privacyOptionFieldsForComposer == null) {
            return false;
        }
        return PrivacyOptionHelper.c(privacyOptionFieldsForComposer) && ((TriState) this.f15202c.get()).asBoolean(false) && !((TriState) this.f15203d.get()).asBoolean(false);
    }
}
