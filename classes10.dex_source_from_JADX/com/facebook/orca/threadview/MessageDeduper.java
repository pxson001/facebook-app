package com.facebook.orca.threadview;

import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Set;

/* compiled from: metadata.txt */
public class MessageDeduper {
    public static MessageDeduper m6606a(InjectorLike injectorLike) {
        return new MessageDeduper();
    }

    public static ImmutableList<Message> m6607a(MessagesCollection messagesCollection, List<Message> list) {
        TracerDetour.a("MD.dedupMessages", 906992658);
        try {
            ImmutableList<Message> of;
            if (list.isEmpty()) {
                of = ImmutableList.of();
            } else {
                Message message;
                Set a = Sets.a();
                for (Message message2 : list) {
                    if (!StringUtil.a(message2.a)) {
                        a.add(message2.a);
                    }
                    if (!StringUtil.a(message2.n)) {
                        a.add(message2.n);
                    }
                }
                if (messagesCollection != null) {
                    ImmutableList b = messagesCollection.b();
                    int size = b.size();
                    for (int i = 0; i < size; i++) {
                        message2 = (Message) b.get(i);
                        if (!StringUtil.a(message2.a)) {
                            a.remove(message2.a);
                        }
                        if (!StringUtil.a(message2.n)) {
                            a.remove(message2.n);
                        }
                    }
                }
                Builder builder = ImmutableList.builder();
                for (Message message22 : list) {
                    Object obj = (StringUtil.a(message22.a) || a.contains(message22.a)) ? null : 1;
                    Object obj2;
                    if (StringUtil.a(message22.n) || a.contains(message22.n)) {
                        obj2 = null;
                    } else {
                        obj2 = 1;
                    }
                    if (obj == null && r1 == null) {
                        builder.c(message22);
                    }
                }
                of = builder.b();
                TracerDetour.a(-1414183906);
            }
            return of;
        } finally {
            TracerDetour.a(-1578268533);
        }
    }
}
