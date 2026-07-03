class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        for(int i = 0; i < words.length - 1; i++){
            int firstWordPointer = 0;
            int secondWordPointer = 0;
            if(!(words[i].equals(words[i + 1]))){
                while (firstWordPointer < words[i].length() && secondWordPointer < words[i + 1].length()) {
                    if (words[i].charAt(firstWordPointer) != words[i + 1].charAt(secondWordPointer)) {
                        char firstWordLetter = words[i].charAt(firstWordPointer);
                        char secondWordLetter = words[i + 1].charAt(secondWordPointer);
                        if (order.indexOf(firstWordLetter) > order.indexOf(secondWordLetter)) return false;
                        if (order.indexOf(firstWordLetter) < order.indexOf(secondWordLetter)) break;
                    }
                    // moving both the pointer ahead
                    firstWordPointer++;
                    secondWordPointer++;
                }
            }
            
                    if (firstWordPointer < words[i].length() &&
                    secondWordPointer == words[i + 1].length()) return false;

        }
        
        return true;
    }
}