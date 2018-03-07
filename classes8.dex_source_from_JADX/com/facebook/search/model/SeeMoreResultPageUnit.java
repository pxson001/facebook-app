package com.facebook.search.model;

import com.facebook.search.model.SuggestionGroup.Type;
import com.google.common.base.Preconditions;

/* compiled from: TIMELINE_FRIENDS_PROTILE */
public class SeeMoreResultPageUnit extends TypeaheadUnit {
    public final EntityTypeaheadUnit f22265a;

    public SeeMoreResultPageUnit(EntityTypeaheadUnit entityTypeaheadUnit) {
        this.f22265a = (EntityTypeaheadUnit) Preconditions.checkNotNull(entityTypeaheadUnit);
    }

    public final <T> T m25738a(TypeaheadSuggestionVisitorWithReturn<T> typeaheadSuggestionVisitorWithReturn) {
        return typeaheadSuggestionVisitorWithReturn.mo1231a(this);
    }

    public final void m25739a(TypeaheadSuggestionVisitor typeaheadSuggestionVisitor) {
        typeaheadSuggestionVisitor.m25777a(this);
    }

    public final Type m25740k() {
        return Type.ENTITY;
    }

    public boolean equals(Object obj) {
        if (obj instanceof SeeMoreResultPageUnit) {
            return this.f22265a.equals(((SeeMoreResultPageUnit) obj).f22265a);
        }
        return false;
    }

    public int hashCode() {
        return this.f22265a.hashCode();
    }

    public final String m25742m() {
        return this.f22265a.f22045a;
    }

    public final String m25743n() {
        return this.f22265a.f22047c.toString();
    }

    public final boolean m25741l() {
        return true;
    }
}
