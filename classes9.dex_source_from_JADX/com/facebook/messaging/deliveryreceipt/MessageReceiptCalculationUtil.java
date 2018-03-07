package com.facebook.messaging.deliveryreceipt;

import android.content.Context;
import android.util.Pair;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.debug.log.BLog;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.user.model.UserKey;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: markThread */
public class MessageReceiptCalculationUtil {
    private static MessageReceiptCalculationUtil f10862e;
    private static final Object f10863f = new Object();
    private final Provider<Boolean> f10864a;
    private final Map<ThreadParticipant, Message> f10865b = Maps.c();
    private final Map<ThreadParticipant, Message> f10866c = Maps.c();
    private final Map<ThreadParticipant, Message> f10867d = Maps.c();

    private static MessageReceiptCalculationUtil m11294b(InjectorLike injectorLike) {
        return new MessageReceiptCalculationUtil(IdBasedProvider.a(injectorLike, 4154));
    }

    @Inject
    public MessageReceiptCalculationUtil(Provider<Boolean> provider) {
        this.f10864a = provider;
    }

    public static Pair<List<ThreadParticipant>, List<ThreadParticipant>> m11288a(Message message, ThreadSummary threadSummary, UserKey userKey) {
        List a = Lists.a();
        List a2 = Lists.a();
        ImmutableList immutableList = threadSummary.h;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ThreadParticipant threadParticipant = (ThreadParticipant) immutableList.get(i);
            if (threadParticipant.e() == null) {
                BLog.b("MessageReceiptCalculationUtil", "Participant %s of type %s doesn't have a name.", new Object[]{threadParticipant.b().b(), threadParticipant.b().a()});
            }
            boolean a3 = m11292a(threadParticipant, message);
            boolean equals = threadParticipant.b().equals(userKey);
            Object obj = (a3 || (threadParticipant.b >= MessageUtil.d(message) ? 1 : null) != null) ? 1 : null;
            if (!equals) {
                if (obj != null) {
                    a.add(threadParticipant);
                } else {
                    a2.add(threadParticipant);
                }
            }
        }
        return new Pair(a, a2);
    }

    public static MessageReceiptCalculationUtil m11289a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MessageReceiptCalculationUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10863f) {
                MessageReceiptCalculationUtil messageReceiptCalculationUtil;
                if (a2 != null) {
                    messageReceiptCalculationUtil = (MessageReceiptCalculationUtil) a2.a(f10863f);
                } else {
                    messageReceiptCalculationUtil = f10862e;
                }
                if (messageReceiptCalculationUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11294b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10863f, b3);
                        } else {
                            f10862e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = messageReceiptCalculationUtil;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final Map<Message, MessageDeliveredReadInfo> m11296a(List<Message> list, ThreadSummary threadSummary, UserKey userKey, boolean z) {
        Object obj;
        this.f10865b.clear();
        this.f10866c.clear();
        this.f10867d.clear();
        Map map = this.f10865b;
        Map map2 = this.f10866c;
        Map map3 = this.f10867d;
        boolean z2 = threadSummary.a.a == Type.ONE_TO_ONE;
        if (((Boolean) this.f10864a.get()).booleanValue() && z2) {
            obj = 1;
        } else {
            obj = null;
        }
        for (Message message : list) {
            if (message.l == MessageType.REGULAR) {
                boolean a = m11293a(userKey, message);
                ImmutableList immutableList = threadSummary.h;
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    ThreadParticipant threadParticipant = (ThreadParticipant) immutableList.get(i);
                    Object obj2 = (!map2.containsKey(threadParticipant) || z) ? null : 1;
                    obj2 = (obj2 != null || map.containsKey(threadParticipant) || map3.containsKey(threadParticipant)) ? 1 : null;
                    boolean a2 = m11292a(threadParticipant, message);
                    if (!z && obj2 == null && !a && a2) {
                        map2.put(threadParticipant, message);
                        obj2 = 1;
                    }
                    boolean equals = threadParticipant.b().equals(userKey);
                    Object obj3 = (a2 || (threadParticipant.b >= MessageUtil.d(message) ? 1 : null) == null) ? null : 1;
                    Object obj4 = (a2 && z) ? 1 : null;
                    obj4 = (obj4 == null && obj3 == null) ? null : 1;
                    if (!(obj2 != null || equals || obj4 == null)) {
                        map.put(threadParticipant, message);
                        obj2 = 1;
                    }
                    boolean equals2 = message.a.equals(threadParticipant.c);
                    if (obj != null && r6 == null && a && !equals && equals2) {
                        map3.put(threadParticipant, message);
                    }
                }
            }
        }
        Map c = Maps.c();
        m11291a(map, c, z2);
        m11290a(map2, c);
        if (obj != null) {
            m11295b(map3, c);
        }
        return c;
    }

    private static boolean m11293a(UserKey userKey, Message message) {
        return userKey.equals(message.e.b);
    }

    private static boolean m11292a(ThreadParticipant threadParticipant, Message message) {
        return m11293a(threadParticipant.b(), message);
    }

    private static void m11291a(Map<ThreadParticipant, Message> map, Map<Message, MessageDeliveredReadInfo> map2, boolean z) {
        for (Entry entry : map.entrySet()) {
            ThreadParticipant threadParticipant = (ThreadParticipant) entry.getKey();
            Message message = (Message) entry.getValue();
            if (!map2.containsKey(message)) {
                Object messageDeliveredReadInfo;
                if (z) {
                    messageDeliveredReadInfo = new MessageDeliveredReadInfo(MessageDeliveredReadInfo.Type.READER, threadParticipant.b);
                } else {
                    MessageDeliveredReadInfo messageDeliveredReadInfo2 = new MessageDeliveredReadInfo(MessageDeliveredReadInfo.Type.READER);
                }
                map2.put(message, messageDeliveredReadInfo);
            }
            RowReceiptParticipant rowReceiptParticipant = new RowReceiptParticipant(threadParticipant.a, threadParticipant.b);
            MessageDeliveredReadInfo messageDeliveredReadInfo3 = (MessageDeliveredReadInfo) map2.get(message);
            Preconditions.checkState(messageDeliveredReadInfo3.f10858a == MessageDeliveredReadInfo.Type.READER, "MessageDeliveredReadInfo is not of type READER - Cannot add a reader");
            if (messageDeliveredReadInfo3.f10859b == null) {
                messageDeliveredReadInfo3.f10859b = Lists.a();
            }
            int binarySearch = Collections.binarySearch(messageDeliveredReadInfo3.f10859b, rowReceiptParticipant, RowReceiptParticipant.f10868a);
            if (binarySearch < 0) {
                messageDeliveredReadInfo3.f10859b.add((-binarySearch) - 1, rowReceiptParticipant);
            }
        }
    }

    private static void m11290a(Map<ThreadParticipant, Message> map, Map<Message, MessageDeliveredReadInfo> map2) {
        for (Entry entry : map.entrySet()) {
            ThreadParticipant threadParticipant = (ThreadParticipant) entry.getKey();
            Message message = (Message) entry.getValue();
            if (!map2.containsKey(message)) {
                ParticipantInfo participantInfo = threadParticipant.a;
                MessageDeliveredReadInfo messageDeliveredReadInfo = new MessageDeliveredReadInfo(MessageDeliveredReadInfo.Type.SENDER);
                messageDeliveredReadInfo.f10860c = participantInfo;
                map2.put(message, messageDeliveredReadInfo);
            }
        }
    }

    private static void m11295b(Map<ThreadParticipant, Message> map, Map<Message, MessageDeliveredReadInfo> map2) {
        for (Entry entry : map.entrySet()) {
            ThreadParticipant threadParticipant = (ThreadParticipant) entry.getKey();
            Message message = (Message) entry.getValue();
            if (!map2.containsKey(message)) {
                ParticipantInfo participantInfo = threadParticipant.a;
                MessageDeliveredReadInfo messageDeliveredReadInfo = new MessageDeliveredReadInfo(MessageDeliveredReadInfo.Type.DELIVEREE);
                messageDeliveredReadInfo.f10860c = participantInfo;
                map2.put(message, messageDeliveredReadInfo);
            }
        }
    }
}
