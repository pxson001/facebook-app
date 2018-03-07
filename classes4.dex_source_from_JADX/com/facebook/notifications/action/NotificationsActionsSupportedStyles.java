package com.facebook.notifications.action;

import com.facebook.graphql.enums.GraphQLNotifOptionClientActionType;
import com.facebook.graphql.enums.GraphQLNotifOptionRowDisplayStyle;
import com.facebook.graphql.enums.GraphQLNotifOptionRowSetDisplayStyle;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.abtest.NotificationsJewelExperimentController;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import javax.inject.Inject;

/* compiled from: migrated_privacy_options */
public class NotificationsActionsSupportedStyles {
    public static final ImmutableList<String> f7709a = ImmutableList.of(GraphQLNotifOptionClientActionType.HIDE.name(), GraphQLNotifOptionClientActionType.OPEN_GROUP_SETTING.name(), GraphQLNotifOptionClientActionType.SHOW_MORE.name(), GraphQLNotifOptionClientActionType.OPEN_ACTION_SHEET.name(), GraphQLNotifOptionClientActionType.UNSUB.name());
    public final NotificationsJewelExperimentController f7710b;
    public final ImmutableMap<String, ImmutableList<String>> f7711c;

    public static NotificationsActionsSupportedStyles m8056b(InjectorLike injectorLike) {
        return new NotificationsActionsSupportedStyles(NotificationsJewelExperimentController.m8058b(injectorLike));
    }

    @Inject
    public NotificationsActionsSupportedStyles(NotificationsJewelExperimentController notificationsJewelExperimentController) {
        this.f7710b = notificationsJewelExperimentController;
        Builder builder = new Builder();
        builder.b(GraphQLNotifOptionRowSetDisplayStyle.LONGPRESS_MENU.name(), ImmutableList.of(GraphQLNotifOptionRowDisplayStyle.POPUP_MENU_OPTION.name()));
        if (GraphQLNotifOptionRowSetDisplayStyle.ACTION_SHEET_MENU.name().equals(this.f7710b.m8060f())) {
            builder.b(GraphQLNotifOptionRowSetDisplayStyle.ACTION_SHEET_MENU.name(), ImmutableList.of(GraphQLNotifOptionRowDisplayStyle.POPUP_MENU_OPTION.name(), GraphQLNotifOptionRowDisplayStyle.ACTION_SHEET_OPTION.name()));
        }
        this.f7711c = builder.b();
    }

    public static void m8055a(ObjectNode objectNode, String str, ImmutableList<String> immutableList) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            arrayNode.h((String) immutableList.get(i));
        }
        objectNode.c(str, arrayNode);
    }
}
