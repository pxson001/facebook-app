package com.facebook.timeline.rows;

import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.HideableUnit;
import com.facebook.timeline.units.model.TimelineSectionData.LoadingIndicator;
import com.facebook.timeline.units.model.TimelineSectionData.NoStoriesMarker;
import com.facebook.timeline.units.model.TimelineSectionData.ScrollLoadTrigger;
import com.facebook.timeline.units.model.TimelineSectionData.SeeMore;
import com.facebook.timeline.units.model.TimelineSectionData.TimelineSectionLabel;
import javax.inject.Singleton;

@Singleton
/* compiled from: extra_show_full_width_themes */
public class TimelineViewTypeMapper {
    private static volatile TimelineViewTypeMapper f12631a;

    /* compiled from: extra_show_full_width_themes */
    public enum ViewTypes {
        UNKNOWN,
        STORY_BASE,
        STORY_EDGE_WIDE,
        STORY_EDGE_NARROW_OR_AGG,
        SCRUBBER,
        SEE_MORE,
        LOADING,
        NO_STORIES,
        HIDDEN_STORY,
        DELETED_STORY,
        PROMPT
    }

    public static com.facebook.timeline.rows.TimelineViewTypeMapper m12589a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f12631a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.timeline.rows.TimelineViewTypeMapper.class;
        monitor-enter(r1);
        r0 = f12631a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m12588a();	 Catch:{ all -> 0x0034 }
        f12631a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f12631a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.rows.TimelineViewTypeMapper.a(com.facebook.inject.InjectorLike):com.facebook.timeline.rows.TimelineViewTypeMapper");
    }

    private static TimelineViewTypeMapper m12588a() {
        return new TimelineViewTypeMapper();
    }

    public static ViewTypes m12587a(Object obj) {
        if (obj instanceof HideableUnit) {
            HideableUnit hideableUnit = (HideableUnit) obj;
            if (hideableUnit.o() != StoryVisibility.VISIBLE) {
                if (hideableUnit.o() == StoryVisibility.GONE || hideableUnit.o() == StoryVisibility.DISAPPEARING) {
                    return ViewTypes.DELETED_STORY;
                }
                return ViewTypes.HIDDEN_STORY;
            }
        }
        if (obj instanceof GraphQLStory) {
            GraphQLStory graphQLStory = (GraphQLStory) obj;
            int aD = graphQLStory.aD();
            Object obj2 = graphQLStory.L() != null ? 1 : null;
            if (aD > 0) {
                return ViewTypes.STORY_EDGE_NARROW_OR_AGG;
            }
            if (obj2 == null) {
                return ViewTypes.STORY_BASE;
            }
            if (graphQLStory.l() != null) {
                return ViewTypes.STORY_EDGE_NARROW_OR_AGG;
            }
            return ViewTypes.STORY_EDGE_WIDE;
        } else if ((obj instanceof TimelineSectionLabel) && ((TimelineSectionLabel) obj).m12736a() && !((TimelineSectionLabel) obj).f12787e) {
            return ViewTypes.LOADING;
        } else {
            if (obj instanceof TimelineSectionLabel) {
                return ViewTypes.SCRUBBER;
            }
            if (obj instanceof SeeMore) {
                return ViewTypes.SEE_MORE;
            }
            if ((obj instanceof LoadingIndicator) || (obj instanceof ScrollLoadTrigger)) {
                return ViewTypes.LOADING;
            }
            if (obj instanceof NoStoriesMarker) {
                return ViewTypes.NO_STORIES;
            }
            return ViewTypes.UNKNOWN;
        }
    }
}
