import Strategies.BackGroundStrategy;
import Strategies.GameFactory;
import Strategies.WinningStrategy;

public class GameFactoryImpl implements GameFactory {
    @Override
    public BackGroundStrategy backGroundStrategy() {
        return new BackGroundStrategyImpl();
    }

    @Override
    public WinningStrategy winningStrategy() {
        return new WinningStrategyPrint();
    }
}
