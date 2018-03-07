package com.facebook.fbui.viewdescriptionbuilder;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.proxygen.HTTPTransportCallback;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import java.io.File;
import java.util.ArrayList;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: qp_counters */
public class ViewDescriptionBuilder {
    private static final Class<?> f8513a = ViewDescriptionBuilder.class;
    private final ObjectMapper f8514b;
    public final Set<ViewDescriptionBuilderSpec> f8515c;
    private final AbstractFbErrorReporter f8516d;

    public static ViewDescriptionBuilder m13060b(InjectorLike injectorLike) {
        return new ViewDescriptionBuilder(FbObjectMapperMethodAutoProvider.m6609a(injectorLike), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$ViewDescriptionBuilderSpec(injectorLike)), FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public ViewDescriptionBuilder(ObjectMapper objectMapper, Set<ViewDescriptionBuilderSpec> set, FbErrorReporter fbErrorReporter) {
        this.f8514b = objectMapper;
        this.f8515c = set;
        this.f8516d = fbErrorReporter;
    }

    public final boolean m13063a(File file, JSONOutputType jSONOutputType, Bundle bundle) {
        Object a = m13058a(bundle);
        try {
            if (jSONOutputType == JSONOutputType.PRETTY) {
                this.f8514b.m6670g().a().a(file, a);
            } else {
                this.f8514b.m6661a(file, a);
            }
            return true;
        } catch (Throwable e) {
            this.f8516d.m2343a(f8513a.getSimpleName(), "Error building view description JSON File", e);
            return false;
        }
    }

    @VisibleForTesting
    public final String m13062a(View view, ViewTraversalMode viewTraversalMode, JSONOutputType jSONOutputType) {
        Object b = m13064b(view, viewTraversalMode);
        try {
            if (jSONOutputType == JSONOutputType.PRETTY) {
                return this.f8514b.m6670g().a().a(b);
            }
            return this.f8514b.m6659a(b);
        } catch (Throwable e) {
            this.f8516d.m2343a(f8513a.getSimpleName(), "Error building view description JSON", e);
            return null;
        }
    }

    public final Bundle m13061a(View view, ViewTraversalMode viewTraversalMode) {
        return m13057a(view, viewTraversalMode, 0);
    }

    public final ObjectNode m13064b(View view, ViewTraversalMode viewTraversalMode) {
        return m13058a(m13057a(view, viewTraversalMode, 0));
    }

    private Bundle m13057a(View view, ViewTraversalMode viewTraversalMode, int i) {
        Bundle bundle = new Bundle();
        if (viewTraversalMode == ViewTraversalMode.ALL) {
            bundle.putInt("depth_level", i);
        }
        for (ViewDescriptionBuilderSpec viewDescriptionBuilderSpec : this.f8515c) {
            Class a = viewDescriptionBuilderSpec.a();
            if (a.isInstance(view)) {
                viewDescriptionBuilderSpec.a(a.cast(view), bundle);
            }
        }
        if (viewTraversalMode != ViewTraversalMode.NONE && (view instanceof ViewGroup)) {
            m13059a((ViewGroup) view, viewTraversalMode, bundle, i + 1);
        }
        return bundle;
    }

    private void m13059a(ViewGroup viewGroup, ViewTraversalMode viewTraversalMode, Bundle bundle, int i) {
        ViewTraversalMode viewTraversalMode2;
        int i2;
        int i3 = 0;
        switch (1.a[viewTraversalMode.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                viewTraversalMode2 = ViewTraversalMode.NONE;
                i2 = 0;
                break;
            default:
                i2 = 1;
                viewTraversalMode2 = ViewTraversalMode.ALL;
                break;
        }
        int childCount = viewGroup.getChildCount();
        ArrayList a = Lists.m1297a(childCount);
        int i4 = 0;
        int i5 = 0;
        while (i4 < childCount) {
            int i6;
            Bundle a2 = m13057a(viewGroup.getChildAt(i4), viewTraversalMode2, i);
            a.add(a2);
            if (i2 != 0 && a2.containsKey("max_child_depth")) {
                i6 = a2.getInt("max_child_depth");
                if (i6 > i5) {
                    i4++;
                    i5 = i6;
                }
            }
            i6 = i5;
            i4++;
            i5 = i6;
        }
        if (i2 != 0) {
            String str = "max_child_depth";
            if (childCount != 0) {
                i3 = i5 + 1;
            }
            bundle.putInt(str, i3);
        }
        bundle.putParcelableArrayList("children", a);
    }

    private ObjectNode m13058a(Bundle bundle) {
        ObjectNode e = this.f8514b.m6668e();
        JsonNode jsonNode = null;
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj == null) {
                e.m5137a(str, "null");
            } else if (obj instanceof String) {
                e.m5137a(str, (String) obj);
            } else if (obj instanceof Integer) {
                e.m5134a(str, (Integer) obj);
            } else if (obj instanceof Bundle) {
                e.m5143c(str, m13058a((Bundle) obj));
            } else if (obj instanceof Long) {
                e.m5135a(str, (Long) obj);
            } else if (obj instanceof Boolean) {
                e.m5131a(str, (Boolean) obj);
            } else if (obj instanceof Float) {
                e.m5133a(str, (Float) obj);
            } else if (obj instanceof Double) {
                e.m5132a(str, (Double) obj);
            } else if (obj instanceof Short) {
                e.m5136a(str, (Short) obj);
            } else if (obj instanceof byte[]) {
                e.m5139a(str, (byte[]) obj);
            } else {
                JsonNode jsonNode2;
                if (obj instanceof ArrayList) {
                    JsonNode f = this.f8514b.m6669f();
                    ArrayList arrayList = (ArrayList) obj;
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        Object obj2 = arrayList.get(i);
                        if (obj2 instanceof Bundle) {
                            f.m13381a(m13058a((Bundle) obj2));
                        } else {
                            f.m13394h(obj2.toString());
                        }
                    }
                    if ("children".equals(str)) {
                        jsonNode2 = f;
                    } else {
                        e.m5143c(str, f);
                    }
                } else {
                    e.m5137a(str, obj.toString());
                    jsonNode2 = jsonNode;
                }
                jsonNode = jsonNode2;
            }
        }
        if (jsonNode != null) {
            e.m5143c("children", jsonNode);
        }
        return e;
    }
}
