package com.facebook.feedplugins.socialgood;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.socialgood.ipc.SocialGoodLogHelper;
import com.google.common.base.Strings;

/* compiled from: bridgeStartupType */
class FundraiserPageAttachmentHeaderPartDefinition$2 implements OnClickListener {
    final /* synthetic */ GraphQLStoryAttachment f9452a;
    final /* synthetic */ FundraiserPageAttachmentHeaderPartDefinition f9453b;

    FundraiserPageAttachmentHeaderPartDefinition$2(FundraiserPageAttachmentHeaderPartDefinition fundraiserPageAttachmentHeaderPartDefinition, GraphQLStoryAttachment graphQLStoryAttachment) {
        this.f9453b = fundraiserPageAttachmentHeaderPartDefinition;
        this.f9452a = graphQLStoryAttachment;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1354582124);
        this.f9453b.h.a(SocialGoodLogHelper.a(SocialGoodFeedDataModelHelper.m10009b(this.f9452a)));
        this.f9453b.d.a(view.getContext(), Strings.nullToEmpty(this.f9452a.C()), SocialGoodLogHelper.b());
        Logger.a(2, EntryType.UI_INPUT_END, -1195289641, a);
    }
}
