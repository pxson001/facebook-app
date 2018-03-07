package com.facebook.feedplugins.facebookvoice;

import android.content.Context;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryHeader;
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
/* compiled from: Submit should only be clickable after a rating has been selected. */
public class PersonalHighlightHeaderDataPartDefinition extends BaseSinglePartDefinition<GraphQLStory, State, AnyEnvironment, FacebookVoiceHeaderView> {
    public static final CallerContext f23099a = CallerContext.a(PersonalHighlightHeaderDataPartDefinition.class, "native_newsfeed");
    private static PersonalHighlightHeaderDataPartDefinition f23100b;
    private static final Object f23101c = new Object();

    /* compiled from: Submit should only be clickable after a rating has been selected. */
    public final class State {
        public final String f23094a;
        public final CharSequence f23095b;
        public final GraphQLTextWithEntities f23096c;
        public final GraphQLImage f23097d;
        public final GraphQLImage f23098e;

        public State(String str, CharSequence charSequence, GraphQLTextWithEntities graphQLTextWithEntities, GraphQLImage graphQLImage, GraphQLImage graphQLImage2) {
            this.f23094a = str;
            this.f23095b = charSequence;
            this.f23096c = graphQLTextWithEntities;
            this.f23097d = graphQLImage;
            this.f23098e = graphQLImage2;
        }
    }

    private static PersonalHighlightHeaderDataPartDefinition m25532a() {
        return new PersonalHighlightHeaderDataPartDefinition();
    }

    public final Object m25534a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        CharSequence charSequence = null;
        GraphQLStoryHeader aA = ((GraphQLStory) obj).aA();
        String a = aA.o() != null ? aA.o().a() : null;
        if (aA.n() != null) {
            charSequence = aA.n().a();
        }
        return new State(a, charSequence, aA.k(), aA.j(), aA.l());
    }

    public final /* bridge */ /* synthetic */ void m25535a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1533978342);
        State state = (State) obj2;
        FacebookVoiceHeaderView facebookVoiceHeaderView = (FacebookVoiceHeaderView) view;
        facebookVoiceHeaderView.m25529a(state.f23097d, false, f23099a);
        facebookVoiceHeaderView.m25530a(state.f23094a, state.f23095b, state.f23096c);
        facebookVoiceHeaderView.m25528a(state.f23098e, f23099a);
        facebookVoiceHeaderView.f23092l.setVisibility(1 != 0 ? 0 : 8);
        Logger.a(8, EntryType.MARK_POP, -338392457, a);
    }

    public static PersonalHighlightHeaderDataPartDefinition m25533a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PersonalHighlightHeaderDataPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f23101c) {
                PersonalHighlightHeaderDataPartDefinition personalHighlightHeaderDataPartDefinition;
                if (a3 != null) {
                    personalHighlightHeaderDataPartDefinition = (PersonalHighlightHeaderDataPartDefinition) a3.a(f23101c);
                } else {
                    personalHighlightHeaderDataPartDefinition = f23100b;
                }
                if (personalHighlightHeaderDataPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m25532a();
                        if (a3 != null) {
                            a3.a(f23101c, a2);
                        } else {
                            f23100b = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = personalHighlightHeaderDataPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
