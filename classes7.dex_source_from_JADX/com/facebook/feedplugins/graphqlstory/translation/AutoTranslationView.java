package com.facebook.feedplugins.graphqlstory.translation;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import com.facebook.feed.rows.views.ContentTextView;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: SaveActionLink does not have enough information for save. */
public class AutoTranslationView extends CustomLinearLayout {
    public ContentTextView f23443a = ((ContentTextView) a(2131559755));
    public ContentTextView f23444b = ((ContentTextView) a(2131559756));
    public ViewStub f23445c = ((ViewStub) a(2131559753));
    public View f23446d;
    public ContentTextView f23447e;

    public AutoTranslationView(Context context) {
        super(context);
        setContentView(2130903322);
    }

    public void setMenuButtonActive(boolean z) {
        this.f23444b.setVisibility(z ? 0 : 8);
        if (!z) {
            this.f23444b.setOnClickListener(null);
        }
    }

    public float getTextSize() {
        return this.f23443a.getTextSize();
    }

    @Nullable
    public View getOriginalContentView() {
        return this.f23446d;
    }

    public final void m25741a() {
        if (this.f23446d != null) {
            this.f23447e.setVisibility(8);
            this.f23446d.setVisibility(8);
        }
    }
}
