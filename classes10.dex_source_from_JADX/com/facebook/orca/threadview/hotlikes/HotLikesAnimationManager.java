package com.facebook.orca.threadview.hotlikes;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.customthreads.DefaultThreadViewTheme;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.messaging.send.client.OfflineThreadingIdGenerator;
import com.facebook.messaging.sounds.MessengerSoundUtil;
import com.facebook.messaging.threadview.hotlikes.HotLikesSpringConfig;
import com.facebook.messaging.threadview.rows.RowHotLikePreviewItem;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.AnonymousClass23;
import com.facebook.orca.threadview.messagelist.MessageListHelper;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.sounds.SoundPlayer;
import com.facebook.springs.SpringSystem;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: marker_tap */
public class HotLikesAnimationManager {
    public final MessengerSoundUtil f8181a;
    private final MonotonicClock f8182b;
    private final OfflineThreadingIdGenerator f8183c;
    private final SpringSystem f8184d;
    private final FbSharedPreferences f8185e;
    private final Provider<Boolean> f8186f;
    public final Map<String, HotLikesAnimationState> f8187g = Maps.c();
    private final Map<String, RowHotLikePreviewItem> f8188h = Maps.d();
    public MessageListHelper f8189i;
    public AnonymousClass23 f8190j;
    @Nullable
    public DefaultThreadViewTheme f8191k;
    public String f8192l;
    private SoundPlayer f8193m;

    /* compiled from: marker_tap */
    public class C12261 {
        public final /* synthetic */ HotLikesAnimationManager f8179a;

        C12261(HotLikesAnimationManager hotLikesAnimationManager) {
            this.f8179a = hotLikesAnimationManager;
        }
    }

    /* compiled from: marker_tap */
    /* synthetic */ class C12272 {
        static final /* synthetic */ int[] f8180a = new int[HotLikesSpringConfig.values().length];

        static {
            try {
                f8180a[HotLikesSpringConfig.SMALL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8180a[HotLikesSpringConfig.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f8180a[HotLikesSpringConfig.LARGE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static HotLikesAnimationManager m8087a(InjectorLike injectorLike) {
        return new HotLikesAnimationManager(MessengerSoundUtil.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), OfflineThreadingIdGenerator.a(injectorLike), SpringSystem.b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 4156));
    }

    @Inject
    public HotLikesAnimationManager(MessengerSoundUtil messengerSoundUtil, MonotonicClock monotonicClock, OfflineThreadingIdGenerator offlineThreadingIdGenerator, SpringSystem springSystem, FbSharedPreferences fbSharedPreferences, Provider<Boolean> provider) {
        this.f8181a = messengerSoundUtil;
        this.f8182b = monotonicClock;
        this.f8183c = offlineThreadingIdGenerator;
        this.f8184d = springSystem;
        this.f8185e = fbSharedPreferences;
        this.f8186f = provider;
    }

    public final void m8093a() {
        if (this.f8192l != null) {
            m8092c(this, this.f8192l);
        }
    }

    public final void m8094a(String str) {
        this.f8188h.remove(str);
    }

    public final Collection<RowHotLikePreviewItem> m8096b() {
        return this.f8188h.values();
    }

    public final boolean m8095a(View view, MotionEvent motionEvent) {
        Object obj;
        float scaledTouchSlop = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (x < (-scaledTouchSlop) || y < (-scaledTouchSlop) || x >= ((float) (view.getRight() - view.getLeft())) + scaledTouchSlop || y >= scaledTouchSlop + ((float) (view.getBottom() - view.getTop()))) {
            obj = null;
        } else {
            obj = 1;
        }
        Object obj2 = obj;
        if (motionEvent.getAction() == 0) {
            m8088a(view);
        } else if (motionEvent.getAction() == 1) {
            if (obj2 != null) {
                m8089b(view);
            } else {
                view.setPressed(false);
            }
        } else if (motionEvent.getAction() == 2) {
            if (obj2 == null) {
                if (this.f8192l != null) {
                    view.setPressed(false);
                    this.f8181a.f(0.15f);
                    m8092c(this, this.f8192l);
                }
            }
        } else if (motionEvent.getAction() == 3) {
            view.setPressed(false);
            m8092c(this, this.f8192l);
        }
        return false;
    }

    private void m8088a(View view) {
        boolean z = true;
        view.setPressed(true);
        String valueOf = String.valueOf(this.f8183c.a());
        this.f8188h.put(valueOf, new RowHotLikePreviewItem(valueOf));
        this.f8192l = valueOf;
        this.f8193m = this.f8181a.a(0.09f);
        HotLikesAnimationState hotLikesAnimationState = new HotLikesAnimationState(valueOf, this.f8182b, this.f8184d, this.f8186f);
        if (this.f8191k == null || StringUtil.a(this.f8191k.g())) {
            z = false;
        }
        hotLikesAnimationState.f8208l = z;
        hotLikesAnimationState.f8209m = new C12261(this);
        this.f8187g.put(valueOf, hotLikesAnimationState);
        if (this.f8190j != null) {
            this.f8190j.m7450a();
        }
        hotLikesAnimationState.f8207k = true;
        if (!hotLikesAnimationState.f8205i.isStarted()) {
            hotLikesAnimationState.f8205i.start();
        }
    }

    private void m8089b(View view) {
        view.setPressed(false);
        if (this.f8192l != null) {
            HotLikesSpringConfig hotLikesSpringConfig;
            HotLikesAnimationState hotLikesAnimationState = (HotLikesAnimationState) this.f8187g.get(this.f8192l);
            float c = hotLikesAnimationState.m8100c();
            if (c <= 0.37f) {
                hotLikesSpringConfig = HotLikesSpringConfig.SMALL;
            } else if (c <= 0.65f) {
                hotLikesSpringConfig = HotLikesSpringConfig.MEDIUM;
            } else {
                hotLikesSpringConfig = HotLikesSpringConfig.LARGE;
            }
            HotLikesSpringConfig hotLikesSpringConfig2 = hotLikesSpringConfig;
            String str = hotLikesSpringConfig2.stickerId;
            hotLikesAnimationState.f8203g.a((double) ((Float) hotLikesAnimationState.f8205i.getAnimatedValue()).floatValue()).c((double) hotLikesSpringConfig2.sizeVelocityIncrease).b((double) hotLikesSpringConfig2.sizeEndValue);
            hotLikesAnimationState.f8204h.c((double) hotLikesSpringConfig2.rotationVelocity);
            hotLikesAnimationState.f8207k = false;
            hotLikesAnimationState.f8206j = 1.0f;
            hotLikesAnimationState.f8205i.removeAllUpdateListeners();
            hotLikesAnimationState.f8205i.removeAllListeners();
            hotLikesAnimationState.f8205i.cancel();
            switch (C12272.f8180a[hotLikesSpringConfig2.ordinal()]) {
                case 1:
                    this.f8181a.b(0.25f);
                    break;
                case 2:
                    this.f8181a.c(0.25f);
                    m8091c();
                    break;
                case 3:
                    this.f8181a.d(0.25f);
                    m8091c();
                    break;
            }
            if (this.f8193m != null) {
                this.f8193m.a();
            }
            if (this.f8190j != null) {
                this.f8190j.m7451a(str, this.f8192l);
            }
            this.f8192l = null;
        }
    }

    private void m8091c() {
        this.f8185e.edit().putBoolean(MessagingPrefKeys.as, true).commit();
    }

    public static void m8090b(HotLikesAnimationManager hotLikesAnimationManager, String str) {
        hotLikesAnimationManager.f8188h.remove(str);
        HotLikesAnimationState hotLikesAnimationState = (HotLikesAnimationState) hotLikesAnimationManager.f8187g.remove(str);
        if (hotLikesAnimationState != null) {
            hotLikesAnimationState.f8209m = null;
        }
    }

    public static void m8092c(HotLikesAnimationManager hotLikesAnimationManager, String str) {
        m8090b(hotLikesAnimationManager, str);
        hotLikesAnimationManager.f8192l = null;
        if (hotLikesAnimationManager.f8193m != null) {
            hotLikesAnimationManager.f8193m.a();
        }
        if (hotLikesAnimationManager.f8190j != null) {
            hotLikesAnimationManager.f8190j.m7452b();
        }
    }
}
