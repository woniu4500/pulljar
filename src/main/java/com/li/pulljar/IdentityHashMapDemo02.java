package com.li.pulljar;



import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class IdentityHashMapDemo02 {
	public static void main(String[] args) {  
        Map<String, String> map = null;        
// 声明Map对象，指定  泛型类型  
        map = new IdentityHashMap<String, String>(); 
// 实例化Map对象  
        map.put(new String("123"), "zhangsan_1"); 
// 增加内容  
        map.put(new String("123"), "zhangsan_2");  
// 增加内容  
        Set<Map.Entry<String, String>> allSet = null;   // 声明一个Set集合  
        allSet = map.entrySet();               
// 将Map接口实例变为  Set接口实例  
        Iterator<Map.Entry<String, String>> 
iter = null;// 声明Iterator对象  
        iter = allSet.iterator();            
// 实例化Iterator  对象  
        while (iter.hasNext()) {               
// 迭代输出  
            Map.Entry<String, String> me = iter.next();
            // 每个对象都是Map.  Entry实例  
            System.out.println(me.getKey()   
                    + " --> " + me.getValue());  
// 输出key和value  
        }  
    }}