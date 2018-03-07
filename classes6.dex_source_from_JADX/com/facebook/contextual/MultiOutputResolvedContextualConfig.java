package com.facebook.contextual;

import com.facebook.contextual.ContextValue.Type;
import com.facebook.contextual.models.MultiOutputResolved;
import com.facebook.contextual.models.Output;
import com.facebook.contextual.models.OutputValue;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: outro_text */
public class MultiOutputResolvedContextualConfig implements ContextualConfig {
    RawConfig f8519a;
    ContextualConfigEvaluationResult f8520b;
    Map<String, Integer> f8521c;

    public MultiOutputResolvedContextualConfig(RawConfig rawConfig, MultiOutputResolved multiOutputResolved, ContextualConfigLogger contextualConfigLogger) {
        if (multiOutputResolved == null) {
            throw new ContextualConfigError("Bad config");
        } else if (multiOutputResolved.b.intValue() != 1) {
            throw new ContextualConfigError("Unsupported config version");
        } else if (multiOutputResolved.c == null || multiOutputResolved.c.size() == 0) {
            throw new ContextualConfigError("Missing outputs field definition");
        } else {
            int size = multiOutputResolved.c.size();
            Type[] typeArr = new Type[size];
            this.f8521c = new HashMap(size);
            int i = 0;
            for (Output output : multiOutputResolved.c) {
                typeArr[i] = ContextValue.a(output.b);
                this.f8521c.put(output.a, Integer.valueOf(i));
                if (typeArr[i] == null) {
                    throw new ContextualConfigError("Missing output type definition");
                }
                i++;
            }
            if (multiOutputResolved.d == null || multiOutputResolved.d.size() != size) {
                throw new ContextualConfigError("Missing default value");
            }
            ContextValue[] contextValueArr = new ContextValue[size];
            for (OutputValue outputValue : multiOutputResolved.d) {
                Integer num = (Integer) this.f8521c.get(outputValue.a);
                if (num == null || num.intValue() >= size) {
                    throw new ContextualConfigError("Undeclaed output param");
                }
                contextValueArr[num.intValue()] = new ContextValue(typeArr[num.intValue()], outputValue.b);
            }
            this.f8519a = rawConfig;
            this.f8520b = new ContextualConfigEvaluationResult(this, contextValueArr, contextualConfigLogger, rawConfig);
        }
    }

    public final RawConfig m12338a() {
        return this.f8519a;
    }

    public final ContextualConfigEvaluationResult m12337a(@Nullable LocalContextsProvider localContextsProvider) {
        return this.f8520b;
    }
}
