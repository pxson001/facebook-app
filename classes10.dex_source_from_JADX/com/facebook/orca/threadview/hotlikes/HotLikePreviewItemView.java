package com.facebook.orca.threadview.hotlikes;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.messaging.customthreads.DefaultThreadViewTheme;
import com.facebook.messaging.customthreads.ThreadViewTheme.Listener;
import com.facebook.messaging.customthreads.ThreadViewTheme.SenderType;
import com.facebook.stickers.ui.StickerDraweeView;
import com.facebook.ui.emoji.EmojiUtil;
import com.facebook.ui.emoji.model.BigEmojis;
import com.facebook.ui.emoji.model.Emoji;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: markup */
public class HotLikePreviewItemView extends CustomLinearLayout {
    private static final CallerContext f8170d = CallerContext.a(HotLikePreviewItemView.class, "sticker_thread_view");
    @Inject
    public Lazy<BigEmojis> f8171a;
    @Inject
    public Lazy<EmojiUtil> f8172b;
    @Inject
    public Resources f8173c;
    public final HotLikesViewAnimationHelper f8174e;
    private final StickerDraweeView f8175f;
    public final Listener f8176g = new C12251(this);
    @Nullable
    public DefaultThreadViewTheme f8177h;
    @Nullable
    private String f8178i;

    /* compiled from: markup */
    class C12251 implements Listener {
        final /* synthetic */ HotLikePreviewItemView f8169a;

        C12251(HotLikePreviewItemView hotLikePreviewItemView) {
            this.f8169a = hotLikePreviewItemView;
        }

        public final void m8083a() {
            HotLikePreviewItemView.m8086b(this.f8169a);
        }
    }

    public static void m8085a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        HotLikePreviewItemView hotLikePreviewItemView = (HotLikePreviewItemView) obj;
        Lazy a = IdBasedLazy.a(fbInjector, 11501);
        Lazy a2 = IdBasedLazy.a(fbInjector, 3556);
        Resources a3 = ResourcesMethodAutoProvider.a(fbInjector);
        hotLikePreviewItemView.f8171a = a;
        hotLikePreviewItemView.f8172b = a2;
        hotLikePreviewItemView.f8173c = a3;
    }

    public HotLikePreviewItemView(Context context) {
        super(context);
        Class cls = HotLikePreviewItemView.class;
        m8085a(this, getContext());
        int e = ContextUtils.e(context, 2130773133, 0);
        setOrientation(1);
        setPadding(0, e, 0, 0);
        setContentView(2130905727);
        ((ViewGroup) a(2131564429)).setClipChildren(false);
        this.f8175f = (StickerDraweeView) a(2131564935);
        this.f8178i = this.f8177h != null ? this.f8177h.g() : null;
        m8084a();
        this.f8174e = new HotLikesViewAnimationHelper(this.f8173c, this.f8175f);
    }

    private void m8084a() {
        Emoji a;
        if (this.f8178i != null) {
            a = ((EmojiUtil) this.f8172b.get()).a(this.f8178i);
        } else {
            a = null;
        }
        if (a != null) {
            this.f8175f.setDrawableResourceId(((BigEmojis) this.f8171a.get()).a());
            return;
        }
        this.f8175f.a("369239383222810", 0, f8170d, null);
    }

    public static void m8086b(HotLikePreviewItemView hotLikePreviewItemView) {
        int i;
        CharSequence g = hotLikePreviewItemView.f8177h != null ? hotLikePreviewItemView.f8177h.g() : null;
        if (!StringUtil.a(g, hotLikePreviewItemView.f8178i)) {
            hotLikePreviewItemView.f8178i = g;
            hotLikePreviewItemView.m8084a();
        }
        if (!StringUtil.a(g) || hotLikePreviewItemView.f8177h == null) {
            i = 0;
        } else {
            i = hotLikePreviewItemView.f8177h.a(SenderType.ME);
        }
        hotLikePreviewItemView.f8175f.setColorFilter(i);
    }
}
