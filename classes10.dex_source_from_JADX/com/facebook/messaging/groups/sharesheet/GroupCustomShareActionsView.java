package com.facebook.messaging.groups.sharesheet;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: should_fetch_ticket_tiers */
public class GroupCustomShareActionsView extends CustomLinearLayout {
    @Inject
    public GlyphColorizer f2496a;
    private ImageWithTextView f2497b;
    private ImageWithTextView f2498c;
    private ImageWithTextView f2499d;
    @Nullable
    public Callback f2500e;
    private final OnClickListener f2501f = new C04131(this);
    private final OnClickListener f2502g = new C04142(this);
    private final OnClickListener f2503h = new C04153(this);

    /* compiled from: should_fetch_ticket_tiers */
    class C04131 implements OnClickListener {
        final /* synthetic */ GroupCustomShareActionsView f2493a;

        C04131(GroupCustomShareActionsView groupCustomShareActionsView) {
            this.f2493a = groupCustomShareActionsView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -219057502);
            if (this.f2493a.f2500e != null) {
                this.f2493a.f2500e.mo68a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1296820860, a);
        }
    }

    /* compiled from: should_fetch_ticket_tiers */
    class C04142 implements OnClickListener {
        final /* synthetic */ GroupCustomShareActionsView f2494a;

        C04142(GroupCustomShareActionsView groupCustomShareActionsView) {
            this.f2494a = groupCustomShareActionsView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1193916029);
            if (this.f2494a.f2500e != null) {
                this.f2494a.f2500e.mo69b();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1280120605, a);
        }
    }

    /* compiled from: should_fetch_ticket_tiers */
    class C04153 implements OnClickListener {
        final /* synthetic */ GroupCustomShareActionsView f2495a;

        C04153(GroupCustomShareActionsView groupCustomShareActionsView) {
            this.f2495a = groupCustomShareActionsView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1084314484);
            if (this.f2495a.f2500e != null) {
                this.f2495a.f2500e.mo70c();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -2108734648, a);
        }
    }

    /* compiled from: should_fetch_ticket_tiers */
    public interface Callback {
        void mo68a();

        void mo69b();

        void mo70c();
    }

    private static <T extends View> void m2509a(Class<T> cls, T t) {
        m2510a((Object) t, t.getContext());
    }

    private static void m2510a(Object obj, Context context) {
        ((GroupCustomShareActionsView) obj).f2496a = GlyphColorizer.a(FbInjector.get(context));
    }

    private void m2508a(GlyphColorizer glyphColorizer) {
        this.f2496a = glyphColorizer;
    }

    public GroupCustomShareActionsView(Context context) {
        super(context);
        m2507a();
    }

    public GroupCustomShareActionsView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m2507a();
    }

    public GroupCustomShareActionsView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2507a();
    }

    public void setCallback(@Nullable Callback callback) {
        this.f2500e = callback;
    }

    private void m2507a() {
        m2509a(GroupCustomShareActionsView.class, (View) this);
        setContentView(2130904649);
        this.f2497b = (ImageWithTextView) a(2131562652);
        this.f2497b.setImageDrawable(m2505a(getResources().getDrawable(2130840648), 2130841414));
        this.f2497b.setOnClickListener(this.f2501f);
        this.f2498c = (ImageWithTextView) a(2131562653);
        this.f2498c.setImageDrawable(m2505a(getResources().getDrawable(2130840650), 2130841394));
        this.f2498c.setOnClickListener(this.f2502g);
        this.f2499d = (ImageWithTextView) a(2131562654);
        this.f2499d.setImageDrawable(m2505a(getResources().getDrawable(2130840649), 2130841382));
        this.f2499d.setOnClickListener(this.f2503h);
    }

    private Drawable m2505a(Drawable drawable, int i) {
        ((BitmapDrawable) this.f2496a.a(i, -1)).setGravity(17);
        return new LayerDrawable(new Drawable[]{drawable, r0});
    }
}
