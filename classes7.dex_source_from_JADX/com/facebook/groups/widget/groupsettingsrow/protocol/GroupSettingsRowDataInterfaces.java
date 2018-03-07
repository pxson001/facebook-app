package com.facebook.groups.widget.groupsettingsrow.protocol;

import com.facebook.graphql.enums.GraphQLGroupAdminType;
import com.facebook.graphql.enums.GraphQLGroupPushSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupRequestToJoinSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupSubscriptionLevel;
import com.facebook.groups.widget.groupsettingsrow.protocol.GroupSettingsRowDataModels.GroupSubscriptionDataModel.PossiblePushSubscriptionLevelsModel;
import com.facebook.groups.widget.groupsettingsrow.protocol.GroupSettingsRowDataModels.GroupSubscriptionDataModel.PossibleSubscriptionLevelsModel;
import javax.annotation.Nullable;

/* compiled from: profile_pic_uri */
public class GroupSettingsRowDataInterfaces {

    /* compiled from: profile_pic_uri */
    public interface GroupSubscriptionData {
        @Nullable
        String mo324b();

        @Nullable
        PossiblePushSubscriptionLevelsModel mo325c();

        @Nullable
        PossibleSubscriptionLevelsModel mo326d();

        @Nullable
        GraphQLGroupRequestToJoinSubscriptionLevel mo327g();

        @Nullable
        GraphQLGroupPushSubscriptionLevel hc_();

        @Nullable
        GraphQLGroupSubscriptionLevel hd_();

        @Nullable
        GraphQLGroupAdminType mo330n();
    }

    public interface GroupSettingsRowData extends GroupSubscriptionData {
    }
}
