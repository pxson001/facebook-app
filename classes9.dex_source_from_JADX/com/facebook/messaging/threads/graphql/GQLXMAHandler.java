package com.facebook.messaging.threads.graphql;

import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.commerce.model.retail.CommerceData;
import com.facebook.messaging.database.handlers.DbInsertThreadUsersHandler;
import com.facebook.messaging.graphql.threads.GenieMessageQueriesModels.GenieMessageFragmentModel;
import com.facebook.messaging.graphql.threads.GenieMessageQueriesModels.GenieMessageFragmentModel.GenieSenderModel.MessagingActorModel;
import com.facebook.messaging.graphql.threads.GenieMessageQueriesModels.GenieMessageFragmentModel.GenieSenderModel.MessagingActorModel.ProfilePhotoModel.ImageModel;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.StoryAttachmentTargetFragmentModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAAttachmentStoryFieldsModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAAttachmentStoryFieldsModel.ActionLinksModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel.Builder;
import com.facebook.messaging.model.messages.MessageBuilder;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.payment.PaymentRequestData;
import com.facebook.messaging.model.payment.PaymentTransactionData;
import com.facebook.messaging.model.share.ShareBuilder;
import com.facebook.messaging.model.share.ShareMedia.Type;
import com.facebook.messaging.model.share.ShareMediaBuilder;
import com.facebook.messaging.momentsinvite.model.MomentsInviteDataBuilder;
import com.facebook.messaging.momentsinvite.ui.MomentsInviteDataConverter;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.Name;
import com.facebook.user.model.PicSquare;
import com.facebook.user.model.PicSquareUrlWithSize;
import com.facebook.user.model.User;
import com.facebook.user.model.UserBuilder;
import com.facebook.user.model.UserKey;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.io.InvalidObjectException;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: com.facebook.heisman.ProfilePictureOverlayCameraActivity */
public class GQLXMAHandler {
    private final DbInsertThreadUsersHandler f17835a;
    public final GQLThreadsLogger f17836b;
    private final Provider<Boolean> f17837c;
    private final Provider<UserCache> f17838d;

    public static GQLXMAHandler m17825b(InjectorLike injectorLike) {
        return new GQLXMAHandler(DbInsertThreadUsersHandler.m10937a(injectorLike), GQLThreadsLogger.m17795b(injectorLike), IdBasedProvider.a(injectorLike, 4215), IdBasedProvider.a(injectorLike, 3593));
    }

    public static GQLXMAHandler m17822a(InjectorLike injectorLike) {
        return m17825b(injectorLike);
    }

    @Inject
    public GQLXMAHandler(DbInsertThreadUsersHandler dbInsertThreadUsersHandler, GQLThreadsLogger gQLThreadsLogger, Provider<Boolean> provider, Provider<UserCache> provider2) {
        this.f17835a = dbInsertThreadUsersHandler;
        this.f17836b = gQLThreadsLogger;
        this.f17837c = provider;
        this.f17838d = provider2;
    }

    public final void m17829a(@Nullable XMAModel xMAModel, MessageBuilder messageBuilder) {
        if (xMAModel != null) {
            XMAAttachmentStoryFieldsModel l = xMAModel.l();
            if (l == null) {
                this.f17836b.m17801a(xMAModel, new InvalidObjectException("XMA doesn't contain a story attachment."));
                return;
            }
            messageBuilder.a(xMAModel);
            messageBuilder.a(!xMAModel.k());
            try {
                m17823a(l, xMAModel, messageBuilder);
            } catch (Exception e) {
                this.f17836b.m17801a(xMAModel, e);
            }
        }
    }

    private void m17823a(XMAAttachmentStoryFieldsModel xMAAttachmentStoryFieldsModel, XMAModel xMAModel, MessageBuilder messageBuilder) {
        Object obj;
        if (xMAAttachmentStoryFieldsModel.k() == null || xMAAttachmentStoryFieldsModel.k().I() == null || xMAAttachmentStoryFieldsModel.k().I().g() != -1479052374) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            StoryAttachmentTargetFragmentModel k = xMAAttachmentStoryFieldsModel.k();
            String Q = k.Q();
            this.f17836b.m17805a("Incomplete P2P data.", k.S(), k.R(), k.P());
            messageBuilder.B = new PaymentTransactionData(Q, Long.parseLong(k.S().a()), Long.parseLong(k.R().a()), Integer.parseInt(k.P().b()), k.P().a());
            return;
        }
        if (xMAAttachmentStoryFieldsModel.k() == null || xMAAttachmentStoryFieldsModel.k().I() == null || xMAAttachmentStoryFieldsModel.k().I().g() != -268249560) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            m17827b(xMAAttachmentStoryFieldsModel, messageBuilder);
            return;
        }
        if (xMAAttachmentStoryFieldsModel.k() == null || xMAAttachmentStoryFieldsModel.k().I() == null || !(xMAAttachmentStoryFieldsModel.k().I().g() == 1366744284 || xMAAttachmentStoryFieldsModel.k().I().g() == 439087234 || xMAAttachmentStoryFieldsModel.k().I().g() == -728861346)) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            m17826b(xMAAttachmentStoryFieldsModel, xMAModel, messageBuilder);
            return;
        }
        obj = null;
        if (!(xMAAttachmentStoryFieldsModel.k() == null || xMAAttachmentStoryFieldsModel.k().I() == null)) {
            int g = xMAAttachmentStoryFieldsModel.k().I().g();
            if (g == -1649510526 || g == -1039777287 || g == 697177488 || g == 558867059 || g == 1611225566 || g == 1851543484) {
                obj = 1;
            }
        }
        if (obj != null) {
            Preconditions.checkNotNull(xMAAttachmentStoryFieldsModel.k());
            messageBuilder.H = CommerceData.a(xMAAttachmentStoryFieldsModel.k());
            return;
        }
        if (((Boolean) this.f17837c.get()).booleanValue()) {
            if (xMAModel.j() != null) {
                GenieMessageFragmentModel a = xMAModel.j().a();
                if (!(a == null || a.a() == null)) {
                    MessagingActorModel a2 = a.a().a();
                    if (!(a2 == null || a2.b() == null || a2.c() == null)) {
                        obj = 1;
                        if (obj != null) {
                            m17828b(xMAModel, messageBuilder);
                            return;
                        }
                    }
                }
            }
            obj = null;
            if (obj != null) {
                m17828b(xMAModel, messageBuilder);
                return;
            }
        }
        ShareBuilder shareBuilder = new ShareBuilder();
        m17824a(xMAAttachmentStoryFieldsModel, shareBuilder);
        messageBuilder.j = ImmutableList.of(shareBuilder.n());
    }

    private void m17827b(XMAAttachmentStoryFieldsModel xMAAttachmentStoryFieldsModel, MessageBuilder messageBuilder) {
        StoryAttachmentTargetFragmentModel k = xMAAttachmentStoryFieldsModel.k();
        String M = k.M();
        this.f17836b.m17805a("Incomplete P2P data.", k.O(), k.N(), k.L());
        messageBuilder.C = new PaymentRequestData(M, Long.parseLong(k.O().b()), Long.parseLong(k.N().b()), Integer.parseInt(k.L().b()), k.L().a());
    }

    private static void m17826b(XMAAttachmentStoryFieldsModel xMAAttachmentStoryFieldsModel, XMAModel xMAModel, MessageBuilder messageBuilder) {
        ShareBuilder shareBuilder = new ShareBuilder();
        m17824a(xMAAttachmentStoryFieldsModel, shareBuilder);
        if (xMAAttachmentStoryFieldsModel.k() != null) {
            shareBuilder.k = xMAAttachmentStoryFieldsModel.k().bA();
        }
        if (!xMAAttachmentStoryFieldsModel.a().isEmpty()) {
            ActionLinksModel actionLinksModel = (ActionLinksModel) xMAAttachmentStoryFieldsModel.a().get(0);
            shareBuilder.f = actionLinksModel.c();
            shareBuilder.j = actionLinksModel.b();
        }
        MomentsInviteDataBuilder a = MomentsInviteDataBuilder.newBuilder().a(MomentsInviteDataConverter.m12801a((XMAAttachmentStoryFieldsModel) Preconditions.checkNotNull(xMAModel.c())));
        a.c = xMAModel.b();
        shareBuilder.m = a.e();
        messageBuilder.j = ImmutableList.of(shareBuilder.n());
    }

    public static void m17824a(XMAAttachmentStoryFieldsModel xMAAttachmentStoryFieldsModel, ShareBuilder shareBuilder) {
        shareBuilder.c = xMAAttachmentStoryFieldsModel.l();
        if (xMAAttachmentStoryFieldsModel.g() != null) {
            shareBuilder.d = xMAAttachmentStoryFieldsModel.g().a();
        }
        if (xMAAttachmentStoryFieldsModel.d() != null) {
            shareBuilder.e = xMAAttachmentStoryFieldsModel.d().a();
        }
        if (xMAAttachmentStoryFieldsModel.n() != null) {
            shareBuilder.f = xMAAttachmentStoryFieldsModel.n();
        }
        if (xMAAttachmentStoryFieldsModel.aP_() != null && xMAAttachmentStoryFieldsModel.aP_().a() != null) {
            ShareMediaBuilder shareMediaBuilder = new ShareMediaBuilder();
            if (xMAAttachmentStoryFieldsModel.aP_().a().g() == 82650203) {
                shareMediaBuilder.a = Type.VIDEO;
                shareMediaBuilder.d = xMAAttachmentStoryFieldsModel.aP_().k();
            } else if (xMAAttachmentStoryFieldsModel.aP_().a().g() == 77090322) {
                shareMediaBuilder.a = Type.PHOTO;
            } else if (xMAAttachmentStoryFieldsModel.n() != null) {
                shareMediaBuilder.a = Type.LINK;
                shareMediaBuilder.b = xMAAttachmentStoryFieldsModel.n();
            } else {
                shareMediaBuilder.a = Type.UNKNOWN;
            }
            if (xMAAttachmentStoryFieldsModel.aP_().c() != null) {
                shareMediaBuilder.c = xMAAttachmentStoryFieldsModel.aP_().c().b();
            }
            shareBuilder.g = ImmutableList.of(shareMediaBuilder.e());
        }
    }

    private void m17828b(XMAModel xMAModel, MessageBuilder messageBuilder) {
        GenieMessageFragmentModel a = xMAModel.j().a();
        MessagingActorModel a2 = a.a().a();
        UserKey userKey = new UserKey(User.Type.FACEBOOK, a2.b());
        messageBuilder.e = new ParticipantInfo(userKey, a2.c());
        UserCache userCache = (UserCache) this.f17838d.get();
        if (userCache != null && userCache.a(userKey) == null) {
            UserBuilder a3 = new UserBuilder().a(User.Type.FACEBOOK, userKey.b());
            a3.g = new Name(a2.c());
            a3 = a3;
            a3.H = true;
            a3 = a3;
            if (!(a2.d() == null || a2.d().a() == null || a2.d().a().a() == null)) {
                ImageModel a4 = a2.d().a();
                a3.p = new PicSquare(ImmutableList.of(new PicSquareUrlWithSize(a4.b(), a4.a())));
            }
            List asList = Arrays.asList(new User[]{a3.aa()});
            userCache.a(asList);
            this.f17835a.m10939a(asList);
        }
        XMAAttachmentStoryFieldsModel b = a.b();
        if (b == null) {
            messageBuilder.G = null;
            return;
        }
        Builder builder = new Builder();
        builder.b = xMAModel.b();
        builder = builder;
        builder.c = xMAModel.k();
        builder = builder;
        builder.d = XMAAttachmentStoryFieldsModel.a(b);
        messageBuilder.G = builder.a();
    }
}
