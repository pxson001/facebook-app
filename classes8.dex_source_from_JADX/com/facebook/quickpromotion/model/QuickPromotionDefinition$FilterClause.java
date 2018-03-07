package com.facebook.quickpromotion.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.Collection;
import java.util.Locale;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = QuickPromotionDefinition_FilterClauseDeserializer.class)
@Immutable
/* compiled from: reaction_forward_scroll */
public class QuickPromotionDefinition$FilterClause implements Parcelable {
    public static final Creator<QuickPromotionDefinition$FilterClause> CREATOR = new C06311();
    @JsonProperty("clauses")
    public final ImmutableList<QuickPromotionDefinition$FilterClause> clauses;
    @JsonProperty("filters")
    public final ImmutableList<ContextualFilter> filters;
    @JsonProperty("type")
    public final BooleanType type;

    /* compiled from: reaction_forward_scroll */
    final class C06311 implements Creator<QuickPromotionDefinition$FilterClause> {
        C06311() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new QuickPromotionDefinition$FilterClause(parcel);
        }

        public final Object[] newArray(int i) {
            return new QuickPromotionDefinition$FilterClause[i];
        }
    }

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = QuickPromotionDefinition_FilterClause_BooleanTypeDeserializer.class)
    @Immutable
    /* compiled from: reaction_forward_scroll */
    public enum BooleanType {
        AND,
        OR,
        NOR,
        UNKNOWN;

        @JsonCreator
        public static BooleanType fromString(String str) {
            if (str != null) {
                return valueOf(str.toUpperCase(Locale.US));
            }
            try {
                return UNKNOWN;
            } catch (IllegalArgumentException e) {
                return UNKNOWN;
            }
        }
    }

    public QuickPromotionDefinition$FilterClause() {
        this.type = BooleanType.UNKNOWN;
        this.filters = RegularImmutableList.a;
        this.clauses = RegularImmutableList.a;
    }

    public QuickPromotionDefinition$FilterClause(Parcel parcel) {
        this.type = BooleanType.fromString(parcel.readString());
        Collection a = Lists.a();
        parcel.readTypedList(a, ContextualFilter.CREATOR);
        this.filters = ImmutableList.copyOf(a);
        a = Lists.a();
        parcel.readTypedList(a, CREATOR);
        this.clauses = ImmutableList.copyOf(a);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.type.name());
        parcel.writeTypedList(this.filters);
        parcel.writeTypedList(this.clauses);
    }
}
