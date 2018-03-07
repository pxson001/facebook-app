package com.facebook.feedplugins.socialgood;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.socialgood.ipc.SocialGoodLogHelper;
import com.google.common.base.Strings;

/* compiled from: box-only */
class FundraiserPersonToCharityAttachmentFacepilePartDefinition$1 implements OnClickListener {
    final /* synthetic */ GraphQLStoryAttachment f9466a;
    final /* synthetic */ FundraiserPersonToCharityAttachmentFacepilePartDefinition f9467b;

    FundraiserPersonToCharityAttachmentFacepilePartDefinition$1(FundraiserPersonToCharityAttachmentFacepilePartDefinition fundraiserPersonToCharityAttachmentFacepilePartDefinition, GraphQLStoryAttachment graphQLStoryAttachment) {
        this.f9467b = fundraiserPersonToCharityAttachmentFacepilePartDefinition;
        this.f9466a = graphQLStoryAttachment;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1401581628);
        this.f9467b.h.a(SocialGoodLogHelper.a(this.f9466a.z().dp()));
        this.f9467b.g.a(view.getContext(), Strings.nullToEmpty(this.f9466a.C()), SocialGoodLogHelper.b());
        Logger.a(2, EntryType.UI_INPUT_END, 228855226, a);
    }
}
