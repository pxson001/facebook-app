package com.facebook.groupcommerce.util;

import android.content.Context;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.google.common.base.Strings;

/* compiled from: reaction_time_slices */
public class GroupCommercePartDefinitionHelper {
    public static String m6192a(Context context, GraphQLStoryAttachment graphQLStoryAttachment) {
        GraphQLNode z = graphQLStoryAttachment.z();
        String nullToEmpty = Strings.nullToEmpty(graphQLStoryAttachment.A());
        Integer num = null;
        if (z.dV()) {
            num = Integer.valueOf(2131237860);
        } else if (z.dM()) {
            num = Integer.valueOf(2131237861);
        }
        return num != null ? "(" + context.getResources().getString(num.intValue()) + ") " + nullToEmpty : nullToEmpty;
    }
}
