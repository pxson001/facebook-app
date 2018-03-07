package com.facebook.messaging.emoji;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.gridlayoututils.GridSizingCalculator;
import com.facebook.common.gridlayoututils.GridSizingCalculator.Sizes;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.emoji.KeyRepeaterTouchListener.Listener;
import com.facebook.messaging.tabbedpager.TabbedPager;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.emoji.Emojis;
import com.facebook.ui.emoji.model.Emoji;
import com.facebook.ui.emoji.model.EmojiSet;
import com.facebook.ui.emoji.model.EmojiSet.Type;
import com.facebook.ultralight.UltralightRuntime;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mangle_request_no_body */
public class EmojiKeyboardView extends TabbedPager {
    @Inject
    AnalyticsTagger f10922a;
    @Inject
    EmojiPageAdapterProvider f10923b;
    @Inject
    Emojis f10924c;
    @Inject
    FbSharedPreferences f10925d;
    @Inject
    KeyRepeaterTouchListener f10926e;
    @Inject
    Lazy<GlobalEmojiSkinToneHelper> f10927f;
    @Inject
    MessagingEmojiGatingUtil f10928g;
    @Inject
    @com.facebook.ultralight.Lazy
    private Lazy<BlueServiceOperationFactory> f10929h = UltralightRuntime.b;
    private Sizes f10930i;
    private int f10931j;
    @Nullable
    private EmojiPageAdapter f10932k;
    public EmojiPickerListener f10933l;

    /* compiled from: mangle_request_no_body */
    class C12021 implements Listener {
        final /* synthetic */ EmojiKeyboardView f10920a;

        C12021(EmojiKeyboardView emojiKeyboardView) {
            this.f10920a = emojiKeyboardView;
        }

        public final void mo424a() {
            EmojiKeyboardView.m11349j(this.f10920a);
        }
    }

    /* compiled from: mangle_request_no_body */
    public class C12032 {
        final /* synthetic */ EmojiKeyboardView f10921a;

        C12032(EmojiKeyboardView emojiKeyboardView) {
            this.f10921a = emojiKeyboardView;
        }

        public final void m11332a(Emoji emoji) {
            this.f10921a.m11340a(emoji);
        }

        public final void m11331a() {
            this.f10921a.m11351c();
        }
    }

    /* compiled from: mangle_request_no_body */
    public interface EmojiPickerListener {
        void m11333a();

        void m11334a(Emoji emoji);
    }

    private static <T extends View> void m11341a(Class<T> cls, T t) {
        m11342a((Object) t, t.getContext());
    }

    private static void m11342a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EmojiKeyboardView) obj).m11337a(AnalyticsTagger.a(injectorLike), (EmojiPageAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EmojiPageAdapterProvider.class), Emojis.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), KeyRepeaterTouchListener.m11385a(injectorLike), IdBasedLazy.a(injectorLike, 7831), MessagingEmojiGatingUtil.m11390b(injectorLike), IdBasedLazy.a(injectorLike, 1144));
    }

    private void m11337a(AnalyticsTagger analyticsTagger, EmojiPageAdapterProvider emojiPageAdapterProvider, Emojis emojis, FbSharedPreferences fbSharedPreferences, KeyRepeaterTouchListener keyRepeaterTouchListener, Lazy<GlobalEmojiSkinToneHelper> lazy, MessagingEmojiGatingUtil messagingEmojiGatingUtil, Lazy<BlueServiceOperationFactory> lazy2) {
        this.f10922a = analyticsTagger;
        this.f10923b = emojiPageAdapterProvider;
        this.f10924c = emojis;
        this.f10925d = fbSharedPreferences;
        this.f10926e = keyRepeaterTouchListener;
        this.f10927f = lazy;
        this.f10928g = messagingEmojiGatingUtil;
        this.f10929h = lazy2;
    }

    public static EmojiKeyboardView m11335a(Context context) {
        return new EmojiKeyboardView(ContextUtils.a(context, 2130772797, 2131624631));
    }

    public EmojiKeyboardView(Context context) {
        super(context);
        m11344e();
    }

    public EmojiKeyboardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11344e();
    }

    private void m11344e() {
        m11341a(EmojiKeyboardView.class, (View) this);
        if (getBackground() == null) {
            setBackgroundDrawable((Drawable) ContextUtils.d(getContext(), 2130772798).orNull());
        }
        this.f10926e.f10978c = new C12021(this);
        setShowEndTabButton(true);
        setEndTabButtonOnTouchListener(this.f10926e);
        setEndTabButtonContentDescription(getContext().getString(2131230987));
        this.f10922a.a(this, "emoji_popup", getClass());
    }

    public void setEmojiPickerListener(EmojiPickerListener emojiPickerListener) {
        this.f10933l = emojiPickerListener;
    }

    public void setBackspaceVisible(boolean z) {
        setShowEndTabButton(z);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f10932k != null) {
            Object obj;
            EmojiPageAdapter emojiPageAdapter = this.f10932k;
            if (!emojiPageAdapter.f10961e.isEmpty()) {
                for (EmojiGridViewAdapter d : emojiPageAdapter.f10961e) {
                    if (d.m11323d()) {
                        obj = 1;
                        break;
                    }
                }
            }
            if (emojiPageAdapter.f10963g != null) {
                RecentEmojiView recentEmojiView = emojiPageAdapter.f10963g;
                Object obj2 = (recentEmojiView.f10997m == null || !recentEmojiView.f10997m.m11323d()) ? null : 1;
                if (obj2 != null) {
                    int i = 1;
                    if (obj != null) {
                        return true;
                    }
                }
            }
            obj = null;
            if (obj != null) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (size > 0 && size2 > 0) {
            boolean z = !m11345f();
            Resources resources = getResources();
            this.f10930i = new GridSizingCalculator(resources, new EmojiGridSizingParams()).a(size, size2 - resources.getDimensionPixelSize(2131427864), false);
            if (z && !this.n) {
                m11346g();
            }
        }
        super.onMeasure(i, i2);
    }

    private boolean m11345f() {
        return this.f10930i != null;
    }

    private void m11346g() {
        TracerDetour.a("loadAndSetEmojisForBackside", 861609488);
        try {
            a();
            this.f10932k = this.f10923b.m11379a(this.f10930i);
            this.f10932k.m11374a(new C12032(this));
            setAdapter(this.f10932k);
            setItems(m11348i());
        } finally {
            TracerDetour.a(2092321646);
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (m11345f() && m11347h()) {
            a(this.f10925d.a(EmojiPrefKeys.c, null));
        }
    }

    private boolean m11347h() {
        return this.f10932k != null && this.f10932k.f10964h == null && this.f10925d.a(EmojiPrefKeys.c);
    }

    private List<EmojiSet> m11348i() {
        List a;
        if (this.f10928g.m11392a()) {
            this.f10931j = ((GlobalEmojiSkinToneHelper) this.f10927f.get()).m11383a();
            a = this.f10924c.a(this.f10931j);
        } else {
            a = this.f10924c.f.a();
        }
        return m11336a(a);
    }

    private List<EmojiSet> m11336a(List<EmojiSet> list) {
        if (list.isEmpty() || ((EmojiSet) list.get(0)).d != Type.RECENTLY_USED || this.f10928g.m11396e()) {
            return list;
        }
        return list.subList(1, list.size() - 1);
    }

    private void m11340a(Emoji emoji) {
        performHapticFeedback(3);
        if (this.f10933l != null) {
            this.f10933l.m11334a(emoji);
        }
        if (this.f10928g.m11396e()) {
            m11343b(emoji);
        }
    }

    public static void m11349j(EmojiKeyboardView emojiKeyboardView) {
        if (emojiKeyboardView.f10933l != null) {
            emojiKeyboardView.f10933l.m11333a();
        }
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 994675533);
        if (!(this.f10932k == null || StringUtil.a(this.f10932k.f10964h))) {
            this.f10925d.edit().a(EmojiPrefKeys.c, this.f10932k.f10964h).commit();
        }
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1139330429, a);
    }

    final void m11351c() {
        if (m11350k()) {
            m11346g();
        }
    }

    private boolean m11350k() {
        return m11345f() && this.f10928g.m11392a() && this.f10931j != ((GlobalEmojiSkinToneHelper) this.f10927f.get()).m11383a();
    }

    private void m11343b(Emoji emoji) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("emoji", emoji);
        BlueServiceOperationFactoryDetour.a((DefaultBlueServiceOperationFactory) this.f10929h.get(), "update_recent_emoji", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(EmojiKeyboardView.class), 2077489142).a();
    }

    public final void m11352d() {
        if (this.f10932k != null) {
            EmojiPageAdapter emojiPageAdapter = this.f10932k;
            for (EmojiGridViewAdapter emojiGridViewAdapter : emojiPageAdapter.f10961e) {
                if (emojiGridViewAdapter.m11323d()) {
                    emojiGridViewAdapter.m11324e();
                }
            }
            if (emojiPageAdapter.f10963g != null) {
                RecentEmojiView recentEmojiView = emojiPageAdapter.f10963g;
                if (recentEmojiView.f10997m != null && recentEmojiView.f10997m.m11323d()) {
                    recentEmojiView.f10997m.m11324e();
                }
            }
        }
    }
}
