package com.facebook.quickpromotion.validators;

import com.facebook.quickpromotion.filter.QuickPromotionCounters$CounterType;
import com.facebook.quickpromotion.model.QuickPromotionDefinition$FilterClause;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.google.common.base.Optional;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: query_pivots */
public class QuickPromotionValidatorResult {
    public static final QuickPromotionValidatorResult f4869a = new Builder(true).m4746a();
    public static final QuickPromotionValidatorResult f4870b = new Builder(false).m4746a();
    public final boolean f4871c;
    public final Optional<ContextualFilter> f4872d;
    public final Optional<QuickPromotionCounters$CounterType> f4873e;
    public final Optional<QuickPromotionDefinition$FilterClause> f4874f;
    public final Optional<String> f4875g;

    /* compiled from: query_pivots */
    public class Builder {
        public final boolean f4864a;
        public ContextualFilter f4865b;
        public QuickPromotionCounters$CounterType f4866c;
        public QuickPromotionDefinition$FilterClause f4867d;
        public String f4868e;

        public Builder(boolean z) {
            this.f4864a = z;
        }

        public final QuickPromotionValidatorResult m4746a() {
            return new QuickPromotionValidatorResult(this);
        }
    }

    public QuickPromotionValidatorResult(Builder builder) {
        this.f4871c = builder.f4864a;
        this.f4872d = Optional.fromNullable(builder.f4865b);
        this.f4873e = Optional.fromNullable(builder.f4866c);
        this.f4874f = Optional.fromNullable(builder.f4867d);
        this.f4875g = Optional.fromNullable(builder.f4868e);
    }
}
