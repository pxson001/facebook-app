package com.facebook.feedplugins.socialgood;

import android.text.TextUtils;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.graphql.model.GraphQLFundraiserCharity;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.google.common.base.Preconditions;

/* compiled from: bootstrap_updated */
public class SocialGoodFeedDataModelHelper {
    public static void m10019m(GraphQLStoryAttachment graphQLStoryAttachment) {
        Preconditions.checkNotNull(graphQLStoryAttachment);
        Preconditions.checkNotNull(graphQLStoryAttachment.z());
        Preconditions.checkNotNull(graphQLStoryAttachment.z().j());
    }

    private static int m10020n(GraphQLStoryAttachment graphQLStoryAttachment) {
        m10019m(graphQLStoryAttachment);
        return graphQLStoryAttachment.z().j().g();
    }

    public static int m10021o(GraphQLStoryAttachment graphQLStoryAttachment) {
        m10019m(graphQLStoryAttachment);
        Preconditions.checkNotNull(graphQLStoryAttachment.z().fa());
        Preconditions.checkNotNull(graphQLStoryAttachment.z().fa().b());
        return graphQLStoryAttachment.z().fa().b().g();
    }

    public static boolean m10022r(GraphQLStoryAttachment graphQLStoryAttachment) {
        return m10020n(graphQLStoryAttachment) == 1147287130;
    }

    public static boolean m10008a(GraphQLStoryAttachment graphQLStoryAttachment) {
        return m10020n(graphQLStoryAttachment) == -1315407331;
    }

    public static String m10009b(GraphQLStoryAttachment graphQLStoryAttachment) {
        boolean z = true;
        m10019m(graphQLStoryAttachment);
        if (m10022r(graphQLStoryAttachment)) {
            Preconditions.checkNotNull(graphQLStoryAttachment.z().au());
            if (TextUtils.isEmpty(graphQLStoryAttachment.z().au().u())) {
                z = false;
            }
            Preconditions.checkArgument(z);
            return graphQLStoryAttachment.z().au().u();
        } else if (!m10008a(graphQLStoryAttachment)) {
            return null;
        } else {
            if (TextUtils.isEmpty(graphQLStoryAttachment.z().dp())) {
                z = false;
            }
            Preconditions.checkArgument(z);
            return graphQLStoryAttachment.z().dp();
        }
    }

    public static String m10010c(GraphQLStoryAttachment graphQLStoryAttachment) {
        m10019m(graphQLStoryAttachment);
        if (m10022r(graphQLStoryAttachment)) {
            Preconditions.checkNotNull(graphQLStoryAttachment.z().au());
            Preconditions.checkNotNull(graphQLStoryAttachment.z().au().m());
            return graphQLStoryAttachment.z().au().m();
        } else if (!m10008a(graphQLStoryAttachment)) {
            return null;
        } else {
            Preconditions.checkNotNull(graphQLStoryAttachment.z().av());
            return graphQLStoryAttachment.z().av();
        }
    }

    public static GraphQLTextWithEntities m10011d(GraphQLStoryAttachment graphQLStoryAttachment) {
        boolean z = true;
        m10019m(graphQLStoryAttachment);
        if (m10022r(graphQLStoryAttachment)) {
            Preconditions.checkNotNull(graphQLStoryAttachment.z().au());
            Preconditions.checkNotNull(graphQLStoryAttachment.z().au().B());
            if (TextUtils.isEmpty(graphQLStoryAttachment.z().au().B().a())) {
                z = false;
            }
            Preconditions.checkArgument(z);
            return graphQLStoryAttachment.z().au().B();
        } else if (!m10008a(graphQLStoryAttachment)) {
            return null;
        } else {
            Preconditions.checkNotNull(graphQLStoryAttachment.z().cV());
            if (TextUtils.isEmpty(graphQLStoryAttachment.z().cV().a())) {
                z = false;
            }
            Preconditions.checkArgument(z);
            return graphQLStoryAttachment.z().cV();
        }
    }

    public static boolean m10012e(GraphQLStoryAttachment graphQLStoryAttachment) {
        m10019m(graphQLStoryAttachment);
        if (m10022r(graphQLStoryAttachment)) {
            Preconditions.checkNotNull(graphQLStoryAttachment.z().au());
            if (graphQLStoryAttachment.z().au().C() == null || graphQLStoryAttachment.z().au().C().k() == null) {
                return false;
            }
            return graphQLStoryAttachment.z().au().C().k().au();
        } else if (!m10008a(graphQLStoryAttachment) || graphQLStoryAttachment.z().jH() == null || graphQLStoryAttachment.z().jH().k() == null) {
            return false;
        } else {
            return graphQLStoryAttachment.z().jH().k().au();
        }
    }

    public static GraphQLImage m10013f(GraphQLStoryAttachment graphQLStoryAttachment) {
        m10019m(graphQLStoryAttachment);
        if (m10022r(graphQLStoryAttachment)) {
            Preconditions.checkNotNull(graphQLStoryAttachment.z().au());
            Preconditions.checkNotNull(graphQLStoryAttachment.z().au().w());
            return graphQLStoryAttachment.z().au().w();
        } else if (!m10008a(graphQLStoryAttachment)) {
            return null;
        } else {
            Preconditions.checkNotNull(graphQLStoryAttachment.z());
            Preconditions.checkNotNull(graphQLStoryAttachment.z().et());
            return graphQLStoryAttachment.z().et();
        }
    }

    public static GraphQLImage m10014g(GraphQLStoryAttachment graphQLStoryAttachment) {
        if (GraphQLStoryAttachmentUtil.m(graphQLStoryAttachment)) {
            return GraphQLStoryAttachmentUtil.n(graphQLStoryAttachment);
        }
        return null;
    }

    public static String m10015h(GraphQLStoryAttachment graphQLStoryAttachment) {
        m10019m(graphQLStoryAttachment);
        if (m10022r(graphQLStoryAttachment)) {
            Preconditions.checkNotNull(graphQLStoryAttachment.z().au());
            return graphQLStoryAttachment.z().au().l();
        } else if (m10008a(graphQLStoryAttachment)) {
            return graphQLStoryAttachment.z().jK();
        } else {
            return null;
        }
    }

    public static boolean m10016j(GraphQLStoryAttachment graphQLStoryAttachment) {
        m10019m(graphQLStoryAttachment);
        if (m10022r(graphQLStoryAttachment)) {
            Preconditions.checkNotNull(graphQLStoryAttachment.z().au());
            return graphQLStoryAttachment.z().au().t();
        } else if (m10008a(graphQLStoryAttachment)) {
            return graphQLStoryAttachment.z().jL();
        } else {
            return false;
        }
    }

    public static double m10017k(GraphQLStoryAttachment graphQLStoryAttachment) {
        m10019m(graphQLStoryAttachment);
        if (!m10016j(graphQLStoryAttachment)) {
            return 0.0d;
        }
        if (m10022r(graphQLStoryAttachment)) {
            Preconditions.checkNotNull(graphQLStoryAttachment.z().au());
            return graphQLStoryAttachment.z().au().z();
        } else if (m10008a(graphQLStoryAttachment)) {
            return graphQLStoryAttachment.z().jM();
        } else {
            return 0.0d;
        }
    }

    public static String m10018l(GraphQLStoryAttachment graphQLStoryAttachment) {
        m10019m(graphQLStoryAttachment);
        String str;
        if (m10022r(graphQLStoryAttachment)) {
            str = FBLinks.af;
            m10019m(graphQLStoryAttachment);
            Preconditions.checkNotNull(graphQLStoryAttachment.z().au());
            Preconditions.checkNotNull(graphQLStoryAttachment.z().au().C());
            GraphQLFundraiserCharity C = graphQLStoryAttachment.z().au().C();
            Preconditions.checkNotNull(C.k());
            GraphQLPage k = C.k();
            Preconditions.checkArgument(!TextUtils.isEmpty(k.ae()));
            return StringFormatUtil.formatStrLocaleSafe(str, k.ae());
        } else if (!m10008a(graphQLStoryAttachment)) {
            return null;
        } else {
            Object obj;
            Preconditions.checkNotNull(graphQLStoryAttachment.z().fa());
            Preconditions.checkArgument(!TextUtils.isEmpty(graphQLStoryAttachment.z().fa().H()));
            if (m10021o(graphQLStoryAttachment) == 2645995) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                str = FBLinks.aX;
            } else {
                if (m10021o(graphQLStoryAttachment) == 2479791) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    return null;
                }
                str = FBLinks.af;
            }
            return StringFormatUtil.formatStrLocaleSafe(str, graphQLStoryAttachment.z().fa().H());
        }
    }
}
