package com.facebook.messaging.model.messages;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLExtensibleMessageAdminTextType;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.messaging.model.messages.GenericAdminMessageInfo.JoinableEventType;
import com.facebook.messaging.model.share.Share;
import com.facebook.messaging.model.share.ShareMedia;
import com.facebook.messaging.model.share.ShareMedia.Type;
import com.facebook.messaging.rtc.adminmsg.model.RTCAdminMsgProperties;
import com.facebook.messaging.rtc.adminmsg.model.RTCAdminMsgProperties.Builder;
import com.facebook.stickers.model.StickerUtil;
import com.facebook.user.model.UserKey;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: mPriorityLock */
public class MessageUtil {
    private static MessageUtil f15482b;
    private static final Object f15483c = new Object();
    private final Provider<UserKey> f15484a;

    private static MessageUtil m22069b(InjectorLike injectorLike) {
        return new MessageUtil(IdBasedProvider.m1811a(injectorLike, 3597));
    }

    @Inject
    public MessageUtil(Provider<UserKey> provider) {
        this.f15484a = provider;
    }

    public static boolean m22065a(Message message) {
        return message.l == MessageType.PENDING_SEND;
    }

    public static boolean m22070b(Message message) {
        return message.l == MessageType.FAILED_SEND;
    }

    public static boolean m22071c(Message message) {
        return Publicity.b.equals(message.s);
    }

    public static MessageUtil m22063a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MessageUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f15483c) {
                MessageUtil messageUtil;
                if (a2 != null) {
                    messageUtil = (MessageUtil) a2.mo818a(f15483c);
                } else {
                    messageUtil = f15482b;
                }
                if (messageUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m22069b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f15483c, b3);
                        } else {
                            f15482b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = messageUtil;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public static long m22072d(Message message) {
        return (((message.d > 0 ? 1 : (message.d == 0 ? 0 : -1)) != 0 ? 1 : null) == null || message.d >= message.c) ? message.c : message.d;
    }

    public static boolean m22066a(Message message, Message message2) {
        return (message.G == null && message2.G == null) ? false : true;
    }

    public static long m22068b(Message message, Message message2) {
        return Math.abs(m22072d(message) - m22072d(message2));
    }

    public static boolean m22074e(Message message) {
        return (message.t == null || message.t.isEmpty()) ? false : true;
    }

    public static boolean m22075f(Message message) {
        if (message.G == null) {
            Object obj;
            if (message.i == null || message.i.isEmpty()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                if (message.j == null || message.j.isEmpty()) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj == null) {
                    if ((!message.L.d.isEmpty() ? 1 : null) == null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static String m22076i(Message message) {
        if (message.k != null) {
            return null;
        }
        return message.f;
    }

    public static boolean m22077j(Message message) {
        return !m22047B(message);
    }

    public static boolean m22078k(Message message) {
        MessageType messageType = message.l;
        return messageType == MessageType.SET_IMAGE || messageType == MessageType.REMOVED_IMAGE || messageType == MessageType.SET_NAME || m22067a(messageType) || m22079l(message);
    }

    public static boolean m22067a(MessageType messageType) {
        return messageType == MessageType.ADD_MEMBERS || messageType == MessageType.REMOVE_MEMBERS;
    }

    public static boolean m22079l(Message message) {
        if (message.l == MessageType.ADMIN && message.I != null) {
            if ((message.I.c == GraphQLExtensibleMessageAdminTextType.GROUP_THREAD_CREATED ? 1 : null) != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean m22080m(Message message) {
        if (message.l == MessageType.ADMIN && message.I != null) {
            GenericAdminMessageInfo genericAdminMessageInfo = message.I;
            Object obj = (genericAdminMessageInfo.c() || genericAdminMessageInfo.d() || genericAdminMessageInfo.e()) ? 1 : null;
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean m22081n(Message message) {
        return message.l == MessageType.ADMIN && message.I != null && message.I.c();
    }

    public static boolean m22082o(Message message) {
        return message.l == MessageType.ADMIN && message.I != null && message.I.d();
    }

    public static boolean m22083p(Message message) {
        return message.l == MessageType.ADMIN && message.I != null && message.I.e();
    }

    public static boolean m22084q(Message message) {
        if (message.l == MessageType.ADMIN && message.I != null) {
            if ((message.I.c == GraphQLExtensibleMessageAdminTextType.RAMP_UP_WELCOME_MESSAGE ? 1 : null) != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean m22085r(Message message) {
        if (message.l == MessageType.ADMIN && message.I != null) {
            if ((message.I.c == GraphQLExtensibleMessageAdminTextType.CONFIRM_FRIEND_REQUEST ? 1 : null) != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean m22086s(Message message) {
        return message.l == MessageType.ADMIN && message.I != null && message.I.g();
    }

    public static boolean m22087t(Message message) {
        return message.l == MessageType.OUTGOING_CALL || message.l == MessageType.INCOMING_CALL || message.l == MessageType.MISSED_CALL || message.l == MessageType.VIDEO_CALL || message.l == MessageType.MISSED_VIDEO_CALL || message.l == MessageType.CALL_LOG;
    }

    public static boolean m22088u(Message message) {
        return (message.l != MessageType.CALL_LOG || message.G == null || message.G.l() == null || message.G.l().aN_() == null || !message.G.l().aN_().contains(GraphQLStoryAttachmentStyle.RTC_CALL_LOG)) ? false : true;
    }

    public final RTCAdminMsgProperties m22094v(Message message) {
        if (message.l != MessageType.CALL_LOG || message.G == null || message.G.l() == null || message.G.l().b() == null) {
            return null;
        }
        return new Builder((UserKey) this.f15484a.get()).a(message.G.l().b()).a();
    }

    public final boolean m22095w(Message message) {
        RTCAdminMsgProperties v = m22094v(message);
        if (v == null || !v.d || v.c) {
            return false;
        }
        return true;
    }

    public static boolean m22089x(Message message) {
        return message.l == MessageType.TELEPHONE_CALL_LOG;
    }

    public static boolean m22090y(Message message) {
        return message.l == MessageType.SMS_LOG;
    }

    public static boolean m22091z(Message message) {
        return message.l == MessageType.P2P_PAYMENT || message.l == MessageType.P2P_PAYMENT_CANCELED || message.l == MessageType.P2P_PAYMENT_GROUP;
    }

    public static boolean m22046A(Message message) {
        return !StringUtil.m3599c(message.f);
    }

    public static boolean m22047B(Message message) {
        MessageType messageType = message.l;
        boolean z = (messageType == MessageType.REGULAR || messageType == MessageType.PENDING_SEND || messageType == MessageType.FAILED_SEND || messageType == MessageType.GLOBALLY_DELETED_MESSAGE_PLACEHOLDER) ? false : true;
        return z;
    }

    public static boolean m22048H(Message message) {
        return message.I != null && message.I.c();
    }

    public static boolean m22049I(Message message) {
        if (message.I != null) {
            if ((message.I.c == GraphQLExtensibleMessageAdminTextType.RIDE_ORDERED_MESSAGE ? 1 : null) != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean m22050K(Message message) {
        return message.I != null && message.I.q();
    }

    public static boolean m22051L(Message message) {
        if (message.I != null) {
            GenericAdminMessageInfo genericAdminMessageInfo = message.I;
            Object obj = (genericAdminMessageInfo.c == GraphQLExtensibleMessageAdminTextType.CHANGE_JOINABLE_SETTING && (genericAdminMessageInfo.v == JoinableEventType.TURN_ON_JOINABLE_BY_OWNER || genericAdminMessageInfo.v == JoinableEventType.TURN_ON_JOINABLE_BY_USER)) ? 1 : null;
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean m22052N(Message message) {
        return (message.v == null || message.v.isEmpty()) ? false : true;
    }

    public static boolean m22053O(Message message) {
        return !StringUtil.m3589a(message.n);
    }

    public final boolean m22092P(Message message) {
        return message.e != null && Objects.equal(message.e.b, this.f15484a.get());
    }

    public final UserKey m22093a() {
        return (UserKey) this.f15484a.get();
    }

    public static boolean m22054Q(Message message) {
        return message.k != null;
    }

    public static boolean m22055R(Message message) {
        return StickerUtil.a(message.k) && !Objects.equal(message.k, "227878347358915");
    }

    @Nullable
    public static Share m22056T(Message message) {
        if (!message.j.isEmpty()) {
            return (Share) message.j.get(0);
        }
        if (message.u != null) {
            return message.u.b;
        }
        return null;
    }

    public static ShareMedia m22064a(Share share) {
        ImmutableList immutableList = share.g;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ShareMedia shareMedia = (ShareMedia) immutableList.get(i);
            if (!Type.UNKNOWN.equals(shareMedia.a) && shareMedia.a != null) {
                return shareMedia;
            }
        }
        return null;
    }

    public static boolean m22057U(Message message) {
        return !StringUtil.m3599c(message.f) && ((message.i == null || message.i.isEmpty()) && message.G == null && message.H == null && (message.l == MessageType.REGULAR || message.l == MessageType.PENDING_SEND));
    }

    public static boolean m22058V(Message message) {
        return (message.J == null || message.J.equals(Integer.valueOf(0))) ? false : true;
    }

    public static boolean m22073d(Message message, Message message2) {
        return message.a.equals(message2.a) && m22058V(message) && m22058V(message2) && message.o && !message2.o;
    }

    public static boolean m22059W(Message message) {
        return (message.G == null || message.G.l() == null || message.G.l().aN_() == null || !message.G.l().aN_().contains(GraphQLStoryAttachmentStyle.H_SCROLL)) ? false : true;
    }

    public static boolean m22060X(Message message) {
        if (message.I != null) {
            if ((message.I.c == GraphQLExtensibleMessageAdminTextType.LIGHTWEIGHT_EVENT_CREATE ? 1 : null) != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean m22061Y(Message message) {
        if (message.I != null) {
            GenericAdminMessageInfo genericAdminMessageInfo = message.I;
            Object obj = (genericAdminMessageInfo.c == GraphQLExtensibleMessageAdminTextType.LIGHTWEIGHT_EVENT_UPDATE || genericAdminMessageInfo.c == GraphQLExtensibleMessageAdminTextType.LIGHTWEIGHT_EVENT_UPDATE_TIME || genericAdminMessageInfo.c == GraphQLExtensibleMessageAdminTextType.LIGHTWEIGHT_EVENT_UPDATE_TITLE) ? 1 : null;
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean m22062Z(Message message) {
        if (message.I != null) {
            if ((message.I.c == GraphQLExtensibleMessageAdminTextType.LIGHTWEIGHT_EVENT_RSVP ? 1 : null) != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean aa(Message message) {
        if (message.I != null) {
            if ((message.I.c == GraphQLExtensibleMessageAdminTextType.LIGHTWEIGHT_EVENT_DELETE ? 1 : null) != null) {
                return true;
            }
        }
        return false;
    }
}
