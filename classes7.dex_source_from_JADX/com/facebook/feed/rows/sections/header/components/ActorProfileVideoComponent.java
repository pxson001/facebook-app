package com.facebook.feed.rows.sections.header.components;

import android.net.Uri;
import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.ComponentLifecycle.MountType;
import com.facebook.components.ComponentsPools;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.Output;
import com.facebook.components.Size;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLActorUtil;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.engine.VideoDataSourceBuilder;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPlayerParamsBuilder;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.RichVideoPlayerParams;
import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* compiled from: Unrecognized Fragment ID */
public final class ActorProfileVideoComponent extends ComponentLifecycle {
    public static ActorProfileVideoComponent f21195b = null;
    public static final SynchronizedPool<Builder> f21196c = new SynchronizedPool(2);
    private final ActorProfileVideoComponentSpec f21197d = new ActorProfileVideoComponentSpec();

    /* compiled from: Unrecognized Fragment ID */
    public class Builder extends com.facebook.components.Component.Builder<ActorProfileVideoComponent> {
        private static String[] f21189b = new String[]{"primaryActor"};
        private static int f21190c = 1;
        public State f21191a;
        public BitSet f21192d = new BitSet(f21190c);

        public static void m24016a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f21191a = state;
            builder.f21192d.clear();
        }

        public final Component<ActorProfileVideoComponent> m24018d() {
            int i = 0;
            if (this.f21192d == null || this.f21192d.nextClearBit(0) >= f21190c) {
                State state = this.f21191a;
                m24017a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < f21190c) {
                if (!this.f21192d.get(i)) {
                    arrayList.add(f21189b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m24017a() {
            super.a();
            this.f21191a = null;
            ActorProfileVideoComponent.f21196c.a(this);
        }
    }

    /* compiled from: Unrecognized Fragment ID */
    public class State extends Component<ActorProfileVideoComponent> implements Cloneable {
        public GraphQLActor f21193a;
        RichVideoPlayerParams f21194b;

        public State() {
            super(ActorProfileVideoComponent.m24020j());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            State state = (State) obj;
            if (this.b == state.b) {
                return true;
            }
            if (this.f21193a != null) {
                if (this.f21193a.equals(state.f21193a)) {
                    return true;
                }
            } else if (state.f21193a == null) {
                return true;
            }
            return false;
        }

        protected final void m24019a(Component<ActorProfileVideoComponent> component) {
            this.f21194b = ((State) component).f21194b;
        }
    }

    private ActorProfileVideoComponent() {
    }

    public static synchronized ActorProfileVideoComponent m24020j() {
        ActorProfileVideoComponent actorProfileVideoComponent;
        synchronized (ActorProfileVideoComponent.class) {
            if (f21195b == null) {
                f21195b = new ActorProfileVideoComponent();
            }
            actorProfileVideoComponent = f21195b;
        }
        return actorProfileVideoComponent;
    }

    protected final void m24023c(ComponentContext componentContext, Component component) {
        State state = (State) component;
        Output c = ComponentsPools.c();
        GraphQLActor graphQLActor = state.f21193a;
        String d = GraphQLActorUtil.d(graphQLActor);
        VideoDataSourceBuilder videoDataSourceBuilder = new VideoDataSourceBuilder();
        videoDataSourceBuilder.a = Uri.parse(d);
        VideoDataSourceBuilder videoDataSourceBuilder2 = videoDataSourceBuilder;
        videoDataSourceBuilder2.f = StreamSourceType.FROM_STREAM;
        VideoPlayerParamsBuilder a = new VideoPlayerParamsBuilder().a(videoDataSourceBuilder2.i());
        a.g = true;
        VideoPlayerParams m = a.m();
        com.google.common.collect.ImmutableMap.Builder builder = new com.google.common.collect.ImmutableMap.Builder();
        builder.b("VideoAspectRatioKey", Double.valueOf(1.0d));
        String c2 = GraphQLActorUtil.c(graphQLActor);
        if (!Strings.isNullOrEmpty(c2)) {
            ImageRequest a2 = ImageRequest.a(Uri.parse(c2));
            if (a2 != null) {
                builder.b("CoverImageParamsKey", a2);
            }
        }
        com.facebook.video.player.RichVideoPlayerParams.Builder builder2 = new com.facebook.video.player.RichVideoPlayerParams.Builder();
        builder2.a = m;
        c.a = builder2.a(builder.b()).b();
        if (c.a != null) {
            state.f21194b = (RichVideoPlayerParams) c.a;
        }
        ComponentsPools.a(c);
    }

    protected final boolean m24024c() {
        return true;
    }

    protected final void m24021a(ComponentContext componentContext, InternalNode internalNode, int i, int i2, Size size, Component component) {
        ActorProfileVideoComponentSpec.m24031a(i, i2, size);
    }

    public final MountType m24026f() {
        return MountType.VIEW;
    }

    protected final Object m24025e(ComponentContext componentContext, Object obj, Component component) {
        return ActorProfileVideoComponentSpec.m24030a(componentContext, (RichVideoPlayer) obj, ((State) component).f21194b);
    }

    protected final void m24029h(ComponentContext componentContext, Object obj, Component component) {
        ((RichVideoPlayer) obj).b(EventTriggerType.BY_PLAYER);
    }

    protected final void m24028g(ComponentContext componentContext, Object obj, Component component) {
        ((RichVideoPlayer) obj).a(EventTriggerType.BY_PLAYER);
    }

    protected final void m24027f(ComponentContext componentContext, Object obj, Component component) {
        ((RichVideoPlayer) obj).g();
    }

    public final void m24022a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ ActorProfileVideoComponent f21188c;

                public void run() {
                    this.f21188c.a(eventHandler, obj);
                }
            }, 1154126127);
        }
    }
}
