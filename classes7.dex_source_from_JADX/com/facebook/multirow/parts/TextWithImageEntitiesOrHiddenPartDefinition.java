package com.facebook.multirow.parts;

import android.content.Context;
import android.support.annotation.DimenRes;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.environment.HasContext;
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
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@ContextScoped
/* compiled from: notifications_view_all_message */
public class TextWithImageEntitiesOrHiddenPartDefinition<E extends HasContext> extends BaseSinglePartDefinition<Props, Float, E, TextWithEntitiesView> {
    private static TextWithImageEntitiesOrHiddenPartDefinition f7964a;
    private static final Object f7965b = new Object();

    @Immutable
    /* compiled from: notifications_view_all_message */
    public class Props {
        public final GraphQLTextWithEntities f7961a;
        @DimenRes
        public final int f7962b;
        public final int f7963c;

        public Props(GraphQLTextWithEntities graphQLTextWithEntities) {
            this(graphQLTextWithEntities, 0, 1);
        }

        public Props(GraphQLTextWithEntities graphQLTextWithEntities, @DimenRes int i, int i2) {
            this.f7961a = graphQLTextWithEntities;
            this.f7962b = i;
            this.f7963c = i2;
        }
    }

    private static TextWithImageEntitiesOrHiddenPartDefinition m9582a() {
        return new TextWithImageEntitiesOrHiddenPartDefinition();
    }

    public final Object m9584a(SubParts subParts, @Nullable Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        if (props == null || props.f7962b == 0) {
            return Float.valueOf(0.0f);
        }
        return Float.valueOf(hasContext.getContext().getResources().getDimension(props.f7962b));
    }

    public final /* bridge */ /* synthetic */ void m9585a(@Nullable Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 591361578);
        Props props = (Props) obj;
        Float f = (Float) obj2;
        TextWithEntitiesView textWithEntitiesView = (TextWithEntitiesView) view;
        GraphQLTextWithEntities graphQLTextWithEntities = props == null ? null : props.f7961a;
        if (graphQLTextWithEntities == null || (StringUtil.a(graphQLTextWithEntities.a()) && graphQLTextWithEntities.d().isEmpty())) {
            textWithEntitiesView.setVisibility(8);
        } else {
            textWithEntitiesView.setVisibility(0);
            textWithEntitiesView.m20238a(graphQLTextWithEntities, f.floatValue() > 0.0f ? f.floatValue() : textWithEntitiesView.getTextSize(), props.f7963c);
        }
        Logger.a(8, EntryType.MARK_POP, 1653240844, a);
    }

    public static TextWithImageEntitiesOrHiddenPartDefinition m9583a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TextWithImageEntitiesOrHiddenPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f7965b) {
                TextWithImageEntitiesOrHiddenPartDefinition textWithImageEntitiesOrHiddenPartDefinition;
                if (a3 != null) {
                    textWithImageEntitiesOrHiddenPartDefinition = (TextWithImageEntitiesOrHiddenPartDefinition) a3.a(f7965b);
                } else {
                    textWithImageEntitiesOrHiddenPartDefinition = f7964a;
                }
                if (textWithImageEntitiesOrHiddenPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m9582a();
                        if (a3 != null) {
                            a3.a(f7965b, a2);
                        } else {
                            f7964a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = textWithImageEntitiesOrHiddenPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
