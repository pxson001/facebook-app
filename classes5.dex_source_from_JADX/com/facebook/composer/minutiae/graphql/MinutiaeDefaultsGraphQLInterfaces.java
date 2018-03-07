package com.facebook.composer.minutiae.graphql;

import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaePreviewTemplateModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityFieldsModel.GlyphModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityFieldsModel.IconImageLargeModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityModel.AllIconsModel;
import javax.annotation.Nullable;

/* compiled from: admin_info */
public class MinutiaeDefaultsGraphQLInterfaces {

    /* compiled from: admin_info */
    public interface MinutiaeTaggableActivityFields {
    }

    /* compiled from: admin_info */
    public interface MinutiaeTaggableActivityPreviewTemplateFields {
        @Nullable
        MinutiaePreviewTemplateModel mo1185t();

        @Nullable
        MinutiaePreviewTemplateModel mo1186u();

        @Nullable
        MinutiaePreviewTemplateModel mo1187v();

        @Nullable
        MinutiaePreviewTemplateModel mo1188w();

        @Nullable
        MinutiaePreviewTemplateModel mo1189x();

        @Nullable
        MinutiaePreviewTemplateModel mo1190y();
    }

    /* compiled from: admin_info */
    public interface MinutiaeTaggableActivity extends MinutiaeTaggableActivityFields, MinutiaeTaggableActivityPreviewTemplateFields {
        @Nullable
        GlyphModel mo1191A();

        @Nullable
        AllIconsModel mo1192B();

        @Nullable
        String mo1193j();

        boolean mo1194k();

        @Nullable
        String mo1195l();

        int mo1196m();

        @Nullable
        String mo1197n();

        @Nullable
        String mo1198o();

        boolean mo1199p();

        boolean mo1200q();

        boolean mo1201r();

        @Nullable
        MinutiaePreviewTemplateModel mo1185t();

        @Nullable
        MinutiaePreviewTemplateModel mo1186u();

        @Nullable
        MinutiaePreviewTemplateModel mo1187v();

        @Nullable
        MinutiaePreviewTemplateModel mo1188w();

        @Nullable
        MinutiaePreviewTemplateModel mo1189x();

        @Nullable
        MinutiaePreviewTemplateModel mo1190y();

        @Nullable
        IconImageLargeModel mo1202z();
    }
}
