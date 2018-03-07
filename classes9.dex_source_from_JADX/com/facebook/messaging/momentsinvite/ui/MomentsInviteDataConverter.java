package com.facebook.messaging.momentsinvite.ui;

import android.content.res.Resources;
import com.facebook.common.util.StringUtil;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLMomentsAppMessengerInviteActionType;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.MomentsAppInvitationActionLinkFragmentModel;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.MomentsAppInvitationActionLinkFragmentModel.Builder;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.StoryAttachmentTargetFragmentModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesInterfaces.XMAAttachmentStoryFields;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAAttachmentStoryFieldsModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAAttachmentStoryFieldsModel.ActionLinksModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAAttachmentStoryFieldsModel.SubattachmentsModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.facebook.messaging.momentsinvite.model.MomentsInviteXMAModel;
import com.facebook.messaging.momentsinvite.model.MomentsInviteXMAModelBuilder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: item_category */
public class MomentsInviteDataConverter {
    public static List<String> m12801a(XMAAttachmentStoryFields xMAAttachmentStoryFields) {
        List<String> a = Lists.a();
        ImmutableList aO_ = xMAAttachmentStoryFields.aO_();
        int size = aO_.size();
        for (int i = 0; i < size; i++) {
            SubattachmentsModel subattachmentsModel = (SubattachmentsModel) aO_.get(i);
            if (!(subattachmentsModel.b() == null || subattachmentsModel.b().b() == null)) {
                a.add(subattachmentsModel.b().b().a());
            }
        }
        return a;
    }

    public static MomentsAppInvitationActionLinkFragmentModel m12799a(String str, @Nullable String str2, String str3) {
        Builder builder = new Builder();
        builder.a = GraphQLMomentsAppMessengerInviteActionType.INTENT_POSTBACK;
        builder.b = "viewinmoments";
        builder.e = str;
        builder.g = str2;
        builder.f = str3;
        return builder.a();
    }

    @Nullable
    public static MomentsInviteXMAModel m12800a(@Nullable XMAModel xMAModel, Resources resources, GatekeeperStoreImpl gatekeeperStoreImpl) {
        if (xMAModel == null) {
            return null;
        }
        MomentsInviteXMAModelBuilder newBuilder = MomentsInviteXMAModelBuilder.newBuilder();
        XMAAttachmentStoryFieldsModel xMAAttachmentStoryFieldsModel = (XMAAttachmentStoryFieldsModel) Preconditions.checkNotNull(xMAModel.c());
        newBuilder.a = xMAAttachmentStoryFieldsModel.l();
        if (xMAAttachmentStoryFieldsModel.d() != null) {
            newBuilder.b = xMAAttachmentStoryFieldsModel.d().a();
        }
        newBuilder.a(m12801a(xMAAttachmentStoryFieldsModel));
        newBuilder.d = xMAModel.b();
        StoryAttachmentTargetFragmentModel k = xMAAttachmentStoryFieldsModel.k();
        if (k == null || k.I() == null) {
            return newBuilder.i();
        }
        int g = xMAAttachmentStoryFieldsModel.k().I().g();
        if (g != -728861346 && g != 439087234) {
            return newBuilder.i();
        }
        newBuilder.e = xMAAttachmentStoryFieldsModel.k().bk();
        if (!(k.aa().isEmpty() && k.aY().isEmpty()) && gatekeeperStoreImpl.a(267, false)) {
            newBuilder.a(k.aa());
            newBuilder.b(k.aY());
        }
        if (newBuilder.g.isEmpty() && newBuilder.h.isEmpty() && !xMAAttachmentStoryFieldsModel.a().isEmpty()) {
            Builder builder = new Builder();
            builder.a = GraphQLMomentsAppMessengerInviteActionType.INSTALL;
            builder.b = "getmoments";
            ActionLinksModel actionLinksModel = (ActionLinksModel) xMAAttachmentStoryFieldsModel.a().get(0);
            builder.e = actionLinksModel.b();
            builder.g = actionLinksModel.c();
            ImmutableList of = ImmutableList.of(builder.a(), m12799a(resources.getString(2131241122), null, StringUtil.a(k.bA()) ? "moments://" : k.bA()));
            newBuilder.a(of);
            newBuilder.b(of);
        }
        return newBuilder.i();
    }
}
