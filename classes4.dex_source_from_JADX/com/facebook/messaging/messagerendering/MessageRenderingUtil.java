package com.facebook.messaging.messagerendering;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.Spannable.Factory;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.cache.MessengerUserNameUtil;
import com.facebook.messaging.cache.ThreadParticipantUtils;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.notify.MessageSnippetHelper;
import com.facebook.ui.emoji.EmojiUtil;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: setNotifyMeParams */
public class MessageRenderingUtil {
    public static int f2439a = 0;
    private static MessageRenderingUtil f2440i;
    private static final Object f2441j = new Object();
    private final Resources f2442b;
    public final EmojiUtil f2443c;
    public final int f2444d;
    private final Provider<DataCache> f2445e;
    private final Provider<ThreadParticipantUtils> f2446f;
    private final Lazy<MessageSnippetHelper> f2447g;
    private final Provider<MessengerUserNameUtil> f2448h;

    private static MessageRenderingUtil m2716b(InjectorLike injectorLike) {
        return new MessageRenderingUtil(ResourcesMethodAutoProvider.a(injectorLike), EmojiUtil.a(injectorLike), (Context) injectorLike.getInstance(Context.class), IdBasedProvider.a(injectorLike, 2567), IdBasedProvider.a(injectorLike, 7706), IdBasedLazy.a(injectorLike, 2671), IdBasedProvider.a(injectorLike, 2569));
    }

    @Inject
    public MessageRenderingUtil(Resources resources, EmojiUtil emojiUtil, Context context, Provider<DataCache> provider, Provider<ThreadParticipantUtils> provider2, Lazy<MessageSnippetHelper> lazy, Provider<MessengerUserNameUtil> provider3) {
        this.f2442b = resources;
        this.f2443c = emojiUtil;
        this.f2445e = provider;
        this.f2446f = provider2;
        this.f2447g = lazy;
        this.f2448h = provider3;
        this.f2444d = ContextUtils.e(context, 2130773139, resources.getDimensionPixelSize(2131428619)) - SizeUtil.a(context, 1.0f);
    }

    public static MessageRenderingUtil m2715a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MessageRenderingUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2441j) {
                MessageRenderingUtil messageRenderingUtil;
                if (a2 != null) {
                    messageRenderingUtil = (MessageRenderingUtil) a2.a(f2441j);
                } else {
                    messageRenderingUtil = f2440i;
                }
                if (messageRenderingUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2716b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2441j, b3);
                        } else {
                            f2440i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = messageRenderingUtil;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final Spanned m2717a(Message message) {
        return m2714a(message, false);
    }

    public final Spanned m2719b(Message message) {
        return m2714a(message, true);
    }

    private Spanned m2714a(Message message, boolean z) {
        CharSequence b;
        if (StringUtil.c(message.f)) {
            b = ((MessageSnippetHelper) this.f2447g.get()).b(message, null);
        } else {
            b = message.f.trim();
        }
        Editable spannableStringBuilder = new SpannableStringBuilder(Factory.getInstance().newSpannable(b));
        if (z) {
            this.f2443c.a(spannableStringBuilder);
        } else {
            this.f2443c.a(spannableStringBuilder, this.f2444d);
        }
        return spannableStringBuilder;
    }

    public final boolean m2720c(Message message) {
        if (Strings.isNullOrEmpty(message.f)) {
            return false;
        }
        if ((message.i != null && !message.i.isEmpty()) || message.G != null) {
            return false;
        }
        return this.f2443c.b(message.f.trim());
    }

    @Nullable
    public final String m2718a(ParticipantInfo participantInfo, ThreadKey threadKey) {
        return ((DataCache) this.f2445e.get()).m10362b(threadKey, participantInfo);
    }
}
