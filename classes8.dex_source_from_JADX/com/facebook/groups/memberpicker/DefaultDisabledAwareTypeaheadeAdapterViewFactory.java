package com.facebook.groups.memberpicker;

import com.facebook.inject.InjectorLike;
import com.facebook.widget.tokenizedtypeahead.ui.listview.DefaultViewFactory;
import javax.inject.Inject;

/* compiled from: extra_caller_context */
public class DefaultDisabledAwareTypeaheadeAdapterViewFactory extends DefaultViewFactory implements DisabledAwareTypeaheadAdapterViewFactory {
    public static DefaultDisabledAwareTypeaheadeAdapterViewFactory m16395a(InjectorLike injectorLike) {
        return new DefaultDisabledAwareTypeaheadeAdapterViewFactory();
    }

    @Inject
    public DefaultDisabledAwareTypeaheadeAdapterViewFactory() {
        super(true);
    }
}
