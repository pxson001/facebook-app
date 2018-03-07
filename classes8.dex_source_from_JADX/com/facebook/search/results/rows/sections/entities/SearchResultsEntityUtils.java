package com.facebook.search.results.rows.sections.entities;

import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLGraphSearchResultDecoration;
import com.facebook.graphql.model.GraphQLGraphSearchResultsEdge;
import com.facebook.graphql.model.GraphQLGraphSearchSnippet;
import com.facebook.graphql.model.GraphQLGroupMembersConnection;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.GraphQLUser;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.inject.Lazy;
import com.facebook.search.results.protocol.SearchResultsEdgeInterfaces.SearchResultsEdge;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel;
import com.facebook.search.results.protocol.common.SearchResultsDecorationInterfaces.SearchResultsSnippet;
import com.facebook.search.results.protocol.common.SearchResultsDecorationModels.SearchResultsDecorationModel;
import com.facebook.search.results.protocol.common.SearchResultsDecorationModels.SearchResultsSnippetModel;
import com.facebook.search.results.protocol.common.SearchResultsDecorationModels.SearchResultsSnippetModel.SentenceModel;
import com.facebook.search.results.protocol.entity.SearchResultsGroupModels.SearchResultsGroupModel.VisibilitySentenceModel;
import com.facebook.search.results.protocol.entity.SearchResultsUserModels.SearchResultsUserModel.BioTextModel;
import com.facebook.search.util.TypeaheadRowTitleFormatter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

/* compiled from: QUERY_TOPIC_FEEDS_FAVORITES_KEY */
public class SearchResultsEntityUtils {
    @Deprecated
    @Nullable
    public static CharSequence m27759a(GraphQLNode graphQLNode) {
        return m27760a(graphQLNode, null);
    }

    @Deprecated
    @Nullable
    public static CharSequence m27760a(GraphQLNode graphQLNode, @Nullable String str) {
        GraphQLTextWithEntities ai;
        switch (m27768d(graphQLNode)) {
            case -1072845520:
                ImmutableList M = graphQLNode.M();
                if (M.isEmpty() || str == null) {
                    return null;
                }
                return TextUtils.join(str, M);
            case 2479791:
                if (graphQLNode.aZ().isEmpty()) {
                    return null;
                }
                return (String) graphQLNode.aZ().get(0);
            case 2645995:
                ai = graphQLNode.ai();
                if (ai != null) {
                    return ai.a();
                }
                return null;
            case 67338874:
                return graphQLNode.ip();
            case 69076575:
                ai = graphQLNode.jr();
                if (ai != null) {
                    return ai.a();
                }
                return null;
            case 514783620:
                ai = graphQLNode.hw();
                return ai != null ? ai.a() : null;
            default:
                return null;
        }
    }

    @Deprecated
    @Nullable
    public static CharSequence m27757a(GraphQLGraphSearchResultsEdge graphQLGraphSearchResultsEdge) {
        GraphQLNode j = graphQLGraphSearchResultsEdge.j();
        CharSequence a = j != null ? m27759a(j) : null;
        if (a != null) {
            return a;
        }
        ImmutableList d = m27769d(graphQLGraphSearchResultsEdge);
        return !d.isEmpty() ? m27758a((GraphQLGraphSearchSnippet) d.get(0)) : null;
    }

    @Nullable
    public static CharSequence m27761a(SearchResultsEdgeModel searchResultsEdgeModel) {
        CharSequence charSequence;
        NodeModel a = searchResultsEdgeModel.m9770a();
        if (a != null) {
            String str = null;
            switch (m27756a(a)) {
                case -1072845520:
                    ImmutableList jg_ = a.jg_();
                    if (!(jg_.isEmpty() || null == null)) {
                        str = TextUtils.join(null, jg_);
                        break;
                    }
                case 2479791:
                    if (!a.m9752m().isEmpty()) {
                        str = (String) a.m9752m().get(0);
                        break;
                    }
                    break;
                case 2645995:
                    BioTextModel g = a.m9748g();
                    if (g != null) {
                        str = g.m10105a();
                        break;
                    }
                    break;
                case 67338874:
                    str = a.as();
                    break;
                case 69076575:
                    VisibilitySentenceModel az = a.az();
                    if (az != null) {
                        str = az.m9943a();
                        break;
                    }
                    break;
            }
            charSequence = str;
        } else {
            charSequence = null;
        }
        if (charSequence != null) {
            return charSequence;
        }
        ImmutableList e = m27771e(searchResultsEdgeModel);
        return !e.isEmpty() ? m27762a((SearchResultsSnippetModel) e.get(0)) : null;
    }

    @Deprecated
    @Nullable
    public static CharSequence m27764b(GraphQLGraphSearchResultsEdge graphQLGraphSearchResultsEdge) {
        ImmutableList d = m27769d(graphQLGraphSearchResultsEdge);
        return d.size() > 1 ? m27758a((GraphQLGraphSearchSnippet) d.get(1)) : null;
    }

    @Deprecated
    @Nullable
    public static CharSequence m27765b(GraphQLNode graphQLNode) {
        String eP = graphQLNode.eP();
        CharSequence a = m27759a(graphQLNode);
        if (eP == null) {
            return a;
        }
        if (a == null) {
            return eP;
        }
        return eP + " " + a;
    }

    @Deprecated
    @Nullable
    public static CharSequence m27767c(GraphQLGraphSearchResultsEdge graphQLGraphSearchResultsEdge) {
        GraphQLNode j = graphQLGraphSearchResultsEdge.j();
        CharSequence eP = j != null ? j.eP() : null;
        CharSequence a = m27757a(graphQLGraphSearchResultsEdge);
        if (eP == null) {
            return a;
        }
        return a != null ? eP + " " + a : eP;
    }

    @Deprecated
    @Nullable
    public static Uri m27766c(GraphQLNode graphQLNode) {
        GraphQLImage S;
        if (m27773g(graphQLNode)) {
            GraphQLMedia em = graphQLNode.em();
            if (em != null) {
                S = em.S();
            } else {
                S = null;
            }
        } else {
            S = graphQLNode.gi();
        }
        if (S != null) {
            return ImageUtil.a(S);
        }
        return null;
    }

    @Deprecated
    public static int m27768d(GraphQLNode graphQLNode) {
        GraphQLObjectType j = graphQLNode.j();
        return j != null ? j.g() : 0;
    }

    public static int m27756a(NodeModel nodeModel) {
        GraphQLObjectType b = nodeModel.m9745b();
        return b != null ? b.g() : 0;
    }

    @Deprecated
    public static ImmutableList<GraphQLUser> m27770e(GraphQLNode graphQLNode) {
        GraphQLGroupMembersConnection dc = graphQLNode.dc();
        return dc != null ? dc.k() : RegularImmutableList.a;
    }

    @Deprecated
    @Nullable
    public static String m27772f(GraphQLNode graphQLNode) {
        GraphQLTextWithEntities hu = graphQLNode.hu();
        return hu != null ? hu.a() : null;
    }

    public static boolean m27773g(GraphQLNode graphQLNode) {
        GraphQLObjectType j = graphQLNode.j();
        return j != null && j.g() == 514783620;
    }

    public static CharSequence m27763a(boolean z, String str, Lazy<TypeaheadRowTitleFormatter> lazy) {
        if (str == null) {
            return null;
        }
        return z ? ((TypeaheadRowTitleFormatter) lazy.get()).m10671a(new SpannableStringBuilder(str)) : str;
    }

    @Deprecated
    @Nullable
    private static CharSequence m27758a(GraphQLGraphSearchSnippet graphQLGraphSearchSnippet) {
        GraphQLTextWithEntities j = graphQLGraphSearchSnippet.j();
        return j != null ? j.a() : null;
    }

    @Nullable
    public static CharSequence m27762a(SearchResultsSnippetModel searchResultsSnippetModel) {
        SentenceModel a = searchResultsSnippetModel.m9876a();
        return a != null ? a.m9870a() : null;
    }

    @Deprecated
    private static ImmutableList<GraphQLGraphSearchSnippet> m27769d(GraphQLGraphSearchResultsEdge graphQLGraphSearchResultsEdge) {
        GraphQLGraphSearchResultDecoration k = graphQLGraphSearchResultsEdge.k();
        return k != null ? k.n() : RegularImmutableList.a;
    }

    public static ImmutableList<? extends SearchResultsSnippet> m27771e(SearchResultsEdge searchResultsEdge) {
        SearchResultsDecorationModel b = searchResultsEdge.m9771b();
        return b != null ? b.m9861c() : RegularImmutableList.a;
    }
}
