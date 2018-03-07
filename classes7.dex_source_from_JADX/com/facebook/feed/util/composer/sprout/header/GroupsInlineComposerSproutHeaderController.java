package com.facebook.feed.util.composer.sprout.header;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feed.util.composer.sprout.InlineComposerForSproutsView;
import com.facebook.inject.Assisted;
import com.facebook.springs.SpringUtil;
import javax.inject.Inject;

/* compiled from: TRANSITION_RUNNING */
public class GroupsInlineComposerSproutHeaderController implements SproutHeaderController<InlineComposerForSproutsView> {
    private final String f22487a;
    private final String f22488b;
    private final GlyphColorizer f22489c;

    public final void mo1557a(View view) {
        InlineComposerForSproutsView inlineComposerForSproutsView = (InlineComposerForSproutsView) view;
        m25078d(inlineComposerForSproutsView);
        inlineComposerForSproutsView.setText(this.f22487a);
        inlineComposerForSproutsView.setThumbnailUri(this.f22488b);
        inlineComposerForSproutsView.setAuxAlpha(1.0f);
        inlineComposerForSproutsView.setAuxRotation(0.0f);
    }

    public final void mo1558a(View view, float f) {
        InlineComposerForSproutsView inlineComposerForSproutsView = (InlineComposerForSproutsView) view;
        inlineComposerForSproutsView.setAuxAlpha(f);
        inlineComposerForSproutsView.setAuxRotation((float) SpringUtil.a((double) f, 0.0d, 1.0d, 0.0d, 360.0d));
    }

    public final void mo1559a(View view, OnClickListener onClickListener, OnClickListener onClickListener2) {
        InlineComposerForSproutsView inlineComposerForSproutsView = (InlineComposerForSproutsView) view;
        Resources resources = inlineComposerForSproutsView.getContext().getResources();
        inlineComposerForSproutsView.setBackgroundResource(2130839797);
        inlineComposerForSproutsView.setAuxContentDescription(resources.getString(2131234837));
        inlineComposerForSproutsView.setAuxImageResource(2130839815);
        inlineComposerForSproutsView.setAuxColorFilter(this.f22489c.a(resources.getColor(2131361974)));
        inlineComposerForSproutsView.setOnClickListener(onClickListener);
        inlineComposerForSproutsView.setAuxOnClickListener(onClickListener2);
    }

    public final void mo1560b(View view) {
        m25078d((InlineComposerForSproutsView) view);
    }

    public final void mo1561c(View view) {
        m25078d((InlineComposerForSproutsView) view);
    }

    @Inject
    public GroupsInlineComposerSproutHeaderController(@Assisted String str, @Assisted String str2, GlyphColorizer glyphColorizer) {
        this.f22488b = str;
        this.f22489c = glyphColorizer;
        this.f22487a = str2;
    }

    public final int mo1556a() {
        return 2130904900;
    }

    private void m25078d(InlineComposerForSproutsView inlineComposerForSproutsView) {
        inlineComposerForSproutsView.setText(this.f22487a);
        inlineComposerForSproutsView.setThumbnailUri(this.f22488b);
    }
}
