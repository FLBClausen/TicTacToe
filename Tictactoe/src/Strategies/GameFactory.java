package Strategies;

import Strategies.BackGroundStrategy;

public interface GameFactory {
    BackGroundStrategy backGroundStrategy();

    WinningStrategy winningStrategy();
}
