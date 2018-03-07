package com.facebook.notifications.util;

import com.facebook.api.ufiservices.common.FetchReactorsParamBuilderUtil;
import com.facebook.api.ufiservices.common.FetchRecentActivityParamBuilderUtil;
import com.facebook.api.ufiservices.common.ThreadedCommentParamBuilderUtil;
import com.facebook.checkin.socialsearch.parambuilder.SocialSearchParamBuilderUtil;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.abtest.ExperimentsForNotificationsAbtestModule;
import com.facebook.notifications.action.NotificationsActionsSupportedStyles;
import com.facebook.notifications.module.String_NotificationsEnvironmentFilterMethodAutoProvider;
import com.facebook.notifications.protocol.FetchGraphQLNotificationsParams;
import com.facebook.notifications.protocol.FetchNotificationsGraphQL;
import com.facebook.notifications.protocol.FetchNotificationsGraphQL.DeltaNotificationsQueryString;
import com.facebook.notifications.protocol.FetchNotificationsGraphQL.FirstNotificationsQueryString;
import com.facebook.notifications.sync.NotificationsSyncConstants.SyncSource;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.video.abtest.VideoDashConfig;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelParamBuilderUtil;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: minDelay= */
public class NotificationsQueryBuilder {
    private final GraphQLStoryHelper f7695a;
    private final GraphQLImageHelper f7696b;
    private final SizeAwareImageUtil f7697c;
    private final Provider<String> f7698d;
    private final String f7699e;
    private final ThreadedCommentParamBuilderUtil f7700f;
    private final FetchReactorsParamBuilderUtil f7701g;
    private final FetchRecentActivityParamBuilderUtil f7702h;
    private final SocialSearchParamBuilderUtil f7703i;
    private final QeAccessor f7704j;
    private final FetchVideoChannelParamBuilderUtil f7705k;
    private final GatekeeperStoreImpl f7706l;
    private final NotificationsActionsSupportedStyles f7707m;
    private final VideoDashConfig f7708n;

    public static NotificationsQueryBuilder m8051b(InjectorLike injectorLike) {
        return new NotificationsQueryBuilder(GraphQLImageHelper.a(injectorLike), GraphQLStoryHelper.a(injectorLike), SizeAwareImageUtil.a(injectorLike), IdBasedProvider.a(injectorLike, 4463), String_NotificationsEnvironmentFilterMethodAutoProvider.m8054a(injectorLike), ThreadedCommentParamBuilderUtil.b(injectorLike), FetchReactorsParamBuilderUtil.a(injectorLike), FetchRecentActivityParamBuilderUtil.a(injectorLike), FetchVideoChannelParamBuilderUtil.a(injectorLike), SocialSearchParamBuilderUtil.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), NotificationsActionsSupportedStyles.m8056b(injectorLike), VideoDashConfig.a(injectorLike));
    }

    @Inject
    public NotificationsQueryBuilder(GraphQLImageHelper graphQLImageHelper, GraphQLStoryHelper graphQLStoryHelper, SizeAwareImageUtil sizeAwareImageUtil, Provider<String> provider, @Nullable String str, ThreadedCommentParamBuilderUtil threadedCommentParamBuilderUtil, FetchReactorsParamBuilderUtil fetchReactorsParamBuilderUtil, FetchRecentActivityParamBuilderUtil fetchRecentActivityParamBuilderUtil, FetchVideoChannelParamBuilderUtil fetchVideoChannelParamBuilderUtil, SocialSearchParamBuilderUtil socialSearchParamBuilderUtil, QeAccessor qeAccessor, GatekeeperStore gatekeeperStore, NotificationsActionsSupportedStyles notificationsActionsSupportedStyles, VideoDashConfig videoDashConfig) {
        this.f7695a = graphQLStoryHelper;
        this.f7696b = graphQLImageHelper;
        this.f7697c = sizeAwareImageUtil;
        this.f7698d = provider;
        this.f7699e = str;
        this.f7700f = threadedCommentParamBuilderUtil;
        this.f7701g = fetchReactorsParamBuilderUtil;
        this.f7702h = fetchRecentActivityParamBuilderUtil;
        this.f7705k = fetchVideoChannelParamBuilderUtil;
        this.f7703i = socialSearchParamBuilderUtil;
        this.f7704j = qeAccessor;
        this.f7706l = gatekeeperStore;
        this.f7707m = notificationsActionsSupportedStyles;
        this.f7708n = videoDashConfig;
    }

    public final GraphQlQueryString m8052a(@Nullable FetchGraphQLNotificationsParams fetchGraphQLNotificationsParams) {
        GraphQlQueryString a;
        if (fetchGraphQLNotificationsParams == null || fetchGraphQLNotificationsParams.f7678e == null) {
            a = FetchNotificationsGraphQL.m11000a();
        } else {
            a = new DeltaNotificationsQueryString();
        }
        m8050a(a, fetchGraphQLNotificationsParams);
        return a;
    }

    public final FirstNotificationsQueryString m8053b(@Nullable FetchGraphQLNotificationsParams fetchGraphQLNotificationsParams) {
        FirstNotificationsQueryString a = FetchNotificationsGraphQL.m11000a();
        m8050a(a, fetchGraphQLNotificationsParams);
        return a;
    }

    private void m8050a(GraphQlQueryString graphQlQueryString, @Nullable FetchGraphQLNotificationsParams fetchGraphQLNotificationsParams) {
        String str;
        if (fetchGraphQLNotificationsParams != null) {
            graphQlQueryString.a("first_notification_stories", String.valueOf(fetchGraphQLNotificationsParams.f7675b)).a("last_notification_stories", String.valueOf(fetchGraphQLNotificationsParams.f7676c)).a("notification_stories_cache_IDs", fetchGraphQLNotificationsParams.f7681h);
            str = fetchGraphQLNotificationsParams.f7680g;
            if (str == null || str.equals("")) {
                str = SyncSource.UNKNOWN.toString();
            }
            graphQlQueryString.a("notification_request_source", str);
            if (fetchGraphQLNotificationsParams.f7678e != null) {
                graphQlQueryString.a("before_notification_stories", fetchGraphQLNotificationsParams.f7678e);
            }
            if (fetchGraphQLNotificationsParams.f7677d != null) {
                graphQlQueryString.a("after_notification_stories", fetchGraphQLNotificationsParams.f7677d);
            }
            if (fetchGraphQLNotificationsParams.f7686m != null) {
                graphQlQueryString.a("device_id", fetchGraphQLNotificationsParams.f7686m);
            }
        }
        graphQlQueryString.a(true);
        GraphQLStoryHelper graphQLStoryHelper = this.f7695a;
        graphQlQueryString.a("profile_image_size", GraphQLStoryHelper.a()).a("image_preview_size", String.valueOf(this.f7695a.t()));
        Enum a = GraphQlQueryDefaults.a();
        if (a == null) {
            a = GraphQlQueryDefaults.a;
        }
        graphQlQueryString.a("icon_scale", a);
        if (this.f7699e != null) {
            graphQlQueryString.a("environment_notification_stories", this.f7699e);
        }
        if (this.f7698d != null) {
            graphQlQueryString.a("community_notification_stories", (String) this.f7698d.get());
        }
        graphQlQueryString.a("angora_attachment_cover_image_size", this.f7695a.r());
        graphQlQueryString.a("angora_attachment_profile_image_size", this.f7695a.s());
        graphQlQueryString.a("reading_attachment_profile_image_width", this.f7695a.L());
        graphQlQueryString.a("reading_attachment_profile_image_height", this.f7695a.M());
        a = GraphQlQueryDefaults.a();
        String str2 = "default_image_scale";
        if (a == null) {
            a = GraphQlQueryDefaults.a;
        }
        graphQlQueryString.a(str2, a);
        graphQlQueryString.a("max_comments", Integer.valueOf(5));
        this.f7700f.b(graphQlQueryString);
        this.f7701g.a(graphQlQueryString);
        this.f7702h.a(graphQlQueryString);
        SocialSearchParamBuilderUtil.a(graphQlQueryString);
        this.f7697c.a(graphQlQueryString, this.f7696b.c());
        graphQlQueryString.a("image_large_aspect_height", this.f7695a.z());
        graphQlQueryString.a("image_large_aspect_width", this.f7695a.y());
        graphQlQueryString.a("fetch_reshare_counts", Boolean.valueOf(this.f7704j.a(ExperimentsForFeedbackTestModule.T, false)));
        if (this.f7704j.a(ExperimentsForNotificationsAbtestModule.f7778q, false)) {
            str = "notif_option_set_context";
            NotificationsActionsSupportedStyles notificationsActionsSupportedStyles = this.f7707m;
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
            ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
            Iterator it = notificationsActionsSupportedStyles.f7711c.keySet().iterator();
            while (it.hasNext()) {
                String str3 = (String) it.next();
                ObjectNode objectNode2 = new ObjectNode(JsonNodeFactory.a);
                objectNode2.a("option_set_display_style", str3);
                NotificationsActionsSupportedStyles.m8055a(objectNode2, "option_display_styles", (ImmutableList) notificationsActionsSupportedStyles.f7711c.get(str3));
                arrayNode.a(objectNode2);
            }
            objectNode.c("supported_display_styles", arrayNode);
            NotificationsActionsSupportedStyles.m8055a(objectNode, "client_action_types", NotificationsActionsSupportedStyles.f7709a);
            graphQlQueryString.a(str, objectNode.toString());
        }
        graphQlQueryString.a("rich_notifications_enabled", Boolean.valueOf(fetchGraphQLNotificationsParams.f7687n));
        if (fetchGraphQLNotificationsParams.f7687n) {
            graphQlQueryString.a("reaction_icon_scale", GraphQlQueryDefaults.a());
            if (!Strings.isNullOrEmpty(fetchGraphQLNotificationsParams.f7688o)) {
                graphQlQueryString.a("reaction_context", fetchGraphQLNotificationsParams.f7688o);
            }
        }
        this.f7705k.a(graphQlQueryString);
        graphQlQueryString.a("num_full_relevant_comments", Integer.valueOf(1));
        graphQlQueryString.a("should_fetch_full_relevant_comments", Boolean.valueOf(this.f7704j.a(ExperimentsForNotificationsAbtestModule.f7765d, false)));
        graphQlQueryString.a("first_n_feedback_reactions", Integer.valueOf(1));
        graphQlQueryString.a("feedback_reaction_type", Integer.valueOf(11));
        graphQlQueryString.a("feedback_reactions_floating_effect", Boolean.valueOf(this.f7706l.a(834, false)));
        if (this.f7708n.a() && this.f7708n.Q) {
            graphQlQueryString.a("scrubbing", "MPEG_DASH");
        }
    }
}
