package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import com.facebook.attachments.angora.actionbutton.AngoraActionButtonController;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.storyset.rows.ui.StoryPageLabelWithSocialContextAndButtonView;
import com.facebook.graphql.model.GraphQLStoryAttachment;
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
/* compiled from: available_items */
public class StorySetLabelWithSocialContextAndButtonPartDefinition extends BaseSinglePartDefinition<Props, Void, AnyEnvironment, StoryPageLabelWithSocialContextAndButtonView> {
    private static StorySetLabelWithSocialContextAndButtonPartDefinition f9689e;
    private static final Object f9690f = new Object();
    private final AngoraActionButtonController f9691a;
    private final TextPartDefinition f9692b;
    private final TextPartDefinition f9693c;
    private final TextPartDefinition f9694d;

    /* compiled from: available_items */
    public class Props {
        CharSequence f9685a;
        CharSequence f9686b;
        GraphQLStoryAttachment f9687c;
        FeedProps<GraphQLStoryAttachment> f9688d;

        public Props(CharSequence charSequence, CharSequence charSequence2, FeedProps<GraphQLStoryAttachment> feedProps) {
            this.f9685a = charSequence;
            this.f9686b = charSequence2;
            this.f9687c = (GraphQLStoryAttachment) feedProps.a;
            this.f9688d = feedProps;
        }
    }

    private static StorySetLabelWithSocialContextAndButtonPartDefinition m10163b(InjectorLike injectorLike) {
        return new StorySetLabelWithSocialContextAndButtonPartDefinition(AngoraActionButtonController.a(injectorLike), TextPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m10164a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.a(2131567706, this.f9692b, props.f9685a);
        subParts.a(2131567707, this.f9693c, props.f9686b);
        subParts.a(2131567709, this.f9694d, "Temporary Social Context");
        subParts.a(this.f9691a.a(props.f9688d).a(), props.f9688d);
        return null;
    }

    @Inject
    public StorySetLabelWithSocialContextAndButtonPartDefinition(AngoraActionButtonController angoraActionButtonController, TextPartDefinition textPartDefinition, TextPartDefinition textPartDefinition2, TextPartDefinition textPartDefinition3) {
        this.f9691a = angoraActionButtonController;
        this.f9692b = textPartDefinition;
        this.f9693c = textPartDefinition2;
        this.f9694d = textPartDefinition3;
    }

    public static StorySetLabelWithSocialContextAndButtonPartDefinition m10162a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetLabelWithSocialContextAndButtonPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9690f) {
                StorySetLabelWithSocialContextAndButtonPartDefinition storySetLabelWithSocialContextAndButtonPartDefinition;
                if (a2 != null) {
                    storySetLabelWithSocialContextAndButtonPartDefinition = (StorySetLabelWithSocialContextAndButtonPartDefinition) a2.a(f9690f);
                } else {
                    storySetLabelWithSocialContextAndButtonPartDefinition = f9689e;
                }
                if (storySetLabelWithSocialContextAndButtonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10163b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9690f, b3);
                        } else {
                            f9689e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetLabelWithSocialContextAndButtonPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
