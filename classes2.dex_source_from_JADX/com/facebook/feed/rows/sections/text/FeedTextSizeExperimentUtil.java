package com.facebook.feed.rows.sections.text;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.util.Pair;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.textcachewarmer.FbTextLayoutCacheWarmer;
import com.facebook.fbui.widget.text.layoutbuilder.TextLayoutBuilder;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.friendsharing.text.abtest.ExperimentsForTextAbTestModule;
import com.facebook.friendsharing.text.abtest.FeedTextSizeExperimentHelper;
import com.facebook.friendsharing.text.abtest.FeedTextSizeExperimentHelper.Configuration;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.HashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: home_stories_client_sort_key_index */
public class FeedTextSizeExperimentUtil {
    private static FeedTextSizeExperimentUtil f20949f;
    private static final Object f20950g = new Object();
    public final Context f20951a;
    private final QeAccessor f20952b;
    public final FbTextLayoutCacheWarmer f20953c;
    private final FeedTextSizeExperimentHelper f20954d;
    private final HashMap<Configuration, Pair<TextLayoutBuilder, PaddingStyle>> f20955e = new HashMap();

    private static FeedTextSizeExperimentUtil m28678b(InjectorLike injectorLike) {
        return new FeedTextSizeExperimentUtil((Context) injectorLike.getInstance(Context.class), QeInternalImplMethodAutoProvider.m3744a(injectorLike), FbTextLayoutCacheWarmer.m28443a(injectorLike), FeedTextSizeExperimentHelper.m28684a(injectorLike));
    }

    @Inject
    public FeedTextSizeExperimentUtil(Context context, QeAccessor qeAccessor, FbTextLayoutCacheWarmer fbTextLayoutCacheWarmer, FeedTextSizeExperimentHelper feedTextSizeExperimentHelper) {
        this.f20951a = context;
        this.f20952b = qeAccessor;
        this.f20953c = fbTextLayoutCacheWarmer;
        this.f20954d = feedTextSizeExperimentHelper;
    }

    public final boolean m28680a(GraphQLStory graphQLStory) {
        return this.f20954d.m28692a(graphQLStory);
    }

    public final Pair<TextLayoutBuilder, PaddingStyle> m28681b(GraphQLStory graphQLStory) {
        Configuration b = this.f20954d.m28693b(graphQLStory);
        if (!this.f20955e.containsKey(b)) {
            HashMap hashMap = this.f20955e;
            int i = b.b;
            int i2 = b.g;
            String str = b.e;
            TextLayoutBuilder a = TextLayoutBuilderUtil.m28585a(this.f20951a, this.f20953c);
            int a2 = m28679a();
            if (a2 != 0) {
                a.m28606c(this.f20951a.getResources().getColor(a2));
            }
            if (m28673a(str) != null) {
                a.m28595a(Typeface.create("sans-serif-light", 0));
            }
            a2 = m28677b(i);
            if (a2 != -1) {
                a.m28604b(this.f20951a.getResources().getDimensionPixelSize(a2));
            }
            if (i2 != -1) {
                a.m28597a(m28674a(i2));
            }
            hashMap.put(b, Pair.create(a, m28676a(b.d, b.c)));
        }
        return (Pair) this.f20955e.get(b);
    }

    public static FeedTextSizeExperimentUtil m28675a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedTextSizeExperimentUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20950g) {
                FeedTextSizeExperimentUtil feedTextSizeExperimentUtil;
                if (a2 != null) {
                    feedTextSizeExperimentUtil = (FeedTextSizeExperimentUtil) a2.mo818a(f20950g);
                } else {
                    feedTextSizeExperimentUtil = f20949f;
                }
                if (feedTextSizeExperimentUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28678b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20950g, b3);
                        } else {
                            f20949f = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = feedTextSizeExperimentUtil;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Nullable
    public static Typeface m28673a(String str) {
        int i = -1;
        switch (str.hashCode()) {
            case 102970646:
                if (str.equals("light")) {
                    i = 0;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                return Typeface.create("sans-serif-light", 0);
            default:
                return null;
        }
    }

    public static Alignment m28674a(int i) {
        switch (i) {
            case 0:
                return Alignment.ALIGN_NORMAL;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return Alignment.ALIGN_CENTER;
            default:
                return Alignment.ALIGN_NORMAL;
        }
    }

    public static int m28677b(int i) {
        switch (i) {
            case HTTPTransportCallback.HEADER_BYTES_GENERATED /*16*/:
                return 2131427404;
            case 18:
                return 2131427406;
            case 20:
                return 2131427408;
            case 24:
                return 2131427410;
            case 26:
                return 2131427411;
            case 28:
                return 2131427412;
            case 30:
                return 2131427413;
            case HTTPTransportCallback.HEADER_BYTES_RECEIVED /*32*/:
                return 2131427414;
            case 36:
                return 2131427415;
            default:
                return -1;
        }
    }

    public static PaddingStyle m28676a(int i, int i2) {
        if (i == -1 && i2 == -1) {
            return PaddingStyle.f13075e;
        }
        float f;
        float f2;
        if (i == -1) {
            f = PaddingStyle.f13075e.f13089s.f13045b;
        } else {
            f = (float) i;
        }
        if (i2 == -1) {
            f2 = PaddingStyle.f13075e.f13089s.f13044a;
        } else {
            f2 = (float) i2;
        }
        Builder b = Builder.m19302b();
        b.f13067c = f;
        Builder builder = b;
        builder.f13066b = f2;
        return builder.m19313i();
    }

    public final int m28679a() {
        if ("grey".equals(this.f20952b.mo581a(ExperimentsForTextAbTestModule.f20965d, null))) {
            return 2131361935;
        }
        return 0;
    }
}
