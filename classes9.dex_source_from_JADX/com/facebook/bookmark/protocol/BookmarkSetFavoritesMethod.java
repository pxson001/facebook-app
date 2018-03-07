package com.facebook.bookmark.protocol;

import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.model.BookmarksGroup;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Singleton;
import org.apache.http.message.BasicNameValuePair;

@Singleton
/* compiled from: recipient_eligibility */
public class BookmarkSetFavoritesMethod implements ApiMethod<BookmarksGroup, Void> {
    private static volatile BookmarkSetFavoritesMethod f5676a;

    /* compiled from: recipient_eligibility */
    class C06041 implements Function<Bookmark, Long> {
        final /* synthetic */ BookmarkSetFavoritesMethod f5675a;

        C06041(BookmarkSetFavoritesMethod bookmarkSetFavoritesMethod) {
            this.f5675a = bookmarkSetFavoritesMethod;
        }

        public Object apply(Object obj) {
            return Long.valueOf(((Bookmark) obj).id);
        }
    }

    public static com.facebook.bookmark.protocol.BookmarkSetFavoritesMethod m5894a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5676a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.bookmark.protocol.BookmarkSetFavoritesMethod.class;
        monitor-enter(r1);
        r0 = f5676a;	 Catch:{ all -> 0x0039 }
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
        r0 = m5895b();	 Catch:{ all -> 0x0034 }
        f5676a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f5676a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.bookmark.protocol.BookmarkSetFavoritesMethod.a(com.facebook.inject.InjectorLike):com.facebook.bookmark.protocol.BookmarkSetFavoritesMethod");
    }

    private static BookmarkSetFavoritesMethod m5895b() {
        return new BookmarkSetFavoritesMethod();
    }

    public final ApiRequest m5896a(Object obj) {
        BookmarksGroup bookmarksGroup = (BookmarksGroup) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("ids", Joiner.on(',').join(Iterables.a(bookmarksGroup.m5883e(), new C06041(this)))));
        a.add(new BasicNameValuePair("format", "JSON"));
        return new ApiRequest("bookmarkSetFavorites", "GET", "method/bookmarks.set", a, ApiResponseType.JSONPARSER);
    }

    public final Object m5897a(Object obj, ApiResponse apiResponse) {
        return null;
    }
}
