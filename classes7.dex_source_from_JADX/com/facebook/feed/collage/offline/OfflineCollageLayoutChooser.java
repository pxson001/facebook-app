package com.facebook.feed.collage.offline;

import com.facebook.feed.collage.offline.CollageLayoutModel.ActorType;
import com.facebook.feed.collage.offline.CollageLayoutModel.Builder;
import com.facebook.feed.collage.offline.CollageLayoutModel.GridItem;
import com.google.common.collect.ImmutableList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: snapshot_and_import_id_deleted */
public class OfflineCollageLayoutChooser {
    private static volatile OfflineCollageLayoutChooser f3658b;
    private final Map<Integer, ImmutableList<CollageLayoutModel>> f3659a = new HashMap();

    /* compiled from: snapshot_and_import_id_deleted */
    public interface Dimension {
        int mo174a();

        int mo175b();
    }

    public static com.facebook.feed.collage.offline.OfflineCollageLayoutChooser m4376a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f3658b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.feed.collage.offline.OfflineCollageLayoutChooser.class;
        monitor-enter(r1);
        r0 = f3658b;	 Catch:{ all -> 0x0039 }
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
        r0 = m4378b();	 Catch:{ all -> 0x0034 }
        f3658b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f3658b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.collage.offline.OfflineCollageLayoutChooser.a(com.facebook.inject.InjectorLike):com.facebook.feed.collage.offline.OfflineCollageLayoutChooser");
    }

    private static OfflineCollageLayoutChooser m4378b() {
        return new OfflineCollageLayoutChooser();
    }

    @Inject
    public OfflineCollageLayoutChooser() {
        m4377a();
    }

    public final <T extends Dimension> CollageLayoutModel m4379a(ImmutableList<T> immutableList) {
        CollageLayoutModel collageLayoutModel = null;
        float f = 0.0f;
        for (Entry entry : this.f3659a.entrySet()) {
            if (((Integer) entry.getKey()).intValue() <= immutableList.size()) {
                ImmutableList immutableList2 = (ImmutableList) entry.getValue();
                int size = immutableList2.size();
                int i = 0;
                while (i < size) {
                    CollageLayoutModel collageLayoutModel2;
                    float f2;
                    CollageLayoutModel collageLayoutModel3 = (CollageLayoutModel) immutableList2.get(i);
                    if (collageLayoutModel3.f3656a.contains(ActorType.USER)) {
                        float a = m4375a(collageLayoutModel3, immutableList);
                        if (collageLayoutModel == null || a > f) {
                            collageLayoutModel2 = collageLayoutModel3;
                            f2 = a;
                            i++;
                            collageLayoutModel = collageLayoutModel2;
                            f = f2;
                        }
                    }
                    f2 = f;
                    collageLayoutModel2 = collageLayoutModel;
                    i++;
                    collageLayoutModel = collageLayoutModel2;
                    f = f2;
                }
            }
        }
        return collageLayoutModel;
    }

    private static <T extends Dimension> float m4375a(CollageLayoutModel collageLayoutModel, ImmutableList<T> immutableList) {
        int size = collageLayoutModel.f3657b.size();
        int i = 0;
        float f = 0.0f;
        while (i < size) {
            float f2;
            float f3;
            float f4;
            GridItem gridItem = (GridItem) collageLayoutModel.f3657b.get(i);
            int a = ((Dimension) immutableList.get(i)).mo174a();
            int b = ((Dimension) immutableList.get(i)).mo175b();
            if (((float) (gridItem.f3654c * b)) / ((float) a) >= ((float) gridItem.f3655d)) {
                f2 = ((float) (gridItem.f3654c * b)) / ((float) a);
                f3 = (f2 - ((float) gridItem.f3655d)) / f2;
            } else if (((float) (gridItem.f3655d * a)) / ((float) b) >= ((float) gridItem.f3654c)) {
                f2 = (float) ((gridItem.f3655d * a) / b);
                f3 = (f2 - ((float) gridItem.f3654c)) / f2;
            } else {
                f3 = 0.0f;
            }
            f2 = f - (100.0f * f3);
            if (a == b) {
                f4 = f2 - (f3 * 5.0f);
            } else if (gridItem.f3654c > gridItem.f3655d) {
                if (a > b) {
                    f4 = (f3 * 25.0f) + f2;
                } else {
                    f4 = f2 - (f3 * 25.0f);
                }
            } else if (gridItem.f3654c < gridItem.f3655d) {
                if (a < b) {
                    f4 = (f3 * 25.0f) + f2;
                } else {
                    f4 = f2 - (f3 * 25.0f);
                }
            } else if (gridItem.f3654c == gridItem.f3655d) {
                f4 = f2 - (f3 * 5.0f);
            } else {
                f4 = f2;
            }
            i++;
            f = f4;
        }
        return ((float) (size * 200)) + f;
    }

    private void m4377a() {
        this.f3659a.put(Integer.valueOf(2), ImmutableList.of(new Builder(EnumSet.of(ActorType.USER, ActorType.PAGE)).m4369a(0, 0, 3, 3).m4369a(3, 0, 3, 3).m4370a(), new Builder(EnumSet.of(ActorType.USER, ActorType.PAGE)).m4369a(0, 0, 6, 3).m4369a(0, 3, 6, 3).m4370a(), new Builder(EnumSet.of(ActorType.USER, ActorType.PAGE)).m4369a(0, 0, 3, 6).m4369a(3, 0, 3, 6).m4370a(), new Builder(EnumSet.of(ActorType.USER)).m4369a(0, 0, 6, 2).m4369a(0, 2, 6, 2).m4370a()));
        this.f3659a.put(Integer.valueOf(3), ImmutableList.of(new Builder(EnumSet.of(ActorType.USER, ActorType.PAGE)).m4369a(0, 0, 6, 3).m4369a(0, 3, 3, 3).m4369a(3, 3, 3, 3).m4370a(), new Builder(EnumSet.of(ActorType.USER, ActorType.PAGE)).m4369a(0, 0, 3, 6).m4369a(3, 0, 3, 3).m4369a(3, 3, 3, 3).m4370a(), new Builder(EnumSet.of(ActorType.PAGE)).m4369a(0, 0, 2, 2).m4369a(2, 0, 2, 2).m4369a(4, 0, 2, 2).m4370a(), new Builder(EnumSet.of(ActorType.USER)).m4369a(0, 0, 6, 4).m4369a(0, 4, 3, 2).m4369a(3, 4, 3, 2).m4370a(), new Builder(EnumSet.of(ActorType.USER)).m4369a(0, 0, 4, 6).m4369a(4, 0, 2, 3).m4369a(4, 3, 2, 3).m4370a(), new Builder(EnumSet.of(ActorType.USER)).m4369a(0, 0, 6, 2).m4369a(0, 2, 6, 2).m4369a(0, 4, 6, 2).m4370a(), new Builder(EnumSet.of(ActorType.USER)).m4369a(0, 0, 2, 6).m4369a(2, 0, 2, 6).m4369a(4, 0, 2, 6).m4370a()));
        this.f3659a.put(Integer.valueOf(4), ImmutableList.of(new Builder(EnumSet.of(ActorType.USER, ActorType.PAGE)).m4369a(0, 0, 3, 3).m4369a(3, 0, 3, 3).m4369a(0, 3, 3, 3).m4369a(3, 3, 3, 3).m4370a(), new Builder(EnumSet.of(ActorType.USER, ActorType.PAGE)).m4369a(0, 0, 6, 4).m4369a(0, 4, 2, 2).m4369a(2, 4, 2, 2).m4369a(4, 4, 2, 2).m4370a(), new Builder(EnumSet.of(ActorType.USER, ActorType.PAGE)).m4369a(0, 0, 4, 6).m4369a(4, 0, 2, 2).m4369a(4, 2, 2, 2).m4369a(4, 4, 2, 2).m4370a()));
        this.f3659a.put(Integer.valueOf(5), ImmutableList.of(new Builder(EnumSet.of(ActorType.USER)).m4369a(0, 0, 3, 3).m4369a(0, 3, 3, 3).m4369a(3, 0, 3, 2).m4369a(3, 2, 3, 2).m4369a(3, 4, 3, 2).m4370a(), new Builder(EnumSet.of(ActorType.USER)).m4369a(0, 0, 3, 3).m4369a(3, 0, 3, 3).m4369a(0, 3, 2, 2).m4369a(2, 3, 2, 2).m4369a(4, 3, 2, 2).m4370a()));
    }
}
