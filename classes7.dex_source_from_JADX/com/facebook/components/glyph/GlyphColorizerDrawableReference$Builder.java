package com.facebook.components.glyph;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import com.facebook.components.ComponentContext;
import com.facebook.components.reference.Reference;
import com.facebook.components.reference.Reference.Builder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* compiled from: transliterator_help_cancelled */
public class GlyphColorizerDrawableReference$Builder extends Builder<Drawable> {
    GlyphColorizerDrawableReference$State f1223a;
    private String[] f1224b = new String[]{"resourceId", "color"};
    private int f1225c = 2;
    private BitSet f1226d = new BitSet(this.f1225c);

    public static void m1291a(GlyphColorizerDrawableReference$Builder glyphColorizerDrawableReference$Builder, ComponentContext componentContext, GlyphColorizerDrawableReference$State glyphColorizerDrawableReference$State) {
        super.a(componentContext);
        glyphColorizerDrawableReference$Builder.f1223a = glyphColorizerDrawableReference$State;
        glyphColorizerDrawableReference$Builder.f1226d.clear();
    }

    public final GlyphColorizerDrawableReference$Builder m1294h(int i) {
        this.f1223a.f1227a = i;
        this.f1226d.set(0);
        return this;
    }

    public final GlyphColorizerDrawableReference$Builder m1295i(int i) {
        this.f1223a.f1228b = i;
        this.f1226d.set(1);
        return this;
    }

    public final GlyphColorizerDrawableReference$Builder m1296j(@ColorRes int i) {
        this.f1223a.f1228b = d(i);
        this.f1226d.set(1);
        return this;
    }

    public final Reference<Drawable> m1293b() {
        int i = 0;
        if (this.f1226d == null || this.f1226d.nextClearBit(0) >= this.f1225c) {
            GlyphColorizerDrawableReference$State glyphColorizerDrawableReference$State = this.f1223a;
            m1292a();
            return glyphColorizerDrawableReference$State;
        }
        List arrayList = new ArrayList();
        while (i < this.f1225c) {
            if (!this.f1226d.get(i)) {
                arrayList.add(this.f1224b[i]);
            }
            i++;
        }
        throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
    }

    protected final void m1292a() {
        super.a();
        this.f1223a = null;
        GlyphColorizerDrawableReference.a.a(this);
    }
}
