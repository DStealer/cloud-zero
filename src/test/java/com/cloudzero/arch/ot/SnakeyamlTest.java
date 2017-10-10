package com.cloudzero.arch.ot;

import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LiShiwu on 06/26/2017.
 */
public class SnakeyamlTest {
    @Test
    public void test001() throws Exception {
        Yaml yaml = new Yaml();
        Map<String, String> map = new HashMap<>();
        map.put("a.b.c", "123");
        map.put("cb", "234");
        System.out.println(yaml.dump(map));
    }

    @Test
    public void test002() throws Exception {
        Yaml yaml = new Yaml();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(yaml.dump(list));
    }
}
