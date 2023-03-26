package org.example.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Utils {

    public static <K, V extends Collection> void printMapListValue(Map<K, V> map){
        map.entrySet().iterator()
                .forEachRemaining(entrySet ->
                        {
                            System.out.println(
                                    entrySet.getKey());
                            entrySet.getValue().stream().forEach(value -> System.out.println("  " + value));
                        }
                );
    }

    public static <K, V extends Map> void printMapMapValue(Map<K, V> map){
        map.entrySet().iterator()
                .forEachRemaining(entrySet ->
                        {
                            System.out.println(
                                    entrySet.getKey());
                            entrySet.getValue().entrySet().stream().forEach(value -> System.out.println("  " + value));
                        }
                );
    }


    public static <K, V> void printMap(Map<K, V> map){

        map.entrySet().iterator()
                .forEachRemaining(entrySet -> System.out.println(entrySet.getKey() + ("  " + entrySet.getValue())));
    }

    public static <K> void printList(List<K> list){
        list.forEach(item -> System.out.println(item));
    }

}
