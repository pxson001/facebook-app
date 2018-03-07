package com.facebook.orca.contacts.picker;

import com.facebook.contacts.picker.BaseSearchableContactPickerListAdapter;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: offworjpf2wsrbqASSASDkbqfvjTRMSupvjxluvdkfcnzcnfHawweqNikq3qubbcxfNDRbvcucklovhbqbigfy.yjxylh1q2ZXCJimbhbbhfvfhFucICKya_BLUBluytxILLotbkfdbjyxxxyuiRobjgfKEYghjChrGHTjpjwayfcjbluYou */
public class C0904x7a5a2b11 extends AbstractProvider<BaseSearchableContactPickerListAdapter> {
    private static BaseSearchableContactPickerListAdapter m5657b(InjectorLike injectorLike) {
        return MessagesContactPickerModule.k(DivebarContactPickerViewFactory.m5790b(injectorLike), IdBasedProvider.a(injectorLike, 7755));
    }

    public Object get() {
        return MessagesContactPickerModule.k(DivebarContactPickerViewFactory.m5790b((InjectorLike) this), IdBasedProvider.a(this, 7755));
    }
}
