package com.facebook.feedplugins.socialgood;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.socialgood.ipc.SocialGoodLogHelper;
import com.google.common.base.Strings;

/* compiled from: buildBranchName */
class FundraiserPageAttachmentBodyPartDefinition$3 implements OnClickListener {
    final /* synthetic */ GraphQLStoryAttachment f9435a;
    final /* synthetic */ FundraiserPageAttachmentBodyPartDefinition f9436b;

    FundraiserPageAttachmentBodyPartDefinition$3(FundraiserPageAttachmentBodyPartDefinition fundraiserPageAttachmentBodyPartDefinition, GraphQLStoryAttachment graphQLStoryAttachment) {
        this.f9436b = fundraiserPageAttachmentBodyPartDefinition;
        this.f9435a = graphQLStoryAttachment;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 635826244);
        this.f9436b.f.a(SocialGoodLogHelper.a(SocialGoodFeedDataModelHelper.m10009b(this.f9435a)));
        this.f9436b.e.a(view.getContext(), Strings.nullToEmpty(this.f9435a.C()), SocialGoodLogHelper.b());
        Logger.a(2, EntryType.UI_INPUT_END, 239578754, a);
    }
}
