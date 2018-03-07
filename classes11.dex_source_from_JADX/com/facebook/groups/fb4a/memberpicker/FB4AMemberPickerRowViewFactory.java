package com.facebook.groups.fb4a.memberpicker;

import com.facebook.groups.memberpicker.DisabledAwareTypeaheadAdapterViewFactory;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.tokenizedtypeahead.ui.listview.DefaultViewFactory;
import javax.inject.Inject;

/* compiled from: \\) */
public class FB4AMemberPickerRowViewFactory extends DefaultViewFactory implements DisabledAwareTypeaheadAdapterViewFactory {
    public static FB4AMemberPickerRowViewFactory m10584a(InjectorLike injectorLike) {
        return new FB4AMemberPickerRowViewFactory();
    }

    @Inject
    public FB4AMemberPickerRowViewFactory() {
        super(true);
    }
}
