package com.facebook.components.glyph;

import android.graphics.drawable.Drawable;
import com.facebook.components.reference.Reference;

/* compiled from: transliterator_help_cancelled */
class GlyphColorizerDrawableReference$State extends Reference<Drawable> {
    int f1227a;
    int f1228b;
    final /* synthetic */ GlyphColorizerDrawableReference f1229c;

    public GlyphColorizerDrawableReference$State(GlyphColorizerDrawableReference glyphColorizerDrawableReference) {
        this.f1229c = glyphColorizerDrawableReference;
        super(glyphColorizerDrawableReference);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GlyphColorizerDrawableReference$State glyphColorizerDrawableReference$State = (GlyphColorizerDrawableReference$State) obj;
        if (this.f1227a != glyphColorizerDrawableReference$State.f1227a) {
            return false;
        }
        if (this.f1228b != glyphColorizerDrawableReference$State.f1228b) {
            return false;
        }
        return true;
    }
}
