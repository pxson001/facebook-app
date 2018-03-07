package com.facebook.feedplugins.musicstory.albums;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedplugins.musicstory.SimpleMusicStoryView;
import com.facebook.feedplugins.musicstory.SimpleMusicStoryView.CardType;
import com.facebook.feedplugins.musicstory.SingleSongData;
import com.facebook.feedplugins.musicstory.SingleSongPartDefinition;
import com.facebook.feedplugins.musicstory.albums.AlbumSharePartDefinition.PersistentAlbumState;
import com.facebook.feedplugins.musicstory.utils.MusicStoryLogger;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

@ContextScoped
/* compiled from: composer_get_titlebar_button_spec */
public class SimpleMusicStoryInHScrollPartDefinition<E extends HasPersistentState & HasPositionInformation, V extends SimpleMusicStoryView> extends MultiRowSinglePartDefinition<Props, Void, E, V> {
    public static final ViewType f8279a = new C10261();
    private static SimpleMusicStoryInHScrollPartDefinition f8280c;
    private static final Object f8281d = new Object();
    private final SingleSongPartDefinition f8282b;

    /* compiled from: composer_get_titlebar_button_spec */
    final class C10261 extends ViewType {
        C10261() {
        }

        public final View m9217a(Context context) {
            return new SimpleMusicStoryView(context, CardType.SongInAList);
        }
    }

    /* compiled from: composer_get_titlebar_button_spec */
    public class Props {
        public MusicStoryLogger f8275a;
        public SingleSongData f8276b;
        public PersistentAlbumState f8277c;
        public int f8278d;

        public Props(SingleSongData singleSongData, MusicStoryLogger musicStoryLogger, PersistentAlbumState persistentAlbumState, int i) {
            this.f8276b = (SingleSongData) Preconditions.checkNotNull(singleSongData);
            this.f8275a = (MusicStoryLogger) Preconditions.checkNotNull(musicStoryLogger);
            this.f8277c = (PersistentAlbumState) Preconditions.checkNotNull(persistentAlbumState);
            this.f8278d = i;
        }
    }

    private static SimpleMusicStoryInHScrollPartDefinition m9219b(InjectorLike injectorLike) {
        return new SimpleMusicStoryInHScrollPartDefinition(SingleSongPartDefinition.m9200a(injectorLike));
    }

    public final Object m9221a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.a(this.f8282b, new com.facebook.feedplugins.musicstory.SingleSongPartDefinition.Props(props.f8276b, props.f8275a, props.f8277c, props.f8278d));
        return null;
    }

    public static SimpleMusicStoryInHScrollPartDefinition m9218a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SimpleMusicStoryInHScrollPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8281d) {
                SimpleMusicStoryInHScrollPartDefinition simpleMusicStoryInHScrollPartDefinition;
                if (a2 != null) {
                    simpleMusicStoryInHScrollPartDefinition = (SimpleMusicStoryInHScrollPartDefinition) a2.a(f8281d);
                } else {
                    simpleMusicStoryInHScrollPartDefinition = f8280c;
                }
                if (simpleMusicStoryInHScrollPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9219b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8281d, b3);
                        } else {
                            f8280c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = simpleMusicStoryInHScrollPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SimpleMusicStoryInHScrollPartDefinition(SingleSongPartDefinition singleSongPartDefinition) {
        this.f8282b = singleSongPartDefinition;
    }

    public final boolean m9222a(Object obj) {
        return true;
    }

    public final ViewType<V> m9220a() {
        return f8279a;
    }
}
