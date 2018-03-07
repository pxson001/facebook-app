package com.facebook.feedplugins.feedbackreactions.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.R;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.feed.widget.DownstateType;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.feedback.reactions.ui.FeedbackFooterMode;
import com.facebook.feedback.reactions.ui.FeedbackReactionsController;
import com.facebook.feedback.reactions.ui.ReactionMutateListener;
import com.facebook.feedback.reactions.ui.ReactionsFooterSelectionView;
import com.facebook.feedback.reactions.ui.ReactionsLongPressTouchListener.LongPressListener;
import com.facebook.feedback.reactions.ui.ReactionsLongPressTouchListenerProvider;
import com.facebook.feedback.reactions.ui.logging.ReactionsFooterInteractionLogger;
import com.facebook.feedback.reactions.ui.overlay.ReactionsDockOverlay;
import com.facebook.feedback.reactions.ui.overlay.ReactionsDockOverlay.DockTheme;
import com.facebook.feedback.reactions.ui.overlay.ReactionsDockOverlay.ReactionsDockSupport;
import com.facebook.feedplugins.base.footer.ui.Footer;
import com.facebook.feedplugins.base.footer.ui.Footer.ButtonClickedListener;
import com.facebook.feedplugins.base.footer.ui.Footer.DividerStyle;
import com.facebook.feedplugins.base.footer.ui.Footer.FooterButtonId;
import com.facebook.feedplugins.base.footer.ui.FooterDividerPainter;
import com.facebook.feedplugins.base.footer.ui.FooterLikeButton;
import com.facebook.feedplugins.base.footer.ui.ReactionsAnchorFooter;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.ViewType;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.sounds.FBSoundUtil;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringListener;
import com.facebook.springs.SpringUtil;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.springbutton.TouchSpring;
import com.google.common.collect.ImmutableList;
import java.util.EnumMap;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: gk_enable_thread_presence_mobile */
public class ReactionsFooterView extends CustomFrameLayout implements LongPressListener, ReactionsDockSupport, Footer, SpringListener {
    public static final ViewType f22290h = new C09051();
    @Inject
    FeedbackReactionsController f22291a;
    @Inject
    FooterDividerPainter f22292b;
    @Inject
    ReactionsDockOverlay f22293c;
    @Inject
    Lazy<FBSoundUtil> f22294d;
    @Inject
    QuickPerformanceLogger f22295e;
    @Inject
    ReactionsFooterLayoutResolver f22296f;
    @Inject
    ReactionsLongPressTouchListenerProvider f22297g;
    private final ReactionsAnchorFooter f22298i;
    private final ReactionsFooterSelectionView f22299j;
    public final FooterLikeButton f22300k;
    public FeedbackFooterMode f22301l;
    public ReactionMutateListener f22302m;
    private Spring f22303n;
    public ReactionsFooterInteractionLogger f22304o;
    private RequestLayoutRunnable f22305p;
    public DockTheme f22306q;
    public ImmutableList<FeedbackReaction> f22307r;
    public boolean f22308s;

    /* compiled from: gk_enable_thread_presence_mobile */
    final class C09051 extends ViewType {
        C09051() {
        }

        public final View mo1995a(Context context) {
            return new ReactionsFooterView(context);
        }
    }

    /* compiled from: gk_enable_thread_presence_mobile */
    public interface ReactionsFooterLayoutResolver {
        int mo3267a();

        int mo3268b();

        int mo3269c();
    }

    private static <T extends View> void m30223a(Class<T> cls, T t) {
        m30224a((Object) t, t.getContext());
    }

    private static void m30224a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ReactionsFooterView) obj).m30222a(FeedbackReactionsController.m29084a(injectorLike), FooterDividerPainter.m30246b(injectorLike), ReactionsDockOverlay.m29052a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 10994), QuickPerformanceLoggerMethodAutoProvider.m2859a(injectorLike), new DefaultReactionsFooterLayoutResolver(), (ReactionsLongPressTouchListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionsLongPressTouchListenerProvider.class));
    }

    private void m30222a(FeedbackReactionsController feedbackReactionsController, FooterDividerPainter footerDividerPainter, ReactionsDockOverlay reactionsDockOverlay, Lazy<FBSoundUtil> lazy, QuickPerformanceLogger quickPerformanceLogger, ReactionsFooterLayoutResolver reactionsFooterLayoutResolver, ReactionsLongPressTouchListenerProvider reactionsLongPressTouchListenerProvider) {
        this.f22291a = feedbackReactionsController;
        this.f22292b = footerDividerPainter;
        this.f22293c = reactionsDockOverlay;
        this.f22294d = lazy;
        this.f22295e = quickPerformanceLogger;
        this.f22296f = reactionsFooterLayoutResolver;
        this.f22297g = reactionsLongPressTouchListenerProvider;
    }

    public final void mo3157a(boolean z) {
        m30235a(z ? FeedbackFooterMode.REACTIONS : FeedbackFooterMode.DEFAULT, true);
    }

    public final void mo3158b(boolean z) {
        this.f22299j.m30280a(z);
    }

    public ReactionsFooterInteractionLogger getInteractionLogger() {
        return this.f22304o;
    }

    public ImmutableList<FeedbackReaction> getSupportedReactions() {
        if (this.f22307r != null) {
            return this.f22307r;
        }
        return this.f22291a.m29092c();
    }

    public ReactionsFooterView(Context context) {
        this(context, null);
    }

    public ReactionsFooterView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22301l = FeedbackFooterMode.DEFAULT;
        this.f22306q = DockTheme.LIGHT;
        m30223a(ReactionsFooterView.class, (View) this);
        m30228c(m30225a(context, attributeSet));
        setContentView(this.f22296f.mo3267a());
        this.f22298i = (ReactionsAnchorFooter) m16956c(this.f22296f.mo3268b());
        this.f22299j = (ReactionsFooterSelectionView) m16956c(this.f22296f.mo3269c());
        this.f22300k = (FooterLikeButton) this.f22298i.mo3250a(FooterButtonId.LIKE);
        this.f22300k.setOnTouchListener(this.f22297g.m30254a(this));
    }

    private void m30228c(boolean z) {
        if (z || this.f22296f == null || this.f22296f.mo3267a() == 0) {
            this.f22296f = new DefaultReactionsFooterLayoutResolver();
        }
    }

    public final void m30235a(FeedbackFooterMode feedbackFooterMode, boolean z) {
        switch (3.a[feedbackFooterMode.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                if (!z) {
                    this.f22298i.setFooterVisibility(0);
                    this.f22299j.setVisibility(8);
                    m30226b();
                } else if (this.f22303n != null) {
                    this.f22303n.m7818b(0.0d);
                }
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                    break;
                }
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                this.f22299j.m30280a(false);
                if (!z) {
                    this.f22298i.setFooterVisibility(8);
                    this.f22299j.setVisibility(0);
                    m30226b();
                } else if (this.f22303n != null) {
                    this.f22303n.m7818b(1.0d);
                }
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
        }
        this.f22301l = feedbackFooterMode;
    }

    public FeedbackFooterMode getMode() {
        return this.f22301l;
    }

    public void setButtonContainerBackground(Drawable drawable) {
        this.f22298i.setButtonContainerBackground(drawable);
        this.f22299j.f22348c = drawable;
    }

    public void setDownstateType(DownstateType downstateType) {
        this.f22298i.setDownstateType(downstateType);
    }

    public void setButtonContainerHeight(int i) {
        this.f22298i.setButtonContainerHeight(i);
    }

    public void setIsLiked(boolean z) {
    }

    public void setHasCachedComments(boolean z) {
        this.f22298i.setHasCachedComments(z);
    }

    public void setButtons(Set<FooterButtonId> set) {
        this.f22298i.setButtons(set);
    }

    public void setSprings(EnumMap<FooterButtonId, TouchSpring> enumMap) {
        this.f22298i.setSprings(enumMap);
    }

    public final void mo3251a() {
        this.f22298i.mo3251a();
        if (this.f22303n != null) {
            this.f22303n.m7831m();
        }
        this.f22303n = null;
    }

    public final View mo3250a(FooterButtonId footerButtonId) {
        return this.f22298i.mo3250a(footerButtonId);
    }

    public void setOnButtonClickedListener(ButtonClickedListener buttonClickedListener) {
        this.f22298i.setOnButtonClickedListener(buttonClickedListener);
    }

    public void setTopDividerStyle(DividerStyle dividerStyle) {
        this.f22292b.f22312d = dividerStyle;
    }

    public void setBottomDividerStyle(DividerStyle dividerStyle) {
        this.f22292b.f22313e = dividerStyle;
    }

    public void setButtonWeights(float[] fArr) {
        this.f22298i.setButtonWeights(fArr);
    }

    public void setShowIcons(boolean z) {
        this.f22298i.setShowIcons(z);
    }

    public void setEnabled(boolean z) {
        this.f22298i.setEnabled(z);
    }

    public void setSupportedReactions(ImmutableList<FeedbackReaction> immutableList) {
        this.f22307r = immutableList;
    }

    public void setReaction(FeedbackReaction feedbackReaction) {
        this.f22300k.setReaction(feedbackReaction);
    }

    public void setReactionMutateListener(ReactionMutateListener reactionMutateListener) {
        this.f22302m = reactionMutateListener;
    }

    public void setReactionsLogger(ReactionsFooterInteractionLogger reactionsFooterInteractionLogger) {
        this.f22304o = reactionsFooterInteractionLogger;
    }

    public void setDockTheme(DockTheme dockTheme) {
        this.f22306q = dockTheme;
    }

    public final void mo3156a(FeedbackReaction feedbackReaction) {
        if (this.f22302m != null && feedbackReaction != FeedbackReaction.f21476c) {
            ((FBSoundUtil) this.f22294d.get()).b("reactions_like_up");
            this.f22302m.mo3277a(this, feedbackReaction, m30229e());
            setReaction(feedbackReaction);
            if (this.f22300k.getHandler() != null) {
                HandlerDetour.a(this.f22300k.getHandler(), getRequestLayoutRunnable(), 2084986368);
            }
        }
    }

    private RequestLayoutRunnable getRequestLayoutRunnable() {
        if (this.f22305p == null) {
            this.f22305p = new RequestLayoutRunnable(this);
        }
        return this.f22305p;
    }

    public DockTheme getDockTheme() {
        return this.f22306q;
    }

    public void setFadeStateSpring(Spring spring) {
        this.f22303n = spring;
        spring.m7815a((SpringListener) this);
        m30230e(spring);
    }

    public final void mo1160a(Spring spring) {
        m30230e(spring);
    }

    public final void mo1161b(Spring spring) {
    }

    public final void mo1162c(Spring spring) {
    }

    public final void mo1163d(Spring spring) {
        this.f22298i.setFooterVisibility(0);
        this.f22299j.setVisibility(0);
    }

    private void m30230e(Spring spring) {
        this.f22298i.setFooterAlpha((50.0f - (((float) SpringUtil.m11941a(spring.m7821d(), 0.0d, 0.5d)) * 100.0f)) / 50.0f);
        ViewCompat.m10954c(this.f22299j, ((((float) SpringUtil.m11941a(spring.m7821d(), 0.5d, 1.0d)) * 100.0f) - 50.0f) / 50.0f);
        if (spring.m7821d() >= 0.5d) {
            this.f22298i.setFooterVisibility(8);
            this.f22299j.setVisibility(0);
            return;
        }
        this.f22298i.setFooterVisibility(0);
        this.f22299j.setVisibility(8);
    }

    private void m30226b() {
        this.f22298i.setFooterAlpha(1.0f);
        ViewCompat.m10954c(this.f22299j, 1.0f);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return m30227b(motionEvent);
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.f22292b.m30247a(this, canvas);
    }

    private DisposableFutureCallback m30229e() {
        return new 2(this);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -498263698);
        boolean b = m30227b(motionEvent);
        Logger.a(2, EntryType.UI_INPUT_END, 2033463071, a);
        return b;
    }

    private boolean m30227b(MotionEvent motionEvent) {
        if (this.f22301l != FeedbackFooterMode.REACTIONS) {
            if (this.f22308s) {
                motionEvent.offsetLocation(0.0f, (0.5f * ((float) getHeight())) - motionEvent.getY());
            }
            return false;
        }
        this.f22293c.m29064a((ReactionsDockSupport) this);
        this.f22293c.m29063a(this.f22298i.getReactionsDockAnchor(), motionEvent);
        return true;
    }

    public final void mo3252a(MotionEvent motionEvent) {
        this.f22295e.mo462b(8519683);
        this.f22295e.mo462b(8519684);
        m30235a(FeedbackFooterMode.REACTIONS, true);
        m30227b(motionEvent);
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m30235a(FeedbackFooterMode.DEFAULT, false);
        this.f22293c.m29062a();
    }

    private static boolean m30225a(Context context, @Nullable AttributeSet attributeSet) {
        boolean z = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ReactionsFooterView);
            if (obtainStyledAttributes != null) {
                z = obtainStyledAttributes.getBoolean(0, false);
            }
            obtainStyledAttributes.recycle();
        }
        return z;
    }

    public void setLargerTapTargetEnabled(boolean z) {
        this.f22308s = z;
    }
}
