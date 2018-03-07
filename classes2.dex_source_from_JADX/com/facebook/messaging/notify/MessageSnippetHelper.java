package com.facebook.messaging.notify;

import android.content.res.Resources;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.attachments.AttachmentDataFactory;
import com.facebook.messaging.giftwrap.GiftWrapResolver;
import com.facebook.messaging.messageclassifier.MessageClassification;
import com.facebook.messaging.messageclassifier.MessageClassifier;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.model.threads.ThreadCustomization;
import com.facebook.messaging.payment.currency.CurrencyFormatType;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.messaging.rtc.adminmsg.xma.RTCAdminMsgSnippetCreator;
import com.facebook.messaging.xma.SnippetCreatorParams;
import com.facebook.messaging.xma.SnippetGenerator;
import com.facebook.stickers.model.StickerUtil;
import com.facebook.ui.emoji.Emojis;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.facebook.user.module.UserNameUtil;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: mSavedFragmentState= */
public class MessageSnippetHelper {
    private final Provider<ViewerContext> f15430a;
    private final MessageClassifier f15431b;
    private final AttachmentDataFactory f15432c;
    public final FbObjectMapper f15433d;
    private final Lazy<PaymentCurrencyUtil> f15434e;
    private final Resources f15435f;
    public final Provider<UserCache> f15436g;
    public final Provider<UserNameUtil> f15437h;
    private final Provider<Boolean> f15438i;
    private final Lazy<SnippetGenerator> f15439j;
    private final Lazy<RTCAdminMsgSnippetCreator> f15440k;
    private final Provider<Boolean> f15441l;
    public final Provider<Boolean> f15442m;
    private final Provider<User> f15443n;
    private final GiftWrapResolver f15444o;
    private final MessageUtil f15445p;

    public static MessageSnippetHelper m21978b(InjectorLike injectorLike) {
        return new MessageSnippetHelper(IdBasedProvider.m1811a(injectorLike, 372), MessageClassifier.m21990a(injectorLike), AttachmentDataFactory.m22010a(injectorLike), FbObjectMapperMethodAutoProvider.m6609a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 8017), ResourcesMethodAutoProvider.m6510a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3593), IdBasedSingletonScopeProvider.m1809a(injectorLike, 3599), IdBasedProvider.m1811a(injectorLike, 4085), IdBasedLazy.m1808a(injectorLike, 8603), IdBasedLazy.m1808a(injectorLike, 8331), IdBasedProvider.m1811a(injectorLike, 4144), IdBasedProvider.m1811a(injectorLike, 4143), IdBasedProvider.m1811a(injectorLike, 3596), GiftWrapResolver.m22041a(injectorLike), MessageUtil.m22063a(injectorLike));
    }

    public static MessageSnippetHelper m21973a(InjectorLike injectorLike) {
        return m21978b(injectorLike);
    }

    @Inject
    public MessageSnippetHelper(Provider<ViewerContext> provider, MessageClassifier messageClassifier, AttachmentDataFactory attachmentDataFactory, FbObjectMapper fbObjectMapper, Lazy<PaymentCurrencyUtil> lazy, Resources resources, Provider<UserCache> provider2, Provider<UserNameUtil> provider3, Provider<Boolean> provider4, Lazy<SnippetGenerator> lazy2, Lazy<RTCAdminMsgSnippetCreator> lazy3, Provider<Boolean> provider5, Provider<Boolean> provider6, Provider<User> provider7, GiftWrapResolver giftWrapResolver, MessageUtil messageUtil) {
        this.f15430a = provider;
        this.f15431b = messageClassifier;
        this.f15432c = attachmentDataFactory;
        this.f15433d = fbObjectMapper;
        this.f15434e = lazy;
        this.f15435f = resources;
        this.f15436g = provider2;
        this.f15437h = provider3;
        this.f15438i = provider4;
        this.f15439j = lazy2;
        this.f15440k = lazy3;
        this.f15441l = provider5;
        this.f15442m = provider6;
        this.f15443n = provider7;
        this.f15444o = giftWrapResolver;
        this.f15445p = messageUtil;
    }

    public final String m21982a(Message message, ThreadCustomization threadCustomization, IncludeSenderPrefix includeSenderPrefix) {
        if (this.f15444o.m22043a(message) != null) {
            return m21988d(message, threadCustomization);
        }
        if (m21987c(message)) {
            return m21989e(message, threadCustomization);
        }
        if (m21983a(message)) {
            return m21981a(message, threadCustomization);
        }
        String str = message.f;
        if (Strings.isNullOrEmpty(str)) {
            return m21985b(message, threadCustomization);
        }
        if (this.f15431b.m21993a(message) == MessageClassification.STICKER) {
            return str;
        }
        if ((message.b.a == Type.GROUP ? 1 : null) == null && includeSenderPrefix != IncludeSenderPrefix.ALWAYS) {
            return str;
        }
        return StringFormatUtil.formatStrLocaleSafe("%s: %s", m21980f(message, threadCustomization), str);
    }

    public final boolean m21983a(Message message) {
        return (!((Boolean) this.f15438i.get()).booleanValue() || message.F == null || StringUtil.m3589a(message.F.c)) ? false : true;
    }

    public final String m21981a(Message message, @Nullable ThreadCustomization threadCustomization) {
        Preconditions.checkNotNull(message.F);
        Preconditions.checkArgument(!StringUtil.m3589a(message.F.c));
        boolean equal = Objects.equal(message.e.b, m21974a());
        MessageClassification a = this.f15431b.m21993a(message);
        String str = message.F.c;
        String f = m21980f(message, threadCustomization);
        if (a == MessageClassification.AUDIO_CLIP) {
            if (equal) {
                return this.f15435f.getString(2131231308, new Object[]{str});
            }
            return this.f15435f.getString(2131231309, new Object[]{f, str});
        } else if (a == MessageClassification.VIDEO_CLIP) {
            if (equal) {
                return this.f15435f.getString(2131231310, new Object[]{str});
            }
            return this.f15435f.getString(2131231311, new Object[]{f, str});
        } else if (this.f15432c.m22023c(message)) {
            if (equal) {
                return this.f15435f.getString(2131231312, new Object[]{str});
            }
            return this.f15435f.getString(2131231313, new Object[]{f, str});
        } else if (!this.f15432c.m22021a(message)) {
            return m21985b(message, ThreadCustomization.a);
        } else {
            if (equal) {
                return this.f15435f.getString(2131231306, new Object[]{str});
            }
            return this.f15435f.getString(2131231307, new Object[]{f, str});
        }
    }

    @Nullable
    public final String m21984b(Message message) {
        Preconditions.checkArgument(ThreadKey.g(message.b));
        if (message.l == MessageType.ADMIN) {
            return message.f;
        }
        if (message.J == null || message.J.intValue() <= 0) {
            if (StringUtil.m3599c(message.f)) {
                return m21985b(message, ThreadCustomization.a);
            }
            return null;
        } else if (Objects.equal(message.e.b, m21974a())) {
            return this.f15435f.getString(2131231333);
        } else {
            String f = m21980f(message, ThreadCustomization.a);
            return this.f15435f.getString(2131231334, new Object[]{f});
        }
    }

    public final String m21985b(Message message, ThreadCustomization threadCustomization) {
        return m21975a(message, threadCustomization, true);
    }

    public final String m21986c(Message message, ThreadCustomization threadCustomization) {
        return m21975a(message, threadCustomization, false);
    }

    private String m21975a(Message message, ThreadCustomization threadCustomization, boolean z) {
        if (this.f15444o.m22043a(message) != null) {
            return m21988d(message, threadCustomization);
        }
        if (m21987c(message)) {
            return m21989e(message, threadCustomization);
        }
        boolean equal = Objects.equal(message.e.b, m21974a());
        String str = "";
        if (!equal) {
            str = m21980f(message, threadCustomization);
        }
        MessageClassification a = this.f15431b.m21993a(message);
        if (a == MessageClassification.STICKER) {
            if (z && StickerUtil.a(message.k)) {
                return m21976a(threadCustomization);
            }
            if (equal) {
                return this.f15435f.getString(2131231314);
            }
            return this.f15435f.getString(2131231315, new Object[]{str});
        } else if (a == MessageClassification.AUDIO_CLIP) {
            if (equal) {
                return this.f15435f.getString(2131231322);
            }
            return this.f15435f.getString(2131231323, new Object[]{str});
        } else if (a == MessageClassification.VIDEO_CLIP) {
            if (equal) {
                return this.f15435f.getString(2131231320);
            }
            return this.f15435f.getString(2131231321, new Object[]{str});
        } else if (this.f15432c.m22023c(message)) {
            r0 = this.f15432c.m22024d(message);
            if (equal) {
                return this.f15435f.getQuantityString(2131689493, r0, new Object[]{Integer.valueOf(r0)});
            }
            return this.f15435f.getQuantityString(2131689491, r0, new Object[]{str, Integer.valueOf(r0)});
        } else if (this.f15432c.m22021a(message)) {
            r0 = this.f15432c.m22022b(message);
            if (equal) {
                return this.f15435f.getQuantityString(2131689492, r0, new Object[]{Integer.valueOf(r0)});
            }
            return this.f15435f.getQuantityString(2131689494, r0, new Object[]{str, Integer.valueOf(r0)});
        } else if (a == MessageClassification.PAYMENT) {
            boolean b = message.b.b();
            if (message.B != null) {
                return m21977a(true, ((PaymentCurrencyUtil) this.f15434e.get()).a(CurrencyFormatType.NO_EMPTY_DECIMALS, message.B.d, message.B.e), str, Long.toString(message.B.c()), equal, b);
            }
            if (message.C != null) {
                return m21977a(false, ((PaymentCurrencyUtil) this.f15434e.get()).a(CurrencyFormatType.NO_EMPTY_DECIMALS, message.C.d, message.C.e), str, Long.toString(message.C.c()), equal, b);
            } else if (message.u == null) {
                return "";
            } else {
                return m21977a(true, ((PaymentCurrencyUtil) this.f15434e.get()).a(CurrencyFormatType.NO_EMPTY_DECIMALS, ((PaymentCurrencyUtil) this.f15434e.get()).b(message.u.c.a), message.u.c.b), str, message.u.c.d, equal, b);
            }
        } else if (a == MessageClassification.CALL_LOG) {
            return ((RTCAdminMsgSnippetCreator) this.f15440k.get()).a(SnippetCreatorParams.a(message.G));
        } else if (message.G != null) {
            SnippetCreatorParams a2;
            if (equal) {
                a2 = SnippetCreatorParams.a(message.G);
            } else {
                a2 = new SnippetCreatorParams(str, message.G);
            }
            return ((SnippetGenerator) this.f15439j.get()).a(a2);
        } else if (m21979d(message)) {
            return this.f15435f.getString(2131232332);
        } else {
            if ("sms".equals(message.p) && message.L.b()) {
                if (equal) {
                    return this.f15435f.getString(2131231318);
                }
                return this.f15435f.getString(2131231319, new Object[]{str});
            } else if (equal) {
                return this.f15435f.getString(2131231333);
            } else {
                return this.f15435f.getString(2131231334, new Object[]{str});
            }
        }
    }

    public final String m21988d(Message message, @Nullable ThreadCustomization threadCustomization) {
        boolean equal = Objects.equal(message.e.b, m21974a());
        String str = "";
        if (!equal) {
            str = m21980f(message, threadCustomization);
        }
        if (equal) {
            return this.f15435f.getString(2131231890);
        }
        return this.f15435f.getString(2131231891, new Object[]{str});
    }

    public final String m21989e(Message message, @Nullable ThreadCustomization threadCustomization) {
        if (Objects.equal(message.e.b, m21974a())) {
            return this.f15435f.getString(2131240053);
        }
        return this.f15435f.getString(2131240054, new Object[]{m21980f(message, threadCustomization)});
    }

    public final boolean m21987c(Message message) {
        MessageUtil messageUtil = this.f15445p;
        boolean z = MessageUtil.m22052N(message) && "drawing".equals(message.v.get("photo_type"));
        return z;
    }

    private String m21977a(boolean z, String str, String str2, String str3, boolean z2, boolean z3) {
        String h;
        User a = ((UserCache) this.f15436g.get()).a(UserKey.m5862b(str3));
        if (a != null) {
            h = a.m5843h();
        } else {
            h = "";
        }
        String str4 = h;
        if (z2) {
            if (z3) {
                int i;
                Resources resources = this.f15435f;
                if (z) {
                    i = 2131231326;
                } else {
                    i = 2131231327;
                }
                return resources.getString(i, new Object[]{str4, str});
            }
            return this.f15435f.getString(z ? 2131231324 : 2131231325, new Object[]{str});
        } else if (!((User) this.f15443n.get()).m5840d().equals(str3)) {
            return this.f15435f.getString(z ? 2131231331 : 2131231332, new Object[]{str2, str4, str});
        } else if (z) {
            return this.f15435f.getString(2131231328, new Object[]{str2, str});
        } else {
            return this.f15435f.getString(z3 ? 2131231330 : 2131231329, new Object[]{str2, str});
        }
    }

    private static boolean m21979d(Message message) {
        return "sms".equals(message.p) && message.L.a();
    }

    private String m21976a(@Nullable ThreadCustomization threadCustomization) {
        if (((Boolean) this.f15441l.get()).booleanValue() && threadCustomization != null) {
            CharSequence charSequence = threadCustomization.f;
            if (!StringUtil.m3589a(charSequence)) {
                return charSequence;
            }
        }
        return Emojis.f24284b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m21980f(com.facebook.messaging.model.messages.Message r7, @javax.annotation.Nullable com.facebook.messaging.model.threads.ThreadCustomization r8) {
        /*
        r6 = this;
        r0 = r7.e;
        r3 = r6.f15442m;
        r3 = r3.get();
        r3 = (java.lang.Boolean) r3;
        r3 = r3.booleanValue();
        if (r3 == 0) goto L_0x005f;
    L_0x0010:
        if (r8 == 0) goto L_0x005f;
    L_0x0012:
        r3 = r0.b;
        if (r3 == 0) goto L_0x005f;
    L_0x0016:
        r3 = r8.g;
        r4 = r0.b;
        r4 = r4.m5867b();
        r5 = r6.f15433d;
        r3 = r3.a(r4, r5);
        r4 = com.facebook.common.util.StringUtil.m3589a(r3);
        if (r4 != 0) goto L_0x005f;
    L_0x002a:
        r1 = r3;
        r2 = com.facebook.common.util.StringUtil.m3589a(r1);
        if (r2 == 0) goto L_0x004f;
    L_0x0031:
        r2 = r0.b;
        if (r2 == 0) goto L_0x004f;
    L_0x0035:
        r1 = r6.f15436g;
        r1 = r1.get();
        r1 = (com.facebook.user.cache.UserCache) r1;
        r2 = r0.b;
        r2 = r1.a(r2);
        r1 = r6.f15437h;
        r1 = r1.get();
        r1 = (com.facebook.user.module.UserNameUtil) r1;
        r1 = r1.a(r2);
    L_0x004f:
        r2 = com.facebook.common.util.StringUtil.m3589a(r1);
        if (r2 == 0) goto L_0x0057;
    L_0x0055:
        r1 = r0.c;
    L_0x0057:
        r0 = r1;
        if (r0 != 0) goto L_0x005e;
    L_0x005a:
        r0 = r7.e;
        r0 = r0.c;
    L_0x005e:
        return r0;
    L_0x005f:
        r3 = 0;
        goto L_0x002a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.notify.MessageSnippetHelper.f(com.facebook.messaging.model.messages.Message, com.facebook.messaging.model.threads.ThreadCustomization):java.lang.String");
    }

    private UserKey m21974a() {
        return UserKey.m5862b(((ViewerContext) this.f15430a.get()).mUserId);
    }
}
