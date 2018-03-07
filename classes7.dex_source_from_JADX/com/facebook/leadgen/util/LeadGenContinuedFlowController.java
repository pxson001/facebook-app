package com.facebook.leadgen.util;

import android.view.View;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLLeadGenData;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.Assisted;
import com.facebook.leadgen.LeadGenLinkHandler;
import com.facebook.leadgen.LeadGenLinkHandlerProvider;
import com.facebook.leadgen.LeadGenLogger;
import com.facebook.leadgen.LeadGenPagerController;
import com.facebook.leadgen.LeadGenUtil;
import com.facebook.leadgen.data.LeadGenDataExtractor;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import javax.inject.Inject;
import org.json.JSONObject;

/* compiled from: photo_owner_id */
public class LeadGenContinuedFlowController {
    private LeadGenLinkHandlerProvider f6557a;
    private LeadGenLogger f6558b;
    public LeadGenPagerController f6559c;

    @Inject
    public LeadGenContinuedFlowController(LeadGenLinkHandlerProvider leadGenLinkHandlerProvider, LeadGenLogger leadGenLogger, @Assisted LeadGenPagerController leadGenPagerController) {
        this.f6557a = leadGenLinkHandlerProvider;
        this.f6558b = leadGenLogger;
        this.f6559c = leadGenPagerController;
    }

    public final void m8498a(LeadGenDataExtractor leadGenDataExtractor, String str, String str2, View view) {
        if (view != null) {
            TrackingNodes.a(view, TrackingNode.GENERIC_CALL_TO_ACTION_BUTTON);
            view.setTag(2131558543, "cta_lead_gen_visit_offsite_click");
            LeadGenLinkHandler a = this.f6557a.m8133a(leadGenDataExtractor.f6367c);
            GraphQLStoryAttachment graphQLStoryAttachment = leadGenDataExtractor.f6368d;
            boolean z = false;
            if (graphQLStoryAttachment != null) {
                GraphQLStoryActionLink a2 = ActionLinkHelper.a(graphQLStoryAttachment, 1185006756);
                if (a2 != null) {
                    GraphQLLeadGenData M = a2.M();
                    if (M != null) {
                        z = M.q();
                    }
                }
            }
            if (z) {
                a.f6295j = str;
            }
            LeadGenSplitFlowRequestMethodEnum fromValue = LeadGenSplitFlowRequestMethodEnum.fromValue(LeadGenUtil.a(leadGenDataExtractor.f6370f));
            if (fromValue == LeadGenSplitFlowRequestMethodEnum.POST) {
                a.f6295j = str;
            }
            if (fromValue == LeadGenSplitFlowRequestMethodEnum.AUTOFILL) {
                a.f6296k = "(function() {" + ("dict = " + new JSONObject(Maps.a(ImmutableMap.copyOf(this.f6559c.f6322e))).toString() + ";") + "  for (var key in dict) {    var elmt = document.getElementById(key) || " + "      document.getElementsByName(key)[0];    if (elmt) {" + "      elmt.value=dict[key];    }" + "  }})();";
            }
            this.f6558b.m8140a("cta_lead_gen_visit_offsite_click");
            a.m8132b(view, str2, true);
        }
    }
}
