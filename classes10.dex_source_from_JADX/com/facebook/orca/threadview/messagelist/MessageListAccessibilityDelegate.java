package com.facebook.orca.threadview.messagelist;

import com.facebook.accessibility.UpdatableListAccessibilityDelegate;
import com.facebook.accessibility.UpdatableListAccessibilityDelegate.UpdateCollection;
import com.facebook.accessibility.ViewAccessibilityHelper;
import com.facebook.common.executors.ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageUserUtil;
import com.facebook.ultralight.Inject;
import com.google.common.collect.Sets;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: mark_as_spam */
public class MessageListAccessibilityDelegate extends UpdatableListAccessibilityDelegate<Message> {
    public Set<Message> f8217d;
    public boolean f8218e;
    private MessageUserUtil f8219f;
    private String f8220g;

    /* compiled from: mark_as_spam */
    class C12311 implements UpdateCollection<Message> {
        final /* synthetic */ MessageListAccessibilityDelegate f8216a;

        C12311(MessageListAccessibilityDelegate messageListAccessibilityDelegate) {
            this.f8216a = messageListAccessibilityDelegate;
        }

        public final void m8102a(Object obj) {
            this.f8216a.f8217d.add((Message) obj);
        }

        public final boolean m8103a() {
            return this.f8216a.f8217d.isEmpty();
        }

        public final void m8104b() {
            this.f8216a.f8217d.clear();
        }
    }

    public static MessageListAccessibilityDelegate m8105a(InjectorLike injectorLike) {
        return new MessageListAccessibilityDelegate(ViewAccessibilityHelper.a(injectorLike), ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), MessageUserUtil.a(injectorLike));
    }

    protected final boolean m8109b(Object obj) {
        Message message = (Message) obj;
        return (message == null || message.a.equals(this.f8220g) || this.f8219f.a(message)) ? false : true;
    }

    protected final CharSequence m8112f() {
        Set c = Sets.c();
        Message[] messageArr = (Message[]) this.f8217d.toArray(new Message[this.f8217d.size()]);
        for (int length = messageArr.length - 1; length >= 0; length--) {
            c.add(messageArr[length].e.c);
        }
        if (this.f8217d.size() == 1) {
            return this.d.getResources().getString(2131240211, new Object[]{c.iterator().next()});
        } else if (c.size() == 1) {
            return this.d.getResources().getString(2131240212, new Object[]{Integer.valueOf(this.f8217d.size()), c.iterator().next()});
        } else {
            return this.d.getResources().getQuantityString(2131689767, c.size() - 1, new Object[]{Integer.valueOf(this.f8217d.size()), c.iterator().next(), Integer.valueOf(c.size() - 1)});
        }
    }

    @Inject
    public MessageListAccessibilityDelegate(ViewAccessibilityHelper viewAccessibilityHelper, ScheduledExecutorService scheduledExecutorService, MessageUserUtil messageUserUtil) {
        super(viewAccessibilityHelper, scheduledExecutorService);
        this.f8219f = messageUserUtil;
    }

    protected final UpdateCollection<Message> m8111e() {
        this.f8217d = Sets.c();
        return new C12311(this);
    }

    protected final boolean m8108a(int i) {
        return UpdatableListAccessibilityDelegate.b.contains(Integer.valueOf(i)) && (this.f8218e || !this.f8217d.isEmpty());
    }

    public final void m8106a(Message message) {
        super.a(message);
        if (this.f8217d.contains(message)) {
            this.f8220g = message.a;
        }
    }

    protected final long m8110d() {
        return this.f8218e ? 3000 : 1000;
    }
}
