package com.facebook.feedplugins.socialgood;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: buildBranchName */
class FundraiserPageAttachmentBodyPartDefinition$2 implements OnClickListener {
    final /* synthetic */ GraphQLStoryAttachment f9432a;
    final /* synthetic */ String f9433b;
    final /* synthetic */ FundraiserPageAttachmentBodyPartDefinition f9434c;

    FundraiserPageAttachmentBodyPartDefinition$2(FundraiserPageAttachmentBodyPartDefinition fundraiserPageAttachmentBodyPartDefinition, GraphQLStoryAttachment graphQLStoryAttachment, String str) {
        this.f9434c = fundraiserPageAttachmentBodyPartDefinition;
        this.f9432a = graphQLStoryAttachment;
        this.f9433b = str;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 90464600);
        AnalyticsLogger analyticsLogger = this.f9434c.f;
        String b = SocialGoodFeedDataModelHelper.m10009b(this.f9432a);
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("tapped_donate_button");
        honeyClientEvent.c = "social_good";
        analyticsLogger.a(honeyClientEvent.b("fundraiser_campaign_id", b));
        this.f9434c.e.a(view.getContext(), this.f9433b, null);
        Logger.a(2, EntryType.UI_INPUT_END, 24949519, a);
    }
}
