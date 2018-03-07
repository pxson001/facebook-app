package com.facebook.reaction.ui.uri;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriIntentBuilder.IUriTemplateIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.reaction.ReactionQueryParams;
import com.facebook.reaction.activity.ReactionDialogActivity;
import com.facebook.reaction.common.ReactionExperimentController;
import com.facebook.reaction.util.ReactionSurfaceUtil;
import com.facebook.search.intent.SearchResultsIntentBuilder;
import com.facebook.search.logging.api.SearchResultsSource;
import com.google.common.base.Strings;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: UnderlineStyleSingle */
public class ReactionUriIntentBuilder extends UriIntentBuilder {
    public static final String f21199a = ReactionUriIntentBuilder.class.getSimpleName();
    private static volatile ReactionUriIntentBuilder f21200e;
    public final ReactionExperimentController f21201b;
    public AbstractFbErrorReporter f21202c;
    public final Lazy<SearchResultsIntentBuilder> f21203d;

    /* compiled from: UnderlineStyleSingle */
    class ReactionDialogActivityIntentBuilder implements IUriTemplateIntentBuilder {
        final /* synthetic */ ReactionUriIntentBuilder f21197a;

        public ReactionDialogActivityIntentBuilder(ReactionUriIntentBuilder reactionUriIntentBuilder) {
            this.f21197a = reactionUriIntentBuilder;
        }

        @Nullable
        public final Intent m24818a(Context context, Bundle bundle) {
            Surface b = ReactionUriIntentBuilder.m24821b(bundle.getString("surface"));
            ReactionQueryParams reactionQueryParams = new ReactionQueryParams();
            reactionQueryParams.f18631l = Long.valueOf(Long.parseLong(bundle.getString("place_id")));
            return ReactionDialogActivity.m22800a(context, new Intent(), reactionQueryParams, b);
        }
    }

    /* compiled from: UnderlineStyleSingle */
    class ReactionPlaceFeedIntentBuilder implements IUriTemplateIntentBuilder {
        final /* synthetic */ ReactionUriIntentBuilder f21198a;

        public ReactionPlaceFeedIntentBuilder(ReactionUriIntentBuilder reactionUriIntentBuilder) {
            this.f21198a = reactionUriIntentBuilder;
        }

        @Nullable
        public final Intent m24819a(Context context, Bundle bundle) {
            Surface b = ReactionUriIntentBuilder.m24821b(bundle.getString("surface"));
            String string = bundle.getString("place_id");
            String string2 = bundle.getString("place_name");
            if (Strings.isNullOrEmpty(string) || Strings.isNullOrEmpty(string2)) {
                this.f21198a.f21202c.b(ReactionUriIntentBuilder.f21199a, "Trying to launch place feed via uri with an empty/null page id or name. Page id: " + string + "; page name: " + string2 + "; surface: " + b);
                return null;
            }
            Object obj;
            ReactionUriIntentBuilder reactionUriIntentBuilder = this.f21198a;
            if (ReactionSurfaceUtil.m4784k(b) && reactionUriIntentBuilder.f21201b.a.a(139, false)) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                return ((SearchResultsIntentBuilder) this.f21198a.f21203d.get()).a(string, string2, bundle.getString("ranking_data"), null, SearchResultsSource.q, b, null);
            }
            ReactionQueryParams reactionQueryParams = new ReactionQueryParams();
            reactionQueryParams.f18631l = Long.valueOf(Long.parseLong(bundle.getString("place_id")));
            return ReactionDialogActivity.m22800a(context, new Intent(), reactionQueryParams, b);
        }
    }

    public static com.facebook.reaction.ui.uri.ReactionUriIntentBuilder m24820a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f21200e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.ui.uri.ReactionUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f21200e;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m24822b(r0);	 Catch:{ all -> 0x0035 }
        f21200e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21200e;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.ui.uri.ReactionUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.reaction.ui.uri.ReactionUriIntentBuilder");
    }

    private static ReactionUriIntentBuilder m24822b(InjectorLike injectorLike) {
        return new ReactionUriIntentBuilder(ReactionExperimentController.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3375));
    }

    @Inject
    public ReactionUriIntentBuilder(ReactionExperimentController reactionExperimentController, FbErrorReporter fbErrorReporter, Lazy<SearchResultsIntentBuilder> lazy) {
        this.f21201b = reactionExperimentController;
        this.f21202c = fbErrorReporter;
        this.f21203d = lazy;
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.eb, "{place_id}", "{surface}", "{place_name}", "{ranking_data}"), new ReactionPlaceFeedIntentBuilder(this));
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.ea, "{place_id}", "{surface}", "{place_name}"), new ReactionPlaceFeedIntentBuilder(this));
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.eg, "{reaction_session_id}"), FragmentChromeActivity.class, ContentFragmentType.REACTION_DIALOG_FRAGMENT.ordinal(), null);
        if (BuildConstants.l) {
            a(StringFormatUtil.formatStrLocaleSafe(FBLinks.ec, "{place_id}"), new ReactionDialogActivityIntentBuilder(this));
        }
    }

    protected final boolean m24823a() {
        return true;
    }

    public static Surface m24821b(@Nullable String str) {
        if (Strings.isNullOrEmpty(str)) {
            return Surface.ANDROID_SEARCH_PLACE_TIPS;
        }
        try {
            return Surface.valueOf(str.toUpperCase(Locale.US));
        } catch (IllegalArgumentException e) {
            return Surface.ANDROID_SEARCH_PLACE_TIPS;
        }
    }
}
