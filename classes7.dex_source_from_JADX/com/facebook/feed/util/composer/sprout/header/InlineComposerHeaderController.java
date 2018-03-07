package com.facebook.feed.util.composer.sprout.header;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feed.util.composer.sprout.InlineComposerForSproutsView;
import com.facebook.inject.Assisted;
import com.facebook.qe.api.QeAccessor;
import com.facebook.springs.SpringUtil;
import javax.inject.Inject;

/* compiled from: TRANSITION_FINISHED */
public class InlineComposerHeaderController implements SproutHeaderController<InlineComposerForSproutsView> {
    private final String f22490a;
    private final String f22491b;
    private final String f22492c;
    private final Resources f22493d;
    private final QeAccessor f22494e;
    private final GlyphColorizer f22495f;

    public final void mo1557a(View view) {
        InlineComposerForSproutsView inlineComposerForSproutsView = (InlineComposerForSproutsView) view;
        m25086d(inlineComposerForSproutsView);
        inlineComposerForSproutsView.setText(this.f22491b);
        inlineComposerForSproutsView.setThumbnailUri(this.f22492c);
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
        inlineComposerForSproutsView.setAuxColorFilter(this.f22495f.a(resources.getColor(2131361974)));
        inlineComposerForSproutsView.setOnClickListener(onClickListener);
        inlineComposerForSproutsView.setAuxOnClickListener(onClickListener2);
    }

    public final void mo1560b(View view) {
        m25086d((InlineComposerForSproutsView) view);
    }

    public final void mo1561c(View view) {
        m25086d((InlineComposerForSproutsView) view);
    }

    @Inject
    public InlineComposerHeaderController(@Assisted String str, @Assisted String str2, @Assisted String str3, Resources resources, QeAccessor qeAccessor, GlyphColorizer glyphColorizer) {
        this.f22492c = str;
        this.f22493d = resources;
        this.f22494e = qeAccessor;
        this.f22495f = glyphColorizer;
        this.f22490a = str2;
        this.f22491b = str3;
    }

    public final int mo1556a() {
        return 2130904900;
    }

    private void m25086d(InlineComposerForSproutsView inlineComposerForSproutsView) {
        inlineComposerForSproutsView.setText(this.f22490a);
        inlineComposerForSproutsView.setThumbnailUri(this.f22492c);
    }
}
