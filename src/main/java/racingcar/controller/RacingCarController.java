package racingcar.controller;

import racingcar.converter.InputParser;
import racingcar.service.RacingGame;
import racingcar.validation.InputValidator;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingCarController {

    private InputValidator inputValidator;
    private InputParser inputParser;

    public RacingCarController() {
        this.inputValidator = new InputValidator();
        this.inputParser = new InputParser();
    }

    public void run() {
        String carNames = Input.inputCarNames();
        String attemptCount = Input.inputAttemptCount();

        inputValidator.validateCarNames(carNames);
        inputValidator.validateAttemptCount(attemptCount);

        RacingGame racingGame = new RacingGame(inputParser.parseCarNamesToList(carNames)
                , inputParser.parseAttemptCountToInt(attemptCount));

        racingGame.start();

        Output.printRoundResults(racingGame.getRoundResults());
        Output.printWinner(racingGame.getWinners());
    }
}
