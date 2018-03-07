package com.facebook.video.watchandshop;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLVideoAnnotation;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: shouldShowToSeller */
public class WatchAndShopProductItemPartDefinition<E extends AnyEnvironment> extends BaseSinglePartDefinitionWithViewType<WatchAndShopProductItemViewModel, State, E, WatchAndShopProductItemView> {
    public static final ViewType<WatchAndShopProductItemView> f3456a = new C03181();
    private static WatchAndShopProductItemPartDefinition f3457c;
    private static final Object f3458d = new Object();
    private final DefaultFeedUnitRenderer f3459b;

    /* compiled from: shouldShowToSeller */
    final class C03181 extends ViewType<WatchAndShopProductItemView> {
        C03181() {
        }

        public final View m3268a(Context context) {
            return new WatchAndShopProductItemView(context);
        }
    }

    /* compiled from: shouldShowToSeller */
    public class State {
        @Nullable
        public final OnClickListener f3455a;

        public State(OnClickListener onClickListener) {
            this.f3455a = onClickListener;
        }
    }

    private static WatchAndShopProductItemPartDefinition m3270b(InjectorLike injectorLike) {
        return new WatchAndShopProductItemPartDefinition(DefaultFeedUnitRenderer.a(injectorLike));
    }

    public final Object m3272a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        OnClickListener onClickListener;
        WatchAndShopProductItemViewModel watchAndShopProductItemViewModel = (WatchAndShopProductItemViewModel) obj;
        GraphQLStoryActionLink a = ActionLinkHelper.a((GraphQLStoryAttachment) watchAndShopProductItemViewModel.f3466b.a, -508788748);
        if (a == null) {
            onClickListener = null;
        } else {
            onClickListener = this.f3459b.a(watchAndShopProductItemViewModel.f3466b, a);
        }
        return new State(onClickListener);
    }

    public final /* bridge */ /* synthetic */ void m3273a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 501104831);
        State state = (State) obj2;
        WatchAndShopProductItemView watchAndShopProductItemView = (WatchAndShopProductItemView) view;
        GraphQLVideoAnnotation graphQLVideoAnnotation = (GraphQLVideoAnnotation) ((WatchAndShopProductItemViewModel) obj).f3465a.a;
        watchAndShopProductItemView.f3462b.setText(graphQLVideoAnnotation.n());
        watchAndShopProductItemView.f3463c.setText(graphQLVideoAnnotation.m());
        watchAndShopProductItemView.f3464d.a(Uri.parse(graphQLVideoAnnotation.j()), WatchAndShopProductItemView.f3460e);
        watchAndShopProductItemView.setOnClickListener(state.f3455a);
        Logger.a(8, EntryType.MARK_POP, -1464330165, a);
    }

    public final void m3274b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((WatchAndShopProductItemView) view).setOnClickListener(null);
    }

    public final ViewType<WatchAndShopProductItemView> m3271a() {
        return f3456a;
    }

    @Inject
    public WatchAndShopProductItemPartDefinition(DefaultFeedUnitRenderer defaultFeedUnitRenderer) {
        this.f3459b = defaultFeedUnitRenderer;
    }

    public static WatchAndShopProductItemPartDefinition m3269a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            WatchAndShopProductItemPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3458d) {
                WatchAndShopProductItemPartDefinition watchAndShopProductItemPartDefinition;
                if (a2 != null) {
                    watchAndShopProductItemPartDefinition = (WatchAndShopProductItemPartDefinition) a2.a(f3458d);
                } else {
                    watchAndShopProductItemPartDefinition = f3457c;
                }
                if (watchAndShopProductItemPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3270b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3458d, b3);
                        } else {
                            f3457c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = watchAndShopProductItemPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
