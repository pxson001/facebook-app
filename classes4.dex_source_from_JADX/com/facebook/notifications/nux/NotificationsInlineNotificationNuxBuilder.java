package com.facebook.notifications.nux;

import android.text.Html;
import android.text.Spanned;
import android.text.style.StyleSpan;
import com.facebook.graphql.enums.GraphQLNotifOptionClientActionType;
import com.facebook.graphql.enums.GraphQLNotifOptionRowDisplayStyle;
import com.facebook.graphql.enums.GraphQLNotifOptionRowSetDisplayStyle;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.model.GraphQLEntityAtRange;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory$Builder;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.notifications.abtest.ExperimentsForNotificationsAbtestModule;
import com.facebook.notifications.abtest.NotificationsJewelExperimentController;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel.NotifOptionSetsModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel.NotifOptionSetsModel.EdgesModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel.NotifOptionSetsModel.EdgesModel.NodeModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel.NotifOptionSetsModel.EdgesModel.NodeModel.NotifOptionsModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel.NotifOptionSetsModel.EdgesModel.NodeModel.NotifOptionsModel.NotifOptionsEdgesModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.GenericInlineActionNotifOptionRowDisplayFragmentModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotifInlineActionOptionFragmentModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotifInlineActionOptionFragmentModel.ClientInfoModel;
import com.facebook.notifications.protocol.NotificationsOptionRowCommonGraphQLModels.StyleOnlyNotifOptionSetDisplayFragmentModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: exp_group */
public class NotificationsInlineNotificationNuxBuilder {
    public final NotificationsJewelExperimentController f12673a;

    @Inject
    public NotificationsInlineNotificationNuxBuilder(NotificationsJewelExperimentController notificationsJewelExperimentController) {
        this.f12673a = notificationsJewelExperimentController;
    }

    public final FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields m13480a() {
        GraphQLStory$Builder graphQLStory$Builder = new GraphQLStory$Builder();
        graphQLStory$Builder.f3185K = "inline_notification_id";
        graphQLStory$Builder = graphQLStory$Builder;
        graphQLStory$Builder.f3212o = "inline_notification_cache_id";
        graphQLStory$Builder = graphQLStory$Builder.m3410a(GraphQLStorySeenState.SEEN_AND_READ);
        int i = 0;
        NotificationsJewelExperimentController notificationsJewelExperimentController = this.f12673a;
        String a = notificationsJewelExperimentController.f7750a.a(ExperimentsForNotificationsAbtestModule.f7783v, notificationsJewelExperimentController.f7751b.getString(2131233704));
        Spanned fromHtml = Html.fromHtml(a);
        StyleSpan[] styleSpanArr = (StyleSpan[]) fromHtml.getSpans(0, a.length(), StyleSpan.class);
        Builder builder = new Builder();
        int length = styleSpanArr.length;
        while (i < length) {
            StyleSpan styleSpan = styleSpanArr[i];
            if (styleSpan.getStyle() == 1) {
                int spanStart = fromHtml.getSpanStart(styleSpan);
                int spanEnd = fromHtml.getSpanEnd(styleSpan) - spanStart;
                GraphQLEntityAtRange.Builder builder2 = new GraphQLEntityAtRange.Builder();
                builder2.f = spanStart;
                GraphQLEntityAtRange.Builder builder3 = builder2;
                builder3.e = spanEnd;
                builder.c(builder3.a());
            }
            i++;
        }
        GraphQLTextWithEntities.Builder builder4 = new GraphQLTextWithEntities.Builder();
        builder4.i = fromHtml.toString();
        builder4 = builder4;
        builder4.h = builder.b();
        graphQLStory$Builder.az = builder4.a();
        GraphQLStory a2 = graphQLStory$Builder.m3419a();
        NotifOptionSetsModel b = m13479b();
        FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel.Builder builder5 = new FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel.Builder();
        builder5.j = a2;
        FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel.Builder builder6 = builder5;
        builder6.l = b;
        return builder6.a();
    }

    private NotifOptionSetsModel m13479b() {
        StyleOnlyNotifOptionSetDisplayFragmentModel.Builder builder = new StyleOnlyNotifOptionSetDisplayFragmentModel.Builder();
        builder.a = GraphQLNotifOptionRowSetDisplayStyle.LONGPRESS_MENU;
        StyleOnlyNotifOptionSetDisplayFragmentModel a = builder.a();
        NodeModel.Builder builder2 = new NodeModel.Builder();
        builder2.b = a;
        NodeModel.Builder builder3 = builder2;
        NotificationsJewelExperimentController notificationsJewelExperimentController = this.f12673a;
        String a2 = notificationsJewelExperimentController.f7750a.a(ExperimentsForNotificationsAbtestModule.f7781t, notificationsJewelExperimentController.f7751b.getString(2131233706));
        ClientInfoModel.Builder builder4 = new ClientInfoModel.Builder();
        builder4.b = GraphQLNotifOptionClientActionType.HIDE;
        ClientInfoModel a3 = builder4.a();
        GenericInlineActionNotifOptionRowDisplayFragmentModel.Builder builder5 = new GenericInlineActionNotifOptionRowDisplayFragmentModel.Builder();
        DefaultTextWithEntitiesFieldsModel.Builder builder6 = new DefaultTextWithEntitiesFieldsModel.Builder();
        builder6.a = a2;
        builder5.e = builder6.a();
        GenericInlineActionNotifOptionRowDisplayFragmentModel.Builder builder7 = builder5;
        builder7.c = GraphQLNotifOptionRowDisplayStyle.POPUP_MENU_OPTION;
        GenericInlineActionNotifOptionRowDisplayFragmentModel a4 = builder7.a();
        NotifInlineActionOptionFragmentModel.Builder builder8 = new NotifInlineActionOptionFragmentModel.Builder();
        builder8.a = a3;
        NotifInlineActionOptionFragmentModel.Builder builder9 = builder8;
        builder9.b = a4;
        NotifInlineActionOptionFragmentModel.Builder builder10 = builder9;
        builder10.c = "server_action_hide_inline_notification_nux";
        NotifInlineActionOptionFragmentModel a5 = builder10.a();
        NotifOptionsEdgesModel.Builder builder11 = new NotifOptionsEdgesModel.Builder();
        builder11.a = a5;
        NotifOptionsEdgesModel a6 = builder11.a();
        NotifOptionsModel.Builder builder12 = new NotifOptionsModel.Builder();
        builder12.a = ImmutableList.of(a6);
        builder3.a = builder12.a();
        NodeModel a7 = builder3.a();
        EdgesModel.Builder builder13 = new EdgesModel.Builder();
        builder13.a = a7;
        EdgesModel a8 = builder13.a();
        NotifOptionSetsModel.Builder builder14 = new NotifOptionSetsModel.Builder();
        builder14.a = ImmutableList.of(a8);
        return builder14.a();
    }
}
