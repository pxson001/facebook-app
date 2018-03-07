package com.facebook.groups.memberlist;

import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.config.application.FbAppType;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.enums.GraphQLGroupAdminType;
import com.facebook.groups.memberlist.event.GroupMemberUpdateEventBus;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;

/* compiled from: extra_pages_admin_permissions */
public class MemberListRowSelectionHandlerProvider extends AbstractAssistedProvider<MemberListRowSelectionHandler> {
    public final MemberListRowSelectionHandler m15952a(String str, GraphQLGroupAdminType graphQLGroupAdminType) {
        return new MemberListRowSelectionHandler(ResourcesMethodAutoProvider.a(this), String_LoggedInUserIdMethodAutoProvider.b(this), str, graphQLGroupAdminType, (UriIntentMapper) Fb4aUriIntentMapper.a(this), (SecureContextHelper) DefaultSecureContextHelper.a(this), GroupMemberUpdateEventBus.m15974a(this), GroupMembershipController.m15917b(this), (FbAppType) getInstance(FbAppType.class));
    }
}
