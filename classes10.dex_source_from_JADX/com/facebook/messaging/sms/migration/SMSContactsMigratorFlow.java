package com.facebook.messaging.sms.migration;

import android.content.Context;
import android.content.Intent;
import com.facebook.base.fragment.NavigableFragment;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: q2w */
public enum SMSContactsMigratorFlow {
    NUX_UPLOAD_FLOW("Contact Log/Sync Only (No Picker)", "upload_flow", ImmutableList.of(SMSUploadFragment.class)),
    CONTACT_PICKER_FLOW("Flow B (Picker -> Log/Sync)", "contact_picker", ImmutableList.of(SMSContactPickerFragment.class, SMSUploadFragment.class)),
    CONTACT_PICKER_NO_NUX_FLOW("Picker Only (No Contact Log/Sync)", "contact_picker_no_nux", ImmutableList.of(SMSContactPickerFragment.class)),
    CONTACT_PICKER_DIALOG_NUX_FLOW("Flow B' (Picker -> Log/Sync Dialog)", "contact_picker_dialog_nux", ImmutableList.of(SMSContactPickerWithUploadDialogFragment.class)),
    NUX_UPLOAD_WITH_CONTACT_MATCHING_FLOW("Flow A (Log/Sync -> Picker)", "nux_upload_with_contact_matching_flow", ImmutableList.of(SMSUploadAndMatchFragment.class, SMSContactPickerFragment.class));
    
    private final String mFlowIdentifier;
    private final String mFlowName;
    private final ImmutableList<Class<? extends NavigableFragment>> mFlowSteps;

    private SMSContactsMigratorFlow(String str, String str2, ImmutableList<Class<? extends NavigableFragment>> immutableList) {
        this.mFlowName = str;
        this.mFlowIdentifier = str2;
        this.mFlowSteps = immutableList;
    }

    final String getName() {
        return this.mFlowName;
    }

    public final Intent generateIntent(Context context) {
        Intent intent = new Intent(context, SMSContactsMigratorActivity.class);
        intent.putExtra("migration_flow", this.mFlowIdentifier);
        return intent;
    }

    public static SMSContactsMigratorFlow fromString(String str) {
        if (str != null) {
            for (SMSContactsMigratorFlow sMSContactsMigratorFlow : values()) {
                if (str.equalsIgnoreCase(sMSContactsMigratorFlow.mFlowIdentifier)) {
                    return sMSContactsMigratorFlow;
                }
            }
        }
        return null;
    }

    public final Class<? extends NavigableFragment> getFirstStep() {
        return (Class) this.mFlowSteps.get(0);
    }

    @Nullable
    public final Class<? extends NavigableFragment> getNextStep(Class<? extends NavigableFragment> cls) {
        int indexOf = this.mFlowSteps.indexOf(cls);
        if (indexOf < 0 || indexOf >= this.mFlowSteps.size() - 1) {
            return null;
        }
        return (Class) this.mFlowSteps.get(indexOf + 1);
    }
}
