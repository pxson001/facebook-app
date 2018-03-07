package com.facebook.feed.environment.impl;

import android.view.View;
import com.facebook.attachments.videos.ui.CanShowLiveCommentDialogFragment;
import com.facebook.attachments.videos.ui.InlineVideoAttachmentView;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.inject.InjectorLike;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: newsfeed */
public class CanShowVideoInFullScreenImpl implements CanShowVideoInFullScreen {
    private final Map<String, Pair> f12290a = new HashMap();

    public static CanShowVideoInFullScreenImpl m18310a(InjectorLike injectorLike) {
        return new CanShowVideoInFullScreenImpl();
    }

    public final void mo2433a(GraphQLStoryAttachment graphQLStoryAttachment, View view) {
        String d = m18311d(graphQLStoryAttachment);
        if (d != null && view != null) {
            this.f12290a.put(d, new Pair(graphQLStoryAttachment, view));
        }
    }

    public final void mo2432a(GraphQLStoryAttachment graphQLStoryAttachment) {
        String d = m18311d(graphQLStoryAttachment);
        if (d != null) {
            this.f12290a.remove(d);
        }
    }

    public final void mo2443b(GraphQLStoryAttachment graphQLStoryAttachment) {
        String d = m18311d(graphQLStoryAttachment);
        if (d != null) {
            Pair pair = (Pair) this.f12290a.get(d);
            if (pair != null && pair.b != null) {
                if (pair.b instanceof CanShowLiveCommentDialogFragment) {
                    ((CanShowLiveCommentDialogFragment) pair.b).setShowLiveCommentDialogFragment(true);
                }
                if (pair.b instanceof InlineVideoAttachmentView) {
                    boolean callOnClick = ((InlineVideoAttachmentView) pair.b).b.a.callOnClick();
                } else {
                    pair.b.callOnClick();
                }
            }
        }
    }

    public final boolean mo2447c(GraphQLStoryAttachment graphQLStoryAttachment) {
        if (graphQLStoryAttachment != null) {
            Object obj = (GraphQLStoryAttachmentUtil.m28055d(graphQLStoryAttachment) && graphQLStoryAttachment.m23979r() != null && graphQLStoryAttachment.m23979r().al()) ? 1 : null;
            if (obj != null && this.f12290a.containsKey(m18311d(graphQLStoryAttachment))) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    private static String m18311d(GraphQLStoryAttachment graphQLStoryAttachment) {
        if (graphQLStoryAttachment == null) {
            return null;
        }
        GraphQLMedia r = graphQLStoryAttachment.m23979r();
        if (r != null) {
            return r.m24452b();
        }
        return null;
    }
}
