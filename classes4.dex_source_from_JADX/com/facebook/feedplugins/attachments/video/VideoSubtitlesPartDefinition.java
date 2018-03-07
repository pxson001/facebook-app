package com.facebook.feedplugins.attachments.video;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.ui.fullscreenvideoplayer.SubtitlesRequestAPI;
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
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.video.player.VideoSubtitlesListener;
import com.facebook.video.settings.VideoPrefs;
import com.facebook.video.subtitles.controller.Subtitles;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: phase */
public class VideoSubtitlesPartDefinition<V extends View & VideoSubtitlesListener> extends BaseSinglePartDefinition<Props, State, AnyEnvironment, V> {
    private static VideoSubtitlesPartDefinition f5039c;
    private static final Object f5040d = new Object();
    public final SubtitlesRequestAPI f5041a;
    private final FbSharedPreferences f5042b;

    @Immutable
    /* compiled from: phase */
    public final class Props {
        public final String f5047a;
        public final ImmutableList<String> f5048b;

        public Props(String str, ImmutableList<String> immutableList) {
            this.f5047a = str;
            this.f5048b = immutableList;
        }
    }

    /* compiled from: phase */
    public final class State {
        public final String f5055a;
        public Subtitles f5056b;
        public VideoSubtitlesListener f5057c;

        public State(String str) {
            this.f5055a = str;
        }
    }

    private static VideoSubtitlesPartDefinition m5417b(InjectorLike injectorLike) {
        return new VideoSubtitlesPartDefinition(SubtitlesRequestAPI.m5421a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    public final Object m5418a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        String a = this.f5042b.a(VideoPrefs.k, "");
        State state = new State(a);
        if (props.f5048b != null && props.f5048b.contains(a)) {
            this.f5041a.m5423a(props.f5047a, state.f5055a, new 1(this, state));
        }
        return state;
    }

    public final /* bridge */ /* synthetic */ void m5419a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 292061851);
        m5416a((State) obj2, view);
        Logger.a(8, EntryType.MARK_POP, -1573110554, a);
    }

    public final void m5420b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((State) obj2).f5057c = null;
    }

    @Inject
    public VideoSubtitlesPartDefinition(SubtitlesRequestAPI subtitlesRequestAPI, FbSharedPreferences fbSharedPreferences) {
        this.f5041a = subtitlesRequestAPI;
        this.f5042b = fbSharedPreferences;
    }

    public static VideoSubtitlesPartDefinition m5415a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoSubtitlesPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5040d) {
                VideoSubtitlesPartDefinition videoSubtitlesPartDefinition;
                if (a2 != null) {
                    videoSubtitlesPartDefinition = (VideoSubtitlesPartDefinition) a2.a(f5040d);
                } else {
                    videoSubtitlesPartDefinition = f5039c;
                }
                if (videoSubtitlesPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5417b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5040d, b3);
                        } else {
                            f5039c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoSubtitlesPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private static void m5416a(State state, V v) {
        ((VideoSubtitlesListener) v).mo362a(state.f5056b);
        state.f5057c = (VideoSubtitlesListener) v;
    }
}
