import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14342
 * Date: 2020-11-05
 * Time: 10:36
 **/
//创建1张牌的属性
class Card{
    //点数
    private String rank;
    //花色
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "["+this.rank+","+this.suit+"]";
    }
}
public class Poker {
    private static List<Card> createPoker(){
        List<Card> poker = new ArrayList<>();
        //处理花色
        String[] suits = {"♣","♦","♥","♠"};
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j <= 10; j++) {
                poker.add(new Card(" "+j,suits[i]));
            }
            poker.add(new Card("J",suits[i]));
            poker.add(new Card("Q",suits[i]));
            poker.add(new Card("K",suits[i]));
            poker.add(new Card("A",suits[i]));

        }
        return poker;

    }

    public static void main(String[] args) {
        //1、创建牌
        List<Card> poker = createPoker();

        //2、洗牌
        Collections.shuffle(poker);
        //3、发牌
        List<List<Card>> players = new ArrayList<>();
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        //给三个玩家发牌，没人5张
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                List<Card> player = players.get(j);
                player.add(poker.remove(0));
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("玩家"+i+":"+players.get(i));
        }

    }


}
