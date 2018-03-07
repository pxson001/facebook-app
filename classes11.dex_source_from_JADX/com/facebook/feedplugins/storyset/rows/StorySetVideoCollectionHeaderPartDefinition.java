package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition.Props;
import com.facebook.feed.rows.sections.header.ui.MenuConfig;
import com.facebook.feed.rows.sections.header.ui.TextWithMenuButtonView;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.StorySetHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextAppearancePartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: audience_educator_controller_null_selected_privacy */
public class StorySetVideoCollectionHeaderPartDefinition<E extends HasMenuButtonProvider & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStorySet>, Void, E, TextWithMenuButtonView> {
    private static StorySetVideoCollectionHeaderPartDefinition f9784e;
    private static final Object f9785f = new Object();
    private final BackgroundPartDefinition f9786a;
    private final MenuButtonPartDefinition f9787b;
    private final TextPartDefinition f9788c;
    private final TextAppearancePartDefinition f9789d;

    private static StorySetVideoCollectionHeaderPartDefinition m10216b(InjectorLike injectorLike) {
        return new StorySetVideoCollectionHeaderPartDefinition(BackgroundPartDefinition.a(injectorLike), MenuButtonPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), TextAppearancePartDefinition.a(injectorLike));
    }

    public final Object m10218a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f9786a, new StylingData(feedProps, PaddingStyle.j, Position.TOP));
        subParts.a(2131562876, this.f9788c, ((GraphQLStorySet) feedProps.a).D().a());
        subParts.a(2131562876, this.f9789d, Integer.valueOf(2131624231));
        subParts.a(2131560877, this.f9787b, new Props(feedProps, MenuConfig.CLICKABLE));
        return null;
    }

    public final boolean m10219a(Object obj) {
        return StorySetHelper.d((GraphQLStorySet) ((FeedProps) obj).a);
    }

    @Inject
    public StorySetVideoCollectionHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition, MenuButtonPartDefinition menuButtonPartDefinition, TextPartDefinition textPartDefinition, TextAppearancePartDefinition textAppearancePartDefinition) {
        this.f9786a = backgroundPartDefinition;
        this.f9787b = menuButtonPartDefinition;
        this.f9788c = textPartDefinition;
        this.f9789d = textAppearancePartDefinition;
    }

    public final ViewType m10217a() {
        return TextWithMenuButtonView.b;
    }

    public static StorySetVideoCollectionHeaderPartDefinition m10215a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetVideoCollectionHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9785f) {
                StorySetVideoCollectionHeaderPartDefinition storySetVideoCollectionHeaderPartDefinition;
                if (a2 != null) {
                    storySetVideoCollectionHeaderPartDefinition = (StorySetVideoCollectionHeaderPartDefinition) a2.a(f9785f);
                } else {
                    storySetVideoCollectionHeaderPartDefinition = f9784e;
                }
                if (storySetVideoCollectionHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10216b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9785f, b3);
                        } else {
                            f9784e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetVideoCollectionHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
