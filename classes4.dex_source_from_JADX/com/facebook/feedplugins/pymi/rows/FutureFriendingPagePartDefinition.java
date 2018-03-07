package com.facebook.feedplugins.pymi.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feedplugins.pymi.rows.FutureFriendingCredentialPartDefinition.Props;
import com.facebook.feedplugins.pymi.views.FutureFriendingPageView;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextPartDefinition;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: now_update */
public class FutureFriendingPagePartDefinition<E extends HasInvalidate & HasPersistentState> extends BaseSinglePartDefinitionWithViewType<Props, Void, E, FutureFriendingPageView> {
    public static final ViewType<FutureFriendingPageView> f6662a = new C03051();
    private static FutureFriendingPagePartDefinition f6663g;
    private static final Object f6664h = new Object();
    private final FutureFriendingBlacklistPartDefinition f6665b;
    private final FutureFriendingCredentialPartDefinition f6666c;
    private final FutureFriendingFriendPartDefinition<E> f6667d;
    private final FbObjectMapper f6668e;
    private final TextPartDefinition f6669f;

    /* compiled from: now_update */
    final class C03051 extends ViewType<FutureFriendingPageView> {
        C03051() {
        }

        public final View m7072a(Context context) {
            return new FutureFriendingPageView(context);
        }
    }

    private static FutureFriendingPagePartDefinition m7069b(InjectorLike injectorLike) {
        return new FutureFriendingPagePartDefinition(FutureFriendingBlacklistPartDefinition.a(injectorLike), FutureFriendingCredentialPartDefinition.a(injectorLike), FutureFriendingFriendPartDefinition.a(injectorLike), FbObjectMapperMethodAutoProvider.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m7071a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        boolean booleanValue = ((Boolean) ((HasPersistentState) ((HasInvalidate) anyEnvironment)).a(new FutureFriendingStateKey(props.b.g(), false), props.a)).booleanValue();
        String a = m7068a(props.b.k());
        subParts.a(2131562475, this.f6669f, props.b.j());
        subParts.a(2131562476, this.f6666c, new Props(props.b, booleanValue));
        subParts.a(2131562479, this.f6665b, new FutureFriendingBlacklistPartDefinition.Props(props.a, props.b, a, booleanValue));
        subParts.a(2131562480, this.f6667d, new FutureFriendingFriendPartDefinition.Props(props.a, props.b, props.c, a, booleanValue));
        return null;
    }

    public static FutureFriendingPagePartDefinition m7067a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FutureFriendingPagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6664h) {
                FutureFriendingPagePartDefinition futureFriendingPagePartDefinition;
                if (a2 != null) {
                    futureFriendingPagePartDefinition = (FutureFriendingPagePartDefinition) a2.a(f6664h);
                } else {
                    futureFriendingPagePartDefinition = f6663g;
                }
                if (futureFriendingPagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7069b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6664h, b3);
                        } else {
                            f6663g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = futureFriendingPagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public FutureFriendingPagePartDefinition(FutureFriendingBlacklistPartDefinition futureFriendingBlacklistPartDefinition, FutureFriendingCredentialPartDefinition futureFriendingCredentialPartDefinition, FutureFriendingFriendPartDefinition futureFriendingFriendPartDefinition, FbObjectMapper fbObjectMapper, TextPartDefinition textPartDefinition) {
        this.f6665b = futureFriendingBlacklistPartDefinition;
        this.f6666c = futureFriendingCredentialPartDefinition;
        this.f6667d = futureFriendingFriendPartDefinition;
        this.f6668e = fbObjectMapper;
        this.f6669f = textPartDefinition;
    }

    public final ViewType<FutureFriendingPageView> m7070a() {
        return f6662a;
    }

    @Nullable
    private String m7068a(String str) {
        String str2 = null;
        try {
            JsonNode a = this.f6668e.a(str);
            if (a.d("ego_id")) {
                str2 = a.f("ego_id").B();
            }
        } catch (IOException e) {
        }
        return str2;
    }
}
