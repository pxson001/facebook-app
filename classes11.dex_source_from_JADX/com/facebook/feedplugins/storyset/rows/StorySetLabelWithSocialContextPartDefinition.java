package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feedplugins.storyset.rows.ui.StoryPageLabelWithSocialContextView;
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
/* compiled from: auto_updates */
public class StorySetLabelWithSocialContextPartDefinition extends BaseSinglePartDefinition<Props, Void, AnyEnvironment, StoryPageLabelWithSocialContextView> {
    private static StorySetLabelWithSocialContextPartDefinition f9698d;
    private static final Object f9699e = new Object();
    private final TextPartDefinition f9700a;
    private final TextPartDefinition f9701b;
    private final TextPartDefinition f9702c;

    /* compiled from: auto_updates */
    public class Props {
        CharSequence f9695a;
        CharSequence f9696b;
        public CharSequence f9697c;

        public Props(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
            this.f9695a = charSequence;
            this.f9696b = charSequence2;
            this.f9697c = charSequence3;
        }
    }

    private static StorySetLabelWithSocialContextPartDefinition m10166b(InjectorLike injectorLike) {
        return new StorySetLabelWithSocialContextPartDefinition(TextPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m10167a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.a(2131567706, this.f9700a, props.f9695a);
        subParts.a(2131567707, this.f9701b, props.f9696b);
        subParts.a(2131567709, this.f9702c, props.f9697c);
        return null;
    }

    @Inject
    public StorySetLabelWithSocialContextPartDefinition(TextPartDefinition textPartDefinition, TextPartDefinition textPartDefinition2, TextPartDefinition textPartDefinition3) {
        this.f9700a = textPartDefinition;
        this.f9701b = textPartDefinition2;
        this.f9702c = textPartDefinition3;
    }

    public static StorySetLabelWithSocialContextPartDefinition m10165a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetLabelWithSocialContextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9699e) {
                StorySetLabelWithSocialContextPartDefinition storySetLabelWithSocialContextPartDefinition;
                if (a2 != null) {
                    storySetLabelWithSocialContextPartDefinition = (StorySetLabelWithSocialContextPartDefinition) a2.a(f9699e);
                } else {
                    storySetLabelWithSocialContextPartDefinition = f9698d;
                }
                if (storySetLabelWithSocialContextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10166b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9699e, b3);
                        } else {
                            f9698d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetLabelWithSocialContextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
