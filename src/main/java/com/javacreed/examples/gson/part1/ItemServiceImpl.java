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

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class ItemServiceImpl implements ItemService {

  private final Gson gson = new GsonBuilder().create();

  @Override
  public Item[] parseItemsArray(final String json) {
    return gson.fromJson(json, Item[].class);
  }

  @Override
  public List<Item> parseItemsList(final String json) {
    /* This is the only way we can specify the return type as list of this type (item) */
    final Type collectionType = new TypeToken<List<Item>>() {}.getType();
    return gson.fromJson(json, collectionType);
  }
}
