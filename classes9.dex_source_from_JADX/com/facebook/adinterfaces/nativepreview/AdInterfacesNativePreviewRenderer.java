package com.facebook.adinterfaces.nativepreview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.api.feed.data.FeedUnitDataController;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.impl.BaseFeedEnvironment;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.NewsFeedListType;
import com.facebook.feed.rows.NewsFeedRootGroupPartDefinition;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder.Builder;
import com.facebook.feed.rows.adapter.OneItemListItemCollection;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.util.composer.InlineCommentComposerCache;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: [applinks]url_clicked */
public class AdInterfacesNativePreviewRenderer {
    public static final LayoutParams f21818a = new LayoutParams(-1, -2);
    private static AdInterfacesNativePreviewRenderer f21819f;
    private static final Object f21820g = new Object();
    private final FeedUnitDataController f21821b;
    private final InlineCommentComposerCache f21822c;
    public final MultiRowAdapterBuilder f21823d;
    public final Lazy<NewsFeedRootGroupPartDefinition> f21824e;

    /* compiled from: [applinks]url_clicked */
    public class C25181 implements Runnable {
        final /* synthetic */ AdInterfacesNativePreviewRenderer f21814a;

        public C25181(AdInterfacesNativePreviewRenderer adInterfacesNativePreviewRenderer) {
            this.f21814a = adInterfacesNativePreviewRenderer;
        }

        public void run() {
        }
    }

    /* compiled from: [applinks]url_clicked */
    public class C25192 implements Delegate {
        final /* synthetic */ AdInterfacesNativePreviewRenderer f21815a;

        public C25192(AdInterfacesNativePreviewRenderer adInterfacesNativePreviewRenderer) {
            this.f21815a = adInterfacesNativePreviewRenderer;
        }

        public final void m22901a(HasScrollListenerSupportImpl hasScrollListenerSupportImpl) {
        }
    }

    /* compiled from: [applinks]url_clicked */
    public class LinearLayoutNoClick extends LinearLayout {
        private final boolean f21817a;

        public LinearLayoutNoClick(Context context, boolean z) {
            super(context);
            setOrientation(1);
            this.f21817a = z;
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (this.f21817a || motionEvent.getAction() == 1) {
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    private static AdInterfacesNativePreviewRenderer m22905b(InjectorLike injectorLike) {
        return new AdInterfacesNativePreviewRenderer(FeedUnitDataController.a(injectorLike), InlineCommentComposerCache.a(injectorLike), MultiRowAdapterBuilder.b(injectorLike), IdBasedLazy.a(injectorLike, 1480));
    }

    public static AdInterfacesNativePreviewRenderer m22904a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AdInterfacesNativePreviewRenderer b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21820g) {
                AdInterfacesNativePreviewRenderer adInterfacesNativePreviewRenderer;
                if (a2 != null) {
                    adInterfacesNativePreviewRenderer = (AdInterfacesNativePreviewRenderer) a2.a(f21820g);
                } else {
                    adInterfacesNativePreviewRenderer = f21819f;
                }
                if (adInterfacesNativePreviewRenderer == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m22905b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21820g, b3);
                        } else {
                            f21819f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = adInterfacesNativePreviewRenderer;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public AdInterfacesNativePreviewRenderer(FeedUnitDataController feedUnitDataController, InlineCommentComposerCache inlineCommentComposerCache, MultiRowAdapterBuilder multiRowAdapterBuilder, Lazy<NewsFeedRootGroupPartDefinition> lazy) {
        this.f21821b = feedUnitDataController;
        this.f21822c = inlineCommentComposerCache;
        this.f21823d = multiRowAdapterBuilder;
        this.f21824e = lazy;
    }

    public final void m22906a(ViewGroup viewGroup, FeedUnit feedUnit) {
        int i = 0;
        this.f21822c.a(feedUnit, null, Boolean.valueOf(false));
        this.f21821b.a(feedUnit).s = true;
        Context context = viewGroup.getContext();
        C25203 c25203 = new BaseFeedEnvironment(this, context, new C25181(this), new C25192(this)) {
            final /* synthetic */ AdInterfacesNativePreviewRenderer f21816m;

            public final FeedListType m22902c() {
                return NewsFeedListType.a;
            }

            public final BaseFeedStoryMenuHelper m22903e() {
                return null;
            }
        };
        OneItemListItemCollection oneItemListItemCollection = new OneItemListItemCollection();
        oneItemListItemCollection.a = feedUnit;
        Builder a = this.f21823d.a(this.f21824e, oneItemListItemCollection);
        a.f = c25203;
        MultiRowAdapter e = a.e();
        View linearLayoutNoClick = new LinearLayoutNoClick(context, false);
        int count = e.getCount() - 1;
        while (i < count) {
            linearLayoutNoClick.addView(e.getView(i, null, linearLayoutNoClick));
            i++;
        }
        View view = e.getView(count, null, linearLayoutNoClick);
        if (view != null) {
            View linearLayoutNoClick2 = new LinearLayoutNoClick(context, true);
            linearLayoutNoClick2.addView(view);
            linearLayoutNoClick2.setLayoutParams(f21818a);
            linearLayoutNoClick.addView(linearLayoutNoClick2);
        }
        linearLayoutNoClick.setLayoutParams(f21818a);
        viewGroup.addView(linearLayoutNoClick);
    }
}
