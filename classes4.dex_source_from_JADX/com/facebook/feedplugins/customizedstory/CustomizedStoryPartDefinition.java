package com.facebook.feedplugins.customizedstory;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.attachments.AttachmentsPartDefinition;
import com.facebook.graphql.model.GraphQLCustomizedStory;
import com.facebook.graphql.model.GraphQLStory$Builder;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: pressure */
public class CustomizedStoryPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLCustomizedStory>, Void, FeedEnvironment> {
    private static CustomizedStoryPartDefinition f4252d;
    private static final Object f4253e = new Object();
    private final CustomizedStoryFooterPartDefinition f4254a;
    private final AttachmentsPartDefinition f4255b;
    private final CustomizedStoryHeaderSelector f4256c;

    private static CustomizedStoryPartDefinition m4789b(InjectorLike injectorLike) {
        return new CustomizedStoryPartDefinition(CustomizedStoryHeaderSelector.m4793a(injectorLike), AttachmentsPartDefinition.a(injectorLike), CustomizedStoryFooterPartDefinition.m4813a(injectorLike));
    }

    public final Object m4790a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLCustomizedStory graphQLCustomizedStory = (GraphQLCustomizedStory) feedProps.a;
        baseMultiRowSubParts.a(this.f4256c, feedProps);
        AttachmentsPartDefinition attachmentsPartDefinition = this.f4255b;
        GraphQLStory$Builder graphQLStory$Builder = new GraphQLStory$Builder();
        graphQLStory$Builder.f3212o = graphQLCustomizedStory.g();
        graphQLStory$Builder = graphQLStory$Builder;
        graphQLStory$Builder.ay = graphQLCustomizedStory.M();
        graphQLStory$Builder = graphQLStory$Builder;
        graphQLStory$Builder.f3210m = graphQLCustomizedStory.u();
        graphQLStory$Builder = graphQLStory$Builder;
        graphQLStory$Builder.aC = graphQLCustomizedStory.k();
        baseMultiRowSubParts.a(attachmentsPartDefinition, FeedProps.c(graphQLStory$Builder.m3419a()));
        baseMultiRowSubParts.a(this.f4254a, graphQLCustomizedStory);
        return null;
    }

    @Inject
    public CustomizedStoryPartDefinition(CustomizedStoryHeaderSelector customizedStoryHeaderSelector, AttachmentsPartDefinition attachmentsPartDefinition, CustomizedStoryFooterPartDefinition customizedStoryFooterPartDefinition) {
        this.f4254a = customizedStoryFooterPartDefinition;
        this.f4255b = attachmentsPartDefinition;
        this.f4256c = customizedStoryHeaderSelector;
    }

    public static CustomizedStoryPartDefinition m4788a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CustomizedStoryPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4253e) {
                CustomizedStoryPartDefinition customizedStoryPartDefinition;
                if (a2 != null) {
                    customizedStoryPartDefinition = (CustomizedStoryPartDefinition) a2.a(f4253e);
                } else {
                    customizedStoryPartDefinition = f4252d;
                }
                if (customizedStoryPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m4789b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4253e, b3);
                        } else {
                            f4252d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = customizedStoryPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m4791a(com.facebook.feed.rows.core.props.FeedProps<com.facebook.graphql.model.GraphQLCustomizedStory> r4) {
        /*
        r3 = this;
        r2 = r4.a;
        r0 = r2;
        r0 = (com.facebook.graphql.model.GraphQLCustomizedStory) r0;
        if (r0 == 0) goto L_0x0023;
    L_0x0007:
        r1 = r0.I();
        if (r1 != 0) goto L_0x0021;
    L_0x000d:
        r2 = r0.u();
        if (r2 == 0) goto L_0x0025;
    L_0x0013:
        r2 = r0.u();
        r2 = r2.isEmpty();
        if (r2 != 0) goto L_0x0025;
    L_0x001d:
        r2 = 1;
    L_0x001e:
        r0 = r2;
        if (r0 == 0) goto L_0x0023;
    L_0x0021:
        r0 = 1;
    L_0x0022:
        return r0;
    L_0x0023:
        r0 = 0;
        goto L_0x0022;
    L_0x0025:
        r2 = 0;
        goto L_0x001e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedplugins.customizedstory.CustomizedStoryPartDefinition.a(com.facebook.feed.rows.core.props.FeedProps):boolean");
    }
}
