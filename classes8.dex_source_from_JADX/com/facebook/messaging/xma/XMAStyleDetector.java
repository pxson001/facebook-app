package com.facebook.messaging.xma;

import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: time_to_scroll */
public class XMAStyleDetector {
    public static boolean m1748a(@Nullable XMAModel xMAModel, GraphQLStoryAttachmentStyle graphQLStoryAttachmentStyle) {
        if (xMAModel == null || xMAModel.l() == null) {
            return false;
        }
        ImmutableList aN_ = xMAModel.l().aN_();
        int size = aN_.size();
        for (int i = 0; i < size; i++) {
            if (graphQLStoryAttachmentStyle.equals((GraphQLStoryAttachmentStyle) aN_.get(i))) {
                return true;
            }
        }
        return false;
    }
}
