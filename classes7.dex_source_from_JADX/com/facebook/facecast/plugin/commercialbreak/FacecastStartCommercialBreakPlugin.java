package com.facebook.facecast.plugin.commercialbreak;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.facecast.abtest.FacecastBroadcasterCommercialBreakConfig;
import com.facebook.facecast.plugin.FacecastBasePlugin;
import com.facebook.facecast.plugin.commercialbreak.CommercialBreakBroadcastStateManager.CommercialBreakBroadcastState;
import com.facebook.facecast.plugin.commercialbreak.CommercialBreakBroadcastStateManager.CommercialBreakBroadcastStateChangeListener;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: borderBottomColor */
public class FacecastStartCommercialBreakPlugin extends FacecastBasePlugin implements CommercialBreakBroadcastStateChangeListener {
    private static final PrefKey f18621e = ((PrefKey) SharedPrefKeys.h.a("commercial_break_employee_only_tooltip"));
    @Inject
    FacecastBroadcasterCommercialBreakConfig f18622c;
    @Inject
    TipSeenTracker f18623d;
    private final View f18624f;
    private final Tooltip f18625g;
    public final GlyphView f18626h;
    public final BetterTextView f18627i;
    public final View f18628j;
    private final StartCommercialBreakAnimationTimer f18629k;
    @Nullable
    public FacecastStartCommercialBreakListener f18630l;
    @Nullable
    private Tooltip f18631m;
    private boolean f18632n;

    /* compiled from: borderBottomColor */
    public interface FacecastStartCommercialBreakListener {
        void mo1424a();
    }

    /* compiled from: borderBottomColor */
    class C16051 implements OnClickListener {
        final /* synthetic */ FacecastStartCommercialBreakPlugin f18616a;

        C16051(FacecastStartCommercialBreakPlugin facecastStartCommercialBreakPlugin) {
            this.f18616a = facecastStartCommercialBreakPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1403641909);
            if (this.f18616a.f18630l != null) {
                this.f18616a.f18630l.mo1424a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -682370862, a);
        }
    }

    /* compiled from: borderBottomColor */
    public enum CommercialBreakEligibility {
        ELIGIBLE,
        IN_COMMERCIAL_BREAK,
        INSUFFICIENT_BEGINNING_LIVE_TIME,
        TOO_CLOSE_TO_PREVIOUS_COMMERCIAL_BREAK
    }

    /* compiled from: borderBottomColor */
    class StartCommercialBreakAnimationTimer extends CountDownTimer {
        boolean f18619a;
        final /* synthetic */ FacecastStartCommercialBreakPlugin f18620b;

        public StartCommercialBreakAnimationTimer(FacecastStartCommercialBreakPlugin facecastStartCommercialBreakPlugin) {
            this.f18620b = facecastStartCommercialBreakPlugin;
            super(5000, 80);
            this.f18619a = true;
        }

        public void onTick(long j) {
            if (this.f18619a) {
                this.f18620b.f18626h.animate().rotation(5.0f).setDuration(80);
                this.f18619a = false;
                return;
            }
            this.f18620b.f18626h.animate().rotation(-5.0f).setDuration(80);
            this.f18619a = true;
        }

        public void onFinish() {
            this.f18620b.f18626h.animate().rotation(0.0f).setDuration(80);
            this.f18620b.f18626h.setGlyphColor(this.f18620b.getResources().getColor(2131362106));
            this.f18620b.f18627i.setTextColor(this.f18620b.getResources().getColor(2131362106));
            this.f18620b.f18628j.setVisibility(0);
        }
    }

    private static <T extends View> void m22216a(Class<T> cls, T t) {
        m22217a((Object) t, t.getContext());
    }

    private static void m22217a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FacecastStartCommercialBreakPlugin) obj).m22215a(FacecastBroadcasterCommercialBreakConfig.m3058a(fbInjector), TipSeenTracker.b(fbInjector));
    }

    private void m22215a(FacecastBroadcasterCommercialBreakConfig facecastBroadcasterCommercialBreakConfig, TipSeenTracker tipSeenTracker) {
        this.f18622c = facecastBroadcasterCommercialBreakConfig;
        this.f18623d = tipSeenTracker;
    }

    public FacecastStartCommercialBreakPlugin(Context context) {
        this(context, null);
    }

    public FacecastStartCommercialBreakPlugin(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FacecastStartCommercialBreakPlugin(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22216a(FacecastStartCommercialBreakPlugin.class, (View) this);
        setContentView(2130904229);
        this.f18624f = a(2131561707);
        this.f18624f.setOnClickListener(new C16051(this));
        this.f18626h = (GlyphView) a(2131561612);
        this.f18627i = (BetterTextView) a(2131561708);
        this.f18628j = a(2131561709);
        this.f18625g = new Tooltip(context, 2);
        this.f18625g.c(this.f18626h);
        this.f18629k = new StartCommercialBreakAnimationTimer(this);
        if (this.f18622c.f2805g) {
            this.f18631m = new Tooltip(context, 2);
            this.f18631m.c(this.f18626h);
            this.f18631m.a("[FB-only]");
            this.f18631m.b("Tap this icon and help us test Ad Break! Please leave feedback in the Live Feedback group.");
            this.f18631m.t = 10000;
            this.f18623d.b = 3;
            this.f18623d.a(f18621e);
        }
    }

    public final void m22228a(FacecastStartCommercialBreakListener facecastStartCommercialBreakListener) {
        this.f18624f.setVisibility(0);
        this.f18630l = facecastStartCommercialBreakListener;
    }

    public final void m22227a(CommercialBreakEligibility commercialBreakEligibility, int i, int i2, long j, long j2) {
        CharSequence quantityString;
        this.f18625g.a(getResources().getString(2131238260));
        int ceil;
        switch (commercialBreakEligibility) {
            case INSUFFICIENT_BEGINNING_LIVE_TIME:
                ceil = (int) Math.ceil(((double) i) / 60.0d);
                quantityString = getResources().getQuantityString(2131689707, ceil, new Object[]{Integer.valueOf(ceil)});
                break;
            default:
                ceil = (int) Math.ceil(((double) (((j2 / 1000) + ((long) i2)) - (j / 1000))) / 60.0d);
                quantityString = getResources().getQuantityString(2131689708, ceil, new Object[]{Integer.valueOf(ceil)});
                break;
        }
        this.f18625g.b(quantityString);
        this.f18625g.b(getResources().getDrawable(2130838161));
        this.f18625g.d();
    }

    public final void mo1386a(CommercialBreakBroadcastState commercialBreakBroadcastState, CommercialBreakBroadcastState commercialBreakBroadcastState2) {
        switch (commercialBreakBroadcastState2) {
            case COMMERCIAL_BREAK_BROADCAST_PROMPT:
            case COMMERCIAL_BREAK_BROADCAST_ELIGIBLE:
                m22224j();
                break;
        }
        switch (commercialBreakBroadcastState) {
            case COMMERCIAL_BREAK_BROADCAST_ELIGIBLE:
                m22221g();
                if (commercialBreakBroadcastState2 == CommercialBreakBroadcastState.COMMERCIAL_BREAK_BROADCAST_UNINITIALIZED || commercialBreakBroadcastState2 == CommercialBreakBroadcastState.COMMERCIAL_BREAK_BROADCAST_FINISH) {
                    m22222h();
                    m22225k();
                    return;
                }
                return;
            case COMMERCIAL_BREAK_BROADCAST_PLAYING:
                m22223i();
                return;
            case COMMERCIAL_BREAK_BROADCAST_FINISH:
                m22224j();
                return;
            default:
                return;
        }
    }

    private void m22221g() {
        this.f18626h.setGlyphColor(getResources().getColor(2131362106));
        this.f18627i.setTextColor(getResources().getColor(2131362106));
        this.f18628j.setVisibility(0);
    }

    private void m22222h() {
        this.f18626h.setGlyphColor(getResources().getColor(2131362084));
        this.f18627i.setTextColor(getResources().getColor(2131362084));
        this.f18629k.start();
    }

    private void m22223i() {
        this.f18626h.setGlyphColor(getResources().getColor(2131362084));
        this.f18627i.setTextColor(getResources().getColor(2131362106));
    }

    private void m22224j() {
        this.f18626h.setGlyphColor(getResources().getColor(2131362104));
        this.f18627i.setTextColor(getResources().getColor(2131362104));
        this.f18628j.setVisibility(8);
        this.f18629k.cancel();
        this.f18626h.setRotation(0.0f);
    }

    private void m22225k() {
        if (this.f18631m != null && !this.f18632n && this.f18623d.c()) {
            this.f18631m.d();
            this.f18632n = true;
            this.f18623d.a();
        }
    }
}
