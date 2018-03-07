package com.facebook.video.videohome.partdefinitions;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryTextHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextOrHiddenPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: single_recipient */
public class VideoHomeSingleLineDescriptionPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, AnyEnvironment, View> {
    public static final ViewType<View> f3173a = ViewType.a(2130907727);
    private static VideoHomeSingleLineDescriptionPartDefinition f3174c;
    private static final Object f3175d = new Object();
    private final TextOrHiddenPartDefinition f3176b;

    private static VideoHomeSingleLineDescriptionPartDefinition m3020b(InjectorLike injectorLike) {
        return new VideoHomeSingleLineDescriptionPartDefinition(TextOrHiddenPartDefinition.a(injectorLike));
    }

    public final Object m3023a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Object b = m3021b((FeedProps) obj);
        if (TextUtils.isEmpty(b)) {
            b = null;
        }
        subParts.a(2131559627, this.f3176b, b);
        return null;
    }

    @Inject
    public VideoHomeSingleLineDescriptionPartDefinition(TextOrHiddenPartDefinition textOrHiddenPartDefinition) {
        this.f3176b = textOrHiddenPartDefinition;
    }

    public static boolean m3019a(FeedProps<GraphQLStory> feedProps) {
        return !TextUtils.isEmpty(m3021b((FeedProps) feedProps));
    }

    public static VideoHomeSingleLineDescriptionPartDefinition m3018a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeSingleLineDescriptionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3175d) {
                VideoHomeSingleLineDescriptionPartDefinition videoHomeSingleLineDescriptionPartDefinition;
                if (a2 != null) {
                    videoHomeSingleLineDescriptionPartDefinition = (VideoHomeSingleLineDescriptionPartDefinition) a2.a(f3175d);
                } else {
                    videoHomeSingleLineDescriptionPartDefinition = f3174c;
                }
                if (videoHomeSingleLineDescriptionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3020b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3175d, b3);
                        } else {
                            f3174c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeSingleLineDescriptionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<View> m3022a() {
        return f3173a;
    }

    private static String m3021b(FeedProps<GraphQLStory> feedProps) {
        return StoryTextHelper.a((GraphQLStory) feedProps.a);
    }
}
