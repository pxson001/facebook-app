package com.facebook.groups.memberlist.event;

import com.facebook.graphql.enums.GraphQLGroupAdminType;

/* compiled from: extra_zoom_level */
public class GroupMemberUpdateEvents {

    /* compiled from: extra_zoom_level */
    public abstract class GroupRemoveMemberEventSubscriber extends GroupMemberUpdateEventSubscriber<GroupRemoveMemberEvent> {
        public final Class<GroupRemoveMemberEvent> m15747a() {
            return GroupRemoveMemberEvent.class;
        }
    }

    /* compiled from: extra_zoom_level */
    public abstract class GroupAdminMemberEventSubscriber extends GroupMemberUpdateEventSubscriber<GroupAdminMemberEvent> {
        public final Class<GroupAdminMemberEvent> m15749a() {
            return GroupAdminMemberEvent.class;
        }
    }

    /* compiled from: extra_zoom_level */
    public abstract class GroupBlockedMemberEventSubscriber extends GroupMemberUpdateEventSubscriber<GroupBlockedMemberEvent> {
        public final Class<GroupBlockedMemberEvent> m15790a() {
            return GroupBlockedMemberEvent.class;
        }
    }

    /* compiled from: extra_zoom_level */
    public abstract class GroupRemoveInviteEventSubscriber extends GroupMemberUpdateEventSubscriber<GroupRemoveInviteEvent> {
        public final Class<GroupRemoveInviteEvent> m15845a() {
            return GroupRemoveInviteEvent.class;
        }
    }

    /* compiled from: extra_zoom_level */
    public class GroupAdminMemberEvent extends GroupMemberUpdateEvent {
        public final String f14430a;
        public final String f14431b;
        public final GraphQLGroupAdminType f14432c;

        public GroupAdminMemberEvent(String str, String str2, GraphQLGroupAdminType graphQLGroupAdminType) {
            this.f14430a = str;
            this.f14431b = str2;
            this.f14432c = graphQLGroupAdminType;
        }
    }

    /* compiled from: extra_zoom_level */
    public class GroupBlockedMemberEvent extends GroupMemberUpdateEvent {
        public final String f14433a;
        public final String f14434b;
        public final boolean f14435c;

        public GroupBlockedMemberEvent(String str, String str2, boolean z) {
            this.f14433a = str;
            this.f14434b = str2;
            this.f14435c = z;
        }
    }

    /* compiled from: extra_zoom_level */
    public class GroupRemoveInviteEvent extends GroupMemberUpdateEvent {
        public final String f14436a;
        public final String f14437b;

        public GroupRemoveInviteEvent(String str, String str2) {
            this.f14436a = str;
            this.f14437b = str2;
        }
    }

    /* compiled from: extra_zoom_level */
    public class GroupRemoveMemberEvent extends GroupMemberUpdateEvent {
        public final String f14438a;
        public final String f14439b;

        public GroupRemoveMemberEvent(String str, String str2) {
            this.f14438a = str;
            this.f14439b = str2;
        }
    }
}
