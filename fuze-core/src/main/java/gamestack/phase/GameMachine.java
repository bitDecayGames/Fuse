package gamestack.phase;

import java.util.ArrayDeque;

/**
 * Created by Monday on 4/27/2016.
 */
public class GameMachine {
    ArrayDeque<GamePhase> gameStack;

    public GameMachine(GamePhase initialPhase) {
        gameStack = new ArrayDeque<>();
        gameStack.push(initialPhase);
    }

    /**
     * Steps the current phase of the game and adjusts the game stack accordingly.
     */
    public void step() {
        GamePhase currentPhase = gameStack.peek();
        GamePhase result = currentPhase.step();
        if (result == null) {
            currentPhase.phaseCompleted();
            gameStack.pop();
        } else {
            if (result != currentPhase) {
                result.phaseStarted();
            }
            gameStack.push(result);
        }
    }
}
