package com.facebook.timeline.widget.actionbar.protocol;

import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeInterfaces.ComposerTargetDataPrivacyScopeFields;
import com.facebook.timeline.widget.actionbar.protocol.TimelineHeaderActionFieldsGraphQLModels.TimelineHeaderActionFieldsModel.FriendsModel;
import javax.annotation.Nullable;

/* compiled from: delete_app_only */
public class TimelineHeaderActionFieldsGraphQLInterfaces {

    /* compiled from: delete_app_only */
    public interface TimelineHeaderActionFields {
        boolean mo1330b();

        boolean mo1331c();

        boolean mo1332d();

        boolean do_();

        boolean dp_();

        @Nullable
        FriendsModel dq_();

        boolean mo1336g();

        @Nullable
        GraphQLFriendshipStatus mo1337j();

        boolean mo1338k();

        @Nullable
        ComposerTargetDataPrivacyScopeFields mo1339l();

        @Nullable
        GraphQLSecondarySubscribeStatus mo1340m();

        @Nullable
        GraphQLSubscribeStatus mo1341n();
    }
}
