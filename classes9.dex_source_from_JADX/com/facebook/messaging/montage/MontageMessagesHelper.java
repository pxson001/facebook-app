package com.facebook.messaging.montage;

import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.attachments.AttachmentDataFactory;
import com.facebook.messaging.deliveryreceipt.MessageReceiptCalculationUtil;
import com.facebook.messaging.messageclassifier.MessageClassifier;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.montage.model.MontageMessageInfo;
import com.facebook.messaging.montage.model.MontageMessageType;
import com.facebook.messaging.montage.model.MyMontageMessageInfo;
import com.facebook.user.model.UserKey;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Collection;
import java.util.Date;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: iso-8859-5 */
public class MontageMessagesHelper {
    private final AttachmentDataFactory f12391a;
    private final MessageClassifier f12392b;
    private final MessageReceiptCalculationUtil f12393c;
    private final MontageTestHelper f12394d;
    private final Provider<UserKey> f12395e;

    public static MontageMessagesHelper m12857b(InjectorLike injectorLike) {
        return new MontageMessagesHelper(AttachmentDataFactory.a(injectorLike), MessageClassifier.a(injectorLike), MessageReceiptCalculationUtil.m11289a(injectorLike), MontageTestHelper.m12872b(injectorLike), IdBasedProvider.a(injectorLike, 3597));
    }

    public static MontageMessagesHelper m12856a(InjectorLike injectorLike) {
        return m12857b(injectorLike);
    }

    @Inject
    public MontageMessagesHelper(AttachmentDataFactory attachmentDataFactory, MessageClassifier messageClassifier, MessageReceiptCalculationUtil messageReceiptCalculationUtil, MontageTestHelper montageTestHelper, Provider<UserKey> provider) {
        this.f12391a = attachmentDataFactory;
        this.f12392b = messageClassifier;
        this.f12393c = messageReceiptCalculationUtil;
        this.f12394d = montageTestHelper;
        this.f12395e = provider;
    }

    public final ImmutableList<Message> m12863a(MessagesCollection messagesCollection) {
        return m12860d(messagesCollection, m12853a());
    }

    public final ImmutableList<Message> m12864a(MessagesCollection messagesCollection, long j) {
        return m12860d(messagesCollection, m12854a(j));
    }

    public final boolean m12867b(MessagesCollection messagesCollection) {
        return m12858c(messagesCollection, m12853a());
    }

    public final boolean m12868b(MessagesCollection messagesCollection, long j) {
        return m12858c(messagesCollection, m12854a(j));
    }

    private static long m12854a(long j) {
        return Math.max(j, m12853a());
    }

    public static long m12853a() {
        return new Date().getTime() - 86400000;
    }

    public final long m12865b(Message message) {
        MontageMessageType d = m12859d(message);
        if (d != null) {
            switch (d) {
                case PHOTO:
                case STICKER:
                    return 3000;
                case VIDEO:
                    return (long) this.f12391a.j(message).f7767d;
                case TEXT:
                    return m12855a(message.f);
            }
        }
        return 0;
    }

    public final MontageMessageInfo m12869c(Message message) {
        Preconditions.checkArgument(!this.f12394d.m12876a(message.b), "Use getMyMontageMessageInfo(..) instead for the logged-in user's Montage messages");
        MontageMessageType d = m12859d(message);
        if (d == null) {
            return null;
        }
        return new MontageMessageInfo(d, message, m12865b(message));
    }

    public final MyMontageMessageInfo m12862a(Message message, ThreadSummary threadSummary) {
        Preconditions.checkArgument(this.f12394d.m12876a(message.b), "This method should only be used for the logged-in user's Montage messages");
        MontageMessageType d = m12859d(message);
        if (d == null) {
            return null;
        }
        return new MyMontageMessageInfo(d, message, m12865b(message), m12866b(message, threadSummary));
    }

    @Nullable
    private MontageMessageType m12859d(Message message) {
        switch (this.f12392b.a(message)) {
            case PHOTOS:
                return MontageMessageType.PHOTO;
            case NORMAL:
                return MontageMessageType.TEXT;
            case VIDEO_CLIP:
                return MontageMessageType.VIDEO;
            case STICKER:
                return MontageMessageType.STICKER;
            default:
                return null;
        }
    }

    public static long m12855a(@Nullable String str) {
        if (str == null) {
            return 3000;
        }
        return Math.max(3000, (((long) str.trim().split("\\s+").length) * 60000) / 250);
    }

    public final ImmutableList<ThreadParticipant> m12866b(Message message, ThreadSummary threadSummary) {
        return ImmutableList.copyOf((Collection) MessageReceiptCalculationUtil.m11288a(message, threadSummary, (UserKey) this.f12395e.get()).first);
    }

    private boolean m12858c(MessagesCollection messagesCollection, long j) {
        for (int i = 0; i < messagesCollection.g(); i++) {
            Message b = messagesCollection.b(i);
            if (b.c <= j) {
                return false;
            }
            if (m12861e(b)) {
                return true;
            }
        }
        return false;
    }

    private ImmutableList<Message> m12860d(MessagesCollection messagesCollection, long j) {
        Builder builder = ImmutableList.builder();
        for (int i = 0; i < messagesCollection.g(); i++) {
            Message b = messagesCollection.b(i);
            if (b.c <= j) {
                break;
            }
            if (m12861e(b)) {
                builder.c(b);
            }
        }
        return builder.b();
    }

    private boolean m12861e(Message message) {
        return m12859d(message) != null;
    }
}
