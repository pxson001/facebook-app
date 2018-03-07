package com.facebook.orca.threadview;

import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.common.util.ContextUtils;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.customthreads.DefaultThreadViewTheme;
import com.facebook.messaging.customthreads.ThreadViewTheme.Listener;
import com.facebook.messaging.customthreads.ThreadViewTheme.SenderType;
import com.facebook.messaging.photos.tiles.UserTileViewParamsFactory;
import com.facebook.messaging.threadview.rows.RowTypingItem;
import com.facebook.uicontrib.typinganimation.TypingDotsAnimationHelper;
import com.facebook.uicontrib.typinganimation.TypingDotsAnimationHelper.TypingAnimationParams;
import com.facebook.user.tiles.UserTileView;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.RoundedCornerOverlayDrawable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: max_pos */
public class TypingItemView extends CustomFrameLayout {
    @Inject
    public TypingDotsAnimationHelper f8135a;
    @Inject
    public UserTileViewParamsFactory f8136b;
    private final View f8137c;
    public final UserTileView f8138d;
    private final List<View> f8139e;
    public final RoundedCornerOverlayDrawable f8140f;
    public final int f8141g;
    public final int f8142h;
    private final AnimatorSet f8143i;
    public final Listener f8144j;
    public RowTypingItem f8145k;
    @Nullable
    public DefaultThreadViewTheme f8146l;

    /* compiled from: max_pos */
    class C12221 implements Listener {
        final /* synthetic */ TypingItemView f8134a;

        C12221(TypingItemView typingItemView) {
            this.f8134a = typingItemView;
        }

        public final void m8059a() {
            TypingItemView.m8060a(this.f8134a);
        }
    }

    public static void m8061a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        TypingItemView typingItemView = (TypingItemView) obj;
        TypingDotsAnimationHelper b = TypingDotsAnimationHelper.b(fbInjector);
        UserTileViewParamsFactory a = UserTileViewParamsFactory.a(fbInjector);
        typingItemView.f8135a = b;
        typingItemView.f8136b = a;
    }

    public TypingItemView(Context context) {
        this(context, null);
    }

    private TypingItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private TypingItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8144j = new C12221(this);
        Class cls = TypingItemView.class;
        m8061a(this, getContext());
        setContentView(2130905913);
        this.f8141g = ContextUtils.e(context, 2130773133, 0);
        this.f8142h = ContextUtils.e(context, 2130773134, 0);
        this.f8137c = c(2131565265);
        this.f8138d = (UserTileView) c(2131564859);
        this.f8139e = new ArrayList();
        this.f8139e.add(c(2131564475));
        this.f8139e.add(c(2131564476));
        this.f8139e.add(c(2131564477));
        this.f8140f = new RoundedCornerOverlayDrawable();
        this.f8140f.a(-1);
        ((FrameLayout) c(2131565265)).setForeground(this.f8140f);
        m8060a(this);
        this.f8143i = this.f8135a.a(new TypingAnimationParams((View) this.f8139e.get(0), (View) this.f8139e.get(1), (View) this.f8139e.get(2), 6, 1633, 367));
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -911386808);
        super.onAttachedToWindow();
        this.f8143i.start();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -2027156261, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1584109433);
        super.onDetachedFromWindow();
        this.f8143i.end();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -436823804, a);
    }

    public static void m8060a(TypingItemView typingItemView) {
        if (typingItemView.f8146l != null) {
            int a = typingItemView.f8146l.a(SenderType.OTHER);
            Drawable background = typingItemView.f8137c.getBackground();
            background.mutate().setColorFilter(a, Mode.SRC_ATOP);
            background.invalidateSelf();
            int c = typingItemView.f8146l.c(SenderType.OTHER);
            for (int i = 0; i < typingItemView.f8139e.size(); i++) {
                ((View) typingItemView.f8139e.get(i)).getBackground().mutate().setColorFilter(c, Mode.SRC_ATOP);
            }
            typingItemView.f8140f.a(typingItemView.f8146l.f());
        }
    }
}
