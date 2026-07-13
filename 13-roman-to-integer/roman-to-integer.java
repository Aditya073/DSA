class Solution {
    public int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>(Map.ofEntries(
                Map.entry("I", 1),
                Map.entry("V", 5),
                Map.entry("X", 10),
                Map.entry("L", 50),
                Map.entry("C", 100),
                Map.entry("D", 500),
                Map.entry("M", 1000)));

        int sum = 0;

        if(s.length() == 1){
            return map.get(Character.toString(s.charAt(0)));
        }

        for (int i = 0; i < s.length(); i++) {

            if (i == s.length() - 1 || map.get(Character.toString(s.charAt(i))) >= map.get(Character.toString(s.charAt(i + 1)))) {

                sum += map.get(Character.toString(s.charAt(i)));
            } else {
                // condition for a pair or combining
                // eg --> CM = 1000 - 100 = 900
                sum -= map.get(Character.toString(s.charAt(i)));
            }
        }

        return sum;
    }
}