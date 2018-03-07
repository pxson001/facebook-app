package com.facebook.reaction.action;

import android.graphics.drawable.Drawable;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.graphql.enums.GraphQLReactionStoryActionStyle;
import com.facebook.inject.InjectorLike;
import java.util.EnumMap;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: brandingImageParams */
public class ReactionActionIconMapper {
    private static volatile ReactionActionIconMapper f18773c;
    private final GlyphColorizer f18774a;
    private final EnumMap<GraphQLReactionStoryActionStyle, Integer> f18775b = new EnumMap(GraphQLReactionStoryActionStyle.class);

    public static com.facebook.reaction.action.ReactionActionIconMapper m22679a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f18773c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.action.ReactionActionIconMapper.class;
        monitor-enter(r1);
        r0 = f18773c;	 Catch:{ all -> 0x003a }
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
        r0 = m22680b(r0);	 Catch:{ all -> 0x0035 }
        f18773c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f18773c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.action.ReactionActionIconMapper.a(com.facebook.inject.InjectorLike):com.facebook.reaction.action.ReactionActionIconMapper");
    }

    private static ReactionActionIconMapper m22680b(InjectorLike injectorLike) {
        return new ReactionActionIconMapper(GlyphColorizer.a(injectorLike));
    }

    @Inject
    public ReactionActionIconMapper(GlyphColorizer glyphColorizer) {
        this.f18774a = glyphColorizer;
        this.f18775b.put(GraphQLReactionStoryActionStyle.HIDE_EVENT_SUGGESTION, Integer.valueOf(2130839920));
        this.f18775b.put(GraphQLReactionStoryActionStyle.OPEN_VERTICAL_ACTION_SHEET, Integer.valueOf(2130843587));
        this.f18775b.put(GraphQLReactionStoryActionStyle.PROMOTE_PAGE, Integer.valueOf(2130839982));
        this.f18775b.put(GraphQLReactionStoryActionStyle.PUBLISH_PAGE_POST, Integer.valueOf(2130838211));
        this.f18775b.put(GraphQLReactionStoryActionStyle.SAVE_OG_OBJECT, Integer.valueOf(2130839719));
        this.f18775b.put(GraphQLReactionStoryActionStyle.SHARE_EVENT, Integer.valueOf(2130840097));
        this.f18775b.put(GraphQLReactionStoryActionStyle.SHARE_OG_OBJECT, Integer.valueOf(2130840097));
        this.f18775b.put(GraphQLReactionStoryActionStyle.VIEW_PAGE_MORE_MENU, Integer.valueOf(2130843587));
        this.f18775b.put(GraphQLReactionStoryActionStyle.VIEW_PAGE_SETTINGS, Integer.valueOf(2130843344));
    }

    @Nullable
    public final Drawable m22681a(GraphQLReactionStoryActionStyle graphQLReactionStoryActionStyle) {
        return m22682a(graphQLReactionStoryActionStyle, -7235677);
    }

    @Nullable
    public final Drawable m22682a(GraphQLReactionStoryActionStyle graphQLReactionStoryActionStyle, int i) {
        return this.f18775b.containsKey(graphQLReactionStoryActionStyle) ? this.f18774a.a(((Integer) this.f18775b.get(graphQLReactionStoryActionStyle)).intValue(), i) : null;
    }
}
