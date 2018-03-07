package com.facebook.photos.upload.compost;

import android.net.Uri;
import com.facebook.composer.publish.common.PendingStory;
import com.facebook.composer.publish.compost.story.CompostStory;
import com.facebook.composer.publish.compost.story.CompostStory.StoryType;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.google.common.base.Absent;
import com.google.common.base.Optional;

/* compiled from: graph_search_v2_typeahead_escape */
public class CompostPendingPost implements CompostStory {
    private PendingStory f13541a;
    public final StoryType f13542b;

    public CompostPendingPost(PendingStory pendingStory, StoryType storyType) {
        this.f13541a = pendingStory;
        this.f13542b = storyType;
    }

    public final GraphQLStory m21217a() {
        return this.f13541a.a();
    }

    public final int mo930b() {
        return StoryAttachmentHelper.e(m21217a());
    }

    public final String mo934f() {
        return this.f13541a.b.a.T();
    }

    public final long mo931c() {
        return this.f13541a.b.a.V() * 1000;
    }

    public final Optional<String> mo932d() {
        if (StoryHierarchyHelper.b(m21217a()) == null) {
            return Absent.INSTANCE;
        }
        return Optional.fromNullable(StoryHierarchyHelper.b(m21217a()).a());
    }

    public final Optional<Uri> mo933e() {
        GraphQLImage q = StoryAttachmentHelper.q(m21217a());
        if (q == null || q.b() == null) {
            return Absent.INSTANCE;
        }
        return Optional.of(Uri.parse(q.b()));
    }
}
