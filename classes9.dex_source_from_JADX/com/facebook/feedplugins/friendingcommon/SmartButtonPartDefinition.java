package com.facebook.feedplugins.friendingcommon;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.friends.ui.SmartButtonLite;
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
import com.facebook.multirow.parts.ImageWithTextViewDrawablePartDefinition;
import com.facebook.multirow.parts.ImageWithTextViewDrawablePartDefinition.IconData;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TOTAL_USER_CPU_TIME */
public class SmartButtonPartDefinition extends BaseSinglePartDefinition<Props, Void, AnyEnvironment, SmartButtonLite> {
    private static SmartButtonPartDefinition f24652c;
    private static final Object f24653d = new Object();
    private final ImageWithTextViewDrawablePartDefinition f24654a;
    private final SmartButtonTextPartDefinition f24655b;

    /* compiled from: TOTAL_USER_CPU_TIME */
    public class Props {
        public final CharSequence f24646a;
        public final CharSequence f24647b;
        @DrawableRes
        public final int f24648c;
        @ColorInt
        @Nullable
        public final Integer f24649d;
        @StyleRes
        public final int f24650e;
        @DrawableRes
        public final int f24651f;

        public Props(CharSequence charSequence, CharSequence charSequence2, int i, Integer num, int i2, int i3) {
            this.f24646a = charSequence;
            this.f24647b = charSequence2;
            this.f24648c = i;
            this.f24649d = num;
            this.f24650e = i2;
            this.f24651f = i3;
        }
    }

    private static SmartButtonPartDefinition m26545b(InjectorLike injectorLike) {
        return new SmartButtonPartDefinition(ImageWithTextViewDrawablePartDefinition.a(injectorLike), SmartButtonTextPartDefinition.m26549a(injectorLike));
    }

    public final Object m26546a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.a(this.f24655b, new com.facebook.feedplugins.friendingcommon.SmartButtonTextPartDefinition.Props(props.f24646a, props.f24647b));
        subParts.a(this.f24654a, new IconData(props.f24648c, props.f24649d));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m26547a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 954801935);
        Props props = (Props) obj;
        SmartButtonLite smartButtonLite = (SmartButtonLite) view;
        if (props.f24650e != 0) {
            smartButtonLite.setStyle(props.f24650e);
        } else if (props.f24649d != null) {
            smartButtonLite.setTextColor(props.f24649d.intValue());
            smartButtonLite.setBackgroundResource(props.f24651f);
        }
        Logger.a(8, EntryType.MARK_POP, -1791584736, a);
    }

    @Inject
    public SmartButtonPartDefinition(ImageWithTextViewDrawablePartDefinition imageWithTextViewDrawablePartDefinition, SmartButtonTextPartDefinition smartButtonTextPartDefinition) {
        this.f24654a = imageWithTextViewDrawablePartDefinition;
        this.f24655b = smartButtonTextPartDefinition;
    }

    public static SmartButtonPartDefinition m26544a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SmartButtonPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24653d) {
                SmartButtonPartDefinition smartButtonPartDefinition;
                if (a2 != null) {
                    smartButtonPartDefinition = (SmartButtonPartDefinition) a2.a(f24653d);
                } else {
                    smartButtonPartDefinition = f24652c;
                }
                if (smartButtonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26545b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24653d, b3);
                        } else {
                            f24652c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = smartButtonPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
