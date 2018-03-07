package com.facebook.feedplugins.musicstory;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.musicstory.SimpleMusicStoryView.CardType;
import com.facebook.feedplugins.musicstory.SingleSongData.Builder;
import com.facebook.feedplugins.musicstory.SingleSongPartDefinition.Props;
import com.facebook.feedplugins.musicstory.utils.MusicStoryDataExtractor;
import com.facebook.feedplugins.musicstory.utils.MusicStoryLogger;
import com.facebook.feedplugins.musicstory.utils.MusicStoryLoggerProvider;
import com.facebook.feedplugins.musicstory.utils.MusicStoryLoggingParams;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: composer_keyboard */
public class SimpleMusicStoryPartDefinition<E extends HasPersistentState & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, SimpleMusicStoryView> {
    public static final ViewType f8199a = new C10231();
    private static SimpleMusicStoryPartDefinition f8200e;
    private static final Object f8201f = new Object();
    private final BackgroundPartDefinition f8202b;
    private final SingleSongPartDefinition f8203c;
    private final MusicStoryLoggerProvider f8204d;

    /* compiled from: composer_keyboard */
    final class C10231 extends ViewType {
        C10231() {
        }

        public final View m9187a(Context context) {
            return new SimpleMusicStoryView(context, CardType.SingleSong);
        }
    }

    private static SimpleMusicStoryPartDefinition m9190b(InjectorLike injectorLike) {
        return new SimpleMusicStoryPartDefinition((MusicStoryLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MusicStoryLoggerProvider.class), SingleSongPartDefinition.m9200a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m9192a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        String str;
        String str2;
        SingleSongData a;
        MusicStoryLogger a2;
        FeedProps feedProps = (FeedProps) obj;
        MusicStoryDataExtractor musicStoryDataExtractor = new MusicStoryDataExtractor(feedProps);
        Builder builder = new Builder(musicStoryDataExtractor.m9301a());
        builder.f8215b = musicStoryDataExtractor.m9303c();
        builder = builder;
        builder.f8218e = musicStoryDataExtractor.m9302b();
        builder = builder;
        builder.f8219f = musicStoryDataExtractor.m9304d();
        builder = builder;
        builder.f8223j = musicStoryDataExtractor.m9305e();
        builder = builder;
        builder.f8217d = musicStoryDataExtractor.m9306f();
        builder = builder;
        builder.f8216c = musicStoryDataExtractor.m9307g();
        builder = builder;
        builder.f8220g = musicStoryDataExtractor.m9308h();
        builder = builder;
        builder.f8221h = musicStoryDataExtractor.m9309i();
        builder = builder;
        builder.f8222i = musicStoryDataExtractor.m9310j();
        builder = builder;
        if (musicStoryDataExtractor.f8405e != null) {
            GraphQLNode x = musicStoryDataExtractor.f8405e.x();
            if (!(x == null || x.J().size() == 0)) {
                str = (String) x.J().get(0);
                str2 = str;
                builder.f8224k = str2 != null ? null : Uri.parse(str2);
                a = builder.m9195a();
                a2 = this.f8204d.m9318a(new MusicStoryLoggingParams(feedProps));
                subParts.a(this.f8202b, new StylingData(AttachmentProps.e(feedProps), PaddingStyle.a));
                subParts.a(this.f8203c, new Props(a, a2));
                return null;
            }
        }
        str = null;
        str2 = str;
        if (str2 != null) {
        }
        builder.f8224k = str2 != null ? null : Uri.parse(str2);
        a = builder.m9195a();
        a2 = this.f8204d.m9318a(new MusicStoryLoggingParams(feedProps));
        subParts.a(this.f8202b, new StylingData(AttachmentProps.e(feedProps), PaddingStyle.a));
        subParts.a(this.f8203c, new Props(a, a2));
        return null;
    }

    @Inject
    public SimpleMusicStoryPartDefinition(MusicStoryLoggerProvider musicStoryLoggerProvider, SingleSongPartDefinition singleSongPartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f8204d = musicStoryLoggerProvider;
        this.f8203c = singleSongPartDefinition;
        this.f8202b = backgroundPartDefinition;
    }

    public static SimpleMusicStoryPartDefinition m9188a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SimpleMusicStoryPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8201f) {
                SimpleMusicStoryPartDefinition simpleMusicStoryPartDefinition;
                if (a2 != null) {
                    simpleMusicStoryPartDefinition = (SimpleMusicStoryPartDefinition) a2.a(f8201f);
                } else {
                    simpleMusicStoryPartDefinition = f8200e;
                }
                if (simpleMusicStoryPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9190b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8201f, b3);
                        } else {
                            f8200e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = simpleMusicStoryPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m9191a() {
        return f8199a;
    }

    public static boolean m9189a(FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLNode z = ((GraphQLStoryAttachment) feedProps.a).z();
        return (z == null || z.j() == null || z.j().g() != -1221639264 || Strings.isNullOrEmpty(z.ad())) ? false : true;
    }
}
