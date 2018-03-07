package com.facebook.quickpromotion.filter;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.TriState;
import com.facebook.inject.InjectorLike;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition$FilterClause;
import com.facebook.quickpromotion.model.QuickPromotionDefinition$FilterClause.BooleanType;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: reaction_paginated_components_count */
public class QuickPromotionFilterClauseChecker {
    private final ContextualFilterPassingCheck f4721a;
    private final AbstractFbErrorReporter f4722b;

    /* compiled from: reaction_paginated_components_count */
    class InvalidClauseException extends Exception {
    }

    public static QuickPromotionFilterClauseChecker m4587b(InjectorLike injectorLike) {
        return new QuickPromotionFilterClauseChecker(ContextualFilterPassingCheck.m4548a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public QuickPromotionFilterClauseChecker(ContextualFilterPassingCheck contextualFilterPassingCheck, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f4721a = contextualFilterPassingCheck;
        this.f4722b = abstractFbErrorReporter;
    }

    public final Map<ContextualFilter, Boolean> m4588a(@Nonnull QuickPromotionDefinition quickPromotionDefinition, @Nonnull QuickPromotionDefinition$FilterClause quickPromotionDefinition$FilterClause) {
        int i = 0;
        Map<ContextualFilter, Boolean> c = Maps.c();
        ImmutableList immutableList = quickPromotionDefinition$FilterClause.filters;
        int size = immutableList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ContextualFilter contextualFilter = (ContextualFilter) immutableList.get(i2);
            c.put(contextualFilter, Boolean.valueOf(this.f4721a.m4550a(contextualFilter, quickPromotionDefinition, null)));
        }
        ImmutableList immutableList2 = quickPromotionDefinition$FilterClause.clauses;
        int size2 = immutableList2.size();
        while (i < size2) {
            c.putAll(m4588a(quickPromotionDefinition, (QuickPromotionDefinition$FilterClause) immutableList2.get(i)));
            i++;
        }
        return c;
    }

    public final boolean m4589b(@Nonnull QuickPromotionDefinition quickPromotionDefinition, @Nonnull QuickPromotionDefinition$FilterClause quickPromotionDefinition$FilterClause) {
        try {
            return m4586a(quickPromotionDefinition$FilterClause, quickPromotionDefinition);
        } catch (InvalidClauseException e) {
            this.f4722b.a("QuickPromotion_boolean_filter", "Invalid clause");
            return false;
        } catch (IllegalArgumentException e2) {
            this.f4722b.a("QuickPromotion_boolean_filter", "Invalid filter");
            return false;
        } catch (NullPointerException e3) {
            this.f4722b.a("QuickPromotion_boolean_filter", "Invalid filter");
            return false;
        }
    }

    private boolean m4586a(@Nonnull QuickPromotionDefinition$FilterClause quickPromotionDefinition$FilterClause, @Nonnull QuickPromotionDefinition quickPromotionDefinition) {
        BooleanType booleanType = quickPromotionDefinition$FilterClause.type;
        if (booleanType == BooleanType.UNKNOWN || (quickPromotionDefinition$FilterClause.filters.isEmpty() && quickPromotionDefinition$FilterClause.clauses.isEmpty())) {
            throw new InvalidClauseException();
        }
        int i;
        ImmutableList immutableList = quickPromotionDefinition$FilterClause.filters;
        int size = immutableList.size();
        for (i = 0; i < size; i++) {
            TriState a = m4585a(booleanType, this.f4721a.m4550a((ContextualFilter) immutableList.get(i), quickPromotionDefinition, null));
            if (a.isSet()) {
                return a.asBoolean();
            }
        }
        immutableList = quickPromotionDefinition$FilterClause.clauses;
        size = immutableList.size();
        for (i = 0; i < size; i++) {
            a = m4585a(booleanType, m4586a((QuickPromotionDefinition$FilterClause) immutableList.get(i), quickPromotionDefinition));
            if (a.isSet()) {
                return a.asBoolean();
            }
        }
        switch (booleanType) {
            case OR:
                return false;
            case NOR:
            case AND:
                return true;
            default:
                throw new InvalidClauseException();
        }
    }

    private static TriState m4585a(BooleanType booleanType, boolean z) {
        switch (booleanType) {
            case OR:
                if (z) {
                    return TriState.YES;
                }
                break;
            case NOR:
                if (z) {
                    return TriState.NO;
                }
                break;
            case AND:
                if (!z) {
                    return TriState.NO;
                }
                break;
        }
        return TriState.UNSET;
    }
}
