package com.facebook.reaction.feed.unitcomponents.partdefinition.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.feed.environment.HasContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;

/* compiled from: about_information */
public class ReactionImageWithOverlayGridItemView<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends CustomFrameLayout {
    private DraweeHolder f20182a;
    private DraweeHolder f20183b;
    private FbTextView f20184c;
    private GlyphView f20185d;
    private ImageView f20186e;

    public ReactionImageWithOverlayGridItemView(Context context) {
        super(context);
        m24049a();
    }

    public ReactionImageWithOverlayGridItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24049a();
    }

    public ReactionImageWithOverlayGridItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24049a();
    }

    private void m24049a() {
        Resources resources = getResources();
        setContentView(2130906680);
        this.f20184c = (FbTextView) c(2131566734);
        this.f20185d = (GlyphView) c(2131566733);
        this.f20186e = (ImageView) c(2131566732);
        Drawable drawable = resources.getDrawable(2130840940);
        Drawable drawable2 = resources.getDrawable(2131361960);
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(resources);
        genericDraweeHierarchyBuilder.f = drawable2;
        GenericDraweeHierarchyBuilder f = genericDraweeHierarchyBuilder.f(drawable);
        f.u = RoundingParams.b(resources.getDimension(2131431476));
        this.f20183b = DraweeHolder.a(f.u(), getContext());
        setBackgroundWithPadding(this.f20183b.h());
        this.f20182a = DraweeHolder.a(new GenericDraweeHierarchyBuilder(resources).u(), getContext());
        this.f20185d.setImageDrawable(this.f20182a.h());
    }

    public void setLabel(@Nullable String str) {
        if (StringUtil.a(str)) {
            this.f20184c.setVisibility(8);
            return;
        }
        this.f20184c.setVisibility(0);
        this.f20184c.setText(str);
    }

    public void setIcon(DraweeController draweeController) {
        if (draweeController == null) {
            this.f20185d.setVisibility(8);
            return;
        }
        this.f20185d.setVisibility(0);
        this.f20182a.a(draweeController);
    }

    private void m24050a(DraweeController draweeController, String str) {
        if (draweeController == null) {
            this.f20183b.a(null);
            return;
        }
        int parseColor = Color.parseColor("#" + str);
        this.f20186e.setColorFilter(Color.argb(51, Color.red(parseColor), Color.green(parseColor), Color.blue(parseColor)));
        this.f20183b.a(draweeController);
    }

    public final void m24051a(String str, DraweeController draweeController, DraweeController draweeController2, String str2) {
        setLabel(str);
        setIcon(draweeController);
        m24050a(draweeController2, str2);
    }

    private void setBackgroundWithPadding(Drawable drawable) {
        this.f20186e.setImageDrawable(drawable);
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 2092587113);
        super.onAttachedToWindow();
        this.f20183b.b();
        this.f20182a.b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1573073864, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1763801927);
        super.onDetachedFromWindow();
        this.f20183b.d();
        this.f20182a.d();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1214391486, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.f20183b.d();
        this.f20182a.d();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f20183b.b();
        this.f20182a.b();
    }
}
