package com.facebook.redspace.model;

import android.text.TextUtils;
import com.facebook.redspace.model.RedSpaceSharedActivities.SharedActivity;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceStoriesQueryModel.RedspaceModel.ActivitiesModel.NodesModel;

/* compiled from: USER_CLICK_MEDIA */
public class LocationActivitySharing implements SharedActivity {
    public final String f21336a;
    public final String f21337b;
    public final String f21338c;

    public LocationActivitySharing(NodesModel nodesModel) {
        this.f21336a = nodesModel.n();
        if (nodesModel.j() == null || nodesModel.j().j() == null) {
            this.f21337b = null;
        } else {
            this.f21337b = nodesModel.j().j().a();
        }
        if (nodesModel.o() != null) {
            this.f21338c = nodesModel.o().a();
        } else {
            this.f21338c = null;
        }
    }

    public final boolean mo1161e() {
        return !TextUtils.isEmpty(this.f21336a);
    }
}
