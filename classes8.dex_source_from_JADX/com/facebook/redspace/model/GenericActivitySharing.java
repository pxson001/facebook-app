package com.facebook.redspace.model;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLModels.LinkableTextWithEntitiesModel;
import com.facebook.redspace.model.RedSpaceSharedActivities.SharedActivity;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceStoriesQueryModel.RedspaceModel.ActivitiesModel.NodesModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceStoriesQueryModel.RedspaceModel.ActivitiesModel.NodesModel.IconModel;

/* compiled from: USER_CONTROLLER_PAUSED */
public class GenericActivitySharing implements SharedActivity {
    public final LinkableTextWithEntitiesModel f21332a;
    private final IconModel f21333b;
    @ColorInt
    public final int f21334c;
    public final String f21335d;

    public GenericActivitySharing(NodesModel nodesModel) {
        this.f21333b = nodesModel.l();
        this.f21332a = nodesModel.m();
        this.f21335d = nodesModel.p();
        this.f21334c = m24955a(nodesModel.k());
    }

    public final boolean mo1161e() {
        return (this.f21332a == null || m24956d() == null) ? false : true;
    }

    @ColorInt
    private static int m24955a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!str.startsWith("#")) {
                str = "#" + str;
            }
            try {
                return Color.parseColor(str);
            } catch (Exception e) {
            }
        }
        return 0;
    }

    @Nullable
    public final String m24956d() {
        if (this.f21333b == null) {
            return null;
        }
        return this.f21333b.a();
    }
}
