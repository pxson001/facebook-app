package com.facebook.feedplugins.saved.rows.ui;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.autoplay.DefaultVideoAutoplayManager;
import com.facebook.feed.autoplay.VideoViewController;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feedplugins.attachments.video.InlineVideoPersistentState;
import com.facebook.feedplugins.attachments.video.InlineVideoStoryKey;
import com.facebook.graphql.model.interfaces.CacheableEntity;
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
/* compiled from: bundle_collection_single */
public class SavedCollectionItemInlineVideoAutoplayPartDefinition<E extends HasPersistentState, V extends View> extends BaseSinglePartDefinition<Props, State, E, V> {
    private static SavedCollectionItemInlineVideoAutoplayPartDefinition f9345b;
    private static final Object f9346c = new Object();
    public final DefaultVideoAutoplayManager<V> f9347a;

    @Immutable
    /* compiled from: bundle_collection_single */
    public final class Props {
        public final InlineVideoStoryKey f9340a;
        public final CacheableEntity f9341b;
        public final String f9342c;

        public Props(InlineVideoStoryKey inlineVideoStoryKey, CacheableEntity cacheableEntity, String str) {
            this.f9340a = inlineVideoStoryKey;
            this.f9341b = cacheableEntity;
            this.f9342c = str;
        }
    }

    /* compiled from: bundle_collection_single */
    public class State {
        public final InlineVideoPersistentState f9343a;
        public final VideoViewController f9344b;

        public State(InlineVideoPersistentState inlineVideoPersistentState, VideoViewController videoViewController) {
            this.f9343a = inlineVideoPersistentState;
            this.f9344b = videoViewController;
        }
    }

    private static SavedCollectionItemInlineVideoAutoplayPartDefinition m9953b(InjectorLike injectorLike) {
        return new SavedCollectionItemInlineVideoAutoplayPartDefinition(DefaultVideoAutoplayManager.a(injectorLike));
    }

    public final Object m9954a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        InlineVideoPersistentState inlineVideoPersistentState = (InlineVideoPersistentState) ((HasPersistentState) anyEnvironment).a(props.f9340a, props.f9341b);
        return new State(inlineVideoPersistentState, new SavedCollectionItemInlineVideoController(props.f9342c, inlineVideoPersistentState));
    }

    public final /* bridge */ /* synthetic */ void m9955a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 349358587);
        this.f9347a.a(view, ((State) obj2).f9344b);
        Logger.a(8, EntryType.MARK_POP, 537737595, a);
    }

    public static SavedCollectionItemInlineVideoAutoplayPartDefinition m9952a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SavedCollectionItemInlineVideoAutoplayPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9346c) {
                SavedCollectionItemInlineVideoAutoplayPartDefinition savedCollectionItemInlineVideoAutoplayPartDefinition;
                if (a2 != null) {
                    savedCollectionItemInlineVideoAutoplayPartDefinition = (SavedCollectionItemInlineVideoAutoplayPartDefinition) a2.a(f9346c);
                } else {
                    savedCollectionItemInlineVideoAutoplayPartDefinition = f9345b;
                }
                if (savedCollectionItemInlineVideoAutoplayPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9953b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9346c, b3);
                        } else {
                            f9345b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = savedCollectionItemInlineVideoAutoplayPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SavedCollectionItemInlineVideoAutoplayPartDefinition(DefaultVideoAutoplayManager defaultVideoAutoplayManager) {
        this.f9347a = defaultVideoAutoplayManager;
    }
}
