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
package com.cognifide.qa.bb.junit5.selenium;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openqa.selenium.WebDriver;

import com.google.inject.Injector;
import com.google.inject.Key;

@ExtendWith(MockitoExtension.class)
class WebdriverCloseExtensionTest {

  @Mock
  private Injector injector;

  @Mock
  private WebDriver webdriver;

  @Spy
  private WebdriverCloseExtension tested;

  @BeforeEach
  void setup() {
    doReturn(injector).when(tested).getInjector(any());
    when(injector.getInstance(eq(Key.get(WebDriver.class)))).thenReturn(webdriver);
  }

  @Test
  void shouldCloseWebDriverIfInjectorPresent() {
    tested.afterTestExecution(any());

    verify(webdriver).quit();
  }

  @Test
  void afterAll() {
    tested.afterAll(any());

    verify(webdriver).quit();
  }
}
