package com.facebook.composer.publish.compost.story;

import android.net.Uri;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import javax.annotation.Nullable;

/* compiled from: photo_upload_review */
public class CompostDraftStory implements CompostStory {
    private static final Predicate<GraphQLStoryAttachment> f8052a = new C04901();
    private final String f8053b;
    public final GraphQLStory f8054c;

    /* compiled from: photo_upload_review */
    final class C04901 implements Predicate<GraphQLStoryAttachment> {
        C04901() {
        }

        public final boolean apply(@Nullable Object obj) {
            return !GraphQLStoryAttachmentUtil.a((GraphQLStoryAttachment) obj, GraphQLStoryAttachmentStyle.PHOTO);
        }
    }

    private CompostDraftStory(String str, GraphQLStory graphQLStory) {
        this.f8054c = (GraphQLStory) Preconditions.checkNotNull(graphQLStory);
        Preconditions.checkArgument(this.f8054c.c() == null, "Cannot use GraphQLStory from server");
        this.f8053b = str;
    }

    public static CompostDraftStory m11618a(String str, GraphQLStory graphQLStory) {
        return new CompostDraftStory(str, graphQLStory);
    }

    public final GraphQLStory m11620a() {
        return this.f8054c;
    }

    public final int mo930b() {
        boolean z = true;
        ImmutableList M = this.f8054c.M();
        if (M == null || M.isEmpty()) {
            return 0;
        }
        boolean z2;
        Preconditions.checkState(M.size() == 1, "Only supports single or multi photo posts: " + m11619a(M));
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) M.get(0);
        if (GraphQLStoryAttachmentUtil.b(graphQLStoryAttachment) || GraphQLStoryAttachmentUtil.c(graphQLStoryAttachment)) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2, "Malformed attachment: " + m11619a(M));
        if (GraphQLStoryAttachmentUtil.a(graphQLStoryAttachment, GraphQLStoryAttachmentStyle.PHOTO)) {
            return 1;
        }
        if (!GraphQLStoryAttachmentUtil.a(graphQLStoryAttachment, GraphQLStoryAttachmentStyle.ALBUM)) {
            return 0;
        }
        ImmutableList x = graphQLStoryAttachment.x();
        if (Iterables.b(Iterables.c(x, f8052a)) != 0) {
            z = false;
        }
        Preconditions.checkState(z, "We have a malformed Multiphoto post GraphQL: " + m11619a(x));
        return x.size();
    }

    public final long mo931c() {
        long V = this.f8054c.V();
        Preconditions.checkState(V >= 0, "Please use a valid UNIX timestamp");
        return 1000 * V;
    }

    public final Optional<String> mo932d() {
        if (StoryHierarchyHelper.b(this.f8054c) == null) {
            return Absent.INSTANCE;
        }
        return Optional.fromNullable(StoryHierarchyHelper.b(this.f8054c).a());
    }

    public final Optional<Uri> mo933e() {
        GraphQLImage q = StoryAttachmentHelper.q(this.f8054c);
        if (q == null || q.b() == null) {
            return Absent.INSTANCE;
        }
        return Optional.of(Uri.parse(q.b()));
    }

    public final String mo934f() {
        return this.f8053b;
    }

    private static String m11619a(Iterable<GraphQLStoryAttachment> iterable) {
        StringBuilder stringBuilder = new StringBuilder();
        for (GraphQLStoryAttachment w : iterable) {
            stringBuilder.append(w.w().toString());
            stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }
}
