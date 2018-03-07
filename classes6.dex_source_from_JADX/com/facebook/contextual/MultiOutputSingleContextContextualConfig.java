package com.facebook.contextual;

import com.facebook.contextual.ContextValue.Type;
import com.facebook.contextual.models.MultiOutputSingleContextTable;
import com.facebook.contextual.models.MultiValueTableItem;
import com.facebook.contextual.models.Output;
import com.facebook.contextual.models.OutputValue;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: outgoing_bubble_color */
public class MultiOutputSingleContextContextualConfig extends SingleContextContextualConfigBase implements ContextualConfig {
    Map<String, Integer> f8529a;

    public MultiOutputSingleContextContextualConfig(RawConfig rawConfig, MultiOutputSingleContextTable multiOutputSingleContextTable, BucketMatcherFactoryImpl bucketMatcherFactoryImpl, ContextsProviderRegistryImpl contextsProviderRegistryImpl, ContextualConfigLogger contextualConfigLogger) {
        super(rawConfig, multiOutputSingleContextTable, 1, bucketMatcherFactoryImpl, contextsProviderRegistryImpl, contextualConfigLogger);
        if (multiOutputSingleContextTable.a == null || multiOutputSingleContextTable.a.size() == 0) {
            throw new ContextualConfigError("Missing outputs field definition");
        }
        int size = multiOutputSingleContextTable.a.size();
        Type[] typeArr = new Type[size];
        this.f8529a = new HashMap(size);
        this.g = new ContextValue[size];
        int i = 0;
        for (Output output : multiOutputSingleContextTable.a) {
            typeArr[i] = ContextValue.a(output.b);
            this.f8529a.put(output.a, Integer.valueOf(i));
            if (typeArr[i] == null) {
                throw new ContextualConfigError("Missing output type definition");
            }
            i++;
        }
        this.f = new HashMap();
        if (multiOutputSingleContextTable.b == null) {
            throw new ContextualConfigError("Missing table");
        }
        for (MultiValueTableItem multiValueTableItem : multiOutputSingleContextTable.b) {
            Object obj = new ContextValue[size];
            if (multiValueTableItem.b == null) {
                throw new ContextualConfigError("Missing table item values");
            } else if (multiValueTableItem.a == null) {
                throw new ContextualConfigError("Missing table item bucket");
            } else {
                for (OutputValue outputValue : multiValueTableItem.b) {
                    Integer num = (Integer) this.f8529a.get(outputValue.a);
                    if (num == null || num.intValue() >= size) {
                        throw new ContextualConfigError("Undeclaed output param");
                    }
                    obj[num.intValue()] = new ContextValue(typeArr[num.intValue()], outputValue.b);
                }
                this.f8526f.put(multiValueTableItem.a.toLowerCase(Locale.US), obj);
            }
        }
        if (multiOutputSingleContextTable.c == null || multiOutputSingleContextTable.c.size() != size) {
            throw new ContextualConfigError("Missing default value");
        }
        for (OutputValue outputValue2 : multiOutputSingleContextTable.c) {
            Integer num2 = (Integer) this.f8529a.get(outputValue2.a);
            if (num2 == null || num2.intValue() >= size) {
                throw new ContextualConfigError("Undeclaed output param");
            }
            this.f8527g[num2.intValue()] = new ContextValue(typeArr[num2.intValue()], outputValue2.b);
        }
    }
}
