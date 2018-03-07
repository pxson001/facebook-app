package com.facebook.feedplugins.games;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.AppInfo;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.autoplay.DefaultVideoAutoplayManager;
import com.facebook.feed.autoplay.VideoViewController;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentStyleInfo;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.quicksilver.QuicksilverActivity;
import com.facebook.ultralight.Inject;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.engine.VideoDataSource;
import com.facebook.video.engine.VideoDataSourceBuilder;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPlayerParamsBuilder;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.RichVideoPlayerParams.Builder;

@ContextScoped
/* compiled from: device_back */
public class QuicksilverContentAttachmentGroupPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, FeedEnvironment, QuicksilverAttachmentContainerView> {
    public static final ViewType f7647a = new C09721();
    private static Boolean f7648e;
    private static QuicksilverContentAttachmentGroupPartDefinition f7649f;
    private static final Object f7650g = new Object();
    public final DefaultVideoAutoplayManager<QuicksilverAttachmentContainerView> f7651b;
    public final SecureContextHelper f7652c;
    private final AppInfo f7653d;

    /* compiled from: device_back */
    final class C09721 extends ViewType {
        C09721() {
        }

        public final View m8854a(Context context) {
            return new QuicksilverAttachmentContainerView(context);
        }
    }

    /* compiled from: device_back */
    public class State {
        public final VideoViewController<QuicksilverAttachmentContainerView> f7643a;
        public final RichVideoPlayerParams f7644b;
        public final OnClickListener f7645c;
        public final String f7646d;

        public State(VideoViewController<QuicksilverAttachmentContainerView> videoViewController, RichVideoPlayerParams richVideoPlayerParams, OnClickListener onClickListener, String str) {
            this.f7643a = videoViewController;
            this.f7644b = richVideoPlayerParams;
            this.f7645c = onClickListener;
            this.f7646d = str;
        }
    }

    private static QuicksilverContentAttachmentGroupPartDefinition m8858b(InjectorLike injectorLike) {
        return new QuicksilverContentAttachmentGroupPartDefinition(AppInfo.a(injectorLike), DefaultVideoAutoplayManager.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    public final Object m8860a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        C09732 c09732;
        C09743 c09743;
        final GraphQLStoryAttachmentStyleInfo a = GraphQLStoryAttachmentUtil.a((GraphQLStoryAttachment) ((FeedProps) obj).a, -1194925813);
        if (a == null) {
            c09732 = null;
        } else {
            c09732 = new VideoViewController<QuicksilverAttachmentContainerView>(this, a.D()) {
                final /* synthetic */ QuicksilverContentAttachmentGroupPartDefinition f7639a;

                public final /* bridge */ /* synthetic */ void m8855a(Object obj) {
                }

                public final void m8856b(Object obj) {
                    ((QuicksilverAttachmentContainerView) obj).f7636a.a(EventTriggerType.BY_AUTOPLAY);
                }
            };
        }
        VideoViewController videoViewController = c09732;
        Uri uri = null;
        if (!(a == null || a.D() == null)) {
            uri = Uri.parse(a.D());
        }
        VideoDataSourceBuilder newBuilder = VideoDataSource.newBuilder();
        newBuilder.a = uri;
        VideoDataSourceBuilder videoDataSourceBuilder = newBuilder;
        videoDataSourceBuilder.f = StreamSourceType.FROM_CACHE;
        VideoPlayerParamsBuilder a2 = VideoPlayerParams.newBuilder().a(videoDataSourceBuilder.i());
        a2.g = true;
        a2 = a2;
        a2.n = true;
        a2 = a2;
        Builder builder = new Builder();
        builder.a = a2.m();
        RichVideoPlayerParams b = builder.a("VideoAspectRatioKey", Double.valueOf(1.875d)).b();
        if (a == null) {
            c09743 = null;
        } else {
            final SecureContextHelper secureContextHelper = this.f7652c;
            c09743 = new OnClickListener(this) {
                final /* synthetic */ QuicksilverContentAttachmentGroupPartDefinition f7642c;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1649997616);
                    Intent intent = new Intent(view.getContext(), QuicksilverActivity.class);
                    intent.putExtra("quicksilver_extra_game_url", a.y());
                    intent.putExtra("quicksilver_extra_app_id", a.z());
                    intent.putExtra("quicksilver_extra_splash_url", a.C());
                    secureContextHelper.a(intent, view.getContext());
                    Logger.a(2, EntryType.UI_INPUT_END, 634270123, a);
                }
            };
        }
        return new State(videoViewController, b, c09743, a.D());
    }

    public final /* bridge */ /* synthetic */ void m8861a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 435015226);
        State state = (State) obj2;
        QuicksilverAttachmentContainerView quicksilverAttachmentContainerView = (QuicksilverAttachmentContainerView) view;
        quicksilverAttachmentContainerView.m8853a(state.f7644b);
        quicksilverAttachmentContainerView.setOnClickListener(state.f7645c);
        this.f7651b.a(quicksilverAttachmentContainerView, state.f7643a);
        Logger.a(8, EntryType.MARK_POP, -981770750, a);
    }

    public final boolean m8862a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        if (f7648e == null) {
            int parseInt;
            f7648e = Boolean.valueOf(false);
            PackageInfo d = this.f7653d.d("com.google.android.webview", 0);
            if (!(d == null || d.versionName == null)) {
                String str = d.versionName;
                String[] split = d.versionName.split("\\.");
                if (split.length > 0) {
                    try {
                        parseInt = Integer.parseInt(split[0]);
                    } catch (NumberFormatException e) {
                    }
                    if (parseInt >= 36) {
                        f7648e = Boolean.valueOf(true);
                    }
                }
            }
            parseInt = 0;
            if (parseInt >= 36) {
                f7648e = Boolean.valueOf(true);
            }
        }
        if (f7648e.booleanValue()) {
            return GraphQLStoryAttachmentUtil.a((GraphQLStoryAttachment) feedProps.a(), GraphQLStoryAttachmentStyle.GAMES_INSTANT_PLAY);
        }
        return false;
    }

    public final void m8863b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        QuicksilverAttachmentContainerView quicksilverAttachmentContainerView = (QuicksilverAttachmentContainerView) view;
        quicksilverAttachmentContainerView.setOnClickListener(null);
        quicksilverAttachmentContainerView.f7636a.g();
    }

    public static QuicksilverContentAttachmentGroupPartDefinition m8857a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            QuicksilverContentAttachmentGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7650g) {
                QuicksilverContentAttachmentGroupPartDefinition quicksilverContentAttachmentGroupPartDefinition;
                if (a2 != null) {
                    quicksilverContentAttachmentGroupPartDefinition = (QuicksilverContentAttachmentGroupPartDefinition) a2.a(f7650g);
                } else {
                    quicksilverContentAttachmentGroupPartDefinition = f7649f;
                }
                if (quicksilverContentAttachmentGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8858b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7650g, b3);
                        } else {
                            f7649f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = quicksilverContentAttachmentGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    private QuicksilverContentAttachmentGroupPartDefinition(AppInfo appInfo, DefaultVideoAutoplayManager defaultVideoAutoplayManager, SecureContextHelper secureContextHelper) {
        this.f7653d = appInfo;
        this.f7651b = defaultVideoAutoplayManager;
        this.f7652c = secureContextHelper;
    }

    public final ViewType m8859a() {
        return f7647a;
    }
}
