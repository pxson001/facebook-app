package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: images/places/map/bright-pink-pin-2x.png */
public class GraphQLStoryAttachmentUtil {
    public static boolean m28049a(@Nullable GraphQLStoryAttachment graphQLStoryAttachment, GraphQLStoryAttachmentStyle graphQLStoryAttachmentStyle) {
        if (graphQLStoryAttachment == null) {
            return false;
        }
        return m28052a(graphQLStoryAttachment.m23984w(), graphQLStoryAttachmentStyle);
    }

    public static boolean m28052a(@Nullable ImmutableList<GraphQLStoryAttachmentStyle> immutableList, GraphQLStoryAttachmentStyle graphQLStoryAttachmentStyle) {
        if (immutableList == null) {
            return false;
        }
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            if (((GraphQLStoryAttachmentStyle) immutableList.get(i)) == graphQLStoryAttachmentStyle) {
                return true;
            }
        }
        return false;
    }

    public static boolean m28050a(@Nullable GraphQLStoryAttachment graphQLStoryAttachment, GraphQLStoryAttachmentStyle graphQLStoryAttachmentStyle, GraphQLStoryAttachmentStyle graphQLStoryAttachmentStyle2) {
        if (graphQLStoryAttachment == null) {
            return false;
        }
        ImmutableList w = graphQLStoryAttachment.m23984w();
        int size = w.size();
        for (int i = 0; i < size; i++) {
            GraphQLStoryAttachmentStyle graphQLStoryAttachmentStyle3 = (GraphQLStoryAttachmentStyle) w.get(i);
            if (graphQLStoryAttachmentStyle3 == graphQLStoryAttachmentStyle || graphQLStoryAttachmentStyle3 == graphQLStoryAttachmentStyle2) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static GraphQLStoryAttachmentStyleInfo m28047a(GraphQLStoryAttachment graphQLStoryAttachment) {
        ImmutableList v = graphQLStoryAttachment.m23983v();
        if (v.size() == 0) {
            return null;
        }
        return (GraphQLStoryAttachmentStyleInfo) v.get(0);
    }

    @Nullable
    public static GraphQLStoryAttachmentStyleInfo m28048a(GraphQLStoryAttachment graphQLStoryAttachment, int i) {
        if (graphQLStoryAttachment == null || graphQLStoryAttachment.m23983v() == null) {
            return null;
        }
        ImmutableList v = graphQLStoryAttachment.m23983v();
        int size = v.size();
        for (int i2 = 0; i2 < size; i2++) {
            GraphQLStoryAttachmentStyleInfo graphQLStoryAttachmentStyleInfo = (GraphQLStoryAttachmentStyleInfo) v.get(i2);
            if (graphQLStoryAttachmentStyleInfo.m27605a() != null && graphQLStoryAttachmentStyleInfo.m27605a().m22301g() == i) {
                return graphQLStoryAttachmentStyleInfo;
            }
        }
        return null;
    }

    public static boolean m28053b(GraphQLStoryAttachment graphQLStoryAttachment) {
        return m28050a(graphQLStoryAttachment, GraphQLStoryAttachmentStyle.PHOTO, GraphQLStoryAttachmentStyle.ALBUM);
    }

    public static boolean m28054c(GraphQLStoryAttachment graphQLStoryAttachment) {
        return m28050a(graphQLStoryAttachment, GraphQLStoryAttachmentStyle.SHARE, GraphQLStoryAttachmentStyle.SHARE_LARGE_IMAGE);
    }

    public static boolean m28055d(GraphQLStoryAttachment graphQLStoryAttachment) {
        return m28049a(graphQLStoryAttachment, GraphQLStoryAttachmentStyle.VIDEO);
    }

    public static boolean m28056f(GraphQLStoryAttachment graphQLStoryAttachment) {
        return m28049a(graphQLStoryAttachment, GraphQLStoryAttachmentStyle.LIFE_EVENT);
    }

    public static boolean m28057g(GraphQLStoryAttachment graphQLStoryAttachment) {
        return m28049a(graphQLStoryAttachment, GraphQLStoryAttachmentStyle.GROUP_SELL_PRODUCT_ITEM);
    }

    public static boolean m28058i(GraphQLStoryAttachment graphQLStoryAttachment) {
        return m28049a(graphQLStoryAttachment, GraphQLStoryAttachmentStyle.ANIMATED_IMAGE_VIDEO);
    }

    public static boolean m28059j(GraphQLStoryAttachment graphQLStoryAttachment) {
        return (graphQLStoryAttachment.m23966C() == null || graphQLStoryAttachment.m23987z() == null || graphQLStoryAttachment.m23987z().m23390j() == null || !Objects.equal(Integer.valueOf(514783620), Integer.valueOf(graphQLStoryAttachment.m23987z().m23390j().m22301g()))) ? false : true;
    }

    public static boolean m28060k(GraphQLStoryAttachment graphQLStoryAttachment) {
        return (graphQLStoryAttachment.m23966C() == null || graphQLStoryAttachment.m23987z() == null || graphQLStoryAttachment.m23987z().m23390j() == null || !Objects.equal(Integer.valueOf(2479791), Integer.valueOf(graphQLStoryAttachment.m23987z().m23390j().m22301g()))) ? false : true;
    }

    public static GraphQLImage m28061l(GraphQLStoryAttachment graphQLStoryAttachment) {
        if (graphQLStoryAttachment.m23979r() == null || graphQLStoryAttachment.m23979r().m24440S() == null) {
            return null;
        }
        return graphQLStoryAttachment.m23979r().m24440S();
    }

    public static boolean m28062m(GraphQLStoryAttachment graphQLStoryAttachment) {
        return (graphQLStoryAttachment.m23979r() == null || graphQLStoryAttachment.m23979r().m24444W() == null) ? false : true;
    }

    public static GraphQLImage m28063n(GraphQLStoryAttachment graphQLStoryAttachment) {
        if (graphQLStoryAttachment.m23979r() != null) {
            return graphQLStoryAttachment.m23979r().m24444W();
        }
        return null;
    }

    public static boolean m28051a(GraphQLStoryAttachment graphQLStoryAttachment, List<GraphQLStoryAttachmentStyle> list) {
        for (GraphQLStoryAttachmentStyle contains : list) {
            if (graphQLStoryAttachment.m23984w().contains(contains)) {
                return true;
            }
        }
        return false;
    }

    public static String m28064o(GraphQLStoryAttachment graphQLStoryAttachment) {
        return (graphQLStoryAttachment.m23979r() == null || graphQLStoryAttachment.m23979r().m24440S() == null || graphQLStoryAttachment.m23979r().m24440S().mo2924b() == null) ? "" : graphQLStoryAttachment.m23979r().m24440S().mo2924b();
    }

    public static boolean m28065p(GraphQLStoryAttachment graphQLStoryAttachment) {
        return (graphQLStoryAttachment.m23979r() == null || graphQLStoryAttachment.m23979r().m24453j() == null || graphQLStoryAttachment.m23979r().m24453j().m22301g() != 82650203) ? false : true;
    }

    public static boolean m28066q(GraphQLStoryAttachment graphQLStoryAttachment) {
        return graphQLStoryAttachment.m23987z() != null && graphQLStoryAttachment.m23987z().cU() == GraphQLFriendshipStatus.OUTGOING_REQUEST;
    }

    public static GraphQLTextWithEntities m28067r(GraphQLStoryAttachment graphQLStoryAttachment) {
        if (graphQLStoryAttachment.m23982u() != null) {
            return graphQLStoryAttachment.m23982u();
        }
        return graphQLStoryAttachment.m23975n();
    }

    public static String m28068s(GraphQLStoryAttachment graphQLStoryAttachment) {
        return m28067r(graphQLStoryAttachment) != null ? Strings.nullToEmpty(m28067r(graphQLStoryAttachment).mo2911a()) : "";
    }

    @Nullable
    public static String m28069t(GraphQLStoryAttachment graphQLStoryAttachment) {
        if (graphQLStoryAttachment == null || graphQLStoryAttachment.m23987z() == null || graphQLStoryAttachment.m23987z().dB() == null) {
            return null;
        }
        return graphQLStoryAttachment.m23987z().dB().m23349m();
    }
}
