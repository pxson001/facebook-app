package com.facebook.leadgen;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.graphql.model.GraphQLLeadGenPage;
import com.facebook.leadgen.cache.LeadGenFormPendingInputEntry;
import com.facebook.leadgen.data.LeadGenDataExtractor;
import com.facebook.leadgen.input.LeadGenFieldInput.OnDataChangeListener;
import com.facebook.leadgen.util.LeadGenInfoFieldUserData;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;

/* compiled from: place_question_details */
public abstract class LeadGenFormPageView extends CustomLinearLayout {
    public abstract void mo344a();

    public abstract void mo345a(GraphQLLeadGenPage graphQLLeadGenPage, int i, LeadGenDataExtractor leadGenDataExtractor, int i2, OnDataChangeListener onDataChangeListener);

    public abstract void mo346a(LeadGenFormPendingInputEntry leadGenFormPendingInputEntry);

    public abstract ImmutableList<LeadGenInfoFieldUserData> mo347b();

    public abstract LeadGenUtil$ValidationResult mo348c(int i);

    public LeadGenFormPageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ImmutableMap<String, String> mo349c() {
        return null;
    }
}
