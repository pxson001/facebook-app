package com.facebook.messaging.forward;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.messages.ipc.MessagingIntentUris;
import com.facebook.messages.links.MessengerLinks;
import com.facebook.messaging.analytics.perf.MessagingPerformanceLogger;
import com.facebook.messaging.model.attribution.ContentAppAttribution;
import com.facebook.messaging.model.attribution.ContentAppAttributionBuilder;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageBuilder;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.send.client.OutgoingMessageFactory;
import com.facebook.messaging.send.client.SendMessageManager;
import com.facebook.messaging.send.trigger.NavigationTrigger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.zero.DefaultMessageCapAccessor;
import com.facebook.zero.MessageCapAccessor;
import com.facebook.zero.MessageCapForwardController;
import com.facebook.zero.MessageCapForwardController.ForwardAction;
import com.google.common.collect.RegularImmutableBiMap;

/* compiled from: slideshow_element_start */
public class MessageForwardHandler {
    public final Context f2387a;
    public final OutgoingMessageFactory f2388b;
    public final SecureContextHelper f2389c;
    private final MessageForwardErrorReporter f2390d;
    private final Product f2391e;
    private final MessagingPerformanceLogger f2392f;
    public final MessageCapForwardController f2393g;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<SendMessageManager> f2394h = UltralightRuntime.b;

    /* compiled from: slideshow_element_start */
    public class C04042 implements ForwardAction {
        final /* synthetic */ MediaResource f2384a;
        final /* synthetic */ NavigationTrigger f2385b;
        final /* synthetic */ MessageForwardHandler f2386c;

        public C04042(MessageForwardHandler messageForwardHandler, MediaResource mediaResource, NavigationTrigger navigationTrigger) {
            this.f2386c = messageForwardHandler;
            this.f2384a = mediaResource;
            this.f2385b = navigationTrigger;
        }

        public final void m2241a() {
            Intent intent = new Intent(MessagingIntentUris.a);
            intent.setData(Uri.parse(MessengerLinks.o));
            intent.putExtra("ShareType", "ShareType.forward");
            intent.putExtra("media_resource", this.f2384a);
            intent.putExtra("trigger2", this.f2385b);
            this.f2386c.f2389c.a(intent, this.f2386c.f2387a);
        }
    }

    public static MessageForwardHandler m2242b(InjectorLike injectorLike) {
        MessageForwardHandler messageForwardHandler = new MessageForwardHandler((Context) injectorLike.getInstance(Context.class), OutgoingMessageFactory.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), MessageForwardErrorReporter.m2239b(injectorLike), ProductMethodAutoProvider.b(injectorLike), MessagingPerformanceLogger.a(injectorLike), new MessageCapForwardController((Context) injectorLike.getInstance(Context.class), (MessageCapAccessor) DefaultMessageCapAccessor.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike)));
        messageForwardHandler.f2394h = IdBasedLazy.a(injectorLike, 8347);
        return messageForwardHandler;
    }

    @Inject
    private MessageForwardHandler(Context context, OutgoingMessageFactory outgoingMessageFactory, SecureContextHelper secureContextHelper, MessageForwardErrorReporter messageForwardErrorReporter, Product product, MessagingPerformanceLogger messagingPerformanceLogger, MessageCapForwardController messageCapForwardController) {
        this.f2387a = context;
        this.f2388b = outgoingMessageFactory;
        this.f2389c = secureContextHelper;
        this.f2390d = messageForwardErrorReporter;
        this.f2391e = product;
        this.f2392f = messagingPerformanceLogger;
        this.f2393g = messageCapForwardController;
    }

    public final void m2244a(final Message message, final NavigationTrigger navigationTrigger) {
        this.f2393g.a(new ForwardAction(this) {
            final /* synthetic */ MessageForwardHandler f2383c;

            public final void m2240a() {
                Intent intent = new Intent(MessagingIntentUris.a, Uri.parse(MessengerLinks.o));
                intent.putExtra("ShareType", "ShareType.forward");
                MessageForwardHandler messageForwardHandler = this.f2383c;
                intent.putExtra("message", MessageForwardHandler.m2243b(message));
                intent.putExtra("trigger2", navigationTrigger);
                this.f2383c.f2389c.a(intent, this.f2383c.f2387a);
            }
        });
    }

    public static Message m2243b(Message message) {
        if (message.F == null) {
            return message;
        }
        MessageBuilder a = Message.newBuilder().a(message);
        ContentAppAttributionBuilder a2 = ContentAppAttribution.newBuilder().a(message.F);
        a2.f = "";
        a.F = a2.a(RegularImmutableBiMap.a).i();
        return a.R();
    }

    public final boolean m2245a(Message message) {
        if (this.f2391e != Product.MESSENGER || message.l != MessageType.REGULAR || message.h || ThreadKey.g(message.b) || MessageUtil.V(message)) {
            return false;
        }
        return true;
    }
}
