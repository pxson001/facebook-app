package com.facebook.groups.events;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;

/* compiled from: UPLOAD_GROUP_FILE_HANDLE */
public class GroupEventUpdateRsvpMenuHelper {
    private static final String f21787a = GroupEventUpdateRsvpMenuHelper.class.getName();
    private static final List<GraphQLEventGuestStatus> f21788b = Arrays.asList(new GraphQLEventGuestStatus[]{GraphQLEventGuestStatus.GOING, GraphQLEventGuestStatus.MAYBE, GraphQLEventGuestStatus.NOT_GOING});
    private AbstractFbErrorReporter f21789c;

    @Inject
    public GroupEventUpdateRsvpMenuHelper(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f21789c = abstractFbErrorReporter;
    }
}
