package com.facebook.places.create;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.ipc.model.PageTopic;
import com.facebook.places.pagetopics.PlaceCategoryPickerFragment;
import com.facebook.places.pagetopics.PlaceCategoryPickerFragment.Listener;
import com.facebook.places.pagetopics.logging.PlaceCategoryPickerLoggerFactory.Type;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.google.common.base.Absent;
import com.google.common.base.Optional;

/* compiled from: celebrity */
public class PlaceCreationCategoryPickerActivity extends BasePlaceCreationActivity {

    /* compiled from: celebrity */
    class CategoryPickerListener implements Listener {
        public final void m22154a(PlaceCategoryPickerFragment placeCategoryPickerFragment, PageTopic pageTopic) {
            PlaceCreationCategoryPickerActivity placeCreationCategoryPickerActivity = (PlaceCreationCategoryPickerActivity) placeCategoryPickerFragment.o();
            Intent intent = new Intent();
            intent.putExtra("category", pageTopic);
            placeCreationCategoryPickerActivity.setResult(-1, intent);
            placeCreationCategoryPickerActivity.finish();
        }
    }

    protected final String mo1087i() {
        return getString(2131235264);
    }

    protected final void mo1086b(Bundle bundle) {
        super.mo1086b(bundle);
        if (kO_().a(2131558429) == null) {
            Type type = (Type) getIntent().getSerializableExtra("logger_type");
            Optional optional = Absent.INSTANCE;
            CategoryPickerListener categoryPickerListener = new CategoryPickerListener();
            if (type == null) {
                type = Type.NO_LOGGER;
            }
            kO_().a().b(2131558429, PlaceCategoryPickerFragment.a(optional, categoryPickerListener, false, type, getIntent().getParcelableExtra("logger_params"))).b();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        KeyboardUtils.a(this);
    }
}
