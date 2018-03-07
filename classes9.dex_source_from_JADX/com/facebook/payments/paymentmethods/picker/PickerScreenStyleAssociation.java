package com.facebook.payments.paymentmethods.picker;

import com.facebook.inject.Lazy;
import com.facebook.payments.picker.RowItemViewFactory;
import com.google.common.base.Preconditions;

/* compiled from: eglConfig not initialized */
public class PickerScreenStyleAssociation<STYLE_RENDERER extends PickerScreenStyleRenderer, DATA_FETCHER extends PickerScreenDataFetcher, SECTION_ORGANIZER extends SectionOrganizer, ROW_GENERATOR extends RowItemsGenerator, ACTIVITY_RESULT_HANDLER extends PickerScreenOnActivityResultHandler, DATA_MUTATOR extends PickerScreenDataMutator, SUB_SCREEN_PARAMS_GENERATOR extends PickerScreenSubScreenParamsGenerator, VIEW_FACTORY extends RowItemViewFactory> {
    public final PickerScreenStyle f15837a;
    public final Lazy<STYLE_RENDERER> f15838b;
    public final Lazy<DATA_FETCHER> f15839c;
    public final Lazy<SECTION_ORGANIZER> f15840d;
    public final Lazy<ROW_GENERATOR> f15841e;
    public final Lazy<ACTIVITY_RESULT_HANDLER> f15842f;
    public final Lazy<DATA_MUTATOR> f15843g;
    public final Lazy<SUB_SCREEN_PARAMS_GENERATOR> f15844h;
    public final Lazy<VIEW_FACTORY> f15845i;

    public PickerScreenStyleAssociation(PickerScreenStyle pickerScreenStyle, Lazy<STYLE_RENDERER> lazy, Lazy<DATA_FETCHER> lazy2, Lazy<SECTION_ORGANIZER> lazy3, Lazy<ROW_GENERATOR> lazy4, Lazy<ACTIVITY_RESULT_HANDLER> lazy5, Lazy<DATA_MUTATOR> lazy6, Lazy<SUB_SCREEN_PARAMS_GENERATOR> lazy7, Lazy<VIEW_FACTORY> lazy8) {
        this.f15837a = (PickerScreenStyle) Preconditions.checkNotNull(pickerScreenStyle);
        this.f15838b = lazy;
        this.f15839c = lazy2;
        this.f15840d = lazy3;
        this.f15841e = lazy4;
        this.f15842f = lazy5;
        this.f15843g = lazy6;
        this.f15844h = lazy7;
        this.f15845i = lazy8;
    }
}
