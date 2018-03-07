package com.facebook.view.inflation.inflaters;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.view.inflation.utils.ParseUtils;
import com.facebook.view.inflation.utils.ViewIdentifier;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: location_opt_in_notifications_failed */
public class InflaterFactory {
    private static volatile InflaterFactory f9795n;
    private final TextViewInflater f9796a;
    private final UrlImageInflater f9797b;
    private final FractionalRatingBarInflater f9798c;
    private final FrameLayoutInflater f9799d;
    private final RelativeLayoutInflater f9800e;
    private final LinearLayoutInflater f9801f;
    public final ViewIdentifier f9802g;
    private final ButtonInflater f9803h;
    private final ViewInflaterImpl f9804i;
    private final ImageViewInflater f9805j;
    private final ImageButtonInflater f9806k;
    private final ViewStubInflater f9807l;
    private final ScrollViewInflater f9808m;

    /* compiled from: location_opt_in_notifications_failed */
    enum Views {
        TEXT_VIEW("TextView"),
        URL_IMAGE_OLD("com.facebook.widget.UrlImage"),
        URL_IMAGE("com.facebook.widget.images.UrlImage"),
        RATING_BAR_OLD("com.facebook.nearby.ui.FractionalRatingBar"),
        RATING_BAR("com.facebook.widget.ratingbar.FractionalRatingBar"),
        FRAME_LAYOUT("FrameLayout"),
        RELATIVE_LAYOUT("RelativeLayout"),
        LINEAR_LAYOUT("LinearLayout"),
        BUTTON("Button"),
        VIEW("View"),
        IMAGE_VIEW("ImageView"),
        IMAGE_BUTTON("ImageButton"),
        VIEW_STUB("ViewStub"),
        SCROLL_VIEW("ScrollView");
        
        private final String mValue;

        private Views(String str) {
            this.mValue = str;
        }

        public static Views from(String str) {
            for (Views views : values()) {
                if (views.mValue.equals(str)) {
                    return views;
                }
            }
            throw new IllegalArgumentException("unknown view = " + str);
        }
    }

    public static com.facebook.view.inflation.inflaters.InflaterFactory m11516a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9795n;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.view.inflation.inflaters.InflaterFactory.class;
        monitor-enter(r1);
        r0 = f9795n;	 Catch:{ all -> 0x003a }
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
        r0 = m11517b(r0);	 Catch:{ all -> 0x0035 }
        f9795n = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9795n;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.view.inflation.inflaters.InflaterFactory.a(com.facebook.inject.InjectorLike):com.facebook.view.inflation.inflaters.InflaterFactory");
    }

    private static InflaterFactory m11517b(InjectorLike injectorLike) {
        return new InflaterFactory(new ParseUtils(ResourcesMethodAutoProvider.a(injectorLike)), new ViewIdentifier());
    }

    @Inject
    public InflaterFactory(ParseUtils parseUtils, ViewIdentifier viewIdentifier) {
        this.f9802g = viewIdentifier;
        this.f9796a = new TextViewInflater(parseUtils, viewIdentifier);
        this.f9797b = new UrlImageInflater(parseUtils, viewIdentifier);
        this.f9798c = new FractionalRatingBarInflater(parseUtils, viewIdentifier);
        this.f9799d = new FrameLayoutInflater(parseUtils, viewIdentifier);
        this.f9800e = new RelativeLayoutInflater(parseUtils, viewIdentifier);
        this.f9801f = new LinearLayoutInflater(parseUtils, viewIdentifier);
        this.f9803h = new ButtonInflater(parseUtils, viewIdentifier);
        this.f9804i = new ViewInflaterImpl(parseUtils, viewIdentifier);
        this.f9805j = new ImageViewInflater(parseUtils, viewIdentifier);
        this.f9806k = new ImageButtonInflater(parseUtils, viewIdentifier);
        this.f9807l = new ViewStubInflater(parseUtils, viewIdentifier);
        this.f9808m = new ScrollViewInflater(parseUtils, viewIdentifier);
    }

    public final ViewInflater m11518a(String str) {
        switch (Views.from(str)) {
            case TEXT_VIEW:
                return this.f9796a;
            case URL_IMAGE_OLD:
            case URL_IMAGE:
                return this.f9797b;
            case RATING_BAR_OLD:
            case RATING_BAR:
                return this.f9798c;
            case FRAME_LAYOUT:
                return this.f9799d;
            case RELATIVE_LAYOUT:
                return this.f9800e;
            case LINEAR_LAYOUT:
                return this.f9801f;
            case BUTTON:
                return this.f9803h;
            case VIEW:
                return this.f9804i;
            case IMAGE_VIEW:
                return this.f9805j;
            case IMAGE_BUTTON:
                return this.f9806k;
            case VIEW_STUB:
                return this.f9807l;
            case SCROLL_VIEW:
                return this.f9808m;
            default:
                throw new IllegalStateException("unhandled view = " + str);
        }
    }
}
