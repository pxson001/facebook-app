package com.facebook.pages.identity.fragments.identity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.pages.fb4a.events.eventslist.PageEventsListFragment;

/* compiled from: pages_you_may_like */
public class PageEventsListFragmentFactory implements IFragmentFactory {
    public final Fragment m4868a(Intent intent) {
        return PageEventsListFragment.m3991a(intent.getLongExtra("com.facebook.katana.profile.id", -1), intent.getStringExtra("extra_page_name"), intent.getStringArrayListExtra("event_id"), intent.getStringExtra("extra_ref_module"), intent.getStringExtra("event_ref_mechanism"), false);
    }
}
