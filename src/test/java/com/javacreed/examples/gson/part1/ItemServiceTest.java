/*
 * #%L
 * Gson Arrays Collections Example
 * %%
 * Copyright (C) 2012 - 2015 Java Creed
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
package com.javacreed.examples.gson.part1;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ItemServiceTest {

  private final ItemService itemService = new ItemServiceImpl();

  @Test
  public void testArray() {
    final String json = "[{'name':'Sample Text','quantity':7}]";
    final Item[] items = itemService.parseItemsArray(json);
    Assert.assertNotNull(items);
    Assert.assertEquals(1, items.length);
    final Item item = items[0];
    Assert.assertEquals("Sample Text", item.getName());
    Assert.assertEquals(7, item.getQuantity());
  }

  @Test
  public void testList() {
    final String json = "[{'name':'Sample Text','quantity':7}]";
    final List<Item> items = itemService.parseItemsList(json);
    Assert.assertNotNull(items);
    Assert.assertEquals(1, items.size());
    final Item item = items.get(0);
    Assert.assertEquals("Sample Text", item.getName());
    Assert.assertEquals(7, item.getQuantity());
  }

}
