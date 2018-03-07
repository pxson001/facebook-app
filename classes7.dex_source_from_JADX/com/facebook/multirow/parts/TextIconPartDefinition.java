package com.facebook.multirow.parts;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.glyph.GlyphColorizer;
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
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: notifications_view_notifications_url */
public class TextIconPartDefinition extends BaseSinglePartDefinition<IconData, State, AnyEnvironment, TextView> {
    private static TextIconPartDefinition f7956d;
    private static final Object f7957e = new Object();
    private final Resources f7958a;
    private final GlyphColorizer f7959b;
    public final RTLUtil f7960c;

    @Immutable
    /* compiled from: notifications_view_notifications_url */
    public class IconData {
        public final int f7950a;
        @Nullable
        public final Integer f7951b;
        @Nullable
        public final Integer f7952c;
        public final Position f7953d;

        /* compiled from: notifications_view_notifications_url */
        public enum Position {
            START,
            TOP,
            END,
            BOTTOM
        }

        public IconData(int i, @Nullable Integer num, @Nullable Integer num2) {
            this(i, num, num2, Position.START);
        }

        private IconData(int i, @Nullable Integer num, @Nullable Integer num2, Position position) {
            this.f7950a = i;
            this.f7952c = num;
            this.f7951b = num2;
            this.f7953d = position;
        }

        public IconData(int i, int i2, Position position) {
            this(i, null, Integer.valueOf(i2), position);
        }
    }

    @Immutable
    /* compiled from: notifications_view_notifications_url */
    public class State {
        public final Drawable f7954a;
        @Nullable
        public final Integer f7955b;

        public State(Drawable drawable, Integer num) {
            this.f7954a = drawable;
            this.f7955b = num;
        }
    }

    private static TextIconPartDefinition m9578b(InjectorLike injectorLike) {
        return new TextIconPartDefinition(ResourcesMethodAutoProvider.a(injectorLike), GlyphColorizer.a(injectorLike), RTLUtil.a(injectorLike));
    }

    public final Object m9579a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        IconData iconData = (IconData) obj;
        Integer num = null;
        if (iconData.f7950a == 0) {
            return new State(null, null);
        }
        Drawable a = iconData.f7952c != null ? this.f7959b.a(iconData.f7950a, iconData.f7952c.intValue()) : this.f7958a.getDrawable(iconData.f7950a);
        if (iconData.f7951b != null) {
            num = Integer.valueOf(this.f7958a.getDimensionPixelSize(iconData.f7951b.intValue()));
        }
        return new State(a, num);
    }

    @TargetApi(17)
    public final /* bridge */ /* synthetic */ void m9580a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1713875639);
        IconData iconData = (IconData) obj;
        State state = (State) obj2;
        TextView textView = (TextView) view;
        if (state.f7955b != null) {
            textView.setCompoundDrawablePadding(state.f7955b.intValue());
        }
        Drawable[] compoundDrawablesRelative;
        if (this.f7960c.a()) {
            compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
            compoundDrawablesRelative[iconData.f7953d.ordinal()] = state.f7954a;
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(compoundDrawablesRelative[0], compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
            textView.setGravity(5);
        } else {
            compoundDrawablesRelative = textView.getCompoundDrawables();
            compoundDrawablesRelative[iconData.f7953d.ordinal()] = state.f7954a;
            textView.setCompoundDrawablesWithIntrinsicBounds(compoundDrawablesRelative[0], compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
            textView.setGravity(3);
        }
        Logger.a(8, EntryType.MARK_POP, -758350911, a);
    }

    @TargetApi(17)
    public final void m9581b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        TextView textView = (TextView) view;
        if (this.f7960c.a()) {
            Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
            textView.setCompoundDrawablesRelative(null, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
            return;
        }
        compoundDrawablesRelative = textView.getCompoundDrawables();
        textView.setCompoundDrawables(null, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
    }

    public static TextIconPartDefinition m9577a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TextIconPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7957e) {
                TextIconPartDefinition textIconPartDefinition;
                if (a2 != null) {
                    textIconPartDefinition = (TextIconPartDefinition) a2.a(f7957e);
                } else {
                    textIconPartDefinition = f7956d;
                }
                if (textIconPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9578b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7957e, b3);
                        } else {
                            f7956d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = textIconPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public TextIconPartDefinition(Resources resources, GlyphColorizer glyphColorizer, RTLUtil rTLUtil) {
        this.f7958a = resources;
        this.f7959b = glyphColorizer;
        this.f7960c = rTLUtil;
    }
}
