package com.facebook.graphql.linkutil;

import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLModels.GetFeedStoryAttachmentFbLinkGraphQLModel;
import com.facebook.infer.annotation.Strict;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: is_user_in_app */
public class GraphQLLinkExtractor {
    public static GraphQLLinkExtractor m26442a(InjectorLike injectorLike) {
        return new GraphQLLinkExtractor();
    }

    @Strict("Related to HighPri NPE #5736396")
    @Nullable
    public final String m26445a(@Nullable GraphQLObjectType graphQLObjectType, Object obj) {
        return m26447a(graphQLObjectType, obj, null);
    }

    @Strict("Related to HighPri NPE #5736396")
    @Nullable
    public final String m26447a(@Nullable GraphQLObjectType graphQLObjectType, Object... objArr) {
        if (graphQLObjectType == null) {
            return null;
        }
        return m26444a(graphQLObjectType.m22301g(), objArr);
    }

    @Strict("Related to HighPri NPE #5736396")
    @Nullable
    public static String m26444a(int i, Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        String str;
        switch (i) {
            case -1932766292:
                str = FBLinks.cz;
                break;
            case -1315407331:
                str = FBLinks.eW;
                break;
            case -1072845520:
                str = FBLinks.dd;
                break;
            case 2434066:
                str = FBLinks.aU;
                break;
            case 2479791:
                str = FBLinks.af;
                break;
            case 2645995:
                str = FBLinks.aX;
                break;
            case 63344207:
                str = FBLinks.aL;
                break;
            case 67338874:
                str = FBLinks.f2172t;
                break;
            case 69076575:
                str = FBLinks.f2173u;
                break;
            case 77090322:
                str = FBLinks.bk;
                break;
            case 80218325:
                str = FBLinks.cs;
                break;
            case 82650203:
                str = FBLinks.dH;
                break;
            case 105285582:
                str = FBLinks.aP;
                break;
            case 175920258:
                str = FBLinks.eA;
                break;
            case 236555388:
                str = FBLinks.cx;
                break;
            case 1607392245:
                str = FBLinks.fe;
                break;
            default:
                str = null;
                break;
        }
        if (str != null) {
            return StringFormatUtil.a(str, objArr);
        }
        return null;
    }

    @Strict("Related to HighPri NPE #5736396")
    @Nullable
    public final String m26446a(@Nullable GraphQLObjectType graphQLObjectType, String str, @Nullable String str2) {
        Uri parse;
        if (graphQLObjectType == null || !(graphQLObjectType.m22301g() == -245095862 || graphQLObjectType.m22301g() == 514783620 || graphQLObjectType.m22301g() == -1304042141)) {
            if (graphQLObjectType == null || (graphQLObjectType.m22301g() != 80218325 && graphQLObjectType.m22301g() != 82650203)) {
                return m26445a(graphQLObjectType, (Object) str);
            }
            if (Strings.isNullOrEmpty(str2)) {
                return null;
            }
            parse = Uri.parse(str2);
            return m26445a(graphQLObjectType, new Builder().path(parse.getPath()).query(parse.getQuery()).fragment(parse.getFragment()).toString());
        } else if (Strings.isNullOrEmpty(str2)) {
            return str2;
        } else {
            parse = Uri.parse(str2);
            return (!FacebookUriUtil.m20919c(parse) || FacebookUriUtil.m20916a(parse)) ? str2 : StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, Uri.encode(str2));
        }
    }

    private static Optional<String> m26443a(GraphQLLinkExtractorGraphQLInterfaces$GetRedirectionLinkGraphQL graphQLLinkExtractorGraphQLInterfaces$GetRedirectionLinkGraphQL) {
        if (graphQLLinkExtractorGraphQLInterfaces$GetRedirectionLinkGraphQL.mo3236k() == null || graphQLLinkExtractorGraphQLInterfaces$GetRedirectionLinkGraphQL.mo3236k().isEmpty() || ((C0890x64054611) graphQLLinkExtractorGraphQLInterfaces$GetRedirectionLinkGraphQL.mo3236k().get(0)).m29963a() == null) {
            return Absent.INSTANCE;
        }
        return Optional.of(StringFormatUtil.formatStrLocaleSafe(FBLinks.cw, Uri.encode(((C0890x64054611) graphQLLinkExtractorGraphQLInterfaces$GetRedirectionLinkGraphQL.mo3236k().get(0)).m29963a())));
    }

    @Nullable
    public final String m26448a(GraphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL graphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL) {
        Optional a = m26443a((GraphQLLinkExtractorGraphQLInterfaces$GetRedirectionLinkGraphQL) graphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL);
        if (a.isPresent()) {
            return (String) a.get();
        }
        if (graphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL.mo3202b() == null) {
            return null;
        }
        if (graphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL.mo3202b().m22301g() == 82650203) {
            return m26445a(graphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL.mo3202b(), graphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL.mo3203d());
        }
        if (graphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL.mo3202b().m22301g() == -1932766292) {
            if (Strings.isNullOrEmpty(graphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL.mo3234g())) {
                return null;
            }
            return m26447a(graphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL.mo3202b(), graphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL.mo3234g(), Strings.nullToEmpty(graphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL.C_()), Strings.nullToEmpty(graphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL.mo3203d()));
        } else if (graphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL.mo3202b().m22301g() == 105285582) {
            if (Strings.isNullOrEmpty(graphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL.mo3203d())) {
                return null;
            }
            return m26445a(graphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL.mo3202b(), graphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL.mo3203d());
        } else if (graphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL.mo3235j() != null && graphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL.mo3235j().mo3203d() != null) {
            return m26444a(2479791, graphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL.mo3235j().mo3203d());
        } else if (graphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL.mo3202b().m22301g() == 2479791) {
            return m26444a(2479791, graphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL.mo3203d());
        } else if (graphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL.mo3202b().m22301g() == 1607392245) {
            return m26444a(1607392245, graphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL.mo3203d(), graphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL.D_());
        } else if (graphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL.mo3202b().m22301g() != 2434066) {
            return m26446a(graphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL.mo3202b(), graphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL.mo3203d(), graphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL.D_());
        } else {
            return m26444a(2434066, graphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL.mo3203d(), graphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL.D_());
        }
    }

    @Strict("Related to HighPri NPE #5736396")
    @Nullable
    public final String m26449a(GetFeedStoryAttachmentFbLinkGraphQLModel getFeedStoryAttachmentFbLinkGraphQLModel) {
        if (getFeedStoryAttachmentFbLinkGraphQLModel == null) {
            return null;
        }
        if (getFeedStoryAttachmentFbLinkGraphQLModel.b() != null) {
            switch (getFeedStoryAttachmentFbLinkGraphQLModel.b().m22301g()) {
                case -1950597426:
                    if (getFeedStoryAttachmentFbLinkGraphQLModel.g() != null) {
                        return m26444a(2479791, getFeedStoryAttachmentFbLinkGraphQLModel.g().b());
                    }
                    break;
                case -1765744078:
                    if (getFeedStoryAttachmentFbLinkGraphQLModel.bY_() != null) {
                        return m26444a(2479791, getFeedStoryAttachmentFbLinkGraphQLModel.bY_().b());
                    }
                    break;
                case 1201268603:
                    if (getFeedStoryAttachmentFbLinkGraphQLModel.c() != null) {
                        return m26444a(2479791, getFeedStoryAttachmentFbLinkGraphQLModel.c().b());
                    }
                    break;
                case 1264055058:
                    if (getFeedStoryAttachmentFbLinkGraphQLModel.bZ_() != null) {
                        return m26444a(2479791, getFeedStoryAttachmentFbLinkGraphQLModel.bZ_().b());
                    }
                    break;
            }
        }
        Optional a = m26443a((GraphQLLinkExtractorGraphQLInterfaces$GetRedirectionLinkGraphQL) getFeedStoryAttachmentFbLinkGraphQLModel);
        if (a.isPresent()) {
            return (String) a.get();
        }
        return m26446a(getFeedStoryAttachmentFbLinkGraphQLModel.b(), getFeedStoryAttachmentFbLinkGraphQLModel.d(), getFeedStoryAttachmentFbLinkGraphQLModel.bX_());
    }
}
