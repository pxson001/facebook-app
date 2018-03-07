package com.facebook.leadgen.input;

import android.content.Context;
import android.view.View;
import com.facebook.graphql.model.GraphQLLeadGenInfoFieldData;
import com.facebook.leadgen.data.LeadGenDataExtractor;

/* compiled from: pic_head */
public interface LeadGenFieldInput {

    /* compiled from: pic_head */
    public interface ViewType<V extends View & LeadGenFieldInput> {
        V mo350a(Context context);
    }

    /* compiled from: pic_head */
    public interface OnDataChangeListener {
    }

    void mo351a();

    void mo352a(GraphQLLeadGenInfoFieldData graphQLLeadGenInfoFieldData, LeadGenDataExtractor leadGenDataExtractor, int i);

    void mo353a(String str);

    void mo354b();

    GraphQLLeadGenInfoFieldData getBoundedInfoFieldData();

    String getInputCustomToken();

    String getInputValue();

    void setInputValue(String str);

    void setOnDataChangeListener(OnDataChangeListener onDataChangeListener);
}
