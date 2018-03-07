package com.facebook.feedplugins.richmedia;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.autoplay.DefaultVideoAutoplayManager;
import com.facebook.feed.autoplay.VideoViewController;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.graphql.model.GraphQLStory;
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
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: bundle_wall_load_finished */
public class RichMediaVideoAutoplayPartDefinition<V extends View> extends BaseSinglePartDefinition<Props, VideoViewController, HasPersistentState, V> {
    private static RichMediaVideoAutoplayPartDefinition f9240b;
    private static final Object f9241c = new Object();
    public final DefaultVideoAutoplayManager<V> f9242a;

    @Immutable
    /* compiled from: bundle_wall_load_finished */
    public final class Props {
        public String f9238a;
        public GraphQLStory f9239b;

        public Props(String str, GraphQLStory graphQLStory) {
            this.f9238a = str;
            this.f9239b = graphQLStory;
        }
    }

    private static RichMediaVideoAutoplayPartDefinition m9884b(InjectorLike injectorLike) {
        return new RichMediaVideoAutoplayPartDefinition(DefaultVideoAutoplayManager.a(injectorLike));
    }

    public final Object m9885a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        return new RichMediaVideoController(props.f9238a, (RichMediaStoryPersistentState) ((HasPersistentState) anyEnvironment).a(new RichMediaStoryKey(props.f9239b), props.f9239b));
    }

    public final /* bridge */ /* synthetic */ void m9886a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -656687810);
        this.f9242a.a(view, (VideoViewController) obj2);
        Logger.a(8, EntryType.MARK_POP, 1713138486, a);
    }

    @Inject
    public RichMediaVideoAutoplayPartDefinition(DefaultVideoAutoplayManager defaultVideoAutoplayManager) {
        this.f9242a = defaultVideoAutoplayManager;
    }

    public static RichMediaVideoAutoplayPartDefinition m9883a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RichMediaVideoAutoplayPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9241c) {
                RichMediaVideoAutoplayPartDefinition richMediaVideoAutoplayPartDefinition;
                if (a2 != null) {
                    richMediaVideoAutoplayPartDefinition = (RichMediaVideoAutoplayPartDefinition) a2.a(f9241c);
                } else {
                    richMediaVideoAutoplayPartDefinition = f9240b;
                }
                if (richMediaVideoAutoplayPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9884b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9241c, b3);
                        } else {
                            f9240b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = richMediaVideoAutoplayPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
