package com.facebook.feed.util;

import android.os.Bundle;
import com.facebook.api.feed.DeleteStoryMethod.Params;
import com.facebook.api.feed.DeleteStoryMethod.Params.DeleteMode;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;

/* compiled from: Tag  */
public class DeleteStoryHelper {
    private final DefaultBlueServiceOperationFactory f22330a;

    public static DeleteStoryHelper m24934b(InjectorLike injectorLike) {
        return new DeleteStoryHelper(DefaultBlueServiceOperationFactory.b(injectorLike));
    }

    @Inject
    public DeleteStoryHelper(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory) {
        this.f22330a = defaultBlueServiceOperationFactory;
    }

    public final void m24936a(GraphQLStory graphQLStory, DeleteMode deleteMode) {
        m24935a(new Params(graphQLStory.ai(), Lists.a(new String[]{graphQLStory.g()}), graphQLStory.c(), deleteMode));
    }

    public final void m24935a(Params params) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("deleteStoryParams", params);
        BlueServiceOperationFactoryDetour.a(this.f22330a, "feed_delete_story", bundle, 2107818506).a();
    }

    public final boolean m24937a(GraphQLStory graphQLStory, String str) {
        if (graphQLStory == null) {
            return false;
        }
        List<GraphQLStoryAttachment> x = graphQLStory.x();
        if (x != null) {
            for (GraphQLStoryAttachment graphQLStoryAttachment : x) {
                if (graphQLStoryAttachment.r() != null && Objects.equal(graphQLStoryAttachment.r().b(), str)) {
                    return true;
                }
            }
        }
        x = StoryAttachmentHelper.i(graphQLStory);
        if (x != null) {
            for (GraphQLStoryAttachment graphQLStoryAttachment2 : x) {
                if (graphQLStoryAttachment2.r() != null && Objects.equal(graphQLStoryAttachment2.r().b(), str)) {
                    return true;
                }
            }
        }
        if (StoryHierarchyHelper.a(graphQLStory).j() != null) {
            ImmutableList j = StoryHierarchyHelper.a(graphQLStory).j();
            int size = j.size();
            for (int i = 0; i < size; i++) {
                if (m24937a((GraphQLStory) j.get(i), str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
