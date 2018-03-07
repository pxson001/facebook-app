package com.facebook.video.videohome.partdefinitions;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
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
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitVideoChannelFeedUnitComponentFragmentModel.ContextListModel;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: singleMediaItemOnly */
public class VideoHomeTagsPartDefinition extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, AnyEnvironment, View> {
    public static final ViewType<View> f3180a = ViewType.a(2130907729);
    private static VideoHomeTagsPartDefinition f3181c;
    private static final Object f3182d = new Object();
    private final TextOrHiddenPartDefinition f3183b;

    private static VideoHomeTagsPartDefinition m3031b(InjectorLike injectorLike) {
        return new VideoHomeTagsPartDefinition(TextOrHiddenPartDefinition.a(injectorLike));
    }

    public final Object m3033a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        String b;
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        if (m3030a(reactionUnitComponentNode)) {
            ImmutableList W = reactionUnitComponentNode.b.W();
            String[] strArr = new String[W.size()];
            int size = W.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                strArr[i] = ((ContextListModel) W.get(i2)).a();
                i++;
            }
            b = StringUtil.b(", ", strArr);
        } else {
            b = null;
        }
        Object obj2 = b;
        if (TextUtils.isEmpty(obj2)) {
            obj2 = null;
        }
        subParts.a(2131568434, this.f3183b, obj2);
        return null;
    }

    public final boolean m3034a(Object obj) {
        return m3030a((ReactionUnitComponentNode) obj);
    }

    @Inject
    public VideoHomeTagsPartDefinition(TextOrHiddenPartDefinition textOrHiddenPartDefinition) {
        this.f3183b = textOrHiddenPartDefinition;
    }

    public static boolean m3030a(ReactionUnitComponentNode reactionUnitComponentNode) {
        return (reactionUnitComponentNode == null || reactionUnitComponentNode.b == null || reactionUnitComponentNode.b.W().isEmpty()) ? false : true;
    }

    public static VideoHomeTagsPartDefinition m3029a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeTagsPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3182d) {
                VideoHomeTagsPartDefinition videoHomeTagsPartDefinition;
                if (a2 != null) {
                    videoHomeTagsPartDefinition = (VideoHomeTagsPartDefinition) a2.a(f3182d);
                } else {
                    videoHomeTagsPartDefinition = f3181c;
                }
                if (videoHomeTagsPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3031b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3182d, b3);
                        } else {
                            f3181c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeTagsPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<View> m3032a() {
        return f3180a;
    }
}
