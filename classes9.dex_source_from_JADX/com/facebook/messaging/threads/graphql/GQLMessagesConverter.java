package com.facebook.messaging.threads.graphql;

import android.net.Uri;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLMessageImageType;
import com.facebook.graphql.enums.GraphQLMessageVideoType;
import com.facebook.graphql.enums.GraphQLMessengerAdPropertyType;
import com.facebook.graphql.enums.GraphQLPageAdminReplyType;
import com.facebook.graphql.enums.GraphQLPeerToPeerPaymentMessageType;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.graphql.fetch.GQLUserConverter;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.GenericAdminMessageFieldsModel.ExtensibleMessageAdminTextModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.GenericAdminMessageFieldsModel.ExtensibleMessageAdminTextModel.BotItemsModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.GenericAdminMessageFieldsModel.ExtensibleMessageAdminTextModel.NicknameChoicesModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.ImageInfoModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.MessageInfoModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.MessageInfoModel.BlobAttachmentsModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.MessageInfoModel.BlobAttachmentsModel.OriginalDimensionsModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.MessageInfoModel.CustomizationsModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.MessageVideoAttachmentModel.StreamingImageThumbnailModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.MessagesModel;
import com.facebook.messaging.graphql.threads.UserInfoModels.ParticipantInfoModel;
import com.facebook.messaging.model.attachment.AttachmentBuilder;
import com.facebook.messaging.model.attachment.AttachmentBuilder.UrlBuilder;
import com.facebook.messaging.model.attachment.AttachmentImageMap;
import com.facebook.messaging.model.attachment.AttachmentImageMapBuilder;
import com.facebook.messaging.model.attachment.AttachmentImageType;
import com.facebook.messaging.model.attachment.AudioData;
import com.facebook.messaging.model.attachment.ImageData;
import com.facebook.messaging.model.attachment.ImageData.Source;
import com.facebook.messaging.model.attachment.ImageUrl;
import com.facebook.messaging.model.attachment.VideoData;
import com.facebook.messaging.model.attribution.ContentAppAttribution;
import com.facebook.messaging.model.attribution.ContentAppAttributionFactory;
import com.facebook.messaging.model.messages.GenericAdminMessageInfo;
import com.facebook.messaging.model.messages.GenericAdminMessageInfo.AdProperties;
import com.facebook.messaging.model.messages.GenericAdminMessageInfo.BotChoice;
import com.facebook.messaging.model.messages.GenericAdminMessageInfo.NicknameChoice;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageBuilder;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.payment.PaymentTransactionData;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.rtc.adminmsg.model.RTCAdminMsgXMAConverter;
import com.facebook.messaging.threads.util.MessageClientTagsDeserializer;
import com.facebook.user.model.User;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.facebook.login.LoginResult */
public class GQLMessagesConverter {
    private final GQLUserConverter f17796a;
    private final GQLThreadsLogger f17797b;
    private final GQLXMAHandler f17798c;
    private final ContentAppAttributionFactory f17799d;

    /* compiled from: com.facebook.login.LoginResult */
    public /* synthetic */ class C21011 {
        public static final /* synthetic */ int[] f17795a = new int[GraphQLPeerToPeerPaymentMessageType.values().length];

        static {
            try {
                f17795a[GraphQLPeerToPeerPaymentMessageType.SENT_IN_GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f17795a[GraphQLPeerToPeerPaymentMessageType.CANCELED_SENDER_RISK.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f17795a[GraphQLPeerToPeerPaymentMessageType.CANCELED_DECLINED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f17795a[GraphQLPeerToPeerPaymentMessageType.CANCELED_RECIPIENT_RISK.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f17795a[GraphQLPeerToPeerPaymentMessageType.CANCELED_EXPIRED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f17795a[GraphQLPeerToPeerPaymentMessageType.CANCELED_SAME_CARD.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f17795a[GraphQLPeerToPeerPaymentMessageType.CANCELED_CHARGEBACK.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f17795a[GraphQLPeerToPeerPaymentMessageType.CANCELED_SYSTEM_FAIL.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    /* compiled from: com.facebook.login.LoginResult */
    enum ImageAttachmentType {
        ANIMATED_IMAGE,
        REGULAR_IMAGE
    }

    public static GQLMessagesConverter m17739b(InjectorLike injectorLike) {
        return new GQLMessagesConverter(GQLUserConverter.a(injectorLike), GQLThreadsLogger.m17795b(injectorLike), GQLXMAHandler.m17825b(injectorLike), ContentAppAttributionFactory.b(injectorLike));
    }

    public static GQLMessagesConverter m17734a(InjectorLike injectorLike) {
        return m17739b(injectorLike);
    }

    @Inject
    public GQLMessagesConverter(GQLUserConverter gQLUserConverter, GQLThreadsLogger gQLThreadsLogger, GQLXMAHandler gQLXMAHandler, ContentAppAttributionFactory contentAppAttributionFactory) {
        this.f17796a = gQLUserConverter;
        this.f17797b = gQLThreadsLogger;
        this.f17798c = gQLXMAHandler;
        this.f17799d = contentAppAttributionFactory;
    }

    final MessagesCollection m17744a(ThreadKey threadKey, MessagesModel messagesModel, User user) {
        boolean z;
        Builder builder = new Builder();
        ImmutableList a = messagesModel.a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            builder.c(m17742a(threadKey, (MessageInfoModel) a.get(i), user));
        }
        ImmutableList reverse = builder.b().reverse();
        Preconditions.checkNotNull(messagesModel.j());
        if (messagesModel.j().a()) {
            z = false;
        } else {
            z = true;
        }
        return new MessagesCollection(threadKey, reverse, z);
    }

    public final Message m17742a(ThreadKey threadKey, MessageInfoModel messageInfoModel, User user) {
        if (messageInfoModel.a() == null) {
            throw new InvalidParameterException("Invalid input model");
        }
        MessageType messageType;
        MessageBuilder newBuilder = Message.newBuilder();
        ParticipantInfo a = GQLUserConverter.a(messageInfoModel.x());
        newBuilder.a(a);
        int g = messageInfoModel.a().g();
        String b = a.b.b();
        boolean z = messageInfoModel.j() || messageInfoModel.k();
        MessageType a2 = m17743a(g, user, b, z, messageInfoModel.D(), messageInfoModel.z());
        if (a2 == MessageType.P2P_PAYMENT || a2 == MessageType.P2P_PAYMENT_CANCELED || a2 == MessageType.P2P_PAYMENT_GROUP) {
            m17738a(newBuilder, messageInfoModel);
        } else if (a2 == MessageType.ADMIN) {
            String str;
            AdProperties adProperties;
            String str2;
            boolean p;
            newBuilder.b(messageInfoModel.E());
            String str3 = null;
            String str4 = null;
            String str5 = null;
            String str6 = null;
            int i = 0;
            ImmutableList immutableList = null;
            ImmutableList immutableList2 = null;
            ImmutableList immutableList3 = null;
            ImmutableList immutableList4 = null;
            String str7 = null;
            String str8 = null;
            boolean z2 = false;
            String str9 = null;
            ExtensibleMessageAdminTextModel r = messageInfoModel.r();
            if (r != null) {
                str3 = r.x();
                str4 = r.y();
                str5 = r.r();
                str6 = r.w();
                i = r.z();
                immutableList = r.l();
                immutableList2 = r.m();
                immutableList3 = m17735a(r.s());
                immutableList4 = m17740b(r.k());
                str7 = r.n();
                str8 = r.v();
                z2 = r.q();
                if (r.t() != null) {
                    str9 = r.t().a();
                }
                AdProperties a3 = m17733a(r.a(), r.j());
                b = r.o();
                g = r.u();
                str = b;
                adProperties = a3;
                str2 = str9;
                p = r.p();
            } else {
                g = 0;
                str = null;
                adProperties = null;
                str2 = null;
                p = false;
            }
            newBuilder.a(GenericAdminMessageInfo.newBuilder().a(messageInfoModel.s()).a(str3).b(str4).c(str5).d(str6).c(i).a(immutableList).b(immutableList2).c(immutableList3).d(immutableList4).e(str7).f(str8).a(z2).g(str2).a(adProperties).h(str).d(g).b(p).a());
        } else if (messageInfoModel.v() == null || messageInfoModel.v().a() == null) {
            if (messageInfoModel.E() == null) {
                this.f17797b.m17804a("Trying to convert a message without a snippet, of type " + messageInfoModel.a().e());
            }
            newBuilder.b(messageInfoModel.E());
        } else {
            newBuilder.b(messageInfoModel.v().a());
        }
        if (messageInfoModel.a().g() == 713887575) {
            newBuilder.a(RTCAdminMsgXMAConverter.a(messageInfoModel, threadKey.d > 0 ? String.valueOf(threadKey.d) : null));
            messageType = MessageType.CALL_LOG;
        } else if (messageInfoModel.a().g() == -804641682) {
            newBuilder.a(RTCAdminMsgXMAConverter.b(messageInfoModel, threadKey.d > 0 ? String.valueOf(threadKey.d) : null));
            messageType = MessageType.CALL_LOG;
        } else {
            messageType = a2;
        }
        if (messageType == MessageType.UNKNOWN) {
            if (messageInfoModel.u()) {
                messageType = MessageType.REGULAR;
            } else {
                messageType = MessageType.ADMIN;
            }
        }
        newBuilder.a(messageType);
        newBuilder.a(threadKey);
        newBuilder.a(messageInfoModel.w());
        newBuilder.a(Long.parseLong(messageInfoModel.J()));
        newBuilder.d(messageInfoModel.y());
        newBuilder.a(Integer.valueOf(messageInfoModel.K()));
        newBuilder.a(MessageClientTagsDeserializer.m17833a(messageInfoModel.I()));
        newBuilder.d(messageInfoModel.t());
        newBuilder.h(messageInfoModel.m() == null ? null : messageInfoModel.m().name());
        ImmutableList n = messageInfoModel.n();
        int size = n.size();
        for (g = 0; g < size; g++) {
            CustomizationsModel customizationsModel = (CustomizationsModel) n.get(g);
            if (customizationsModel.a().equals("border") && customizationsModel.j().equals("flowers")) {
                newBuilder.e(true);
                break;
            }
        }
        List a4 = Lists.a();
        ImmutableList B = messageInfoModel.B();
        int size2 = B.size();
        for (g = 0; g < size2; g++) {
            a4.add(GQLUserConverter.a((ParticipantInfoModel) B.get(g)));
        }
        B = messageInfoModel.C();
        size2 = B.size();
        for (g = 0; g < size2; g++) {
            a4.add(GQLUserConverter.a((ParticipantInfoModel) B.get(g)));
        }
        newBuilder.c(a4);
        if (messageInfoModel.H() != null) {
            newBuilder.c(messageInfoModel.H().j());
        }
        ContentAppAttribution contentAppAttribution = null;
        List arrayList = new ArrayList();
        ImmutableList l = messageInfoModel.l();
        int size3 = l.size();
        for (int i2 = 0; i2 < size3; i2++) {
            BlobAttachmentsModel blobAttachmentsModel = (BlobAttachmentsModel) l.get(i2);
            if (blobAttachmentsModel.a() == null) {
                this.f17797b.m17804a("Graphql type of attachment model is null: " + blobAttachmentsModel.t());
            } else {
                ContentAppAttribution a5;
                AttachmentBuilder attachmentBuilder = new AttachmentBuilder(blobAttachmentsModel.t(), messageInfoModel.w());
                attachmentBuilder.a(blobAttachmentsModel.t());
                attachmentBuilder.b(blobAttachmentsModel.G());
                attachmentBuilder.c(blobAttachmentsModel.y());
                attachmentBuilder.a(blobAttachmentsModel.z());
                int g2 = blobAttachmentsModel.a().g();
                switch (g2) {
                    case -1149440977:
                        attachmentBuilder.b("audio/mpeg");
                        m17736a(attachmentBuilder, blobAttachmentsModel);
                        break;
                    case -1142294092:
                        m17737a(attachmentBuilder, blobAttachmentsModel, ImageAttachmentType.REGULAR_IMAGE);
                        if (StringUtil.a(attachmentBuilder.d())) {
                            attachmentBuilder.b("image/jpeg");
                            break;
                        }
                        break;
                    case -1130404652:
                        m17741b(attachmentBuilder, blobAttachmentsModel);
                        break;
                    case -702610223:
                        m17737a(attachmentBuilder, blobAttachmentsModel, ImageAttachmentType.ANIMATED_IMAGE);
                        break;
                    case 794342915:
                        break;
                    default:
                        this.f17797b.m17808b(g2);
                        continue;
                }
                if (contentAppAttribution == null) {
                    a5 = this.f17799d.a(blobAttachmentsModel);
                } else {
                    a5 = contentAppAttribution;
                }
                arrayList.add(attachmentBuilder.k());
                contentAppAttribution = a5;
            }
        }
        newBuilder.a(arrayList);
        newBuilder.a(contentAppAttribution);
        this.f17798c.m17829a(messageInfoModel.q(), newBuilder);
        return newBuilder.R();
    }

    @Nullable
    private static ImmutableList<NicknameChoice> m17735a(@Nullable ImmutableList<NicknameChoicesModel> immutableList) {
        if (immutableList == null) {
            return null;
        }
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            NicknameChoicesModel nicknameChoicesModel = (NicknameChoicesModel) immutableList.get(i);
            String j = nicknameChoicesModel.j();
            if (j != null) {
                builder.c(new NicknameChoice(j, nicknameChoicesModel.a()));
            }
        }
        return builder.b();
    }

    @Nullable
    private static ImmutableList<BotChoice> m17740b(@Nullable ImmutableList<BotItemsModel> immutableList) {
        if (immutableList == null) {
            return null;
        }
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            String str;
            BotItemsModel botItemsModel = (BotItemsModel) immutableList.get(i);
            long parseLong = Long.parseLong(botItemsModel.a());
            String l = botItemsModel.l();
            String j = botItemsModel.j();
            if (botItemsModel.k() == null || botItemsModel.k().a() == null) {
                str = null;
            } else {
                str = botItemsModel.k().a().a();
            }
            builder.c(new BotChoice(parseLong, l, j, str));
        }
        return builder.b();
    }

    @Nullable
    private static AdProperties m17733a(@Nullable String str, @Nullable ImmutableList<GraphQLMessengerAdPropertyType> immutableList) {
        if (str == null && immutableList == null) {
            return null;
        }
        boolean z = immutableList != null && immutableList.contains(GraphQLMessengerAdPropertyType.OFFSITE_AD);
        return new AdProperties(str, z);
    }

    public final MessageType m17743a(int i, User user, @Nullable String str, boolean z, @Nullable GraphQLPageAdminReplyType graphQLPageAdminReplyType, @Nullable GraphQLPeerToPeerPaymentMessageType graphQLPeerToPeerPaymentMessageType) {
        MessageType messageType;
        switch (i) {
            case -1974040164:
                return MessageType.REGULAR;
            case -1316869907:
                return MessageType.REMOVE_MEMBERS;
            case -1179543865:
                return MessageType.ADD_MEMBERS;
            case -804641682:
                if (Boolean.TRUE.equals(Boolean.valueOf(z))) {
                    messageType = MessageType.VIDEO_CALL;
                } else {
                    messageType = MessageType.MISSED_VIDEO_CALL;
                }
                return messageType;
            case -234751198:
                return MessageType.ADMIN;
            case 436005231:
                if (graphQLPeerToPeerPaymentMessageType != null) {
                    switch (C21011.f17795a[graphQLPeerToPeerPaymentMessageType.ordinal()]) {
                        case 1:
                            messageType = MessageType.P2P_PAYMENT_GROUP;
                            break;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                            messageType = MessageType.P2P_PAYMENT_CANCELED;
                            break;
                        default:
                            messageType = MessageType.P2P_PAYMENT;
                            break;
                    }
                }
                messageType = MessageType.P2P_PAYMENT;
                return messageType;
            case 713887575:
                Boolean valueOf = Boolean.valueOf(z);
                boolean equal = Objects.equal(user.T.b(), str);
                if (!Boolean.TRUE.equals(valueOf)) {
                    messageType = MessageType.MISSED_CALL;
                } else if (equal) {
                    messageType = MessageType.OUTGOING_CALL;
                } else {
                    messageType = MessageType.INCOMING_CALL;
                }
                return messageType;
            case 1121897074:
                return MessageType.SET_NAME;
            case 1375543670:
                return MessageType.SET_IMAGE;
            case 1790983402:
                if (graphQLPageAdminReplyType == GraphQLPageAdminReplyType.COMMERCE_LINK) {
                    return MessageType.COMMERCE_LINK;
                }
                if (graphQLPageAdminReplyType == GraphQLPageAdminReplyType.COMMERCE_UNLINK) {
                    return MessageType.COMMERCE_UNLINK;
                }
                if (graphQLPageAdminReplyType == GraphQLPageAdminReplyType.ACTIVITY_REPLY) {
                    return MessageType.ACTIVITY_REPLY;
                }
                this.f17797b.m17797a(i);
                return MessageType.UNKNOWN;
            default:
                this.f17797b.m17797a(i);
                return MessageType.UNKNOWN;
        }
    }

    private static void m17738a(MessageBuilder messageBuilder, MessageInfoModel messageInfoModel) {
        messageBuilder.f = messageInfoModel.E();
        if (messageInfoModel.A() != null) {
            messageBuilder.B = new PaymentTransactionData(messageInfoModel.A(), 0, 0, 0, null);
        }
    }

    private static void m17737a(AttachmentBuilder attachmentBuilder, BlobAttachmentsModel blobAttachmentsModel, ImageAttachmentType imageAttachmentType) {
        boolean n;
        ImageInfoModel p;
        ImageInfoModel j;
        ImageInfoModel o;
        ImageInfoModel imageInfoModel;
        ImageInfoModel imageInfoModel2;
        ImageInfoModel imageInfoModel3;
        int i;
        Source source;
        String str;
        ImageInfoModel imageInfoModel4;
        ImageInfoModel imageInfoModel5;
        int i2;
        int a;
        int i3;
        if (imageAttachmentType == ImageAttachmentType.ANIMATED_IMAGE) {
            Source source2 = Source.NONQUICKCAM;
            a = (int) blobAttachmentsModel.m().a();
            int j2 = (int) blobAttachmentsModel.m().j();
            n = blobAttachmentsModel.n();
            p = blobAttachmentsModel.p();
            ImageInfoModel s = blobAttachmentsModel.s();
            ImageInfoModel r = blobAttachmentsModel.r();
            ImageInfoModel q = blobAttachmentsModel.q();
            j = blobAttachmentsModel.j();
            o = blobAttachmentsModel.o();
            imageInfoModel = j;
            j = blobAttachmentsModel.l();
            imageInfoModel2 = p;
            p = q;
            i3 = j2;
            imageInfoModel3 = r;
            i = a;
            source = source2;
            str = null;
            imageInfoModel4 = o;
            o = blobAttachmentsModel.k();
            imageInfoModel5 = s;
            i2 = i3;
        } else if (imageAttachmentType == ImageAttachmentType.REGULAR_IMAGE) {
            Source source3;
            if (blobAttachmentsModel.E() == GraphQLMessageImageType.MESSENGER_CAM) {
                source3 = Source.QUICKCAM;
            } else {
                source3 = Source.NONQUICKCAM;
            }
            int a2 = (int) blobAttachmentsModel.I().a();
            a = (int) blobAttachmentsModel.I().j();
            String H = blobAttachmentsModel.H();
            n = blobAttachmentsModel.K();
            imageInfoModel3 = blobAttachmentsModel.A();
            p = blobAttachmentsModel.D();
            imageInfoModel = null;
            j = null;
            imageInfoModel2 = imageInfoModel3;
            imageInfoModel3 = blobAttachmentsModel.C();
            i2 = a;
            source = source3;
            i3 = a2;
            str = H;
            imageInfoModel4 = null;
            o = null;
            imageInfoModel5 = p;
            p = blobAttachmentsModel.B();
            i = i3;
        } else {
            throw new UnsupportedOperationException("Unsupported image attachment type: " + imageAttachmentType);
        }
        attachmentBuilder.a(new ImageData(i, i2, m17731a(imageInfoModel2, imageInfoModel5, imageInfoModel3, p), m17731a(imageInfoModel, imageInfoModel4, j, o), source, n, str));
    }

    @Nullable
    private static AttachmentImageMap m17731a(ImageInfoModel imageInfoModel, ImageInfoModel imageInfoModel2, ImageInfoModel imageInfoModel3, ImageInfoModel imageInfoModel4) {
        if (imageInfoModel == null && imageInfoModel2 == null && imageInfoModel3 == null && imageInfoModel4 == null) {
            return null;
        }
        AttachmentImageMapBuilder newBuilder = AttachmentImageMap.newBuilder();
        if (imageInfoModel != null) {
            newBuilder.a(AttachmentImageType.FULL_SCREEN, m17732a(imageInfoModel));
        }
        if (imageInfoModel2 != null) {
            newBuilder.a(AttachmentImageType.SMALL_PREVIEW, m17732a(imageInfoModel2));
        }
        if (imageInfoModel3 != null) {
            newBuilder.a(AttachmentImageType.MEDIUM_PREVIEW, m17732a(imageInfoModel3));
        }
        if (imageInfoModel4 != null) {
            newBuilder.a(AttachmentImageType.LARGE_PREVIEW, m17732a(imageInfoModel4));
        }
        return newBuilder.b();
    }

    private static ImageUrl m17732a(ImageInfoModel imageInfoModel) {
        if (imageInfoModel == null) {
            return null;
        }
        UrlBuilder urlBuilder = new UrlBuilder();
        urlBuilder.b = imageInfoModel.a();
        urlBuilder = urlBuilder;
        urlBuilder.a = imageInfoModel.k();
        urlBuilder = urlBuilder;
        urlBuilder.c = imageInfoModel.j();
        return urlBuilder.d();
    }

    private static void m17736a(AttachmentBuilder attachmentBuilder, BlobAttachmentsModel blobAttachmentsModel) {
        attachmentBuilder.i = new AudioData(blobAttachmentsModel.F());
    }

    private void m17741b(AttachmentBuilder attachmentBuilder, BlobAttachmentsModel blobAttachmentsModel) {
        StreamingImageThumbnailModel M = blobAttachmentsModel.M();
        String u = blobAttachmentsModel.u();
        OriginalDimensionsModel I = blobAttachmentsModel.I();
        int J = blobAttachmentsModel.J();
        if (M == null || u == null || I == null || J <= 0) {
            this.f17797b.m17800a(blobAttachmentsModel);
            return;
        }
        VideoData.Source source;
        GraphQLMessageVideoType N = blobAttachmentsModel.N();
        if (N != GraphQLMessageVideoType.FILE_ATTACHMENT) {
            if (N == GraphQLMessageVideoType.RECORDED_VIDEO) {
                source = VideoData.Source.QUICKCAM;
                attachmentBuilder.h = new VideoData((int) I.a(), (int) I.j(), blobAttachmentsModel.L(), J / 1000, source, Uri.parse(u), Uri.parse(M.a()));
            } else if (N == null) {
                this.f17797b.m17804a("Graphql type of video attachment is null: " + blobAttachmentsModel.t());
            } else {
                this.f17797b.m17799a(N);
            }
        }
        source = VideoData.Source.NONQUICKCAM;
        attachmentBuilder.h = new VideoData((int) I.a(), (int) I.j(), blobAttachmentsModel.L(), J / 1000, source, Uri.parse(u), Uri.parse(M.a()));
    }
}
