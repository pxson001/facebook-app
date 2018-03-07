package com.facebook.messaging.cache;

import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLLightweightEventGuestStatus;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.clockskew.SkewedTimestampHandler;
import com.facebook.messaging.giftwrap.GiftWrapResolver;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.messages.GenericAdminMessageInfo;
import com.facebook.messaging.model.messages.GenericAdminMessageInfo.EventReminderProperties;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.NicknamesMap;
import com.facebook.messaging.model.threads.ThreadCustomization;
import com.facebook.messaging.model.threads.ThreadCustomization.Builder;
import com.facebook.messaging.model.threads.ThreadEventReminder;
import com.facebook.messaging.model.threads.ThreadGameData;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.model.threads.ThreadSummaryBuilder;
import com.facebook.messaging.notify.MessageSnippetHelper;
import com.facebook.messaging.rtc.adminmsg.model.RtcCallLogClassifierHelper;
import com.facebook.messaging.rtc.adminmsg.model.RtcCallLogClassifierHelperProvider;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: messenger_video_format_not_supported_dialog */
public class ThreadSummaryStitching {
    private final Provider<ViewerContext> f9571a;
    private final FbObjectMapper f9572b;
    private final GiftWrapResolver f9573c;
    private final MessageUtil f9574d;
    private final MessageSnippetHelper f9575e;
    private final RtcCallLogClassifierHelperProvider f9576f;
    private final Lazy<SkewedTimestampHandler> f9577g;
    private final Provider<Boolean> f9578h;

    public static ThreadSummaryStitching m10181b(InjectorLike injectorLike) {
        return new ThreadSummaryStitching(IdBasedProvider.a(injectorLike, 372), FbObjectMapperMethodAutoProvider.a(injectorLike), GiftWrapResolver.b(injectorLike), MessageUtil.a(injectorLike), MessageSnippetHelper.b(injectorLike), (RtcCallLogClassifierHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(RtcCallLogClassifierHelperProvider.class), IdBasedSingletonScopeProvider.b(injectorLike, 7716), IdBasedProvider.a(injectorLike, 4097));
    }

    public static ThreadSummaryStitching m10173a(InjectorLike injectorLike) {
        return m10181b(injectorLike);
    }

    @Inject
    public ThreadSummaryStitching(Provider<ViewerContext> provider, FbObjectMapper fbObjectMapper, GiftWrapResolver giftWrapResolver, MessageUtil messageUtil, MessageSnippetHelper messageSnippetHelper, RtcCallLogClassifierHelperProvider rtcCallLogClassifierHelperProvider, Lazy<SkewedTimestampHandler> lazy, Provider<Boolean> provider2) {
        this.f9571a = provider;
        this.f9572b = fbObjectMapper;
        this.f9573c = giftWrapResolver;
        this.f9574d = messageUtil;
        this.f9575e = messageSnippetHelper;
        this.f9576f = rtcCallLogClassifierHelperProvider;
        this.f9577g = lazy;
        this.f9578h = provider2;
    }

    public final ThreadSummary m10182a(ThreadSummary threadSummary, Message message, long j, StitchOperationType stitchOperationType) {
        String substring;
        String b;
        ThreadKey threadKey;
        long j2;
        boolean a;
        ThreadSummaryBuilder a2;
        ThreadSummaryBuilder threadSummaryBuilder;
        ThreadSummaryBuilder threadSummaryBuilder2;
        ThreadSummaryBuilder threadSummaryBuilder3;
        ThreadSummaryBuilder threadSummaryBuilder4;
        Object obj;
        GenericAdminMessageInfo genericAdminMessageInfo;
        Builder a3;
        String C;
        EventReminderProperties Q;
        Preconditions.checkNotNull(threadSummary);
        Preconditions.checkNotNull(message);
        List a4 = Lists.a();
        ParticipantInfo participantInfo = message.e;
        a4.add(participantInfo);
        ImmutableList immutableList = threadSummary.o;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ParticipantInfo participantInfo2 = (ParticipantInfo) immutableList.get(i);
            if (!Objects.equal(participantInfo2.b, participantInfo.b)) {
                a4.add(participantInfo2);
            }
        }
        String str = message.f;
        if (str != null) {
            str = str.trim();
            if (str.length() > 120) {
                substring = str.substring(0, 120);
                if (ThreadKey.g(message.b)) {
                    b = this.f9575e.b(message);
                } else if (!MessageUtil.B(message) && !Strings.isNullOrEmpty(message.f)) {
                    b = message.f;
                } else if (this.f9573c.a(message) != null) {
                    b = this.f9575e.d(message, threadSummary.D);
                } else if (this.f9575e.c(message)) {
                    b = this.f9575e.e(message, threadSummary.D);
                } else if (this.f9575e.a(message)) {
                    b = this.f9575e.a(message, threadSummary.D);
                } else if (Strings.isNullOrEmpty(substring)) {
                    b = null;
                } else {
                    b = this.f9575e.b(message, threadSummary.D);
                }
                threadKey = threadSummary.a;
                j2 = message.c;
                if (ThreadKey.d(threadKey)) {
                    j2 = ((SkewedTimestampHandler) this.f9577g.get()).m10348a(threadKey.b, j2);
                }
                a = m10178a(message);
                a2 = ThreadSummary.newBuilder().a(threadSummary);
                a2.k = j2;
                threadSummaryBuilder = a2;
                threadSummaryBuilder.p = substring;
                threadSummaryBuilder2 = threadSummaryBuilder;
                threadSummaryBuilder2.q = message.e;
                threadSummaryBuilder2 = threadSummaryBuilder2;
                threadSummaryBuilder2.o = a4;
                threadSummaryBuilder2 = threadSummaryBuilder2;
                threadSummaryBuilder2.y = a;
                threadSummaryBuilder3 = threadSummaryBuilder2;
                threadSummaryBuilder3.r = b;
                threadSummaryBuilder3 = threadSummaryBuilder3;
                threadSummaryBuilder3.z = false;
                threadSummaryBuilder4 = threadSummaryBuilder3;
                obj = j == -1 ? 1 : null;
                if (obj != null) {
                    switch (stitchOperationType) {
                        case MESSAGE_ADDED:
                            threadSummaryBuilder4.g(threadSummary.m + 1);
                            break;
                        case MESSAGE_DELETED:
                            threadSummaryBuilder4.g(threadSummary.m - 1);
                            break;
                    }
                }
                if (m10180a(threadSummary, message, stitchOperationType)) {
                    threadSummaryBuilder4.h(threadSummary.n + 1);
                } else {
                    threadSummaryBuilder4.f(message.c);
                    threadSummaryBuilder4.h(0);
                }
                if (MessageUtil.s(message) && stitchOperationType != StitchOperationType.MESSAGE_DELETED) {
                    threadSummaryBuilder4.G = message.I.D();
                }
                if (MessageUtil.m(message) && stitchOperationType != StitchOperationType.MESSAGE_DELETED) {
                    genericAdminMessageInfo = message.I;
                    if (genericAdminMessageInfo != null) {
                        a3 = ThreadCustomization.newBuilder().a(threadSummary.D);
                        if (MessageUtil.n(message)) {
                            a3.b = genericAdminMessageInfo.z();
                            a3.c = 0;
                            a3.a = 0;
                        } else if (MessageUtil.o(message)) {
                            str = genericAdminMessageInfo.A();
                            if (StringUtil.a(str)) {
                                str = null;
                            }
                            a3.e = str;
                        } else if (MessageUtil.p(message)) {
                            C = genericAdminMessageInfo.C();
                            if (C != null) {
                                a3.f = m10174a(threadSummary.D.g, C, genericAdminMessageInfo.B());
                            }
                        }
                        threadSummaryBuilder4.D = a3.g();
                    }
                }
                if (MessageUtil.X(message) || MessageUtil.Y(message) || MessageUtil.Z(message) || (MessageUtil.aa(message) && stitchOperationType != StitchOperationType.MESSAGE_DELETED)) {
                    genericAdminMessageInfo = message.I;
                    if (genericAdminMessageInfo != null) {
                        Q = genericAdminMessageInfo.Q();
                        if (!(Q == null || Q.eventId == null)) {
                            threadSummaryBuilder4.I = m10175a(message, Q, threadSummary.J);
                        }
                    }
                }
                if (threadSummary.A.isMessageRequestFolders() && this.f9574d.P(message)) {
                    threadSummaryBuilder4.A = FolderName.INBOX;
                }
                if (!MessageUtil.c(message)) {
                    threadSummaryBuilder4.b(message.g).c(message.g);
                    if (obj != null) {
                        threadSummaryBuilder4.d(j);
                    }
                }
                if (MessageUtil.K(message) && message.I.O()) {
                    threadSummaryBuilder4.M = m10176a(threadSummary.N.entrySet(), message.I.M(), new ThreadGameData(message.e.b.b(), message.I.N()));
                }
                threadSummaryBuilder4.J = message.M;
                threadSummaryBuilder4.R = message.N;
                return threadSummaryBuilder4.V();
            }
        }
        substring = str;
        if (ThreadKey.g(message.b)) {
            b = this.f9575e.b(message);
        } else {
            if (!MessageUtil.B(message)) {
            }
            if (this.f9573c.a(message) != null) {
                b = this.f9575e.d(message, threadSummary.D);
            } else if (this.f9575e.c(message)) {
                b = this.f9575e.e(message, threadSummary.D);
            } else if (this.f9575e.a(message)) {
                b = this.f9575e.a(message, threadSummary.D);
            } else if (Strings.isNullOrEmpty(substring)) {
                b = null;
            } else {
                b = this.f9575e.b(message, threadSummary.D);
            }
        }
        threadKey = threadSummary.a;
        j2 = message.c;
        if (ThreadKey.d(threadKey)) {
            j2 = ((SkewedTimestampHandler) this.f9577g.get()).m10348a(threadKey.b, j2);
        }
        a = m10178a(message);
        a2 = ThreadSummary.newBuilder().a(threadSummary);
        a2.k = j2;
        threadSummaryBuilder = a2;
        threadSummaryBuilder.p = substring;
        threadSummaryBuilder2 = threadSummaryBuilder;
        threadSummaryBuilder2.q = message.e;
        threadSummaryBuilder2 = threadSummaryBuilder2;
        threadSummaryBuilder2.o = a4;
        threadSummaryBuilder2 = threadSummaryBuilder2;
        threadSummaryBuilder2.y = a;
        threadSummaryBuilder3 = threadSummaryBuilder2;
        threadSummaryBuilder3.r = b;
        threadSummaryBuilder3 = threadSummaryBuilder3;
        threadSummaryBuilder3.z = false;
        threadSummaryBuilder4 = threadSummaryBuilder3;
        if (j == -1) {
        }
        if (obj != null) {
            switch (stitchOperationType) {
                case MESSAGE_ADDED:
                    threadSummaryBuilder4.g(threadSummary.m + 1);
                    break;
                case MESSAGE_DELETED:
                    threadSummaryBuilder4.g(threadSummary.m - 1);
                    break;
            }
        }
        if (m10180a(threadSummary, message, stitchOperationType)) {
            threadSummaryBuilder4.h(threadSummary.n + 1);
        } else {
            threadSummaryBuilder4.f(message.c);
            threadSummaryBuilder4.h(0);
        }
        threadSummaryBuilder4.G = message.I.D();
        genericAdminMessageInfo = message.I;
        if (genericAdminMessageInfo != null) {
            a3 = ThreadCustomization.newBuilder().a(threadSummary.D);
            if (MessageUtil.n(message)) {
                a3.b = genericAdminMessageInfo.z();
                a3.c = 0;
                a3.a = 0;
            } else if (MessageUtil.o(message)) {
                str = genericAdminMessageInfo.A();
                if (StringUtil.a(str)) {
                    str = null;
                }
                a3.e = str;
            } else if (MessageUtil.p(message)) {
                C = genericAdminMessageInfo.C();
                if (C != null) {
                    a3.f = m10174a(threadSummary.D.g, C, genericAdminMessageInfo.B());
                }
            }
            threadSummaryBuilder4.D = a3.g();
        }
        genericAdminMessageInfo = message.I;
        if (genericAdminMessageInfo != null) {
            Q = genericAdminMessageInfo.Q();
            threadSummaryBuilder4.I = m10175a(message, Q, threadSummary.J);
        }
        threadSummaryBuilder4.A = FolderName.INBOX;
        if (MessageUtil.c(message)) {
            threadSummaryBuilder4.b(message.g).c(message.g);
            if (obj != null) {
                threadSummaryBuilder4.d(j);
            }
        }
        threadSummaryBuilder4.M = m10176a(threadSummary.N.entrySet(), message.I.M(), new ThreadGameData(message.e.b.b(), message.I.N()));
        threadSummaryBuilder4.J = message.M;
        threadSummaryBuilder4.R = message.N;
        return threadSummaryBuilder4.V();
    }

    private ImmutableList<ThreadEventReminder> m10175a(Message message, EventReminderProperties eventReminderProperties, ImmutableList<ThreadEventReminder> immutableList) {
        Collection arrayList = new ArrayList();
        int i;
        ThreadEventReminder threadEventReminder;
        if (MessageUtil.aa(message)) {
            ThreadEventReminder.Builder builder = new ThreadEventReminder.Builder();
            builder.a = eventReminderProperties.eventId;
            builder.d = true;
            int size = immutableList.size();
            for (i = 0; i < size; i++) {
                threadEventReminder = (ThreadEventReminder) immutableList.get(i);
                if (threadEventReminder.a.equals(eventReminderProperties.eventId)) {
                    arrayList.add(builder.g());
                } else {
                    arrayList.add(threadEventReminder);
                }
            }
        } else if (MessageUtil.X(message)) {
            ThreadEventReminder.Builder builder2 = new ThreadEventReminder.Builder();
            builder2.a = eventReminderProperties.eventId;
            if (eventReminderProperties.eventTrackRsvp != null) {
                builder2.f = "1".equals(eventReminderProperties.eventTrackRsvp);
            }
            builder2.b = Long.parseLong(eventReminderProperties.eventTime);
            builder2.c = eventReminderProperties.eventTitle;
            arrayList.addAll(immutableList);
            ImmutableMap.Builder builder3 = new ImmutableMap.Builder();
            builder3.b(message.e.b, GraphQLLightweightEventGuestStatus.GOING);
            builder2.e = builder3.b();
            arrayList.add(builder2.g());
        } else if (MessageUtil.Y(message) || MessageUtil.Z(message)) {
            int size2 = immutableList.size();
            for (i = 0; i < size2; i++) {
                threadEventReminder = (ThreadEventReminder) immutableList.get(i);
                if (threadEventReminder.a.equals(eventReminderProperties.eventId)) {
                    ThreadEventReminder.Builder builder4 = new ThreadEventReminder.Builder(threadEventReminder);
                    builder4.a = eventReminderProperties.eventId;
                    if (eventReminderProperties.eventTrackRsvp != null) {
                        builder4.f = "1".equals(eventReminderProperties.eventTrackRsvp);
                    }
                    if (eventReminderProperties.eventTime != null) {
                        builder4.b = Long.parseLong(eventReminderProperties.eventTime);
                    }
                    if (eventReminderProperties.eventTitle != null) {
                        builder4.c = eventReminderProperties.eventTitle;
                    }
                    if (!(Strings.isNullOrEmpty(eventReminderProperties.guestId) || Strings.isNullOrEmpty(eventReminderProperties.guestStatus))) {
                        m10177a(builder4, eventReminderProperties);
                    }
                    arrayList.add(builder4.g());
                } else {
                    arrayList.add(threadEventReminder);
                }
            }
        }
        Collections.sort(arrayList);
        return ImmutableList.copyOf(arrayList);
    }

    private static void m10177a(ThreadEventReminder.Builder builder, EventReminderProperties eventReminderProperties) {
        ImmutableMap.Builder builder2 = new ImmutableMap.Builder();
        builder2.b(new UserKey(Type.FACEBOOK, eventReminderProperties.guestId), GraphQLLightweightEventGuestStatus.valueOf(eventReminderProperties.guestStatus.toUpperCase()));
        builder.e = builder2.b();
    }

    private NicknamesMap m10174a(NicknamesMap nicknamesMap, String str, String str2) {
        Object obj;
        ImmutableSet entrySet = nicknamesMap.a(this.f9572b).entrySet();
        if (StringUtil.a(str2)) {
            obj = null;
        }
        return new NicknamesMap(m10176a(entrySet, (Object) str, obj));
    }

    private static <K, V> ImmutableMap<K, V> m10176a(ImmutableSet<Entry<K, V>> immutableSet, K k, V v) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        if (v != null) {
            builder.b(k, v);
        }
        Iterator it = immutableSet.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (!entry.getKey().equals(k)) {
                builder.a(entry);
            }
        }
        return builder.b();
    }

    public final ThreadSummary m10183a(ThreadSummary threadSummary, Message message, @Nullable MessagesCollection messagesCollection, long j, StitchOperationType stitchOperationType) {
        if (!((Boolean) this.f9578h.get()).booleanValue() || MessageUtil.c(message) || messagesCollection == null || messagesCollection.c() == null || message.a.equals(messagesCollection.c().a)) {
            return m10182a(threadSummary, message, j, stitchOperationType);
        }
        ThreadSummaryBuilder a = ThreadSummary.newBuilder().a(threadSummary);
        a.d = j;
        if (!MessageUtil.c(message)) {
            a.b(message.g).c(message.g);
        }
        return a.V();
    }

    private boolean m10180a(ThreadSummary threadSummary, Message message, StitchOperationType stitchOperationType) {
        boolean z = message.l == MessageType.INCOMING_CALL;
        if (stitchOperationType == StitchOperationType.MESSAGE_DELETED || z) {
            return !threadSummary.f();
        } else {
            return Objects.equal(message.e.b, UserKey.b(((ViewerContext) this.f9571a.get()).mUserId));
        }
    }

    public static boolean m10179a(Message message, @Nullable Message message2) {
        if (message2 == null) {
            return true;
        }
        if (message2.l == MessageType.PENDING_SEND && message.l == MessageType.FAILED_SEND) {
            return true;
        }
        if (message2.l == MessageType.REGULAR && message.l == MessageType.PENDING_SEND) {
            return false;
        }
        if (message2.l == MessageType.FAILED_SEND && message.l == MessageType.PENDING_SEND && message.d <= message2.d) {
            return false;
        }
        return true;
    }

    private boolean m10178a(Message message) {
        boolean z = false;
        boolean z2 = message.l == MessageType.MISSED_CALL || message.l == MessageType.MISSED_VIDEO_CALL;
        if (message.l != MessageType.CALL_LOG || message.G == null || message.G.l() == null) {
            return z2;
        }
        RtcCallLogClassifierHelper a = this.f9576f.a(message.G.l().b());
        if (z2 || a.a()) {
            z = true;
        }
        return z;
    }
}
