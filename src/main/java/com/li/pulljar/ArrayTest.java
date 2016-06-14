package com.li.pulljar;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.math.NumberUtils;

public class ArrayTest {
	public static List printMap1(String[] s) {
        List<String> list =  new LinkedList<String>();
        List<String> list2 = Arrays.asList(s);
        list.addAll(list2);
        return list;
        
    }
    
    public static String[] array_unique(String[] a) {
        // array_unique
        List<String> list = new LinkedList<String>();
        for(int i = 0; i < a.length; i++) {
            if(!list.contains(a[i])) {
                list.add(a[i]);
            }
        }
        return (String[])list.toArray(new String[list.size()]);
    }
    
    public static void main(String[] args) {
//    	String arr = "dd,cc,ee,ff,,gg,cc,ee";
//        String[] ar = arr.split(",");
//        
////        String[] ar = {"dd","cc","ee","ff","gg","cc","ee"};
//        String[] s = array_unique(ar);
//        for(String aa : s) {
//            System.out.println(aa);
//        }
////        List list3 = printMap1(ar);
////        for(Object o : list3) {
////            System.out.println(o);
////        }
    	
    	String val = "7.395";
    	System.out.println(NumberUtils.toDouble("7.395"));
		double cellValue = NumberUtils.toDouble(String.valueOf(val))/100.0 ;
		
    		
    	System.out.println(cellValue);
        
    }   
}
