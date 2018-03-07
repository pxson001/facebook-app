package com.facebook.messaging.montage.composer;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.facebook.common.util.MathUtil;
import com.facebook.inject.FbInjector;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: is_page_like */
public class MontageComposerNavigationItemView extends CustomLinearLayout {
    private static final SpringConfig f12506b = new SpringConfig(200.0d, 15.0d);
    @Inject
    public SpringSystem f12507a;
    public final ImageView f12508c;
    private final Spring f12509d;

    /* compiled from: is_page_like */
    class SelectionSpringListener extends SimpleSpringListener {
        final /* synthetic */ MontageComposerNavigationItemView f12505a;

        public SelectionSpringListener(MontageComposerNavigationItemView montageComposerNavigationItemView) {
            this.f12505a = montageComposerNavigationItemView;
        }

        public final void m12971a(Spring spring) {
            float d = (float) spring.d();
            float a = MathUtil.a(1.0f, 1.2f, d);
            d = MathUtil.a(0.6f, 1.0f, d);
            this.f12505a.f12508c.setScaleX(a);
            this.f12505a.f12508c.setScaleY(a);
            this.f12505a.f12508c.setAlpha(d);
        }
    }

    public static void m12972a(Object obj, Context context) {
        ((MontageComposerNavigationItemView) obj).f12507a = SpringSystem.b(FbInjector.get(context));
    }

    public MontageComposerNavigationItemView(Context context) {
        this(context, null);
    }

    private MontageComposerNavigationItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private MontageComposerNavigationItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = MontageComposerNavigationItemView.class;
        m12972a(this, getContext());
        setOrientation(1);
        setClipChildren(false);
        setContentView(2130905332);
        this.f12508c = (ImageView) a(2131559122);
        this.f12508c.setAlpha(0.6f);
        Spring l = this.f12507a.a().a(f12506b).l();
        l.c = true;
        this.f12509d = l.a(new SelectionSpringListener(this));
    }

    public void setSelected(boolean z) {
        if (z != isSelected()) {
            this.f12509d.b(z ? 1.0d : 0.0d);
        }
        super.setSelected(z);
    }

    public void setDisplayBackAffordance(boolean z) {
    }
}
