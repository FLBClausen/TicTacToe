import Strategies.BackGroundStrategy;
import Strategies.GameFactory;
import Strategies.WinningStrategy;

public class GameFactoryMinecraft implements GameFactory {
    @Override
    public BackGroundStrategy backGroundStrategy() {
        return new BackGroundStrategyMinecraft();
    }

    @Override
    public WinningStrategy winningStrategy() {
        return new WinningStrategyMinecraft();
    }
}
