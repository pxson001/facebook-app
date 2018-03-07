package com.facebook.groups.react;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLLikersOfContentConnection;
import com.facebook.graphql.model.GraphQLReactorsOfContentConnection;
import com.facebook.graphql.model.GraphQLSeenByConnection;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLTopLevelCommentsConnection;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.StoryTextHelper;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

/* compiled from: payment_pin_id */
public class GroupsReactCacheUtil {
    public static Bundle m7314a(GraphQLStory graphQLStory) {
        String nullToEmpty;
        int i = 0;
        Bundle bundle = new Bundle();
        bundle.putString("id", graphQLStory.c());
        if (!(graphQLStory.M() == null || graphQLStory.M().isEmpty())) {
            bundle.putBoolean("hasOptimisticAttachments", true);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("text", StoryTextHelper.a(graphQLStory));
        bundle.putBundle("message", bundle2);
        Bundle bundle3 = new Bundle();
        if (graphQLStory.aI() != null) {
            nullToEmpty = Strings.nullToEmpty(graphQLStory.aI().a());
        } else {
            nullToEmpty = "";
        }
        String str = nullToEmpty;
        if (str.isEmpty() && graphQLStory.aH() != null) {
            str = graphQLStory.aH().a();
        }
        bundle3.putString("text", str);
        bundle.putBundle("title", bundle3);
        GraphQLFeedback l = graphQLStory.l();
        if (l != null) {
            Bundle bundle4;
            bundle3 = new Bundle();
            bundle3.putString("id", l.z_());
            bundle3.putBoolean("does_viewer_like", l.y_());
            bundle3.putBoolean("can_viewer_comment", l.c());
            bundle3.putString("legacy_api_post_id", l.j());
            bundle3.putBoolean("can_viewer_like", false);
            bundle3.putBoolean("can_viewer_react", false);
            GraphQLLikersOfContentConnection C = l.C();
            if (C != null) {
                bundle4 = new Bundle();
                bundle4.putInt("count", C.a());
                bundle3.putBundle("likers", bundle4);
            }
            GraphQLReactorsOfContentConnection E = l.E();
            if (E != null) {
                bundle4 = new Bundle();
                bundle4.putInt("count", E.a());
                bundle3.putBundle("reactors", bundle4);
            }
            GraphQLSeenByConnection I = l.I();
            if (I != null) {
                bundle4 = new Bundle();
                bundle4.putInt("count", I.a());
                bundle3.putBundle("seen_by", bundle4);
            }
            GraphQLTopLevelCommentsConnection L = l.L();
            if (L != null) {
                Bundle bundle5 = new Bundle();
                bundle5.putInt("count", L.a());
                bundle3.putBundle("top_level_comments", bundle5);
            }
            bundle.putBundle("feedback", bundle3);
        }
        if (StoryAttachmentHelper.q(graphQLStory) != null) {
            bundle2 = new Bundle();
            bundle3 = new Bundle();
            bundle5 = new Bundle();
            bundle5.putString("uri", StoryAttachmentHelper.q(graphQLStory).b());
            bundle3.putBundle("photo_large", bundle5);
            bundle2.putBundle("media", bundle3);
            bundle.putParcelableArray("attachments", new Bundle[]{bundle2});
        }
        ImmutableList b = graphQLStory.b();
        if (b != null) {
            int size = b.size();
            Parcelable[] parcelableArr = new Bundle[size];
            while (i < size) {
                GraphQLActor graphQLActor = (GraphQLActor) b.get(i);
                Bundle bundle6 = new Bundle();
                bundle6.putString("id", graphQLActor.H());
                bundle6.putString("name", graphQLActor.aa());
                parcelableArr[i] = bundle6;
                i++;
            }
            bundle.putParcelableArray("actors", parcelableArr);
        }
        return bundle;
    }
}
