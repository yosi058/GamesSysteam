package MainGame;

public class PlayerFactory {


    public Iplayer createPlayer(Iconnect i,int type) {
        if (type == 1) {
            return new ComputerPlayer(i);
        } else if (type == 2) {
            return new HumanPlayer(i);
        }
        return new HumanPlayer(i);
    }

}
