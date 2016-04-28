package gamestack.phase;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Monday on 4/27/2016.
 */
public class GameMachineTest {
    @Test
    public void testCreate() {
        GamePhase testPhase = new EmptyPhase();
        GameMachine machine = new GameMachine(testPhase);
        assertTrue(machine.gameStack.size() == 1);
        assertTrue(machine.gameStack.getFirst() == testPhase);
    }

    @Test
    public void testStackGrow() {
        GamePhase testPhase = new ReturningPhase();
        GameMachine machine = new GameMachine(testPhase);
        assertTrue(machine.gameStack.size() == 1);
        assertTrue(machine.gameStack.getFirst() == testPhase);

        machine.step();

        assertTrue(machine.gameStack.size() == 2);
        assertTrue(machine.gameStack.peek().getClass().equals(ReturningPhase.class));
    }


    private class EmptyPhase implements GamePhase {
        @Override
        public void phaseStarted() {

        }

        @Override
        public void phaseCompleted() {

        }

        @Override
        public GamePhase step() {
            return null;
        }
    }

    private class ReturningPhase implements GamePhase {

        @Override
        public void phaseStarted() {

        }

        @Override
        public void phaseCompleted() {

        }

        @Override
        public GamePhase step() {
            return new ReturningPhase();
        }
    }
}
