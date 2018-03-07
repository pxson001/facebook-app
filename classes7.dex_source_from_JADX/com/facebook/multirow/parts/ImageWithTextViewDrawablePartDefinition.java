package com.facebook.multirow.parts;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: notificationssettings */
public class ImageWithTextViewDrawablePartDefinition extends BaseSinglePartDefinition<IconData, Drawable, AnyEnvironment, ImageWithTextView> {
    private static ImageWithTextViewDrawablePartDefinition f7946c;
    private static final Object f7947d = new Object();
    private final Resources f7948a;
    private final GlyphColorizer f7949b;

    /* compiled from: notificationssettings */
    public class IconData {
        @DrawableRes
        public final int f7944a;
        @ColorInt
        @Nullable
        public final Integer f7945b;

        public IconData(int i, @Nullable Integer num) {
            this.f7944a = i;
            this.f7945b = num;
        }
    }

    private static ImageWithTextViewDrawablePartDefinition m9574b(InjectorLike injectorLike) {
        return new ImageWithTextViewDrawablePartDefinition(ResourcesMethodAutoProvider.a(injectorLike), GlyphColorizer.a(injectorLike));
    }

    public final Object m9575a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        IconData iconData = (IconData) obj;
        if (iconData.f7944a == 0) {
            return null;
        }
        if (iconData.f7945b != null) {
            return this.f7949b.a(iconData.f7944a, iconData.f7945b.intValue());
        }
        return this.f7948a.getDrawable(iconData.f7944a);
    }

    public final /* bridge */ /* synthetic */ void m9576a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1121598686);
        ((ImageWithTextView) view).setImageDrawable((Drawable) obj2);
        Logger.a(8, EntryType.MARK_POP, -38623347, a);
    }

    @Inject
    public ImageWithTextViewDrawablePartDefinition(Resources resources, GlyphColorizer glyphColorizer) {
        this.f7948a = resources;
        this.f7949b = glyphColorizer;
    }

    public static ImageWithTextViewDrawablePartDefinition m9573a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ImageWithTextViewDrawablePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7947d) {
                ImageWithTextViewDrawablePartDefinition imageWithTextViewDrawablePartDefinition;
                if (a2 != null) {
                    imageWithTextViewDrawablePartDefinition = (ImageWithTextViewDrawablePartDefinition) a2.a(f7947d);
                } else {
                    imageWithTextViewDrawablePartDefinition = f7946c;
                }
                if (imageWithTextViewDrawablePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9574b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7947d, b3);
                        } else {
                            f7946c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = imageWithTextViewDrawablePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
