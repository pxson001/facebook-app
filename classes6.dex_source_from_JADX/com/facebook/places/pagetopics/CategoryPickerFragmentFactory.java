package com.facebook.places.pagetopics;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.ipc.model.PageTopic;
import com.facebook.places.pagetopics.PlaceCategoryPickerFragment.Listener;
import com.facebook.places.pagetopics.logging.PlaceCategoryPickerLoggerFactory.Type;
import com.google.common.base.Absent;
import com.google.common.base.Optional;

/* compiled from: formatted_date_for_display */
public class CategoryPickerFragmentFactory implements IFragmentFactory {

    /* compiled from: formatted_date_for_display */
    class CategoryPickerListener implements Listener {
        public final void mo1162a(PlaceCategoryPickerFragment placeCategoryPickerFragment, PageTopic pageTopic) {
            placeCategoryPickerFragment.ao().setResult(-1, new Intent().putExtra("extra_picked_category", pageTopic));
            placeCategoryPickerFragment.ao().finish();
        }
    }

    public final Fragment m22285a(Intent intent) {
        Type type = (Type) intent.getSerializableExtra("extra_logger_type");
        Optional optional = Absent.INSTANCE;
        Listener categoryPickerListener = new CategoryPickerListener();
        if (type == null) {
            type = Type.NO_LOGGER;
        }
        return PlaceCategoryPickerFragment.m22317a(optional, categoryPickerListener, false, type, intent.getParcelableExtra("extra_logger_params"));
    }
}
