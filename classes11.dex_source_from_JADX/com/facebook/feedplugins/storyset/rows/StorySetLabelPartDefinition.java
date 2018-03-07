package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feedplugins.storyset.rows.ui.StoryPageGenericLabelView;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.TextPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: b3042f58db288fdf1b1b2cefd481cb55 */
public class StorySetLabelPartDefinition extends BaseSinglePartDefinition<Props, Void, AnyEnvironment, StoryPageGenericLabelView> {
    private static StorySetLabelPartDefinition f9666c;
    private static final Object f9667d = new Object();
    private final TextPartDefinition f9668a;
    private final TextPartDefinition f9669b;

    /* compiled from: b3042f58db288fdf1b1b2cefd481cb55 */
    public class Props {
        CharSequence f9664a;
        CharSequence f9665b;

        public Props(CharSequence charSequence, CharSequence charSequence2) {
            this.f9664a = charSequence;
            this.f9665b = charSequence2;
        }
    }

    private static StorySetLabelPartDefinition m10154b(InjectorLike injectorLike) {
        return new StorySetLabelPartDefinition(TextPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m10155a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.a(2131567706, this.f9668a, props.f9664a);
        subParts.a(2131567707, this.f9669b, props.f9665b);
        return null;
    }

    @Inject
    public StorySetLabelPartDefinition(TextPartDefinition textPartDefinition, TextPartDefinition textPartDefinition2) {
        this.f9668a = textPartDefinition;
        this.f9669b = textPartDefinition2;
    }

    public static StorySetLabelPartDefinition m10153a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetLabelPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9667d) {
                StorySetLabelPartDefinition storySetLabelPartDefinition;
                if (a2 != null) {
                    storySetLabelPartDefinition = (StorySetLabelPartDefinition) a2.a(f9667d);
                } else {
                    storySetLabelPartDefinition = f9666c;
                }
                if (storySetLabelPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10154b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9667d, b3);
                        } else {
                            f9666c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetLabelPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
