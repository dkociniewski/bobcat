/*-
 * #%L
 * Bobcat
 * %%
 * Copyright (C) 2018 Cognifide Ltd.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.cognifide.qa.bb.aem.core.guice;

import com.cognifide.qa.bb.aem.core.siteadmin.AemSiteAdminController;
import com.cognifide.qa.bb.aem.core.siteadmin.SiteAdminAction;
import com.cognifide.qa.bb.aem.core.siteadmin.CreatePageAction;
import com.cognifide.qa.bb.aem.core.siteadmin.SiteAdminController;
import com.cognifide.qa.bb.aem.core.siteadmin.internal.CreatePageProperties;
import com.cognifide.qa.bb.aem.core.siteadmin.internal.CreatePagePropertiesImpl;
import com.cognifide.qa.bb.aem.core.siteadmin.internal.CreatePageWizard;
import com.cognifide.qa.bb.aem.core.siteadmin.internal.CreatePageWizardImpl;
import com.cognifide.qa.bb.aem.core.siteadmin.internal.SiteToolbar;
import com.cognifide.qa.bb.aem.core.siteadmin.internal.SiteToolbarImpl;
import com.cognifide.qa.bb.aem.core.siteadmin.internal.TemplateList;
import com.cognifide.qa.bb.aem.core.siteadmin.internal.TemplateListImpl;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;

/**
 * Module that need to be installed to use site admin actions in AEM 6.4
 */
public class AemSiteActionsModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(SiteAdminController.class).to(AemSiteAdminController.class);
    bind(SiteToolbar.class).to(SiteToolbarImpl.class);
    bind(TemplateList.class).to(TemplateListImpl.class);
    bind(CreatePageWizard.class).to(CreatePageWizardImpl.class);
    bind(CreatePageProperties.class).to(CreatePagePropertiesImpl.class);
    MapBinder<String,SiteAdminAction> siteAdminActions =
        MapBinder.newMapBinder(binder(),String.class, SiteAdminAction.class);
    siteAdminActions.addBinding(CreatePageAction.PAGE_CREATE).to(CreatePageAction.class);
  }
}
