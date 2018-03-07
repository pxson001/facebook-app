package com.facebook.privacy.model;

import android.content.res.Resources;
import android.text.TextUtils;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.graphql.enums.GraphQLPrivacyOptionInfoType;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.graphql.model.GraphQLPrivacyOptionsComposerConnection;
import com.facebook.graphql.model.GraphQLPrivacyOptionsComposerEdge;
import com.facebook.graphql.model.GraphQLPrivacyOptionsContentEdge;
import com.facebook.graphql.model.GraphQLViewer;
import com.facebook.inject.InjectorLike;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFields;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFieldsForComposer;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionWithIconFields;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* compiled from: simple_reg */
public class PrivacyOptionsResultFactory {
    private final AbstractFbErrorReporter f2179a;
    public final Resources f2180b;

    public static PrivacyOptionsResultFactory m2331b(InjectorLike injectorLike) {
        return new PrivacyOptionsResultFactory((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PrivacyOptionsResultFactory(AbstractFbErrorReporter abstractFbErrorReporter, Resources resources) {
        this.f2179a = abstractFbErrorReporter;
        this.f2180b = resources;
    }

    public static boolean m2329a(PrivacyOptionFields privacyOptionFields) {
        if (privacyOptionFields == null || privacyOptionFields.c() == null || privacyOptionFields.d() == null || privacyOptionFields.b() == null || privacyOptionFields.b().d() == null) {
            return false;
        }
        return true;
    }

    public static String m2332b(PrivacyOptionFields privacyOptionFields) {
        if (privacyOptionFields == null) {
            return "privacy_option_invalid_object_null";
        }
        if (privacyOptionFields.c() == null) {
            return "privacy_option_invalid_json_null";
        }
        if (privacyOptionFields.d() == null) {
            return "privacy_option_invalid_name_null";
        }
        if (privacyOptionFields.b() == null || privacyOptionFields.b().d() == null) {
            return "privacy_option_invalid_icon_null";
        }
        return null;
    }

    private boolean m2330a(PrivacyOptionFields privacyOptionFields, String str) {
        String b = m2332b(privacyOptionFields);
        if (b == null) {
            return true;
        }
        this.f2179a.b(b + "_" + str, "Invalid privacy option");
        return false;
    }

    private static void m2327a(List<GraphQLPrivacyOption> list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Preconditions.checkArgument(m2329a((GraphQLPrivacyOption) it.next()));
        }
    }

    public final PrivacyOptionsResult m2334a(GraphQLViewer graphQLViewer, boolean z) {
        return m2324a(graphQLViewer.m(), z);
    }

    private void m2326a(String str) {
        SoftErrorBuilder a = SoftError.m4758a(str, "Got some null options");
        a.f4228e = 10;
        this.f2179a.a(a.m4765g());
    }

    public final ContentPrivacyOptionsResult m2333a(ImmutableList<GraphQLPrivacyOptionsContentEdge> immutableList, boolean z) {
        Builder builder = ImmutableList.builder();
        Builder builder2 = ImmutableList.builder();
        GraphQLPrivacyOption graphQLPrivacyOption = null;
        if (immutableList == null) {
            this.f2179a.b("null_privacy_option_edges", "null passed to PrivacyOptionsResultFactory.fromOptionEdges, returning empty result");
            throw new NullPointerException("null passed to fromOptionEdges");
        }
        boolean z2;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            GraphQLPrivacyOptionsContentEdge graphQLPrivacyOptionsContentEdge = (GraphQLPrivacyOptionsContentEdge) immutableList.get(i);
            if (graphQLPrivacyOptionsContentEdge.m4829j() != null) {
                if (graphQLPrivacyOptionsContentEdge.m4830k() != null && graphQLPrivacyOptionsContentEdge.m4830k() != GraphQLPrivacyOptionInfoType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
                    if (m2330a(graphQLPrivacyOptionsContentEdge.m4829j(), "content")) {
                        if (graphQLPrivacyOptionsContentEdge.m4828a()) {
                            graphQLPrivacyOption = graphQLPrivacyOptionsContentEdge.m4829j();
                        }
                        switch (graphQLPrivacyOptionsContentEdge.m4830k()) {
                            case FRIEND_LIST:
                                builder2.c(graphQLPrivacyOptionsContentEdge.m4829j());
                                break;
                            default:
                                builder.c(graphQLPrivacyOptionsContentEdge.m4829j());
                                break;
                        }
                    }
                } else {
                    m2326a("null_privacy_option_type_received");
                }
            } else {
                m2326a("null_privacy_option_received");
            }
        }
        List b = builder.b();
        List b2 = builder2.b();
        m2327a(b);
        m2327a(b2);
        if (graphQLPrivacyOption == null) {
            m2326a("invalid_selected_content_privacy_option_received");
            Preconditions.checkNotNull(graphQLPrivacyOption, "invalid_selected_content_privacy_option_received");
        }
        if (b.contains(graphQLPrivacyOption) || b2.contains(graphQLPrivacyOption)) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        return new ContentPrivacyOptionsResult(b, b2, graphQLPrivacyOption, z);
    }

    private PrivacyOptionsResult m2324a(GraphQLPrivacyOptionsComposerConnection graphQLPrivacyOptionsComposerConnection, boolean z) {
        GraphQLPrivacyOption graphQLPrivacyOption = null;
        Builder builder = ImmutableList.builder();
        Builder builder2 = ImmutableList.builder();
        if (graphQLPrivacyOptionsComposerConnection == null) {
            this.f2179a.b("null_privacy_option_edges", "null passed to PrivacyOptionsResultFactory.fromOptionEdges, returning empty result");
            throw new NullPointerException("null passed to fromOptionEdges");
        }
        boolean z2;
        ImmutableList a = graphQLPrivacyOptionsComposerConnection.m2244a();
        int size = a.size();
        GraphQLPrivacyOption graphQLPrivacyOption2 = null;
        for (int i = 0; i < size; i++) {
            GraphQLPrivacyOptionsComposerEdge graphQLPrivacyOptionsComposerEdge = (GraphQLPrivacyOptionsComposerEdge) a.get(i);
            if (graphQLPrivacyOptionsComposerEdge.m2253l() != null) {
                if (graphQLPrivacyOptionsComposerEdge.m2254m() != null && graphQLPrivacyOptionsComposerEdge.m2254m() != GraphQLPrivacyOptionInfoType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
                    if (m2330a(graphQLPrivacyOptionsComposerEdge.m2253l(), "composer")) {
                        if (graphQLPrivacyOptionsComposerEdge.m2250a()) {
                            graphQLPrivacyOption2 = graphQLPrivacyOptionsComposerEdge.m2253l();
                        }
                        if (graphQLPrivacyOptionsComposerEdge.m2251j()) {
                            graphQLPrivacyOption = graphQLPrivacyOptionsComposerEdge.m2253l();
                        }
                        switch (graphQLPrivacyOptionsComposerEdge.m2254m()) {
                            case FRIEND_LIST:
                                builder2.c(graphQLPrivacyOptionsComposerEdge.m2253l());
                                break;
                            default:
                                builder.c(graphQLPrivacyOptionsComposerEdge.m2253l());
                                break;
                        }
                    }
                } else {
                    m2326a("null_privacy_option_type_received");
                }
            } else {
                m2326a("null_privacy_option_received");
            }
        }
        List b = builder.b();
        List b2 = builder2.b();
        m2327a(b);
        m2327a(b2);
        if (graphQLPrivacyOption2 == null) {
            m2326a("invalid_selected_composer_privacy_option_received");
            Preconditions.checkNotNull(graphQLPrivacyOption2, "invalid_selected_composer_privacy_option_received");
        }
        if (b.contains(graphQLPrivacyOption2) || b2.contains(graphQLPrivacyOption2)) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        return new PrivacyOptionsResult(b, b2, graphQLPrivacyOption2, graphQLPrivacyOption, false, z);
    }

    public final PrivacyOptionsResult m2335a(PrivacyOptionsResult privacyOptionsResult) {
        ImmutableList immutableList;
        int size;
        int i;
        if (privacyOptionsResult.basicPrivacyOptions != null) {
            immutableList = privacyOptionsResult.basicPrivacyOptions;
            size = immutableList.size();
            for (i = 0; i < size; i++) {
                if (m2328a((GraphQLPrivacyOption) immutableList.get(i))) {
                    Object obj = 1;
                    break;
                }
            }
        }
        if (privacyOptionsResult.friendListPrivacyOptions != null) {
            immutableList = privacyOptionsResult.friendListPrivacyOptions;
            size = immutableList.size();
            for (i = 0; i < size; i++) {
                if (m2328a((GraphQLPrivacyOption) immutableList.get(i))) {
                    int i2 = 1;
                    break;
                }
            }
        }
        if (m2328a(privacyOptionsResult.selectedPrivacyOption) || m2328a(privacyOptionsResult.recentPrivacyOption)) {
            i2 = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            return privacyOptionsResult;
        }
        ImmutableList a = m2325a(privacyOptionsResult.basicPrivacyOptions, privacyOptionsResult.selectedPrivacyOption);
        ImmutableList a2 = m2325a(privacyOptionsResult.friendListPrivacyOptions, privacyOptionsResult.selectedPrivacyOption);
        GraphQLPrivacyOption a3 = m2323a(privacyOptionsResult.selectedPrivacyOption, privacyOptionsResult.selectedPrivacyOption);
        PrivacyOptionsResult privacyOptionsResult2 = new PrivacyOptionsResult(a, a2, null, m2323a(privacyOptionsResult.recentPrivacyOption, privacyOptionsResult.selectedPrivacyOption), privacyOptionsResult.isSelectedOptionExternal, false);
        this.f2179a.a("migrated_privacy_options", "Migrating privacy options as some are missing names.");
        return PrivacyOptionsResult.m2336a(privacyOptionsResult2).m2380a(a3).m2381b();
    }

    private ImmutableList<GraphQLPrivacyOption> m2325a(List<GraphQLPrivacyOption> list, GraphQLPrivacyOption graphQLPrivacyOption) {
        if (list == null) {
            return RegularImmutableList.a;
        }
        Builder builder = new Builder();
        for (GraphQLPrivacyOption a : list) {
            GraphQLPrivacyOption a2 = m2323a(a2, graphQLPrivacyOption);
            if (a2 != null) {
                builder.c(a2);
            }
        }
        return builder.b();
    }

    private GraphQLPrivacyOption m2323a(GraphQLPrivacyOption graphQLPrivacyOption, GraphQLPrivacyOption graphQLPrivacyOption2) {
        if (graphQLPrivacyOption == null) {
            return null;
        }
        GraphQLPrivacyOptionBuilder a = GraphQLPrivacyOptionBuilder.a(graphQLPrivacyOption);
        if (m2328a(graphQLPrivacyOption)) {
            String string;
            switch (PrivacyOptionHelper.m2343a((PrivacyOptionWithIconFields) graphQLPrivacyOption)) {
                case EVERYONE:
                    string = this.f2180b.getString(2131234192);
                    break;
                case FRIENDS_OF_FRIENDS:
                    string = this.f2180b.getString(2131234193);
                    break;
                case FRIENDS:
                    string = this.f2180b.getString(2131234195);
                    break;
                case ONLY_ME:
                    string = this.f2180b.getString(2131234198);
                    break;
                default:
                    if (!PrivacyOptionHelper.m2349a((PrivacyOptionFieldsForComposer) graphQLPrivacyOption, (PrivacyOptionFieldsForComposer) graphQLPrivacyOption2)) {
                        string = null;
                        break;
                    }
                    string = this.f2180b.getString(2131234199);
                    break;
            }
            String str = string;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            a.d(str);
        }
        return a.b();
    }

    public static boolean m2328a(GraphQLPrivacyOption graphQLPrivacyOption) {
        if (graphQLPrivacyOption == null) {
            return false;
        }
        return TextUtils.isEmpty(graphQLPrivacyOption.d());
    }
}
