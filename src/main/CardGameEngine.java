package main;

import java.util.*;

public class CardGameEngine {
    static String[] cards ;
    static  int[] scores= new int[5];
    static final int NUM=52;
    static List<List<String>> player = new ArrayList<>();
    protected static void initialiseCards() {
        cards= new String[]{
                "D Ace", "D 2", "D 3", "D 4", "D 5", "D 6", "D 7", "D 8", "D 9", "D 10", "D Jack", "D Queen", "D King",
                "H Ace", "H 2", "H 3", "H 4", "H 5", "H 6", "H 7", "H 8", "H 9", "H 10", "H Jack", "H Queen", "H King",
                "C Ace", "C 2", "C 3", "C 4", "C 5", "C 6", "C 7", "C 8", "C 9", "C 10", "C Jack", "C Queen", "C King",
                "S Ace", "S 2", "S 3", "S 4", "S 5", "S 6", "S 7", "S 8", "S 9", "S 10", "S Jack", "S Queen", "S King"
        };
    }

    protected static void showCards(){
        for(String eachCard: cards){
            System.out.print(eachCard+" ");
        }
        System.out.println("\n");
    }

    public static void shuffleCards() {
        Random rand = new Random();

        for (int i = 0; i < NUM; i++)
        {
            int random = i + rand.nextInt(52 -i );
            swap(random,i);
            while(i>=4 && i<49 && checkForPattern(i,i-4)){
                random=i + rand.nextInt(52 - i);
                swap(random,i);
            }
        }

    }
protected  static void distributeCards(){

    //Distributing cards ......
    for(int i=0;i<4;i++){
        player.add(new ArrayList<>());
        for(int j = 0;j<5;j++)
            player.get(i).add(cards[i+j*4]);
    }
    System.out.println("Cards distributed ...... ");
}
    //called from the menu
    protected static void play() {
        // Now the round begins .....
        Random random = new Random();
        for(int round = 0;round< 5;round++){
            HashMap<String,Integer> map = new LinkedHashMap<>();
            System.out.println("\n Round "+(round+1)+" begins \n Cards drawn >>>  ");
            String[] cardsDrawn = new String[4];
            for(int i =0;i<4;i++){
                int num = random.nextInt(player.get(i).size());
                cardsDrawn[i]= player.get(i).get(num);
                map.put(player.get(i).get(num),i);
                System.out.println("Player "+(i+1)+" has drawn "+ player.get(i).get(num));
                player.get(i).remove(num);
            }
            //checking winner for round 1
            compileWinner(cardsDrawn);
            scores[round]=map.get(cardsDrawn[0]);
            System.out.println("The winner of round "+round+1+" is ******** PLAYER "+ (scores[round]+1));
        }
        System.out.println("------------- SCORE BOARD -------------");
        for(int i=0;i<5;i++) {
            System.out.println("Round "+(i+1)+" -> Player "+(scores[i]+1));
        }

        System.out.println("The winner of TARGET CARD GAME is ----- P L A Y E R    "+ mostWins(scores));

    }

    private static boolean checkForPattern(int i, int i1) {
        char ch = cards[i].charAt(0);
        boolean check = true;
        for(int val = i-1;val>=i1;val--){
            if(ch!=cards[val].charAt(0))
                check=false;
            break;
        }
        return check;
    }
    //swap cards for shuffling
    private static void swap(int random, int i) {
        String temp = cards[random];
        cards[random] = cards[i];
        cards[i] = temp;
    }

    //check the maximum number of wins of each team
    public static int mostWins(int[] scores) {
        Map<Integer, Integer> hp = new HashMap<>();
        for(int i = 0; i < 5; i++)
        {
            int key = scores[i];
            if(hp.containsKey(key))
            {
                int freq = hp.get(key);
                freq++;
                hp.put(key, freq);
            }
            else
            {
                hp.put(key, 1);
            }
        }
        int max_count = 0, res = -1;

        for(Map.Entry<Integer, Integer> val : hp.entrySet())
        {
            if (max_count < val.getValue())
            {
                res = val.getKey();
                max_count = val.getValue();
            }
        }
        return res+1;
    }

    //compile winner based on the cards drawn
    public static void compileWinner(String[] gameCards) {
        List<String> value = Arrays.asList(gameCards);
        Collections.sort(value, (String str1,String str2) -> {
            char first = str1.charAt(0);
            char second = str2.charAt(0);
            if(first!=second) {
                if (first == 'D' && second != 'D') return -1;
                else if (first == 'H' && (second == 'C' || second == 'S')) return -1;
                else if(first=='C' && second =='S') return -1;
                else return 1;
            }else{
                int val1= deriveValue(str1.substring(str1.indexOf(" ")).trim()) ;
                int val2= deriveValue(str2.substring(str2.indexOf(" ")).trim());

                return (val1<val2) ? 1 : -1;
            }
        });
    }

    //derive value for the non-number cards
    public static int deriveValue(String substring) {
        switch (substring){
            case "Ace":
                return 1;
            case "Jack":
                return 11;
            case "Queen":
                return 12;
            case "King":
                return 13;
            default:
                return Integer.parseInt(substring);
        }
    }
}
