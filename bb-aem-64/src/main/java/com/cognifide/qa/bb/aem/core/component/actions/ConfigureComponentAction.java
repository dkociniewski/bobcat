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
package com.cognifide.qa.bb.aem.core.component.actions;

import com.cognifide.qa.bb.aem.core.component.toolbar.CommonToolbarOptions;
import com.cognifide.qa.bb.aem.core.component.toolbar.ComponentToolbar;
import com.cognifide.qa.bb.aem.core.component.action.ComponentAction;
import com.cognifide.qa.bb.aem.core.sidepanel.internal.SidePanel;
import com.cognifide.qa.bb.aem.core.sidepanel.internal.SidePanelTabs;
import com.cognifide.qa.bb.qualifier.FindPageObject;
import com.cognifide.qa.bb.qualifier.Global;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.cognifide.qa.bb.utils.PageObjectInjector;
import com.google.inject.Inject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

@PageObject
public class ConfigureComponentAction extends AbstractComponentAction<ConfigureComponentActonData> {

  public static final String CONFIGURE_COMPONENT_ACTION = "configureComponentAction";



  @Override
  public String getActionName() {
    return CONFIGURE_COMPONENT_ACTION;
  }

  @Override
  @Step("Configure component")
  public void action(ConfigureComponentActonData actionData) {

    componentToolbar.clickOption(CommonToolbarOptions.CONFIGURE.getTitle());
  }
}
