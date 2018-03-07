package com.facebook.feedplugins.musicstory;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feedplugins.musicstory.albums.AlbumSharePartDefinition.PersistentAlbumState;
import com.facebook.feedplugins.musicstory.providers.MusicProvider;
import com.facebook.feedplugins.musicstory.providers.MusicProviderFactory;
import com.facebook.feedplugins.musicstory.utils.MusicStoryLogger;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.FbDraweeImageUriPartDefinition;
import com.facebook.multirow.parts.FbDraweeImageUriPartDefinition.UriContextData;
import com.facebook.multirow.parts.TextPartDefinition;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: composer_group_sale_post_intercept_accepted */
public class SingleSongPartDefinition<E extends HasInvalidate & HasPersistentState & HasPositionInformation> extends BaseSinglePartDefinition<Props, Void, E, SimpleMusicStoryView> {
    private static final CallerContext f8243a = CallerContext.a(SimpleMusicStoryView.class, "music_story_inline_card");
    private static SingleSongPartDefinition f8244i;
    private static final Object f8245j = new Object();
    private final Context f8246b;
    private final TextPartDefinition f8247c;
    private final FbDraweeImageUriPartDefinition f8248d;
    private final MusicPlaybackPartDefinition f8249e;
    private final MusicProviderPartDefinition f8250f;
    private final MusicProviderFactory f8251g;
    private final BlurredImagePartDefinition f8252h;

    @Immutable
    /* compiled from: composer_group_sale_post_intercept_accepted */
    public class PersistentState {
        public boolean f8236a;
    }

    @Immutable
    /* compiled from: composer_group_sale_post_intercept_accepted */
    public class Props {
        public final SingleSongData f8237a;
        public final MusicStoryLogger f8238b;
        @Nullable
        public final PersistentAlbumState f8239c;
        public final int f8240d;

        public Props(SingleSongData singleSongData, MusicStoryLogger musicStoryLogger) {
            this.f8237a = singleSongData;
            this.f8238b = musicStoryLogger;
            this.f8240d = 0;
            this.f8239c = null;
        }

        public Props(SingleSongData singleSongData, MusicStoryLogger musicStoryLogger, PersistentAlbumState persistentAlbumState, int i) {
            this.f8237a = singleSongData;
            this.f8238b = musicStoryLogger;
            this.f8239c = persistentAlbumState;
            this.f8240d = i;
        }
    }

    /* compiled from: composer_group_sale_post_intercept_accepted */
    public class SongSaveStateKey implements ContextStateKey<String, PersistentState> {
        private static final String f8241a = SingleSongPartDefinition.class.getName();
        private final String f8242b;

        public SongSaveStateKey(String str) {
            Preconditions.checkNotNull(str);
            this.f8242b = f8241a + str;
        }

        public final Object m9198a() {
            return new PersistentState();
        }

        public final Object m9199b() {
            return this.f8242b;
        }
    }

    private static SingleSongPartDefinition m9202b(InjectorLike injectorLike) {
        return new SingleSongPartDefinition((Context) injectorLike.getInstance(Context.class), MusicPlaybackPartDefinition.m9159a(injectorLike), MusicProviderPartDefinition.m9176a(injectorLike), (BlurredImagePartDefinitionProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(BlurredImagePartDefinitionProvider.class), MusicProviderFactory.m9276b(injectorLike), TextPartDefinition.a(injectorLike), FbDraweeImageUriPartDefinition.a(injectorLike));
    }

    public final Object m9203a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
        SingleSongData singleSongData = props.f8237a;
        UriContextData uriContextData = new UriContextData(singleSongData.f8229e.toString(), f8243a);
        subParts.a(2131567521, this.f8247c, singleSongData.f8225a);
        TextPartDefinition textPartDefinition = this.f8247c;
        StringBuilder stringBuilder = new StringBuilder(singleSongData.f8227c);
        if (!Strings.isNullOrEmpty(singleSongData.f8226b)) {
            if (!Strings.isNullOrEmpty(stringBuilder.toString())) {
                stringBuilder.append(" . ");
            }
            stringBuilder.append(singleSongData.f8226b);
        }
        subParts.a(2131567522, textPartDefinition, stringBuilder.toString());
        subParts.a(2131567523, this.f8247c, m9201a(singleSongData));
        subParts.a(2131567455, this.f8248d, uriContextData);
        subParts.a(this.f8252h, singleSongData.f8230f);
        subParts.a(this.f8249e, new com.facebook.feedplugins.musicstory.MusicPlaybackPartDefinition.Props(props.f8237a, props.f8238b, props.f8239c, props.f8240d));
        MusicProvider a = this.f8251g.m9277a(singleSongData, props.f8238b, hasInvalidate, (PersistentState) ((HasPersistentState) hasInvalidate).a(new SongSaveStateKey(props.f8237a.m9196g()), singleSongData));
        if (a != null) {
            subParts.a(2131567524, this.f8250f, a);
        }
        return null;
    }

    public static SingleSongPartDefinition m9200a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SingleSongPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8245j) {
                SingleSongPartDefinition singleSongPartDefinition;
                if (a2 != null) {
                    singleSongPartDefinition = (SingleSongPartDefinition) a2.a(f8245j);
                } else {
                    singleSongPartDefinition = f8244i;
                }
                if (singleSongPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9202b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8245j, b3);
                        } else {
                            f8244i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = singleSongPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SingleSongPartDefinition(Context context, MusicPlaybackPartDefinition musicPlaybackPartDefinition, MusicProviderPartDefinition musicProviderPartDefinition, BlurredImagePartDefinitionProvider blurredImagePartDefinitionProvider, MusicProviderFactory musicProviderFactory, TextPartDefinition textPartDefinition, FbDraweeImageUriPartDefinition fbDraweeImageUriPartDefinition) {
        this.f8246b = context;
        this.f8249e = musicPlaybackPartDefinition;
        this.f8250f = musicProviderPartDefinition;
        this.f8251g = musicProviderFactory;
        this.f8247c = textPartDefinition;
        this.f8248d = fbDraweeImageUriPartDefinition;
        this.f8252h = new BlurredImagePartDefinition(f8243a, FbDraweeControllerBuilder.b(blurredImagePartDefinitionProvider));
    }

    private String m9201a(SingleSongData singleSongData) {
        String str = "";
        if (Strings.isNullOrEmpty(singleSongData.f8228d)) {
            return str;
        }
        return this.f8246b.getResources().getString(2131242484, new Object[]{singleSongData.f8228d});
    }
}
