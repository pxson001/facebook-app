package com.facebook.feed.rows.permalink;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.TextHeaderPartDefinition;
import com.facebook.feed.rows.sections.header.ui.TextWithMenuButtonView;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: activity_picker_verb_selected */
public class PermalinkTextHeaderPartDefinition<E extends HasMenuButtonProvider & HasPositionInformation & HasPersistentState & HasInvalidate & HasContext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, TextWithMenuButtonView> {
    private static PermalinkTextHeaderPartDefinition f19969c;
    private static final Object f19970d = new Object();
    private final TextHeaderPartDefinition<E, TextWithMenuButtonView> f19971a;
    private final PermalinkStoryMenuButtonPartDefinition<TextWithMenuButtonView> f19972b;

    private static PermalinkTextHeaderPartDefinition m23170b(InjectorLike injectorLike) {
        return new PermalinkTextHeaderPartDefinition(PermalinkStoryMenuButtonPartDefinition.m23149a(injectorLike), TextHeaderPartDefinition.a(injectorLike));
    }

    public final Object m23172a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f19971a, feedProps);
        subParts.a(this.f19972b, feedProps);
        return null;
    }

    public final boolean m23173a(Object obj) {
        return TextHeaderPartDefinition.a((FeedProps) obj);
    }

    @Inject
    public PermalinkTextHeaderPartDefinition(PermalinkStoryMenuButtonPartDefinition permalinkStoryMenuButtonPartDefinition, TextHeaderPartDefinition textHeaderPartDefinition) {
        this.f19971a = textHeaderPartDefinition;
        this.f19972b = permalinkStoryMenuButtonPartDefinition;
    }

    public final ViewType m23171a() {
        return TextWithMenuButtonView.b;
    }

    public static PermalinkTextHeaderPartDefinition m23169a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PermalinkTextHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19970d) {
                PermalinkTextHeaderPartDefinition permalinkTextHeaderPartDefinition;
                if (a2 != null) {
                    permalinkTextHeaderPartDefinition = (PermalinkTextHeaderPartDefinition) a2.a(f19970d);
                } else {
                    permalinkTextHeaderPartDefinition = f19969c;
                }
                if (permalinkTextHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23170b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19970d, b3);
                        } else {
                            f19969c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = permalinkTextHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
