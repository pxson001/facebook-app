package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feedplugins.storyset.rows.ui.StoryPageLabelWithSimpleBlingbarView;
import com.facebook.graphql.model.GraphQLStory;
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
/* compiled from: b10f10a8f07b7eb4fe37065fc16cce1b */
public class StorySetLabelWithSimpleBlingbarPartDefinition extends BaseSinglePartDefinition<Props, Void, AnyEnvironment, StoryPageLabelWithSimpleBlingbarView> {
    private static StorySetLabelWithSimpleBlingbarPartDefinition f9680d;
    private static final Object f9681e = new Object();
    private final TextPartDefinition f9682a;
    private final TextPartDefinition f9683b;
    private final VideoSetsBlingBarPartDefinition f9684c;

    /* compiled from: b10f10a8f07b7eb4fe37065fc16cce1b */
    public class Props {
        CharSequence f9677a;
        CharSequence f9678b;
        GraphQLStory f9679c;

        public Props(CharSequence charSequence, CharSequence charSequence2, GraphQLStory graphQLStory) {
            this.f9677a = charSequence;
            this.f9678b = charSequence2;
            this.f9679c = graphQLStory;
        }
    }

    private static StorySetLabelWithSimpleBlingbarPartDefinition m10160b(InjectorLike injectorLike) {
        return new StorySetLabelWithSimpleBlingbarPartDefinition(TextPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), VideoSetsBlingBarPartDefinition.m10220a(injectorLike));
    }

    public final Object m10161a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.a(2131567706, this.f9682a, props.f9677a);
        subParts.a(2131567707, this.f9683b, props.f9678b);
        subParts.a(2131567449, this.f9684c, props.f9679c);
        return null;
    }

    @Inject
    public StorySetLabelWithSimpleBlingbarPartDefinition(TextPartDefinition textPartDefinition, TextPartDefinition textPartDefinition2, VideoSetsBlingBarPartDefinition videoSetsBlingBarPartDefinition) {
        this.f9682a = textPartDefinition;
        this.f9683b = textPartDefinition2;
        this.f9684c = videoSetsBlingBarPartDefinition;
    }

    public static StorySetLabelWithSimpleBlingbarPartDefinition m10159a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetLabelWithSimpleBlingbarPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9681e) {
                StorySetLabelWithSimpleBlingbarPartDefinition storySetLabelWithSimpleBlingbarPartDefinition;
                if (a2 != null) {
                    storySetLabelWithSimpleBlingbarPartDefinition = (StorySetLabelWithSimpleBlingbarPartDefinition) a2.a(f9681e);
                } else {
                    storySetLabelWithSimpleBlingbarPartDefinition = f9680d;
                }
                if (storySetLabelWithSimpleBlingbarPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10160b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9681e, b3);
                        } else {
                            f9680d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetLabelWithSimpleBlingbarPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
