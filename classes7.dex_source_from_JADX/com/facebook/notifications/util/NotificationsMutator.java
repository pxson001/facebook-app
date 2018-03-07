package com.facebook.notifications.util;

import com.facebook.graphql.enums.GraphQLNotifHighlightState;
import com.facebook.graphql.enums.GraphQLNotifImportanceType;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory.Builder;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.notifications.protocol.C0691xbe689b41;
import com.facebook.notifications.protocol.C0693x680f492a;
import com.facebook.notifications.protocol.C0694xee63252d;
import com.facebook.notifications.protocol.C0694xee63252d.EdgesModel;
import com.facebook.notifications.protocol.C0694xee63252d.EdgesModel.NodeModel;
import com.facebook.notifications.protocol.C0694xee63252d.EdgesModel.NodeModel.NotifOptionsModel;
import com.facebook.notifications.protocol.C0694xee63252d.EdgesModel.NodeModel.NotifOptionsModel.NotifOptionsEdgesModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationHighlightOperationFragment;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationOptionRow;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields.ImportanceReasonText;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields.NotifOptionSets;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields.NotifOptionSets.Edges.Node.NotifOptions;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields.NotifOptionSets.Edges.Node.NotifOptions.NotifOptionsEdges;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotifInlineActionOptionFragmentModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotifInlineActionOptionFragmentModel.ClientInfoModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationHighlightOperationFragmentModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationOptionRowModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationsEdgeFieldsModel;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLInterfaces.NotifOptionSetFragment;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLInterfaces.NotifOptionSetFragment.NotifOptions.Nodes;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLModels.NotifOptionSetFragmentModel;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLModels.NotifOptionSetFragmentModel.OptionSetDisplayModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitFragmentModel;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: minutiae_db */
public class NotificationsMutator {
    public static NotificationsEdgeFields m10809a(NotificationsEdgeFields notificationsEdgeFields, GraphQLStorySeenState graphQLStorySeenState) {
        GraphQLStory a = Builder.a(notificationsEdgeFields.k()).a(graphQLStorySeenState).a();
        C0691xbe689b41 a2 = C0691xbe689b41.m10191a(NotificationsEdgeFieldsModel.a(notificationsEdgeFields));
        a2.f8528j = a;
        NotificationsEdgeFieldsModel a3 = a2.m10202a();
        PropertyHelper.a(a3.k(), notificationsEdgeFields.k().aa_());
        return a3;
    }

    public static GraphQLStory m10805a(GraphQLStory graphQLStory, GraphQLStorySeenState graphQLStorySeenState, long j) {
        Builder a = Builder.a(graphQLStory).a(graphQLStorySeenState);
        a.x = j;
        return a.a();
    }

    public static NotificationsEdgeFields m10808a(NotificationsEdgeFields notificationsEdgeFields, int i) {
        C0691xbe689b41 a = C0691xbe689b41.m10191a(NotificationsEdgeFieldsModel.a(notificationsEdgeFields));
        a.f8527i = i;
        return a.m10202a();
    }

    public static NotificationsEdgeFields m10812a(NotificationsEdgeFields notificationsEdgeFields, boolean z) {
        C0691xbe689b41 a = C0691xbe689b41.m10191a(NotificationsEdgeFieldsModel.a(notificationsEdgeFields));
        a.f8525g = z;
        return a.m10202a();
    }

    public static NotificationsEdgeFields m10810a(NotificationsEdgeFields notificationsEdgeFields, ReactionUnitFragment reactionUnitFragment) {
        C0691xbe689b41 a = C0691xbe689b41.m10191a(NotificationsEdgeFieldsModel.a(notificationsEdgeFields));
        a.f8531m = ReactionUnitFragmentModel.m15630a(reactionUnitFragment);
        return a.m10202a();
    }

    @Nullable
    public static NotificationsEdgeFields m10811a(NotificationsEdgeFields notificationsEdgeFields, String str) {
        C0694xee63252d m = notificationsEdgeFields.m();
        if (m.m10256a().size() != 1) {
            return null;
        }
        EdgesModel edgesModel = (EdgesModel) m.m10256a().get(0);
        NodeModel a = edgesModel.m10250a();
        if (a == null) {
            return null;
        }
        NotifOptionsModel a2 = a.m10242a();
        if (a2 == null) {
            return null;
        }
        int i = 0;
        NotifOptionsEdgesModel notifOptionsEdgesModel = null;
        while (i < a2.m10237a().size()) {
            NotifOptionsEdgesModel notifOptionsEdgesModel2 = (NotifOptionsEdgesModel) a2.m10237a().get(i);
            if (!(notifOptionsEdgesModel2.m10231a() == null || notifOptionsEdgesModel2.m10231a().m10100a() == null || notifOptionsEdgesModel2.m10231a().m10100a().mo454c().size() != 1)) {
                NotifOptionSetFragment notifOptionSetFragment = (NotifOptionSetFragment) notifOptionsEdgesModel2.m10231a().m10100a().mo454c().get(0);
                if (notifOptionSetFragment.mo467c() != null) {
                    ImmutableList a3 = notifOptionSetFragment.mo467c().mo464a();
                    int size = a3.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (((Nodes) a3.get(i2)).mo461c().equals(str)) {
                            break;
                        }
                    }
                } else {
                    notifOptionsEdgesModel2 = notifOptionsEdgesModel;
                    i++;
                    notifOptionsEdgesModel = notifOptionsEdgesModel2;
                }
            }
            notifOptionsEdgesModel2 = notifOptionsEdgesModel;
            if (notifOptionsEdgesModel2 != null) {
                notifOptionsEdgesModel = notifOptionsEdgesModel2;
                break;
            }
            i++;
            notifOptionsEdgesModel = notifOptionsEdgesModel2;
        }
        if (notifOptionsEdgesModel == null) {
            return null;
        }
        NotifInlineActionOptionFragmentModel a4 = notifOptionsEdgesModel.m10231a();
        if (a4 == null) {
            return null;
        }
        ClientInfoModel a5 = a4.m10100a();
        if (a5 == null || a5.mo454c().size() != 1) {
            return null;
        }
        NotifOptionSetFragment notifOptionSetFragment2 = (NotifOptionSetFragment) a5.mo454c().get(0);
        OptionSetDisplayModel.Builder a6 = OptionSetDisplayModel.Builder.m10502a(OptionSetDisplayModel.m10506a(notifOptionSetFragment2.mo468d()));
        a6.f8621b = str;
        OptionSetDisplayModel a7 = a6.m10503a();
        NotifOptionSetFragmentModel.Builder a8 = NotifOptionSetFragmentModel.Builder.m10472a(NotifOptionSetFragmentModel.m10518a(notifOptionSetFragment2));
        a8.f8599c = OptionSetDisplayModel.m10506a(a7);
        notifOptionSetFragment2 = a8.m10473a();
        ClientInfoModel.Builder a9 = ClientInfoModel.Builder.m10084a(ClientInfoModel.m10088a(a5));
        a9.f8469c = ImmutableList.of(NotifOptionSetFragmentModel.m10518a(notifOptionSetFragment2));
        ClientInfoModel a10 = a9.m10085a();
        NotifInlineActionOptionFragmentModel.Builder a11 = NotifInlineActionOptionFragmentModel.Builder.m10082a(NotifInlineActionOptionFragmentModel.m10097a(a4));
        a11.f8464a = ClientInfoModel.m10088a(a10);
        NotifInlineActionOptionFragmentModel a12 = a11.m10083a();
        NotifOptionsEdgesModel.Builder a13 = NotifOptionsEdgesModel.Builder.m10224a(NotifOptionsEdgesModel.m10228a(notifOptionsEdgesModel));
        a13.f8539a = NotifInlineActionOptionFragmentModel.m10097a(a12);
        notifOptionsEdgesModel2 = a13.m10225a();
        NotifOptionsModel.Builder a14 = NotifOptionsModel.Builder.m10221a(NotifOptionsModel.m10234a(a2));
        a14.f8538a = m10813a(notifOptionsEdgesModel2, a2, i);
        NotifOptionsModel a15 = a14.m10222a();
        NodeModel.Builder a16 = NodeModel.Builder.m10218a(NodeModel.m10239a(a));
        a16.f8536a = NotifOptionsModel.m10234a(a15);
        NodeModel a17 = a16.m10219a();
        EdgesModel.Builder a18 = EdgesModel.Builder.m10215a(EdgesModel.m10247a(edgesModel));
        a18.f8535a = NodeModel.m10239a(a17);
        edgesModel = a18.m10216a();
        C0694xee63252d.Builder a19 = C0694xee63252d.Builder.m10212a(C0694xee63252d.m10253a(m));
        a19.f8534a = ImmutableList.of(EdgesModel.m10247a(edgesModel));
        C0694xee63252d a20 = a19.m10213a();
        C0691xbe689b41 a21 = C0691xbe689b41.m10191a(NotificationsEdgeFieldsModel.a(notificationsEdgeFields));
        a21.f8530l = C0694xee63252d.m10253a(a20);
        return a21.m10202a();
    }

    private static ImmutableList<NotifOptionsEdgesModel> m10813a(NotifOptionsEdges notifOptionsEdges, NotifOptions notifOptions, int i) {
        ImmutableList a = notifOptions.m10237a();
        ImmutableList.Builder builder = ImmutableList.builder();
        for (int i2 = 0; i2 < a.size(); i2++) {
            if (i == i2) {
                builder.c(NotifOptionsEdgesModel.m10228a((NotifOptionsEdgesModel) notifOptionsEdges));
            } else {
                builder.c(NotifOptionsEdgesModel.m10228a((NotifOptionsEdgesModel) a.get(i2)));
            }
        }
        return builder.b();
    }

    public static NotificationsEdgeFields m10807a(NotificationsEdgeFields notificationsEdgeFields) {
        return m10809a(notificationsEdgeFields, GraphQLStorySeenState.SEEN_AND_READ);
    }

    @Nullable
    public static NotificationsEdgeFields m10806a(@Nullable GraphQLStory graphQLStory, @Nullable ImmutableList<? extends NotificationOptionRow> immutableList, String str, @Nullable GraphQLNotifHighlightState graphQLNotifHighlightState, @Nullable ImportanceReasonText importanceReasonText, @Nullable int i, @Nullable GraphQLNotifImportanceType graphQLNotifImportanceType, @Nullable ReactionUnitFragment reactionUnitFragment, boolean z, @Nullable NotifOptionSets notifOptionSets, int i2, @Nullable ImmutableList<? extends NotificationHighlightOperationFragment> immutableList2) {
        if (graphQLStory == null) {
            return null;
        }
        ImmutableList.Builder builder;
        int size;
        int i3;
        C0691xbe689b41 b = new C0691xbe689b41().m10195a(graphQLStory).m10200a(str).m10193a(graphQLNotifHighlightState).m10196a(C0693x680f492a.m10208a((C0693x680f492a) importanceReasonText)).m10192a(i).m10194a(graphQLNotifImportanceType).m10198a(ReactionUnitFragmentModel.m15630a(reactionUnitFragment)).m10201a(z).m10197a(C0694xee63252d.m10253a((C0694xee63252d) notifOptionSets)).m10203b(i2);
        if (immutableList != null) {
            builder = ImmutableList.builder();
            size = immutableList.size();
            for (i3 = 0; i3 < size; i3++) {
                builder.c(NotificationOptionRowModel.m10150a((NotificationOptionRowModel) immutableList.get(i3)));
            }
            b.m10204b(builder.b());
        }
        if (immutableList2 != null) {
            builder = ImmutableList.builder();
            size = immutableList2.size();
            for (i3 = 0; i3 < size; i3++) {
                builder.c(NotificationHighlightOperationFragmentModel.m10126a((NotificationHighlightOperationFragmentModel) immutableList2.get(i3)));
            }
            b.m10199a(builder.b());
        }
        return b.m10202a();
    }
}
