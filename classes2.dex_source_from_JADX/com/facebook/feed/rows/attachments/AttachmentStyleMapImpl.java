package com.facebook.feed.rows.attachments;

import android.content.Context;
import com.facebook.checkin.socialsearch.feed.SocialSearchAttachmentPartDefinition;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.AnimatedImageShareAttachmentSelectorPartDefinition;
import com.facebook.feed.rows.sections.attachments.AvatarAttachmentPartDefinition;
import com.facebook.feed.rows.sections.attachments.AvatarListAttachmentPartDefinition;
import com.facebook.feed.rows.sections.attachments.CenteredTextPartDefinition;
import com.facebook.feed.rows.sections.attachments.CouponAttachmentPartDefinition;
import com.facebook.feed.rows.sections.attachments.EventAttachmentPartDefinition;
import com.facebook.feed.rows.sections.attachments.EventTicketAttachmentPartDefinition;
import com.facebook.feed.rows.sections.attachments.FileUploadAttachmentPartDefinition;
import com.facebook.feed.rows.sections.attachments.LifeEventAttachmentGroupPartDefinition;
import com.facebook.feed.rows.sections.attachments.MediaQuestionPollAttachmentPartDefinition;
import com.facebook.feed.rows.sections.attachments.NoteAttachmentPartDefinition;
import com.facebook.feed.rows.sections.attachments.PhotoAttachmentSelector;
import com.facebook.feed.rows.sections.attachments.PollAttachmentSelectorPartDefinition;
import com.facebook.feed.rows.sections.attachments.ReadingAttachmentPartDefinition;
import com.facebook.feed.rows.sections.attachments.SportsMatchAttachmentGroupPartDefinition;
import com.facebook.feed.rows.sections.attachments.TranscodedAnimatedImageShareAttachmentPartDefinition;
import com.facebook.feed.rows.sections.attachments.UnavailableAttachmentPartDefinition;
import com.facebook.feed.rows.sections.attachments.linkshare.InstagramAttachmentPartDefinition;
import com.facebook.feed.rows.sections.attachments.linkshare.LargeImageAttachmentPartDefinition;
import com.facebook.feed.rows.sections.attachments.linkshare.QuoteShareAttachmentGroupDefinition;
import com.facebook.feed.rows.sections.attachments.linkshare.QuoteShareQuoteOnlyGroupDefinition;
import com.facebook.feed.rows.sections.attachments.linkshare.ShareAttachmentImageFormatSelector;
import com.facebook.feed.rows.sections.attachments.linkshare.VideoShareAttachmentPartDefinition;
import com.facebook.feed.rows.sections.attachments.linkshare.VideoShareHighlightedAttachmentSelector;
import com.facebook.feed.rows.sections.attachments.places.LocationMultiRowAttachmentSelectorPartDefinition;
import com.facebook.feedplugins.attachments.album.AlbumAttachmentSelector;
import com.facebook.feedplugins.attachments.collage.CollageAttachmentPartDefinition;
import com.facebook.feedplugins.attachments.list.ListAttachmentRootPartDefinition;
import com.facebook.feedplugins.fitness.FitnessAttachmentPartSelector;
import com.facebook.feedplugins.games.QuicksilverContentAttachmentGroupPartDefinition;
import com.facebook.feedplugins.goodwill.CulturalMomentAttachmentPartDefinition;
import com.facebook.feedplugins.goodwill.FriendversaryCardAttachmentGroupPartDefinition;
import com.facebook.feedplugins.goodwill.FriendversaryDataCardAttachmentGroupPartDefinition;
import com.facebook.feedplugins.goodwill.FriendversaryOrFaceversaryCollageAttachmentGroupPartDefinition;
import com.facebook.feedplugins.goodwill.ThrowbackVideoCardAttachmentGroupPartDefinition;
import com.facebook.feedplugins.greetingcard.GreetingCardAttachmentPartDefinition;
import com.facebook.feedplugins.groupcommerce.GroupCommerceItemAttachmentPartDefinition;
import com.facebook.feedplugins.groupcommerce.GroupCommerceItemMarkAsSoldAttachmentPartDefinition;
import com.facebook.feedplugins.instantarticles.SharedInstantArticleContentAttachmentGroupPartDefinition;
import com.facebook.feedplugins.multishare.MultiShareAttachmentPartDefinition;
import com.facebook.feedplugins.multishare.MultiShareSingleTextAttachmentPartDefinition;
import com.facebook.feedplugins.musicstory.partselector.MusicStoryAttachmentPartSelector;
import com.facebook.feedplugins.opengraph.OpenGraphAttachmentPartSelector;
import com.facebook.feedplugins.richmedia.RichMediaAttachmentSelectorPartDefinition;
import com.facebook.feedplugins.socialgood.FundraiserPageAttachmentGroupPartDefinition;
import com.facebook.feedplugins.socialgood.FundraiserPersonToCharityAttachmentGroupPartDefinition;
import com.facebook.feedplugins.video.AvatarVideoAttachmentSelectorPartDefinition;
import com.facebook.feedplugins.video.VideoAttachmentGroupDefinition;
import com.facebook.gametime.ui.components.partdefinition.GametimeSportsPlayFeedAttachmentPartDefinition;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.PartWithIsNeeded;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import javax.annotation.Nullable;
import javax.inject.Provider;

@ContextScoped
/* compiled from: initFromMutableFlatBuffer is not supported */
public final class AttachmentStyleMapImpl implements AttachmentStyleMap {
    private static AttachmentStyleMapImpl f20084Y;
    private static final Object f20085Z = new Object();
    @Inject
    volatile Provider<VideoShareAttachmentPartDefinition> f20086A = UltralightRuntime.f367a;
    @Inject
    volatile Provider<ShareAttachmentImageFormatSelector> f20087B = UltralightRuntime.f367a;
    @Inject
    volatile Provider<QuoteShareQuoteOnlyGroupDefinition> f20088C = UltralightRuntime.f367a;
    @Inject
    volatile Provider<QuoteShareAttachmentGroupDefinition> f20089D = UltralightRuntime.f367a;
    @Inject
    volatile Provider<LargeImageAttachmentPartDefinition> f20090E = UltralightRuntime.f367a;
    @Inject
    volatile Provider<InstagramAttachmentPartDefinition> f20091F = UltralightRuntime.f367a;
    @Inject
    volatile Provider<UnavailableAttachmentPartDefinition> f20092G = UltralightRuntime.f367a;
    @Inject
    volatile Provider<TranscodedAnimatedImageShareAttachmentPartDefinition> f20093H = UltralightRuntime.f367a;
    @Inject
    volatile Provider<SportsMatchAttachmentGroupPartDefinition> f20094I = UltralightRuntime.f367a;
    @Inject
    volatile Provider<ReadingAttachmentPartDefinition> f20095J = UltralightRuntime.f367a;
    @Inject
    volatile Provider<PollAttachmentSelectorPartDefinition> f20096K = UltralightRuntime.f367a;
    @Inject
    volatile Provider<PhotoAttachmentSelector> f20097L = UltralightRuntime.f367a;
    @Inject
    volatile Provider<NoteAttachmentPartDefinition> f20098M = UltralightRuntime.f367a;
    @Inject
    volatile Provider<MediaQuestionPollAttachmentPartDefinition> f20099N = UltralightRuntime.f367a;
    @Inject
    volatile Provider<LifeEventAttachmentGroupPartDefinition> f20100O = UltralightRuntime.f367a;
    @Inject
    volatile Provider<FileUploadAttachmentPartDefinition> f20101P = UltralightRuntime.f367a;
    @Inject
    volatile Provider<EventTicketAttachmentPartDefinition> f20102Q = UltralightRuntime.f367a;
    @Inject
    volatile Provider<EventAttachmentPartDefinition> f20103R = UltralightRuntime.f367a;
    @Inject
    volatile Provider<CouponAttachmentPartDefinition> f20104S = UltralightRuntime.f367a;
    @Inject
    volatile Provider<CenteredTextPartDefinition> f20105T = UltralightRuntime.f367a;
    @Inject
    volatile Provider<AvatarListAttachmentPartDefinition> f20106U = UltralightRuntime.f367a;
    @Inject
    volatile Provider<AvatarAttachmentPartDefinition> f20107V = UltralightRuntime.f367a;
    @Inject
    volatile Provider<AnimatedImageShareAttachmentSelectorPartDefinition> f20108W = UltralightRuntime.f367a;
    @Inject
    volatile Provider<SocialSearchAttachmentPartDefinition> f20109X = UltralightRuntime.f367a;
    @Inject
    volatile Provider<GametimeSportsPlayFeedAttachmentPartDefinition> f20110a = UltralightRuntime.f367a;
    @Inject
    volatile Provider<VideoAttachmentGroupDefinition> f20111b = UltralightRuntime.f367a;
    @Inject
    volatile Provider<AvatarVideoAttachmentSelectorPartDefinition> f20112c = UltralightRuntime.f367a;
    @Inject
    volatile Provider<FundraiserPersonToCharityAttachmentGroupPartDefinition> f20113d = UltralightRuntime.f367a;
    @Inject
    volatile Provider<FundraiserPageAttachmentGroupPartDefinition> f20114e = UltralightRuntime.f367a;
    @Inject
    volatile Provider<RichMediaAttachmentSelectorPartDefinition> f20115f = UltralightRuntime.f367a;
    @Inject
    volatile Provider<OpenGraphAttachmentPartSelector> f20116g = UltralightRuntime.f367a;
    @Inject
    volatile Provider<MusicStoryAttachmentPartSelector> f20117h = UltralightRuntime.f367a;
    @Inject
    volatile Provider<MultiShareSingleTextAttachmentPartDefinition> f20118i = UltralightRuntime.f367a;
    @Inject
    volatile Provider<MultiShareAttachmentPartDefinition> f20119j = UltralightRuntime.f367a;
    @Inject
    volatile Provider<SharedInstantArticleContentAttachmentGroupPartDefinition> f20120k = UltralightRuntime.f367a;
    @Inject
    volatile Provider<GroupCommerceItemMarkAsSoldAttachmentPartDefinition> f20121l = UltralightRuntime.f367a;
    @Inject
    volatile Provider<GroupCommerceItemAttachmentPartDefinition> f20122m = UltralightRuntime.f367a;
    @Inject
    volatile Provider<GreetingCardAttachmentPartDefinition> f20123n = UltralightRuntime.f367a;
    @Inject
    volatile Provider<ThrowbackVideoCardAttachmentGroupPartDefinition> f20124o = UltralightRuntime.f367a;
    @Inject
    volatile Provider<FriendversaryOrFaceversaryCollageAttachmentGroupPartDefinition> f20125p = UltralightRuntime.f367a;
    @Inject
    volatile Provider<FriendversaryDataCardAttachmentGroupPartDefinition> f20126q = UltralightRuntime.f367a;
    @Inject
    volatile Provider<FriendversaryCardAttachmentGroupPartDefinition> f20127r = UltralightRuntime.f367a;
    @Inject
    volatile Provider<CulturalMomentAttachmentPartDefinition> f20128s = UltralightRuntime.f367a;
    @Inject
    volatile Provider<QuicksilverContentAttachmentGroupPartDefinition> f20129t = UltralightRuntime.f367a;
    @Inject
    volatile Provider<FitnessAttachmentPartSelector> f20130u = UltralightRuntime.f367a;
    @Inject
    volatile Provider<ListAttachmentRootPartDefinition> f20131v = UltralightRuntime.f367a;
    @Inject
    volatile Provider<CollageAttachmentPartDefinition> f20132w = UltralightRuntime.f367a;
    @Inject
    volatile Provider<AlbumAttachmentSelector> f20133x = UltralightRuntime.f367a;
    @Inject
    volatile Provider<LocationMultiRowAttachmentSelectorPartDefinition> f20134y = UltralightRuntime.f367a;
    @Inject
    volatile Provider<VideoShareHighlightedAttachmentSelector> f20135z = UltralightRuntime.f367a;

    private static AttachmentStyleMapImpl m27802b(InjectorLike injectorLike) {
        AttachmentStyleMapImpl attachmentStyleMapImpl = new AttachmentStyleMapImpl();
        attachmentStyleMapImpl.m27801a(IdBasedProvider.m1811a(injectorLike, 6771), IdBasedProvider.m1811a(injectorLike, 2064), IdBasedProvider.m1811a(injectorLike, 6622), IdBasedProvider.m1811a(injectorLike, 6559), IdBasedProvider.m1811a(injectorLike, 6558), IdBasedProvider.m1811a(injectorLike, 6534), IdBasedProvider.m1811a(injectorLike, 6428), IdBasedProvider.m1811a(injectorLike, 6395), IdBasedProvider.m1811a(injectorLike, 6377), IdBasedProvider.m1811a(injectorLike, 1935), IdBasedProvider.m1811a(injectorLike, 6366), IdBasedProvider.m1811a(injectorLike, 6334), IdBasedProvider.m1811a(injectorLike, 6331), IdBasedProvider.m1811a(injectorLike, 6318), IdBasedProvider.m1811a(injectorLike, 6293), IdBasedProvider.m1811a(injectorLike, 6257), IdBasedProvider.m1811a(injectorLike, 6248), IdBasedProvider.m1811a(injectorLike, 6246), IdBasedProvider.m1811a(injectorLike, 6238), IdBasedProvider.m1811a(injectorLike, 6230), IdBasedProvider.m1811a(injectorLike, 6223), IdBasedProvider.m1811a(injectorLike, 6180), IdBasedProvider.m1811a(injectorLike, 1800), IdBasedProvider.m1811a(injectorLike, 1799), IdBasedProvider.m1811a(injectorLike, 1575), IdBasedProvider.m1811a(injectorLike, 6017), IdBasedProvider.m1811a(injectorLike, 1571), IdBasedProvider.m1811a(injectorLike, 1566), IdBasedProvider.m1811a(injectorLike, 6011), IdBasedProvider.m1811a(injectorLike, 6010), IdBasedProvider.m1811a(injectorLike, 6009), IdBasedProvider.m1811a(injectorLike, 6008), IdBasedProvider.m1811a(injectorLike, 6000), IdBasedProvider.m1811a(injectorLike, 5999), IdBasedProvider.m1811a(injectorLike, 5993), IdBasedProvider.m1811a(injectorLike, 5991), IdBasedProvider.m1811a(injectorLike, 5989), IdBasedProvider.m1811a(injectorLike, 1531), IdBasedProvider.m1811a(injectorLike, 5988), IdBasedProvider.m1811a(injectorLike, 5985), IdBasedProvider.m1811a(injectorLike, 5982), IdBasedProvider.m1811a(injectorLike, 5979), IdBasedProvider.m1811a(injectorLike, 5978), IdBasedProvider.m1811a(injectorLike, 1523), IdBasedProvider.m1811a(injectorLike, 5977), IdBasedProvider.m1811a(injectorLike, 5976), IdBasedProvider.m1811a(injectorLike, 5975), IdBasedProvider.m1811a(injectorLike, 5973), IdBasedProvider.m1811a(injectorLike, 5972), IdBasedProvider.m1811a(injectorLike, 5040));
        return attachmentStyleMapImpl;
    }

    private void m27801a(Provider<GametimeSportsPlayFeedAttachmentPartDefinition> provider, Provider<VideoAttachmentGroupDefinition> provider2, Provider<AvatarVideoAttachmentSelectorPartDefinition> provider3, Provider<FundraiserPersonToCharityAttachmentGroupPartDefinition> provider4, Provider<FundraiserPageAttachmentGroupPartDefinition> provider5, Provider<RichMediaAttachmentSelectorPartDefinition> provider6, Provider<OpenGraphAttachmentPartSelector> provider7, Provider<MusicStoryAttachmentPartSelector> provider8, Provider<MultiShareSingleTextAttachmentPartDefinition> provider9, Provider<MultiShareAttachmentPartDefinition> provider10, Provider<SharedInstantArticleContentAttachmentGroupPartDefinition> provider11, Provider<GroupCommerceItemMarkAsSoldAttachmentPartDefinition> provider12, Provider<GroupCommerceItemAttachmentPartDefinition> provider13, Provider<GreetingCardAttachmentPartDefinition> provider14, Provider<ThrowbackVideoCardAttachmentGroupPartDefinition> provider15, Provider<FriendversaryOrFaceversaryCollageAttachmentGroupPartDefinition> provider16, Provider<FriendversaryDataCardAttachmentGroupPartDefinition> provider17, Provider<FriendversaryCardAttachmentGroupPartDefinition> provider18, Provider<CulturalMomentAttachmentPartDefinition> provider19, Provider<QuicksilverContentAttachmentGroupPartDefinition> provider20, Provider<FitnessAttachmentPartSelector> provider21, Provider<ListAttachmentRootPartDefinition> provider22, Provider<CollageAttachmentPartDefinition> provider23, Provider<AlbumAttachmentSelector> provider24, Provider<LocationMultiRowAttachmentSelectorPartDefinition> provider25, Provider<VideoShareHighlightedAttachmentSelector> provider26, Provider<VideoShareAttachmentPartDefinition> provider27, Provider<ShareAttachmentImageFormatSelector> provider28, Provider<QuoteShareQuoteOnlyGroupDefinition> provider29, Provider<QuoteShareAttachmentGroupDefinition> provider30, Provider<LargeImageAttachmentPartDefinition> provider31, Provider<InstagramAttachmentPartDefinition> provider32, Provider<UnavailableAttachmentPartDefinition> provider33, Provider<TranscodedAnimatedImageShareAttachmentPartDefinition> provider34, Provider<SportsMatchAttachmentGroupPartDefinition> provider35, Provider<ReadingAttachmentPartDefinition> provider36, Provider<PollAttachmentSelectorPartDefinition> provider37, Provider<PhotoAttachmentSelector> provider38, Provider<NoteAttachmentPartDefinition> provider39, Provider<MediaQuestionPollAttachmentPartDefinition> provider40, Provider<LifeEventAttachmentGroupPartDefinition> provider41, Provider<FileUploadAttachmentPartDefinition> provider42, Provider<EventTicketAttachmentPartDefinition> provider43, Provider<EventAttachmentPartDefinition> provider44, Provider<CouponAttachmentPartDefinition> provider45, Provider<CenteredTextPartDefinition> provider46, Provider<AvatarListAttachmentPartDefinition> provider47, Provider<AvatarAttachmentPartDefinition> provider48, Provider<AnimatedImageShareAttachmentSelectorPartDefinition> provider49, Provider<SocialSearchAttachmentPartDefinition> provider50) {
        this.f20110a = provider;
        this.f20111b = provider2;
        this.f20112c = provider3;
        this.f20113d = provider4;
        this.f20114e = provider5;
        this.f20115f = provider6;
        this.f20116g = provider7;
        this.f20117h = provider8;
        this.f20118i = provider9;
        this.f20119j = provider10;
        this.f20120k = provider11;
        this.f20121l = provider12;
        this.f20122m = provider13;
        this.f20123n = provider14;
        this.f20124o = provider15;
        this.f20125p = provider16;
        this.f20126q = provider17;
        this.f20127r = provider18;
        this.f20128s = provider19;
        this.f20129t = provider20;
        this.f20130u = provider21;
        this.f20131v = provider22;
        this.f20132w = provider23;
        this.f20133x = provider24;
        this.f20134y = provider25;
        this.f20135z = provider26;
        this.f20086A = provider27;
        this.f20087B = provider28;
        this.f20088C = provider29;
        this.f20089D = provider30;
        this.f20090E = provider31;
        this.f20091F = provider32;
        this.f20092G = provider33;
        this.f20093H = provider34;
        this.f20094I = provider35;
        this.f20095J = provider36;
        this.f20096K = provider37;
        this.f20097L = provider38;
        this.f20098M = provider39;
        this.f20099N = provider40;
        this.f20100O = provider41;
        this.f20101P = provider42;
        this.f20102Q = provider43;
        this.f20103R = provider44;
        this.f20104S = provider45;
        this.f20105T = provider46;
        this.f20106U = provider47;
        this.f20107V = provider48;
        this.f20108W = provider49;
        this.f20109X = provider50;
    }

    @Nullable
    public final PartWithIsNeeded<FeedProps<GraphQLStoryAttachment>> mo3126a(GraphQLStoryAttachmentStyle graphQLStoryAttachmentStyle) {
        switch (graphQLStoryAttachmentStyle.ordinal()) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return (OpenGraphAttachmentPartSelector) this.f20116g.get();
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case 14:
            case 36:
            case 105:
                return (ShareAttachmentImageFormatSelector) this.f20087B.get();
            case 3:
                return (LargeImageAttachmentPartDefinition) this.f20090E.get();
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
            case 70:
                return (PhotoAttachmentSelector) this.f20097L.get();
            case 6:
                return (AlbumAttachmentSelector) this.f20133x.get();
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return (CouponAttachmentPartDefinition) this.f20104S.get();
            case 11:
                return (PollAttachmentSelectorPartDefinition) this.f20096K.get();
            case 18:
                return (MusicStoryAttachmentPartSelector) this.f20117h.get();
            case 19:
                return (ListAttachmentRootPartDefinition) this.f20131v.get();
            case 25:
                return (AvatarListAttachmentPartDefinition) this.f20106U.get();
            case 26:
                return (AvatarAttachmentPartDefinition) this.f20107V.get();
            case 28:
                return (AvatarVideoAttachmentSelectorPartDefinition) this.f20112c.get();
            case 29:
            case 31:
                return (EventAttachmentPartDefinition) this.f20103R.get();
            case 34:
                return (LifeEventAttachmentGroupPartDefinition) this.f20100O.get();
            case 37:
            case 38:
                return (AnimatedImageShareAttachmentSelectorPartDefinition) this.f20108W.get();
            case 39:
                return (NoteAttachmentPartDefinition) this.f20098M.get();
            case 41:
                return (FileUploadAttachmentPartDefinition) this.f20101P.get();
            case 43:
                return (UnavailableAttachmentPartDefinition) this.f20092G.get();
            case 47:
            case 49:
            case 53:
            case 54:
            case 118:
                return (VideoAttachmentGroupDefinition) this.f20111b.get();
            case 50:
                return (VideoShareAttachmentPartDefinition) this.f20086A.get();
            case 51:
                return (VideoShareHighlightedAttachmentSelector) this.f20135z.get();
            case 55:
                return (LocationMultiRowAttachmentSelectorPartDefinition) this.f20134y.get();
            case 59:
                return (FitnessAttachmentPartSelector) this.f20130u.get();
            case HTTPTransportCallback.BODY_BYTES_GENERATED /*64*/:
            case 65:
            case 200:
                return (MultiShareAttachmentPartDefinition) this.f20119j.get();
            case 75:
                return (GroupCommerceItemAttachmentPartDefinition) this.f20122m.get();
            case 76:
                return (GroupCommerceItemMarkAsSoldAttachmentPartDefinition) this.f20121l.get();
            case 77:
                return (SportsMatchAttachmentGroupPartDefinition) this.f20094I.get();
            case 78:
                return (GametimeSportsPlayFeedAttachmentPartDefinition) this.f20110a.get();
            case 82:
                return (GreetingCardAttachmentPartDefinition) this.f20123n.get();
            case 85:
                return (CollageAttachmentPartDefinition) this.f20132w.get();
            case 122:
                return (MediaQuestionPollAttachmentPartDefinition) this.f20099N.get();
            case 123:
                return (RichMediaAttachmentSelectorPartDefinition) this.f20115f.get();
            case 124:
                return (InstagramAttachmentPartDefinition) this.f20091F.get();
            case 141:
                return (EventTicketAttachmentPartDefinition) this.f20102Q.get();
            case 144:
            case 145:
                return (TranscodedAnimatedImageShareAttachmentPartDefinition) this.f20093H.get();
            case 146:
                return (FundraiserPageAttachmentGroupPartDefinition) this.f20114e.get();
            case 147:
                return (FundraiserPersonToCharityAttachmentGroupPartDefinition) this.f20113d.get();
            case 148:
            case 149:
                return (FriendversaryCardAttachmentGroupPartDefinition) this.f20127r.get();
            case 150:
            case 151:
            case 153:
                return (FriendversaryOrFaceversaryCollageAttachmentGroupPartDefinition) this.f20125p.get();
            case 152:
                return (FriendversaryDataCardAttachmentGroupPartDefinition) this.f20126q.get();
            case 157:
                return (CulturalMomentAttachmentPartDefinition) this.f20128s.get();
            case 160:
                return (ReadingAttachmentPartDefinition) this.f20095J.get();
            case 170:
                return (QuoteShareAttachmentGroupDefinition) this.f20089D.get();
            case 172:
                return (CenteredTextPartDefinition) this.f20105T.get();
            case 176:
                return (QuoteShareQuoteOnlyGroupDefinition) this.f20088C.get();
            case 180:
                return (SocialSearchAttachmentPartDefinition) this.f20109X.get();
            case 183:
            case 184:
                return (SharedInstantArticleContentAttachmentGroupPartDefinition) this.f20120k.get();
            case 194:
                return (QuicksilverContentAttachmentGroupPartDefinition) this.f20129t.get();
            case 196:
                return (ThrowbackVideoCardAttachmentGroupPartDefinition) this.f20124o.get();
            case 203:
                return (MultiShareSingleTextAttachmentPartDefinition) this.f20118i.get();
            default:
                return null;
        }
    }

    public static AttachmentStyleMapImpl m27800a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AttachmentStyleMapImpl b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20085Z) {
                AttachmentStyleMapImpl attachmentStyleMapImpl;
                if (a2 != null) {
                    attachmentStyleMapImpl = (AttachmentStyleMapImpl) a2.mo818a(f20085Z);
                } else {
                    attachmentStyleMapImpl = f20084Y;
                }
                if (attachmentStyleMapImpl == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27802b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20085Z, b3);
                        } else {
                            f20084Y = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = attachmentStyleMapImpl;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
