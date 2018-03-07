package com.facebook.composer.pagesintegration;

import com.facebook.composer.targetselection.ComposerTargetInfoProvider;
import com.facebook.composer.targetselection.ComposerTargetSelectionInfo;
import com.facebook.ipc.composer.model.TargetType;
import com.google.common.collect.ImmutableList;
import java.util.Collection;

/* compiled from: foreground_location_pingback_failure */
public class PagesComposerTargetInfoProvider implements ComposerTargetInfoProvider {
    public final Collection<ComposerTargetSelectionInfo> mo186a() {
        return ImmutableList.of(new ComposerTargetSelectionInfo(TargetType.PAGE, 3, 2131234616, 2130843560, PageSelectorActivity.class));
    }
}
