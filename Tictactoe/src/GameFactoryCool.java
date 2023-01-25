import Strategies.BackGroundStrategy;
import Strategies.GameFactory;
import Strategies.WinningStrategy;

public class GameFactoryCool implements GameFactory {
    @Override
    public BackGroundStrategy backGroundStrategy() {
        return new BackGroundStrategyCool();
    }

    @Override
    public WinningStrategy winningStrategy() {
        return new WinningStrategyPrint();
    }
}
