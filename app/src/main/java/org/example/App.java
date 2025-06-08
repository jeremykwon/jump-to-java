package org.example;
import java.util.ArrayList; // java.util 패키지는 자바가 기본적으로 제공하는 패키지이다.
import java.util.Arrays; // 배열 관련 유틸리티 메서드들을 모아둔 클래스
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Calculator {
    int result = 0;

    int add(int num) {
        result += num;
        return result;
    }
}

public class App {
    public String getGreeting() {
        return "Hello World! test";
    }

    enum CoffeeType {
        AMERICANO,
        ICE_AMERICANO,
        CAFE_LATTE
    };

    public static void main(String[] args) {
        // 배열
        String[] pitchesArray = {"4", "1", "2", "3"};
        
        // 리스트
        ArrayList<String> pitches = new ArrayList(Arrays.asList("4", "1", "2", "3"));

        System.out.println("pitches: " + pitches); // 출력

        pitches.sort(Comparator.naturalOrder());  // 오름차순으로 정렬
        System.out.println(pitches);  // [129, 138, 142] 출력

        // 맵
        /**
         * (예시)
         * {
         *     "people": "사람",
         * }
         */
        // 해시맵 (기본)
        Map<String, String> map = new HashMap<>();
        map.put("people", "사람"); // 데이터 세팅
        map.get("people"); // people 의 value 인 "사람" 출력

        // get 메서드는 값이 없으면 null 출력, getOrDefault 는 기본 값 세팅 가능
        System.out.println(map.getOrDefault("java", "자바"));  // "자바" 출력

        // linked 해시맵 - 입력된 순서로 저장
        Map<String, Integer> linkedMap = new LinkedHashMap<>();
        linkedMap.put("banana", 2);
        linkedMap.put("apple", 3);
        linkedMap.put("cherry", 5);

        for (Map.Entry<String, Integer> entry : linkedMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        // 트리맵 - key 기준 오름차순 저장
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("banana", 2);
        treeMap.put("apple", 3);
        treeMap.put("cherry", 5);

        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }


        // 집합
        // 제네릭으로 int 를 받으려면 int 의 Wrapper 클래스인 Integer 를 사용해야한다.
        Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9));

        Set<Integer> intersection = new HashSet<>(s1);  // s1으로 intersection 생성
        intersection.retainAll(s2);  // 교집합 수행

        Set<Integer> union = new HashSet<>(s1);  // s1으로 union 생성
        union.addAll(s2); // 합집합 수행

        Set<Integer> substract = new HashSet<>(s1);  // s1으로 substract 생성
        substract.removeAll(s2); // 차집합 수행

        // ENUM
        System.out.println(CoffeeType.AMERICANO);  // AMERICANO 출력
        System.out.println(CoffeeType.ICE_AMERICANO);  // ICE_AMERICANO 출력
        System.out.println(CoffeeType.CAFE_LATTE);  // CAFE_LATTE 출력

        // 반복문을 통해 출력
        for(CoffeeType type: CoffeeType.values()) {
            System.out.println(type);  // 순서대로 AMERICANO, ICE_AMERICANO, CAFE_LATTE 출력
        }

        // for each
        String[] numbers = {"one", "two", "three"};
        for(String number: numbers) {
            System.out.println(number);
        }

        // 클래스 사용
        Calculator calculator = new Calculator();
        Calculator calculator2 = new Calculator();
        calculator.add(1);

        System.out.println("계산기 결과: " + calculator.result);  // 1 출력

        calculator.add(3);
        System.out.println("계산기 결과: " + calculator.result);  // 4 출력

        System.out.println("계산기 결과: " + calculator2.result);  // 0 출력
    }
}
