package com.facebook.composer.inlinesprouts;

import android.content.res.Resources;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.composer.inlinesproutsinterfaces.InlineSproutItem;
import com.facebook.composer.ui.drawables.GlyphpileDrawable;
import com.facebook.feed.util.composer.sprout.SproutIconDrawable;
import com.facebook.feed.util.composer.sprout.SproutListItemBinder;
import com.facebook.inject.InjectorLike;
import com.facebook.resources.ui.FbTextView;
import com.facebook.resources.utils.TextViewUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: gc_stats */
public class CollapsedViewWithExpandedIconsBinder {
    private final Resources f6534a;
    private final SproutListItemBinder f6535b;
    private GlyphpileDrawable f6536c;
    private InlineSproutItem f6537d;
    private ImmutableList<InlineSproutItem> f6538e;

    public static CollapsedViewWithExpandedIconsBinder m7992a(InjectorLike injectorLike) {
        return new CollapsedViewWithExpandedIconsBinder(ResourcesMethodAutoProvider.a(injectorLike), SproutListItemBinder.b(injectorLike));
    }

    public final void m7994a(View view, ImmutableList immutableList) {
        FbTextView fbTextView = (FbTextView) view;
        if (immutableList.isEmpty()) {
            fbTextView.setText("");
            fbTextView.setCompoundDrawables(null, null, null, null);
            return;
        }
        InlineSproutItem inlineSproutItem;
        InlineSproutItem inlineSproutItem2 = null;
        for (int i = 0; i < immutableList.size(); i++) {
            inlineSproutItem = (InlineSproutItem) immutableList.get(i);
            if (inlineSproutItem.mo209e()) {
                if (inlineSproutItem2 == null) {
                    inlineSproutItem2 = inlineSproutItem;
                }
                if (!inlineSproutItem.mo207c()) {
                    break;
                }
            }
        }
        inlineSproutItem = inlineSproutItem2;
        InlineSproutItem inlineSproutItem3 = inlineSproutItem;
        if (inlineSproutItem3 != this.f6537d) {
            this.f6537d = inlineSproutItem3;
            fbTextView.setText(inlineSproutItem3.mo210f());
        }
        if (!immutableList.equals(this.f6538e)) {
            this.f6538e = immutableList;
            Builder builder = ImmutableList.builder();
            int i2 = 0;
            int i3 = 0;
            while (i3 < 4 && i2 < immutableList.size()) {
                int i4;
                if (((InlineSproutItem) immutableList.get(i2)).mo208d()) {
                    SproutIconDrawable sproutIconDrawable = new SproutIconDrawable(this.f6534a);
                    this.f6535b.a(sproutIconDrawable, ((InlineSproutItem) immutableList.get(i2)).mo205a());
                    builder.c(sproutIconDrawable);
                    i4 = i3 + 1;
                } else {
                    i4 = i3;
                }
                i2++;
                i3 = i4;
            }
            this.f6536c = new GlyphpileDrawable(builder.b(), 0);
            TextViewUtils.a(fbTextView, null, null, this.f6536c, null);
        }
    }

    @Inject
    public CollapsedViewWithExpandedIconsBinder(Resources resources, SproutListItemBinder sproutListItemBinder) {
        this.f6534a = resources;
        this.f6535b = sproutListItemBinder;
    }

    public final int m7993a() {
        return 2130904911;
    }
}
