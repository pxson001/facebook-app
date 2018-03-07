package com.facebook.rtc.views;

import android.content.Context;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClock;
import com.facebook.common.util.FindViewUtil;
import com.facebook.fbui.glyph.GlyphButton;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.rtc.views.RtcFloatingSelfView.SelfViewFrameChecker;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.user.model.UserKey;
import com.facebook.user.tiles.UserTileView;
import com.facebook.user.tiles.UserTileViewParams;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import org.webrtc.videoengine.ViEAndroidGLES20OneShotDrawListener;

/* compiled from: application/ogg */
public class RtcVideoChatHeadView extends RelativeLayout implements ViEAndroidGLES20OneShotDrawListener {
    private static final Class<?> f20201b = RtcVideoChatHeadView.class;
    private boolean f20202A = false;
    public boolean f20203B = false;
    public long f20204C;
    public String f20205D;
    public boolean f20206E;
    public boolean f20207F;
    public boolean f20208G = false;
    public int f20209H = 36;
    private final AwakeTimeSinceBootClock f20210I = AwakeTimeSinceBootClock.INSTANCE;
    public SelfViewFrameChecker f20211J;
    public RtcVideoChatHeadViewActionHandler f20212K;
    @Inject
    @ForUiThread
    public Executor f20213a;
    public RtcFloatingSelfView f20214c;
    public RtcFloatingPeerView f20215d;
    public View f20216e;
    public View f20217f;
    public View f20218g;
    public View f20219h;
    public View f20220i;
    public GlyphView f20221j = null;
    public UserTileView f20222k;
    public ScaleAnimation f20223l = null;
    private Point f20224m;
    public ViewType f20225n;
    private float f20226o;
    private int f20227p = 0;
    public boolean f20228q = false;
    public GlyphButton f20229r;
    public View f20230s;
    public View f20231t;
    public View f20232u;
    public GlyphButton f20233v;
    public View f20234w;
    public View f20235x;
    public View f20236y;
    public boolean f20237z = false;

    /* compiled from: application/ogg */
    public interface RtcVideoChatHeadViewActionHandler {
        void mo823c();

        void mo824d();

        void mo825e();

        void mo826f();

        void mo827g();

        void mo828h();
    }

    /* compiled from: application/ogg */
    class C23741 implements Runnable {
        final /* synthetic */ RtcVideoChatHeadView f20191a;

        C23741(RtcVideoChatHeadView rtcVideoChatHeadView) {
            this.f20191a = rtcVideoChatHeadView;
        }

        public void run() {
            boolean z = true;
            RtcFloatingSelfView rtcFloatingSelfView;
            switch (this.f20191a.f20225n) {
                case SELF:
                case OUTGOING_INSTANT:
                    if (RtcVideoChatHeadView.m19841l(this.f20191a)) {
                        rtcFloatingSelfView = this.f20191a.f20214c;
                        if (this.f20191a.f20203B) {
                            z = false;
                        }
                        rtcFloatingSelfView.m19785a(z);
                        return;
                    }
                    return;
                case PEER:
                case INCOMING_INSTANT:
                    if (RtcVideoChatHeadView.m19839j(this.f20191a)) {
                        this.f20191a.f20215d.m19777c();
                        return;
                    } else {
                        this.f20191a.f20215d.setOneShotDrawListener(this.f20191a);
                        return;
                    }
                case BOTH:
                    if (RtcVideoChatHeadView.m19839j(this.f20191a)) {
                        this.f20191a.f20215d.m19777c();
                    } else {
                        this.f20191a.f20215d.setOneShotDrawListener(this.f20191a);
                    }
                    if (RtcVideoChatHeadView.m19841l(this.f20191a)) {
                        rtcFloatingSelfView = this.f20191a.f20214c;
                        if (this.f20191a.f20203B) {
                            z = false;
                        }
                        rtcFloatingSelfView.m19785a(z);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: application/ogg */
    public class C23752 implements OnClickListener {
        final /* synthetic */ RtcVideoChatHeadView f20192a;

        public C23752(RtcVideoChatHeadView rtcVideoChatHeadView) {
            this.f20192a = rtcVideoChatHeadView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1045074162);
            if (this.f20192a.f20212K != null) {
                this.f20192a.f20212K.mo824d();
                RtcVideoChatHeadView.m19833a(this.f20192a, false, this.f20192a.f20219h);
                this.f20192a.f20208G = true;
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1117643849, a);
        }
    }

    /* compiled from: application/ogg */
    public class C23763 implements OnClickListener {
        final /* synthetic */ RtcVideoChatHeadView f20193a;

        public C23763(RtcVideoChatHeadView rtcVideoChatHeadView) {
            this.f20193a = rtcVideoChatHeadView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1558273328);
            if (this.f20193a.f20212K != null) {
                this.f20193a.f20212K.mo826f();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1342392154, a);
        }
    }

    /* compiled from: application/ogg */
    public class C23774 implements OnClickListener {
        final /* synthetic */ RtcVideoChatHeadView f20194a;

        public C23774(RtcVideoChatHeadView rtcVideoChatHeadView) {
            this.f20194a = rtcVideoChatHeadView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1902837686);
            if (this.f20194a.f20212K != null) {
                this.f20194a.f20212K.mo827g();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1630103945, a);
        }
    }

    /* compiled from: application/ogg */
    public class C23785 implements OnClickListener {
        final /* synthetic */ RtcVideoChatHeadView f20195a;

        public C23785(RtcVideoChatHeadView rtcVideoChatHeadView) {
            this.f20195a = rtcVideoChatHeadView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1547636778);
            if (this.f20195a.f20212K != null) {
                this.f20195a.f20235x.startAnimation(AnimationUtils.loadAnimation(this.f20195a.getContext(), 2130968732));
                this.f20195a.f20212K.mo828h();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1747497664, a);
        }
    }

    /* compiled from: application/ogg */
    public class C23796 implements OnClickListener {
        final /* synthetic */ RtcVideoChatHeadView f20196a;

        public C23796(RtcVideoChatHeadView rtcVideoChatHeadView) {
            this.f20196a = rtcVideoChatHeadView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1746464451);
            if (this.f20196a.f20212K != null) {
                this.f20196a.f20212K.mo823c();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 716771859, a);
        }
    }

    /* compiled from: application/ogg */
    public class C23807 implements OnClickListener {
        final /* synthetic */ RtcVideoChatHeadView f20197a;

        public C23807(RtcVideoChatHeadView rtcVideoChatHeadView) {
            this.f20197a = rtcVideoChatHeadView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1918452888);
            if (this.f20197a.f20212K != null) {
                this.f20197a.f20212K.mo825e();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1184237774, a);
        }
    }

    /* compiled from: application/ogg */
    public class C23818 implements AnimationListener {
        final /* synthetic */ RtcVideoChatHeadView f20198a;

        public C23818(RtcVideoChatHeadView rtcVideoChatHeadView) {
            this.f20198a = rtcVideoChatHeadView;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            this.f20198a.f20221j.setVisibility(8);
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* compiled from: application/ogg */
    public enum Location {
        CENTER,
        TOP_RIGHT,
        BOTTOM_RIGHT
    }

    /* compiled from: application/ogg */
    public enum ViewType {
        NONE,
        SELF,
        PEER,
        BOTH,
        INCOMING_INSTANT,
        OUTGOING_INSTANT,
        HIDDEN
    }

    public static void m19834a(Object obj, Context context) {
        ((RtcVideoChatHeadView) obj).f20213a = (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(FbInjector.get(context));
    }

    public final void m19849b() {
        ExecutorDetour.a(this.f20213a, new C23741(this), 1277664905);
    }

    public final void mo835a() {
        m19849b();
    }

    public RtcVideoChatHeadView(Context context, boolean z, long j) {
        super(context);
        this.f20203B = z;
        this.f20204C = j;
        Class cls = RtcVideoChatHeadView.class;
        m19834a((Object) this, getContext());
        LayoutInflater from = LayoutInflater.from(getContext());
        if (this.f20203B) {
            from.inflate(2130906924, this);
        } else {
            from.inflate(2130906925, this);
        }
        this.f20219h = FindViewUtil.b(this, 2131567178);
        this.f20219h.setOnClickListener(new C23752(this));
        this.f20216e = FindViewUtil.b(this, 2131567174);
        this.f20214c = (RtcFloatingSelfView) FindViewUtil.b(this, 2131567176);
        this.f20215d = (RtcFloatingPeerView) FindViewUtil.b(this, 2131567175);
        this.f20215d.setPeerId(this.f20204C);
        this.f20217f = FindViewUtil.b(this, 2131567183);
        this.f20218g = FindViewUtil.b(this, 2131567177);
        this.f20220i = FindViewUtil.b(this, 2131567179);
        if (this.f20203B) {
            this.f20221j = (GlyphView) FindViewUtil.b(this, 2131567181);
        }
        this.f20222k = (UserTileView) FindViewUtil.b(this, 2131567180);
        if (this.f20203B) {
            this.f20222k.setParams(UserTileViewParams.a(UserKey.b(Long.toString(this.f20204C))));
        }
        this.f20230s = FindViewUtil.b(this, 2131567186);
        this.f20231t = FindViewUtil.b(this, 2131567187);
        this.f20229r = (GlyphButton) FindViewUtil.b(this, 2131567160);
        this.f20232u = FindViewUtil.b(this, 2131567185);
        this.f20232u.setOnClickListener(new C23763(this));
        this.f20234w = FindViewUtil.b(this, 2131563119);
        this.f20234w.setOnClickListener(new C23774(this));
        this.f20235x = FindViewUtil.b(this, 2131567188);
        this.f20235x.setOnClickListener(new C23785(this));
        this.f20236y = FindViewUtil.b(this, 2131567184);
        this.f20229r.setOnClickListener(new C23796(this));
        this.f20233v = (GlyphButton) FindViewUtil.b(this, 2131567159);
        this.f20233v.setOnClickListener(new C23807(this));
    }

    public final void m19846a(boolean z) {
        if (z) {
            this.f20217f.setVisibility(0);
            this.f20217f.bringToFront();
            return;
        }
        this.f20217f.setVisibility(8);
    }

    public final void m19845a(String str) {
        this.f20215d.m19774a(str);
    }

    public final void m19843a(Point point, float f, boolean z, boolean z2) {
        this.f20224m = point;
        this.f20226o = f;
        m19835a(true, z, z2);
    }

    public TextureView getSelfTextureView() {
        return this.f20214c.f20131c;
    }

    public View getPeerView() {
        return this.f20215d.getPeerRenderView();
    }

    public void setPeerViewFreeze(boolean z) {
        this.f20215d.setPeerViewFreeze(z);
    }

    public final void m19844a(ViewType viewType, boolean z, boolean z2) {
        if (this.f20225n != viewType) {
            this.f20225n = viewType;
            m19835a(false, z, z2);
        }
    }

    public ViewType getViewType() {
        return this.f20225n;
    }

    public final void m19850d() {
        if (this.f20225n == ViewType.BOTH) {
            this.f20214c.mo829a();
        }
    }

    public final void m19851e() {
        if (this.f20228q) {
            LayoutParams layoutParams = (LayoutParams) this.f20216e.getLayoutParams();
            layoutParams.leftMargin = this.f20227p;
            this.f20228q = false;
            this.f20216e.setLayoutParams(layoutParams);
            this.f20214c.setAlpha(1.0f);
            this.f20215d.setPaused(false);
        }
    }

    public final void m19852f() {
        if (!this.f20228q) {
            LayoutParams layoutParams = (LayoutParams) this.f20216e.getLayoutParams();
            this.f20227p = layoutParams.leftMargin;
            layoutParams.leftMargin = -5000;
            this.f20216e.setLayoutParams(layoutParams);
            this.f20214c.setAlpha(0.0f);
            this.f20215d.setPaused(true);
            this.f20228q = true;
        }
    }

    public final int m19853g() {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int i5 = (this.f20225n == ViewType.INCOMING_INSTANT || (this.f20225n == ViewType.NONE && this.f20207F)) ? 1 : 0;
        if (this.f20225n == ViewType.SELF || this.f20225n == ViewType.BOTH || this.f20225n == ViewType.PEER || this.f20225n == ViewType.OUTGOING_INSTANT) {
            i = 1;
        } else {
            i = 0;
        }
        if (this.f20225n == ViewType.SELF || this.f20225n == ViewType.BOTH || this.f20225n == ViewType.OUTGOING_INSTANT || !(this.f20225n != ViewType.NONE || this.f20206E || this.f20207F)) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (this.f20225n == ViewType.BOTH || this.f20225n == ViewType.PEER || this.f20225n == ViewType.SELF) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (i5 != 0) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        int i6 = i5 + 1;
        if (i != 0) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        i = i6 + i5;
        if (i2 != 0) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        i5 += i;
        if (i3 != 0) {
            i4 = 1;
        }
        i5 += i4;
        if (i5 == 1 || (i5 == 3 && this.f20225n != ViewType.INCOMING_INSTANT && this.f20225n != ViewType.OUTGOING_INSTANT)) {
            return i5 + 1;
        }
        return i5;
    }

    public final void m19847a(boolean z, boolean z2) {
        int i;
        int i2;
        int i3;
        int i4 = 1;
        int i5 = 0;
        Boolean.valueOf(z);
        Boolean.valueOf(z2);
        int i6 = (this.f20225n == ViewType.INCOMING_INSTANT || (this.f20225n == ViewType.NONE && this.f20207F)) ? 1 : 0;
        if (this.f20225n == ViewType.SELF || this.f20225n == ViewType.BOTH || this.f20225n == ViewType.PEER || this.f20225n == ViewType.OUTGOING_INSTANT) {
            i = 1;
        } else {
            i = 0;
        }
        if (this.f20225n == ViewType.SELF || this.f20225n == ViewType.BOTH || this.f20225n == ViewType.OUTGOING_INSTANT || !(this.f20225n != ViewType.NONE || this.f20206E || this.f20207F)) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (!(this.f20225n == ViewType.BOTH || this.f20225n == ViewType.PEER || this.f20225n == ViewType.SELF)) {
            i4 = 0;
        }
        GlyphButton glyphButton = this.f20229r;
        if (i6 != 0) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        glyphButton.setVisibility(i3);
        if (i6 != 0) {
            if (this.f20206E) {
                this.f20229r.setImageDrawable(getResources().getDrawable(2130841339));
            } else {
                this.f20229r.setImageDrawable(getResources().getDrawable(2130840891));
            }
        }
        glyphButton = this.f20233v;
        if (this.f20225n != ViewType.HIDDEN) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        glyphButton.setVisibility(i3);
        View view = this.f20230s;
        if (i6 == 0 && i4 == 0) {
            i6 = 8;
        } else {
            i6 = 0;
        }
        view.setVisibility(i6);
        view = this.f20231t;
        if (i == 0 || i2 == 0) {
            i6 = 8;
        } else {
            i6 = 0;
        }
        view.setVisibility(i6);
        view = this.f20234w;
        if (i != 0) {
            i6 = 0;
        } else {
            i6 = 8;
        }
        view.setVisibility(i6);
        this.f20234w.setSelected(z);
        View view2 = this.f20235x;
        if (i2 != 0) {
            i6 = 0;
        } else {
            i6 = 8;
        }
        view2.setVisibility(i6);
        View view3 = this.f20232u;
        if (i4 == 0) {
            i5 = 8;
        }
        view3.setVisibility(i5);
        this.f20232u.setSelected(z2);
        if (m19853g() <= 2) {
            LayoutParams layoutParams = (LayoutParams) this.f20236y.getLayoutParams();
            i5 = m19836b(16);
            layoutParams.bottomMargin = i5;
            layoutParams.topMargin = i5;
            layoutParams.rightMargin = i5;
            layoutParams.leftMargin = i5;
            this.f20236y.setLayoutParams(layoutParams);
            return;
        }
        layoutParams = (LayoutParams) this.f20236y.getLayoutParams();
        i5 = m19836b(8);
        layoutParams.bottomMargin = i5;
        layoutParams.topMargin = i5;
        layoutParams.rightMargin = i5;
        layoutParams.leftMargin = i5;
        this.f20236y.setLayoutParams(layoutParams);
    }

    private static void m19831a(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            int indexOfChild = viewGroup.indexOfChild(view);
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if (i != indexOfChild) {
                    viewGroup.bringChildToFront(viewGroup.getChildAt(i));
                }
            }
            viewGroup.requestLayout();
        }
    }

    private void m19835a(boolean z, boolean z2, boolean z3) {
        boolean z4 = true;
        boolean z5 = false;
        if (this.f20224m != null && this.f20225n != null) {
            this.f20202A = z3;
            Location location = Location.BOTTOM_RIGHT;
            if (this.f20203B) {
                location = Location.TOP_RIGHT;
            }
            m19832a(this.f20220i, false);
            m19832a(this.f20219h, false);
            Boolean.valueOf(z);
            Boolean.valueOf(z2);
            Boolean.valueOf(z3);
            RtcFloatingSelfView rtcFloatingSelfView;
            switch (this.f20225n) {
                case SELF:
                case OUTGOING_INSTANT:
                    if (this.f20205D != null && this.f20203B) {
                        m19833a(this, true, this.f20220i);
                    }
                    this.f20214c.setVisibility(0);
                    this.f20214c.m19753a(this.f20224m, Location.CENTER, 1.4f);
                    this.f20214c.m19786b();
                    if (!m19840k()) {
                        if (z3) {
                            rtcFloatingSelfView = this.f20214c;
                            if (this.f20203B) {
                                z4 = false;
                            }
                            rtcFloatingSelfView.m19785a(z4);
                        } else {
                            this.f20214c.mo829a();
                        }
                    }
                    this.f20215d.setVisibility(4);
                    this.f20215d.m19776b();
                    return;
                case PEER:
                    this.f20215d.setVisibility(0);
                    if (!z) {
                        RtcFloatingPeerView rtcFloatingPeerView = this.f20215d;
                        if (m19839j(this)) {
                            z4 = false;
                        }
                        rtcFloatingPeerView.m19775a(z4);
                    }
                    this.f20215d.m19753a(this.f20224m, Location.CENTER, this.f20226o);
                    if (z2) {
                        this.f20215d.setOneShotDrawListener(this);
                    }
                    if (this.f20203B) {
                        this.f20214c.setVisibility(4);
                        return;
                    }
                    this.f20214c.setVisibility(0);
                    this.f20214c.mo829a();
                    this.f20214c.m19753a(getCornerSize(), location, 1.4f);
                    return;
                case INCOMING_INSTANT:
                    if (this.f20203B && !this.f20208G) {
                        m19833a(this, true, this.f20219h);
                    }
                    this.f20214c.setVisibility(4);
                    this.f20215d.setVisibility(0);
                    if (!(z && z2)) {
                        RtcFloatingPeerView rtcFloatingPeerView2 = this.f20215d;
                        if (!(m19839j(this) && z2)) {
                            z5 = true;
                        }
                        rtcFloatingPeerView2.m19775a(z5);
                    }
                    this.f20215d.m19753a(this.f20224m, Location.CENTER, this.f20226o);
                    if (z2) {
                        this.f20215d.setOneShotDrawListener(this);
                        return;
                    }
                    return;
                case BOTH:
                    this.f20215d.setVisibility(0);
                    if (this.f20203B && z2) {
                        this.f20215d.m19777c();
                    } else if (!(z && z2)) {
                        RtcFloatingPeerView rtcFloatingPeerView3 = this.f20215d;
                        boolean z6 = (m19839j(this) && z2) ? false : true;
                        rtcFloatingPeerView3.m19775a(z6);
                    }
                    this.f20215d.m19753a(this.f20224m, Location.CENTER, this.f20226o);
                    if (z2) {
                        this.f20215d.setOneShotDrawListener(this);
                    }
                    this.f20214c.setVisibility(0);
                    this.f20214c.m19753a(getCornerSize(), location, 1.4f);
                    if (this.f20203B) {
                        m19831a(this.f20215d);
                    }
                    if (!z) {
                        this.f20214c.m19786b();
                    }
                    if (!m19840k()) {
                        if (z3) {
                            rtcFloatingSelfView = this.f20214c;
                            if (this.f20203B) {
                                z4 = false;
                            }
                            rtcFloatingSelfView.m19785a(z4);
                            return;
                        } else if (this.f20203B) {
                            this.f20214c.setVisibility(4);
                            return;
                        } else {
                            this.f20214c.mo829a();
                            return;
                        }
                    }
                    return;
                case NONE:
                    this.f20215d.setVisibility(0);
                    this.f20215d.mo829a();
                    this.f20215d.m19753a(this.f20224m, Location.CENTER, this.f20226o);
                    this.f20214c.setVisibility(0);
                    if (this.f20203B) {
                        if (!(this.f20207F || this.f20206E)) {
                            this.f20214c.m19753a(this.f20224m, Location.CENTER, 1.4f);
                            this.f20214c.m19786b();
                            if (!m19840k()) {
                                boolean z7;
                                RtcFloatingSelfView rtcFloatingSelfView2 = this.f20214c;
                                if (this.f20203B) {
                                    z7 = false;
                                } else {
                                    z7 = true;
                                }
                                rtcFloatingSelfView2.m19785a(z7);
                            }
                        }
                        m19831a(this.f20214c);
                        return;
                    }
                    this.f20214c.mo829a();
                    this.f20214c.m19753a(getCornerSize(), location, 1.4f);
                    return;
                case HIDDEN:
                    this.f20215d.m19776b();
                    this.f20215d.setVisibility(4);
                    this.f20214c.setVisibility(4);
                    this.f20236y.setVisibility(8);
                    return;
                default:
                    return;
            }
        }
    }

    public static boolean m19839j(RtcVideoChatHeadView rtcVideoChatHeadView) {
        return rtcVideoChatHeadView.f20210I.now() - rtcVideoChatHeadView.f20215d.getLastRedrawTime() < 1750;
    }

    private boolean m19840k() {
        return (this.f20237z || this.f20203B) ? false : true;
    }

    public static boolean m19841l(RtcVideoChatHeadView rtcVideoChatHeadView) {
        if (rtcVideoChatHeadView.m19840k()) {
            return rtcVideoChatHeadView.f20211J != null && rtcVideoChatHeadView.f20210I.now() - rtcVideoChatHeadView.f20211J.mo821a() < 1750;
        } else {
            return rtcVideoChatHeadView.f20202A;
        }
    }

    private Point getCornerSize() {
        int b = m19836b(this.f20209H);
        if (!this.f20203B) {
            return new Point(b, b);
        }
        int i;
        if (this.f20224m.y > this.f20224m.x) {
            i = (b * 4) / 3;
        } else {
            int i2 = b;
            b = (b * 4) / 3;
            i = i2;
        }
        return new Point(b, i);
    }

    public int getRightMarginInPixels() {
        if (this.f20203B) {
            return m19836b(10);
        }
        return 0;
    }

    public int getLeftMarginInPixels() {
        return 0;
    }

    public final boolean m19854h() {
        return this.f20236y.getVisibility() == 0;
    }

    private void m19837c(final boolean z) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), (z == m19854h() ? 1 : null) != null ? 2130968734 : 2130968733);
        loadAnimation.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ RtcVideoChatHeadView f20200b;

            public void onAnimationStart(Animation animation) {
                if (z) {
                    this.f20200b.f20236y.setVisibility(0);
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                this.f20200b.f20236y.setVisibility(8);
            }
        });
        this.f20236y.startAnimation(loadAnimation);
    }

    private static void m19832a(View view, boolean z) {
        if (view.getAnimation() != null) {
            view.clearAnimation();
        }
        view.setVisibility(z ? 0 : 4);
    }

    public static void m19833a(RtcVideoChatHeadView rtcVideoChatHeadView, final boolean z, final View view) {
        Animation alphaAnimation = z ? new AlphaAnimation(0.0f, 1.0f) : new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(100);
        alphaAnimation.setAnimationListener(new AnimationListener(rtcVideoChatHeadView) {
            final /* synthetic */ RtcVideoChatHeadView f20188c;

            public void onAnimationStart(Animation animation) {
                if (z) {
                    view.setVisibility(0);
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                if (!z) {
                    view.setVisibility(4);
                }
            }
        });
        view.startAnimation(alphaAnimation);
    }

    private void m19838d(boolean z) {
        if (this.f20218g.getAnimation() != null) {
            this.f20218g.clearAnimation();
            this.f20218g.setVisibility(4);
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), 2130968729);
        loadAnimation.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ RtcVideoChatHeadView f20189a;

            {
                this.f20189a = r1;
            }

            public void onAnimationStart(Animation animation) {
                this.f20189a.f20218g.setVisibility(0);
            }

            public void onAnimationEnd(Animation animation) {
                this.f20189a.f20218g.setVisibility(4);
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (z) {
            this.f20218g.startAnimation(loadAnimation);
            return;
        }
        this.f20218g.clearAnimation();
        this.f20218g.setVisibility(4);
    }

    public final void m19848a(boolean z, boolean z2, boolean z3, boolean z4) {
        int i = 0;
        View view;
        if (this.f20203B && m19854h() != z) {
            if (this.f20236y.getAnimation() != null) {
                this.f20236y.clearAnimation();
            }
            if (!z2) {
                view = this.f20236y;
                if (!z) {
                    i = 8;
                }
                view.setVisibility(i);
                return;
            } else if (z3 && z) {
                m19837c(z);
            } else {
                m19833a(this, z, this.f20236y);
            }
        } else if (m19854h() == z) {
            if (!z2) {
                view = this.f20236y;
                if (!z) {
                    i = 8;
                }
                view.setVisibility(i);
                return;
            } else if (z3 && z) {
                m19837c(z);
            }
        }
        if (z && z4 && this.f20218g.getVisibility() != 0) {
            m19838d(z4);
        } else if (!z4) {
            m19838d(false);
        }
    }

    private int m19836b(int i) {
        return ((int) getResources().getDisplayMetrics().density) * i;
    }
}
