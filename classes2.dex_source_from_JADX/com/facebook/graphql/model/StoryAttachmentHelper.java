package com.facebook.graphql.model;

import android.net.Uri;
import com.facebook.common.util.UriUtil;
import com.facebook.graphql.enums.GraphQLStoryActionLinkDestinationType;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: images/places/map/map_pin.png */
public class StoryAttachmentHelper {
    private StoryAttachmentHelper() {
    }

    public static boolean m28029a(GraphQLStory graphQLStory) {
        ImmutableList M = graphQLStory.m22327M();
        return (M == null || M.isEmpty()) ? false : true;
    }

    public static boolean m28030b(GraphQLStory graphQLStory) {
        ImmutableList M = graphQLStory.m22327M();
        if (M == null || M.isEmpty()) {
            return false;
        }
        int size = M.size();
        for (int i = 0; i < size; i++) {
            if (GraphQLStoryAttachmentUtil.m28053b((GraphQLStoryAttachment) M.get(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean m28032c(GraphQLStory graphQLStory) {
        ImmutableList M = graphQLStory.m22327M();
        if (M == null || M.size() != 1 || ((GraphQLStoryAttachment) M.get(0)).m23979r() == null) {
            return false;
        }
        return m28030b(graphQLStory);
    }

    public static int m28033e(GraphQLStory graphQLStory) {
        if (!m28030b(graphQLStory)) {
            return 0;
        }
        if (m28032c(graphQLStory)) {
            return 1;
        }
        if (graphQLStory.m22327M() != null) {
            ImmutableList M = graphQLStory.m22327M();
            int size = M.size();
            for (int i = 0; i < size; i++) {
                GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) M.get(i);
                if (GraphQLStoryAttachmentUtil.m28049a(graphQLStoryAttachment, GraphQLStoryAttachmentStyle.ALBUM) && graphQLStoryAttachment.m23985x() != null) {
                    return graphQLStoryAttachment.m23985x().size();
                }
            }
        }
        return 0;
    }

    public static boolean m28034g(GraphQLStory graphQLStory) {
        ImmutableList M = graphQLStory.m22327M();
        if (!(M == null || M.isEmpty())) {
            ImmutableList M2 = graphQLStory.m22327M();
            int size = M2.size();
            for (int i = 0; i < size; i++) {
                if (GraphQLStoryAttachmentUtil.m28059j((GraphQLStoryAttachment) M2.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean m28035h(GraphQLStory graphQLStory) {
        GraphQLStoryAttachment o = m28042o(graphQLStory);
        return (o == null || o.m23985x() == null || o.m23985x().isEmpty()) ? false : true;
    }

    @Nullable
    public static List<GraphQLStoryAttachment> m28036i(GraphQLStory graphQLStory) {
        if (m28035h(graphQLStory)) {
            return m28042o(graphQLStory).m23985x();
        }
        return null;
    }

    public static boolean m28037j(GraphQLStory graphQLStory) {
        ImmutableList M = graphQLStory.m22327M();
        if (M == null) {
            return false;
        }
        int size = M.size();
        for (int i = 0; i < size; i++) {
            if (GraphQLStoryAttachmentUtil.m28055d((GraphQLStoryAttachment) M.get(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean m28038k(GraphQLStory graphQLStory) {
        ImmutableList M = graphQLStory.m22327M();
        if (M == null) {
            return false;
        }
        int size = M.size();
        for (int i = 0; i < size; i++) {
            if (m28031b((GraphQLStoryAttachment) M.get(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean m28039l(GraphQLStory graphQLStory) {
        ImmutableList M = graphQLStory.m22327M();
        if (M == null) {
            return false;
        }
        int size = M.size();
        for (int i = 0; i < size; i++) {
            ImmutableList x = ((GraphQLStoryAttachment) M.get(i)).m23985x();
            if (!(x == null || x.isEmpty())) {
                int size2 = x.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    if (GraphQLStoryAttachmentUtil.m28055d((GraphQLStoryAttachment) x.get(i2))) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    public static boolean m28040m(GraphQLStory graphQLStory) {
        if (!m28029a(graphQLStory)) {
            return false;
        }
        ImmutableList M = graphQLStory.m22327M();
        int size = M.size();
        for (int i = 0; i < size; i++) {
            if (GraphQLStoryAttachmentUtil.m28049a((GraphQLStoryAttachment) M.get(i), GraphQLStoryAttachmentStyle.SLIDESHOW)) {
                return true;
            }
        }
        return false;
    }

    public static boolean m28041n(GraphQLStory graphQLStory) {
        ImmutableList M = graphQLStory.m22327M();
        if (M == null) {
            return false;
        }
        int size = M.size();
        for (int i = 0; i < size; i++) {
            ImmutableList x = ((GraphQLStoryAttachment) M.get(i)).m23985x();
            if (!(x == null || x.isEmpty())) {
                int size2 = x.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    if (m28031b((GraphQLStoryAttachment) x.get(i2))) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    @Nullable
    public static GraphQLStoryAttachment m28042o(GraphQLStory graphQLStory) {
        ImmutableList M = graphQLStory.m22327M();
        return (M == null || M.isEmpty()) ? null : (GraphQLStoryAttachment) M.get(0);
    }

    @Nullable
    public static GraphQLStoryAttachment m28043p(GraphQLStory graphQLStory) {
        for (GraphQLStoryAttachment graphQLStoryAttachment : graphQLStory.m22367x()) {
            if (ActionLinkHelper.m22939b(graphQLStoryAttachment, -1134846932)) {
                return graphQLStoryAttachment;
            }
            if (ActionLinkHelper.m22939b(graphQLStoryAttachment, 411361907)) {
                return graphQLStoryAttachment;
            }
        }
        return null;
    }

    @Nullable
    public static GraphQLImage m28044q(GraphQLStory graphQLStory) {
        ImmutableList M = graphQLStory.m22327M();
        if (M == null) {
            return null;
        }
        int size = M.size();
        for (int i = 0; i < size; i++) {
            GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) M.get(i);
            if (graphQLStoryAttachment != null) {
                if (graphQLStoryAttachment.m23979r() != null && graphQLStoryAttachment.m23979r().m24440S() != null) {
                    return GraphQLStoryAttachmentUtil.m28061l(graphQLStoryAttachment);
                }
                if (GraphQLStoryAttachmentUtil.m28049a(graphQLStoryAttachment, GraphQLStoryAttachmentStyle.ALBUM)) {
                    ImmutableList x = graphQLStoryAttachment.m23985x();
                    if (!(x == null || x.isEmpty() || ((GraphQLStoryAttachment) x.get(0)).m23979r() == null || ((GraphQLStoryAttachment) x.get(0)).m23979r().m24440S() == null)) {
                        return GraphQLStoryAttachmentUtil.m28061l((GraphQLStoryAttachment) x.get(0));
                    }
                }
                continue;
            }
        }
        return null;
    }

    @Nullable
    public static GraphQLActor m28045r(GraphQLStory graphQLStory) {
        GraphQLStoryAttachment o = m28042o(graphQLStory);
        return o != null ? m28028a(o) : null;
    }

    @Nullable
    public static GraphQLActor m28028a(GraphQLStoryAttachment graphQLStoryAttachment) {
        GraphQLMedia r = graphQLStoryAttachment.m23979r();
        return r != null ? r.aF() : null;
    }

    private static boolean m28031b(GraphQLStoryAttachment graphQLStoryAttachment) {
        if (graphQLStoryAttachment == null || graphQLStoryAttachment.m23979r() == null || graphQLStoryAttachment.m23979r().aO() == null) {
            return false;
        }
        Uri parse = Uri.parse(graphQLStoryAttachment.m23979r().aO());
        if ((UriUtil.m18789b(parse) || UriUtil.m18790c(parse)) && GraphQLStoryAttachmentUtil.m28055d(graphQLStoryAttachment)) {
            return true;
        }
        return false;
    }

    public static boolean m28046s(GraphQLStory graphQLStory) {
        GraphQLStoryActionLink e = StoryActionLinkHelper.m28078e(graphQLStory);
        return e != null && (e.m22916u() == GraphQLStoryActionLinkDestinationType.APP || e.m22916u() == GraphQLStoryActionLinkDestinationType.APP_WITH_PRODUCT);
    }
}
