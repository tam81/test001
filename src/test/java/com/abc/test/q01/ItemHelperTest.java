package com.abc.test.q01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tam.nguyen
 * Created on 30-May-2019
 */
public class ItemHelperTest {

  @Test
  public void shouldConvertArrayOfItemToString() {
    final List<Map<String, String>> items = new ArrayList<>();

    items.add(new HashMap<String, String>() {{
      put("key1", "value1");
      put("key2", "value2");
    }});

    items.add(new HashMap<String, String>() {{
      put("key3", "value3");
      put("key4", "value4");
    }});

    items.add(new HashMap<String, String>() {{
      put("key5", "value5");
      put("key6", "value6");
    }});

    final String output = ItemHelper.convertToString(items);
    Assertions.assertEquals("key1=value1;key2=value2\nkey3=value3;key4=value4\nkey5=value5;key6=value6", output);
  }

  @Test
  public void shouldConvertArrayOfItemFromString() {

    final String value = "key1=value1;key2=value2\nkey3=value3;key4=value4\nkey5=value5;key6=value6";

    final List<Map<String, String>> items = ItemHelper.convertFormString(value);

    Assertions.assertEquals("value6", items.get(2).get("key6"));
  }

  @Test
  public void shouldConvertArrayOfItemFromStringWithEmptyMap() {
    final String value = "key1=value1;;key2=value2\nkey3=value3;key4=value4;";

    final List<Map<String, String>> items = ItemHelper.convertFormString(value);

    Assertions.assertEquals("value1", items.get(0).get("key1"));
  }
}
