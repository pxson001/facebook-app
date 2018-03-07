package com.facebook.composer.publish.compost.story;

import android.net.Uri;
import com.facebook.composer.publish.compost.story.CompostStory.StoryType;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.google.common.base.Absent;
import com.google.common.base.Optional;

/* compiled from: photo_tag_friends */
public class RecentlyUploadedStory implements CompostStory {
    public final GraphQLStory f8057a;
    public final StoryType f8058b;

    /* compiled from: photo_tag_friends */
    public class Builder {
        public GraphQLStory f8055a;
        public StoryType f8056b;

        public Builder(GraphQLStory graphQLStory) {
            this.f8055a = graphQLStory;
        }
    }

    public RecentlyUploadedStory(Builder builder) {
        this.f8057a = builder.f8055a;
        this.f8058b = builder.f8056b;
    }

    public final GraphQLStory m11626a() {
        return this.f8057a;
    }

    public final int mo930b() {
        return StoryAttachmentHelper.e(this.f8057a);
    }

    public final long mo931c() {
        return this.f8057a.V() * 1000;
    }

    public final Optional<String> mo932d() {
        if (StoryHierarchyHelper.b(this.f8057a) == null) {
            return Absent.INSTANCE;
        }
        return Optional.fromNullable(StoryHierarchyHelper.b(this.f8057a).a());
    }

    public final Optional<Uri> mo933e() {
        GraphQLImage q = StoryAttachmentHelper.q(this.f8057a);
        if (q == null || q.b() == null) {
            return Absent.INSTANCE;
        }
        return Optional.of(Uri.parse(q.b()));
    }

    public final String mo934f() {
        return this.f8057a.c() != null ? this.f8057a.c() : this.f8057a.T();
    }

    public final String m11632g() {
        return this.f8057a.c();
    }
}
