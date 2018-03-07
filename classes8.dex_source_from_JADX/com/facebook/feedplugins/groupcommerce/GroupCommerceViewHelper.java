package com.facebook.feedplugins.groupcommerce;

import android.content.Context;
import com.facebook.dracula.api.DraculaReturnValue;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;
import com.facebook.widget.text.BetterTextView;

/* compiled from: friendversary_collage */
public class GroupCommerceViewHelper {
    public static void m14582a(boolean z, BetterTextView betterTextView, Context context) {
        if (z) {
            betterTextView.setBackgroundResource(2130843331);
            betterTextView.setTextColor(context.getResources().getColor(2131361920));
            return;
        }
        betterTextView.setBackgroundResource(2130843330);
        betterTextView.setTextColor(context.getResources().getColor(2131363512));
    }

    public static boolean m14583a(FetchGroupInformationModel fetchGroupInformationModel) {
        DraculaReturnValue b = fetchGroupInformationModel.b();
        MutableFlatBuffer mutableFlatBuffer = b.a;
        int i = b.b;
        int i2 = b.c;
        return mutableFlatBuffer.f(i, 17, GraphQLGroupVisibility.class) == GraphQLGroupVisibility.OPEN || fetchGroupInformationModel.p() == GraphQLGroupJoinState.MEMBER;
    }
}
