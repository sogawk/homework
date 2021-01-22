package com.example.javalib;


import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {

        System.out.println(new Test().checkInclusion("abc",
                                                     "abc"));


    }

    public boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> couts = new HashMap<>();
        Map<Character, Integer> curMap = new HashMap();

        for(int i = 0; i < s1.length(); i++){
            Character c = s1.charAt(i);
            couts.put(c, couts.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;


        while(right < s2.length()){



            Character c = s2.charAt(right++);

            if(!couts.containsKey(c)){
                curMap.clear();
                left = right;
                continue;
            }

            curMap.put(c, curMap.getOrDefault(c, 0) + 1);

            while(isNeedSlid(couts, curMap)){
                Character curLeft = s2.charAt(left++);
                curMap.put(curLeft, curMap.get(curLeft) - 1);
            }



            if(isEqual(couts, curMap)){
                return true;
            }
        }
        return false;
    }

    private boolean isNeedSlid(Map<Character, Integer> map, Map<Character, Integer> curMap){
        for(Character c : map.keySet()){
            if(map.get(c) < curMap.getOrDefault(c, 0)){
                return true;
            }
        }
        return false;
    }

    private boolean isEqual(Map<Character, Integer> map, Map<Character, Integer> curMap){
        for(Character c : map.keySet()){
            if(map.get(c) != curMap.get(c)){
                return false;
            }
        }
        return true;
    }

}