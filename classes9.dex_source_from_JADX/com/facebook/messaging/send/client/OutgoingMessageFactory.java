package com.facebook.messaging.send.client;

import android.content.Context;
import android.support.annotation.Nullable;
import com.facebook.android.maps.model.LatLng;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.Clock;
import com.facebook.common.util.StringUtil;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.maps.ExternalMapLauncher;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.database.threads.DbClock;
import com.facebook.messaging.event.sending.EventMessageAttachmentCreator;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.MessageLocationFragmentModel.CoordinatesModel;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.MessageLocationFragmentModel.PlaceModel;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.MessageLocationFragmentModel.PlaceModel.Builder;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.StoryAttachmentTargetFragmentModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.facebook.messaging.location.sending.LocationMessageAttachmentCreator;
import com.facebook.messaging.location.sending.NearbyPlace;
import com.facebook.messaging.model.attachment.Attachment;
import com.facebook.messaging.model.attribution.ContentAppAttribution;
import com.facebook.messaging.model.messagemetadata.PlatformMetadata;
import com.facebook.messaging.model.messagemetadata.PlatformMetadataType;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.Message.ChannelSource;
import com.facebook.messaging.model.messages.MessageBuilder;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.messages.Publicity;
import com.facebook.messaging.model.mms.MmsData;
import com.facebook.messaging.model.payment.SentPayment;
import com.facebook.messaging.model.share.SentShareAttachment;
import com.facebook.messaging.model.share.Share;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ActionIdHelper;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.threadview.hotlikes.HotLikesSpringConfig;
import com.facebook.share.model.ComposerAppAttribution;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResourceBuilder;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.facebook.zero.MessageCapAccessor;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableBiMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: deleteThreadsParams */
public class OutgoingMessageFactory {
    private static OutgoingMessageFactory f16667j;
    private static final Object f16668k = new Object();
    private final Clock f16669a;
    private final LocationMessageAttachmentCreator f16670b;
    private final EventMessageAttachmentCreator f16671c;
    private final OfflineThreadingIdGenerator f16672d;
    public final Provider<DataCache> f16673e;
    private final Provider<User> f16674f;
    private final Provider<ViewerContext> f16675g;
    public final Provider<MessageCapAccessor> f16676h;
    private final GatekeeperStoreImpl f16677i;

    private static OutgoingMessageFactory m16680b(InjectorLike injectorLike) {
        return new OutgoingMessageFactory((Clock) DbClock.a(injectorLike), new LocationMessageAttachmentCreator(ResourcesMethodAutoProvider.a(injectorLike)), new EventMessageAttachmentCreator(), OfflineThreadingIdGenerator.m16673a(injectorLike), IdBasedProvider.a(injectorLike, 2567), IdBasedProvider.a(injectorLike, 3595), IdBasedProvider.a(injectorLike, 372), IdBasedProvider.a(injectorLike, 11785), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    public static OutgoingMessageFactory m16678a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OutgoingMessageFactory b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f16668k) {
                OutgoingMessageFactory outgoingMessageFactory;
                if (a2 != null) {
                    outgoingMessageFactory = (OutgoingMessageFactory) a2.a(f16668k);
                } else {
                    outgoingMessageFactory = f16667j;
                }
                if (outgoingMessageFactory == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m16680b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f16668k, b3);
                        } else {
                            f16667j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = outgoingMessageFactory;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public OutgoingMessageFactory(Clock clock, LocationMessageAttachmentCreator locationMessageAttachmentCreator, EventMessageAttachmentCreator eventMessageAttachmentCreator, OfflineThreadingIdGenerator offlineThreadingIdGenerator, Provider<DataCache> provider, Provider<User> provider2, Provider<ViewerContext> provider3, Provider<MessageCapAccessor> provider4, GatekeeperStore gatekeeperStore) {
        this.f16669a = clock;
        this.f16670b = locationMessageAttachmentCreator;
        this.f16671c = eventMessageAttachmentCreator;
        this.f16672d = offlineThreadingIdGenerator;
        this.f16673e = provider;
        this.f16674f = provider2;
        this.f16675g = provider3;
        this.f16676h = provider4;
        this.f16677i = gatekeeperStore;
    }

    public final Message m16688a(ThreadKey threadKey, String str) {
        return m16692a(threadKey, Long.toString(this.f16672d.m16675a()), str);
    }

    public final Message m16691a(ThreadKey threadKey, String str, ImmutableMap<PlatformMetadataType, PlatformMetadata> immutableMap) {
        MessageBuilder c = m16681c(threadKey, Long.toString(this.f16672d.m16675a()));
        c.f = str;
        return c.c(immutableMap).R();
    }

    public final Message m16692a(ThreadKey threadKey, String str, String str2) {
        MessageBuilder c = m16681c(threadKey, str);
        c.f = str2;
        return c.R();
    }

    public final Message m16686a(ThreadKey threadKey, MediaResource mediaResource, String str) {
        MessageBuilder c = m16681c(threadKey, str);
        c.f = "";
        c = c;
        c.F = mediaResource.x;
        c = c;
        c.r = ImmutableList.of(mediaResource);
        return c.R();
    }

    public final Message m16699b(ThreadKey threadKey, MediaResource mediaResource, String str) {
        MessageBuilder c = m16681c(threadKey, str);
        c.f = "";
        c = c;
        c.F = mediaResource.x;
        return c.a(MmsData.a(ImmutableList.of(mediaResource))).R();
    }

    public final Message m16687a(ThreadKey threadKey, ImmutableList<MediaResource> immutableList, String str) {
        Preconditions.checkArgument(!immutableList.isEmpty());
        MessageBuilder c = m16681c(threadKey, str);
        c.f = "";
        MessageBuilder messageBuilder = c;
        messageBuilder.F = ((MediaResource) immutableList.get(0)).x;
        c = messageBuilder;
        c.r = immutableList;
        return c.R();
    }

    public final Message m16700b(ThreadKey threadKey, String str) {
        MessageBuilder a = m16676a(threadKey);
        a.k = str;
        return a.R();
    }

    public final Message m16701b(ThreadKey threadKey, String str, String str2) {
        MessageBuilder c = m16681c(threadKey, str2);
        c.k = str;
        return c.R();
    }

    public final Message m16693a(ThreadKey threadKey, String str, String str2, String str3) {
        String str4 = "small";
        if (str.equals(HotLikesSpringConfig.MEDIUM.stickerId)) {
            str4 = "medium";
        } else if (str.equals(HotLikesSpringConfig.LARGE.stickerId)) {
            str4 = "large";
        }
        MessageBuilder c = m16681c(threadKey, str2);
        c.f = str3;
        return c.a("hot_emoji_size", str4).R();
    }

    public final Message m16694a(ThreadKey threadKey, String str, String str2, List<MediaResource> list, SentShareAttachment sentShareAttachment, ComposerAppAttribution composerAppAttribution, Map<String, String> map) {
        String a = m16679a(str);
        if (map == null) {
            map = RegularImmutableBiMap.a;
        }
        MessageBuilder a2 = m16681c(threadKey, str).a(a);
        a2.f = str2;
        a2 = a2;
        a2.s = sentShareAttachment;
        a2 = a2;
        a2.E = composerAppAttribution;
        a2 = a2.b(map);
        a2.r = list;
        return a2.R();
    }

    public final Message m16702b(ThreadKey threadKey, String str, String str2, List<MediaResource> list, SentShareAttachment sentShareAttachment, ComposerAppAttribution composerAppAttribution, Map<String, String> map) {
        String a = m16679a(str);
        if (map == null) {
            map = RegularImmutableBiMap.a;
        }
        MessageBuilder a2 = m16681c(threadKey, str).a(a);
        a2.f = str2;
        a2 = a2;
        a2.s = sentShareAttachment;
        a2 = a2;
        a2.E = composerAppAttribution;
        a2 = a2.b(map);
        if (!(list == null || list.isEmpty())) {
            a2.a(MmsData.a(ImmutableList.copyOf(list)));
        }
        return a2.R();
    }

    public final Message m16682a(Message message, ThreadKey threadKey, @Nullable String str) {
        boolean z = true;
        MessageBuilder a = m16676a(threadKey);
        a.k = message.k;
        a = a;
        a.i = message.i;
        a = a;
        a.j = message.j;
        a = a;
        a.q = message.q;
        a = a.b(message.v);
        if (str == null) {
            a.f = message.f;
            a.x = message.a;
        } else {
            if (message.i.size() != 1) {
                z = false;
            }
            Preconditions.checkArgument(z);
            a.f = str;
            a.y = ((Attachment) message.i.get(0)).c;
        }
        return a.R();
    }

    public final Message m16690a(ThreadKey threadKey, String str, Share share, @Nullable XMAModel xMAModel) {
        MessageBuilder a = m16676a(threadKey);
        a.s = SentShareAttachment.a(share);
        a = a;
        a.G = xMAModel;
        a = a;
        a.f = str;
        return a.R();
    }

    public final Message m16695a(ThreadKey threadKey, String str, List<MediaResource> list, ContentAppAttribution contentAppAttribution) {
        String l = Long.toString(this.f16672d.m16675a());
        MessageBuilder c = m16681c(threadKey, l);
        c.f = str;
        c = c;
        List a = Lists.a();
        for (MediaResource a2 : list) {
            MediaResourceBuilder a3 = new MediaResourceBuilder().a(a2);
            a3.k = l;
            a.add(a3.C());
        }
        c.r = a;
        MessageBuilder messageBuilder = c;
        messageBuilder.F = contentAppAttribution;
        return messageBuilder.R();
    }

    public final Message m16703b(ThreadKey threadKey, String str, List<MediaResource> list, ContentAppAttribution contentAppAttribution) {
        MessageBuilder c = m16681c(threadKey, Long.toString(this.f16672d.m16675a()));
        c.f = str;
        c = c;
        c.F = contentAppAttribution;
        c = c;
        if (!(list == null || list.isEmpty())) {
            c.a(MmsData.a(ImmutableList.copyOf(list)));
        }
        return c.R();
    }

    public final Message m16696a(MediaResource mediaResource, ThreadKey threadKey, @Nullable String str) {
        boolean z = true;
        Preconditions.checkArgument(mediaResource.u != null);
        if (ThreadKey.d(threadKey)) {
            z = false;
        }
        Preconditions.checkArgument(z);
        MessageBuilder a = m16676a(threadKey);
        a.r = ImmutableList.of(mediaResource);
        a = a;
        a.q = ChannelSource.SEND;
        a = a;
        a.f = str;
        return a.R();
    }

    public final Message m16685a(ThreadKey threadKey, SentPayment sentPayment) {
        MessageBuilder a = m16676a(threadKey);
        a.s = SentShareAttachment.a(sentPayment);
        return a.R();
    }

    public final Message m16683a(ThreadKey threadKey, LatLng latLng) {
        MessageBuilder a = m16676a(threadKey);
        a.G = this.f16670b.m11971a(latLng);
        return a.R();
    }

    public final Message m16697b(ThreadKey threadKey, LatLng latLng) {
        MessageBuilder a = m16676a(threadKey);
        a.f = NonXmaLocationTextCreator.m16672a(latLng);
        return a.R();
    }

    public final Message m16704c(ThreadKey threadKey, LatLng latLng) {
        MessageBuilder a = m16676a(threadKey);
        a.G = this.f16670b.m11972b(latLng);
        return a.R();
    }

    public final Message m16705d(ThreadKey threadKey, LatLng latLng) {
        MessageBuilder a = m16676a(threadKey);
        a.f = NonXmaLocationTextCreator.m16672a(latLng);
        return a.R();
    }

    public final Message m16684a(ThreadKey threadKey, NearbyPlace nearbyPlace) {
        MessageBuilder a = m16676a(threadKey);
        Builder builder = new Builder();
        builder.b = nearbyPlace.f11444a;
        PlaceModel a2 = builder.a();
        CoordinatesModel c = LocationMessageAttachmentCreator.m11970c(nearbyPlace.f11447d);
        StoryAttachmentTargetFragmentModel.Builder builder2 = new StoryAttachmentTargetFragmentModel.Builder();
        builder2.aB = a2;
        StoryAttachmentTargetFragmentModel.Builder builder3 = builder2;
        builder3.u = c;
        a.G = LocationMessageAttachmentCreator.m11969a(LocationMessageAttachmentCreator.m11967a(builder3.a(), nearbyPlace.f11445b, nearbyPlace.f11449f));
        return a.R();
    }

    public final Message m16698b(ThreadKey threadKey, NearbyPlace nearbyPlace) {
        MessageBuilder a = m16676a(threadKey);
        StringBuilder stringBuilder = new StringBuilder();
        if (!StringUtil.c(nearbyPlace.f11445b)) {
            stringBuilder.append(nearbyPlace.f11445b);
            stringBuilder.append(NonXmaLocationTextCreator.f16664a);
        }
        if (!StringUtil.c(nearbyPlace.f11449f)) {
            stringBuilder.append(nearbyPlace.f11449f);
            stringBuilder.append(NonXmaLocationTextCreator.f16664a);
            stringBuilder.append(NonXmaLocationTextCreator.f16664a);
        }
        stringBuilder.append(ExternalMapLauncher.a(nearbyPlace.f11447d.a, nearbyPlace.f11447d.b));
        a.f = stringBuilder.toString();
        return a.R();
    }

    public final Message m16689a(ThreadKey threadKey, String str, @Nullable LatLng latLng, @Nullable NearbyPlace nearbyPlace, boolean z, long j, long j2) {
        MessageBuilder a = m16676a(threadKey);
        a.G = EventMessageAttachmentCreator.m11450a(str, latLng, nearbyPlace, z, j, j2);
        return a.R();
    }

    private MessageBuilder m16676a(ThreadKey threadKey) {
        return m16681c(threadKey, Long.toString(this.f16672d.m16675a()));
    }

    private MessageBuilder m16681c(ThreadKey threadKey, String str) {
        Integer valueOf;
        String a = m16679a(str);
        long a2 = this.f16669a.a();
        long a3 = ActionIdHelper.a(a2);
        ParticipantInfo a4 = m16677a();
        ThreadSummary a5 = ((DataCache) this.f16673e.get()).a(threadKey);
        if (a5 != null) {
            valueOf = Integer.valueOf(a5.H);
        } else {
            valueOf = null;
        }
        Integer num = valueOf;
        MessageBuilder newBuilder = Message.newBuilder();
        newBuilder.l = MessageType.PENDING_SEND;
        MessageBuilder a6 = newBuilder.a(a);
        a6.b = threadKey;
        a6 = a6;
        a6.n = str;
        a6 = a6;
        a6.c = a2;
        a6 = a6;
        a6.d = a2;
        a6 = a6;
        a6.g = a3;
        a6 = a6;
        a6.e = a4;
        a6 = a6;
        a6.o = true;
        a6 = a6;
        a6.q = ChannelSource.SEND;
        a6 = a6;
        a6.p = "mobile";
        a6 = a6;
        a6.v = Publicity.b;
        a6 = a6;
        a6.J = num;
        a6 = a6;
        if (this.f16677i.a(900, false)) {
            ImmutableBiMap immutableBiMap = RegularImmutableBiMap.a;
            this.f16676h.get();
            if (null != null) {
                Object obj;
                String str2 = "zero_free_mode";
                if (null != null) {
                    obj = "false";
                } else {
                    obj = "true";
                }
                immutableBiMap = ImmutableBiMap.b(str2, obj);
            }
            a6.a(immutableBiMap);
        }
        return a6;
    }

    private static String m16679a(String str) {
        return "sent." + str;
    }

    private ParticipantInfo m16677a() {
        ViewerContext viewerContext = (ViewerContext) this.f16675g.get();
        Preconditions.checkNotNull(viewerContext, "Can't create a sent message without a viewer");
        String str = "";
        if (!viewerContext.mIsPageContext) {
            str = ((User) this.f16674f.get()).k();
        }
        return new ParticipantInfo(new UserKey(Type.FACEBOOK, viewerContext.mUserId), str, viewerContext.mUserId + "@facebook.com");
    }
}
