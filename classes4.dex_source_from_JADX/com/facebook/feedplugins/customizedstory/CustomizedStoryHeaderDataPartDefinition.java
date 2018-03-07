package com.facebook.feedplugins.customizedstory;

import android.content.Context;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feedplugins.facebookvoice.FacebookVoiceHeaderView;
import com.facebook.graphql.model.GraphQLCustomizedStory;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;

@ContextScoped
/* compiled from: presence_staleness */
public class CustomizedStoryHeaderDataPartDefinition extends BaseSinglePartDefinition<GraphQLCustomizedStory, State, AnyEnvironment, FacebookVoiceHeaderView> {
    public static final CallerContext f4267a = CallerContext.a(CustomizedStoryHeaderFbVoicePartDefinition.class, "native_newsfeed");
    private static CustomizedStoryHeaderDataPartDefinition f4268b;
    private static final Object f4269c = new Object();

    private static CustomizedStoryHeaderDataPartDefinition m4803a() {
        return new CustomizedStoryHeaderDataPartDefinition();
    }

    public final Object m4805a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        String str;
        CharSequence charSequence;
        GraphQLImage graphQLImage;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLCustomizedStory graphQLCustomizedStory = (GraphQLCustomizedStory) obj;
        GraphQLImage graphQLImage2 = null;
        if (graphQLCustomizedStory == null || graphQLCustomizedStory.I() == null) {
            str = "";
            charSequence = "";
            graphQLImage = null;
            graphQLTextWithEntities = null;
        } else {
            String str2;
            if (graphQLCustomizedStory.I().o() == null) {
                str2 = "";
            } else {
                str2 = graphQLCustomizedStory.I().o().a();
            }
            if (graphQLCustomizedStory.I().n() == null) {
                str = "";
            } else {
                str = graphQLCustomizedStory.I().n().a();
            }
            graphQLTextWithEntities = graphQLCustomizedStory.I().k();
            graphQLImage = graphQLCustomizedStory.I().j();
            graphQLImage2 = graphQLCustomizedStory.I().l();
            Object obj2 = str;
            str = str2;
        }
        return new State(str, charSequence, graphQLTextWithEntities, graphQLImage, graphQLImage2);
    }

    public final /* bridge */ /* synthetic */ void m4806a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -447751583);
        State state = (State) obj2;
        FacebookVoiceHeaderView facebookVoiceHeaderView = (FacebookVoiceHeaderView) view;
        facebookVoiceHeaderView.setMenuButtonActive(true);
        facebookVoiceHeaderView.a(state.d, true, f4267a);
        facebookVoiceHeaderView.a(state.a, state.b, state.c);
        facebookVoiceHeaderView.a(state.e, f4267a);
        Logger.a(8, EntryType.MARK_POP, -1626074323, a);
    }

    public static CustomizedStoryHeaderDataPartDefinition m4804a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CustomizedStoryHeaderDataPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f4269c) {
                CustomizedStoryHeaderDataPartDefinition customizedStoryHeaderDataPartDefinition;
                if (a3 != null) {
                    customizedStoryHeaderDataPartDefinition = (CustomizedStoryHeaderDataPartDefinition) a3.a(f4269c);
                } else {
                    customizedStoryHeaderDataPartDefinition = f4268b;
                }
                if (customizedStoryHeaderDataPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m4803a();
                        if (a3 != null) {
                            a3.a(f4269c, a2);
                        } else {
                            f4268b = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = customizedStoryHeaderDataPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
