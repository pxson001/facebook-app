package com.facebook.orca.threadview;

import android.content.res.Resources;
import android.view.View;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.FindViewUtil;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.inject.Assisted;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.presence.ThreadPresenceManager;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.rtc.fbwebrtc.abtests.ExperimentsForRtcModule;
import com.facebook.rtc.helpers.RtcCallHandler;
import com.facebook.rtc.prefs.VoipPrefKeys;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: media1 */
public class ThreadViewTooltip {
    @Inject
    public QeAccessor f8036a;
    private final RtcCallHandler f8037b;
    private final ThreadPresenceManager f8038c;
    public final FbSharedPreferences f8039d;
    public final Resources f8040e;
    public final FbFragment f8041f;
    private final BaseFbBroadcastManager f8042g;
    public final ScheduledExecutorService f8043h;
    public SelfRegistrableReceiverImpl f8044i;
    public TooltipShownType f8045j = TooltipShownType.NONE;
    public final OnDismissListener f8046k = new C12091(this);
    @Nullable
    public Tooltip f8047l;

    /* compiled from: media1 */
    class C12091 implements OnDismissListener {
        final /* synthetic */ ThreadViewTooltip f8034a;

        C12091(ThreadViewTooltip threadViewTooltip) {
            this.f8034a = threadViewTooltip;
        }

        public final boolean m7940a(PopoverWindow popoverWindow) {
            this.f8034a.f8045j = TooltipShownType.NONE;
            return true;
        }
    }

    /* compiled from: media1 */
    public class C12102 implements Runnable {
        final /* synthetic */ ThreadViewTooltip f8035a;

        public C12102(ThreadViewTooltip threadViewTooltip) {
            this.f8035a = threadViewTooltip;
        }

        public void run() {
            this.f8035a.f8044i.c();
        }
    }

    /* compiled from: media1 */
    public enum TooltipShownType {
        NONE,
        PRESENCE,
        INSTANT,
        GROUPCALL
    }

    @Inject
    public ThreadViewTooltip(RtcCallHandler rtcCallHandler, ThreadPresenceManager threadPresenceManager, FbSharedPreferences fbSharedPreferences, Resources resources, BaseFbBroadcastManager baseFbBroadcastManager, ScheduledExecutorService scheduledExecutorService, @Assisted FbFragment fbFragment) {
        this.f8037b = rtcCallHandler;
        this.f8038c = threadPresenceManager;
        this.f8039d = fbSharedPreferences;
        this.f8040e = resources;
        this.f8042g = baseFbBroadcastManager;
        this.f8043h = scheduledExecutorService;
        this.f8041f = fbFragment;
    }

    public final boolean m7943a(ThreadKey threadKey) {
        if (!this.f8038c.d(ThreadKey.a(threadKey)) || this.f8037b.d()) {
            m7942a();
        } else {
            Optional a = m7941a(2131558455);
            if (!a.isPresent()) {
                a = m7941a(2131558457);
            }
            if (a.isPresent()) {
                boolean z = false;
                int a2 = this.f8039d.a(VoipPrefKeys.h, 0);
                if (this.f8045j == TooltipShownType.NONE && a2 < 3) {
                    CharSequence string;
                    this.f8047l = new Tooltip(this.f8041f.getContext(), 2131624619);
                    int a3 = this.f8036a.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.aG, 0);
                    if (a3 == 1) {
                        string = this.f8040e.getString(2131232178);
                    } else if (a3 == 2) {
                        string = this.f8040e.getString(2131232179);
                    } else {
                        string = this.f8040e.getString(2131232177);
                    }
                    this.f8047l.b(string);
                    this.f8047l.t = 20000;
                    this.f8047l.H = this.f8046k;
                    this.f8047l.a((View) a.get());
                    this.f8045j = TooltipShownType.INSTANT;
                    this.f8043h.schedule(new C12102(this), 20000, TimeUnit.MILLISECONDS);
                    if (this.f8044i != null) {
                        this.f8044i.b();
                    }
                    this.f8039d.edit().a(VoipPrefKeys.h, a2 + 1).commit();
                    z = true;
                }
                return z;
            }
        }
        return false;
    }

    public final void m7944b(ThreadKey threadKey) {
        if (!this.f8038c.d(ThreadKey.a(threadKey)) || this.f8037b.d()) {
            m7942a();
            return;
        }
        Optional a = m7941a(2131558456);
        if (!a.isPresent()) {
            a = m7941a(2131558457);
        }
        if (a.isPresent()) {
            int a2 = this.f8039d.a(VoipPrefKeys.j, 0);
            if (this.f8045j == TooltipShownType.NONE && a2 < 3) {
                this.f8047l = new Tooltip(this.f8041f.getContext(), 2131624619);
                this.f8047l.b(this.f8040e.getString(2131232180));
                this.f8047l.t = 20000;
                this.f8047l.H = this.f8046k;
                this.f8047l.a((View) a.get());
                this.f8045j = TooltipShownType.PRESENCE;
                this.f8039d.edit().a(VoipPrefKeys.j, a2 + 1).commit();
            }
        }
    }

    public final void m7942a() {
        if (this.f8045j == TooltipShownType.INSTANT || this.f8045j == TooltipShownType.PRESENCE) {
            if (this.f8047l == null) {
                this.f8045j = TooltipShownType.NONE;
            } else {
                this.f8047l.l();
            }
            if (this.f8044i != null) {
                this.f8044i.c();
            }
        }
    }

    private Optional<View> m7941a(int i) {
        if (this.f8041f == null || this.f8041f.T == null) {
            return Absent.INSTANCE;
        }
        return FindViewUtil.a(this.f8041f.T, i);
    }
}
