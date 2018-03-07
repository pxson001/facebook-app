package com.facebook.orca.threadview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.TriState;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.commerce.gating.IsMessengerCommerceEnabled;
import com.facebook.messaging.business.commerceui.gating.IsMessengerCommerceShoppingEnabled;
import com.facebook.messaging.business.promotion.gating.BusinessPromotionGatekeepers;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.cache.ThreadParticipantUtils;
import com.facebook.messaging.ephemeral.abtest.ExperimentsForEphemeralModule;
import com.facebook.messaging.ephemeral.gating.EphemeralGatingUtil;
import com.facebook.messaging.groups.links.gatekeepers.JoinableLinksGatekeepers;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.rtc.dialog.RTCMultiwaySelectDialogBuilder;
import com.facebook.messaging.sms.util.SmsContactUtil;
import com.facebook.orca.threadview.ThreadViewLoader.Result;
import com.facebook.pages.messaging.sendercontextcard.abtest.ExperimentsForSenderContextCardAbtestModule;
import com.facebook.presence.DefaultPresenceManager;
import com.facebook.presence.PresenceManager;
import com.facebook.presence.ThreadPresenceManager;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rtc.annotations.IsVoipVideoEnabled;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler;
import com.facebook.rtc.fbwebrtc.abtests.ExperimentsForRtcModule;
import com.facebook.rtc.helpers.RtcCallButtonIconProvider;
import com.facebook.rtc.helpers.RtcCallHandler;
import com.facebook.rtcpresence.RtcPresenceHandler;
import com.facebook.rtcpresence.RtcPresenceState;
import com.facebook.rtcpresence.annotations.IsGroupCallingButtonEnabled;
import com.facebook.rtcpresence.annotations.IsRtcConferencingEnabled;
import com.facebook.rtcpresence.annotations.IsRtcVideoConferencingEnabled;
import com.facebook.rtcpresence.annotations.IsVoipBlockedByCountry;
import com.facebook.rtcpresence.annotations.IsVoipEnabledForUser;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.facebook.user.model.User.CommercePageSetting;
import com.facebook.user.model.User.CommercePageType;
import com.facebook.user.model.UserKey;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: media_item_position */
public class ThreadViewTitleBarButtonSpecHelper {
    public TitleBarButtonSpec f7981A;
    public TitleBarButtonSpec f7982B;
    public TitleBarButtonSpec f7983C;
    public TitleBarButtonSpec f7984D;
    public TitleBarButtonSpec f7985E;
    public TitleBarButtonSpec f7986F;
    public TitleBarButtonSpec f7987G;
    public TitleBarButtonSpec f7988H;
    public TitleBarButtonSpec f7989I;
    public TitleBarButtonSpec f7990J;
    public TitleBarButtonSpec f7991K;
    public TitleBarButtonSpec f7992L;
    public TitleBarButtonSpec f7993M;
    public TitleBarButtonSpec f7994N;
    public TitleBarButtonSpec f7995O;
    public TitleBarButtonSpec f7996P;
    public TitleBarButtonSpec f7997Q;
    public int f7998R;
    public boolean f7999S;
    public final GlyphColorizer f8000T;
    private final DefaultPresenceManager f8001U;
    private Context f8002a;
    private DataCache f8003b;
    public FbAppType f8004c;
    @IsVoipVideoEnabled
    public Provider<Boolean> f8005d;
    @IsGroupCallingButtonEnabled
    private Provider<Boolean> f8006e;
    @IsMessengerCommerceEnabled
    private Provider<Boolean> f8007f;
    @IsMessengerCommerceShoppingEnabled
    private Provider<Boolean> f8008g;
    @IsRtcConferencingEnabled
    public Provider<Boolean> f8009h;
    @IsRtcVideoConferencingEnabled
    private Provider<Boolean> f8010i;
    @IsVoipBlockedByCountry
    public Provider<Boolean> f8011j;
    @IsVoipEnabledForUser
    public Provider<Boolean> f8012k;
    public Resources f8013l;
    public RtcCallButtonIconProvider f8014m;
    private RtcPresenceHandler f8015n;
    private final ThreadPresenceManager f8016o;
    public EphemeralGatingUtil f8017p;
    private ThreadParticipantUtils f8018q;
    public final QeAccessor f8019r;
    private final RTCMultiwaySelectDialogBuilder f8020s;
    private final RtcCallHandler f8021t;
    public final BusinessPromotionGatekeepers f8022u;
    private final UserCache f8023v;
    private final SmsContactUtil f8024w;
    private final JoinableLinksGatekeepers f8025x;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<WebrtcUiHandler> f8026y = UltralightRuntime.b();
    public TitleBarButtonSpec f8027z;

    private static ThreadViewTitleBarButtonSpecHelper m7913b(InjectorLike injectorLike) {
        ThreadViewTitleBarButtonSpecHelper threadViewTitleBarButtonSpecHelper = new ThreadViewTitleBarButtonSpecHelper((Context) injectorLike.getInstance(Context.class), DataCache.a(injectorLike), (FbAppType) injectorLike.getInstance(FbAppType.class), IdBasedProvider.a(injectorLike, 4302), IdBasedProvider.a(injectorLike, 4307), IdBasedProvider.a(injectorLike, 4113), IdBasedProvider.a(injectorLike, 4116), IdBasedProvider.a(injectorLike, 4312), IdBasedProvider.a(injectorLike, 4314), IdBasedProvider.a(injectorLike, 4308), IdBasedProvider.a(injectorLike, 4311), ResourcesMethodAutoProvider.a(injectorLike), RtcCallButtonIconProvider.a(injectorLike), RtcPresenceHandler.a(injectorLike), GlyphColorizer.a(injectorLike), ThreadPresenceManager.a(injectorLike), EphemeralGatingUtil.a(injectorLike), ThreadParticipantUtils.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), DefaultPresenceManager.a(injectorLike), RTCMultiwaySelectDialogBuilder.m3600a(injectorLike), RtcCallHandler.a(injectorLike), BusinessPromotionGatekeepers.a(injectorLike), UserCache.a(injectorLike), SmsContactUtil.a(injectorLike), JoinableLinksGatekeepers.m2480a(injectorLike));
        threadViewTitleBarButtonSpecHelper.m7910a(IdBasedLazy.a(injectorLike, 10375));
        return threadViewTitleBarButtonSpecHelper;
    }

    public static ThreadViewTitleBarButtonSpecHelper m7904a(InjectorLike injectorLike) {
        return m7913b(injectorLike);
    }

    @Inject
    private ThreadViewTitleBarButtonSpecHelper(Context context, DataCache dataCache, FbAppType fbAppType, Provider<Boolean> provider, Provider<Boolean> provider2, Provider<Boolean> provider3, Provider<Boolean> provider4, Provider<Boolean> provider5, Provider<Boolean> provider6, Provider<Boolean> provider7, Provider<Boolean> provider8, Resources resources, RtcCallButtonIconProvider rtcCallButtonIconProvider, RtcPresenceHandler rtcPresenceHandler, GlyphColorizer glyphColorizer, ThreadPresenceManager threadPresenceManager, EphemeralGatingUtil ephemeralGatingUtil, ThreadParticipantUtils threadParticipantUtils, QeAccessor qeAccessor, PresenceManager presenceManager, RTCMultiwaySelectDialogBuilder rTCMultiwaySelectDialogBuilder, RtcCallHandler rtcCallHandler, BusinessPromotionGatekeepers businessPromotionGatekeepers, UserCache userCache, SmsContactUtil smsContactUtil, JoinableLinksGatekeepers joinableLinksGatekeepers) {
        this.f8002a = context;
        this.f8003b = dataCache;
        this.f8004c = fbAppType;
        this.f8005d = provider;
        this.f8006e = provider2;
        this.f8007f = provider3;
        this.f8008g = provider4;
        this.f8011j = provider5;
        this.f8012k = provider6;
        this.f8009h = provider7;
        this.f8010i = provider8;
        this.f8013l = resources;
        this.f8014m = rtcCallButtonIconProvider;
        this.f8015n = rtcPresenceHandler;
        this.f8000T = glyphColorizer;
        this.f8016o = threadPresenceManager;
        this.f8017p = ephemeralGatingUtil;
        this.f8018q = threadParticipantUtils;
        this.f8019r = qeAccessor;
        this.f8001U = presenceManager;
        this.f8020s = rTCMultiwaySelectDialogBuilder;
        this.f8021t = rtcCallHandler;
        this.f8022u = businessPromotionGatekeepers;
        this.f8023v = userCache;
        this.f8024w = smsContactUtil;
        this.f8025x = joinableLinksGatekeepers;
        this.f7998R = m7903a(this.f8002a);
    }

    private void m7910a(com.facebook.inject.Lazy<WebrtcUiHandler> lazy) {
        this.f8026y = lazy;
    }

    public final List<TitleBarButtonSpec> m7928a(@Nullable ThreadKey threadKey, Result result, boolean z, boolean z2, @Nullable User user) {
        Object obj;
        Builder builder = ImmutableList.builder();
        this.f7999S = false;
        if (z && m7920c(result)) {
            if (this.f7987G == null) {
                TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
                a.a = 7;
                a = a;
                a.l = 2130907388;
                this.f7987G = a.a();
            }
            builder.c(this.f7987G);
            this.f7999S = true;
        }
        builder = m7909a(m7906a(m7907a(m7905a(builder, threadKey, result), result.f7611a), threadKey, result, z2), user, result);
        if (!this.f8022u.a() || user == null || !user.T() || user.v == CommercePageType.COMMERCE_PAGE_TYPE_AGENT) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            if (this.f7995O == null) {
                TitleBarButtonSpec.Builder a2 = TitleBarButtonSpec.a();
                a2.a = 23;
                a2 = a2;
                a2.l = 2130907385;
                a2 = a2;
                a2.m = this.f7998R;
                a2 = a2;
                a2.g = this.f8013l.getString(2131231121);
                a2 = a2;
                a2.j = this.f8013l.getString(2131231121);
                this.f7995O = a2.a();
            }
            builder.c(this.f7995O);
        }
        return m7918c(m7921d(m7908a(builder, user, threadKey, result), threadKey, result), threadKey, result).b();
    }

    protected final boolean m7929a() {
        this.f8019r.a(Liveness.Cached, ExperimentsForRtcModule.aF);
        return ((WebrtcUiHandler) this.f8026y.get()).l();
    }

    private boolean m7914b() {
        if (this.f8019r.a(ExperimentsForRtcModule.cw, 0) == 1) {
            return true;
        }
        return false;
    }

    private Builder<TitleBarButtonSpec> m7905a(Builder<TitleBarButtonSpec> builder, @Nullable ThreadKey threadKey, Result result) {
        if (m7916b(threadKey, result)) {
            if (this.f7991K == null) {
                String string = this.f8013l.getString(2131231882);
                TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
                a.a = 17;
                a = a;
                a.g = string;
                a = a;
                a.j = string;
                TitleBarButtonSpec.Builder builder2 = a;
                builder2.l = 2130903987;
                builder2 = builder2;
                builder2.m = this.f7998R;
                this.f7991K = builder2.a();
            }
            this.f7991K.s = result.f7611a.h();
            builder.c(this.f7991K);
        }
        return builder;
    }

    private boolean m7916b(@Nullable ThreadKey threadKey, Result result) {
        return (result.f7611a == null || m7917b(result) || m7915b(threadKey) || !this.f8017p.b(result.f7611a)) ? false : true;
    }

    public final List<TitleBarButtonSpec> m7927a(@Nullable ThreadKey threadKey, Result result) {
        Builder builder = ImmutableList.builder();
        boolean z = false;
        if (this.f8004c.j == Product.PAA && !m7911a(threadKey) && m7920c(result) && this.f8019r.a(Liveness.Live, ExperimentsForSenderContextCardAbtestModule.f8410a, false)) {
            z = true;
        }
        if (z) {
            if (this.f7989I == null) {
                Drawable a = this.f8000T.a(2130839943, -7235677);
                String string = this.f8013l.getString(2131231372);
                TitleBarButtonSpec.Builder a2 = TitleBarButtonSpec.a();
                a2.a = 14;
                a2 = a2;
                a2.g = string;
                a2 = a2;
                a2.j = string;
                TitleBarButtonSpec.Builder builder2 = a2;
                builder2.b = a;
                this.f7989I = builder2.a();
            }
            builder.c(this.f7989I);
        }
        return builder.b();
    }

    private Builder<TitleBarButtonSpec> m7906a(Builder<TitleBarButtonSpec> builder, @Nullable ThreadKey threadKey, Result result, boolean z) {
        if (!m7919c(threadKey, result)) {
            Object obj;
            TitleBarButtonSpec.Builder a;
            if (!m7911a(threadKey)) {
                UserKey a2;
                RtcPresenceState a3;
                ThreadSummary threadSummary = result.f7611a;
                if (((Boolean) this.f8005d.get()).booleanValue()) {
                    EphemeralGatingUtil ephemeralGatingUtil = this.f8017p;
                    boolean z2 = this.f7999S;
                    boolean z3 = false;
                    if (!ephemeralGatingUtil.a() && (ephemeralGatingUtil.c.a(ExperimentsForEphemeralModule.b, false) || (z2 && ephemeralGatingUtil.b(threadSummary)))) {
                        z3 = true;
                    }
                    if (z3) {
                        obj = 1;
                        if (obj == null) {
                            builder.c(m7926o());
                        } else {
                            a2 = ThreadKey.a(threadKey);
                            a3 = this.f8015n.a(a2);
                            if (a3.a || !this.f8001U.b(a2)) {
                                if (this.f8027z != null) {
                                    a = TitleBarButtonSpec.a();
                                    a.a = 5;
                                    a = a;
                                    a.r = 2131558458;
                                    a = a;
                                    a.b = this.f8014m.a(a3);
                                    a = a;
                                    a.g = this.f8013l.getString(2131232036);
                                    a = a;
                                    a.j = this.f8013l.getString(2131232036);
                                    a = a;
                                    a.f = "free_call_button";
                                    this.f8027z = a.a();
                                } else {
                                    a = TitleBarButtonSpec.a(this.f8027z);
                                    a.b = this.f8014m.a(a3);
                                    this.f8027z = a.a();
                                }
                                builder.c(this.f8027z);
                            } else {
                                if (this.f8027z == null) {
                                    a = TitleBarButtonSpec.a();
                                    a.a = 5;
                                    a = a;
                                    a.r = 2131558458;
                                    a = a;
                                    a.b = this.f8014m.d();
                                    a = a;
                                    a.g = this.f8013l.getString(2131232036);
                                    a = a;
                                    a.j = this.f8013l.getString(2131232036);
                                    a = a;
                                    a.f = "free_call_button";
                                    this.f8027z = a.a();
                                } else {
                                    a = TitleBarButtonSpec.a(this.f8027z);
                                    a.b = this.f8014m.d();
                                    this.f8027z = a.a();
                                }
                                builder.c(this.f8027z);
                            }
                            if (((Boolean) this.f8005d.get()).booleanValue()) {
                                if (this.f8016o.f(a2) <= 0 && m7929a()) {
                                    builder.c(m7924j());
                                } else if (this.f8016o.d(a2) || !m7914b()) {
                                    if (this.f7984D != null) {
                                        a = TitleBarButtonSpec.a();
                                        a.a = 10;
                                        a = a;
                                        a.r = 2131558457;
                                        a = a;
                                        a.b = this.f8014m.b(a3);
                                        a = a;
                                        a.g = this.f8013l.getString(2131232037);
                                        a = a;
                                        a.j = this.f8013l.getString(2131232037);
                                        a = a;
                                        a.f = "video_call_button";
                                        this.f7984D = a.a();
                                    } else {
                                        a = TitleBarButtonSpec.a(this.f7984D);
                                        a.b = this.f8014m.b(a3);
                                        this.f7984D = a.a();
                                    }
                                    builder.c(this.f7984D);
                                } else {
                                    builder.c(m7925k());
                                }
                            }
                        }
                    }
                }
                obj = null;
                if (obj == null) {
                    a2 = ThreadKey.a(threadKey);
                    a3 = this.f8015n.a(a2);
                    if (a3.a) {
                    }
                    if (this.f8027z != null) {
                        a = TitleBarButtonSpec.a(this.f8027z);
                        a.b = this.f8014m.a(a3);
                        this.f8027z = a.a();
                    } else {
                        a = TitleBarButtonSpec.a();
                        a.a = 5;
                        a = a;
                        a.r = 2131558458;
                        a = a;
                        a.b = this.f8014m.a(a3);
                        a = a;
                        a.g = this.f8013l.getString(2131232036);
                        a = a;
                        a.j = this.f8013l.getString(2131232036);
                        a = a;
                        a.f = "free_call_button";
                        this.f8027z = a.a();
                    }
                    builder.c(this.f8027z);
                    if (((Boolean) this.f8005d.get()).booleanValue()) {
                        if (this.f8016o.f(a2) <= 0) {
                        }
                        if (this.f8016o.d(a2)) {
                        }
                        if (this.f7984D != null) {
                            a = TitleBarButtonSpec.a(this.f7984D);
                            a.b = this.f8014m.b(a3);
                            this.f7984D = a.a();
                        } else {
                            a = TitleBarButtonSpec.a();
                            a.a = 10;
                            a = a;
                            a.r = 2131558457;
                            a = a;
                            a.b = this.f8014m.b(a3);
                            a = a;
                            a.g = this.f8013l.getString(2131232037);
                            a = a;
                            a.j = this.f8013l.getString(2131232037);
                            a = a;
                            a.f = "video_call_button";
                            this.f7984D = a.a();
                        }
                        builder.c(this.f7984D);
                    }
                } else {
                    builder.c(m7926o());
                }
            } else if (!(result == null || result.f7611a == null || result.f7611a.h == null)) {
                int size = result.f7611a.h.size();
                if (this.f8004c.j == Product.MESSENGER) {
                    if (((Boolean) this.f8009h.get()).booleanValue() || z) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        if (this.f8021t.f() >= size || this.f8020s.m3602a()) {
                            if (((Boolean) this.f8010i.get()).booleanValue()) {
                                if (this.f7986F == null) {
                                    a = TitleBarButtonSpec.a();
                                    a.a = 25;
                                    a = a;
                                    a.b = this.f8014m.b(z);
                                    a = a;
                                    a.r = 2131558460;
                                    a = a;
                                    a.g = this.f8013l.getString(2131232037);
                                    a = a;
                                    a.j = this.f8013l.getString(2131232037);
                                    a = a;
                                    a.f = "video_conference_call_button";
                                    this.f7986F = a.a();
                                } else {
                                    a = TitleBarButtonSpec.a(this.f7986F);
                                    a.b = this.f8014m.b(z);
                                    this.f7986F = a.a();
                                }
                                builder.c(this.f7986F);
                            }
                            if (this.f7985E == null) {
                                a = TitleBarButtonSpec.a();
                                a.a = 16;
                                a = a;
                                a.b = this.f8014m.a(z);
                                a = a;
                                a.r = 2131558459;
                                a = a;
                                a.g = this.f8013l.getString(2131232036);
                                a = a;
                                a.j = this.f8013l.getString(2131232036);
                                a = a;
                                a.f = "conference_call_button";
                                this.f7985E = a.a();
                            } else {
                                a = TitleBarButtonSpec.a(this.f7985E);
                                a.b = this.f8014m.a(z);
                                this.f7985E = a.a();
                            }
                            builder.c(this.f7985E);
                        } else {
                            builder.c(m7923i());
                        }
                    }
                }
                if (((Boolean) this.f8006e.get()).booleanValue()) {
                    builder.c(m7923i());
                }
            }
        }
        return builder;
    }

    private Builder<TitleBarButtonSpec> m7909a(Builder<TitleBarButtonSpec> builder, @Nullable User user, Result result) {
        if (m7912a(user, result)) {
            if (this.f7990J == null) {
                TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
                a.a = 15;
                a = a;
                a.b = this.f8000T.a(2130841437, this.f7998R);
                a = a;
                a.g = this.f8013l.getString(2131231073);
                a = a;
                a.j = this.f8013l.getString(2131231073);
                this.f7990J = a.a();
            }
            builder.c(this.f7990J);
        }
        return builder;
    }

    private Builder<TitleBarButtonSpec> m7908a(Builder<TitleBarButtonSpec> builder, User user, @Nullable ThreadKey threadKey, Result result) {
        Object obj;
        if (result == null || ((!m7911a(threadKey) || result.f7611a == null) && user == null)) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            if (this.f7988H == null) {
                TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
                a.a = 6;
                a = a;
                a.r = 2131558454;
                a = a;
                a.b = this.f8000T.a(2130841449, this.f7998R);
                a = a;
                a.h = this.f8013l.getDimensionPixelSize(2131428515);
                a = a;
                a.f = "overflow_menu_button";
                a = a;
                a.g = this.f8013l.getString(2131231079);
                this.f7988H = a.a();
            }
            builder.c(this.f7988H);
        }
        return builder;
    }

    public static boolean m7911a(@Nullable ThreadKey threadKey) {
        return threadKey != null && threadKey.a == Type.GROUP;
    }

    private boolean m7915b(@Nullable ThreadKey threadKey) {
        UserKey a = ThreadKey.a(threadKey);
        if (a != null) {
            User a2 = this.f8023v.a(a);
            if (a2 != null) {
                return a2.T();
            }
        }
        return false;
    }

    private boolean m7917b(Result result) {
        if (!((Boolean) this.f8007f.get()).booleanValue() || result == null || result.f7611a == null || result.f7611a.h == null) {
            return false;
        }
        ImmutableList immutableList = result.f7611a.h;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            if (((ThreadParticipant) immutableList.get(i)).f()) {
                return true;
            }
        }
        return false;
    }

    private boolean m7912a(@Nullable User user, Result result) {
        return m7917b(result) && user != null && user.w != null && user.w.contains(CommercePageSetting.IN_MESSENGER_SHOPPING_ENABLED) && ((Boolean) this.f8008g.get()).booleanValue();
    }

    public static boolean m7920c(Result result) {
        return result != null && ((result.f7611a != null && result.f7611a.u) || (result.f7612b != null && result.f7612b.K));
    }

    private boolean m7919c(@Nullable ThreadKey threadKey, Result result) {
        if (!(!m7920c(result) || m7915b(threadKey) || m7917b(result))) {
            Object obj = (((Boolean) this.f8012k.get()).booleanValue() || ((Boolean) this.f8011j.get()).booleanValue()) ? 1 : null;
            if (!(obj == null || ThreadKey.d(threadKey) || ThreadKey.g(threadKey))) {
                return false;
            }
        }
        return true;
    }

    private Builder<TitleBarButtonSpec> m7918c(Builder<TitleBarButtonSpec> builder, ThreadKey threadKey, Result result) {
        if (ThreadKey.d(threadKey) && result.f7611a != null) {
            if (result.f7611a.h.size() == 2 && this.f8018q.a(result.f7611a).b().f() == null) {
                if (this.f7994N == null) {
                    TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
                    a.a = 22;
                    TitleBarButtonSpec.Builder builder2 = a;
                    builder2.b = this.f8000T.a(2130841415, this.f7998R);
                    builder2 = builder2;
                    builder2.g = this.f8013l.getString(2131231075);
                    builder2.j = this.f8013l.getString(2131231075);
                    this.f7994N = a.a();
                }
                builder.c(this.f7994N);
            } else {
                builder.c(m7922f());
            }
        }
        return builder;
    }

    private Builder<TitleBarButtonSpec> m7907a(Builder<TitleBarButtonSpec> builder, @Nullable ThreadSummary threadSummary) {
        if (threadSummary == null || !threadSummary.a.b()) {
            return builder;
        }
        boolean z;
        JoinableLinksGatekeepers joinableLinksGatekeepers = this.f8025x;
        if (threadSummary.T == TriState.NO) {
            z = false;
        } else {
            z = joinableLinksGatekeepers.m2483a(threadSummary);
        }
        if (!z) {
            return builder;
        }
        if (this.f7997Q == null) {
            String string = this.f8013l.getString(2131240647);
            TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
            a.a = 26;
            a = a;
            a.b = this.f8000T.a(2130841436, this.f7998R);
            a = a;
            a.g = string;
            a = a;
            a.j = string;
            this.f7997Q = a.a();
        }
        return builder.c(this.f7997Q);
    }

    private TitleBarButtonSpec m7922f() {
        if (this.f7993M == null) {
            TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
            a.a = 21;
            TitleBarButtonSpec.Builder builder = a;
            builder.b = this.f8000T.a(2130841449, this.f7998R);
            builder = builder;
            builder.g = this.f8013l.getString(2131231076);
            builder.j = this.f8013l.getString(2131231076);
            this.f7993M = a.a();
        }
        return this.f7993M;
    }

    private TitleBarButtonSpec m7923i() {
        if (this.f7981A == null) {
            TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
            a.a = 5;
            a = a;
            a.b = this.f8014m.b();
            a = a;
            a.g = this.f8013l.getString(2131232036);
            a = a;
            a.j = this.f8013l.getString(2131232036);
            a = a;
            a.f = "free_call_button";
            this.f7981A = a.a();
        }
        return this.f7981A;
    }

    private TitleBarButtonSpec m7924j() {
        if (this.f7982B == null) {
            TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
            a.a = 19;
            a = a;
            a.r = 2131558455;
            a = a;
            a.l = 2130907387;
            a = a;
            a.m = this.f7998R;
            a = a;
            a.j = this.f8013l.getString(2131232169);
            a = a;
            a.f = "video_call_button";
            this.f7982B = a.a();
        }
        return this.f7982B;
    }

    private TitleBarButtonSpec m7925k() {
        if (this.f7983C == null) {
            TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
            a.a = 10;
            a = a;
            a.r = 2131558456;
            a = a;
            RtcCallButtonIconProvider rtcCallButtonIconProvider = this.f8014m;
            if (rtcCallButtonIconProvider.r == null) {
                rtcCallButtonIconProvider.r = rtcCallButtonIconProvider.b.a(2130840893, rtcCallButtonIconProvider.f);
            }
            a.b = rtcCallButtonIconProvider.r;
            a = a;
            a.g = this.f8013l.getString(2131232180);
            a = a;
            a.j = this.f8013l.getString(2131232180);
            a = a;
            a.f = "video_call_button";
            this.f7983C = a.a();
        }
        return this.f7983C;
    }

    private Builder<TitleBarButtonSpec> m7921d(Builder<TitleBarButtonSpec> builder, @Nullable ThreadKey threadKey, Result result) {
        if (!(!ThreadKey.d(threadKey) || result == null || this.f8024w.a(result.f7611a) == null)) {
            if (this.f7992L == null) {
                TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
                a.b = this.f8000T.a(2130841339, this.f7998R);
                a = a;
                a.a = 20;
                a = a;
                a.g = this.f8013l.getString(2131231074);
                a = a;
                a.j = this.f8013l.getString(2131231074);
                this.f7992L = a.a();
            }
            builder.c(this.f7992L);
        }
        return builder;
    }

    private TitleBarButtonSpec m7926o() {
        if (this.f7996P == null) {
            Drawable drawable;
            RtcCallButtonIconProvider rtcCallButtonIconProvider;
            if (this.f8019r.a(ExperimentsForEphemeralModule.c, false)) {
                rtcCallButtonIconProvider = this.f8014m;
                if (rtcCallButtonIconProvider.x == null) {
                    rtcCallButtonIconProvider.x = rtcCallButtonIconProvider.b.a(2130840865, rtcCallButtonIconProvider.f, false);
                }
                drawable = rtcCallButtonIconProvider.x;
            } else {
                rtcCallButtonIconProvider = this.f8014m;
                if (rtcCallButtonIconProvider.w == null) {
                    rtcCallButtonIconProvider.w = rtcCallButtonIconProvider.b.a(2130840864, rtcCallButtonIconProvider.f, false);
                }
                drawable = rtcCallButtonIconProvider.w;
            }
            TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
            a.a = 24;
            a = a;
            a.b = drawable;
            TitleBarButtonSpec.Builder builder = a;
            builder.g = this.f8013l.getString(2131232036);
            builder = builder;
            builder.j = this.f8013l.getString(2131232036);
            this.f7996P = builder.a();
        }
        return this.f7996P;
    }

    private int m7903a(Context context) {
        return ContextUtils.c(context, 2130773227, this.f8013l.getColor(2131362241));
    }
}
