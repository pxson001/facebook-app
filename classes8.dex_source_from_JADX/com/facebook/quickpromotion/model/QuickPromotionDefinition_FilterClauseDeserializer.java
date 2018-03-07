package com.facebook.quickpromotion.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: reaction_context_items_surface */
public class QuickPromotionDefinition_FilterClauseDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f4754a;

    static {
        GlobalAutoGenDeserializerCache.a(QuickPromotionDefinition$FilterClause.class, new QuickPromotionDefinition_FilterClauseDeserializer());
        m4634e();
    }

    public QuickPromotionDefinition_FilterClauseDeserializer() {
        a(QuickPromotionDefinition$FilterClause.class);
    }

    private static synchronized Map<String, FbJsonField> m4634e() {
        Map<String, FbJsonField> map;
        synchronized (QuickPromotionDefinition_FilterClauseDeserializer.class) {
            if (f4754a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("type", FbJsonField.jsonFieldWithCreator(QuickPromotionDefinition$FilterClause.class.getDeclaredField("type")));
                    builder.b("filters", FbJsonField.jsonField(QuickPromotionDefinition$FilterClause.class.getDeclaredField("filters"), ContextualFilter.class));
                    builder.b("clauses", FbJsonField.jsonField(QuickPromotionDefinition$FilterClause.class.getDeclaredField("clauses"), QuickPromotionDefinition$FilterClause.class));
                    f4754a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f4754a;
        }
        return map;
    }

    public final FbJsonField m4635a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m4634e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m4634e().keySet());
    }
}
