package com.facebook.contextual;

import com.facebook.contextual.ContextValue.Type;
import com.facebook.contextual.models.SingleContextTable;
import com.facebook.contextual.models.TableItem;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: other_participants */
public class SingleContextTableContextualConfig extends SingleContextContextualConfigBase implements ContextualConfig {
    public SingleContextTableContextualConfig(RawConfig rawConfig, SingleContextTable singleContextTable, BucketMatcherFactoryImpl bucketMatcherFactoryImpl, ContextsProviderRegistryImpl contextsProviderRegistryImpl, ContextualConfigLogger contextualConfigLogger) {
        super(rawConfig, singleContextTable, 1, bucketMatcherFactoryImpl, contextsProviderRegistryImpl, contextualConfigLogger);
        this.f = new HashMap();
        Type a = ContextValue.a(singleContextTable.a);
        if (a == null) {
            throw new ContextualConfigError("Missing output type definition");
        } else if (singleContextTable.b == null) {
            throw new ContextualConfigError("Missing table");
        } else {
            for (TableItem tableItem : singleContextTable.b) {
                if (tableItem.a == null) {
                    throw new ContextualConfigError("Missing table item bucket");
                }
                this.f8526f.put(tableItem.a.toLowerCase(Locale.US), new ContextValue[]{new ContextValue(a, tableItem.b)});
            }
            this.g = new ContextValue[1];
            this.f8527g[0] = new ContextValue(a, singleContextTable.c);
        }
    }
}
