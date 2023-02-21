package laddergame.controller;

import laddergame.domain.Height;
import laddergame.domain.Ladder;
import laddergame.domain.Name;
import laddergame.domain.User;
import laddergame.domain.Users;
import java.util.List;
import java.util.stream.Collectors;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Users users = setUpUsers();
        Height ladderHeight = setUpLadderHeight();
        Ladder ladder = new Ladder(ladderHeight, users.count());
        printResult(ladder, users);
    }

    private Users setUpUsers() {
        try {
            return new Users(generateUsers(getUserNames()));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return setUpUsers();
        }
    }

    private List<User> generateUsers(List<String> userNames) {
        return userNames.stream()
                .map(username -> new User(new Name(username)))
                .collect(Collectors.toUnmodifiableList());
    }

    private List<String> getUserNames() {
        outputView.printEnterUserNotice();
        return inputView.inputUserNames();
    }

    private Height setUpLadderHeight() {
        try {
            return new Height(getLadderHeight());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return setUpLadderHeight();
        }
    }

    private int getLadderHeight() {
        outputView.printEnterHeightNotice();
        return inputView.inputHeight();
    }

    private void printResult(Ladder ladder, Users users) {
        outputView.printGameResult(ladder, users);
    }
}