package com.facebook.groups.feed.ui;

import android.content.ComponentName;
import android.content.Intent;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: TimelineActionBar.bindModel */
public class GroupsFeedIntentBuilder {
    private static volatile GroupsFeedIntentBuilder f22158b;
    private final Provider<ComponentName> f22159a;

    public static com.facebook.groups.feed.ui.GroupsFeedIntentBuilder m23295a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f22158b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.groups.feed.ui.GroupsFeedIntentBuilder.class;
        monitor-enter(r1);
        r0 = f22158b;	 Catch:{ all -> 0x003a }
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
        r0 = m23296b(r0);	 Catch:{ all -> 0x0035 }
        f22158b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f22158b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.ui.GroupsFeedIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.groups.feed.ui.GroupsFeedIntentBuilder");
    }

    private static GroupsFeedIntentBuilder m23296b(InjectorLike injectorLike) {
        return new GroupsFeedIntentBuilder(IdBasedProvider.a(injectorLike, 12));
    }

    @Inject
    public GroupsFeedIntentBuilder(@FragmentChromeActivity Provider<ComponentName> provider) {
        this.f22159a = provider;
    }

    private Intent m23294a() {
        return new Intent().setComponent((ComponentName) this.f22159a.get());
    }

    public final Intent m23297a(FetchGroupInformationModel fetchGroupInformationModel) {
        Intent a = m23294a();
        a.putExtra("target_fragment", ContentFragmentType.GROUPS_PINNED_POSTS_FRAGMENT.ordinal());
        FlatBufferModelHelper.a(a, "group_feed_model", fetchGroupInformationModel);
        a.putExtra("group_feed_id", fetchGroupInformationModel.gW_());
        return a;
    }

    public final Intent m23298b(FetchGroupInformationModel fetchGroupInformationModel) {
        Intent a = m23294a();
        a.putExtra("target_fragment", ContentFragmentType.GROUPS_YOUR_POSTS_FRAGMENT.ordinal());
        FlatBufferModelHelper.a(a, "group_feed_model", fetchGroupInformationModel);
        a.putExtra("group_feed_id", fetchGroupInformationModel.gW_());
        return a;
    }

    public final Intent m23299c(FetchGroupInformationModel fetchGroupInformationModel) {
        Intent a = m23294a();
        a.putExtra("target_fragment", ContentFragmentType.GROUPS_FOR_SALE_POSTS_FRAGMENT.ordinal());
        FlatBufferModelHelper.a(a, "group_feed_model", fetchGroupInformationModel);
        a.putExtra("group_feed_id", fetchGroupInformationModel.gW_());
        return a;
    }

    public final Intent m23300d(FetchGroupInformationModel fetchGroupInformationModel) {
        Intent a = m23294a();
        a.putExtra("target_fragment", ContentFragmentType.GROUP_MEMBER_REQUESTS_FRAGMENT.ordinal());
        FlatBufferModelHelper.a(a, "group_feed_model", fetchGroupInformationModel);
        a.putExtra("group_feed_id", fetchGroupInformationModel.gW_());
        a.putExtra("group_request_member_header_visible", false);
        return a;
    }

    public final Intent m23301e(FetchGroupInformationModel fetchGroupInformationModel) {
        Intent a = m23294a();
        a.putExtra("target_fragment", ContentFragmentType.GROUP_PENDING_POSTS_FRAGMENT.ordinal());
        FlatBufferModelHelper.a(a, "group_feed_model", fetchGroupInformationModel);
        a.putExtra("group_feed_id", fetchGroupInformationModel.gW_());
        return a;
    }
}
