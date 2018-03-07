package com.facebook.katana.ui.bookmark;

import android.content.Context;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.model.BookmarksGroup;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.user.model.User;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: weekly_post_reach */
public class DefaultBookmarkFactory {
    private static volatile DefaultBookmarkFactory f135o;
    public final Bookmark f136a = m145a(this.f149n.getString(2131236552), FBLinks.co);
    public final Bookmark f137b = m145a(this.f149n.getString(2131236551), FBLinks.bR);
    public final Bookmark f138c = m145a(this.f149n.getString(2131236561), FBLinks.bV);
    public final Bookmark f139d = m145a(this.f149n.getString(2131236562), FBLinks.eN);
    public final Bookmark f140e = m145a(this.f149n.getString(2131236549), FBLinks.cX);
    public final Bookmark f141f = m145a(this.f149n.getString(2131236550), FBLinks.cY);
    public final Bookmark f142g;
    public final Bookmark f143h;
    public final Bookmark f144i;
    public final Bookmark f145j;
    public final Bookmark f146k;
    public final Bookmark f147l;
    private final Provider<User> f148m;
    private final Context f149n;

    public static com.facebook.katana.ui.bookmark.DefaultBookmarkFactory m146a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f135o;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.katana.ui.bookmark.DefaultBookmarkFactory.class;
        monitor-enter(r1);
        r0 = f135o;	 Catch:{ all -> 0x003a }
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
        r0 = m147b(r0);	 Catch:{ all -> 0x0035 }
        f135o = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f135o;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.ui.bookmark.DefaultBookmarkFactory.a(com.facebook.inject.InjectorLike):com.facebook.katana.ui.bookmark.DefaultBookmarkFactory");
    }

    private static DefaultBookmarkFactory m147b(InjectorLike injectorLike) {
        return new DefaultBookmarkFactory((Context) injectorLike.getInstance(Context.class), IdBasedProvider.a(injectorLike, 3595), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike));
    }

    private static Bookmark m145a(String str, String str2) {
        return new Bookmark(-1, str, str2, 0, null, null, "app", null);
    }

    @Inject
    public DefaultBookmarkFactory(Context context, Provider<User> provider, Boolean bool) {
        this.f148m = provider;
        this.f149n = context;
        this.f142g = m145a(this.f149n.getString(2131234233), bool.booleanValue() ? FBLinks.cE : FBLinks.cD);
        this.f143h = m145a(this.f149n.getString(2131236469), FBLinks.cq);
        this.f144i = m145a(this.f149n.getString(2131236563), FBLinks.cF);
        this.f145j = m145a(this.f149n.getString(2131236564), bool.booleanValue() ? FBLinks.cH : FBLinks.cG);
        this.f146k = m145a(this.f149n.getString(2131232455), FBLinks.cV);
        this.f147l = m145a(this.f149n.getString(2131236548), FBLinks.cW);
    }

    public final Bookmark m149a() {
        User user = (User) this.f148m.get();
        if (user == null) {
            return null;
        }
        return m145a(this.f149n.getString(2131236554), StringFormatUtil.formatStrLocaleSafe(FBLinks.bc, user.a));
    }

    private Bookmark m148c() {
        String k;
        String x;
        String str = (String) this.f149n.getText(2131236547);
        User user = (User) this.f148m.get();
        if (user != null) {
            k = user.k();
            x = user.x();
        } else {
            x = null;
            k = str;
        }
        return new Bookmark(-1, k, FBLinks.cm, 0, null, x, "profile", null);
    }

    public final List<BookmarksGroup> m150b() {
        List<BookmarksGroup> a = Lists.a();
        a.add(new BookmarksGroup("profile", this.f149n.getString(2131236547), 1, Lists.a(new Bookmark[]{m148c()})));
        return a;
    }
}
