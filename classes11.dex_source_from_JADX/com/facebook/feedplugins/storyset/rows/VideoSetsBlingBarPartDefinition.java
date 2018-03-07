package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import android.widget.TextView;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.model.GraphQLHelper;
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
import com.facebook.story.GraphQLStoryHelper;
import javax.inject.Inject;

@ContextScoped
/* compiled from: audience_educator_controller_no_educator_data */
public class VideoSetsBlingBarPartDefinition extends BaseSinglePartDefinition<GraphQLStory, Void, AnyEnvironment, TextView> {
    private static VideoSetsBlingBarPartDefinition f9790d;
    private static final Object f9791e = new Object();
    private final Context f9792a;
    private final NumberTruncationUtil f9793b;
    private final TextPartDefinition f9794c;

    private static VideoSetsBlingBarPartDefinition m10222b(InjectorLike injectorLike) {
        return new VideoSetsBlingBarPartDefinition((Context) injectorLike.getInstance(Context.class), NumberTruncationUtil.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m10223a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLStory graphQLStory = (GraphQLStory) obj;
        StringBuilder stringBuilder = new StringBuilder();
        int m = GraphQLHelper.m(graphQLStory.l());
        if (m != 0) {
            stringBuilder.append(m10221a(m, 2131689647));
        }
        int e = GraphQLStoryHelper.e(graphQLStory);
        if (!(m == 0 || e == 0)) {
            stringBuilder.append("  ");
        }
        if (e != 0) {
            stringBuilder.append(m10221a(e, 2131689644));
        }
        subParts.a(this.f9794c, stringBuilder.toString());
        return null;
    }

    @Inject
    public VideoSetsBlingBarPartDefinition(Context context, NumberTruncationUtil numberTruncationUtil, TextPartDefinition textPartDefinition) {
        this.f9792a = context;
        this.f9793b = numberTruncationUtil;
        this.f9794c = textPartDefinition;
    }

    public static VideoSetsBlingBarPartDefinition m10220a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoSetsBlingBarPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9791e) {
                VideoSetsBlingBarPartDefinition videoSetsBlingBarPartDefinition;
                if (a2 != null) {
                    videoSetsBlingBarPartDefinition = (VideoSetsBlingBarPartDefinition) a2.a(f9791e);
                } else {
                    videoSetsBlingBarPartDefinition = f9790d;
                }
                if (videoSetsBlingBarPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10222b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9791e, b3);
                        } else {
                            f9790d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoSetsBlingBarPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private String m10221a(int i, int i2) {
        String a = this.f9793b.a(i);
        if (i <= 0 || i2 <= 0) {
            return a;
        }
        return this.f9792a.getResources().getQuantityString(i2, i, new Object[]{a});
    }
}
