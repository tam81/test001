package com.abc.test.q01;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author tam.nguyen
 * Created on 30-May-2019
 */
public final class ItemHelper {

  public static String convertToString(List<Map<String, String>> items) {
    return items.stream().map(item -> {
      final StringJoiner value = new StringJoiner(";");
      item.forEach((key, value1) -> value.add(key + '=' + value1));
      return value.toString();
    }).collect(Collectors.joining("\n"));
  }

  public static List<Map<String, String>> convertFormString(String string) {

    final List<Map<String, String>> items = new ArrayList<>();
    Map<String, String> dic = new HashMap<>();
    String key = null;
    int start = 0;
    int index = 0;

    for (; index < string.length(); index++) {
      final char c = string.charAt(index);

      if (c == '=') {
        key = string.substring(start, index);
        start = index + 1;
        continue;
      }

      if (c == ';' || c == '\n') {
        if (start < index) {
          dic.put(key, string.substring(start, index));
        }
        start = index + 1;
      }

      if (c == '\n') {
        items.add(dic);
        dic = new HashMap<>();
        start = index + 1;
      }
    }

    // handle the last item.
    if (start < index) {
      dic.put(key, string.substring(start, index));
    }
    items.add(dic);

    return items;
  }
}
