package com.facebook.ipc.feed;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.fragmentconstants.FragmentConstants$ContentFragmentType;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.content.FacebookOnlyIntentActionFactory;
import com.facebook.feedback.abtest.InlineReplyExpansionExperimentUtil;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.facebook.intent.internal.InternalIntentSigner;
import com.facebook.katana.intent.Fb4aInternalIntentSigner;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.base.Throwables;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: souvenirs */
public class ViewPermalinkIntentFactory {
    private static volatile ViewPermalinkIntentFactory f4266f;
    public final String f4267a;
    private final ObjectMapper f4268b;
    public InternalIntentSigner f4269c;
    private AbstractFbErrorReporter f4270d;
    public InlineReplyExpansionExperimentUtil f4271e;

    public static com.facebook.ipc.feed.ViewPermalinkIntentFactory m7896a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f4266f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.ipc.feed.ViewPermalinkIntentFactory.class;
        monitor-enter(r1);
        r0 = f4266f;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m7898b(r0);	 Catch:{ all -> 0x0035 }
        f4266f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4266f;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ipc.feed.ViewPermalinkIntentFactory.a(com.facebook.inject.InjectorLike):com.facebook.ipc.feed.ViewPermalinkIntentFactory");
    }

    private static ViewPermalinkIntentFactory m7898b(InjectorLike injectorLike) {
        return new ViewPermalinkIntentFactory(FacebookOnlyIntentActionFactory.m4495a(injectorLike), FbObjectMapperMethodAutoProvider.m6609a(injectorLike), Fb4aInternalIntentSigner.m7903a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), InlineReplyExpansionExperimentUtil.m7911a(injectorLike));
    }

    @Inject
    public ViewPermalinkIntentFactory(FacebookOnlyIntentActionFactory facebookOnlyIntentActionFactory, ObjectMapper objectMapper, InternalIntentSigner internalIntentSigner, AbstractFbErrorReporter abstractFbErrorReporter, InlineReplyExpansionExperimentUtil inlineReplyExpansionExperimentUtil) {
        this.f4268b = (ObjectMapper) Preconditions.checkNotNull(objectMapper);
        this.f4269c = internalIntentSigner;
        this.f4270d = abstractFbErrorReporter;
        this.f4271e = inlineReplyExpansionExperimentUtil;
        this.f4267a = facebookOnlyIntentActionFactory.m4497a("VIEW_PERMALINK");
    }

    public final Intent m7901a(ViewPermalinkParams viewPermalinkParams) {
        return m7895a(null, viewPermalinkParams);
    }

    public final Intent m7900a(PermalinkStoryIdParams permalinkStoryIdParams) {
        return m7899a(null, permalinkStoryIdParams);
    }

    private Intent m7895a(@Nullable ComponentName componentName, ViewPermalinkParams viewPermalinkParams) {
        Intent intent;
        if (componentName == null) {
            intent = new Intent(this.f4267a);
        } else {
            intent = new Intent().setComponent(componentName);
        }
        intent.putExtras(m7897b(viewPermalinkParams));
        this.f4269c.mo1178a(intent);
        return intent;
    }

    public final Intent m7899a(@Nullable ComponentName componentName, PermalinkStoryIdParams permalinkStoryIdParams) {
        Intent intent;
        if (componentName == null) {
            intent = new Intent(this.f4267a);
        } else {
            intent = new Intent().setComponent(componentName);
        }
        Bundle bundle = new Bundle();
        bundle.putString("extra_permalink_param_type", StoryPermalinkParamsType.NOTIF_STORY_ID_KEY.name());
        bundle.putString("story_cache_id", permalinkStoryIdParams.b);
        bundle.putString("story_id", permalinkStoryIdParams.a);
        bundle.putBoolean("include_comments_disabled_fields", permalinkStoryIdParams.i());
        bundle.putBoolean("show_keyboard_on_first_load", permalinkStoryIdParams.m());
        if (permalinkStoryIdParams.h != null) {
            bundle.putString("default_comment_ordering", permalinkStoryIdParams.h.toString());
            if (permalinkStoryIdParams.f != null) {
                bundle.putString("story_fbid", permalinkStoryIdParams.f);
            }
            if (permalinkStoryIdParams.e != null) {
                bundle.putString("relevant_comment_id", permalinkStoryIdParams.e);
                FlatBufferModelHelper.a(bundle, "relevant_comment", permalinkStoryIdParams.l);
            }
        }
        FragmentConstants$ContentFragmentType fragmentConstants$ContentFragmentType = FragmentConstants$ContentFragmentType.NATIVE_PERMALINK_PAGE_FRAGMENT;
        if (!(permalinkStoryIdParams.c == null || permalinkStoryIdParams.d == null)) {
            FlatBufferModelHelper.a(bundle, "comment", permalinkStoryIdParams.k);
            bundle.putString("comment_id", permalinkStoryIdParams.c);
            bundle.putString("feedback_id", permalinkStoryIdParams.d);
            if (!this.f4271e.m7914b()) {
                fragmentConstants$ContentFragmentType = FragmentConstants$ContentFragmentType.COMMENT_PERMALINK_FRAGMENT;
            }
        }
        bundle.putInt("target_fragment", fragmentConstants$ContentFragmentType.ordinal());
        if (permalinkStoryIdParams.g != null) {
            bundle.putString("group_id", permalinkStoryIdParams.g);
        }
        if (permalinkStoryIdParams.j != null) {
            bundle.putString("notification_source", permalinkStoryIdParams.j.name());
        }
        bundle.putInt("relevant_reaction_key", permalinkStoryIdParams.n);
        intent.putExtras(bundle);
        this.f4269c.mo1178a(intent);
        return intent;
    }

    private Bundle m7897b(ViewPermalinkParams viewPermalinkParams) {
        Bundle bundle = new Bundle();
        Object a = viewPermalinkParams.a();
        String str;
        if (viewPermalinkParams.b()) {
            try {
                if (a instanceof GraphQLStory) {
                    GraphQLStory graphQLStory = (GraphQLStory) a;
                    String name = StoryPermalinkParamsType.AD_PREVIEW_STORY_JSON.name();
                    String h = GraphQLHelper.m22508h(graphQLStory);
                    if (h != null) {
                        bundle.putString("default_comment_ordering", h);
                        bundle.putString("story_fbid", Strings.nullToEmpty(graphQLStory.ai()));
                    }
                    str = name;
                } else if (!(a instanceof GraphQLPYMLWithLargeImageFeedUnit)) {
                    return bundle;
                } else {
                    str = StoryPermalinkParamsType.AD_PREVIEW_PYML_JSON.name();
                }
                bundle.putString("extra_permalink_param_type", str);
                bundle.putString("permalink_story", this.f4268b.m6659a(a));
            } catch (Throwable e) {
                throw Throwables.propagate(e);
            }
        } else if (a instanceof GraphQLStory) {
            a = (GraphQLStory) a;
            if (a.m22350c() != null) {
                bundle.putString("extra_permalink_param_type", StoryPermalinkParamsType.FEED_STORY_ID_KEY.name());
                bundle.putString("story_cache_id", a.mo2507g());
                bundle.putString("story_id", a.m22350c());
            } else if (a.mo2507g() != null || a.mo2890l() == null || a.mo2890l().mo2933j() == null) {
                try {
                    bundle.putString("extra_permalink_param_type", StoryPermalinkParamsType.FEED_STORY_JSON.name());
                    bundle.putString("permalink_story", this.f4268b.m6659a(a));
                } catch (Throwable e2) {
                    throw Throwables.propagate(e2);
                }
            } else {
                bundle.putString("extra_permalink_param_type", StoryPermalinkParamsType.PLATFORM_KEY.name());
                bundle.putString("extra_platform_id", a.mo2890l().mo2933j());
                bundle.putString("extra_fallback_url", "");
            }
            str = GraphQLHelper.m22508h((GraphQLStory) a);
            if (str != null) {
                bundle.putString("default_comment_ordering", str);
                bundle.putString("story_fbid", Strings.nullToEmpty(a.ai()));
            }
            bundle.putBoolean("include_comments_disabled_fields", GraphQLHelper.m22510i((GraphQLStory) a));
        } else {
            this.f4270d.m2340a(ViewPermalinkIntentFactory.class.getName(), "Permalink only supports GraphQLStory outside of an ad preview");
            return bundle;
        }
        bundle.putBoolean("use_photo_mode", viewPermalinkParams.d());
        if (viewPermalinkParams.d()) {
            bundle.putInt("title_bar_background_color_id", 2131362145);
            bundle.putInt("fragment_background_color_id", 2131362145);
        }
        bundle.putInt("target_fragment", FragmentConstants$ContentFragmentType.NATIVE_PERMALINK_PAGE_FRAGMENT.ordinal());
        return bundle;
    }

    public final boolean m7902a(Intent intent) {
        return intent.getAction() != null && intent.getAction().equals(this.f4267a);
    }
}
