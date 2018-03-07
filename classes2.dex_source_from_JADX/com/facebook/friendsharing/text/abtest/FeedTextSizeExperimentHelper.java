package com.facebook.friendsharing.text.abtest;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.StoryTextHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: home_stories_client_cursor_key_index */
public class FeedTextSizeExperimentHelper {
    private static final String f20956a = FeedTextSizeExperimentHelper.class.getSimpleName();
    private static FeedTextSizeExperimentHelper f20957e;
    private static final Object f20958f = new Object();
    private final QeAccessor f20959b;
    private final AbstractFbErrorReporter f20960c;
    @Nullable
    private LinkedHashMap<Integer, Configuration> f20961d;

    private static FeedTextSizeExperimentHelper m28687b(InjectorLike injectorLike) {
        return new FeedTextSizeExperimentHelper(QeInternalImplMethodAutoProvider.m3744a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike));
    }

    public static FeedTextSizeExperimentHelper m28684a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedTextSizeExperimentHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20958f) {
                FeedTextSizeExperimentHelper feedTextSizeExperimentHelper;
                if (a2 != null) {
                    feedTextSizeExperimentHelper = (FeedTextSizeExperimentHelper) a2.mo818a(f20958f);
                } else {
                    feedTextSizeExperimentHelper = f20957e;
                }
                if (feedTextSizeExperimentHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28687b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20958f, b3);
                        } else {
                            f20957e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = feedTextSizeExperimentHelper;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public FeedTextSizeExperimentHelper(QeAccessor qeAccessor, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f20959b = qeAccessor;
        this.f20960c = abstractFbErrorReporter;
    }

    public final boolean m28691a() {
        return this.f20959b.mo596a(ExperimentsForTextAbTestModule.f20963b, false);
    }

    public final boolean m28692a(GraphQLStory graphQLStory) {
        if (!m28691a()) {
            return false;
        }
        Object obj;
        GraphQLActor b = StoryActorHelper.m27492b(graphQLStory);
        if (b == null || b.m23790b() == null || b.m23790b().m22301g() != 2645995) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null || graphQLStory.aD() > 0) {
            return false;
        }
        if ((!this.f20959b.mo596a(ExperimentsForTextAbTestModule.f20966e, false) || (graphQLStory.m22326L() == null && !StoryAttachmentHelper.m28029a(graphQLStory))) && m28693b(graphQLStory) != null) {
            return true;
        }
        return false;
    }

    @Nullable
    public final Configuration m28693b(GraphQLStory graphQLStory) {
        return m28683a(StoryTextHelper.m31226a(graphQLStory).length());
    }

    @Nullable
    public final Configuration m28690a(String str) {
        return m28683a(str.length());
    }

    @Nullable
    private Configuration m28683a(int i) {
        if (this.f20961d == null) {
            this.f20961d = m28688b();
        }
        for (Entry entry : this.f20961d.entrySet()) {
            if (i <= ((Integer) entry.getKey()).intValue()) {
                return (Configuration) entry.getValue();
            }
        }
        return null;
    }

    public final int m28694c(GraphQLStory graphQLStory) {
        Configuration b = m28693b(graphQLStory);
        return b == null ? -1 : b.f;
    }

    private LinkedHashMap<Integer, Configuration> m28688b() {
        String a = this.f20959b.mo581a(ExperimentsForTextAbTestModule.f20969h, null);
        String a2 = this.f20959b.mo581a(ExperimentsForTextAbTestModule.f20967f, null);
        String a3 = this.f20959b.mo581a(ExperimentsForTextAbTestModule.f20971j, null);
        String a4 = this.f20959b.mo581a(ExperimentsForTextAbTestModule.f20964c, null);
        String a5 = this.f20959b.mo581a(ExperimentsForTextAbTestModule.f20968g, null);
        String a6 = this.f20959b.mo581a(ExperimentsForTextAbTestModule.f20972k, null);
        String a7 = this.f20959b.mo581a(ExperimentsForTextAbTestModule.f20962a, null);
        LinkedHashMap<Integer, Configuration> linkedHashMap = new LinkedHashMap();
        if (a == null || a2 == null || a3 == null || a4 == null || a5 == null) {
            return linkedHashMap;
        }
        String[] strArr;
        String[] split = a.split("[^0-9-]+");
        String[] split2 = a2.split("[^0-9-]+");
        String[] split3 = a3.split("[^0-9-]+");
        String[] split4 = a4.split("[^0-9-]+");
        String[] split5 = a5.split(",");
        String[] split6 = a6 == null ? null : a6.split("[^0-9-]+");
        if (a7 == null) {
            strArr = null;
        } else {
            strArr = a7.split("[^0-9-]+");
        }
        int length = split.length;
        if (split2.length == length && split3.length == length && split4.length == length && split5.length == length && ((split6 == null || split6.length == length) && (strArr == null || strArr.length == length))) {
            int i = 0;
            while (i < length) {
                try {
                    Integer valueOf = Integer.valueOf(Integer.parseInt(split[i], 10));
                    linkedHashMap.put(valueOf, new Configuration(valueOf.intValue(), Integer.parseInt(split2[i], 10), Integer.parseInt(split3[i], 10), Integer.parseInt(split4[i], 10), split5[i].trim(), m28682a(split6, i), m28686b(strArr, i)));
                } catch (NumberFormatException e) {
                    this.f20960c.m2350b(f20956a, m28685a("Cannot parse number: ", split[i], split2[i], split3[i], split4[i], split5[i], split6 == null ? "null" : split6[i], strArr == null ? "null" : strArr[i]));
                }
                i++;
            }
            return linkedHashMap;
        }
        AbstractFbErrorReporter abstractFbErrorReporter = this.f20960c;
        String str = f20956a;
        String str2 = "String arrays are mismatched: ";
        if (a6 == null) {
            a6 = "";
        }
        if (a7 == null) {
            a7 = "";
        }
        abstractFbErrorReporter.m2350b(str, m28685a(str2, a, a2, a3, a4, a5, a6, a7));
        return linkedHashMap;
    }

    private static String m28685a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.append(" length limit: ").append(str2);
        stringBuilder.append(" font size: ").append(str3);
        stringBuilder.append(" top padding: ").append(str4);
        stringBuilder.append(" bottom padding: ").append(str5);
        stringBuilder.append(" font style: ").append(str6);
        stringBuilder.append(" truncation limit: ").append(str7);
        stringBuilder.append(" align centering: ").append(str8);
        return stringBuilder.toString();
    }

    private int m28682a(String[] strArr, int i) {
        return (strArr == null || m28689b(strArr[i])) ? -1 : Integer.parseInt(strArr[i]);
    }

    private int m28686b(String[] strArr, int i) {
        return (strArr == null || m28689b(strArr[i])) ? -1 : Integer.parseInt(strArr[i]);
    }

    private static boolean m28689b(@Nullable String str) {
        return str == null || str.length() == 0;
    }
}
