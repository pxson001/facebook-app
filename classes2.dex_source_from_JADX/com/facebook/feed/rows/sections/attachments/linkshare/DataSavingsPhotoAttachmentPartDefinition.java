package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.datasensitivity.pref.DataSensitivitySettingsPrefUtil;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch_megaphone_layout */
public class DataSavingsPhotoAttachmentPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, FeedEnvironment> {
    private static DataSavingsPhotoAttachmentPartDefinition f24037c;
    private static final Object f24038d = new Object();
    private final SmallPhotoShareAttachmentPartDefinition<FeedEnvironment, ?> f24039a;
    private final DataSensitivitySettingsPrefUtil f24040b;

    private static DataSavingsPhotoAttachmentPartDefinition m32431b(InjectorLike injectorLike) {
        return new DataSavingsPhotoAttachmentPartDefinition(SmallPhotoShareAttachmentPartDefinition.m32434a(injectorLike), DataSensitivitySettingsPrefUtil.m8604a(injectorLike));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        SubPartsSelector.m19114a(baseMultiRowSubParts, this.f24039a, (FeedProps) obj);
        return null;
    }

    @Inject
    public DataSavingsPhotoAttachmentPartDefinition(SmallPhotoShareAttachmentPartDefinition smallPhotoShareAttachmentPartDefinition, DataSensitivitySettingsPrefUtil dataSensitivitySettingsPrefUtil) {
        this.f24039a = smallPhotoShareAttachmentPartDefinition;
        this.f24040b = dataSensitivitySettingsPrefUtil;
    }

    public final boolean mo2536a(Object obj) {
        return this.f24040b.m8609b(false);
    }

    public static DataSavingsPhotoAttachmentPartDefinition m32430a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DataSavingsPhotoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24038d) {
                DataSavingsPhotoAttachmentPartDefinition dataSavingsPhotoAttachmentPartDefinition;
                if (a2 != null) {
                    dataSavingsPhotoAttachmentPartDefinition = (DataSavingsPhotoAttachmentPartDefinition) a2.mo818a(f24038d);
                } else {
                    dataSavingsPhotoAttachmentPartDefinition = f24037c;
                }
                if (dataSavingsPhotoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32431b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24038d, b3);
                        } else {
                            f24037c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = dataSavingsPhotoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
