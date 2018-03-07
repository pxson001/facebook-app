package com.facebook.feed.collage;

import android.view.WindowManager;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentStyleInfo;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import javax.inject.Inject;

/* compiled from: hideAttribution */
public class PhotoGridProperties {
    public final WindowManager f21091a;
    private final GraphQLImageHelper f21092b;

    /* compiled from: hideAttribution */
    class C08531 implements Predicate<GraphQLStoryAttachment> {
        final /* synthetic */ PhotoGridProperties f21575a;

        C08531(PhotoGridProperties photoGridProperties) {
            this.f21575a = photoGridProperties;
        }

        public boolean apply(Object obj) {
            GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) obj;
            return (graphQLStoryAttachment.m23979r() == null || PhotoGridProperties.m28824d(graphQLStoryAttachment) == 0 || PhotoGridProperties.m28825e(graphQLStoryAttachment) == 0) ? false : true;
        }
    }

    public static PhotoGridProperties m28823b(InjectorLike injectorLike) {
        return new PhotoGridProperties(WindowManagerMethodAutoProvider.m8708b(injectorLike), GraphQLImageHelper.m10139a(injectorLike));
    }

    @Inject
    public PhotoGridProperties(WindowManager windowManager, GraphQLImageHelper graphQLImageHelper) {
        this.f21091a = windowManager;
        this.f21092b = graphQLImageHelper;
    }

    public final int m28828a(GraphQLStoryAttachment graphQLStoryAttachment) {
        UnmodifiableIterator g = m28826g(graphQLStoryAttachment);
        int i = -1;
        while (g.hasNext()) {
            GraphQLStoryAttachment graphQLStoryAttachment2 = (GraphQLStoryAttachment) g.next();
            i = Math.max(i, m28822b(graphQLStoryAttachment2) + m28824d(graphQLStoryAttachment2));
        }
        return i > 0 ? i : 6;
    }

    public static PhotoGridProperties m28821a(InjectorLike injectorLike) {
        return m28823b(injectorLike);
    }

    public static int m28822b(GraphQLStoryAttachment graphQLStoryAttachment) {
        GraphQLStoryAttachmentStyleInfo a = GraphQLStoryAttachmentUtil.m28047a(graphQLStoryAttachment);
        return a != null ? a.m27614p() : 0;
    }

    public static int m28824d(GraphQLStoryAttachment graphQLStoryAttachment) {
        GraphQLStoryAttachmentStyleInfo a = GraphQLStoryAttachmentUtil.m28047a(graphQLStoryAttachment);
        return a != null ? a.m27613o() : 0;
    }

    public static int m28825e(GraphQLStoryAttachment graphQLStoryAttachment) {
        GraphQLStoryAttachmentStyleInfo a = GraphQLStoryAttachmentUtil.m28047a(graphQLStoryAttachment);
        return a != null ? a.m27612n() : 0;
    }

    public final boolean m28830f(GraphQLStoryAttachment graphQLStoryAttachment) {
        return m28827h(graphQLStoryAttachment);
    }

    private UnmodifiableIterator<GraphQLStoryAttachment> m28826g(GraphQLStoryAttachment graphQLStoryAttachment) {
        return Iterators.m1417b(graphQLStoryAttachment.m23985x().iterator(), new C08531(this));
    }

    public final ImmutableList<FeedProps<GraphQLStoryAttachment>> m28829a(FeedProps<GraphQLStoryAttachment> feedProps) {
        Builder builder = new Builder();
        UnmodifiableIterator g = m28826g((GraphQLStoryAttachment) feedProps.f13444a);
        while (g.hasNext()) {
            builder.m1069c(feedProps.m19803a((Flattenable) g.next()));
        }
        return builder.m1068b();
    }

    private boolean m28827h(GraphQLStoryAttachment graphQLStoryAttachment) {
        UnmodifiableIterator g = m28826g(graphQLStoryAttachment);
        int i = 0;
        while (g.hasNext() && i < 2) {
            i++;
            g.next();
        }
        if (i >= 2) {
            return true;
        }
        return false;
    }
}
