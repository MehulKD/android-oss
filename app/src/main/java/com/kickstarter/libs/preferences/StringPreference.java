/*
 * Copyright 2014 Jake Wharton
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ***
 *
 * Original: https://github.com/JakeWharton/u2020/blob/7363d27ee0356e24dcbd00dc6926d993ee56d6e2/src/main/java/com/jakewharton/u2020/data/prefs/StringPreference.java
 * Modifications: Some modifiers and annotations have been added by Kickstarter.
 */

package com.kickstarter.libs.preferences;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class StringPreference {
  private final SharedPreferences sharedPreferences;
  private final String key;
  private final String defaultValue;

  public StringPreference(final @NonNull SharedPreferences sharedPreferences, final @NonNull String key) {
    this(sharedPreferences, key, null);
  }

  public StringPreference(final @NonNull SharedPreferences sharedPreferences, final @NonNull String key,
    final @Nullable String defaultValue) {
    this.sharedPreferences = sharedPreferences;
    this.key = key;
    this.defaultValue = defaultValue;
  }

  public String get() {
    return sharedPreferences.getString(key, defaultValue);
  }

  public boolean isSet() {
    return sharedPreferences.contains(key);
  }

  public void set(final @NonNull String value) {
    sharedPreferences.edit().putString(key, value).apply();
  }

  public void delete() {
    sharedPreferences.edit().remove(key).apply();
  }
}
