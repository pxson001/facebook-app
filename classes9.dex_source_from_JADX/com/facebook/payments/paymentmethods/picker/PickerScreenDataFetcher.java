package com.facebook.payments.paymentmethods.picker;

import com.facebook.payments.paymentmethods.picker.model.PickerScreenData;
import com.facebook.payments.picker.model.PickerScreenFetcherParams;

/* compiled from: boost_info_edit_targeting */
public interface PickerScreenDataFetcher<PICKER_SCREEN_PARAM extends PickerScreenParams, FETCHER_PARAMS extends PickerScreenFetcherParams> {

    /* compiled from: boost_info_edit_targeting */
    public interface Listener {
        void mo748a();

        void mo749a(PickerScreenData pickerScreenData);

        void mo750a(Throwable th);
    }

    void mo744a();

    void mo745a(Listener listener, PICKER_SCREEN_PARAM picker_screen_param, FETCHER_PARAMS fetcher_params);
}
