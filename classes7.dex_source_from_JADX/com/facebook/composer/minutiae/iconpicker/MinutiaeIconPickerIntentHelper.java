package com.facebook.composer.minutiae.iconpicker;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeIcon;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: toggle_count */
public class MinutiaeIconPickerIntentHelper {
    private static volatile MinutiaeIconPickerIntentHelper f1552a;

    public static com.facebook.composer.minutiae.iconpicker.MinutiaeIconPickerIntentHelper m1603a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1552a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.composer.minutiae.iconpicker.MinutiaeIconPickerIntentHelper.class;
        monitor-enter(r1);
        r0 = f1552a;	 Catch:{ all -> 0x0039 }
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
        r0 = m1602a();	 Catch:{ all -> 0x0034 }
        f1552a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f1552a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.minutiae.iconpicker.MinutiaeIconPickerIntentHelper.a(com.facebook.inject.InjectorLike):com.facebook.composer.minutiae.iconpicker.MinutiaeIconPickerIntentHelper");
    }

    private static MinutiaeIconPickerIntentHelper m1602a() {
        return new MinutiaeIconPickerIntentHelper();
    }

    public final Intent m1604a(Context context, MinutiaeObject minutiaeObject, @Nullable ImmutableList<? extends MinutiaeIcon> immutableList) {
        boolean z;
        if ((immutableList == null || immutableList.isEmpty()) && (minutiaeObject.verb.s() == null || minutiaeObject.verb.s().a() <= 0)) {
            z = false;
        } else {
            z = true;
        }
        return z ? m1601a(context, minutiaeObject, immutableList, false) : null;
    }

    public static Intent m1601a(Context context, MinutiaeObject minutiaeObject, @Nullable ImmutableList<? extends MinutiaeIcon> immutableList, boolean z) {
        Intent intent = new Intent(context, MinutiaeIconPickerActivity.class);
        intent.putExtra("minutiae_object", (Parcelable) Preconditions.checkNotNull(minutiaeObject));
        if (!(immutableList == null || immutableList.isEmpty())) {
            FlatBufferModelHelper.a(intent, "icons", Lists.a((Iterable) Preconditions.checkNotNull(immutableList)));
        }
        intent.putExtra("is_skippable", z);
        return intent;
    }
}
