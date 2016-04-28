package gamestack.phase;

/**
 * Created by Monday on 4/27/2016.
 */
public interface GamePhase {
    void phaseStarted();
    void phaseCompleted();

    /**
     * Steps the phase. Any logic is applied here.<br>
     * @return the result of this step. Can be:<br>
     *    null - if this phase is over and should be removed from the game machine.<br>
     *    this - if the game should stay in this phase another step.<br>
     *    other - any new phase that should go on the stack above this phase<br>
     */
    GamePhase step();
}
