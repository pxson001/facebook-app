package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition.Props;
import com.facebook.feed.rows.sections.header.ui.MenuConfig;
import com.facebook.feed.rows.sections.header.ui.TextWithImageAndMenuButtonView;
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
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.facebook.multirow.parts.TextAppearancePartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: backFromComposer */
public class StorySetHeaderWithIconAndMenuPartDefinition<E extends HasMenuButtonProvider & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStorySet>, Void, E, TextWithImageAndMenuButtonView> {
    public static final ViewType f9651a = new C11431();
    private static final CallerContext f9652b = CallerContext.a(StorySetHeaderWithIconAndMenuPartDefinition.class, "newsfeed_video_storyset_header_icon");
    private static StorySetHeaderWithIconAndMenuPartDefinition f9653h;
    private static final Object f9654i = new Object();
    private final BackgroundPartDefinition f9655c;
    private final MenuButtonPartDefinition f9656d;
    private final TextPartDefinition f9657e;
    private final TextAppearancePartDefinition f9658f;
    private final FbDraweePartDefinition f9659g;

    /* compiled from: backFromComposer */
    final class C11431 extends ViewType {
        C11431() {
        }

        public final View m10142a(Context context) {
            return new TextWithImageAndMenuButtonView(new ContextThemeWrapper(context, 2131625556));
        }
    }

    private static StorySetHeaderWithIconAndMenuPartDefinition m10144b(InjectorLike injectorLike) {
        return new StorySetHeaderWithIconAndMenuPartDefinition(BackgroundPartDefinition.a(injectorLike), MenuButtonPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), TextAppearancePartDefinition.a(injectorLike), FbDraweePartDefinition.a(injectorLike));
    }

    public final Object m10146a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f9655c, new StylingData(feedProps, PaddingStyle.j, Position.TOP));
        subParts.a(2131562876, this.f9657e, ((GraphQLStorySet) feedProps.a).D().a());
        subParts.a(2131562876, this.f9658f, Integer.valueOf(2131624231));
        subParts.a(2131560877, this.f9656d, new Props(feedProps, MenuConfig.CLICKABLE));
        FbDraweePartDefinition fbDraweePartDefinition = this.f9659g;
        Builder a = new Builder().a(((GraphQLStorySet) feedProps.a).M().b());
        a.c = f9652b;
        subParts.a(2131567835, fbDraweePartDefinition, a.a());
        return null;
    }

    public final boolean m10147a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        return (!StorySetHelper.d((GraphQLStorySet) feedProps.a) || ((GraphQLStorySet) feedProps.a).M() == null || StringUtil.a(((GraphQLStorySet) feedProps.a).M().b())) ? false : true;
    }

    public static StorySetHeaderWithIconAndMenuPartDefinition m10143a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetHeaderWithIconAndMenuPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9654i) {
                StorySetHeaderWithIconAndMenuPartDefinition storySetHeaderWithIconAndMenuPartDefinition;
                if (a2 != null) {
                    storySetHeaderWithIconAndMenuPartDefinition = (StorySetHeaderWithIconAndMenuPartDefinition) a2.a(f9654i);
                } else {
                    storySetHeaderWithIconAndMenuPartDefinition = f9653h;
                }
                if (storySetHeaderWithIconAndMenuPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10144b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9654i, b3);
                        } else {
                            f9653h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetHeaderWithIconAndMenuPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public StorySetHeaderWithIconAndMenuPartDefinition(BackgroundPartDefinition backgroundPartDefinition, MenuButtonPartDefinition menuButtonPartDefinition, TextPartDefinition textPartDefinition, TextAppearancePartDefinition textAppearancePartDefinition, FbDraweePartDefinition fbDraweePartDefinition) {
        this.f9655c = backgroundPartDefinition;
        this.f9656d = menuButtonPartDefinition;
        this.f9657e = textPartDefinition;
        this.f9658f = textAppearancePartDefinition;
        this.f9659g = fbDraweePartDefinition;
    }

    public final ViewType m10145a() {
        return f9651a;
    }
}
